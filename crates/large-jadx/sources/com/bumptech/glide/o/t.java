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

/* loaded from: classes.dex */
public class t extends Fragment {

    private final com.bumptech.glide.o.a a;
    private final com.bumptech.glide.o.q b;
    private final Set<com.bumptech.glide.o.t> c;
    private com.bumptech.glide.o.t v;
    private k w;
    private Fragment x;

    private class a implements com.bumptech.glide.o.q {

        final com.bumptech.glide.o.t a;
        a(com.bumptech.glide.o.t t) {
            this.a = t;
            super();
        }

        public Set<k> a() {
            int size;
            k kVar;
            Set set = this.a.C1();
            HashSet hashSet = new HashSet(set.size());
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                size = iterator.next();
                if ((t)size.F1() != null) {
                }
                hashSet.add(size.F1());
            }
            return hashSet;
        }

        @Override // com.bumptech.glide.o.q
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("{fragment=");
            stringBuilder.append(this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
    public t() {
        a aVar = new a();
        super(aVar);
    }

    public t(com.bumptech.glide.o.a a) {
        super();
        t.a aVar = new t.a(this);
        this.b = aVar;
        HashSet hashSet = new HashSet();
        this.c = hashSet;
        this.a = a;
    }

    private void B1(com.bumptech.glide.o.t t) {
        this.c.add(t);
    }

    private Fragment E1() {
        Fragment parentFragment;
        if (getParentFragment() != null) {
        } else {
            parentFragment = this.x;
        }
        return parentFragment;
    }

    private static n H1(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            Fragment obj1 = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean I1(Fragment fragment) {
        boolean equals;
        Fragment obj3;
        Fragment parentFragment = obj3.getParentFragment();
        while (parentFragment != null) {
            obj3 = obj3.getParentFragment();
            parentFragment = obj3.getParentFragment();
        }
        return 0;
    }

    private void J1(Context context, n n2) {
        boolean obj1;
        N1();
        obj1 = c.c(context).k().s(n2);
        this.v = obj1;
        if (!equals(obj1)) {
            this.v.B1(this);
        }
    }

    private void K1(com.bumptech.glide.o.t t) {
        this.c.remove(t);
    }

    private void N1() {
        com.bumptech.glide.o.t tVar;
        tVar = this.v;
        if (tVar != null) {
            tVar.K1(this);
            this.v = 0;
        }
    }

    Set<com.bumptech.glide.o.t> C1() {
        Object next;
        boolean z;
        com.bumptech.glide.o.t tVar = this.v;
        if (tVar == null) {
            return Collections.emptySet();
        }
        if (equals(tVar)) {
            return Collections.unmodifiableSet(this.c);
        }
        HashSet hashSet = new HashSet();
        Iterator iterator = this.v.C1().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (I1((t)next.E1())) {
            }
            hashSet.add(next);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // androidx.fragment.app.Fragment
    com.bumptech.glide.o.a D1() {
        return this.a;
    }

    @Override // androidx.fragment.app.Fragment
    public k F1() {
        return this.w;
    }

    @Override // androidx.fragment.app.Fragment
    public com.bumptech.glide.o.q G1() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    void L1(Fragment fragment) {
        Object context;
        Object obj2;
        this.x = fragment;
        if (fragment != null) {
            if (fragment.getContext() == null) {
            } else {
                context = t.H1(fragment);
                if (context == null) {
                }
                J1(fragment.getContext(), context);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M1(k k) {
        this.w = k;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        int i;
        boolean obj4;
        super.onAttach(context);
        obj4 = t.H1(this);
        final String str2 = "SupportRMFragment";
        if (obj4 == null && Log.isLoggable(str2, 5)) {
            if (Log.isLoggable(str2, i)) {
                Log.w(str2, "Unable to register fragment with root, ancestor detached");
            }
        }
        J1(getContext(), obj4);
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
        this.x = 0;
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
        stringBuilder.append(super.toString());
        stringBuilder.append("{parent=");
        stringBuilder.append(E1());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
