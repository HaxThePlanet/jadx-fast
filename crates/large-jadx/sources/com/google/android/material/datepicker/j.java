package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.k;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.google.android.material.internal.CheckableImageButton;
import d.a.k.a.a;
import d.h.l.u;
import f.c.a.e.a0.b;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.d0.g;
import f.c.a.e.e;
import f.c.a.e.f;
import f.c.a.e.h;
import f.c.a.e.j;
import f.c.a.e.k;
import f.c.a.e.s.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public final class j<S>  extends d {

    static final Object J;
    static final Object K;
    static final Object L;
    private com.google.android.material.datepicker.i<S> A;
    private int B;
    private java.lang.CharSequence C;
    private boolean D;
    private int E;
    private TextView F;
    private CheckableImageButton G;
    private g H;
    private Button I;
    private final LinkedHashSet<com.google.android.material.datepicker.k<? super S>> a;
    private final LinkedHashSet<View.OnClickListener> b;
    private final LinkedHashSet<DialogInterface.OnCancelListener> c;
    private final LinkedHashSet<DialogInterface.OnDismissListener> v;
    private int w;
    private com.google.android.material.datepicker.e<S> x;
    private com.google.android.material.datepicker.q<S> y;
    private com.google.android.material.datepicker.a z;

    class a implements View.OnClickListener {

        final com.google.android.material.datepicker.j a;
        a(com.google.android.material.datepicker.j j) {
            this.a = j;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            Object next;
            Object obj;
            Iterator obj3 = j.B1(this.a).iterator();
            for (k next : obj3) {
                next.a(this.a.O1());
            }
            this.a.dismiss();
        }
    }

    class b implements View.OnClickListener {

        final com.google.android.material.datepicker.j a;
        b(com.google.android.material.datepicker.j j) {
            this.a = j;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            Object next;
            Iterator iterator = j.C1(this.a).iterator();
            for (View.OnClickListener next : iterator) {
                next.onClick(view);
            }
            this.a.dismiss();
        }
    }

    class d implements View.OnClickListener {

        final com.google.android.material.datepicker.j a;
        d(com.google.android.material.datepicker.j j) {
            this.a = j;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            j.F1(this.a).setEnabled(j.E1(this.a).l1());
            j.G1(this.a).toggle();
            com.google.android.material.datepicker.j obj2 = this.a;
            j.H1(obj2, j.G1(obj2));
            j.I1(this.a);
        }
    }

    public static final class e {

        final com.google.android.material.datepicker.e<S> a;
        int b = 0;
        com.google.android.material.datepicker.a c;
        int d = 0;
        java.lang.CharSequence e = null;
        S f = 0;
        int g = 0;
        private e(com.google.android.material.datepicker.e<S> e) {
            super();
            final int i = 0;
            final int i2 = 0;
            this.a = e;
        }

        private com.google.android.material.datepicker.m b() {
            boolean empty;
            com.google.android.material.datepicker.m mVar;
            long l;
            empty = m.e((Long)this.a.t1().iterator().next().longValue());
            if (!this.a.t1().isEmpty() && j.e.d(empty, this.c)) {
                empty = m.e((Long)this.a.t1().iterator().next().longValue());
                if (j.e.d(empty, this.c)) {
                    return empty;
                }
            }
            if (j.e.d(m.f(), this.c)) {
            } else {
                mVar = this.c.j();
            }
            return mVar;
        }

        public static com.google.android.material.datepicker.j.e<Long> c() {
            r rVar = new r();
            j.e eVar = new j.e(rVar);
            return eVar;
        }

        private static boolean d(com.google.android.material.datepicker.m m, com.google.android.material.datepicker.a a2) {
            int obj1;
            com.google.android.material.datepicker.m obj2;
            if (m.a(a2.j()) >= 0 && m.a(a2.g()) <= 0) {
                obj1 = m.a(a2.g()) <= 0 ? 1 : 0;
            } else {
            }
            return obj1;
        }

        public com.google.android.material.datepicker.j<S> a() {
            com.google.android.material.datepicker.a aVar;
            int i;
            Object mVar;
            com.google.android.material.datepicker.e eVar;
            if (this.c == null) {
                a.b bVar = new a.b();
                this.c = bVar.a();
            }
            if (this.d == 0) {
                this.d = this.a.I0();
            }
            Object obj = this.f;
            if (obj != null) {
                this.a.U(obj);
            }
            if (this.c.i() == null) {
                this.c.m(b());
            }
            return j.T1(this);
        }

        public com.google.android.material.datepicker.j.e<S> e(S s) {
            this.f = s;
            return this;
        }
    }

    class c extends com.google.android.material.datepicker.p<S> {

        final com.google.android.material.datepicker.j a;
        c(com.google.android.material.datepicker.j j) {
            this.a = j;
            super();
        }

        @Override // com.google.android.material.datepicker.p
        public void a() {
            j.F1(this.a).setEnabled(false);
        }

        public void b(S s) {
            j.D1(this.a);
            j.F1(this.a).setEnabled(j.E1(this.a).l1());
        }
    }
    static {
        j.J = "CONFIRM_BUTTON_TAG";
        j.K = "CANCEL_BUTTON_TAG";
        j.L = "TOGGLE_BUTTON_TAG";
    }

    public j() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.a = linkedHashSet;
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        this.b = linkedHashSet2;
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        this.c = linkedHashSet3;
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        this.v = linkedHashSet4;
    }

    static LinkedHashSet B1(com.google.android.material.datepicker.j j) {
        return j.a;
    }

    static LinkedHashSet C1(com.google.android.material.datepicker.j j) {
        return j.b;
    }

    static void D1(com.google.android.material.datepicker.j j) {
        j.W1();
    }

    static com.google.android.material.datepicker.e E1(com.google.android.material.datepicker.j j) {
        return j.L1();
    }

    static Button F1(com.google.android.material.datepicker.j j) {
        return j.I;
    }

    static CheckableImageButton G1(com.google.android.material.datepicker.j j) {
        return j.G;
    }

    static void H1(com.google.android.material.datepicker.j j, CheckableImageButton checkableImageButton2) {
        j.X1(checkableImageButton2);
    }

    static void I1(com.google.android.material.datepicker.j j) {
        j.V1();
    }

    private static Drawable K1(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = new int[1];
        final int i5 = 0;
        iArr[i5] = 16842912;
        stateListDrawable.addState(iArr, a.d(context, e.b));
        stateListDrawable.addState(new int[i5], a.d(context, e.c));
        return stateListDrawable;
    }

    private com.google.android.material.datepicker.e<S> L1() {
        android.os.Parcelable parcelable;
        String str;
        if (this.x == null) {
            this.x = (e)getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.x;
    }

    private static int N1(Context context) {
        Resources obj4 = context.getResources();
        int i5 = mVar.v;
        return i3 += i7;
    }

    private int P1(Context context) {
        int i = this.w;
        if (i != 0) {
            return i;
        }
        return L1().e1(context);
    }

    private void Q1(Context context) {
        int i;
        this.G.setTag(j.L);
        this.G.setImageDrawable(j.K1(context));
        i = this.E != 0 ? 1 : 0;
        this.G.setChecked(i);
        u.l0(this.G, 0);
        X1(this.G);
        j.d dVar = new j.d(this);
        this.G.setOnClickListener(dVar);
    }

    static boolean R1(Context context) {
        return j.U1(context, 16843277);
    }

    static boolean S1(Context context) {
        return j.U1(context, b.K);
    }

    static <S> com.google.android.material.datepicker.j<S> T1(com.google.android.material.datepicker.j.e<S> j$e) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putInt("OVERRIDE_THEME_RES_ID", e.b);
        bundle.putParcelable("DATE_SELECTOR_KEY", e.a);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", e.c);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", e.d);
        bundle.putCharSequence("TITLE_TEXT_KEY", e.e);
        bundle.putInt("INPUT_MODE_KEY", e.g);
        jVar.setArguments(bundle);
        return jVar;
    }

    static boolean U1(Context context, int i2) {
        int[] iArr = new int[1];
        final int i5 = 0;
        iArr[i5] = i2;
        final TypedArray obj3 = context.obtainStyledAttributes(b.d(context, b.B, i.class.getCanonicalName()), iArr);
        obj3.recycle();
        return obj3.getBoolean(i5, i5);
    }

    private void V1() {
        com.google.android.material.datepicker.q qVar;
        com.google.android.material.datepicker.e checked;
        com.google.android.material.datepicker.a aVar;
        int i = P1(requireContext());
        this.A = i.T1(L1(), i, this.z);
        if (this.G.isChecked()) {
            qVar = l.D1(L1(), i, this.z);
        } else {
            qVar = this.A;
        }
        this.y = qVar;
        W1();
        w wVar = getChildFragmentManager().n();
        wVar.o(f.H, this.y);
        wVar.i();
        j.c cVar = new j.c(this);
        this.y.B1(cVar);
    }

    private void W1() {
        final String str = M1();
        Object[] arr = new Object[1];
        this.F.setContentDescription(String.format(getString(j.u), str));
        this.F.setText(str);
    }

    private void X1(CheckableImageButton checkableImageButton) {
        int i;
        String obj2;
        if (this.G.isChecked()) {
            obj2 = checkableImageButton.getContext().getString(j.H);
        } else {
            obj2 = checkableImageButton.getContext().getString(j.J);
        }
        this.G.setContentDescription(obj2);
    }

    public boolean J1(com.google.android.material.datepicker.k<? super S> k) {
        return this.a.add(k);
    }

    @Override // androidx.fragment.app.d
    public String M1() {
        return L1().E(getContext());
    }

    public final S O1() {
        return L1().z1();
    }

    @Override // androidx.fragment.app.d
    public final void onCancel(DialogInterface dialogInterface) {
        Object next;
        Iterator iterator = this.c.iterator();
        for (DialogInterface.OnCancelListener next : iterator) {
            next.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.d
    public final void onCreate(Bundle bundle) {
        Bundle obj2;
        super.onCreate(bundle);
        if (bundle == null) {
            obj2 = getArguments();
        }
        this.w = obj2.getInt("OVERRIDE_THEME_RES_ID");
        this.x = (e)obj2.getParcelable("DATE_SELECTOR_KEY");
        this.z = (a)obj2.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.B = obj2.getInt("TITLE_TEXT_RES_ID_KEY");
        this.C = obj2.getCharSequence("TITLE_TEXT_KEY");
        this.E = obj2.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.d
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog obj7 = new Dialog(requireContext(), P1(requireContext()));
        Context context = obj7.getContext();
        this.D = j.R1(context);
        g gVar3 = new g(context, 0, b.B, k.y);
        this.H = gVar3;
        gVar3.O(context);
        this.H.Z(ColorStateList.valueOf(b.d(context, b.q, j.class.getCanonicalName())));
        this.H.Y(u.w(obj7.getWindow().getDecorView()));
        return obj7;
    }

    @Override // androidx.fragment.app.d
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        LinearLayout.LayoutParams layoutParams;
        int i2;
        java.lang.CharSequence charSequence;
        int i;
        Button obj5;
        int obj6;
        obj6 = this.D ? h.z : h.y;
        final View obj4 = layoutInflater.inflate(obj6, viewGroup2);
        obj5 = obj4.getContext();
        if (this.D) {
            layoutParams = new LinearLayout.LayoutParams(j.N1(obj5), -2);
            obj4.findViewById(f.H).setLayoutParams(layoutParams);
        } else {
            layoutParams = new LinearLayout.LayoutParams(j.N1(obj5), -1);
            obj4.findViewById(f.I).setLayoutParams(layoutParams);
        }
        obj6 = obj4.findViewById(f.O);
        this.F = (TextView)obj6;
        int i3 = 1;
        u.n0(obj6, i3);
        this.G = (CheckableImageButton)obj4.findViewById(f.P);
        obj6 = obj4.findViewById(f.R);
        charSequence = this.C;
        if (charSequence != null) {
            (TextView)obj6.setText(charSequence);
        } else {
            obj6.setText(this.B);
        }
        Q1(obj5);
        this.I = (Button)obj4.findViewById(f.c);
        if (L1().l1()) {
            this.I.setEnabled(i3);
        } else {
            this.I.setEnabled(false);
        }
        this.I.setTag(j.J);
        obj6 = new j.a(this);
        this.I.setOnClickListener(obj6);
        obj5 = obj4.findViewById(f.a);
        (Button)obj5.setTag(j.K);
        obj6 = new j.b(this);
        obj5.setOnClickListener(obj6);
        return obj4;
    }

    @Override // androidx.fragment.app.d
    public final void onDismiss(DialogInterface dialogInterface) {
        Object next;
        Iterator iterator = this.v.iterator();
        for (DialogInterface.OnDismissListener next : iterator) {
            next.onDismiss(dialogInterface);
        }
        View view = getView();
        if ((ViewGroup)view != null) {
            (ViewGroup)view.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.d
    public final void onSaveInstanceState(Bundle bundle) {
        com.google.android.material.datepicker.m mVar;
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.w);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.x);
        a.b bVar = new a.b(this.z);
        if (this.A.O1() != null) {
            bVar.b(mVar2.x);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.B);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.C);
    }

    @Override // androidx.fragment.app.d
    public void onStart() {
        Object decorView;
        Object rect;
        a aVar;
        Dialog requireDialog;
        g gVar;
        int i;
        int i3;
        int i2;
        int dimensionPixelOffset;
        super.onStart();
        decorView = requireDialog().getWindow();
        if (this.D) {
            int i4 = -1;
            decorView.setLayout(i4, i4);
            decorView.setBackgroundDrawable(this.H);
        } else {
            int i5 = -2;
            decorView.setLayout(i5, i5);
            dimensionPixelOffset = getResources().getDimensionPixelOffset(d.V);
            rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            super(this.H, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            decorView.setBackgroundDrawable(insetDrawable);
            aVar = new a(requireDialog(), rect);
            decorView.getDecorView().setOnTouchListener(aVar);
        }
        V1();
    }

    @Override // androidx.fragment.app.d
    public void onStop() {
        this.y.C1();
        super.onStop();
    }
}
