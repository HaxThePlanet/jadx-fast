package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Signature;
import java.security.SignatureException;

/* loaded from: classes3.dex */
public class RsaSigner extends io.jsonwebtoken.impl.crypto.RsaProvider implements io.jsonwebtoken.impl.crypto.Signer {
    public RsaSigner(SignatureAlgorithm signatureAlgorithm, Key key2) {
        boolean obj2;
        super(signatureAlgorithm, key2);
        if (!key2 instanceof PrivateKey) {
        } else {
            if (!key2 instanceof RSAKey) {
            } else {
            }
        }
        obj2 = new StringBuilder();
        obj2.append("RSA signatures must be computed using an RSA PrivateKey.  The specified key of type ");
        obj2.append(key2.getClass().getName());
        obj2.append(" is not an RSA PrivateKey.");
        IllegalArgumentException obj3 = new IllegalArgumentException(obj2.toString());
        throw obj3;
    }

    @Override // io.jsonwebtoken.impl.crypto.RsaProvider
    protected byte[] doSign(byte[] bArr) {
        final Signature signatureInstance = createSignatureInstance();
        signatureInstance.initSign((PrivateKey)this.key);
        signatureInstance.update(bArr);
        return signatureInstance.sign();
    }

    @Override // io.jsonwebtoken.impl.crypto.RsaProvider
    public byte[] sign(byte[] bArr) {
        try {
            return doSign(bArr);
            StringBuilder string = new StringBuilder();
            String message = "Unable to calculate signature using RSA PrivateKey. ";
            string.append(message);
            message = bArr.getMessage();
            string.append(message);
            string = string.toString();
            SignatureException signatureException = new SignatureException(string, bArr);
            throw signatureException;
            string = new StringBuilder();
            message = "Invalid RSA PrivateKey. ";
            string.append(message);
            message = bArr.getMessage();
            string.append(message);
            string = string.toString();
            signatureException = new SignatureException(string, bArr);
            throw signatureException;
        }
    }
}
