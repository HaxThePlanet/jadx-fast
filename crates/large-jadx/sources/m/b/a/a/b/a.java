package m.b.a.a.b;

import org.mp4parser.aspectj.lang.b;

/* loaded from: classes3.dex */
abstract class a extends m.b.a.a.b.d implements b {

    Class[] i;
    Class[] j;
    a(int i, String string2, Class class3, Class[] class4Arr4, String[] string5Arr5, Class[] class6Arr6) {
        super(i, string2, class3);
        this.i = class4Arr4;
        this.j = class6Arr6;
    }

    @Override // m.b.a.a.b.d
    public Class[] l() {
        Class[] objArr;
        if (this.j == null) {
            this.j = e(5);
        }
        return this.j;
    }

    @Override // m.b.a.a.b.d
    public Class[] m() {
        Class[] objArr;
        if (this.i == null) {
            this.i = e(3);
        }
        return this.i;
    }
}
