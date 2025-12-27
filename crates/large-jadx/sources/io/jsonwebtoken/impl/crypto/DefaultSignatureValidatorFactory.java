package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;

/* compiled from: DefaultSignatureValidatorFactory.java */
/* loaded from: classes3.dex */
public class DefaultSignatureValidatorFactory implements SignatureValidatorFactory {

    public static final SignatureValidatorFactory INSTANCE = new DefaultSignatureValidatorFactory();

    static class AnonymousClass1 {

        static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;
        static {
            int[] iArr = new int[SignatureAlgorithm.values().length];
            DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm = iArr;
            try {
                iArr[SignatureAlgorithm.HS256.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.HS384.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.HS512.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.RS256.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.RS384.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.RS512.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS256.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS384.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS512.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES256.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES384.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES512.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public SignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key, "Signing Key cannot be null.");
        switch (DefaultSignatureValidatorFactory.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()]) {
            case 1: /* ordinal */
                return new MacValidator(signatureAlgorithm, key);
            case 2: /* ordinal */
                return new RsaSignatureValidator(signatureAlgorithm, key);
            case 3: /* ordinal */
                return new EllipticCurveSignatureValidator(signatureAlgorithm, key);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "The '";
                String name = signatureAlgorithm.name();
                String str4 = "' algorithm cannot be used for signing.";
                signatureAlgorithm = str3 + name + "' algorithm cannot be used for signing.";
                throw new IllegalArgumentException(str3 + name + str4);
        }
    }
}
