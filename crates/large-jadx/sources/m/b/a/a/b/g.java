package m.b.a.a.b;

import org.mp4parser.aspectj.lang.reflect.b;

/* loaded from: classes3.dex */
class g implements b {

    String a;
    int b;
    g(Class class, String string2, int i3) {
        super();
        this.a = string2;
        this.b = i3;
    }

    @Override // org.mp4parser.aspectj.lang.reflect.b
    public String a() {
        return this.a;
    }

    @Override // org.mp4parser.aspectj.lang.reflect.b
    public int b() {
        return this.b;
    }

    @Override // org.mp4parser.aspectj.lang.reflect.b
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(":");
        stringBuffer.append(b());
        return stringBuffer.toString();
    }
}
