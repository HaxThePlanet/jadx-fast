package com.airbnb.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.v.g;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.t;
import com.airbnb.lottie.y.d;
import java.io.IOException;
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
import l.q;

/* compiled from: LottieCompositionFactory.java */
/* loaded from: classes.dex */
public class e {

    private static final Map<String, m<d>> a = new HashMap<>();
    private static final byte[] b;

    class c implements Callable<l<d>> {

        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        c(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
            super();
        }

        public l<d> a() {
            com.airbnb.lottie.l lVar = c.d(this.a).c(this.b, this.c);
            if (this.c != null && lVar.b() != null) {
                g.b().c(this.c, (d)lVar.b());
            }
            return lVar;
        }
    }

    class d implements Callable<l<d>> {

        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        d(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
            super();
        }

        public l<d> a() {
            return e.g(this.a, this.b, this.c);
        }
    }

    class e implements Callable<l<d>> {

        final /* synthetic */ WeakReference a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;
        final /* synthetic */ String v;
        e(WeakReference weakReference, Context context, int i, String str) {
            this.a = weakReference;
            this.b = context;
            this.c = i;
            this.v = str;
            super();
        }

        public l<d> a() {
            Context context;
            if ((Context)this.a.get() == null) {
            }
            return e.p(context, this.c, this.v);
        }
    }

    class f implements Callable<l<d>> {

        final /* synthetic */ InputStream a;
        final /* synthetic */ String b;
        f(InputStream inputStream, String str) {
            this.a = inputStream;
            this.b = str;
            super();
        }

        public l<d> a() {
            return e.i(this.a, this.b);
        }
    }

    class g implements Callable<l<d>> {

        final /* synthetic */ d a;
        g(d dVar) {
            this.a = dVar;
            super();
        }

        public l<d> a() {
            return new l(this.a);
        }
    }

    class a implements h<d> {

        final /* synthetic */ String a;
        a(String str) {
            this.a = str;
            super();
        }

        public void b(d dVar) {
            e.a.remove(this.a);
        }
    }

    class b implements h<Throwable> {

        final /* synthetic */ String a;
        b(String str) {
            this.a = str;
            super();
        }

        public void b(Throwable th) {
            e.a.remove(this.a);
        }
    }
    static {
        e.b = new byte[] { 80, 75, 3, 4 };
    }

    static /* synthetic */ Map a() {
        return e.a;
    }

    private static m<d> b(String str, Callable<l<d>> callable) {
        com.airbnb.lottie.d dVar = null;
        if (str == null) {
            int i = 0;
        } else {
            dVar = g.b().a(str);
        }
        if (dVar != null) {
            return new m(new e.g(dVar));
        }
        if (str != null && e.a.containsKey(str)) {
            return (m)e.a.get(str);
        }
        com.airbnb.lottie.m mVar = new m(callable);
        if (str != null) {
            mVar.f(new e.a(str));
            mVar.e(new e.b(str));
            e.a.put(str, mVar);
        }
        return mVar;
    }

    private static g c(d dVar, String str) {
        Iterator it = dVar.i().values().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.b().equals(str)) {
                return item;
            }
        }
        return null;
    }

    public static m<d> d(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        final String str3 = "asset_";
        str = str3 + str;
        return e.e(context, str, str);
    }

    public static m<d> e(Context context, String str, String str2) {
        return e.b(str2, new e.d(context.getApplicationContext(), str, str2));
    }

    public static l<d> f(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        final String str3 = "asset_";
        str = str3 + str;
        return e.g(context, str, str);
    }

    public static l<d> g(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip")) {
                return e.i(context.getAssets().open(str), str2);
            }
        } catch (java.io.IOException ioException) {
            str = new l(ioException);
            return str;
        }
        return e.s(new ZipInputStream(context.getAssets().open(str)), str2);
    }

    public static m<d> h(InputStream inputStream, String str) {
        return e.b(str, new e.f(inputStream, str));
    }

    public static l<d> i(InputStream inputStream, String str) {
        return e.j(inputStream, str, true);
    }

    private static l<d> j(InputStream inputStream, String str, boolean z) {
        try {
        } catch (Throwable th) {
        }
        if (z) {
            h.c(inputStream);
        }
        return e.k(c.r(q.d(q.l(inputStream))), str);
    }

    public static l<d> k(c cVar, String str) {
        return e.l(cVar, str, true);
    }

    private static l<d> l(c cVar, String str, boolean z) {
        try {
            final com.airbnb.lottie.d dVar = t.a(cVar);
            if (str != null) {
                g.b().c(str, dVar);
            }
        } catch (Throwable th) {
        }
        if (z) {
            h.c(cVar);
        }
        return new l(dVar);
    }

    public static m<d> m(Context context, int i) {
        return e.n(context, i, e.w(context, i));
    }

    public static m<d> n(Context context, int i, String str) {
        return e.b(str, new e.e(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    public static l<d> o(Context context, int i) {
        return e.p(context, i, e.w(context, i));
    }

    public static l<d> p(Context context, int i, String str) throws IOException {
        try {
            l.h hVar = q.d(q.l(context.getResources().openRawResource(i)));
            if (e.v(hVar).booleanValue()) {
                return e.s(new ZipInputStream(hVar.g2()), str);
            }
        } catch (android.content.res.Resources.NotFoundException notFound) {
            i = new l(notFound);
            return i;
        }
        return e.i(hVar.g2(), str);
    }

    public static m<d> q(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        final String str3 = "url_";
        str = str3 + str;
        return e.r(context, str, str);
    }

    public static m<d> r(Context context, String str, String str2) {
        return e.b(str2, new e.c(context, str, str2));
    }

    public static l<d> s(ZipInputStream zipInputStream, String str) {
        try {
        } finally {
            h.c(zipInputStream);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str;
        }
        h.c(zipInputStream);
        return e.t(zipInputStream, str);
    }

    private static l<d> t(ZipInputStream zipInputStream, String str) {
        ZipEntry nextEntry;
        com.airbnb.lottie.d dVar;
        String name;
        int i;
        boolean equalsIgnoreCase;
        String str3;
        HashMap hashMap = new HashMap();
        try {
            nextEntry = zipInputStream.getNextEntry();
            str = null;
            int i3 = str;
            name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else {
                str3 = "manifest.json";
                if (nextEntry.getName().equalsIgnoreCase(str3)) {
                    zipInputStream.closeEntry();
                } else {
                    if (nextEntry.getName().contains(".json")) {
                    } else {
                        if (!name.contains(".png")) {
                            if (name.contains(".webp")) {
                                String[] parts = name.split("/");
                                hashMap.put(parts[parts.length - 1], BitmapFactory.decodeStream(zipInputStream));
                            } else {
                                zipInputStream.closeEntry();
                            }
                        }
                    }
                }
            }
            nextEntry = zipInputStream.getNextEntry();
        } catch (java.io.IOException ioException) {
            str = new l(ioException);
            return str;
        }
        if (dVar == null) {
            return new l(new IllegalArgumentException("Unable to parse composition"));
        }
        Iterator it2 = hashMap.entrySet().iterator();
        while (it2.hasNext()) {
            hashMap = it2.next();
            Object obj4 = e.c(dVar, (String)hashMap.getKey());
        }
        Iterator it = dVar.i().entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if ((g)item.getValue().a() == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str10 = "There is no image for ";
                String str4 = (g)item.getValue().b();
                r0 = str10 + str4;
                return new l(new IllegalStateException(r0));
            }
        }
        if (str != null) {
            g.b().c(str, dVar);
        }
        return new l(dVar);
    }

    private static boolean u(Context context) {
        boolean z = true;
        context = (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
        return ((context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0);
    }

    private static Boolean v(l.h hVar) {
        int i = 0;
        try {
            l.h peek = hVar.peek();
            final byte[] bArr = e.b;
            i = 0;
            for (byte b : bArr) {
                if (peek.readByte() != b) {
                    return Boolean.FALSE;
                } else {
                    for (byte b : bArr) {
                        if (peek.readByte() != b) {
                            return Boolean.FALSE;
                        }
                    }
                    peek.close();
                }
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            d.b("Failed to check zip file header", e);
            e = Boolean.FALSE;
            return e;
        }
        return Boolean.TRUE;
    }

    private static String w(Context context, int i) {
        String str;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rawRes");
        context = e.u(context) ? "_night_" : "_day_";
        stringBuilder.append((e.u(context) ? "_night_" : "_day_"));
        stringBuilder.append(i);
        return (e.u(context) ? "_night_" : "_day_");
    }
}
