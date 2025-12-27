package l;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.kt */
/* loaded from: classes3.dex */
public interface h extends d0, ReadableByteChannel {
    f A();

    i B(long j);

    long J1(b0 b0Var);

    boolean K0(long j, i iVar);

    String M0(Charset charset);

    void V1(long j);

    byte[] X();

    i Y0();

    long a0(i iVar);

    boolean b0();

    long d2();

    InputStream g2();

    f h();

    int i2(t tVar);

    void k0(f fVar, long j);

    String m1();

    long n0(i iVar);

    long p0();

    byte[] p1(long j);

    h peek();

    String r0(long j);

    String r1();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    boolean request(long j);

    void skip(long j);
}
