package io.jsonwebtoken.lang;

import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RuntimeEnvironment.java */
/* loaded from: classes3.dex */
public final class RuntimeEnvironment {

    private static final String BC_PROVIDER_CLASS_NAME = "org.bouncycastle.jce.provider.BouncyCastleProvider";
    public static final boolean BOUNCY_CASTLE_AVAILABLE = false;
    private static final AtomicBoolean bcLoaded = new AtomicBoolean(0);
    static {
        RuntimeEnvironment.BOUNCY_CASTLE_AVAILABLE = Classes.isAvailable("org.bouncycastle.jce.provider.BouncyCastleProvider");
        RuntimeEnvironment.enableBouncyCastleIfPossible();
    }

    private RuntimeEnvironment() {
        super();
    }

    public static void enableBouncyCastleIfPossible() {
        int i = 0;
        boolean instance;
        if (RuntimeEnvironment.BOUNCY_CASTLE_AVAILABLE) {
            if (!(RuntimeEnvironment.bcLoaded.get())) {
                try {
                    Class cls = Classes.forName("org.bouncycastle.jce.provider.BouncyCastleProvider");
                    java.security.Provider[] providers = Security.getProviders();
                    i = 0;
                    boolean z = true;
                    for (java.security.Provider provider : providers) {
                        if (cls.isInstance(provider)) {
                            RuntimeEnvironment.bcLoaded.set(z);
                            return;
                        } else {
                            z = true;
                            for (java.security.Provider provider : providers) {
                                if (cls.isInstance(provider)) {
                                    RuntimeEnvironment.bcLoaded.set(z);
                                    return;
                                }
                            }
                            Security.addProvider((Provider)Classes.newInstance(cls));
                            RuntimeEnvironment.bcLoaded.set(z);
                        }
                    }
                    RuntimeEnvironment.bcLoaded.set(z);
                    return;
                } catch (io.jsonwebtoken.lang.UnknownClassException unused) {
                    return;
                }
            }
        }
    }
}
