package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u000c8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0011\u0010\u0002\u001a\u0004\u0008\u0012\u0010\u0007¨\u0006\u0015", d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "()V", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "getIO$annotations", "getIO", "Main", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "Unconfined", "getUnconfined$annotations", "getUnconfined", "shutdown", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Dispatchers {

    private static final kotlinx.coroutines.CoroutineDispatcher Default;
    public static final kotlinx.coroutines.Dispatchers INSTANCE;
    private static final kotlinx.coroutines.CoroutineDispatcher IO;
    private static final kotlinx.coroutines.CoroutineDispatcher Unconfined;
    static {
        Dispatchers dispatchers = new Dispatchers();
        Dispatchers.INSTANCE = dispatchers;
        Dispatchers.Default = (CoroutineDispatcher)DefaultScheduler.INSTANCE;
        Dispatchers.Unconfined = (CoroutineDispatcher)Unconfined.INSTANCE;
        Dispatchers.IO = (CoroutineDispatcher)DefaultIoScheduler.INSTANCE;
    }

    public static final kotlinx.coroutines.CoroutineDispatcher getDefault() {
        return Dispatchers.Default;
    }

    @JvmStatic
    public static void getDefault$annotations() {
    }

    public static final kotlinx.coroutines.CoroutineDispatcher getIO() {
        return Dispatchers.IO;
    }

    @JvmStatic
    public static void getIO$annotations() {
    }

    public static final kotlinx.coroutines.MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    @JvmStatic
    public static void getMain$annotations() {
    }

    public static final kotlinx.coroutines.CoroutineDispatcher getUnconfined() {
        return Dispatchers.Unconfined;
    }

    @JvmStatic
    public static void getUnconfined$annotations() {
    }

    public final void shutdown() {
        DefaultExecutor.INSTANCE.shutdown();
        DefaultScheduler.INSTANCE.shutdown$kotlinx_coroutines_core();
    }
}
