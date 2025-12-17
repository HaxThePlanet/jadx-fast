package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;

/* loaded from: classes3.dex */
public interface SignerFactory {
    public abstract io.jsonwebtoken.impl.crypto.Signer createSigner(SignatureAlgorithm signatureAlgorithm, Key key2);
}
