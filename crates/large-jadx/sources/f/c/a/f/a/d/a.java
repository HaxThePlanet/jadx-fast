package f.c.a.f.a.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.play.core.internal.b0;
import com.google.android.play.core.internal.u;
import com.google.android.play.core.internal.w;
import com.google.android.play.core.internal.y;
import com.google.android.play.core.internal.z;
import com.google.android.play.core.internal.zzbt;
import com.google.android.play.core.splitinstall.o0;
import com.google.android.play.core.splitinstall.r0;
import com.google.android.play.core.splitinstall.s0;
import com.google.android.play.core.splitinstall.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
public class a {

    private static final AtomicReference<f.c.a.f.a.d.a> e;
    private final f.c.a.f.a.d.f a;
    private final z b;
    private final Set<String> c;
    private final f.c.a.f.a.d.b d;
    static {
        AtomicReference atomicReference = new AtomicReference(0);
        a.e = atomicReference;
    }

    private a(Context context) {
        super();
        HashSet hashSet = new HashSet();
        this.c = hashSet;
        f fVar = new f(context);
        this.a = fVar;
        b bVar = new b(fVar);
        this.d = bVar;
        z zVar = new z(context);
        this.b = zVar;
    }

    public static boolean a(Context context) {
        return a.k(context, false);
    }

    public static boolean b(Context context) {
        Context applicationContext;
        if (a.l()) {
            return 0;
        }
        Object obj = a.e.get();
        if ((a)obj == null && context.getApplicationContext() != null) {
            if (context.getApplicationContext() != null) {
                a.a(context.getApplicationContext());
            }
            return a.a(context);
        }
        return obj.d.b(context, (a)obj.h());
    }

    static f.c.a.f.a.d.f c(f.c.a.f.a.d.a a) {
        return a.a;
    }

    static Set d(f.c.a.f.a.d.a a) {
        return a.h();
    }

    static void e(f.c.a.f.a.d.a a, Set set2) {
        a.i(set2);
    }

    public static boolean f(Context context) {
        return a.k(context, true);
    }

    public static boolean g() {
        if (a.e.get() != null) {
            return 1;
        }
        return 0;
    }

    private final Set<String> h() {
        final Set set = this.c;
        HashSet hashSet = new HashSet(this.c);
        return hashSet;
        synchronized (set) {
            set = this.c;
            hashSet = new HashSet(this.c);
            return hashSet;
        }
    }

    private final void i(Set<String> set) {
        java.io.File file;
        f.c.a.f.a.d.f fVar;
        Iterator obj3 = set.iterator();
        for (String next2 : obj3) {
            f.l(this.a.g(next2));
        }
        this.b.b();
    }

    private final void j(Context context, boolean z2) {
        Object obj;
        Object nVar;
        f.c.a.f.a.d.q qVar;
        Set empty;
        z str;
        Object arrayList;
        HashSet hashSet;
        Iterator iterator;
        int size;
        java.lang.ClassLoader stringBuilder;
        Object rVar;
        boolean contains;
        Iterator stringBuilder3;
        String str2;
        boolean next;
        int zipFile;
        Object stringBuilder2;
        synchronized (this) {
            this.a.k();
            try {
                String[] splitNames = packageInfo.splitNames;
                if (splitNames == null) {
                } else {
                }
                arrayList = new ArrayList();
                arrayList = Arrays.asList(splitNames);
                Set set = this.a.j();
                HashSet hashSet4 = new HashSet();
                rVar = set.iterator();
                while (rVar.hasNext()) {
                    str2 = (t)rVar.next().b();
                    if (!arrayList.contains(str2)) {
                    } else {
                    }
                    hashSet4.add(str2);
                    rVar.remove();
                    if (this.b.a().contains(s0.b(str2))) {
                    }
                }
                str2 = (t)rVar.next().b();
                if (!arrayList.contains(str2)) {
                } else {
                }
                if (empty.contains(s0.b(str2))) {
                }
                hashSet4.add(str2);
                rVar.remove();
                if (z2) {
                } else {
                }
                i(hashSet4);
                if (!hashSet4.isEmpty()) {
                }
                rVar = new r(this, hashSet4);
                e.a().execute(rVar);
                HashSet hashSet3 = new HashSet();
                iterator = set.iterator();
                while (iterator.hasNext()) {
                    rVar = (t)iterator.next().b();
                    if (!s0.f(rVar)) {
                    }
                    hashSet3.add(rVar);
                }
                rVar = (t)iterator.next().b();
                if (!s0.f(rVar)) {
                }
                hashSet3.add(rVar);
                Iterator iterator3 = arrayList.iterator();
                while (iterator3.hasNext()) {
                    iterator = iterator3.next();
                    if (!s0.f((String)iterator)) {
                    }
                    hashSet3.add(iterator);
                }
                iterator = iterator3.next();
                if (!s0.f((String)iterator)) {
                }
                hashSet3.add(iterator);
                hashSet = new HashSet(set.size());
                Iterator iterator2 = set.iterator();
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            } catch (Throwable th1) {
            }
            size = iterator2.next();
            if (!s0.e((t)size.b())) {
                try {
                    if (hashSet3.contains(s0.b(size.b()))) {
                    }
                    hashSet.add(size);
                    nVar = new n(this.a);
                    str = b0.a();
                    stringBuilder = context.getClassLoader();
                    if (z2) {
                    } else {
                    }
                    str.b(stringBuilder, nVar.c());
                    contains = hashSet.iterator();
                    while (contains.hasNext()) {
                        next = nVar.b((t)contains.next());
                        if (!next) {
                        } else {
                        }
                        str.b(stringBuilder, next);
                        contains.remove();
                    }
                    next = nVar.b((t)contains.next());
                    if (!next) {
                    } else {
                    }
                    contains.remove();
                    str.b(stringBuilder, next);
                    HashSet hashSet2 = new HashSet();
                    stringBuilder3 = hashSet.iterator();
                    while (stringBuilder3.hasNext()) {
                        Object next10 = stringBuilder3.next();
                        zipFile = new ZipFile((t)next10.a());
                        zipFile.close();
                        if (zipFile.getEntry("classes.dex") != null) {
                        } else {
                        }
                        hashSet2.add(next10.a());
                        if (str.a(stringBuilder, this.a.a(next10.b()), next10.a(), z2)) {
                        } else {
                        }
                        String valueOf = String.valueOf(next10.a());
                        stringBuilder2 = new StringBuilder(length3 += 24);
                        stringBuilder2.append("split was not installed ");
                        stringBuilder2.append(valueOf);
                        Log.w("SplitCompat", stringBuilder2.toString());
                    }
                    next10 = stringBuilder3.next();
                    zipFile = new ZipFile((t)next10.a());
                    zipFile.close();
                    if (zipFile.getEntry("classes.dex") != null) {
                    } else {
                    }
                    if (str.a(stringBuilder, this.a.a(next10.b()), next10.a(), z2)) {
                    } else {
                    }
                    valueOf = String.valueOf(next10.a());
                    stringBuilder2 = new StringBuilder(length3 += 24);
                    stringBuilder2.append("split was not installed ");
                    stringBuilder2.append(valueOf);
                    Log.w("SplitCompat", stringBuilder2.toString());
                    hashSet2.add(next10.a());
                    zipFile = 0;
                    if (zipFile == null) {
                    } else {
                    }
                    zipFile.close();
                    throw context;
                    this.d.a(context, hashSet2);
                    HashSet obj9 = new HashSet();
                    Iterator obj10 = hashSet.iterator();
                } catch (java.io.IOException ioException) {
                } catch (Throwable th1) {
                }
            } else {
            }
        }
    }

    private static boolean k(Context context, boolean z2) {
        boolean compareAndSet;
        int pVar;
        Context context2;
        Executor executor;
        y yVar;
        f.c.a.f.a.d.f fVar;
        f.c.a.f.a.d.s sVar;
        int i;
        w wVar;
        if (a.l()) {
            return 0;
        }
        AtomicReference atomicReference = a.e;
        a aVar = new a(context);
        Object obj = atomicReference.get();
        if (atomicReference.compareAndSet(0, aVar)) {
            u uVar = new u();
            yVar = new y(context, obj.a, uVar);
            sVar = new s();
            super(context, e.a(), yVar, obj.a, sVar, 0);
            o0.zza.zzb(wVar);
            o oVar = new o((a)obj);
            r0.b(oVar);
            pVar = new p(context);
            e.a().execute(pVar);
        }
        obj.j(context, z2);
        return 1;
    }

    private static boolean l() {
        if (Build.VERSION.SDK_INT < 21) {
            return 1;
        }
        return 0;
    }
}
