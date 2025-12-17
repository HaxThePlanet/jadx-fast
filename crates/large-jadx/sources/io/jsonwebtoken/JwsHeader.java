package io.jsonwebtoken;

/* loaded from: classes3.dex */
public interface JwsHeader<T extends io.jsonwebtoken.JwsHeader<T>>  extends io.jsonwebtoken.Header<T> {

    public static final String ALGORITHM = "alg";
    public static final String CRITICAL = "crit";
    public static final String JSON_WEB_KEY = "jwk";
    public static final String JWK_SET_URL = "jku";
    public static final String KEY_ID = "kid";
    public static final String X509_CERT_CHAIN = "x5c";
    public static final String X509_CERT_SHA1_THUMBPRINT = "x5t";
    public static final String X509_CERT_SHA256_THUMBPRINT = "x5t#S256";
    public static final String X509_URL = "x5u";
    @Override // io.jsonwebtoken.Header
    public abstract String getAlgorithm();

    @Override // io.jsonwebtoken.Header
    public abstract String getKeyId();

    public abstract T setAlgorithm(String string);

    public abstract T setKeyId(String string);
}
