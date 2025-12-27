package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.e0;
import io.grpc.e0.a;
import io.grpc.e0.b;
import io.grpc.i0;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: ChannelTracer.java */
/* loaded from: classes3.dex */
final class o {

    static final Logger e;
    private final Object a = new Object();
    private final i0 b;
    private final Collection<e0> c;
    private int d;

    class a extends ArrayDeque<e0> {
        a(int i) {
            this.val$maxEvents = i;
            super();
        }

        @Override // java.util.ArrayDeque
        public boolean b(e0 e0Var) {
            if (size() == this.val$maxEvents) {
                removeFirst();
            }
            o.a(o.this);
            return super.add(e0Var);
        }
    }

    static class b {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[e0.b.values().length];
            o.b.a = iArr;
            try {
                iArr[e0.b.CT_ERROR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                o.b.a[e0.b.CT_WARNING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        o.e = Logger.getLogger(g.class.getName());
    }

    o(i0 i0Var, int i, long j, String str) {
        super();
        Object object = new Object();
        n.p(str, "description");
        n.p(i0Var, "logId");
        this.b = i0Var;
        if (i > 0) {
            this.c = new o.a(this, i);
        } else {
            this.c = null;
        }
        e0.a aVar2 = new e0.a();
        StringBuilder stringBuilder = new StringBuilder();
        final String str5 = " created";
        str3 = str + str5;
        aVar2.b(str3);
        aVar2.c(e0.b.CT_INFO);
        aVar2.e(j);
        e(aVar2.a());
    }

    static /* synthetic */ int a(o oVar) {
        oVar.d++;
        return oVar.d;
    }

    static void d(i0 i0Var, Level level, String str) {
        final Logger logger = o.e;
        if (logger.isLoggable(level)) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "[";
            String str4 = "] ";
            i0Var = str + i0Var + str4 + str;
            LogRecord logRecord = new LogRecord(level, i0Var);
            logRecord.setLoggerName(o.e.getName());
            logRecord.setSourceClassName(o.e.getName());
            str2 = "log";
            logRecord.setSourceMethodName(str2);
            o.e.log(logRecord);
        }
    }

    i0 b() {
        return this.b;
    }

    boolean c() {
        boolean z = false;
        synchronized (obj2) {
            try {
                Throwable th = this.c != null ? 1 : 0;
                return (this.c != null ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (this.c != null ? 1 : 0);
        }
    }

    void e(e0 e0Var) {
        Level fINER2;
        int i2 = o.b.a[e0Var.b.ordinal()];
        int i = 1;
        if (o.b.a != 1) {
            i = 2;
            Level r0 = o.b.a != 2 ? Level.FINEST : Level.FINER;
        } else {
            r0 = Level.FINE;
        }
        f(e0Var);
        o.d(this.b, (o.b.a != 2 ? Level.FINEST : Level.FINER), e0Var.a);
    }

    void f(e0 e0Var) {
        synchronized (obj2) {
            try {
                if (this.c != null) {
                    this.c.add(e0Var);
                }
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }
}
