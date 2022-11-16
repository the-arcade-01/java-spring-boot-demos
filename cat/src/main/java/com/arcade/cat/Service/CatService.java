package com.arcade.cat.Service;

import com.arcade.cat.Entity.CatModel;
import com.arcade.cat.Repository.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {

    @Autowired
    CatRepo catRepo;

    public List<CatModel> getCats() {
        return catRepo.findAll();
    }

    public Optional<CatModel> getCat(Long Id) {
        return catRepo.findById(Id);
    }

    public CatModel createCat(CatModel cat) {
        catRepo.save(cat);
        return cat;
    }

    public CatModel updateCat(CatModel cat, Long Id) {
        catRepo.save(cat);
        return cat;
    }

    public void deleteCat(Long Id) {
        catRepo.deleteById(Id);
    }
}
