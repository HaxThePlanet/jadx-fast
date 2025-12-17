package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class MacSigner extends io.jsonwebtoken.impl.crypto.MacProvider implements io.jsonwebtoken.impl.crypto.Signer {
    public MacSigner(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super(signatureAlgorithm, key2);
        Assert.isTrue(signatureAlgorithm.isHmac(), "The MacSigner only supports HMAC signature algorithms.");
        if (!key2 instanceof SecretKey) {
        } else {
        }
        StringBuilder obj2 = new StringBuilder();
        obj2.append("MAC signatures must be computed and verified using a SecretKey.  The specified key of type ");
        obj2.append(key2.getClass().getName());
        obj2.append(" is not a SecretKey.");
        IllegalArgumentException obj3 = new IllegalArgumentException(obj2.toString());
        throw obj3;
    }

    public MacSigner(SignatureAlgorithm signatureAlgorithm, byte[] b2Arr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(b2Arr2, signatureAlgorithm.getJcaName());
        super(signatureAlgorithm, secretKeySpec);
    }

    @Override // io.jsonwebtoken.impl.crypto.MacProvider
    protected Mac doGetMacInstance() {
        Mac instance = Mac.getInstance(this.alg.getJcaName());
        instance.init(this.key);
        return instance;
    }

    @Override // io.jsonwebtoken.impl.crypto.MacProvider
    protected Mac getMacInstance() {
        try {
            return doGetMacInstance();
            StringBuilder string = new StringBuilder();
            String signatureException = "The specified signing key is not a valid ";
            string.append(signatureException);
            signatureException = this.alg;
            signatureException = signatureException.name();
            string.append(signatureException);
            signatureException = " key: ";
            string.append(signatureException);
            signatureException = th.getMessage();
            string.append(signatureException);
            string = string.toString();
            signatureException = new SignatureException(string, th);
            throw signatureException;
            string = new StringBuilder();
            signatureException = "Unable to obtain JCA MAC algorithm '";
            string.append(signatureException);
            signatureException = this.alg;
            signatureException = signatureException.getJcaName();
            string.append(signatureException);
            signatureException = "': ";
            string.append(signatureException);
            signatureException = th.getMessage();
            string.append(signatureException);
            string = string.toString();
            signatureException = new SignatureException(string, th);
            throw signatureException;
        }
    }

    @Override // io.jsonwebtoken.impl.crypto.MacProvider
    public byte[] sign(byte[] bArr) {
        return getMacInstance().doFinal(bArr);
    }
}
