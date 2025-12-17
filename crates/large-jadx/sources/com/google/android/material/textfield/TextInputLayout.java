package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.k;
import androidx.appcompat.widget.t0;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.k;
import com.google.android.exoplayer2.audio.AudioSink.WriteException;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.a;
import com.google.android.material.internal.b;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.theme.a.a;
import d.a.k.a.a;
import d.h.j.a;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.h;
import d.h.l.u;
import d.j.a.a;
import d.u.d;
import d.u.o;
import d.u.q;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.c;
import f.c.a.e.d;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.f;
import f.c.a.e.h;
import f.c.a.e.j;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.m.a;
import f.c.a.e.r.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {

    private static final int f1;
    private final com.google.android.material.textfield.f A;
    private final CheckableImageButton A0;
    boolean B;
    private final LinkedHashSet<com.google.android.material.textfield.TextInputLayout.g> B0;
    private int C;
    private ColorStateList C0;
    private boolean D;
    private boolean D0;
    private TextView E;
    private PorterDuff.Mode E0;
    private int F;
    private boolean F0;
    private int G;
    private Drawable G0;
    private java.lang.CharSequence H;
    private int H0;
    private boolean I;
    private Drawable I0;
    private TextView J;
    private View.OnLongClickListener J0;
    private ColorStateList K;
    private View.OnLongClickListener K0;
    private int L;
    private final CheckableImageButton L0;
    private d M;
    private ColorStateList M0;
    private d N;
    private ColorStateList N0;
    private ColorStateList O;
    private ColorStateList O0;
    private ColorStateList P;
    private int P0;
    private java.lang.CharSequence Q;
    private int Q0;
    private final TextView R;
    private int R0;
    private java.lang.CharSequence S;
    private ColorStateList S0;
    private final TextView T;
    private int T0;
    private boolean U;
    private int U0;
    private java.lang.CharSequence V;
    private int V0;
    private boolean W;
    private int W0;
    private int X0;
    private boolean Y0;
    final a Z0;
    private final FrameLayout a;
    private g a0;
    private boolean a1;
    private final LinearLayout b;
    private g b0;
    private boolean b1;
    private final LinearLayout c;
    private k c0;
    private ValueAnimator c1;
    private final int d0;
    private boolean d1;
    private int e0;
    private boolean e1;
    private int f0;
    private int g0;
    private int h0;
    private int i0;
    private int j0;
    private int k0;
    private final Rect l0;
    private final Rect m0;
    private final RectF n0;
    private Typeface o0;
    private final CheckableImageButton p0;
    private ColorStateList q0;
    private boolean r0;
    private PorterDuff.Mode s0;
    private boolean t0;
    private Drawable u0;
    private final FrameLayout v;
    private int v0;
    EditText w;
    private View.OnLongClickListener w0;
    private java.lang.CharSequence x;
    private final LinkedHashSet<com.google.android.material.textfield.TextInputLayout.f> x0;
    private int y;
    private int y0;
    private int z;
    private final SparseArray<com.google.android.material.textfield.e> z0;

    class a implements TextWatcher {

        final com.google.android.material.textfield.TextInputLayout a;
        a(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            this.a = textInputLayout;
            super();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z;
            boolean length;
            int obj3;
            com.google.android.material.textfield.TextInputLayout textInputLayout = this.a;
            textInputLayout.w0(z2 ^= 1);
            com.google.android.material.textfield.TextInputLayout textInputLayout2 = this.a;
            if (textInputLayout2.B) {
                textInputLayout2.p0(editable.length());
            }
            if (TextInputLayout.b(this.a)) {
                TextInputLayout.c(this.a, editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements Runnable {

        final com.google.android.material.textfield.TextInputLayout a;
        b(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            this.a = textInputLayout;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.d(this.a).performClick();
            TextInputLayout.d(this.a).jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {

        final com.google.android.material.textfield.TextInputLayout a;
        c(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            this.a = textInputLayout;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            textInputLayout.w.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.textfield.TextInputLayout a;
        d(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            this.a = textInputLayout;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            textInputLayout.Z0.Z((Float)valueAnimator.getAnimatedValue().floatValue());
        }
    }

    public interface f {
        public abstract void a(com.google.android.material.textfield.TextInputLayout textInputLayout);
    }

    public interface g {
        public abstract void a(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2);
    }

    public static class e extends a {

        private final com.google.android.material.textfield.TextInputLayout d;
        public e(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            super();
            this.d = textInputLayout;
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            int length;
            String string;
            java.lang.CharSequence error;
            Object placeholderText;
            int stringBuilder;
            int counterMaxLength;
            int stringBuilder2;
            int i;
            boolean empty;
            boolean empty2;
            int obj15;
            super.g(view, c2);
            EditText obj14 = this.d.getEditText();
            if (obj14 != null) {
                length = obj14.getText();
            } else {
                length = 0;
            }
            java.lang.CharSequence hint = this.d.getHint();
            placeholderText = this.d.getPlaceholderText();
            java.lang.CharSequence counterOverflowDescription = this.d.getCounterOverflowDescription();
            final int i4 = 1;
            empty3 ^= i4;
            empty5 ^= i4;
            if (i6 == 0) {
                if (!TextUtils.isEmpty(counterOverflowDescription)) {
                    i = i4;
                } else {
                    i = 0;
                }
            } else {
            }
            if (empty4 ^= i4 != 0) {
                string = hint.toString();
            } else {
                string = "";
            }
            String str = ", ";
            if (i3 != 0) {
                c2.u0(length);
            } else {
                if (!TextUtils.isEmpty(string)) {
                    c2.u0(string);
                    if (z ^= i4 != 0 && placeholderText != null) {
                        if (placeholderText != null) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(string);
                            stringBuilder2.append(str);
                            stringBuilder2.append(placeholderText);
                            c2.u0(stringBuilder2.toString());
                        }
                    }
                } else {
                    if (placeholderText != null) {
                        c2.u0(placeholderText);
                    }
                }
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    c2.i0(string);
                } else {
                    if (i3 != 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(length);
                        stringBuilder.append(str);
                        stringBuilder.append(string);
                        string = stringBuilder.toString();
                    }
                    c2.u0(string);
                }
                c2.r0(i3 ^ 1);
            }
            if (length != 0 && length.length() == this.d.getCounterMaxLength()) {
                if (length.length() == this.d.getCounterMaxLength()) {
                } else {
                    counterMaxLength = -1;
                }
            } else {
            }
            c2.j0(counterMaxLength);
            if (i != 0) {
                if (i6 != 0) {
                } else {
                    error = counterOverflowDescription;
                }
                c2.e0(error);
            }
            if (Build.VERSION.SDK_INT >= 17 && obj14 != null) {
                if (obj14 != null) {
                    obj14.setLabelFor(f.f0);
                }
            }
        }
    }

    static class h extends a {

        public static final Parcelable.Creator<com.google.android.material.textfield.TextInputLayout.h> CREATOR;
        java.lang.CharSequence c;
        boolean v;
        java.lang.CharSequence w;
        java.lang.CharSequence x;
        java.lang.CharSequence y;
        static {
            TextInputLayout.h.a aVar = new TextInputLayout.h.a();
            TextInputLayout.h.CREATOR = aVar;
        }

        h(Parcel parcel, java.lang.ClassLoader classLoader2) {
            int i;
            super(parcel, classLoader2);
            this.c = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 1) {
            } else {
                i = 0;
            }
            this.v = i;
            this.w = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.x = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.y = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // d.j.a.a
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TextInputLayout.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" error=");
            stringBuilder.append(this.c);
            stringBuilder.append(" hint=");
            stringBuilder.append(this.w);
            stringBuilder.append(" helperText=");
            stringBuilder.append(this.x);
            stringBuilder.append(" placeholderText=");
            stringBuilder.append(this.y);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.c, parcel, i2);
            parcel.writeInt(this.v);
            TextUtils.writeToParcel(this.w, parcel, i2);
            TextUtils.writeToParcel(this.x, parcel, i2);
            TextUtils.writeToParcel(this.y, parcel, i2);
        }
    }
    static {
        TextInputLayout.f1 = k.n;
    }

    public TextInputLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.X);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet2, int i3) {
        int i25;
        int i12;
        ColorStateList colorForState;
        int i7;
        int i16;
        int i11;
        int i6;
        int list;
        int i;
        Object layoutParams;
        int i27;
        int i21;
        int i2;
        int i23;
        boolean layoutParams3;
        int i13;
        int i9;
        int i24;
        boolean z3;
        int i4;
        int i17;
        int i14;
        int i10;
        int i18;
        int i26;
        int i5;
        int i22;
        int i20;
        int i15;
        float iArr;
        boolean z5;
        float f;
        int bVar;
        int i19;
        boolean z4;
        boolean z2;
        boolean z;
        boolean layoutParams2;
        int i8;
        final Object obj = this;
        AttributeSet set2 = attributeSet2;
        int i101 = i3;
        int i113 = TextInputLayout.f1;
        super(a.c(context, set2, i101, i113), set2, i101);
        int i122 = -1;
        obj.y = i122;
        obj.z = i122;
        f fVar = new f(obj);
        obj.A = fVar;
        Rect rect = new Rect();
        obj.l0 = rect;
        Rect rect2 = new Rect();
        obj.m0 = rect2;
        RectF rectF = new RectF();
        obj.n0 = rectF;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        obj.x0 = linkedHashSet;
        int i129 = 0;
        obj.y0 = i129;
        SparseArray sparseArray = new SparseArray();
        obj.z0 = sparseArray;
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        obj.B0 = linkedHashSet2;
        a aVar = new a(obj);
        obj.Z0 = aVar;
        final Context context8 = getContext();
        int i133 = 1;
        obj.setOrientation(i133);
        obj.setWillNotDraw(i129);
        obj.setAddStatesFromChildren(i133);
        FrameLayout frameLayout = new FrameLayout(context8);
        obj.a = frameLayout;
        frameLayout.setAddStatesFromChildren(i133);
        obj.addView(frameLayout);
        LinearLayout linearLayout4 = new LinearLayout(context8);
        obj.b = linearLayout4;
        linearLayout4.setOrientation(i129);
        int i135 = -2;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i135, i122, 8388611);
        linearLayout4.setLayoutParams(layoutParams6);
        frameLayout.addView(linearLayout4);
        LinearLayout linearLayout8 = new LinearLayout(context8);
        obj.c = linearLayout8;
        linearLayout8.setOrientation(i129);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i135, i122, 8388613);
        linearLayout8.setLayoutParams(layoutParams4);
        frameLayout.addView(linearLayout8);
        FrameLayout frameLayout2 = new FrameLayout(context8);
        obj.v = frameLayout2;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i135, i122);
        frameLayout2.setLayoutParams(layoutParams5);
        android.animation.TimeInterpolator time = a.a;
        aVar.e0(time);
        aVar.b0(time);
        aVar.P(8388659);
        int[] iArr6 = new int[5];
        int g5 = l.G5;
        iArr6[i129] = g5;
        int e5 = l.E5;
        iArr6[i133] = e5;
        int t5 = l.T5;
        iArr6[2] = t5;
        int y5 = l.Y5;
        iArr6[3] = y5;
        int i131 = l.c6;
        iArr6[4] = i131;
        t0 t0Var = l.i(context8, attributeSet2, l.l5, i3, i113, iArr6);
        obj.U = t0Var.a(l.b6, i133);
        obj.setHint(t0Var.p(l.q5));
        obj.b1 = t0Var.a(l.a6, i133);
        obj.a1 = t0Var.a(l.V5, i133);
        i25 = l.p5;
        if (t0Var.s(i25)) {
            obj.setMinWidth(t0Var.f(i25, i122));
        }
        i12 = l.o5;
        if (t0Var.s(i12)) {
            obj.setMaxWidth(t0Var.f(i12, i122));
        }
        obj.c0 = k.e(context8, set2, i101, i113).m();
        obj.d0 = context8.getResources().getDimensionPixelOffset(d.o0);
        obj.f0 = t0Var.e(l.t5, 0);
        obj.h0 = t0Var.f(l.A5, context8.getResources().getDimensionPixelSize(d.p0));
        obj.i0 = t0Var.f(l.B5, context8.getResources().getDimensionPixelSize(d.q0));
        obj.g0 = obj.h0;
        int i82 = -1082130432;
        float f2 = t0Var.d(l.x5, i82);
        iArr = t0Var.d(l.w5, i82);
        f = t0Var.d(l.u5, i82);
        float f3 = t0Var.d(l.v5, i82);
        bVar = obj.c0.v();
        int i99 = 0;
        if (Float.compare(f2, i99) >= 0) {
            bVar.C(f2);
        }
        if (Float.compare(iArr, i99) >= 0) {
            bVar.G(iArr);
        }
        if (Float.compare(f, i99) >= 0) {
            bVar.y(f);
        }
        if (Float.compare(f3, i99) >= 0) {
            bVar.u(f3);
        }
        obj.c0 = bVar.m();
        colorForState = c.b(context8, t0Var, l.r5);
        if (colorForState != null) {
            int defaultColor = colorForState.getDefaultColor();
            obj.T0 = defaultColor;
            obj.k0 = defaultColor;
            int i93 = -16842910;
            if (colorForState.isStateful()) {
                int[] iArr3 = new int[i133];
                iArr3[0] = i93;
                obj.U0 = colorForState.getColorForState(iArr3, i122);
                i15 = 2;
                int[] iArr4 = new int[i15];
                iArr4 = new int[]{16842908, 16842910};
                obj.V0 = colorForState.getColorForState(iArr4, i122);
                iArr = new int[i15];
                iArr = new int[]{16843623, 16842910};
                obj.W0 = colorForState.getColorForState(iArr, i122);
            } else {
                i15 = 2;
                obj.V0 = obj.T0;
                ColorStateList list2 = a.c(context8, c.h);
                int[] iArr5 = new int[i133];
                bVar = 0;
                iArr5[bVar] = i93;
                obj.U0 = list2.getColorForState(iArr5, i122);
                iArr = new int[i133];
                iArr[bVar] = 16843623;
                obj.W0 = list2.getColorForState(iArr, i122);
            }
        } else {
            i15 = 2;
            bVar = 0;
            obj.k0 = bVar;
            obj.T0 = bVar;
            obj.U0 = bVar;
            obj.V0 = bVar;
            obj.W0 = bVar;
        }
        i7 = l.n5;
        if (t0Var.s(i7)) {
            i7 = t0Var.c(i7);
            obj.O0 = i7;
            obj.N0 = i7;
        }
        int i43 = l.y5;
        ColorStateList list3 = c.b(context8, t0Var, i43);
        obj.R0 = t0Var.b(i43, 0);
        obj.P0 = a.d(context8, c.i);
        obj.X0 = a.d(context8, c.j);
        obj.Q0 = a.d(context8, c.k);
        if (list3 != null) {
            obj.setBoxStrokeColorStateList(list3);
        }
        i16 = l.z5;
        if (t0Var.s(i16)) {
            obj.setBoxStrokeErrorColor(c.b(context8, t0Var, i16));
        }
        if (t0Var.n(i131, i122) != i122) {
            obj.setHintTextAppearance(t0Var.n(i131, 0));
        } else {
            i11 = 0;
        }
        int i102 = h.h;
        View inflate2 = LayoutInflater.from(getContext()).inflate(i102, linearLayout8, i11);
        obj.L0 = (CheckableImageButton)inflate2;
        inflate2.setId(f.c0);
        inflate2.setVisibility(8);
        if (c.g(context8)) {
            h.d((ViewGroup.MarginLayoutParams)inflate2.getLayoutParams(), i11);
        }
        i6 = l.Q5;
        if (t0Var.s(i6)) {
            obj.setErrorIconDrawable(t0Var.g(i6));
        }
        list = l.R5;
        if (t0Var.s(list)) {
            obj.setErrorIconTintList(c.b(context8, t0Var, list));
        }
        i = l.S5;
        if (t0Var.s(i)) {
            obj.setErrorIconTintMode(n.f(t0Var.k(i, i122), 0));
        }
        inflate2.setContentDescription(getResources().getText(j.f));
        u.v0(inflate2, i15);
        int i52 = 0;
        inflate2.setClickable(i52);
        inflate2.setPressable(i52);
        inflate2.setFocusable(i52);
        obj.setCounterMaxLength(t0Var.k(l.D5, -1));
        int i126 = 0;
        obj.G = t0Var.n(g5, i126);
        obj.F = t0Var.n(e5, i126);
        layoutParams = LayoutInflater.from(getContext()).inflate(h.i, obj.b, i126);
        obj.p0 = (CheckableImageButton)layoutParams;
        layoutParams.setVisibility(8);
        if (c.g(context8)) {
            h.c((ViewGroup.MarginLayoutParams)layoutParams.getLayoutParams(), i126);
        }
        int i60 = 0;
        obj.setStartIconOnClickListener(i60);
        obj.setStartIconOnLongClickListener(i60);
        i21 = l.r6;
        obj.setStartIconDrawable(t0Var.g(i21));
        i27 = l.q6;
        if (t0Var.s(i21) && t0Var.s(i27)) {
            obj.setStartIconDrawable(t0Var.g(i21));
            i27 = l.q6;
            if (t0Var.s(i27)) {
                obj.setStartIconContentDescription(t0Var.p(i27));
            }
            obj.setStartIconCheckable(t0Var.a(l.p6, true));
        }
        i2 = l.s6;
        if (t0Var.s(i2)) {
            obj.setStartIconTintList(c.b(context8, t0Var, i2));
        }
        i23 = l.t6;
        if (t0Var.s(i23)) {
            obj.setStartIconTintMode(n.f(t0Var.k(i23, -1), 0));
        }
        int i118 = 0;
        obj.setBoxBackgroundMode(t0Var.k(l.s5, i118));
        obj.A0 = (CheckableImageButton)LayoutInflater.from(getContext()).inflate(i102, obj.v, i118);
        obj.v.addView(obj.A0);
        obj.A0.setVisibility(8);
        if (c.g(context8)) {
            h.d((ViewGroup.MarginLayoutParams)obj.A0.getLayoutParams(), 0);
        } else {
            i19 = 0;
        }
        int i64 = t0Var.n(l.K5, i19);
        b bVar3 = new b(obj, i64);
        obj.z0.append(-1, bVar3);
        h hVar = new h(obj);
        obj.z0.append(i19, hVar);
        if (i64 == 0) {
            i8 = t0Var.n(l.f6, i19);
        } else {
            i8 = i64;
        }
        i iVar = new i(obj, i8);
        obj.z0.append(1, iVar);
        a aVar2 = new a(obj, i64);
        obj.z0.append(2, aVar2);
        d dVar = new d(obj, i64);
        obj.z0.append(3, dVar);
        int l5 = l.L5;
        if (t0Var.s(l5)) {
            obj.setEndIconMode(t0Var.k(l5, 0));
            i20 = l.J5;
            if (t0Var.s(i20)) {
                obj.setEndIconContentDescription(t0Var.p(i20));
            }
            obj.setEndIconCheckable(t0Var.a(l.I5, true));
        } else {
            i9 = l.g6;
            obj.setEndIconMode(t0Var.a(i9, false));
            obj.setEndIconContentDescription(t0Var.p(l.e6));
            i13 = l.h6;
            if (t0Var.s(i9) && t0Var.s(i13)) {
                obj.setEndIconMode(t0Var.a(i9, false));
                obj.setEndIconContentDescription(t0Var.p(l.e6));
                i13 = l.h6;
                if (t0Var.s(i13)) {
                    obj.setEndIconTintList(c.b(context8, t0Var, i13));
                }
                i9 = l.i6;
                if (t0Var.s(i9)) {
                    obj.setEndIconTintMode(n.f(t0Var.k(i9, -1), 0));
                }
            }
        }
        i24 = l.M5;
        if (!t0Var.s(l.g6) && t0Var.s(i24)) {
            i24 = l.M5;
            if (t0Var.s(i24)) {
                obj.setEndIconTintList(c.b(context8, t0Var, i24));
            }
            z3 = l.N5;
            if (t0Var.s(z3)) {
                obj.setEndIconTintMode(n.f(t0Var.k(z3, -1), 0));
            }
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(context8);
        obj.R = appCompatTextView;
        appCompatTextView.setId(f.h0);
        int i119 = -2;
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(i119, i119);
        appCompatTextView.setLayoutParams(layoutParams7);
        u.n0(appCompatTextView, 1);
        obj.b.addView(obj.p0);
        obj.b.addView(appCompatTextView);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(context8);
        obj.T = appCompatTextView2;
        appCompatTextView2.setId(f.i0);
        int i128 = -2;
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(i128, i128, 80);
        appCompatTextView2.setLayoutParams(layoutParams8);
        u.n0(appCompatTextView2, 1);
        obj.c.addView(obj.T);
        obj.c.addView(obj.L0);
        obj.c.addView(obj.v);
        obj.setHelperTextEnabled(t0Var.a(l.X5, i52));
        obj.setHelperText(t0Var.p(l.W5));
        obj.setHelperTextTextAppearance(t0Var.n(y5, i52));
        obj.setErrorEnabled(t0Var.a(l.P5, i11));
        obj.setErrorTextAppearance(t0Var.n(t5, i11));
        obj.setErrorContentDescription(t0Var.p(l.O5));
        obj.setCounterTextAppearance(obj.G);
        obj.setCounterOverflowTextAppearance(obj.F);
        obj.setPlaceholderText(t0Var.p(l.j6));
        obj.setPlaceholderTextAppearance(t0Var.n(l.k6, i52));
        obj.setPrefixText(t0Var.p(l.m6));
        obj.setPrefixTextAppearance(t0Var.n(l.n6, i52));
        obj.setSuffixText(t0Var.p(l.u6));
        obj.setSuffixTextAppearance(t0Var.n(l.v6, i52));
        i4 = l.U5;
        if (t0Var.s(i4)) {
            obj.setErrorTextColor(t0Var.c(i4));
        }
        i17 = l.Z5;
        if (t0Var.s(i17)) {
            obj.setHelperTextColor(t0Var.c(i17));
        }
        i14 = l.d6;
        if (t0Var.s(i14)) {
            obj.setHintTextColor(t0Var.c(i14));
        }
        i10 = l.H5;
        if (t0Var.s(i10)) {
            obj.setCounterTextColor(t0Var.c(i10));
        }
        i18 = l.F5;
        if (t0Var.s(i18)) {
            obj.setCounterOverflowTextColor(t0Var.c(i18));
        }
        i26 = l.l6;
        if (t0Var.s(i26)) {
            obj.setPlaceholderTextColor(t0Var.c(i26));
        }
        i5 = l.o6;
        if (t0Var.s(i5)) {
            obj.setPrefixTextColor(t0Var.c(i5));
        }
        i22 = l.w6;
        if (t0Var.s(i22)) {
            obj.setSuffixTextColor(t0Var.c(i22));
        }
        obj.setCounterEnabled(t0Var.a(l.C5, false));
        int i85 = 1;
        obj.setEnabled(t0Var.a(l.m5, i85));
        t0Var.w();
        u.v0(obj, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            u.w0(obj, i85);
        }
    }

    private d A() {
        d dVar = new d();
        dVar.Y(87);
        dVar.a0(a.a);
        return dVar;
    }

    private void A0(int i) {
        boolean obj1;
        if (!i && !this.Y0) {
            if (!this.Y0) {
                k0();
            } else {
                K();
            }
        } else {
        }
    }

    private boolean B() {
        int i;
        boolean empty;
        if (this.U && !TextUtils.isEmpty(this.V) && gVar instanceof c) {
            if (!TextUtils.isEmpty(this.V)) {
                i = gVar instanceof c ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private void B0() {
        int i;
        if (this.w == null) {
        }
        if (R()) {
            i = 0;
        } else {
            i = u.G(this.w);
        }
        u.y0(this.R, i, this.w.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(d.D), this.w.getCompoundPaddingBottom());
    }

    private void C() {
        Object next;
        Iterator iterator = this.x0.iterator();
        for (TextInputLayout.f next : iterator) {
            next.a(this);
        }
    }

    private void C0() {
        java.lang.CharSequence charSequence;
        int i;
        if (this.Q != null && !O()) {
            i = !O() ? 0 : 8;
        } else {
        }
        this.R.setVisibility(i);
        s0();
    }

    private void D(int i) {
        Object next;
        Iterator iterator = this.B0.iterator();
        for (TextInputLayout.g next : iterator) {
            next.a(this, i);
        }
    }

    private void D0(boolean z, boolean z2) {
        int defaultColor = this.S0.getDefaultColor();
        int i3 = 2;
        int[] iArr2 = new int[i3];
        iArr2 = new int[]{16843623, 16842910};
        int[] iArr = new int[i3];
        iArr = new int[]{16843518, 16842910};
        if (z) {
            this.j0 = this.S0.getColorForState(iArr, defaultColor);
        } else {
            if (z2) {
                this.j0 = this.S0.getColorForState(iArr2, defaultColor);
            } else {
                this.j0 = defaultColor;
            }
        }
    }

    private void E(Canvas canvas) {
        g gVar;
        int i2;
        int i;
        gVar = this.b0;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bottom -= i;
            this.b0.draw(canvas);
        }
    }

    private void E0() {
        int i;
        boolean z;
        if (this.w == null) {
        }
        if (!L()) {
            if (M()) {
                i = 0;
            } else {
                i = u.F(this.w);
            }
        } else {
        }
        u.y0(this.T, getContext().getResources().getDimensionPixelSize(d.D), this.w.getPaddingTop(), i, this.w.getPaddingBottom());
    }

    private void F(Canvas canvas) {
        boolean z;
        if (this.U) {
            this.Z0.l(canvas);
        }
    }

    private void F0() {
        int endIconDelegate;
        java.lang.CharSequence charSequence;
        int i;
        int i2;
        if (this.S != null && !O()) {
            i = !O() ? 1 : i2;
        } else {
        }
        if (i != 0) {
        } else {
            i2 = 8;
        }
        this.T.setVisibility(i2);
        if (this.T.getVisibility() != this.T.getVisibility()) {
            getEndIconDelegate().c(i);
        }
        s0();
    }

    private void G(boolean z) {
        ValueAnimator running;
        a obj2;
        running = this.c1;
        if (running != null && running.isRunning()) {
            if (running.isRunning()) {
                this.c1.cancel();
            }
        }
        int i = 0;
        if (z && this.b1) {
            if (this.b1) {
                i(i);
            } else {
                this.Z0.Z(i);
            }
        } else {
        }
        if (B() && (c)this.a0.n0()) {
            if ((c)this.a0.n0()) {
                y();
            }
        }
        this.Y0 = true;
        K();
        C0();
        F0();
    }

    private int H(int i, boolean z2) {
        int obj2;
        int obj3;
        if (this.Q != null && z2 == 0) {
            if (z2 == 0) {
                obj2 += obj3;
            }
        }
        return obj2;
    }

    private int I(int i, boolean z2) {
        java.lang.CharSequence paddingRight;
        int obj2;
        int obj3;
        if (this.Q != null && z2 != 0) {
            if (z2 != 0) {
                obj2 += obj3;
            }
        }
        return obj2;
    }

    private boolean J() {
        int i;
        i = this.y0 != 0 ? 1 : 0;
        return i;
    }

    private void K() {
        TextView view;
        boolean z;
        view = this.J;
        if (view != null && this.I) {
            if (this.I) {
                view.setText(0);
                q.a(this.a, this.N);
                this.J.setVisibility(4);
            }
        }
    }

    private boolean M() {
        int i;
        i = this.L0.getVisibility() == 0 ? 1 : 0;
        return i;
    }

    private boolean Q() {
        int minLines;
        int i2;
        int i;
        i2 = 1;
        if (this.e0 == i2) {
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.w.getMinLines() <= i2) {
                } else {
                    i2 = 0;
                }
            }
        } else {
        }
        return i2;
    }

    private int[] S(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        final int[] obj5 = checkableImageButton.getDrawableState();
        int[] copyOf = Arrays.copyOf(drawableState, length2 += length4);
        System.arraycopy(obj5, 0, copyOf, drawableState.length, obj5.length);
        return copyOf;
    }

    private void T() {
        p();
        c0();
        G0();
        m0();
        h();
        if (this.e0 != 0) {
            v0();
        }
    }

    private void U() {
        if (!B()) {
        }
        RectF rectF = this.n0;
        this.Z0.o(rectF, this.w.getWidth(), this.w.getGravity());
        l(rectF);
        rectF.offset((float)i, i3 += f3);
        (c)this.a0.t0(rectF);
    }

    private void V() {
        boolean z;
        if (B() && !this.Y0) {
            if (!this.Y0) {
                y();
                U();
            }
        }
    }

    private static void W(ViewGroup viewGroup, boolean z2) {
        int i;
        View childAt;
        boolean z;
        i = 0;
        while (i < viewGroup.getChildCount()) {
            childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
            }
            i++;
            TextInputLayout.W((ViewGroup)childAt, z2);
        }
    }

    private void Z(CheckableImageButton checkableImageButton, ColorStateList colorStateList2) {
        Drawable drawable;
        Drawable drawable2;
        int defaultColor;
        ColorStateList obj5;
        if (checkableImageButton.getDrawable() != null && colorStateList2 != null) {
            if (colorStateList2 != null) {
                if (!colorStateList2.isStateful()) {
                } else {
                    drawable = a.r(checkableImageButton.getDrawable()).mutate();
                    a.o(drawable, ColorStateList.valueOf(colorStateList2.getColorForState(S(checkableImageButton), colorStateList2.getDefaultColor())));
                    checkableImageButton.setImageDrawable(drawable);
                }
            }
        }
    }

    static boolean a(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        return textInputLayout.e1;
    }

    static boolean b(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        return textInputLayout.I;
    }

    private void b0() {
        int i;
        final TextView view = this.J;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    static void c(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2) {
        textInputLayout.A0(i2);
    }

    private void c0() {
        boolean z;
        g gVar;
        if (j0()) {
            u.o0(this.w, this.a0);
        }
    }

    static CheckableImageButton d(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        return textInputLayout.A0;
    }

    private static void d0(CheckableImageButton checkableImageButton, View.OnLongClickListener view$OnLongClickListener2) {
        int i;
        int i2;
        int obj4;
        final boolean z = u.M(checkableImageButton);
        i2 = 1;
        obj4 = onLongClickListener2 != null ? i2 : i;
        if (!z) {
            if (obj4 != null) {
                i = i2;
            }
        } else {
        }
        checkableImageButton.setFocusable(i);
        checkableImageButton.setClickable(z);
        checkableImageButton.setPressable(z);
        checkableImageButton.setLongClickable(obj4);
        if (i != 0) {
        } else {
            i2 = 2;
        }
        u.v0(checkableImageButton, i2);
    }

    private static void e0(CheckableImageButton checkableImageButton, View.OnClickListener view$OnClickListener2, View.OnLongClickListener view$OnLongClickListener3) {
        checkableImageButton.setOnClickListener(onClickListener2);
        TextInputLayout.d0(checkableImageButton, onLongClickListener3);
    }

    private static void f0(CheckableImageButton checkableImageButton, View.OnLongClickListener view$OnLongClickListener2) {
        checkableImageButton.setOnLongClickListener(onLongClickListener2);
        TextInputLayout.d0(checkableImageButton, onLongClickListener2);
    }

    private void g() {
        TextView view;
        int i;
        view = this.J;
        if (view != null) {
            this.a.addView(view);
            this.J.setVisibility(0);
        }
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        Object obj;
        int i;
        if ((e)this.z0.get(this.y0) != null) {
        } else {
            obj = this.z0.get(0);
        }
        return obj;
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        boolean z;
        if (this.L0.getVisibility() == 0) {
            return this.L0;
        }
        if (J() && L()) {
            if (L()) {
                return this.A0;
            }
        }
        return null;
    }

    private void h() {
        EditText editText;
        int i;
        int dimensionPixelSize;
        int i2;
        int dimensionPixelSize2;
        int i3;
        if (this.w != null) {
            if (this.e0 != 1) {
            } else {
                if (c.h(getContext())) {
                    editText = this.w;
                    u.y0(editText, u.G(editText), getResources().getDimensionPixelSize(d.x), u.F(this.w), getResources().getDimensionPixelSize(d.w));
                } else {
                    if (c.g(getContext())) {
                        editText = this.w;
                        u.y0(editText, u.G(editText), getResources().getDimensionPixelSize(d.v), u.F(this.w), getResources().getDimensionPixelSize(d.u));
                    }
                }
            }
        }
    }

    private boolean h0() {
        int i;
        java.lang.CharSequence measuredWidth;
        if (this.L0.getVisibility() != 0) {
            if (J()) {
                if (!L()) {
                    if (this.S != null && this.c.getMeasuredWidth() > 0) {
                        i = this.c.getMeasuredWidth() > 0 ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private boolean i0() {
        int i;
        java.lang.CharSequence startIconDrawable;
        if (getStartIconDrawable() == null) {
            if (this.Q != null && this.b.getMeasuredWidth() > 0) {
                i = this.b.getMeasuredWidth() > 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private void j() {
        boolean z;
        int background;
        k kVar;
        int i;
        g gVar = this.a0;
        if (gVar == null) {
        }
        gVar.setShapeAppearanceModel(this.c0);
        if (w()) {
            this.a0.g0((float)i3, this.j0);
        }
        int i2 = q();
        this.k0 = i2;
        this.a0.Z(ColorStateList.valueOf(i2));
        if (this.y0 == 3) {
            this.w.getBackground().invalidateSelf();
        }
        k();
        invalidate();
    }

    private boolean j0() {
        EditText background;
        int i;
        g gVar;
        background = this.w;
        if (background != null && this.a0 != null && background.getBackground() == null && this.e0 != 0) {
            if (this.a0 != null) {
                if (background.getBackground() == null) {
                    i = this.e0 != 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private void k() {
        boolean z;
        ColorStateList valueOf;
        if (this.b0 == null) {
        }
        if (x()) {
            this.b0.Z(ColorStateList.valueOf(this.j0));
        }
        invalidate();
    }

    private void k0() {
        TextView view;
        boolean z;
        view = this.J;
        if (view != null && this.I) {
            if (this.I) {
                view.setText(this.H);
                q.a(this.a, this.M);
                this.J.setVisibility(0);
                this.J.bringToFront();
            }
        }
    }

    private void l(RectF rectF) {
        int i3 = this.d0;
        rectF.left = left -= f2;
        rectF.right = right += f;
    }

    private void l0(boolean z) {
        CheckableImageButton checkableImageButton;
        Drawable obj2;
        if (z != null && getEndIconDrawable() != null) {
            if (getEndIconDrawable() != null) {
                obj2 = a.r(getEndIconDrawable()).mutate();
                a.n(obj2, this.A.o());
                this.A0.setImageDrawable(obj2);
            } else {
                m();
            }
        } else {
        }
    }

    private void m() {
        this.n(this.A0, this.D0, this.C0, this.F0, this.E0);
    }

    private void m0() {
        int dimensionPixelSize;
        int i;
        if (this.e0 == 1) {
            if (c.h(getContext())) {
                this.f0 = getResources().getDimensionPixelSize(d.z);
            } else {
                if (c.g(getContext())) {
                    this.f0 = getResources().getDimensionPixelSize(d.y);
                }
            }
        }
    }

    private void n(CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList3, boolean z4, PorterDuff.Mode porterDuff$Mode5) {
        Drawable drawable;
        drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            if (!z2) {
                drawable = a.r(drawable).mutate();
                if (z4 && z2) {
                    drawable = a.r(drawable).mutate();
                    if (z2) {
                        a.o(drawable, colorStateList3);
                    }
                    if (z4) {
                        a.p(drawable, mode5);
                    }
                }
            } else {
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void n0(Rect rect) {
        int bottom;
        int i;
        int left;
        Object obj5;
        final g gVar = this.b0;
        if (gVar != null) {
            bottom = rect.bottom;
            gVar.setBounds(rect.left, bottom - i2, rect.right, bottom);
        }
    }

    private void o() {
        this.n(this.p0, this.r0, this.q0, this.t0, this.s0);
    }

    private void o0() {
        int length;
        if (this.E != null) {
            EditText editText = this.w;
            if (editText == null) {
                length = 0;
            } else {
                length = editText.getText().length();
            }
            p0(length);
        }
    }

    private void p() {
        int gVar;
        boolean z;
        int i;
        k kVar;
        gVar = this.e0;
        i = 0;
        if (gVar != 0) {
            if (gVar != 1) {
                if (gVar != 2) {
                } else {
                    if (this.U && !gVar2 instanceof c) {
                        if (!gVar2 instanceof c) {
                            gVar = new c(this.c0);
                            this.a0 = gVar;
                        } else {
                            gVar = new g(this.c0);
                            this.a0 = gVar;
                        }
                    } else {
                    }
                    this.b0 = i;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.e0);
                stringBuilder.append(" is illegal; only @BoxBackgroundMode constants are supported.");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            g gVar3 = new g(this.c0);
            this.a0 = gVar3;
            gVar = new g();
            this.b0 = gVar;
        } else {
            this.a0 = i;
            this.b0 = i;
        }
    }

    private int q() {
        int i;
        int i2;
        i = this.k0;
        if (this.e0 == 1) {
            i = a.g(a.e(this, b.q, 0), this.k0);
        }
        return i;
    }

    private static void q0(Context context, TextView textView2, int i3, int i4, boolean z5) {
        int obj6;
        obj6 = z5 ? j.c : j.b;
        Object[] arr = new Object[2];
        textView2.setContentDescription(context.getString(obj6, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    private Rect r(Rect rect) {
        int i;
        if (this.w == null) {
        } else {
            Rect rect2 = this.m0;
            int i5 = 1;
            i = u.B(this) == i5 ? i5 : 0;
            rect2.bottom = rect.bottom;
            int i11 = this.e0;
            if (i11 != i5 && i11 != 2) {
                if (i11 != 2) {
                    rect2.left = H(rect.left, i);
                    rect2.top = getPaddingTop();
                    rect2.right = I(rect.right, i);
                    return rect2;
                }
                rect2.left = left += paddingLeft;
                rect2.top = top -= i7;
                rect2.right = obj5 -= paddingRight;
                return rect2;
            }
            rect2.left = H(rect.left, i);
            rect2.top = top2 += i12;
            rect2.right = I(rect.right, i);
            return rect2;
        }
        IllegalStateException obj5 = new IllegalStateException();
        throw obj5;
    }

    private void r0() {
        TextView view;
        boolean z;
        int i;
        view = this.E;
        if (view != null) {
            i = this.D ? this.F : this.G;
            g0(view, i);
            z = this.O;
            if (!this.D && z != null) {
                z = this.O;
                if (z != null) {
                    this.E.setTextColor(z);
                }
            }
            view = this.P;
            if (this.D && view != null) {
                view = this.P;
                if (view != null) {
                    this.E.setTextColor(view);
                }
            }
        }
    }

    private int s(Rect rect, Rect rect2, float f3) {
        if (Q()) {
            return (int)obj2;
        }
        return obj2 -= obj3;
    }

    private boolean s0() {
        int i;
        Drawable[] objArr2;
        Drawable drawable;
        Drawable i6;
        int i3;
        int i4;
        Drawable i7;
        Drawable i2;
        int i5;
        ColorDrawable colorDrawable;
        Object drawable2;
        Drawable[] objArr;
        CheckableImageButton endIconToUpdateDummyDrawable;
        Drawable colorDrawable2;
        Drawable drawable4;
        Drawable drawable3;
        i6 = 0;
        if (this.w == null) {
            return i6;
        }
        i3 = 0;
        i7 = 3;
        i2 = 2;
        i5 = 1;
        if (i0()) {
            measuredWidth -= paddingLeft;
            if (this.u0 != null) {
                if (this.v0 != i8) {
                    colorDrawable = new ColorDrawable();
                    this.u0 = colorDrawable;
                    this.v0 = i8;
                    colorDrawable.setBounds(i6, i6, i8, i5);
                }
            } else {
            }
            objArr2 = k.a(this.w);
            colorDrawable2 = this.u0;
            if (objArr2[i6] != colorDrawable2) {
                k.l(this.w, colorDrawable2, objArr2[i5], objArr2[i2], objArr2[i7]);
                i = i5;
            } else {
                i = i6;
            }
        } else {
            if (this.u0 != null) {
                Drawable[] objArr3 = k.a(this.w);
                k.l(this.w, i3, objArr3[i5], objArr3[i2], objArr3[i7]);
                this.u0 = i3;
            } else {
            }
        }
        if (h0()) {
            endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                i9 += endIconToUpdateDummyDrawable;
            }
            objArr = k.a(this.w);
            colorDrawable2 = this.G0;
            if (colorDrawable2 != null && this.H0 != i4) {
                if (this.H0 != i4) {
                    this.H0 = i4;
                    colorDrawable2.setBounds(i6, i6, i4, i5);
                    k.l(this.w, objArr[i6], objArr[i5], this.G0, objArr[i7]);
                } else {
                    if (colorDrawable2 == null) {
                        colorDrawable2 = new ColorDrawable();
                        this.G0 = colorDrawable2;
                        this.H0 = i4;
                        colorDrawable2.setBounds(i6, i6, i4, i5);
                    }
                    colorDrawable2 = this.G0;
                    if (objArr[i2] != colorDrawable2) {
                        this.I0 = objArr[i2];
                        k.l(this.w, objArr[i6], objArr[i5], colorDrawable2, objArr[i7]);
                    } else {
                        i5 = i;
                    }
                }
            } else {
            }
            i = i5;
        } else {
            if (this.G0 != null) {
                objArr = k.a(this.w);
                if (objArr[i2] == this.G0) {
                    k.l(this.w, objArr[i6], objArr[i5], this.I0, objArr[i7]);
                } else {
                    i5 = i;
                }
                this.G0 = i3;
            }
        }
        return i;
    }

    private void setEditText(EditText editText) {
        int str2;
        ColorStateList hintTextColors;
        boolean empty;
        TextView length;
        int str;
        int i;
        if (this.w != null) {
        } else {
            if (this.y0 != 3 && !editText instanceof TextInputEditText) {
                if (!editText instanceof TextInputEditText) {
                    Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
                }
            }
            this.w = editText;
            setMinWidth(this.y);
            setMaxWidth(this.z);
            T();
            TextInputLayout.e eVar = new TextInputLayout.e(this);
            setTextInputAccessibilityDelegate(eVar);
            this.Z0.f0(this.w.getTypeface());
            this.Z0.X(this.w.getTextSize());
            int gravity = this.w.getGravity();
            this.Z0.P(i5 |= 48);
            this.Z0.W(gravity);
            TextInputLayout.a aVar = new TextInputLayout.a(this);
            this.w.addTextChangedListener(aVar);
            if (this.N0 == null) {
                this.N0 = this.w.getHintTextColors();
            }
            int i4 = 1;
            if (this.U && TextUtils.isEmpty(this.V)) {
                if (TextUtils.isEmpty(this.V)) {
                    java.lang.CharSequence hint = this.w.getHint();
                    this.x = hint;
                    setHint(hint);
                    this.w.setHint(0);
                }
                this.W = i4;
            }
            if (this.E != null) {
                p0(this.w.getText().length());
            }
            t0();
            this.A.e();
            this.b.bringToFront();
            this.c.bringToFront();
            this.v.bringToFront();
            this.L0.bringToFront();
            C();
            B0();
            E0();
            int i6 = 0;
            if (!isEnabled()) {
                editText.setEnabled(i6);
            }
            x0(i6, i4);
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("We already have an EditText, can only have one");
        throw obj4;
    }

    private void setErrorIconVisible(boolean z) {
        int i2;
        int i;
        final int i3 = 8;
        i = z ? i2 : i3;
        this.L0.setVisibility(i);
        if (z) {
            i2 = i3;
        }
        this.v.setVisibility(i2);
        E0();
        if (!J()) {
            s0();
        }
    }

    private void setHintInternal(java.lang.CharSequence charSequence) {
        boolean equals;
        java.lang.CharSequence obj2;
        this.V = charSequence;
        this.Z0.d0(charSequence);
        if (!TextUtils.equals(charSequence, this.V) && !this.Y0) {
            this.V = charSequence;
            this.Z0.d0(charSequence);
            if (!this.Y0) {
                U();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z) {
        ColorStateList list;
        int i;
        if (this.I == z) {
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.J = appCompatTextView;
            appCompatTextView.setId(f.g0);
            d dVar = A();
            this.M = dVar;
            dVar.e0(67);
            this.N = A();
            u.n0(this.J, 1);
            setPlaceholderTextAppearance(this.L);
            setPlaceholderTextColor(this.K);
            g();
        } else {
            b0();
            this.J = 0;
        }
        this.I = z;
    }

    private int t(Rect rect, float f2) {
        if (Q()) {
            return (int)obj2;
        }
        return obj2 += obj3;
    }

    private Rect u(Rect rect) {
        if (this.w == null) {
        } else {
            Rect rect2 = this.m0;
            float f = this.Z0.w();
            rect2.left = left += compoundPaddingLeft;
            rect2.top = t(rect, f);
            rect2.right = right -= compoundPaddingRight;
            rect2.bottom = s(rect, rect2, f);
            return rect2;
        }
        IllegalStateException obj5 = new IllegalStateException();
        throw obj5;
    }

    private boolean u0() {
        int i3 = 0;
        if (this.w == null) {
            return i3;
        }
        int i = Math.max(this.c.getMeasuredHeight(), this.b.getMeasuredHeight());
        if (this.w.getMeasuredHeight() < i) {
            this.w.setMinimumHeight(i);
            return 1;
        }
        return i3;
    }

    private int v() {
        int i;
        int i2;
        int i3;
        i2 = 0;
        if (!this.U) {
            return i2;
        }
        int i4 = this.e0;
        if (i4 != 0 && i4 != 1) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return i2;
                }
                f /= i2;
            } else {
                i = this.Z0.q();
            }
        } else {
        }
        return (int)i;
    }

    private void v0() {
        int layoutParams;
        int i;
        int topMargin;
        layoutParams = this.a.getLayoutParams();
        i = v();
        if (this.e0 != 1 && i != layoutParams.topMargin) {
            layoutParams = this.a.getLayoutParams();
            i = v();
            if (i != layoutParams.topMargin) {
                layoutParams.topMargin = i;
                this.a.requestLayout();
            }
        }
    }

    private boolean w() {
        int i2;
        int i;
        if (this.e0 == 2 && x()) {
            i = x() ? 1 : 0;
        } else {
        }
        return i;
    }

    private boolean x() {
        int i;
        int i2;
        if (this.g0 > -1 && this.j0 != 0) {
            i2 = this.j0 != 0 ? 1 : 0;
        } else {
        }
        return i2;
    }

    private void x0(boolean z, boolean z2) {
        boolean textColors;
        int colorForState;
        EditText empty;
        int i2;
        int[] iArr;
        int valueOf;
        int i;
        EditText focus;
        int z3;
        Object obj;
        ColorStateList list;
        boolean obj10;
        empty = this.w;
        iArr = 1;
        valueOf = 0;
        if (empty != null && !TextUtils.isEmpty(empty.getText())) {
            i2 = !TextUtils.isEmpty(empty.getText()) ? iArr : valueOf;
        } else {
        }
        focus = this.w;
        if (focus != null && focus.hasFocus()) {
            i = focus.hasFocus() ? iArr : valueOf;
        } else {
        }
        obj = this.N0;
        if (obj != null) {
            this.Z0.O(obj);
            this.Z0.V(this.N0);
        }
        if (!isEnabled()) {
            ColorStateList n0 = this.N0;
            if (n0 != null) {
                iArr = new int[iArr];
                iArr[valueOf] = -16842910;
                colorForState = n0.getColorForState(iArr, this.X0);
            } else {
                colorForState = this.X0;
            }
            this.Z0.O(ColorStateList.valueOf(colorForState));
            this.Z0.V(ColorStateList.valueOf(colorForState));
        } else {
            if (this.A.k()) {
                this.Z0.O(this.A.p());
            } else {
                textColors = this.E;
                if (this.D && textColors != null) {
                    textColors = this.E;
                    if (textColors != null) {
                        this.Z0.O(textColors.getTextColors());
                    } else {
                        textColors = this.O0;
                        if (i != 0 && textColors != null) {
                            textColors = this.O0;
                            if (textColors != null) {
                                this.Z0.O(textColors);
                            }
                        }
                    }
                } else {
                }
            }
        }
        if (i2 == 0 && this.a1) {
            if (this.a1) {
                if (isEnabled() && i != 0) {
                    if (i != 0) {
                        if (!z2) {
                            if (this.Y0) {
                                z(z);
                            }
                        } else {
                        }
                    } else {
                        if (!z2) {
                            if (!this.Y0) {
                                G(z);
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    private void y() {
        boolean z;
        if (B()) {
            (c)this.a0.q0();
        }
    }

    private void y0() {
        Object view;
        int compoundPaddingLeft;
        int compoundPaddingTop;
        int compoundPaddingRight;
        int compoundPaddingBottom;
        view = this.w;
        if (this.J != null && view != null) {
            view = this.w;
            if (view != null) {
                this.J.setGravity(view.getGravity());
                this.J.setPadding(this.w.getCompoundPaddingLeft(), this.w.getCompoundPaddingTop(), this.w.getCompoundPaddingRight(), this.w.getCompoundPaddingBottom());
            }
        }
    }

    private void z(boolean z) {
        ValueAnimator running;
        a obj2;
        running = this.c1;
        if (running != null && running.isRunning()) {
            if (running.isRunning()) {
                this.c1.cancel();
            }
        }
        int i = 1065353216;
        if (z && this.b1) {
            if (this.b1) {
                i(i);
            } else {
                this.Z0.Z(i);
            }
        } else {
        }
        this.Y0 = false;
        if (B()) {
            U();
        }
        z0();
        C0();
        F0();
    }

    private void z0() {
        int length;
        EditText editText = this.w;
        if (editText == null) {
            length = 0;
        } else {
            length = editText.getText().length();
        }
        A0(length);
    }

    @Override // android.widget.LinearLayout
    void G0() {
        int gVar;
        boolean focused;
        int i;
        boolean z;
        int i4;
        int enabled;
        int i3;
        int i5;
        boolean hovered;
        int currentTextColor;
        Drawable errorIconDrawable;
        int i6;
        int i2;
        ColorStateList list;
        if (this.a0 != null) {
            if (this.e0 == 0) {
            } else {
                i = 0;
                i3 = 1;
                if (!isFocused()) {
                    focused = this.w;
                    if (focused != null && focused.hasFocus()) {
                        if (focused.hasFocus()) {
                            gVar = i3;
                        } else {
                            gVar = i;
                        }
                    } else {
                    }
                } else {
                }
                if (!isHovered()) {
                    hovered = this.w;
                    if (hovered != null && hovered.isHovered()) {
                        if (hovered.isHovered()) {
                            i5 = i3;
                        } else {
                            i5 = i;
                        }
                    } else {
                    }
                } else {
                }
                if (!isEnabled()) {
                    this.j0 = this.X0;
                } else {
                    if (this.A.k()) {
                        if (this.S0 != null) {
                            D0(gVar, i5);
                        } else {
                            this.j0 = this.A.o();
                        }
                    } else {
                        currentTextColor = this.E;
                        if (this.D && currentTextColor != null) {
                            currentTextColor = this.E;
                            if (currentTextColor != null) {
                                if (this.S0 != null) {
                                    D0(gVar, i5);
                                } else {
                                    this.j0 = currentTextColor.getCurrentTextColor();
                                }
                            } else {
                                if (gVar != 0) {
                                    this.j0 = this.R0;
                                } else {
                                    if (i5 != 0) {
                                        this.j0 = this.Q0;
                                    } else {
                                        this.j0 = this.P0;
                                    }
                                }
                            }
                        } else {
                        }
                    }
                }
                if (getErrorIconDrawable() != null && this.A.x() && this.A.k()) {
                    if (this.A.x()) {
                        if (this.A.k()) {
                            i = i3;
                        }
                    }
                }
                setErrorIconVisible(i);
                Y();
                a0();
                X();
                if (getEndIconDelegate().d()) {
                    l0(this.A.k());
                }
                if (gVar != 0 && isEnabled()) {
                    if (isEnabled()) {
                        this.g0 = this.i0;
                    } else {
                        this.g0 = this.h0;
                    }
                } else {
                }
                if (this.g0 != this.g0 && this.e0 == 2) {
                    if (this.e0 == 2) {
                        V();
                    }
                }
                if (this.e0 == i3) {
                    if (!isEnabled()) {
                        this.k0 = this.U0;
                    } else {
                        if (i5 != 0 && gVar == 0) {
                            if (gVar == 0) {
                                this.k0 = this.W0;
                            } else {
                                if (gVar != 0) {
                                    this.k0 = this.V0;
                                } else {
                                    this.k0 = this.T0;
                                }
                            }
                        } else {
                        }
                    }
                }
                j();
            }
        }
    }

    @Override // android.widget.LinearLayout
    public boolean L() {
        int visibility;
        int i;
        if (this.v.getVisibility() == 0 && this.A0.getVisibility() == 0) {
            i = this.A0.getVisibility() == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.widget.LinearLayout
    public boolean N() {
        return this.A.y();
    }

    @Override // android.widget.LinearLayout
    final boolean O() {
        return this.Y0;
    }

    @Override // android.widget.LinearLayout
    public boolean P() {
        return this.W;
    }

    @Override // android.widget.LinearLayout
    public boolean R() {
        int i;
        i = this.p0.getVisibility() == 0 ? 1 : 0;
        return i;
    }

    @Override // android.widget.LinearLayout
    public void X() {
        Z(this.A0, this.C0);
    }

    @Override // android.widget.LinearLayout
    public void Y() {
        Z(this.L0, this.M0);
    }

    @Override // android.widget.LinearLayout
    public void a0() {
        Z(this.p0, this.q0);
    }

    @Override // android.widget.LinearLayout
    public void addView(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        FrameLayout frameLayout;
        FrameLayout obj3;
        if (view instanceof EditText) {
            obj3 = new FrameLayout.LayoutParams(layoutParams3);
            obj3.gravity = i |= 16;
            this.a.addView(view, obj3);
            this.a.setLayoutParams(layoutParams3);
            v0();
            setEditText((EditText)view);
        } else {
            super.addView(view, i2, layoutParams3);
        }
    }

    @Override // android.widget.LinearLayout
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        java.lang.CharSequence childCount;
        int childCount2;
        boolean child;
        EditText i;
        Object charSequence;
        Object obj5;
        EditText editText = this.w;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        }
        if (this.x != null) {
            this.W = false;
            this.w.setHint(this.x);
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            this.w.setHint(editText.getHint());
            this.W = this.W;
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i2);
            onProvideAutofillVirtualStructure(viewStructure, i2);
            viewStructure.setChildCount(this.a.getChildCount());
            while (i < this.a.getChildCount()) {
                childCount2 = this.a.getChildAt(i);
                child = viewStructure.newChild(i);
                childCount2.dispatchProvideAutofillStructure(child, i2);
                if (childCount2 == this.w) {
                }
                i++;
                child.setHint(getHint());
            }
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.e1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.e1 = false;
    }

    @Override // android.widget.LinearLayout
    public void draw(Canvas canvas) {
        super.draw(canvas);
        F(canvas);
        E(canvas);
    }

    @Override // android.widget.LinearLayout
    protected void drawableStateChanged() {
        int i2;
        int i;
        EditText enabled;
        if (this.d1) {
        }
        this.d1 = true;
        super.drawableStateChanged();
        a z0 = this.Z0;
        final int i3 = 0;
        if (z0 != null) {
            z2 |= i3;
        } else {
            i = i3;
        }
        if (this.w != null) {
            if (u.R(this) && isEnabled()) {
                if (isEnabled()) {
                } else {
                    i2 = i3;
                }
            } else {
            }
            w0(i2);
        }
        t0();
        G0();
        if (i != 0) {
            invalidate();
        }
        this.d1 = i3;
    }

    @Override // android.widget.LinearLayout
    public void e(com.google.android.material.textfield.TextInputLayout.f textInputLayout$f) {
        this.x0.add(f);
        if (this.w != null) {
            f.a(this);
        }
    }

    @Override // android.widget.LinearLayout
    public void f(com.google.android.material.textfield.TextInputLayout.g textInputLayout$g) {
        this.B0.add(g);
    }

    @Override // android.widget.LinearLayout
    void g0(TextView textView, int i2) {
        int i3;
        int i;
        int obj4;
        i3 = 1;
        k.q(textView, i2);
        if (Build.VERSION.SDK_INT >= 23 && textView.getTextColors().getDefaultColor() == -65281) {
            try {
                if (textView.getTextColors().getDefaultColor() == -65281) {
                } else {
                }
                i3 = obj4;
                if (i3 != 0) {
                }
                k.q(textView, k.c);
                textView.setTextColor(a.d(getContext(), c.b));
            }
        } else {
        }
    }

    @Override // android.widget.LinearLayout
    public int getBaseline() {
        EditText editText = this.w;
        if (editText != null) {
            return i += i3;
        }
        return super.getBaseline();
    }

    @Override // android.widget.LinearLayout
    g getBoxBackground() {
        int i;
        int i2 = this.e0;
        if (i2 != 1) {
            if (i2 != 2) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
        return this.a0;
    }

    @Override // android.widget.LinearLayout
    public int getBoxBackgroundColor() {
        return this.k0;
    }

    @Override // android.widget.LinearLayout
    public int getBoxBackgroundMode() {
        return this.e0;
    }

    @Override // android.widget.LinearLayout
    public int getBoxCollapsedPaddingTop() {
        return this.f0;
    }

    @Override // android.widget.LinearLayout
    public float getBoxCornerRadiusBottomEnd() {
        return this.a0.s();
    }

    @Override // android.widget.LinearLayout
    public float getBoxCornerRadiusBottomStart() {
        return this.a0.t();
    }

    @Override // android.widget.LinearLayout
    public float getBoxCornerRadiusTopEnd() {
        return this.a0.I();
    }

    @Override // android.widget.LinearLayout
    public float getBoxCornerRadiusTopStart() {
        return this.a0.H();
    }

    @Override // android.widget.LinearLayout
    public int getBoxStrokeColor() {
        return this.R0;
    }

    @Override // android.widget.LinearLayout
    public ColorStateList getBoxStrokeErrorColor() {
        return this.S0;
    }

    @Override // android.widget.LinearLayout
    public int getBoxStrokeWidth() {
        return this.h0;
    }

    @Override // android.widget.LinearLayout
    public int getBoxStrokeWidthFocused() {
        return this.i0;
    }

    @Override // android.widget.LinearLayout
    public int getCounterMaxLength() {
        return this.C;
    }

    @Override // android.widget.LinearLayout
    java.lang.CharSequence getCounterOverflowDescription() {
        boolean z;
        z = this.E;
        if (this.B && this.D && z != null) {
            if (this.D) {
                z = this.E;
                if (z != null) {
                    return z.getContentDescription();
                }
            }
        }
        return null;
    }

    @Override // android.widget.LinearLayout
    public ColorStateList getCounterOverflowTextColor() {
        return this.O;
    }

    @Override // android.widget.LinearLayout
    public ColorStateList getCounterTextColor() {
        return this.O;
    }

    @Override // android.widget.LinearLayout
    public ColorStateList getDefaultHintTextColor() {
        return this.N0;
    }

    @Override // android.widget.LinearLayout
    public EditText getEditText() {
        return this.w;
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getEndIconContentDescription() {
        return this.A0.getContentDescription();
    }

    @Override // android.widget.LinearLayout
    public Drawable getEndIconDrawable() {
        return this.A0.getDrawable();
    }

    @Override // android.widget.LinearLayout
    public int getEndIconMode() {
        return this.y0;
    }

    @Override // android.widget.LinearLayout
    CheckableImageButton getEndIconView() {
        return this.A0;
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getError() {
        java.lang.CharSequence charSequence;
        if (this.A.x()) {
            charSequence = this.A.n();
        } else {
            charSequence = 0;
        }
        return charSequence;
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getErrorContentDescription() {
        return this.A.m();
    }

    @Override // android.widget.LinearLayout
    public int getErrorCurrentTextColors() {
        return this.A.o();
    }

    @Override // android.widget.LinearLayout
    public Drawable getErrorIconDrawable() {
        return this.L0.getDrawable();
    }

    @Override // android.widget.LinearLayout
    final int getErrorTextCurrentColor() {
        return this.A.o();
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getHelperText() {
        java.lang.CharSequence charSequence;
        if (this.A.y()) {
            charSequence = this.A.q();
        } else {
            charSequence = 0;
        }
        return charSequence;
    }

    @Override // android.widget.LinearLayout
    public int getHelperTextCurrentTextColor() {
        return this.A.r();
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getHint() {
        java.lang.CharSequence charSequence;
        charSequence = this.U ? this.V : 0;
        return charSequence;
    }

    @Override // android.widget.LinearLayout
    final float getHintCollapsedTextHeight() {
        return this.Z0.q();
    }

    @Override // android.widget.LinearLayout
    final int getHintCurrentCollapsedTextColor() {
        return this.Z0.t();
    }

    @Override // android.widget.LinearLayout
    public ColorStateList getHintTextColor() {
        return this.O0;
    }

    @Override // android.widget.LinearLayout
    public int getMaxWidth() {
        return this.z;
    }

    @Override // android.widget.LinearLayout
    public int getMinWidth() {
        return this.y;
    }

    @Deprecated
    public java.lang.CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.A0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.A0.getDrawable();
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getPlaceholderText() {
        java.lang.CharSequence charSequence;
        charSequence = this.I ? this.H : 0;
        return charSequence;
    }

    @Override // android.widget.LinearLayout
    public int getPlaceholderTextAppearance() {
        return this.L;
    }

    @Override // android.widget.LinearLayout
    public ColorStateList getPlaceholderTextColor() {
        return this.K;
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getPrefixText() {
        return this.Q;
    }

    @Override // android.widget.LinearLayout
    public ColorStateList getPrefixTextColor() {
        return this.R.getTextColors();
    }

    @Override // android.widget.LinearLayout
    public TextView getPrefixTextView() {
        return this.R;
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getStartIconContentDescription() {
        return this.p0.getContentDescription();
    }

    @Override // android.widget.LinearLayout
    public Drawable getStartIconDrawable() {
        return this.p0.getDrawable();
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getSuffixText() {
        return this.S;
    }

    @Override // android.widget.LinearLayout
    public ColorStateList getSuffixTextColor() {
        return this.T.getTextColors();
    }

    @Override // android.widget.LinearLayout
    public TextView getSuffixTextView() {
        return this.T;
    }

    @Override // android.widget.LinearLayout
    public Typeface getTypeface() {
        return this.o0;
    }

    @Override // android.widget.LinearLayout
    void i(float f) {
        ValueAnimator valueAnimator;
        com.google.android.material.textfield.TextInputLayout.d dVar;
        if (Float.compare(f2, f) == 0) {
        }
        if (this.c1 == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.c1 = valueAnimator2;
            valueAnimator2.setInterpolator(a.b);
            this.c1.setDuration(167);
            dVar = new TextInputLayout.d(this);
            this.c1.addUpdateListener(dVar);
        }
        float[] fArr = new float[2];
        this.c1.setFloatValues(this.Z0.x(), f);
        this.c1.start();
    }

    @Override // android.widget.LinearLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        EditText obj1;
        int obj2;
        int obj3;
        int obj4;
        super.onLayout(z, i2, i3, i4, i5);
        obj1 = this.w;
        obj2 = this.l0;
        b.a(this, obj1, obj2);
        n0(obj2);
        this.Z0.X(this.w.getTextSize());
        obj1 = this.w.getGravity();
        this.Z0.P(obj4 |= 48);
        this.Z0.W(obj1);
        this.Z0.L(r(obj2));
        this.Z0.T(u(obj2));
        this.Z0.H();
        if (obj1 != null && this.U && B() && !this.Y0) {
            obj2 = this.l0;
            b.a(this, obj1, obj2);
            n0(obj2);
            if (this.U) {
                this.Z0.X(this.w.getTextSize());
                obj1 = this.w.getGravity();
                this.Z0.P(obj4 |= 48);
                this.Z0.W(obj1);
                this.Z0.L(r(obj2));
                this.Z0.T(u(obj2));
                this.Z0.H();
                if (B()) {
                    if (!this.Y0) {
                        U();
                    }
                }
            }
        }
    }

    @Override // android.widget.LinearLayout
    protected void onMeasure(int i, int i2) {
        boolean obj1;
        boolean obj2;
        super.onMeasure(i, i2);
        if (!u0()) {
            if (s0()) {
                obj2 = new TextInputLayout.c(this);
                this.w.post(obj2);
            }
        } else {
        }
        y0();
        B0();
        E0();
    }

    @Override // android.widget.LinearLayout
    protected void onRestoreInstanceState(Parcelable parcelable) {
        boolean z;
        com.google.android.material.textfield.TextInputLayout.b bVar;
        if (!parcelable instanceof TextInputLayout.h) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((TextInputLayout.h)parcelable.a());
        setError(parcelable.c);
        if (parcelable.v) {
            bVar = new TextInputLayout.b(this);
            this.A0.post(bVar);
        }
        setHint(parcelable.w);
        setHelperText(parcelable.x);
        setPlaceholderText(parcelable.y);
        requestLayout();
    }

    @Override // android.widget.LinearLayout
    public Parcelable onSaveInstanceState() {
        boolean error;
        boolean checked;
        int i;
        TextInputLayout.h hVar = new TextInputLayout.h(super.onSaveInstanceState());
        if (this.A.k()) {
            hVar.c = getError();
        }
        if (J() && this.A0.isChecked()) {
            i = this.A0.isChecked() ? 1 : 0;
        } else {
        }
        hVar.v = i;
        hVar.w = getHint();
        hVar.x = getHelperText();
        hVar.y = getPlaceholderText();
        return hVar;
    }

    @Override // android.widget.LinearLayout
    void p0(int i) {
        int i2;
        a aVar;
        int i4;
        TextView view;
        Context context;
        int i3;
        Object[] arr;
        Object obj9;
        final boolean z = this.D;
        int i5 = this.C;
        final int i6 = 0;
        if (i5 == -1) {
            this.E.setText(String.valueOf(i));
            this.E.setContentDescription(0);
            this.D = i6;
        } else {
            i4 = 1;
            i2 = i > i5 ? i4 : i6;
            this.D = i2;
            TextInputLayout.q0(getContext(), this.E, i, this.C, this.D);
            if (z != this.D) {
                r0();
            }
            arr = new Object[2];
            arr[i6] = Integer.valueOf(i);
            arr[i4] = Integer.valueOf(this.C);
            this.E.setText(a.c().j(getContext().getString(j.d, arr)));
        }
        if (this.w != null && z != this.D) {
            if (z != this.D) {
                w0(i6);
                G0();
                t0();
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void setBoxBackgroundColor(int i) {
        if (this.k0 != i) {
            this.k0 = i;
            this.T0 = i;
            this.V0 = i;
            this.W0 = i;
            j();
        }
    }

    @Override // android.widget.LinearLayout
    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(a.d(getContext(), i));
    }

    @Override // android.widget.LinearLayout
    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.T0 = defaultColor;
        this.k0 = defaultColor;
        int[] iArr = new int[1];
        int i5 = -1;
        this.U0 = colorStateList.getColorForState(iArr, i5);
        int i3 = 2;
        int[] iArr3 = new int[i3];
        iArr3 = new int[]{16842908, 16842910};
        this.V0 = colorStateList.getColorForState(iArr3, i5);
        int[] iArr2 = new int[i3];
        iArr2 = new int[]{16843623, 16842910};
        this.W0 = colorStateList.getColorForState(iArr2, i5);
        j();
    }

    @Override // android.widget.LinearLayout
    public void setBoxBackgroundMode(int i) {
        if (i == this.e0) {
        }
        this.e0 = i;
        if (this.w != null) {
            T();
        }
    }

    @Override // android.widget.LinearLayout
    public void setBoxCollapsedPaddingTop(int i) {
        this.f0 = i;
    }

    @Override // android.widget.LinearLayout
    public void setBoxStrokeColor(int i) {
        if (this.R0 != i) {
            this.R0 = i;
            G0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int[] iArr;
        int defaultColor;
        int colorForState;
        int obj4;
        if (colorStateList.isStateful()) {
            this.P0 = colorStateList.getDefaultColor();
            int[] iArr2 = new int[1];
            defaultColor = -1;
            this.X0 = colorStateList.getColorForState(iArr2, defaultColor);
            int i3 = 2;
            int[] iArr3 = new int[i3];
            iArr3 = new int[]{16843623, 16842910};
            this.Q0 = colorStateList.getColorForState(iArr3, defaultColor);
            iArr = new int[i3];
            iArr = new int[]{16842908, 16842910};
            this.R0 = colorStateList.getColorForState(iArr, defaultColor);
        } else {
            if (this.R0 != colorStateList.getDefaultColor()) {
                this.R0 = colorStateList.getDefaultColor();
            }
        }
        G0();
    }

    @Override // android.widget.LinearLayout
    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.S0 != colorStateList) {
            this.S0 = colorStateList;
            G0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setBoxStrokeWidth(int i) {
        this.h0 = i;
        G0();
    }

    @Override // android.widget.LinearLayout
    public void setBoxStrokeWidthFocused(int i) {
        this.i0 = i;
        G0();
    }

    @Override // android.widget.LinearLayout
    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    @Override // android.widget.LinearLayout
    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    @Override // android.widget.LinearLayout
    public void setCounterEnabled(boolean z) {
        boolean layoutParams;
        int dimensionPixelOffset;
        int i;
        int i2;
        if (this.B != z) {
            int i3 = 2;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.E = appCompatTextView;
                appCompatTextView.setId(f.d0);
                Typeface typeface = this.o0;
                if (typeface != null) {
                    this.E.setTypeface(typeface);
                }
                this.E.setMaxLines(1);
                this.A.d(this.E, i3);
                h.d((ViewGroup.MarginLayoutParams)this.E.getLayoutParams(), getResources().getDimensionPixelOffset(d.r0));
                r0();
                o0();
            } else {
                this.A.z(this.E, i3);
                this.E = 0;
            }
            this.B = z;
        }
    }

    @Override // android.widget.LinearLayout
    public void setCounterMaxLength(int i) {
        int obj2;
        if (this.C != i) {
            if (i > 0) {
                this.C = i;
            } else {
                this.C = -1;
            }
            if (this.B) {
                o0();
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void setCounterOverflowTextAppearance(int i) {
        if (this.F != i) {
            this.F = i;
            r0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            r0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setCounterTextAppearance(int i) {
        if (this.G != i) {
            this.G = i;
            r0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.O != colorStateList) {
            this.O = colorStateList;
            r0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        EditText obj1;
        this.N0 = colorStateList;
        this.O0 = colorStateList;
        if (this.w != null) {
            w0(false);
        }
    }

    @Override // android.widget.LinearLayout
    public void setEnabled(boolean z) {
        TextInputLayout.W(this, z);
        super.setEnabled(z);
    }

    @Override // android.widget.LinearLayout
    public void setEndIconActivated(boolean z) {
        this.A0.setActivated(z);
    }

    @Override // android.widget.LinearLayout
    public void setEndIconCheckable(boolean z) {
        this.A0.setCheckable(z);
    }

    @Override // android.widget.LinearLayout
    public void setEndIconContentDescription(int i) {
        Resources resources;
        java.lang.CharSequence obj2;
        if (i != 0) {
            obj2 = getResources().getText(i);
        } else {
            obj2 = 0;
        }
        setEndIconContentDescription(obj2);
    }

    @Override // android.widget.LinearLayout
    public void setEndIconContentDescription(java.lang.CharSequence charSequence) {
        Object endIconContentDescription;
        if (getEndIconContentDescription() != charSequence) {
            this.A0.setContentDescription(charSequence);
        }
    }

    @Override // android.widget.LinearLayout
    public void setEndIconDrawable(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.d(getContext(), i);
        } else {
            obj2 = 0;
        }
        setEndIconDrawable(obj2);
    }

    @Override // android.widget.LinearLayout
    public void setEndIconDrawable(Drawable drawable) {
        this.A0.setImageDrawable(drawable);
        if (drawable != null) {
            m();
            X();
        }
    }

    @Override // android.widget.LinearLayout
    public void setEndIconMode(int i) {
        int i2;
        this.y0 = i;
        D(this.y0);
        i2 = i != 0 ? 1 : 0;
        setEndIconVisible(i2);
        if (!getEndIconDelegate().b(this.e0)) {
        } else {
            getEndIconDelegate().a();
            m();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The current box background mode ");
        stringBuilder.append(this.e0);
        stringBuilder.append(" is not supported by the end icon mode ");
        stringBuilder.append(i);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.widget.LinearLayout
    public void setEndIconOnClickListener(View.OnClickListener view$OnClickListener) {
        TextInputLayout.e0(this.A0, onClickListener, this.J0);
    }

    @Override // android.widget.LinearLayout
    public void setEndIconOnLongClickListener(View.OnLongClickListener view$OnLongClickListener) {
        this.J0 = onLongClickListener;
        TextInputLayout.f0(this.A0, onLongClickListener);
    }

    @Override // android.widget.LinearLayout
    public void setEndIconTintList(ColorStateList colorStateList) {
        ColorStateList obj2;
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            this.D0 = true;
            m();
        }
    }

    @Override // android.widget.LinearLayout
    public void setEndIconTintMode(PorterDuff.Mode porterDuff$Mode) {
        PorterDuff.Mode obj2;
        if (this.E0 != mode) {
            this.E0 = mode;
            this.F0 = true;
            m();
        }
    }

    @Override // android.widget.LinearLayout
    public void setEndIconVisible(boolean z) {
        boolean z2;
        int obj2;
        if (L() != z) {
            obj2 = z ? 0 : 8;
            this.A0.setVisibility(obj2);
            E0();
            s0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setError(java.lang.CharSequence charSequence) {
        boolean z;
        boolean empty;
        Object obj2;
        if (!this.A.x() && TextUtils.isEmpty(charSequence)) {
            if (TextUtils.isEmpty(charSequence)) {
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.A.M(charSequence);
        } else {
            this.A.t();
        }
    }

    @Override // android.widget.LinearLayout
    public void setErrorContentDescription(java.lang.CharSequence charSequence) {
        this.A.B(charSequence);
    }

    @Override // android.widget.LinearLayout
    public void setErrorEnabled(boolean z) {
        this.A.C(z);
    }

    @Override // android.widget.LinearLayout
    public void setErrorIconDrawable(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.d(getContext(), i);
        } else {
            obj2 = 0;
        }
        setErrorIconDrawable(obj2);
        Y();
    }

    @Override // android.widget.LinearLayout
    public void setErrorIconDrawable(Drawable drawable) {
        Drawable obj2;
        this.L0.setImageDrawable(drawable);
        if (drawable != null && this.A.x()) {
            obj2 = this.A.x() ? 1 : 0;
        } else {
        }
        setErrorIconVisible(obj2);
    }

    @Override // android.widget.LinearLayout
    public void setErrorIconOnClickListener(View.OnClickListener view$OnClickListener) {
        TextInputLayout.e0(this.L0, onClickListener, this.K0);
    }

    @Override // android.widget.LinearLayout
    public void setErrorIconOnLongClickListener(View.OnLongClickListener view$OnLongClickListener) {
        this.K0 = onLongClickListener;
        TextInputLayout.f0(this.L0, onLongClickListener);
    }

    @Override // android.widget.LinearLayout
    public void setErrorIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        Object obj2;
        this.M0 = colorStateList;
        drawable = this.L0.getDrawable();
        if (drawable != null) {
            a.o(a.r(drawable).mutate(), colorStateList);
        }
        if (this.L0.getDrawable() != drawable) {
            this.L0.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout
    public void setErrorIconTintMode(PorterDuff.Mode porterDuff$Mode) {
        Drawable drawable;
        Object obj2;
        drawable = this.L0.getDrawable();
        if (drawable != null) {
            a.p(a.r(drawable).mutate(), mode);
        }
        if (this.L0.getDrawable() != drawable) {
            this.L0.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout
    public void setErrorTextAppearance(int i) {
        this.A.D(i);
    }

    @Override // android.widget.LinearLayout
    public void setErrorTextColor(ColorStateList colorStateList) {
        this.A.E(colorStateList);
    }

    @Override // android.widget.LinearLayout
    public void setExpandedHintEnabled(boolean z) {
        boolean obj2;
        if (this.a1 != z) {
            this.a1 = z;
            w0(false);
        }
    }

    @Override // android.widget.LinearLayout
    public void setHelperText(java.lang.CharSequence charSequence) {
        boolean z;
        com.google.android.material.textfield.f empty;
        java.lang.CharSequence obj2;
        if (TextUtils.isEmpty(charSequence)) {
            if (N()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!N()) {
                setHelperTextEnabled(true);
            }
            this.A.N(charSequence);
        }
    }

    @Override // android.widget.LinearLayout
    public void setHelperTextColor(ColorStateList colorStateList) {
        this.A.H(colorStateList);
    }

    @Override // android.widget.LinearLayout
    public void setHelperTextEnabled(boolean z) {
        this.A.G(z);
    }

    @Override // android.widget.LinearLayout
    public void setHelperTextTextAppearance(int i) {
        this.A.F(i);
    }

    @Override // android.widget.LinearLayout
    public void setHint(int i) {
        Resources resources;
        java.lang.CharSequence obj2;
        if (i != 0) {
            obj2 = getResources().getText(i);
        } else {
            obj2 = 0;
        }
        setHint(obj2);
    }

    @Override // android.widget.LinearLayout
    public void setHint(java.lang.CharSequence charSequence) {
        java.lang.CharSequence obj2;
        if (this.U) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.LinearLayout
    public void setHintAnimationEnabled(boolean z) {
        this.b1 = z;
    }

    @Override // android.widget.LinearLayout
    public void setHintEnabled(boolean z) {
        boolean z2;
        boolean empty;
        boolean obj3;
        if (z != this.U) {
            this.U = z;
            z2 = 0;
            if (!z) {
                this.W = false;
                if (!TextUtils.isEmpty(this.V) && TextUtils.isEmpty(this.w.getHint())) {
                    if (TextUtils.isEmpty(this.w.getHint())) {
                        this.w.setHint(this.V);
                    }
                }
                setHintInternal(z2);
            } else {
                obj3 = this.w.getHint();
                if (!TextUtils.isEmpty(obj3) && TextUtils.isEmpty(this.V)) {
                    if (TextUtils.isEmpty(this.V)) {
                        setHint(obj3);
                    }
                    this.w.setHint(z2);
                }
                this.W = true;
            }
            if (this.w != null) {
                v0();
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void setHintTextAppearance(int i) {
        EditText obj2;
        this.Z0.M(i);
        this.O0 = this.Z0.p();
        if (this.w != null) {
            w0(false);
            v0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setHintTextColor(ColorStateList colorStateList) {
        Object obj;
        ColorStateList obj2;
        if (this.O0 != colorStateList && this.N0 == null) {
            if (this.N0 == null) {
                this.Z0.O(colorStateList);
            }
            this.O0 = colorStateList;
            if (this.w != null) {
                w0(false);
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void setMaxWidth(int i) {
        int i2;
        this.z = i;
        final EditText editText = this.w;
        if (editText != null && i != -1) {
            if (i != -1) {
                editText.setMaxWidth(i);
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Override // android.widget.LinearLayout
    public void setMinWidth(int i) {
        int i2;
        this.y = i;
        final EditText editText = this.w;
        if (editText != null && i != -1) {
            if (i != -1) {
                editText.setMinWidth(i);
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        Resources resources;
        java.lang.CharSequence obj2;
        if (i != 0) {
            obj2 = getResources().getText(i);
        } else {
            obj2 = 0;
        }
        setPasswordVisibilityToggleContentDescription(obj2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(java.lang.CharSequence charSequence) {
        this.A0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.d(getContext(), i);
        } else {
            obj2 = 0;
        }
        setPasswordVisibilityToggleDrawable(obj2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.A0.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        int i;
        int i2;
        int obj3;
        i2 = 1;
        if (z != 0 && this.y0 != i2) {
            i2 = 1;
            if (this.y0 != i2) {
                setEndIconMode(i2);
            } else {
                if (z == 0) {
                    setEndIconMode(0);
                }
            }
        } else {
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.C0 = colorStateList;
        this.D0 = true;
        m();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.E0 = mode;
        this.F0 = true;
        m();
    }

    @Override // android.widget.LinearLayout
    public void setPlaceholderText(java.lang.CharSequence charSequence) {
        boolean empty;
        java.lang.CharSequence obj2;
        if (this.I && TextUtils.isEmpty(charSequence)) {
            if (TextUtils.isEmpty(charSequence)) {
                setPlaceholderTextEnabled(false);
            } else {
                if (!this.I) {
                    setPlaceholderTextEnabled(true);
                }
                this.H = charSequence;
            }
        } else {
        }
        z0();
    }

    @Override // android.widget.LinearLayout
    public void setPlaceholderTextAppearance(int i) {
        this.L = i;
        final TextView view = this.J;
        if (view != null) {
            k.q(view, i);
        }
    }

    @Override // android.widget.LinearLayout
    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        Object list;
        this.K = colorStateList;
        list = this.J;
        if (this.K != colorStateList && list != null && colorStateList != null) {
            this.K = colorStateList;
            list = this.J;
            if (list != null) {
                if (colorStateList != null) {
                    list.setTextColor(colorStateList);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void setPrefixText(java.lang.CharSequence charSequence) {
        int i;
        i = TextUtils.isEmpty(charSequence) ? 0 : charSequence;
        this.Q = i;
        this.R.setText(charSequence);
        C0();
    }

    @Override // android.widget.LinearLayout
    public void setPrefixTextAppearance(int i) {
        k.q(this.R, i);
    }

    @Override // android.widget.LinearLayout
    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.R.setTextColor(colorStateList);
    }

    @Override // android.widget.LinearLayout
    public void setStartIconCheckable(boolean z) {
        this.p0.setCheckable(z);
    }

    @Override // android.widget.LinearLayout
    public void setStartIconContentDescription(int i) {
        Resources resources;
        java.lang.CharSequence obj2;
        if (i != 0) {
            obj2 = getResources().getText(i);
        } else {
            obj2 = 0;
        }
        setStartIconContentDescription(obj2);
    }

    @Override // android.widget.LinearLayout
    public void setStartIconContentDescription(java.lang.CharSequence charSequence) {
        Object startIconContentDescription;
        if (getStartIconContentDescription() != charSequence) {
            this.p0.setContentDescription(charSequence);
        }
    }

    @Override // android.widget.LinearLayout
    public void setStartIconDrawable(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.d(getContext(), i);
        } else {
            obj2 = 0;
        }
        setStartIconDrawable(obj2);
    }

    @Override // android.widget.LinearLayout
    public void setStartIconDrawable(Drawable drawable) {
        int obj2;
        this.p0.setImageDrawable(drawable);
        if (drawable != null) {
            o();
            setStartIconVisible(true);
            a0();
        } else {
            setStartIconVisible(false);
            obj2 = 0;
            setStartIconOnClickListener(obj2);
            setStartIconOnLongClickListener(obj2);
            setStartIconContentDescription(obj2);
        }
    }

    @Override // android.widget.LinearLayout
    public void setStartIconOnClickListener(View.OnClickListener view$OnClickListener) {
        TextInputLayout.e0(this.p0, onClickListener, this.w0);
    }

    @Override // android.widget.LinearLayout
    public void setStartIconOnLongClickListener(View.OnLongClickListener view$OnLongClickListener) {
        this.w0 = onLongClickListener;
        TextInputLayout.f0(this.p0, onLongClickListener);
    }

    @Override // android.widget.LinearLayout
    public void setStartIconTintList(ColorStateList colorStateList) {
        ColorStateList obj2;
        if (this.q0 != colorStateList) {
            this.q0 = colorStateList;
            this.r0 = true;
            o();
        }
    }

    @Override // android.widget.LinearLayout
    public void setStartIconTintMode(PorterDuff.Mode porterDuff$Mode) {
        PorterDuff.Mode obj2;
        if (this.s0 != mode) {
            this.s0 = mode;
            this.t0 = true;
            o();
        }
    }

    @Override // android.widget.LinearLayout
    public void setStartIconVisible(boolean z) {
        boolean z2;
        int obj2;
        if (R() != z) {
            obj2 = z ? 0 : 8;
            this.p0.setVisibility(obj2);
            B0();
            s0();
        }
    }

    @Override // android.widget.LinearLayout
    public void setSuffixText(java.lang.CharSequence charSequence) {
        int i;
        i = TextUtils.isEmpty(charSequence) ? 0 : charSequence;
        this.S = i;
        this.T.setText(charSequence);
        F0();
    }

    @Override // android.widget.LinearLayout
    public void setSuffixTextAppearance(int i) {
        k.q(this.T, i);
    }

    @Override // android.widget.LinearLayout
    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.T.setTextColor(colorStateList);
    }

    @Override // android.widget.LinearLayout
    public void setTextInputAccessibilityDelegate(com.google.android.material.textfield.TextInputLayout.e textInputLayout$e) {
        final EditText editText = this.w;
        if (editText != null) {
            u.l0(editText, e);
        }
    }

    @Override // android.widget.LinearLayout
    public void setTypeface(Typeface typeface) {
        Object typeface2;
        this.o0 = typeface;
        this.Z0.f0(typeface);
        this.A.J(typeface);
        typeface2 = this.E;
        if (typeface != this.o0 && typeface2 != null) {
            this.o0 = typeface;
            this.Z0.f0(typeface);
            this.A.J(typeface);
            typeface2 = this.E;
            if (typeface2 != null) {
                typeface2.setTypeface(typeface);
            }
        }
    }

    @Override // android.widget.LinearLayout
    void t0() {
        Object background;
        android.graphics.PorterDuffColorFilter porterDuffColorFilter;
        PorterDuff.Mode sRC_IN;
        background = this.w;
        if (background != null) {
            if (this.e0 != 0) {
            } else {
                background = background.getBackground();
                if (background == null) {
                }
                if (a0.a(background)) {
                    background = background.mutate();
                }
                if (this.A.k()) {
                    background.setColorFilter(i.e(this.A.o(), PorterDuff.Mode.SRC_IN));
                } else {
                    porterDuffColorFilter = this.E;
                    if (this.D && porterDuffColorFilter != null) {
                        porterDuffColorFilter = this.E;
                        if (porterDuffColorFilter != null) {
                            background.setColorFilter(i.e(porterDuffColorFilter.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
                        } else {
                            a.c(background);
                            this.w.refreshDrawableState();
                        }
                    } else {
                    }
                }
            }
        }
    }

    @Override // android.widget.LinearLayout
    void w0(boolean z) {
        x0(z, false);
    }
}
