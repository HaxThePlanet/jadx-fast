package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a\u0018\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020.H\u0002\u001a\u0018\u00109\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u000bH\u0002\u001a*\u0010;\u001a\u0008\u0012\u0004\u0012\u0002H<0\u001a\"\u0004\u0008\u0000\u0010<2\u0006\u0010=\u001a\u00020\u00032\u000c\u0010>\u001a\u0008\u0012\u0004\u0012\u0002H<0\u001aH\u0002\u001a,\u0010?\u001a \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H<0\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H<0\u001a0@\"\u0004\u0008\u0000\u0010<H\u0000\u001a\u0010\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u000bH\u0002\u001aL\u0010C\u001a\u00020.\"\u0004\u0008\u0000\u0010D*\u0008\u0012\u0004\u0012\u0002HD0E2\u0006\u0010F\u001a\u0002HD2%\u0008\u0002\u0010G\u001a\u001f\u0012\u0013\u0012\u00110I¢\u0006\u000c\u0008J\u0012\u0008\u0008K\u0012\u0004\u0008\u0008(L\u0012\u0004\u0012\u00020M\u0018\u00010HH\u0002¢\u0006\u0002\u0010N\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u000e\u0010\u0008\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010%\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010*\u001a\u00020\u0003*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008+\u0010,\"\u0019\u0010-\u001a\u00020.*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008/\u00100\"\u0019\u00101\u001a\u00020\u000b*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u00082\u00103\"\u0019\u00104\u001a\u00020\u0003*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u00085\u0010,¨\u0006O", d2 = {"BUFFERED", "Lkotlinx/coroutines/internal/Symbol;", "BUFFER_END_RENDEZVOUS", "", "BUFFER_END_UNLIMITED", "CHANNEL_CLOSED", "getCHANNEL_CLOSED", "()Lkotlinx/coroutines/internal/Symbol;", "CLOSE_HANDLER_CLOSED", "CLOSE_HANDLER_INVOKED", "CLOSE_STATUS_ACTIVE", "", "CLOSE_STATUS_CANCELLATION_STARTED", "CLOSE_STATUS_CANCELLED", "CLOSE_STATUS_CLOSED", "DONE_RCV", "EB_COMPLETED_COUNTER_MASK", "EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT", "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", "FAILED", "INTERRUPTED_RCV", "INTERRUPTED_SEND", "IN_BUFFER", "NO_CLOSE_CAUSE", "NO_RECEIVE_RESULT", "NULL_SEGMENT", "Lkotlinx/coroutines/channels/ChannelSegment;", "", "POISONED", "RESULT_BUFFERED", "RESULT_CLOSED", "RESULT_FAILED", "RESULT_RENDEZVOUS", "RESULT_SUSPEND", "RESULT_SUSPEND_NO_WAITER", "RESUMING_BY_EB", "RESUMING_BY_RCV", "SEGMENT_SIZE", "SENDERS_CLOSE_STATUS_SHIFT", "SENDERS_COUNTER_MASK", "SUSPEND", "SUSPEND_NO_WAITER", "ebCompletedCounter", "getEbCompletedCounter", "(J)J", "ebPauseExpandBuffers", "", "getEbPauseExpandBuffers", "(J)Z", "sendersCloseStatus", "getSendersCloseStatus", "(J)I", "sendersCounter", "getSendersCounter", "constructEBCompletedAndPauseFlag", "counter", "pauseEB", "constructSendersAndCloseStatus", "closeStatus", "createSegment", "E", "id", "prev", "createSegmentFunction", "Lkotlin/reflect/KFunction2;", "initialBufferEnd", "capacity", "tryResume0", "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BufferedChannelKt {

    public static final Symbol BUFFERED = null;
    private static final long BUFFER_END_RENDEZVOUS = 0L;
    private static final long BUFFER_END_UNLIMITED = Long.MAX_VALUE;
    private static final Symbol CHANNEL_CLOSED = null;
    private static final Symbol CLOSE_HANDLER_CLOSED = null;
    private static final Symbol CLOSE_HANDLER_INVOKED = null;
    private static final int CLOSE_STATUS_ACTIVE = 0;
    private static final int CLOSE_STATUS_CANCELLATION_STARTED = 1;
    private static final int CLOSE_STATUS_CANCELLED = 3;
    private static final int CLOSE_STATUS_CLOSED = 2;
    private static final Symbol DONE_RCV = null;
    private static final long EB_COMPLETED_COUNTER_MASK = 4611686018427387903L;
    private static final long EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT = 4611686018427387904L;
    private static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = 0;
    private static final Symbol FAILED = null;
    private static final Symbol INTERRUPTED_RCV = null;
    private static final Symbol INTERRUPTED_SEND = null;
    private static final Symbol IN_BUFFER = null;
    private static final Symbol NO_CLOSE_CAUSE = null;
    private static final Symbol NO_RECEIVE_RESULT = null;
    private static final kotlinx.coroutines.channels.ChannelSegment<Object> NULL_SEGMENT = null;
    private static final Symbol POISONED = null;
    private static final int RESULT_BUFFERED = 1;
    private static final int RESULT_CLOSED = 4;
    private static final int RESULT_FAILED = 5;
    private static final int RESULT_RENDEZVOUS = 0;
    private static final int RESULT_SUSPEND = 2;
    private static final int RESULT_SUSPEND_NO_WAITER = 3;
    private static final Symbol RESUMING_BY_EB = null;
    private static final Symbol RESUMING_BY_RCV = null;
    public static final int SEGMENT_SIZE = 0;
    private static final int SENDERS_CLOSE_STATUS_SHIFT = 60;
    private static final long SENDERS_COUNTER_MASK = 1152921504606846975L;
    private static final Symbol SUSPEND;
    private static final Symbol SUSPEND_NO_WAITER;
    static {
        ChannelSegment channelSegment = new ChannelSegment(-1, obj2, 0, 0, 0);
        BufferedChannelKt.NULL_SEGMENT = channelSegment;
        int i9 = 12;
        final int i10 = 0;
        int i5 = 0;
        int i7 = 0;
        BufferedChannelKt.SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, i5, i7, i9, i10);
        BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, i5, i7, i9, i10);
        Symbol symbol = new Symbol("BUFFERED");
        BufferedChannelKt.BUFFERED = symbol;
        Symbol symbol2 = new Symbol("SHOULD_BUFFER");
        BufferedChannelKt.IN_BUFFER = symbol2;
        Symbol symbol3 = new Symbol("S_RESUMING_BY_RCV");
        BufferedChannelKt.RESUMING_BY_RCV = symbol3;
        Symbol symbol4 = new Symbol("RESUMING_BY_EB");
        BufferedChannelKt.RESUMING_BY_EB = symbol4;
        Symbol symbol5 = new Symbol("POISONED");
        BufferedChannelKt.POISONED = symbol5;
        Symbol symbol6 = new Symbol("DONE_RCV");
        BufferedChannelKt.DONE_RCV = symbol6;
        Symbol symbol7 = new Symbol("INTERRUPTED_SEND");
        BufferedChannelKt.INTERRUPTED_SEND = symbol7;
        Symbol symbol8 = new Symbol("INTERRUPTED_RCV");
        BufferedChannelKt.INTERRUPTED_RCV = symbol8;
        Symbol symbol9 = new Symbol("CHANNEL_CLOSED");
        BufferedChannelKt.CHANNEL_CLOSED = symbol9;
        Symbol symbol10 = new Symbol("SUSPEND");
        BufferedChannelKt.SUSPEND = symbol10;
        Symbol symbol11 = new Symbol("SUSPEND_NO_WAITER");
        BufferedChannelKt.SUSPEND_NO_WAITER = symbol11;
        Symbol symbol12 = new Symbol("FAILED");
        BufferedChannelKt.FAILED = symbol12;
        Symbol symbol13 = new Symbol("NO_RECEIVE_RESULT");
        BufferedChannelKt.NO_RECEIVE_RESULT = symbol13;
        Symbol symbol14 = new Symbol("CLOSE_HANDLER_CLOSED");
        BufferedChannelKt.CLOSE_HANDLER_CLOSED = symbol14;
        Symbol symbol15 = new Symbol("CLOSE_HANDLER_INVOKED");
        BufferedChannelKt.CLOSE_HANDLER_INVOKED = symbol15;
        Symbol symbol16 = new Symbol("NO_CLOSE_CAUSE");
        BufferedChannelKt.NO_CLOSE_CAUSE = symbol16;
    }

    public static final long access$constructEBCompletedAndPauseFlag(long counter, boolean pauseEB) {
        return BufferedChannelKt.constructEBCompletedAndPauseFlag(counter, pauseEB);
    }

    public static final long access$constructSendersAndCloseStatus(long counter, int closeStatus) {
        return BufferedChannelKt.constructSendersAndCloseStatus(counter, closeStatus);
    }

    public static final kotlinx.coroutines.channels.ChannelSegment access$createSegment(long id, kotlinx.coroutines.channels.ChannelSegment prev) {
        return BufferedChannelKt.createSegment(id, prev);
    }

    public static final Symbol access$getCLOSE_HANDLER_CLOSED$p() {
        return BufferedChannelKt.CLOSE_HANDLER_CLOSED;
    }

    public static final Symbol access$getCLOSE_HANDLER_INVOKED$p() {
        return BufferedChannelKt.CLOSE_HANDLER_INVOKED;
    }

    public static final Symbol access$getDONE_RCV$p() {
        return BufferedChannelKt.DONE_RCV;
    }

    public static final int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p() {
        return BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
    }

    public static final Symbol access$getFAILED$p() {
        return BufferedChannelKt.FAILED;
    }

    public static final Symbol access$getINTERRUPTED_RCV$p() {
        return BufferedChannelKt.INTERRUPTED_RCV;
    }

    public static final Symbol access$getINTERRUPTED_SEND$p() {
        return BufferedChannelKt.INTERRUPTED_SEND;
    }

    public static final Symbol access$getIN_BUFFER$p() {
        return BufferedChannelKt.IN_BUFFER;
    }

    public static final Symbol access$getNO_CLOSE_CAUSE$p() {
        return BufferedChannelKt.NO_CLOSE_CAUSE;
    }

    public static final Symbol access$getNO_RECEIVE_RESULT$p() {
        return BufferedChannelKt.NO_RECEIVE_RESULT;
    }

    public static final kotlinx.coroutines.channels.ChannelSegment access$getNULL_SEGMENT$p() {
        return BufferedChannelKt.NULL_SEGMENT;
    }

    public static final Symbol access$getPOISONED$p() {
        return BufferedChannelKt.POISONED;
    }

    public static final Symbol access$getRESUMING_BY_EB$p() {
        return BufferedChannelKt.RESUMING_BY_EB;
    }

    public static final Symbol access$getRESUMING_BY_RCV$p() {
        return BufferedChannelKt.RESUMING_BY_RCV;
    }

    public static final Symbol access$getSUSPEND$p() {
        return BufferedChannelKt.SUSPEND;
    }

    public static final Symbol access$getSUSPEND_NO_WAITER$p() {
        return BufferedChannelKt.SUSPEND_NO_WAITER;
    }

    public static final long access$initialBufferEnd(int capacity) {
        return BufferedChannelKt.initialBufferEnd(capacity);
    }

    public static final boolean access$tryResume0(CancellableContinuation $receiver, Object value, Function1 onCancellation) {
        return BufferedChannelKt.tryResume0($receiver, value, onCancellation);
    }

    private static final long constructEBCompletedAndPauseFlag(long counter, boolean pauseEB) {
        long l;
        l = obj4 != null ? 4611686018427387904L : 0;
        return l += counter;
    }

    private static final long constructSendersAndCloseStatus(long counter, int closeStatus) {
        return i += counter;
    }

    private static final <E> kotlinx.coroutines.channels.ChannelSegment<E> createSegment(long id, kotlinx.coroutines.channels.ChannelSegment<E> prev) {
        ChannelSegment channelSegment = new ChannelSegment(id, obj2, obj8, obj8.getChannel(), 0);
        return channelSegment;
    }

    public static final <E> KFunction<kotlinx.coroutines.channels.ChannelSegment<E>> createSegmentFunction() {
        return (KFunction)BufferedChannelKt.createSegmentFunction.1.INSTANCE;
    }

    public static final Symbol getCHANNEL_CLOSED() {
        return BufferedChannelKt.CHANNEL_CLOSED;
    }

    private static final long getEbCompletedCounter(long $this$ebCompletedCounter) {
        final int i = 0;
        return l &= $this$ebCompletedCounter;
    }

    private static final boolean getEbPauseExpandBuffers(long $this$ebPauseExpandBuffers) {
        int i;
        final int i2 = 0;
        i = Long.compare(i3, i4) != 0 ? 1 : 0;
        return i;
    }

    private static final int getSendersCloseStatus(long $this$sendersCloseStatus) {
        final int i = 0;
        return (int)i3;
    }

    private static final long getSendersCounter(long $this$sendersCounter) {
        final int i = 0;
        return l &= $this$sendersCounter;
    }

    private static final long initialBufferEnd(int capacity) {
        int i;
        switch (capacity) {
            case 0:
                i = 0;
                break;
            case 2147483647:
                i = Long.MAX_VALUE;
                break;
            default:
                i = (long)capacity;
        }
        return i;
    }

    private static final <T> boolean tryResume0(CancellableContinuation<? super T> $this$tryResume0, T value, Function1<? super Throwable, Unit> onCancellation) {
        int i;
        Object tryResume = $this$tryResume0.tryResume(value, 0, onCancellation);
        final int i3 = 0;
        i = tryResume != null ? 1 : 0;
        return i;
    }

    static boolean tryResume0$default(CancellableContinuation cancellableContinuation, Object object2, Function1 function13, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return BufferedChannelKt.tryResume0(cancellableContinuation, object2, obj2);
    }
}
