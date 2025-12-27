package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Signature;

/* compiled from: EllipticCurveSigner.java */
/* loaded from: classes3.dex */
public class EllipticCurveSigner extends EllipticCurveProvider implements Signer {
    public EllipticCurveSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        z = key instanceof PrivateKey;
        if (!(key instanceof PrivateKey)) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Elliptic Curve signatures must be computed using an EC PrivateKey.  The specified key of type ";
            String name = key.getClass().getName();
            String str2 = " is not an EC PrivateKey.";
            signatureAlgorithm = str + name + str2;
            throw new IllegalArgumentException(signatureAlgorithm);
        } else {
            z = key instanceof ECKey;
            if (key instanceof ECKey) {
                return;
            }
        }
    }

    @Override // io.jsonwebtoken.impl.crypto.EllipticCurveProvider
    protected byte[] doSign(byte[] bArr) throws InvalidKeyException, java.security.SignatureException {
        final Signature signatureInstance = createSignatureInstance();
        signatureInstance.initSign((PrivateKey)this.key);
        signatureInstance.update(bArr);
        return EllipticCurveProvider.transcodeSignatureToConcat(signatureInstance.sign(), EllipticCurveProvider.getSignatureByteArrayLength(this.alg));
    }

    @Override // io.jsonwebtoken.impl.crypto.EllipticCurveProvider
    public byte[] sign(byte[] bArr) throws io.jsonwebtoken.security.SignatureException {
        try {
        } catch (io.jsonwebtoken.JwtException e) {
            StringBuilder str = new StringBuilder();
            String message = "Unable to convert signature to JOSE format. ";
            str.append(message);
            message = e.getMessage();
            str.append(message);
            str = str.toString();
            io.jsonwebtoken.security.SignatureException signatureException = new SignatureException(str, e);
            throw signatureException;
        } catch (java.security.SignatureException signature1) {
            str = new StringBuilder();
            message = "Unable to calculate signature using Elliptic Curve PrivateKey. ";
            str.append(message);
            message = signature1.getMessage();
            str.append(message);
            str = str.toString();
            signatureException = new SignatureException(str, signature1);
            throw signatureException;
        } catch (java.security.InvalidKeyException invalidKey2) {
            str = new StringBuilder();
            message = "Invalid Elliptic Curve PrivateKey. ";
            str.append(message);
            message = invalidKey2.getMessage();
            str.append(message);
            str = str.toString();
            signatureException = new SignatureException(str, invalidKey2);
            throw signatureException;
        }
        return doSign(bArr);
    }
}
