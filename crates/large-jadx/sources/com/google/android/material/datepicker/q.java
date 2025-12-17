package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
abstract class q<S>  extends Fragment {

    protected final LinkedHashSet<com.google.android.material.datepicker.p<S>> a;
    q() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.a = linkedHashSet;
    }

    boolean B1(com.google.android.material.datepicker.p<S> p) {
        return this.a.add(p);
    }

    @Override // androidx.fragment.app.Fragment
    void C1() {
        this.a.clear();
    }
}
