package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class z {

    private final Context a;
    public z(Context context) {
        super();
        this.a = context;
    }

    private final SharedPreferences d() {
        return this.a.getSharedPreferences("playcore_split_install_internal", 0);
    }

    public final Set<String> a() {
        Object stringSet;
        final Class<com.google.android.play.core.splitinstall.z> obj = z.class;
        HashSet hashSet2 = new HashSet();
        synchronized (obj) {
            stringSet = new HashSet();
            return stringSet;
        }
    }

    public final void b() {
        final Class<com.google.android.play.core.splitinstall.z> obj = z.class;
        HashSet hashSet = new HashSet();
        d().edit().putStringSet("modules_to_uninstall_if_emulated", hashSet).apply();
        return;
        synchronized (obj) {
            obj = z.class;
            hashSet = new HashSet();
            d().edit().putStringSet("modules_to_uninstall_if_emulated", hashSet).apply();
        }
    }

    final void c(Collection<String> collection) {
        Object iterator;
        int i;
        Object next;
        boolean contains;
        Object obj7;
        final Class<com.google.android.play.core.splitinstall.z> obj = z.class;
        HashSet hashSet = new HashSet();
        iterator = a().iterator();
        i = 0;
        synchronized (obj) {
            while (iterator.hasNext()) {
                next = iterator.next();
                if (collection.contains((String)next)) {
                } else {
                }
                hashSet.add(next);
                i = 1;
            }
            if (i != 0) {
                d().edit().putStringSet("modules_to_uninstall_if_emulated", hashSet).apply();
            }
        }
    }
}
