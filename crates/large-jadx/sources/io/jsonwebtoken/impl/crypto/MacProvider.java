package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public abstract class MacProvider extends io.jsonwebtoken.impl.crypto.SignatureProvider {
    protected MacProvider(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super(signatureAlgorithm, key2);
        Assert.isTrue(signatureAlgorithm.isHmac(), "SignatureAlgorithm must be a HMAC SHA algorithm.");
    }

    public static SecretKey generateKey() {
        return MacProvider.generateKey(SignatureAlgorithm.HS512);
    }

    public static SecretKey generateKey(SignatureAlgorithm signatureAlgorithm) {
        return MacProvider.generateKey(signatureAlgorithm, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    @Deprecated
    public static SecretKey generateKey(SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom2) {
        Assert.isTrue(signatureAlgorithm.isHmac(), "SignatureAlgorithm argument must represent an HMAC algorithm.");
        return KeyGenerator.getInstance(signatureAlgorithm.getJcaName()).generateKey();
    }
}
