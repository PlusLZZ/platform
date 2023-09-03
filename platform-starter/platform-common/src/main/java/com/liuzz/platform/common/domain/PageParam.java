package com.liuzz.platform.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam implements Serializable {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private List<SortField> sorts;


}
