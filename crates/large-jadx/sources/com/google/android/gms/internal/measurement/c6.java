package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import d.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class c6 implements com.google.android.gms.internal.measurement.g6 {

    private static final Map<Uri, com.google.android.gms.internal.measurement.c6> g;
    public static final String[] h;
    private final ContentResolver a;
    private final Uri b;
    private final ContentObserver c;
    private final Object d;
    private volatile Map<String, String> e;
    private final List<com.google.android.gms.internal.measurement.d6> f;
    static {
        a aVar = new a();
        c6.g = aVar;
        c6.h = /* result */;
    }

    private c6(ContentResolver contentResolver, Uri uri2) {
        super();
        a6 a6Var = new a6(this, 0);
        this.c = a6Var;
        Object object = new Object();
        this.d = object;
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri2);
        this.a = contentResolver;
        this.b = uri2;
        contentResolver.registerContentObserver(uri2, false, a6Var);
    }

    public static com.google.android.gms.internal.measurement.c6 b(ContentResolver contentResolver, Uri uri2) {
        Object obj;
        com.google.android.gms.internal.measurement.c6 c6Var;
        final Class<com.google.android.gms.internal.measurement.c6> obj2 = c6.class;
        final Map map = c6.g;
        synchronized (obj2) {
            c6Var = new c6(contentResolver, uri2);
            map.put(uri2, c6Var);
            obj = c6Var;
            return obj;
        }
    }

    static void e() {
        ContentObserver contentObserver;
        ContentResolver contentResolver;
        final Class<com.google.android.gms.internal.measurement.c6> obj = c6.class;
        Iterator iterator = c6.g.values().iterator();
        synchronized (obj) {
            for (c6 next2 : iterator) {
                next2.a.unregisterContentObserver(next2.c);
            }
            try {
                c6.g.clear();
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public final Object a(String string) {
        return (String)c().get(string);
    }

    public final Map<String, String> c() {
        Object map;
        Object obj;
        Object th;
        String str;
        obj = this.d;
        if (this.e == null && this.e == null) {
            obj = this.d;
            synchronized (obj) {
                z5 z5Var = new z5(this);
                th = e6.a(z5Var);
                StrictMode.setThreadPolicy(StrictMode.allowThreadDiskReads());
                this.e = th;
                map = th;
                try {
                    throw threadPolicy;
                    if (map != null) {
                    }
                    return map;
                    return Collections.emptyMap();
                } catch (java.lang.SecurityException se) {
                } catch (android.database.sqlite.SQLiteException sQLite1) {
                } catch (java.lang.IllegalStateException ise2) {
                } catch (Throwable th3) {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.g6
    final Map d() {
        int string2;
        Object hashMap;
        int string;
        Cursor query = this.a.query(this.b, c6.h, 0, 0, 0);
        if (query == null) {
            return Collections.emptyMap();
        }
        string2 = query.getCount();
        if (string2 == null) {
            query.close();
            return Collections.emptyMap();
        }
        if (string2 <= 256) {
            hashMap = new a(string2);
        } else {
            hashMap = new HashMap(string2, 1065353216);
        }
        while (query.moveToNext()) {
            hashMap.put(query.getString(0), query.getString(1));
        }
        query.close();
        return hashMap;
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public final void f() {
        int next;
        Object obj = this.d;
        this.e = 0;
        w6.e();
        Iterator iterator = this.f.iterator();
        synchronized (obj) {
            obj = this.d;
            this.e = 0;
            w6.e();
            iterator = this.f.iterator();
        }
        for (d6 next : iterator) {
            next.zza();
        }
    }
}
