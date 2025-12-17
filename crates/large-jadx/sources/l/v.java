package l;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class v implements l.d0 {

    private final l.f a;
    private l.y b;
    private int c = -1;
    private boolean v;
    private long w;
    private final l.h x;
    public v(l.h h) {
        n.f(h, "upstream");
        super();
        this.x = h;
        l.f obj2 = h.h();
        this.a = obj2;
        obj2 = obj2.a;
        this.b = obj2;
        obj2 = obj2 != null ? obj2.b : obj2;
        obj2 = -1;
    }

    @Override // l.d0
    public void close() {
        this.v = true;
    }

    @Override // l.d0
    public long read(l.f f, long l2) {
        l.y yVar3;
        int i;
        int i2;
        l.y yVar;
        l.y yVar2;
        n.f(f, "sink");
        int i3 = 0;
        int cmp = Long.compare(l2, i3);
        int i8 = 1;
        i2 = cmp >= 0 ? i8 : i;
        if (i2 == 0) {
        } else {
            if (z ^= i8 == 0) {
            } else {
                yVar = this.b;
                if (yVar != null) {
                    yVar2 = fVar4.a;
                    n.d(yVar2);
                    if (yVar == yVar2 && this.c == yVar2.b) {
                        n.d(yVar2);
                        if (this.c == yVar2.b) {
                            i = i8;
                        }
                    }
                } else {
                }
                if (i == 0) {
                } else {
                    if (cmp == 0) {
                        return i3;
                    }
                    l3 += i7;
                    if (!this.x.request(i6)) {
                        return -1;
                    }
                    yVar3 = fVar2.a;
                    if (this.b == null && yVar3 != null) {
                        yVar3 = fVar2.a;
                        if (yVar3 != null) {
                            this.b = yVar3;
                            n.d(yVar3);
                            this.c = yVar3.b;
                        }
                    }
                    long obj10 = Math.min(l2, obj11);
                    this.a.j(f, this.w, yVar);
                    this.w = l += obj10;
                    return obj10;
                }
                IllegalStateException obj9 = new IllegalStateException("Peek source is invalid because upstream source was used".toString());
                throw obj9;
            }
            obj9 = new IllegalStateException("closed".toString());
            throw obj9;
        }
        obj9 = new StringBuilder();
        obj9.append("byteCount < 0: ");
        obj9.append(l2);
        obj10 = new IllegalArgumentException(obj9.toString().toString());
        throw obj10;
    }

    @Override // l.d0
    public l.e0 timeout() {
        return this.x.timeout();
    }
}
