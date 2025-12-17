package io.grpc;

/* loaded from: classes2.dex */
public class StatusRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1950934672280720624L;
    private final boolean fillInStackTrace;
    private final io.grpc.d1 status;
    private final io.grpc.t0 trailers;
    public StatusRuntimeException(io.grpc.d1 d1) {
        super(d1, 0);
    }

    public StatusRuntimeException(io.grpc.d1 d1, io.grpc.t0 t02) {
        super(d1, t02, 1);
    }

    StatusRuntimeException(io.grpc.d1 d1, io.grpc.t0 t02, boolean z3) {
        super(d1.h(d1), d1.m());
        this.status = d1;
        this.trailers = t02;
        this.fillInStackTrace = z3;
        fillInStackTrace();
    }

    @Override // java.lang.RuntimeException
    public final io.grpc.d1 a() {
        return this.status;
    }

    @Override // java.lang.RuntimeException
    public final io.grpc.t0 b() {
        return this.trailers;
    }

    @Override // java.lang.RuntimeException
    public Throwable fillInStackTrace() {
        Object fillInStackTrace;
        synchronized (this) {
            try {
                fillInStackTrace = super.fillInStackTrace();
                fillInStackTrace = this;
                return fillInStackTrace;
                throw th;
            }
        }
    }
}
