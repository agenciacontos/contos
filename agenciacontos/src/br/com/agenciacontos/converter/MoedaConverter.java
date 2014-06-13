package br.com.agenciacontos.converter;

import java.text.DecimalFormat;
import java.util.Currency;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("moedaConverter")
public class MoedaConverter implements Converter {

//	private static Currency currency = Currency.getInstance("BRL");  
	private static DecimalFormat formato = new DecimalFormat("#,##0.00");  
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		return Double.parseDouble(value.replaceAll("\\.", "").replaceAll(",", "."));  
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		return formato.format(value);
		
	}
}