package com.airbnb.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.v.g;
import com.airbnb.lottie.w.h;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.t;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.h;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import l.d0;
import l.h;
import l.q;

/* loaded from: classes.dex */
public class e {

    private static final Map<String, com.airbnb.lottie.m<com.airbnb.lottie.d>> a;
    private static final byte[] b;

    class c implements Callable<com.airbnb.lottie.l<com.airbnb.lottie.d>> {

        final Context a;
        final String b;
        final String c;
        c(Context context, String string2, String string3) {
            this.a = context;
            this.b = string2;
            this.c = string3;
            super();
        }

        public com.airbnb.lottie.l<com.airbnb.lottie.d> a() {
            Object str2;
            String str;
            Object obj;
            com.airbnb.lottie.l lVar = c.d(this.a).c(this.b, this.c);
            if (this.c != null && lVar.b() != null) {
                if (lVar.b() != null) {
                    g.b().c(this.c, (d)lVar.b());
                }
            }
            return lVar;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d implements Callable<com.airbnb.lottie.l<com.airbnb.lottie.d>> {

        final Context a;
        final String b;
        final String c;
        d(Context context, String string2, String string3) {
            this.a = context;
            this.b = string2;
            this.c = string3;
            super();
        }

        public com.airbnb.lottie.l<com.airbnb.lottie.d> a() {
            return e.g(this.a, this.b, this.c);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e implements Callable<com.airbnb.lottie.l<com.airbnb.lottie.d>> {

        final WeakReference a;
        final Context b;
        final int c;
        final String v;
        e(WeakReference weakReference, Context context2, int i3, String string4) {
            this.a = weakReference;
            this.b = context2;
            this.c = i3;
            this.v = string4;
            super();
        }

        public com.airbnb.lottie.l<com.airbnb.lottie.d> a() {
            Object obj;
            if ((Context)this.a.get() != null) {
            } else {
                obj = this.b;
            }
            return e.p(obj, this.c, this.v);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class f implements Callable<com.airbnb.lottie.l<com.airbnb.lottie.d>> {

        final InputStream a;
        final String b;
        f(InputStream inputStream, String string2) {
            this.a = inputStream;
            this.b = string2;
            super();
        }

        public com.airbnb.lottie.l<com.airbnb.lottie.d> a() {
            return e.i(this.a, this.b);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class g implements Callable<com.airbnb.lottie.l<com.airbnb.lottie.d>> {

        final com.airbnb.lottie.d a;
        g(com.airbnb.lottie.d d) {
            this.a = d;
            super();
        }

        public com.airbnb.lottie.l<com.airbnb.lottie.d> a() {
            l lVar = new l(this.a);
            return lVar;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class a implements com.airbnb.lottie.h<com.airbnb.lottie.d> {

        final String a;
        a(String string) {
            this.a = string;
            super();
        }

        @Override // com.airbnb.lottie.h
        public void a(Object object) {
            b((d)object);
        }

        @Override // com.airbnb.lottie.h
        public void b(com.airbnb.lottie.d d) {
            e.a().remove(this.a);
        }
    }

    class b implements com.airbnb.lottie.h<Throwable> {

        final String a;
        b(String string) {
            this.a = string;
            super();
        }

        @Override // com.airbnb.lottie.h
        public void a(Object object) {
            b((Throwable)object);
        }

        @Override // com.airbnb.lottie.h
        public void b(Throwable throwable) {
            e.a().remove(this.a);
        }
    }
    static {
        HashMap hashMap = new HashMap();
        e.a = hashMap;
        byte[] bArr = new byte[4];
        bArr = new byte[]{80, 75, 3, 4};
        e.b = bArr;
    }

    static Map a() {
        return e.a;
    }

    private static com.airbnb.lottie.m<com.airbnb.lottie.d> b(String string, Callable<com.airbnb.lottie.l<com.airbnb.lottie.d>> callable2) {
        com.airbnb.lottie.d dVar;
        boolean key;
        Object obj3;
        if (string == null) {
            dVar = 0;
        } else {
            dVar = g.b().a(string);
        }
        if (dVar != null) {
            obj3 = new e.g(dVar);
            m obj2 = new m(obj3);
            return obj2;
        }
        dVar = e.a;
        if (string != null && dVar.containsKey(string)) {
            dVar = e.a;
            if (dVar.containsKey(string)) {
                return (m)dVar.get(string);
            }
        }
        m mVar = new m(callable2);
        if (string != null) {
            obj3 = new e.a(string);
            mVar.f(obj3);
            obj3 = new e.b(string);
            mVar.e(obj3);
            e.a.put(string, mVar);
        }
        return mVar;
    }

    private static com.airbnb.lottie.g c(com.airbnb.lottie.d d, String string2) {
        Object next;
        boolean equals;
        Iterator obj2 = d.i().values().iterator();
        for (g next : obj2) {
        }
        return null;
    }

    public static com.airbnb.lottie.m<com.airbnb.lottie.d> d(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_");
        stringBuilder.append(string2);
        return e.e(context, string2, stringBuilder.toString());
    }

    public static com.airbnb.lottie.m<com.airbnb.lottie.d> e(Context context, String string2, String string3) {
        e.d dVar = new e.d(context.getApplicationContext(), string2, string3);
        return e.b(string3, dVar);
    }

    public static com.airbnb.lottie.l<com.airbnb.lottie.d> f(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_");
        stringBuilder.append(string2);
        return e.g(context, string2, stringBuilder.toString());
    }

    public static com.airbnb.lottie.l<com.airbnb.lottie.d> g(Context context, String string2, String string3) {
        boolean endsWith;
        try {
            if (!string2.endsWith(".zip") && string2.endsWith(".lottie")) {
            }
            if (string2.endsWith(".lottie")) {
            }
            return e.i(context.getAssets().open(string2), string3);
            ZipInputStream zipInputStream = new ZipInputStream(context.getAssets().open(string2));
            return e.s(zipInputStream, string3);
            string2 = new l(context);
            return string2;
        }
    }

    public static com.airbnb.lottie.m<com.airbnb.lottie.d> h(InputStream inputStream, String string2) {
        e.f fVar = new e.f(inputStream, string2);
        return e.b(string2, fVar);
    }

    public static com.airbnb.lottie.l<com.airbnb.lottie.d> i(InputStream inputStream, String string2) {
        return e.j(inputStream, string2, true);
    }

    private static com.airbnb.lottie.l<com.airbnb.lottie.d> j(InputStream inputStream, String string2, boolean z3) {
        try {
            if (z3) {
            }
            h.c(inputStream);
            return e.k(c.r(q.d(q.l(inputStream))), string2);
            if (!z3) {
            } else {
            }
            h.c(inputStream);
            throw string2;
        }
    }

    public static com.airbnb.lottie.l<com.airbnb.lottie.d> k(c c, String string2) {
        return e.l(c, string2, true);
    }

    private static com.airbnb.lottie.l<com.airbnb.lottie.d> l(c c, String string2, boolean z3) {
        g gVar;
        try {
            final com.airbnb.lottie.d dVar = t.a(c);
            if (string2 != null) {
            }
            g.b().c(string2, dVar);
            l obj3 = new l(dVar);
            if (z3) {
            }
            h.c(c);
            return obj3;
            l lVar = new l(string2);
            if (z3) {
            }
            h.c(c);
            return lVar;
            if (!z3) {
            } else {
            }
            h.c(c);
            throw string2;
        } catch (Throwable th) {
        }
    }

    public static com.airbnb.lottie.m<com.airbnb.lottie.d> m(Context context, int i2) {
        return e.n(context, i2, e.w(context, i2));
    }

    public static com.airbnb.lottie.m<com.airbnb.lottie.d> n(Context context, int i2, String string3) {
        WeakReference weakReference = new WeakReference(context);
        e.e eVar = new e.e(weakReference, context.getApplicationContext(), i2, string3);
        return e.b(string3, eVar);
    }

    public static com.airbnb.lottie.l<com.airbnb.lottie.d> o(Context context, int i2) {
        return e.p(context, i2, e.w(context, i2));
    }

    public static com.airbnb.lottie.l<com.airbnb.lottie.d> p(Context context, int i2, String string3) {
        try {
            h obj0 = q.d(q.l(context.getResources().openRawResource(i2)));
            if (e.v(obj0).booleanValue()) {
            }
            ZipInputStream obj1 = new ZipInputStream(obj0.g2());
            return e.s(obj1, string3);
            return e.i(obj0.g2(), string3);
            i2 = new l(context);
            return i2;
        }
    }

    public static com.airbnb.lottie.m<com.airbnb.lottie.d> q(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url_");
        stringBuilder.append(string2);
        return e.r(context, string2, stringBuilder.toString());
    }

    public static com.airbnb.lottie.m<com.airbnb.lottie.d> r(Context context, String string2, String string3) {
        e.c cVar = new e.c(context, string2, string3);
        return e.b(string3, cVar);
    }

    public static com.airbnb.lottie.l<com.airbnb.lottie.d> s(ZipInputStream zipInputStream, String string2) {
        try {
            h.c(zipInputStream);
            return e.t(zipInputStream, string2);
            h.c(zipInputStream);
            throw string2;
        }
    }

    private static com.airbnb.lottie.l<com.airbnb.lottie.d> t(ZipInputStream zipInputStream, String string2) {
        HashMap hashMap;
        boolean next;
        ZipEntry nextEntry;
        int i2;
        int i;
        String decodeStream;
        boolean equalsIgnoreCase;
        String str;
        Object obj7;
        hashMap = new HashMap();
        nextEntry = zipInputStream.getNextEntry();
        i2 = 0;
        i = i2;
        while (nextEntry != null) {
            decodeStream = nextEntry.getName();
            if (decodeStream.contains("__MACOSX")) {
            } else {
            }
            if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
            } else {
            }
            if (nextEntry.getName().contains(".json")) {
            } else {
            }
            if (!decodeStream.contains(".png")) {
            } else {
            }
            String[] split = decodeStream.split("/");
            hashMap.put(split[length--], BitmapFactory.decodeStream(zipInputStream));
            nextEntry = zipInputStream.getNextEntry();
            if (decodeStream.contains(".webp")) {
            } else {
            }
            zipInputStream.closeEntry();
            i = nextEntry;
            zipInputStream.closeEntry();
            zipInputStream.closeEntry();
        }
        if (i == 0) {
            IllegalArgumentException obj8 = new IllegalArgumentException("Unable to parse composition");
            obj7 = new l(obj8);
            return obj7;
        }
        obj7 = hashMap.entrySet().iterator();
        while (obj7.hasNext()) {
            hashMap = obj7.next();
            nextEntry = e.c(i, (String)(Map.Entry)hashMap.getKey());
            if (nextEntry != null) {
            }
            nextEntry.f(h.l((Bitmap)hashMap.getValue(), nextEntry.e(), nextEntry.c()));
        }
        obj7 = i.i().entrySet().iterator();
        for (Map.Entry next : obj7) {
        }
        if (string2 != null) {
            g.b().c(string2, i);
        }
        obj7 = new l(i);
        return obj7;
    }

    private static boolean u(Context context) {
        int obj1;
        obj1 = obj1 &= 48 == 32 ? 1 : 0;
        return obj1;
    }

    private static Boolean v(h h) {
        int i;
        byte b;
        byte byte;
        try {
            h obj5 = h.peek();
            final byte[] bArr = e.b;
            i = 0;
            while (i < bArr.length) {
                i++;
            }
            if (obj5.readByte() != bArr[i]) {
            } else {
            }
            return Boolean.FALSE;
            i++;
            obj5.close();
            return Boolean.TRUE;
            d.b("Failed to check zip file header", h);
            h = Boolean.FALSE;
            return h;
        }
    }

    private static String w(Context context, int i2) {
        String obj2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rawRes");
        obj2 = e.u(context) ? "_night_" : "_day_";
        stringBuilder.append(obj2);
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }
}
