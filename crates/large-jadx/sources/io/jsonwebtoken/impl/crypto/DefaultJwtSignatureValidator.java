package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.lang.Assert;
import java.nio.charset.Charset;
import java.security.Key;

/* loaded from: classes3.dex */
public class DefaultJwtSignatureValidator implements io.jsonwebtoken.impl.crypto.JwtSignatureValidator {

    private static final Charset US_ASCII;
    private final Decoder<String, byte[]> base64UrlDecoder;
    private final io.jsonwebtoken.impl.crypto.SignatureValidator signatureValidator;
    static {
        DefaultJwtSignatureValidator.US_ASCII = Charset.forName("US-ASCII");
    }

    @Deprecated
    public DefaultJwtSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super(DefaultSignatureValidatorFactory.INSTANCE, signatureAlgorithm, key2, Decoders.BASE64URL);
    }

    public DefaultJwtSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key2, Decoder<String, byte[]> decoder3) {
        super(DefaultSignatureValidatorFactory.INSTANCE, signatureAlgorithm, key2, decoder3);
    }

    @Deprecated
    public DefaultJwtSignatureValidator(io.jsonwebtoken.impl.crypto.SignatureValidatorFactory signatureValidatorFactory, SignatureAlgorithm signatureAlgorithm2, Key key3) {
        super(signatureValidatorFactory, signatureAlgorithm2, key3, Decoders.BASE64URL);
    }

    public DefaultJwtSignatureValidator(io.jsonwebtoken.impl.crypto.SignatureValidatorFactory signatureValidatorFactory, SignatureAlgorithm signatureAlgorithm2, Key key3, Decoder<String, byte[]> decoder4) {
        super();
        Assert.notNull(signatureValidatorFactory, "SignerFactory argument cannot be null.");
        Assert.notNull(decoder4, "Base64Url decoder argument cannot be null.");
        this.signatureValidator = signatureValidatorFactory.createSignatureValidator(signatureAlgorithm2, key3);
        this.base64UrlDecoder = decoder4;
    }

    @Override // io.jsonwebtoken.impl.crypto.JwtSignatureValidator
    public boolean isValid(String string, String string2) {
        return this.signatureValidator.isValid(string.getBytes(DefaultJwtSignatureValidator.US_ASCII), (byte[])this.base64UrlDecoder.decode(string2));
    }
}
