package m.b.a.a.b;

import org.mp4parser.aspectj.lang.a;
import org.mp4parser.aspectj.lang.a.a;
import org.mp4parser.aspectj.lang.b;
import org.mp4parser.aspectj.lang.reflect.b;

/* loaded from: classes3.dex */
class c implements a {

    Object a;
    Object b;
    Object[] c;
    a.a d;

    static class a implements a.a {

        String a;
        b b;
        public a(int i, String string2, b b3, b b4) {
            super();
            this.a = string2;
            this.b = b3;
        }

        @Override // org.mp4parser.aspectj.lang.a$a
        public String a() {
            return this.a;
        }

        @Override // org.mp4parser.aspectj.lang.a$a
        public b b() {
            return this.b;
        }

        @Override // org.mp4parser.aspectj.lang.a$a
        String c(m.b.a.a.b.h h) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(h.d(a()));
            stringBuffer.append("(");
            stringBuffer.append((f)b().k(h));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        @Override // org.mp4parser.aspectj.lang.a$a
        public final String toString() {
            return c(h.h);
        }
    }
    public c(a.a a$a, Object object2, Object object3, Object[] object4Arr4) {
        super();
        this.d = a;
        this.a = object2;
        this.b = object3;
        this.c = object4Arr4;
    }

    @Override // org.mp4parser.aspectj.lang.a
    public Object a() {
        return this.b;
    }

    @Override // org.mp4parser.aspectj.lang.a
    public final String toString() {
        return this.d.toString();
    }
}
