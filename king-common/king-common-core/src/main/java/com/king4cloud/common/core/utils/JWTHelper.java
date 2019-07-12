package com.king4cloud.common.core.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.king4cloud.common.core.constant.CommonConstants;
import io.jsonwebtoken.*;

import java.time.LocalDateTime;

public class JWTHelper {


    /**
     * 密钥加密token
     *
     * @param priKey
     * @param expire
     * @return
     */
    public static String generateToken(JWTInfo jwtInfo, byte[] priKey, int expire) {
        return Jwts.builder()
                .setSubject(jwtInfo.getUsername())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getUserId())
                .claim(CommonConstants.CONTEXT_KEY_CAMPUS_ID, jwtInfo.getLoginType())
                .setExpiration(LocalDateTimeUtils.convertLDTToDate(LocalDateTime.now().plusSeconds(expire)))
                .signWith(SignatureAlgorithm.RS512, SecureUtil.generatePrivateKey("RSA", priKey))
                .compact();
    }

    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static JWTInfo getInfoFromToken(String token, byte[] pubKey) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException{
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        Object userId = body.get(CommonConstants.JWT_KEY_USER_ID);
        Object loginType = body.get(CommonConstants.JWT_KEY_LOGIN_TYPE);
        return new JWTInfo(userId == null ? "" : userId.toString(), body.getSubject(), StrUtil.toString(loginType));
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException{
        return Jwts.parser().setSigningKey(SecureUtil.generatePublicKey("RSA", pubKey)).parseClaimsJws(token);
    }


}
