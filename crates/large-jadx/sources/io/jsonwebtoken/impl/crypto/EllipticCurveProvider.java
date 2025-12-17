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

/* loaded from: classes3.dex */
public abstract class EllipticCurveProvider extends io.jsonwebtoken.impl.crypto.SignatureProvider {

    private static final Map<SignatureAlgorithm, String> EC_CURVE_NAMES;
    static {
        EllipticCurveProvider.EC_CURVE_NAMES = EllipticCurveProvider.createEcCurveNames();
    }

    protected EllipticCurveProvider(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super(signatureAlgorithm, key2);
        Assert.isTrue(signatureAlgorithm.isEllipticCurve(), "SignatureAlgorithm must be an Elliptic Curve algorithm.");
    }

    private static Map<SignatureAlgorithm, String> createEcCurveNames() {
        HashMap hashMap = new HashMap();
        hashMap.put(SignatureAlgorithm.ES256, "secp256r1");
        hashMap.put(SignatureAlgorithm.ES384, "secp384r1");
        hashMap.put(SignatureAlgorithm.ES512, "secp521r1");
        return hashMap;
    }

    public static KeyPair generateKeyPair() {
        return EllipticCurveProvider.generateKeyPair(SignatureAlgorithm.ES512);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm) {
        return EllipticCurveProvider.generateKeyPair(signatureAlgorithm, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom2) {
        return EllipticCurveProvider.generateKeyPair("EC", 0, signatureAlgorithm, secureRandom2);
    }

    public static KeyPair generateKeyPair(String string, String string2, SignatureAlgorithm signatureAlgorithm3, SecureRandom secureRandom4) {
        KeyPairGenerator obj2;
        Assert.notNull(signatureAlgorithm3, "SignatureAlgorithm argument cannot be null.");
        Assert.isTrue(signatureAlgorithm3.isEllipticCurve(), "SignatureAlgorithm argument must represent an Elliptic Curve algorithm.");
        if (Strings.hasText(string2)) {
            obj2 = KeyPairGenerator.getInstance(string, string2);
        } else {
            obj2 = KeyPairGenerator.getInstance(string);
        }
        ECGenParameterSpec obj4 = new ECGenParameterSpec((String)EllipticCurveProvider.EC_CURVE_NAMES.get(signatureAlgorithm3));
        obj2.initialize(obj4, secureRandom4);
        return obj2.generateKeyPair();
    }

    public static int getSignatureByteArrayLength(SignatureAlgorithm signatureAlgorithm) {
        int i = EllipticCurveProvider.1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    return 132;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported Algorithm: ");
                stringBuilder.append(signatureAlgorithm.name());
                JwtException jwtException = new JwtException(stringBuilder.toString());
                throw jwtException;
            }
            return 96;
        }
        return 64;
    }

    public static byte[] transcodeSignatureToConcat(byte[] bArr, int i2) {
        int i;
        int length;
        byte b;
        byte b2;
        int i3;
        byte b6;
        byte b3;
        byte b4;
        byte b5;
        int i4;
        String str = "Invalid ECDSA signature format";
        if (bArr.length < 8) {
        } else {
            if (bArr[0] != 48) {
            } else {
                int i6 = 1;
                final int i13 = 2;
                if (bArr[i6] > 0) {
                    i = i13;
                    b2 = bArr[i + 1];
                    b6 = b2;
                    while (b6 > 0) {
                        if (bArr[i20 -= b6] == 0) {
                        }
                        b6--;
                    }
                    i14 += b2;
                    byte b8 = bArr[i15 + 1];
                    b4 = b8;
                    while (b4 > 0) {
                        if (bArr[i25 -= b4] == 0) {
                        }
                        b4--;
                    }
                    int obj12 = Math.max(Math.max(b6, b4), i2 /= i13);
                    i4 = i + -1;
                    if (b10 &= 255 != length2 -= i) {
                    } else {
                        if (b9 &= 255 != i11 += b8) {
                        } else {
                            if (bArr[i] != i13) {
                            } else {
                                if (bArr[i15] != i13) {
                                } else {
                                    int i7 = obj12 * 2;
                                    byte[] bArr2 = new byte[i7];
                                    System.arraycopy(bArr, i15 - b6, bArr2, obj12 -= b6, b6);
                                    System.arraycopy(bArr, i17 -= b4, bArr2, i7 -= b4, b4);
                                    return bArr2;
                                }
                            }
                        }
                    }
                    JwtException obj11 = new JwtException(str);
                    throw obj11;
                } else {
                    if (bArr[i6] != -127) {
                    } else {
                        i = 3;
                    }
                }
                obj11 = new JwtException(str);
                throw obj11;
            }
        }
        obj11 = new JwtException(str);
        throw obj11;
    }

    public static byte[] transcodeSignatureToDER(byte[] bArr) {
        int i;
        byte b2;
        int i4;
        int i6;
        byte b;
        int i3;
        byte[] bArr2;
        int i5;
        int i2;
        int i10 = 2;
        length /= i10;
        i = i7;
        while (i > 0) {
            if (bArr[i7 - i] == 0) {
            }
            i--;
        }
        int i15 = i7 - i;
        i4 = bArr[i15] < 0 ? i + 1 : i;
        i6 = i7;
        while (i6 > 0) {
            if (bArr[i18 -= i6] == 0) {
            }
            i6--;
        }
        i8 -= i6;
        i3 = bArr[i9] < 0 ? i6 + 1 : i6;
        i21 += i3;
        if (i22 > 255) {
        } else {
            if (i22 < 128) {
                bArr2 = new byte[i30 += i3];
            } else {
                new byte[i27 += i3][1] = -127;
                i5 = i10;
            }
            bArr2[0] = 48;
            int i35 = i5 + 1;
            bArr2[i5] = (byte)i22;
            int i23 = i35 + 1;
            bArr2[i35] = i10;
            bArr2[i23] = (byte)i4;
            i32 += i4;
            System.arraycopy(bArr, i15, bArr2, i33 - i, i);
            int i14 = i33 + 1;
            bArr2[i33] = i10;
            bArr2[i14] = (byte)i3;
            System.arraycopy(bArr, i9, bArr2, i12 -= i6, i6);
            return bArr2;
        }
        JwtException obj12 = new JwtException("Invalid ECDSA signature format");
        throw obj12;
    }
}
