package io.jsonwebtoken;

import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import java.math.BigInteger;
import java.security.Key;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public enum SignatureAlgorithm {

    NONE("none", "No digital signature or MAC performed", "None", false, false, false, false),
    PS256(2, "HS384", "HMAC using SHA-384", "HMAC", "HmacSHA384", true, 384),
    PS384("HS256", "HMAC using SHA-256", "HMAC", "HmacSHA256", true, 256, 256);

    private final String description;
    private final int digestLength;
    private final String familyName;
    private final String jcaName;
    private final boolean jdkStandard;
    private final int minKeyLength;
    @Deprecated
    private final String pkcs12Name;
    private final String value;
    private void assertValid(Key key, boolean z2) {
        int minKeyLength;
        boolean hmac;
        String str;
        io.jsonwebtoken.SignatureAlgorithm equals;
        boolean equalsIgnoreCase2;
        boolean equalsIgnoreCase3;
        boolean equalsIgnoreCase;
        String str3;
        String str2;
        int obj14;
        Class<io.jsonwebtoken.security.Keys> obj = Keys.class;
        if (this == SignatureAlgorithm.NONE) {
        } else {
            final String str4 = " key's size is ";
            String str5 = " algorithm.  The JWT ";
            final String str7 = ".  See ";
            final String str8 = " class's ";
            equals = " ";
            final String str9 = "The ";
            if (isHmac()) {
                if (!key instanceof SecretKey) {
                } else {
                    byte[] encoded = (SecretKey)key.getEncoded();
                    if (encoded == null) {
                    } else {
                        obj14 = key.getAlgorithm();
                        if (obj14 == null) {
                        } else {
                            equals = SignatureAlgorithm.HS256;
                            equalsIgnoreCase2 = SignatureAlgorithm.HS384;
                            equalsIgnoreCase3 = SignatureAlgorithm.HS512;
                            if (!equals.jcaName.equalsIgnoreCase(obj14) && !equalsIgnoreCase2.jcaName.equalsIgnoreCase(obj14) && !equalsIgnoreCase3.jcaName.equalsIgnoreCase(obj14) && !equals.pkcs12Name.equals(obj14) && !equalsIgnoreCase2.pkcs12Name.equals(obj14)) {
                                equalsIgnoreCase2 = SignatureAlgorithm.HS384;
                                if (!equalsIgnoreCase2.jcaName.equalsIgnoreCase(obj14)) {
                                    equalsIgnoreCase3 = SignatureAlgorithm.HS512;
                                    if (!equalsIgnoreCase3.jcaName.equalsIgnoreCase(obj14)) {
                                        if (!equals.pkcs12Name.equals(obj14)) {
                                            if (!equalsIgnoreCase2.pkcs12Name.equals(obj14)) {
                                                if (!equalsIgnoreCase3.pkcs12Name.equals(obj14)) {
                                                } else {
                                                }
                                                StringBuilder stringBuilder3 = new StringBuilder();
                                                stringBuilder3.append(str9);
                                                stringBuilder3.append(SignatureAlgorithm.keyType(z2));
                                                stringBuilder3.append(" key's algorithm '");
                                                stringBuilder3.append(obj14);
                                                stringBuilder3.append("' does not equal a valid HmacSHA* algorithm name and cannot be used with ");
                                                stringBuilder3.append(name());
                                                stringBuilder3.append(".");
                                                InvalidKeyException invalidKeyException = new InvalidKeyException(stringBuilder3.toString());
                                                throw invalidKeyException;
                                            }
                                        }
                                    }
                                }
                            }
                            obj14 *= 8;
                            if (obj14 < this.minKeyLength) {
                            } else {
                            }
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(str9);
                            stringBuilder4.append(SignatureAlgorithm.keyType(z2));
                            stringBuilder4.append(str4);
                            stringBuilder4.append(obj14);
                            stringBuilder4.append(" bits which ");
                            stringBuilder4.append("is not secure enough for the ");
                            stringBuilder4.append(name());
                            stringBuilder4.append(str5);
                            stringBuilder4.append("JWA Specification (RFC 7518, Section 3.2) states that keys used with ");
                            stringBuilder4.append(name());
                            stringBuilder4.append(" MUST have a ");
                            stringBuilder4.append("size >= ");
                            stringBuilder4.append(this.minKeyLength);
                            stringBuilder4.append(" bits (the key size must be greater than or equal to the hash ");
                            stringBuilder4.append("output size).  Consider using the ");
                            stringBuilder4.append(obj.getName());
                            stringBuilder4.append(str8);
                            stringBuilder4.append("'secretKeyFor(SignatureAlgorithm.");
                            stringBuilder4.append(name());
                            stringBuilder4.append(")' method to create a key guaranteed to be ");
                            stringBuilder4.append("secure enough for ");
                            stringBuilder4.append(name());
                            stringBuilder4.append(str7);
                            stringBuilder4.append("https://tools.ietf.org/html/rfc7518#section-3.2 for more information.");
                            WeakKeyException obj15 = new WeakKeyException(stringBuilder4.toString());
                            throw obj15;
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str9);
                        stringBuilder2.append(SignatureAlgorithm.keyType(z2));
                        stringBuilder2.append(" key's algorithm cannot be null.");
                        obj14 = new InvalidKeyException(stringBuilder2.toString());
                        throw obj14;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str9);
                    stringBuilder.append(SignatureAlgorithm.keyType(z2));
                    stringBuilder.append(" key's encoded bytes cannot be null.");
                    obj14 = new InvalidKeyException(stringBuilder.toString());
                    throw obj14;
                }
                obj14 = new StringBuilder();
                obj14.append(this.familyName);
                obj14.append(equals);
                obj14.append(SignatureAlgorithm.keyType(z2));
                obj14.append(" keys must be SecretKey instances.");
                obj15 = new InvalidKeyException(obj14.toString());
                throw obj15;
            }
            if (z2) {
                if (!key instanceof PrivateKey) {
                } else {
                }
                obj14 = new StringBuilder();
                obj14.append(this.familyName);
                obj14.append(" signing keys must be PrivateKey instances.");
                obj15 = new InvalidKeyException(obj14.toString());
                throw obj15;
            }
            equalsIgnoreCase2 = "to be secure enough for ";
            equalsIgnoreCase3 = ")' method to create a key pair guaranteed ";
            equalsIgnoreCase = "'keyPairFor(SignatureAlgorithm.";
            str3 = " bits.  Consider using the ";
            str2 = " MUST have a size >= ";
            if (isEllipticCurve()) {
                if (!key instanceof ECKey) {
                } else {
                    obj14 = (ECKey)key.getParams().getOrder().bitLength();
                    if (obj14 < this.minKeyLength) {
                    } else {
                    }
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(str9);
                    stringBuilder5.append(SignatureAlgorithm.keyType(z2));
                    stringBuilder5.append(" key's size (ECParameterSpec order) is ");
                    stringBuilder5.append(obj14);
                    stringBuilder5.append(" bits which is not secure enough for the ");
                    stringBuilder5.append(name());
                    stringBuilder5.append(str5);
                    stringBuilder5.append("JWA Specification (RFC 7518, Section 3.4) states that keys used with ");
                    stringBuilder5.append(name());
                    stringBuilder5.append(str2);
                    stringBuilder5.append(this.minKeyLength);
                    stringBuilder5.append(str3);
                    stringBuilder5.append(obj.getName());
                    stringBuilder5.append(str8);
                    stringBuilder5.append(equalsIgnoreCase);
                    stringBuilder5.append(name());
                    stringBuilder5.append(equalsIgnoreCase3);
                    stringBuilder5.append(equalsIgnoreCase2);
                    stringBuilder5.append(name());
                    stringBuilder5.append(str7);
                    stringBuilder5.append("https://tools.ietf.org/html/rfc7518#section-3.4 for more information.");
                    obj15 = new WeakKeyException(stringBuilder5.toString());
                    throw obj15;
                }
                obj14 = new StringBuilder();
                obj14.append(this.familyName);
                obj14.append(equals);
                obj14.append(SignatureAlgorithm.keyType(z2));
                obj14.append(" keys must be ECKey instances.");
                obj15 = new InvalidKeyException(obj14.toString());
                throw obj15;
            }
            if (!key instanceof RSAKey) {
            } else {
                obj14 = (RSAKey)key.getModulus().bitLength();
                if (obj14 < this.minKeyLength) {
                    str = name().startsWith("P") ? "3.5" : "3.3";
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(str9);
                    stringBuilder6.append(SignatureAlgorithm.keyType(z2));
                    stringBuilder6.append(str4);
                    stringBuilder6.append(obj14);
                    stringBuilder6.append(" bits which is not secure ");
                    stringBuilder6.append("enough for the ");
                    stringBuilder6.append(name());
                    stringBuilder6.append(" algorithm.  The JWT JWA Specification (RFC 7518, Section ");
                    stringBuilder6.append(str);
                    stringBuilder6.append(") states that keys used with ");
                    stringBuilder6.append(name());
                    stringBuilder6.append(str2);
                    stringBuilder6.append(this.minKeyLength);
                    stringBuilder6.append(str3);
                    stringBuilder6.append(obj.getName());
                    stringBuilder6.append(str8);
                    stringBuilder6.append(equalsIgnoreCase);
                    stringBuilder6.append(name());
                    stringBuilder6.append(equalsIgnoreCase3);
                    stringBuilder6.append(equalsIgnoreCase2);
                    stringBuilder6.append(name());
                    stringBuilder6.append(str7);
                    stringBuilder6.append("https://tools.ietf.org/html/rfc7518#section-");
                    stringBuilder6.append(str);
                    stringBuilder6.append(" for more information.");
                    obj15 = new WeakKeyException(stringBuilder6.toString());
                    throw obj15;
                }
            }
            obj14 = new StringBuilder();
            obj14.append(this.familyName);
            obj14.append(equals);
            obj14.append(SignatureAlgorithm.keyType(z2));
            obj14.append(" keys must be RSAKey instances.");
            obj15 = new InvalidKeyException(obj14.toString());
            throw obj15;
        }
        obj14 = new InvalidKeyException("The 'NONE' signature algorithm does not support cryptographic keys.");
        throw obj14;
    }

    public static io.jsonwebtoken.SignatureAlgorithm forName(String string) {
        int i;
        io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm;
        boolean equalsIgnoreCase;
        io.jsonwebtoken.SignatureAlgorithm[] values = SignatureAlgorithm.values();
        i = 0;
        while (i < values.length) {
            signatureAlgorithm = values[i];
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported signature algorithm '");
        stringBuilder.append(string);
        stringBuilder.append("'");
        SignatureException signatureException = new SignatureException(stringBuilder.toString());
        throw signatureException;
    }

    public static io.jsonwebtoken.SignatureAlgorithm forSigningKey(Key key) {
        boolean z;
        Object next;
        int minKeyLength;
        if (key == null) {
        } else {
            boolean z2 = key instanceof SecretKey;
            if (!z2) {
                if (!key instanceof PrivateKey) {
                } else {
                    if (!key instanceof ECKey) {
                        if (!key instanceof RSAKey) {
                        } else {
                        }
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("JWT standard signing algorithms require either 1) a SecretKey for HMAC-SHA algorithms or 2) a private RSAKey for RSA algorithms or 3) a private ECKey for Elliptic Curve algorithms.  The specified key is of type ");
                stringBuilder2.append(key.getClass().getName());
                InvalidKeyException invalidKeyException = new InvalidKeyException(stringBuilder2.toString());
                throw invalidKeyException;
            }
            String str5 = "information.";
            if (z2) {
                obj4 *= 8;
                Iterator iterator = SignatureAlgorithm.PREFERRED_HMAC_ALGS.iterator();
                for (SignatureAlgorithm next : iterator) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The specified SecretKey is not strong enough to be used with JWT HMAC signature algorithms.  The JWT specification requires HMAC keys to be >= 256 bits long.  The specified key is ");
                stringBuilder.append(obj4);
                stringBuilder.append(" bits.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more ");
                stringBuilder.append(str5);
                WeakKeyException weakKeyException3 = new WeakKeyException(stringBuilder.toString());
                throw weakKeyException3;
            }
            int bitLength = (RSAKey)key.getModulus().bitLength();
            if (key instanceof RSAKey && bitLength >= 4096) {
                bitLength = (RSAKey)key.getModulus().bitLength();
                if (bitLength >= 4096) {
                    io.jsonwebtoken.SignatureAlgorithm rS512 = SignatureAlgorithm.RS512;
                    rS512.assertValidSigningKey(key);
                    return rS512;
                }
                if (bitLength >= 3072) {
                    io.jsonwebtoken.SignatureAlgorithm rS384 = SignatureAlgorithm.RS384;
                    rS384.assertValidSigningKey(key);
                    return rS384;
                }
                io.jsonwebtoken.SignatureAlgorithm rS256 = SignatureAlgorithm.RS256;
                if (bitLength < rS256.minKeyLength) {
                } else {
                    rS256.assertValidSigningKey(key);
                    return rS256;
                }
                StringBuilder obj4 = new StringBuilder();
                obj4.append("The specified RSA signing key is not strong enough to be used with JWT RSA signature algorithms.  The JWT specification requires RSA keys to be >= 2048 bits long.  The specified RSA key is ");
                obj4.append(bitLength);
                obj4.append(" bits.  See https://tools.ietf.org/html/rfc7518#section-3.3 for more ");
                obj4.append(str5);
                WeakKeyException weakKeyException = new WeakKeyException(obj4.toString());
                throw weakKeyException;
            }
            int bitLength2 = (ECKey)key.getParams().getOrder().bitLength();
            Iterator iterator2 = SignatureAlgorithm.PREFERRED_EC_ALGS.iterator();
            for (SignatureAlgorithm next : iterator2) {
            }
            obj4 = new StringBuilder();
            obj4.append("The specified Elliptic Curve signing key is not strong enough to be used with JWT ECDSA signature algorithms.  The JWT specification requires ECDSA keys to be >= 256 bits long.  The specified ECDSA key is ");
            obj4.append(bitLength2);
            obj4.append(" bits.  See ");
            obj4.append("https://tools.ietf.org/html/rfc7518#section-3.4 for more information.");
            WeakKeyException weakKeyException2 = new WeakKeyException(obj4.toString());
            throw weakKeyException2;
        }
        obj4 = new InvalidKeyException("Key argument cannot be null.");
        throw obj4;
    }

    private static String keyType(boolean z) {
        String obj0;
        obj0 = z ? "signing" : "verification";
        return obj0;
    }

    @Override // java.lang.Enum
    public void assertValidSigningKey(Key key) {
        assertValid(key, true);
    }

    @Override // java.lang.Enum
    public void assertValidVerificationKey(Key key) {
        assertValid(key, false);
    }

    @Override // java.lang.Enum
    public String getDescription() {
        return this.description;
    }

    @Override // java.lang.Enum
    public String getFamilyName() {
        return this.familyName;
    }

    @Override // java.lang.Enum
    public String getJcaName() {
        return this.jcaName;
    }

    @Override // java.lang.Enum
    public int getMinKeyLength() {
        return this.minKeyLength;
    }

    @Override // java.lang.Enum
    public String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public boolean isEllipticCurve() {
        return this.familyName.equals("ECDSA");
    }

    @Override // java.lang.Enum
    public boolean isHmac() {
        return this.familyName.equals("HMAC");
    }

    @Override // java.lang.Enum
    public boolean isJdkStandard() {
        return this.jdkStandard;
    }

    @Override // java.lang.Enum
    public boolean isRsa() {
        return this.familyName.equals("RSA");
    }
}
