package com.example.facadecontroller.demo.utils;

public class VersionCompareUtil {
    /**
     * 版本号比较 工具
     *
     * @param version1
     * @param version2
     * @return 0:version1和version2版本相同，正数:version1版本高，负数:version2版本高
     */
    public static int compare(String version1, String version2) {
        String[] v1Array = version1.split("[.]");
        String[] v2Array = version2.split("[.]");
        int diff = 0;
        int index = 0;
        int minArrLength = Math.min(v1Array.length, v2Array.length);
        while (index < minArrLength
                && (diff = v1Array[index].length() - v2Array[index].length()) == 0
                && (diff = v1Array[index].compareTo(v2Array[index])) == 0) {
            ++index;
        }
        return diff != 0 ? diff : v1Array.length - v2Array.length;
    }

    public static void main(String[] args) {
        int result = 0;
        try {
            result = VersionCompareUtil.compare("3.5.7", "3.5.9");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
