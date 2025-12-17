package androidx.compose.runtime;

import android.os.Trace;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001¨\u0006\t", d2 = {"Landroidx/compose/runtime/Trace;", "", "()V", "beginSection", "name", "", "endSection", "", "token", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Trace {

    public static final int $stable;
    public static final androidx.compose.runtime.Trace INSTANCE;
    static {
        Trace trace = new Trace();
        Trace.INSTANCE = trace;
    }

    public final Object beginSection(String name) {
        Trace.beginSection(name);
        return null;
    }

    public final void endSection(Object token) {
        Trace.endSection();
    }
}
