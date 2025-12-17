package l;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public interface h extends l.d0, ReadableByteChannel {
    @Override // l.d0
    public abstract l.f A();

    @Override // l.d0
    public abstract l.i B(long l);

    @Override // l.d0
    public abstract long J1(l.b0 b0);

    @Override // l.d0
    public abstract boolean K0(long l, l.i i2);

    @Override // l.d0
    public abstract String M0(Charset charset);

    @Override // l.d0
    public abstract void V1(long l);

    @Override // l.d0
    public abstract byte[] X();

    @Override // l.d0
    public abstract l.i Y0();

    @Override // l.d0
    public abstract long a0(l.i i);

    @Override // l.d0
    public abstract boolean b0();

    @Override // l.d0
    public abstract long d2();

    @Override // l.d0
    public abstract InputStream g2();

    @Override // l.d0
    public abstract l.f h();

    @Override // l.d0
    public abstract int i2(l.t t);

    @Override // l.d0
    public abstract void k0(l.f f, long l2);

    @Override // l.d0
    public abstract String m1();

    @Override // l.d0
    public abstract long n0(l.i i);

    @Override // l.d0
    public abstract long p0();

    @Override // l.d0
    public abstract byte[] p1(long l);

    @Override // l.d0
    public abstract l.h peek();

    @Override // l.d0
    public abstract String r0(long l);

    @Override // l.d0
    public abstract String r1();

    @Override // l.d0
    public abstract byte readByte();

    @Override // l.d0
    public abstract void readFully(byte[] bArr);

    @Override // l.d0
    public abstract int readInt();

    @Override // l.d0
    public abstract long readLong();

    @Override // l.d0
    public abstract short readShort();

    @Override // l.d0
    public abstract boolean request(long l);

    @Override // l.d0
    public abstract void skip(long l);
}
