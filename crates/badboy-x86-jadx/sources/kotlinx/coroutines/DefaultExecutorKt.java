package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\u0008\u0010\u0008\u001a\u00020\u0001H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay$annotations", "()V", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "defaultMainDelayOptIn", "", "initializeDefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DefaultExecutorKt {

    private static final kotlinx.coroutines.Delay DefaultDelay;
    private static final boolean defaultMainDelayOptIn;
    static {
        DefaultExecutorKt.defaultMainDelayOptIn = SystemPropsKt.systemProp("kotlinx.coroutines.main.delay", false);
        DefaultExecutorKt.DefaultDelay = DefaultExecutorKt.initializeDefaultDelay();
    }

    public static final kotlinx.coroutines.Delay getDefaultDelay() {
        return DefaultExecutorKt.DefaultDelay;
    }

    public static void getDefaultDelay$annotations() {
    }

    private static final kotlinx.coroutines.Delay initializeDefaultDelay() {
        kotlinx.coroutines.CoroutineDispatcher iNSTANCE;
        boolean missing;
        if (!DefaultExecutorKt.defaultMainDelayOptIn) {
            return (Delay)DefaultExecutor.INSTANCE;
        }
        kotlinx.coroutines.MainCoroutineDispatcher main = Dispatchers.getMain();
        if (!MainDispatchersKt.isMissing(main)) {
            if (!main instanceof Delay) {
                iNSTANCE = DefaultExecutor.INSTANCE;
            } else {
                iNSTANCE = main;
            }
        } else {
        }
        return iNSTANCE;
    }
}
