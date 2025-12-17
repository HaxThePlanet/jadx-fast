package l;

import java.util.zip.Deflater;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class j implements l.b0 {

    private boolean a;
    private final l.g b;
    private final Deflater c;
    public j(l.b0 b0, Deflater deflater2) {
        n.f(b0, "sink");
        n.f(deflater2, "deflater");
        super(q.c(b0), deflater2);
    }

    public j(l.g g, Deflater deflater2) {
        n.f(g, "sink");
        n.f(deflater2, "deflater");
        super();
        this.b = g;
        this.c = deflater2;
    }

    private final void a(boolean z) {
        Object obj;
        boolean needsInput;
        byte[] bArr;
        int i3;
        int i;
        int i2;
        int obj8;
        l.f fVar = this.b.h();
        obj = fVar.Y(1);
        do {
            obj = fVar.Y(1);
            i3 = obj.c;
            needsInput = this.c.deflate(obj.a, i3, i3 - 8192);
            if (needsInput > 0) {
            }
            if (!this.c.needsInput()) {
            }
            obj.c = i6 += needsInput;
            fVar.T(size += l);
            this.b.o0();
            i3 = obj.c;
            needsInput = this.c.deflate(obj.a, i3, i3 - 8192, 2);
        } while (z);
        if (obj.b == obj.c) {
            fVar.a = obj.b();
            z.b(obj);
        }
    }

    @Override // l.b0
    public final void c() {
        this.c.finish();
        a(false);
    }

    @Override // l.b0
    public void close() {
        int i;
        Deflater deflater;
        l.g gVar;
        if (this.a) {
        }
        i = 0;
        c();
        this.c.end();
        this.b.close();
        this.a = true;
        if (i != 0) {
        } else {
            try {
                throw i;
            }
        }
    }

    @Override // l.b0
    public void flush() {
        a(true);
        this.b.flush();
    }

    @Override // l.b0
    public l.e0 timeout() {
        return this.b.timeout();
    }

    @Override // l.b0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeflaterSink(");
        stringBuilder.append(this.b);
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
            str = f.a;
            n.d(str);
            int i6 = str.b;
            int i5 = (int)l5;
            i = str.a;
            this.c.setInput(i, str.b, i5);
            a(false);
            l3 = (long)i5;
            f.T(size2 -= l3);
            i9 += i5;
            str.b = l;
            if (l == str.c) {
            }
            obj9 -= l3;
            f.a = str.b();
            z.b(str);
        }
    }
}
