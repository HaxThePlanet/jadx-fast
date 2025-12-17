package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.d0.c.q;
import kotlin.d0.d.g0;
import kotlin.d0.d.k;
import kotlin.w;
import kotlinx.coroutines.b3.e;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\">\u0010\u0000\u001a,\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"emitFun", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/coroutines/Continuation;", "", "getEmitFun$annotations", "()V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class f {

    private static final q<e<Object>, Object, d<? super w>, Object> a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<e<? super Object>, Object, w> {

        public static final kotlinx.coroutines.flow.internal.f.a a;
        static {
            f.a aVar = new f.a();
            f.a.a = aVar;
        }

        a() {
            super(3, e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((e)object, object2, (d)object3);
        }

        public final Object l(e<Object> e, Object object2, d<? super w> d3) {
            return e.b(object2, d3);
        }
    }
    static {
        final kotlinx.coroutines.flow.internal.f.a aVar = f.a.a;
        g0.e(aVar, 3);
        f.a = (q)aVar;
    }

    public static final q a() {
        return f.a;
    }
}
