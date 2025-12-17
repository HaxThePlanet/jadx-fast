package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.lang.Strings;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultHeader<T extends Header<T>>  extends io.jsonwebtoken.impl.JwtMap implements Header<T> {
    public DefaultHeader(Map<String, Object> map) {
        super(map);
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public String getCompressionAlgorithm() {
        String string;
        if (!Strings.hasText(getString("zip"))) {
            string = getString("calg");
        }
        return string;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public String getContentType() {
        return getString("cty");
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public String getType() {
        return getString("typ");
    }

    public T setCompressionAlgorithm(String string) {
        setValue("zip", string);
        return this;
    }

    public T setContentType(String string) {
        setValue("cty", string);
        return this;
    }

    public T setType(String string) {
        setValue("typ", string);
        return this;
    }
}
