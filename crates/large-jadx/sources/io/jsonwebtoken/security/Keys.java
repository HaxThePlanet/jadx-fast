package io.jsonwebtoken.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Keys.java */
/* loaded from: classes3.dex */
public final class Keys {

    private static final String EC = "io.jsonwebtoken.impl.crypto.EllipticCurveProvider";
    private static final String MAC = "io.jsonwebtoken.impl.crypto.MacProvider";
    private static final List<SignatureAlgorithm> PREFERRED_HMAC_ALGS;
    private static final String RSA = "io.jsonwebtoken.impl.crypto.RsaProvider";
    private static final Class[] SIG_ARG_TYPES;

    static class AnonymousClass1 {

        static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;
        static {
            int[] iArr = new int[SignatureAlgorithm.values().length];
            Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm = iArr;
            try {
                iArr[SignatureAlgorithm.HS256.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.HS384.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.HS512.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.RS256.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS256.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.RS384.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS384.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.RS512.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS512.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES256.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES384.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES512.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        int i = 1;
        Class[] arr = new Class[i];
        final int i4 = 0;
        arr[i4] = SignatureAlgorithm.class;
        Keys.SIG_ARG_TYPES = arr;
        SignatureAlgorithm[] arr2 = new SignatureAlgorithm[3];
        arr2[i4] = SignatureAlgorithm.HS512;
        arr2[i] = SignatureAlgorithm.HS384;
        arr2[2] = SignatureAlgorithm.HS256;
        Keys.PREFERRED_HMAC_ALGS = Collections.unmodifiableList(Arrays.asList(arr2));
    }

    private Keys() {
        super();
    }

    public static SecretKey hmacShaKeyFor(byte[] bArr) throws WeakKeyException, InvalidKeyException {
        if (bArr == null) {
            throw new InvalidKeyException("SecretKey byte array cannot be null.");
        } else {
            int i = bArr.length * 8;
            Iterator it = Keys.PREFERRED_HMAC_ALGS.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                if (i >= item.getMinKeyLength()) {
                    return new SecretKeySpec(bArr, item.getJcaName());
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str10 = "The specified key byte array is ";
            String str = " bits which ";
            String str2 = "is not secure enough for any JWT HMAC-SHA algorithm.  The JWT ";
            String str3 = "JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a ";
            String str4 = "size >= 256 bits (the key size must be greater than or equal to the hash ";
            String str5 = "output size).  Consider using the ";
            String name = Keys.class.getName();
            String str6 = "#secretKeyFor(SignatureAlgorithm) method ";
            String str7 = "to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See ";
            String str8 = "https://tools.ietf.org/html/rfc7518#section-3.2 for more information.";
            bArr = str10 + i + str + str2 + str3 + str4 + str5 + name + str6 + str7 + str8;
            throw new WeakKeyException(bArr);
        }
    }

    public static KeyPair keyPairFor(SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        int i2 = 0;
        int i3 = 1;
        final String str3 = "generateKeyPair";
        switch (Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()]) {
            case 4: /* ordinal */
                Object[] arr2 = new Object[i3];
                arr2[i2] = signatureAlgorithm;
                return (KeyPair)Classes.invokeStatic("io.jsonwebtoken.impl.crypto.RsaProvider", str3, Keys.SIG_ARG_TYPES, arr2);
            case 5: /* ordinal */
                Object[] arr3 = new Object[i3];
                arr3[i2] = signatureAlgorithm;
                return (KeyPair)Classes.invokeStatic("io.jsonwebtoken.impl.crypto.EllipticCurveProvider", str3, Keys.SIG_ARG_TYPES, arr3);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "The ";
                String name = signatureAlgorithm.name();
                String str5 = " algorithm does not support Key Pairs.";
                signatureAlgorithm = str2 + name + " algorithm does not support Key Pairs.";
                throw new IllegalArgumentException(str2 + name + str5);
        }
    }

    public static SecretKey secretKeyFor(SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        int i2 = Keys.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        int i3 = 1;
        Object[] arr = new Object[i3];
        return (SecretKey)Classes.invokeStatic("io.jsonwebtoken.impl.crypto.MacProvider", "generateKey", Keys.SIG_ARG_TYPES, signatureAlgorithm);
    }
}
