package io.grpc.k1.r.j;

import java.io.Closeable;
import java.util.List;
import l.f;

/* loaded from: classes3.dex */
public interface c extends Closeable {
    @Override // java.io.Closeable
    public abstract void R0(io.grpc.k1.r.j.i i);

    public abstract void T1(boolean z, boolean z2, int i3, int i4, List<io.grpc.k1.r.j.d> list5);

    @Override // java.io.Closeable
    public abstract void Z0(io.grpc.k1.r.j.i i);

    @Override // java.io.Closeable
    public abstract void connectionPreface();

    @Override // java.io.Closeable
    public abstract void data(boolean z, int i2, f f3, int i4);

    @Override // java.io.Closeable
    public abstract void flush();

    @Override // java.io.Closeable
    public abstract void h2(int i, io.grpc.k1.r.j.a a2, byte[] b3Arr3);

    @Override // java.io.Closeable
    public abstract int maxDataLength();

    @Override // java.io.Closeable
    public abstract void p(int i, io.grpc.k1.r.j.a a2);

    @Override // java.io.Closeable
    public abstract void ping(boolean z, int i2, int i3);

    @Override // java.io.Closeable
    public abstract void windowUpdate(int i, long l2);
}
