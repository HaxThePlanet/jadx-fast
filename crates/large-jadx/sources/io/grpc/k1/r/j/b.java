package io.grpc.k1.r.j;

import java.io.Closeable;
import java.util.List;
import l.h;
import l.i;

/* compiled from: FrameReader.java */
/* loaded from: classes3.dex */
public interface b extends Closeable {

    public interface a {
        void ackSettings();

        void data(boolean z, int i, h hVar, int i2);

        void p(int i, a aVar);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<d> list);

        void q(int i, a aVar, i iVar);

        void r(boolean z, i iVar);

        void s(boolean z, boolean z2, int i, int i2, List<d> list, e eVar);

        void windowUpdate(int i, long j);
    }
    boolean d0(b.a aVar);
}
