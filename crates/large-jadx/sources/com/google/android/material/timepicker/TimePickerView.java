package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButtonToggleGroup.e;
import com.google.android.material.chip.Chip;
import d.h.l.a;
import d.h.l.u;
import f.c.a.e.f;
import f.c.a.e.h;

/* loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout {

    private final Chip M;
    private final Chip N;
    private final com.google.android.material.timepicker.ClockHandView O;
    private final com.google.android.material.timepicker.ClockFaceView P;
    private final MaterialButtonToggleGroup Q;
    private final View.OnClickListener R;
    private com.google.android.material.timepicker.TimePickerView.f S;
    private com.google.android.material.timepicker.TimePickerView.g T;
    private com.google.android.material.timepicker.TimePickerView.e U;

    class a implements View.OnClickListener {

        final com.google.android.material.timepicker.TimePickerView a;
        a(com.google.android.material.timepicker.TimePickerView timePickerView) {
            this.a = timePickerView;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            com.google.android.material.timepicker.TimePickerView.g time;
            int i;
            int obj3;
            if (TimePickerView.v(this.a) != null) {
                TimePickerView.v(this.a).f((Integer)view.getTag(f.Z).intValue());
            }
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {

        final com.google.android.material.timepicker.TimePickerView a;
        c(com.google.android.material.timepicker.TimePickerView timePickerView) {
            this.a = timePickerView;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            com.google.android.material.timepicker.TimePickerView.e obj1 = TimePickerView.x(this.a);
            if (obj1 != null) {
                obj1.w0();
                return 1;
            }
            return 0;
        }
    }

    class d implements View.OnTouchListener {

        final GestureDetector a;
        d(com.google.android.material.timepicker.TimePickerView timePickerView, GestureDetector gestureDetector2) {
            this.a = gestureDetector2;
            super();
        }

        @Override // android.view.View$OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent2) {
            if ((Checkable)view.isChecked()) {
                return this.a.onTouchEvent(motionEvent2);
            }
            return 0;
        }
    }

    interface e {
        public abstract void w0();
    }

    interface f {
        public abstract void e(int i);
    }

    interface g {
        public abstract void f(int i);
    }

    class b implements MaterialButtonToggleGroup.e {

        final com.google.android.material.timepicker.TimePickerView a;
        b(com.google.android.material.timepicker.TimePickerView timePickerView) {
            this.a = timePickerView;
            super();
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup$e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z3) {
            int obj1;
            com.google.android.material.timepicker.TimePickerView.f obj2;
            obj1 = i2 == f.m ? 1 : 0;
            if (TimePickerView.w(this.a) != null && z3) {
                if (z3) {
                    TimePickerView.w(this.a).e(obj1);
                }
            }
        }
    }
    public TimePickerView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public TimePickerView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        TimePickerView.a obj2 = new TimePickerView.a(this);
        this.R = obj2;
        LayoutInflater.from(context).inflate(h.o, this);
        this.P = (ClockFaceView)findViewById(f.j);
        View obj1 = findViewById(f.n);
        this.Q = (MaterialButtonToggleGroup)obj1;
        obj2 = new TimePickerView.b(this);
        obj1.g(obj2);
        obj1 = findViewById(f.s);
        this.M = (Chip)obj1;
        obj2 = findViewById(f.p);
        this.N = (Chip)obj2;
        this.O = (ClockHandView)findViewById(f.k);
        int obj3 = 2;
        u.n0(obj1, obj3);
        u.n0(obj2, obj3);
        K();
        I();
    }

    private void I() {
        int i = f.Z;
        this.M.setTag(i, 12);
        this.N.setTag(i, 10);
        this.M.setOnClickListener(this.R);
        this.N.setOnClickListener(this.R);
    }

    private void K() {
        TimePickerView.c cVar = new TimePickerView.c(this);
        GestureDetector gestureDetector = new GestureDetector(getContext(), cVar);
        TimePickerView.d dVar = new TimePickerView.d(this, gestureDetector);
        this.M.setOnTouchListener(dVar);
        this.N.setOnTouchListener(dVar);
    }

    private void N() {
        int visibility;
        int i2;
        int i3;
        int i;
        if (this.Q.getVisibility() == 0) {
            visibility = new d();
            visibility.g(this);
            i3 = u.B(this) == 0 ? i : 0;
            if (i3 != 0) {
                i = 2;
            }
            visibility.e(f.i, i);
            visibility.c(this);
        }
    }

    static com.google.android.material.timepicker.TimePickerView.g v(com.google.android.material.timepicker.TimePickerView timePickerView) {
        return timePickerView.T;
    }

    static com.google.android.material.timepicker.TimePickerView.f w(com.google.android.material.timepicker.TimePickerView timePickerView) {
        return timePickerView.S;
    }

    static com.google.android.material.timepicker.TimePickerView.e x(com.google.android.material.timepicker.TimePickerView timePickerView) {
        return timePickerView.U;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void A(boolean z) {
        this.O.j(z);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void B(float f, boolean z2) {
        this.O.m(f, z2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void C(a a) {
        u.l0(this.M, a);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void D(a a) {
        u.l0(this.N, a);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void E(com.google.android.material.timepicker.ClockHandView.c clockHandView$c) {
        this.O.o(c);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void F(com.google.android.material.timepicker.TimePickerView.e timePickerView$e) {
        this.U = e;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void G(com.google.android.material.timepicker.TimePickerView.f timePickerView$f) {
        this.S = f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void H(com.google.android.material.timepicker.TimePickerView.g timePickerView$g) {
        this.T = g;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void J(String[] stringArr, int i2) {
        this.P.H(stringArr, i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void L() {
        this.Q.setVisibility(0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void M(int i, int i2, int i3) {
        int obj4;
        int i4 = 1;
        obj4 = i == i4 ? f.m : f.l;
        this.Q.j(obj4);
        obj4 = obj4.locale;
        Object[] arr2 = new Object[i4];
        final int i5 = 0;
        arr2[i5] = Integer.valueOf(i3);
        String obj6 = "%02d";
        Object[] arr = new Object[i4];
        arr[i5] = Integer.valueOf(i2);
        this.M.setText(String.format(obj4, obj6, arr2));
        this.N.setText(String.format(obj4, obj6, arr));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        N();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            if (i2 == 0) {
                N();
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void y(com.google.android.material.timepicker.ClockHandView.d clockHandView$d) {
        this.O.b(d);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void z(int i) {
        int i3;
        int i2;
        final int i4 = 0;
        i2 = i == 12 ? i3 : i4;
        this.M.setChecked(i2);
        if (i == 10) {
        } else {
            i3 = i4;
        }
        this.N.setChecked(i3);
    }
}
