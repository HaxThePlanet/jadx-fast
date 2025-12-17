package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.e;
import kotlin.b0.g;
import kotlin.b0.k.a.e;
import kotlinx.coroutines.d3.b;
import kotlinx.coroutines.internal.a0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0008\u0010\u000b\u001a\u00020\u000cH\u0000\u001a8\u0010\r\u001a\u0002H\u000e\"\u0004\u0008\u0000\u0010\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u0014H\u0080\u0008¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u000e\"\u0004\u0008\u0000\u0010\u000e2\u0006\u0010\u0017\u001a\u00020\u00082\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u0014H\u0080\u0008¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0008*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0008H\u0007\u001a\u0013\u0010\u001b\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\u0008\u00030\u00102\u0006\u0010\u0017\u001a\u00020\u00082\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006 ", d2 = {"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withContinuationContext", "T", "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class g0 {

    private static final boolean a = true;
    static {
        boolean equals;
        int i;
        String str2 = a0.d("kotlinx.coroutines.scheduler");
        if (str2 != null) {
            equals = str2.hashCode();
            if (equals != 0) {
                if (equals != 3551) {
                    if (equals != 109935) {
                    } else {
                        if (!str2.equals("off")) {
                        } else {
                            int i4 = 0;
                        }
                    }
                } else {
                    if (!str2.equals("on")) {
                    } else {
                    }
                }
            } else {
                if (!str2.equals("")) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("System property 'kotlinx.coroutines.scheduler' has unrecognized value '");
            stringBuilder.append(str2);
            stringBuilder.append('\'');
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
            throw illegalStateException;
        }
        int i2 = 1;
    }

    public static final kotlinx.coroutines.h0 a() {
        kotlinx.coroutines.o1 o1Var;
        o1Var = g0.a ? b.y : y.b;
        return o1Var;
    }

    public static final String b(g g) {
        String str;
        Object obj2;
        int i = 0;
        if (!q0.c()) {
            return i;
        }
        kotlin.b0.g.b bVar = g.get(k0.b);
        if ((k0)bVar == null) {
            return i;
        }
        obj2 = g.get(l0.b);
        str = "coroutine";
        if ((l0)obj2 == null) {
        } else {
            obj2 = (l0)obj2.K();
            if (obj2 == null) {
            } else {
                str = obj2;
            }
        }
        obj2 = new StringBuilder();
        obj2.append(str);
        int i2 = 35;
        obj2.append(i2);
        obj2.append((k0)bVar.K());
        return obj2.toString();
    }

    public static final g c(kotlinx.coroutines.m0 m0, g g2) {
        long incrementAndGet;
        Object h0Var;
        g obj2;
        g obj3;
        obj2 = m0.r().plus(g2);
        if (q0.c()) {
            obj3 = new k0(q0.b().incrementAndGet(), obj1);
            obj3 = obj2.plus(obj3);
        } else {
            obj3 = obj2;
        }
        if (obj2 != c1.a() && obj2.get(e.p) == null) {
            if (obj2.get(e.p) == null) {
                obj3 = obj3.plus(c1.a());
            }
        }
        return obj3;
    }

    public static final kotlinx.coroutines.y2<?> d(e e) {
        final int i = 0;
        while (e instanceof y0) {
            final e obj2 = e.getCallerFrame();
            i = 0;
        }
        return i;
    }

    public static final kotlinx.coroutines.y2<?> e(d<?> d, g g2, Object object3) {
        int i;
        final int i2 = 0;
        if (!d instanceof e) {
            return i2;
        }
        i = g2.get(z2.a) != null ? 1 : 0;
        if (i == 0) {
            return i2;
        }
        final kotlinx.coroutines.y2 obj2 = g0.d((e)d);
        if (obj2 == null) {
        } else {
            obj2.M0(g2, object3);
        }
        return obj2;
    }
}
