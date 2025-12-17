package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.RequiredTypeException;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultClaims extends io.jsonwebtoken.impl.JwtMap implements Claims {

    private static final String CONVERSION_ERROR_MSG = "Cannot convert existing claim value of type '%s' to desired type '%s'. JJWT only converts simple String, Date, Long, Integer, Short and Byte types automatically. Anything more complex is expected to be already converted to your desired type by the JSON Deserializer implementation. You may specify a custom Deserializer for a JwtParser with the desired conversion configuration via the JwtParserBuilder.deserializeJsonWith() method. See https://github.com/jwtk/jjwt#custom-json-processor for more information. If using Jackson, you can specify custom claim POJO types as described in https://github.com/jwtk/jjwt#json-jackson-custom-types";
    public DefaultClaims(Map<String, ?> map) {
        super(map);
    }

    private <T> T castClaimValue(Object object, Class<T> class2) {
        boolean intValue;
        Class<Byte> obj;
        Object obj4;
        if (object instanceof Integer) {
            intValue = (Integer)object.intValue();
            obj = Long.class;
            if (class2 == obj) {
                obj4 = Long.valueOf((long)intValue);
            } else {
                if (class2 == Short.class && -32768 <= intValue && intValue <= 32767) {
                    if (-32768 <= intValue) {
                        if (intValue <= 32767) {
                            obj4 = Short.valueOf((short)intValue);
                        } else {
                            if (class2 == Byte.class && -128 <= intValue && intValue <= 127) {
                                if (-128 <= intValue) {
                                    if (intValue <= 127) {
                                        obj4 = Byte.valueOf((byte)intValue);
                                    }
                                }
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        }
        if (!class2.isInstance(obj4)) {
        } else {
            return class2.cast(obj4);
        }
        Object[] arr = new Object[2];
        RequiredTypeException requiredTypeException = new RequiredTypeException(String.format("Cannot convert existing claim value of type '%s' to desired type '%s'. JJWT only converts simple String, Date, Long, Integer, Short and Byte types automatically. Anything more complex is expected to be already converted to your desired type by the JSON Deserializer implementation. You may specify a custom Deserializer for a JwtParser with the desired conversion configuration via the JwtParserBuilder.deserializeJsonWith() method. See https://github.com/jwtk/jjwt#custom-json-processor for more information. If using Jackson, you can specify custom claim POJO types as described in https://github.com/jwtk/jjwt#json-jackson-custom-types", obj4.getClass(), class2));
        throw requiredTypeException;
    }

    private static boolean isSpecDate(String string) {
        boolean equals;
        Object obj1;
        if (!"exp".equals(string) && !"iat".equals(string)) {
            if (!"iat".equals(string)) {
                if ("nbf".equals(string)) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public <T> T get(String string, Class<T> class2) {
        Object specDate;
        boolean specDate2;
        specDate = get(string);
        if (specDate == null) {
            return 0;
        }
        if (Date.class.equals(class2)) {
            if (DefaultClaims.isSpecDate(string)) {
                specDate = JwtMap.toSpecDate(specDate, string);
            } else {
                specDate = JwtMap.toDate(specDate, string);
            }
        }
        return castClaimValue(specDate, class2);
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

    @Override // io.jsonwebtoken.impl.JwtMap
    public Object put(Object object, Object object2) {
        return put((String)object, object2);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Object put(String string, Object object2) {
        boolean specDate;
        if (object2 instanceof Date && DefaultClaims.isSpecDate(string)) {
            if (DefaultClaims.isSpecDate(string)) {
                return setDateAsSeconds(string, (Date)object2);
            }
        }
        return super.put(string, object2);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setAudience(String string) {
        setValue("aud", string);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public ClaimsMutator setAudience(String string) {
        return setAudience(string);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setExpiration(Date date) {
        setDateAsSeconds("exp", date);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public ClaimsMutator setExpiration(Date date) {
        return setExpiration(date);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setId(String string) {
        setValue("jti", string);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public ClaimsMutator setId(String string) {
        return setId(string);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setIssuedAt(Date date) {
        setDateAsSeconds("iat", date);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public ClaimsMutator setIssuedAt(Date date) {
        return setIssuedAt(date);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setIssuer(String string) {
        setValue("iss", string);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public ClaimsMutator setIssuer(String string) {
        return setIssuer(string);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setNotBefore(Date date) {
        setDateAsSeconds("nbf", date);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public ClaimsMutator setNotBefore(Date date) {
        return setNotBefore(date);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public Claims setSubject(String string) {
        setValue("sub", string);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public ClaimsMutator setSubject(String string) {
        return setSubject(string);
    }
}
