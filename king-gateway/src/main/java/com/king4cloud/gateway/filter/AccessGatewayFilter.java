package com.king4cloud.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

@Configuration
@Slf4j
public class AccessGatewayFilter implements GlobalFilter {

    @Value("${gateway.ignore.startWith}")
    private String ignoreUrls;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst("Authorization");
        String method = request.getMethodValue();
        String url = request.getPath().value();
        log.info("url:{}, method:{}, token:{}", url, method, url);

        if (this.ignoreAuthentication(url)) {
            return chain.filter(exchange);
        }

        //如果token是空 则直接返回错误信息
        if (StrUtil.isBlank(token)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "SUCCESS");
            jsonObject.put("msg", "User Token Forbidden or Expired!");
            return unauthorizedResponse(exchange, jsonObject);
        }

        //调用url鉴权，如果有权限则进入下一个filter 否则返回拒绝
        ServerHttpRequest.Builder builder = request.mutate();
        //将token传给服务端
        builder.header("ClientToken", token);
        return chain.filter(exchange.mutate().request(builder.build()).build());


    }

    /**
     * 网关拒绝请求
     */
    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange, JSONObject baseResponse) {
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = JSONObject.toJSONString(baseResponse).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
        return exchange.getResponse().writeWith(Flux.just(buffer));
    }

    public boolean ignoreAuthentication(String url) {
        return Stream.of(this.ignoreUrls.split(",")).anyMatch(ignoreUrl -> url.startsWith(StringUtils.trim(ignoreUrl)));
    }


}
