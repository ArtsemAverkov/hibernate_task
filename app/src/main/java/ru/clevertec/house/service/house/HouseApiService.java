package ru.clevertec.house.service.house;

import org.springframework.stereotype.Service;
import ru.clevertec.house.entity.House;
import ru.clevertec.house.repository.house.HouseRepository;

import java.util.List;

@Service
public class HouseApiService implements HouseService{

    private final HouseRepository houseRepository;

    public HouseApiService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public long create(House house) {
        return houseRepository.create(house);
    }

    @Override
    public House read(long id) throws Exception {
        return houseRepository.read(id);
    }

    @Override
    public boolean update(House house, Long id) {
        return houseRepository.update(house, id);
    }

    @Override
    public boolean delete(Long id) {
        return houseRepository.delete(id);
    }

    @Override
    public List<House> readAll() {
        return houseRepository.readAll();
    }
}
