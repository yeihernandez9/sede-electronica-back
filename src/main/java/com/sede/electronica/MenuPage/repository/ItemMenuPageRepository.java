package com.sede.electronica.MenuPage.repository;

import com.sede.electronica.MenuPage.entity.ItemMenuPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMenuPageRepository extends JpaRepository<ItemMenuPage, Integer> {
}
