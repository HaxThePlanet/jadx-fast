package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.k1.r.j.a;
import io.grpc.k1.r.j.d;
import io.grpc.k1.r.j.i;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import l.f;
import l.i;

/* loaded from: classes3.dex */
class i {

    private final Logger a;
    private final Level b;

    static enum a {

        INBOUND,
        OUTBOUND;
    }

    private static enum b {

        HEADER_TABLE_SIZE(true),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);

        private final int bit;
        @Override // java.lang.Enum
        public int getBit() {
            return this.bit;
        }
    }
    i(Level level, Class<?> class2) {
        super(level, Logger.getLogger(class2.getName()));
    }

    i(Level level, Logger logger2) {
        super();
        n.p(level, "level");
        this.b = (Level)level;
        n.p(logger2, "logger");
        this.a = (Logger)logger2;
    }

    private boolean a() {
        return this.a.isLoggable(this.b);
    }

    private static String l(i i) {
        int i2;
        io.grpc.k1.i.b bVar;
        boolean valueOf;
        EnumMap enumMap = new EnumMap(i.b.class);
        io.grpc.k1.i.b[] values = i.b.values();
        i2 = 0;
        while (i2 < values.length) {
            bVar = values[i2];
            if (i.d(bVar.getBit())) {
            }
            i2++;
            enumMap.put(bVar, Integer.valueOf(i.a(bVar.getBit())));
        }
        return enumMap.toString();
    }

    private static String m(f f) {
        final int i2 = 64;
        if (Long.compare(size, i2) <= 0) {
            return f.U().p();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f.V((int)l).p());
        stringBuilder.append("...");
        return stringBuilder.toString();
    }

    void b(io.grpc.k1.i.a i$a, int i2, f f3, int i4, boolean z5) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" DATA: streamId=");
            stringBuilder.append(i2);
            stringBuilder.append(" endStream=");
            stringBuilder.append(z5);
            stringBuilder.append(" length=");
            stringBuilder.append(i4);
            stringBuilder.append(" bytes=");
            stringBuilder.append(i.m(f3));
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void c(io.grpc.k1.i.a i$a, int i2, a a3, i i4) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" GO_AWAY: lastStreamId=");
            stringBuilder.append(i2);
            stringBuilder.append(" errorCode=");
            stringBuilder.append(a3);
            stringBuilder.append(" length=");
            stringBuilder.append(i4.A());
            stringBuilder.append(" bytes=");
            obj4 = new f();
            obj4.e0(i4);
            stringBuilder.append(i.m(obj4));
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void d(io.grpc.k1.i.a i$a, int i2, List<d> list3, boolean z4) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" HEADERS: streamId=");
            stringBuilder.append(i2);
            stringBuilder.append(" headers=");
            stringBuilder.append(list3);
            stringBuilder.append(" endStream=");
            stringBuilder.append(z4);
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void e(io.grpc.k1.i.a i$a, long l2) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" PING: ack=false bytes=");
            stringBuilder.append(l2);
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void f(io.grpc.k1.i.a i$a, long l2) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" PING: ack=true bytes=");
            stringBuilder.append(l2);
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void g(io.grpc.k1.i.a i$a, int i2, int i3, List<d> list4) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" PUSH_PROMISE: streamId=");
            stringBuilder.append(i2);
            stringBuilder.append(" promisedStreamId=");
            stringBuilder.append(i3);
            stringBuilder.append(" headers=");
            stringBuilder.append(list4);
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void h(io.grpc.k1.i.a i$a, int i2, a a3) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" RST_STREAM: streamId=");
            stringBuilder.append(i2);
            stringBuilder.append(" errorCode=");
            stringBuilder.append(a3);
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void i(io.grpc.k1.i.a i$a, i i2) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" SETTINGS: ack=false settings=");
            stringBuilder.append(i.l(i2));
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void j(io.grpc.k1.i.a i$a) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" SETTINGS: ack=true");
            this.a.log(this.b, stringBuilder.toString());
        }
    }

    void k(io.grpc.k1.i.a i$a, int i2, long l3) {
        boolean z;
        Level level;
        StringBuilder stringBuilder;
        Object obj4;
        if (a()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(" WINDOW_UPDATE: streamId=");
            stringBuilder.append(i2);
            stringBuilder.append(" windowSizeIncrement=");
            stringBuilder.append(l3);
            this.a.log(this.b, stringBuilder.toString());
        }
    }
}
