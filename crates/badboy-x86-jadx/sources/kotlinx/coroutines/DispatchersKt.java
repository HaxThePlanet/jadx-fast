package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00048FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"IO_PARALLELISM_PROPERTY_NAME", "", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Dispatchers;", "getIO$annotations", "(Lkotlinx/coroutines/Dispatchers;)V", "getIO", "(Lkotlinx/coroutines/Dispatchers;)Lkotlinx/coroutines/CoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DispatchersKt {

    public static final String IO_PARALLELISM_PROPERTY_NAME = "kotlinx.coroutines.io.parallelism";
    public static final kotlinx.coroutines.CoroutineDispatcher getIO(kotlinx.coroutines.Dispatchers $this$IO) {
        return Dispatchers.getIO();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Should not be used directly")
    public static void getIO$annotations(kotlinx.coroutines.Dispatchers dispatchers) {
    }
}
