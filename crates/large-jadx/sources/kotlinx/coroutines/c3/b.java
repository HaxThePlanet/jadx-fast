package kotlinx.coroutines.c3;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.g0;
import kotlin.p;
import kotlin.q;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.q0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082\u0008\u001a>\u0010\u0008\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\u0008\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\n\"\u0004\u0008\u0001\u0010\u0002*\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\u000c\u001a\u0002H\n2\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a>\u0010\u000e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\u000e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\n\"\u0004\u0008\u0001\u0010\u0002*\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\u000c\u001a\u0002H\n2\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aY\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0008\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u000c\u001a\u0002H\n2'\u0010\u0005\u001a#\u0008\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\u0008\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aY\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0008\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u000c\u001a\u0002H\n2'\u0010\u0005\u001a#\u0008\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\u0008\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0082\u0008\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001a", d2 = {"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class b {
    public static final <T> void a(l<? super d<? super T>, ? extends Object> l, d<? super T> d2) {
        Object obj;
        Object obj3;
        h.a(d2);
        kotlin.b0.g context = d2.getContext();
        if (l == null) {
        } else {
            g0.e(l, 1);
            obj3 = (l)l.invoke(d2);
            d0.a(context, d0.c(context, 0));
            if (obj3 != b.d()) {
                obj = p.a;
                p.a(obj3);
                d2.resumeWith(obj3);
            }
        }
        obj3 = new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        throw obj3;
    }

    public static final <R, T> void b(p<? super R, ? super d<? super T>, ? extends Object> p, R r2, d<? super T> d3) {
        Object obj3;
        Object obj4;
        h.a(d3);
        final kotlin.b0.g context = d3.getContext();
        if (p == null) {
        } else {
            g0.e(p, 2);
            obj3 = (p)p.invoke(r2, d3);
            d0.a(context, d0.c(context, 0));
            if (obj3 != b.d()) {
                obj4 = p.a;
                p.a(obj3);
                d3.resumeWith(obj3);
            }
        }
        obj3 = new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        throw obj3;
    }

    public static final <T, R> Object c(x<? super T> x, R r2, p<? super R, ? super d<? super T>, ? extends Object> p3) {
        int i;
        int i2;
        Object obj3;
        Object obj4;
        Object obj5;
        if (p3 == null) {
        } else {
            g0.e(p3, 2);
            obj4 = p3.invoke(r2, x);
            if (obj4 == b.d()) {
                obj3 = b.d();
            } else {
                obj4 = x.j0(obj4);
                if (obj4 == g2.b) {
                    obj3 = b.d();
                } else {
                    if (obj4 instanceof b0) {
                        obj3 = x.c;
                        if (!q0.d()) {
                        } else {
                            if (!obj3 instanceof e) {
                            } else {
                                obj4 = y.a(obj4.a, (e)obj3);
                            }
                        }
                        throw obj4;
                    }
                    obj3 = g2.h((b0)obj4);
                }
            }
            return obj3;
        }
        try {
            obj4 = new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            throw obj4;
            p3 = new b0(r2, 0, obj0, 0);
            r2 = p3;
            if (obj4 == b.d()) {
            } else {
            }
            obj3 = b.d();
            obj4 = x.j0(obj4);
            if (obj4 == g2.b) {
            } else {
            }
            obj3 = b.d();
            if (obj4 instanceof b0) {
            }
            obj3 = x.c;
            if (!q0.d()) {
            } else {
            }
            if (!obj3 instanceof e) {
            } else {
            }
            obj4 = y.a(obj4.a, (e)obj3);
            throw obj4;
            obj3 = g2.h((b0)obj4);
            return obj3;
        }
    }

    public static final <T, R> Object d(x<? super T> x, R r2, p<? super R, ? super d<? super T>, ? extends Object> p3) {
        int i;
        boolean coroutine;
        int i2;
        Object obj3;
        Object obj4;
        Object obj5;
        i = 0;
        if (p3 == null) {
        } else {
            g0.e(p3, 2);
            obj4 = (p)p3.invoke(r2, x);
            if (obj4 == b.d()) {
                obj3 = b.d();
            } else {
                obj5 = x.j0(obj4);
                if (obj5 == g2.b) {
                    obj3 = b.d();
                } else {
                    if (obj5 instanceof b0) {
                        obj5 = obj5.a;
                        if (obj5 instanceof TimeoutCancellationException != null) {
                            if (th.coroutine != x) {
                                i = 1;
                            }
                        } else {
                        }
                        if (i != 0) {
                            obj3 = x.c;
                            if (!q0.d()) {
                            } else {
                                if (!obj3 instanceof e) {
                                } else {
                                    obj5 = y.a(obj5, (e)obj3);
                                }
                            }
                            throw obj5;
                        }
                        if (obj4 instanceof b0) {
                            obj3 = x.c;
                            if (!q0.d()) {
                            } else {
                                if (!obj3 instanceof e) {
                                } else {
                                    obj4 = y.a(obj4.a, (e)obj3);
                                }
                            }
                            throw obj4;
                        }
                    } else {
                        obj4 = g2.h((b0)obj5);
                    }
                    obj3 = obj4;
                }
            }
            return obj3;
        }
        obj4 = new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        throw obj4;
    }
}
