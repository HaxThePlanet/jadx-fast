package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.e.f.c;
import androidx.core.widget.d;
import androidx.core.widget.k;
import d.a.j;
import d.h.l.u;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: classes.dex */
class v {

    private final TextView a;
    private androidx.appcompat.widget.r0 b;
    private androidx.appcompat.widget.r0 c;
    private androidx.appcompat.widget.r0 d;
    private androidx.appcompat.widget.r0 e;
    private androidx.appcompat.widget.r0 f;
    private androidx.appcompat.widget.r0 g;
    private androidx.appcompat.widget.r0 h;
    private final androidx.appcompat.widget.w i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    class a extends f.c {

        final int a;
        final int b;
        final WeakReference c;
        final androidx.appcompat.widget.v d;
        a(androidx.appcompat.widget.v v, int i2, int i3, WeakReference weakReference4) {
            this.d = v;
            this.a = i2;
            this.b = i3;
            this.c = weakReference4;
            super();
        }

        @Override // androidx.core.content.e.f$c
        public void d(int i) {
        }

        @Override // androidx.core.content.e.f$c
        public void e(Typeface typeface) {
            int sDK_INT;
            int i;
            Typeface obj3;
            sDK_INT = this.a;
            if (Build.VERSION.SDK_INT >= 28 && sDK_INT != -1) {
                sDK_INT = this.a;
                if (sDK_INT != -1) {
                    i = i2 &= 2 != 0 ? 1 : 0;
                    obj3 = Typeface.create(typeface, sDK_INT, i);
                }
            }
            this.d.n(this.c, obj3);
        }
    }
    v(TextView textView) {
        super();
        int i = 0;
        int i2 = -1;
        this.a = textView;
        w wVar = new w(textView);
        this.i = wVar;
    }

    private void A(int i, float f2) {
        this.i.y(i, f2);
    }

    private void B(Context context, androidx.appcompat.widget.t0 t02) {
        int sDK_INT;
        int i2;
        int i4;
        int i3;
        boolean z;
        int i;
        androidx.appcompat.widget.v.a aVar;
        Typeface obj11;
        int obj12;
        this.j = t02.k(j.M2, this.j);
        sDK_INT = Build.VERSION.SDK_INT;
        int i8 = 28;
        final int i9 = 2;
        final int i10 = -1;
        i2 = 0;
        i4 = t02.k(j.R2, i10);
        this.k = i4;
        if (sDK_INT >= i8 && i4 != i10) {
            i4 = t02.k(j.R2, i10);
            this.k = i4;
            if (i4 != i10) {
                this.j = i12 |= i2;
            }
        }
        final int i16 = 1;
        if (!t02.s(j.Q2)) {
            if (t02.s(j.S2)) {
            } else {
                obj11 = j.L2;
                if (t02.s(obj11)) {
                    this.m = i2;
                    obj11 = t02.k(obj11, i16);
                    if (obj11 != i16) {
                        if (obj11 != i9) {
                            if (obj11 != 3) {
                            } else {
                                this.l = Typeface.MONOSPACE;
                            }
                        } else {
                            this.l = Typeface.SERIF;
                        }
                    } else {
                        this.l = Typeface.SANS_SERIF;
                    }
                }
            }
        }
        this.l = 0;
        int s2 = j.S2;
        if (t02.s(s2)) {
            i3 = s2;
        }
        obj11 = new WeakReference(this.a);
        aVar = new v.a(this, this.k, this.j, obj11);
        obj11 = t02.j(i3, this.j, aVar);
        if (!context.isRestricted() && obj11 != null) {
            obj11 = new WeakReference(this.a);
            aVar = new v.a(this, i, i17, obj11);
            obj11 = t02.j(i3, this.j, aVar);
            if (obj11 != null) {
                if (sDK_INT >= i8 && this.k != i10) {
                    if (this.k != i10) {
                        i = i14 &= i9 != 0 ? i16 : i2;
                        this.l = Typeface.create(Typeface.create(obj11, i2), this.k, i);
                    } else {
                        this.l = obj11;
                    }
                } else {
                }
            }
            obj11 = this.l == null ? i16 : i2;
            this.m = obj11;
        }
        obj11 = t02.o(i3);
        if (this.l == null && obj11 != null) {
            obj11 = t02.o(i3);
            if (obj11 != null) {
                if (Build.VERSION.SDK_INT >= i8 && this.k != i10) {
                    if (this.k != i10) {
                        if (i6 &= i9 != 0) {
                            i2 = i16;
                        }
                        this.l = Typeface.create(Typeface.create(obj11, i2), this.k, i2);
                    } else {
                        this.l = Typeface.create(obj11, this.j);
                    }
                } else {
                }
            }
        }
    }

    private void a(Drawable drawable, androidx.appcompat.widget.r0 r02) {
        int[] drawableState;
        if (drawable != null && r02 != null) {
            if (r02 != null) {
                i.i(drawable, r02, this.a.getDrawableState());
            }
        }
    }

    private static androidx.appcompat.widget.r0 d(Context context, androidx.appcompat.widget.i i2, int i3) {
        ColorStateList obj0 = i2.f(context, i3);
        if (obj0 != null) {
            r0 obj1 = new r0();
            obj1.d = true;
            obj1.a = obj0;
            return obj1;
        }
        return null;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        Drawable[] obj7;
        Drawable obj8;
        Object obj9;
        Drawable obj10;
        Drawable obj11;
        Object obj12;
        final int sDK_INT = Build.VERSION.SDK_INT;
        final int i = 17;
        final int i2 = 3;
        final int i3 = 1;
        final int i4 = 2;
        final int i5 = 0;
        if (sDK_INT >= i) {
            if (drawable5 == null) {
                if (drawable6 != null) {
                    obj7 = this.a.getCompoundDrawablesRelative();
                    if (drawable5 != null) {
                    } else {
                        obj11 = obj7[i5];
                    }
                    if (drawable2 != null) {
                    } else {
                        obj8 = obj7[i3];
                    }
                    if (drawable6 != null) {
                    } else {
                        obj12 = obj7[i4];
                    }
                    if (drawable4 != null) {
                    } else {
                        obj10 = obj7[i2];
                    }
                    this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(obj11, obj8, obj12, obj10);
                } else {
                    if (drawable == null && drawable2 == null && drawable3 == null) {
                        if (drawable2 == null) {
                            if (drawable3 == null) {
                                if (drawable4 != null && sDK_INT >= i) {
                                    if (sDK_INT >= i) {
                                        obj11 = this.a.getCompoundDrawablesRelative();
                                        if (obj11[i5] == null) {
                                            if (obj11[i4] != null) {
                                                if (drawable2 != null) {
                                                } else {
                                                    obj8 = obj11[i3];
                                                }
                                                if (drawable4 != null) {
                                                } else {
                                                    obj10 = obj11[i2];
                                                }
                                            }
                                        } else {
                                        }
                                        this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(obj11[i5], obj8, obj11[i4], obj10);
                                    }
                                    obj11 = this.a.getCompoundDrawables();
                                    if (drawable != null) {
                                    } else {
                                        obj7 = obj11[i5];
                                    }
                                    if (drawable2 != null) {
                                    } else {
                                        obj8 = obj11[i3];
                                    }
                                    if (drawable3 != null) {
                                    } else {
                                        obj9 = obj11[i4];
                                    }
                                    if (drawable4 != null) {
                                    } else {
                                        obj10 = obj11[i2];
                                    }
                                    this.a.setCompoundDrawablesWithIntrinsicBounds(obj7, obj8, obj9, obj10);
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
    }

    private void y() {
        final androidx.appcompat.widget.r0 r0Var = this.h;
        this.b = r0Var;
        this.c = r0Var;
        this.d = r0Var;
        this.e = r0Var;
        this.f = r0Var;
        this.g = r0Var;
    }

    void b() {
        Object r0Var;
        androidx.appcompat.widget.r0 sDK_INT;
        int i2;
        int i3;
        androidx.appcompat.widget.r0 r0Var2;
        int i;
        androidx.appcompat.widget.r0 r0Var3;
        i2 = 2;
        i3 = 0;
        if (this.b == null && this.c == null && this.d == null) {
            if (this.c == null) {
                if (this.d == null) {
                    if (this.e != null) {
                        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
                        a(compoundDrawables[i3], this.b);
                        a(compoundDrawables[1], this.c);
                        a(compoundDrawables[i2], this.d);
                        a(compoundDrawables[3], this.e);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null) {
                if (this.g != null) {
                    Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
                    a(compoundDrawablesRelative[i3], this.f);
                    a(compoundDrawablesRelative[i2], this.g);
                }
            } else {
            }
        }
    }

    void c() {
        this.i.b();
    }

    int e() {
        return this.i.j();
    }

    int f() {
        return this.i.k();
    }

    int g() {
        return this.i.l();
    }

    int[] h() {
        return this.i.m();
    }

    int i() {
        return this.i.n();
    }

    ColorStateList j() {
        ColorStateList list;
        androidx.appcompat.widget.r0 r0Var = this.h;
        list = r0Var != null ? r0Var.a : 0;
        return list;
    }

    PorterDuff.Mode k() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.r0 r0Var = this.h;
        mode = r0Var != null ? r0Var.b : 0;
        return mode;
    }

    boolean l() {
        return this.i.s();
    }

    void m(AttributeSet attributeSet, int i2) {
        int i33;
        Object t0Var;
        Object forLanguageTag;
        boolean z4;
        int i16;
        int i9;
        int i19;
        int i13;
        int i5;
        int i21;
        int i39;
        int i18;
        int i28;
        int i37;
        int i27;
        int i6;
        int i;
        int forLanguageTags;
        boolean z;
        int i38;
        int i7;
        int i25;
        boolean length;
        int i40;
        AttributeSet set2;
        int i34;
        int i12;
        int i3;
        int i29;
        int i32;
        int i15;
        int i26;
        int i35;
        int i8;
        int i4;
        int i30;
        int i11;
        int[] iArr;
        int i24;
        AttributeSet set;
        int i14;
        int i22;
        androidx.appcompat.widget.i iVar;
        int i41;
        boolean z10;
        int i36;
        int i17;
        ColorStateList i23;
        int i10;
        int i31;
        boolean z5;
        androidx.appcompat.widget.i iVar2;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z3;
        boolean z11;
        boolean z9;
        int i20;
        boolean z2;
        final Object obj2 = this;
        set = attributeSet;
        int i75 = i2;
        Context context2 = obj2.a.getContext();
        iVar = i.b();
        int[] iArr3 = j.V;
        i41 = 0;
        androidx.appcompat.widget.t0 t0Var3 = t0.v(context2, set, iArr3, i75, i41);
        TextView view2 = obj2.a;
        u.j0(view2, view2.getContext(), iArr3, attributeSet, t0Var3.r(), i2, 0);
        i10 = -1;
        i33 = t0Var3.n(j.W, i10);
        i37 = j.Z;
        if (t0Var3.s(i37)) {
            obj2.b = v.d(context2, iVar, t0Var3.n(i37, i41));
        }
        i27 = j.X;
        if (t0Var3.s(i27)) {
            obj2.c = v.d(context2, iVar, t0Var3.n(i27, i41));
        }
        i6 = j.a0;
        if (t0Var3.s(i6)) {
            obj2.d = v.d(context2, iVar, t0Var3.n(i6, i41));
        }
        i = j.Y;
        if (t0Var3.s(i)) {
            obj2.e = v.d(context2, iVar, t0Var3.n(i, i41));
        }
        forLanguageTags = Build.VERSION.SDK_INT;
        i7 = j.b0;
        if (forLanguageTags >= 17 && t0Var3.s(i7)) {
            i7 = j.b0;
            if (t0Var3.s(i7)) {
                obj2.f = v.d(context2, iVar, t0Var3.n(i7, i41));
            }
            i25 = j.c0;
            if (t0Var3.s(i25)) {
                obj2.g = v.d(context2, iVar, t0Var3.n(i25, i41));
            }
        }
        t0Var3.w();
        length = transformationMethod instanceof PasswordTransformationMethod;
        if (i33 != i10) {
            i33 = t0.t(context2, i33, j.J2);
            iArr = j.U2;
            if (!length && i33.s(iArr)) {
                iArr = j.U2;
                if (i33.s(iArr)) {
                    i11 = i33.a(iArr, i41);
                    i31 = 1;
                } else {
                    i31 = i11;
                }
            } else {
            }
            obj2.B(context2, i33);
            if (forLanguageTags < 23) {
                int n22 = j.N2;
                if (i33.s(n22)) {
                    i26 = i33.c(n22);
                } else {
                    i26 = 0;
                }
                int o22 = j.O2;
                if (i33.s(o22)) {
                    i17 = i33.c(o22);
                } else {
                    i17 = 0;
                }
                i10 = j.P2;
                if (i33.s(i10)) {
                    i23 = i33.c(i10);
                } else {
                    i23 = 0;
                }
            } else {
                i26 = 0;
                i17 = 0;
            }
            int v22 = j.V2;
            if (i33.s(v22)) {
                i4 = i33.o(v22);
            } else {
                i4 = 0;
            }
            i12 = j.T2;
            if (forLanguageTags >= 26 && i33.s(i12)) {
                i12 = j.T2;
                if (i33.s(i12)) {
                    i34 = i33.o(i12);
                } else {
                    i34 = 0;
                }
            } else {
            }
            i33.w();
        } else {
            i31 = i11;
            i34 = 0;
            i26 = 0;
            i4 = 0;
            i17 = 0;
            i23 = 0;
        }
        t0Var = t0.v(context2, set, j.J2, i75, i41);
        i41 = j.U2;
        if (!length && t0Var.s(i41)) {
            i41 = j.U2;
            if (t0Var.s(i41)) {
                i20 = i34;
                i11 = t0Var.a(i41, false);
                i3 = 23;
                i31 = 1;
            } else {
                i20 = i34;
                i3 = 23;
            }
        } else {
        }
        int n2 = j.N2;
        if (forLanguageTags < i3 && t0Var.s(n2)) {
            n2 = j.N2;
            if (t0Var.s(n2)) {
                i26 = t0Var.c(n2);
            }
            int o2 = j.O2;
            if (t0Var.s(o2)) {
                i17 = t0Var.c(o2);
            }
            i3 = j.P2;
            if (t0Var.s(i3)) {
                i23 = t0Var.c(i3);
            }
        }
        int v2 = j.V2;
        if (t0Var.s(v2)) {
            i4 = t0Var.o(v2);
        }
        i15 = j.T2;
        if (forLanguageTags >= 26 && t0Var.s(i15)) {
            i15 = j.T2;
            if (t0Var.s(i15)) {
                i29 = t0Var.o(i15);
            } else {
                i29 = i20;
            }
        } else {
        }
        i36 = j.K2;
        if (forLanguageTags >= 28 && t0Var.s(i36)) {
            i36 = j.K2;
            if (t0Var.s(i36)) {
                iVar2 = iVar;
                if (t0Var.f(i36, -1) == 0) {
                    obj2.a.setTextSize(0, 0);
                }
            } else {
                iVar2 = iVar;
            }
        } else {
        }
        obj2.B(context2, t0Var);
        t0Var.w();
        if (i26 != 0) {
            obj2.a.setTextColor(i26);
        }
        if (i17 != 0) {
            obj2.a.setHintTextColor(i17);
        }
        if (i23 != 0) {
            obj2.a.setLinkTextColor(i23);
        }
        if (!length && i31 != 0) {
            if (i31 != 0) {
                obj2.r(i11);
            }
        }
        forLanguageTag = obj2.l;
        if (forLanguageTag != null) {
            if (obj2.k == -1) {
                obj2.a.setTypeface(forLanguageTag, obj2.j);
            } else {
                obj2.a.setTypeface(forLanguageTag);
            }
        }
        if (i29 != 0) {
            obj2.a.setFontVariationSettings(i29);
        }
        if (i4 != 0) {
            if (forLanguageTags >= 24) {
                obj2.a.setTextLocales(LocaleList.forLanguageTags(i4));
            } else {
                if (forLanguageTags >= 21) {
                    obj2.a.setTextLocale(Locale.forLanguageTag(i4.substring(0, i4.indexOf(44))));
                }
            }
        }
        AttributeSet set3 = attributeSet;
        obj2.i.t(set3, i75);
        z4 = obj2.i.m();
        if (d.d && obj2.i.n() != 0 && z4.length > 0) {
            if (obj2.i.n() != 0) {
                z4 = obj2.i.m();
                if (z4.length > 0) {
                    if (Float.compare(f, i29) != 0) {
                        obj2.a.setAutoSizeTextTypeUniformWithConfiguration(obj2.i.k(), obj2.i.j(), obj2.i.l(), 0);
                    } else {
                        obj2.a.setAutoSizeTextTypeUniformWithPresetSizes(z4, 0);
                    }
                }
            }
        }
        androidx.appcompat.widget.t0 t0Var2 = t0.u(context2, set3, j.d0);
        int i53 = -1;
        i16 = t0Var2.n(j.l0, i53);
        androidx.appcompat.widget.i iVar3 = iVar2;
        if (i16 != i53) {
            i32 = i16;
        } else {
            i32 = 0;
        }
        i9 = t0Var2.n(j.q0, i53);
        if (i9 != i53) {
            i35 = i9;
        } else {
            i35 = 0;
        }
        i19 = t0Var2.n(j.m0, i53);
        if (i19 != i53) {
            i30 = i19;
        } else {
            i30 = 0;
        }
        i13 = t0Var2.n(j.j0, i53);
        if (i13 != i53) {
            i24 = i13;
        } else {
            i24 = 0;
        }
        i5 = t0Var2.n(j.n0, i53);
        if (i5 != i53) {
            i14 = i5;
        } else {
            i14 = 0;
        }
        i21 = t0Var2.n(j.k0, i53);
        if (i21 != i53) {
            i22 = i21;
        } else {
            i22 = 0;
        }
        this.x(i32, i35, i30, i24, i14, i22);
        i39 = j.o0;
        if (t0Var2.s(i39)) {
            k.j(obj2.a, t0Var2.c(i39));
        }
        i18 = j.p0;
        if (t0Var2.s(i18)) {
            k.k(obj2.a, a0.e(t0Var2.k(i18, -1), 0));
        } else {
            i38 = -1;
        }
        i28 = t0Var2.f(j.r0, i38);
        int i63 = t0Var2.f(j.s0, i38);
        int i68 = t0Var2.f(j.t0, i38);
        t0Var2.w();
        if (i28 != i38) {
            k.m(obj2.a, i28);
        }
        if (i63 != i38) {
            k.n(obj2.a, i63);
        }
        if (i68 != i38) {
            k.o(obj2.a, i68);
        }
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface2) {
        boolean z;
        Object obj2;
        this.l = typeface2;
        obj2 = weakReference.get();
        if (this.m && (TextView)obj2 != null) {
            this.l = typeface2;
            obj2 = weakReference.get();
            if ((TextView)(TextView)obj2 != null) {
                (TextView)(TextView)obj2.setTypeface(typeface2, this.j);
            }
        }
    }

    void o(boolean z, int i2, int i3, int i4, int i5) {
        if (!d.d) {
            c();
        }
    }

    void p() {
        b();
    }

    void q(Context context, int i2) {
        int z;
        int sDK_INT;
        int i3;
        int i;
        boolean z2;
        boolean z3;
        int obj5;
        Object obj6;
        obj6 = t0.t(context, i2, j.J2);
        z = j.U2;
        final int i4 = 0;
        if (obj6.s(z)) {
            r(obj6.a(z, i4));
        }
        sDK_INT = Build.VERSION.SDK_INT;
        i3 = j.N2;
        i3 = obj6.c(i3);
        if (sDK_INT < 23 && obj6.s(i3) && i3 != null) {
            i3 = j.N2;
            if (obj6.s(i3)) {
                i3 = obj6.c(i3);
                if (i3 != null) {
                    this.a.setTextColor(i3);
                }
            }
        }
        i = j.K2;
        if (obj6.s(i) && obj6.f(i, -1) == 0) {
            if (obj6.f(i, -1) == 0) {
                this.a.setTextSize(i4, 0);
            }
        }
        B(context, obj6);
        obj5 = j.T2;
        obj5 = obj6.o(obj5);
        if (sDK_INT >= 26 && obj6.s(obj5) && obj5 != null) {
            obj5 = j.T2;
            if (obj6.s(obj5)) {
                obj5 = obj6.o(obj5);
                if (obj5 != null) {
                    this.a.setFontVariationSettings(obj5);
                }
            }
        }
        obj6.w();
        obj5 = this.l;
        if (obj5 != null) {
            this.a.setTypeface(obj5, this.j);
        }
    }

    void r(boolean z) {
        this.a.setAllCaps(z);
    }

    void s(int i, int i2, int i3, int i4) {
        this.i.u(i, i2, i3, i4);
    }

    void t(int[] iArr, int i2) {
        this.i.v(iArr, i2);
    }

    void u(int i) {
        this.i.w(i);
    }

    void v(ColorStateList colorStateList) {
        androidx.appcompat.widget.r0 r0Var;
        int obj2;
        if (this.h == null) {
            r0Var = new r0();
            this.h = r0Var;
        }
        androidx.appcompat.widget.r0 r0Var2 = this.h;
        r0Var2.a = colorStateList;
        obj2 = colorStateList != null ? 1 : 0;
        r0Var2.d = obj2;
        y();
    }

    void w(PorterDuff.Mode porterDuff$Mode) {
        androidx.appcompat.widget.r0 r0Var;
        int obj2;
        if (this.h == null) {
            r0Var = new r0();
            this.h = r0Var;
        }
        androidx.appcompat.widget.r0 r0Var2 = this.h;
        r0Var2.b = mode;
        obj2 = mode != null ? 1 : 0;
        r0Var2.c = obj2;
        y();
    }

    void z(int i, float f2) {
        boolean z;
        if (!d.d && !l()) {
            if (!l()) {
                A(i, f2);
            }
        }
    }
}
