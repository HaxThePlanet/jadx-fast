package f.c.a.d.b.j;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.i;
import f.c.a.d.c.e;
import f.c.a.d.c.g;

/* loaded from: classes2.dex */
public class j {

    static class a implements e {

        private final Status a;
        private final g b;
        public a(Status status, g g2) {
            super();
            this.a = status;
            this.b = g2;
        }

        @Override // f.c.a.d.c.e
        public final String E1() {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.E1();
        }

        @Override // f.c.a.d.c.e
        public final Status m() {
            return this.a;
        }
    }

    static abstract class b extends f.c.a.d.b.j.e<e> {

        protected f.c.a.d.b.j.f p;
        public b(d d) {
            super(d);
            l obj1 = new l(this);
            this.p = obj1;
        }

        @Override // f.c.a.d.b.j.e
        protected i c(Status status) {
            j.a aVar = new j.a(status, 0);
            return aVar;
        }
    }
    static {
    }

    public static e<e> a(d d, byte[] b2Arr2, String string3) {
        k kVar = new k(d, b2Arr2, string3);
        return d.a(kVar);
    }
}
