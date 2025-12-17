package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.q;
import d.h.l.u;
import f.c.a.e.f;
import f.c.a.e.h;

/* loaded from: classes2.dex */
class o extends RecyclerView.h<com.google.android.material.datepicker.o.b> {

    private final Context a;
    private final com.google.android.material.datepicker.a b;
    private final com.google.android.material.datepicker.e<?> c;
    private final com.google.android.material.datepicker.i.l d;
    private final int e;

    class a implements AdapterView.OnItemClickListener {

        final com.google.android.material.datepicker.MaterialCalendarGridView a;
        final com.google.android.material.datepicker.o b;
        a(com.google.android.material.datepicker.o o, com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView2) {
            this.b = o;
            this.a = materialCalendarGridView2;
            super();
        }

        public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long l4) {
            boolean obj1;
            long obj2;
            if (this.a.b().n(i3)) {
                o.f(this.b).a(this.a.b().c(i3).longValue());
            }
        }
    }

    public static class b extends RecyclerView.e0 {

        final TextView a;
        final com.google.android.material.datepicker.MaterialCalendarGridView b;
        b(LinearLayout linearLayout, boolean z2) {
            View obj3;
            super(linearLayout);
            View viewById = linearLayout.findViewById(f.D);
            this.a = (TextView)viewById;
            u.m0(viewById, true);
            this.b = (MaterialCalendarGridView)linearLayout.findViewById(f.z);
            if (!z2) {
                viewById.setVisibility(8);
            }
        }
    }
    o(Context context, com.google.android.material.datepicker.e<?> e2, com.google.android.material.datepicker.a a3, com.google.android.material.datepicker.i.l i$l4) {
        int i;
        super();
        final com.google.android.material.datepicker.m mVar3 = a3.i();
        if (a3.j().a(mVar3) > 0) {
        } else {
            if (mVar3.a(a3.g()) > 0) {
            } else {
                if (j.R1(context)) {
                    i = i.Q1(context);
                } else {
                    i = 0;
                }
                this.a = context;
                this.e = i5 += i;
                this.b = a3;
                this.c = e2;
                this.d = l4;
                setHasStableIds(true);
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("currentPage cannot be after lastPage");
            throw obj4;
        }
        obj4 = new IllegalArgumentException("firstPage cannot be after currentPage");
        throw obj4;
    }

    static com.google.android.material.datepicker.i.l f(com.google.android.material.datepicker.o o) {
        return o.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    com.google.android.material.datepicker.m g(int i) {
        return this.b.j().o(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.b.h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public long getItemId(int i) {
        return this.b.j().o(i).n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    java.lang.CharSequence h(int i) {
        return g(i).m(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    int i(com.google.android.material.datepicker.m m) {
        return this.b.j().p(m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void j(com.google.android.material.datepicker.o.b o$b, int i2) {
        com.google.android.material.datepicker.n nVar;
        Object str;
        com.google.android.material.datepicker.a aVar;
        int obj5;
        obj5 = this.b.j().o(i2);
        b.a.setText(obj5.m(b.itemView.getContext()));
        View obj4 = b.b.findViewById(f.z);
        if ((MaterialCalendarGridView)obj4.b() != null && obj5.equals(nVar2.a)) {
            if (obj5.equals(nVar2.a)) {
                obj4.invalidate();
                obj4.b().m(obj4);
            } else {
                nVar = new n(obj5, this.c, this.b);
                obj4.setNumColumns(obj5.v);
                obj4.setAdapter(nVar);
            }
        } else {
        }
        obj5 = new o.a(this, obj4);
        obj4.setOnItemClickListener(obj5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public com.google.android.material.datepicker.o.b l(ViewGroup viewGroup, int i2) {
        int i5 = 0;
        View obj4 = LayoutInflater.from(viewGroup.getContext()).inflate(h.t, viewGroup, i5);
        if (j.R1(viewGroup.getContext())) {
            RecyclerView.q obj3 = new RecyclerView.q(-1, this.e);
            (LinearLayout)obj4.setLayoutParams(obj3);
            obj3 = new o.b(obj4, 1);
            return obj3;
        }
        obj3 = new o.b(obj4, i5);
        return obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        j((o.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return l(viewGroup, i2);
    }
}
