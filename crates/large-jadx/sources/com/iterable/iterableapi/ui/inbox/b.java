package com.iterable.iterableapi.ui.inbox;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.h.e;
import com.iterable.iterableapi.g0;
import com.iterable.iterableapi.g0.d;
import com.iterable.iterableapi.j1.a;
import com.iterable.iterableapi.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* compiled from: IterableInboxAdapter.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.h<b.f> {

    private final b.e a;
    private final c b;
    private final d c;
    private final f d;
    private final e e;
    private List<b.d> f;
    private View.OnClickListener g = new b$a();

    class a implements View.OnClickListener {

        final /* synthetic */ b a;
        a() {
            this.a = bVar;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.a.o1((g0)view.getTag());
        }
    }

    class b implements Comparator<b.d> {

        final /* synthetic */ b a;
        b() {
            this.a = bVar;
            super();
        }

        public int a(b.d dVar, b.d dVar2) {
            return this.a.c.m(dVar.a, dVar2.a);
        }
    }

    private static class d {

        private final g0 a;
        private final g0.d b;
        private final boolean c;
        private final Date d;
        /* synthetic */ d(g0 g0Var, b.a aVar) {
            this(g0Var);
        }

        static /* synthetic */ g0 a(b.d dVar) {
            return dVar.a;
        }

        static /* synthetic */ g0.d b(b.d dVar) {
            return dVar.b;
        }

        static /* synthetic */ boolean c(b.d dVar) {
            return dVar.c;
        }

        public boolean equals(Object object) {
            boolean z = true;
            g0 g0Var;
            g0 g0Var2;
            boolean z2;
            z = true;
            if (object == this) {
                return true;
            }
            final int i = 0;
            if (!(object instanceof b.d)) {
                return false;
            }
            if (this.a == object.a) {
                if (c.a(this.b, object.b)) {
                    if (c.a(Boolean.valueOf(this.c), Boolean.valueOf(object.c))) {
                        if (!(c.a(this.d, object.d))) {
                        }
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            Object[] arr = new Object[4];
            return c.b(new Object[] { this.a, this.b, Boolean.valueOf(this.c), this.d });
        }

        private d(g0 g0Var) {
            super();
            this.a = g0Var;
            this.b = g0Var.h();
            this.c = g0Var.r();
            this.d = g0Var.f();
        }
    }

    interface e {
        void T0(g0 g0Var);

        void h0(g0 g0Var);

        void o1(g0 g0Var);

        void v(g0 g0Var, z zVar);
    }

    private static class c extends h.b {

        private final List<b.d> a;
        private final List<b.d> b;
        /* synthetic */ c(List list, List list2, b.a aVar) {
            this(list, list2);
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areContentsTheSame(int i, int i2) {
            return (b.d)this.a.get(i).equals((b.d)this.b.get(i2));
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areItemsTheSame(int i, int i2) {
            return (b.d)this.a.get(i).a.i().equals((b.d)this.b.get(i2).a.i());
        }

        @Override // androidx.recyclerview.widget.h$b
        public int getNewListSize() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.h$b
        public int getOldListSize() {
            return this.a.size();
        }

        private c(List<b.d> list, List<b.d> list2) {
            super();
            this.a = list;
            this.b = list2;
        }
    }

    public static class f extends RecyclerView.e0 {

        public final TextView a;
        public final TextView b;
        public final TextView c;
        public final ImageView d;
        public final ImageView e;
        private Object f;
        /* synthetic */ f(View view, Object object, b.a aVar) {
            this(view, object);
        }

        static /* synthetic */ Object a(b.f fVar) {
            return fVar.f;
        }

        private f(View view, Object object) {
            super(view);
            this.a = (TextView)view.findViewById(c.h);
            this.b = (TextView)view.findViewById(c.g);
            this.d = (ImageView)view.findViewById(c.e);
            this.e = (ImageView)view.findViewById(c.i);
            this.c = (TextView)view.findViewById(c.b);
            this.f = object;
        }
    }
    b(List<g0> list, b.e eVar, c cVar, d dVar, f fVar, e eVar2) {
        super();
        final com.iterable.iterableapi.ui.inbox.b.a aVar = new b.a(this);
        this.a = eVar;
        this.b = cVar;
        this.c = dVar;
        this.d = fVar;
        this.f = i(list);
        this.e = eVar2;
    }

    static /* synthetic */ b.e f(b bVar) {
        return bVar.a;
    }

    static /* synthetic */ d g(b bVar) {
        return bVar.c;
    }

    private List<b.d> i(List<g0> list) {
        com.iterable.iterableapi.ui.inbox.b.a aVar = null;
        final ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        Collections.sort(arrayList, new b.b(this));
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return this.b.d((b.d)this.f.get(i).a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(int i, z zVar) {
        this.f.remove(i);
        this.a.v((b.d)this.f.get(i).a, zVar);
        notifyItemRemoved(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void j(b.f fVar, int i) {
        ImageView imageView2 = null;
        String str;
        Object item = this.f.get(i);
        g0.d dVar = item.b;
        if (fVar.a != null) {
            fVar.a.setText(dVar.a);
        }
        if (fVar.b != null) {
            fVar.b.setText(dVar.b);
        }
        if (fVar.d != null) {
            a.c(fVar.d, Uri.parse(dVar.c));
        }
        if (fVar.e != null) {
            if (item.c) {
                fVar.e.setVisibility(4);
            } else {
                fVar.e.setVisibility(0);
            }
        }
        if (fVar.c != null) {
            fVar.c.setText(this.e.a(item.a));
        }
        fVar.itemView.setTag(item.a);
        fVar.itemView.setOnClickListener(this.g);
        this.b.c(fVar, fVar.f, item.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public b.f l(ViewGroup viewGroup, int i) {
        final View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.b.a(i), viewGroup, false);
        return new b.f(inflate, this.b.b(inflate, i), null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void m(b.f fVar) {
        super.onViewAttachedToWindow(fVar);
        this.a.T0((g0)fVar.itemView.getTag());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void n(b.f fVar) {
        super.onViewDetachedFromWindow(fVar);
        this.a.h0((g0)fVar.itemView.getTag());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void o(List<g0> list) {
        final List list5 = i(list);
        this.f.clear();
        this.f.addAll(list5);
        h.b(new b.c(this.f, list5, null)).c(this);
    }
}
