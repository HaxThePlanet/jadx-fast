package d.h.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.e.c.a;
import androidx.core.content.e.c.d;
import androidx.core.content.e.f.c;
import d.e.e;
import d.h.i.f;
import d.h.i.f.b;
import d.h.i.f.c;

/* loaded from: classes.dex */
public class d {

    private static final d.h.f.j a;
    private static final e<String, Typeface> b;

    public static class a extends f.c {

        private f.c a;
        public a(f.c f$c) {
            super();
            this.a = c;
        }

        @Override // d.h.i.f$c
        public void a(int i) {
            final f.c cVar = this.a;
            if (cVar != null) {
                cVar.d(i);
            }
        }

        @Override // d.h.i.f$c
        public void b(Typeface typeface) {
            final f.c cVar = this.a;
            if (cVar != null) {
                cVar.e(typeface);
            }
        }
    }
    static {
        d.h.f.j hVar;
        int i;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 29) {
            hVar = new i();
            d.a = hVar;
        } else {
            if (sDK_INT >= 28) {
                hVar = new h();
                d.a = hVar;
            } else {
                if (sDK_INT >= 26) {
                    hVar = new g();
                    d.a = hVar;
                } else {
                    if (sDK_INT >= 24 && f.m()) {
                        if (f.m()) {
                            hVar = new f();
                            d.a = hVar;
                        } else {
                            if (sDK_INT >= 21) {
                                hVar = new e();
                                d.a = hVar;
                            } else {
                                hVar = new j();
                                d.a = hVar;
                            }
                        }
                    } else {
                    }
                }
            }
        }
        e eVar = new e(16);
        d.b = eVar;
    }

    public static Typeface a(Context context, Typeface typeface2, int i3) {
        Object obj2;
        if (context == null) {
        } else {
            obj2 = d.g(context, typeface2, i3);
            if (Build.VERSION.SDK_INT < 21 && obj2 != null) {
                obj2 = d.g(context, typeface2, i3);
                if (obj2 != null) {
                    return obj2;
                }
            }
            return Typeface.create(typeface2, i3);
        }
        obj2 = new IllegalArgumentException("Context cannot be null");
        throw obj2;
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal2, f.b[] f$b3Arr3, int i4) {
        return d.a.c(context, cancellationSignal2, b3Arr3, i4);
    }

    public static Typeface c(Context context, c.a c$a2, Resources resources3, int i4, int i5, f.c f$c6, Handler handler7, boolean z8) {
        Typeface typeface;
        Object cVar;
        Object handler2;
        int i7;
        int i;
        int i8;
        Resources resources;
        int i6;
        d.h.i.d dVar;
        int i2;
        int i9;
        int i3;
        Handler handler;
        d.h.f.d.a aVar;
        Object obj = a2;
        cVar = c6;
        handler2 = handler7;
        if (obj instanceof c.d) {
            Typeface typeface2 = d.h((c.d)obj.c());
            if (typeface2 != null && cVar != null) {
                if (cVar != null) {
                    cVar.b(typeface2, handler2);
                }
                return typeface2;
            }
            if (z8) {
                if (obj.a() == 0) {
                    i9 = i10;
                } else {
                    i9 = i;
                }
            } else {
                if (cVar == null) {
                } else {
                }
            }
            if (z8) {
                i7 = obj.d();
            } else {
                i7 = -1;
            }
            aVar = new d.a(cVar);
            typeface = f.a(context, obj.b(), i5, i9, i7, f.c.c(handler7), aVar);
            resources = resources3;
            i6 = i5;
        } else {
            i = context;
            resources = resources3;
            typeface = d.a.b(context, (c.b)obj, resources3, i5);
            if (cVar != null) {
                if (typeface != null) {
                    cVar.b(typeface, handler2);
                } else {
                    cVar.a(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            d.b.d(d.e(resources3, i4, i5), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources2, int i3, String string4, int i5) {
        Object obj7;
        int obj8;
        final Typeface obj6 = d.a.e(context, resources2, i3, string4, i5);
        if (obj6 != null) {
            d.b.d(d.e(resources2, i3, i5), obj6);
        }
        return obj6;
    }

    private static String e(Resources resources, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(i2));
        String obj1 = "-";
        stringBuilder.append(obj1);
        stringBuilder.append(i2);
        stringBuilder.append(obj1);
        stringBuilder.append(i3);
        return stringBuilder.toString();
    }

    public static Typeface f(Resources resources, int i2, int i3) {
        return (Typeface)d.b.c(d.e(resources, i2, i3));
    }

    private static Typeface g(Context context, Typeface typeface2, int i3) {
        final d.h.f.j jVar = d.a;
        final androidx.core.content.e.c.b obj3 = jVar.i(typeface2);
        if (obj3 == null) {
            return null;
        }
        return jVar.b(context, obj3, context.getResources(), i3);
    }

    private static Typeface h(String string) {
        int i;
        Typeface create;
        Typeface dEFAULT;
        Object obj3;
        i = 0;
        if (string != null) {
            if (string.isEmpty()) {
            } else {
                int i2 = 0;
                obj3 = Typeface.create(string, i2);
                if (obj3 != null && !obj3.equals(Typeface.create(Typeface.DEFAULT, i2))) {
                    if (!obj3.equals(create)) {
                        i = obj3;
                    }
                }
            }
        }
        return i;
    }
}
