package com.google.android.gms.internal.firebase-auth-api;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;

/* loaded from: classes2.dex */
public final class kc {
    public static int a(EllipticCurve ellipticCurve) {
        return obj1 /= 8;
    }

    public static BigInteger b(EllipticCurve ellipticCurve) {
        java.security.spec.ECField obj1 = ellipticCurve.getField();
        if (!obj1 instanceof ECFieldFp) {
        } else {
            return (ECFieldFp)obj1.getP();
        }
        obj1 = new GeneralSecurityException("Only curves over prime order fields are supported");
        throw obj1;
    }

    public static BigInteger c(BigInteger bigInteger, boolean z2, EllipticCurve ellipticCurve3) {
        int shiftRight;
        int shiftRight2;
        BigInteger num2;
        BigInteger probablePrime;
        BigInteger modPow;
        BigInteger oNE;
        boolean multiply;
        BigInteger num;
        BigInteger obj10;
        int obj12;
        final BigInteger num3 = kc.b(ellipticCurve3);
        shiftRight = 1;
        if (num3.signum() != shiftRight) {
        } else {
            obj10 = bigInteger.multiply(bigInteger).add(ellipticCurve3.getA()).multiply(bigInteger).add(ellipticCurve3.getB()).mod(num3).mod(num3);
            final int i = 0;
            if (obj10.equals(BigInteger.ZERO)) {
            } else {
                if (num3.testBit(i) && num3.testBit(shiftRight)) {
                    if (num3.testBit(shiftRight)) {
                        obj12 = obj10.modPow(num3.add(BigInteger.ONE).shiftRight(2), num3);
                        if (obj12 != null) {
                            if (obj12.multiply(obj12).mod(num3).compareTo(obj10) != 0) {
                            } else {
                            }
                            obj10 = new GeneralSecurityException("Could not find a modular square root");
                            throw obj10;
                        }
                    } else {
                        if (num3.testBit(i) && !num3.testBit(shiftRight)) {
                            if (!num3.testBit(shiftRight)) {
                                num2 = i;
                                probablePrime = obj12.multiply(obj12).subtract(obj10).mod(num3);
                                while (!probablePrime.equals(BigInteger.ZERO)) {
                                    modPow = probablePrime.modPow(num3.subtract(BigInteger.ONE).shiftRight(shiftRight), num3);
                                    oNE = BigInteger.ONE;
                                    modPow = "p is not prime";
                                    obj12 = obj12.add(oNE);
                                    probablePrime = obj12.multiply(obj12).subtract(obj10).mod(num3);
                                }
                            } else {
                                obj12 = shiftRight2;
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
            if (z2 != obj12.testBit(i)) {
                return num3.subtract(obj12).mod(num3);
            }
            return obj12;
        }
        obj10 = new InvalidAlgorithmParameterException("p must be positive");
        throw obj10;
    }

    static void d(ECPoint eCPoint, EllipticCurve ellipticCurve2) {
        int compareTo2;
        int compareTo;
        final BigInteger num = kc.b(ellipticCurve2);
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger obj4 = eCPoint.getAffineY();
        if (affineX == null) {
        } else {
            if (obj4 == null) {
            } else {
                int i = -1;
                if (affineX.signum() == i) {
                } else {
                    if (affineX.compareTo(num) >= 0) {
                    } else {
                        if (obj4.signum() == i) {
                        } else {
                            if (obj4.compareTo(num) >= 0) {
                            } else {
                                if (!obj4.multiply(obj4).mod(num).equals(affineX.multiply(affineX).add(ellipticCurve2.getA()).multiply(affineX).add(ellipticCurve2.getB()).mod(num))) {
                                } else {
                                }
                                obj4 = new GeneralSecurityException("Point is not on curve");
                                throw obj4;
                            }
                        }
                        obj4 = new GeneralSecurityException("y is out of range");
                        throw obj4;
                    }
                }
                obj4 = new GeneralSecurityException("x is out of range");
                throw obj4;
            }
        }
        obj4 = new GeneralSecurityException("point is at infinity");
        throw obj4;
    }

    public static ECPublicKey e(int i, byte[] b2Arr2, byte[] b3Arr3) {
        ECParameterSpec obj2 = kc.f(i);
        final int i2 = 1;
        BigInteger bigInteger = new BigInteger(i2, b2Arr2);
        BigInteger obj3 = new BigInteger(i2, b3Arr3);
        ECPoint obj4 = new ECPoint(bigInteger, obj3);
        kc.d(obj4, obj2.getCurve());
        obj3 = new ECPublicKeySpec(obj4, obj2);
        return (ECPublicKey)(KeyFactory)mc.i.a("EC").generatePublic(obj3);
    }

    public static ECParameterSpec f(int i) {
        i--;
        if (obj4 != null && obj4 != 1) {
            if (obj4 != 1) {
                return kc.g("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
            }
            return kc.g("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
        }
        return kc.g("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }

    private static ECParameterSpec g(String string, String string2, String string3, String string4, String string5) {
        BigInteger bigInteger = new BigInteger(string);
        BigInteger obj3 = new BigInteger(string2);
        BigInteger obj4 = new BigInteger("3");
        final int i = 16;
        BigInteger bigInteger2 = new BigInteger(string3, i);
        BigInteger obj5 = new BigInteger(string4, i);
        BigInteger obj6 = new BigInteger(string5, i);
        ECFieldFp obj7 = new ECFieldFp(bigInteger);
        EllipticCurve ellipticCurve = new EllipticCurve(obj7, bigInteger.subtract(obj4), bigInteger2);
        obj4 = new ECPoint(obj5, obj6);
        obj5 = new ECParameterSpec(ellipticCurve, obj4, obj3, 1);
        return obj5;
    }
}
