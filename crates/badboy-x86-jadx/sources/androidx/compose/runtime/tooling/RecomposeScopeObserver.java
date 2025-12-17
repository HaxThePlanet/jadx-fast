package androidx.compose.runtime.tooling;

import androidx.compose.runtime.RecomposeScope;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008g\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0008À\u0006\u0001", d2 = {"Landroidx/compose/runtime/tooling/RecomposeScopeObserver;", "", "onBeginScopeComposition", "", "scope", "Landroidx/compose/runtime/RecomposeScope;", "onEndScopeComposition", "onScopeDisposed", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RecomposeScopeObserver {
    public abstract void onBeginScopeComposition(RecomposeScope recomposeScope);

    public abstract void onEndScopeComposition(RecomposeScope recomposeScope);

    public abstract void onScopeDisposed(RecomposeScope recomposeScope);
}
