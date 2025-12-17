package d.h.i;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import d.h.k.i;

/* loaded from: classes.dex */
public class f {

    public static class a {

        private final int a;
        private final d.h.i.f.b[] b;
        @Deprecated
        public a(int i, d.h.i.f.b[] f$b2Arr2) {
            super();
            this.a = i;
            this.b = b2Arr2;
        }

        static d.h.i.f.a a(int i, d.h.i.f.b[] f$b2Arr2) {
            f.a aVar = new f.a(i, b2Arr2);
            return aVar;
        }

        public d.h.i.f.b[] b() {
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
        public b(Uri uri, int i2, int i3, boolean z4, int i5) {
            super();
            i.c(uri);
            this.a = (Uri)uri;
            this.b = i2;
            this.c = i3;
            this.d = z4;
            this.e = i5;
        }

        static d.h.i.f.b a(Uri uri, int i2, int i3, boolean z4, int i5) {
            super(uri, i2, i3, z4, i5);
            return bVar2;
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
            throw 0;
        }

        public void b(Typeface typeface) {
            throw 0;
        }
    }
    public static Typeface a(Context context, d.h.i.d d2, int i3, boolean z4, int i5, Handler handler6, d.h.i.f.c f$c7) {
        a aVar = new a(c7, handler6);
        if (z4) {
            return e.e(context, d2, aVar, i3, i5);
        }
        return e.d(context, d2, i3, 0, aVar);
    }
}
