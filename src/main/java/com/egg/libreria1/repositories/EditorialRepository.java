
package com.egg.libreria1.repositories;

import com.egg.libreria1.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository  extends JpaRepository<Editorial, String> {
    
    
}
