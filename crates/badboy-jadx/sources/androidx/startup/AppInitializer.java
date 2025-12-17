package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class AppInitializer {

    private static final String SECTION_NAME = "Startup";
    private static volatile androidx.startup.AppInitializer sInstance;
    private static final Object sLock;
    final Context mContext;
    final Set<Class<? extends androidx.startup.Initializer<?>>> mDiscovered;
    final Map<Class<?>, Object> mInitialized;
    static {
        Object object = new Object();
        AppInitializer.sLock = object;
    }

    AppInitializer(Context context) {
        super();
        this.mContext = context.getApplicationContext();
        HashSet hashSet = new HashSet();
        this.mDiscovered = hashSet;
        HashMap hashMap = new HashMap();
        this.mInitialized = hashMap;
    }

    private <T> T doInitialize(Class<? extends androidx.startup.Initializer<?>> class, Set<Class<?>> set2) {
        Object message;
        Object instance;
        Object startupException;
        List dependencies;
        Object create;
        boolean iterator;
        Map mInitialized;
        boolean key;
        if (Trace.isEnabled()) {
            Trace.beginSection(class.getSimpleName());
        }
        if (set2.contains(class)) {
        } else {
            if (!this.mInitialized.containsKey(class)) {
                set2.add(class);
                int i = 0;
                startupException = instance;
                dependencies = (Initializer)startupException.dependencies();
                if (!dependencies.isEmpty()) {
                    iterator = dependencies.iterator();
                    try {
                        while (iterator.hasNext()) {
                            mInitialized = iterator.next();
                            if (!this.mInitialized.containsKey((Class)mInitialized)) {
                            }
                            doInitialize(mInitialized, set2);
                        }
                        mInitialized = iterator.next();
                        if (!this.mInitialized.containsKey((Class)mInitialized)) {
                        }
                        doInitialize(mInitialized, set2);
                        set2.remove(class);
                        this.mInitialized.put(class, startupException.create(this.mContext));
                        startupException = new StartupException(message);
                        throw startupException;
                        create = instance;
                        Trace.endSection();
                        return create;
                        IllegalStateException illegalStateException = new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", /* result */));
                        throw illegalStateException;
                        Trace.endSection();
                        throw message;
                    } catch (Throwable th) {
                    }
                }
            } else {
            }
        }
    }

    public static androidx.startup.AppInitializer getInstance(Context context) {
        Object sInstance;
        androidx.startup.AppInitializer appInitializer;
        sInstance = AppInitializer.sLock;
        if (AppInitializer.sInstance == null && AppInitializer.sInstance == null) {
            sInstance = AppInitializer.sLock;
            synchronized (sInstance) {
                appInitializer = new AppInitializer(context);
                AppInitializer.sInstance = appInitializer;
            }
        }
        return AppInitializer.sInstance;
    }

    static void setDelegate(androidx.startup.AppInitializer delegate) {
        final Object sLock = AppInitializer.sLock;
        AppInitializer.sInstance = delegate;
        return;
        synchronized (sLock) {
            sLock = AppInitializer.sLock;
            AppInitializer.sInstance = delegate;
        }
    }

    void discoverAndInitialize() {
        try {
            Trace.beginSection("Startup");
            ComponentName componentName = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());
            discoverAndInitialize(providerInfo.metaData);
            Trace.endSection();
            StartupException startupException = new StartupException(th);
            throw startupException;
            Trace.endSection();
            throw th;
        } catch (Throwable th) {
        }
    }

    void discoverAndInitialize(Bundle metadata) {
        int androidx_startup;
        Object startupException;
        Iterator iterator;
        boolean next2;
        boolean next;
        String string;
        boolean forName;
        boolean assignableFrom;
        Set mDiscovered;
        if (metadata != null) {
            androidx_startup = new HashSet();
            Iterator iterator2 = metadata.keySet().iterator();
            while (iterator2.hasNext()) {
                next2 = iterator2.next();
                forName = Class.forName(next2);
                if (this.mContext.getString(R.string.androidx_startup).equals(metadata.getString((String)next2, 0)) && Initializer.class.isAssignableFrom(forName)) {
                }
                forName = Class.forName(next2);
                if (Initializer.class.isAssignableFrom(forName)) {
                }
                this.mDiscovered.add(forName);
            }
            iterator = this.mDiscovered.iterator();
            for (Class next : iterator) {
                doInitialize(next, androidx_startup);
            }
        }
    }

    <T> T doInitialize(Class<? extends androidx.startup.Initializer<?>> class) {
        Object result;
        Object doInitialize;
        final Object sLock = AppInitializer.sLock;
        synchronized (sLock) {
            HashSet hashSet = new HashSet();
            result = doInitialize;
            return result;
        }
    }

    public <T> T initializeComponent(Class<? extends androidx.startup.Initializer<T>> class) {
        return doInitialize(class);
    }

    public boolean isEagerlyInitialized(Class<? extends androidx.startup.Initializer<?>> class) {
        return this.mDiscovered.contains(class);
    }
}
