package com.google.android.gms.internal.firebase-auth-api;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class jc {

    private final ECPrivateKey a;
    public jc(ECPrivateKey eCPrivateKey) {
        super();
        this.a = eCPrivateKey;
    }

    public final byte[] a(byte[] bArr, String string2, byte[] b3Arr3, byte[] b4Arr4, int i5, int i6) {
        byte[] doFinal;
        int i4;
        byte[] secretKeySpec2;
        Object curve;
        SecretKeySpec secretKeySpec;
        SecretKeySpec secretKeySpec3;
        int length;
        int i2;
        ECPoint eCPoint;
        int compareTo;
        BigInteger compareTo2;
        int bigInteger;
        ECParameterSpec cofactor;
        boolean cofactor2;
        int i;
        int i3;
        BigInteger bigInteger2;
        Object generator;
        final Object obj = this;
        byte[] bArr2 = bArr;
        String str = string2;
        secretKeySpec2 = b3Arr3;
        int i8 = i5;
        ECParameterSpec params = obj.a.getParams();
        curve = params.getCurve();
        int i10 = kc.a(curve);
        compareTo = -1;
        int i15 = i6 + -1;
        String str11 = "invalid point size";
        final int i16 = 2;
        int i17 = 0;
        i = 1;
        if (i15 != 0 && i15 != i16) {
            if (i15 != i16) {
                int length2 = bArr2.length;
                if (length2 != i10 += i) {
                } else {
                    byte b2 = bArr2[i17];
                    if (b2 == i16) {
                        i2 = i17;
                        bigInteger2 = new BigInteger(i, Arrays.copyOfRange(bArr2, i, length2));
                        if (bigInteger2.signum() == compareTo) {
                        } else {
                            if (bigInteger2.compareTo(kc.b(curve)) >= 0) {
                            } else {
                                eCPoint = new ECPoint(bigInteger2, kc.c(bigInteger2, i2, curve));
                                ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPoint, params);
                                com.google.android.gms.internal.firebase-auth-api.mc mcVar = mc.i;
                                String str9 = "EC";
                                java.security.PublicKey public2 = (KeyFactory)mcVar.a(str9).generatePublic(eCPublicKeySpec);
                                ECPrivateKey eCPrivateKey2 = obj.a;
                                cofactor = (ECPublicKey)public2.getParams();
                                ECParameterSpec params5 = eCPrivateKey2.getParams();
                                if (!cofactor.getCurve().equals(params5.getCurve())) {
                                } else {
                                    if (!cofactor.getGenerator().equals(params5.getGenerator())) {
                                    } else {
                                        if (!cofactor.getOrder().equals(params5.getOrder())) {
                                        } else {
                                            if (cofactor.getCofactor() != params5.getCofactor()) {
                                            } else {
                                                ECPoint eCPoint2 = public2.getW();
                                                kc.d(eCPoint2, eCPrivateKey2.getParams().getCurve());
                                                ECPublicKeySpec eCPublicKeySpec2 = new ECPublicKeySpec(eCPoint2, eCPrivateKey2.getParams());
                                                Object obj4 = mc.g.a("ECDH");
                                                (KeyAgreement)obj4.init(eCPrivateKey2);
                                                obj4.doPhase((KeyFactory)mcVar.a(str9).generatePublic(eCPublicKeySpec2), i);
                                                byte[] secret = obj4.generateSecret();
                                                EllipticCurve curve2 = eCPrivateKey2.getParams().getCurve();
                                                BigInteger bigInteger3 = new BigInteger(i, secret);
                                                if (bigInteger3.signum() == compareTo) {
                                                } else {
                                                    if (bigInteger3.compareTo(kc.b(curve2)) >= 0) {
                                                    } else {
                                                        kc.c(bigInteger3, i, curve2);
                                                        byte[][] bArr5 = new byte[i16];
                                                        bArr5[0] = bArr2;
                                                        bArr5[i] = secret;
                                                        Object obj3 = mc.f.a(str);
                                                        if (i8 > macLength *= 255) {
                                                        } else {
                                                            if (secretKeySpec2 != null) {
                                                                if (secretKeySpec2.length == 0) {
                                                                    secretKeySpec2 = new SecretKeySpec(new byte[obj3.getMacLength()], str);
                                                                    obj3.init(secretKeySpec2);
                                                                } else {
                                                                    secretKeySpec = new SecretKeySpec(secretKeySpec2, str);
                                                                    obj3.init(secretKeySpec);
                                                                }
                                                            } else {
                                                            }
                                                            byte[] bArr4 = new byte[i8];
                                                            secretKeySpec3 = new SecretKeySpec(obj3.doFinal(bc.c(bArr5)), str);
                                                            obj3.init(secretKeySpec3);
                                                            int i14 = 0;
                                                            doFinal = new byte[i14];
                                                            i4 = i14;
                                                            obj3.update(doFinal);
                                                            obj3.update(0);
                                                            obj3.update((byte)i);
                                                            doFinal = obj3.doFinal();
                                                            secretKeySpec3 = doFinal.length;
                                                            compareTo = i4 + secretKeySpec3;
                                                            while (compareTo < i8) {
                                                                System.arraycopy(doFinal, i14, bArr4, i4, secretKeySpec3);
                                                                i++;
                                                                i4 = compareTo;
                                                                obj3.update(doFinal);
                                                                obj3.update(0);
                                                                obj3.update((byte)i);
                                                                doFinal = obj3.doFinal();
                                                                secretKeySpec3 = doFinal.length;
                                                                compareTo = i4 + secretKeySpec3;
                                                            }
                                                            System.arraycopy(doFinal, i14, bArr4, i4, i8 -= i4);
                                                            return bArr4;
                                                        }
                                                        GeneralSecurityException generalSecurityException7 = new GeneralSecurityException("size too large");
                                                        throw generalSecurityException7;
                                                    }
                                                }
                                                GeneralSecurityException generalSecurityException8 = new GeneralSecurityException("shared secret is out of range");
                                                throw generalSecurityException8;
                                            }
                                        }
                                    }
                                }
                                GeneralSecurityException generalSecurityException9 = new GeneralSecurityException("invalid public key spec");
                                throw generalSecurityException9;
                            }
                        }
                        GeneralSecurityException generalSecurityException2 = new GeneralSecurityException("x is out of range");
                        throw generalSecurityException2;
                    } else {
                        if (b2 != 3) {
                        } else {
                            i2 = i;
                        }
                    }
                    GeneralSecurityException generalSecurityException = new GeneralSecurityException("invalid format");
                    throw generalSecurityException;
                }
                GeneralSecurityException generalSecurityException3 = new GeneralSecurityException("compressed point has wrong length");
                throw generalSecurityException3;
            }
            compareTo2 = bArr2.length;
            if (compareTo2 != i10 + i10) {
            } else {
                bigInteger = new BigInteger(i, Arrays.copyOfRange(bArr2, i17, i10));
                bigInteger2 = new BigInteger(i, Arrays.copyOfRange(bArr2, i10, compareTo2));
                eCPoint = new ECPoint(bigInteger, bigInteger2);
                kc.d(eCPoint, curve);
            }
            GeneralSecurityException generalSecurityException4 = new GeneralSecurityException(str11);
            throw generalSecurityException4;
        }
        compareTo2 = bArr2.length;
        if (compareTo2 != i19 += i) {
        } else {
            if (bArr2[i17] != 4) {
            } else {
                i10 += i;
                bigInteger = new BigInteger(i, Arrays.copyOfRange(bArr2, i, i12));
                bigInteger2 = new BigInteger(i, Arrays.copyOfRange(bArr2, i12, compareTo2));
                eCPoint = new ECPoint(bigInteger, bigInteger2);
                kc.d(eCPoint, curve);
            }
            GeneralSecurityException generalSecurityException6 = new GeneralSecurityException("invalid point format");
            throw generalSecurityException6;
        }
        GeneralSecurityException generalSecurityException5 = new GeneralSecurityException(str11);
        throw generalSecurityException5;
    }
}
