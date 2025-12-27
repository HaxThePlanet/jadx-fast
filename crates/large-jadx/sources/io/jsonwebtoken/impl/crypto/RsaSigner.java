package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Signature;

/* compiled from: RsaSigner.java */
/* loaded from: classes3.dex */
public class RsaSigner extends RsaProvider implements Signer {
    public RsaSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        z = key instanceof PrivateKey;
        if (!(key instanceof PrivateKey)) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "RSA signatures must be computed using an RSA PrivateKey.  The specified key of type ";
            String name = key.getClass().getName();
            String str2 = " is not an RSA PrivateKey.";
            signatureAlgorithm = str + name + str2;
            throw new IllegalArgumentException(signatureAlgorithm);
        } else {
            z = key instanceof RSAKey;
            if (key instanceof RSAKey) {
                return;
            }
        }
    }

    @Override // io.jsonwebtoken.impl.crypto.RsaProvider
    protected byte[] doSign(byte[] bArr) throws java.security.SignatureException, InvalidKeyException {
        final Signature signatureInstance = createSignatureInstance();
        signatureInstance.initSign((PrivateKey)this.key);
        signatureInstance.update(bArr);
        return signatureInstance.sign();
    }

    @Override // io.jsonwebtoken.impl.crypto.RsaProvider
    public byte[] sign(byte[] bArr) throws io.jsonwebtoken.security.SignatureException {
        try {
        } catch (java.security.SignatureException signature) {
            StringBuilder str = new StringBuilder();
            String message = "Unable to calculate signature using RSA PrivateKey. ";
            str.append(message);
            message = signature.getMessage();
            str.append(message);
            str = str.toString();
            io.jsonwebtoken.security.SignatureException signatureException = new SignatureException(str, signature);
            throw signatureException;
        } catch (java.security.InvalidKeyException invalidKey1) {
            str = new StringBuilder();
            message = "Invalid RSA PrivateKey. ";
            str.append(message);
            message = invalidKey1.getMessage();
            str.append(message);
            str = str.toString();
            signatureException = new SignatureException(str, invalidKey1);
            throw signatureException;
        }
        return doSign(bArr);
    }
}
