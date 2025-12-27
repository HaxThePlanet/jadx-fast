package l;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.d0.d.n;

/* compiled from: GzipSource.kt */
/* loaded from: classes3.dex */
public final class n implements d0 {

    private byte a;
    private final x b = new x();
    private final Inflater c = new Inflater(1);
    private final o v = new o();
    private final CRC32 w = new CRC32();
    public n(d0 d0Var) {
        n.f(d0Var, "source");
        super();
        l.o oVar = new o(new x(d0Var), new Inflater(true));
        CRC32 crc32 = new CRC32();
    }

    private final void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            i = 3;
            final Object[] arr = new Object[i];
            arr[0] = str;
            arr[1] = Integer.valueOf(i2);
            arr[2] = Integer.valueOf(i);
            String formatted = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(arr, i));
            n.e(formatted, "java.lang.String.format(this, *args)");
            throw new IOException(formatted);
        }
    }

    private final void c() throws EOFException {
        int i2;
        int i3;
        long l2 = 2;
        String str = null;
        int i4 = 10;
        byte b2 = 1;
        final Object obj3 = this;
        obj3.b.V1(10L);
        long l = 3L;
        byte b = obj3.b.a.n(l);
        i2 = 1;
        i = (b >> 1) & i2;
        b2 = (byte) 0;
        int r10 = (b >> 1 & i2) == i2 ? i2 : b2;
        if (i2 != 0) {
            long l3 = 0L;
            i4 = 10;
            this.f(obj3.b.a, l3, i4);
        }
        str = "ID1ID2";
        obj3.a(str, 8075, obj3.b.readShort());
        l2 = 8L;
        obj3.b.skip(l2);
        int r0 = ((b >> 2) & i2) == i2 ? i2 : b2;
        if (obj3.b != 0) {
            l2 = 2L;
            obj3.b.V1(l2);
            if (i2 != 0) {
                i4 = 2;
                this.f(obj3.b.a, 0L, i4);
            }
            l4 = (long)obj3.b.a.J();
            obj3.b.V1(l4);
            if (i2 != 0) {
                this.f(obj3.b.a, 0L, l4);
            }
            obj3.b.skip(l4);
        }
        r0 = ((b >> 3) & i2) == i2 ? i2 : b2;
        long l15 = -1L;
        final long l16 = 1L;
        if (obj3.b != 0) {
            long l5 = obj3.b.a(b2);
            if (l5 == l15) {
                throw new EOFException();
            } else {
                if (i2 != 0) {
                    this.f(obj3.b.a, 0L, l5 + 1L);
                }
                l2 = l5 + 1L;
                obj3.b.skip(l2);
            }
        }
        i3 = (b >> 4) & i2;
        if ((b >> 4 & i2) != i2) {
        }
        if (b2 != 0) {
            long l13 = obj3.b.a(b2);
            if (l13 == l15) {
                throw new EOFException();
            } else {
                if (i2 != 0) {
                    this.f(obj3.b.a, 0L, l13 + 1L);
                }
                obj3.b.skip(l13 + 1L);
            }
        }
        if (i2 != 0) {
            str = "FHCRC";
            obj3.a(str, obj3.b.k(), (short)(int)obj3.w.getValue());
            obj3.w.reset();
        }
    }

    private final void e() {
        a("CRC", this.b.j(), (int)this.w.getValue());
        a("ISIZE", this.b.j(), (int)this.c.getBytesWritten());
    }

    private final void f(f fVar, long j, long j2) {
        long l8;
        l.y yVar;
        long l2;
        long l3;
        n.d(fVar.a);
        long l4 = (long)(i3 - i);
        while (l2 >= l4) {
            l = (long)(i3 - i);
            l2 = l2 - l;
            n.d(yVar.f);
            l4 = (long)(i3 - i);
        }
        l2 = 0L;
        while (l3 > yVar.c) {
            int i7 = (int)(long)yVar.b + l2;
            long min = Math.min((long)(yVar.c - i7), l3);
            i2 = (int)min;
            this.w.update(yVar.a, i7, i2);
            l3 = l3 - min;
            n.d(yVar.f);
        }
    }

    public void close() {
        this.v.close();
    }

    public long read(f fVar, long j) throws IOException {
        int i = 0;
        n.f(fVar, "sink");
        long l = 0L;
        final byte b4 = (byte) 1;
        byte r4 = j >= l ? b4 : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "byteCount < 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            if (j == l) {
                return l;
            }
            if (this.a == 0) {
                c();
                this.a = b4;
            }
            final long l2 = -1L;
            byte b5 = (byte) 2;
            if (this.a == b4) {
                long j22 = this.v.read(fVar, j);
                if (j22 != l2) {
                    this.f(fVar, fVar.size(), j22);
                    return j22;
                }
                this.a = b5;
            }
            if (this.a == b5) {
                e();
                this.a = (byte) 3;
                if (!this.b.b0()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return l2;
        }
    }

    public e0 timeout() {
        return this.b.timeout();
    }
}
