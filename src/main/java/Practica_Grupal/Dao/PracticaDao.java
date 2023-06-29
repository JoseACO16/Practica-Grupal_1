package Practica_Grupal.Dao;

import Practica_Grupal.Domain.Practica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticaDao extends JpaRepository<Practica, Long>{
    
}
