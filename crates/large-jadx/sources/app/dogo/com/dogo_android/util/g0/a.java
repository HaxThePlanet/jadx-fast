package app.dogo.com.dogo_android.util.g0;

import androidx.databinding.a;

/* loaded from: classes.dex */
public class a extends a {

    private int a;
    private int b;
    private String c;
    private int v;
    private float w;
    private boolean x;
    private boolean y;
    private int z;
    public a(int i, boolean z2, int i3, int i4, String string5, int i6, float f7, int i8) {
        super();
        this.a = i;
        this.b = i3;
        this.c = string5;
        this.v = i6;
        this.w = f7;
        this.x = z2;
        this.z = i8;
    }

    @Override // androidx.databinding.a
    public int d() {
        return this.a;
    }

    @Override // androidx.databinding.a
    public float e() {
        return this.w;
    }

    @Override // androidx.databinding.a
    public int f() {
        return this.b;
    }

    @Override // androidx.databinding.a
    public int g() {
        return this.z;
    }

    @Override // androidx.databinding.a
    public String h() {
        return this.c;
    }

    @Override // androidx.databinding.a
    public int i() {
        return this.v;
    }

    @Override // androidx.databinding.a
    public boolean j() {
        return this.y;
    }

    @Override // androidx.databinding.a
    public boolean k() {
        return this.x;
    }

    @Override // androidx.databinding.a
    public void l(boolean z) {
        this.y = z;
    }

    @Override // androidx.databinding.a
    public void m(int i, Boolean boolean2, int i3, int i4, String string5, int i6, float f7, int i8, Boolean boolean9) {
        int obj1;
        if (i != 0) {
            this.a = i;
        }
        if (i3 != 0) {
            this.b = i3;
        }
        if (string5 != null) {
            this.c = string5;
        }
        if (i6 != 0) {
            this.v = i6;
        }
        if (i8 != 0) {
            this.z = i8;
        }
        if (boolean2 != null) {
            this.x = boolean2.booleanValue();
        }
        if (boolean9 != null) {
            this.y = boolean9.booleanValue();
        }
        this.w = f7;
        notifyChange();
    }
}
