package androidx.room;

import d.s.a.i;
import d.s.a.k;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class s0 implements k {

    private final k a;
    private final androidx.room.u0.f b;
    private final String c;
    private final List<Object> v;
    private final Executor w;
    s0(k k, androidx.room.u0.f u0$f2, String string3, Executor executor4) {
        super();
        ArrayList arrayList = new ArrayList();
        this.v = arrayList;
        this.a = k;
        this.b = f2;
        this.c = string3;
        this.w = executor4;
    }

    private void a() {
        this.b.a(this.c, this.v);
    }

    private void e() {
        this.b.a(this.c, this.v);
    }

    private void i(int i, Object object2) {
        int size;
        List list;
        int i2;
        i--;
        if (obj4 >= this.v.size()) {
            size = this.v.size();
            while (size <= obj4) {
                this.v.add(0);
                size++;
            }
        }
        this.v.set(obj4, object2);
    }

    @Override // d.s.a.k
    public void B0(int i, byte[] b2Arr2) {
        i(i, b2Arr2);
        this.a.B0(i, b2Arr2);
    }

    @Override // d.s.a.k
    public void D(int i, String string2) {
        i(i, string2);
        this.a.D(i, string2);
    }

    @Override // d.s.a.k
    public int N() {
        s sVar = new s(this);
        this.w.execute(sVar);
        return this.a.N();
    }

    @Override // d.s.a.k
    public void W(int i, double d2) {
        i(i, Double.valueOf(d2));
        this.a.W(i, d2);
    }

    @Override // d.s.a.k
    public long a2() {
        r rVar = new r(this);
        this.w.execute(rVar);
        return this.a.a2();
    }

    @Override // d.s.a.k
    public void c() {
        a();
    }

    @Override // d.s.a.k
    public void close() {
        this.a.close();
    }

    @Override // d.s.a.k
    public void f() {
        e();
    }

    @Override // d.s.a.k
    public void k1(int i) {
        i(i, this.v.toArray());
        this.a.k1(i);
    }

    @Override // d.s.a.k
    public void u0(int i, long l2) {
        i(i, Long.valueOf(l2));
        this.a.u0(i, l2);
    }
}
