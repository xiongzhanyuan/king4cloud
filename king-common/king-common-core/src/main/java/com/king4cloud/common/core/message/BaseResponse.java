package com.king4cloud.common.core.message;

import com.king4cloud.common.core.constant.CommonConstants;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BaseResponse {

    private CommonConstants.ResponseStatus status = CommonConstants.ResponseStatus.SUCCESS;
    private String message ="成功";

    public BaseResponse(CommonConstants.ResponseStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(String message) {
        this.message = message;
    }

    public BaseResponse() {
    }
}
