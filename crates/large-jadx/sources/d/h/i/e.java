package d.h.i;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import d.e.e;
import d.e.g;
import d.h.f.d;
import d.h.k.a;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
class e {

    static final e<String, Typeface> a = new e<>(16);
    private static final ExecutorService b;
    static final Object c = new Object();
    static final g<String, ArrayList<a<e.e>>> d = new g<>();

    class a implements Callable<e.e> {

        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ d c;
        final /* synthetic */ int v;
        a(String str, Context context, d dVar, int i) {
            this.a = str;
            this.b = context;
            this.c = dVar;
            this.v = i;
            super();
        }

        public e.e a() {
            return e.c(this.a, this.b, this.c, this.v);
        }
    }

    class c implements Callable<e.e> {

        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ d c;
        final /* synthetic */ int v;
        c(String str, Context context, d dVar, int i) {
            this.a = str;
            this.b = context;
            this.c = dVar;
            this.v = i;
            super();
        }

        public e.e a() {
            return e.c(this.a, this.b, this.c, this.v);
        }
    }

    static final class e {

        final Typeface a;
        final int b;
        e(int i) {
            super();
            this.a = null;
            this.b = i;
        }

        boolean a() {
            boolean z = true;
            int r0 = this.b == 0 ? 1 : 0;
            return (this.b == 0 ? 1 : 0);
        }

        e(Typeface typeface) {
            super();
            this.a = typeface;
            this.b = 0;
        }
    }

    class b implements a<e.e> {

        final /* synthetic */ a a;
        b(a aVar) {
            this.a = aVar;
            super();
        }

        public void a(e.e eVar) {
            this.a.b(eVar);
        }
    }

    class d implements a<e.e> {

        final /* synthetic */ String a;
        d(String str) {
            this.a = str;
            super();
        }

        public void a(e.e eVar) {
            int i = 0;
            Object obj2 = e.c;
            synchronized (obj2) {
                try {
                    item = e.d;
                    Object obj3 = item.get(this.a);
                    if (obj3 == null) {
                        return;
                    }
                    e.d.remove(this.a);
                } catch (Throwable th) {
                }
            }
            i = 0;
            while (i < obj3.size()) {
                (a)obj3.get(i).accept(th);
                i = i + 1;
            }
        }
    }
    static {
        e.b = g.a("fonts-androidx", 10, 10000);
    }

    private static String a(d dVar, int i) {
        final StringBuilder stringBuilder = new StringBuilder();
        String str = dVar.d();
        String str2 = "-";
        str3 = str + str2 + i;
        return str3;
    }

    private static int b(f.a aVar) {
        int i = -3;
        int i2 = 1;
        i = -3;
        i2 = 1;
        if (aVar.c() != 0) {
            if (aVar.c() != 1) {
                return -3;
            }
            return -2;
        }
        d.h.i.f.b[] objArr = aVar.b();
        if (objArr != null) {
            length = objArr.length;
            if (objArr.length != 0) {
                length = objArr.length;
                i2 = 0;
                for (d.h.i.f.b bVar : objArr) {
                    i = bVar.b();
                    if (i != 0) {
                    }
                }
            }
        }
        return i2;
    }

    static e.e c(String str, Context context, d dVar, int i) {
        final e eVar = e.a;
        Object obj = eVar.c(str);
        if (obj != null) {
            return new e.e(obj);
        }
        android.os.CancellationSignal cancellationSignal = null;
        try {
            d.h.i.f.a aVar = c.d(context, dVar, cancellationSignal);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            context = -1;
            str = new e.e(context);
            return str;
        }
        i = e.b(aVar);
        if (i != 0) {
            return new e.e(i);
        }
        Typeface typeface = d.b(context, cancellationSignal, aVar.b(), i);
        if (typeface != null) {
            e.a.d(str, typeface);
            return new e.e(typeface);
        }
        return new e.e(-3);
    }

    static Typeface d(Context context, d dVar, int i, Executor executor, a aVar) {
        Object obj3;
        final String str = e.a(dVar, i);
        Object obj = e.a.c(str);
        if (obj != null) {
            aVar.b(new e.e(obj));
            return obj;
        }
        d.h.i.e.b bVar = new e.b(aVar);
        Object obj4 = e.c;
        synchronized (obj4) {
            try {
                final g gVar = e.d;
                Object obj2 = gVar.get(str);
                i = 0;
                if (obj2 != null) {
                    obj2.add(bVar);
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar);
                e.d.put(str, arrayList);
            } catch (Throwable th) {
            }
        }
        if (executor == null) {
            ExecutorService executorService = e.b;
        }
        g.b(obj3, new e.c(str, th, dVar, i), new e.d(str));
        return i;
    }

    static Typeface e(Context context, d dVar, a aVar, int i, int i2) {
        final String str = e.a(dVar, i);
        Object obj = e.a.c(str);
        if (obj != null) {
            aVar.b(new e.e(obj));
            return obj;
        }
        if (i2 == -1) {
            d.h.i.e.e eVar3 = e.c(str, context, dVar, i);
            aVar.b(eVar3);
            return eVar3.a;
        }
        try {
            Object obj2 = g.c(e.b, new e.a(str, context, dVar, i), i2);
            aVar.b(obj2);
        } catch (java.lang.InterruptedException unused) {
            dVar = -3;
            context = new e.e(dVar);
            aVar.b(context);
            context = null;
            return context;
        }
        return obj2.a;
    }
}
