package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import java.nio.charset.Charset;
import java.security.Key;

/* loaded from: classes3.dex */
public class DefaultJwtSigner implements io.jsonwebtoken.impl.crypto.JwtSigner {

    private static final Charset US_ASCII;
    private final Encoder<byte[], String> base64UrlEncoder;
    private final io.jsonwebtoken.impl.crypto.Signer signer;
    static {
        DefaultJwtSigner.US_ASCII = Charset.forName("US-ASCII");
    }

    @Deprecated
    public DefaultJwtSigner(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super(DefaultSignerFactory.INSTANCE, signatureAlgorithm, key2, Encoders.BASE64URL);
    }

    public DefaultJwtSigner(SignatureAlgorithm signatureAlgorithm, Key key2, Encoder<byte[], String> encoder3) {
        super(DefaultSignerFactory.INSTANCE, signatureAlgorithm, key2, encoder3);
    }

    @Deprecated
    public DefaultJwtSigner(io.jsonwebtoken.impl.crypto.SignerFactory signerFactory, SignatureAlgorithm signatureAlgorithm2, Key key3) {
        super(signerFactory, signatureAlgorithm2, key3, Encoders.BASE64URL);
    }

    public DefaultJwtSigner(io.jsonwebtoken.impl.crypto.SignerFactory signerFactory, SignatureAlgorithm signatureAlgorithm2, Key key3, Encoder<byte[], String> encoder4) {
        super();
        Assert.notNull(signerFactory, "SignerFactory argument cannot be null.");
        Assert.notNull(encoder4, "Base64Url Encoder cannot be null.");
        this.base64UrlEncoder = encoder4;
        this.signer = signerFactory.createSigner(signatureAlgorithm2, key3);
    }

    @Override // io.jsonwebtoken.impl.crypto.JwtSigner
    public String sign(String string) {
        return (String)this.base64UrlEncoder.encode(this.signer.sign(string.getBytes(DefaultJwtSigner.US_ASCII)));
    }
}
