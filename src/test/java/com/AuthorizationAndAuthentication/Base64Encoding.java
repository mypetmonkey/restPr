package com.AuthorizationAndAuthentication;

import java.util.Base64;

public class Base64Encoding {
	
public static void main(String[] args) {
	
	String unpwd="myun:mppwd";
	String base64encoded=Base64.getEncoder().encodeToString(unpwd.getBytes());
	System.out.println("encoded "+base64encoded);
	byte[] decode = Base64.getDecoder().decode(base64encoded);
	System.out.println("decode "+new String(decode));
}	

}
