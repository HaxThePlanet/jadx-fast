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

/* loaded from: classes3.dex */
final class o {

    static final Logger e;
    private final Object a;
    private final i0 b;
    private final Collection<e0> c = null;
    private int d;

    class a extends ArrayDeque<e0> {

        final io.grpc.j1.o this$0;
        final int val$maxEvents;
        a(io.grpc.j1.o o, int i2) {
            this.this$0 = o;
            this.val$maxEvents = i2;
            super();
        }

        @Override // java.util.ArrayDeque
        public boolean add(Object object) {
            return b((e0)object);
        }

        @Override // java.util.ArrayDeque
        public boolean b(e0 e0) {
            if (size() == this.val$maxEvents) {
                removeFirst();
            }
            o.a(this.this$0);
            return super.add(e0);
        }
    }

    static class b {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            o.b.a = iArr;
            iArr[e0.b.CT_ERROR.ordinal()] = 1;
            o.b.a[e0.b.CT_WARNING.ordinal()] = 2;
        }
    }
    static {
        o.e = Logger.getLogger(g.class.getName());
    }

    o(i0 i0, int i2, long l3, String string4) {
        io.grpc.j1.o.a obj2;
        super();
        Object object = new Object();
        this.a = object;
        n.p(obj6, "description");
        n.p(i0, "logId");
        this.b = (i0)i0;
        if (i2 > 0) {
            obj2 = new o.a(this, i2);
            this.c = obj2;
        } else {
            obj2 = 0;
        }
        obj2 = new e0.a();
        StringBuilder obj3 = new StringBuilder();
        obj3.append(obj6);
        obj3.append(" created");
        obj2.b(obj3.toString());
        obj2.c(e0.b.CT_INFO);
        obj2.e(l3);
        e(obj2.a());
    }

    static int a(io.grpc.j1.o o) {
        final int i = o.d;
        o.d = i + 1;
        return i;
    }

    static void d(i0 i0, Level level2, String string3) {
        boolean logRecord;
        StringBuilder stringBuilder;
        String str;
        Object obj4;
        final Logger logger = o.e;
        if (logger.isLoggable(level2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(i0);
            stringBuilder.append("] ");
            stringBuilder.append(string3);
            logRecord = new LogRecord(level2, stringBuilder.toString());
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    i0 b() {
        return this.b;
    }

    boolean c() {
        int i;
        final Object obj = this.a;
        synchronized (obj) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    void e(e0 e0) {
        Level fINEST;
        int i;
        int i2 = o.b.a[e0.b.ordinal()];
        if (i2 != 1) {
            fINEST = i2 != 2 ? Level.FINEST : Level.FINER;
        } else {
            fINEST = Level.FINE;
        }
        f(e0);
        o.d(this.b, fINEST, e0.a);
    }

    void f(e0 e0) {
        final Object obj = this.a;
        final Collection collection = this.c;
        synchronized (obj) {
            collection.add(e0);
        }
    }
}
