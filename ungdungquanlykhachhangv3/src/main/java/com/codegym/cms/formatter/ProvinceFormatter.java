package com.codegym.cms.formatter;

import com.codegym.cms.model.Province;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project ProvinceFormatter
 * @Email:
 */
@Component
public class ProvinceFormatter implements Formatter<Province> {

    @Autowired
    private ProvinceService provinceService;
    @Autowired
    public ProvinceFormatter(ProvinceService provinceService){
        this.provinceService=provinceService;
    }
    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return provinceService.findById ( Long.parseLong ( text ) );
    }

    @Override
    public String print(Province object, Locale locale) {
        return "["+object.getId ()+","+object.getName ()+"]";
    }
}