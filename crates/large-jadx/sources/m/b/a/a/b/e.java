package m.b.a.a.b;

import org.mp4parser.aspectj.lang.reflect.a;

/* loaded from: classes3.dex */
class e extends m.b.a.a.b.a implements a {

    Class k;
    e(int i, String string2, Class class3, Class[] class4Arr4, String[] string5Arr5, Class[] class6Arr6, Class class7) {
        super(i, string2, class3, class4Arr4, string5Arr5, class6Arr6);
        this.k = class7;
    }

    @Override // m.b.a.a.b.a
    protected String a(m.b.a.a.b.h h) {
        boolean z;
        boolean str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h.e(i()));
        if (h.b) {
            stringBuffer.append(h.g(n()));
        }
        if (h.b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(h.f(f(), g()));
        stringBuffer.append(".");
        stringBuffer.append(j());
        h.a(stringBuffer, m());
        h.b(stringBuffer, l());
        return stringBuffer.toString();
    }

    @Override // m.b.a.a.b.a
    public Class n() {
        Class cls;
        if (this.k == null) {
            this.k = d(6);
        }
        return this.k;
    }
}
