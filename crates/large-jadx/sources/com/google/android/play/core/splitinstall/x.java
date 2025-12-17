package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.a1;
import com.google.android.play.core.internal.e1;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.h1;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import com.google.android.play.core.tasks.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class x {

    private static final h c;
    private static final Intent d;
    private final String a;
    t<a1> b;
    static {
        h hVar = new h("SplitInstallService");
        x.c = hVar;
        Intent intent = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE");
        x.d = intent.setPackage("com.android.vending");
    }

    x(Context context, String string2) {
        t tVar;
        Context context2;
        h hVar;
        String str;
        Intent intent;
        com.google.android.play.core.splitinstall.s sVar;
        int i;
        boolean obj9;
        super();
        this.a = string2;
        if (h1.b(context)) {
            super(e1.a(context), x.c, "SplitInstallService", x.d, s.a, 0);
            this.b = obj9;
        }
    }

    static Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 11002);
        return bundle;
    }

    static h b() {
        return x.c;
    }

    static String d(com.google.android.play.core.splitinstall.x x) {
        return x.a;
    }

    static ArrayList e(Collection collection) {
        int size;
        Bundle bundle;
        String str;
        ArrayList arrayList = new ArrayList(collection.size());
        final Iterator obj4 = collection.iterator();
        for (String size : obj4) {
            bundle = new Bundle();
            bundle.putString("language", size);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static ArrayList f(Collection collection) {
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

    private static <T> d<T> g() {
        Object[] arr = new Object[1];
        final int i2 = -14;
        x.c.b("onError(%d)", Integer.valueOf(i2));
        SplitInstallException splitInstallException = new SplitInstallException(i2);
        return f.b(splitInstallException);
    }

    public final d<Integer> c(Collection<String> collection, Collection<String> collection2) {
        if (this.b == null) {
            return x.g();
        }
        Object[] arr = new Object[2];
        x.c.d("startInstall(%s,%s)", collection, collection2);
        o oVar = new o();
        super(this, oVar, collection, collection2, oVar);
        this.b.q(tVar3, oVar);
        return oVar.a();
    }
}
