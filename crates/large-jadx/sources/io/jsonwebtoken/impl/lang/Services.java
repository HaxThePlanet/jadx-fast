package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* loaded from: classes3.dex */
public final class Services {

    private static final List<io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor> CLASS_LOADER_ACCESSORS;

    private interface ClassLoaderAccessor {
        public abstract java.lang.ClassLoader getClassLoader();
    }
    static {
        io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor[] arr = new Services.ClassLoaderAccessor[3];
        Services.1 anon = new Services.1();
        Services.2 anon2 = new Services.2();
        Services.3 anon3 = new Services.3();
        Services.CLASS_LOADER_ACCESSORS = Collections.arrayToList(arr);
    }

    public static <T> List<T> loadAll(Class<T> class) {
        List all;
        boolean empty;
        Assert.notNull(class, "Parameter 'spi' must not be null.");
        Iterator iterator = Services.CLASS_LOADER_ACCESSORS.iterator();
        for (Services.ClassLoaderAccessor next2 : iterator) {
            all = Services.loadAll(class, next2.getClassLoader());
        }
        UnavailableImplementationException unavailableImplementationException = new UnavailableImplementationException(class);
        throw unavailableImplementationException;
    }

    private static <T> List<T> loadAll(Class<T> class, java.lang.ClassLoader classLoader2) {
        Object next;
        ArrayList obj2 = new ArrayList();
        Iterator obj1 = ServiceLoader.load(class, classLoader2).iterator();
        for (Object next : obj1) {
            obj2.add(next);
        }
        return obj2;
    }

    public static <T> T loadFirst(Class<T> class) {
        Object first;
        Assert.notNull(class, "Parameter 'spi' must not be null.");
        Iterator iterator = Services.CLASS_LOADER_ACCESSORS.iterator();
        for (Services.ClassLoaderAccessor next2 : iterator) {
            first = Services.loadFirst(class, next2.getClassLoader());
        }
        UnavailableImplementationException unavailableImplementationException = new UnavailableImplementationException(class);
        throw unavailableImplementationException;
    }

    private static <T> T loadFirst(Class<T> class, java.lang.ClassLoader classLoader2) {
        ServiceLoader obj0 = ServiceLoader.load(class, classLoader2);
        if (obj0.iterator().hasNext()) {
            return obj0.iterator().next();
        }
        return 0;
    }
}
