package io.jsonwebtoken;

import java.util.Map;

/* loaded from: classes3.dex */
public interface Header<T extends io.jsonwebtoken.Header<T>>  extends Map<String, Object> {

    public static final String COMPRESSION_ALGORITHM = "zip";
    public static final String CONTENT_TYPE = "cty";
    @Deprecated
    public static final String DEPRECATED_COMPRESSION_ALGORITHM = "calg";
    public static final String JWT_TYPE = "JWT";
    public static final String TYPE = "typ";
    @Override // java.util.Map
    public abstract String getCompressionAlgorithm();

    @Override // java.util.Map
    public abstract String getContentType();

    @Override // java.util.Map
    public abstract String getType();

    public abstract T setCompressionAlgorithm(String string);

    public abstract T setContentType(String string);

    public abstract T setType(String string);
}
