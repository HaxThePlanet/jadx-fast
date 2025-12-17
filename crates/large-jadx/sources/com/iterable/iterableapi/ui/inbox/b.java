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
import com.iterable.iterableapi.j1.c;
import com.iterable.iterableapi.z;
import d.h.k.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class b extends RecyclerView.h<com.iterable.iterableapi.ui.inbox.b.f> {

    private final com.iterable.iterableapi.ui.inbox.b.e a;
    private final com.iterable.iterableapi.ui.inbox.c b;
    private final com.iterable.iterableapi.ui.inbox.d c;
    private final com.iterable.iterableapi.ui.inbox.f d;
    private final com.iterable.iterableapi.ui.inbox.e e;
    private List<com.iterable.iterableapi.ui.inbox.b.d> f;
    private View.OnClickListener g;

    class a implements View.OnClickListener {

        final com.iterable.iterableapi.ui.inbox.b a;
        a(com.iterable.iterableapi.ui.inbox.b b) {
            this.a = b;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            b.f(this.a).o1((g0)view.getTag());
        }
    }

    class b implements Comparator<com.iterable.iterableapi.ui.inbox.b.d> {

        final com.iterable.iterableapi.ui.inbox.b a;
        b(com.iterable.iterableapi.ui.inbox.b b) {
            this.a = b;
            super();
        }

        @Override // java.util.Comparator
        public int a(com.iterable.iterableapi.ui.inbox.b.d b$d, com.iterable.iterableapi.ui.inbox.b.d b$d2) {
            return b.g(this.a).m(b.d.a(d), b.d.a(d2));
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((b.d)object, (b.d)object2);
        }
    }

    private static class d {

        private final g0 a;
        private final g0.d b;
        private final boolean c;
        private final Date d;
        private d(g0 g0) {
            super();
            this.a = g0;
            this.b = g0.h();
            this.c = g0.r();
            this.d = g0.f();
        }

        d(g0 g0, com.iterable.iterableapi.ui.inbox.b.a b$a2) {
            super(g0);
        }

        static g0 a(com.iterable.iterableapi.ui.inbox.b.d b$d) {
            return d.a;
        }

        static g0.d b(com.iterable.iterableapi.ui.inbox.b.d b$d) {
            return d.b;
        }

        static boolean c(com.iterable.iterableapi.ui.inbox.b.d b$d) {
            return d.c;
        }

        public boolean equals(Object object) {
            int i;
            Object g0Var;
            Object valueOf;
            Object obj5;
            if (object == this) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof b.d) {
                return i2;
            }
            if (this.a == object.a && c.a(this.b, object.b) && c.a(Boolean.valueOf(this.c), Boolean.valueOf(object.c)) && c.a(this.d, object.d)) {
                if (c.a(this.b, object.b)) {
                    if (c.a(Boolean.valueOf(this.c), Boolean.valueOf(object.c))) {
                        if (c.a(this.d, object.d)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            Object[] arr = new Object[4];
            return c.b(this.a, this.b, Boolean.valueOf(this.c), this.d);
        }
    }

    interface e {
        public abstract void T0(g0 g0);

        public abstract void h0(g0 g0);

        public abstract void o1(g0 g0);

        public abstract void v(g0 g0, z z2);
    }

    private static class c extends h.b {

        private final List<com.iterable.iterableapi.ui.inbox.b.d> a;
        private final List<com.iterable.iterableapi.ui.inbox.b.d> b;
        private c(List<com.iterable.iterableapi.ui.inbox.b.d> list, List<com.iterable.iterableapi.ui.inbox.b.d> list2) {
            super();
            this.a = list;
            this.b = list2;
        }

        c(List list, List list2, com.iterable.iterableapi.ui.inbox.b.a b$a3) {
            super(list, list2);
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areContentsTheSame(int i, int i2) {
            return (b.d)this.a.get(i).equals((b.d)this.b.get(i2));
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areItemsTheSame(int i, int i2) {
            return b.d.a((b.d)this.a.get(i)).i().equals(b.d.a((b.d)this.b.get(i2)).i());
        }

        @Override // androidx.recyclerview.widget.h$b
        public int getNewListSize() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.h$b
        public int getOldListSize() {
            return this.a.size();
        }
    }

    public static class f extends RecyclerView.e0 {

        public final TextView a;
        public final TextView b;
        public final TextView c;
        public final ImageView d;
        public final ImageView e;
        private Object f;
        private f(View view, Object object2) {
            super(view);
            this.a = (TextView)view.findViewById(c.h);
            this.b = (TextView)view.findViewById(c.g);
            this.d = (ImageView)view.findViewById(c.e);
            this.e = (ImageView)view.findViewById(c.i);
            this.c = (TextView)view.findViewById(c.b);
            this.f = object2;
        }

        f(View view, Object object2, com.iterable.iterableapi.ui.inbox.b.a b$a3) {
            super(view, object2);
        }

        static Object a(com.iterable.iterableapi.ui.inbox.b.f b$f) {
            return f.f;
        }
    }
    b(List<g0> list, com.iterable.iterableapi.ui.inbox.b.e b$e2, com.iterable.iterableapi.ui.inbox.c c3, com.iterable.iterableapi.ui.inbox.d d4, com.iterable.iterableapi.ui.inbox.f f5, com.iterable.iterableapi.ui.inbox.e e6) {
        super();
        b.a aVar = new b.a(this);
        this.g = aVar;
        this.a = e2;
        this.b = c3;
        this.c = d4;
        this.d = f5;
        this.f = i(list);
        this.e = e6;
    }

    static com.iterable.iterableapi.ui.inbox.b.e f(com.iterable.iterableapi.ui.inbox.b b) {
        return b.a;
    }

    static com.iterable.iterableapi.ui.inbox.d g(com.iterable.iterableapi.ui.inbox.b b) {
        return b.c;
    }

    private List<com.iterable.iterableapi.ui.inbox.b.d> i(List<g0> list) {
        int size;
        boolean dVar;
        int i;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator obj5 = list.iterator();
        while (obj5.hasNext()) {
            size = obj5.next();
            if (this.d.a((g0)size)) {
            }
            dVar = new b.d(size, 0);
            arrayList.add(dVar);
        }
        obj5 = new b.b(this);
        Collections.sort(arrayList, obj5);
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return this.b.d(b.d.a((b.d)this.f.get(i)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(int i, z z2) {
        this.f.remove(i);
        this.a.v(b.d.a((b.d)this.f.get(i)), z2);
        notifyItemRemoved(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void j(com.iterable.iterableapi.ui.inbox.b.f b$f, int i2) {
        Object parse;
        ImageView view;
        ImageView view2;
        String str;
        Object obj5 = this.f.get(i2);
        parse = b.d.b((b.d)obj5);
        TextView view4 = f.a;
        if (view4 != null) {
            view4.setText(parse.a);
        }
        TextView view5 = f.b;
        if (view5 != null) {
            view5.setText(parse.b);
        }
        view2 = f.d;
        if (view2 != null) {
            a.c(view2, Uri.parse(parse.c));
        }
        if (f.e != null) {
            if (b.d.c(obj5)) {
                f.e.setVisibility(4);
            } else {
                f.e.setVisibility(0);
            }
        }
        TextView view3 = f.c;
        if (view3 != null) {
            view3.setText(this.e.a(b.d.a(obj5)));
        }
        f.itemView.setTag(b.d.a(obj5));
        f.itemView.setOnClickListener(this.g);
        this.b.c(f, b.f.a(f), b.d.a(obj5));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public com.iterable.iterableapi.ui.inbox.b.f l(ViewGroup viewGroup, int i2) {
        final View obj4 = LayoutInflater.from(viewGroup.getContext()).inflate(this.b.a(i2), viewGroup, false);
        b.f fVar = new b.f(obj4, this.b.b(obj4, i2), 0);
        return fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void m(com.iterable.iterableapi.ui.inbox.b.f b$f) {
        super.onViewAttachedToWindow(f);
        this.a.T0((g0)f.itemView.getTag());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void n(com.iterable.iterableapi.ui.inbox.b.f b$f) {
        super.onViewDetachedFromWindow(f);
        this.a.h0((g0)f.itemView.getTag());
    }

    public void o(List<g0> list) {
        final List obj4 = i(list);
        b.c cVar = new b.c(this.f, obj4, 0);
        this.f.clear();
        this.f.addAll(obj4);
        h.b(cVar).c(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        j((b.f)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return l(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onViewAttachedToWindow(RecyclerView.e0 recyclerView$e0) {
        m((b.f)e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onViewDetachedFromWindow(RecyclerView.e0 recyclerView$e0) {
        n((b.f)e0);
    }
}
