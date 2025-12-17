package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.assetpacks.c.b;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
final class z1 {

    private static final h g;
    private final com.google.android.play.core.assetpacks.f0 a;
    private final n1<com.google.android.play.core.assetpacks.d4> b;
    private final com.google.android.play.core.assetpacks.k1 c;
    private final n1<Executor> d;
    private final Map<Integer, com.google.android.play.core.assetpacks.w1> e;
    private final ReentrantLock f;
    static {
        h hVar = new h("ExtractorSessionStoreView");
        z1.g = hVar;
    }

    z1(com.google.android.play.core.assetpacks.f0 f0, n1<com.google.android.play.core.assetpacks.d4> n12, com.google.android.play.core.assetpacks.k1 k13, n1<Executor> n14) {
        super();
        this.a = f0;
        this.b = n12;
        this.c = k13;
        this.d = n14;
        HashMap obj1 = new HashMap();
        this.e = obj1;
        obj1 = new ReentrantLock();
        this.f = obj1;
    }

    private final com.google.android.play.core.assetpacks.w1 o(int i) {
        Integer valueOf = Integer.valueOf(i);
        Object obj = this.e.get(valueOf);
        if ((w1)obj == null) {
        } else {
            return (w1)obj;
        }
        Object[] arr = new Object[1];
        g1 g1Var = new g1(String.format("Could not find session %d while trying to get it", valueOf), i);
        throw g1Var;
    }

    private final <T> T p(com.google.android.play.core.assetpacks.y1<T> y1) {
        try {
            this.f.lock();
            this.f.unlock();
            return y1.zza();
            this.f.unlock();
            throw y1;
        }
    }

    private static String q(Bundle bundle) {
        String empty;
        ArrayList obj1 = bundle.getStringArrayList("pack_names");
        if (obj1 == null) {
        } else {
            if (obj1.isEmpty()) {
            } else {
                return (String)obj1.get(0);
            }
        }
        obj1 = new g1("Session without pack received.");
        throw obj1;
    }

    private static <T> List<T> r(List<T> list) {
        List obj0;
        if (list == null) {
            obj0 = Collections.emptyList();
        }
        return obj0;
    }

    private final Map<String, com.google.android.play.core.assetpacks.w1> s(List<String> list) {
        s1 s1Var = new s1(this, list);
        return (Map)p(s1Var);
    }

    final Boolean a(Bundle bundle) {
        int int = bundle.getInt("session_id");
        if (int == 0) {
            return Boolean.TRUE;
        }
        Integer valueOf = Integer.valueOf(int);
        if (!this.e.containsKey(valueOf)) {
            return Boolean.TRUE;
        }
        Object obj = this.e.get(valueOf);
        if (v1Var2.d == 6) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(obj4 ^= 1);
    }

    final Boolean b(Bundle bundle) {
        int i3;
        int valueOf;
        Object v1Var;
        boolean w1Var;
        Object[] str3;
        int parcelableArrayList;
        String next;
        int i2;
        com.google.android.play.core.assetpacks.x1 x1Var2;
        int i;
        boolean iterator;
        int arrayList;
        String str2;
        long long2;
        int int;
        long long3;
        ArrayList next2;
        String string;
        com.google.android.play.core.assetpacks.x1 x1Var;
        String str;
        String string2;
        long long;
        ArrayList list;
        int int2;
        int int3;
        final Object obj = this;
        i3 = bundle;
        valueOf = i3.getInt("session_id");
        if (valueOf == 0) {
            return Boolean.FALSE;
        }
        Integer valueOf2 = Integer.valueOf(valueOf);
        str3 = "chunk_intents";
        next = "status";
        i2 = 1;
        i = 0;
        if (obj.e.containsKey(valueOf2)) {
            v1Var = obj.o(valueOf);
            parcelableArrayList = i3.getInt(b.a(next, v1Var8.a));
            if (e0.c(v1Var9.d, parcelableArrayList)) {
                str3 = new Object[2];
                str3[i] = valueOf2;
                str3[i2] = Integer.valueOf(v1Var5.d);
                z1.g.a("Found stale update for session %s with status %d.", str3);
                com.google.android.play.core.assetpacks.v1 v1Var2 = v1Var.c;
                v1Var = v1Var2.a;
                i3 = v1Var2.d;
                if (i3 == 4) {
                    (d4)obj.b.zza().a(valueOf, v1Var);
                } else {
                    if (i3 == 5) {
                        (d4)obj.b.zza().e(valueOf);
                    } else {
                        if (i3 == 6) {
                            String[] strArr = new String[i2];
                            strArr[i] = v1Var;
                            (d4)obj.b.zza().g(Arrays.asList(strArr));
                        }
                    }
                }
            } else {
                v1Var6.d = parcelableArrayList;
                if (e0.d(parcelableArrayList)) {
                    obj.l(valueOf);
                    obj.c.c(v1Var4.a);
                } else {
                    valueOf = v1Var3.f.iterator();
                    while (valueOf.hasNext()) {
                        w1Var = valueOf.next();
                        parcelableArrayList = i3.getParcelableArrayList(b.b(str3, v1Var7.a, w1Var.a));
                        if (parcelableArrayList != null) {
                        }
                        iterator = i;
                        while (iterator < parcelableArrayList.size()) {
                            if (parcelableArrayList.get(iterator) != null && (Intent)parcelableArrayList.get(iterator).getData() != null) {
                            }
                            iterator++;
                            if ((Intent)parcelableArrayList.get(iterator).getData() != null) {
                            }
                            arrayList.a = i2;
                        }
                        if (parcelableArrayList.get(iterator) != null && (Intent)parcelableArrayList.get(iterator).getData() != null) {
                        }
                        iterator++;
                        if ((Intent)parcelableArrayList.get(iterator).getData() != null) {
                        }
                        arrayList.a = i2;
                    }
                }
            }
        } else {
            str2 = z1.q(bundle);
            ArrayList arrayList2 = new ArrayList();
            Iterator iterator2 = z1.r(i3.getStringArrayList(b.a("slice_ids", str2))).iterator();
            for (String next : iterator2) {
                arrayList = new ArrayList();
                iterator = z1.r(i3.getParcelableArrayList(b.b(str3, str2, next))).iterator();
                while (iterator.hasNext()) {
                    if ((Intent)iterator.next() != null) {
                    } else {
                    }
                    i2 = i;
                    t1 t1Var = new t1(i2);
                    arrayList.add(t1Var);
                    i2 = 1;
                    i = 0;
                }
                string2 = i3.getString(b.b("uncompressed_hash_sha256", str2, next));
                long = i3.getLong(b.b("uncompressed_size", str2, next));
                int3 = i3.getInt(b.b("patch_format", str2, next), 0);
                if (int3 != 0) {
                } else {
                }
                super(next, string2, long, obj23, arrayList, i3.getInt(b.b("compression_format", str2, next), 0), 0);
                arrayList2.add(x1Var2);
                i2 = 1;
                super(next, string2, long, obj23, arrayList, 0, int3);
                i = 0;
                if ((Intent)iterator.next() != null) {
                } else {
                }
                i2 = i;
                t1Var = new t1(i2);
                arrayList.add(t1Var);
                i2 = 1;
                i = 0;
            }
            super(str2, i3.getLong(b.a("pack_version", str2)), obj13, i3.getInt(b.a(next, str2)), i3.getLong(b.a("total_bytes_to_download", str2)), obj16, arrayList2, i3.getString(b.a("pack_version_tag", str2), ""));
            w1Var = new w1(valueOf, i3.getInt("app_version_code"), v1Var);
            obj.e.put(Integer.valueOf(valueOf), w1Var);
        }
        return Boolean.TRUE;
    }

    final Object c(String string, int i2, long l3) {
        int format;
        int arr;
        boolean z;
        String str;
        format = 1;
        String[] strArr = new String[format];
        arr = 0;
        strArr[arr] = string;
        Object obj = s(Arrays.asList(strArr)).get(string);
        if ((w1)obj != null) {
            if (e0.d(v1Var.d)) {
                Object[] arr2 = new Object[format];
                arr2[arr] = string;
                z1.g.b(String.format("Could not find pack %s while trying to complete it", arr2), new Object[arr]);
            }
        } else {
        }
        this.a.d(string, i2, l3);
        obj6.d = 4;
        return null;
    }

    final Object d(int i, int i2) {
        obj1.d = 5;
        return null;
    }

    final Object e(int i) {
        int w1Var;
        com.google.android.play.core.assetpacks.f0 i4;
        int i2;
        long i3;
        w1Var = o(i);
        if (!e0.d(v1Var.d)) {
        } else {
            com.google.android.play.core.assetpacks.v1 v1Var2 = w1Var.c;
            final long l = v1Var2.b;
            this.a.d(v1Var2.a, w1Var.b, l);
            com.google.android.play.core.assetpacks.v1 obj7 = w1Var.c;
            i4 = obj7.d;
            if (i4 != 5) {
                if (i4 == 6) {
                    this.a.e(obj7.a, w1Var.b, obj7.b);
                }
            } else {
            }
            return null;
        }
        Object[] arr = new Object[1];
        g1 g1Var = new g1(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i)), i);
        throw g1Var;
    }

    final Map<Integer, com.google.android.play.core.assetpacks.w1> f() {
        return this.e;
    }

    final Map g(List list) {
        Object next;
        String str;
        boolean contains;
        int i;
        HashMap hashMap = new HashMap();
        Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            str = v1Var.a;
            if (list.contains(str)) {
            }
            Object obj = hashMap.get(str);
            if ((w1)obj == null) {
            } else {
            }
            contains = obj.a;
            if (contains < next.a) {
            }
            hashMap.put(str, (w1)next);
            contains = -1;
        }
        return hashMap;
    }

    final void h() {
        this.f.lock();
    }

    final void i(String string, int i2, long l3) {
        super(this, string, i2, l3, obj5);
        p(r1Var2);
    }

    final void j() {
        this.f.unlock();
    }

    final void k(int i, int i2) {
        o1 obj3 = new o1(this, i, 5);
        p(obj3);
    }

    final void l(int i) {
        n1 n1Var = new n1(this, i);
        p(n1Var);
    }

    final boolean m(Bundle bundle) {
        p1 p1Var = new p1(this, bundle);
        return (Boolean)p(p1Var).booleanValue();
    }

    final boolean n(Bundle bundle) {
        q1 q1Var = new q1(this, bundle);
        return (Boolean)p(q1Var).booleanValue();
    }
}
