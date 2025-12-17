package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class n extends InputStream {

    private final InputStream a;
    private long b;
    private long c;
    private long v;
    private long w;
    private boolean x;
    private int y;
    n(InputStream inputStream) {
        super(inputStream, 4096);
    }

    n(InputStream inputStream, int i2) {
        super(inputStream, i2, 1024);
    }

    private n(InputStream inputStream, int i2, int i3) {
        boolean bufferedInputStream;
        Object obj3;
        super();
        this.w = -1;
        this.x = true;
        this.y = -1;
        if (!inputStream.markSupported()) {
            bufferedInputStream = new BufferedInputStream(inputStream, i2);
            obj3 = bufferedInputStream;
        }
        this.a = obj3;
        this.y = i3;
    }

    private void f(long l) {
        int cmp;
        InputStream inputStream;
        int i;
        long l2;
        try {
            l2 = this.b;
            if (Long.compare(l3, l2) < 0 && Long.compare(l2, l4) <= 0) {
            } else {
            }
            if (Long.compare(l2, l4) <= 0) {
            } else {
            }
            this.a.reset();
            i = (int)i3;
            this.a.mark(i);
            i(this.c, i);
            this.c = l2;
            this.a.mark((int)i2);
            this.v = l;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to mark: ");
            stringBuilder.append(l);
            l = stringBuilder.toString();
            obj6 = new IllegalStateException(l);
            throw obj6;
        }
    }

    private void i(long l, long l2) {
        long skip;
        int read;
        int i;
        int cmp;
        while (Long.compare(l, obj7) < 0) {
            if (Long.compare(skip, i2) == 0) {
                break;
            } else {
            }
            l += skip;
            if (read() == -1) {
                break;
            } else {
            }
            skip = 1;
        }
    }

    @Override // java.io.InputStream
    public void a(boolean z) {
        this.x = z;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.available();
    }

    @Override // java.io.InputStream
    public void c(long l) {
        int cmp;
        if (Long.compare(l2, l5) > 0) {
        } else {
            if (Long.compare(l, l3) < 0) {
            } else {
                this.a.reset();
                i(this.c, obj1);
                this.b = l;
            }
        }
        IOException obj5 = new IOException("Cannot reset");
        throw obj5;
    }

    @Override // java.io.InputStream
    public void close() {
        this.a.close();
    }

    @Override // java.io.InputStream
    public long e(int i) {
        l += l3;
        if (Long.compare(l4, i2) < 0) {
            f(i2);
        }
        return this.b;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.w = e(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        boolean cmp;
        int i2;
        int i;
        long l;
        final int i3 = 1;
        l = this.v;
        if (!this.x && Long.compare(i2, l) > 0) {
            l = this.v;
            if (Long.compare(i2, l) > 0) {
                f(l += i2);
            }
        }
        int read = this.a.read();
        if (read != -1) {
            this.b = l2 += i3;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        boolean z;
        int i;
        int cmp;
        long l;
        z = this.b;
        if (!this.x && Long.compare(i3, l) > 0) {
            z = this.b;
            if (Long.compare(i3, l) > 0) {
                f(i2 += cmp);
            }
        }
        final int obj7 = this.a.read(bArr);
        if (obj7 != -1) {
            this.b = l2 += cmp;
        }
        return obj7;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        boolean z;
        InputStream inputStream;
        long l2;
        int cmp;
        long l;
        int obj10;
        z = this.b;
        l2 = (long)i3;
        if (!this.x && Long.compare(i5, l) > 0) {
            z = this.b;
            l2 = (long)i3;
            if (Long.compare(i5, l) > 0) {
                f(i += l2);
            }
        }
        final int obj9 = this.a.read(bArr, i2, i3);
        if (obj9 != -1) {
            this.b = obj10 += inputStream;
        }
        return obj9;
    }

    @Override // java.io.InputStream
    public void reset() {
        c(this.w);
    }

    @Override // java.io.InputStream
    public long skip(long l) {
        boolean z;
        int cmp;
        long l2;
        z = this.b;
        if (!this.x && Long.compare(i3, l2) > 0) {
            z = this.b;
            if (Long.compare(i3, l2) > 0) {
                f(i2 += cmp);
            }
        }
        final long obj7 = this.a.skip(l);
        this.b = l3 += obj7;
        return obj7;
    }
}
