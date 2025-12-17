package f.c.a.d.b.h;

import java.io.OutputStream;

/* loaded from: classes2.dex */
final class p extends OutputStream {

    private long a = 0;
    p() {
        super();
        final int i = 0;
    }

    @Override // java.io.OutputStream
    final long a() {
        return this.a;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.a = l += i3;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.a = l += l2;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        int obj3;
        int obj4;
        if (i2 < 0) {
        } else {
            obj3 = bArr.length;
            if (i2 > obj3) {
            } else {
                if (i3 < 0) {
                } else {
                    i2 += i3;
                    if (obj4 > obj3) {
                    } else {
                        if (obj4 < 0) {
                        } else {
                            this.a = obj3 += l;
                        }
                    }
                }
            }
        }
        obj3 = new IndexOutOfBoundsException();
        throw obj3;
    }
}
