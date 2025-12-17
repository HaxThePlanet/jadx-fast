package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\n\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u000245B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\n2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0010¢\u0006\u0002\u0008\"J\u0012\u0010#\u001a\u00020\n2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001e\u0010&\u001a\u00020'2\n\u0010(\u001a\u0006\u0012\u0002\u0008\u00030\u00132\u0008\u0010)\u001a\u0004\u0018\u00010\rH\u0014J\u0016\u0010*\u001a\u00020'2\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0002J\u0019\u0010,\u001a\u00020'2\u0006\u0010)\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0008\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\u0008\u0012\u0004\u0012\u00020'012\u0006\u0010)\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u00082\u00103R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012j\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u00028\u00008F¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\u0019\u001a\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u0004\u0018\u00018\u00008F¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u0019\u001a\u0004\u0008\u001e\u0010\u001b\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u00066", d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "(I)V", "getCapacity", "()I", "isClosedForSend", "", "()Z", "lastConflatedElement", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "onSendInternalResult", "Ljava/util/HashMap;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/collections/HashMap;", "subscribers", "", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull$annotations", "getValueOrNull", "cancelImpl", "cause", "", "cancelImpl$kotlinx_coroutines_core", "close", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "registerSelectForSend", "", "select", "element", "removeSubscriber", "s", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BroadcastChannelImpl<E>  extends kotlinx.coroutines.channels.BufferedChannel<E> implements kotlinx.coroutines.channels.BroadcastChannel<E> {

    private final int capacity;
    private Object lastConflatedElement;
    private final ReentrantLock lock;
    private final HashMap<SelectInstance<?>, Object> onSendInternalResult;
    private List<? extends kotlinx.coroutines.channels.BufferedChannel<E>> subscribers;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0082\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007", d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SubscriberBuffered extends kotlinx.coroutines.channels.BufferedChannel<E> {

        final kotlinx.coroutines.channels.BroadcastChannelImpl<E> this$0;
        public SubscriberBuffered(kotlinx.coroutines.channels.BroadcastChannelImpl this$0) {
            this.this$0 = this$0;
            final int i = 0;
            super(this$0.getCapacity(), i, 2, i);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        public boolean cancelImpl(Throwable cause) {
            final int i = 0;
            final ReentrantLock reentrantLock2 = reentrantLock;
            (Lock)reentrantLock2.lock();
            final int i2 = 0;
            BroadcastChannelImpl.access$removeSubscriber(this.this$0, (ReceiveChannel)this);
            reentrantLock2.unlock();
            return super.cancelImpl$kotlinx_coroutines_core(cause);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
            return cancelImpl(cause);
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0082\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007", d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SubscriberConflated extends kotlinx.coroutines.channels.ConflatedBufferedChannel<E> {

        final kotlinx.coroutines.channels.BroadcastChannelImpl<E> this$0;
        public SubscriberConflated(kotlinx.coroutines.channels.BroadcastChannelImpl this$0) {
            this.this$0 = this$0;
            super(1, BufferOverflow.DROP_OLDEST, 0, 4, 0);
        }

        @Override // kotlinx.coroutines.channels.ConflatedBufferedChannel
        public boolean cancelImpl(Throwable cause) {
            BroadcastChannelImpl.access$removeSubscriber(this.this$0, (ReceiveChannel)this);
            return super.cancelImpl$kotlinx_coroutines_core(cause);
        }

        @Override // kotlinx.coroutines.channels.ConflatedBufferedChannel
        public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
            return cancelImpl(cause);
        }
    }
    public BroadcastChannelImpl(int capacity) {
        int capacity2;
        int i;
        int i2;
        super(0, 0);
        this.capacity = capacity;
        int i5 = 1;
        if (this.capacity < i5) {
            i = this.capacity == -1 ? i5 : i;
        } else {
        }
        if (i == 0) {
        } else {
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.subscribers = CollectionsKt.emptyList();
            this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
            HashMap hashMap = new HashMap();
            this.onSendInternalResult = hashMap;
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("BroadcastChannel capacity must be positive or Channel.CONFLATED, but ").append(this.capacity).append(" was specified").toString().toString());
        throw illegalArgumentException;
    }

    public static final ReentrantLock access$getLock$p(kotlinx.coroutines.channels.BroadcastChannelImpl $this) {
        return $this.lock;
    }

    public static final HashMap access$getOnSendInternalResult$p(kotlinx.coroutines.channels.BroadcastChannelImpl $this) {
        return $this.onSendInternalResult;
    }

    public static final void access$removeSubscriber(kotlinx.coroutines.channels.BroadcastChannelImpl $this, kotlinx.coroutines.channels.ReceiveChannel s) {
        $this.removeSubscriber(s);
    }

    public static void getValue$annotations() {
    }

    public static void getValueOrNull$annotations() {
    }

    private final void removeSubscriber(kotlinx.coroutines.channels.ReceiveChannel<? extends E> s) {
        Object next;
        Object obj;
        int i2;
        int i;
        final int i3 = 0;
        final ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        int i4 = 0;
        final int i5 = 0;
        ArrayList arrayList = new ArrayList();
        final int i6 = 0;
        final Iterator iterator = (Iterable)this.subscribers.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            i2 = 0;
            if ((BufferedChannel)next != s) {
            } else {
            }
            i = 0;
            if (i != 0) {
            }
            (Collection)arrayList.add(next);
            i = 1;
        }
        this.subscribers = (List)arrayList;
        Unit iNSTANCE = Unit.INSTANCE;
        reentrantLock.unlock();
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
        Object next;
        Object obj;
        int i;
        final int i2 = 0;
        final ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        final int i3 = 0;
        final int i4 = 0;
        final Iterator iterator = (Iterable)this.subscribers.iterator();
        for (Object next : iterator) {
            i = 0;
            (BufferedChannel)next.cancelImpl$kotlinx_coroutines_core(cause);
        }
        this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
        reentrantLock.unlock();
        return super.cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean close(Throwable cause) {
        Object next;
        Object obj;
        int i;
        Object next2;
        Object obj2;
        int i2;
        boolean elements$kotlinx_coroutines_core;
        final int i3 = 0;
        final ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        final int i4 = 0;
        int i5 = 0;
        Iterator iterator = (Iterable)this.subscribers.iterator();
        for (Object next : iterator) {
            i = 0;
            (BufferedChannel)next.close(cause);
        }
        int i6 = 0;
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        Iterator iterator2 = (Iterable)this.subscribers.iterator();
        while (iterator2.hasNext()) {
            next2 = iterator2.next();
            i2 = 0;
            if ((BufferedChannel)next2.hasElements$kotlinx_coroutines_core()) {
            }
            (Collection)arrayList.add(next2);
        }
        this.subscribers = (List)arrayList;
        reentrantLock.unlock();
        return super.close(cause);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final int getCapacity() {
        return this.capacity;
    }

    public final E getValue() {
        Object illegalStateException;
        String str;
        final int i = 0;
        final ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        final int i2 = 0;
        if (isClosedForSend()) {
            if (getCloseCause() != null) {
            } else {
                illegalStateException = new IllegalStateException("This broadcast channel is closed");
            }
            throw illegalStateException;
        }
        if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
        } else {
            reentrantLock.unlock();
            return this.lastConflatedElement;
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("No value".toString());
        throw illegalStateException2;
    }

    public final E getValueOrNull() {
        boolean lastConflatedElement;
        int lastConflatedElement2;
        kotlinx.coroutines.internal.Symbol symbol;
        final int i = 0;
        final ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        final int i2 = 0;
        lastConflatedElement2 = 0;
        if (isClosedForReceive()) {
        } else {
            if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
            } else {
                lastConflatedElement2 = this.lastConflatedElement;
            }
        }
        reentrantLock.unlock();
        return lastConflatedElement2;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean isClosedForSend() {
        final int i = 0;
        final ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        final int i2 = 0;
        reentrantLock.unlock();
        return super.isClosedForSend();
    }

    public kotlinx.coroutines.channels.ReceiveChannel<E> openSubscription() {
        kotlinx.coroutines.channels.BufferedChannel subscriberConflated;
        boolean lastConflatedElement;
        Object lastConflatedElement2;
        kotlinx.coroutines.internal.Symbol symbol;
        final int i = 0;
        final ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        final int i2 = 0;
        if (this.capacity == -1) {
            subscriberConflated = new BroadcastChannelImpl.SubscriberConflated(this);
        } else {
            subscriberConflated = new BroadcastChannelImpl.SubscriberBuffered(this);
        }
        if (isClosedForSend() && this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
            if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                (BufferedChannel)subscriberConflated.close(getCloseCause());
                reentrantLock.unlock();
                return (ReceiveChannel)subscriberConflated;
            }
        }
        if (this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
            subscriberConflated.trySend-JP2dKIU(getValue());
        }
        this.subscribers = CollectionsKt.plus((Collection)this.subscribers, subscriberConflated);
        reentrantLock.unlock();
        return (ReceiveChannel)subscriberConflated;
    }

    protected void registerSelectForSend(SelectInstance<?> select, Object element) {
        int i2 = 0;
        ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        int i = 0;
        Object remove = this.onSendInternalResult.remove(select);
        if (remove != null) {
            select.selectInRegistrationPhase(remove);
            reentrantLock.unlock();
        }
        Unit iNSTANCE = Unit.INSTANCE;
        reentrantLock.unlock();
        int i3 = 0;
        BroadcastChannelImpl.registerSelectForSend.2 anon = new BroadcastChannelImpl.registerSelectForSend.2(this, element, select, i3);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(select.getContext()), i3, CoroutineStart.UNDISPATCHED, (Function2)anon, 1, 0);
    }

    public Object send(E e, Continuation<? super Unit> continuation2) {
        boolean $result;
        Object $continuation;
        int i2;
        Object $continuation2;
        kotlinx.coroutines.channels.BroadcastChannelImpl.send.1 anon;
        int i;
        Object obj;
        Iterator $this$forEach$iv;
        Object $i$f$forEach;
        kotlinx.coroutines.channels.BroadcastChannelImpl l$0;
        List subscribers;
        int closedForSend;
        kotlinx.coroutines.channels.BroadcastChannelImpl.send.1 anon2;
        int obj10;
        Object obj11;
        $result = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof BroadcastChannelImpl.send.1 && label &= i != 0) {
            $result = continuation2;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                $result.label = obj11 -= i;
            } else {
                $result = new BroadcastChannelImpl.send.1(this, continuation2);
            }
        } else {
        }
        obj11 = $result.result;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                obj = this;
                int i4 = 0;
                ReentrantLock reentrantLock = lock;
                (Lock)reentrantLock.lock();
                int $this$withLock$iv = 0;
                obj.lastConflatedElement = e;
                reentrantLock.unlock();
                $i$f$forEach = e;
                obj10 = $this$forEach$iv2;
                $this$forEach$iv = iterator;
                l$0 = obj;
                throw obj.getSendException();
            case 1:
                obj10 = 0;
                $this$forEach$iv = $result.L$2;
                $i$f$forEach = $result.L$1;
                l$0 = $result.L$0;
                ResultKt.throwOnFailure(obj11);
                subscribers = i3;
                obj = $continuation2;
                anon = $result;
                $continuation = obj11;
                throw l$0.getSendException();
                obj11 = $continuation;
                $result = anon;
                $continuation2 = obj;
                break;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        if ($this$forEach$iv.hasNext()) {
            subscribers = 0;
            $result.L$0 = l$0;
            $result.L$1 = $i$f$forEach;
            $result.L$2 = $this$forEach$iv;
            $result.label = 1;
            Object it = (BufferedChannel)$this$forEach$iv.next().sendBroadcast$kotlinx_coroutines_core($i$f$forEach, $result);
            if (it == $continuation2) {
                return $continuation2;
            } else {
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public String toString() {
        String string;
        Object str;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            string = stringBuilder2.append("CONFLATED_ELEMENT=").append(this.lastConflatedElement).append("; ").toString();
        } else {
            string = "";
        }
        return stringBuilder.append(string).append("BROADCAST=<").append(super.toString()).append(">; SUBSCRIBERS=").append(CollectionsKt.joinToString$default((Iterable)this.subscribers, (CharSequence)";", (CharSequence)"<", (CharSequence)">", 0, 0, 0, 56, 0)).toString();
    }

    public Object trySend-JP2dKIU(E element) {
        boolean iterator;
        int i;
        boolean next;
        Object obj;
        int i2;
        boolean sendSuspend$kotlinx_coroutines_core;
        final int i3 = 0;
        final ReentrantLock reentrantLock = lock;
        (Lock)reentrantLock.lock();
        final int i4 = 0;
        if (isClosedForSend()) {
            reentrantLock.unlock();
            return super.trySend-JP2dKIU(element);
        }
        List subscribers = this.subscribers;
        int i5 = 0;
        i = 0;
        if (subscribers instanceof Collection != null && (Collection)(Iterable)subscribers.isEmpty()) {
            if ((Collection)subscribers.isEmpty()) {
            } else {
                iterator = subscribers.iterator();
                for (Object next : iterator) {
                    i2 = 0;
                }
            }
        } else {
        }
        try {
            if (i != 0) {
            }
            reentrantLock.unlock();
            return ChannelResult.Companion.failure-PtdJZtk();
            if (this.capacity == -1) {
            }
            this.lastConflatedElement = element;
            int i7 = 0;
            Iterator iterator2 = (Iterable)this.subscribers.iterator();
            for (Object next : iterator2) {
                i2 = 0;
                (BufferedChannel)next.trySend-JP2dKIU(element);
            }
            i2 = 0;
            (BufferedChannel)iterator2.next().trySend-JP2dKIU(element);
            reentrantLock.unlock();
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
            obj2.unlock();
            throw th;
        }
    }
}
