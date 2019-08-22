package com.codegym.formatter;

import com.codegym.model.Notetype;
import com.codegym.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author Minh_Nguyen on  8/1/2019
 * @Project NoteTypeFormatter
 * @Email:
 */
@Component
public class NoteTypeFormatter implements Formatter<Notetype> {
    private NotetypeService noteTypeService;

    @Autowired
    public NoteTypeFormatter(NotetypeService noteTypeService) {
        this.noteTypeService = noteTypeService;
    }

    @Override
    public Notetype parse(String text, Locale locale) throws ParseException {
        return noteTypeService.findById ( Long.parseLong ( text ) );
    }

    @Override
    public String print(Notetype object, Locale locale) {
        return "["+object.getId ()+","+object.getName ()+"]";
    }
}
