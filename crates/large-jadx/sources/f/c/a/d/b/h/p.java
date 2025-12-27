package f.c.a.d.b.h;

import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
final class p extends OutputStream {

    private long a = 0;
    p() {
        super();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.a += l3;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            length = bArr.length;
            if (i <= length) {
                if (i2 >= 0) {
                    i = i + i2;
                    if (i <= length) {
                        if (i >= 0) {
                            this.a += l;
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // java.io.OutputStream
    final long a() {
        return this.a;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.a++;
    }
}
