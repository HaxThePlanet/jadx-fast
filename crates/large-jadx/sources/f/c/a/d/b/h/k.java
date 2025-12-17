package f.c.a.d.b.h;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes2.dex */
final class k extends FilterInputStream {

    private long a = 1048577;
    private long b = -1;
    k(InputStream inputStream, long l2) {
        super(inputStream);
        final int obj2 = -1;
        Objects.requireNonNull(inputStream);
        final int obj1 = 1048577;
    }

    @Override // java.io.FilterInputStream
    public final int available() {
        return (int)l2;
    }

    @Override // java.io.FilterInputStream
    public final void mark(int i) {
        this.in.mark(i);
        this.b = this.a;
        return;
        synchronized (this) {
            this.in.mark(i);
            this.b = this.a;
        }
    }

    @Override // java.io.FilterInputStream
    public final int read() {
        int i;
        int i2;
        i = -1;
        if (Long.compare(l, i3) == 0) {
            return i;
        }
        int read = this.in.read();
        if (read != i) {
            this.a = l2 += i2;
        }
        return read;
    }

    @Override // java.io.FilterInputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int i;
        int obj8;
        long l = this.a;
        final int i5 = -1;
        if (Long.compare(l, i4) == 0) {
            return i5;
        }
        final int obj7 = this.in.read(bArr, i2, (int)l2);
        if (obj7 != i5) {
            this.a = obj8 -= i;
        }
        return obj7;
    }

    @Override // java.io.FilterInputStream
    public final void reset() {
        synchronized (this) {
            try {
                if (Long.compare(l, i) == 0) {
                } else {
                }
                this.in.reset();
                this.a = this.b;
                IOException iOException = new IOException("Mark not set");
                throw iOException;
                IOException iOException2 = new IOException("Mark not supported");
                throw iOException2;
                throw th;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public final long skip(long l) {
        long obj3 = this.in.skip(Math.min(l, obj4));
        this.a = l3 -= obj3;
        return obj3;
    }
}
