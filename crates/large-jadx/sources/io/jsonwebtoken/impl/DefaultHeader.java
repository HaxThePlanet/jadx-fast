package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.lang.Strings;
import java.util.Map;

/* compiled from: DefaultHeader.java */
/* loaded from: classes3.dex */
public class DefaultHeader<T extends Header<T>> extends JwtMap implements Header<T> {
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

    @Override // io.jsonwebtoken.impl.JwtMap
    public T setCompressionAlgorithm(String str) {
        setValue("zip", str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public T setContentType(String str) {
        setValue("cty", str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.JwtMap
    public T setType(String str) {
        setValue("typ", str);
        return this;
    }

    public DefaultHeader(Map<String, Object> map) {
        super(map);
    }
}
