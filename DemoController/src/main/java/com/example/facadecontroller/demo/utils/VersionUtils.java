package com.example.facadecontroller.demo.utils;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 可用于版本比较，作用不大
 * @date 2019/12/13 14:25
 */
public class VersionUtils {
    public static int compare(String version1, String version2) {
        String[] v1Array = version1.split("[.]");
        String[] v2Array = version2.split("[.]");
        System.out.println(v2Array);
        int diff = 0;
        int index = 0;
        int minArrLength = Math.min(v1Array.length, v2Array.length);
        System.out.println("最小长度是:"+minArrLength);
        while (index < minArrLength
                && (diff = v1Array[index].length() - v2Array[index].length()) == 0
                && (diff = v1Array[index].compareTo(v2Array[index])) == 0) {
            ++index;
        }
        return diff != 0 ? diff : v1Array.length - v2Array.length;
    }

    public static void main(String[] args) {
        int compare = compare("3.1", "3.11");
        System.out.println(compare);
    }
}
