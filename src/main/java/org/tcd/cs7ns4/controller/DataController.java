package org.tcd.cs7ns4.controller;

import org.tcd.cs7ns4.entity.DataEntity;
import org.tcd.cs7ns4.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/data")
    public DataEntity writeData(@RequestBody String jsonData) {
        return dataService.saveData(jsonData);
    }

    @GetMapping("/data")
    public List<DataEntity> readData() {
        return dataService.getAllData();
    }
}
