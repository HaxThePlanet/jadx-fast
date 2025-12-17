package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.RecomposeScope;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0008\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t0\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/tooling/CompositionObserver;", "", "onBeginComposition", "", "composition", "Landroidx/compose/runtime/Composition;", "invalidationMap", "", "Landroidx/compose/runtime/RecomposeScope;", "", "onEndComposition", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CompositionObserver {
    public abstract void onBeginComposition(Composition composition, Map<RecomposeScope, ? extends Set<? extends Object>> map2);

    public abstract void onEndComposition(Composition composition);
}
