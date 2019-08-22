package com.codegym.formatter;

import com.codegym.model.Clazz;
import com.codegym.service.ClazzService;
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
 public class ClazzFormatter implements Formatter<Clazz> {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    public ClazzFormatter(ClazzService clazzService) {
        this.clazzService = clazzService;
    }
    @Override
    public Clazz parse(String text, Locale locale) throws ParseException {
        return clazzService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Clazz object, Locale locale) {
        return "[" + object.getId() + ", " +object.getDescription() +object.getName()+ "]";
    }
}
