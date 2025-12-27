package d.h.i;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import d.h.k.i;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class f {

    public static class a {

        private final int a;
        private final f.b[] b;
        @Deprecated
        public a(int i, f.b[] bVarArr) {
            super();
            this.a = i;
            this.b = bVarArr;
        }

        static f.a a(int i, f.b[] bVarArr) {
            return new f.a(i, bVarArr);
        }

        public f.b[] b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }
    }

    public static class b {

        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;
        @Deprecated
        public b(Uri uri, int i, int i2, boolean z, int i3) {
            super();
            i.c(uri);
            this.a = uri;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        static f.b a(Uri uri, int i, int i2, boolean z, int i3) {
            f.b bVar = new f.b(uri, i, i2, z, i3);
            return bVar;
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    public static class c {
        public void a(int i) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }

        public void b(Typeface typeface) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }
    public static Typeface a(Context context, d dVar, int i, boolean z, int i2, Handler handler, f.c cVar) {
        final d.h.i.a aVar = new a(cVar, handler);
        if (z) {
            return e.e(context, dVar, aVar, i, i2);
        }
        return e.d(context, dVar, i, null, aVar);
    }
}
