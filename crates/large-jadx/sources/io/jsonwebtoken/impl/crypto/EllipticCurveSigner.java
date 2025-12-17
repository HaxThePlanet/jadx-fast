package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Signature;
import java.security.SignatureException;

/* loaded from: classes3.dex */
public class EllipticCurveSigner extends io.jsonwebtoken.impl.crypto.EllipticCurveProvider implements io.jsonwebtoken.impl.crypto.Signer {
    public EllipticCurveSigner(SignatureAlgorithm signatureAlgorithm, Key key2) {
        boolean obj2;
        super(signatureAlgorithm, key2);
        if (!key2 instanceof PrivateKey) {
        } else {
            if (!key2 instanceof ECKey) {
            } else {
            }
        }
        obj2 = new StringBuilder();
        obj2.append("Elliptic Curve signatures must be computed using an EC PrivateKey.  The specified key of type ");
        obj2.append(key2.getClass().getName());
        obj2.append(" is not an EC PrivateKey.");
        IllegalArgumentException obj3 = new IllegalArgumentException(obj2.toString());
        throw obj3;
    }

    @Override // io.jsonwebtoken.impl.crypto.EllipticCurveProvider
    protected byte[] doSign(byte[] bArr) {
        final Signature signatureInstance = createSignatureInstance();
        signatureInstance.initSign((PrivateKey)this.key);
        signatureInstance.update(bArr);
        return EllipticCurveProvider.transcodeSignatureToConcat(signatureInstance.sign(), EllipticCurveProvider.getSignatureByteArrayLength(this.alg));
    }

    @Override // io.jsonwebtoken.impl.crypto.EllipticCurveProvider
    public byte[] sign(byte[] bArr) {
        try {
            return doSign(bArr);
            StringBuilder string = new StringBuilder();
            String message = "Unable to convert signature to JOSE format. ";
            string.append(message);
            message = bArr.getMessage();
            string.append(message);
            string = string.toString();
            SignatureException signatureException = new SignatureException(string, bArr);
            throw signatureException;
            string = new StringBuilder();
            message = "Unable to calculate signature using Elliptic Curve PrivateKey. ";
            string.append(message);
            message = bArr.getMessage();
            string.append(message);
            string = string.toString();
            signatureException = new SignatureException(string, bArr);
            throw signatureException;
            string = new StringBuilder();
            message = "Invalid Elliptic Curve PrivateKey. ";
            string.append(message);
            message = bArr.getMessage();
            string.append(message);
            string = string.toString();
            signatureException = new SignatureException(string, bArr);
            throw signatureException;
        }
    }
}
