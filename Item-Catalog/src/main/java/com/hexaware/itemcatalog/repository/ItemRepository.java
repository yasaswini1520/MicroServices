package com.hexaware.itemcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.itemcatalog.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

}
