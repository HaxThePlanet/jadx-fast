package io.grpc;

/* compiled from: StatusException.java */
/* loaded from: classes2.dex */
public class StatusException extends Exception {

    private static final long serialVersionUID = -660954903976144640L;
    private final boolean fillInStackTrace;
    private final d1 status;
    private final t0 trailers;
    public StatusException(d1 d1Var) {
        this(d1Var, null);
    }

    @Override // java.lang.Exception
    public final d1 a() {
        return this.status;
    }

    @Override // java.lang.Exception
    public final t0 b() {
        return this.trailers;
    }

    @Override // java.lang.Exception
    public synchronized Throwable fillInStackTrace() {
        Object obj;
        Throwable fillInStackTrace = super.fillInStackTrace();
        obj = this;
        return obj;
    }

    public StatusException(d1 d1Var, t0 t0Var) {
        this(d1Var, t0Var, true);
    }

    StatusException(d1 d1Var, t0 t0Var, boolean z) {
        super(d1.h(d1Var), d1Var.m());
        this.status = d1Var;
        this.trailers = t0Var;
        this.fillInStackTrace = z;
        fillInStackTrace();
    }
}
