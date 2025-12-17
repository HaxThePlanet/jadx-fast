package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J(\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0016\u0010\u000e\u001a\u00020\u00032\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0011À\u0006\u0001", d2 = {"Landroidx/compose/runtime/RememberManager;", "", "deactivating", "", "instance", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "endRelativeOrder", "", "priority", "endRelativeAfter", "forgetting", "Landroidx/compose/runtime/RememberObserver;", "releasing", "remembering", "sideEffect", "effect", "Lkotlin/Function0;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RememberManager {
    public abstract void deactivating(androidx.compose.runtime.ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i2, int i3, int i4);

    public abstract void forgetting(androidx.compose.runtime.RememberObserver rememberObserver, int i2, int i3, int i4);

    public abstract void releasing(androidx.compose.runtime.ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i2, int i3, int i4);

    public abstract void remembering(androidx.compose.runtime.RememberObserver rememberObserver);

    public abstract void sideEffect(Function0<Unit> function0);
}
