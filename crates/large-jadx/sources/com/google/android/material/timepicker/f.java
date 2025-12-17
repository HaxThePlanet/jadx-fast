package com.google.android.material.timepicker;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.a;
import f.c.a.e.j;

/* loaded from: classes2.dex */
class f implements com.google.android.material.timepicker.ClockHandView.d, com.google.android.material.timepicker.TimePickerView.g, com.google.android.material.timepicker.TimePickerView.f, com.google.android.material.timepicker.ClockHandView.c, com.google.android.material.timepicker.g {

    private static final String[] x;
    private static final String[] y;
    private static final String[] z;
    private com.google.android.material.timepicker.TimePickerView a;
    private com.google.android.material.timepicker.e b;
    private float c;
    private float v;
    private boolean w = false;
    static {
        f.x = /* result */;
        f.y = /* result */;
        f.z = /* result */;
    }

    public f(com.google.android.material.timepicker.TimePickerView timePickerView, com.google.android.material.timepicker.e e2) {
        super();
        final int i = 0;
        this.a = timePickerView;
        this.b = e2;
        j();
    }

    private int h() {
        int i;
        i = eVar.c == 1 ? 15 : 30;
        return i;
    }

    private String[] i() {
        String[] strArr;
        strArr = eVar.c == 1 ? f.y : f.x;
        return strArr;
    }

    private void k(int i, int i2) {
        int obj3;
        int obj4;
        final com.google.android.material.timepicker.e eVar = this.b;
        if (eVar.w == i2) {
            if (eVar.v != i) {
                obj3 = Build.VERSION.SDK_INT >= 21 ? 4 : 1;
                this.a.performHapticFeedback(obj3);
            }
        } else {
        }
    }

    private void m() {
        com.google.android.material.timepicker.e eVar = this.b;
        this.a.M(eVar.y, eVar.c(), eVar2.w);
    }

    private void n() {
        String str = "%d";
        o(f.x, str);
        o(f.y, str);
        o(f.z, "%02d");
    }

    private void o(String[] stringArr, String string2) {
        int i;
        String str;
        Object obj;
        i = 0;
        for (Object obj : stringArr) {
            stringArr[i] = e.b(this.a.getResources(), obj, string2);
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    public void a() {
        this.a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    public void b(float f, boolean z2) {
        double floor;
        int i;
        float obj6;
        if (this.w) {
        }
        com.google.android.material.timepicker.e eVar = this.b;
        obj6 = Math.round(f);
        com.google.android.material.timepicker.e eVar2 = this.b;
        i = eVar2.x;
        if (i == 12) {
            eVar2.i(obj6 /= 6);
            this.c = (float)floor;
        } else {
            this.b.g(obj6 /= i6);
            this.v = (float)obj6;
        }
        if (!z2) {
            m();
            k(eVar.v, eVar.w);
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    public void c() {
        this.v = (float)i2;
        com.google.android.material.timepicker.e eVar2 = this.b;
        this.c = (float)i6;
        l(eVar2.x, false);
        m();
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    public void d(float f, boolean z2) {
        int i;
        int obj7;
        boolean obj8;
        i = 1;
        this.w = i;
        com.google.android.material.timepicker.e eVar = this.b;
        final int i5 = 0;
        if (eVar.x == 10) {
            this.a.B(this.v, i5);
            if (!(AccessibilityManager)a.k(this.a.getContext(), AccessibilityManager.class).isTouchExplorationEnabled()) {
                l(12, i);
            }
        } else {
            if (!z2) {
                this.b.i(obj7 *= 5);
                this.c = (float)obj7;
            }
            this.a.B(this.c, z2);
        }
        this.w = i5;
        m();
        k(eVar.v, eVar.w);
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    public void e(int i) {
        this.b.j(i);
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    public void f(int i) {
        l(i, true);
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    public void g() {
        this.a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    public void j() {
        int i;
        if (eVar.c == 0) {
            this.a.L();
        }
        this.a.y(this);
        this.a.H(this);
        this.a.G(this);
        this.a.E(this);
        n();
        c();
    }

    @Override // com.google.android.material.timepicker.ClockHandView$d
    void l(int i, boolean z2) {
        int i2;
        float f;
        String[] strArr;
        int i3;
        i2 = i == 12 ? 1 : 0;
        this.a.A(i2);
        eVar.x = i;
        if (i2 != 0) {
            strArr = f.z;
        } else {
            strArr = i();
        }
        i3 = i2 != 0 ? j.l : j.j;
        this.a.J(strArr, i3);
        f = i2 != 0 ? this.c : this.v;
        this.a.B(f, z2);
        this.a.z(i);
        a obj6 = new a(this.a.getContext(), j.i);
        this.a.D(obj6);
        obj6 = new a(this.a.getContext(), j.k);
        this.a.C(obj6);
    }
}
