package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FastServiceLoaderKt {

    private static final boolean ANDROID_DETECTED;
    static {
        Object constructor-impl;
        Class forName;
        try {
            kotlin.Result.Companion companion = Result.Companion;
            int i = 0;
            constructor-impl = Result.constructor-impl(Class.forName("android.os.Build"));
            kotlin.Result.Companion companion2 = Result.Companion;
            Throwable constructor-impl2 = ResultKt.createFailure(constructor-impl2);
            constructor-impl2 = Result.constructor-impl(constructor-impl2);
            FastServiceLoaderKt.ANDROID_DETECTED = Result.isSuccess-impl(constructor-impl);
        }
    }

    public static final boolean getANDROID_DETECTED() {
        return FastServiceLoaderKt.ANDROID_DETECTED;
    }
}
