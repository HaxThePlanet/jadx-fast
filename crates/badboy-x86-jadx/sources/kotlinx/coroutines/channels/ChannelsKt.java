package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class ChannelsKt {

    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object any(kotlinx.coroutines.channels.ReceiveChannel $this$any, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.any($this$any, $completion);
    }

    public static final void cancelConsumed(kotlinx.coroutines.channels.ReceiveChannel<?> $this$cancelConsumed, Throwable cause) {
        ChannelsKt__Channels_commonKt.cancelConsumed($this$cancelConsumed, cause);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(kotlinx.coroutines.channels.BroadcastChannel<E> $this$consume, Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> block) {
        return ChannelsKt__Channels_commonKt.consume($this$consume, block);
    }

    public static final <E, R> R consume(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$consume, Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> block) {
        return ChannelsKt__Channels_commonKt.consume($this$consume, block);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object consumeEach(kotlinx.coroutines.channels.BroadcastChannel<E> $this$consumeEach, Function1<? super E, Unit> action, Continuation<? super Unit> $completion) {
        return ChannelsKt__Channels_commonKt.consumeEach($this$consumeEach, action, $completion);
    }

    public static final <E> Object consumeEach(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$consumeEach, Function1<? super E, Unit> action, Continuation<? super Unit> $completion) {
        return ChannelsKt__Channels_commonKt.consumeEach($this$consumeEach, action, $completion);
    }

    public static final Function1<Throwable, Unit> consumes(kotlinx.coroutines.channels.ReceiveChannel<?> $this$consumes) {
        return ChannelsKt__DeprecatedKt.consumes($this$consumes);
    }

    public static final Function1<Throwable, Unit> consumesAll(kotlinx.coroutines.channels.ReceiveChannel<?>... channels) {
        return ChannelsKt__DeprecatedKt.consumesAll(channels);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object count(kotlinx.coroutines.channels.ReceiveChannel $this$count, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.count($this$count, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel distinct(kotlinx.coroutines.channels.ReceiveChannel $this$distinct) {
        return ChannelsKt__DeprecatedKt.distinct($this$distinct);
    }

    public static final <E, K> kotlinx.coroutines.channels.ReceiveChannel<E> distinctBy(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$distinctBy, CoroutineContext context, Function2<? super E, ? super Continuation<? super K>, ? extends Object> selector) {
        return ChannelsKt__DeprecatedKt.distinctBy($this$distinctBy, context, selector);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel distinctBy$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.distinctBy$default(receiveChannel, coroutineContext2, function23, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel drop(kotlinx.coroutines.channels.ReceiveChannel $this$drop, int n, CoroutineContext context) {
        return ChannelsKt__DeprecatedKt.drop($this$drop, n, context);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel drop$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i2, CoroutineContext coroutineContext3, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.drop$default(receiveChannel, i2, coroutineContext3, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel dropWhile(kotlinx.coroutines.channels.ReceiveChannel $this$dropWhile, CoroutineContext context, Function2 predicate) {
        return ChannelsKt__DeprecatedKt.dropWhile($this$dropWhile, context, predicate);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel dropWhile$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.dropWhile$default(receiveChannel, coroutineContext2, function23, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object elementAt(kotlinx.coroutines.channels.ReceiveChannel $this$elementAt, int index, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.elementAt($this$elementAt, index, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object elementAtOrNull(kotlinx.coroutines.channels.ReceiveChannel $this$elementAtOrNull, int index, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.elementAtOrNull($this$elementAtOrNull, index, $completion);
    }

    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> filter(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$filter, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return ChannelsKt__DeprecatedKt.filter($this$filter, context, predicate);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel filter$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.filter$default(receiveChannel, coroutineContext2, function23, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel filterIndexed(kotlinx.coroutines.channels.ReceiveChannel $this$filterIndexed, CoroutineContext context, Function3 predicate) {
        return ChannelsKt__DeprecatedKt.filterIndexed($this$filterIndexed, context, predicate);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel filterIndexed$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function3 function33, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.filterIndexed$default(receiveChannel, coroutineContext2, function33, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel filterNot(kotlinx.coroutines.channels.ReceiveChannel $this$filterNot, CoroutineContext context, Function2 predicate) {
        return ChannelsKt__DeprecatedKt.filterNot($this$filterNot, context, predicate);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel filterNot$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.filterNot$default(receiveChannel, coroutineContext2, function23, i4, object5);
    }

    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> filterNotNull(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$filterNotNull) {
        return ChannelsKt__DeprecatedKt.filterNotNull($this$filterNotNull);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel $this$filterNotNullTo, Collection destination, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo($this$filterNotNullTo, destination, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel $this$filterNotNullTo, kotlinx.coroutines.channels.SendChannel destination, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo($this$filterNotNullTo, destination, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object first(kotlinx.coroutines.channels.ReceiveChannel $this$first, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.first($this$first, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object firstOrNull(kotlinx.coroutines.channels.ReceiveChannel $this$firstOrNull, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.firstOrNull($this$firstOrNull, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel flatMap(kotlinx.coroutines.channels.ReceiveChannel $this$flatMap, CoroutineContext context, Function2 transform) {
        return ChannelsKt__DeprecatedKt.flatMap($this$flatMap, context, transform);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel flatMap$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.flatMap$default(receiveChannel, coroutineContext2, function23, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object indexOf(kotlinx.coroutines.channels.ReceiveChannel $this$indexOf, Object element, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.indexOf($this$indexOf, element, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object last(kotlinx.coroutines.channels.ReceiveChannel $this$last, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.last($this$last, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object lastIndexOf(kotlinx.coroutines.channels.ReceiveChannel $this$lastIndexOf, Object element, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.lastIndexOf($this$lastIndexOf, element, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object lastOrNull(kotlinx.coroutines.channels.ReceiveChannel $this$lastOrNull, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.lastOrNull($this$lastOrNull, $completion);
    }

    public static final <E, R> kotlinx.coroutines.channels.ReceiveChannel<R> map(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$map, CoroutineContext context, Function2<? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        return ChannelsKt__DeprecatedKt.map($this$map, context, transform);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel map$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.map$default(receiveChannel, coroutineContext2, function23, i4, object5);
    }

    public static final <E, R> kotlinx.coroutines.channels.ReceiveChannel<R> mapIndexed(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$mapIndexed, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        return ChannelsKt__DeprecatedKt.mapIndexed($this$mapIndexed, context, transform);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel mapIndexed$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function3 function33, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.mapIndexed$default(receiveChannel, coroutineContext2, function33, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel mapIndexedNotNull(kotlinx.coroutines.channels.ReceiveChannel $this$mapIndexedNotNull, CoroutineContext context, Function3 transform) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull($this$mapIndexedNotNull, context, transform);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel mapIndexedNotNull$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function3 function33, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull$default(receiveChannel, coroutineContext2, function33, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel mapNotNull(kotlinx.coroutines.channels.ReceiveChannel $this$mapNotNull, CoroutineContext context, Function2 transform) {
        return ChannelsKt__DeprecatedKt.mapNotNull($this$mapNotNull, context, transform);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel mapNotNull$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.mapNotNull$default(receiveChannel, coroutineContext2, function23, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object maxWith(kotlinx.coroutines.channels.ReceiveChannel $this$maxWith, Comparator comparator, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.maxWith($this$maxWith, comparator, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object minWith(kotlinx.coroutines.channels.ReceiveChannel $this$minWith, Comparator comparator, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.minWith($this$minWith, comparator, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object none(kotlinx.coroutines.channels.ReceiveChannel $this$none, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.none($this$none, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final SelectClause1 onReceiveOrNull(kotlinx.coroutines.channels.ReceiveChannel $this$onReceiveOrNull) {
        return ChannelsKt__Channels_commonKt.onReceiveOrNull($this$onReceiveOrNull);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(...))
    public static final Object receiveOrNull(kotlinx.coroutines.channels.ReceiveChannel $this$receiveOrNull, Continuation $completion) {
        return ChannelsKt__Channels_commonKt.receiveOrNull($this$receiveOrNull, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left for binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel requireNoNulls(kotlinx.coroutines.channels.ReceiveChannel $this$requireNoNulls) {
        return ChannelsKt__DeprecatedKt.requireNoNulls($this$requireNoNulls);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(...))
    public static final void sendBlocking(kotlinx.coroutines.channels.SendChannel $this$sendBlocking, Object element) {
        ChannelsKt__ChannelsKt.sendBlocking($this$sendBlocking, element);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object single(kotlinx.coroutines.channels.ReceiveChannel $this$single, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.single($this$single, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object singleOrNull(kotlinx.coroutines.channels.ReceiveChannel $this$singleOrNull, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.singleOrNull($this$singleOrNull, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel take(kotlinx.coroutines.channels.ReceiveChannel $this$take, int n, CoroutineContext context) {
        return ChannelsKt__DeprecatedKt.take($this$take, n, context);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel take$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i2, CoroutineContext coroutineContext3, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.take$default(receiveChannel, i2, coroutineContext3, i4, object5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel takeWhile(kotlinx.coroutines.channels.ReceiveChannel $this$takeWhile, CoroutineContext context, Function2 predicate) {
        return ChannelsKt__DeprecatedKt.takeWhile($this$takeWhile, context, predicate);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel takeWhile$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        return ChannelsKt__DeprecatedKt.takeWhile$default(receiveChannel, coroutineContext2, function23, i4, object5);
    }

    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> Object toChannel(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$toChannel, C destination, Continuation<? super C> $completion) {
        return ChannelsKt__DeprecatedKt.toChannel($this$toChannel, destination, $completion);
    }

    public static final <E, C extends Collection<? super E>> Object toCollection(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$toCollection, C destination, Continuation<? super C> $completion) {
        return ChannelsKt__DeprecatedKt.toCollection($this$toCollection, destination, $completion);
    }

    public static final <E> Object toList(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$toList, Continuation<? super List<? extends E>> $completion) {
        return ChannelsKt__Channels_commonKt.toList($this$toList, $completion);
    }

    public static final <K, V, M extends java.util.Map<? super K, ? super V>> Object toMap(kotlinx.coroutines.channels.ReceiveChannel<? extends Pair<? extends K, ? extends V>> $this$toMap, M destination, Continuation<? super M> $completion) {
        return ChannelsKt__DeprecatedKt.toMap($this$toMap, destination, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object toMap(kotlinx.coroutines.channels.ReceiveChannel $this$toMap, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.toMap($this$toMap, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object toMutableList(kotlinx.coroutines.channels.ReceiveChannel $this$toMutableList, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.toMutableList($this$toMutableList, $completion);
    }

    public static final <E> Object toMutableSet(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$toMutableSet, Continuation<? super Set<E>> $completion) {
        return ChannelsKt__DeprecatedKt.toMutableSet($this$toMutableSet, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object toSet(kotlinx.coroutines.channels.ReceiveChannel $this$toSet, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.toSet($this$toSet, $completion);
    }

    public static final <E> Object trySendBlocking(kotlinx.coroutines.channels.SendChannel<? super E> $this$trySendBlocking, E element) {
        return ChannelsKt__ChannelsKt.trySendBlocking($this$trySendBlocking, element);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel withIndex(kotlinx.coroutines.channels.ReceiveChannel $this$withIndex, CoroutineContext context) {
        return ChannelsKt__DeprecatedKt.withIndex($this$withIndex, context);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel withIndex$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, int i3, Object object4) {
        return ChannelsKt__DeprecatedKt.withIndex$default(receiveChannel, coroutineContext2, i3, object4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel zip(kotlinx.coroutines.channels.ReceiveChannel $this$zip, kotlinx.coroutines.channels.ReceiveChannel other) {
        return ChannelsKt__DeprecatedKt.zip($this$zip, other);
    }

    public static final <E, R, V> kotlinx.coroutines.channels.ReceiveChannel<V> zip(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$zip, kotlinx.coroutines.channels.ReceiveChannel<? extends R> other, CoroutineContext context, Function2<? super E, ? super R, ? extends V> transform) {
        return ChannelsKt__DeprecatedKt.zip($this$zip, other, context, transform);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel zip$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlinx.coroutines.channels.ReceiveChannel receiveChannel2, CoroutineContext coroutineContext3, Function2 function24, int i5, Object object6) {
        return ChannelsKt__DeprecatedKt.zip$default(receiveChannel, receiveChannel2, coroutineContext3, function24, i5, object6);
    }
}
