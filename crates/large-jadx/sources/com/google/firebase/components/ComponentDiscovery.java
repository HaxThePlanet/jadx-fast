package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.inject.Provider;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ComponentDiscovery<T>  {

    private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
    private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
    static final String TAG = "ComponentDiscovery";
    private final T context;
    private final com.google.firebase.components.ComponentDiscovery.RegistrarNameRetriever<T> retriever;

    interface RegistrarNameRetriever {
        public abstract List<String> retrieve(T t);
    }

    private static class MetadataRegistrarNameRetriever implements com.google.firebase.components.ComponentDiscovery.RegistrarNameRetriever<Context> {

        private final Class<? extends Service> discoveryService;
        private MetadataRegistrarNameRetriever(Class<? extends Service> class) {
            super();
            this.discoveryService = class;
        }

        MetadataRegistrarNameRetriever(Class class, com.google.firebase.components.ComponentDiscovery.1 componentDiscovery$12) {
            super(class);
        }

        private Bundle getMetadata(Context context) {
            final String str = "ComponentDiscovery";
            final int i = 0;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w(str, "Context has no PackageManager.");
                return i;
            }
            ComponentName componentName = new ComponentName(context, this.discoveryService);
            android.content.pm.ServiceInfo obj6 = packageManager.getServiceInfo(componentName, 128);
            if (obj6 == null) {
                try {
                    obj6 = new StringBuilder();
                    obj6.append(this.discoveryService);
                    obj6.append(" has no service info.");
                    Log.w(str, obj6.toString());
                    return i;
                    return obj6.metaData;
                    context = "Application info not found.";
                    Log.w(obj0, context);
                    return obj1;
                }
            }
        }

        public List<String> retrieve(Context context) {
            Object substring;
            boolean startsWith;
            String str;
            Bundle obj6 = getMetadata(context);
            if (obj6 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator iterator = obj6.keySet().iterator();
            while (iterator.hasNext()) {
                substring = iterator.next();
                if ("com.google.firebase.components.ComponentRegistrar".equals(obj6.get((String)substring)) && substring.startsWith("com.google.firebase.components:")) {
                }
                if (substring.startsWith("com.google.firebase.components:")) {
                }
                arrayList.add(substring.substring(31));
            }
            return arrayList;
        }

        @Override // com.google.firebase.components.ComponentDiscovery$RegistrarNameRetriever
        public List retrieve(Object object) {
            return retrieve((Context)object);
        }
    }
    ComponentDiscovery(T t, com.google.firebase.components.ComponentDiscovery.RegistrarNameRetriever<T> componentDiscovery$RegistrarNameRetriever2) {
        super();
        this.context = t;
        this.retriever = registrarNameRetriever2;
    }

    static com.google.firebase.components.ComponentRegistrar a(String string) {
        return ComponentDiscovery.instantiate(string);
    }

    public static com.google.firebase.components.ComponentDiscovery<Context> forContext(Context context, Class<? extends Service> class2) {
        ComponentDiscovery.MetadataRegistrarNameRetriever metadataRegistrarNameRetriever = new ComponentDiscovery.MetadataRegistrarNameRetriever(class2, 0);
        ComponentDiscovery componentDiscovery = new ComponentDiscovery(context, metadataRegistrarNameRetriever);
        return componentDiscovery;
    }

    private static com.google.firebase.components.ComponentRegistrar instantiate(String string) {
        final String str2 = "Could not instantiate %s";
        final String str3 = "Could not instantiate %s.";
        final int i2 = 0;
        Class forName = Class.forName(string);
        if (!ComponentRegistrar.class.isAssignableFrom(forName)) {
        } else {
            return (ComponentRegistrar)forName.getDeclaredConstructor(new Class[i2]).newInstance(new Object[i2]);
        }
        Object[] arr4 = new Object[2];
        arr4[i2] = string;
        arr4[1] = "com.google.firebase.components.ComponentRegistrar";
        InvalidRegistrarException invalidRegistrarException2 = new InvalidRegistrarException(String.format("Class %s is not an instance of %s", arr4));
        throw invalidRegistrarException2;
    }

    @Deprecated
    public List<com.google.firebase.components.ComponentRegistrar> discover() {
        Object instantiate;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.retriever.retrieve(this.context).iterator();
        while (iterator.hasNext()) {
            instantiate = ComponentDiscovery.instantiate((String)iterator.next());
            if (instantiate != null) {
            }
            arrayList.add(instantiate);
        }
        return arrayList;
    }

    public List<Provider<com.google.firebase.components.ComponentRegistrar>> discoverLazy() {
        Object context;
        com.google.firebase.components.d dVar;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.retriever.retrieve(this.context).iterator();
        for (String context : iterator) {
            dVar = new d(context);
            arrayList.add(dVar);
        }
        return arrayList;
    }
}
