package net.time4j.android.spi;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.format.DateFormat;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.net.URI;
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
import net.time4j.calendar.t.b;
import net.time4j.calendar.t.c;
import net.time4j.e1.b;
import net.time4j.engine.r;
import net.time4j.f1.d;
import net.time4j.g1.a0.c;
import net.time4j.g1.e;
import net.time4j.g1.f;
import net.time4j.g1.i;
import net.time4j.g1.o;
import net.time4j.g1.u;
import net.time4j.g1.y;
import net.time4j.h1.a;
import net.time4j.h1.b;
import net.time4j.h1.c;
import net.time4j.h1.f;
import net.time4j.h1.h;
import net.time4j.h1.i;
import net.time4j.i1.c;
import net.time4j.tz.r;
import net.time4j.tz.s;
import net.time4j.tz.t.a;
import net.time4j.tz.t.b;

/* loaded from: classes3.dex */
public class AndroidResourceLoader extends d {

    private static final Map<Class<?>, Iterable<?>> g;
    private static final Set<String> h;
    private Context d = null;
    private b e = null;
    private List<f> f;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            AndroidResourceLoader.a.a = iArr;
            iArr[e.FULL.ordinal()] = 1;
            AndroidResourceLoader.a.a[e.LONG.ordinal()] = 2;
            AndroidResourceLoader.a.a[e.MEDIUM.ordinal()] = 3;
        }
    }

    private static final class c {

        private static final c a;
        private static final Iterable<i> b;
        private static final Iterable<y> c;
        private static final Iterable<u> d;
        static {
            c cVar = new c();
            AndroidResourceLoader.c.a = cVar;
            AndroidResourceLoader.c.b = Collections.singleton(f.d);
            i iVar = new i();
            AndroidResourceLoader.c.c = Collections.singletonList(iVar);
            u[] arr = new u[2];
            b bVar = new b();
            AndroidResourceLoader.c.d = Collections.unmodifiableList(Arrays.asList(cVar, bVar));
        }

        static c a() {
            return AndroidResourceLoader.c.a;
        }

        static Iterable b() {
            return AndroidResourceLoader.c.b;
        }

        static Iterable c() {
            return AndroidResourceLoader.c.c;
        }

        static Iterable d() {
            return AndroidResourceLoader.c.d;
        }
    }

    private static final class d implements Iterable<r> {
        d(net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a) {
            super();
        }

        public Iterator<r> iterator() {
            return AndroidResourceLoader.l.b().iterator();
        }
    }

    private static final class e implements Iterable<c> {
        e(net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a) {
            super();
        }

        public Iterator<c> iterator() {
            return AndroidResourceLoader.m.c().iterator();
        }
    }

    private static final class f implements Iterable<i> {
        f(net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a) {
            super();
        }

        public Iterator<i> iterator() {
            return AndroidResourceLoader.c.b().iterator();
        }
    }

    private static final class g implements Iterable<o> {
        g(net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a) {
            super();
        }

        public Iterator<o> iterator() {
            return AndroidResourceLoader.l.a().iterator();
        }
    }

    private static final class h implements Iterable<u> {
        h(net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a) {
            super();
        }

        public Iterator<u> iterator() {
            return AndroidResourceLoader.c.d().iterator();
        }
    }

    private static final class i implements Iterable<y> {
        i(net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a) {
            super();
        }

        public Iterator<y> iterator() {
            return AndroidResourceLoader.c.c().iterator();
        }
    }

    private static final class j implements Iterable<s> {
        j(net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a) {
            super();
        }

        public Iterator<s> iterator() {
            return AndroidResourceLoader.m.b().iterator();
        }
    }

    private static final class k implements Iterable<r> {
        k(net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a) {
            super();
        }

        public Iterator<r> iterator() {
            return AndroidResourceLoader.m.a().iterator();
        }
    }

    private static final class l {

        private static final Iterable<o> a;
        private static final Iterable<r> b;
        static {
            a aVar = new a();
            AndroidResourceLoader.l.a = Collections.singleton(aVar);
            r[] arr = new r[2];
            b bVar = new b();
            c cVar = new c();
            AndroidResourceLoader.l.b = Arrays.asList(bVar, cVar);
        }

        static Iterable a() {
            return AndroidResourceLoader.l.a;
        }

        static Iterable b() {
            return AndroidResourceLoader.l.b;
        }
    }

    private static final class m {

        private static final Iterable<r> a;
        private static final Iterable<s> b;
        private static final Iterable<c> c;
        static {
            Object cast;
            Object emptyList;
            Set singleton;
            boolean z;
            a aVar = new a();
            Set singleton2 = Collections.singleton(aVar);
            AndroidResourceLoader.m.a = singleton2;
            b bVar = new b();
            AndroidResourceLoader.m.b = Collections.singleton(bVar);
            Iterator iterator = singleton2.iterator();
            for (r singleton : iterator) {
            }
            cast = 0;
            if (cast == null) {
                AndroidResourceLoader.m.c = Collections.emptyList();
            } else {
                AndroidResourceLoader.m.c = Collections.singleton(cast);
            }
        }

        static Iterable a() {
            return AndroidResourceLoader.m.a;
        }

        static Iterable b() {
            return AndroidResourceLoader.m.b;
        }

        static Iterable c() {
            return AndroidResourceLoader.m.c;
        }
    }

    private class b implements c {

        final net.time4j.android.spi.AndroidResourceLoader a;
        private b(net.time4j.android.spi.AndroidResourceLoader androidResourceLoader) {
            this.a = androidResourceLoader;
            super();
        }

        b(net.time4j.android.spi.AndroidResourceLoader androidResourceLoader, net.time4j.android.spi.AndroidResourceLoader.a androidResourceLoader$a2) {
            super(androidResourceLoader);
        }

        private c b() {
            return AndroidResourceLoader.c.a();
        }

        private String c(String string) {
            int i;
            char charAt2;
            int i2;
            int i3;
            char charAt;
            StringBuilder stringBuilder = new StringBuilder();
            final int length = string.length();
            i = 0;
            while (i < length) {
                charAt2 = string.charAt(i);
                i2 = 39;
                if (charAt2 == i2) {
                } else {
                }
                if (charAt2 == 104) {
                } else {
                }
                if (charAt2 != 97) {
                }
                i++;
                stringBuilder.append(charAt2);
                stringBuilder.append('H');
                stringBuilder.append(charAt2);
                i++;
                while (i < length) {
                    charAt2 = string.charAt(i);
                    if (charAt2 == i2) {
                    } else {
                    }
                    stringBuilder.append(charAt2);
                    i++;
                    stringBuilder.append(charAt2);
                    i3 = i + 1;
                    if (i3 < length) {
                    }
                    if (string.charAt(i3) == i2) {
                    }
                    i = i3;
                }
                charAt2 = string.charAt(i);
                if (charAt2 == i2) {
                } else {
                }
                stringBuilder.append(charAt2);
                stringBuilder.append(charAt2);
                i3 = i + 1;
                if (i3 < length) {
                }
                if (string.charAt(i3) == i2) {
                }
                i = i3;
            }
            return stringBuilder.toString();
        }

        @Override // net.time4j.g1.a0.c
        public String a(e e, Locale locale2) {
            return b().a(e, locale2);
        }

        @Override // net.time4j.g1.a0.c
        public String e(e e, Locale locale2) {
            return g(e, locale2, false);
        }

        @Override // net.time4j.g1.a0.c
        public String g(e e, Locale locale2, boolean z3) {
            boolean equals;
            String str;
            boolean z;
            int i;
            String obj5;
            String obj6 = b().g(e, locale2, z3);
            if (Locale.getDefault().equals(locale2)) {
                e sHORT = e.SHORT;
                if (e != sHORT) {
                    str = b().e(sHORT, locale2);
                } else {
                    str = obj6;
                }
                i = 1;
                equals = str.indexOf(97) == -1 ? i : 0;
                z = DateFormat.is24HourFormat(AndroidResourceLoader.h(this.a));
                if (z != equals && z) {
                    if (z) {
                        return c(obj6).replace("  ", " ").trim();
                    }
                    obj5 = locale2.getLanguage().equals("en") ? "b" : "B";
                    int obj4 = AndroidResourceLoader.a.a[e.ordinal()];
                    obj6 = "h:mm:ss ";
                    if (obj4 != i && obj4 != 2 && obj4 != 3) {
                        if (obj4 != 2) {
                            if (obj4 != 3) {
                                obj4 = new StringBuilder();
                                obj4.append("h:mm ");
                                obj4.append(obj5);
                                return obj4.toString();
                            }
                            obj4 = new StringBuilder();
                            obj4.append(obj6);
                            obj4.append(obj5);
                            return obj4.toString();
                        }
                        obj4 = new StringBuilder();
                        obj4.append(obj6);
                        obj4.append(obj5);
                        obj4.append(" z");
                        return obj4.toString();
                    }
                    obj4 = new StringBuilder();
                    obj4.append(obj6);
                    obj4.append(obj5);
                    obj4.append(" zzzz");
                    return obj4.toString();
                }
            }
            return obj6;
        }

        @Override // net.time4j.g1.a0.c
        public String k(e e, e e2, Locale locale3) {
            return b().k(e, e2, locale3);
        }
    }
    static {
        HashMap hashMap = new HashMap();
        final int i = 0;
        AndroidResourceLoader.h hVar = new AndroidResourceLoader.h(i);
        hashMap.put(u.class, hVar);
        AndroidResourceLoader.k kVar = new AndroidResourceLoader.k(i);
        hashMap.put(r.class, kVar);
        AndroidResourceLoader.j jVar = new AndroidResourceLoader.j(i);
        hashMap.put(s.class, jVar);
        AndroidResourceLoader.e eVar = new AndroidResourceLoader.e(i);
        hashMap.put(c.class, eVar);
        AndroidResourceLoader.d dVar = new AndroidResourceLoader.d(i);
        hashMap.put(r.class, dVar);
        AndroidResourceLoader.f fVar = new AndroidResourceLoader.f(i);
        hashMap.put(i.class, fVar);
        AndroidResourceLoader.g gVar = new AndroidResourceLoader.g(i);
        hashMap.put(o.class, gVar);
        h hVar2 = new h();
        hashMap.put(x.class, Collections.singleton(hVar2));
        AndroidResourceLoader.i iVar = new AndroidResourceLoader.i(i);
        hashMap.put(y.class, iVar);
        a aVar = new a();
        hashMap.put(e.class, Collections.singleton(aVar));
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
        int i = 0;
        this.f = Collections.emptyList();
    }

    static Context h(net.time4j.android.spi.AndroidResourceLoader androidResourceLoader) {
        return androidResourceLoader.d;
    }

    private static <T> T i(Object object) {
        return object;
    }

    @Override // net.time4j.f1.d
    public InputStream e(URI uRI, boolean z2) {
        if (uRI == null) {
            return null;
        }
        if (uRI.isAbsolute()) {
            Object obj2 = FirebasePerfUrlConnection.instrument(uRI.toURL().openConnection());
            (URLConnection)obj2.setUseCaches(false);
            return obj2.getInputStream();
        }
        try {
            b bVar = this.e;
            if (bVar != null) {
            }
            return bVar.a(uRI.toString());
            Context context = this.d;
            if (context == null) {
            } else {
            }
            return context.getAssets().open(uRI.toString());
            obj2 = new IllegalStateException("'ApplicationStarter.initialize(context)' must be called first at app start.");
            throw obj2;
            return z2;
        }
    }

    public URI f(String string, Class<?> class2, String string3) {
        try {
            if (AndroidResourceLoader.h.contains(string)) {
            }
            StringBuilder obj3 = new StringBuilder();
            obj3.append("net/time4j/");
            obj3.append(string);
            obj3.append('/');
            obj3.append(string3);
            URI obj2 = new URI(obj3.toString());
            return obj2;
            obj2 = class2.getClassLoader().getResource(string3);
            if (obj2 != null) {
            }
            return obj2.toURI();
            return null;
        }
    }

    public <S> Iterable<S> g(Class<S> class) {
        Object obj;
        if ((Iterable)AndroidResourceLoader.g.get(class) == null && class == f.class) {
            if (class == f.class) {
                obj = this.f;
            }
            return ServiceLoader.load(class, class.getClassLoader());
        }
        AndroidResourceLoader.i(obj);
        return (Iterable)obj;
    }

    @Override // net.time4j.f1.d
    public void j(Context context, b b2) {
        Objects.requireNonNull(context, "Missing Android-context.");
        this.d = context;
        this.e = b2;
        AndroidResourceLoader.b obj2 = new AndroidResourceLoader.b(this, 0);
        this.f = Collections.singletonList(obj2);
    }
}
