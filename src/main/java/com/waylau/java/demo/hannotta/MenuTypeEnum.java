package com.waylau.java.demo.hannotta;


/**
 * Menu item type.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-16
 */
public enum MenuTypeEnum {

    /**
     * 碟子数
     */
    DISC(0),

    /**
     * 从新开始
     */
    RENEW(1),

    /**
     * 自动演示
     */
    AUTO(2);

    private int value;

    MenuTypeEnum(int value) {
        this.value = value;
    }
 
    public int getValue() {
        return value;
    }
}

 
