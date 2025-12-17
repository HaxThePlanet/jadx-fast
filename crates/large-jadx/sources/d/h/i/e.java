package d.h.i;

import android.content.Context;
import android.graphics.Typeface;
import d.e.e;
import d.e.g;
import d.h.f.d;
import d.h.k.a;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
class e {

    static final e<String, Typeface> a;
    private static final ExecutorService b;
    static final Object c;
    static final g<String, ArrayList<a<d.h.i.e.e>>> d;

    class a implements Callable<d.h.i.e.e> {

        final String a;
        final Context b;
        final d.h.i.d c;
        final int v;
        a(String string, Context context2, d.h.i.d d3, int i4) {
            this.a = string;
            this.b = context2;
            this.c = d3;
            this.v = i4;
            super();
        }

        @Override // java.util.concurrent.Callable
        public d.h.i.e.e a() {
            return e.c(this.a, this.b, this.c, this.v);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class c implements Callable<d.h.i.e.e> {

        final String a;
        final Context b;
        final d.h.i.d c;
        final int v;
        c(String string, Context context2, d.h.i.d d3, int i4) {
            this.a = string;
            this.b = context2;
            this.c = d3;
            this.v = i4;
            super();
        }

        @Override // java.util.concurrent.Callable
        public d.h.i.e.e a() {
            return e.c(this.a, this.b, this.c, this.v);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class e {

        final Typeface a;
        final int b;
        e(int i) {
            super();
            this.a = 0;
            this.b = i;
        }

        e(Typeface typeface) {
            super();
            this.a = typeface;
            this.b = 0;
        }

        boolean a() {
            int i;
            i = this.b == 0 ? 1 : 0;
            return i;
        }
    }

    class b implements a<d.h.i.e.e> {

        final d.h.i.a a;
        b(d.h.i.a a) {
            this.a = a;
            super();
        }

        @Override // d.h.k.a
        public void a(d.h.i.e.e e$e) {
            this.a.b(e);
        }

        @Override // d.h.k.a
        public void accept(Object object) {
            a((e.e)object);
        }
    }

    class d implements a<d.h.i.e.e> {

        final String a;
        d(String string) {
            this.a = string;
            super();
        }

        @Override // d.h.k.a
        public void a(d.h.i.e.e e$e) {
            int i;
            g gVar;
            Object obj = e.c;
            gVar = e.d;
            Object obj2 = gVar.get(this.a);
            synchronized (obj) {
            }
            try {
                while (i < (ArrayList)obj2.size()) {
                    (a)obj2.get(i).accept(e);
                    i++;
                }
                (a)obj2.get(i).accept(e);
                i++;
                throw e;
            }
        }

        @Override // d.h.k.a
        public void accept(Object object) {
            a((e.e)object);
        }
    }
    static {
        e eVar = new e(16);
        e.a = eVar;
        e.b = g.a("fonts-androidx", 10, 10000);
        Object object = new Object();
        e.c = object;
        g gVar = new g();
        e.d = gVar;
    }

    private static String a(d.h.i.d d, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d.d());
        stringBuilder.append("-");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    private static int b(d.h.i.f.a f$a) {
        int length;
        int i4;
        int i2;
        int i3;
        int i;
        if (a.c() != 0 && a.c() != 1) {
            if (a.c() != 1) {
                return -3;
            }
            return -2;
        }
        d.h.i.f.b[] obj5 = a.b();
        if (obj5 != null) {
            if (obj5.length == 0) {
            } else {
                i3 = i2;
                while (i3 < obj5.length) {
                    i = obj5[i3].b();
                    i3++;
                }
            }
        }
        return i2;
    }

    static d.h.i.e.e c(String string, Context context2, d.h.i.d d3, int i4) {
        final e eVar = e.a;
        Object obj = eVar.c(string);
        if ((Typeface)obj != null) {
            e.e obj3 = new e.e((Typeface)obj);
            return obj3;
        }
        int i = 0;
        d.h.i.f.a obj5 = c.d(context2, d3, i);
        final int i2 = e.b(obj5);
        if (i2 != 0) {
            obj3 = new e.e(i2);
            return obj3;
        }
        Typeface obj4 = d.b(context2, i, obj5.b(), i4);
        if (obj4 != null) {
            eVar.d(string, obj4);
            obj3 = new e.e(obj4);
            return obj3;
        }
        obj3 = new e.e(-3);
        return obj3;
    }

    static Typeface d(Context context, d.h.i.d d2, int i3, Executor executor4, d.h.i.a a5) {
        ExecutorService obj8;
        final String str = e.a(d2, i3);
        Object obj = e.a.c(str);
        if ((Typeface)obj != null) {
            e.e obj5 = new e.e((Typeface)obj);
            a5.b(obj5);
            return obj;
        }
        e.b bVar = new e.b(a5);
        Object obj9 = e.c;
        final g gVar = e.d;
        Object obj2 = gVar.get(str);
        final int i = 0;
        synchronized (obj9) {
            (ArrayList)obj2.add(bVar);
            return i;
        }
        obj8 = e.b;
        obj5 = new e.d(str);
        g.b(obj8, obj9, obj5);
        return i;
    }

    static Typeface e(Context context, d.h.i.d d2, d.h.i.a a3, int i4, int i5) {
        final String str = e.a(d2, i4);
        Object obj = e.a.c(str);
        if ((Typeface)obj != null) {
            e.e obj2 = new e.e((Typeface)obj);
            a3.b(obj2);
            return obj;
        }
        if (i5 == -1) {
            obj2 = e.c(str, context, d2, i4);
            a3.b(obj2);
            return obj2.a;
        }
        e.a aVar = new e.a(str, context, d2, i4);
        obj2 = g.c(e.b, aVar, i5);
        a3.b((e.e)obj2);
        return obj2.a;
    }
}
