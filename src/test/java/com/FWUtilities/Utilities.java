package com.FWUtilities;

import java.util.Date;

public class Utilities {


	public static  String generateRandomEmail() {
		Date data = new Date();
		String timestamp=data.toString().replaceAll(" ", "_").replaceAll(":", "_");
		return "renekab"+timestamp+"@gmail.com";
		
	}
}
