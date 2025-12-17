package kotlinx.coroutines.b3;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.j;
import kotlinx.coroutines.channels.s;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u001a\u001e\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a0\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H\u0007\u001a\u001c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\n\u001a/\u0010\u000b\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\r2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\r2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u001a&\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\n\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0017", d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class h {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {51, 62}, m = "emitAllImpl$FlowKt__ChannelsKt")
    static final class a extends d {

        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        Object result;
        a(d<? super kotlinx.coroutines.b3.h.a> d) {
            super(d);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int obj2 = 0;
            return h.a(obj2, obj2, false, this);
        }
    }
    public static final Object a(kotlinx.coroutines.b3.e e, s s2, boolean z3, d d4) {
        return h.c(e, s2, z3, d4);
    }

    public static final <T> Object b(kotlinx.coroutines.b3.e<? super T> e, s<? extends T> s2, d<? super w> d3) {
        Object obj1 = h.c(e, s2, true, d3);
        if (obj1 == b.d()) {
            return obj1;
        }
        return w.a;
    }

    private static final <T> Object c(kotlinx.coroutines.b3.e<? super T> e, s<? extends T> s2, boolean z3, d<? super w> d4) {
        boolean aVar;
        int label2;
        int i;
        int label;
        int i2;
        boolean z;
        Throwable th;
        Object obj7;
        Object obj8;
        Throwable obj9;
        Object obj10;
        aVar = d4;
        label2 = aVar.label;
        i = Integer.MIN_VALUE;
        if (d4 instanceof h.a && label2 & i != 0) {
            aVar = d4;
            label2 = aVar.label;
            i = Integer.MIN_VALUE;
            if (label2 & i != 0) {
                aVar.label = label2 -= i;
            } else {
                aVar = new h.a(d4);
            }
        } else {
        }
        obj10 = aVar.result;
        Object obj = b.d();
        label = aVar.label;
        int i3 = 2;
        final int i4 = 1;
        if (label != 0) {
            if (label != i4) {
                if (label != i3) {
                } else {
                    obj7 = aVar.Z$0;
                    obj8 = aVar.L$1;
                    obj9 = aVar.L$0;
                    q.b(obj10);
                    obj9 = obj7;
                    obj7 = th;
                    aVar.L$0 = obj7;
                    aVar.L$1 = obj8;
                    aVar.Z$0 = obj9;
                    aVar.label = i4;
                    if (obj8.b(aVar) != obj) {
                    }
                }
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
            }
            obj7 = aVar.Z$0;
            obj8 = aVar.L$1;
            obj9 = aVar.L$0;
            q.b(obj10);
            obj10 = (i)obj10.k();
            if (i.h(obj10)) {
                obj9 = i.e(obj10);
                if (obj9 != null) {
                } else {
                    if (obj7 != null) {
                        j.a(obj8, 0);
                    }
                    return w.a;
                }
                throw obj9;
            } else {
            }
        } else {
        }
        return obj;
    }
}
