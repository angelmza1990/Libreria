
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
}
