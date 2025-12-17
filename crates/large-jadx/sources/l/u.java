package l;

import java.io.OutputStream;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
final class u implements l.b0 {

    private final OutputStream a;
    private final l.e0 b;
    public u(OutputStream outputStream, l.e0 e02) {
        n.f(outputStream, "out");
        n.f(e02, "timeout");
        super();
        this.a = outputStream;
        this.b = e02;
    }

    @Override // l.b0
    public void close() {
        this.a.close();
    }

    @Override // l.b0
    public void flush() {
        this.a.flush();
    }

    @Override // l.b0
    public l.e0 timeout() {
        return this.b;
    }

    @Override // l.b0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sink(");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // l.b0
    public void write(l.f f, long l2) {
        String str;
        long size;
        long l;
        int i;
        long l3;
        int obj9;
        n.f(f, "source");
        c.b(f.size(), obj2, 0);
        while (Long.compare(obj9, i2) > 0) {
            this.b.throwIfReached();
            str = f.a;
            n.d(str);
            int i6 = str.b;
            int i5 = (int)l5;
            l3 = str.b;
            this.a.write(str.a, l3, i5);
            str.b = i7 += i5;
            long l6 = (long)i5;
            obj9 -= l6;
            f.T(size2 -= l6);
            if (str.b == str.c) {
            }
            f.a = str.b();
            z.b(str);
        }
    }
}
