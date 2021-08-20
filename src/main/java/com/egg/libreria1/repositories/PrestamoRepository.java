
package com.egg.libreria1.repositories;

import com.egg.libreria1.entidades.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository  extends JpaRepository<Prestamo, String> {
       
}
