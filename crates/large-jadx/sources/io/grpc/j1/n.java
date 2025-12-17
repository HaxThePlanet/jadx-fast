package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.e0.a;
import io.grpc.e0.b;
import io.grpc.g;
import io.grpc.g.a;
import io.grpc.i0;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
final class n extends g {

    private final io.grpc.j1.o a;
    private final io.grpc.j1.l2 b;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            n.a.a = iArr;
            iArr[g.a.ERROR.ordinal()] = 1;
            n.a.a[g.a.WARNING.ordinal()] = 2;
        }
    }
    n(io.grpc.j1.o o, io.grpc.j1.l2 l22) {
        super();
        n.p(o, "tracer");
        this.a = (o)o;
        n.p(l22, "time");
        this.b = (l2)l22;
    }

    private boolean c(g.a g$a) {
        g.a obj2;
        if (a != g.a.DEBUG && this.a.c()) {
            obj2 = this.a.c() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    static void d(i0 i0, g.a g$a2, String string3) {
        final Level obj2 = n.f(a2);
        if (o.e.isLoggable(obj2)) {
            o.d(i0, obj2, string3);
        }
    }

    static void e(i0 i0, g.a g$a2, String string3, Object... object4Arr4) {
        String obj3;
        final Level obj2 = n.f(a2);
        if (o.e.isLoggable(obj2)) {
            o.d(i0, obj2, MessageFormat.format(string3, object4Arr4));
        }
    }

    private static Level f(g.a g$a) {
        int obj1 = n.a.a[a.ordinal()];
        if (obj1 != 1 && obj1 != 2) {
            if (obj1 != 2) {
                return Level.FINEST;
            }
            return Level.FINER;
        }
        return Level.FINE;
    }

    private static e0.b g(g.a g$a) {
        int obj1 = n.a.a[a.ordinal()];
        if (obj1 != 1 && obj1 != 2) {
            if (obj1 != 2) {
                return e0.b.CT_INFO;
            }
            return e0.b.CT_WARNING;
        }
        return e0.b.CT_ERROR;
    }

    private void h(g.a g$a, String string2) {
        if (a == g.a.DEBUG) {
        }
        e0.a aVar = new e0.a();
        aVar.b(string2);
        aVar.c(n.g(a));
        aVar.e(this.b.a());
        this.a.f(aVar.a());
    }

    @Override // io.grpc.g
    public void a(g.a g$a, String string2) {
        n.d(this.a.b(), a, string2);
        if (c(a)) {
            h(a, string2);
        }
    }

    @Override // io.grpc.g
    public void b(g.a g$a, String string2, Object... object3Arr3) {
        boolean loggable;
        Logger z;
        int obj4;
        if (!c(a)) {
            if (o.e.isLoggable(n.f(a))) {
                obj4 = MessageFormat.format(string2, object3Arr3);
            } else {
                obj4 = 0;
            }
        } else {
        }
        a(a, obj4);
    }
}
