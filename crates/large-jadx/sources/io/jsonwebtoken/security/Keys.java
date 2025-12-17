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

/* loaded from: classes3.dex */
public final class Keys {

    private static final String EC = "io.jsonwebtoken.impl.crypto.EllipticCurveProvider";
    private static final String MAC = "io.jsonwebtoken.impl.crypto.MacProvider";
    private static final List<SignatureAlgorithm> PREFERRED_HMAC_ALGS = null;
    private static final String RSA = "io.jsonwebtoken.impl.crypto.RsaProvider";
    private static final Class[] SIG_ARG_TYPES;
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

    public static SecretKey hmacShaKeyFor(byte[] bArr) {
        Object next;
        int minKeyLength;
        if (bArr == null) {
        } else {
            length *= 8;
            Iterator iterator = Keys.PREFERRED_HMAC_ALGS.iterator();
            for (SignatureAlgorithm next : iterator) {
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("The specified key byte array is ");
            obj4.append(i);
            obj4.append(" bits which ");
            obj4.append("is not secure enough for any JWT HMAC-SHA algorithm.  The JWT ");
            obj4.append("JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a ");
            obj4.append("size >= 256 bits (the key size must be greater than or equal to the hash ");
            obj4.append("output size).  Consider using the ");
            obj4.append(Keys.class.getName());
            obj4.append("#secretKeyFor(SignatureAlgorithm) method ");
            obj4.append("to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See ");
            obj4.append("https://tools.ietf.org/html/rfc7518#section-3.2 for more information.");
            WeakKeyException weakKeyException = new WeakKeyException(obj4.toString());
            throw weakKeyException;
        }
        obj4 = new InvalidKeyException("SecretKey byte array cannot be null.");
        throw obj4;
    }

    public static KeyPair keyPairFor(SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        int i2 = 0;
        int i3 = 1;
        final String str3 = "generateKeyPair";
        switch (i) {
            case 4:
                Object[] arr2 = new Object[i3];
                arr2[i2] = signatureAlgorithm;
                return (KeyPair)Classes.invokeStatic("io.jsonwebtoken.impl.crypto.RsaProvider", str3, Keys.SIG_ARG_TYPES, arr2);
            case 5:
                Object[] arr3 = new Object[i3];
                arr3[i2] = signatureAlgorithm;
                return (KeyPair)Classes.invokeStatic("io.jsonwebtoken.impl.crypto.EllipticCurveProvider", str3, Keys.SIG_ARG_TYPES, arr3);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The ");
                stringBuilder.append(signatureAlgorithm.name());
                stringBuilder.append(" algorithm does not support Key Pairs.");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
        }
    }

    public static SecretKey secretKeyFor(SignatureAlgorithm signatureAlgorithm) {
        int i;
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        int i2 = Keys.1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        int i3 = 1;
        if (i2 != i3 && i2 != 2) {
            if (i2 != 2) {
                if (i2 != 3) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The ");
                stringBuilder.append(signatureAlgorithm.name());
                stringBuilder.append(" algorithm does not support shared secret keys.");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
        }
        Object[] arr = new Object[i3];
        arr[0] = signatureAlgorithm;
        return (SecretKey)Classes.invokeStatic("io.jsonwebtoken.impl.crypto.MacProvider", "generateKey", Keys.SIG_ARG_TYPES, arr);
    }
}
