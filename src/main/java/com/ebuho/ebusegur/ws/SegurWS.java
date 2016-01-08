package com.ebuho.ebusegur.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by johnm on 1/7/2016.
 */
@WebService()
@Component("ebusegur")
public class SegurWS {
    private final static Logger logger = LoggerFactory.getLogger(SegurWS.class);
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @WebMethod
    public String encode(String string){
        return passwordEncoder.encode(string);
    }
    @WebMethod
    public boolean isMatched(String password,String passwordEncrypted){
        return passwordEncoder.matches(password, passwordEncrypted);
    }
    /*public static void main(String[] argumentos) {
        String direccion = "http://localhost:8080/ebusegur";
        Object implementador = new SegurWS();
        Endpoint.publish(direccion, implementador);
    }*/

}
