package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.lang.Assert;
import java.nio.charset.Charset;
import java.security.Key;

/* compiled from: DefaultJwtSignatureValidator.java */
/* loaded from: classes3.dex */
public class DefaultJwtSignatureValidator implements JwtSignatureValidator {

    private static final Charset US_ASCII;
    private final Decoder<String, byte[]> base64UrlDecoder;
    private final SignatureValidator signatureValidator;
    static {
        DefaultJwtSignatureValidator.US_ASCII = Charset.forName("US-ASCII");
    }

    @Deprecated
    public DefaultJwtSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        this(DefaultSignatureValidatorFactory.INSTANCE, signatureAlgorithm, key, Decoders.BASE64URL);
    }

    public boolean isValid(String str, String str2) throws java.io.UnsupportedEncodingException {
        return this.signatureValidator.isValid(str.getBytes(DefaultJwtSignatureValidator.US_ASCII), (byte[])this.base64UrlDecoder.decode(str2));
    }

    public DefaultJwtSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key, Decoder<String, byte[]> decoder) {
        this(DefaultSignatureValidatorFactory.INSTANCE, signatureAlgorithm, key, decoder);
    }

    @Deprecated
    public DefaultJwtSignatureValidator(SignatureValidatorFactory signatureValidatorFactory, SignatureAlgorithm signatureAlgorithm, Key key) {
        this(signatureValidatorFactory, signatureAlgorithm, key, Decoders.BASE64URL);
    }

    public DefaultJwtSignatureValidator(SignatureValidatorFactory signatureValidatorFactory, SignatureAlgorithm signatureAlgorithm, Key key, Decoder<String, byte[]> decoder) {
        super();
        Assert.notNull(signatureValidatorFactory, "SignerFactory argument cannot be null.");
        Assert.notNull(decoder, "Base64Url decoder argument cannot be null.");
        this.signatureValidator = signatureValidatorFactory.createSignatureValidator(signatureAlgorithm, key);
        this.base64UrlDecoder = decoder;
    }
}
