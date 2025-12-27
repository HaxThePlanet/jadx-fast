package com.bumptech.glide.o;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.n;
import com.bumptech.glide.c;
import com.bumptech.glide.k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: SupportRequestManagerFragment.java */
/* loaded from: classes.dex */
public class t extends Fragment {

    private final a a;
    private final q b;
    private final Set<t> c;
    private t v;
    private k w;
    private Fragment x;

    private class a implements q {

        final /* synthetic */ t a;
        a() {
            this.a = tVar;
            super();
        }

        public Set<k> a() {
            Set set = this.a.C1();
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
    public t() {
        this(new a());
    }

    private void B1(t tVar) {
        this.c.add(tVar);
    }

    private Fragment E1() {
        Fragment parentFragment;
        if (getParentFragment() == null) {
        }
        return parentFragment;
    }

    private static n H1(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
        }
        return fragment.getFragmentManager();
    }

    private boolean I1(Fragment fragment) {
        Fragment parentFragment;
        Fragment parentFragment2 = parentFragment.getParentFragment();
        while (parentFragment2 != null) {
            if (parentFragment2.equals(E1())) {
                return true;
            }
        }
        return false;
    }

    private void J1(Context context, n nVar) {
        N1();
        com.bumptech.glide.o.t tVar = c.c(context).k().s(nVar);
        this.v = tVar;
        if (!equals(tVar)) {
            this.v.B1(this);
        }
    }

    private void K1(t tVar) {
        this.c.remove(tVar);
    }

    private void N1() {
        if (this.v != null) {
            this.v.K1(this);
            com.bumptech.glide.o.t tVar = null;
            this.v = tVar;
        }
    }

    @Override // androidx.fragment.app.Fragment
    Set<t> C1() {
        if (this.v == null) {
            return Collections.emptySet();
        }
        if (equals(this.v)) {
            return Collections.unmodifiableSet(this.c);
        }
        HashSet hashSet = new HashSet();
        Iterator it = this.v.C1().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // androidx.fragment.app.Fragment
    a D1() {
        return this.a;
    }

    @Override // androidx.fragment.app.Fragment
    public k F1() {
        return this.w;
    }

    @Override // androidx.fragment.app.Fragment
    public q G1() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    void L1(Fragment fragment) {
        this.x = fragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void M1(k kVar) {
        this.w = kVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        n nVar = t.H1(this);
        int i = 5;
        final String str3 = "SupportRMFragment";
        if (nVar == null && Log.isLoggable(str3, 5)) {
            Log.w(str3, "Unable to register fragment with root, ancestor detached");
            return;
        }
        try {
            J1(getContext(), nVar);
        } catch (java.lang.IllegalStateException ise) {
            int str = Log.isLoggable(str2, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        N1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.x = null;
        N1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String fragment = super.toString();
        String str2 = "{parent=";
        Fragment fragment2 = E1();
        String str3 = "}";
        str = fragment + str2 + fragment2 + str3;
        return str;
    }

    public t(a aVar) {
        super();
        this.b = new t.a(this);
        this.c = new HashSet();
        this.a = aVar;
    }
}
