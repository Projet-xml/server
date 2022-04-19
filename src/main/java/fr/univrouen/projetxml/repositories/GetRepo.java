package fr.univrouen.projetxml.repositories;

import fr.univrouen.projetxml.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetRepo extends JpaRepository<Item, Integer>{
}
