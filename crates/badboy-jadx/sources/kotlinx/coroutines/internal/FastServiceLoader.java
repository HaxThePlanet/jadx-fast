package kotlinx.coroutines.internal;

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
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00082\u0006\u0010\t\u001a\u00020\u0004H\u0082\u0008J1\u0010\n\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0008H\u0002¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u00082\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\u0008\u0014J/\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u00082\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0008\u0016J\u0016\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\u0008\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\u0082\u0008¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FastServiceLoader {

    public static final kotlinx.coroutines.internal.FastServiceLoader INSTANCE = null;
    private static final String PREFIX = "META-INF/services/";
    static {
        FastServiceLoader fastServiceLoader = new FastServiceLoader();
        FastServiceLoader.INSTANCE = fastServiceLoader;
    }

    private final kotlinx.coroutines.internal.MainDispatcherFactory createInstanceOf(Class<kotlinx.coroutines.internal.MainDispatcherFactory> baseClass, String serviceClass) {
        Class forName;
        Object cast;
        final int i = 0;
        int i4 = 0;
        cast = baseClass.cast(Class.forName(serviceClass, true, baseClass.getClassLoader()).getDeclaredConstructor(new Class[i4]).newInstance(new Object[i4]));
        try {
            return cast;
        }
    }

    private final <S> S getProviderInstance(String name, java.lang.ClassLoader loader, Class<S> service) {
        int i = 0;
        final Class forName = Class.forName(name, i, loader);
        if (!service.isAssignableFrom(forName)) {
        } else {
            return service.cast(forName.getDeclaredConstructor(new Class[i]).newInstance(new Object[i]));
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected service of class ").append(service).append(", but found ").append(forName).toString().toString());
        throw illegalArgumentException;
    }

    private final <S> List<S> load(Class<S> service, java.lang.ClassLoader loader) {
        List providers$kotlinx_coroutines_core;
        ServiceLoader list;
        providers$kotlinx_coroutines_core = loadProviders$kotlinx_coroutines_core(service, loader);
        return providers$kotlinx_coroutines_core;
    }

    private final List<String> parse(URL url) {
        final String string = url.toString();
        int i = 0;
        int i2 = 2;
        final int i4 = 0;
        if (StringsKt.startsWith$default(string, "jar", i, i2, i4)) {
            JarFile jarFile = new JarFile(StringsKt.substringBefore$default(StringsKt.substringAfter$default(string, "jar:file:", i4, i2, i4), '!', i4, i2, i4), i);
            Throwable obj = this;
            final int i6 = 0;
            final int i7 = 0;
            final int i8 = 0;
            ZipEntry zipEntry = new ZipEntry(StringsKt.substringAfter$default(string, "!/", i4, i2, i4));
            InputStreamReader inputStreamReader2 = new InputStreamReader(jarFile.getInputStream(zipEntry), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader((Reader)inputStreamReader2);
            int i9 = 0;
            CloseableKt.closeFinally(bufferedReader, i4);
            jarFile.close();
            return FastServiceLoader.INSTANCE.parseFile((BufferedReader)(Closeable)bufferedReader);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        BufferedReader pathToJar = new BufferedReader((Reader)inputStreamReader);
        int i3 = 0;
        CloseableKt.closeFinally(pathToJar, i4);
        return FastServiceLoader.INSTANCE.parseFile((BufferedReader)(Closeable)pathToJar);
    }

    private final List<String> parseFile(BufferedReader r) {
        String line;
        String string;
        int length;
        int $this$all$iv;
        int i3;
        int i4;
        int i5;
        int charAt;
        int i;
        int it;
        int i2;
        boolean javaIdentifierPart;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        line = r.readLine();
        while (line == null) {
            int i8 = 0;
            string = StringsKt.trim((CharSequence)StringsKt.substringBefore$default(line, "#", i8, 2, i8)).toString();
            String str2 = string;
            i3 = 0;
            i4 = 0;
            i5 = i4;
            i = 1;
            while (i5 < (CharSequence)str2.length()) {
                char c = charAt;
                i2 = 0;
                if (c != 46) {
                } else {
                }
                it = i;
                i5++;
                i = 1;
                if (Character.isJavaIdentifierPart(c)) {
                } else {
                }
                it = i4;
            }
            $this$all$iv = i;
            if ((CharSequence)string.length() > 0) {
            }
            if (i4 != 0) {
            }
            line = r.readLine();
            (Set)linkedHashSet.add(string);
            i4 = i;
            c = charAt;
            i2 = 0;
            if (c != 46) {
            } else {
            }
            it = i;
            if (it == 0) {
            } else {
            }
            i5++;
            $this$all$iv = i4;
            if (Character.isJavaIdentifierPart(c)) {
            } else {
            }
            it = i4;
        }
        return CollectionsKt.toList((Iterable)linkedHashSet);
    }

    private final <R> R use(JarFile $this$use, Function1<? super JarFile, ? extends R> block) {
        final int i = 0;
        final int i2 = 0;
        $this$use.close();
        return block.invoke($this$use);
    }

    public final List<kotlinx.coroutines.internal.MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        ArrayList arrayList;
        String str;
        String $i$a$ApplyFastServiceLoader$loadMainDispatcherFactory$1;
        Class forName2;
        Class forName;
        Object cast;
        final Class<kotlinx.coroutines.internal.MainDispatcherFactory> obj = MainDispatcherFactory.class;
        if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
            return load(obj, obj.getClassLoader());
        }
        arrayList = new ArrayList(2);
        Object obj2 = this;
        int i2 = 0;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        cast = obj.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", i5, obj.getClassLoader()).getDeclaredConstructor(new Class[i6]).newInstance(new Object[i6]));
        if (cast != null) {
            str = 0;
            arrayList.add(cast);
        }
        Object obj3 = this;
        int i3 = 0;
        Object obj4 = cast2;
        if (obj4 != null) {
            $i$a$ApplyFastServiceLoader$loadMainDispatcherFactory$1 = 0;
            arrayList.add(obj4);
        }
        return arrayList;
    }

    public final <S> List<S> loadProviders$kotlinx_coroutines_core(Class<S> service, java.lang.ClassLoader loader) {
        Object next;
        List it;
        int it2;
        kotlinx.coroutines.internal.FastServiceLoader iNSTANCE2;
        kotlinx.coroutines.internal.FastServiceLoader iNSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList list = Collections.list(loader.getResources(stringBuilder.append("META-INF/services/").append(service.getName()).toString()));
        Intrinsics.checkNotNullExpressionValue(list, "list(this)");
        int i = 0;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        Iterator iterator = (Iterable)(List)list.iterator();
        for (Object next : iterator) {
            it2 = 0;
            CollectionsKt.addAll((Collection)arrayList, (Iterable)FastServiceLoader.INSTANCE.parse((URL)next));
        }
        Set set = CollectionsKt.toSet((Iterable)(List)arrayList);
        if ((Collection)set.isEmpty()) {
        } else {
            Set set3 = set;
            int i3 = 0;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)set3, 10));
            int i6 = 0;
            Iterator iterator2 = set3.iterator();
            for (Object it : iterator2) {
                iNSTANCE2 = 0;
                (Collection)arrayList2.add(FastServiceLoader.INSTANCE.getProviderInstance((String)it, loader, service));
            }
            return (List)arrayList2;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireFastServiceLoader$loadProviders$1 = new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        throw $i$a$RequireFastServiceLoader$loadProviders$1;
    }
}
