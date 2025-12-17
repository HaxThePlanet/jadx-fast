package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.a;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import f.c.a.f.a.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
final class i implements com.google.android.play.core.splitinstall.a {

    private final com.google.android.play.core.splitinstall.x a;
    private final com.google.android.play.core.splitinstall.x0 b;
    private final com.google.android.play.core.splitinstall.s0 c;
    private final com.google.android.play.core.splitinstall.z d;
    private final Handler e;
    i(com.google.android.play.core.splitinstall.x x, com.google.android.play.core.splitinstall.x0 x02, com.google.android.play.core.splitinstall.s0 s03, com.google.android.play.core.splitinstall.z z4) {
        super();
        Handler handler = new Handler(Looper.getMainLooper());
        this.e = handler;
        this.a = x;
        this.b = x02;
        this.c = s03;
        this.d = z4;
    }

    static com.google.android.play.core.splitinstall.x0 g(com.google.android.play.core.splitinstall.i i) {
        return i.b;
    }

    static List h(List list) {
        return i.i(list);
    }

    private static List<String> i(List<Locale> list) {
        int languageTag;
        int sDK_INT;
        int i;
        ArrayList arrayList = new ArrayList(list.size());
        final Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            if (Build.VERSION.SDK_INT >= 21) {
            }
            arrayList.add((Locale)obj4.next().toLanguageTag());
        }
        return arrayList;
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final boolean a(com.google.android.play.core.splitinstall.d d, Activity activity2, int i3) {
        z0 z0Var = new z0(this, activity2);
        return f(d, z0Var, i3);
    }

    public final d<Integer> b(com.google.android.play.core.splitinstall.c c) {
        boolean sDK_INT2;
        boolean sDK_INT;
        int i;
        Set set;
        HashSet hashSet;
        boolean language;
        i = 21;
        if (!c.a().isEmpty() && Build.VERSION.SDK_INT >= i) {
            if (Build.VERSION.SDK_INT >= i) {
            }
            SplitInstallException obj6 = new SplitInstallException(-5);
            return f.b(obj6);
        }
        set = this.c.d();
        if (set == null) {
            if (this.c.c().containsAll(c.b())) {
                if (Build.VERSION.SDK_INT >= i) {
                    if (!Collections.disjoint(c.b(), this.d.a())) {
                    }
                }
                y0 y0Var = new y0(this, c);
                this.e.post(y0Var);
                return f.c(0);
            }
        } else {
            hashSet = new HashSet();
            Iterator iterator = c.a().iterator();
            for (Locale next : iterator) {
                hashSet.add(next.getLanguage());
            }
            if (set.containsAll(hashSet) && this.c.c().containsAll(c.b()) && Build.VERSION.SDK_INT >= i && !Collections.disjoint(c.b(), this.d.a())) {
            }
        }
        this.d.c(c.b());
        return this.a.c(c.b(), i.i(c.a()));
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void c(com.google.android.play.core.splitinstall.e e) {
        this.b.e(e);
        return;
        synchronized (this) {
            this.b.e(e);
        }
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void d(com.google.android.play.core.splitinstall.e e) {
        this.b.c(e);
        return;
        synchronized (this) {
            this.b.c(e);
        }
    }

    public final Set<String> e() {
        Set emptySet;
        if (this.c.d() == null) {
            emptySet = Collections.emptySet();
        }
        return emptySet;
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final boolean f(com.google.android.play.core.splitinstall.d d, a a2, int i3) {
        int i;
        if (d.i() == 8 && d.g() == null) {
            if (d.g() == null) {
            }
            a2.a(d.g().getIntentSender(), i3, 0, 0, 0, 0, 0);
            return 1;
        }
        return 0;
    }
}
