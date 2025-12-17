package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.d0.c.l;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.u2;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.y2;
import kotlinx.coroutines.z0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a;\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\u0008\u00030\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00072\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fH\u0082\u0008\u001aU\u0010\u0011\u001a\u00020\u0010\"\u0004\u0008\u0000\u0010\u0012*\u0008\u0012\u0004\u0012\u0002H\u00120\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u00152%\u0008\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u0007*\u0008\u0012\u0004\u0012\u00020\u00100\u0008H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0003\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001e", d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "getREUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "getUNDEFINED$annotations", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class h {

    private static final kotlinx.coroutines.internal.z a;
    public static final kotlinx.coroutines.internal.z b;
    static {
        z zVar = new z("UNDEFINED");
        h.a = zVar;
        z zVar2 = new z("REUSABLE_CLAIMED");
        h.b = zVar2;
    }

    public static final kotlinx.coroutines.internal.z a() {
        return h.a;
    }

    public static final <T> void b(d<? super T> d, Object object2, l<? super Throwable, w> l3) {
        boolean z2;
        boolean i;
        Throwable z;
        Object bVar;
        boolean context;
        d dVar;
        Object obj7;
        int obj8;
        if (d instanceof g) {
            obj8 = e0.b(object2, l3);
            i = 1;
            if (d.v.L((g)d.getContext())) {
                d.x = obj8;
                d.c = i;
                d.v.K(d.getContext(), d);
            } else {
                boolean z3 = q0.a();
                z2 = u2.a.a();
                if (z2.g0()) {
                    d.x = obj8;
                    d.c = i;
                    z2.U(d);
                } else {
                    z2.Y(i);
                    bVar = d.getContext().get(y1.s);
                    if (bVar != null && !(y1)bVar.a()) {
                        if (!bVar.a()) {
                            bVar = bVar.n();
                            d.b(obj8, bVar);
                            obj8 = p.a;
                            obj8 = q.a(bVar);
                            p.a(obj8);
                            d.resumeWith(obj8);
                            obj8 = i;
                        } else {
                            obj8 = 0;
                        }
                    } else {
                    }
                    if (obj8 == null) {
                        obj8 = d.w;
                        context = obj8.getContext();
                        bVar = d0.c(context, d.y);
                        if (bVar != d0.a) {
                            obj8 = g0.e(obj8, context, bVar);
                        } else {
                            obj8 = z;
                        }
                        d.w.resumeWith(object2);
                        obj7 = w.a;
                        if (obj8 != null) {
                            if (obj8.L0()) {
                                d0.a(context, bVar);
                            }
                        } else {
                        }
                    }
                    while (z2.l0() == null) {
                    }
                    z2.M(i);
                }
            }
        } else {
            d.resumeWith(object2);
        }
    }

    public static void c(d d, Object object2, l l3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        h.b(d, object2, obj2);
    }
}
