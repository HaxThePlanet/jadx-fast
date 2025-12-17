package io.jsonwebtoken.impl;

import io.jsonwebtoken.JwsHeader;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultJwsHeader extends io.jsonwebtoken.impl.DefaultHeader implements JwsHeader {
    public DefaultJwsHeader(Map<String, Object> map) {
        super(map);
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader
    public String getAlgorithm() {
        return getString("alg");
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader
    public String getKeyId() {
        return getString("kid");
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader
    public JwsHeader setAlgorithm(String string) {
        setValue("alg", string);
        return this;
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader
    public JwsHeader setKeyId(String string) {
        setValue("kid", string);
        return this;
    }
}
