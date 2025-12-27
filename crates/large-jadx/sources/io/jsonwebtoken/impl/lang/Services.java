package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* compiled from: Services.java */
/* loaded from: classes3.dex */
public final class Services {

    private static final List<Services.ClassLoaderAccessor> CLASS_LOADER_ACCESSORS;

    private interface ClassLoaderAccessor {
        java.lang.ClassLoader getClassLoader();
    }
    static {
        io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor[] arr = new Services.ClassLoaderAccessor[3];
        Services.CLASS_LOADER_ACCESSORS = Collections.arrayToList(new Services.ClassLoaderAccessor[] { new Services.AnonymousClass1(), new Services.AnonymousClass2(), new Services.AnonymousClass3() });
    }

    private Services() {
        super();
    }

    public static <T> List<T> loadAll(Class<T> cls) throws UnavailableImplementationException {
        Assert.notNull(cls, "Parameter 'spi' must not be null.");
        Iterator it = Services.CLASS_LOADER_ACCESSORS.iterator();
        while (it.hasNext()) {
            List all = Services.loadAll(cls, (Services.ClassLoaderAccessor)it.next().getClassLoader());
            if (!all.isEmpty()) {
                return Collections.unmodifiableList(all);
            }
        }
        throw new UnavailableImplementationException(cls);
    }

    public static <T> T loadFirst(Class<T> cls) throws UnavailableImplementationException {
        Assert.notNull(cls, "Parameter 'spi' must not be null.");
        Iterator it = Services.CLASS_LOADER_ACCESSORS.iterator();
        while (it.hasNext()) {
            Object first = Services.loadFirst(cls, (Services.ClassLoaderAccessor)it.next().getClassLoader());
            if (first != null) {
                return first;
            }
        }
        throw new UnavailableImplementationException(cls);
    }

    private static <T> T loadFirst(Class<T> cls, java.lang.ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        if (load.iterator().hasNext()) {
            return load.iterator().next();
        }
        return null;
    }

    private static <T> List<T> loadAll(Class<T> cls, java.lang.ClassLoader classLoader) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = ServiceLoader.load(cls, classLoader).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
