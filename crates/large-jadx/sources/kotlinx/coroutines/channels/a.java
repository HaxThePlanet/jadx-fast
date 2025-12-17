package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.h;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.i;
import kotlinx.coroutines.internal.l;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.o.b;
import kotlinx.coroutines.internal.o.c;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008 \u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0002\u0010\u0008J\u0012\u0010\u0019\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\u0008\u001fJ\u000e\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001a\u00020\n2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001a\u00020\n2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001a\u00020\n\"\u0004\u0008\u0001\u0010'2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H'0)2$\u0010*\u001a \u0008\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0002\u00100J\u000f\u00101\u001a\u0008\u0012\u0004\u0012\u00028\u000002H\u0086\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0014J/\u00105\u001a\u00020\u00062\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u000208072\n\u00109\u001a\u0006\u0012\u0002\u0008\u00030:H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008;\u0010<J\u0008\u0010=\u001a\u00020\u0006H\u0014J\u0008\u0010>\u001a\u00020\u0006H\u0014J\n\u0010?\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001a\u0004\u0018\u00010,2\n\u0010(\u001a\u0006\u0012\u0002\u0008\u00030)H\u0014J\u0011\u0010#\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\"\u0010B\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\u0008C\u0010AJ\u001f\u0010D\u001a\u0002H'\"\u0004\u0008\u0001\u0010'2\u0006\u0010.\u001a\u00020/H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJR\u0010F\u001a\u00020\u0006\"\u0004\u0008\u0001\u0010'2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2$\u0010*\u001a \u0008\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002ø\u0001\u0000¢\u0006\u0002\u0010GJ \u0010H\u001a\u00020\u00062\n\u0010I\u001a\u0006\u0012\u0002\u0008\u00030J2\n\u0010#\u001a\u0006\u0012\u0002\u0008\u00030$H\u0002J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001c\u0010M\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\u0008N\u0010OJX\u0010P\u001a\u00020\u0006\"\u0004\u0008\u0001\u0010'* \u0008\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2\u0008\u0010Q\u001a\u0004\u0018\u00010,H\u0002ø\u0001\u0000¢\u0006\u0002\u0010RR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0012\u0010\r\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0012\u0010\u000e\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000cR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000cR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000cR\u0014\u0010\u0011\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000cR\u0017\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00138F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00170\u00138Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0015\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Z", d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class a<E>  extends kotlinx.coroutines.channels.c<E> implements kotlinx.coroutines.channels.f<E> {

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0012\u0018\u0000*\u0006\u0008\u0001\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000cJ\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\u0008\u00030\u000fH\u0016J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00028\u00012\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static class a extends kotlinx.coroutines.channels.r<E> {

        public final p<Object> v;
        public final int w;
        public a(p<Object> p, int i2) {
            super();
            this.v = p;
            this.w = i2;
        }

        public void A(kotlinx.coroutines.channels.l<?> l) {
            p pVar;
            kotlin.p.a aVar;
            Object obj3;
            if (this.w == 1) {
                obj3 = i.b(i.b.a(l.v));
                aVar = p.a;
                p.a(obj3);
                this.v.resumeWith(obj3);
            } else {
                aVar = p.a;
                obj3 = q.a(l.F());
                p.a(obj3);
                this.v.resumeWith(obj3);
            }
        }

        public final Object B(E e) {
            int i;
            Object obj3;
            if (this.w == 1) {
                i.b.c(e);
                obj3 = i.b(e);
            }
            return obj3;
        }

        public void f(E e) {
            this.v.x(r.a);
        }

        public z g(E e, o.c o$c2) {
            boolean z;
            int i;
            int obj5;
            final int i2 = 0;
            i = c2 == null ? i2 : c2.a;
            obj5 = this.v.j(B(e), i, z(e));
            if (obj5 == null) {
                return i2;
            }
            if (q0.a()) {
                obj5 = obj5 == r.a ? 1 : 0;
                if (obj5 == null) {
                } else {
                }
                obj5 = new AssertionError();
                throw obj5;
            }
            if (c2 != null) {
            } else {
                return r.a;
            }
            c2.d();
            throw i2;
        }

        @Override // kotlinx.coroutines.channels.r
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ReceiveElement@");
            stringBuilder.append(r0.b(this));
            stringBuilder.append("[receiveMode=");
            stringBuilder.append(this.w);
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000*\u0006\u0008\u0001\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\u0008\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\u0008\u0012\u0004\u0012\u00028\u0001`\u000b¢\u0006\u0002\u0010\u000cJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R&\u0010\u0008\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\u0008\u0012\u0004\u0012\u00028\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class b extends kotlinx.coroutines.channels.a.a<E> {

        public final l<E, w> x;
        public b(p<Object> p, int i2, l<? super E, w> l3) {
            super(p, i2);
            this.x = l3;
        }

        public l<Throwable, w> z(E e) {
            return u.a(this.x, e, this.v.getContext());
        }
    }

    @Metadata(d1 = "\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000", d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends o.b {

        final kotlinx.coroutines.channels.a d;
        public d(o o, kotlinx.coroutines.channels.a a2) {
            this.d = a2;
            super(o);
        }

        @Override // kotlinx.coroutines.internal.o$b
        public Object g(Object object) {
            return i((o)object);
        }

        @Override // kotlinx.coroutines.internal.o$b
        public Object i(o o) {
            int obj1;
            if (this.d.A()) {
                obj1 = 0;
            } else {
                obj1 = n.a();
            }
            return obj1;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = 633, m = "receiveCatching-JP2dKIU")
    static final class e extends d {

        int label;
        Object result;
        final kotlinx.coroutines.channels.a<E> this$0;
        e(kotlinx.coroutines.channels.a<E> a, d<? super kotlinx.coroutines.channels.a.e> d2) {
            this.this$0 = a;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            Object obj2 = this.this$0.b(this);
            if (obj2 == b.d()) {
                return obj2;
            }
            return i.b(obj2);
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class c extends i {

        private final kotlinx.coroutines.channels.r<?> a;
        final kotlinx.coroutines.channels.a<E> b;
        public c(kotlinx.coroutines.channels.a a, kotlinx.coroutines.channels.r r2) {
            this.b = a;
            super();
            this.a = r2;
        }

        @Override // kotlinx.coroutines.i
        public void a(Throwable throwable) {
            boolean obj1;
            if (this.a.u()) {
                this.b.E();
            }
        }

        @Override // kotlinx.coroutines.i
        public Object invoke(Object object) {
            a((Throwable)object);
            return w.a;
        }

        @Override // kotlinx.coroutines.i
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RemoveReceiveOnCancel[");
            stringBuilder.append(this.a);
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }
    public a(l<? super E, w> l) {
        super(l);
    }

    private final <R> Object H(int i, d<? super R> d2) {
        kotlinx.coroutines.channels.a.a bVar;
        Object obj;
        int obj4;
        q qVar = s.b(b.c(d2));
        if (this.a == null) {
            bVar = new a.a(qVar, i);
        } else {
            bVar = new a.b(qVar, i, this.a);
        }
        while (a.r(this, bVar)) {
            obj4 = G();
        }
        a.t(this, qVar, bVar);
        obj4 = qVar.y();
        if (obj4 == b.d()) {
            h.c(d2);
        }
        return obj4;
    }

    private final void I(p<?> p, kotlinx.coroutines.channels.r<?> r2) {
        a.c cVar = new a.c(this, r2);
        p.g(cVar);
    }

    public static final boolean r(kotlinx.coroutines.channels.a a, kotlinx.coroutines.channels.r r2) {
        return a.x(r2);
    }

    public static final void t(kotlinx.coroutines.channels.a a, p p2, kotlinx.coroutines.channels.r r3) {
        a.I(p2, r3);
    }

    private final boolean x(kotlinx.coroutines.channels.r<? super E> r) {
        final boolean obj1 = y(r);
        if (obj1 != null) {
            F();
        }
        return obj1;
    }

    @Override // kotlinx.coroutines.channels.c
    protected abstract boolean A();

    @Override // kotlinx.coroutines.channels.c
    public boolean B() {
        kotlinx.coroutines.channels.l lVar;
        int i;
        if (f() != null && A()) {
            i = A() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.channels.c
    protected void C(boolean z) {
        Object obj;
        int i;
        boolean z3;
        boolean z2;
        kotlinx.coroutines.channels.l obj4 = g();
        if (obj4 == null) {
        } else {
            i = 0;
            obj = l.b(i, 1, i);
            i = obj4.q();
            while (i instanceof m) {
                if (!i.u()) {
                } else {
                }
                obj = l.c(obj, (v)i);
                i = obj4.q();
                i.r();
            }
            D(obj, obj4);
        }
        obj4 = new IllegalStateException("Cannot happen".toString());
        throw obj4;
    }

    protected void D(Object object, kotlinx.coroutines.channels.l<?> l2) {
        int i;
        int i2;
        if (object == null) {
        } else {
            if (object instanceof ArrayList == null) {
                (v)object.A(l2);
            } else {
                Objects.requireNonNull(object, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                if (size-- >= 0) {
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.c
    protected void E() {
    }

    @Override // kotlinx.coroutines.channels.c
    protected void F() {
    }

    @Override // kotlinx.coroutines.channels.c
    protected Object G() {
        z zVar;
        boolean z;
        kotlinx.coroutines.channels.v vVar = q();
        while (vVar == null) {
            zVar = vVar.B(0);
            vVar.C();
            vVar = q();
        }
        return b.d;
    }

    public final Object b(d<? super kotlinx.coroutines.channels.i<? extends E>> d) {
        boolean eVar;
        kotlinx.coroutines.channels.i.b bVar;
        int label2;
        int i2;
        int label;
        int i;
        Object obj5;
        eVar = d;
        label2 = eVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof a.e && label2 & i2 != 0) {
            eVar = d;
            label2 = eVar.label;
            i2 = Integer.MIN_VALUE;
            if (label2 & i2 != 0) {
                eVar.label = label2 -= i2;
            } else {
                eVar = new a.e(this, d);
            }
        } else {
        }
        obj5 = eVar.result;
        Object obj = b.d();
        label = eVar.label;
        int i3 = 1;
        if (label != 0) {
            if (label != i3) {
            } else {
                q.b(obj5);
                return (i)obj5.k();
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj5);
        obj5 = G();
        if (obj5 != b.d) {
            if (obj5 instanceof l) {
                obj5 = i.b.a(obj5.v);
            } else {
                i.b.c((l)obj5);
            }
            return obj5;
        }
        eVar.label = i3;
        if (H(i3, eVar) == obj) {
            return obj;
        }
    }

    @Override // kotlinx.coroutines.channels.c
    public final void c(CancellationException cancellationException) {
        boolean z;
        String str;
        CancellationException obj3;
        if (B()) {
        }
        if (cancellationException == null) {
            obj3 = new CancellationException(n.o(r0.a(this), " was cancelled"));
        }
        w(obj3);
    }

    protected kotlinx.coroutines.channels.t<E> p() {
        boolean z;
        final kotlinx.coroutines.channels.t tVar = super.p();
        if (tVar != null && !tVar instanceof l) {
            if (!tVar instanceof l) {
                E();
            }
        }
        return tVar;
    }

    @Override // kotlinx.coroutines.channels.c
    public final boolean w(Throwable throwable) {
        final boolean obj1 = d(throwable);
        C(obj1);
        return obj1;
    }

    protected boolean y(kotlinx.coroutines.channels.r<? super E> r) {
        kotlinx.coroutines.internal.m mVar;
        int i3;
        Object dVar;
        int i;
        int i2;
        i3 = 0;
        final int i4 = 1;
        if (z()) {
            mVar = h();
            dVar = mVar.q();
            while (z2 ^= i4 == 0) {
                dVar = mVar.q();
            }
        } else {
            mVar = h();
            dVar = new a.d(r, this);
            i = mVar.q();
            while (z3 ^= i4 == 0) {
                i = i.x(r, mVar, dVar);
                if (i != 2) {
                    break;
                }
                i = mVar.q();
            }
        }
        return i3;
    }

    @Override // kotlinx.coroutines.channels.c
    protected abstract boolean z();
}
