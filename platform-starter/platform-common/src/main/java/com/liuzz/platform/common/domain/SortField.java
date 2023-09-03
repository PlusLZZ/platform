package com.liuzz.platform.common.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortField {

    /**
     * 顺序 - 升序
     */
    public static final String ORDER_ASC = "asc";
    /**
     * 顺序 - 降序
     */
    public static final String ORDER_DESC = "desc";

    private String field;

    private String order;

}
