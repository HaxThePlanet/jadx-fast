package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class MacValidator implements io.jsonwebtoken.impl.crypto.SignatureValidator {

    private final io.jsonwebtoken.impl.crypto.MacSigner signer;
    public MacValidator(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super();
        MacSigner macSigner = new MacSigner(signatureAlgorithm, key2);
        this.signer = macSigner;
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureValidator
    public boolean isValid(byte[] bArr, byte[] b2Arr2) {
        return MessageDigest.isEqual(this.signer.sign(bArr), b2Arr2);
    }
}
