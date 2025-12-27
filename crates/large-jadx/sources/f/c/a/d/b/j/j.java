package f.c.a.d.b.j;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.i;
import f.c.a.d.c.g;

/* loaded from: classes2.dex */
public class j {

    static class a implements f.c.a.d.c.e {

        private final Status a;
        private final g b;
        public a(Status status, g gVar) {
            super();
            this.a = status;
            this.b = gVar;
        }

        public final String E1() {
            if (this.b == null) {
                return null;
            }
            return this.b.E1();
        }

        public final Status m() {
            return this.a;
        }
    }

    static abstract class b extends e<f.c.a.d.c.e> {

        protected f p = new l();
        public b(d dVar) {
            super(dVar);
            final f.c.a.d.b.j.l lVar = new l(this);
        }

        @Override // f.c.a.d.b.j.e
        protected /* synthetic */ i c(Status status) {
            return new j.a(status, null);
        }
    }

    public static com.google.android.gms.common.api.e<f.c.a.d.c.e> a(d dVar, byte[] bArr, String str) {
        return dVar.a(new k(dVar, bArr, str));
    }
}
