package io.grpc.k1.r.j;

import java.io.Closeable;
import java.util.List;
import l.f;

/* compiled from: FrameWriter.java */
/* loaded from: classes3.dex */
public interface c extends Closeable {
    void R0(i iVar);

    void T1(boolean z, boolean z2, int i, int i2, List<d> list);

    void Z0(i iVar);

    void connectionPreface();

    void data(boolean z, int i, f fVar, int i2);

    void flush();

    void h2(int i, a aVar, byte[] bArr);

    int maxDataLength();

    void p(int i, a aVar);

    void ping(boolean z, int i, int i2);

    void windowUpdate(int i, long j);
}
