/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.repositories;

import com.userapp.userapps.entities.Subprice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Maelo
 */
public interface SubPriceRepository extends JpaRepositoryImplementation<Subprice, Long> {

    @Query("SELECT s FROM Subprice s WHERE s.subcode = :subcode")
    Subprice findBySubCode(@Param("subcode") String subcode);

    @Query("SELECT s FROM Subprice s WHERE s.id = :id")
    Subprice findByID(@Param("id") Long id);



}
