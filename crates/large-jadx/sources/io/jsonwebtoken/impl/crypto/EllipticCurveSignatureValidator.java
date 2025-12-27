package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.PublicKey;
import java.security.Signature;

/* compiled from: EllipticCurveSignatureValidator.java */
/* loaded from: classes3.dex */
public class EllipticCurveSignatureValidator extends EllipticCurveProvider implements SignatureValidator {

    private static final String EC_PUBLIC_KEY_REQD_MSG = "Elliptic Curve signature validation requires an ECPublicKey instance.";
    public EllipticCurveSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(key instanceof ECPublicKey, "Elliptic Curve signature validation requires an ECPublicKey instance.");
    }

    @Override // io.jsonwebtoken.impl.crypto.EllipticCurveProvider
    protected boolean doVerify(Signature signature, PublicKey publicKey, byte[] bArr, byte[] bArr2) throws java.security.SignatureException, java.security.InvalidKeyException {
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    @Override // io.jsonwebtoken.impl.crypto.EllipticCurveProvider
    public boolean isValid(byte[] bArr, byte[] bArr2) throws SignatureException {
        int signatureByteArrayLength;
        int length = 48;
        byte[] transcodeSignatureToDER;
        try {
            length = bArr2.length;
            if (EllipticCurveProvider.getSignatureByteArrayLength(this.alg) != bArr2.length) {
                if (bArr2[0] != (byte) 48) {
                    transcodeSignatureToDER = EllipticCurveProvider.transcodeSignatureToDER(bArr2);
                }
            }
        } catch (Exception e) {
            bArr2 = new StringBuilder();
            String signatureException = "Unable to verify Elliptic Curve signature using configured ECPublicKey. ";
            bArr2.append(signatureException);
            signatureException = e.getMessage();
            bArr2.append(signatureException);
            bArr2 = bArr2.toString();
            signatureException = new SignatureException(bArr2, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) signatureException;
        }
        return doVerify(createSignatureInstance(), (PublicKey)this.key, bArr, transcodeSignatureToDER);
    }
}
