package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008f\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H¦Bø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0008\u001a\u00028\u0000H\u0097@ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0005\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\t", d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", "E", "", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "next0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ChannelIterator<E>  {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public static Object next(kotlinx.coroutines.channels.ChannelIterator channelIterator, Continuation continuation2) {
            boolean anon;
            int i2;
            int i;
            Object next;
            Object obj3;
            Object obj4;
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (continuation2 instanceof ChannelIterator.next0.1 && label &= i != 0) {
                anon = continuation2;
                i = Integer.MIN_VALUE;
                if (label &= i != 0) {
                    anon.label = obj4 -= i;
                } else {
                    anon = new ChannelIterator.next0.1(continuation2);
                }
            } else {
            }
            obj4 = anon.result;
            Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (label2) {
                case 0:
                    ResultKt.throwOnFailure(obj4);
                    anon.L$0 = channelIterator;
                    anon.label = 1;
                    return cOROUTINE_SUSPENDED;
                case 1:
                    obj3 = anon.L$0;
                    ResultKt.throwOnFailure(obj4);
                    next = obj4;
                    break;
                default:
                    obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj3;
            }
            if (!(Boolean)next.booleanValue()) {
            } else {
                return obj3.next();
            }
            ClosedReceiveChannelException closedReceiveChannelException = new ClosedReceiveChannelException("Channel was closed");
            throw closedReceiveChannelException;
        }
    }
    public abstract Object hasNext(Continuation<? super Boolean> continuation);

    public abstract E next();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    public abstract Object next(Continuation continuation);
}
