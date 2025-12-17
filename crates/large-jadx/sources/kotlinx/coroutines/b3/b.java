package kotlinx.coroutines.b3;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.h;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.channels.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002BU\u0012-\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0004¢\u0006\u0002\u0008\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00072\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R:\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0004¢\u0006\u0002\u0008\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0017", d2 = {"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class b<T>  extends kotlinx.coroutines.b3.c<T> {

    private final p<q<? super T>, d<? super w>, Object> e;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = 355, m = "collectTo")
    static final class a extends d {

        Object L$0;
        int label;
        Object result;
        final kotlinx.coroutines.b3.b<T> this$0;
        a(kotlinx.coroutines.b3.b<T> b, d<? super kotlinx.coroutines.b3.b.a> d2) {
            this.this$0 = b;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.d(0, this);
        }
    }
    public b(p<? super q<? super T>, ? super d<? super w>, ? extends Object> p, g g2, int i3, e e4) {
        super(p, g2, i3, e4);
        this.e = p;
    }

    public b(p p, g g2, int i3, e e4, int i5, g g6) {
        h obj2;
        int obj3;
        e obj4;
        obj2 = i5 & 2 != 0 ? h.a : obj2;
        obj3 = i5 & 4 != 0 ? -2 : obj3;
        obj4 = i5 &= 8 != 0 ? e.SUSPEND : obj4;
        super(p, obj2, obj3, obj4);
    }

    protected Object d(q<? super T> q, d<? super w> d2) {
        boolean aVar;
        int label;
        int i;
        int i2;
        Object obj5;
        Object obj6;
        aVar = d2;
        label = aVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof b.a && label & i != 0) {
            aVar = d2;
            label = aVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                aVar.label = label -= i;
            } else {
                aVar = new b.a(this, d2);
            }
        } else {
        }
        obj6 = aVar.result;
        Object obj = b.d();
        int label2 = aVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                obj5 = aVar.L$0;
                q.b(obj6);
                if (!obj5.v()) {
                } else {
                    return w.a;
                }
                obj5 = new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
                throw obj5;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        aVar.L$0 = q;
        aVar.label = i3;
        if (super.d(q, aVar) == obj) {
            return obj;
        }
    }
}
