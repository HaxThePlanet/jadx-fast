package f.c.a.d.b.h;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
final class k extends FilterInputStream {

    private long a = 1048577;
    private long b = -1;
    k(InputStream inputStream, long j) {
        super(inputStream);
        Objects.requireNonNull(inputStream);
    }

    @Override // java.io.FilterInputStream
    public final int available() throws IOException {
        return (int)(Math.min((long)this.in.available(), this.a));
    }

    @Override // java.io.FilterInputStream
    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.b = this.a;
    }

    @Override // java.io.FilterInputStream
    public final int read() throws IOException {
        int i = -1;
        if (this.a == 0) {
            return i;
        }
        int bytesRead = this.in.read();
        if (bytesRead != i) {
            long l = -1L;
            this.a += l;
        }
        return bytesRead;
    }

    @Override // java.io.FilterInputStream
    public final synchronized void reset() {
        this.in.reset();
        this.a = this.b;
        throw new IOException("Mark not supported");
    }

    @Override // java.io.FilterInputStream
    public final long skip(long j) throws IOException {
        long skipped = this.in.skip(Math.min(j, this.a));
        this.a -= skipped;
        return skipped;
    }

    @Override // java.io.FilterInputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        final int i5 = -1;
        if (this.a == 0) {
            return i5;
        }
        i = (int)(Math.min((long)i2, this.a));
        final int bytesRead = this.in.read(bArr, i, i);
        if (bytesRead != i5) {
            this.a -= l3;
        }
        return bytesRead;
    }
}
