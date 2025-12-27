package l;

import kotlin.d0.d.n;

/* compiled from: PeekSource.kt */
/* loaded from: classes3.dex */
public final class v implements d0 {

    private final f a;
    private y b;
    private int c = -1;
    private boolean v;
    private long w;
    private final h x;
    public v(h hVar) {
        n.f(hVar, "upstream");
        super();
        this.x = hVar;
        l.f fVar = hVar.h();
        this.a = fVar;
        this.b = fVar.a;
        hVar = fVar.a != null ? yVar.b : -1;
    }

    public void close() {
        this.v = true;
    }

    public long read(f fVar, long j) {
        int i = 0;
        int i2;
        l.y yVar2;
        int i3;
        n.f(fVar, "sink");
        long l = 0L;
        i = 0;
        i = 1;
        int r5 = j >= l ? i : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "byteCount < 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            if (this.v ^ i == 0) {
                throw new IllegalStateException("closed".toString());
            } else {
                if (this.b != null) {
                    if (this.b == this.a.a && this.c == yVar3.b) {
                    }
                }
                if (i == 0) {
                    throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
                } else {
                    if (j == l) {
                        return l;
                    }
                    long l6 = this.w + 1L;
                    if (!this.x.request(l6)) {
                        return -1;
                    }
                    if (this.b == null) {
                        if (this.a.a != null) {
                            this.b = this.a.a;
                            n.d(this.a.a);
                            this.c = yVar.b;
                        }
                    }
                    long j22 = Math.min(j, this.a.size() - this.w);
                    this.a.j(fVar, this.w, j22);
                    this.w += j22;
                    return j22;
                }
            }
        }
    }

    public e0 timeout() {
        return this.x.timeout();
    }
}
