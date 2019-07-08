//package com.king4cloud.king.biz.user.config;
//
//import feign.Response;
//import feign.Util;
//import feign.codec.ErrorDecoder;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//@Slf4j
//public class ExceptionErrorHandler implements ErrorDecoder {
//    @Override
//    public Exception decode(String s, Response response) {
//        try {
//            String body = Util.toString(response.body().asReader());
//            log.error(body);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//}
