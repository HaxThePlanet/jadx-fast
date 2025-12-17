package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u001aM\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012$\u0008\u0004\u0010\u0003\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0008\u001a\u001f\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0001\"\u0006\u0008\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\u0008\u00030\u0001H\u0086\u0008\u001a,\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0001\"\u0008\u0008\u0000\u0010\n*\u00020\u0007*\u0006\u0012\u0002\u0008\u00030\u00012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000c\u001aM\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012$\u0008\u0004\u0010\u0003\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0008\u001a\"\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\u001ab\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0008\u0012\u0004\u0012\u0002H\u00020\u000123\u0008\u0004\u0010\u0010\u001a-\u0008\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0008\u001ah\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0008\u0008\u0001\u0010\n*\u00020\u0007*\u0008\u0012\u0004\u0012\u0002H\u00020\u000125\u0008\u0004\u0010\u0010\u001a/\u0008\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0008\u001aH\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0016\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0008\u001a|\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0019\u001a\u0002H\n2H\u0008\u0001\u0010\u001a\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\n¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001bø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001al\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012F\u0010\u001a\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a|\u0010 \u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0019\u001a\u0002H\n2H\u0008\u0001\u0010\u001a\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\n¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001bø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\"\u0010!\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\"0\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006#", d2 = {"filter", "Lkotlinx/coroutines/flow/Flow;", "T", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "filterIsInstance", "R", "klass", "Lkotlin/reflect/KClass;", "filterNot", "filterNotNull", "map", "transform", "Lkotlin/ParameterName;", "name", "value", "mapNotNull", "onEach", "action", "", "runningFold", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "runningReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "scan", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__TransformKt {
    public static final <T> kotlinx.coroutines.flow.Flow<T> filter(kotlinx.coroutines.flow.Flow<? extends T> $this$filter, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        FlowKt__TransformKt.filter$$inlined.unsafeTransform.1 anon = new FlowKt__TransformKt.filter$$inlined.unsafeTransform.1($this$filter, predicate);
        return (Flow)anon;
    }

    public static final <R> kotlinx.coroutines.flow.Flow<R> filterIsInstance(kotlinx.coroutines.flow.Flow<?> $this$filterIsInstance) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        Intrinsics.needClassReification();
        FlowKt__TransformKt.filterIsInstance$$inlined.filter.1 anon = new FlowKt__TransformKt.filterIsInstance$$inlined.filter.1($this$filterIsInstance);
        return (Flow)anon;
    }

    public static final <R> kotlinx.coroutines.flow.Flow<R> filterIsInstance(kotlinx.coroutines.flow.Flow<?> $this$filterIsInstance, KClass<R> klass) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        FlowKt__TransformKt.filterIsInstance$$inlined.filter.2 anon = new FlowKt__TransformKt.filterIsInstance$$inlined.filter.2($this$filterIsInstance, klass);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> filterNot(kotlinx.coroutines.flow.Flow<? extends T> $this$filterNot, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        FlowKt__TransformKt.filterNot$$inlined.unsafeTransform.1 anon = new FlowKt__TransformKt.filterNot$$inlined.unsafeTransform.1($this$filterNot, predicate);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> filterNotNull(kotlinx.coroutines.flow.Flow<? extends T> $this$filterNotNull) {
        final int i = 0;
        final int i2 = 0;
        FlowKt__TransformKt.filterNotNull$$inlined.unsafeTransform.1 anon = new FlowKt__TransformKt.filterNotNull$$inlined.unsafeTransform.1($this$filterNotNull);
        return (Flow)anon;
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> map(kotlinx.coroutines.flow.Flow<? extends T> $this$map, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        FlowKt__TransformKt.map$$inlined.unsafeTransform.1 anon = new FlowKt__TransformKt.map$$inlined.unsafeTransform.1($this$map, transform);
        return (Flow)anon;
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> mapNotNull(kotlinx.coroutines.flow.Flow<? extends T> $this$mapNotNull, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        FlowKt__TransformKt.mapNotNull$$inlined.unsafeTransform.1 anon = new FlowKt__TransformKt.mapNotNull$$inlined.unsafeTransform.1($this$mapNotNull, transform);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> onEach(kotlinx.coroutines.flow.Flow<? extends T> $this$onEach, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        final int i = 0;
        final int i2 = 0;
        FlowKt__TransformKt.onEach$$inlined.unsafeTransform.1 anon = new FlowKt__TransformKt.onEach$$inlined.unsafeTransform.1($this$onEach, action);
        return (Flow)anon;
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> runningFold(kotlinx.coroutines.flow.Flow<? extends T> $this$runningFold, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        final int i = 0;
        FlowKt__TransformKt.runningFold$$inlined.unsafeFlow.1 anon = new FlowKt__TransformKt.runningFold$$inlined.unsafeFlow.1(initial, $this$runningFold, operation);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> runningReduce(kotlinx.coroutines.flow.Flow<? extends T> $this$runningReduce, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        final int i = 0;
        FlowKt__TransformKt.runningReduce$$inlined.unsafeFlow.1 anon = new FlowKt__TransformKt.runningReduce$$inlined.unsafeFlow.1($this$runningReduce, operation);
        return (Flow)anon;
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> scan(kotlinx.coroutines.flow.Flow<? extends T> $this$scan, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        return FlowKt.runningFold($this$scan, initial, operation);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<IndexedValue<T>> withIndex(kotlinx.coroutines.flow.Flow<? extends T> $this$withIndex) {
        final int i = 0;
        FlowKt__TransformKt.withIndex$$inlined.unsafeFlow.1 anon = new FlowKt__TransformKt.withIndex$$inlined.unsafeFlow.1($this$withIndex);
        return (Flow)anon;
    }
}
