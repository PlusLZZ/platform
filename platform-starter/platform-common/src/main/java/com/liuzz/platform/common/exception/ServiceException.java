package com.liuzz.platform.common.exception;

import com.liuzz.platform.common.domain.ErrorCode;
import com.liuzz.platform.common.domain.GlobalCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 业务逻辑异常
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ServiceException extends RuntimeException{

    private Integer code;

    private String message;

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message) {
        this.code = GlobalCode.INTERNAL_SERVER_ERROR.getCode();
        this.message = message;
    }

}
