package app.dogo.com.dogo_android.util.g0;

import androidx.databinding.a;

/* compiled from: CustomFabViewStateModel.java */
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
    public a(int i, boolean z, int i2, int i3, String str, int i4, float f, int i5) {
        super();
        this.a = i;
        this.b = i2;
        this.c = str;
        this.v = i4;
        this.w = f;
        this.x = z;
        this.z = i5;
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
    public void m(int i, Boolean boolean, int i2, int i3, String str, int i4, float f, int i5, Boolean boolean2) {
        boolean booleanValue;
        if (i != 0) {
            this.a = i;
        }
        if (i2 != 0) {
            this.b = i2;
        }
        if (str != null) {
            this.c = str;
        }
        if (i4 != 0) {
            this.v = i4;
        }
        if (i5 != 0) {
            this.z = i5;
        }
        if (boolean != null) {
            this.x = boolean.booleanValue();
        }
        if (boolean2 != null) {
            this.y = boolean2.booleanValue();
        }
        this.w = f;
        notifyChange();
    }
}
