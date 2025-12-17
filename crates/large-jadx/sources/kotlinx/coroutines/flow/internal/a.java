package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.h;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.b3.d;
import kotlinx.coroutines.b3.e;
import kotlinx.coroutines.b3.f;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001f\u0010\u0017\u001a\u00020\u000e2\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u000e2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cH¤@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H$J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H\u0016J&\u0010!\u001a\u0008\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0016\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0008\u0010%\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R9\u0010\n\u001a$\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000c\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00088\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006&", d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "additionalToStringProps", "", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class a<T>  implements d {

    public final g a;
    public final int b;
    public final e c;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = 123, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final e<T> $collector;
        private Object L$0;
        int label;
        final kotlinx.coroutines.flow.internal.a<T> this$0;
        a(e<? super T> e, kotlinx.coroutines.flow.internal.a<T> a2, d<? super kotlinx.coroutines.flow.internal.a.a> d3) {
            this.$collector = e;
            this.this$0 = a2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (a.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            a.a aVar = new a.a(this.$collector, this.this$0, d2);
            aVar.L$0 = object;
            return aVar;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int $collector;
            kotlinx.coroutines.flow.internal.a this$0;
            Object obj5;
            Object obj = b.d();
            $collector = this.label;
            final int i = 1;
            if ($collector != 0) {
                if ($collector != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            this.label = i;
            if (f.c(this.$collector, this.this$0.g((m0)this.L$0), this) == obj) {
                return obj;
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@", d2 = {"<anonymous>", "", "T", "it", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = 60, m = "invokeSuspend")
    static final class b extends k implements p<q<? super T>, d<? super w>, Object> {

        Object L$0;
        int label;
        final kotlinx.coroutines.flow.internal.a<T> this$0;
        b(kotlinx.coroutines.flow.internal.a<T> a, d<? super kotlinx.coroutines.flow.internal.a.b> d2) {
            this.this$0 = a;
            super(2, d2);
        }

        public final Object c(q<? super T> q, d<? super w> d2) {
            return (a.b)create(q, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            a.b bVar = new a.b(this.this$0, d2);
            bVar.L$0 = object;
            return bVar;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((q)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            Object obj4;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            this.label = i;
            if (this.this$0.d((q)this.L$0, this) == obj) {
                return obj;
            }
        }
    }
    public a(g g, int i2, e e3) {
        boolean obj1;
        super();
        this.a = g;
        this.b = i2;
        this.c = e3;
        if (q0.a()) {
            obj1 = i2 != -1 ? 1 : 0;
            if (obj1 == null) {
            } else {
            }
            obj1 = new AssertionError();
            throw obj1;
        }
    }

    static Object c(kotlinx.coroutines.flow.internal.a a, e e2, d d3) {
        a.a aVar = new a.a(e2, a, 0);
        Object obj2 = n0.b(aVar, d3);
        if (obj2 == b.d()) {
            return obj2;
        }
        return w.a;
    }

    public Object a(e<? super T> e, d<? super w> d2) {
        return a.c(this, e, d2);
    }

    @Override // kotlinx.coroutines.b3.d
    protected String b() {
        return null;
    }

    protected abstract Object d(q<? super T> q, d<? super w> d2);

    public final p<q<? super T>, d<? super w>, Object> e() {
        a.b bVar = new a.b(this, 0);
        return bVar;
    }

    @Override // kotlinx.coroutines.b3.d
    public final int f() {
        int i;
        if (this.b == -3) {
            i = -2;
        }
        return i;
    }

    public s<T> g(m0 m0) {
        return o.d(m0, this.a, f(), this.c, o0.ATOMIC, 0, e(), 16, 0);
    }

    @Override // kotlinx.coroutines.b3.d
    public String toString() {
        Object gVar;
        int i;
        Object eVar;
        Object str;
        int str2;
        Object sUSPEND;
        ArrayList arrayList = new ArrayList(4);
        String str4 = b();
        if (str4 == null) {
        } else {
            arrayList.add(str4);
        }
        gVar = this.a;
        if (gVar != h.a) {
            arrayList.add(n.o("context=", gVar));
        }
        i = this.b;
        if (i != -3) {
            arrayList.add(n.o("capacity=", Integer.valueOf(i)));
        }
        eVar = this.c;
        if (eVar != e.SUSPEND) {
            arrayList.add(n.o("onBufferOverflow=", eVar));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r0.a(this));
        stringBuilder.append('[');
        stringBuilder.append(p.h0(arrayList, ", ", 0, 0, 0, 0, 0, 62, 0));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
