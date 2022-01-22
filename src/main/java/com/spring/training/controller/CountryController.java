package com.spring.training.controller;

import com.spring.training.model.Country;
import com.spring.training.service.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("countries")
@AllArgsConstructor
@Slf4j
public class CountryController {

    private CountryService countryService;

    @GetMapping(produces = "application/json")
    @Cacheable("countries")
    public List<Country> getCountries() {
      log.info("getting the list of countries");
      return countryService.getCountries();
    }

}