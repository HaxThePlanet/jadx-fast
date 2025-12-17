package androidx.compose.runtime.internal;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"emptyThreadMap", "Landroidx/compose/runtime/internal/ThreadMap;", "getEmptyThreadMap", "()Landroidx/compose/runtime/internal/ThreadMap;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThreadMap_jvmKt {

    private static final androidx.compose.runtime.internal.ThreadMap emptyThreadMap;
    static {
        final int i = 0;
        int i2 = 0;
        ThreadMap threadMap = new ThreadMap(i, new long[i], new Object[i]);
        ThreadMap_jvmKt.emptyThreadMap = threadMap;
    }

    public static final androidx.compose.runtime.internal.ThreadMap getEmptyThreadMap() {
        return ThreadMap_jvmKt.emptyThreadMap;
    }
}
