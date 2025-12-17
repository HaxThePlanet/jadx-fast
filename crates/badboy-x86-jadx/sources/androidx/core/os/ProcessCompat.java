package androidx.core.os;

import android.os.Process;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public final class ProcessCompat {

    static class Api19Impl {

        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock;
        static {
            Object object = new Object();
            ProcessCompat.Api19Impl.sResolvedLock = object;
        }

        static boolean isApplicationUid(int uid) {
            Method sMethodUserHandleIsAppMethod;
            boolean declaredMethod;
            String str;
            Class[] arr;
            Class tYPE;
            int i;
            int i2 = 1;
            Object sResolvedLock = ProcessCompat.Api19Impl.sResolvedLock;
            synchronized (sResolvedLock) {
                try {
                    ProcessCompat.Api19Impl.sResolved = i2;
                    arr = new Class[i2];
                    arr[0] = Integer.TYPE;
                    ProcessCompat.Api19Impl.sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", arr);
                    Object invoke = ProcessCompat.Api19Impl.sMethodUserHandleIsAppMethod.invoke(0, /* result */);
                } catch (Throwable th) {
                }
                return i2;
            }
        }
    }

    static class Api24Impl {
        static boolean isApplicationUid(int uid) {
            return Process.isApplicationUid(uid);
        }
    }
    public static boolean isApplicationUid(int uid) {
        return ProcessCompat.Api24Impl.isApplicationUid(uid);
    }
}
