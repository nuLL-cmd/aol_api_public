package com.automatodev.loa.api.offer.controller;

import java.util.List;

import javax.validation.Valid;

import com.automatodev.loa.api.offer.service.OfferService;
import com.automatodev.loa.domain.model.entityModel.OfferEntity;
import com.automatodev.loa.domain.model.representationModel.OfferOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("offers")
public class OfferController {
    


    @Autowired
    private OfferService oService;


    @PostMapping()
    public ResponseEntity<Long> postOffer(@Valid @RequestBody OfferEntity offerEntity){
        return ResponseEntity.ok(oService.postOffer(offerEntity));
    }

    @GetMapping("user")
    public ResponseEntity<List<OfferOutput>> getOffersUser(@RequestParam Long id){
        return ResponseEntity.ok(oService.getOffersUser(id));
    }

    @GetMapping("item")
    public ResponseEntity<List<OfferOutput>> getOfferItem(@RequestParam Long id,@RequestParam String status){
        return ResponseEntity.ok(oService.getOfferItem(id, status));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(oService.deleteById(id));
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Long updateOffer(@PathVariable Long id, @RequestBody OfferEntity offerEntity) {
        return oService.updateOffer(id,offerEntity);
    }
}
