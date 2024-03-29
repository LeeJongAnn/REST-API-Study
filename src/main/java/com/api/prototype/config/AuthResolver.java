package com.api.prototype.config;

import com.api.prototype.Exception.Unauthorized;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Base64;


@Slf4j
public class AuthResolver implements HandlerMethodArgumentResolver {

    private static final String KEY = "1OUusVd9qt7aerP2flB+I8JmEh7yTYz3X3mFlPRamzo=";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String accessToken = webRequest.getHeader("Authorization");
        if (accessToken == null || accessToken.isEmpty()) {
            throw new Unauthorized();
        }

        byte[] decodekey = Base64.getDecoder().decode(KEY);
        try {

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(decodekey).build().parseSignedClaims(accessToken);
            log.info(">>>{}", claimsJws);
        } catch (JwtException e) {
            return new Unauthorized();
        }

        return null;
    }
}
