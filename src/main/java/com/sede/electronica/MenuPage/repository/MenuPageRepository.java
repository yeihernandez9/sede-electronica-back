package com.sede.electronica.MenuPage.repository;

import com.sede.electronica.MenuPage.entity.MenuPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPageRepository extends JpaRepository<MenuPage, Integer> {
}
