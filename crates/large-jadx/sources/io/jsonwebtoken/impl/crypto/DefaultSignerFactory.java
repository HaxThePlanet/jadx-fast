package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;

/* loaded from: classes3.dex */
public class DefaultSignerFactory implements io.jsonwebtoken.impl.crypto.SignerFactory {

    public static final io.jsonwebtoken.impl.crypto.SignerFactory INSTANCE;
    static {
        DefaultSignerFactory defaultSignerFactory = new DefaultSignerFactory();
        DefaultSignerFactory.INSTANCE = defaultSignerFactory;
    }

    @Override // io.jsonwebtoken.impl.crypto.SignerFactory
    public io.jsonwebtoken.impl.crypto.Signer createSigner(SignatureAlgorithm signatureAlgorithm, Key key2) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key2, "Signing Key cannot be null.");
        switch (i) {
            case 1:
                MacSigner macSigner = new MacSigner(signatureAlgorithm, key2);
                return macSigner;
            case 2:
                RsaSigner rsaSigner = new RsaSigner(signatureAlgorithm, key2);
                return rsaSigner;
            case 3:
                EllipticCurveSigner ellipticCurveSigner = new EllipticCurveSigner(signatureAlgorithm, key2);
                return ellipticCurveSigner;
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
