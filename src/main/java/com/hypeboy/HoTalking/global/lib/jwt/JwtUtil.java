package com.hypeboy.HoTalking.global.lib.jwt;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.repository.MemberRepository;
import com.hypeboy.HoTalking.global.config.properties.AppProperties;
import com.hypeboy.HoTalking.domain.member.exception.MemberNotFoundException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.*;

@Service
@RequiredArgsConstructor
public class JwtUtil {

    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

    private final AppProperties jwtProperties;

    private final MemberRepository memberRepository;

    public String generateToken(String uniqueId, JwtType jwtType) {
        System.out.println(uniqueId);
        Date currentDate = new Date();
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.setTime(currentDate);

        String secretKey = jwtProperties.getSECRET_KEY();

        expiredDate.add(Calendar.DATE, (JwtType.ACCESS_TOKEN==jwtType) ? 1 : 20);

        byte[] apiKeySecretBytes = secretKey.getBytes();
        Key singingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", uniqueId);

        JwtBuilder builder = Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .setExpiration(expiredDate.getTime())
                .signWith(signatureAlgorithm, singingKey);

        return builder.compact();
    }

    @Transactional(readOnly = true)
    public Member validate(String token) {
        Claims claims = parse(token);
        return memberRepository.findByUniqueId(claims.get("id", String.class))
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }

    public Claims parse(String token) {
        return Jwts.parser().setSigningKey(new SecretKeySpec(jwtProperties.getSECRET_KEY().getBytes(), signatureAlgorithm.getJcaName()))
                .parseClaimsJws(token).getBody();
    }

    public String extract(HttpServletRequest request, String type) {

        Enumeration<String> headers = request.getHeaders("Authorization");

        while(headers.hasMoreElements()) {
            String value = headers.nextElement();
            if(value.toLowerCase().startsWith(type.toLowerCase())) {
                return value.substring(type.length()).trim();
            }
        }

        return Strings.EMPTY;
    }

    public Member getMemberByToken(String token) {
        return memberRepository.findByUniqueId(parse(token).get("id", String.class))
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }

}