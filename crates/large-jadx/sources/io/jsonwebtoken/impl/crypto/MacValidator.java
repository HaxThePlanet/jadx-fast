package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.security.MessageDigest;

/* compiled from: MacValidator.java */
/* loaded from: classes3.dex */
public class MacValidator implements SignatureValidator {

    private final MacSigner signer = new MacSigner();
    public MacValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        super();
        final io.jsonwebtoken.impl.crypto.MacSigner macSigner = new MacSigner(signatureAlgorithm, key);
    }

    public boolean isValid(byte[] bArr, byte[] bArr2) {
        return MessageDigest.isEqual(this.signer.sign(bArr), bArr2);
    }
}
