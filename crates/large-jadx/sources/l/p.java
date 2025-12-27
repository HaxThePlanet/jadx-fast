package l;

import java.io.IOException;
import java.io.InputStream;
import kotlin.d0.d.n;

/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
final class p implements d0 {

    private final InputStream a;
    private final e0 b;
    public p(InputStream inputStream, e0 e0Var) {
        n.f(inputStream, "input");
        n.f(e0Var, "timeout");
        super();
        this.a = inputStream;
        this.b = e0Var;
    }

    public void close() throws IOException {
        this.a.close();
    }

    public long read(f fVar, long j) throws IOException {
        int i = 0;
        n.f(fVar, "sink");
        long l = 0L;
        if (j == l) {
            return l;
        }
        i = 1;
        int r1 = j >= l ? i : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "byteCount < 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            try {
                this.b.throwIfReached();
                l.y yVar = fVar.Y(i);
                int bytesRead = this.a.read(yVar.a, yVar.c, (int)(Math.min(j, (long)(yVar.c - 8192))));
                if (bytesRead == -1) {
                    if (yVar.b == yVar.c) {
                        fVar.a = yVar.b();
                        z.b(yVar);
                    }
                    return -1;
                }
                yVar.c += bytesRead;
                long l4 = (long)bytesRead;
                fVar.T(fVar.size() + l4);
            } catch (java.lang.AssertionError e) {
                j = q.e(e);
            }
            return l4;
        }
    }

    public e0 timeout() {
        return this.b;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "source(";
        str = str2 + this.a + 41;
        return str;
    }
}
