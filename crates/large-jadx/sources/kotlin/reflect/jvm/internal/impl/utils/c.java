package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class c {
    public static final boolean a(Throwable throwable) {
        String str;
        String str2;
        Class obj2;
        n.f(throwable, "<this>");
        obj2 = throwable.getClass();
        while (n.b(obj2.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException") != null) {
        }
        return 1;
    }

    public static final RuntimeException b(Throwable throwable) {
        n.f(throwable, "e");
        throw throwable;
    }
}
