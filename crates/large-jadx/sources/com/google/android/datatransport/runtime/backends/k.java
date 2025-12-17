package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class k implements com.google.android.datatransport.runtime.backends.e {

    private final com.google.android.datatransport.runtime.backends.k.a a;
    private final com.google.android.datatransport.runtime.backends.i b;
    private final Map<String, com.google.android.datatransport.runtime.backends.m> c;

    static class a {

        private final Context a;
        private Map<String, String> b = null;
        a(Context context) {
            super();
            final int i = 0;
            this.a = context;
        }

        private Map<String, String> a(Context context) {
            Object next;
            Object split;
            boolean startsWith;
            int i;
            String trim;
            String substring;
            Bundle obj9 = k.a.d(context);
            if (obj9 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            Iterator iterator = obj9.keySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                split = obj9.get((String)next);
                if (split instanceof String != null && next.startsWith("backend:")) {
                }
                if (next.startsWith("backend:")) {
                }
                split = (String)split.split(",", -1);
                i = 0;
                while (i < split.length) {
                    trim = split[i].trim();
                    if (trim.isEmpty()) {
                    } else {
                    }
                    hashMap.put(trim, next.substring(8));
                    i++;
                }
                trim = split[i].trim();
                if (trim.isEmpty()) {
                } else {
                }
                hashMap.put(trim, next.substring(8));
                i++;
            }
            return hashMap;
        }

        private Map<String, String> c() {
            Map map;
            if (this.b == null) {
                this.b = a(this.a);
            }
            return this.b;
        }

        private static Bundle d(Context context) {
            final String str = "BackendRegistry";
            final int i = 0;
            final PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w(str, "Context has no PackageManager.");
                return i;
            }
            ComponentName componentName = new ComponentName(context, TransportBackendDiscovery.class);
            android.content.pm.ServiceInfo obj5 = packageManager.getServiceInfo(componentName, 128);
            if (obj5 == null) {
                try {
                    Log.w(str, "TransportBackendDiscovery has no service info.");
                    return i;
                    return obj5.metaData;
                    context = "Application info not found.";
                    Log.w(obj0, context);
                    return obj1;
                }
            }
        }

        com.google.android.datatransport.runtime.backends.d b(String string) {
            Throwable arr;
            int arr2;
            final String str2 = "Could not instantiate %s";
            final String str3 = "Could not instantiate %s.";
            final String str4 = "BackendRegistry";
            final Object obj9 = c().get(string);
            if ((String)obj9 == null) {
                return null;
            }
            final int i2 = 1;
            final int i3 = 0;
            return (d)Class.forName((String)obj9).asSubclass(d.class).getDeclaredConstructor(new Class[i3]).newInstance(new Object[i3]);
        }
    }
    k(Context context, com.google.android.datatransport.runtime.backends.i i2) {
        k.a aVar = new k.a(context);
        super(aVar, i2);
    }

    k(com.google.android.datatransport.runtime.backends.k.a k$a, com.google.android.datatransport.runtime.backends.i i2) {
        super();
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        this.a = a;
        this.b = i2;
    }

    @Override // com.google.android.datatransport.runtime.backends.e
    public com.google.android.datatransport.runtime.backends.m get(String string) {
        synchronized (this) {
            try {
                return (m)this.c.get(string);
                com.google.android.datatransport.runtime.backends.d dVar = this.a.b(string);
                if (dVar == null) {
                }
                return null;
                com.google.android.datatransport.runtime.backends.m create = dVar.create(this.b.a(string));
                this.c.put(string, create);
                return create;
                throw string;
            }
        }
    }
}
