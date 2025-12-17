package l;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes3.dex */
public interface g extends l.b0, WritableByteChannel {
    @Override // l.b0
    public abstract l.g E0(String string);

    @Override // l.b0
    public abstract l.g G();

    @Override // l.b0
    public abstract l.g I(int i);

    @Override // l.b0
    public abstract l.g P(int i);

    @Override // l.b0
    public abstract l.g U0(String string, int i2, int i3);

    @Override // l.b0
    public abstract long W0(l.d0 d0);

    @Override // l.b0
    public abstract l.g X0(long l);

    @Override // l.b0
    public abstract l.g Y1(long l);

    @Override // l.b0
    public abstract l.g b(byte[] bArr, int i2, int i3);

    @Override // l.b0
    public abstract OutputStream b2();

    @Override // l.b0
    public abstract l.g c0(int i);

    @Override // l.b0
    public abstract void flush();

    @Override // l.b0
    public abstract l.f h();

    @Override // l.b0
    public abstract l.g o0();

    @Override // l.b0
    public abstract l.g w1(byte[] bArr);

    @Override // l.b0
    public abstract l.g y1(l.i i);
}
