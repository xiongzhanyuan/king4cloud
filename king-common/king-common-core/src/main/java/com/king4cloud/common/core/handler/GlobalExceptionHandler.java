package com.king4cloud.common.core.handler;


import com.king4cloud.common.core.constant.CommonConstants;
import com.king4cloud.common.core.message.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResponse globalExceptionHandler(HttpServletResponse httpServletResponse, Exception e){
        StringBuffer errorMsg = new StringBuffer();
        if (e instanceof MethodArgumentNotValidException) {
            ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().forEach(objectError -> {
                errorMsg.append(objectError.getDefaultMessage()).append(",");
            });
            return new BaseResponse(CommonConstants.ResponseStatus.FAIL, errorMsg.toString());
        }
        log.error(e.getMessage(), e);
        httpServletResponse.setStatus(500);
        return new BaseResponse(CommonConstants.ResponseStatus.FAIL, e.getMessage());
    }

}
