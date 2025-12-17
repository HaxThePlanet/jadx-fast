package androidx.lifecycle.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u001d\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"LocalLifecycleOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner$annotations", "()V", "getLocalLifecycleOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "lifecycle-runtime-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LocalLifecycleOwnerKt {

    private static final ProvidableCompositionLocal<LifecycleOwner> LocalLifecycleOwner;
    public static LifecycleOwner $r8$lambda$Ec8ElF-OkdPb2C9Ia3t1Rrp-8Bg() {
        return LocalLifecycleOwnerKt.LocalLifecycleOwner$lambda$3$lambda$2();
    }

    static {
        int staticCompositionLocalOf;
        Object constructor-impl;
        java.lang.ClassLoader classLoader;
        int invoke;
        java.lang.annotation.Annotation[] annotations;
        int i2;
        int i;
        java.lang.annotation.Annotation annotation;
        java.lang.annotation.Annotation annotation2;
        int i3;
        boolean z;
        final int i4 = 0;
        staticCompositionLocalOf = 0;
        kotlin.Result.Companion companion = Result.Companion;
        int i5 = 0;
        classLoader = LifecycleOwner.class.getClassLoader();
        Intrinsics.checkNotNull(classLoader);
        int i6 = 0;
        Method method = classLoader.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalLifecycleOwner", new Class[i6]);
        annotations = method.getAnnotations();
        final int i7 = 0;
        i = i6;
        while (i < annotations.length) {
            i3 = 0;
            i++;
        }
        i2 = i6;
        if (i2 != 0) {
            invoke = staticCompositionLocalOf;
        } else {
            if (invoke instanceof ProvidableCompositionLocal) {
            } else {
                invoke = staticCompositionLocalOf;
            }
        }
        constructor-impl = Result.constructor-impl(invoke);
        if (Result.isFailure-impl(constructor-impl)) {
        } else {
            staticCompositionLocalOf = constructor-impl;
        }
        if ((ProvidableCompositionLocal)staticCompositionLocalOf == 0) {
            LocalLifecycleOwnerKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LocalLifecycleOwnerKt$$ExternalSyntheticLambda0();
            staticCompositionLocalOf = CompositionLocalKt.staticCompositionLocalOf(externalSyntheticLambda0);
        }
        LocalLifecycleOwnerKt.LocalLifecycleOwner = staticCompositionLocalOf;
    }

    private static final LifecycleOwner LocalLifecycleOwner$lambda$3$lambda$2() {
        IllegalStateException illegalStateException = new IllegalStateException("CompositionLocal LocalLifecycleOwner not present".toString());
        throw illegalStateException;
    }

    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwnerKt.LocalLifecycleOwner;
    }

    public static void getLocalLifecycleOwner$annotations() {
    }
}
