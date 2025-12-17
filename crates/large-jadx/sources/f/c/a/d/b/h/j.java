package f.c.a.d.b.h;

import java.io.OutputStream;
import java.util.Objects;

/* loaded from: classes2.dex */
final class j extends OutputStream {
    @Override // java.io.OutputStream
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        Objects.requireNonNull(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr);
    }
}
