package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: MacSigner.java */
/* loaded from: classes3.dex */
public class MacSigner extends MacProvider implements Signer {
    public MacSigner(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        this(signatureAlgorithm, new SecretKeySpec(bArr, signatureAlgorithm.getJcaName()));
    }

    @Override // io.jsonwebtoken.impl.crypto.MacProvider
    protected Mac doGetMacInstance() throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(this.alg.getJcaName());
        mac.init(this.key);
        return mac;
    }

    @Override // io.jsonwebtoken.impl.crypto.MacProvider
    protected Mac getMacInstance() throws SignatureException {
        try {
        } catch (java.security.InvalidKeyException invalidKey) {
            StringBuilder str = new StringBuilder();
            String signatureException = "The specified signing key is not a valid ";
            str.append(signatureException);
            signatureException = this.alg.name();
            str.append(this.alg);
            signatureException = " key: ";
            str.append(this.alg);
            signatureException = invalidKey.getMessage();
            str.append(this.alg);
            str = str.toString();
            signatureException = new SignatureException(str, invalidKey);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) this.alg;
        } catch (java.security.NoSuchAlgorithmException noSuchAlgorithm1) {
            str = new StringBuilder();
            signatureException = "Unable to obtain JCA MAC algorithm '";
            str.append(this.alg);
            signatureException = this.alg.getJcaName();
            str.append(this.alg);
            signatureException = "': ";
            str.append(this.alg);
            signatureException = noSuchAlgorithm1.getMessage();
            str.append(this.alg);
            str = str.toString();
            signatureException = new SignatureException(str, noSuchAlgorithm1);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) this.alg;
        }
        return doGetMacInstance();
    }

    @Override // io.jsonwebtoken.impl.crypto.MacProvider
    public byte[] sign(byte[] bArr) {
        return getMacInstance().doFinal(bArr);
    }

    public MacSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isHmac(), "The MacSigner only supports HMAC signature algorithms.");
        if (!(key instanceof SecretKey)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "MAC signatures must be computed and verified using a SecretKey.  The specified key of type ";
            String name = key.getClass().getName();
            String str3 = " is not a SecretKey.";
            signatureAlgorithm = str2 + name + str3;
            throw new IllegalArgumentException(signatureAlgorithm);
        }
    }
}
