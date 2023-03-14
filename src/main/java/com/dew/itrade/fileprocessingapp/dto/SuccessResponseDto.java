package com.dew.itrade.fileprocessingapp.dto;

import com.dew.itrade.fileprocessingapp.constant.ApplicationConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SuccessResponseDto <T> implements ResponseDto<T>{

    protected Integer code = ApplicationConstant.HTTP_RESPONSE_SUCCESS_CODE;
    protected T data;
    protected String message = null;
    protected Integer status = ApplicationConstant.SUCCESS_STATUS_CODE;
    protected long timestamp;

    public SuccessResponseDto() {
        this(null, ApplicationConstant.SUCCESS);
    }

    public SuccessResponseDto(T data) {
        this(data, ApplicationConstant.SUCCESS);
    }

    public SuccessResponseDto(String message) {
        this.message = message;
    }

    public SuccessResponseDto(T data2, String message2) {
        this.data = data2;
        this.message = message2;
        this.timestamp = System.currentTimeMillis();
    }

    public SuccessResponseDto(T data2, String message2, Integer status) {
        this(data2, message2);
        this.status = status;
    }

    public SuccessResponseDto(Integer status) {
        this.status = status;
    }



    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setCode(Integer code) {
        this.code=code;
    }

    @Override
    public void setData(T data) {
        this.data=data;
    }

    @Override
    public void setMessage(String message) {
        this.message=message;
    }

    @Override
    public void setStatus(Integer status) {
        this.status=status;
    }

    @Override
    public void setTimeStamp(long currentTimeMillis) {
        this.timestamp=currentTimeMillis;
    }
}
