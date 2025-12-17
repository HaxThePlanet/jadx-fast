package androidx.room;

import d.s.a.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class r0 implements i {

    private List<Object> a;
    r0() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    private void c(int i, Object object2) {
        int size;
        List list;
        int i2;
        i--;
        if (obj4 >= this.a.size()) {
            size = this.a.size();
            while (size <= obj4) {
                this.a.add(0);
                size++;
            }
        }
        this.a.set(obj4, object2);
    }

    @Override // d.s.a.i
    public void B0(int i, byte[] b2Arr2) {
        c(i, b2Arr2);
    }

    @Override // d.s.a.i
    public void D(int i, String string2) {
        c(i, string2);
    }

    @Override // d.s.a.i
    public void W(int i, double d2) {
        c(i, Double.valueOf(d2));
    }

    List<Object> a() {
        return this.a;
    }

    @Override // d.s.a.i
    public void close() {
    }

    @Override // d.s.a.i
    public void k1(int i) {
        c(i, 0);
    }

    @Override // d.s.a.i
    public void u0(int i, long l2) {
        c(i, Long.valueOf(l2));
    }
}
