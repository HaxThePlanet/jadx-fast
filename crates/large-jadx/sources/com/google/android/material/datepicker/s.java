package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.p;

/* loaded from: classes2.dex */
class s extends LinearLayoutManager {

    class a extends p {
        a(com.google.android.material.datepicker.s s, Context context2) {
            super(context2);
        }

        @Override // androidx.recyclerview.widget.p
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return i /= obj2;
        }
    }
    s(Context context, int i2, boolean z3) {
        super(context, i2, z3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void e2(RecyclerView recyclerView, RecyclerView.b0 recyclerView$b02, int i3) {
        s.a obj2 = new s.a(this, recyclerView.getContext());
        obj2.setTargetPosition(i3);
        f2(obj2);
    }
}
