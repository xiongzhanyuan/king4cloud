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
                .claim(CommonConstants.CONTEXT_KEY_UN_ID, jwtInfo.getUnId())
                .claim(CommonConstants.CONTEXT_KEY_CAMPUS_ID, jwtInfo.getCampusId())
                .claim(CommonConstants.JWT_KEY_USER_CLASS_TYPE, jwtInfo.getUserClassType())
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
        Object userClassType = body.get(CommonConstants.JWT_KEY_USER_CLASS_TYPE);
        Object unId = body.get(CommonConstants.CONTEXT_KEY_UN_ID);
        Object campusId = body.get(CommonConstants.CONTEXT_KEY_CAMPUS_ID);
        return new JWTInfo(userId == null ? "" : userId.toString(), body.getSubject(), unId == null ? "" : unId.toString(), campusId == null ? "" : campusId.toString(), StrUtil.toString(userClassType));
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
