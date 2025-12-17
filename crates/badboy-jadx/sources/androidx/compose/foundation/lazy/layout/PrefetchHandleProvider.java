package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.collection.MutableObjectLongMap;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0018", d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "executor", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "createNestedPrefetchRequest", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "createNestedPrefetchRequest-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrefetch-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "HandleAndRequestImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrefetchHandleProvider {

    public static final int $stable = 8;
    private final androidx.compose.foundation.lazy.layout.PrefetchScheduler executor;
    private final androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory itemContentFactory;
    private final SubcomposeLayoutState subcomposeLayoutState;

    @Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u0019H\u0016J\u0008\u0010\u001b\u001a\u00020\u0019H\u0002J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u000c\u0018\u00010\u0014R\u00060\u0000R\u00020\u0015H\u0002J\u0008\u0010 \u001a\u00020!H\u0016J\u000c\u0010\"\u001a\u00020\u000c*\u00020#H\u0016J\u0014\u0010$\u001a\u00020\u000c*\u00020#2\u0006\u0010%\u001a\u00020&H\u0002R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000fR\u0018\u0010\u0013\u001a\u000c\u0018\u00010\u0014R\u00060\u0000R\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006(", d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "hasResolvedNestedPrefetches", "", "isCanceled", "isComposed", "()Z", "isMeasured", "isUrgent", "isValid", "nestedPrefetchController", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "cancel", "", "markAsUrgent", "performComposition", "performMeasure", "performMeasure-BRTryo0", "(J)V", "resolveNestedPrefetchStates", "toString", "", "execute", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "shouldExecute", "average", "", "NestedPrefetchController", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class HandleAndRequestImpl implements androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle, androidx.compose.foundation.lazy.layout.PrefetchRequest {

        private final long constraints;
        private boolean hasResolvedNestedPrefetches;
        private final int index;
        private boolean isCanceled;
        private boolean isMeasured;
        private boolean isUrgent;
        private androidx.compose.foundation.lazy.layout.PrefetchHandleProvider.HandleAndRequestImpl.NestedPrefetchController nestedPrefetchController;
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
        private final androidx.compose.foundation.lazy.layout.PrefetchMetrics prefetchMetrics;
        final androidx.compose.foundation.lazy.layout.PrefetchHandleProvider this$0;
        private HandleAndRequestImpl(androidx.compose.foundation.lazy.layout.PrefetchHandleProvider this$0, int index, long constraints, androidx.compose.foundation.lazy.layout.PrefetchMetrics prefetchMetrics) {
            this.this$0 = this$0;
            super();
            this.index = index;
            this.constraints = constraints;
            this.prefetchMetrics = obj5;
        }

        public HandleAndRequestImpl(androidx.compose.foundation.lazy.layout.PrefetchHandleProvider prefetchHandleProvider, int i2, long l3, androidx.compose.foundation.lazy.layout.PrefetchMetrics prefetchMetrics4, DefaultConstructorMarker defaultConstructorMarker5) {
            super(prefetchHandleProvider, i2, l3, prefetchMetrics4, defaultConstructorMarker5);
        }

        public static final boolean access$isCanceled$p(androidx.compose.foundation.lazy.layout.PrefetchHandleProvider.HandleAndRequestImpl $this) {
            return $this.isCanceled;
        }

        private final boolean isComposed() {
            int i;
            i = this.precomposeHandle != null ? 1 : 0;
            return i;
        }

        private final boolean isValid() {
            boolean isCanceled;
            int i;
            int index;
            int i2;
            if (!this.isCanceled) {
                index = this.index;
                i2 = 1;
                if (index >= 0 && index < (LazyLayoutItemProvider)PrefetchHandleProvider.access$getItemContentFactory$p(this.this$0).getItemProvider().invoke().getItemCount()) {
                    isCanceled = index < (LazyLayoutItemProvider)PrefetchHandleProvider.access$getItemContentFactory$p(this.this$0).getItemProvider().invoke().getItemCount() ? i2 : i;
                } else {
                }
                if (isCanceled != 0) {
                    i = i2;
                } else {
                }
            } else {
            }
            return i;
        }

        private final void performComposition() {
            int i;
            if (!isValid()) {
            } else {
                i = this.precomposeHandle == null ? 1 : 0;
                if (i == 0) {
                } else {
                    Object invoke = PrefetchHandleProvider.access$getItemContentFactory$p(this.this$0).getItemProvider().invoke();
                    Object key = (LazyLayoutItemProvider)invoke.getKey(this.index);
                    this.precomposeHandle = PrefetchHandleProvider.access$getSubcomposeLayoutState$p(this.this$0).precompose(key, PrefetchHandleProvider.access$getItemContentFactory$p(this.this$0).getContent(this.index, key, invoke.getContentType(this.index)));
                }
                int itemProvider = 0;
                IllegalArgumentException $i$a$RequirePrefetchHandleProvider$HandleAndRequestImpl$performComposition$2 = new IllegalArgumentException("Request was already composed!".toString());
                throw $i$a$RequirePrefetchHandleProvider$HandleAndRequestImpl$performComposition$2;
            }
            int i2 = 0;
            IllegalArgumentException $i$a$RequirePrefetchHandleProvider$HandleAndRequestImpl$performComposition$1 = new IllegalArgumentException("Callers should check whether the request is still valid before calling performComposition()".toString());
            throw $i$a$RequirePrefetchHandleProvider$HandleAndRequestImpl$performComposition$1;
        }

        private final void performMeasure-BRTryo0(long constraints) {
            int i;
            int i2;
            int i3;
            if (this.isCanceled) {
            } else {
                if (this.isMeasured) {
                } else {
                    this.isMeasured = true;
                    SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle = this.precomposeHandle;
                    if (precomposeHandle == null) {
                    } else {
                        i = 0;
                        while (i < precomposeHandle.getPlaceablesCount()) {
                            i3 = 0;
                            precomposeHandle.premeasure-0kLqBqw(i, constraints);
                            i++;
                        }
                    }
                    int handle = 0;
                    IllegalArgumentException $i$a$RequireNotNullPrefetchHandleProvider$HandleAndRequestImpl$performMeasure$handle$1 = new IllegalArgumentException("performComposition() must be called before performMeasure()".toString());
                    throw $i$a$RequireNotNullPrefetchHandleProvider$HandleAndRequestImpl$performMeasure$handle$1;
                }
                int i6 = 0;
                IllegalArgumentException $i$a$RequirePrefetchHandleProvider$HandleAndRequestImpl$performMeasure$2 = new IllegalArgumentException("Request was already measured!".toString());
                throw $i$a$RequirePrefetchHandleProvider$HandleAndRequestImpl$performMeasure$2;
            }
            int i4 = 0;
            IllegalArgumentException $i$a$RequirePrefetchHandleProvider$HandleAndRequestImpl$performMeasure$1 = new IllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()".toString());
            throw $i$a$RequirePrefetchHandleProvider$HandleAndRequestImpl$performMeasure$1;
        }

        private final androidx.compose.foundation.lazy.layout.PrefetchHandleProvider.HandleAndRequestImpl.NestedPrefetchController resolveNestedPrefetchStates() {
            String str;
            int nestedPrefetchController;
            SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle = this.precomposeHandle;
            if (precomposeHandle == null) {
            } else {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                PrefetchHandleProvider.HandleAndRequestImpl.resolveNestedPrefetchStates.1 anon = new PrefetchHandleProvider.HandleAndRequestImpl.resolveNestedPrefetchStates.1(objectRef);
                precomposeHandle.traverseDescendants("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", (Function1)anon);
                Object element = objectRef.element;
                if ((List)element != null) {
                    str = 0;
                    nestedPrefetchController = new PrefetchHandleProvider.HandleAndRequestImpl.NestedPrefetchController(this, (List)element);
                } else {
                    nestedPrefetchController = 0;
                }
                return nestedPrefetchController;
            }
            int precomposedSlotHandle = 0;
            IllegalArgumentException $i$a$RequireNotNullPrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$precomposedSlotHandle$1 = new IllegalArgumentException("Should precompose before resolving nested prefetch states".toString());
            throw $i$a$RequireNotNullPrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$precomposedSlotHandle$1;
        }

        private final boolean shouldExecute(androidx.compose.foundation.lazy.layout.PrefetchRequestScope $this$shouldExecute, long average) {
            int isUrgent;
            int i;
            final long availableTimeNanos = $this$shouldExecute.availableTimeNanos();
            if (this.isUrgent) {
                if (Long.compare(availableTimeNanos, i2) <= 0) {
                    i = Long.compare(average, availableTimeNanos) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle
        public void cancel() {
            boolean isCanceled;
            this.isCanceled = true;
            SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle = this.precomposeHandle;
            if (!this.isCanceled && precomposeHandle != null) {
                this.isCanceled = true;
                precomposeHandle = this.precomposeHandle;
                if (precomposeHandle != null) {
                    precomposeHandle.dispose();
                }
                this.precomposeHandle = 0;
            }
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle
        public boolean execute(androidx.compose.foundation.lazy.layout.PrefetchRequestScope $this$execute) {
            boolean $i$a$TracePrefetchHandleProvider$HandleAndRequestImpl$execute$1$1;
            Object averageCompositionTimeNanosByContentType;
            boolean $this$execute_u24lambda_u243;
            boolean hasMoreWork;
            Object averageMeasureTimeNanosByContentType;
            boolean $i$a$TracePrefetchHandleProvider$HandleAndRequestImpl$execute$2;
            int i;
            long averageMeasureTimeNanos;
            long l3;
            long prefetchMetrics2;
            long averageCompositionTimeNanos;
            int i2;
            long l;
            androidx.compose.foundation.lazy.layout.PrefetchMetrics prefetchMetrics;
            int i6;
            int $i$f$measureNanoTime;
            long nanoTime;
            int averageMeasureTimeNanosByContentType2;
            MutableObjectLongMap averageCompositionTimeNanosByContentType2;
            Object obj;
            String str;
            int i3;
            long i4;
            int i5;
            int i7;
            long l2;
            final Object obj2 = this;
            final androidx.compose.foundation.lazy.layout.PrefetchRequestScope request = $this$execute;
            i = 0;
            if (!obj2.isValid()) {
                return i;
            }
            Object contentType = (LazyLayoutItemProvider)PrefetchHandleProvider.access$getItemContentFactory$p(obj2.this$0).getItemProvider().invoke().getContentType(obj2.index);
            averageMeasureTimeNanos = 0;
            if (!obj2.isComposed()) {
                if (contentType != null && obj2.prefetchMetrics.getAverageCompositionTimeNanosByContentType().contains(contentType)) {
                    if (obj2.prefetchMetrics.getAverageCompositionTimeNanosByContentType().contains(contentType)) {
                        averageCompositionTimeNanos = obj2.prefetchMetrics.getAverageCompositionTimeNanosByContentType().get(contentType);
                    } else {
                        averageCompositionTimeNanos = obj2.prefetchMetrics.getAverageCompositionTimeNanos();
                    }
                } else {
                }
                if (obj2.shouldExecute(request, averageCompositionTimeNanos)) {
                    prefetchMetrics = obj2.prefetchMetrics;
                    i6 = 0;
                    int i11 = 0;
                    nanoTime = System.nanoTime();
                    int i12 = 0;
                    i4 = 0;
                    Trace.beginSection("compose:lazy:prefetch:compose");
                    int i8 = 0;
                    obj2.performComposition();
                    $i$a$TracePrefetchHandleProvider$HandleAndRequestImpl$execute$1$1 = Unit.INSTANCE;
                    Trace.endSection();
                    $i$f$measureNanoTime = averageCompositionTimeNanosByContentType2;
                    if (contentType != null) {
                        $i$a$TracePrefetchHandleProvider$HandleAndRequestImpl$execute$1$1 = contentType;
                        averageMeasureTimeNanosByContentType2 = 0;
                        i5 = averageMeasureTimeNanos;
                        l2 = averageCompositionTimeNanos;
                        i7 = 1;
                        prefetchMetrics.getAverageCompositionTimeNanosByContentType().set(contentType, PrefetchMetrics.access$calculateAverageTime(prefetchMetrics, $i$f$measureNanoTime, nanoTime));
                    } else {
                        i5 = averageMeasureTimeNanos;
                        l2 = averageCompositionTimeNanos;
                        i7 = 1;
                    }
                    PrefetchMetrics.access$setAverageCompositionTimeNanos$p(prefetchMetrics, PrefetchMetrics.access$calculateAverageTime(prefetchMetrics, $i$f$measureNanoTime, nanoTime));
                    if (!obj2.isUrgent && !obj2.hasResolvedNestedPrefetches && Long.compare(availableTimeNanos, i5) > 0) {
                        if (!obj2.hasResolvedNestedPrefetches) {
                            if (Long.compare(availableTimeNanos, i5) > 0) {
                                l3 = 0;
                                Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                                int i10 = 0;
                                obj2.nestedPrefetchController = obj2.resolveNestedPrefetchStates();
                                obj2.hasResolvedNestedPrefetches = i7;
                                $i$a$TracePrefetchHandleProvider$HandleAndRequestImpl$execute$2 = Unit.INSTANCE;
                                Trace.endSection();
                            }
                            return 1;
                        }
                        androidx.compose.foundation.lazy.layout.PrefetchHandleProvider.HandleAndRequestImpl.NestedPrefetchController nestedPrefetchController = obj2.nestedPrefetchController;
                        if (nestedPrefetchController != null) {
                            averageMeasureTimeNanos = 0;
                            $this$execute_u24lambda_u243 = nestedPrefetchController.executeNestedPrefetches(request);
                        } else {
                            $this$execute_u24lambda_u243 = i;
                        }
                        if ($this$execute_u24lambda_u243) {
                            return 1;
                        }
                    }
                    if (!obj2.isMeasured && !Constraints.isZero-impl(obj2.constraints)) {
                        if (!Constraints.isZero-impl(obj2.constraints)) {
                            if (contentType != null && obj2.prefetchMetrics.getAverageMeasureTimeNanosByContentType().contains(contentType)) {
                                if (obj2.prefetchMetrics.getAverageMeasureTimeNanosByContentType().contains(contentType)) {
                                    averageMeasureTimeNanos = obj2.prefetchMetrics.getAverageMeasureTimeNanosByContentType().get(contentType);
                                } else {
                                    averageMeasureTimeNanos = obj2.prefetchMetrics.getAverageMeasureTimeNanos();
                                }
                            } else {
                            }
                            prefetchMetrics2 = obj2.prefetchMetrics;
                            averageCompositionTimeNanos = 0;
                            i2 = 0;
                            nanoTime = "compose:lazy:prefetch:measure";
                            averageMeasureTimeNanosByContentType2 = 0;
                            Trace.beginSection(nanoTime);
                            int i9 = 0;
                            i3 = i;
                            obj = contentType;
                            obj2.performMeasure-BRTryo0(obj2.constraints);
                            hasMoreWork = Unit.INSTANCE;
                            Trace.endSection();
                            nanoTime2 -= prefetchMetrics;
                            if (obj2.shouldExecute(request, averageMeasureTimeNanos) && obj != null) {
                                prefetchMetrics2 = obj2.prefetchMetrics;
                                averageCompositionTimeNanos = 0;
                                i2 = 0;
                                nanoTime = "compose:lazy:prefetch:measure";
                                averageMeasureTimeNanosByContentType2 = 0;
                                Trace.beginSection(nanoTime);
                                i9 = 0;
                                i3 = i;
                                obj = contentType;
                                obj2.performMeasure-BRTryo0(obj2.constraints);
                                hasMoreWork = Unit.INSTANCE;
                                Trace.endSection();
                                nanoTime2 -= prefetchMetrics;
                                if (obj != null) {
                                    hasMoreWork = obj;
                                    i2 = 0;
                                    i6 = i5;
                                    prefetchMetrics2.getAverageMeasureTimeNanosByContentType().set(obj, PrefetchMetrics.access$calculateAverageTime(prefetchMetrics2, i, contentType));
                                }
                                PrefetchMetrics.access$setAverageMeasureTimeNanos$p(prefetchMetrics2, PrefetchMetrics.access$calculateAverageTime(prefetchMetrics2, i, contentType));
                                return i3;
                            }
                            return 1;
                        }
                    }
                    i3 = i;
                    obj = contentType;
                }
                return 1;
            }
            i5 = averageMeasureTimeNanos;
            i7 = 1;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle
        public void markAsUrgent() {
            this.isUrgent = true;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("HandleAndRequestImpl { index = ").append(this.index).append(", constraints = ").append(Constraints.toString-impl(this.constraints)).append(", isComposed = ").append(isComposed()).append(", isMeasured = ").append(this.isMeasured).append(", isCanceled = ").append(this.isCanceled).append(" }").toString();
        }
    }
    static {
        final int i = 8;
    }

    public PrefetchHandleProvider(androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory itemContentFactory, SubcomposeLayoutState subcomposeLayoutState, androidx.compose.foundation.lazy.layout.PrefetchScheduler executor) {
        super();
        this.itemContentFactory = itemContentFactory;
        this.subcomposeLayoutState = subcomposeLayoutState;
        this.executor = executor;
    }

    public static final androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory access$getItemContentFactory$p(androidx.compose.foundation.lazy.layout.PrefetchHandleProvider $this) {
        return $this.itemContentFactory;
    }

    public static final SubcomposeLayoutState access$getSubcomposeLayoutState$p(androidx.compose.foundation.lazy.layout.PrefetchHandleProvider $this) {
        return $this.subcomposeLayoutState;
    }

    public final androidx.compose.foundation.lazy.layout.PrefetchRequest createNestedPrefetchRequest-VKLhPVY(int index, long constraints, androidx.compose.foundation.lazy.layout.PrefetchMetrics prefetchMetrics) {
        PrefetchHandleProvider.HandleAndRequestImpl handleAndRequestImpl = new PrefetchHandleProvider.HandleAndRequestImpl(this, index, constraints, obj4, obj11, 0);
        return (PrefetchRequest)handleAndRequestImpl;
    }

    public final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch-VKLhPVY(int index, long constraints, androidx.compose.foundation.lazy.layout.PrefetchMetrics prefetchMetrics) {
        final androidx.compose.foundation.lazy.layout.PrefetchHandleProvider prefetchHandleProvider = this;
        PrefetchHandleProvider.HandleAndRequestImpl handleAndRequestImpl = new PrefetchHandleProvider.HandleAndRequestImpl(prefetchHandleProvider, index, constraints, obj4, obj11, 0);
        final int obj9 = 0;
        prefetchHandleProvider.executor.schedulePrefetch((PrefetchRequest)handleAndRequestImpl);
        return (LazyLayoutPrefetchState.PrefetchHandle)handleAndRequestImpl;
    }
}
