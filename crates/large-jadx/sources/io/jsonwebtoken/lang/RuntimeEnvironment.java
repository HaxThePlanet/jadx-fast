package io.jsonwebtoken.lang;

import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class RuntimeEnvironment {

    private static final String BC_PROVIDER_CLASS_NAME = "org.bouncycastle.jce.provider.BouncyCastleProvider";
    public static final boolean BOUNCY_CASTLE_AVAILABLE;
    private static final AtomicBoolean bcLoaded;
    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        RuntimeEnvironment.bcLoaded = atomicBoolean;
        RuntimeEnvironment.BOUNCY_CASTLE_AVAILABLE = Classes.isAvailable("org.bouncycastle.jce.provider.BouncyCastleProvider");
        RuntimeEnvironment.enableBouncyCastleIfPossible();
    }

    public static void enableBouncyCastleIfPossible() {
        boolean bOUNCY_CASTLE_AVAILABLE;
        java.security.Provider[] providers;
        int length;
        int i;
        int i2;
        boolean instance;
        if (RuntimeEnvironment.BOUNCY_CASTLE_AVAILABLE) {
            if (RuntimeEnvironment.bcLoaded.get()) {
            } else {
                Class forName = Classes.forName("org.bouncycastle.jce.provider.BouncyCastleProvider");
                providers = Security.getProviders();
                i = 0;
                i2 = 1;
                while (i < providers.length) {
                    i++;
                    i2 = 1;
                }
                Security.addProvider((Provider)Classes.newInstance(forName));
                RuntimeEnvironment.bcLoaded.set(i2);
            }
        }
    }
}
