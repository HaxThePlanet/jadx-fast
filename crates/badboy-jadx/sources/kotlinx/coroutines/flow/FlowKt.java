package kotlinx.coroutines.flow;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class FlowKt {

    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Iterable<? extends T> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Iterator<? extends T> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Function0<? extends T> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Function1<? super Continuation<? super T>, ? extends Object> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final kotlinx.coroutines.flow.Flow<Integer> asFlow(IntRange $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final kotlinx.coroutines.flow.Flow<Long> asFlow(LongRange $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Sequence<? extends T> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(BroadcastChannel<T> $this$asFlow) {
        return FlowKt__ChannelsKt.asFlow($this$asFlow);
    }

    public static final kotlinx.coroutines.flow.Flow<Integer> asFlow(int[] $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final kotlinx.coroutines.flow.Flow<Long> asFlow(long[] $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(T[] $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> asSharedFlow(kotlinx.coroutines.flow.MutableSharedFlow<T> $this$asSharedFlow) {
        return FlowKt__ShareKt.asSharedFlow($this$asSharedFlow);
    }

    public static final <T> kotlinx.coroutines.flow.StateFlow<T> asStateFlow(kotlinx.coroutines.flow.MutableStateFlow<T> $this$asStateFlow) {
        return FlowKt__ShareKt.asStateFlow($this$asStateFlow);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final kotlinx.coroutines.flow.Flow buffer(kotlinx.coroutines.flow.Flow $this$buffer, int capacity) {
        return FlowKt__ContextKt.buffer($this$buffer, capacity);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> buffer(kotlinx.coroutines.flow.Flow<? extends T> $this$buffer, int capacity, BufferOverflow onBufferOverflow) {
        return FlowKt__ContextKt.buffer($this$buffer, capacity, onBufferOverflow);
    }

    public static kotlinx.coroutines.flow.Flow buffer$default(kotlinx.coroutines.flow.Flow flow, int i2, int i3, Object object4) {
        return FlowKt__ContextKt.buffer$default(flow, i2, i3, object4);
    }

    public static kotlinx.coroutines.flow.Flow buffer$default(kotlinx.coroutines.flow.Flow flow, int i2, BufferOverflow bufferOverflow3, int i4, Object object5) {
        return FlowKt__ContextKt.buffer$default(flow, i2, bufferOverflow3, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> cache(kotlinx.coroutines.flow.Flow<? extends T> $this$cache) {
        return FlowKt__MigrationKt.cache($this$cache);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> callbackFlow(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return FlowKt__BuildersKt.callbackFlow(block);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> cancellable(kotlinx.coroutines.flow.Flow<? extends T> $this$cancellable) {
        return FlowKt__ContextKt.cancellable($this$cancellable);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> catch(kotlinx.coroutines.flow.Flow<? extends T> $this$catch, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__ErrorsKt.catch($this$catch, action);
    }

    public static final <T> Object catchImpl(kotlinx.coroutines.flow.Flow<? extends T> $this$catchImpl, kotlinx.coroutines.flow.FlowCollector<? super T> collector, Continuation<? super Throwable> $completion) {
        return FlowKt__ErrorsKt.catchImpl($this$catchImpl, collector, $completion);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> channelFlow(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return FlowKt__BuildersKt.channelFlow(block);
    }

    public static final Object collect(kotlinx.coroutines.flow.Flow<?> $this$collect, Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.collect($this$collect, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final <T> Object collect(kotlinx.coroutines.flow.Flow<? extends T> $this$collect, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.collect($this$collect, action, $completion);
    }

    public static final <T> Object collectIndexed(kotlinx.coroutines.flow.Flow<? extends T> $this$collectIndexed, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.collectIndexed($this$collectIndexed, action, $completion);
    }

    public static final <T> Object collectLatest(kotlinx.coroutines.flow.Flow<? extends T> $this$collectLatest, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.collectLatest($this$collectLatest, action, $completion);
    }

    public static final <T> Object collectWhile(kotlinx.coroutines.flow.Flow<? extends T> $this$collectWhile, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, Continuation<? super Unit> $completion) {
        return FlowKt__LimitKt.collectWhile($this$collectWhile, predicate, $completion);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> combine(Iterable<? extends kotlinx.coroutines.flow.Flow<? extends T>> flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__ZipKt.combine(flows, transform);
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__ZipKt.combine(flow, flow2, transform);
    }

    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, transform);
    }

    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, kotlinx.coroutines.flow.Flow<? extends T4> flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, transform);
    }

    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, kotlinx.coroutines.flow.Flow<? extends T4> flow4, kotlinx.coroutines.flow.Flow<? extends T5> flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, flow5, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T>[] flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__ZipKt.combine(flows, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(...))
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineLatest, kotlinx.coroutines.flow.Flow<? extends T2> other, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__MigrationKt.combineLatest($this$combineLatest, other, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(...))
    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineLatest, kotlinx.coroutines.flow.Flow<? extends T2> other, kotlinx.coroutines.flow.Flow<? extends T3> other2, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__MigrationKt.combineLatest($this$combineLatest, other, other2, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(...))
    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineLatest, kotlinx.coroutines.flow.Flow<? extends T2> other, kotlinx.coroutines.flow.Flow<? extends T3> other2, kotlinx.coroutines.flow.Flow<? extends T4> other3, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__MigrationKt.combineLatest($this$combineLatest, other, other2, other3, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(...))
    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineLatest, kotlinx.coroutines.flow.Flow<? extends T2> other, kotlinx.coroutines.flow.Flow<? extends T3> other2, kotlinx.coroutines.flow.Flow<? extends T4> other3, kotlinx.coroutines.flow.Flow<? extends T5> other4, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__MigrationKt.combineLatest($this$combineLatest, other, other2, other3, other4, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> combineTransform(Iterable<? extends kotlinx.coroutines.flow.Flow<? extends T>> flows, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__ZipKt.combineTransform(flows, transform);
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, Function4<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, transform);
    }

    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, Function5<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, transform);
    }

    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, kotlinx.coroutines.flow.Flow<? extends T4> flow4, Function6<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, transform);
    }

    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, kotlinx.coroutines.flow.Flow<? extends T4> flow4, kotlinx.coroutines.flow.Flow<? extends T5> flow5, Function7<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, flow5, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T>[] flows, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__ZipKt.combineTransform(flows, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> compose(kotlinx.coroutines.flow.Flow<? extends T> $this$compose, Function1<? super kotlinx.coroutines.flow.Flow<? extends T>, ? extends kotlinx.coroutines.flow.Flow<? extends R>> transformer) {
        return FlowKt__MigrationKt.compose($this$compose, transformer);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> concatMap(kotlinx.coroutines.flow.Flow<? extends T> $this$concatMap, Function1<? super T, ? extends kotlinx.coroutines.flow.Flow<? extends R>> mapper) {
        return FlowKt__MigrationKt.concatMap($this$concatMap, mapper);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> concatWith(kotlinx.coroutines.flow.Flow<? extends T> $this$concatWith, T value) {
        return FlowKt__MigrationKt.concatWith($this$concatWith, value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> concatWith(kotlinx.coroutines.flow.Flow<? extends T> $this$concatWith, kotlinx.coroutines.flow.Flow<? extends T> other) {
        return FlowKt__MigrationKt.concatWith($this$concatWith, other);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> conflate(kotlinx.coroutines.flow.Flow<? extends T> $this$conflate) {
        return FlowKt__ContextKt.conflate($this$conflate);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> consumeAsFlow(ReceiveChannel<? extends T> $this$consumeAsFlow) {
        return FlowKt__ChannelsKt.consumeAsFlow($this$consumeAsFlow);
    }

    public static final <T> Object count(kotlinx.coroutines.flow.Flow<? extends T> $this$count, Continuation<? super Integer> $completion) {
        return FlowKt__CountKt.count($this$count, $completion);
    }

    public static final <T> Object count(kotlinx.coroutines.flow.Flow<? extends T> $this$count, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, Continuation<? super Integer> $completion) {
        return FlowKt__CountKt.count($this$count, predicate, $completion);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> debounce(kotlinx.coroutines.flow.Flow<? extends T> $this$debounce, long timeoutMillis) {
        return FlowKt__DelayKt.debounce($this$debounce, timeoutMillis);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> debounce(kotlinx.coroutines.flow.Flow<? extends T> $this$debounce, Function1<? super T, Long> timeoutMillis) {
        return FlowKt__DelayKt.debounce($this$debounce, timeoutMillis);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> debounce-HG0u8IE(kotlinx.coroutines.flow.Flow<? extends T> $this$debounce_u2dHG0u8IE, long timeout) {
        return FlowKt__DelayKt.debounce-HG0u8IE($this$debounce_u2dHG0u8IE, timeout);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> debounceDuration(kotlinx.coroutines.flow.Flow<? extends T> $this$debounce, Function1<? super T, Duration> timeout) {
        return FlowKt__DelayKt.debounceDuration($this$debounce, timeout);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> delayEach(kotlinx.coroutines.flow.Flow<? extends T> $this$delayEach, long timeMillis) {
        return FlowKt__MigrationKt.delayEach($this$delayEach, timeMillis);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> delayFlow(kotlinx.coroutines.flow.Flow<? extends T> $this$delayFlow, long timeMillis) {
        return FlowKt__MigrationKt.delayFlow($this$delayFlow, timeMillis);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> distinctUntilChanged(kotlinx.coroutines.flow.Flow<? extends T> $this$distinctUntilChanged) {
        return FlowKt__DistinctKt.distinctUntilChanged($this$distinctUntilChanged);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> distinctUntilChanged(kotlinx.coroutines.flow.Flow<? extends T> $this$distinctUntilChanged, Function2<? super T, ? super T, Boolean> areEquivalent) {
        return FlowKt__DistinctKt.distinctUntilChanged($this$distinctUntilChanged, areEquivalent);
    }

    public static final <T, K> kotlinx.coroutines.flow.Flow<T> distinctUntilChangedBy(kotlinx.coroutines.flow.Flow<? extends T> $this$distinctUntilChangedBy, Function1<? super T, ? extends K> keySelector) {
        return FlowKt__DistinctKt.distinctUntilChangedBy($this$distinctUntilChangedBy, keySelector);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> drop(kotlinx.coroutines.flow.Flow<? extends T> $this$drop, int count) {
        return FlowKt__LimitKt.drop($this$drop, count);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> dropWhile(kotlinx.coroutines.flow.Flow<? extends T> $this$dropWhile, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__LimitKt.dropWhile($this$dropWhile, predicate);
    }

    public static final <T> Object emitAll(kotlinx.coroutines.flow.FlowCollector<? super T> $this$emitAll, ReceiveChannel<? extends T> channel, Continuation<? super Unit> $completion) {
        return FlowKt__ChannelsKt.emitAll($this$emitAll, channel, $completion);
    }

    public static final <T> Object emitAll(kotlinx.coroutines.flow.FlowCollector<? super T> $this$emitAll, kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.emitAll($this$emitAll, flow, $completion);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    public static final void ensureActive(kotlinx.coroutines.flow.FlowCollector<?> $this$ensureActive) {
        FlowKt__EmittersKt.ensureActive($this$ensureActive);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> filter(kotlinx.coroutines.flow.Flow<? extends T> $this$filter, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__TransformKt.filter($this$filter, predicate);
    }

    public static final <R> kotlinx.coroutines.flow.Flow<R> filterIsInstance(kotlinx.coroutines.flow.Flow<?> $this$filterIsInstance) {
        return FlowKt__TransformKt.filterIsInstance($this$filterIsInstance);
    }

    public static final <R> kotlinx.coroutines.flow.Flow<R> filterIsInstance(kotlinx.coroutines.flow.Flow<?> $this$filterIsInstance, KClass<R> klass) {
        return FlowKt__TransformKt.filterIsInstance($this$filterIsInstance, klass);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> filterNot(kotlinx.coroutines.flow.Flow<? extends T> $this$filterNot, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__TransformKt.filterNot($this$filterNot, predicate);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> filterNotNull(kotlinx.coroutines.flow.Flow<? extends T> $this$filterNotNull) {
        return FlowKt__TransformKt.filterNotNull($this$filterNotNull);
    }

    public static final <T> Object first(kotlinx.coroutines.flow.Flow<? extends T> $this$first, Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.first($this$first, $completion);
    }

    public static final <T> Object first(kotlinx.coroutines.flow.Flow<? extends T> $this$first, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.first($this$first, predicate, $completion);
    }

    public static final <T> Object firstOrNull(kotlinx.coroutines.flow.Flow<? extends T> $this$firstOrNull, Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.firstOrNull($this$firstOrNull, $completion);
    }

    public static final <T> Object firstOrNull(kotlinx.coroutines.flow.Flow<? extends T> $this$firstOrNull, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.firstOrNull($this$firstOrNull, predicate, $completion);
    }

    public static final ReceiveChannel<Unit> fixedPeriodTicker(CoroutineScope $this$fixedPeriodTicker, long delayMillis, long initialDelayMillis) {
        return FlowKt__DelayKt.fixedPeriodTicker($this$fixedPeriodTicker, delayMillis, initialDelayMillis);
    }

    public static ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long l2, long l3, int i4, Object object5) {
        return FlowKt__DelayKt.fixedPeriodTicker$default(coroutineScope, l2, l3, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMap(kotlinx.coroutines.flow.Flow<? extends T> $this$flatMap, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> mapper) {
        return FlowKt__MigrationKt.flatMap($this$flatMap, mapper);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapConcat(kotlinx.coroutines.flow.Flow<? extends T> $this$flatMapConcat, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> transform) {
        return FlowKt__MergeKt.flatMapConcat($this$flatMapConcat, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapLatest(kotlinx.coroutines.flow.Flow<? extends T> $this$flatMapLatest, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> transform) {
        return FlowKt__MergeKt.flatMapLatest($this$flatMapLatest, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapMerge(kotlinx.coroutines.flow.Flow<? extends T> $this$flatMapMerge, int concurrency, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> transform) {
        return FlowKt__MergeKt.flatMapMerge($this$flatMapMerge, concurrency, transform);
    }

    public static kotlinx.coroutines.flow.Flow flatMapMerge$default(kotlinx.coroutines.flow.Flow flow, int i2, Function2 function23, int i4, Object object5) {
        return FlowKt__MergeKt.flatMapMerge$default(flow, i2, function23, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> flatten(kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$flatten) {
        return FlowKt__MigrationKt.flatten($this$flatten);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flattenConcat(kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$flattenConcat) {
        return FlowKt__MergeKt.flattenConcat($this$flattenConcat);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flattenMerge(kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$flattenMerge, int concurrency) {
        return FlowKt__MergeKt.flattenMerge($this$flattenMerge, concurrency);
    }

    public static kotlinx.coroutines.flow.Flow flattenMerge$default(kotlinx.coroutines.flow.Flow flow, int i2, int i3, Object object4) {
        return FlowKt__MergeKt.flattenMerge$default(flow, i2, i3, object4);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flow(Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return FlowKt__BuildersKt.flow(block);
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> flowCombine(kotlinx.coroutines.flow.Flow<? extends T1> $this$combine, kotlinx.coroutines.flow.Flow<? extends T2> flow, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__ZipKt.flowCombine($this$combine, flow, transform);
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> flowCombineTransform(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineTransform, kotlinx.coroutines.flow.Flow<? extends T2> flow, Function4<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__ZipKt.flowCombineTransform($this$combineTransform, flow, transform);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOf(T value) {
        return FlowKt__BuildersKt.flowOf(value);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOf(T... elements) {
        return FlowKt__BuildersKt.flowOf(elements);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOn(kotlinx.coroutines.flow.Flow<? extends T> $this$flowOn, CoroutineContext context) {
        return FlowKt__ContextKt.flowOn($this$flowOn, context);
    }

    public static final <T, R> Object fold(kotlinx.coroutines.flow.Flow<? extends T> $this$fold, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation, Continuation<? super R> $completion) {
        return FlowKt__ReduceKt.fold($this$fold, initial, operation, $completion);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(...))
    public static final <T> void forEach(kotlinx.coroutines.flow.Flow<? extends T> $this$forEach, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        FlowKt__MigrationKt.forEach($this$forEach, action);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }

    public static void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
        FlowKt__MergeKt.getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations();
    }

    public static final <T> Object last(kotlinx.coroutines.flow.Flow<? extends T> $this$last, Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.last($this$last, $completion);
    }

    public static final <T> Object lastOrNull(kotlinx.coroutines.flow.Flow<? extends T> $this$lastOrNull, Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.lastOrNull($this$lastOrNull, $completion);
    }

    public static final <T> Job launchIn(kotlinx.coroutines.flow.Flow<? extends T> $this$launchIn, CoroutineScope scope) {
        return FlowKt__CollectKt.launchIn($this$launchIn, scope);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> map(kotlinx.coroutines.flow.Flow<? extends T> $this$map, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__TransformKt.map($this$map, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> mapLatest(kotlinx.coroutines.flow.Flow<? extends T> $this$mapLatest, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__MergeKt.mapLatest($this$mapLatest, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> mapNotNull(kotlinx.coroutines.flow.Flow<? extends T> $this$mapNotNull, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__TransformKt.mapNotNull($this$mapNotNull, transform);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(Iterable<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$merge) {
        return FlowKt__MergeKt.merge($this$merge);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$merge) {
        return FlowKt__MigrationKt.merge($this$merge);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(kotlinx.coroutines.flow.Flow<? extends T>... flows) {
        return FlowKt__MergeKt.merge(flows);
    }

    public static final Void noImpl() {
        return FlowKt__MigrationKt.noImpl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> kotlinx.coroutines.flow.Flow<T> observeOn(kotlinx.coroutines.flow.Flow<? extends T> $this$observeOn, CoroutineContext context) {
        return FlowKt__MigrationKt.observeOn($this$observeOn, context);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> onCompletion(kotlinx.coroutines.flow.Flow<? extends T> $this$onCompletion, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__EmittersKt.onCompletion($this$onCompletion, action);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> onEach(kotlinx.coroutines.flow.Flow<? extends T> $this$onEach, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__TransformKt.onEach($this$onEach, action);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> onEmpty(kotlinx.coroutines.flow.Flow<? extends T> $this$onEmpty, Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__EmittersKt.onEmpty($this$onEmpty, action);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorResume(kotlinx.coroutines.flow.Flow<? extends T> $this$onErrorResume, kotlinx.coroutines.flow.Flow<? extends T> fallback) {
        return FlowKt__MigrationKt.onErrorResume($this$onErrorResume, fallback);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorResumeNext(kotlinx.coroutines.flow.Flow<? extends T> $this$onErrorResumeNext, kotlinx.coroutines.flow.Flow<? extends T> fallback) {
        return FlowKt__MigrationKt.onErrorResumeNext($this$onErrorResumeNext, fallback);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorReturn(kotlinx.coroutines.flow.Flow<? extends T> $this$onErrorReturn, T fallback) {
        return FlowKt__MigrationKt.onErrorReturn($this$onErrorReturn, fallback);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorReturn(kotlinx.coroutines.flow.Flow<? extends T> $this$onErrorReturn, T fallback, Function1<? super Throwable, Boolean> predicate) {
        return FlowKt__MigrationKt.onErrorReturn($this$onErrorReturn, fallback, predicate);
    }

    public static kotlinx.coroutines.flow.Flow onErrorReturn$default(kotlinx.coroutines.flow.Flow flow, Object object2, Function1 function13, int i4, Object object5) {
        return FlowKt__MigrationKt.onErrorReturn$default(flow, object2, function13, i4, object5);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> onStart(kotlinx.coroutines.flow.Flow<? extends T> $this$onStart, Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__EmittersKt.onStart($this$onStart, action);
    }

    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> onSubscription(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$onSubscription, Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__ShareKt.onSubscription($this$onSubscription, action);
    }

    public static final <T> ReceiveChannel<T> produceIn(kotlinx.coroutines.flow.Flow<? extends T> $this$produceIn, CoroutineScope scope) {
        return FlowKt__ChannelsKt.produceIn($this$produceIn, scope);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> publish(kotlinx.coroutines.flow.Flow<? extends T> $this$publish) {
        return FlowKt__MigrationKt.publish($this$publish);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> publish(kotlinx.coroutines.flow.Flow<? extends T> $this$publish, int bufferSize) {
        return FlowKt__MigrationKt.publish($this$publish, bufferSize);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> kotlinx.coroutines.flow.Flow<T> publishOn(kotlinx.coroutines.flow.Flow<? extends T> $this$publishOn, CoroutineContext context) {
        return FlowKt__MigrationKt.publishOn($this$publishOn, context);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> receiveAsFlow(ReceiveChannel<? extends T> $this$receiveAsFlow) {
        return FlowKt__ChannelsKt.receiveAsFlow($this$receiveAsFlow);
    }

    public static final <S, T extends S> Object reduce(kotlinx.coroutines.flow.Flow<? extends T> $this$reduce, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> operation, Continuation<? super S> $completion) {
        return FlowKt__ReduceKt.reduce($this$reduce, operation, $completion);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> replay(kotlinx.coroutines.flow.Flow<? extends T> $this$replay) {
        return FlowKt__MigrationKt.replay($this$replay);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> replay(kotlinx.coroutines.flow.Flow<? extends T> $this$replay, int bufferSize) {
        return FlowKt__MigrationKt.replay($this$replay, bufferSize);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> retry(kotlinx.coroutines.flow.Flow<? extends T> $this$retry, long retries, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__ErrorsKt.retry($this$retry, retries, predicate);
    }

    public static kotlinx.coroutines.flow.Flow retry$default(kotlinx.coroutines.flow.Flow flow, long l2, Function2 function23, int i4, Object object5) {
        return FlowKt__ErrorsKt.retry$default(flow, l2, function23, i4, object5);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> retryWhen(kotlinx.coroutines.flow.Flow<? extends T> $this$retryWhen, Function4<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__ErrorsKt.retryWhen($this$retryWhen, predicate);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> runningFold(kotlinx.coroutines.flow.Flow<? extends T> $this$runningFold, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        return FlowKt__TransformKt.runningFold($this$runningFold, initial, operation);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> runningReduce(kotlinx.coroutines.flow.Flow<? extends T> $this$runningReduce, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        return FlowKt__TransformKt.runningReduce($this$runningReduce, operation);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> sample(kotlinx.coroutines.flow.Flow<? extends T> $this$sample, long periodMillis) {
        return FlowKt__DelayKt.sample($this$sample, periodMillis);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> sample-HG0u8IE(kotlinx.coroutines.flow.Flow<? extends T> $this$sample_u2dHG0u8IE, long period) {
        return FlowKt__DelayKt.sample-HG0u8IE($this$sample_u2dHG0u8IE, period);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> scan(kotlinx.coroutines.flow.Flow<? extends T> $this$scan, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        return FlowKt__TransformKt.scan($this$scan, initial, operation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> scanFold(kotlinx.coroutines.flow.Flow<? extends T> $this$scanFold, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        return FlowKt__MigrationKt.scanFold($this$scanFold, initial, operation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> scanReduce(kotlinx.coroutines.flow.Flow<? extends T> $this$scanReduce, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        return FlowKt__MigrationKt.scanReduce($this$scanReduce, operation);
    }

    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> shareIn(kotlinx.coroutines.flow.Flow<? extends T> $this$shareIn, CoroutineScope scope, kotlinx.coroutines.flow.SharingStarted started, int replay) {
        return FlowKt__ShareKt.shareIn($this$shareIn, scope, started, replay);
    }

    public static kotlinx.coroutines.flow.SharedFlow shareIn$default(kotlinx.coroutines.flow.Flow flow, CoroutineScope coroutineScope2, kotlinx.coroutines.flow.SharingStarted sharingStarted3, int i4, int i5, Object object6) {
        return FlowKt__ShareKt.shareIn$default(flow, coroutineScope2, sharingStarted3, i4, i5, object6);
    }

    public static final <T> Object single(kotlinx.coroutines.flow.Flow<? extends T> $this$single, Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.single($this$single, $completion);
    }

    public static final <T> Object singleOrNull(kotlinx.coroutines.flow.Flow<? extends T> $this$singleOrNull, Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.singleOrNull($this$singleOrNull, $completion);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> skip(kotlinx.coroutines.flow.Flow<? extends T> $this$skip, int count) {
        return FlowKt__MigrationKt.skip($this$skip, count);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> startWith(kotlinx.coroutines.flow.Flow<? extends T> $this$startWith, T value) {
        return FlowKt__MigrationKt.startWith($this$startWith, value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> startWith(kotlinx.coroutines.flow.Flow<? extends T> $this$startWith, kotlinx.coroutines.flow.Flow<? extends T> other) {
        return FlowKt__MigrationKt.startWith($this$startWith, other);
    }

    public static final <T> Object stateIn(kotlinx.coroutines.flow.Flow<? extends T> $this$stateIn, CoroutineScope scope, Continuation<? super kotlinx.coroutines.flow.StateFlow<? extends T>> $completion) {
        return FlowKt__ShareKt.stateIn($this$stateIn, scope, $completion);
    }

    public static final <T> kotlinx.coroutines.flow.StateFlow<T> stateIn(kotlinx.coroutines.flow.Flow<? extends T> $this$stateIn, CoroutineScope scope, kotlinx.coroutines.flow.SharingStarted started, T initialValue) {
        return FlowKt__ShareKt.stateIn($this$stateIn, scope, started, initialValue);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(kotlinx.coroutines.flow.Flow<? extends T> $this$subscribe) {
        FlowKt__MigrationKt.subscribe($this$subscribe);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(kotlinx.coroutines.flow.Flow<? extends T> $this$subscribe, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onEach) {
        FlowKt__MigrationKt.subscribe($this$subscribe, onEach);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(kotlinx.coroutines.flow.Flow<? extends T> $this$subscribe, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onEach, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> onError) {
        FlowKt__MigrationKt.subscribe($this$subscribe, onEach, onError);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    public static final <T> kotlinx.coroutines.flow.Flow<T> subscribeOn(kotlinx.coroutines.flow.Flow<? extends T> $this$subscribeOn, CoroutineContext context) {
        return FlowKt__MigrationKt.subscribeOn($this$subscribeOn, context);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> switchMap(kotlinx.coroutines.flow.Flow<? extends T> $this$switchMap, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> transform) {
        return FlowKt__MigrationKt.switchMap($this$switchMap, transform);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> take(kotlinx.coroutines.flow.Flow<? extends T> $this$take, int count) {
        return FlowKt__LimitKt.take($this$take, count);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> takeWhile(kotlinx.coroutines.flow.Flow<? extends T> $this$takeWhile, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__LimitKt.takeWhile($this$takeWhile, predicate);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> timeout-HG0u8IE(kotlinx.coroutines.flow.Flow<? extends T> $this$timeout_u2dHG0u8IE, long timeout) {
        return FlowKt__DelayKt.timeout-HG0u8IE($this$timeout_u2dHG0u8IE, timeout);
    }

    public static final <T, C extends java.util.Collection<? super T>> Object toCollection(kotlinx.coroutines.flow.Flow<? extends T> $this$toCollection, C destination, Continuation<? super C> $completion) {
        return FlowKt__CollectionKt.toCollection($this$toCollection, destination, $completion);
    }

    public static final <T> Object toList(kotlinx.coroutines.flow.Flow<? extends T> $this$toList, List<T> destination, Continuation<? super List<? extends T>> $completion) {
        return FlowKt__CollectionKt.toList($this$toList, destination, $completion);
    }

    public static Object toList$default(kotlinx.coroutines.flow.Flow flow, List list2, Continuation continuation3, int i4, Object object5) {
        return FlowKt__CollectionKt.toList$default(flow, list2, continuation3, i4, object5);
    }

    public static final <T> Object toSet(kotlinx.coroutines.flow.Flow<? extends T> $this$toSet, Set<T> destination, Continuation<? super Set<? extends T>> $completion) {
        return FlowKt__CollectionKt.toSet($this$toSet, destination, $completion);
    }

    public static Object toSet$default(kotlinx.coroutines.flow.Flow flow, Set set2, Continuation continuation3, int i4, Object object5) {
        return FlowKt__CollectionKt.toSet$default(flow, set2, continuation3, i4, object5);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transform(kotlinx.coroutines.flow.Flow<? extends T> $this$transform, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__EmittersKt.transform($this$transform, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transformLatest(kotlinx.coroutines.flow.Flow<? extends T> $this$transformLatest, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__MergeKt.transformLatest($this$transformLatest, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transformWhile(kotlinx.coroutines.flow.Flow<? extends T> $this$transformWhile, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> transform) {
        return FlowKt__LimitKt.transformWhile($this$transformWhile, transform);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> unsafeTransform(kotlinx.coroutines.flow.Flow<? extends T> $this$unsafeTransform, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform) {
        return FlowKt__EmittersKt.unsafeTransform($this$unsafeTransform, transform);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<IndexedValue<T>> withIndex(kotlinx.coroutines.flow.Flow<? extends T> $this$withIndex) {
        return FlowKt__TransformKt.withIndex($this$withIndex);
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> zip(kotlinx.coroutines.flow.Flow<? extends T1> $this$zip, kotlinx.coroutines.flow.Flow<? extends T2> other, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt__ZipKt.zip($this$zip, other, transform);
    }
}
