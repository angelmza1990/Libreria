
package com.egg.libreria1.repositories;

import com.egg.libreria1.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository <Libro, String>{
    @Query("SELECT c FROM Libro c WHERE c.autor =:autor")
    public List<Libro> buscarPorAutor(@Param("autor") String autor);
    
    @Query("SELECT c FROM Libro c WHERE c.titulo LIKE :q or c.autor.nombre LIKE :q")
    public List<Libro> findAllByQ(@Param("q") String q);
    
    @Query("SELECT c FROM Libro c WHERE c.autor.nombre =:q")
    public List<Libro> findAllByAutor(@Param("q") String q);
    
    
}
