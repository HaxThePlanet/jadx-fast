package com.bumptech.glide.o;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.bumptech.glide.c;
import com.bumptech.glide.f;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.t.l;
import d.e.a;
import d.e.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class p implements Handler.Callback {

    private static final p.b B = new p$a();
    private final k A;
    private volatile com.bumptech.glide.k a;
    final Map<FragmentManager, o> b = new HashMap<>();
    final Map<n, t> c = new HashMap<>();
    private final Handler v = new Handler();
    private final p.b w;
    private final a<View, androidx.fragment.app.Fragment> x = new a<>();
    private final a<View, android.app.Fragment> y = new a<>();
    private final Bundle z = new Bundle();

    public interface b {
        com.bumptech.glide.k a(c cVar, l lVar, q qVar, Context context);
    }

    class a implements p.b {
        a() {
            super();
        }

        public com.bumptech.glide.k a(c cVar, l lVar, q qVar, Context context) {
            return new k(cVar, lVar, qVar, context);
        }
    }

    public p(p.b bVar, f fVar) {
        com.bumptech.glide.o.p.b bVar2;
        super();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a aVar = new a();
        a aVar2 = new a();
        Bundle bundle = new Bundle();
        if (bVar == null) {
            bVar2 = p.B;
        }
        this.w = bVar2;
        Handler handler = new Handler(Looper.getMainLooper(), this);
        this.A = p.b(fVar);
    }

    private static void a(Activity activity) {
    }

    private static k b(f fVar) {
        com.bumptech.glide.o.j jVar;
        return new g();
    }

    private static Activity c(Context context) {
        if (context instanceof Activity) {
            return context;
        }
        if (context instanceof ContextWrapper) {
            return p.c(context.getBaseContext());
        }
        return null;
    }

    @Deprecated
    private void d(FragmentManager fragmentManager, a<View, android.app.Fragment> aVar) {
        int i = 26;
        i = 26;
        if (Build.VERSION.SDK_INT >= 26) {
            Iterator it = fragmentManager.getFragments().iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
        } else {
            e(fragmentManager, aVar);
        }
    }

    @Deprecated
    private void e(FragmentManager fragmentManager, a<View, android.app.Fragment> aVar) {
        int i = 0;
        View view;
        String str;
        i = 0;
        while (/* condition */) {
            try {
                android.app.Fragment fragment = fragmentManager.getFragment(this.z, str);
            } catch (Exception unused) {
                return;
            }
        }
    }

    private static void f(Collection<androidx.fragment.app.Fragment> collection, Map<View, androidx.fragment.app.Fragment> map) {
        View view;
        if (collection == null) {
            return;
        }
        final Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }

    @Deprecated
    private android.app.Fragment g(View view, Activity activity) {
        int i = 0;
        android.view.ViewParent parent;
        this.y.clear();
        d(activity.getFragmentManager(), this.y);
        i = 0;
        while (!parent.equals(activity.findViewById(16908290))) {
            if ((Fragment)this.y.get(parent) != null) {
                break;
            }
        }
        this.y.clear();
        return i;
    }

    private androidx.fragment.app.Fragment h(View view, e eVar) {
        int i = 0;
        android.view.ViewParent parent;
        this.x.clear();
        p.f(eVar.getSupportFragmentManager().v0(), this.x);
        i = 0;
        while (!parent.equals(eVar.findViewById(16908290))) {
            if ((Fragment)this.x.get(parent) != null) {
                break;
            }
        }
        this.x.clear();
        return i;
    }

    @Deprecated
    private com.bumptech.glide.k i(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        com.bumptech.glide.k kVar;
        final com.bumptech.glide.o.o oVar = r(fragmentManager, fragment);
        if (oVar.e() == null) {
            kVar = this.w.a(c.c(context), oVar.c(), oVar.f(), context);
            if (z) {
                kVar.onStart();
            }
            oVar.k(kVar);
        }
        return kVar;
    }

    private com.bumptech.glide.k p(Context context) {
        com.bumptech.glide.k kVar;
        com.bumptech.glide.o.p.b bVar;
        com.bumptech.glide.o.b bVar2;
        com.bumptech.glide.o.h hVar;
        com.bumptech.glide.k kVar2;
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = this.w.a(c.c(context.getApplicationContext()), new b(), new h(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                }
            }
        }
        return this.a;
    }

    private o r(FragmentManager fragmentManager, android.app.Fragment fragment) {
        Object value;
        android.app.Fragment fragmentByTag;
        Message message;
        Handler handler;
        if ((o)this.b.get(fragmentManager) == null) {
            str = "com.bumptech.glide.manager";
            if ((o)fragmentManager.findFragmentByTag(str) == null) {
                com.bumptech.glide.o.o oVar = new o();
                oVar.j(fragment);
                this.b.put(fragmentManager, oVar);
                fragmentManager.beginTransaction().add(oVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.v.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        return value;
    }

    private t t(n nVar, androidx.fragment.app.Fragment fragment) {
        Object value;
        Message message;
        Handler handler;
        if ((t)this.c.get(nVar) == null) {
            str = "com.bumptech.glide.manager";
            if ((t)nVar.k0(str) == null) {
                com.bumptech.glide.o.t tVar = new t();
                tVar.L1(fragment);
                this.c.put(nVar, tVar);
                w wVar = nVar.n();
                wVar.d(tVar, "com.bumptech.glide.manager");
                wVar.h();
                this.v.obtainMessage(2, nVar).sendToTarget();
            }
        }
        return value;
    }

    private static boolean u(Context context) {
        boolean z = false;
        Activity activity = p.c(context);
        if (activity == null || !activity.isFinishing()) {
            int i2 = 1;
        }
        return z;
    }

    private com.bumptech.glide.k v(Context context, n nVar, androidx.fragment.app.Fragment fragment, boolean z) {
        com.bumptech.glide.k kVar;
        final com.bumptech.glide.o.t tVar = t(nVar, fragment);
        if (tVar.F1() == null) {
            kVar = this.w.a(c.c(context), tVar.D1(), tVar.G1(), context);
            if (z) {
                kVar.onStart();
            }
            tVar.M1(kVar);
        }
        return kVar;
    }

    private boolean w(FragmentManager fragmentManager, boolean z) {
        Object value = this.b.get(fragmentManager);
        String str2 = "com.bumptech.glide.manager";
        final android.app.Fragment fragmentByTag = fragmentManager.findFragmentByTag(str2);
        final int i2 = 1;
        if (fragmentByTag == value) {
            return true;
        }
        if (fragmentByTag != null) {
            if (fragmentByTag.e() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "We've added two fragments with requests! Old: ";
                String str4 = " New: ";
                z = str3 + fragmentByTag + str4 + value;
                throw new IllegalStateException(z);
            }
        }
        String str5 = "RMRetriever";
        if (Log.isLoggable(str5, 5) && fragmentManager.isDestroyed()) {
            str = "Parent was destroyed before our Fragment could be added";
            Log.w(str5, str);
        }
        value.c().c();
        return true;
    }

    private boolean x(n nVar, boolean z) {
        Object value = this.c.get(nVar);
        String str = "com.bumptech.glide.manager";
        final androidx.fragment.app.Fragment fragment = nVar.k0(str);
        final int i3 = 1;
        if (fragment == value) {
            return true;
        }
        if (fragment != null) {
            if (fragment.F1() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "We've added two fragments with requests! Old: ";
                String str3 = " New: ";
                z = str2 + fragment + str3 + value;
                throw new IllegalStateException(z);
            }
        }
        String str4 = "RMRetriever";
        if (!z) {
            if (!(nVar.H0())) {
                w wVar = nVar.n();
                wVar.d(value, "com.bumptech.glide.manager");
                if (fragment != null) {
                    wVar.n(fragment);
                }
                wVar.j();
                int i2 = 0;
                this.v.obtainMessage(2, i3, i2, nVar).sendToTarget();
                if (Log.isLoggable(str4, 3)) {
                    Log.d(str4, "We failed to add our Fragment the first time around, trying again...");
                }
            }
            return false;
        }
        if (nVar.H0()) {
            if (Log.isLoggable(str4, 5)) {
                Log.w(str4, "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
            }
        } else {
            if (Log.isLoggable(str4, 6)) {
                Log.e(str4, "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
            }
        }
        value.D1().c();
        return true;
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        boolean z;
        Map map;
        int i = 0;
        boolean z2 = true;
        int i2 = 0;
        Object remove;
        int i3 = 2;
        String str;
        Object obj2;
        i = 0;
        i = 1;
        int r0 = i;
        i2 = 0;
        if (message.what != i) {
            i3 = 2;
            if (message.what != 2) {
            } else {
                if (x(obj2, z)) {
                    remove = this.c.remove(obj2);
                }
            }
        } else {
            if (w(obj2, z)) {
                remove = this.b.remove(obj2);
            }
        }
        String str3 = "RMRetriever";
        if (Log.isLoggable(str3, 5) && i != 0 && i2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Failed to remove expected request manager fragment, manager: ";
            str = str2 + str;
            Log.w(str3, str);
        }
        return z2;
    }

    public com.bumptech.glide.k j(Activity activity) {
        if (l.q()) {
            return l(activity.getApplicationContext());
        }
        if (activity instanceof e) {
            return o(activity);
        }
        p.a(activity);
        this.A.a(activity);
        return i(activity, activity.getFragmentManager(), null, p.u(activity));
    }

    @Deprecated
    public com.bumptech.glide.k k(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else {
            if (!l.q()) {
                int i = 17;
                if (Build.VERSION.SDK_INT >= 17) {
                    if (fragment.getActivity() != null) {
                        this.A.a(fragment.getActivity());
                    }
                }
                return i(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return l(fragment.getActivity().getApplicationContext());
        }
    }

    public com.bumptech.glide.k l(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        } else {
            if (l.r()) {
                z = context instanceof Application;
                if (!(context instanceof Application)) {
                    if (context instanceof e) {
                        return o(context);
                    }
                    if (context instanceof Activity) {
                        return j(context);
                    }
                    z = context instanceof ContextWrapper;
                    if (context instanceof ContextWrapper) {
                        Object context2 = context;
                        if (context2.getBaseContext().getApplicationContext() != null) {
                            return l(context2.getBaseContext());
                        }
                    }
                }
            }
            return p(context);
        }
    }

    public com.bumptech.glide.k m(View view) {
        com.bumptech.glide.k kVar;
        if (l.q()) {
            return l(view.getContext().getApplicationContext());
        }
        k.d(view);
        k.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activity = p.c(view.getContext());
        if (activity == null) {
            return l(view.getContext().getApplicationContext());
        }
        if (activity instanceof e) {
            androidx.fragment.app.Fragment fragment2 = h(view, activity);
            if (fragment2 != null) {
                kVar = n(fragment2);
            } else {
                kVar = o(activity);
            }
            return kVar;
        }
        android.app.Fragment fragment = g(view, activity);
        if (fragment == null) {
            return j(activity);
        }
        return k(fragment);
    }

    public com.bumptech.glide.k n(androidx.fragment.app.Fragment fragment) {
        str = "You cannot start a load on a fragment before it is attached or after it is destroyed";
        k.e(fragment.getContext(), str);
        if (l.q()) {
            return l(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.A.a(fragment.getActivity());
        }
        return v(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public com.bumptech.glide.k o(e eVar) {
        if (l.q()) {
            return l(eVar.getApplicationContext());
        }
        p.a(eVar);
        this.A.a(eVar);
        return v(eVar, eVar.getSupportFragmentManager(), null, p.u(eVar));
    }

    @Deprecated
    o q(Activity activity) {
        return r(activity.getFragmentManager(), null);
    }

    t s(n nVar) {
        return t(nVar, null);
    }
}
