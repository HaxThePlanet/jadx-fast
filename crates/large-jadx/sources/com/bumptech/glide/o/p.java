package com.bumptech.glide.o;

import android.app.Activity;
import android.app.Fragment;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.bumptech.glide.c;
import com.bumptech.glide.f;
import com.bumptech.glide.k;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import d.e.a;
import d.e.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class p implements Handler.Callback {

    private static final com.bumptech.glide.o.p.b B;
    private final com.bumptech.glide.o.k A;
    private volatile k a;
    final Map<FragmentManager, com.bumptech.glide.o.o> b;
    final Map<n, com.bumptech.glide.o.t> c;
    private final Handler v;
    private final com.bumptech.glide.o.p.b w;
    private final a<View, Fragment> x;
    private final a<View, Fragment> y;
    private final Bundle z;

    public interface b {
        public abstract k a(c c, com.bumptech.glide.o.l l2, com.bumptech.glide.o.q q3, Context context4);
    }

    class a implements com.bumptech.glide.o.p.b {
        @Override // com.bumptech.glide.o.p$b
        public k a(c c, com.bumptech.glide.o.l l2, com.bumptech.glide.o.q q3, Context context4) {
            k kVar = new k(c, l2, q3, context4);
            return kVar;
        }
    }
    static {
        p.a aVar = new p.a();
        p.B = aVar;
    }

    public p(com.bumptech.glide.o.p.b p$b, f f2) {
        com.bumptech.glide.o.p.b obj2;
        super();
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        HashMap hashMap2 = new HashMap();
        this.c = hashMap2;
        a aVar = new a();
        this.x = aVar;
        a aVar2 = new a();
        this.y = aVar2;
        Bundle bundle = new Bundle();
        this.z = bundle;
        if (b != null) {
        } else {
            obj2 = p.B;
        }
        this.w = obj2;
        obj2 = new Handler(Looper.getMainLooper(), this);
        this.v = obj2;
        this.A = p.b(f2);
    }

    private static void a(Activity activity) {
        boolean obj2;
        if (Build.VERSION.SDK_INT >= 17) {
            if (activity.isDestroyed()) {
            } else {
            }
            obj2 = new IllegalArgumentException("You cannot start a load for a destroyed activity");
            throw obj2;
        }
    }

    private static com.bumptech.glide.o.k b(f f) {
        boolean z;
        Object obj1;
        if (r.h) {
            if (!r.g) {
            } else {
                if (f.a(d.e.class)) {
                    obj1 = new i();
                } else {
                    obj1 = new j();
                }
            }
            return obj1;
        }
        obj1 = new g();
        return obj1;
    }

    private static Activity c(Context context) {
        if (context instanceof Activity != null) {
            return (Activity)context;
        }
        if (context instanceof ContextWrapper) {
            return p.c((ContextWrapper)context.getBaseContext());
        }
        return null;
    }

    @Deprecated
    private void d(FragmentManager fragmentManager, a<View, Fragment> a2) {
        int childFragmentManager;
        int view;
        Object obj3;
        if (Build.VERSION.SDK_INT >= 26) {
            obj3 = fragmentManager.getFragments().iterator();
            while (obj3.hasNext()) {
                childFragmentManager = obj3.next();
                if ((Fragment)childFragmentManager.getView() != 0) {
                }
                a2.put(childFragmentManager.getView(), childFragmentManager);
                d(childFragmentManager.getChildFragmentManager(), a2);
            }
        } else {
            e(fragmentManager, a2);
        }
    }

    @Deprecated
    private void e(FragmentManager fragmentManager, a<View, Fragment> a2) {
        int i2;
        Object childFragmentManager;
        View sDK_INT;
        int i;
        String str;
        i2 = 0;
        str = "key";
        this.z.putInt(str, i2);
        int i3 = 0;
        childFragmentManager = fragmentManager.getFragment(this.z, str);
        while (childFragmentManager == null) {
            a2.put(childFragmentManager.getView(), childFragmentManager);
            if (childFragmentManager.getView() != null && Build.VERSION.SDK_INT >= 17) {
            }
            i2 = i;
            str = "key";
            this.z.putInt(str, i2);
            i3 = 0;
            childFragmentManager = fragmentManager.getFragment(this.z, str);
            a2.put(childFragmentManager.getView(), childFragmentManager);
            if (Build.VERSION.SDK_INT >= 17) {
            }
            d(childFragmentManager.getChildFragmentManager(), a2);
        }
    }

    private static void f(Collection<Fragment> collection, Map<View, Fragment> map2) {
        Object next;
        View view;
        if (collection == null) {
        }
        final Iterator obj2 = collection.iterator();
        while (obj2.hasNext()) {
            next = obj2.next();
            if ((Fragment)next != null) {
            }
            if ((Fragment)next.getView() == null) {
            } else {
            }
            map2.put(next.getView(), next);
            p.f(next.getChildFragmentManager().v0(), map2);
        }
    }

    @Deprecated
    private Fragment g(View view, Activity activity2) {
        int i;
        a equals;
        Object obj3;
        this.y.clear();
        d(activity2.getFragmentManager(), this.y);
        i = 0;
        while (!obj3.equals(activity2.findViewById(16908290))) {
            if ((Fragment)this.y.get(obj3) != 0) {
                break;
            } else {
            }
            if (parent instanceof View != null) {
                break;
            }
            obj3 = obj3.getParent();
        }
        this.y.clear();
        return i;
    }

    private Fragment h(View view, e e2) {
        int i;
        a equals;
        Object obj3;
        this.x.clear();
        p.f(e2.getSupportFragmentManager().v0(), this.x);
        i = 0;
        while (!obj3.equals(e2.findViewById(16908290))) {
            if ((Fragment)this.x.get(obj3) != 0) {
                break;
            } else {
            }
            if (parent instanceof View != null) {
                break;
            }
            obj3 = obj3.getParent();
        }
        this.x.clear();
        return i;
    }

    @Deprecated
    private k i(Context context, FragmentManager fragmentManager2, Fragment fragment3, boolean z4) {
        com.bumptech.glide.o.p.b bVar;
        com.bumptech.glide.o.a aVar;
        com.bumptech.glide.o.q qVar;
        k obj6;
        final com.bumptech.glide.o.o obj5 = r(fragmentManager2, fragment3);
        obj6 = this.w.a(c.c(context), obj5.c(), obj5.f(), context);
        if (obj5.e() == null && z4) {
            obj6 = this.w.a(c.c(context), obj5.c(), obj5.f(), context);
            if (z4) {
                obj6.onStart();
            }
            obj5.k(obj6);
        }
        return obj6;
    }

    private k p(Context context) {
        Object kVar;
        com.bumptech.glide.o.p.b bVar2;
        com.bumptech.glide.o.b bVar;
        com.bumptech.glide.o.h hVar;
        Object obj5;
        if (this.a == null && this.a == null) {
            synchronized (this) {
                bVar = new b();
                hVar = new h();
                this.a = this.w.a(c.c(context.getApplicationContext()), bVar, hVar, context.getApplicationContext());
            }
        }
        try {
            return this.a;
        }
    }

    private com.bumptech.glide.o.o r(FragmentManager fragmentManager, Fragment fragment2) {
        String str;
        Object obj;
        Fragment fragmentByTag;
        Object obj3;
        Object obj4;
        str = "com.bumptech.glide.manager";
        if ((o)this.b.get(fragmentManager) == null && (o)fragmentManager.findFragmentByTag(str) == null) {
            str = "com.bumptech.glide.manager";
            if ((o)fragmentManager.findFragmentByTag(str) == null) {
                fragmentByTag = new o();
                fragmentByTag.j(fragment2);
                this.b.put(fragmentManager, fragmentByTag);
                fragmentManager.beginTransaction().add(fragmentByTag, str).commitAllowingStateLoss();
                this.v.obtainMessage(1, fragmentManager).sendToTarget();
            }
            obj = fragmentByTag;
        }
        return obj;
    }

    private com.bumptech.glide.o.t t(n n, Fragment fragment2) {
        String str;
        Object obj;
        Fragment tVar;
        Object obj3;
        Object obj4;
        str = "com.bumptech.glide.manager";
        if ((t)this.c.get(n) == null && (t)n.k0(str) == null) {
            str = "com.bumptech.glide.manager";
            if ((t)n.k0(str) == null) {
                tVar = new t();
                tVar.L1(fragment2);
                this.c.put(n, tVar);
                obj4 = n.n();
                obj4.d(tVar, str);
                obj4.h();
                this.v.obtainMessage(2, n).sendToTarget();
            }
            obj = tVar;
        }
        return obj;
    }

    private static boolean u(Context context) {
        int obj0;
        obj0 = p.c(context);
        if (obj0 != null) {
            if (!obj0.isFinishing()) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    private k v(Context context, n n2, Fragment fragment3, boolean z4) {
        com.bumptech.glide.o.p.b bVar;
        com.bumptech.glide.o.a aVar;
        com.bumptech.glide.o.q qVar;
        k obj6;
        final com.bumptech.glide.o.t obj5 = t(n2, fragment3);
        obj6 = this.w.a(c.c(context), obj5.D1(), obj5.G1(), context);
        if (obj5.F1() == null && z4) {
            obj6 = this.w.a(c.c(context), obj5.D1(), obj5.G1(), context);
            if (z4) {
                obj6.onStart();
            }
            obj5.M1(obj6);
        }
        return obj6;
    }

    private boolean w(FragmentManager fragmentManager, boolean z2) {
        k kVar;
        Object obj6;
        boolean obj7;
        Object obj = this.b.get(fragmentManager);
        String str = "com.bumptech.glide.manager";
        final Fragment fragmentByTag = fragmentManager.findFragmentByTag(str);
        final int i2 = 1;
        if ((o)fragmentByTag == (o)obj) {
            return i2;
        }
        if ((o)fragmentByTag != null) {
            if ((o)fragmentByTag.e() != null) {
            } else {
            }
            obj7 = new StringBuilder();
            obj7.append("We've added two fragments with requests! Old: ");
            obj7.append(fragmentByTag);
            obj7.append(" New: ");
            obj7.append((o)obj);
            obj6 = new IllegalStateException(obj7.toString());
            throw obj6;
        }
        String str4 = "RMRetriever";
        if (!z2) {
            if (fragmentManager.isDestroyed()) {
            } else {
                obj7 = fragmentManager.beginTransaction().add(obj, str);
                if (fragmentByTag != null) {
                    obj7.remove(fragmentByTag);
                }
                obj7.commitAllowingStateLoss();
                int i = 0;
                this.v.obtainMessage(i2, i2, i, fragmentManager).sendToTarget();
                if (Log.isLoggable(str4, 3)) {
                    Log.d(str4, "We failed to add our Fragment the first time around, trying again...");
                }
            }
            return i;
        }
        if (Log.isLoggable(str4, 5)) {
            if (fragmentManager.isDestroyed()) {
                Log.w(str4, "Parent was destroyed before our Fragment could be added");
            } else {
                Log.w(str4, "Tried adding Fragment twice and failed twice, giving up!");
            }
        }
        obj.c().c();
        return i2;
    }

    private boolean x(n n, boolean z2) {
        k kVar;
        boolean obj6;
        boolean obj7;
        Object obj = this.c.get(n);
        String str = "com.bumptech.glide.manager";
        final Fragment fragment = n.k0(str);
        final int i3 = 1;
        if ((t)fragment == (t)obj) {
            return i3;
        }
        if ((t)fragment != null) {
            if ((t)fragment.F1() != null) {
            } else {
            }
            obj7 = new StringBuilder();
            obj7.append("We've added two fragments with requests! Old: ");
            obj7.append(fragment);
            obj7.append(" New: ");
            obj7.append((t)obj);
            obj6 = new IllegalStateException(obj7.toString());
            throw obj6;
        }
        String str4 = "RMRetriever";
        if (!z2) {
            if (n.H0()) {
            } else {
                obj7 = n.n();
                obj7.d(obj, str);
                if (fragment != null) {
                    obj7.n(fragment);
                }
                obj7.j();
                int i2 = 0;
                this.v.obtainMessage(2, i3, i2, n).sendToTarget();
                if (Log.isLoggable(str4, 3)) {
                    Log.d(str4, "We failed to add our Fragment the first time around, trying again...");
                }
            }
            return i2;
        }
        if (n.H0()) {
            if (Log.isLoggable(str4, 5)) {
                Log.w(str4, "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
            }
        } else {
            if (Log.isLoggable(str4, 6)) {
                Log.e(str4, "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
            }
        }
        obj.D1().c();
        return i3;
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        int i3;
        boolean stringBuilder;
        int str;
        int i2;
        int remove;
        int i;
        Object obj7;
        str = 0;
        i2 = 1;
        i3 = message.arg1 == i2 ? i2 : str;
        int what = message.what;
        if (what != i2) {
            if (what != 2) {
                i2 = str;
                obj7 = remove;
            } else {
                obj7 = message.obj;
                if (x((n)obj7, i3)) {
                    remove = this.c.remove(obj7);
                    str = i2;
                } else {
                }
            }
        } else {
            obj7 = message.obj;
            if (w((FragmentManager)obj7, i3)) {
                remove = this.b.remove(obj7);
            } else {
            }
        }
        String str2 = "RMRetriever";
        if (Log.isLoggable(str2, 5) && str != null && remove == 0) {
            if (str != null) {
                if (remove == 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to remove expected request manager fragment, manager: ");
                    stringBuilder.append(obj7);
                    Log.w(str2, stringBuilder.toString());
                }
            }
        }
        return i2;
    }

    @Override // android.os.Handler$Callback
    public k j(Activity activity) {
        if (l.q()) {
            return l(activity.getApplicationContext());
        }
        if (activity instanceof e) {
            return o((e)activity);
        }
        p.a(activity);
        this.A.a(activity);
        return i(activity, activity.getFragmentManager(), 0, p.u(activity));
    }

    @Deprecated
    public k k(Fragment fragment) {
        boolean sDK_INT;
        Object activity2;
        int activity;
        if (fragment.getActivity() == null) {
        } else {
            if (!l.q()) {
                if (Build.VERSION.SDK_INT < 17) {
                } else {
                    if (fragment.getActivity() != null) {
                        this.A.a(fragment.getActivity());
                    }
                }
                return i(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return l(fragment.getActivity().getApplicationContext());
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        throw obj4;
    }

    @Override // android.os.Handler$Callback
    public k l(Context context) {
        boolean z;
        Context applicationContext;
        if (context == null) {
        } else {
            if (l.r() && !context instanceof Application && context instanceof e) {
                if (!context instanceof Application) {
                    if (context instanceof e) {
                        return o((e)context);
                    }
                    if (context instanceof Activity != null) {
                        return j((Activity)context);
                    }
                    z = context;
                    if (context instanceof ContextWrapper && (ContextWrapper)z.getBaseContext().getApplicationContext() != null) {
                        z = context;
                        if ((ContextWrapper)z.getBaseContext().getApplicationContext() != null) {
                            return l(z.getBaseContext());
                        }
                    }
                }
            }
            return p(context);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("You cannot start a load on a null Context");
        throw obj3;
    }

    @Override // android.os.Handler$Callback
    public k m(View view) {
        k obj3;
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
            obj3 = h(view, (e)activity);
            if (obj3 != null) {
                obj3 = n(obj3);
            } else {
                obj3 = o(activity);
            }
            return obj3;
        }
        obj3 = g(view, activity);
        if (obj3 == null) {
            return j(activity);
        }
        return k(obj3);
    }

    @Override // android.os.Handler$Callback
    public k n(Fragment fragment) {
        Object activity;
        Object activity2;
        k.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (l.q()) {
            return l(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.A.a(fragment.getActivity());
        }
        return v(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @Override // android.os.Handler$Callback
    public k o(e e) {
        if (l.q()) {
            return l(e.getApplicationContext());
        }
        p.a(e);
        this.A.a(e);
        return v(e, e.getSupportFragmentManager(), 0, p.u(e));
    }

    @Deprecated
    com.bumptech.glide.o.o q(Activity activity) {
        return r(activity.getFragmentManager(), 0);
    }

    @Override // android.os.Handler$Callback
    com.bumptech.glide.o.t s(n n) {
        return t(n, 0);
    }
}
