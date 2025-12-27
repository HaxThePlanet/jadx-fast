package com.bumptech.glide.o;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: RequestManagerFragment.java */
@Deprecated
/* loaded from: classes.dex */
public class o extends Fragment {

    private final a a;
    private final q b;
    private final Set<o> c;
    private k v;
    private o w;
    private Fragment x;

    private class a implements q {

        final /* synthetic */ o a;
        a() {
            this.a = oVar;
            super();
        }

        public Set<k> a() {
            Set set = this.a.b();
            final HashSet hashSet = new HashSet(set.size());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            return hashSet;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String object = super.toString();
            String str2 = "{fragment=";
            String str3 = "}";
            str = object + str2 + this.a + str3;
            return str;
        }
    }
    public o() {
        this(new a());
    }

    private void a(o oVar) {
        this.c.add(oVar);
    }

    private Fragment d() {
        Fragment parentFragment = null;
        if (Build.VERSION.SDK_INT >= 17) {
            parentFragment = getParentFragment();
        } else {
            int i = 0;
        }
        if (Build.VERSION.SDK_INT == null) {
        }
        return parentFragment;
    }

    private boolean g(Fragment fragment) {
        Fragment parentFragment;
        Fragment parentFragment3 = parentFragment.getParentFragment();
        while (parentFragment3 != null) {
            if (parentFragment3.equals(getParentFragment())) {
                return true;
            }
        }
        return false;
    }

    private void h(Activity activity) {
        l();
        com.bumptech.glide.o.o oVar = c.c(activity).k().q(activity);
        this.w = oVar;
        if (!equals(oVar)) {
            this.w.a(this);
        }
    }

    private void i(o oVar) {
        this.c.remove(oVar);
    }

    private void l() {
        if (this.w != null) {
            this.w.i(this);
            com.bumptech.glide.o.o oVar = null;
            this.w = oVar;
        }
    }

    @Override // android.app.Fragment
    Set<o> b() {
        if (equals(this.w)) {
            return Collections.unmodifiableSet(this.c);
        }
        if (this.w != null) {
            int i = 17;
            if (Build.VERSION.SDK_INT >= 17) {
                HashSet hashSet = new HashSet();
                Iterator it = this.w.b().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    @Override // android.app.Fragment
    a c() {
        return this.a;
    }

    @Override // android.app.Fragment
    public k e() {
        return this.v;
    }

    @Override // android.app.Fragment
    public q f() {
        return this.b;
    }

    @Override // android.app.Fragment
    void j(Fragment fragment) {
        this.x = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    @Override // android.app.Fragment
    public void k(k kVar) {
        this.v = kVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (java.lang.IllegalStateException ise) {
            int str = 5;
            String str2 = "RMFragment";
            str = Log.isLoggable(str2, str);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String fragment = super.toString();
        String str2 = "{parent=";
        Fragment fragment2 = d();
        String str3 = "}";
        str = fragment + str2 + fragment2 + str3;
        return str;
    }

    o(a aVar) {
        super();
        this.b = new o.a(this);
        this.c = new HashSet();
        this.a = aVar;
    }
}
