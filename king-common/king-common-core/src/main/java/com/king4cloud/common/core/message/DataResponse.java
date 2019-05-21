package com.king4cloud.common.core.message;

import com.king4cloud.common.core.constant.CommonConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse<T> extends BaseResponse {

    private T data;

    public DataResponse(CommonConstants.ResponseStatus status, String message, T data) {
        super(status, message);
        this.data = data;
    }

    public DataResponse(String message, T data) {
        super(message);
        this.data = data;
    }

    public DataResponse(T data) {
        this.data = data;
    }

    public DataResponse() {

    }
}
