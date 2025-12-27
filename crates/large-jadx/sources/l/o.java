package l;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.d0.d.n;

/* compiled from: InflaterSource.kt */
/* loaded from: classes3.dex */
public final class o implements d0 {

    private int a;
    private boolean b;
    private final h c;
    private final Inflater v;
    public o(h hVar, Inflater inflater) {
        n.f(hVar, "source");
        n.f(inflater, "inflater");
        super();
        this.c = hVar;
        this.v = inflater;
    }

    private final void e() {
        if (this.a == 0) {
            return;
        }
        int i2 = i - this.v.getRemaining();
        this.a -= i2;
        this.c.skip((long)i2);
    }

    public final long a(f fVar, long j) throws IOException {
        int i = 0;
        n.f(fVar, "sink");
        long l = 0L;
        i = 1;
        int r4 = j >= l ? i : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "byteCount < 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            int i5 = this.b ^ i;
            if (this.b == 0) {
                throw new IllegalStateException("closed".toString());
            } else {
                if (j == l) {
                    return l;
                }
                try {
                    l.y yVar = fVar.Y(i);
                    c();
                    int inflate = this.v.inflate(yVar.a, yVar.c, (int)(Math.min(j, (long)(yVar.c - 8192))));
                    e();
                    if (inflate > 0) {
                        yVar.c += inflate;
                        long l4 = (long)inflate;
                        fVar.T(fVar.size() + l4);
                        return l4;
                    }
                    if (yVar.b == yVar.c) {
                        fVar.a = yVar.b();
                        z.b(yVar);
                    }
                } catch (java.util.zip.DataFormatException dataFormat) {
                    j = new IOException(dataFormat);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) j;
                }
                return l;
            }
        }
    }

    public final boolean c() {
        final boolean z2 = false;
        if (!this.v.needsInput()) {
            return false;
        }
        if (this.c.b0()) {
            return true;
        }
        n.d(yVar);
        int i3 = yVar.c - i4;
        this.a = i3;
        this.v.setInput(yVar.a, yVar.b, i3);
        return false;
    }

    public void close() {
        if (this.b) {
            return;
        }
        this.v.end();
        this.b = true;
        this.c.close();
    }

    public long read(f fVar, long j) throws EOFException {
        str = "sink";
        n.f(fVar, str);
        long l = a(fVar, j);
        while (l > 0) {
        }
        return l;
    }

    public e0 timeout() {
        return this.c.timeout();
    }

    public o(d0 d0Var, Inflater inflater) {
        n.f(d0Var, "source");
        n.f(inflater, "inflater");
        this(q.d(d0Var), inflater);
    }
}
