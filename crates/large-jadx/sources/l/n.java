package l;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class n implements l.d0 {

    private byte a;
    private final l.x b;
    private final Inflater c;
    private final l.o v;
    private final CRC32 w;
    public n(l.d0 d0) {
        n.f(d0, "source");
        super();
        x xVar = new x(d0);
        this.b = xVar;
        Inflater obj3 = new Inflater(1);
        this.c = obj3;
        o oVar = new o(xVar, obj3);
        this.v = oVar;
        obj3 = new CRC32();
        this.w = obj3;
    }

    private final void a(String string, int i2, int i3) {
        if (i3 != i2) {
        } else {
        }
        final int i = 3;
        final Object[] arr = new Object[i];
        arr[0] = string;
        arr[1] = Integer.valueOf(i3);
        arr[2] = Integer.valueOf(i2);
        String obj5 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(arr, i));
        n.e(obj5, "java.lang.String.format(this, *args)");
        IOException iOException = new IOException(obj5);
        throw iOException;
    }

    private final void c() {
        int i;
        int i6;
        l.x xVar;
        l.x xVar2;
        int i8;
        int cmp;
        int cmp2;
        int i4;
        int i7;
        int i2;
        int i9;
        String str;
        int i5;
        byte b;
        int i10;
        int i3;
        long l2;
        long l;
        final Object obj = this;
        obj.b.V1(10);
        b = xVar4.a.n(3);
        i10 = 1;
        final int i20 = 0;
        i3 = i11 &= i10 == i10 ? i10 : i20;
        if (i3 != 0) {
            this.f(xVar15.a, 0, obj3);
        }
        str = "ID1ID2";
        obj.a(str, 8075, obj.b.readShort());
        obj.b.skip(8);
        i6 = i12 &= i10 == i10 ? i10 : i20;
        obj.b.V1(2);
        if (i6 != 0 && i3 != 0) {
            obj.b.V1(2);
            if (i3 != 0) {
                this.f(xVar9.a, 0, obj3);
            }
            l2 = (long)s;
            obj.b.V1(l2);
            if (i3 != 0) {
                this.f(xVar8.a, 0, obj3);
            }
            obj.b.skip(l2);
        }
        i8 = i14 &= i10 == i10 ? i10 : i20;
        int i21 = -1;
        final int i22 = 1;
        if (i8 != 0) {
            l = obj.b.a(i20);
            if (Long.compare(l, i21) == 0) {
            } else {
                if (i3 != 0) {
                    this.f(xVar11.a, 0, obj3);
                }
                obj.b.skip(l + i22);
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }
        if (i16 &= i10 == i10) {
        } else {
            i10 = i20;
        }
        if (i10 != 0) {
            long l3 = obj.b.a(i20);
            if (Long.compare(l3, i21) == 0) {
            } else {
                if (i3 != 0) {
                    this.f(xVar13.a, 0, obj3);
                }
                obj.b.skip(l3 += i22);
            }
            EOFException eOFException2 = new EOFException();
            throw eOFException2;
        }
        if (i3 != 0) {
            obj.a("FHCRC", obj.b.k(), (short)i19);
            obj.w.reset();
        }
    }

    private final void e() {
        a("CRC", this.b.j(), (int)value);
        a("ISIZE", this.b.j(), (int)bytesWritten);
    }

    private final void f(l.f f, long l2, long l3) {
        long l4;
        int i;
        int cmp;
        long l;
        l.y obj5;
        long obj6;
        int obj7;
        int obj8;
        n.d(f.a);
        int i2 = obj5.c;
        i = obj5.b;
        while (Long.compare(obj6, l5) >= 0) {
            obj6 -= l4;
            n.d(obj5.f);
            i2 = obj5.c;
            i = obj5.b;
        }
        int i3 = 0;
        while (Long.compare(obj8, i3) > 0) {
            obj6 = (int)i7;
            obj7 = (int)l8;
            this.w.update(obj5.a, obj6, obj7);
            obj8 -= obj6;
            n.d(obj5.f);
            obj6 = i3;
        }
    }

    @Override // l.d0
    public void close() {
        this.v.close();
    }

    @Override // l.d0
    public long read(l.f f, long l2) {
        byte cmp;
        int i;
        long size;
        byte obj12;
        int obj13;
        n.f(f, "sink");
        int i2 = 0;
        final int cmp2 = Long.compare(l2, i2);
        final int i4 = 1;
        i = cmp2 >= 0 ? i4 : 0;
        if (i == 0) {
        } else {
            if (cmp2 == 0) {
                return i2;
            }
            if (this.a == 0) {
                c();
                this.a = i4;
            }
            final int i3 = -1;
            int i5 = 2;
            obj13 = this.v.read(f, l2);
            if (this.a == i4 && Long.compare(obj13, i3) != 0) {
                obj13 = this.v.read(f, l2);
                if (Long.compare(obj13, i3) != 0) {
                    this.f(f, f.size(), obj8);
                    return obj13;
                }
                this.a = i5;
            }
            if (this.a == i5) {
                e();
                this.a = 3;
                if (!this.b.b0()) {
                } else {
                }
                obj12 = new IOException("gzip finished without exhausting source");
                throw obj12;
            }
            return i3;
        }
        obj12 = new StringBuilder();
        obj12.append("byteCount < 0: ");
        obj12.append(l2);
        obj13 = new IllegalArgumentException(obj12.toString().toString());
        throw obj13;
    }

    @Override // l.d0
    public l.e0 timeout() {
        return this.b.timeout();
    }
}
