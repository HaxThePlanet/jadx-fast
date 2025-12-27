package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.k1.r.j.a;
import io.grpc.k1.r.j.d;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import l.f;

/* compiled from: OkHttpFrameLogger.java */
/* loaded from: classes3.dex */
class i {

    private final Logger a;
    private final Level b;

    enum a {

        INBOUND,
        OUTBOUND;
    }

    private enum b {

        ENABLE_PUSH,
        HEADER_TABLE_SIZE,
        INITIAL_WINDOW_SIZE,
        MAX_CONCURRENT_STREAMS,
        MAX_FRAME_SIZE,
        MAX_HEADER_LIST_SIZE;

        private final int bit;
        @Override // java.lang.Enum
        public int getBit() {
            return this.bit;
        }
    }
    i(Level level, Class<?> cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    private boolean a() {
        return this.a.isLoggable(this.b);
    }

    private static String l(io.grpc.k1.r.j.i iVar) {
        int i = 0;
        boolean z;
        final EnumMap enumMap = new EnumMap(i.b.class);
        io.grpc.k1.i.b[] values = i.b.values();
        i = 0;
        for (io.grpc.k1.i.b bVar : values) {
        }
        return enumMap.toString();
    }

    private static String m(f fVar) {
        long size = fVar.size();
        final long l2 = 64L;
        if (size <= l2) {
            return fVar.U().p();
        }
        final StringBuilder stringBuilder = new StringBuilder();
        String str2 = fVar.V((int)(Math.min(fVar.size(), l2))).p();
        String str3 = "...";
        str4 = str2 + str3;
        return str4;
    }

    void b(i.a aVar, int i, f fVar, int i2, boolean z) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " DATA: streamId=";
            String str3 = " endStream=";
            String str4 = " length=";
            String str5 = " bytes=";
            String str6 = i.m(fVar);
            str = aVar + str2 + i + str3 + z + str4 + i2 + str5 + str6;
            this.a.log(this.b, str);
        }
    }

    void c(i.a aVar, int i, a aVar2, l.i iVar) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " GO_AWAY: lastStreamId=";
            String str3 = " errorCode=";
            String str4 = " length=";
            i = iVar.E();
            String str5 = " bytes=";
            f fVar = new f();
            fVar.e0(iVar);
            String str6 = i.m(fVar);
            str = aVar + str2 + i + str3 + aVar2 + str4 + i + str5 + str6;
            this.a.log(this.b, str);
        }
    }

    void d(i.a aVar, int i, List<d> list, boolean z) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " HEADERS: streamId=";
            String str3 = " headers=";
            String str4 = " endStream=";
            str = aVar + str2 + i + str3 + list + str4 + z;
            this.a.log(this.b, str);
        }
    }

    void e(i.a aVar, long j) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " PING: ack=false bytes=";
            str = aVar + str2 + j;
            this.a.log(this.b, str);
        }
    }

    void f(i.a aVar, long j) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " PING: ack=true bytes=";
            str = aVar + str2 + j;
            this.a.log(this.b, str);
        }
    }

    void g(i.a aVar, int i, int i2, List<d> list) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " PUSH_PROMISE: streamId=";
            String str3 = " promisedStreamId=";
            String str4 = " headers=";
            str = aVar + str2 + i + str3 + i2 + str4 + list;
            this.a.log(this.b, str);
        }
    }

    void h(i.a aVar, int i, a aVar2) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " RST_STREAM: streamId=";
            String str3 = " errorCode=";
            str = aVar + str2 + i + str3 + aVar2;
            this.a.log(this.b, str);
        }
    }

    void i(i.a aVar, io.grpc.k1.r.j.i iVar) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " SETTINGS: ack=false settings=";
            String str3 = i.l(iVar);
            str = aVar + str2 + str3;
            this.a.log(this.b, str);
        }
    }

    void j(i.a aVar) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " SETTINGS: ack=true";
            str = aVar + str2;
            this.a.log(this.b, str);
        }
    }

    void k(i.a aVar, int i, long j) {
        if (a()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " WINDOW_UPDATE: streamId=";
            String str3 = " windowSizeIncrement=";
            str = aVar + str2 + i + str3 + j;
            this.a.log(this.b, str);
        }
    }

    i(Level level, Logger logger) {
        super();
        n.p(level, "level");
        this.b = level;
        n.p(logger, "logger");
        this.a = logger;
    }
}
