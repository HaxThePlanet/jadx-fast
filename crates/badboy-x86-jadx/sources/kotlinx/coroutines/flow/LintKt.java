package kotlinx.coroutines.flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0094\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\u0008\u0002\u001a\"\u0010\u000b\u001a\u00020\u000c*\u0006\u0012\u0002\u0008\u00030\u00022\u0010\u0008\u0002\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0007\u001a\u001e\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u0013H\u0007\u001am\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u00132D\u0008\u0008\u0010\u0015\u001a>\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00120\u0002\u0012\u0013\u0012\u00110\u0017¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\r\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0016¢\u0006\u0002\u0008\u001cH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001e\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u001fH\u0007\u001a!\u0010 \u001a\u00020!\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u0013H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u001e\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u001fH\u0007\u001a&\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010%\u001a\u00020\u0001H\u0007\u001af\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u00132\u0008\u0008\u0002\u0010'\u001a\u00020(23\u0008\n\u0010)\u001a-\u0008\u0001\u0012\u0013\u0012\u00110\u0017¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\r\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0*H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010+\u001a\u0082\u0001\u0010,\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u00132Y\u0008\u0008\u0010)\u001aS\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00120\u0002\u0012\u0013\u0012\u00110\u0017¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\r\u0012\u0013\u0012\u00110(¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(.\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0-¢\u0006\u0002\u0008\u001cH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010/\u001a'\u00100\u001a\u0008\u0012\u0004\u0012\u0002H\u001201\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u0013H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\"\u001a/\u00100\u001a\u000202\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u00132\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002H\u001204H\u0087Hø\u0001\u0000¢\u0006\u0002\u00105\u001a'\u00106\u001a\u0008\u0012\u0004\u0012\u0002H\u001207\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u0013H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\"\u001a/\u00106\u001a\u000202\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u00132\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002H\u001208H\u0087Hø\u0001\u0000¢\u0006\u0002\u00109\"\"\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\u0008*\u0006\u0012\u0002\u0008\u00030\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u0004\u001a\u0004\u0008\u0007\u0010\n\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006:", d2 = {"coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/flow/FlowCollector;", "getCoroutineContext$annotations", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "getCoroutineContext", "(Lkotlinx/coroutines/flow/FlowCollector;)Lkotlin/coroutines/CoroutineContext;", "isActive", "", "isActive$annotations", "(Lkotlinx/coroutines/flow/FlowCollector;)Z", "cancel", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancellable", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "catch", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "conflate", "Lkotlinx/coroutines/flow/StateFlow;", "count", "", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distinctUntilChanged", "flowOn", "context", "retry", "retries", "", "predicate", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/SharedFlow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "toList", "", "", "destination", "", "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LintKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @ReplaceWith(...))
    public static final void cancel(kotlinx.coroutines.flow.FlowCollector<?> $this$cancel, CancellationException cause) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static void cancel$default(kotlinx.coroutines.flow.FlowCollector flowCollector, CancellationException cancellationException2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        LintKt.cancel(flowCollector, obj1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> cancellable(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$cancellable) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith = @ReplaceWith(...))
    private static final <T> kotlinx.coroutines.flow.Flow<T> catch(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$catch, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNull($this$catch, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return FlowKt.catch((Flow)$this$catch, action);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> conflate(kotlinx.coroutines.flow.StateFlow<? extends T> $this$conflate) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    private static final <T> Object count(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$count, Continuation<? super Integer> $completion) {
        Intrinsics.checkNotNull($this$count, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        return FlowKt.count((Flow)$this$count, $completion);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> distinctUntilChanged(kotlinx.coroutines.flow.StateFlow<? extends T> $this$distinctUntilChanged) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOn(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$flowOn, CoroutineContext context) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final CoroutineContext getCoroutineContext(kotlinx.coroutines.flow.FlowCollector<?> $this$coroutineContext) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @ReplaceWith(...))
    public static void getCoroutineContext$annotations(kotlinx.coroutines.flow.FlowCollector flowCollector) {
    }

    public static final boolean isActive(kotlinx.coroutines.flow.FlowCollector<?> $this$isActive) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @ReplaceWith(...))
    public static void isActive$annotations(kotlinx.coroutines.flow.FlowCollector flowCollector) {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @ReplaceWith(...))
    private static final <T> kotlinx.coroutines.flow.Flow<T> retry(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$retry, long retries, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkNotNull($this$retry, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return FlowKt.retry((Flow)$this$retry, retries, predicate);
    }

    static kotlinx.coroutines.flow.Flow retry$default(kotlinx.coroutines.flow.SharedFlow $this$retry_u24default, long retries, Function2 predicate, int i4, Object object5) {
        long obj1;
        kotlinx.coroutines.flow.LintKt.retry.1 obj3;
        int obj4;
        int obj5;
        if (object5 & 1 != 0) {
            obj1 = Long.MAX_VALUE;
        }
        if (object5 &= 2 != 0) {
            obj4 = new LintKt.retry.1(0);
            obj3 = obj4;
        }
        Intrinsics.checkNotNull($this$retry_u24default, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return FlowKt.retry((Flow)$this$retry_u24default, obj1, predicate);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @ReplaceWith(...))
    private static final <T> kotlinx.coroutines.flow.Flow<T> retryWhen(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$retryWhen, Function4<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkNotNull($this$retryWhen, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return FlowKt.retryWhen((Flow)$this$retryWhen, predicate);
    }

    private static final <T> Object toList(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$toList, List<T> destination, Continuation<?> $completion) {
        Intrinsics.checkNotNull($this$toList, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        FlowKt.toList((Flow)$this$toList, destination, $completion);
        IllegalStateException illegalStateException = new IllegalStateException("this code is supposed to be unreachable");
        throw illegalStateException;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    private static final <T> Object toList(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$toList, Continuation<? super List<? extends T>> $completion) {
        Intrinsics.checkNotNull($this$toList, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        final int i = 0;
        return FlowKt.toList$default((Flow)$this$toList, i, $completion, 1, i);
    }

    private static final <T> Object toSet(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$toSet, Set<T> destination, Continuation<?> $completion) {
        Intrinsics.checkNotNull($this$toSet, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        FlowKt.toSet((Flow)$this$toSet, destination, $completion);
        IllegalStateException illegalStateException = new IllegalStateException("this code is supposed to be unreachable");
        throw illegalStateException;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    private static final <T> Object toSet(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$toSet, Continuation<? super Set<? extends T>> $completion) {
        Intrinsics.checkNotNull($this$toSet, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        final int i = 0;
        return FlowKt.toSet$default((Flow)$this$toSet, i, $completion, 1, i);
    }
}
