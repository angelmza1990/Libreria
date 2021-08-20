
package com.egg.libreria1.repositories;

import com.egg.libreria1.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, String> {
    
    
}
