package io.grpc.k1.r.j;

import java.io.Closeable;
import java.util.List;
import l.h;
import l.i;

/* loaded from: classes3.dex */
public interface b extends Closeable {

    public interface a {
        public abstract void ackSettings();

        public abstract void data(boolean z, int i2, h h3, int i4);

        public abstract void p(int i, io.grpc.k1.r.j.a a2);

        public abstract void ping(boolean z, int i2, int i3);

        public abstract void priority(int i, int i2, int i3, boolean z4);

        public abstract void pushPromise(int i, int i2, List<io.grpc.k1.r.j.d> list3);

        public abstract void q(int i, io.grpc.k1.r.j.a a2, i i3);

        public abstract void r(boolean z, io.grpc.k1.r.j.i i2);

        public abstract void s(boolean z, boolean z2, int i3, int i4, List<io.grpc.k1.r.j.d> list5, io.grpc.k1.r.j.e e6);

        public abstract void windowUpdate(int i, long l2);
    }
    @Override // java.io.Closeable
    public abstract boolean d0(io.grpc.k1.r.j.b.a b$a);
}
