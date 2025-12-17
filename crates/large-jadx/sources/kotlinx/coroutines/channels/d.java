package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.i;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u00028\u00000BB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0008¢\u0006\u0004\u0008\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00122\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0014¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u0000H\u0014¢\u0006\u0004\u0008\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\u0008\u00030\u001eH\u0014¢\u0006\u0004\u0008 \u0010!J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0014¢\u0006\u0004\u0008#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\u0008%\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\u0008\u00030\u001eH\u0014¢\u0006\u0004\u0008'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u000c\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008*\u0010+R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008-\u0010.R\u0014\u00102\u001a\u00020/8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u00080\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00084\u00103R\u0014\u00105\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u00085\u00106R\u0014\u00107\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u00087\u00106R\u0014\u00108\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u00088\u00106R\u0014\u00109\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u00089\u00106R\u0014\u0010:\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008:\u00106R\u0014\u0010;\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008;\u00106R\u0018\u0010>\u001a\u00060<j\u0002`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008>\u0010?R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0005\u0010@¨\u0006A", d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", "element", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class d<E>  extends kotlinx.coroutines.channels.a<E> {

    private volatile int size = 0;
    private final int v;
    private final kotlinx.coroutines.channels.e w;
    private final ReentrantLock x;
    private Object[] y;
    private int z;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[e.SUSPEND.ordinal()] = 1;
            iArr[e.DROP_LATEST.ordinal()] = 2;
            iArr[e.DROP_OLDEST.ordinal()] = 3;
            d.a.a = iArr;
        }
    }
    public d(int i, kotlinx.coroutines.channels.e e2, l<? super E, w> l3) {
        int obj9;
        super(l3);
        this.v = i;
        this.w = e2;
        if (i >= 1) {
        } else {
            obj9 = obj8;
        }
        if (obj9 == null) {
        } else {
            obj9 = new ReentrantLock();
            this.x = obj9;
            Object[] obj7 = new Object[Math.min(i, 8)];
            i.n(obj7, b.a, 0, 0, 6, 0);
            obj9 = w.a;
            this.y = obj7;
        }
        StringBuilder obj8 = new StringBuilder();
        obj8.append("ArrayChannel capacity must be at least 1, but ");
        obj8.append(i);
        obj8.append(" was specified");
        obj8 = new IllegalArgumentException(obj8.toString().toString());
        throw obj8;
    }

    private final void J(int i, E e2) {
        Object[] objArr;
        int z;
        int i2;
        int dROP_OLDEST;
        int length;
        int i3;
        int obj6;
        if (i < this.v) {
            K(i);
            objArr = this.y;
            objArr[i6 %= obj6] = e2;
        } else {
            i2 = 1;
            if (q0.a()) {
                z = this.w == e.DROP_OLDEST ? i2 : 0;
                if (z == 0) {
                } else {
                }
                obj6 = new AssertionError();
                throw obj6;
            }
            objArr = this.y;
            int i7 = this.z;
            objArr[i7 % length2] = 0;
            objArr[obj6 %= length] = e2;
            this.z = i8 %= obj6;
        }
    }

    private final void K(int i) {
        Object[] objArr;
        int length;
        int i4;
        z zVar;
        int i2;
        Object obj;
        int i3;
        int length2;
        objArr = this.y;
        objArr = Math.min(length3 *= 2, this.v);
        length = new Object[objArr];
        i4 = 0;
        if (i >= objArr.length && i > 0) {
            objArr = Math.min(length3 *= 2, this.v);
            length = new Object[objArr];
            i4 = 0;
            if (i > 0) {
                zVar = i4;
                i2 = zVar + 1;
                Object[] objArr2 = this.y;
                length[zVar] = objArr2[i8 %= length2];
                while (i2 >= i) {
                    zVar = i2;
                    i2 = zVar + 1;
                    objArr2 = this.y;
                    length[zVar] = objArr2[i8 %= length2];
                }
            }
            i.l(length, b.a, i, objArr);
            this.y = length;
            this.z = i4;
        }
    }

    private final z L(int i) {
        int iArr;
        z i2;
        final int i4 = 1;
        if (i < this.v) {
            this.size = i += i4;
            return null;
        }
        int obj4 = d.a.a[this.w.ordinal()];
        if (obj4 != i4) {
            if (obj4 != 2) {
                if (obj4 != 3) {
                } else {
                }
                obj4 = new NoWhenBranchMatchedException();
                throw obj4;
            }
            i2 = b.b;
        } else {
            i2 = b.c;
        }
        return i2;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean A() {
        int i;
        i = this.size == 0 ? 1 : 0;
        return i;
    }

    @Override // kotlinx.coroutines.channels.a
    public boolean B() {
        final ReentrantLock reentrantLock = this.x;
        reentrantLock.lock();
        reentrantLock.unlock();
        return super.B();
    }

    @Override // kotlinx.coroutines.channels.a
    protected void C(boolean z) {
        int i;
        int i2;
        int length;
        int i3;
        int i4;
        z zVar;
        l lVar = this.a;
        final ReentrantLock reentrantLock = this.x;
        reentrantLock.lock();
        final int i5 = 0;
        i = 0;
        i2 = i5;
        while (i2 < this.size) {
            Object obj = this.y[this.z];
            if (lVar != null && obj != b.a) {
            }
            Object[] objArr2 = this.y;
            int i6 = this.z;
            objArr2[i6] = b.a;
            this.z = i7 %= length;
            i2++;
            if (obj != b.a) {
            }
            i = u.c(lVar, obj, i);
        }
        this.size = i5;
        w wVar = w.a;
        reentrantLock.unlock();
        super.C(z);
        if (i != 0) {
        } else {
            try {
                throw i;
                obj1.unlock();
                throw z;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected Object G() {
        Object lVar;
        int length;
        Object zVar;
        boolean z;
        int i;
        z zVar2;
        int i3;
        int i2;
        kotlinx.coroutines.channels.v vVar;
        final ReentrantLock reentrantLock = this.x;
        reentrantLock.lock();
        length = this.size;
        if (length == 0 && g() == null) {
            if (g() == null) {
                lVar = b.d;
            }
            reentrantLock.unlock();
            return lVar;
        }
        Object[] objArr = this.y;
        int i8 = this.z;
        i3 = 0;
        objArr[i8] = i3;
        this.size = length + -1;
        zVar = b.d;
        i2 = 0;
        final int i9 = 1;
        if (length == this.v) {
            try {
                i = i3;
                vVar = q();
                while (vVar == null) {
                    i = vVar.B(i3);
                    vVar.C();
                    i = vVar;
                    vVar = q();
                }
                i3 = i;
                i = vVar.B(i3);
                if (i != null) {
                } else {
                }
                if (q0.a() && i == r.a) {
                }
                if (i == r.a) {
                }
                i2 = i9;
                AssertionError assertionError = new AssertionError();
                throw assertionError;
                zVar = vVar.z();
                i2 = i9;
                i3 = vVar;
                vVar.C();
                i = vVar;
            }
        }
        if (zVar != b.d && !zVar instanceof l) {
            if (!zVar instanceof l) {
                this.size = length;
                zVar2 = this.y;
                zVar2[i11 %= length] = zVar;
            }
        }
        this.z = i5 %= length2;
        w wVar = w.a;
        reentrantLock.unlock();
        if (i2 != 0) {
            try {
                n.d(i3);
                i3.y();
                return objArr[i8];
                obj0.unlock();
                throw th;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected String e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(buffer:capacity=");
        stringBuilder.append(this.v);
        stringBuilder.append(",size=");
        stringBuilder.append(this.size);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    protected Object m(E e) {
        z zVar2;
        z zVar;
        boolean z;
        final ReentrantLock reentrantLock = this.x;
        reentrantLock.lock();
        int size = this.size;
        kotlinx.coroutines.channels.l lVar = g();
        zVar2 = L(size);
        if (lVar == null && zVar2 == null && size == 0) {
            zVar2 = L(size);
            if (zVar2 == null) {
                if (size == 0) {
                }
                J(size, e);
                reentrantLock.unlock();
                return b.b;
            }
            reentrantLock.unlock();
            return zVar2;
        }
        reentrantLock.unlock();
        return lVar;
    }

    protected boolean y(kotlinx.coroutines.channels.r<? super E> r) {
        final ReentrantLock reentrantLock = this.x;
        reentrantLock.lock();
        reentrantLock.unlock();
        return super.y(r);
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean z() {
        return 0;
    }
}
