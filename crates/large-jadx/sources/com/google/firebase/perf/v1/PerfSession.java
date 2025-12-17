package com.google.firebase.perf.v1;

import com.google.protobuf.c0.g;
import com.google.protobuf.c0.h;
import com.google.protobuf.c0.h.a;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class PerfSession extends z<com.google.firebase.perf.v1.PerfSession, com.google.firebase.perf.v1.PerfSession.Builder> implements com.google.firebase.perf.v1.PerfSessionOrBuilder {

    private static final com.google.firebase.perf.v1.PerfSession DEFAULT_INSTANCE = null;
    private static volatile d1<com.google.firebase.perf.v1.PerfSession> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int SESSION_VERBOSITY_FIELD_NUMBER = 2;
    private static final c0.h.a<Integer, com.google.firebase.perf.v1.SessionVerbosity> sessionVerbosity_converter_;
    private int bitField0_;
    private String sessionId_;
    private c0.g sessionVerbosity_;

    public static final class Builder extends z.a<com.google.firebase.perf.v1.PerfSession, com.google.firebase.perf.v1.PerfSession.Builder> implements com.google.firebase.perf.v1.PerfSessionOrBuilder {
        private Builder() {
            super(PerfSession.access$000());
        }

        Builder(com.google.firebase.perf.v1.PerfSession.1 perfSession$1) {
            super();
        }

        public com.google.firebase.perf.v1.PerfSession.Builder addAllSessionVerbosity(Iterable<? extends com.google.firebase.perf.v1.SessionVerbosity> iterable) {
            copyOnWrite();
            PerfSession.access$600((PerfSession)this.instance, iterable);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfSession.Builder addSessionVerbosity(com.google.firebase.perf.v1.SessionVerbosity sessionVerbosity) {
            copyOnWrite();
            PerfSession.access$500((PerfSession)this.instance, sessionVerbosity);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfSession.Builder clearSessionId() {
            copyOnWrite();
            PerfSession.access$200((PerfSession)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfSession.Builder clearSessionVerbosity() {
            copyOnWrite();
            PerfSession.access$700((PerfSession)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public String getSessionId() {
            return (PerfSession)this.instance.getSessionId();
        }

        @Override // com.google.protobuf.z$a
        public j getSessionIdBytes() {
            return (PerfSession)this.instance.getSessionIdBytes();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.SessionVerbosity getSessionVerbosity(int i) {
            return (PerfSession)this.instance.getSessionVerbosity(i);
        }

        @Override // com.google.protobuf.z$a
        public int getSessionVerbosityCount() {
            return (PerfSession)this.instance.getSessionVerbosityCount();
        }

        public List<com.google.firebase.perf.v1.SessionVerbosity> getSessionVerbosityList() {
            return (PerfSession)this.instance.getSessionVerbosityList();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasSessionId() {
            return (PerfSession)this.instance.hasSessionId();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfSession.Builder setSessionId(String string) {
            copyOnWrite();
            PerfSession.access$100((PerfSession)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfSession.Builder setSessionIdBytes(j j) {
            copyOnWrite();
            PerfSession.access$300((PerfSession)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfSession.Builder setSessionVerbosity(int i, com.google.firebase.perf.v1.SessionVerbosity sessionVerbosity2) {
            copyOnWrite();
            PerfSession.access$400((PerfSession)this.instance, i, sessionVerbosity2);
            return this;
        }
    }
    static {
        PerfSession.1 anon = new PerfSession.1();
        PerfSession.sessionVerbosity_converter_ = anon;
        PerfSession perfSession = new PerfSession();
        PerfSession.DEFAULT_INSTANCE = perfSession;
        z.registerDefaultInstance(PerfSession.class, perfSession);
    }

    private PerfSession() {
        super();
        this.sessionId_ = "";
        this.sessionVerbosity_ = z.emptyIntList();
    }

    static com.google.firebase.perf.v1.PerfSession access$000() {
        return PerfSession.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.PerfSession perfSession, String string2) {
        perfSession.setSessionId(string2);
    }

    static void access$200(com.google.firebase.perf.v1.PerfSession perfSession) {
        perfSession.clearSessionId();
    }

    static void access$300(com.google.firebase.perf.v1.PerfSession perfSession, j j2) {
        perfSession.setSessionIdBytes(j2);
    }

    static void access$400(com.google.firebase.perf.v1.PerfSession perfSession, int i2, com.google.firebase.perf.v1.SessionVerbosity sessionVerbosity3) {
        perfSession.setSessionVerbosity(i2, sessionVerbosity3);
    }

    static void access$500(com.google.firebase.perf.v1.PerfSession perfSession, com.google.firebase.perf.v1.SessionVerbosity sessionVerbosity2) {
        perfSession.addSessionVerbosity(sessionVerbosity2);
    }

    static void access$600(com.google.firebase.perf.v1.PerfSession perfSession, Iterable iterable2) {
        perfSession.addAllSessionVerbosity(iterable2);
    }

    static void access$700(com.google.firebase.perf.v1.PerfSession perfSession) {
        perfSession.clearSessionVerbosity();
    }

    private void addAllSessionVerbosity(Iterable<? extends com.google.firebase.perf.v1.SessionVerbosity> iterable) {
        int number;
        c0.g sessionVerbosity_;
        ensureSessionVerbosityIsMutable();
        final Iterator obj3 = iterable.iterator();
        for (SessionVerbosity next2 : obj3) {
            this.sessionVerbosity_.V(next2.getNumber());
        }
    }

    private void addSessionVerbosity(com.google.firebase.perf.v1.SessionVerbosity sessionVerbosity) {
        sessionVerbosity.getClass();
        ensureSessionVerbosityIsMutable();
        this.sessionVerbosity_.V(sessionVerbosity.getNumber());
    }

    private void clearSessionId() {
        this.bitField0_ = bitField0_ &= -2;
        this.sessionId_ = PerfSession.getDefaultInstance().getSessionId();
    }

    private void clearSessionVerbosity() {
        this.sessionVerbosity_ = z.emptyIntList();
    }

    private void ensureSessionVerbosityIsMutable() {
        c0.g sessionVerbosity_;
        sessionVerbosity_ = this.sessionVerbosity_;
        if (!sessionVerbosity_.c2()) {
            this.sessionVerbosity_ = z.mutableCopy(sessionVerbosity_);
        }
    }

    public static com.google.firebase.perf.v1.PerfSession getDefaultInstance() {
        return PerfSession.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.perf.v1.PerfSession.Builder newBuilder() {
        return (PerfSession.Builder)PerfSession.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.PerfSession.Builder newBuilder(com.google.firebase.perf.v1.PerfSession perfSession) {
        return (PerfSession.Builder)PerfSession.DEFAULT_INSTANCE.createBuilder(perfSession);
    }

    public static com.google.firebase.perf.v1.PerfSession parseDelimitedFrom(InputStream inputStream) {
        return (PerfSession)z.parseDelimitedFrom(PerfSession.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.PerfSession parseDelimitedFrom(InputStream inputStream, q q2) {
        return (PerfSession)z.parseDelimitedFrom(PerfSession.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(j j) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(j j, q q2) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(k k) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(k k, q q2) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(InputStream inputStream) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(InputStream inputStream, q q2) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(ByteBuffer byteBuffer) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(ByteBuffer byteBuffer, q q2) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(byte[] bArr) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.PerfSession parseFrom(byte[] bArr, q q2) {
        return (PerfSession)z.parseFrom(PerfSession.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.PerfSession> parser() {
        return PerfSession.DEFAULT_INSTANCE.getParserForType();
    }

    private void setSessionId(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.sessionId_ = string;
    }

    private void setSessionIdBytes(j j) {
        this.sessionId_ = j.R();
        this.bitField0_ = obj1 |= 1;
    }

    private void setSessionVerbosity(int i, com.google.firebase.perf.v1.SessionVerbosity sessionVerbosity2) {
        sessionVerbosity2.getClass();
        ensureSessionVerbosityIsMutable();
        this.sessionVerbosity_.M(i, sessionVerbosity2.getNumber());
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj2;
        int obj3;
        int obj4;
        obj3 = 1;
        obj4 = 0;
        switch (obj2) {
            case 1:
                obj2 = new PerfSession();
                return obj2;
            case 2:
                obj2 = new PerfSession.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[4];
                obj2[obj3] = "sessionId_";
                obj2[2] = "sessionVerbosity_";
                obj2[3] = SessionVerbosity.internalGetVerifier();
                return z.newMessageInfo(PerfSession.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001e", obj2);
            case 4:
                return PerfSession.DEFAULT_INSTANCE;
            case 5:
                return obj2;
            case 6:
                return Byte.valueOf(obj3);
            case 7:
                return obj4;
            default:
                obj2 = new UnsupportedOperationException();
                throw obj2;
        }
        obj3 = PerfSession.class;
        synchronized (obj3) {
            obj2 = new z.b(PerfSession.DEFAULT_INSTANCE);
            PerfSession.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.google.protobuf.z
    public j getSessionIdBytes() {
        return j.u(this.sessionId_);
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.SessionVerbosity getSessionVerbosity(int i) {
        return (SessionVerbosity)PerfSession.sessionVerbosity_converter_.convert(Integer.valueOf(this.sessionVerbosity_.getInt(i)));
    }

    @Override // com.google.protobuf.z
    public int getSessionVerbosityCount() {
        return this.sessionVerbosity_.size();
    }

    public List<com.google.firebase.perf.v1.SessionVerbosity> getSessionVerbosityList() {
        c0.h hVar = new c0.h(this.sessionVerbosity_, PerfSession.sessionVerbosity_converter_);
        return hVar;
    }

    @Override // com.google.protobuf.z
    public boolean hasSessionId() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
