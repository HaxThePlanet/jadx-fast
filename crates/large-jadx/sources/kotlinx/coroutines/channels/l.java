package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.o.c;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r;
import kotlinx.coroutines.r0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0008\u0010\u0015\u001a\u00020\u0012H\u0016J\u0014\u0010\u0016\u001a\u00020\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\u0008\u00030\u0000H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u001f\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00028\u00002\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u000c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000e¨\u0006 ", d2 = {"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "completeResumeSend", "resumeSendClosed", "closed", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l<E>  extends kotlinx.coroutines.channels.v implements kotlinx.coroutines.channels.t<E> {

    public final Throwable v;
    public l(Throwable throwable) {
        super();
        this.v = throwable;
    }

    public void A(kotlinx.coroutines.channels.l<?> l) {
        if (q0.a()) {
            AssertionError obj1 = new AssertionError();
            throw obj1;
        }
    }

    @Override // kotlinx.coroutines.channels.v
    public z B(o.c o$c) {
        if (c != null) {
        } else {
            return r.a;
        }
        c.d();
        throw 0;
    }

    public kotlinx.coroutines.channels.l<E> D() {
        return this;
    }

    public kotlinx.coroutines.channels.l<E> E() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.v
    public final Throwable F() {
        Object closedReceiveChannelException;
        String str;
        if (this.v == null) {
            closedReceiveChannelException = new ClosedReceiveChannelException("Channel was closed");
        }
        return closedReceiveChannelException;
    }

    @Override // kotlinx.coroutines.channels.v
    public final Throwable G() {
        Object closedSendChannelException;
        String str;
        if (this.v == null) {
            closedSendChannelException = new ClosedSendChannelException("Channel was closed");
        }
        return closedSendChannelException;
    }

    @Override // kotlinx.coroutines.channels.v
    public Object b() {
        D();
        return this;
    }

    public void f(E e) {
    }

    public z g(E e, o.c o$c2) {
        if (c2 != null) {
        } else {
            return r.a;
        }
        c2.d();
        throw 0;
    }

    @Override // kotlinx.coroutines.channels.v
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Closed@");
        stringBuilder.append(r0.b(this));
        stringBuilder.append('[');
        stringBuilder.append(this.v);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // kotlinx.coroutines.channels.v
    public void y() {
    }

    @Override // kotlinx.coroutines.channels.v
    public Object z() {
        E();
        return this;
    }
}
