package com.automatodev.loa.api.item.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.automatodev.loa.api.exceptionHandler.RulesException;
import com.automatodev.loa.domain.model.entityModel.ItemEntity;
import com.automatodev.loa.domain.model.entityModel.UserEntity;
import com.automatodev.loa.domain.model.representationModel.AnnouncementOutput;
import com.automatodev.loa.domain.repository.ItemRepository;
import com.automatodev.loa.domain.repository.UserRepository;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemService {

    //Injetando o modelMapper para uso do representation model da entidade AnnouncementEntity
    @Autowired 
	private ModelMapper modelMapper;

	 //Injetando a dependencia de ItemRepository que possui os metodos de ações jpa para os anuncios
	@Autowired
	private ItemRepository iRepository;

	@Autowired
	private UserRepository uRepository;


	@PersistenceContext
	private EntityManager manager;
	
    	//Metodo de conversao do domainModel para o representationModel da classe AnnouncementEntity
	public AnnouncementOutput toModel(ItemEntity announcementEntity) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(announcementEntity, AnnouncementOutput.class);
    }
    
	//Metodo de conversao do domainModel para o representationModel de uma lista da classe AnnouncementEntity
	public List<AnnouncementOutput> toCollectionModel(List<ItemEntity> announcementEntities) {
		return announcementEntities.stream().map(announcementEntity -> toModel(announcementEntity))
				.collect(Collectors.toList());
	}

	//Service que ira recuperar todos os dados do banco
	public List<AnnouncementOutput> getAll(){
		return toCollectionModel(iRepository.findAll());
	} 


	//Service que ira recuperar todos os dados com base no id passado no parametro
	public AnnouncementOutput getById(Long id){
		ItemEntity itemFind = iRepository.findById(id).orElse(null);
		if(itemFind != null)
			return toModel(itemFind);
		
		throw new RulesException("Item não encontrado",404);
	}

	//Service que ira deletar um item pelo id
	public ItemEntity deleteById(Long id){
		ItemEntity itemEntity = iRepository.findById(id).orElse(null);
		if(itemEntity == null)
			throw new RulesException("Item não encontrado",404);
		else{
			iRepository.deleteById(id);
			return itemEntity;
		}
	}

	//Service que ira gravar um item na tabella caso o uruario informado exista no banco
	 public AnnouncementOutput postItem(ItemEntity itemEntity){
		 UserEntity userEntity = uRepository.findById(itemEntity.getUserEntity().getIdUser()).orElse(null);
		if(userEntity != null){
			itemEntity.setDateCad(OffsetDateTime.now().toEpochSecond());
			itemEntity.setStatusItem("ativo");
			return toModel(iRepository.save(itemEntity));
		}
		
		throw new RulesException("Usuario informado não existe",404);
	 }

	 //Service que ira atualizar um item caso ele exista na tabela
	 public AnnouncementOutput updaEntity(ItemEntity itemEntity, Long id){
		ItemEntity itemOrigin = iRepository.findById(id).orElse(null);
		if(itemOrigin != null){
			UserEntity userOrigin = uRepository.findByIdUser(itemEntity.getUserEntity().getIdUser());
			if(userOrigin != null){
				itemEntity.setIdAnnouncement(itemOrigin.getIdAnnouncement());
				itemEntity.setDateCad(itemOrigin.getDateCad());
				itemEntity.setStatusItem(itemOrigin.getStatusItem());
				return toModel(iRepository.save(itemEntity));

			}

			throw new RulesException("Usuario não encontrado",404);

		}

		throw new RulesException("Item não encontrado",404);
	}

	//Service que ira recupera um dado atraves do id no endpoint "announcement/query" passando atributos no queryParams na urlDinamica
	public List<AnnouncementOutput> getFilterUserDefult(String uf, String city){
		return toCollectionModel(iRepository.findByUfAndCityAndStatusItem(uf, city,"ativo"));
	}

	//Service que ira recupera um dado atraves do id no endpoint "announcement/query" passando atributos no queryParams na urlDinamic
	public List<AnnouncementOutput> filterItem(ItemEntity itemEntity){
		DetachedCriteria criteria = DetachedCriteria.forClass(ItemEntity.class);	
		Example example = Example.create(itemEntity).enableLike(MatchMode.ANYWHERE);
		Session session = (Session) manager.getDelegate();

		criteria.add(example).getExecutableCriteria(session);
		List<ItemEntity> founds = criteria.getExecutableCriteria(session).list();
		return toCollectionModel(founds);
	}

  	//Service que ira recupera uma lista atraves do id no endpoint "announcement/search" passando atributos no queryParams na urlDinamica
	public List<AnnouncementOutput> getSearch(ItemEntity itemEntity){
		DetachedCriteria criteria = DetachedCriteria.forClass(ItemEntity.class);
		Example example = Example.create(itemEntity).enableLike(MatchMode.ANYWHERE);
		Session session = (Session)  manager.getDelegate();

		criteria.add(example).getExecutableCriteria(session);
		List<ItemEntity> founds = criteria.getExecutableCriteria(session).list();
		return toCollectionModel(founds);

	}

}