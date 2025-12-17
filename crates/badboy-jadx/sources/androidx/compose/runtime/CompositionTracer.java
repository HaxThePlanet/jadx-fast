package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008g\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000cH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\rÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/CompositionTracer;", "", "isTraceInProgress", "", "traceEventEnd", "", "traceEventStart", "key", "", "dirty1", "dirty2", "info", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CompositionTracer {
    public abstract boolean isTraceInProgress();

    public abstract void traceEventEnd();

    public abstract void traceEventStart(int i, int i2, int i3, String string4);
}
