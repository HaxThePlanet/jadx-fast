package l;

import java.io.OutputStream;
import kotlin.d0.d.n;

/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
final class u implements b0 {

    private final OutputStream a;
    private final e0 b;
    public u(OutputStream outputStream, e0 e0Var) {
        n.f(outputStream, "out");
        n.f(e0Var, "timeout");
        super();
        this.a = outputStream;
        this.b = e0Var;
    }

    public void close() throws java.io.IOException {
        this.a.close();
    }

    public void flush() throws java.io.IOException {
        this.a.flush();
    }

    public e0 timeout() {
        return this.b;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "sink(";
        str = str2 + this.a + 41;
        return str;
    }

    public void write(f fVar, long j) throws java.io.IOException {
        long l2;
        str = "source";
        n.f(fVar, str);
        long l = 0L;
        c.b(fVar.size(), l, j);
        while (l2 > 0) {
            this.b.throwIfReached();
            n.d(fVar.a);
            long min = Math.min(l2, (long)(obj.c - i8));
            int i6 = (int)min;
            this.a.write(obj.a, obj.b, i6);
            obj.b += i6;
            l2 = l2 - min;
            l = fVar.size() - min;
            fVar.T(l);
        }
    }
}
