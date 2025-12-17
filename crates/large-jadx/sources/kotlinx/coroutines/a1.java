package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.internal.d0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u000c\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\u000f2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\u0008\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\u0008\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\u0008\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\u0008\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001dH\u0080\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0008\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\n¨\u0006\u001e", d2 = {"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class a1 {
    public static final <T> void a(kotlinx.coroutines.z0<? super T> z0, int i2) {
        int z;
        Object context;
        int i3;
        boolean i;
        kotlinx.coroutines.h0 obj5;
        i = 0;
        if (q0.a()) {
            z = i2 != -1 ? i3 : i;
            if (z == 0) {
            } else {
            }
            AssertionError obj4 = new AssertionError();
            throw obj4;
        }
        context = z0.c();
        if (i2 == 4) {
        } else {
            i3 = i;
        }
        if (i3 == 0 && context instanceof g && a1.b(i2) == a1.b(z0.c)) {
            if (context instanceof g) {
                if (a1.b(i2) == a1.b(z0.c)) {
                    obj5 = obj5.v;
                    context = context.getContext();
                    if (obj5.L(context)) {
                        obj5.K(context, z0);
                    } else {
                        a1.e(z0);
                    }
                } else {
                    a1.d(z0, context, i3);
                }
            } else {
            }
        } else {
        }
    }

    public static final boolean b(int i) {
        int i3;
        int i2;
        if (i != 1) {
            if (i == 2) {
            } else {
                i3 = 0;
            }
        }
        return i3;
    }

    public static final boolean c(int i) {
        int obj1;
        obj1 = i == 2 ? 1 : 0;
        return obj1;
    }

    public static final <T> void d(kotlinx.coroutines.z0<? super T> z0, d<? super T> d2, boolean z3) {
        Object obj;
        Object context;
        kotlinx.coroutines.internal.z zVar;
        Object obj3;
        Object obj4;
        int obj5;
        obj = z0.i();
        context = z0.d(obj);
        if (context != null) {
            obj3 = p.a;
            obj3 = q.a(context);
        } else {
            context = p.a;
            obj3 = z0.e(obj);
        }
        p.a(obj3);
        if (z3 != 0) {
            obj5 = d2.w;
            context = obj5.getContext();
            obj = d0.c(context, d2.y);
            if (obj != d0.a) {
                obj5 = g0.e(obj5, context, obj);
            } else {
                obj5 = 0;
            }
            d2.w.resumeWith(obj3);
            obj3 = w.a;
            if (obj5 != null) {
                if (obj5.L0()) {
                    d0.a(context, obj);
                }
            } else {
            }
        } else {
            (g)d2.resumeWith(obj3);
        }
    }

    private static final void e(kotlinx.coroutines.z0<?> z0) {
        boolean z;
        Object th;
        int i;
        kotlinx.coroutines.i1 i1Var = u2.a.a();
        if (i1Var.g0()) {
            i1Var.U(z0);
        } else {
            z = 1;
            i1Var.Y(z);
            a1.d(z0, z0.c(), z);
            while (i1Var.l0() == null) {
            }
            i1Var.M(z);
        }
    }
}
