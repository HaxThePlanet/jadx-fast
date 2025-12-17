package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.y;
import com.google.android.material.button.MaterialButton;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.u;
import f.c.a.e.d;
import f.c.a.e.f;
import f.c.a.e.g;
import f.c.a.e.h;
import f.c.a.e.j;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public final class i<S>  extends com.google.android.material.datepicker.q<S> {

    static final Object D;
    static final Object E;
    static final Object F;
    static final Object G;
    private RecyclerView A;
    private View B;
    private View C;
    private int b;
    private com.google.android.material.datepicker.e<S> c;
    private com.google.android.material.datepicker.a v;
    private com.google.android.material.datepicker.m w;
    private com.google.android.material.datepicker.i.k x;
    private com.google.android.material.datepicker.c y;
    private RecyclerView z;

    class a implements Runnable {

        final int a;
        final com.google.android.material.datepicker.i b;
        a(com.google.android.material.datepicker.i i, int i2) {
            this.b = i;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            i.D1(this.b).y1(this.a);
        }
    }

    class h implements View.OnClickListener {

        final com.google.android.material.datepicker.i a;
        h(com.google.android.material.datepicker.i i) {
            this.a = i;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.X1();
        }
    }

    class i implements View.OnClickListener {

        final com.google.android.material.datepicker.o a;
        final com.google.android.material.datepicker.i b;
        i(com.google.android.material.datepicker.i i, com.google.android.material.datepicker.o o2) {
            this.b = i;
            this.a = o2;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            int itemCount;
            com.google.android.material.datepicker.o oVar;
            int obj3;
            obj3++;
            if (obj3 < i.D1(this.b).getAdapter().getItemCount()) {
                this.b.V1(this.a.g(obj3));
            }
        }
    }

    class j implements View.OnClickListener {

        final com.google.android.material.datepicker.o a;
        final com.google.android.material.datepicker.i b;
        j(com.google.android.material.datepicker.i i, com.google.android.material.datepicker.o o2) {
            this.b = i;
            this.a = o2;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            com.google.android.material.datepicker.i iVar;
            com.google.android.material.datepicker.o oVar;
            int obj3;
            obj3--;
            if (obj3 >= 0) {
                this.b.V1(this.a.g(obj3));
            }
        }
    }

    static enum k {

        DAY,
        YEAR;
    }

    interface l {
        public abstract void a(long l);
    }

    class b extends a {
        b(com.google.android.material.datepicker.i i) {
            super();
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            super.g(view, c2);
            c2.Z(0);
        }
    }

    class d implements com.google.android.material.datepicker.i.l {

        final com.google.android.material.datepicker.i a;
        d(com.google.android.material.datepicker.i i) {
            this.a = i;
            super();
        }

        @Override // com.google.android.material.datepicker.i$l
        public void a(long l) {
            com.google.android.material.datepicker.e z;
            long obj2;
            Object obj3;
            if (i.E1(this.a).f().g1(l)) {
                i.F1(this.a).U1(l);
                obj2 = obj2.a.iterator();
                for (p obj3 : obj2) {
                    obj3.b(i.F1(this.a).z1());
                }
                i.D1(this.a).getAdapter().notifyDataSetChanged();
                if (i.G1(this.a) != null) {
                    i.G1(this.a).getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    class e extends RecyclerView.o {

        private final Calendar a;
        private final Calendar b;
        final com.google.android.material.datepicker.i c;
        e(com.google.android.material.datepicker.i i) {
            this.c = i;
            super();
            this.a = u.q();
            this.b = u.q();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$o
        public void onDraw(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
            boolean adapter;
            RecyclerView.p layoutManager;
            Iterator iterator;
            boolean next;
            Object obj2;
            Object obj;
            View view;
            int i;
            View view2;
            float f2;
            android.graphics.Paint paint;
            int i3;
            int width;
            int i2;
            float f3;
            float f5;
            float f4;
            float f;
            android.graphics.Paint paint2;
            final Object obj3 = this;
            if (adapter2 instanceof v) {
                if (layoutManager2 instanceof GridLayoutManager == null) {
                } else {
                    adapter = recyclerView2.getAdapter();
                    layoutManager = recyclerView2.getLayoutManager();
                    iterator = i.F1(obj3.c).L().iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        obj2 = next.a;
                        if (obj2 != null) {
                        }
                        if (next.b == null) {
                        } else {
                        }
                        long longValue2 = (Long)obj2.longValue();
                        obj3.a.setTimeInMillis(longValue2);
                        obj3.b.setTimeInMillis((Long)next.b.longValue());
                        int i6 = 1;
                        int i5 = (v)adapter.h(obj3.a.get(i6));
                        int i8 = adapter.h(obj3.b.get(i6));
                        obj = (GridLayoutManager)layoutManager.Z(i5);
                        view = layoutManager.Z(i8);
                        i5 /= i9;
                        i8 /= i10;
                        i = next;
                        while (i <= obj2) {
                            view2 = layoutManager.Z(i11 *= i);
                            if (view2 == null) {
                            } else {
                            }
                            if (i == next) {
                            } else {
                            }
                            i3 = 0;
                            if (i == obj2) {
                            } else {
                            }
                            width = recyclerView2.getWidth();
                            canvas.drawRect((float)i3, (float)i14, (float)width, (float)i13, cVar3.h);
                            i++;
                            left2 += i2;
                            left += width;
                        }
                        view2 = layoutManager.Z(i11 *= i);
                        if (view2 == null) {
                        } else {
                        }
                        if (i == next) {
                        } else {
                        }
                        i3 = 0;
                        if (i == obj2) {
                        } else {
                        }
                        width = recyclerView2.getWidth();
                        canvas.drawRect((float)i3, (float)i14, (float)width, (float)i13, cVar3.h);
                        i++;
                        left2 += i2;
                        left += width;
                    }
                }
            }
        }
    }

    class f extends a {

        final com.google.android.material.datepicker.i d;
        f(com.google.android.material.datepicker.i i) {
            this.d = i;
            super();
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            int i;
            String obj2;
            super.g(view, c2);
            if (i.I1(this.d).getVisibility() == 0) {
                obj2 = this.d.getString(j.K);
            } else {
                obj2 = this.d.getString(j.I);
            }
            c2.i0(obj2);
        }
    }

    class g extends RecyclerView.u {

        final com.google.android.material.datepicker.o a;
        final MaterialButton b;
        final com.google.android.material.datepicker.i c;
        g(com.google.android.material.datepicker.i i, com.google.android.material.datepicker.o o2, MaterialButton materialButton3) {
            this.c = i;
            this.a = o2;
            this.b = materialButton3;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int sDK_INT;
            int i;
            int obj4;
            if (i2 == 0) {
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(this.b.getText());
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int obj1;
            if (i2 < 0) {
                obj1 = this.c.S1().v2();
            } else {
                obj1 = this.c.S1().y2();
            }
            i.J1(this.c, this.a.g(obj1));
            this.b.setText(this.a.h(obj1));
        }
    }

    class c extends com.google.android.material.datepicker.s {

        final int I;
        final com.google.android.material.datepicker.i J;
        c(com.google.android.material.datepicker.i i, Context context2, int i3, boolean z4, int i5) {
            this.J = i;
            this.I = i5;
            super(context2, i3, z4);
        }

        @Override // com.google.android.material.datepicker.s
        protected void i2(RecyclerView.b0 recyclerView$b0, int[] i2Arr2) {
            int obj3;
            final int i = 1;
            final int i2 = 0;
            if (this.I == 0) {
                i2Arr2[i2] = i.D1(this.J).getWidth();
                i2Arr2[i] = i.D1(this.J).getWidth();
            } else {
                i2Arr2[i2] = i.D1(this.J).getHeight();
                i2Arr2[i] = i.D1(this.J).getHeight();
            }
        }
    }
    static {
        i.D = "MONTHS_VIEW_GROUP_TAG";
        i.E = "NAVIGATION_PREV_TAG";
        i.F = "NAVIGATION_NEXT_TAG";
        i.G = "SELECTOR_TOGGLE_TAG";
    }

    static RecyclerView D1(com.google.android.material.datepicker.i i) {
        return i.A;
    }

    static com.google.android.material.datepicker.a E1(com.google.android.material.datepicker.i i) {
        return i.v;
    }

    static com.google.android.material.datepicker.e F1(com.google.android.material.datepicker.i i) {
        return i.c;
    }

    static RecyclerView G1(com.google.android.material.datepicker.i i) {
        return i.z;
    }

    static com.google.android.material.datepicker.c H1(com.google.android.material.datepicker.i i) {
        return i.y;
    }

    static View I1(com.google.android.material.datepicker.i i) {
        return i.C;
    }

    static com.google.android.material.datepicker.m J1(com.google.android.material.datepicker.i i, com.google.android.material.datepicker.m m2) {
        i.w = m2;
        return m2;
    }

    private void K1(View view, com.google.android.material.datepicker.o o2) {
        View viewById = view.findViewById(f.A);
        (MaterialButton)viewById.setTag(i.G);
        i.f fVar = new i.f(this);
        u.l0(viewById, fVar);
        View viewById2 = view.findViewById(f.C);
        (MaterialButton)viewById2.setTag(i.E);
        View viewById3 = view.findViewById(f.B);
        (MaterialButton)viewById3.setTag(i.F);
        this.B = view.findViewById(f.K);
        this.C = view.findViewById(f.F);
        W1(i.k.DAY);
        viewById.setText(this.w.m(view.getContext()));
        i.g gVar = new i.g(this, o2, viewById);
        this.A.l(gVar);
        i.h obj5 = new i.h(this);
        viewById.setOnClickListener(obj5);
        obj5 = new i.i(this, o2);
        viewById3.setOnClickListener(obj5);
        obj5 = new i.j(this, o2);
        viewById2.setOnClickListener(obj5);
    }

    private RecyclerView.o L1() {
        i.e eVar = new i.e(this);
        return eVar;
    }

    static int Q1(Context context) {
        return context.getResources().getDimensionPixelSize(d.S);
    }

    private static int R1(Context context) {
        Resources obj5 = context.getResources();
        int i10 = n.x;
        return i5 += obj5;
    }

    public static <T> com.google.android.material.datepicker.i<T> T1(com.google.android.material.datepicker.e<T> e, int i2, com.google.android.material.datepicker.a a3) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", e);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", a3);
        bundle.putParcelable("CURRENT_MONTH_KEY", a3.i());
        iVar.setArguments(bundle);
        return iVar;
    }

    private void U1(int i) {
        i.a aVar = new i.a(this, i);
        this.A.post(aVar);
    }

    public boolean B1(com.google.android.material.datepicker.p<S> p) {
        return super.B1(p);
    }

    @Override // com.google.android.material.datepicker.q
    com.google.android.material.datepicker.a M1() {
        return this.v;
    }

    @Override // com.google.android.material.datepicker.q
    com.google.android.material.datepicker.c N1() {
        return this.y;
    }

    @Override // com.google.android.material.datepicker.q
    com.google.android.material.datepicker.m O1() {
        return this.w;
    }

    public com.google.android.material.datepicker.e<S> P1() {
        return this.c;
    }

    @Override // com.google.android.material.datepicker.q
    LinearLayoutManager S1() {
        return (LinearLayoutManager)this.A.getLayoutManager();
    }

    @Override // com.google.android.material.datepicker.q
    void V1(com.google.android.material.datepicker.m m) {
        int i;
        int i3;
        int i2;
        Object obj7;
        RecyclerView.h adapter = this.A.getAdapter();
        final int i5 = (o)adapter.i(m);
        i = i5 - i4;
        final int i7 = 0;
        i3 = Math.abs(i) > 3 ? i2 : i7;
        if (i > 0) {
        } else {
            i2 = i7;
        }
        this.w = m;
        if (i3 != 0 && i2 != 0) {
            if (i2 != 0) {
                this.A.q1(i5 + -3);
                U1(i5);
            } else {
                if (i3 != 0) {
                    this.A.q1(i5 + 3);
                    U1(i5);
                } else {
                    U1(i5);
                }
            }
        } else {
        }
    }

    @Override // com.google.android.material.datepicker.q
    void W1(com.google.android.material.datepicker.i.k i$k) {
        int dAY;
        int i;
        Object obj5;
        this.x = k;
        final int i2 = 8;
        final int i3 = 0;
        if (k == i.k.YEAR) {
            this.z.getLayoutManager().S1((v)this.z.getAdapter().h(mVar.c));
            this.B.setVisibility(i3);
            this.C.setVisibility(i2);
        } else {
            if (k == i.k.DAY) {
                this.B.setVisibility(i2);
                this.C.setVisibility(i3);
                V1(this.w);
            }
        }
    }

    @Override // com.google.android.material.datepicker.q
    void X1() {
        com.google.android.material.datepicker.i.k dAY;
        com.google.android.material.datepicker.i.k dAY2;
        dAY = this.x;
        final com.google.android.material.datepicker.i.k yEAR = i.k.YEAR;
        if (dAY == yEAR) {
            W1(i.k.DAY);
        } else {
            if (dAY == i.k.DAY) {
                W1(yEAR);
            }
        }
    }

    @Override // com.google.android.material.datepicker.q
    public void onCreate(Bundle bundle) {
        Bundle obj2;
        super.onCreate(bundle);
        if (bundle == null) {
            obj2 = getArguments();
        }
        this.b = obj2.getInt("THEME_RES_ID_KEY");
        this.c = (e)obj2.getParcelable("GRID_SELECTOR_KEY");
        this.v = (a)obj2.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.w = (m)obj2.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // com.google.android.material.datepicker.q
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        int integer;
        Object viewById2;
        int i2;
        Object viewById;
        Object gridLayoutManager;
        int i;
        boolean obj13;
        obj13 = new ContextThemeWrapper(getContext(), this.b);
        c cVar = new c(obj13);
        this.y = cVar;
        final int i8 = 1;
        final int i9 = 0;
        i = j.R1(obj13) ? i8 : i9;
        View obj11 = layoutInflater.cloneInContext(obj13).inflate(i2, viewGroup2, i9);
        obj11.setMinimumHeight(i.R1(requireContext()));
        View obj12 = obj11.findViewById(f.G);
        i.b bVar = new i.b(this);
        u.l0((GridView)obj12, bVar);
        h hVar = new h();
        obj12.setAdapter(hVar);
        obj12.setNumColumns(mVar.v);
        obj12.setEnabled(i9);
        this.A = (RecyclerView)obj11.findViewById(f.J);
        super(this, getContext(), i, 0, i);
        this.A.setLayoutManager(obj12);
        this.A.setTag(i.D);
        gridLayoutManager = new i.d(this);
        obj12 = new o(obj13, this.c, this.v, gridLayoutManager);
        this.A.setAdapter(obj12);
        viewById = obj11.findViewById(f.K);
        this.z = (RecyclerView)viewById;
        if (viewById != null) {
            viewById.setHasFixedSize(i8);
            gridLayoutManager = new GridLayoutManager(obj13, obj13.getResources().getInteger(g.c), i8, i9);
            this.z.setLayoutManager(gridLayoutManager);
            v vVar = new v(this);
            this.z.setAdapter(vVar);
            this.z.h(L1());
        }
        if (obj11.findViewById(f.A) != null) {
            K1(obj11, obj12);
        }
        if (!j.R1(obj13)) {
            obj13 = new u();
            obj13.b(this.A);
        }
        this.A.q1(obj12.i(this.w));
        return obj11;
    }

    @Override // com.google.android.material.datepicker.q
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.v);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.w);
    }
}
