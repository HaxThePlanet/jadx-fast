package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlinx.coroutines.t2;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class d0 {

    public static final kotlinx.coroutines.internal.z a;
    private static final p<Object, g.b, Object> b;
    private static final p<t2<?>, g.b, t2<?>> c;
    private static final p<kotlinx.coroutines.internal.g0, g.b, kotlinx.coroutines.internal.g0> d;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n", d2 = {"<no name provided>", "", "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements p<Object, g.b, Object> {

        public static final kotlinx.coroutines.internal.d0.a a;
        static {
            d0.a aVar = new d0.a();
            d0.a.a = aVar;
        }

        a() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final Object a(Object object, g.b g$b2) {
            int obj2;
            Object obj3;
            if (b2 instanceof t2) {
                if (object instanceof Integer) {
                } else {
                    obj2 = 0;
                }
                int i = 1;
                if (obj2 == null) {
                    obj2 = i;
                } else {
                    obj2 = obj2.intValue();
                }
                if (obj2 == null) {
                } else {
                    obj3 = Integer.valueOf(obj2 += i);
                }
                return obj3;
            }
            return (Integer)object;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return a(object, (g.b)object2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n", d2 = {"<no name provided>", "Lkotlinx/coroutines/ThreadContextElement;", "found", "element", "Lkotlin/coroutines/CoroutineContext$Element;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements p<t2<?>, g.b, t2<?>> {

        public static final kotlinx.coroutines.internal.d0.b a;
        static {
            d0.b bVar = new d0.b();
            d0.b.a = bVar;
        }

        b() {
            super(2);
        }

        public final t2<?> a(t2<?> t2, g.b g$b2) {
            Object obj2;
            if (t2 != null) {
                return t2;
            }
            if (b2 instanceof t2) {
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return a((t2)object, (g.b)object2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n", d2 = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements p<kotlinx.coroutines.internal.g0, g.b, kotlinx.coroutines.internal.g0> {

        public static final kotlinx.coroutines.internal.d0.c a;
        static {
            d0.c cVar = new d0.c();
            d0.c.a = cVar;
        }

        c() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final kotlinx.coroutines.internal.g0 a(kotlinx.coroutines.internal.g0 g0, g.b g$b2) {
            boolean z;
            if (b2 instanceof t2) {
                g0.a(b2, (t2)b2.H(g0.a));
            }
            return g0;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            a((g0)object, (g.b)object2);
            return object;
        }
    }
    static {
        z zVar = new z("NO_THREAD_ELEMENTS");
        d0.a = zVar;
        d0.b = d0.a.a;
        d0.c = d0.b.a;
        d0.d = d0.c.a;
    }

    public static final void a(g g, Object object2) {
        boolean fold;
        String str;
        if (object2 == d0.a) {
        }
        if (object2 instanceof g0) {
            (g0)object2.b(g);
        } else {
            fold = g.fold(0, d0.c);
            Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            (t2)fold.E(g, object2);
        }
    }

    public static final Object b(g g) {
        final Object obj2 = g.fold(0, d0.b);
        n.d(obj2);
        return obj2;
    }

    public static final Object c(g g, Object object2) {
        Integer valueOf;
        Object obj1;
        Object obj2;
        if (object2 == null) {
            obj2 = d0.b(g);
        }
        if (obj2 == 0) {
            obj1 = d0.a;
        } else {
            if (obj2 instanceof Integer) {
                valueOf = new g0(g, (Number)obj2.intValue());
                obj1 = g.fold(valueOf, d0.d);
            } else {
                obj1 = (t2)obj2.H(g);
            }
        }
        return obj1;
    }
}
