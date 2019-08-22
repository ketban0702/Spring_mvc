package com.codegym.formatter;

import com.codegym.model.Employeetype;
import com.codegym.service.EmployeetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project ProvinceFormatter
 * @Email:
 */
@Component
 public class EmployeetypeFormatter implements Formatter<Employeetype> {

    private EmployeetypeService employeetypeService;

    @Autowired
    public EmployeetypeFormatter(EmployeetypeService employeetypeService) {
        this.employeetypeService = employeetypeService;
    }

    @Override
    public Employeetype parse(String text, Locale locale) throws ParseException {
        return employeetypeService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Employeetype object, Locale locale) {
        return "[" + object.getId() + ", " +object.getDescription() + "]";
    }
}
