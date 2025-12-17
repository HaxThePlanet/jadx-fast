package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000T\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a7\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\u0008\u0000\u0010\u000b2\u001e\u0010\u000c\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\n0\r\"\u0008\u0012\u0004\u0012\u0002H\u000b0\n¢\u0006\u0002\u0010\u000e\u001ae\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u000b0\n27\u0010\u0011\u001a3\u0008\u0001\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ah\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u000b0\n29\u0008\u0005\u0010\u0011\u001a3\u0008\u0001\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ao\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u000b0\n2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000127\u0010\u0011\u001a3\u0008\u0001\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a$\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\u0008\u0000\u0010\u000b*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\n0\nH\u0007\u001a.\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\u0008\u0000\u0010\u000b*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\n0\n2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0001H\u0007\u001aa\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u000b0\n23\u0008\u0001\u0010\u0011\u001a-\u0008\u0001\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\"\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\u0008\u0000\u0010\u000b*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\n0 \u001ar\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u000b0\n2D\u0008\u0001\u0010\u0011\u001a>\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100#\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020$0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\"¢\u0006\u0002\u0008%H\u0007ø\u0001\u0000¢\u0006\u0002\u0010&\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\u0003\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006'", d2 = {"DEFAULT_CONCURRENCY", "", "getDEFAULT_CONCURRENCY$annotations", "()V", "getDEFAULT_CONCURRENCY", "()I", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "merge", "Lkotlinx/coroutines/flow/Flow;", "T", "flows", "", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flatMapConcat", "R", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "flatMapMerge", "concurrency", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "flattenMerge", "mapLatest", "", "transformLatest", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__MergeKt {

    private static final int DEFAULT_CONCURRENCY;
    static {
        FlowKt__MergeKt.DEFAULT_CONCURRENCY = SystemPropsKt.systemProp("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapConcat(kotlinx.coroutines.flow.Flow<? extends T> $this$flatMapConcat, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> transform) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        FlowKt__MergeKt.flatMapConcat$$inlined.map.1 anon = new FlowKt__MergeKt.flatMapConcat$$inlined.map.1($this$flatMapConcat, transform);
        return FlowKt.flattenConcat((Flow)anon);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapLatest(kotlinx.coroutines.flow.Flow<? extends T> $this$flatMapLatest, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> transform) {
        final int i = 0;
        FlowKt__MergeKt.flatMapLatest.1 anon = new FlowKt__MergeKt.flatMapLatest.1(transform, 0);
        return FlowKt.transformLatest($this$flatMapLatest, (Function3)anon);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapMerge(kotlinx.coroutines.flow.Flow<? extends T> $this$flatMapMerge, int concurrency, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> transform) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        FlowKt__MergeKt.flatMapMerge$$inlined.map.1 anon = new FlowKt__MergeKt.flatMapMerge$$inlined.map.1($this$flatMapMerge, transform);
        return FlowKt.flattenMerge((Flow)anon, concurrency);
    }

    public static kotlinx.coroutines.flow.Flow flatMapMerge$default(kotlinx.coroutines.flow.Flow flow, int i2, Function2 function23, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        }
        return FlowKt.flatMapMerge(flow, obj1, function23);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flattenConcat(kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$flattenConcat) {
        final int i = 0;
        FlowKt__MergeKt.flattenConcat$$inlined.unsafeFlow.1 anon = new FlowKt__MergeKt.flattenConcat$$inlined.unsafeFlow.1($this$flattenConcat);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flattenMerge(kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$flattenMerge, int concurrency) {
        kotlinx.coroutines.flow.Flow flattenConcat;
        int channelFlowMerge;
        kotlinx.coroutines.flow.Flow flow;
        int i3;
        int i2;
        int i;
        int i4;
        int i5;
        int i6;
        int i7 = 1;
        channelFlowMerge = concurrency > 0 ? i7 : 0;
        if (channelFlowMerge == 0) {
        } else {
            if (concurrency == i7) {
                flattenConcat = FlowKt.flattenConcat($this$flattenMerge);
                flow = $this$flattenMerge;
                i3 = concurrency;
            } else {
                channelFlowMerge = new ChannelFlowMerge($this$flattenMerge, concurrency, 0, 0, 0, 28, 0);
                flattenConcat = channelFlowMerge;
            }
            return flattenConcat;
        }
        kotlinx.coroutines.flow.Flow $this$flattenMerge2 = $this$flattenMerge;
        int obj9 = 0;
        StringBuilder obj10 = new StringBuilder();
        obj10 = new IllegalArgumentException(obj10.append("Expected positive concurrency level, but had ").append(concurrency).toString().toString());
        throw obj10;
    }

    public static kotlinx.coroutines.flow.Flow flattenMerge$default(kotlinx.coroutines.flow.Flow flow, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        }
        return FlowKt.flattenMerge(flow, obj1);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.DEFAULT_CONCURRENCY;
    }

    public static void getDEFAULT_CONCURRENCY$annotations() {
    }

    public static void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> mapLatest(kotlinx.coroutines.flow.Flow<? extends T> $this$mapLatest, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        FlowKt__MergeKt.mapLatest.1 anon = new FlowKt__MergeKt.mapLatest.1(transform, 0);
        return FlowKt.transformLatest($this$mapLatest, (Function3)anon);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(Iterable<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$merge) {
        ChannelLimitedFlowMerge channelLimitedFlowMerge = new ChannelLimitedFlowMerge($this$merge, 0, 0, 0, 14, 0);
        return (Flow)channelLimitedFlowMerge;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(kotlinx.coroutines.flow.Flow<? extends T>... flows) {
        return FlowKt.merge(ArraysKt.asIterable(flows));
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transformLatest(kotlinx.coroutines.flow.Flow<? extends T> $this$transformLatest, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform) {
        ChannelFlowTransformLatest channelFlowTransformLatest = new ChannelFlowTransformLatest(transform, $this$transformLatest, 0, 0, 0, 28, 0);
        return (Flow)channelFlowTransformLatest;
    }
}
