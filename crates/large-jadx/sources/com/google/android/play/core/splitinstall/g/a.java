package com.google.android.play.core.splitinstall.g;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.play.core.internal.f1;
import com.google.android.play.core.internal.g;
import com.google.android.play.core.internal.j1;
import com.google.android.play.core.internal.n1;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.a;
import com.google.android.play.core.splitinstall.c;
import com.google.android.play.core.splitinstall.d;
import com.google.android.play.core.splitinstall.e;
import com.google.android.play.core.splitinstall.g0;
import com.google.android.play.core.splitinstall.h0;
import com.google.android.play.core.splitinstall.k0;
import com.google.android.play.core.splitinstall.o0;
import com.google.android.play.core.splitinstall.s0;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import f.c.a.f.a.d.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class a implements a {

    private static final long o;
    public static final int p;
    private final Handler a;
    private final Context b;
    private final s0 c;
    private final n1<com.google.android.play.core.splitinstall.g.r> d;
    private final f1 e;
    private final g<d> f;
    private final g<d> g;
    private final Executor h;
    private final g0 i;
    private final File j;
    private final AtomicReference<d> k;
    private final Set<String> l;
    private final Set<String> m;
    private final AtomicBoolean n;
    static {
        a.o = TimeUnit.SECONDS.toMillis(1);
    }

    a(Context context, File file2, s0 s03, n1<com.google.android.play.core.splitinstall.g.r> n14) {
        f1 f1Var = new f1(context);
        com.google.android.play.core.splitinstall.g.e eVar = e.a;
        super();
        Handler handler = new Handler(Looper.getMainLooper());
        this.a = handler;
        AtomicReference atomicReference = new AtomicReference();
        this.k = atomicReference;
        HashSet hashSet = new HashSet();
        this.l = Collections.synchronizedSet(hashSet);
        HashSet hashSet2 = new HashSet();
        this.m = Collections.synchronizedSet(hashSet2);
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.n = atomicBoolean;
        this.b = context;
        this.j = file2;
        this.c = s03;
        this.d = n14;
        this.h = e.a();
        this.e = f1Var;
        g obj5 = new g();
        this.g = obj5;
        obj5 = new g();
        this.f = obj5;
        this.i = o0.zza;
    }

    static void f(com.google.android.play.core.splitinstall.g.a a, List list2, List list3, List list4, long l5, boolean z6) {
        a.r(list2, list3, list4, l5, obj5);
    }

    static void g(com.google.android.play.core.splitinstall.g.a a, List list2, List list3, long l4) {
        a.t(list2, list3, l4);
    }

    static boolean l(com.google.android.play.core.splitinstall.g.a a, int i2, int i3) {
        return a.u(6, i3, 0, 0, 0, 0, 0);
    }

    private final k0 m() {
        k0 k0Var = this.c.a();
        if (k0Var == null) {
        } else {
            return k0Var;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
        throw illegalStateException;
    }

    private final d n() {
        return (d)this.k.get();
    }

    private final d o(com.google.android.play.core.splitinstall.g.o o) {
        d dVar = n();
        d obj3 = o.a(dVar);
        synchronized (this) {
            try {
                return obj3;
                return null;
                throw o;
            }
        }
    }

    private final d<Integer> p(int i) {
        g gVar = new g(i);
        o(gVar);
        SplitInstallException splitInstallException = new SplitInstallException(i);
        return f.b(splitInstallException);
    }

    private static String q(String string) {
        return string.split("\\.config\\.", 2)[0];
    }

    private final void r(List<Intent> list, List<String> list2, List<String> list3, long l4, boolean z5) {
        super(this, list2, list3, l4, obj5, obj17, list);
        List list4 = list;
        obj.i.zza().a(list, nVar2);
    }

    private final void s(d d) {
        l lVar = new l(this, d);
        this.a.post(lVar);
    }

    private final void t(List<String> list, List<String> list2, long l3) {
        this.l.addAll(list);
        this.m.addAll(list2);
        final Long valueOf = Long.valueOf(l3);
        this.u(5, 0, valueOf, valueOf, 0, 0, 0);
    }

    private final boolean u(int i, int i2, Long long3, Long long4, List<String> list5, Integer integer6, List<String> list7) {
        final Object obj = this;
        super(integer6, i, i2, long3, long4, list5, list7);
        d dVar = o(iVar2);
        if (dVar != null) {
            s(dVar);
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final boolean a(d d, Activity activity2, int i3) {
        return 0;
    }

    public final d<Integer> b(c c) {
        int hashSet3;
        int size;
        c contains;
        int i4;
        String language;
        File[] listFiles;
        String str3;
        int hashSet2;
        File file;
        String str;
        boolean contains2;
        Iterator iterator;
        int str2;
        int i3;
        int i;
        boolean contains3;
        HashSet hashSet;
        int i2;
        boolean next;
        File[] objArr;
        int i5;
        int i6;
        final Object obj6 = this;
        h hVar = new h(c);
        d dVar = obj6.o(hVar);
        if (dVar != null) {
            hashSet3 = dVar.h();
            ArrayList arrayList2 = new ArrayList();
            Iterator iterator3 = c.a().iterator();
            try {
                for (Locale next3 : iterator3) {
                    arrayList2.add(next3.getLanguage());
                }
                arrayList2.add((Locale)iterator3.next().getLanguage());
                HashSet hashSet5 = new HashSet();
                ArrayList arrayList3 = new ArrayList();
                listFiles = obj6.j.listFiles(j.a);
                String str7 = "FakeSplitInstallManager";
                if (listFiles == null) {
                }
                Log.w(str7, "Specified splits directory does not exist.");
                return obj6.p(-5);
                hashSet2 = listFiles.length;
                i3 = 0;
                i = 0;
                file = listFiles[i3];
                str = j1.a(file);
                hashSet5.add(str);
                hashSet = new HashSet(obj6.e.a());
                objArr = listFiles;
                String[] strArr = new String[1];
                Map map2 = m().a(Arrays.asList(a.q(str)));
                listFiles = new HashSet();
                Iterator iterator4 = map2.values().iterator();
                for (Object next : iterator4) {
                    listFiles.addAll((Set)next);
                    hashSet2 = i5;
                }
                listFiles.addAll((Set)iterator4.next());
                hashSet2 = i5;
                i5 = hashSet2;
                hashSet2 = new HashSet();
                iterator = hashSet.iterator();
                while (iterator.hasNext()) {
                    hashSet = iterator.next();
                    str2 = "_";
                    if ((String)hashSet.contains(str2)) {
                    } else {
                    }
                    i6 = hashSet3;
                    hashSet2.add(hashSet);
                    iterator = next;
                    hashSet3 = i6;
                    i6 = hashSet3;
                    hashSet = hashSet.split(str2, -1)[0];
                }
                hashSet = iterator.next();
                str2 = "_";
                if ((String)hashSet.contains(str2)) {
                } else {
                }
                i6 = hashSet3;
                hashSet = hashSet.split(str2, -1)[0];
                i6 = hashSet3;
                hashSet2.add(hashSet);
                iterator = next;
                hashSet3 = i6;
                i6 = hashSet3;
                hashSet2.addAll(obj6.m);
                hashSet2.addAll(arrayList2);
                hashSet3 = new HashSet();
                Iterator iterator2 = map2.entrySet().iterator();
            }
            String valueOf = String.valueOf(hashSet5);
            String valueOf3 = String.valueOf(c.b());
            StringBuilder stringBuilder = new StringBuilder(i14 += length2);
            stringBuilder.append("availableSplits ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" want ");
            stringBuilder.append(valueOf3);
            Log.i(str7, stringBuilder.toString());
            if (c.b().size() == 1) {
                if ((Integer)(r)obj6.d.zza().b().get(c.b().get(0)) == null) {
                    size = (r)obj6.d.zza().a();
                }
            } else {
            }
            if (size != null) {
                return obj6.p(size.intValue());
            }
            List list6 = c.b();
            HashSet hashSet4 = new HashSet(list6);
            if (!hashSet5.containsAll(hashSet4)) {
                return obj6.p(-2);
            }
            Integer valueOf2 = Integer.valueOf(hashSet3);
            this.u(1, 0, Long.valueOf(0), Long.valueOf(i), c.b(), valueOf2, arrayList2);
            m mVar = new m(obj6, arrayList3, arrayList2);
            obj6.h.execute(mVar);
            return f.c(valueOf2);
        }
        return obj6.p(-100);
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void c(e e) {
        this.g.b(e);
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void d(e e) {
        this.g.a(e);
    }

    public final Set<String> e() {
        Set set;
        HashSet hashSet = new HashSet();
        if (this.c.d() != null) {
            hashSet.addAll(this.c.d());
        }
        hashSet.addAll(this.m);
        return hashSet;
    }

    @Override // com.google.android.play.core.splitinstall.a
    final void h(long l, List list2, List list3, List list4) {
        int i4;
        int i2;
        int i8;
        int i;
        int i7;
        Long valueOf2;
        Long valueOf;
        int i3;
        int i5;
        int i6;
        int i12 = l;
        i4 = 0;
        i2 = 0;
        while (i2 < 3) {
            int i14 = 2;
            this.u(i14, 0, Long.valueOf(Math.min(i12, obj6)), Long.valueOf(l), 0, 0, 0);
            SystemClock.sleep(a.o);
            i8 = n();
            i2++;
        }
        super(this, list3, list4, obj20, l, obj6);
        obj2.h.execute(fVar2);
    }

    @Override // com.google.android.play.core.splitinstall.a
    final void i(d d) {
        this.f.c(d);
        this.g.c(d);
    }

    @Override // com.google.android.play.core.splitinstall.a
    final void j(List list, List list2, List list3, long l4) {
        if (this.n.get()) {
            this.u(6, -6, 0, 0, 0, 0, 0);
        }
        if (this.i.zza() != null) {
            this.r(list, list2, list3, l4, obj6);
        }
        t(list2, list3, l4);
    }

    @Override // com.google.android.play.core.splitinstall.a
    final void k(List list, List list2) {
        String str4;
        String str3;
        String str;
        Object intent;
        String str2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator obj9 = list.iterator();
        for (File next2 : obj9) {
            str3 = j1.a(next2);
            Uri file = Uri.fromFile(next2);
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(file, this.b.getContentResolver().getType(file));
            intent.addFlags(1);
            intent.putExtra("module_name", a.q(str3));
            intent.putExtra("split_id", str3);
            arrayList.add(intent);
            arrayList2.add(a.q(j1.a(next2)));
        }
        obj9 = n();
        if (obj9 == null) {
        }
        super(this, obj9.j(), intent, arrayList, arrayList2, list2);
        this.h.execute(kVar2);
    }
}
