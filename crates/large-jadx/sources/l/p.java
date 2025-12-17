package l;

import java.io.IOException;
import java.io.InputStream;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
final class p implements l.d0 {

    private final InputStream a;
    private final l.e0 b;
    public p(InputStream inputStream, l.e0 e02) {
        n.f(inputStream, "input");
        n.f(e02, "timeout");
        super();
        this.a = inputStream;
        this.b = e02;
    }

    @Override // l.d0
    public void close() {
        this.a.close();
    }

    @Override // l.d0
    public long read(l.f f, long l2) {
        int i;
        int obj5;
        n.f(f, "sink");
        int i2 = 0;
        int cmp = Long.compare(l2, i2);
        if (cmp == 0) {
            return i2;
        }
        int i3 = 1;
        i = cmp >= 0 ? i3 : 0;
        if (i == 0) {
        } else {
            this.b.throwIfReached();
            l.y yVar = f.Y(i3);
            byte[] bArr = yVar.a;
            obj5 = this.a.read(bArr, yVar.c, (int)obj5);
            if (obj5 == -1 && yVar.b == yVar.c) {
                if (yVar.b == yVar.c) {
                    f.a = yVar.b();
                    z.b(yVar);
                }
                return -1;
            }
            yVar.c = obj6 += obj5;
            obj5 = (long)obj5;
            f.T(size += obj5);
            return obj5;
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("byteCount < 0: ");
        obj4.append(l2);
        obj5 = new IllegalArgumentException(obj4.toString().toString());
        throw obj5;
    }

    @Override // l.d0
    public l.e0 timeout() {
        return this.b;
    }

    @Override // l.d0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("source(");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
