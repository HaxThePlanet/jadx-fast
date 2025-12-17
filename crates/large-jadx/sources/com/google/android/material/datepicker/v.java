package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import f.c.a.e.h;
import f.c.a.e.j;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
class v extends RecyclerView.h<com.google.android.material.datepicker.v.b> {

    private final com.google.android.material.datepicker.i<?> a;

    class a implements View.OnClickListener {

        final int a;
        final com.google.android.material.datepicker.v b;
        a(com.google.android.material.datepicker.v v, int i2) {
            this.b = v;
            this.a = i2;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            v.f(this.b).V1(v.f(this.b).M1().e(m.c(this.a, mVar.b)));
            v.f(this.b).W1(i.k.DAY);
        }
    }

    public static class b extends RecyclerView.e0 {

        final TextView a;
        b(TextView textView) {
            super(textView);
            this.a = textView;
        }
    }
    v(com.google.android.material.datepicker.i<?> i) {
        super();
        this.a = i;
    }

    static com.google.android.material.datepicker.i f(com.google.android.material.datepicker.v v) {
        return v.a;
    }

    private View.OnClickListener g(int i) {
        v.a aVar = new v.a(this, i);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.M1().k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    int h(int i) {
        return i -= i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    int i(int i) {
        return i2 += i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void j(com.google.android.material.datepicker.v.b v$b, int i2) {
        com.google.android.material.datepicker.b bVar;
        String str;
        int obj9 = i(i2);
        final int i4 = 1;
        Object[] arr2 = new Object[i4];
        final int i5 = 0;
        arr2[i5] = Integer.valueOf(obj9);
        b.a.setText(String.format(Locale.getDefault(), "%d", arr2));
        Object[] arr = new Object[i4];
        arr[i5] = Integer.valueOf(obj9);
        b.a.setContentDescription(String.format(b.a.getContext().getString(j.C), arr));
        com.google.android.material.datepicker.c cVar = this.a.N1();
        Calendar calendar = u.o();
        bVar = calendar.get(i4) == obj9 ? cVar.f : cVar.d;
        Iterator iterator = this.a.P1().t1().iterator();
        while (iterator.hasNext()) {
            calendar.setTimeInMillis((Long)iterator.next().longValue());
            if (calendar.get(i4) == obj9) {
            }
            bVar = cVar.e;
        }
        bVar.d(b.a);
        b.a.setOnClickListener(g(obj9));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public com.google.android.material.datepicker.v.b l(ViewGroup viewGroup, int i2) {
        v.b obj4 = new v.b((TextView)LayoutInflater.from(viewGroup.getContext()).inflate(h.v, viewGroup, false));
        return obj4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        j((v.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return l(viewGroup, i2);
    }
}
