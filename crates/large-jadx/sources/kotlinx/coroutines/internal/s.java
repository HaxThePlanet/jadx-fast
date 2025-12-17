package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.j2;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0008\u0010\u000b\u001a\u00020\u000cH\u0000\u001a\u000c\u0010\r\u001a\u00020\u0003*\u00020\u000eH\u0007\u001a\u001a\u0010\u000f\u001a\u00020\u000e*\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0004\u0010\u0005¨\u0006\u0013", d2 = {"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "getSUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class s {

    private static final boolean a = true;
    static {
    }

    private static final kotlinx.coroutines.internal.t a(Throwable throwable, String string2) {
        if (s.a) {
            t tVar = new t(throwable, string2);
            return tVar;
        }
        if (throwable == null) {
            s.c();
            throw 0;
        }
        throw throwable;
    }

    static kotlinx.coroutines.internal.t b(Throwable throwable, String string2, int i3, Object object4) {
        int obj1;
        int obj2;
        final int i = 0;
        if (i3 & 1 != 0) {
            obj1 = i;
        }
        if (i3 &= 2 != 0) {
            obj2 = i;
        }
        return s.a(obj1, obj2);
    }

    public static final Void c() {
        IllegalStateException illegalStateException = new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        throw illegalStateException;
    }

    public static final j2 d(kotlinx.coroutines.internal.MainDispatcherFactory mainDispatcherFactory, List<? extends kotlinx.coroutines.internal.MainDispatcherFactory> list2) {
        j2 obj0;
        List obj1;
        try {
            obj0 = mainDispatcherFactory.createDispatcher(list2);
            mainDispatcherFactory = mainDispatcherFactory.hintOnError();
            mainDispatcherFactory = s.a(list2, mainDispatcherFactory);
            return obj0;
        }
    }
}
