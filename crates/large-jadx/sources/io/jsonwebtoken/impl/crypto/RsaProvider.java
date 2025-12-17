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

/* loaded from: classes3.dex */
public abstract class RsaProvider extends io.jsonwebtoken.impl.crypto.SignatureProvider {

    private static final Map<SignatureAlgorithm, PSSParameterSpec> PSS_PARAMETER_SPECS;
    static {
        RsaProvider.PSS_PARAMETER_SPECS = RsaProvider.createPssParameterSpecs();
        RuntimeEnvironment.enableBouncyCastleIfPossible();
    }

    protected RsaProvider(SignatureAlgorithm signatureAlgorithm, Key key2) {
        super(signatureAlgorithm, key2);
        Assert.isTrue(signatureAlgorithm.isRsa(), "SignatureAlgorithm must be an RSASSA or RSASSA-PSS algorithm.");
    }

    private static Map<SignatureAlgorithm, PSSParameterSpec> createPssParameterSpecs() {
        HashMap hashMap = new HashMap();
        MGF1ParameterSpec sHA256 = MGF1ParameterSpec.SHA256;
        super(sHA256.getDigestAlgorithm(), "MGF1", sHA256, 32, 1);
        hashMap.put(SignatureAlgorithm.PS256, pSSParameterSpec5);
        final MGF1ParameterSpec sHA384 = MGF1ParameterSpec.SHA384;
        super(sHA384.getDigestAlgorithm(), "MGF1", sHA384, 48, 1);
        hashMap.put(SignatureAlgorithm.PS384, pSSParameterSpec2);
        MGF1ParameterSpec sHA512 = MGF1ParameterSpec.SHA512;
        super(sHA512.getDigestAlgorithm(), "MGF1", sHA512, 64, 1);
        hashMap.put(SignatureAlgorithm.PS512, pSSParameterSpec3);
        return hashMap;
    }

    public static KeyPair generateKeyPair() {
        return RsaProvider.generateKeyPair(4096);
    }

    public static KeyPair generateKeyPair(int i) {
        return RsaProvider.generateKeyPair(i, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(int i, SecureRandom secureRandom2) {
        return RsaProvider.generateKeyPair("RSA", i, secureRandom2);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm) {
        int i;
        int obj2;
        Assert.isTrue(signatureAlgorithm.isRsa(), "Only RSA algorithms are supported by this method.");
        obj2 = RsaProvider.1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        if (obj2 != 1 && obj2 != 2) {
            if (obj2 != 2) {
                if (obj2 != 3 && obj2 != 4) {
                    obj2 = obj2 != 4 ? 4096 : 3072;
                } else {
                }
            } else {
                obj2 = 2048;
            }
        } else {
        }
        return RsaProvider.generateKeyPair(obj2, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    protected static KeyPair generateKeyPair(String string, int i2, SecureRandom secureRandom3) {
        try {
            KeyPairGenerator obj1 = KeyPairGenerator.getInstance(string);
            obj1.initialize(i2, secureRandom3);
            return obj1.genKeyPair();
            secureRandom3 = new StringBuilder();
            String message = "Unable to obtain an RSA KeyPairGenerator: ";
            secureRandom3.append(message);
            message = string.getMessage();
            secureRandom3.append(message);
            secureRandom3 = secureRandom3.toString();
            i2 = new IllegalStateException(secureRandom3, string);
            throw i2;
        }
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureProvider
    protected Signature createSignatureInstance() {
        final Signature signatureInstance = super.createSignatureInstance();
        Object obj = RsaProvider.PSS_PARAMETER_SPECS.get(this.alg);
        if ((PSSParameterSpec)obj != null) {
            setParameter(signatureInstance, (PSSParameterSpec)obj);
        }
        return signatureInstance;
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureProvider
    protected void doSetParameter(Signature signature, PSSParameterSpec pSSParameterSpec2) {
        signature.setParameter(pSSParameterSpec2);
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureProvider
    protected void setParameter(Signature signature, PSSParameterSpec pSSParameterSpec2) {
        try {
            doSetParameter(signature, pSSParameterSpec2);
            StringBuilder signatureException = new StringBuilder();
            signatureException.append("Unsupported RSASSA-PSS parameter '");
            signatureException.append(pSSParameterSpec2);
            pSSParameterSpec2 = "': ";
            signatureException.append(pSSParameterSpec2);
            pSSParameterSpec2 = signature.getMessage();
            signatureException.append(pSSParameterSpec2);
            pSSParameterSpec2 = signatureException.toString();
            signatureException = new SignatureException(pSSParameterSpec2, signature);
            throw signatureException;
        }
    }
}
