package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;

/* compiled from: RsaSignatureValidator.java */
/* loaded from: classes3.dex */
public class RsaSignatureValidator extends RsaProvider implements SignatureValidator {

    private final RsaSigner SIGNER = null;
    public RsaSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        boolean z3 = false;
        super(signatureAlgorithm, key);
        boolean z2 = key instanceof RSAPrivateKey;
        if (!z2) {
            z = key instanceof RSAPublicKey;
            if (key instanceof RSAPublicKey) {
                int i3 = 1;
            } else {
                int i2 = 0;
            }
        }
        Assert.isTrue(z3, "RSA Signature validation requires either a RSAPublicKey or RSAPrivateKey instance.");
        RsaSigner r0 = z2 ? new RsaSigner(signatureAlgorithm, key) : 0;
    }

    @Override // io.jsonwebtoken.impl.crypto.RsaProvider
    protected boolean doVerify(Signature signature, PublicKey publicKey, byte[] bArr, byte[] bArr2) throws java.security.InvalidKeyException, java.security.SignatureException {
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    @Override // io.jsonwebtoken.impl.crypto.RsaProvider
    public boolean isValid(byte[] bArr, byte[] bArr2) throws SignatureException {
        if (this.key instanceof PublicKey) {
            try {
            } catch (Exception e) {
                bArr2 = new StringBuilder();
                String signatureException = "Unable to verify RSA signature using configured PublicKey. ";
                bArr2.append(signatureException);
                signatureException = e.getMessage();
                bArr2.append(signatureException);
                bArr2 = bArr2.toString();
                signatureException = new SignatureException(bArr2, e);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) signatureException;
            }
            return doVerify(createSignatureInstance(), (PublicKey)this.key, bArr, bArr2);
        }
        Assert.notNull(this.SIGNER, "RSA Signer instance cannot be null.  This is a bug.  Please report it.");
        return MessageDigest.isEqual(this.SIGNER.sign(e), bArr2);
    }
}
