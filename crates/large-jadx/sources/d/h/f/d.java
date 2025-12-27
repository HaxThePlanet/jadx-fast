package d.h.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.e.c.a;
import androidx.core.content.e.c.d;
import d.e.e;
import d.h.i.f;
import d.h.i.f.b;

/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class d {

    private static final j a = new j();
    private static final e<String, Typeface> b = new e<>(16);

    public static class a extends d.h.i.f.c {

        private androidx.core.content.e.f.c a;
        public a(androidx.core.content.e.f.c cVar) {
            super();
            this.a = cVar;
        }

        @Override // d.h.i.f$c
        public void a(int i) {
            if (this.a != null) {
                this.a.d(i);
            }
        }

        @Override // d.h.i.f$c
        public void b(Typeface typeface) {
            if (this.a != null) {
                this.a.e(typeface);
            }
        }
    }
    static {
        int sDK_INT2 = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 29) {
            d.a = new i();
        } else {
            if (Build.VERSION.SDK_INT >= 28) {
                d.a = new h();
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    d.a = new g();
                } else {
                    int i = 24;
                    if (Build.VERSION.SDK_INT < 24 || !f.m()) {
                        d.a = new e();
                    } else {
                        d.a = new f();
                    }
                }
            }
        }
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else {
            if (Build.VERSION.SDK_INT < 21 && typeface != null) {
                return typeface;
            }
            return Typeface.create(typeface, i);
        }
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        return d.a.c(context, cancellationSignal, bVarArr, i);
    }

    public static Typeface c(Context context, c.a aVar, Resources resources, int i, int i2, androidx.core.content.e.f.c cVar, Handler handler, boolean z) {
        Typeface typeface;
        int i3;
        Object aVar22 = aVar;
        cVar62 = cVar;
        handler72 = handler;
        if (aVar22 instanceof c.d) {
            Typeface typeface2 = d.h(aVar22.c());
            if (typeface2 != null && cVar62 != null) {
                cVar62.b(typeface2, handler72);
                return typeface2;
            }
            i2 = 0;
            if (!z) {
                int r9 = cVar62 == null ? 1 : 0;
            } else {
                if (aVar22.a() == 0) {
                    int i7 = 1;
                } else {
                }
            }
            if (z) {
                i = aVar22.d();
            } else {
                i = -1;
            }
            typeface = f.a(context, aVar22.b(), i2, z, i, f.c.c(handler), new d.a(cVar62));
            resources32 = resources;
            i52 = i2;
        } else {
            Context context2 = context;
            resources32 = resources;
            typeface = d.a.b(context, aVar22, resources, i2);
            if (cVar62 != null) {
                if (typeface != null) {
                    cVar62.b(typeface, handler72);
                } else {
                    i = -3;
                    cVar62.a(i, handler72);
                }
            }
        }
        if (typeface != null) {
            d.b.d(d.e(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int i, String str, int i2) {
        final Typeface typeface = d.a.e(context, resources, i, str, i2);
        if (typeface != null) {
            d.b.d(d.e(resources, i, i2), typeface);
        }
        return typeface;
    }

    private static String e(Resources resources, int i, int i2) throws android.content.res.Resources.NotFoundException {
        final StringBuilder stringBuilder = new StringBuilder();
        String resourcePackageName = resources.getResourcePackageName(i);
        String str = "-";
        str2 = resourcePackageName + str + i + str + i2;
        return str2;
    }

    public static Typeface f(Resources resources, int i, int i2) {
        return (Typeface)d.b.c(d.e(resources, i, i2));
    }

    private static Typeface g(Context context, Typeface typeface, int i) {
        final d.h.f.j jVar = d.a;
        final androidx.core.content.e.c.b bVar = jVar.i(typeface);
        if (bVar == null) {
            return null;
        }
        return d.a.b(context, bVar, context.getResources(), i);
    }

    private static Typeface h(String str) {
        int i = 0;
        i = 0;
        return i;
    }
}
