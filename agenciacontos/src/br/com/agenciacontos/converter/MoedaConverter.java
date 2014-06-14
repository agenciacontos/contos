package br.com.agenciacontos.converter;

import java.text.DecimalFormat;

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

		if(value != null && !value.equalsIgnoreCase("")){
			return Double.parseDouble(value.replaceAll("\\.", "").replaceAll(",", "."));  
		}else{
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if(value != null){
			return formato.format(value);
		}else{
			return null;
		}
		
	}
}