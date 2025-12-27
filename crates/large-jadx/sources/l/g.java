package l;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.kt */
/* loaded from: classes3.dex */
public interface g extends b0, WritableByteChannel {
    g E0(String str);

    g G();

    g I(int i);

    g P(int i);

    g U0(String str, int i, int i2);

    long W0(d0 d0Var);

    g X0(long j);

    g Y1(long j);

    g b(byte[] bArr, int i, int i2);

    OutputStream b2();

    g c0(int i);

    void flush();

    f h();

    g o0();

    g w1(byte[] bArr);

    g y1(i iVar);
}
