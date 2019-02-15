package com.epam.item.utils;

import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtils {
	
	public String decodeData(String data) {
		return new String(Base64.getDecoder().decode(data.getBytes()));
	}
	
	public String encodeData(String data) {
		return Base64.getEncoder().encodeToString(data.getBytes());
	}

}
