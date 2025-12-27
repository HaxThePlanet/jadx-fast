package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.RequiredTypeException;
import java.util.Date;
import java.util.Map;

/* compiled from: DefaultClaims.java */
/* loaded from: classes3.dex */
public class DefaultClaims extends JwtMap implements Claims {

    private static final String CONVERSION_ERROR_MSG = "Cannot convert existing claim value of type '%s' to desired type '%s'. JJWT only converts simple String, Date, Long, Integer, Short and Byte types automatically. Anything more complex is expected to be already converted to your desired type by the JSON Deserializer implementation. You may specify a custom Deserializer for a JwtParser with the desired conversion configuration via the JwtParserBuilder.deserializeJsonWith() method. See https://github.com/jwtk/jjwt#custom-json-processor for more information. If using Jackson, you can specify custom claim POJO types as described in https://github.com/jwtk/jjwt#json-jackson-custom-types";
    private <T> T castClaimValue(Object object, Class<T> cls) throws RequiredTypeException {
        Byte num;
        z = object instanceof Integer;
        if (object instanceof Integer) {
            int value = (Integer)object.intValue();
            obj = Long.class;
            if (cls == obj) {
                Long num3 = Long.valueOf((long)value);
            } else {
                obj2 = Short.class;
                if (cls != obj2 || -32768 > value || value > 32767) {
                    obj = Byte.class;
                    if (cls == obj && -128 <= value && value <= 127) {
                        num = Byte.valueOf((byte)value);
                    }
                } else {
                    Short num2 = Short.valueOf((short)value);
                }
            }
        }
        if (!cls.isInstance(num)) {
            Object[] arr = new Object[2];
            throw new RequiredTypeException(String.format("Cannot convert existing claim value of type '%s' to desired type '%s'. JJWT only converts simple String, Date, Long, Integer, Short and Byte types automatically. Anything more complex is expected to be already converted to your desired type by the JSON Deserializer implementation. You may specify a custom Deserializer for a JwtParser with the desired conversion configuration via the JwtParserBuilder.deserializeJsonWith() method. See https://github.com/jwtk/jjwt#custom-json-processor for more information. If using Jackson, you can specify custom claim POJO types as described in https://github.com/jwtk/jjwt#json-jackson-custom-types", new Object[] { num.getClass(), cls }));
        } else {
            return cls.cast(num);
        }
    }

    private static boolean isSpecDate(String str) {
        boolean equals;
        boolean z = false;
        if (!"exp".equals(str)) {
            if (!"iat".equals(str)) {
                str2 = "nbf";
                if (str2.equals(str)) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
        }
        return z;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public <T> T get(String str, Class<T> cls) {
        Object value;
        value = get(str);
        if (value == null) {
            return null;
        }
        if (Date.class.equals(cls) && DefaultClaims.isSpecDate(str)) {
            Date specDate2 = JwtMap.toSpecDate(value, str);
        }
        return castClaimValue(value, cls);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public String getAudience() {
        return getString("aud");
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Date getExpiration() {
        return (Date)get("exp", Date.class);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public String getId() {
        return getString("jti");
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Date getIssuedAt() {
        return (Date)get("iat", Date.class);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public String getIssuer() {
        return getString("iss");
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Date getNotBefore() {
        return (Date)get("nbf", Date.class);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public String getSubject() {
        return getString("sub");
    }

    public DefaultClaims(Map<String, ?> map) {
        super(map);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Object put(String str, Object object) {
        specDate = object instanceof Date;
        if (object instanceof Date && DefaultClaims.isSpecDate(str)) {
            return setDateAsSeconds(str, object);
        }
        return super.put(str, object);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setAudience(String str) {
        setValue("aud", str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setExpiration(Date date) {
        setDateAsSeconds("exp", date);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setId(String str) {
        setValue("jti", str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setIssuedAt(Date date) {
        setDateAsSeconds("iat", date);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setIssuer(String str) {
        setValue("iss", str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setNotBefore(Date date) {
        setDateAsSeconds("nbf", date);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setSubject(String str) {
        setValue("sub", str);
        return this;
    }
}
