package ru.clevertec.house.service.house;

import ru.clevertec.house.entity.House;

import java.util.List;

public interface HouseService {
    long create(House house);
    House read (long id) throws Exception;
    boolean update (House house, Long id);
    boolean delete (Long id);
    List<House> readAll ();
}
