package com.learning.persistence.regex;

/**
 * Created by zzf on 17/5/11.
 */
public class Test1 {

    public static void main(String[] args) {
        String verifyCode = "0cb730fc-fc03-4cf3-915d-f0d2f0f47399-2c507-63273xxx5A4EF0BBCB90AA353EAE65982B86F55E%7C83304784848914393051092849667%7C8314b5f7f9c29d2334ded83097e0829****MTQ5NDQ3MDg2MzI3M15wYXNzcG9ydC5zdW5pbmcuY29tXjE0XjdeNQ%3D%3D";
        String[] split = verifyCode.split("\\*\\*\\*\\*");
        System.out.println("code:" + split[0]);
        System.out.println("cookie:" + split[1]);
    }
}
