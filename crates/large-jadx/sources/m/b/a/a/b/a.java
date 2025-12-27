package m.b.a.a.b;

import org.mp4parser.aspectj.lang.b;

/* compiled from: CodeSignatureImpl.java */
/* loaded from: classes3.dex */
abstract class a extends d implements b {

    Class[] i;
    Class[] j;
    a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.i = clsArr;
        this.j = clsArr2;
    }

    @Override // m.b.a.a.b.d
    public Class[] l() {
        if (this.j == null) {
            this.j = e(5);
        }
        return this.j;
    }

    @Override // m.b.a.a.b.d
    public Class[] m() {
        if (this.i == null) {
            this.i = e(3);
        }
        return this.i;
    }
}
