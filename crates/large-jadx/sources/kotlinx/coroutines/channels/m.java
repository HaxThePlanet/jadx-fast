package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.w;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0018\u001a\u00020\r2\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\u0008\u00030 H\u0014¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\rH\u0014J\n\u0010$\u001a\u0004\u0018\u00010\u0017H\u0014J\u0016\u0010%\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\u0008\u00030 H\u0014J\u0014\u0010&\u001a\u0004\u0018\u00010'2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\u0008\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006(", d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "updateValueLocked", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class m<E>  extends kotlinx.coroutines.channels.a<E> {

    private final ReentrantLock v;
    private Object w;
    public m(l<? super E, w> l) {
        super(l);
        ReentrantLock obj1 = new ReentrantLock();
        this.v = obj1;
        this.w = b.a;
    }

    private final UndeliveredElementException J(Object object) {
        Object zVar;
        int i2;
        int i;
        final Object obj = this.w;
        i2 = 0;
        if (obj == b.a) {
        } else {
            zVar = this.a;
            if (zVar == null) {
            } else {
                i2 = u.d(zVar, obj, i2, 2, i2);
            }
        }
        this.w = object;
        return i2;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean A() {
        int i;
        i = this.w == b.a ? 1 : 0;
        return i;
    }

    @Override // kotlinx.coroutines.channels.a
    protected void C(boolean z) {
        final ReentrantLock reentrantLock = this.v;
        reentrantLock.lock();
        UndeliveredElementException exc = J(b.a);
        final w wVar = w.a;
        reentrantLock.unlock();
        super.C(z);
        if (exc != null) {
        } else {
        }
        throw exc;
    }

    @Override // kotlinx.coroutines.channels.a
    protected Object G() {
        Object lVar;
        final ReentrantLock reentrantLock = this.v;
        reentrantLock.lock();
        Object obj = this.w;
        kotlinx.coroutines.internal.z zVar = b.a;
        if (obj == zVar && g() == null) {
            if (g() == null) {
                lVar = b.d;
            }
            reentrantLock.unlock();
            return lVar;
        }
        this.w = zVar;
        w wVar = w.a;
        reentrantLock.unlock();
        return obj;
    }

    @Override // kotlinx.coroutines.channels.a
    protected String e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(value=");
        stringBuilder.append(this.w);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    protected Object m(E e) {
        Object obj;
        kotlinx.coroutines.internal.z zVar;
        boolean z;
        final ReentrantLock reentrantLock = this.v;
        reentrantLock.lock();
        kotlinx.coroutines.channels.l lVar = g();
        if (lVar == null && this.w == b.a) {
            if (this.w == b.a) {
            }
            UndeliveredElementException obj5 = J(e);
            if (obj5 != null) {
            } else {
                reentrantLock.unlock();
                return b.b;
            }
            throw obj5;
        }
        reentrantLock.unlock();
        return lVar;
    }

    protected boolean y(kotlinx.coroutines.channels.r<? super E> r) {
        final ReentrantLock reentrantLock = this.v;
        reentrantLock.lock();
        reentrantLock.unlock();
        return super.y(r);
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean z() {
        return 0;
    }
}
