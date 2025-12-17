package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001:\u0002 !B.\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001b\u0008\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015H\u0000¢\u0006\u0002\u0008\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fR!\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0008\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "onNestedPrefetch", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "prefetchHandleProvider", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "getPrefetchHandleProvider$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "setPrefetchHandleProvider$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;)V", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "getPrefetchScheduler$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "collectNestedPrefetchRequests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "collectNestedPrefetchRequests$foundation_release", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "NestedPrefetchScopeImpl", "PrefetchHandle", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutPrefetchState {

    public static final int $stable;
    private final Function1<androidx.compose.foundation.lazy.layout.NestedPrefetchScope, Unit> onNestedPrefetch;
    private androidx.compose.foundation.lazy.layout.PrefetchHandleProvider prefetchHandleProvider;
    private final androidx.compose.foundation.lazy.layout.PrefetchMetrics prefetchMetrics;
    private final androidx.compose.foundation.lazy.layout.PrefetchScheduler prefetchScheduler;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&\u0082\u0001\u0002\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", "cancel", "", "markAsUrgent", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PrefetchHandle {
        public abstract void cancel();

        public abstract void markAsUrgent();
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$NestedPrefetchScopeImpl;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "_requests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "requests", "", "getRequests", "()Ljava/util/List;", "schedulePrefetch", "", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class NestedPrefetchScopeImpl implements androidx.compose.foundation.lazy.layout.NestedPrefetchScope {

        private final List<androidx.compose.foundation.lazy.layout.PrefetchRequest> _requests;
        final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState this$0;
        public NestedPrefetchScopeImpl(androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState this$0) {
            this.this$0 = this$0;
            super();
            ArrayList arrayList = new ArrayList();
            this._requests = (List)arrayList;
        }

        public final List<androidx.compose.foundation.lazy.layout.PrefetchRequest> getRequests() {
            return this._requests;
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public void schedulePrefetch(int index) {
            schedulePrefetch-0kLqBqw(index, LazyLayoutPrefetchStateKt.access$getZeroConstraints$p());
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public void schedulePrefetch-0kLqBqw(int index, long constraints) {
            androidx.compose.foundation.lazy.layout.PrefetchHandleProvider prefetchHandleProvider$foundation_release = this.this$0.getPrefetchHandleProvider$foundation_release();
            if (prefetchHandleProvider$foundation_release == null) {
            }
            this._requests.add(prefetchHandleProvider$foundation_release.createNestedPrefetchRequest-VKLhPVY(index, constraints, obj6));
        }
    }
    static {
    }

    public LazyLayoutPrefetchState() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public LazyLayoutPrefetchState(androidx.compose.foundation.lazy.layout.PrefetchScheduler prefetchScheduler, Function1<? super androidx.compose.foundation.lazy.layout.NestedPrefetchScope, Unit> onNestedPrefetch) {
        super();
        this.prefetchScheduler = prefetchScheduler;
        this.onNestedPrefetch = onNestedPrefetch;
        PrefetchMetrics prefetchMetrics = new PrefetchMetrics();
        this.prefetchMetrics = prefetchMetrics;
    }

    public LazyLayoutPrefetchState(androidx.compose.foundation.lazy.layout.PrefetchScheduler prefetchScheduler, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        int obj3;
        final int i = 0;
        obj2 = i3 & 1 != 0 ? i : obj2;
        obj3 = i3 &= 2 != 0 ? i : obj3;
        super(obj2, obj3);
    }

    public static final androidx.compose.foundation.lazy.layout.PrefetchMetrics access$getPrefetchMetrics$p(androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState $this) {
        return $this.prefetchMetrics;
    }

    public final List<androidx.compose.foundation.lazy.layout.PrefetchRequest> collectNestedPrefetchRequests$foundation_release() {
        Function1 onNestedPrefetch = this.onNestedPrefetch;
        if (onNestedPrefetch == null) {
            return CollectionsKt.emptyList();
        }
        LazyLayoutPrefetchState.NestedPrefetchScopeImpl nestedPrefetchScopeImpl = new LazyLayoutPrefetchState.NestedPrefetchScopeImpl(this);
        final int i = 0;
        onNestedPrefetch.invoke(nestedPrefetchScopeImpl);
        return nestedPrefetchScopeImpl.getRequests();
    }

    public final androidx.compose.foundation.lazy.layout.PrefetchHandleProvider getPrefetchHandleProvider$foundation_release() {
        return this.prefetchHandleProvider;
    }

    public final androidx.compose.foundation.lazy.layout.PrefetchScheduler getPrefetchScheduler$foundation_release() {
        return this.prefetchScheduler;
    }

    public final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch(int index) {
        return schedulePrefetch-0kLqBqw(index, LazyLayoutPrefetchStateKt.access$getZeroConstraints$p());
    }

    public final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch-0kLqBqw(int index, long constraints) {
        androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle prefetchHandleProvider;
        androidx.compose.foundation.lazy.layout.PrefetchMetrics prefetchMetrics;
        prefetchHandleProvider = this.prefetchHandleProvider;
        if (prefetchHandleProvider != null) {
            if (prefetchHandleProvider.schedulePrefetch-VKLhPVY(index, constraints, obj5) == null) {
                prefetchHandleProvider = DummyHandle.INSTANCE;
            }
        } else {
        }
        return prefetchHandleProvider;
    }

    public final void setPrefetchHandleProvider$foundation_release(androidx.compose.foundation.lazy.layout.PrefetchHandleProvider <set-?>) {
        this.prefetchHandleProvider = <set-?>;
    }
}
