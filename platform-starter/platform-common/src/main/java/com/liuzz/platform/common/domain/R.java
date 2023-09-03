package com.liuzz.platform.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.liuzz.platform.common.exception.ServiceException;
import com.liuzz.platform.utils.string.StringUtils;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private T data;

    @Getter
    @Setter
    private List<T> list;

    @Getter
    @Setter
    private Long total;

    public R<T> setErrorCode(ErrorCode errorCode) {
        this.setCode(errorCode.getCode());
        this.setMsg(errorCode.getMsg());
        return this;
    }

    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setErrorCode(GlobalCode.SUCCESS);
        r.setData(data);
        return r;
    }

    public static <T> R<T> success(long total, List<T> list) {
        R<T> r = new R<>();
        r.setErrorCode(GlobalCode.SUCCESS);
        r.setList(list);
        r.setTotal(total);
        return r;
    }

    public static <T> R<T> success() {
        R<T> r = new R<>();
        r.setErrorCode(GlobalCode.SUCCESS);
        return r;
    }

    public static <T> R<T> empty() {
        R<T> r = new R<>();
        r.setErrorCode(GlobalCode.SUCCESS);
        r.setList(Collections.emptyList());
        r.setTotal(0L);
        return r;
    }

    public static <T> R<T> error() {
        R<T> r = new R<>();
        r.setErrorCode(GlobalCode.INTERNAL_SERVER_ERROR);
        return r;
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.setCode(GlobalCode.INTERNAL_SERVER_ERROR.getCode());
        r.setMsg(msg);
        return r;
    }

    public static <T> R<T> error(String msg, Object... args) {
        R<T> r = new R<>();
        r.setCode(GlobalCode.INTERNAL_SERVER_ERROR.getCode());
        r.setMsg(StringUtils.format(msg, args));
        return r;
    }

    public static <T> R<T> error(ErrorCode errorCode) {
        R<T> r = new R<>();
        return r.setErrorCode(errorCode);
    }

    public static <T> R<T> error(Exception e) {
        R<T> r = new R<>();
        r.setCode(GlobalCode.INTERNAL_SERVER_ERROR.getCode());
        r.setMsg(e.getMessage());
        return r;
    }

    public static <T> R<T> error(ServiceException e) {
        R<T> r = new R<>();
        r.setCode(e.getCode());
        r.setMsg(e.getMessage());
        return r;
    }

}
