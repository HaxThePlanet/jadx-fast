package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EllipticCurveProvider.java */
/* loaded from: classes3.dex */
public abstract class EllipticCurveProvider extends SignatureProvider {

    private static final Map<SignatureAlgorithm, String> EC_CURVE_NAMES;

    static class AnonymousClass1 {

        static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;
        static {
            int[] iArr = new int[SignatureAlgorithm.values().length];
            EllipticCurveProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm = iArr;
            try {
                iArr[SignatureAlgorithm.ES256.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                EllipticCurveProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES384.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                EllipticCurveProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.ES512.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        EllipticCurveProvider.EC_CURVE_NAMES = EllipticCurveProvider.createEcCurveNames();
    }

    protected EllipticCurveProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isEllipticCurve(), "SignatureAlgorithm must be an Elliptic Curve algorithm.");
    }

    private static Map<SignatureAlgorithm, String> createEcCurveNames() {
        final HashMap hashMap = new HashMap();
        hashMap.put(SignatureAlgorithm.ES256, "secp256r1");
        hashMap.put(SignatureAlgorithm.ES384, "secp384r1");
        hashMap.put(SignatureAlgorithm.ES512, "secp521r1");
        return hashMap;
    }

    public static KeyPair generateKeyPair() {
        return EllipticCurveProvider.generateKeyPair(SignatureAlgorithm.ES512);
    }

    public static int getSignatureByteArrayLength(SignatureAlgorithm signatureAlgorithm) throws JwtException {
        int i = EllipticCurveProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        if (EllipticCurveProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm != 1 && EllipticCurveProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm != 2) {
            if (EllipticCurveProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm != 3) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "Unsupported Algorithm: ";
                String name = signatureAlgorithm.name();
                signatureAlgorithm = str + name;
                throw new JwtException(signatureAlgorithm);
            } else {
                return 132;
            }
        }
        return 64;
    }

    public static byte[] transcodeSignatureToConcat(byte[] bArr, int i) throws JwtException {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        length = bArr.length;
        String str = "Invalid ECDSA signature format";
        int i3 = 8;
        if (bArr.length < 8) {
            throw new JwtException(str);
        } else {
            if (bArr[0] == (byte) 48) {
                int i6 = 1;
                i = 2;
                if (bArr[i6] > 0) {
                    b2 = bArr[i + 1];
                    while (b2 > 0) {
                    }
                    int i15 = (i + 2) + b2;
                    b4 = bArr[i15 + 1];
                    while (b4 > 0) {
                    }
                    int max2 = Math.max(Math.max(b2, b4), i / i);
                    i4 = i - 1;
                    if ((bArr[i4] & 255) != bArr.length - i) {
                        throw new JwtException(str);
                    } else {
                        i4 = bArr[i4] & 255;
                        if ((bArr[i4] & 255) == (b2 + i) + i + b4) {
                            if (bArr[i] == i) {
                                if (bArr[i15] == i) {
                                    int i7 = max2 * 2;
                                    byte[] bArr2 = new byte[i7];
                                    System.arraycopy(bArr, i15 - b2, bArr2, max2 - b2, b2);
                                    System.arraycopy(bArr, (i15 + i) + b4 - b4, bArr2, i7 - b4, b4);
                                    return bArr2;
                                }
                            }
                        }
                    }
                } else {
                    byte b = (byte) -127;
                    if (bArr[i6] == (byte) -127) {
                        i = 3;
                    }
                }
                throw new JwtException(str);
            }
        }
    }

    public static byte[] transcodeSignatureToDER(byte[] bArr) throws JwtException {
        int i;
        byte b;
        byte b2;
        byte[] bArr2;
        int i2 = 1;
        i2 = 2;
        i = bArr.length / i2;
        while (i > 0) {
        }
        int i9 = i - i;
        int r4 = bArr[i9] < 0 ? i + 1 : i;
        while (i > 0) {
        }
        int i4 = (i * i2) - i;
        int r6 = bArr[i4] < 0 ? i + 1 : i;
        int i16 = (i + 2 + i2) + (bArr[i4] < 0 ? i + 1 : i);
        if (i16 > 255) {
            throw new JwtException("Invalid ECDSA signature format");
        } else {
            i2 = 1;
            if (i16 < 128) {
                bArr2 = new byte[(i + 4) + i2 + r6];
            } else {
                byte b3 = (byte) -127;
                new byte[(i + 5) + i2 + r6][1] = b3;
            }
            bArr2[0] = 48;
            int i29 = i2 + 1;
            bArr2[i2] = (byte)i16;
            int i17 = i29 + 1;
            bArr2[i29] = i2;
            bArr2[i17] = (byte)i;
            int i27 = (i17 + 1) + i;
            System.arraycopy(bArr, i9, bArr2, i27 - i, i);
            int i8 = i27 + 1;
            bArr2[i27] = i2;
            bArr2[i8] = (byte)r6;
            System.arraycopy(bArr, i4, bArr2, (i8 + 1) + r6 - i, i);
            return bArr2;
        }
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm) {
        return EllipticCurveProvider.generateKeyPair(signatureAlgorithm, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom) {
        return EllipticCurveProvider.generateKeyPair("EC", null, signatureAlgorithm, secureRandom);
    }

    public static KeyPair generateKeyPair(String str, String str2, SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom) throws java.security.NoSuchAlgorithmException, java.security.InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator;
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm argument cannot be null.");
        Assert.isTrue(signatureAlgorithm.isEllipticCurve(), "SignatureAlgorithm argument must represent an Elliptic Curve algorithm.");
        try {
            if (Strings.hasText(str2)) {
                keyPairGenerator = KeyPairGenerator.getInstance(str, str2);
            } else {
                keyPairGenerator = KeyPairGenerator.getInstance(str);
            }
            keyPairGenerator.initialize(new ECGenParameterSpec((String)EllipticCurveProvider.EC_CURVE_NAMES.get(signatureAlgorithm)), secureRandom);
        } catch (Exception e) {
            signatureAlgorithm = new StringBuilder();
            secureRandom = "Unable to generate Elliptic Curve KeyPair: ";
            signatureAlgorithm.append(secureRandom);
            secureRandom = e.getMessage();
            signatureAlgorithm.append(secureRandom);
            signatureAlgorithm = signatureAlgorithm.toString();
            str2 = new IllegalStateException(signatureAlgorithm, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        }
        return keyPairGenerator.generateKeyPair();
    }
}
