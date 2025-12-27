package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.RuntimeEnvironment;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RsaProvider.java */
/* loaded from: classes3.dex */
public abstract class RsaProvider extends SignatureProvider {

    private static final Map<SignatureAlgorithm, PSSParameterSpec> PSS_PARAMETER_SPECS;

    static class AnonymousClass1 {

        static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;
        static {
            int[] iArr = new int[SignatureAlgorithm.values().length];
            RsaProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm = iArr;
            try {
                iArr[SignatureAlgorithm.RS256.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                RsaProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS256.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                RsaProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.RS384.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                RsaProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS384.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        RsaProvider.PSS_PARAMETER_SPECS = RsaProvider.createPssParameterSpecs();
        RuntimeEnvironment.enableBouncyCastleIfPossible();
    }

    protected RsaProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isRsa(), "SignatureAlgorithm must be an RSASSA or RSASSA-PSS algorithm.");
    }

    private static Map<SignatureAlgorithm, PSSParameterSpec> createPssParameterSpecs() {
        final HashMap hashMap = new HashMap();
        MGF1ParameterSpec sHA2562 = MGF1ParameterSpec.SHA256;
        PSSParameterSpec pSSParameterSpec = new PSSParameterSpec(sHA2562.getDigestAlgorithm(), "MGF1", sHA2562, 32, 1);
        hashMap.put(SignatureAlgorithm.PS256, pSSParameterSpec);
        final MGF1ParameterSpec sHA3842 = MGF1ParameterSpec.SHA384;
        PSSParameterSpec pSSParameterSpec2 = new PSSParameterSpec(sHA3842.getDigestAlgorithm(), "MGF1", sHA3842, 48, 1);
        hashMap.put(SignatureAlgorithm.PS384, pSSParameterSpec2);
        MGF1ParameterSpec sHA5122 = MGF1ParameterSpec.SHA512;
        PSSParameterSpec pSSParameterSpec3 = new PSSParameterSpec(sHA5122.getDigestAlgorithm(), "MGF1", sHA5122, 64, 1);
        hashMap.put(SignatureAlgorithm.PS512, pSSParameterSpec3);
        return hashMap;
    }

    public static KeyPair generateKeyPair() {
        return RsaProvider.generateKeyPair(4096);
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureProvider
    protected Signature createSignatureInstance() {
        final Signature signatureInstance = super.createSignatureInstance();
        Object value = RsaProvider.PSS_PARAMETER_SPECS.get(this.alg);
        if (value != null) {
            setParameter(signatureInstance, value);
        }
        return signatureInstance;
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureProvider
    protected void doSetParameter(Signature signature, PSSParameterSpec pSSParameterSpec) throws java.security.InvalidParameterException {
        signature.setParameter(pSSParameterSpec);
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureProvider
    protected void setParameter(Signature signature, PSSParameterSpec pSSParameterSpec) throws SignatureException {
        try {
            doSetParameter(signature, pSSParameterSpec);
        } catch (java.security.InvalidAlgorithmParameterException invalidAlgorithmParameter) {
            StringBuilder signatureException = new SignatureException();
            String str = "Unsupported RSASSA-PSS parameter '";
            pSSParameterSpec = "': ";
            pSSParameterSpec = invalidAlgorithmParameter.getMessage();
            pSSParameterSpec = str + pSSParameterSpec + pSSParameterSpec + pSSParameterSpec;
            signatureException = new SignatureException(pSSParameterSpec, invalidAlgorithmParameter);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) signatureException;
        }
    }

    public static KeyPair generateKeyPair(int i) {
        return RsaProvider.generateKeyPair(i, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm) {
        int i = 1;
        int i2 = 2048;
        Assert.isTrue(signatureAlgorithm.isRsa(), "Only RSA algorithms are supported by this method.");
        int i3 = RsaProvider.AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        i = 1;
        if (i3 == 1 || i3 == 2) {
            i2 = 2048;
        } else {
            i = 3;
            signatureAlgorithm = i3 != 3 && i3 != 4 ? 4096 : 3072;
        }
        return (i3 != 3 && i3 != 4 ? 4096 : 3072);
    }

    public static KeyPair generateKeyPair(int i, SecureRandom secureRandom) {
        return RsaProvider.generateKeyPair("RSA", i, secureRandom);
    }

    protected static KeyPair generateKeyPair(String str, int i, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str);
        } catch (java.security.NoSuchAlgorithmException noSuchAlgorithm) {
            secureRandom = new StringBuilder();
            String message = "Unable to obtain an RSA KeyPairGenerator: ";
            secureRandom.append(message);
            message = noSuchAlgorithm.getMessage();
            secureRandom.append(message);
            secureRandom = secureRandom.toString();
            i = new IllegalStateException(secureRandom, noSuchAlgorithm);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
        keyPairGenerator.initialize(i, secureRandom);
        return keyPairGenerator.genKeyPair();
    }
}
