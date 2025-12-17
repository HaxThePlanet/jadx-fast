package kotlinx.coroutines.internal;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.b;
import kotlin.d0.d.n;
import kotlin.io.b;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00082\u0006\u0010\t\u001a\u00020\u0004H\u0082\u0008J1\u0010\n\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0008H\u0002¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u00082\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\u0008\u0014J/\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u00082\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0008\u0016J\u0016\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\u0008\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\u0082\u0008¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j {

    public static final kotlinx.coroutines.internal.j a;
    static {
        j jVar = new j();
        j.a = jVar;
    }

    private final <S> S a(String string, java.lang.ClassLoader classLoader2, Class<S> class3) {
        int i = 0;
        Class obj2 = Class.forName(string, i, classLoader2);
        if (!class3.isAssignableFrom(obj2)) {
        } else {
            return class3.cast(obj2.getDeclaredConstructor(new Class[i]).newInstance(new Object[i]));
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("Expected service of class ");
        obj3.append(class3);
        obj3.append(", but found ");
        obj3.append(obj2);
        obj3 = new IllegalArgumentException(obj3.toString().toString());
        throw obj3;
    }

    private final <S> List<S> b(Class<S> class, java.lang.ClassLoader classLoader2) {
        List obj1;
        try {
            obj1 = d(class, classLoader2);
            class = ServiceLoader.load(class, classLoader2);
            class = p.L0(class);
            return obj1;
        }
    }

    private final List<String> e(URL uRL) {
        String string = uRL.toString();
        int i2 = 0;
        int i3 = 2;
        final int i4 = 0;
        if (l.M(string, "jar", i2, i3, i4)) {
            JarFile jarFile = new JarFile(l.W0(l.P0(string, "jar:file:", i4, i3, i4), '!', i4, i3, i4), i2);
            ZipEntry zipEntry = new ZipEntry(l.P0(string, "!/", i4, i3, i4));
            InputStreamReader inputStreamReader2 = new InputStreamReader(jarFile.getInputStream(zipEntry), "UTF-8");
            BufferedReader obj6 = new BufferedReader(inputStreamReader2);
            b.a(obj6, i4);
            jarFile.close();
            return j.a.f(obj6);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(FirebasePerfUrlConnection.openStream(uRL));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        b.a(bufferedReader, i4);
        return j.a.f(bufferedReader);
    }

    private final List<String> f(BufferedReader bufferedReader) {
        String string;
        int i3;
        int length;
        int i4;
        int i5;
        int length2;
        char javaIdentifierPart;
        int i2;
        int i;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String line = bufferedReader.readLine();
        while (line == null) {
            length2 = 0;
            String str = l.X0(line, "#", length2, 2, length2);
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            string = l.a1(str).toString();
            i3 = 0;
            i4 = i3;
            i2 = 1;
            while (i4 < string.length()) {
                javaIdentifierPart = string.charAt(i4);
                if (javaIdentifierPart != 46) {
                } else {
                }
                length2 = i2;
                i4++;
                i2 = 1;
                if (Character.isJavaIdentifierPart(javaIdentifierPart)) {
                } else {
                }
                length2 = i3;
            }
            i5 = i2;
            if (string.length() > 0) {
            }
            if (i3 != 0) {
            }
            line = bufferedReader.readLine();
            linkedHashSet.add(string);
            i3 = i2;
            javaIdentifierPart = string.charAt(i4);
            if (javaIdentifierPart != 46) {
            } else {
            }
            length2 = i2;
            if (length2 == 0) {
            } else {
            }
            i4++;
            i5 = i3;
            if (Character.isJavaIdentifierPart(javaIdentifierPart)) {
            } else {
            }
            length2 = i3;
        }
        return p.L0(linkedHashSet);
    }

    public final List<kotlinx.coroutines.internal.MainDispatcherFactory> c() {
        ArrayList arrayList;
        Object cast;
        Class<kotlinx.coroutines.internal.MainDispatcherFactory> obj = MainDispatcherFactory.class;
        if (!k.a()) {
            return b(obj, obj.getClassLoader());
        }
        arrayList = new ArrayList(2);
        int i2 = 0;
        int i3 = 1;
        final int i4 = 0;
        cast = obj.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", i3, obj.getClassLoader()).getDeclaredConstructor(new Class[i4]).newInstance(new Object[i4]));
        if (cast == null) {
        } else {
            arrayList.add(cast);
        }
        Object obj3 = cast2;
        if (obj3 == null) {
        } else {
            arrayList.add(obj3);
        }
        return arrayList;
    }

    public final <S> List<S> d(Class<S> class, java.lang.ClassLoader classLoader2) {
        List list;
        int i;
        kotlinx.coroutines.internal.j jVar;
        ArrayList list2 = Collections.list(classLoader2.getResources(n.o("META-INF/services/", class.getName())));
        n.e(list2, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list2.iterator();
        for (URL next4 : iterator) {
            p.y(arrayList, j.a.e(next4));
        }
        Set set = p.P0(arrayList);
        if (empty ^= 1 == 0) {
        } else {
            ArrayList arrayList2 = new ArrayList(p.r(set, 10));
            Iterator iterator2 = set.iterator();
            for (String next3 : iterator2) {
                arrayList2.add(j.a.a(next3, classLoader2, class));
            }
            return arrayList2;
        }
        IllegalArgumentException obj5 = new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        throw obj5;
    }
}
