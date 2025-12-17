package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.internal.e1;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.h1;
import com.google.android.play.core.internal.i2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import com.google.android.play.core.tasks.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class t implements com.google.android.play.core.assetpacks.d4 {

    private static final h g;
    private static final Intent h;
    private final String a;
    private final com.google.android.play.core.assetpacks.k1 b;
    private final com.google.android.play.core.assetpacks.u2 c;
    private t<i2> d;
    private t<i2> e;
    private final AtomicBoolean f;
    static {
        h hVar = new h("AssetPackServiceImpl");
        t.g = hVar;
        Intent intent = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE");
        t.h = intent.setPackage("com.android.vending");
    }

    t(Context context, com.google.android.play.core.assetpacks.k1 k12, com.google.android.play.core.assetpacks.u2 u23) {
        Object packageName;
        Context context3;
        t tVar;
        Context context2;
        h hVar;
        String str;
        Intent intent;
        com.google.android.play.core.assetpacks.e4 e4Var;
        int i;
        Context obj10;
        boolean obj11;
        Object obj12;
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.f = atomicBoolean;
        this.a = context.getPackageName();
        this.b = k12;
        this.c = u23;
        if (h1.b(context)) {
            obj12 = t.g;
            Intent intent3 = t.h;
            com.google.android.play.core.assetpacks.e4 e4Var3 = e4.a;
            super(e1.a(context), obj12, "AssetPackService", intent3, e4Var3, 0);
            this.d = obj11;
            super(e1.a(context), obj12, "AssetPackService-keepAlive", intent3, e4Var3, 0);
            this.e = obj11;
        }
        t.g.a("AssetPackService initiated.", new Object[0]);
    }

    private static Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 11002);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        Integer valueOf2 = 1;
        arrayList.add(valueOf2);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(valueOf2);
        arrayList2.add(2);
        bundle.putIntegerArrayList("supported_patch_formats", arrayList2);
        return bundle;
    }

    private static Bundle i(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    private static <T> d<T> j() {
        Object[] arr = new Object[1];
        final int i2 = -11;
        t.g.b("onError(%d)", Integer.valueOf(i2));
        AssetPackException assetPackException = new AssetPackException(i2);
        return f.b(assetPackException);
    }

    private final void k(int i, String string2, int i3) {
        if (this.d == null) {
        } else {
            t.g.d("notifyModuleCompleted", new Object[0]);
            o oVar = new o();
            super(this, oVar, i, string2, oVar, i3);
            this.d.q(hVar2, oVar);
        }
        g1 obj12 = new g1("The Play Store app is not installed or is an unofficial version.", i);
        throw obj12;
    }

    static Bundle l(int i, String string2, String string3, int i4) {
        final Bundle obj0 = t.y(i, string2);
        obj0.putString("slice_id", string3);
        obj0.putInt("chunk_number", i4);
        return obj0;
    }

    static Bundle m(int i, String string2) {
        return t.y(i, string2);
    }

    static Bundle n() {
        return t.h();
    }

    static Bundle o(Map map) {
        String str;
        Bundle bundle;
        long longValue;
        String str2;
        final Bundle bundle2 = t.h();
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = map.entrySet().iterator();
        for (Map.Entry next2 : obj6) {
            bundle = new Bundle();
            str2 = "installed_asset_module_name";
            bundle.putString(str2, (String)next2.getKey());
            bundle.putLong("installed_asset_module_version", (Long)next2.getValue().longValue());
            arrayList.add(bundle);
        }
        bundle2.putParcelableArrayList("installed_asset_module", arrayList);
        return bundle2;
    }

    static Bundle p(int i) {
        return t.i(i);
    }

    static h q() {
        return t.g;
    }

    static t r(com.google.android.play.core.assetpacks.t t) {
        return t.d;
    }

    static t s(com.google.android.play.core.assetpacks.t t) {
        return t.e;
    }

    static String t(com.google.android.play.core.assetpacks.t t) {
        return t.a;
    }

    static ArrayList u(Collection collection) {
        int size;
        Bundle bundle;
        String str;
        ArrayList arrayList = new ArrayList(collection.size());
        final Iterator obj4 = collection.iterator();
        for (String size : obj4) {
            bundle = new Bundle();
            bundle.putString("module_name", size);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static List v(com.google.android.play.core.assetpacks.t t, List list2) {
        Object next;
        boolean z;
        Object k1Var;
        com.google.android.play.core.assetpacks.u2 arr;
        String str;
        ArrayList arrayList = new ArrayList();
        final Iterator obj6 = list2.iterator();
        while (obj6.hasNext()) {
            next = b.c((Bundle)obj6.next(), t.b, t.c).a().values().iterator().next();
            if ((AssetPackState)next == null) {
            }
            if (e0.a((AssetPackState)next.d())) {
            }
            arrayList.add(next.c());
            t.g.b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
        }
        return arrayList;
    }

    static AtomicBoolean w(com.google.android.play.core.assetpacks.t t) {
        return t.f;
    }

    static void x(com.google.android.play.core.assetpacks.t t, int i2, String string3, int i4) {
        t.k(i2, string3, i4);
    }

    private static Bundle y(int i, String string2) {
        final Bundle obj1 = t.i(i);
        obj1.putString("module_name", string2);
        return obj1;
    }

    @Override // com.google.android.play.core.assetpacks.d4
    public final void a(int i, String string2) {
        k(i, string2, 10);
    }

    public final d<ParcelFileDescriptor> b(int i, String string2, String string3, int i4) {
        if (this.d == null) {
            return t.j();
        }
        Object[] arr = new Object[4];
        t.g.d("getChunkFileDescriptor(%s, %s, %d, session=%d)", string2, string3, Integer.valueOf(i4), Integer.valueOf(i));
        o oVar = new o();
        super(this, oVar, i, string2, string3, i4, oVar);
        this.d.q(jVar, oVar);
        return oVar.a();
    }

    @Override // com.google.android.play.core.assetpacks.d4
    public final void c() {
        int i = 0;
        synchronized (this) {
            try {
                t.g.e("Keep alive connection manager is not initialized.", new Object[i]);
                h hVar2 = t.g;
                hVar2.d("keepAlive", new Object[i]);
                if (!this.f.compareAndSet(i, true)) {
                }
                hVar2.d("Service is already kept alive.", new Object[i]);
                o oVar = new o();
                k kVar = new k(this, oVar, oVar);
                this.e.q(kVar, oVar);
                throw th;
            }
        }
    }

    @Override // com.google.android.play.core.assetpacks.d4
    public final void d(int i, String string2, String string3, int i4) {
        if (this.d == null) {
        } else {
            t.g.d("notifyChunkTransferred", new Object[0]);
            o oVar = new o();
            super(this, oVar, i, string2, string3, i4, oVar);
            this.d.q(gVar, oVar);
        }
        g1 obj13 = new g1("The Play Store app is not installed or is an unofficial version.", i);
        throw obj13;
    }

    @Override // com.google.android.play.core.assetpacks.d4
    public final void e(int i) {
        if (this.d == null) {
        } else {
            t.g.d("notifySessionFailed", new Object[0]);
            o oVar = new o();
            i iVar = new i(this, oVar, i, oVar);
            this.d.q(iVar, oVar);
        }
        g1 g1Var = new g1("The Play Store app is not installed or is an unofficial version.", i);
        throw g1Var;
    }

    public final d<List<String>> f(Map<String, Long> map) {
        if (this.d == null) {
            return t.j();
        }
        t.g.d("syncPacks", new Object[0]);
        o oVar = new o();
        f fVar = new f(this, oVar, map, oVar);
        this.d.q(fVar, oVar);
        return oVar.a();
    }

    public final void g(List<String> list) {
        if (this.d == null) {
        }
        Object[] arr = new Object[1];
        t.g.d("cancelDownloads(%s)", list);
        o oVar = new o();
        e eVar = new e(this, oVar, list, oVar);
        this.d.q(eVar, oVar);
    }
}
