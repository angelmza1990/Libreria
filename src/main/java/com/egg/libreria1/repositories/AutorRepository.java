/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.libreria1.repositories;

import com.egg.libreria1.entidades.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository  extends JpaRepository<Autor, String> {
    
    @Query("SELECT c FROM Autor c WHERE c.id =:id")
    public List<Autor> buscarAutorPorId(@Param("id") String id);
    
    @Query("select a from Autor a where a.nombre LIKE =:q")
    public List<Autor> findAllByQ(@Param("q") String q);
    
}
