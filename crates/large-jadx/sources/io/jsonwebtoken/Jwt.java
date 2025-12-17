package io.jsonwebtoken;

/* loaded from: classes3.dex */
public interface Jwt<H extends io.jsonwebtoken.Header, B>  {
    public abstract B getBody();

    public abstract H getHeader();
}
