package com.automatodev.loa.api.offer.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.automatodev.loa.api.exceptionHandler.RulesException;
import com.automatodev.loa.domain.model.entityModel.OfferEntity;
import com.automatodev.loa.domain.model.representationModel.OfferOutput;
import com.automatodev.loa.domain.repository.ItemRepository;
import com.automatodev.loa.domain.repository.OfferRepository;
import com.automatodev.loa.domain.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    private OfferRepository oRepository;

    @Autowired
    private UserRepository uRepository;

    @Autowired
    private ItemRepository iRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OfferOutput toModel(OfferEntity offerEntity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(offerEntity,OfferOutput.class);
    }

    public List<OfferOutput> toCollectionModel(List<OfferEntity> offers){
        return offers.stream().map(offer -> toModel(offer)).collect(Collectors.toList());
    }

    public Long postOffer(OfferEntity offerEntity){
        OfferEntity o = oRepository.findByUser_idUserAndItem_idAnnouncement(offerEntity.getUser().getIdUser(),
            offerEntity.getItem().getIdAnnouncement());

        if(o == null){
            offerEntity.setDateOffer(OffsetDateTime.now().toEpochSecond());
            return oRepository.save(offerEntity).getIdOffer();
        }

        throw new RulesException("Já existe uma oferta deste item para o mesmo usuário!",422);
     
    }

    public List<OfferOutput> getOffersUser(Long id){
        if(uRepository.existsById(id)){
            
            return toCollectionModel(oRepository.findByUser_idUser(id));
        }
    
        throw new RulesException("Usuário não encontrado!",404);

    }

    public List<OfferOutput> getOfferItem(Long id, String status){
        if(iRepository.existsById(id))
            return toCollectionModel(oRepository.findByItem_idAnnouncementAndStatus(id, status));
        throw new RulesException("Item não encontrado!", 404);
    }

    public Long deleteById(Long id){
        if(oRepository.existsById(id)){
            oRepository.deleteById(id);
            return id;
        }
           
        throw new RulesException("Oferta não encontrada!",404);
    }

    public Long updateOffer(Long id, OfferEntity offerEntity){
        OfferEntity offerOrigin = oRepository.findById(id).orElse(null);
        if(offerOrigin != null){
            offerEntity.setIdOffer(offerOrigin.getIdOffer());
            offerEntity.setDateOffer(offerOrigin.getDateOffer());
            oRepository.save(offerEntity);
            return offerEntity.getIdOffer();
        }

        throw new RulesException("Oferta não encotnrada!", 404);
    }
}
