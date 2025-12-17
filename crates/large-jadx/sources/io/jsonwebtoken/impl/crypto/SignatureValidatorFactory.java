package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;

/* loaded from: classes3.dex */
public interface SignatureValidatorFactory {
    public abstract io.jsonwebtoken.impl.crypto.SignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key2);
}
