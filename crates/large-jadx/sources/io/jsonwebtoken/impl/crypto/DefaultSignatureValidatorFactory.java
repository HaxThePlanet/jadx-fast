package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;

/* loaded from: classes3.dex */
public class DefaultSignatureValidatorFactory implements io.jsonwebtoken.impl.crypto.SignatureValidatorFactory {

    public static final io.jsonwebtoken.impl.crypto.SignatureValidatorFactory INSTANCE;
    static {
        DefaultSignatureValidatorFactory defaultSignatureValidatorFactory = new DefaultSignatureValidatorFactory();
        DefaultSignatureValidatorFactory.INSTANCE = defaultSignatureValidatorFactory;
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureValidatorFactory
    public io.jsonwebtoken.impl.crypto.SignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key2) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key2, "Signing Key cannot be null.");
        switch (i) {
            case 1:
                MacValidator macValidator = new MacValidator(signatureAlgorithm, key2);
                return macValidator;
            case 2:
                RsaSignatureValidator rsaSignatureValidator = new RsaSignatureValidator(signatureAlgorithm, key2);
                return rsaSignatureValidator;
            case 3:
                EllipticCurveSignatureValidator ellipticCurveSignatureValidator = new EllipticCurveSignatureValidator(signatureAlgorithm, key2);
                return ellipticCurveSignatureValidator;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The '");
                stringBuilder.append(signatureAlgorithm.name());
                stringBuilder.append("' algorithm cannot be used for signing.");
                IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
                throw obj4;
        }
    }
}
