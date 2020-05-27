package com.example.facadecontroller.demo.domain.enumExample;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2020/2/26 16:05
 */
public enum UserInfo {

    name("name"),
    idNo("idNo"),
    mobile("mobile");

    private String code;

    UserInfo(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "code='" + code + '\'' +
                '}';
    }

    /**
     * 枚举
     * @param param
     * @return
     */
    public static String eCode(String param){
        for (UserInfo userInfo : UserInfo.values()) {
            if (userInfo.code.equals(param)){
                return userInfo.code;
            }
        }
        return null;
    }
}
