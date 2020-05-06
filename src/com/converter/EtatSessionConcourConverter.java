package com.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


public class EtatSessionConcourConverter implements Serializable, Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String codEtatSession = (String) value;
		String codEtatSessionConv = null;

		if (codEtatSession.equals("E")) {
			codEtatSessionConv = "En cours";
		} else if (codEtatSession.equals("V")) {
			codEtatSessionConv = "Validée";
		} else if (codEtatSession.equals("C")) {
			codEtatSessionConv = "Cloturée";
		}
		return codEtatSessionConv;
	}

}