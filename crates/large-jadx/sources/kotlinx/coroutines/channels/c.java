package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g0;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.internal.l;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.o.c;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r;
import kotlinx.coroutines.r0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008 \u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u00028\u000006:\u0004defgB)\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0004¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ#\u0010\u0013\u001a\u000e\u0012\u0002\u0008\u00030\u0011j\u0006\u0012\u0002\u0008\u0003`\u00122\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\u0008\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\u0008\u00030\u001dH\u0002¢\u0006\u0004\u0008\u001f\u0010 J#\u0010!\u001a\u00020\u00082\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\u0008\u00030\u001dH\u0002¢\u0006\u0004\u0008!\u0010\"J\u001b\u0010!\u001a\u00020\u00082\n\u0010\u001e\u001a\u0006\u0012\u0002\u0008\u00030\u001dH\u0002¢\u0006\u0004\u0008!\u0010#J)\u0010&\u001a\u00020\u00032\u0018\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`$H\u0016¢\u0006\u0004\u0008&\u0010\u0007J\u0019\u0010'\u001a\u00020\u00032\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0002¢\u0006\u0004\u0008'\u0010(J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\u0008)\u0010*J\u0017\u0010+\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0004\u0008+\u0010,J#\u0010/\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010.\u001a\u0006\u0012\u0002\u0008\u00030-H\u0014¢\u0006\u0004\u0008/\u00100J\u0017\u00102\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u000201H\u0014¢\u0006\u0004\u00082\u00103JX\u00109\u001a\u00020\u0003\"\u0004\u0008\u0001\u001042\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010\u0010\u001a\u00028\u00002(\u00108\u001a$\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u000006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u001a05H\u0002ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J\u001b\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010;J\u001d\u0010=\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010<2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\u0008=\u0010>J\u001b\u0010?\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008?\u0010;J\u0017\u0010@\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H\u0014¢\u0006\u0004\u0008@\u0010AJ\u0011\u0010B\u001a\u0004\u0018\u00010\u0018H\u0004¢\u0006\u0004\u0008B\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\u0008E\u0010FJ$\u0010I\u001a\u0008\u0012\u0004\u0012\u00020\u00030G2\u0006\u0010\u0010\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\u0008H\u0010,J+\u0010J\u001a\u00020\u0003*\u0006\u0012\u0002\u0008\u0003072\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\u0008\u00030\u001dH\u0002¢\u0006\u0004\u0008J\u0010KR\u0014\u0010M\u001a\u00020D8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008L\u0010FR\u001a\u0010P\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008N\u0010OR\u001a\u0010R\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008Q\u0010OR\u0014\u0010S\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\u0008S\u0010TR\u0014\u0010U\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\u0008U\u0010TR\u0011\u0010V\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008V\u0010TR\u0014\u0010W\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008W\u0010TR#\u0010[\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u0000060X8F¢\u0006\u0006\u001a\u0004\u0008Y\u0010ZR.\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00048\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\u0008\u0005\u0010\\R\u001a\u0010^\u001a\u00020]8\u0004X\u0084\u0004¢\u0006\u000c\n\u0004\u0008^\u0010_\u001a\u0004\u0008`\u0010aR\u0014\u0010c\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008b\u0010F\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006h", d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class c<E>  implements kotlinx.coroutines.channels.w<E> {

    private static final AtomicReferenceFieldUpdater c;
    protected final l<E, w> a;
    private final m b;
    private volatile Object onCloseHandler = null;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u0000*\u0006\u0008\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\u000c\u001a\u00020\u000b2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0015", d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends kotlinx.coroutines.channels.v {

        public final E v;
        public a(E e) {
            super();
            this.v = e;
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

        @Override // kotlinx.coroutines.channels.v
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SendBuffered@");
            stringBuilder.append(r0.b(this));
            stringBuilder.append('(');
            stringBuilder.append(this.v);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // kotlinx.coroutines.channels.v
        public void y() {
        }

        @Override // kotlinx.coroutines.channels.v
        public Object z() {
            return this.v;
        }
    }
    static {
        c.c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");
    }

    public c(l<? super E, w> l) {
        super();
        this.a = l;
        m obj1 = new m();
        this.b = obj1;
        obj1 = 0;
    }

    private final int a() {
        Object obj;
        int i;
        boolean z;
        final m mVar = this.b;
        obj = mVar.o();
        i = 0;
        while (!n.b(obj, mVar)) {
            if (obj instanceof o) {
            }
            obj = obj.p();
            i++;
        }
        return i;
    }

    private final String i() {
        o stringBuilder;
        String string;
        stringBuilder = this.b.p();
        if (stringBuilder == this.b) {
            return "EmptyQueue";
        }
        if (stringBuilder instanceof l) {
            string = stringBuilder.toString();
        } else {
            if (stringBuilder instanceof r) {
                string = "ReceiveQueued";
            } else {
                if (stringBuilder instanceof v) {
                    string = "SendQueued";
                } else {
                    string = n.o("UNEXPECTED:", stringBuilder);
                }
            }
        }
        o oVar = this.b.q();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string);
        stringBuilder2.append(",queueSize=");
        stringBuilder2.append(a());
        if (oVar != stringBuilder && oVar instanceof l) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(",queueSize=");
            stringBuilder2.append(a());
            if (oVar instanceof l) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder.append(",closedForSend=");
                stringBuilder.append(oVar);
                string = stringBuilder.toString();
            }
        }
        return string;
    }

    private final void j(kotlinx.coroutines.channels.l<?> l) {
        int i2;
        int i;
        Object obj;
        int i3;
        boolean z;
        i2 = 0;
        i = 1;
        obj = l.b(i2, i, i2);
        while (i3 instanceof r) {
            if (i3 != 0) {
            }
            if (!i3.u()) {
            } else {
            }
            obj = l.c(obj, i3);
            i3 = i2;
            i3.r();
        }
        if (obj == null) {
        } else {
            if (obj instanceof ArrayList == null) {
                (r)obj.A(l);
            } else {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                if (size -= i >= 0) {
                }
            }
        }
        n(l);
    }

    private final Throwable k(kotlinx.coroutines.channels.l<?> l) {
        j(l);
        return l.G();
    }

    private final void l(Throwable throwable) {
        z compareAndSet;
        AtomicReferenceFieldUpdater field;
        final Object onCloseHandler = this.onCloseHandler;
        compareAndSet = b.e;
        if (onCloseHandler != null && onCloseHandler != compareAndSet && c.c.compareAndSet(this, onCloseHandler, compareAndSet)) {
            compareAndSet = b.e;
            if (onCloseHandler != compareAndSet) {
                if (c.c.compareAndSet(this, onCloseHandler, compareAndSet)) {
                    g0.e(onCloseHandler, 1);
                    (l)onCloseHandler.invoke(throwable);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.w
    public boolean d(Throwable throwable) {
        o lVar;
        boolean z;
        int i;
        int i2;
        lVar = new l(throwable);
        final m mVar2 = this.b;
        z = mVar2.q();
        while (z2 ^= i2 == 0) {
            if (!z.j(lVar, mVar2)) {
                break;
            }
            z = mVar2.q();
        }
        i2 = 0;
        if (i2 != 0) {
        } else {
            lVar = this.b.q();
        }
        j(lVar);
        if (i2 != 0) {
            l(throwable);
        }
        return i2;
    }

    @Override // kotlinx.coroutines.channels.w
    protected String e() {
        return "";
    }

    protected final kotlinx.coroutines.channels.l<?> f() {
        o oVar;
        o i;
        if (oVar instanceof l) {
        } else {
            oVar = i;
        }
        if (oVar == null) {
        } else {
            j(oVar);
            i = oVar;
        }
        return i;
    }

    protected final kotlinx.coroutines.channels.l<?> g() {
        o oVar;
        o i;
        if (oVar instanceof l) {
        } else {
            oVar = i;
        }
        if (oVar == null) {
        } else {
            j(oVar);
            i = oVar;
        }
        return i;
    }

    @Override // kotlinx.coroutines.channels.w
    protected final m h() {
        return this.b;
    }

    protected Object m(E e) {
        z zVar;
        boolean z;
        final kotlinx.coroutines.channels.t tVar = p();
        while (tVar == null) {
            zVar = tVar.g(e, 0);
            tVar = p();
        }
        return b.c;
    }

    @Override // kotlinx.coroutines.channels.w
    protected void n(o o) {
    }

    protected final kotlinx.coroutines.channels.t<?> o(E e) {
        boolean z;
        Object obj4;
        final m mVar = this.b;
        c.a aVar = new c.a(e);
        obj4 = mVar.q();
        while (obj4 instanceof t) {
            obj4 = mVar.q();
        }
        return (t)obj4;
    }

    protected kotlinx.coroutines.channels.t<E> p() {
        Object obj;
        o oVar;
        boolean z;
        final m mVar = this.b;
        obj = mVar.o();
        while ((o)obj == mVar) {
            oVar = obj.v();
            if (oVar != null) {
                break;
            }
            oVar.s();
            obj = mVar.o();
        }
        obj = oVar;
        return (t)obj;
    }

    @Override // kotlinx.coroutines.channels.w
    protected final kotlinx.coroutines.channels.v q() {
        Object obj;
        o oVar;
        boolean z;
        final m mVar = this.b;
        obj = mVar.o();
        while ((o)obj == mVar) {
            oVar = obj.v();
            if (oVar != null) {
                break;
            }
            oVar.s();
            obj = mVar.o();
        }
        obj = oVar;
        return (v)obj;
    }

    public void s(l<? super Throwable, w> l) {
        AtomicReferenceFieldUpdater compareAndSet;
        z zVar;
        compareAndSet = c.c;
        Object obj4 = this.onCloseHandler;
        if (!compareAndSet.compareAndSet(this, 0, l) && obj4 == b.e) {
            obj4 = this.onCloseHandler;
            if (obj4 == b.e) {
                obj4 = new IllegalStateException("Another handler was already registered and successfully invoked");
                throw obj4;
            }
            IllegalStateException illegalStateException = new IllegalStateException(n.o("Another handler was already registered: ", obj4));
            throw illegalStateException;
        }
        kotlinx.coroutines.channels.l lVar = g();
        if (lVar != null && compareAndSet.compareAndSet(this, l, b.e)) {
            if (compareAndSet.compareAndSet(this, l, b.e)) {
                l.invoke(lVar.v);
            }
        }
    }

    @Override // kotlinx.coroutines.channels.w
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r0.a(this));
        stringBuilder.append('@');
        stringBuilder.append(r0.b(this));
        stringBuilder.append('{');
        stringBuilder.append(i());
        stringBuilder.append('}');
        stringBuilder.append(e());
        return stringBuilder.toString();
    }

    public final Object u(E e) {
        Object obj;
        Object obj2;
        obj2 = m(e);
        if (obj2 == b.b) {
            i.b.c(w.a);
            return obj;
        } else {
            if (obj2 == b.c) {
                obj2 = g();
                if (obj2 == null) {
                    return i.b.b();
                }
                obj = i.b.a(k(obj2));
            } else {
                if (!obj2 instanceof l) {
                } else {
                    obj = i.b.a(k((l)obj2));
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("trySend returned ", obj2).toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.channels.w
    public final boolean v() {
        int i;
        i = g() != null ? 1 : 0;
        return i;
    }
}
