package io.grpc;

/* loaded from: classes2.dex */
public class StatusException extends Exception {

    private static final long serialVersionUID = -660954903976144640L;
    private final boolean fillInStackTrace;
    private final io.grpc.d1 status;
    private final io.grpc.t0 trailers;
    public StatusException(io.grpc.d1 d1) {
        super(d1, 0);
    }

    public StatusException(io.grpc.d1 d1, io.grpc.t0 t02) {
        super(d1, t02, 1);
    }

    StatusException(io.grpc.d1 d1, io.grpc.t0 t02, boolean z3) {
        super(d1.h(d1), d1.m());
        this.status = d1;
        this.trailers = t02;
        this.fillInStackTrace = z3;
        fillInStackTrace();
    }

    @Override // java.lang.Exception
    public final io.grpc.d1 a() {
        return this.status;
    }

    @Override // java.lang.Exception
    public final io.grpc.t0 b() {
        return this.trailers;
    }

    @Override // java.lang.Exception
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
