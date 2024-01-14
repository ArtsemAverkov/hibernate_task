package ru.clevertec.house.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.house.entity.House;
import ru.clevertec.house.service.house.HouseService;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {


    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody House house) {
        return houseService.create(house);
    }


    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public House read(@PathVariable Long id) throws Exception {
        return houseService.read(id);
    }


    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean update (@PathVariable Long id, @RequestBody House house) {
        return houseService.update(house, id);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable Long id) {
        return houseService.delete(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<House> readAll(){
        return houseService.readAll();
    }
}