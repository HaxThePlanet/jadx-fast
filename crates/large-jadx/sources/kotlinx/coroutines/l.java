package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.e;
import kotlin.b0.g;
import kotlin.b0.h;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.c3.a;
import kotlinx.coroutines.c3.b;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.x;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001aU\u0010\u0004\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072'\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\rH\u0086@ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u000e\u001a[\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0010\"\u0004\u0008\u0000\u0010\u0005*\u00020\n2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aF\u0010\u0014\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u0005*\u00020\u00152)\u0008\u0008\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\rH\u0086Jø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aO\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"RESUMED", "", "SUSPENDED", "UNDECIDED", "withContext", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "async", "Lkotlinx/coroutines/Deferred;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launch", "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final class l {
    public static final <T> kotlinx.coroutines.u0<T> a(kotlinx.coroutines.m0 m0, g g2, kotlinx.coroutines.o0 o03, p<? super kotlinx.coroutines.m0, ? super d<? super T>, ? extends Object> p4) {
        int i;
        kotlinx.coroutines.v0 obj2;
        final g obj1 = g0.c(m0, g2);
        if (o03.isLazy()) {
            obj2 = new h2(obj1, p4);
        } else {
            obj2 = new v0(obj1, 1);
        }
        obj2.J0(o03, obj2, p4);
        return obj2;
    }

    public static kotlinx.coroutines.u0 b(kotlinx.coroutines.m0 m0, g g2, kotlinx.coroutines.o0 o03, p p4, int i5, Object object6) {
        h obj1;
        kotlinx.coroutines.o0 obj2;
        if (i5 & 1 != 0) {
            obj1 = h.a;
        }
        if (i5 &= 2 != 0) {
            obj2 = o0.DEFAULT;
        }
        return k.a(m0, obj1, obj2, p4);
    }

    public static final kotlinx.coroutines.y1 c(kotlinx.coroutines.m0 m0, g g2, kotlinx.coroutines.o0 o03, p<? super kotlinx.coroutines.m0, ? super d<? super w>, ? extends Object> p4) {
        int i;
        kotlinx.coroutines.q2 obj2;
        final g obj1 = g0.c(m0, g2);
        if (o03.isLazy()) {
            obj2 = new i2(obj1, p4);
        } else {
            obj2 = new q2(obj1, 1);
        }
        obj2.J0(o03, obj2, p4);
        return obj2;
    }

    public static kotlinx.coroutines.y1 d(kotlinx.coroutines.m0 m0, g g2, kotlinx.coroutines.o0 o03, p p4, int i5, Object object6) {
        h obj1;
        kotlinx.coroutines.o0 obj2;
        if (i5 & 1 != 0) {
            obj1 = h.a;
        }
        if (i5 &= 2 != 0) {
            obj2 = o0.DEFAULT;
        }
        return k.c(m0, obj1, obj2, p4);
    }

    public static final <T> Object e(g g, p<? super kotlinx.coroutines.m0, ? super d<? super T>, ? extends Object> p2, d<? super T> d3) {
        x y2Var;
        Object obj;
        Object obj2;
        kotlinx.coroutines.y0 y0Var;
        kotlinx.coroutines.y0 y0Var2;
        int i2;
        int i;
        int i3;
        Object obj8;
        Object obj9;
        g context = d3.getContext();
        obj8 = context.plus(g);
        b2.g(obj8);
        if (obj8 == context) {
            y2Var = new x(obj8, d3);
            obj8 = b.c(y2Var, y2Var, p2);
        } else {
            obj = e.p;
            if (n.b(obj8.get(obj), context.get(obj))) {
                y2Var = new y2(obj8, d3);
                d0.a(obj8, d0.c(obj8, 0));
                obj8 = obj9;
            } else {
                y2Var = new y0(obj8, d3);
                a.f(p2, y2Var, y2Var, 0, 4, 0);
                obj8 = y2Var.L0();
            }
        }
        if (obj8 == b.d()) {
            h.c(d3);
        }
        return obj8;
    }
}
