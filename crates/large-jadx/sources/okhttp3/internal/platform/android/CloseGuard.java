package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\n\u0012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0017\u0010\u0008\u001a\u00020\u00072\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\u0008\u0008\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u000cR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u000cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u000c¨\u0006\u0012", d2 = {"Lokhttp3/internal/platform/android/CloseGuard;", "", "", "closer", "createAndOpen", "(Ljava/lang/String;)Ljava/lang/Object;", "closeGuardInstance", "", "warnIfOpen", "(Ljava/lang/Object;)Z", "Ljava/lang/reflect/Method;", "warnIfOpenMethod", "Ljava/lang/reflect/Method;", "getMethod", "openMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CloseGuard {

    public static final okhttp3.internal.platform.android.CloseGuard.Companion Companion;
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/platform/android/CloseGuard$Companion;", "", "Lokhttp3/internal/platform/android/CloseGuard;", "get", "()Lokhttp3/internal/platform/android/CloseGuard;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.android.CloseGuard get() {
            Method method;
            Method method2;
            int i = 0;
            Class forName = Class.forName("dalvik.system.CloseGuard");
            int i2 = 0;
            Class[] arr3 = new Class[1];
            arr3[i2] = String.class;
            method2 = forName.getMethod("open", arr3);
            method = method3;
            CloseGuard closeGuard = new CloseGuard(forName.getMethod("get", new Class[i2]), method2, method);
            return closeGuard;
        }
    }
    static {
        CloseGuard.Companion companion = new CloseGuard.Companion(0);
        CloseGuard.Companion = companion;
    }

    public CloseGuard(Method method, Method method2, Method method3) {
        super();
        this.getMethod = method;
        this.openMethod = method2;
        this.warnIfOpenMethod = method3;
    }

    public final Object createAndOpen(String string) {
        n.f(string, "closer");
        Method getMethod = this.getMethod;
        final int i = 0;
        if (getMethod != null) {
            final int i2 = 0;
            Object invoke = getMethod.invoke(i, new Object[i2]);
            Method openMethod = this.openMethod;
            n.d(openMethod);
            Object[] arr2 = new Object[1];
            arr2[i2] = string;
            openMethod.invoke(invoke, arr2);
            return invoke;
        }
        return i;
    }

    public final boolean warnIfOpen(Object object) {
        int i;
        Method warnIfOpenMethod;
        Object[] arr;
        if (object != null) {
            warnIfOpenMethod = this.warnIfOpenMethod;
            n.d(warnIfOpenMethod);
            warnIfOpenMethod.invoke(object, new Object[0]);
            i = 1;
        }
        return i;
    }
}
