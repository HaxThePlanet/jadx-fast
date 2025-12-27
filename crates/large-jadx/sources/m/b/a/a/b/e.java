package m.b.a.a.b;

import org.mp4parser.aspectj.lang.reflect.a;

/* compiled from: MethodSignatureImpl.java */
/* loaded from: classes3.dex */
class e extends a implements a {

    Class k;
    e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.k = cls2;
    }

    @Override // m.b.a.a.b.a
    protected String a(h hVar) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.e(i()));
        if (hVar.b) {
            stringBuffer.append(hVar.g(n()));
        }
        if (hVar.b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.f(f(), g()));
        stringBuffer.append(".");
        stringBuffer.append(j());
        hVar.a(stringBuffer, m());
        hVar.b(stringBuffer, l());
        return stringBuffer.toString();
    }

    @Override // m.b.a.a.b.a
    public Class n() {
        if (this.k == null) {
            this.k = d(6);
        }
        return this.k;
    }
}
