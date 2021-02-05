package io.seven4x.hz2021;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UrlBase64Demo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "sflsfsldfasdfsadfsadfsa as";
        byte[] encode = Base64.getUrlEncoder().encode(str.getBytes(StandardCharsets.UTF_8));
        String s = new String(encode, "utf-8");
        System.out.println(s);
        byte[] decode = Base64.getUrlDecoder().decode(s);
        System.out.println(new String(decode, "utf-8"));
//        byte[] decode2 = Base64.getDecoder().decode("c2Zsc2ZzbGRmYXNkZnNhZGZzYWRmc2EgYXM");
//        System.out.println(new String(decode2, "utf-8"));
//        //=符号转义成%3D再转回来异常 ，=号起填充作用
//        byte[] decode3 = Base64.getDecoder().decode("c2Zsc2ZzbGRmYXNkZnNhZGZzYWRmc2EgYXM%3D");
//        System.out.println(new String(decode3, "utf-8"));
    }
}
