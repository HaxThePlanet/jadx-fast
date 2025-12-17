package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.d0.c.l;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.internal.y;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a4\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aI\u0010\u0008\u001a\u0004\u0018\u00010\u0004\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012%\u0008\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a.\u0010\u0008\u001a\u0004\u0018\u00010\u0004\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u0012H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0014", d2 = {"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class e0 {
    public static final <T> Object a(Object object, d<? super T> d2) {
        boolean z;
        Object obj1;
        Object obj2;
        if (object instanceof b0) {
            kotlin.p.a aVar = p.a;
            if (q0.d()) {
                if (!d2 instanceof e) {
                } else {
                    obj1 = y.a(object.a, (e)d2);
                }
            }
            p.a(q.a(obj1));
        } else {
            obj2 = p.a;
            p.a((b0)object);
        }
        return obj1;
    }

    public static final <T> Object b(Object object, l<? super Throwable, w> l2) {
        Object c0Var;
        int i;
        int i2;
        Object obj3;
        int obj4;
        c0Var = p.c(object);
        if (c0Var == null) {
            if (l2 != null) {
                c0Var = new c0(object, l2);
                obj3 = c0Var;
            }
        } else {
            obj3 = new b0(c0Var, 0, 2, 0);
        }
        return obj3;
    }

    public static final <T> Object c(Object object, kotlinx.coroutines.p<?> p2) {
        Throwable th;
        int i2;
        boolean z;
        int i;
        Object obj3;
        int obj4;
        th = p.c(object);
        if (th == null) {
        } else {
            if (q0.d()) {
                if (!p2 instanceof e) {
                } else {
                    th = y.a(th, (e)p2);
                }
            }
            obj3 = new b0(th, 0, 2, 0);
        }
        return obj3;
    }

    public static Object d(Object object, l l2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return e0.b(object, obj1);
    }
}
