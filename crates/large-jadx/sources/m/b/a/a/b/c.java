package m.b.a.a.b;

import org.mp4parser.aspectj.lang.a;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: JoinPointImpl.java */
/* loaded from: classes3.dex */
class c implements a {

    Object a;
    Object b;
    Object[] c;
    a.a d;

    static class a implements a.a {

        String a;
        org.mp4parser.aspectj.lang.b b;
        public a(int i, String str, org.mp4parser.aspectj.lang.b bVar, org.mp4parser.aspectj.lang.reflect.b bVar2) {
            super();
            this.a = str;
            this.b = bVar;
        }

        public String a() {
            return this.a;
        }

        public org.mp4parser.aspectj.lang.b b() {
            return this.b;
        }

        String c(h hVar) {
            final StringBuffer stringBuffer = new StringBuffer();
            String str2 = hVar.d(a());
            String str3 = "(";
            String str4 = (f)b().k(hVar);
            String str5 = ")";
            str6 = str2 + str3 + str4 + str5;
            return str6;
        }

        @Override // java.lang.Object
        public final String toString() {
            return c(h.h);
        }
    }
    public c(a.a aVar, Object object, Object object2, Object[] objectArr) {
        super();
        this.d = aVar;
        this.a = object;
        this.b = object2;
        this.c = objectArr;
    }

    public Object a() {
        return this.b;
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.d.toString();
    }
}
