package io.jsonwebtoken;

import io.jsonwebtoken.lang.Classes;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Jwts {

    private static final Class[] MAP_ARG;
    static {
        Class[] arr = new Class[1];
        Jwts.MAP_ARG = arr;
    }

    public static io.jsonwebtoken.JwtBuilder builder() {
        return (JwtBuilder)Classes.newInstance("io.jsonwebtoken.impl.DefaultJwtBuilder");
    }

    public static io.jsonwebtoken.Claims claims() {
        return (Claims)Classes.newInstance("io.jsonwebtoken.impl.DefaultClaims");
    }

    public static io.jsonwebtoken.Claims claims(Map<String, Object> map) {
        Object[] arr = new Object[1];
        return (Claims)Classes.newInstance("io.jsonwebtoken.impl.DefaultClaims", Jwts.MAP_ARG, map);
    }

    public static io.jsonwebtoken.Header header() {
        return (Header)Classes.newInstance("io.jsonwebtoken.impl.DefaultHeader");
    }

    public static io.jsonwebtoken.Header header(Map<String, Object> map) {
        Object[] arr = new Object[1];
        return (Header)Classes.newInstance("io.jsonwebtoken.impl.DefaultHeader", Jwts.MAP_ARG, map);
    }

    public static io.jsonwebtoken.JwsHeader jwsHeader() {
        return (JwsHeader)Classes.newInstance("io.jsonwebtoken.impl.DefaultJwsHeader");
    }

    public static io.jsonwebtoken.JwsHeader jwsHeader(Map<String, Object> map) {
        Object[] arr = new Object[1];
        return (JwsHeader)Classes.newInstance("io.jsonwebtoken.impl.DefaultJwsHeader", Jwts.MAP_ARG, map);
    }

    @Deprecated
    public static io.jsonwebtoken.JwtParser parser() {
        return (JwtParser)Classes.newInstance("io.jsonwebtoken.impl.DefaultJwtParser");
    }

    public static io.jsonwebtoken.JwtParserBuilder parserBuilder() {
        return (JwtParserBuilder)Classes.newInstance("io.jsonwebtoken.impl.DefaultJwtParserBuilder");
    }
}
