package com.mobileApp.server;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    private int currentID = 0;
    private final ItemRepository repository;
    Logger logger = LoggerFactory.getLogger(ItemController.class);
    ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/item")
    public List<Items> getItems() {
        logger.info("GET SUCCES");
        return repository.findAll();
    }

    @PostMapping(value = "/item")
    public Items addNewItem(@RequestBody Items newItem) {
        logger.info("Item saved");
        currentID++;
        return repository.save(newItem);
    }

    @GetMapping(value = "/currentID")
    public int getCurrentId(){
        return currentID;
    }

    @GetMapping(value = "/item/{id}")
    public Items getOneItem(@PathVariable long id)
    {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping(value = "/item/{id}")
    public Items updateItem(@RequestBody Items newItem, @PathVariable Long id)
    {
        return repository.findById(id)
                .map(item -> {
                    item.setDescription(newItem.getDescription());
                    item.setName(newItem.getName());
                    item.setPrice(newItem.getPrice());
                    item.setAvailableQuantity(newItem.getAvailableQuantity());
                    item.setImgURL(newItem.getImgURL());
                    return repository.save(item);
                }).orElseGet(()->{
                    newItem.setId(id);
                    return repository.save(newItem);
                });
    }

    @DeleteMapping(value = "/item/{id}")
    public void deleteItem(@PathVariable Long id)
    {
        repository.deleteById(id);
        logger.info("Item deleted");
    }

}
