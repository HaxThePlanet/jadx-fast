package net.time4j.android.spi;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.format.DateFormat;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import net.time4j.f1.d;
import net.time4j.g1.e;
import net.time4j.g1.o;
import net.time4j.g1.u;
import net.time4j.g1.y;
import net.time4j.h1.h;
import net.time4j.tz.s;

/* compiled from: AndroidResourceLoader.java */
/* loaded from: classes3.dex */
public class AndroidResourceLoader extends d {

    private static final Map<Class<?>, Iterable<?>> g;
    private static final Set<String> h;
    private Context d = null;
    private net.time4j.e1.b e = null;
    private List<net.time4j.g1.f> f;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[e.values().length];
            AndroidResourceLoader.a.a = iArr;
            try {
                iArr[e.FULL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                AndroidResourceLoader.a.a[e.LONG.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                AndroidResourceLoader.a.a[e.MEDIUM.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static final class c {

        private static final net.time4j.h1.c a = new c();
        private static final Iterable<net.time4j.g1.i> b;
        private static final Iterable<y> c;
        private static final Iterable<u> d;
        static {
            AndroidResourceLoader.c.b = Collections.singleton(f.d);
            AndroidResourceLoader.c.c = Collections.singletonList(new i());
            u[] arr = new u[2];
            AndroidResourceLoader.c.d = Collections.unmodifiableList(Arrays.asList(new u[] { uVar, new b() }));
        }

        static /* synthetic */ net.time4j.h1.c a() {
            return AndroidResourceLoader.c.a;
        }

        static /* synthetic */ Iterable b() {
            return AndroidResourceLoader.c.b;
        }

        static /* synthetic */ Iterable c() {
            return AndroidResourceLoader.c.c;
        }

        static /* synthetic */ Iterable d() {
            return AndroidResourceLoader.c.d;
        }
    }

    private static final class d implements Iterable<net.time4j.engine.r> {
        private d() {
            super();
        }

        @Override // java.lang.Iterable
        public Iterator<net.time4j.engine.r> iterator() {
            return AndroidResourceLoader.l.b.iterator();
        }

        /* synthetic */ d(AndroidResourceLoader.a aVar) {
            this();
        }
    }

    private static final class e implements Iterable<net.time4j.i1.c> {
        private e() {
            super();
        }

        @Override // java.lang.Iterable
        public Iterator<net.time4j.i1.c> iterator() {
            return AndroidResourceLoader.m.c.iterator();
        }

        /* synthetic */ e(AndroidResourceLoader.a aVar) {
            this();
        }
    }

    private static final class f implements Iterable<net.time4j.g1.i> {
        private f() {
            super();
        }

        @Override // java.lang.Iterable
        public Iterator<net.time4j.g1.i> iterator() {
            return AndroidResourceLoader.c.b.iterator();
        }

        /* synthetic */ f(AndroidResourceLoader.a aVar) {
            this();
        }
    }

    private static final class g implements Iterable<o> {
        private g() {
            super();
        }

        @Override // java.lang.Iterable
        public Iterator<o> iterator() {
            return AndroidResourceLoader.l.a.iterator();
        }

        /* synthetic */ g(AndroidResourceLoader.a aVar) {
            this();
        }
    }

    private static final class h implements Iterable<u> {
        private h() {
            super();
        }

        @Override // java.lang.Iterable
        public Iterator<u> iterator() {
            return AndroidResourceLoader.c.d.iterator();
        }

        /* synthetic */ h(AndroidResourceLoader.a aVar) {
            this();
        }
    }

    private static final class i implements Iterable<y> {
        private i() {
            super();
        }

        @Override // java.lang.Iterable
        public Iterator<y> iterator() {
            return AndroidResourceLoader.c.c.iterator();
        }

        /* synthetic */ i(AndroidResourceLoader.a aVar) {
            this();
        }
    }

    private static final class j implements Iterable<s> {
        private j() {
            super();
        }

        @Override // java.lang.Iterable
        public Iterator<s> iterator() {
            return AndroidResourceLoader.m.b.iterator();
        }

        /* synthetic */ j(AndroidResourceLoader.a aVar) {
            this();
        }
    }

    private static final class k implements Iterable<net.time4j.tz.r> {
        private k() {
            super();
        }

        @Override // java.lang.Iterable
        public Iterator<net.time4j.tz.r> iterator() {
            return AndroidResourceLoader.m.a.iterator();
        }

        /* synthetic */ k(AndroidResourceLoader.a aVar) {
            this();
        }
    }

    private static final class l {

        private static final Iterable<o> a;
        private static final Iterable<net.time4j.engine.r> b;
        static {
            AndroidResourceLoader.l.a = Collections.singleton(new a());
            net.time4j.engine.r[] arr = new r[2];
            AndroidResourceLoader.l.b = Arrays.asList(new r[] { new b(), new c() });
        }

        static /* synthetic */ Iterable a() {
            return AndroidResourceLoader.l.a;
        }

        static /* synthetic */ Iterable b() {
            return AndroidResourceLoader.l.b;
        }
    }

    private static final class m {

        private static final Iterable<net.time4j.tz.r> a;
        private static final Iterable<s> b;
        private static final Iterable<net.time4j.i1.c> c;
        static {
            Object cast = null;
            boolean z;
            Set singleton3 = Collections.singleton(new a());
            AndroidResourceLoader.m.a = singleton3;
            AndroidResourceLoader.m.b = Collections.singleton(new b());
            Iterator it = singleton3.iterator();
            while (it.hasNext()) {
                Set singleton2 = it.next();
                z = singleton2 instanceof c;
                if (singleton2 instanceof c) {
                    break;
                }
            }
            int i = 0;
            if (cast == null) {
                AndroidResourceLoader.m.c = Collections.emptyList();
            } else {
                AndroidResourceLoader.m.c = Collections.singleton(cast);
            }
        }

        static /* synthetic */ Iterable a() {
            return AndroidResourceLoader.m.a;
        }

        static /* synthetic */ Iterable b() {
            return AndroidResourceLoader.m.b;
        }

        static /* synthetic */ Iterable c() {
            return AndroidResourceLoader.m.c;
        }
    }

    private class b implements net.time4j.g1.a0.c {

        final /* synthetic */ AndroidResourceLoader a;
        private b() {
            this.a = androidResourceLoader;
            super();
        }

        private net.time4j.g1.a0.c b() {
            return AndroidResourceLoader.c.a;
        }

        private String c(String str) {
            int i = 0;
            char charAt;
            char c = 39;
            char charAt2;
            final StringBuilder stringBuilder = new StringBuilder();
            final int length = str.length();
            i = 0;
            while (i < length) {
                charAt = str.charAt(i);
                c = '\'';
                i = i + 1;
            }
            return stringBuilder.toString();
        }

        public String a(e eVar, Locale locale) {
            return b().a(eVar, locale);
        }

        public String e(e eVar, Locale locale) {
            return g(eVar, locale, false);
        }

        public String g(e eVar, Locale locale, boolean z) {
            String z32;
            int i = 0;
            String str;
            z32 = b().g(eVar, locale, z);
            if (Locale.getDefault().equals(locale) && eVar != e.SHORT) {
                z32 = b().e(e.SHORT, locale);
                i = 1;
                int r0 = z32.indexOf(97) == -1 ? i : 0;
                z = DateFormat.is24HourFormat(AndroidResourceLoader.h(this.a));
                if (z != e.SHORT && z) {
                    return c(z32).replace("  ", " ").trim();
                }
            }
            return z32;
        }

        public String k(e eVar, e eVar2, Locale locale) {
            return b().k(eVar, eVar2, locale);
        }

        /* synthetic */ b(AndroidResourceLoader.a aVar) {
            this(androidResourceLoader);
        }
    }
    static {
        HashMap hashMap = new HashMap();
        final net.time4j.android.spi.AndroidResourceLoader.a aVar2 = null;
        hashMap.put(u.class, new AndroidResourceLoader.h(aVar2));
        hashMap.put(r.class, new AndroidResourceLoader.k(aVar2));
        hashMap.put(s.class, new AndroidResourceLoader.j(aVar2));
        hashMap.put(c.class, new AndroidResourceLoader.e(aVar2));
        hashMap.put(r.class, new AndroidResourceLoader.d(aVar2));
        hashMap.put(i.class, new AndroidResourceLoader.f(aVar2));
        hashMap.put(o.class, new AndroidResourceLoader.g(aVar2));
        hashMap.put(x.class, Collections.singleton(new h()));
        hashMap.put(y.class, new AndroidResourceLoader.i(aVar2));
        hashMap.put(e.class, Collections.singleton(new a()));
        AndroidResourceLoader.g = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add("i18n");
        hashSet.add("calendar");
        hashSet.add("olson");
        hashSet.add("tzdata");
        AndroidResourceLoader.h = Collections.unmodifiableSet(hashSet);
    }

    public AndroidResourceLoader() {
        super();
        this.f = Collections.emptyList();
    }

    static /* synthetic */ Context h(AndroidResourceLoader androidResourceLoader) {
        return androidResourceLoader.d;
    }

    @Override // net.time4j.f1.d
    public InputStream e(URI uri, boolean z) throws java.net.MalformedURLException {
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isAbsolute()) {
                Object instrument = FirebasePerfUrlConnection.instrument(uri.toURL().openConnection());
                instrument.setUseCaches(false);
                return instrument.getInputStream();
            }
            if (this.e != null) {
                return this.e.a(uri.toString());
            }
            if (this.d == null) {
                throw new IllegalStateException("'ApplicationStarter.initialize(context)' must be called first at app start.");
            } else {
                return this.d.getAssets().open(uri.toString());
            }
        } catch (java.io.IOException | RuntimeException unused) {
            return z;
        }
    }

    @Override // net.time4j.f1.d
    public URI f(String str, Class<?> cls, String str2) {
        try {
            if (AndroidResourceLoader.h.contains(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                str2 = "net/time4j/";
                cls = str2 + str + 47 + str2;
                return new URI(cls);
            }
            URL resource = cls.getClassLoader().getResource(str2);
        } catch (java.net.URISyntaxException unused) {
            return null;
        }
        return resource.toURI();
    }

    @Override // net.time4j.f1.d
    public <S> Iterable<S> g(Class<S> cls) {
        Object value;
        if ((Iterable)AndroidResourceLoader.g.get(cls) == null && cls == AndroidResourceLoader.g) {
        }
        AndroidResourceLoader.i(value);
        return value;
    }

    @Override // net.time4j.f1.d
    public void j(Context context, net.time4j.e1.b bVar) {
        Objects.requireNonNull(context, "Missing Android-context.");
        this.d = context;
        this.e = bVar;
        this.f = Collections.singletonList(new AndroidResourceLoader.b(this, null));
    }

    private static <T> T i(Object object) {
        return object;
    }
}
