package io.jsonwebtoken.impl;

import io.jsonwebtoken.JwsHeader;
import java.util.Map;

/* compiled from: DefaultJwsHeader.java */
/* loaded from: classes3.dex */
public class DefaultJwsHeader extends DefaultHeader implements JwsHeader {
    @Override // io.jsonwebtoken.impl.DefaultHeader
    public String getAlgorithm() {
        return getString("alg");
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader
    public String getKeyId() {
        return getString("kid");
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader
    public JwsHeader setAlgorithm(String str) {
        setValue("alg", str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader
    public JwsHeader setKeyId(String str) {
        setValue("kid", str);
        return this;
    }

    public DefaultJwsHeader(Map<String, Object> map) {
        super(map);
    }
}
