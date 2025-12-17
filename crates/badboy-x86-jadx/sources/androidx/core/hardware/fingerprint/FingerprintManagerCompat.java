package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes5.dex */
@Deprecated
public class FingerprintManagerCompat {

    private final Context mContext;

    static class Api23Impl {
        static void authenticate(Object fingerprintManager, Object crypto, CancellationSignal cancel, int flags, Object callback, Handler handler) {
            (FingerprintManager)fingerprintManager.authenticate((FingerprintManager.CryptoObject)crypto, cancel, flags, (FingerprintManager.AuthenticationCallback)callback, handler);
        }

        static FingerprintManager.CryptoObject getCryptoObject(Object authenticationResult) {
            return (FingerprintManager.AuthenticationResult)authenticationResult.getCryptoObject();
        }

        public static FingerprintManager getFingerprintManagerOrNull(Context context) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return (FingerprintManager)context.getSystemService(FingerprintManager.class);
            }
            return null;
        }

        static boolean hasEnrolledFingerprints(Object fingerprintManager) {
            return (FingerprintManager)fingerprintManager.hasEnrolledFingerprints();
        }

        static boolean isHardwareDetected(Object fingerprintManager) {
            return (FingerprintManager)fingerprintManager.isHardwareDetected();
        }

        public static androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject unwrapCryptoObject(Object cryptoObjectObj) {
            final FingerprintManager.CryptoObject cryptoObject = cryptoObjectObj;
            int i = 0;
            if ((FingerprintManager.CryptoObject)cryptoObject == null) {
                return i;
            }
            if ((FingerprintManager.CryptoObject)cryptoObject.getCipher() != null) {
                FingerprintManagerCompat.CryptoObject cryptoObject2 = new FingerprintManagerCompat.CryptoObject(cryptoObject.getCipher());
                return cryptoObject2;
            }
            if (cryptoObject.getSignature() != null) {
                FingerprintManagerCompat.CryptoObject cryptoObject4 = new FingerprintManagerCompat.CryptoObject(cryptoObject.getSignature());
                return cryptoObject4;
            }
            if (cryptoObject.getMac() != null) {
                FingerprintManagerCompat.CryptoObject cryptoObject3 = new FingerprintManagerCompat.CryptoObject(cryptoObject.getMac());
                return cryptoObject3;
            }
            return i;
        }

        public static FingerprintManager.CryptoObject wrapCryptoObject(androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject) {
            int i = 0;
            if (cryptoObject == null) {
                return i;
            }
            if (cryptoObject.getCipher() != null) {
                FingerprintManager.CryptoObject cryptoObject2 = new FingerprintManager.CryptoObject(cryptoObject.getCipher());
                return cryptoObject2;
            }
            if (cryptoObject.getSignature() != null) {
                FingerprintManager.CryptoObject cryptoObject4 = new FingerprintManager.CryptoObject(cryptoObject.getSignature());
                return cryptoObject4;
            }
            if (cryptoObject.getMac() != null) {
                FingerprintManager.CryptoObject cryptoObject3 = new FingerprintManager.CryptoObject(cryptoObject.getMac());
                return cryptoObject3;
            }
            return i;
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int errMsgId, java.lang.CharSequence errString) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int helpMsgId, java.lang.CharSequence helpString) {
        }

        public void onAuthenticationSucceeded(androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationResult result) {
        }
    }

    public static final class AuthenticationResult {

        private final androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject mCryptoObject;
        public AuthenticationResult(androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject crypto) {
            super();
            this.mCryptoObject = crypto;
        }

        public androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {

        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;
        public CryptoObject(Signature signature) {
            super();
            this.mSignature = signature;
            final int i = 0;
            this.mCipher = i;
            this.mMac = i;
        }

        public CryptoObject(Cipher cipher) {
            super();
            this.mCipher = cipher;
            final int i = 0;
            this.mSignature = i;
            this.mMac = i;
        }

        public CryptoObject(Mac mac) {
            super();
            this.mMac = mac;
            final int i = 0;
            this.mCipher = i;
            this.mSignature = i;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }
    private FingerprintManagerCompat(Context context) {
        super();
        this.mContext = context;
    }

    public static androidx.core.hardware.fingerprint.FingerprintManagerCompat from(Context context) {
        FingerprintManagerCompat fingerprintManagerCompat = new FingerprintManagerCompat(context);
        return fingerprintManagerCompat;
    }

    private static FingerprintManager getFingerprintManagerOrNull(Context context) {
        return FingerprintManagerCompat.Api23Impl.getFingerprintManagerOrNull(context);
    }

    static androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject cryptoObject) {
        return FingerprintManagerCompat.Api23Impl.unwrapCryptoObject(cryptoObject);
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback callback) {
        FingerprintManagerCompat.1 anon = new FingerprintManagerCompat.1(callback);
        return anon;
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject) {
        return FingerprintManagerCompat.Api23Impl.wrapCryptoObject(cryptoObject);
    }

    public void authenticate(androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject crypto, int flags, CancellationSignal cancel, androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback callback, Handler handler) {
        FingerprintManager.CryptoObject wrapCryptoObject;
        CancellationSignal cancellationSignal;
        int flags2;
        FingerprintManager.AuthenticationCallback wrapCallback;
        Handler handler2;
        final FingerprintManager fingerprintManagerOrNull = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull != null) {
            FingerprintManagerCompat.Api23Impl.authenticate(fingerprintManagerOrNull, FingerprintManagerCompat.wrapCryptoObject(crypto), cancel, flags, FingerprintManagerCompat.wrapCallback(callback), handler);
        } else {
            flags2 = flags;
            cancellationSignal = cancel;
            handler2 = handler;
        }
    }

    @Deprecated
    public void authenticate(androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject crypto, int flags, CancellationSignal cancel, androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback callback, Handler handler) {
        Object cancellationSignalObject;
        if (cancel != null) {
            cancellationSignalObject = cancel.getCancellationSignalObject();
        } else {
            cancellationSignalObject = 0;
        }
        this.authenticate(crypto, flags, cancellationSignalObject, callback, handler);
    }

    public boolean hasEnrolledFingerprints() {
        boolean enrolledFingerprints;
        int i;
        FingerprintManager fingerprintManagerOrNull = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull != null && FingerprintManagerCompat.Api23Impl.hasEnrolledFingerprints(fingerprintManagerOrNull)) {
            i = FingerprintManagerCompat.Api23Impl.hasEnrolledFingerprints(fingerprintManagerOrNull) ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isHardwareDetected() {
        boolean hardwareDetected;
        int i;
        FingerprintManager fingerprintManagerOrNull = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull != null && FingerprintManagerCompat.Api23Impl.isHardwareDetected(fingerprintManagerOrNull)) {
            i = FingerprintManagerCompat.Api23Impl.isHardwareDetected(fingerprintManagerOrNull) ? 1 : 0;
        } else {
        }
        return i;
    }
}
