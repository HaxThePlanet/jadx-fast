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

/* loaded from: classes.dex */
@Deprecated
public class o extends Fragment {

    private final com.bumptech.glide.o.a a;
    private final com.bumptech.glide.o.q b;
    private final Set<com.bumptech.glide.o.o> c;
    private k v;
    private com.bumptech.glide.o.o w;
    private Fragment x;

    private class a implements com.bumptech.glide.o.q {

        final com.bumptech.glide.o.o a;
        a(com.bumptech.glide.o.o o) {
            this.a = o;
            super();
        }

        public Set<k> a() {
            int size;
            k kVar;
            Set set = this.a.b();
            HashSet hashSet = new HashSet(set.size());
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                size = iterator.next();
                if ((o)size.e() != null) {
                }
                hashSet.add(size.e());
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
    public o() {
        a aVar = new a();
        super(aVar);
    }

    o(com.bumptech.glide.o.a a) {
        super();
        o.a aVar = new o.a(this);
        this.b = aVar;
        HashSet hashSet = new HashSet();
        this.c = hashSet;
        this.a = a;
    }

    private void a(com.bumptech.glide.o.o o) {
        this.c.add(o);
    }

    private Fragment d() {
        Fragment parentFragment;
        if (Build.VERSION.SDK_INT >= 17) {
            parentFragment = getParentFragment();
        } else {
            parentFragment = 0;
        }
        if (parentFragment != null) {
        } else {
            parentFragment = this.x;
        }
        return parentFragment;
    }

    private boolean g(Fragment fragment) {
        boolean equals;
        Fragment obj3;
        Fragment parentFragment2 = obj3.getParentFragment();
        while (parentFragment2 != null) {
            obj3 = obj3.getParentFragment();
            parentFragment2 = obj3.getParentFragment();
        }
        return 0;
    }

    private void h(Activity activity) {
        boolean obj2;
        l();
        obj2 = c.c(activity).k().q(activity);
        this.w = obj2;
        if (!equals(obj2)) {
            this.w.a(this);
        }
    }

    private void i(com.bumptech.glide.o.o o) {
        this.c.remove(o);
    }

    private void l() {
        com.bumptech.glide.o.o oVar;
        oVar = this.w;
        if (oVar != null) {
            oVar.i(this);
            this.w = 0;
        }
    }

    Set<com.bumptech.glide.o.o> b() {
        com.bumptech.glide.o.o sDK_INT;
        int i;
        Object next;
        boolean z;
        if (equals(this.w)) {
            return Collections.unmodifiableSet(this.c);
        }
        if (this.w != null) {
            if (Build.VERSION.SDK_INT < 17) {
            } else {
                HashSet hashSet = new HashSet();
                Iterator iterator = this.w.b().iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (g((o)next.getParentFragment())) {
                    }
                    hashSet.add(next);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    @Override // android.app.Fragment
    com.bumptech.glide.o.a c() {
        return this.a;
    }

    @Override // android.app.Fragment
    public k e() {
        return this.v;
    }

    @Override // android.app.Fragment
    public com.bumptech.glide.o.q f() {
        return this.b;
    }

    @Override // android.app.Fragment
    void j(Fragment fragment) {
        Activity activity;
        Object obj2;
        this.x = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            if (fragment.getActivity() != null) {
                h(fragment.getActivity());
            }
        }
    }

    @Override // android.app.Fragment
    public void k(k k) {
        this.v = k;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        int str2;
        String str;
        Activity obj3;
        super.onAttach(activity);
        h(activity);
        try {
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
        stringBuilder.append(super.toString());
        stringBuilder.append("{parent=");
        stringBuilder.append(d());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
