package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;

/* loaded from: classes3.dex */
public class RsaSignatureValidator extends io.jsonwebtoken.impl.crypto.RsaProvider implements io.jsonwebtoken.impl.crypto.SignatureValidator {

    private final io.jsonwebtoken.impl.crypto.RsaSigner SIGNER = null;
    public RsaSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key2) {
        int i;
        boolean z;
        super(signatureAlgorithm, key2);
        boolean z2 = key2 instanceof RSAPrivateKey;
        if (!z2) {
            if (key2 instanceof RSAPublicKey) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        Assert.isTrue(i, "RSA Signature validation requires either a RSAPublicKey or RSAPrivateKey instance.");
        if (z2) {
            RsaSigner rsaSigner = new RsaSigner(signatureAlgorithm, key2);
        }
        int i2 = 0;
    }

    @Override // io.jsonwebtoken.impl.crypto.RsaProvider
    protected boolean doVerify(Signature signature, PublicKey publicKey2, byte[] b3Arr3, byte[] b4Arr4) {
        signature.initVerify(publicKey2);
        signature.update(b3Arr3);
        return signature.verify(b4Arr4);
    }

    @Override // io.jsonwebtoken.impl.crypto.RsaProvider
    public boolean isValid(byte[] bArr, byte[] b2Arr2) {
        if (key instanceof PublicKey) {
            return doVerify(createSignatureInstance(), (PublicKey)this.key, bArr, b2Arr2);
        }
        Assert.notNull(this.SIGNER, "RSA Signer instance cannot be null.  This is a bug.  Please report it.");
        return MessageDigest.isEqual(this.SIGNER.sign(bArr), b2Arr2);
    }
}
