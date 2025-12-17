package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0008\u0010\u000b\u001a\u00020\u000cH\u0000\u001a\u000c\u0010\r\u001a\u00020\u0003*\u00020\u000eH\u0007\u001a\u001a\u0010\u000f\u001a\u00020\u000e*\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0004\u0010\u0005¨\u0006\u0013", d2 = {"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "getSUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MainDispatchersKt {

    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";
    private static final boolean SUPPORT_MISSING = true;
    static {
        final int i = 1;
    }

    private static final kotlinx.coroutines.internal.MissingMainCoroutineDispatcher createMissingDispatcher(Throwable cause, String errorHint) {
        if (MainDispatchersKt.SUPPORT_MISSING) {
            MissingMainCoroutineDispatcher missingMainCoroutineDispatcher = new MissingMainCoroutineDispatcher(cause, errorHint);
            return missingMainCoroutineDispatcher;
        }
        if (cause != null) {
            final int i = 0;
            throw cause;
        }
        MainDispatchersKt.throwMissingMainDispatcherException();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    static kotlinx.coroutines.internal.MissingMainCoroutineDispatcher createMissingDispatcher$default(Throwable throwable, String string2, int i3, Object object4) {
        int obj1;
        int obj2;
        final int i = 0;
        if (i3 & 1 != 0) {
            obj1 = i;
        }
        if (i3 &= 2 != 0) {
            obj2 = i;
        }
        return MainDispatchersKt.createMissingDispatcher(obj1, obj2);
    }

    private static void getSUPPORT_MISSING$annotations() {
    }

    public static final boolean isMissing(MainCoroutineDispatcher $this$isMissing) {
        return immediate instanceof MissingMainCoroutineDispatcher;
    }

    public static final Void throwMissingMainDispatcherException() {
        IllegalStateException illegalStateException = new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        throw illegalStateException;
    }

    public static final MainCoroutineDispatcher tryCreateDispatcher(kotlinx.coroutines.internal.MainDispatcherFactory $this$tryCreateDispatcher, List<? extends kotlinx.coroutines.internal.MainDispatcherFactory> factories) {
        MainCoroutineDispatcher dispatcher;
        String missingDispatcher;
        dispatcher = $this$tryCreateDispatcher.createDispatcher(factories);
        return dispatcher;
    }
}
