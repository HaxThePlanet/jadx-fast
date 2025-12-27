package m.b.a.a.b;

import org.mp4parser.aspectj.lang.reflect.b;

/* compiled from: SourceLocationImpl.java */
/* loaded from: classes3.dex */
class g implements b {

    String a;
    int b;
    g(Class cls, String str, int i) {
        super();
        this.a = str;
        this.b = i;
    }

    public String a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = a();
        String str3 = ":";
        int i = b();
        str = str2 + str3 + i;
        return str;
    }
}
