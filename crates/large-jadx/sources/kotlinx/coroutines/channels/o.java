package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.h;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.h;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.p;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.y1;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u00022\u000e\u0008\u0002\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u009e\u0001\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2-\u0008\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a¨\u0001\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2-\u0008\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\u0008\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001ae\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006 ", d2 = {"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class o {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = 157, m = "awaitClose")
    static final class a extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        a(d<? super kotlinx.coroutines.channels.o.a> d) {
            super(d);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int obj2 = 0;
            return o.a(obj2, obj2, this);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        public static final kotlinx.coroutines.channels.o.b a;
        static {
            o.b bVar = new o.b();
            o.b.a = bVar;
        }

        b() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {

        final p<w> $cont;
        c(p<? super w> p) {
            this.$cont = p;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            final w wVar = w.a;
            final kotlin.p.a aVar = p.a;
            p.a(wVar);
            this.$cont.resumeWith(wVar);
        }
    }
    public static final Object a(kotlinx.coroutines.channels.q<?> q, a<w> a2, d<? super w> d3) {
        boolean aVar;
        int label;
        int i2;
        kotlinx.coroutines.channels.o.c cVar;
        int i;
        Object obj4;
        Object obj5;
        Object obj6;
        aVar = d3;
        label = aVar.label;
        i2 = Integer.MIN_VALUE;
        if (d3 instanceof o.a && label & i2 != 0) {
            aVar = d3;
            label = aVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                aVar.label = label -= i2;
            } else {
                aVar = new o.a(d3);
            }
        } else {
        }
        obj6 = aVar.result;
        Object obj = b.d();
        cVar = aVar.label;
        int i3 = 1;
        if (cVar != 0) {
            if (cVar != i3) {
            } else {
                obj5 = obj4;
                obj4 = aVar.L$0;
                q.b(obj6);
                obj5.invoke();
                return w.a;
            }
            obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
        q.b(obj6);
        obj6 = aVar.getContext().get(y1.s) == q ? i3 : 0;
        if (obj6 == null) {
        } else {
            aVar.L$0 = q;
            aVar.L$1 = a2;
            aVar.label = i3;
            obj6 = new q(b.c(aVar), i3);
            obj6.B();
            cVar = new o.c(obj6);
            q.s(cVar);
            obj4 = obj6.y();
            if (obj4 == b.d()) {
                h.c(aVar);
            }
            if (obj4 == obj) {
                return obj;
            }
        }
        obj4 = new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
        throw obj4;
    }

    public static Object b(kotlinx.coroutines.channels.q q, a a2, d d3, int i4, Object object5) {
        kotlinx.coroutines.channels.o.b obj1;
        if (i4 &= 1 != 0) {
            obj1 = o.b.a;
        }
        return o.a(q, obj1, d3);
    }

    public static final <E> kotlinx.coroutines.channels.s<E> c(m0 m0, g g2, int i3, kotlinx.coroutines.channels.e e4, o0 o05, l<? super Throwable, w> l6, p<? super kotlinx.coroutines.channels.q<? super E>, ? super d<? super w>, ? extends Object> p7) {
        final int i = 0;
        p obj3 = new p(g0.c(m0, g2), h.b(i3, e4, i, 4, i));
        if (l6 != null) {
            obj3.w(l6);
        }
        obj3.J0(o05, obj3, p7);
        return obj3;
    }

    public static kotlinx.coroutines.channels.s d(m0 m0, g g2, int i3, kotlinx.coroutines.channels.e e4, o0 o05, l l6, p p7, int i8, Object object9) {
        h obj8;
        int obj9;
        kotlinx.coroutines.channels.e obj10;
        o0 obj11;
        int obj12;
        if (i8 & 1 != 0) {
            obj8 = h.a;
        }
        if (i8 & 2 != 0) {
            obj9 = 0;
        }
        if (i8 & 4 != 0) {
            obj10 = e.SUSPEND;
        }
        if (i8 & 8 != 0) {
            obj11 = o0.DEFAULT;
        }
        if (i8 & 16 != 0) {
            obj12 = 0;
        }
        return o.c(m0, obj8, obj9, obj10, obj11, obj12, p7);
    }
}
