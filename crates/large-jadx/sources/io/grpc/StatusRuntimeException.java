package io.grpc;

/* compiled from: StatusRuntimeException.java */
/* loaded from: classes2.dex */
public class StatusRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1950934672280720624L;
    private final boolean fillInStackTrace;
    private final d1 status;
    private final t0 trailers;
    public StatusRuntimeException(d1 d1Var) {
        this(d1Var, null);
    }

    @Override // java.lang.RuntimeException
    public final d1 a() {
        return this.status;
    }

    @Override // java.lang.RuntimeException
    public final t0 b() {
        return this.trailers;
    }

    @Override // java.lang.RuntimeException
    public synchronized Throwable fillInStackTrace() {
        Object obj;
        Throwable fillInStackTrace = super.fillInStackTrace();
        obj = this;
        return obj;
    }

    public StatusRuntimeException(d1 d1Var, t0 t0Var) {
        this(d1Var, t0Var, true);
    }

    StatusRuntimeException(d1 d1Var, t0 t0Var, boolean z) {
        super(d1.h(d1Var), d1Var.m());
        this.status = d1Var;
        this.trailers = t0Var;
        this.fillInStackTrace = z;
        fillInStackTrace();
    }
}
