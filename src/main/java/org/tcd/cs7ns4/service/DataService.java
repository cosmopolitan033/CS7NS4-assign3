package org.tcd.cs7ns4.service;

import org.tcd.cs7ns4.annotation.ReadOnly;
import org.tcd.cs7ns4.entity.DataEntity;
import org.tcd.cs7ns4.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    @Transactional
    public DataEntity saveData(String jsonData) {
        DataEntity entity = new DataEntity();
        entity.setData(jsonData);
        return dataRepository.save(entity);
    }

    @ReadOnly
    public List<DataEntity> getAllData() {
        return dataRepository.findAll();
    }
}
