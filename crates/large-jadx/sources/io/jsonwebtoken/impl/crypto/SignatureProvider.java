package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.RuntimeEnvironment;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;

/* compiled from: SignatureProvider.java */
/* loaded from: classes3.dex */
abstract class SignatureProvider {

    public static final SecureRandom DEFAULT_SECURE_RANDOM = new SecureRandom();
    protected final SignatureAlgorithm alg;
    protected final Key key;
    static {
        obj.nextBytes(new byte[64]);
    }

    protected SignatureProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        super();
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key, "Key cannot be null.");
        this.alg = signatureAlgorithm;
        this.key = key;
    }

    protected Signature createSignatureInstance() throws SignatureException {
        StringBuilder str;
        String signatureException;
        try {
        } catch (java.security.NoSuchAlgorithmException noSuchAlgorithm) {
            str = new StringBuilder();
            signatureException = "Unavailable ";
            str.append(signatureException);
            signatureException = this.alg.getFamilyName();
            str.append(this.alg);
            signatureException = " Signature algorithm '";
            str.append(this.alg);
            signatureException = this.alg.getJcaName();
            str.append(this.alg);
            signatureException = "'.";
            str.append(this.alg);
            str = str.toString();
            signatureException = this.alg.isJdkStandard();
        }
        return getSignatureInstance();
    }

    protected Signature getSignatureInstance() throws NoSuchAlgorithmException {
        return Signature.getInstance(this.alg.getJcaName());
    }

    protected boolean isBouncyCastleAvailable() {
        return RuntimeEnvironment.BOUNCY_CASTLE_AVAILABLE;
    }
}
