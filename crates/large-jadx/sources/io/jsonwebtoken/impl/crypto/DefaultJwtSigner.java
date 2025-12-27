package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import java.nio.charset.Charset;
import java.security.Key;

/* compiled from: DefaultJwtSigner.java */
/* loaded from: classes3.dex */
public class DefaultJwtSigner implements JwtSigner {

    private static final Charset US_ASCII;
    private final Encoder<byte[], String> base64UrlEncoder;
    private final Signer signer;
    static {
        DefaultJwtSigner.US_ASCII = Charset.forName("US-ASCII");
    }

    @Deprecated
    public DefaultJwtSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        this(DefaultSignerFactory.INSTANCE, signatureAlgorithm, key, Encoders.BASE64URL);
    }

    public String sign(String str) throws java.io.UnsupportedEncodingException {
        return (String)this.base64UrlEncoder.encode(this.signer.sign(str.getBytes(DefaultJwtSigner.US_ASCII)));
    }

    public DefaultJwtSigner(SignatureAlgorithm signatureAlgorithm, Key key, Encoder<byte[], String> encoder) {
        this(DefaultSignerFactory.INSTANCE, signatureAlgorithm, key, encoder);
    }

    @Deprecated
    public DefaultJwtSigner(SignerFactory signerFactory, SignatureAlgorithm signatureAlgorithm, Key key) {
        this(signerFactory, signatureAlgorithm, key, Encoders.BASE64URL);
    }

    public DefaultJwtSigner(SignerFactory signerFactory, SignatureAlgorithm signatureAlgorithm, Key key, Encoder<byte[], String> encoder) {
        super();
        Assert.notNull(signerFactory, "SignerFactory argument cannot be null.");
        Assert.notNull(encoder, "Base64Url Encoder cannot be null.");
        this.base64UrlEncoder = encoder;
        this.signer = signerFactory.createSigner(signatureAlgorithm, key);
    }
}
