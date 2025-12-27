package l;

import java.util.zip.Deflater;
import kotlin.d0.d.n;

/* compiled from: DeflaterSink.kt */
/* loaded from: classes3.dex */
public final class j implements b0 {

    private boolean a;
    private final g b;
    private final Deflater c;
    public j(g gVar, Deflater deflater) {
        n.f(gVar, "sink");
        n.f(deflater, "deflater");
        super();
        this.b = gVar;
        this.c = deflater;
    }

    private final void a(boolean z) {
        boolean needsInput;
        byte[] bArr;
        int i;
        int i2;
        int i3;
        l.f fVar = this.b.h();
        l.y yVar = fVar.Y(1);
        do {
            yVar = fVar.Y(1);
            i2 = i - 8192;
            int deflate = this.c.deflate(yVar.a, yVar.c, i2);
            i2 = i - 8192;
            i3 = 2;
            int deflate2 = this.c.deflate(yVar.a, yVar.c, i2, i3);
        } while (z);
        if (yVar.b == yVar.c) {
            fVar.a = yVar.b();
            z.b(yVar);
        }
    }

    public final void c() {
        this.c.finish();
        a(false);
    }

    public void close() {
        int i = 0;
        if (this.a) {
            return;
        }
        i = 0;
        try {
            c();
        } catch (Throwable th) {
        }
        try {
            this.c.end();
        } catch (Throwable th) {
        }
        try {
            this.b.close();
        } catch (Throwable th) {
        }
        this.a = true;
        if (this.a != 0) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
    }

    public void flush() {
        a(true);
        this.b.flush();
    }

    public e0 timeout() {
        return this.b.timeout();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DeflaterSink(";
        str = str2 + this.b + 41;
        return str;
    }

    public void write(f fVar, long j) {
        long size;
        long l2;
        str = "source";
        n.f(fVar, str);
        long l = 0L;
        c.b(fVar.size(), l, j);
        while (l2 > 0) {
            n.d(fVar.a);
            long min = Math.min(l2, (long)(obj.c - i7));
            int i5 = (int)min;
            this.c.setInput(obj.a, obj.b, i5);
            a(false);
            fVar.T(fVar.size() - min);
            obj.b += i5;
            l2 = l2 - min;
        }
    }

    public j(b0 b0Var, Deflater deflater) {
        n.f(b0Var, "sink");
        n.f(deflater, "deflater");
        this(q.c(b0Var), deflater);
    }
}
