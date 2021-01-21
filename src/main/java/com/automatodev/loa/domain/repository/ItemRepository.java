package com.automatodev.loa.domain.repository;

import java.util.List;

import com.automatodev.loa.domain.model.entityModel.ItemEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<ItemEntity, Long>{

    List<ItemEntity> findByUfAndCityAndStatusItem(String uf, String city,String statusItem);

}
