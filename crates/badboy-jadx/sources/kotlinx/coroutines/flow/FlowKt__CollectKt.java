package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.NopCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u000223\u0008\u0004\u0010\u0005\u001a-\u0008\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u000c\u001ak\u0010\r\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00022H\u0008\u0004\u0010\u0005\u001aB\u0008\u0001\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u0010\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000eH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001aT\u0010\u0012\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u000221\u0010\u0005\u001a-\u0008\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000c\u001a/\u0010\u0013\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\u0018\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00022\u0006\u0010\u0019\u001a\u00020\u001a\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"collect", "", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectIndexed", "Lkotlin/Function3;", "", "index", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectLatest", "emitAll", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchIn", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CollectKt {
    public static final Object collect(kotlinx.coroutines.flow.Flow<?> $this$collect, Continuation<? super Unit> $completion) {
        Object collect = $this$collect.collect((FlowCollector)NopCollector.INSTANCE, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final <T> Object collect(kotlinx.coroutines.flow.Flow<? extends T> $this$collect, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        final int i = 0;
        FlowKt__CollectKt.collect.3 anon = new FlowKt__CollectKt.collect.3(action);
        Object collect = $this$collect.collect((FlowCollector)anon, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    private static final <T> Object collect$$forInline(kotlinx.coroutines.flow.Flow<? extends T> $this$collect, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        final int i = 0;
        FlowKt__CollectKt.collect.3 anon = new FlowKt__CollectKt.collect.3(action);
        $this$collect.collect((FlowCollector)anon, $completion);
        return Unit.INSTANCE;
    }

    public static final <T> Object collectIndexed(kotlinx.coroutines.flow.Flow<? extends T> $this$collectIndexed, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        final int i = 0;
        FlowKt__CollectKt.collectIndexed.2 anon = new FlowKt__CollectKt.collectIndexed.2(action);
        Object collect = $this$collectIndexed.collect((FlowCollector)anon, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    private static final <T> Object collectIndexed$$forInline(kotlinx.coroutines.flow.Flow<? extends T> $this$collectIndexed, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        final int i = 0;
        FlowKt__CollectKt.collectIndexed.2 anon = new FlowKt__CollectKt.collectIndexed.2(action);
        $this$collectIndexed.collect((FlowCollector)anon, $completion);
        return Unit.INSTANCE;
    }

    public static final <T> Object collectLatest(kotlinx.coroutines.flow.Flow<? extends T> $this$collectLatest, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        int i = 0;
        Object collect = FlowKt.collect(FlowKt.buffer$default(FlowKt.mapLatest($this$collectLatest, action), 0, i, 2, i), $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    public static final <T> Object emitAll(kotlinx.coroutines.flow.FlowCollector<? super T> $this$emitAll, kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super Unit> $completion) {
        FlowKt.ensureActive($this$emitAll);
        Object collect = flow.collect($this$emitAll, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    public static final <T> Job launchIn(kotlinx.coroutines.flow.Flow<? extends T> $this$launchIn, CoroutineScope scope) {
        FlowKt__CollectKt.launchIn.1 anon = new FlowKt__CollectKt.launchIn.1($this$launchIn, 0);
        return BuildersKt.launch$default(scope, 0, 0, (Function2)anon, 3, 0);
    }
}
