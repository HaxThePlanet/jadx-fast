package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&J\u0008\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0006À\u0006\u0001", d2 = {"Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "", "onDeactivate", "", "onRelease", "onReuse", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ComposeNodeLifecycleCallback {
    public abstract void onDeactivate();

    public abstract void onRelease();

    public abstract void onReuse();
}
