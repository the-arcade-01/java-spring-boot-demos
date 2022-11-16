package com.arcade.cat.Controller;

import com.arcade.cat.Entity.CatModel;
import com.arcade.cat.Service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CatController {

    @Autowired
    CatService catService;

    @GetMapping("")
    List<CatModel> getCats() {
        return catService.getCats();
    }

    @GetMapping("/{Id}")
    Optional<CatModel> getCat(@PathVariable Long Id) {
        return catService.getCat(Id);
    }

    @PostMapping("")
    CatModel createCat(@RequestBody CatModel cat) {
        return catService.createCat(cat);
    }

    @PutMapping("/{Id}")
    CatModel updateCat(@RequestBody CatModel cat, @PathVariable Long Id) {
        return catService.updateCat(cat, Id);
    }

    @DeleteMapping("/{Id}")
    void deleteCat(@PathVariable Long Id) {
        catService.deleteCat(Id);
    }
}
