package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.z.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class w extends FilterInputStream {

    private volatile byte[] a;
    private int b;
    private int c;
    private int v;
    private int w;
    private final b x;

    static class a extends IOException {

        private static final long serialVersionUID = -4338378848813561757L;
        a(String string) {
            super(string);
        }
    }
    public w(InputStream inputStream, b b2) {
        super(inputStream, b2, 65536);
    }

    w(InputStream inputStream, b b2, int i3) {
        super(inputStream);
        this.v = -1;
        this.x = b2;
        this.a = (byte[])b2.e(i3, byte[].class);
    }

    private int a(InputStream inputStream, byte[] b2Arr2) {
        Object i2;
        b length2;
        int length;
        int i;
        Object obj7;
        i2 = this.v;
        length2 = -1;
        final int i8 = 0;
        if (i2 != length2) {
            i = this.c;
            if (i9 -= i2 >= i) {
            } else {
                if (i2 == 0 && i > b2Arr2.length && this.b == b2Arr2.length) {
                    if (i > b2Arr2.length) {
                        if (this.b == b2Arr2.length) {
                            length3 *= 2;
                            if (i5 > i) {
                            } else {
                                i = i5;
                            }
                            i2 = this.x.e(i, byte[].class);
                            System.arraycopy(b2Arr2, i8, (byte[])i2, i8, b2Arr2.length);
                            this.a = i2;
                            this.x.d(b2Arr2);
                            obj7 = i2;
                        } else {
                            if (i2 > 0) {
                                System.arraycopy(b2Arr2, i2, b2Arr2, i8, length6 -= i2);
                            }
                        }
                    } else {
                    }
                } else {
                }
                i3 -= i6;
                this.w = i4;
                this.v = i8;
                this.b = i8;
                int obj6 = inputStream.read(obj7, i4, length4 -= i4);
                if (obj6 <= 0) {
                } else {
                    obj7 += obj6;
                }
            }
            this.b = obj7;
            return obj6;
        }
        obj6 = inputStream.read(b2Arr2);
        if (obj6 > 0) {
            this.v = length2;
            this.w = i8;
            this.b = obj6;
        }
        return obj6;
    }

    private static IOException f() {
        IOException iOException = new IOException("BufferedInputStream is closed");
        throw iOException;
    }

    @Override // java.io.FilterInputStream
    public int available() {
        InputStream inputStream = this.in;
        synchronized (this) {
            try {
                if (inputStream == null) {
                } else {
                }
                return i3 += available;
                w.f();
                throw 0;
                throw th;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public void c() {
        this.c = bArr.length;
        return;
        synchronized (this) {
            this.c = bArr.length;
        }
    }

    @Override // java.io.FilterInputStream
    public void close() {
        byte[] bArr;
        byte[] bArr2;
        final int i = 0;
        if (this.a != null) {
            this.x.d(this.a);
            this.a = i;
        }
        InputStream inputStream = this.in;
        this.in = i;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream
    public void e() {
        byte[] bArr;
        byte[] bArr2;
        synchronized (this) {
            try {
                this.x.d(this.a);
                this.a = 0;
                throw th;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public void mark(int i) {
        this.c = Math.max(this.c, i);
        this.v = this.w;
        return;
        synchronized (this) {
            this.c = Math.max(this.c, i);
            this.v = this.w;
        }
    }

    @Override // java.io.FilterInputStream
    public boolean markSupported() {
        return 1;
    }

    @Override // java.io.FilterInputStream
    public int read() {
        byte[] bArr;
        InputStream inputStream;
        bArr = this.a;
        inputStream = this.in;
        int i5 = 0;
        synchronized (this) {
            try {
                if (inputStream == null) {
                } else {
                }
                final int i9 = -1;
                if (this.w >= this.b && a(inputStream, bArr) == i9) {
                }
                if (a(inputStream, bArr) == i9) {
                }
                return i9;
                if (bArr != this.a) {
                }
                if (this.a == null) {
                } else {
                }
                w.f();
                throw i5;
                int i6 = this.w;
                if (i2 -= i6 > 0) {
                }
                this.w = i6 + 1;
                return b &= 255;
                return i9;
                w.f();
                throw i5;
                throw th;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        int available2;
        int i;
        int read;
        int length;
        int available;
        int i4;
        int i5;
        int obj9;
        bArr2 = this.a;
        final int i6 = 0;
        synchronized (this) {
            try {
                if (i3 == 0) {
                }
                return 0;
            }
            final InputStream inputStream = this.in;
            if (inputStream == null) {
            } else {
                int i7 = this.w;
                read = this.b;
                if (i7 < read) {
                    read = read - i7 >= i3 ? i3 : read - i7;
                    System.arraycopy(bArr2, i7, bArr, i2, read);
                    this.w = i8 += read;
                    if (read != i3 && inputStream.available() == 0) {
                        if (inputStream.available() == 0) {
                        }
                        try {
                            i2 += read;
                            i = i3 - read;
                            return read;
                            i = i3;
                            i4 = -1;
                            while (this.v == i4) {
                                int i10 = this.b;
                                int i11 = this.w;
                                if (i10 - i11 >= i) {
                                } else {
                                }
                                i10 -= i11;
                                System.arraycopy(bArr2, i11, bArr, obj9, read);
                                this.w = i12 += read;
                                i -= read;
                                obj9 += read;
                                i4 = -1;
                                read = i;
                            }
                            if (i >= bArr2.length) {
                            } else {
                            }
                            if (inputStream.read(bArr, obj9, i) == i4) {
                            } else {
                            }
                            if (i == i3) {
                            } else {
                            }
                            i4 = i3 - i;
                            return i4;
                            if (a(inputStream, bArr2) == i4) {
                            } else {
                            }
                            if (i == i3) {
                            } else {
                            }
                            i4 = i3 - i;
                            return i4;
                            if (bArr2 != this.a) {
                            } else {
                            }
                            if (this.a == null) {
                            } else {
                            }
                            w.f();
                            throw i6;
                            i10 = this.b;
                            i11 = this.w;
                            if (i10 - i11 >= i) {
                            } else {
                            }
                            read = i;
                            i10 -= i11;
                            System.arraycopy(bArr2, i11, bArr, obj9, read);
                            this.w = i12 += read;
                            i -= read;
                            if (i == 0) {
                            } else {
                            }
                            return i3;
                            if (inputStream.available() == 0) {
                            } else {
                            }
                            return i3 -= i;
                            obj9 += read;
                            w.f();
                            throw i6;
                            w.f();
                            throw i6;
                            throw bArr;
                        }
                    }
                }
            }
        }
    }

    @Override // java.io.FilterInputStream
    public void reset() {
        synchronized (this) {
            try {
                int i2 = this.v;
                if (-1 == i2) {
                } else {
                }
                this.w = i2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Mark has been invalidated, pos: ");
                stringBuilder.append(this.w);
                stringBuilder.append(" markLimit: ");
                stringBuilder.append(this.c);
                w.a aVar = new w.a(stringBuilder.toString());
                throw aVar;
                IOException iOException = new IOException("Stream is closed");
                throw iOException;
                throw th;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public long skip(long l) {
        int cmp;
        long l2;
        int i9 = 0;
        synchronized (this) {
            return i9;
        }
    }
}
