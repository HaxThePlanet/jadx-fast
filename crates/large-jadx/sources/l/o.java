package l;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class o implements l.d0 {

    private int a;
    private boolean b;
    private final l.h c;
    private final Inflater v;
    public o(l.d0 d0, Inflater inflater2) {
        n.f(d0, "source");
        n.f(inflater2, "inflater");
        super(q.d(d0), inflater2);
    }

    public o(l.h h, Inflater inflater2) {
        n.f(h, "source");
        n.f(inflater2, "inflater");
        super();
        this.c = h;
        this.v = inflater2;
    }

    private final void e() {
        int i = this.a;
        if (i == 0) {
        }
        i -= remaining;
        this.a = i3 -= i2;
        this.c.skip((long)i2);
    }

    @Override // l.d0
    public final long a(l.f f, long l2) {
        int i;
        int obj7;
        n.f(f, "sink");
        int i2 = 0;
        int cmp = Long.compare(l2, i2);
        int i4 = 1;
        i = cmp >= 0 ? i4 : 0;
        if (i == 0) {
        } else {
            z ^= i4;
            if (i7 == 0) {
            } else {
                if (cmp == 0) {
                    return i2;
                }
                l.y yVar = f.Y(i4);
                c();
                obj7 = this.v.inflate(yVar.a, yVar.c, (int)obj7);
                e();
                if (obj7 > 0) {
                    yVar.c = obj8 += obj7;
                    obj7 = (long)obj7;
                    f.T(size += obj7);
                    return obj7;
                }
                if (yVar.b == yVar.c) {
                    f.a = yVar.b();
                    z.b(yVar);
                }
                return i2;
            }
            IllegalStateException obj6 = new IllegalStateException("closed".toString());
            throw obj6;
        }
        obj6 = new StringBuilder();
        obj6.append("byteCount < 0: ");
        obj6.append(l2);
        obj7 = new IllegalArgumentException(obj6.toString().toString());
        throw obj7;
    }

    @Override // l.d0
    public final boolean c() {
        final int i2 = 0;
        if (!this.v.needsInput()) {
            return i2;
        }
        if (this.c.b0()) {
            return 1;
        }
        l.y yVar = fVar.a;
        n.d(yVar);
        final int i5 = yVar.b;
        i3 -= i5;
        this.a = i4;
        this.v.setInput(yVar.a, i5, i4);
        return i2;
    }

    @Override // l.d0
    public void close() {
        if (this.b) {
        }
        this.v.end();
        this.b = true;
        this.c.close();
    }

    @Override // l.d0
    public long read(l.f f, long l2) {
        String str;
        boolean needsDictionary;
        int cmp;
        n.f(f, "sink");
        long l = a(f, l2);
        while (Long.compare(l, i) > 0) {
            l = a(f, l2);
        }
        return l;
    }

    @Override // l.d0
    public l.e0 timeout() {
        return this.c.timeout();
    }
}
