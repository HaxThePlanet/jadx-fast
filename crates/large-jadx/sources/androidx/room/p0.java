package androidx.room;

import d.s.a.g;
import d.s.a.h;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class p0 implements h, androidx.room.f0 {

    private final h a;
    private final androidx.room.u0.f b;
    private final Executor c;
    p0(h h, androidx.room.u0.f u0$f2, Executor executor3) {
        super();
        this.a = h;
        this.b = f2;
        this.c = executor3;
    }

    @Override // d.s.a.h
    public void close() {
        this.a.close();
    }

    @Override // d.s.a.h
    public String getDatabaseName() {
        return this.a.getDatabaseName();
    }

    @Override // d.s.a.h
    public h getDelegate() {
        return this.a;
    }

    @Override // d.s.a.h
    public g getReadableDatabase() {
        o0 o0Var = new o0(this.a.getReadableDatabase(), this.b, this.c);
        return o0Var;
    }

    @Override // d.s.a.h
    public g getWritableDatabase() {
        o0 o0Var = new o0(this.a.getWritableDatabase(), this.b, this.c);
        return o0Var;
    }

    @Override // d.s.a.h
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.a.setWriteAheadLoggingEnabled(z);
    }
}
