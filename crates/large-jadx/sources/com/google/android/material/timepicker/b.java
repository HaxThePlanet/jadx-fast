package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import com.google.android.material.button.MaterialButton;
import d.h.l.u;
import f.c.a.e.a0.b;
import f.c.a.e.b;
import f.c.a.e.d0.g;
import f.c.a.e.f;
import f.c.a.e.h;
import f.c.a.e.j;
import f.c.a.e.k;
import f.c.a.e.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class b extends d implements com.google.android.material.timepicker.TimePickerView.e {

    private com.google.android.material.timepicker.g A;
    private int B;
    private int C;
    private int D = 0;
    private java.lang.CharSequence E;
    private int F = 0;
    private java.lang.CharSequence G;
    private int H = 0;
    private java.lang.CharSequence I;
    private MaterialButton J;
    private Button K;
    private int L = 0;
    private com.google.android.material.timepicker.e M;
    private int N = 0;
    private final Set<View.OnClickListener> a;
    private final Set<View.OnClickListener> b;
    private final Set<DialogInterface.OnCancelListener> c;
    private final Set<DialogInterface.OnDismissListener> v;
    private com.google.android.material.timepicker.TimePickerView w;
    private ViewStub x;
    private com.google.android.material.timepicker.f y;
    private com.google.android.material.timepicker.i z;

    class a implements View.OnClickListener {

        final com.google.android.material.timepicker.b a;
        a(com.google.android.material.timepicker.b b) {
            this.a = b;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            Object next;
            Iterator iterator = b.H1(this.a).iterator();
            for (View.OnClickListener next : iterator) {
                next.onClick(view);
            }
            this.a.dismiss();
        }
    }

    class b implements View.OnClickListener {

        final com.google.android.material.timepicker.b a;
        b(com.google.android.material.timepicker.b b) {
            this.a = b;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            Object next;
            Iterator iterator = b.B1(this.a).iterator();
            for (View.OnClickListener next : iterator) {
                next.onClick(view);
            }
            this.a.dismiss();
        }
    }

    class c implements View.OnClickListener {

        final com.google.android.material.timepicker.b a;
        c(com.google.android.material.timepicker.b b) {
            this.a = b;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            int i;
            com.google.android.material.timepicker.b obj2 = this.a;
            i = b.C1(obj2) == 0 ? 1 : 0;
            b.D1(obj2, i);
            obj2 = this.a;
            b.F1(obj2, b.E1(obj2));
        }
    }

    public static final class d {

        private com.google.android.material.timepicker.e a;
        private int b;
        private int c = 0;
        private java.lang.CharSequence d;
        private int e = 0;
        private java.lang.CharSequence f;
        private int g = 0;
        private java.lang.CharSequence h;
        private int i = 0;
        public d() {
            super();
            e eVar = new e();
            this.a = eVar;
            int i = 0;
        }

        static com.google.android.material.timepicker.e a(com.google.android.material.timepicker.b.d b$d) {
            return d.a;
        }

        static int b(com.google.android.material.timepicker.b.d b$d) {
            return d.b;
        }

        static int c(com.google.android.material.timepicker.b.d b$d) {
            return d.c;
        }

        static java.lang.CharSequence d(com.google.android.material.timepicker.b.d b$d) {
            return d.d;
        }

        static int e(com.google.android.material.timepicker.b.d b$d) {
            return d.e;
        }

        static java.lang.CharSequence f(com.google.android.material.timepicker.b.d b$d) {
            return d.f;
        }

        static int g(com.google.android.material.timepicker.b.d b$d) {
            return d.g;
        }

        static java.lang.CharSequence h(com.google.android.material.timepicker.b.d b$d) {
            return d.h;
        }

        static int i(com.google.android.material.timepicker.b.d b$d) {
            return d.i;
        }

        public com.google.android.material.timepicker.b j() {
            return b.G1(this);
        }

        public com.google.android.material.timepicker.b.d k(int i) {
            this.a.h(i);
            return this;
        }

        public com.google.android.material.timepicker.b.d l(int i) {
            this.a.i(i);
            return this;
        }

        public com.google.android.material.timepicker.b.d m(int i) {
            com.google.android.material.timepicker.e eVar = this.a;
            e eVar2 = new e(i);
            this.a = eVar2;
            eVar2.i(eVar.w);
            this.a.h(eVar.v);
            return this;
        }
    }
    public b() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.a = linkedHashSet;
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        this.b = linkedHashSet2;
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        this.c = linkedHashSet3;
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        this.v = linkedHashSet4;
        int i = 0;
    }

    static Set B1(com.google.android.material.timepicker.b b) {
        return b.b;
    }

    static int C1(com.google.android.material.timepicker.b b) {
        return b.L;
    }

    static int D1(com.google.android.material.timepicker.b b, int i2) {
        b.L = i2;
        return i2;
    }

    static MaterialButton E1(com.google.android.material.timepicker.b b) {
        return b.J;
    }

    static void F1(com.google.android.material.timepicker.b b, MaterialButton materialButton2) {
        b.R1(materialButton2);
    }

    static com.google.android.material.timepicker.b G1(com.google.android.material.timepicker.b.d b$d) {
        return b.O1(d);
    }

    static Set H1(com.google.android.material.timepicker.b b) {
        return b.a;
    }

    private Pair<Integer, Integer> J1(int i) {
        if (i != 0) {
            if (i != 1) {
            } else {
                Pair obj4 = new Pair(Integer.valueOf(this.C), Integer.valueOf(j.m));
                return obj4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("no icon for mode: ");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        obj4 = new Pair(Integer.valueOf(this.B), Integer.valueOf(j.p));
        return obj4;
    }

    private int M1() {
        int data;
        int i = this.N;
        if (i != 0) {
            return i;
        }
        android.util.TypedValue typedValue = b.a(requireContext(), b.H);
        data = typedValue == null ? 0 : typedValue.data;
        return data;
    }

    private com.google.android.material.timepicker.g N1(int i, com.google.android.material.timepicker.TimePickerView timePickerView2, ViewStub viewStub3) {
        com.google.android.material.timepicker.f obj1;
        Object obj2;
        com.google.android.material.timepicker.e obj3;
        if (i == 0 && this.y == null) {
            if (this.y == null) {
                obj1 = new f(timePickerView2, this.M);
            }
            this.y = obj1;
            return obj1;
        }
        if (this.z == null) {
            obj2 = new i((LinearLayout)viewStub3.inflate(), this.M);
            this.z = obj2;
        }
        this.z.e();
        return this.z;
    }

    private static com.google.android.material.timepicker.b O1(com.google.android.material.timepicker.b.d b$d) {
        java.lang.CharSequence charSequence;
        java.lang.CharSequence charSequence2;
        java.lang.CharSequence charSequence3;
        String str;
        String str3;
        String str2;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", b.d.a(d));
        bundle.putInt("TIME_PICKER_INPUT_MODE", b.d.b(d));
        bundle.putInt("TIME_PICKER_TITLE_RES", b.d.c(d));
        if (b.d.d(d) != null) {
            bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", b.d.d(d));
        }
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", b.d.e(d));
        if (b.d.f(d) != null) {
            bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", b.d.f(d));
        }
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", b.d.g(d));
        if (b.d.h(d) != null) {
            bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", b.d.h(d));
        }
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", b.d.i(d));
        bVar.setArguments(bundle);
        return bVar;
    }

    private void P1(Bundle bundle) {
        android.os.Parcelable parcelable;
        if (bundle == null) {
        }
        parcelable = bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.M = (e)parcelable;
        if (parcelable == null) {
            parcelable = new e();
            this.M = parcelable;
        }
        final int i = 0;
        this.L = bundle.getInt("TIME_PICKER_INPUT_MODE", i);
        this.D = bundle.getInt("TIME_PICKER_TITLE_RES", i);
        this.E = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.F = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", i);
        this.G = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.H = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", i);
        this.I = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.N = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", i);
    }

    private void Q1() {
        int i;
        final Button button = this.K;
        if (button != null) {
            i = isCancelable() ? 0 : 8;
            button.setVisibility(i);
        }
    }

    private void R1(MaterialButton materialButton) {
        com.google.android.material.timepicker.TimePickerView time;
        Resources resources;
        ViewStub view;
        if (materialButton != null && this.w != null) {
            if (this.w != null) {
                if (this.x == null) {
                } else {
                    com.google.android.material.timepicker.g gVar = this.A;
                    if (gVar != null) {
                        gVar.g();
                    }
                    com.google.android.material.timepicker.g gVar2 = N1(this.L, this.w, this.x);
                    this.A = gVar2;
                    gVar2.a();
                    this.A.c();
                    Pair pair = J1(this.L);
                    materialButton.setIconResource((Integer)pair.first.intValue());
                    materialButton.setContentDescription(getResources().getString((Integer)pair.second.intValue()));
                    materialButton.sendAccessibilityEvent(4);
                }
            }
        }
    }

    @Override // androidx.fragment.app.d
    public boolean I1(View.OnClickListener view$OnClickListener) {
        return this.a.add(onClickListener);
    }

    @Override // androidx.fragment.app.d
    public int K1() {
        return i %= 24;
    }

    @Override // androidx.fragment.app.d
    public int L1() {
        return eVar.w;
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
    public void onCreate(Bundle bundle) {
        Bundle obj1;
        super.onCreate(bundle);
        if (bundle == null) {
            obj1 = getArguments();
        }
        P1(obj1);
    }

    @Override // androidx.fragment.app.d
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog obj8 = new Dialog(requireContext(), M1());
        Context context = obj8.getContext();
        int i6 = b.G;
        int i7 = k.A;
        int i10 = 0;
        g gVar = new g(context, i10, i6, i7);
        TypedArray styledAttributes = context.obtainStyledAttributes(i10, l.s3, i6, i7);
        int i11 = 0;
        this.C = styledAttributes.getResourceId(l.t3, i11);
        this.B = styledAttributes.getResourceId(l.u3, i11);
        styledAttributes.recycle();
        gVar.O(context);
        gVar.Z(ColorStateList.valueOf(b.d(context, b.q, b.class.getCanonicalName())));
        Window window = obj8.getWindow();
        window.setBackgroundDrawable(gVar);
        window.requestFeature(1);
        int i5 = -2;
        window.setLayout(i5, i5);
        gVar.Y(u.w(window.getDecorView()));
        return obj8;
    }

    @Override // androidx.fragment.app.d
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        boolean obj2;
        boolean obj3;
        final View obj1 = layoutInflater.inflate(h.p, viewGroup2);
        obj2 = (ViewGroup)obj1.findViewById(f.x);
        this.w = (TimePickerView)obj2;
        obj2.F(this);
        this.x = (ViewStub)obj1.findViewById(f.t);
        this.J = (MaterialButton)obj1.findViewById(f.v);
        obj2 = obj1.findViewById(f.h);
        obj3 = this.D;
        if (obj3 != null) {
            (TextView)obj2.setText(obj3);
        } else {
            if (!TextUtils.isEmpty(this.E)) {
                obj2.setText(this.E);
            }
        }
        R1(this.J);
        obj2 = obj1.findViewById(f.w);
        obj3 = new b.a(this);
        (Button)obj2.setOnClickListener(obj3);
        obj3 = this.F;
        if (obj3 != null) {
            obj2.setText(obj3);
        } else {
            if (!TextUtils.isEmpty(this.G)) {
                obj2.setText(this.G);
            }
        }
        obj2 = obj1.findViewById(f.u);
        this.K = (Button)obj2;
        obj3 = new b.b(this);
        obj2.setOnClickListener(obj3);
        obj2 = this.H;
        if (obj2 != null) {
            this.K.setText(obj2);
        } else {
            if (!TextUtils.isEmpty(this.I)) {
                this.K.setText(this.I);
            }
        }
        Q1();
        obj3 = new b.c(this);
        this.J.setOnClickListener(obj3);
        return obj1;
    }

    @Override // androidx.fragment.app.d
    public void onDestroyView() {
        super.onDestroyView();
        final int i = 0;
        this.A = i;
        this.y = i;
        this.z = i;
        final com.google.android.material.timepicker.TimePickerView time = this.w;
        if (time != null) {
            time.F(i);
            this.w = i;
        }
    }

    @Override // androidx.fragment.app.d
    public final void onDismiss(DialogInterface dialogInterface) {
        Object next;
        Iterator iterator = this.v.iterator();
        for (DialogInterface.OnDismissListener next : iterator) {
            next.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.d
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.M);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.L);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.D);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.E);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.F);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.G);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.H);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.I);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.N);
    }

    @Override // androidx.fragment.app.d
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        Q1();
    }

    @Override // androidx.fragment.app.d
    public void w0() {
        this.L = 1;
        R1(this.J);
        this.z.j();
    }
}
