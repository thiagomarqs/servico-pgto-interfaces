package utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.entities.*;
import model.services.*;

public class Teste {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse("25/06/2018");
		System.out.println(sdf.format(data));
		System.out.println(sdf.format(incrementarMes(data)));
	}
	
	public static Date incrementarMes(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}
}
