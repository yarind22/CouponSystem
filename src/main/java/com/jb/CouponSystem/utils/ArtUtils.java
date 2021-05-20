package com.jb.CouponSystem.utils;

public class ArtUtils {
    private static int COUNT=1;
    public static void testInfo(String contect){
        System.out.println("-----------------------------------------------------");
        System.out.println(String.format("            Test #%d  :  %s              ",COUNT++,contect));
        System.out.println("-----------------------------------------------------");
    }


}
