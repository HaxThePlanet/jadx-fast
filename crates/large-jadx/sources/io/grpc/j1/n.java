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

/* compiled from: ChannelLoggerImpl.java */
/* loaded from: classes3.dex */
final class n extends g {

    private final o a;
    private final l2 b;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[g.a.values().length];
            n.a.a = iArr;
            try {
                iArr[g.a.ERROR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[g.a.WARNING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    n(o oVar, l2 l2Var) {
        super();
        n.p(oVar, "tracer");
        this.a = oVar;
        n.p(l2Var, "time");
        this.b = l2Var;
    }

    private boolean c(g.a aVar) {
        boolean z2 = false;
        if (aVar != g.a.DEBUG) {
            aVar = this.a.c() ? 1 : 0;
        }
        return (this.a.c() ? 1 : 0);
    }

    static void d(i0 i0Var, g.a aVar, String str) {
        final Level level = n.f(aVar);
        if (o.e.isLoggable(level)) {
            o.d(i0Var, level, str);
        }
    }

    static void e(i0 i0Var, g.a aVar, String str, Object... objectArr) {
        final Level level = n.f(aVar);
        if (o.e.isLoggable(level)) {
            o.d(i0Var, level, MessageFormat.format(str, objectArr));
        }
    }

    private static Level f(g.a aVar) {
        int i3 = n.a.a[aVar.ordinal()];
        if (i3 != 1 && i3 != 2) {
            return Level.FINEST;
        }
        return Level.FINE;
    }

    private static e0.b g(g.a aVar) {
        int i3 = n.a.a[aVar.ordinal()];
        if (i3 != 1 && i3 != 2) {
            return e0.b.CT_INFO;
        }
        return e0.b.CT_ERROR;
    }

    private void h(g.a aVar, String str) {
        if (aVar == g.a.DEBUG) {
            return;
        }
        final e0.a aVar2 = new e0.a();
        aVar2.b(str);
        aVar2.c(n.g(aVar));
        aVar2.e(this.b.a());
        this.a.f(aVar2.a());
    }

    @Override // io.grpc.g
    public void a(g.a aVar, String str) {
        n.d(this.a.b(), aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    @Override // io.grpc.g
    public void b(g.a aVar, String str, Object... objectArr) {
        Level level;
        boolean z;
        String format = null;
        if (!c(aVar)) {
            if (o.e.isLoggable(n.f(aVar))) {
                format = MessageFormat.format(str, objectArr);
            } else {
                int i = 0;
            }
        }
        a(aVar, format);
    }
}
