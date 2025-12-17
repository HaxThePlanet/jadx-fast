package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.RuntimeEnvironment;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Signature;

/* loaded from: classes3.dex */
abstract class SignatureProvider {

    public static final SecureRandom DEFAULT_SECURE_RANDOM;
    protected final SignatureAlgorithm alg;
    protected final Key key;
    static {
        SecureRandom secureRandom = new SecureRandom();
        SignatureProvider.DEFAULT_SECURE_RANDOM = secureRandom;
        secureRandom.nextBytes(new byte[64]);
    }

    protected SignatureProvider(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super();
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key2, "Key cannot be null.");
        this.alg = signatureAlgorithm;
        this.key = key2;
    }

    protected Signature createSignatureInstance() {
        StringBuilder string;
        String signatureException;
        try {
            return getSignatureInstance();
            string = new StringBuilder();
            signatureException = "Unavailable ";
            string.append(signatureException);
            signatureException = this.alg;
            signatureException = signatureException.getFamilyName();
            string.append(signatureException);
            signatureException = " Signature algorithm '";
            string.append(signatureException);
            signatureException = this.alg;
            signatureException = signatureException.getJcaName();
            string.append(signatureException);
            signatureException = "'.";
            string.append(signatureException);
            string = string.toString();
            signatureException = this.alg;
            signatureException = signatureException.isJdkStandard();
            signatureException = isBouncyCastleAvailable();
            signatureException = new StringBuilder();
            signatureException.append(string);
            string = " This is not a standard JDK algorithm. Try including BouncyCastle in the runtime classpath.";
            signatureException.append(string);
            string = signatureException.toString();
        }
        signatureException = new SignatureException(string, th);
        throw signatureException;
    }

    protected Signature getSignatureInstance() {
        return Signature.getInstance(this.alg.getJcaName());
    }

    protected boolean isBouncyCastleAvailable() {
        return RuntimeEnvironment.BOUNCY_CASTLE_AVAILABLE;
    }
}
