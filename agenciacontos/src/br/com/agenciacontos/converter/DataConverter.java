package br.com.agenciacontos.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dataConverter")
public class DataConverter extends DateTimeConverter {

    public DataConverter() {
        setPattern("MM/dd/yyyy");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() != getPattern().length()) {
            throw new ConverterException("Invalid format");
        }
        
        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date date;
		try {
			date = formatter.parse(value);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

        return super.getAsObject(context, component, value);
    }

}