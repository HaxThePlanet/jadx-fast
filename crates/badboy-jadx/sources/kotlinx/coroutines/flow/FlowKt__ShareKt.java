package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.Channel.Factory;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u001c\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0006\u001a+\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0008\u000c\u001aM\u0010\r\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0002H\u0002¢\u0006\u0004\u0008\u0017\u0010\u0018\u001aA\u0010\u0019\u001a\u00020\u001a\"\u0004\u0008\u0000\u0010\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00050\u001cH\u0002¢\u0006\u0002\u0008\u001d\u001aS\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012-\u0010\u001f\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020!\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0006\u0012\u0004\u0018\u00010#0 ¢\u0006\u0002\u0008$ø\u0001\u0000¢\u0006\u0002\u0010%\u001a6\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u001a/\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)\u001a9\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0002¢\u0006\u0002\u0010*\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006+", d2 = {"asSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "T", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "asStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "configureSharing", "Lkotlinx/coroutines/flow/SharingConfig;", "Lkotlinx/coroutines/flow/Flow;", "replay", "", "configureSharing$FlowKt__ShareKt", "launchSharing", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "upstream", "shared", "started", "Lkotlinx/coroutines/flow/SharingStarted;", "initialValue", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "launchSharingDeferred", "", "result", "Lkotlinx/coroutines/CompletableDeferred;", "launchSharingDeferred$FlowKt__ShareKt", "onSubscription", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "shareIn", "scope", "stateIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ShareKt {
    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> asSharedFlow(kotlinx.coroutines.flow.MutableSharedFlow<T> $this$asSharedFlow) {
        ReadonlySharedFlow readonlySharedFlow = new ReadonlySharedFlow((SharedFlow)$this$asSharedFlow, 0);
        return (SharedFlow)readonlySharedFlow;
    }

    public static final <T> kotlinx.coroutines.flow.StateFlow<T> asStateFlow(kotlinx.coroutines.flow.MutableStateFlow<T> $this$asStateFlow) {
        ReadonlyStateFlow readonlyStateFlow = new ReadonlyStateFlow((StateFlow)$this$asStateFlow, 0);
        return (StateFlow)readonlyStateFlow;
    }

    private static final <T> kotlinx.coroutines.flow.SharingConfig<T> configureSharing$FlowKt__ShareKt(kotlinx.coroutines.flow.Flow<? extends T> $this$configureSharing, int replay) {
        int $i$a$AssertFlowKt__ShareKt$configureSharing$1;
        int capacity;
        boolean dropChannelOperators;
        BufferOverflow onBufferOverflow;
        BufferOverflow sUSPEND;
        int i3 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i = 0;
            $i$a$AssertFlowKt__ShareKt$configureSharing$1 = replay >= 0 ? capacity : i3;
            if ($i$a$AssertFlowKt__ShareKt$configureSharing$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        coerceAtLeast -= replay;
        dropChannelOperators = (ChannelFlow)$this$configureSharing.dropChannelOperators();
        if ($this$configureSharing instanceof ChannelFlow && dropChannelOperators != null) {
            dropChannelOperators = (ChannelFlow)$this$configureSharing.dropChannelOperators();
            if (dropChannelOperators != null) {
                if (/* condition */) {
                    if (obj6.onBufferOverflow == BufferOverflow.SUSPEND) {
                        capacity = obj.capacity == 0 ? i3 : i2;
                    } else {
                        if (replay == 0) {
                        } else {
                            capacity = i3;
                        }
                    }
                } else {
                    capacity = obj2.capacity;
                }
                super(dropChannelOperators, capacity, obj3.onBufferOverflow, obj7.context);
                return sharingConfig2;
            }
        }
        SharingConfig sharingConfig = new SharingConfig($this$configureSharing, i2, BufferOverflow.SUSPEND, (CoroutineContext)EmptyCoroutineContext.INSTANCE);
        return sharingConfig;
    }

    private static final <T> Job launchSharing$FlowKt__ShareKt(CoroutineScope $this$launchSharing, CoroutineContext context, kotlinx.coroutines.flow.Flow<? extends T> upstream, kotlinx.coroutines.flow.MutableSharedFlow<T> shared, kotlinx.coroutines.flow.SharingStarted started, T initialValue) {
        CoroutineStart uNDISPATCHED;
        uNDISPATCHED = Intrinsics.areEqual(started, SharingStarted.Companion.getEagerly()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED;
        FlowKt__ShareKt.launchSharing.1 anon = new FlowKt__ShareKt.launchSharing.1(started, upstream, shared, initialValue, 0);
        return BuildersKt.launch($this$launchSharing, context, uNDISPATCHED, (Function2)anon);
    }

    private static final <T> void launchSharingDeferred$FlowKt__ShareKt(CoroutineScope $this$launchSharingDeferred, CoroutineContext context, kotlinx.coroutines.flow.Flow<? extends T> upstream, CompletableDeferred<kotlinx.coroutines.flow.StateFlow<T>> result) {
        FlowKt__ShareKt.launchSharingDeferred.1 anon = new FlowKt__ShareKt.launchSharingDeferred.1(upstream, result, 0);
        BuildersKt.launch$default($this$launchSharingDeferred, context, 0, (Function2)anon, 2, 0);
    }

    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> onSubscription(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$onSubscription, Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        SubscribedSharedFlow subscribedSharedFlow = new SubscribedSharedFlow($this$onSubscription, action);
        return (SharedFlow)subscribedSharedFlow;
    }

    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> shareIn(kotlinx.coroutines.flow.Flow<? extends T> $this$shareIn, CoroutineScope scope, kotlinx.coroutines.flow.SharingStarted started, int replay) {
        final kotlinx.coroutines.flow.SharingConfig sharing$FlowKt__ShareKt = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt($this$shareIn, replay);
        final kotlinx.coroutines.flow.MutableSharedFlow mutableSharedFlow2 = SharedFlowKt.MutableSharedFlow(replay, sharing$FlowKt__ShareKt.extraBufferCapacity, sharing$FlowKt__ShareKt.onBufferOverflow);
        ReadonlySharedFlow obj11 = new ReadonlySharedFlow((SharedFlow)mutableSharedFlow2, FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(scope, sharing$FlowKt__ShareKt.context, sharing$FlowKt__ShareKt.upstream, mutableSharedFlow2, started, (Object)SharedFlowKt.NO_VALUE));
        return (SharedFlow)obj11;
    }

    public static kotlinx.coroutines.flow.SharedFlow shareIn$default(kotlinx.coroutines.flow.Flow flow, CoroutineScope coroutineScope2, kotlinx.coroutines.flow.SharingStarted sharingStarted3, int i4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return FlowKt.shareIn(flow, coroutineScope2, sharingStarted3, obj3);
    }

    public static final <T> Object stateIn(kotlinx.coroutines.flow.Flow<? extends T> $this$stateIn, CoroutineScope scope, Continuation<? super kotlinx.coroutines.flow.StateFlow<? extends T>> $completion) {
        int i = 1;
        final kotlinx.coroutines.flow.SharingConfig sharing$FlowKt__ShareKt = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt($this$stateIn, i);
        int i2 = 0;
        CompletableDeferred completableDeferred = CompletableDeferredKt.CompletableDeferred$default(i2, i, i2);
        FlowKt__ShareKt.launchSharingDeferred$FlowKt__ShareKt(scope, sharing$FlowKt__ShareKt.context, sharing$FlowKt__ShareKt.upstream, completableDeferred);
        return completableDeferred.await($completion);
    }

    public static final <T> kotlinx.coroutines.flow.StateFlow<T> stateIn(kotlinx.coroutines.flow.Flow<? extends T> $this$stateIn, CoroutineScope scope, kotlinx.coroutines.flow.SharingStarted started, T initialValue) {
        kotlinx.coroutines.flow.SharingConfig sharing$FlowKt__ShareKt = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt($this$stateIn, 1);
        final kotlinx.coroutines.flow.MutableStateFlow mutableStateFlow = StateFlowKt.MutableStateFlow(initialValue);
        ReadonlyStateFlow obj10 = new ReadonlyStateFlow((StateFlow)mutableStateFlow, FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(scope, sharing$FlowKt__ShareKt.context, sharing$FlowKt__ShareKt.upstream, (MutableSharedFlow)mutableStateFlow, started, initialValue));
        return (StateFlow)obj10;
    }
}
