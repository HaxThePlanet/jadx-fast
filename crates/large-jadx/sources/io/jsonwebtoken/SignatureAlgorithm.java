package io.jsonwebtoken;

import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import java.math.BigInteger;
import java.security.Key;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.crypto.SecretKey;

/* compiled from: SignatureAlgorithm.java */
/* loaded from: classes3.dex */
public enum SignatureAlgorithm {

    NONE("none", "No digital signature or MAC performed", "None", 0, 0, 0, 0),
    PS256("PS256", "RSASSA-PSS using SHA-256 and MGF1 with SHA-256", "RSA", "RSASSA-PSS", 0, 256, 2048),
    PS384("PS384", "RSASSA-PSS using SHA-384 and MGF1 with SHA-384", "RSA", "RSASSA-PSS", 0, 384, 2048);

    private final String description;
    private final int digestLength;
    private final String familyName;
    private final String jcaName;
    private final boolean jdkStandard;
    private final int minKeyLength;
    @Deprecated
    private final String pkcs12Name;
    private final String value;
    private void assertValid(Key key, boolean z) throws InvalidKeyException, WeakKeyException {
        String str;
        io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm;
        boolean equalsIgnoreCase;
        boolean equalsIgnoreCase2;
        boolean equalsIgnoreCase3;
        Class<io.jsonwebtoken.security.Keys> obj = Keys.class;
        if (this == SignatureAlgorithm.NONE) {
            throw new InvalidKeyException("The 'NONE' signature algorithm does not support cryptographic keys.");
        } else {
            final String str4 = " key's size is ";
            String str5 = " algorithm.  The JWT ";
            final String str7 = ".  See ";
            final String str8 = " class's ";
            String str9 = " ";
            final String str10 = "The ";
            if (isHmac()) {
                if (!(key instanceof SecretKey)) {
                    StringBuilder stringBuilder7 = new StringBuilder();
                    String keyType5 = SignatureAlgorithm.keyType(z);
                    String str40 = " keys must be SecretKey instances.";
                    key = this.familyName + str9 + keyType5 + str40;
                    throw new InvalidKeyException(key);
                } else {
                    byte[] encoded = key.getEncoded();
                    if (encoded == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String keyType = SignatureAlgorithm.keyType(z);
                        String str37 = " key's encoded bytes cannot be null.";
                        z = str10 + keyType + str37;
                        throw new InvalidKeyException(z);
                    } else {
                        String algorithm = key.getAlgorithm();
                        if (algorithm == null) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            String keyType4 = SignatureAlgorithm.keyType(z);
                            String str39 = " key's algorithm cannot be null.";
                            z = str10 + keyType4 + str39;
                            throw new InvalidKeyException(z);
                        } else {
                            signatureAlgorithm = SignatureAlgorithm.HS256;
                            if (!signatureAlgorithm.jcaName.equalsIgnoreCase(algorithm) && !SignatureAlgorithm.HS384.jcaName.equalsIgnoreCase(algorithm) && !SignatureAlgorithm.HS512.jcaName.equalsIgnoreCase(algorithm) && !SignatureAlgorithm.HS256.pkcs12Name.equals(algorithm) && !SignatureAlgorithm.HS384.pkcs12Name.equals(algorithm)) {
                                if (!SignatureAlgorithm.HS512.pkcs12Name.equals(algorithm)) {
                                    StringBuilder stringBuilder3 = new StringBuilder();
                                    String keyType2 = SignatureAlgorithm.keyType(z);
                                    String str38 = " key's algorithm '";
                                    String str14 = "' does not equal a valid HmacSHA* algorithm name and cannot be used with ";
                                    String name2 = name();
                                    String str15 = ".";
                                    key = str10 + keyType2 + str38 + algorithm + str14 + name2 + str15;
                                    throw new InvalidKeyException(key);
                                }
                            }
                            bitLength = encoded.length * 8;
                            if (encoded.length < this.minKeyLength) {
                                StringBuilder stringBuilder4 = new StringBuilder();
                                String keyType3 = SignatureAlgorithm.keyType(z);
                                String str16 = " bits which ";
                                String str17 = "is not secure enough for the ";
                                String name3 = name();
                                String str18 = "JWA Specification (RFC 7518, Section 3.2) states that keys used with ";
                                String name4 = name();
                                String str19 = " MUST have a ";
                                String str20 = "size >= ";
                                String str21 = " bits (the key size must be greater than or equal to the hash ";
                                String str22 = "output size).  Consider using the ";
                                String name5 = obj.getName();
                                String str23 = "'secretKeyFor(SignatureAlgorithm.";
                                String name6 = name();
                                String str24 = ")' method to create a key guaranteed to be ";
                                String str25 = "secure enough for ";
                                String name7 = name();
                                String str26 = "https://tools.ietf.org/html/rfc7518#section-3.2 for more information.";
                                key = str10 + keyType3 + str4 + bitLength + str16 + str17 + name3 + " algorithm.  The JWT " + str18 + name4 + str19 + str20 + this.minKeyLength + str21 + str22 + name5 + str8 + str23 + name6 + str24 + str25 + name7 + ".  See " + str26;
                                throw new WeakKeyException(key);
                            }
                        }
                    }
                }
            }
            if (z) {
                hmac = key instanceof PrivateKey;
                if (!(key instanceof PrivateKey)) {
                    StringBuilder stringBuilder8 = new StringBuilder();
                    String str41 = " signing keys must be PrivateKey instances.";
                    key = this.familyName + str41;
                    throw new InvalidKeyException(key);
                }
            }
            String str11 = "to be secure enough for ";
            String str12 = ")' method to create a key pair guaranteed ";
            String str13 = "'keyPairFor(SignatureAlgorithm.";
            str2 = " bits.  Consider using the ";
            str3 = " MUST have a size >= ";
            if (isEllipticCurve()) {
                if (!(key instanceof ECKey)) {
                    StringBuilder stringBuilder9 = new StringBuilder();
                    String keyType7 = SignatureAlgorithm.keyType(z);
                    String str43 = " keys must be ECKey instances.";
                    key = this.familyName + str9 + keyType7 + str43;
                    throw new InvalidKeyException(key);
                } else {
                    int bitLength = key.getParams().getOrder().bitLength();
                    if (bitLength < this.minKeyLength) {
                        StringBuilder stringBuilder5 = new StringBuilder();
                        String keyType6 = SignatureAlgorithm.keyType(z);
                        String str42 = " key's size (ECParameterSpec order) is ";
                        String str27 = " bits which is not secure enough for the ";
                        String name8 = name();
                        String str28 = "JWA Specification (RFC 7518, Section 3.4) states that keys used with ";
                        String name9 = name();
                        String name10 = obj.getName();
                        String name11 = name();
                        String name12 = name();
                        String str29 = "https://tools.ietf.org/html/rfc7518#section-3.4 for more information.";
                        key = str10 + keyType6 + str42 + bitLength + str27 + name8 + " algorithm.  The JWT " + str28 + name9 + str3 + this.minKeyLength + " bits.  Consider using the " + name10 + str8 + str13 + name11 + str12 + str11 + name12 + ".  See " + str29;
                        throw new WeakKeyException(key);
                    }
                }
            }
            if (!(key instanceof RSAKey)) {
                StringBuilder stringBuilder10 = new StringBuilder();
                String keyType9 = SignatureAlgorithm.keyType(z);
                String str44 = " keys must be RSAKey instances.";
                key = this.familyName + str9 + keyType9 + str44;
                throw new InvalidKeyException(key);
            } else {
                bitLength = key.getModulus().bitLength();
                if (bitLength < this.minKeyLength) {
                    String r1 = name().startsWith("P") ? "3.5" : "3.3";
                    StringBuilder stringBuilder6 = new StringBuilder();
                    String keyType8 = SignatureAlgorithm.keyType(z);
                    String str30 = " bits which is not secure ";
                    String str31 = "enough for the ";
                    String name13 = name();
                    String str32 = " algorithm.  The JWT JWA Specification (RFC 7518, Section ";
                    String str33 = ") states that keys used with ";
                    String name14 = name();
                    String name15 = obj.getName();
                    String name16 = name();
                    String name17 = name();
                    String str34 = "https://tools.ietf.org/html/rfc7518#section-";
                    String str35 = " for more information.";
                    key = str10 + keyType8 + str4 + bitLength + str30 + str31 + name13 + str32 + r1 + str33 + name14 + str3 + this.minKeyLength + " bits.  Consider using the " + name15 + str8 + str13 + name16 + str12 + str11 + name17 + ".  See " + "https://tools.ietf.org/html/rfc7518#section-" + r1 + " for more information.";
                    throw new WeakKeyException(str10 + keyType8 + str4 + bitLength + str30 + str31 + name13 + str32 + (name().startsWith("P") ? "3.5" : "3.3") + str33 + name14 + str3 + minKeyLength24 + str2 + name15 + str8 + str13 + name16 + str12 + str11 + name17 + str7 + str34 + (name().startsWith("P") ? "3.5" : "3.3") + str35);
                }
            }
        }
    }

    public static SignatureAlgorithm forName(String str) throws SignatureException {
        int i = 0;
        io.jsonwebtoken.SignatureAlgorithm[] values = SignatureAlgorithm.values();
        i = 0;
        for (io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm : values) {
            if (signatureAlgorithm.getValue().equalsIgnoreCase(str)) {
                return signatureAlgorithm;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Unsupported signature algorithm '";
        String str3 = "'";
        str = str2 + str + str3;
        throw new SignatureException(str);
    }

    public static SignatureAlgorithm forSigningKey(Key key) throws InvalidKeyException, WeakKeyException {
        if (key == null) {
            throw new InvalidKeyException("Key argument cannot be null.");
        } else {
            boolean z2 = key instanceof SecretKey;
            if (!z2) {
                z = key instanceof PrivateKey;
                if (!(key instanceof PrivateKey)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str7 = "JWT standard signing algorithms require either 1) a SecretKey for HMAC-SHA algorithms or 2) a private RSAKey for RSA algorithms or 3) a private ECKey for Elliptic Curve algorithms.  The specified key is of type ";
                    String name = key.getClass().getName();
                    key = str7 + name;
                    throw new InvalidKeyException(key);
                }
            }
            String str5 = "information.";
            if (z2) {
                int i3 = Arrays.length(key.getEncoded()) * 8;
                Iterator it = SignatureAlgorithm.PREFERRED_HMAC_ALGS.iterator();
                while (it.hasNext()) {
                    Object item2 = it.next();
                    if (i3 >= item2.minKeyLength) {
                        return item2;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                String str9 = "The specified SecretKey is not strong enough to be used with JWT HMAC signature algorithms.  The JWT specification requires HMAC keys to be >= 256 bits long.  The specified key is ";
                String str10 = " bits.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more ";
                key = str9 + i3 + str10 + "information.";
                throw new WeakKeyException(key);
            }
            if (key instanceof RSAKey) {
                int bitLength = (RSAKey)key.getModulus().bitLength();
                if (bitLength >= 4096) {
                    io.jsonwebtoken.SignatureAlgorithm rS5122 = SignatureAlgorithm.RS512;
                    rS5122.assertValidSigningKey(key);
                    return rS5122;
                }
                if (bitLength >= 3072) {
                    io.jsonwebtoken.SignatureAlgorithm rS3842 = SignatureAlgorithm.RS384;
                    rS3842.assertValidSigningKey(key);
                    return rS3842;
                }
                io.jsonwebtoken.SignatureAlgorithm rS2562 = SignatureAlgorithm.RS256;
                if (bitLength < rS2562.minKeyLength) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str8 = "The specified RSA signing key is not strong enough to be used with JWT RSA signature algorithms.  The JWT specification requires RSA keys to be >= 2048 bits long.  The specified RSA key is ";
                    String str = " bits.  See https://tools.ietf.org/html/rfc7518#section-3.3 for more ";
                    key = str8 + bitLength + str + "information.";
                    throw new WeakKeyException(key);
                } else {
                    SignatureAlgorithm.RS256.assertValidSigningKey(key);
                    return SignatureAlgorithm.RS256;
                }
            }
            int bitLength2 = (ECKey)key.getParams().getOrder().bitLength();
            Iterator it2 = SignatureAlgorithm.PREFERRED_EC_ALGS.iterator();
            while (it2.hasNext()) {
                Object item = it2.next();
                if (SignatureAlgorithm.PREFERRED_HMAC_ALGS >= item.minKeyLength) {
                    item.assertValidSigningKey(key);
                    return item;
                }
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            String str6 = "The specified Elliptic Curve signing key is not strong enough to be used with JWT ECDSA signature algorithms.  The JWT specification requires ECDSA keys to be >= 256 bits long.  The specified ECDSA key is ";
            String str2 = " bits.  See ";
            String str3 = "https://tools.ietf.org/html/rfc7518#section-3.4 for more information.";
            key = str6 + bitLength2 + str2 + str3;
            throw new WeakKeyException(key);
        }
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

    private static String keyType(boolean z) {
        String str;
        z = z ? "signing" : "verification";
        return (z ? "signing" : "verification");
    }
}
