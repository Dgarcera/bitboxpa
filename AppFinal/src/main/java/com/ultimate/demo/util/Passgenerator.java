package com.ultimate.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Passgenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //El String que mandamos al metodo encode es el password que queremos encriptar.
        System.out.println("El código encriptado es: ");
        System.out.println(bCryptPasswordEncoder.encode("password"));
    }
}
