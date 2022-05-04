package fr.univrouen.projetxml.services;

import fr.univrouen.projetxml.models.Item;
import fr.univrouen.projetxml.repositories.GetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetService {

    @Autowired
    private final GetRepo getRepo;

    public GetService(GetRepo getRepo) {
       this.getRepo = getRepo;
    }

    public List<Item> getAllItems() {
       return getRepo.findAll();
    }
    public Item getItemById(int id) {
        return getRepo.getById(id);
    }

    public Item addItem(Item item) {
      return getRepo.save(item);
    }

   public void deleteItemById(int id) {
        getRepo.deleteById(id);
   }


}
