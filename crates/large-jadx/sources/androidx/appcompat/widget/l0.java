package androidx.appcompat.widget;

/* loaded from: classes.dex */
class l0 {

    private int a = 0;
    private int b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;
    l0() {
        super();
        final int i = 0;
        final int i2 = Integer.MIN_VALUE;
    }

    public int a() {
        int i;
        i = this.g ? this.a : this.b;
        return i;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        int i;
        i = this.g ? this.b : this.a;
        return i;
    }

    public void e(int i, int i2) {
        this.h = false;
        int i4 = Integer.MIN_VALUE;
        if (i != i4) {
            this.e = i;
            this.a = i;
        }
        if (i2 != i4) {
            this.f = i2;
            this.b = i2;
        }
    }

    public void f(boolean z) {
        int z2;
        int obj2;
        if (z == this.g) {
        }
        this.g = z;
        if (this.h) {
            z2 = Integer.MIN_VALUE;
            if (z) {
                if (this.d != z2) {
                } else {
                    obj2 = this.e;
                }
                this.a = obj2;
                if (this.c != z2) {
                } else {
                    obj2 = this.f;
                }
                this.b = obj2;
            } else {
                if (this.c != z2) {
                } else {
                    obj2 = this.e;
                }
                this.a = obj2;
                if (this.d != z2) {
                } else {
                    obj2 = this.f;
                }
                this.b = obj2;
            }
        } else {
            this.a = this.e;
            this.b = this.f;
        }
    }

    public void g(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        final int i4 = Integer.MIN_VALUE;
        if (this.g) {
            if (i2 != i4) {
                this.a = i2;
            }
            if (i != i4) {
                this.b = i;
            }
        } else {
            if (i != i4) {
                this.a = i;
            }
            if (i2 != i4) {
                this.b = i2;
            }
        }
    }
}
