package com.appsflyer;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec.Builder;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.appsflyer.internal.ab;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyPairGeneratorSpi;
import java.security.KeyStore;
import java.util.Calendar;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public class AFKeystoreWrapper {

    public KeyStore AFInAppEventParameterName;
    public String AFInAppEventType;
    public final Object AFKeystoreWrapper;
    public int valueOf = 0;
    private Context values;
    public AFKeystoreWrapper(Context context) {
        super();
        Object object = new Object();
        this.AFKeystoreWrapper = object;
        this.values = context;
        this.AFInAppEventType = "";
        int obj2 = 0;
        AFLogger.AFInAppEventType("Initialising KeyStore..");
        obj2 = KeyStore.getInstance("AndroidKeyStore");
        this.AFInAppEventParameterName = obj2;
        obj2.load(0);
    }

    private static boolean valueOf(String string) {
        return string.startsWith("com.appsflyer");
    }

    public final void AFInAppEventParameterName(String string) {
        Object instance;
        String str;
        int build;
        int sDK_INT;
        int i;
        Object obj7;
        AFLogger.AFInAppEventType("Creating a new key with alias: ".concat(String.valueOf(string)));
        instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.add(1, 5);
        build = 0;
        Object aFKeystoreWrapper = this.AFKeystoreWrapper;
        synchronized (aFKeystoreWrapper) {
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 23) {
                KeyGenParameterSpec.Builder builder2 = new KeyGenParameterSpec.Builder(string, 3);
                obj7 = new X500Principal("CN=AndroidSDK, O=AppsFlyer");
                build = builder2.setCertificateSubject(obj7).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
            } else {
                if (sDK_INT >= 18 && !ab.AFInAppEventParameterName()) {
                    if (!ab.AFInAppEventParameterName()) {
                        KeyPairGeneratorSpec.Builder builder = new KeyPairGeneratorSpec.Builder(this.values);
                        X500Principal x500Principal = new X500Principal("CN=AndroidSDK, O=AppsFlyer");
                        build = builder.setAlias(string).setSubject(x500Principal).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    }
                }
            }
            obj7 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            obj7.initialize(build);
            obj7.generateKeyPair();
        }
    }

    public final boolean AFInAppEventParameterName() {
        Throwable th;
        String[] aFInAppEventParameterName;
        StringBuilder sb;
        int i2;
        String[] split;
        int moreElements;
        int valueOf;
        int i;
        final Object aFKeystoreWrapper = this.AFKeystoreWrapper;
        aFInAppEventParameterName = this.AFInAppEventParameterName;
        i2 = 1;
        synchronized (aFKeystoreWrapper) {
            aFInAppEventParameterName = aFInAppEventParameterName.aliases();
            while (aFInAppEventParameterName.hasMoreElements()) {
                moreElements = aFInAppEventParameterName.nextElement();
            }
            i2 = split;
            return i2;
        }
    }

    public final String AFInAppEventType() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.appsflyer,");
        Object aFKeystoreWrapper = this.AFKeystoreWrapper;
        stringBuilder.append("KSAppsFlyerId=");
        stringBuilder.append(this.AFInAppEventType);
        stringBuilder.append(",");
        stringBuilder.append("KSAppsFlyerRICounter=");
        stringBuilder.append(this.valueOf);
        return stringBuilder.toString();
        synchronized (aFKeystoreWrapper) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("com.appsflyer,");
            aFKeystoreWrapper = this.AFKeystoreWrapper;
            stringBuilder.append("KSAppsFlyerId=");
            stringBuilder.append(this.AFInAppEventType);
            stringBuilder.append(",");
            stringBuilder.append("KSAppsFlyerRICounter=");
            stringBuilder.append(this.valueOf);
            return stringBuilder.toString();
        }
    }

    public final int AFKeystoreWrapper() {
        final Object aFKeystoreWrapper = this.AFKeystoreWrapper;
        return this.valueOf;
        synchronized (aFKeystoreWrapper) {
            aFKeystoreWrapper = this.AFKeystoreWrapper;
            return this.valueOf;
        }
    }

    public final String valueOf() {
        final Object aFKeystoreWrapper = this.AFKeystoreWrapper;
        return this.AFInAppEventType;
        synchronized (aFKeystoreWrapper) {
            aFKeystoreWrapper = this.AFKeystoreWrapper;
            return this.AFInAppEventType;
        }
    }
}
