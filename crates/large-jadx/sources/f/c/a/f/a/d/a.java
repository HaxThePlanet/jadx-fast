package f.c.a.f.a.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.play.core.internal.b0;
import com.google.android.play.core.internal.u;
import com.google.android.play.core.internal.w;
import com.google.android.play.core.internal.y;
import com.google.android.play.core.internal.zzbt;
import com.google.android.play.core.splitinstall.o0;
import com.google.android.play.core.splitinstall.r0;
import com.google.android.play.core.splitinstall.s0;
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

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
public class a {

    private static final AtomicReference<a> e = new AtomicReference<>(0);
    private final f a = new f();
    private final com.google.android.play.core.splitinstall.z b = new z();
    private final Set<String> c = new HashSet<>();
    private final b d = new b();

    private a(Context context) throws zzbt {
        super();
        HashSet hashSet = new HashSet();
        try {
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new zzbt("Failed to initialize FileStorage", nameNotFound);
        }
        final f.c.a.f.a.d.b bVar = new b(new f(context));
        com.google.android.play.core.splitinstall.z zVar = new z(nameNotFound);
    }

    public static boolean a(Context context) {
        return a.k(context, false);
    }

    public static boolean b(Context context) {
        if (a.l()) {
            return false;
        }
        Object obj = a.e.get();
        if (obj == null && context.getApplicationContext() != null) {
            a.a(context.getApplicationContext());
            return a.a(context);
        }
        return obj.d.b(context, obj.h());
    }

    public static boolean f(Context context) {
        return a.k(context, true);
    }

    public static boolean g() {
        if (a.e.get() != null) {
            return true;
        }
        return false;
    }

    private final Set<String> h() {
        synchronized (set) {
            try {
                return new HashSet(this.c);
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private final void i(Set<String> set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            f.l(this.a.g((String)it.next()));
        }
        this.b.b();
    }

    private final synchronized void j(Context context, boolean z) {
        ArrayList arrayList;
        Iterator it;
        boolean hasNext;
        Iterator it2;
        boolean hasNext2;
        int i5;
        boolean contains;
        StringBuilder stringBuilder;
        if (z) {
            try {
                this.a.k();
                e.a().execute(new q(this));
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
            try {
                if (splitNames2 == null) {
                    arrayList = new ArrayList();
                } else {
                    List list = Arrays.asList(splitNames2);
                }
            } catch (java.io.IOException unused) {
            }
            try {
                Set set2 = this.a.j();
                HashSet hashSet4 = new HashSet();
                it = set2.iterator();
                while (it.hasNext()) {
                    String str = (t)it.next().b();
                    if (!arrayList.contains(str)) {
                        if (this.b.a().contains(s0.b(str))) {
                            hashSet4.add(str);
                            it.remove();
                        }
                    }
                }
                if (z) {
                    i(hashSet4);
                } else {
                    if (!hashSet4.isEmpty()) {
                        e.a().execute(new r(this, hashSet4));
                    }
                }
                HashSet hashSet3 = new HashSet();
                Iterator item = set2.iterator();
                while (item.hasNext()) {
                    Object obj4 = (t)item.next().b();
                    if (!s0.f(obj4)) {
                        hashSet3.add(obj4);
                    }
                }
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    item = it4.next();
                    if (!s0.f(item)) {
                        hashSet3.add(item);
                    }
                }
                HashSet hashSet = new HashSet(set2.size());
                Iterator it3 = set2.iterator();
                while (it3.hasNext()) {
                    Object item3 = it3.next();
                    if (!s0.e(item3.b())) {
                        if (hashSet3.contains(s0.b(item3.b()))) {
                            hashSet.add(item3);
                        }
                    }
                }
                f.c.a.f.a.d.n nVar = new n(this.a);
                com.google.android.play.core.internal.z zVar = b0.a();
                java.lang.ClassLoader classLoader = context.getClassLoader();
                if (z) {
                    zVar.b(classLoader, nVar.c());
                } else {
                    Iterator it5 = hashSet.iterator();
                    while (it5.hasNext()) {
                        Set set5 = nVar.b((t)it5.next());
                    }
                }
                HashSet hashSet2 = new HashSet();
                it2 = hashSet.iterator();
                Object item6 = it2.next();
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
            this.d.a(context, hashSet2);
            final HashSet hashSet5 = new HashSet();
            Iterator it6 = hashSet.iterator();
            while (it6.hasNext()) {
                Object item2 = it6.next();
            }
            try {
                this.c.addAll(hashSet5);
            } catch (Throwable th) {
            }
            return;
        }
    }

    private static boolean k(Context context, boolean z) {
        if (a.l()) {
            return false;
        }
        AtomicReference atomicReference = a.e;
        Object obj = null;
        Object obj2 = atomicReference.get();
        if (atomicReference.compareAndSet(obj, new a(context))) {
            byte[] bArr = null;
            w wVar = new w(context, e.a(), new y(context, obj2.a, new u()), obj2.a, new s(), bArr);
            o0.zza.zzb(wVar);
            r0.b(new o(obj2));
            e.a().execute(new p(context));
        }
        try {
            obj2.j(context, z);
        } catch (Exception e) {
            z = "SplitCompat";
            Log.e(z, "Error installing additional splits", e);
            return z3;
        }
        return true;
    }

    private static boolean l() {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        return false;
    }
}
