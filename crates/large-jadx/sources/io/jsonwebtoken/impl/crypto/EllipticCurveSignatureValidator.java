package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.PublicKey;
import java.security.Signature;

/* loaded from: classes3.dex */
public class EllipticCurveSignatureValidator extends io.jsonwebtoken.impl.crypto.EllipticCurveProvider implements io.jsonwebtoken.impl.crypto.SignatureValidator {

    private static final String EC_PUBLIC_KEY_REQD_MSG = "Elliptic Curve signature validation requires an ECPublicKey instance.";
    public EllipticCurveSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super(signatureAlgorithm, key2);
        Assert.isTrue(key2 instanceof ECPublicKey, "Elliptic Curve signature validation requires an ECPublicKey instance.");
    }

    @Override // io.jsonwebtoken.impl.crypto.EllipticCurveProvider
    protected boolean doVerify(Signature signature, PublicKey publicKey2, byte[] b3Arr3, byte[] b4Arr4) {
        signature.initVerify(publicKey2);
        signature.update(b3Arr3);
        return signature.verify(b4Arr4);
    }

    @Override // io.jsonwebtoken.impl.crypto.EllipticCurveProvider
    public boolean isValid(byte[] bArr, byte[] b2Arr2) {
        int signatureByteArrayLength;
        int length;
        byte[] obj6;
        if (EllipticCurveProvider.getSignatureByteArrayLength(this.alg) != b2Arr2.length && b2Arr2[0] == 48) {
            if (b2Arr2[0] == 48) {
            } else {
                obj6 = EllipticCurveProvider.transcodeSignatureToDER(b2Arr2);
            }
        } else {
        }
        return doVerify(createSignatureInstance(), (PublicKey)this.key, bArr, obj6);
    }
}
