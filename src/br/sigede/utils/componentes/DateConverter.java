package br.sigede.utils.componentes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.ioc.ApplicationScoped;

@Convert(Date.class)
@ApplicationScoped
public class DateConverter implements Converter<Date> {

	@Override
	public Date convert(String value, Class<? extends Date> arg1, ResourceBundle msg) {
		if(value == null || value.isEmpty()) {
			return null;
		}
		
		try {  
            String dataEmTexto = value;  
            Date date = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dataEmTexto);  
            return date;  
        } catch (ParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            return null;  
        }  
		
	}

}
