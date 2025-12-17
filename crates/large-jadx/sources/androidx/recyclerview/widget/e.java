package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class e implements androidx.recyclerview.widget.r {

    final androidx.recyclerview.widget.r a;
    int b = 0;
    int c = -1;
    int v = -1;
    Object w = null;
    public e(androidx.recyclerview.widget.r r) {
        super();
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        this.a = r;
    }

    @Override // androidx.recyclerview.widget.r
    public void a() {
        androidx.recyclerview.widget.r i;
        int i2;
        int i3;
        Object obj;
        i = this.b;
        if (i == 0) {
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    this.a.onChanged(this.c, this.v, this.w);
                }
            } else {
                this.a.onRemoved(this.c, this.v);
            }
        } else {
            this.a.onInserted(this.c, this.v);
        }
        this.w = 0;
        this.b = 0;
    }

    @Override // androidx.recyclerview.widget.r
    public void onChanged(int i, int i2, Object object3) {
        int i3;
        int i4;
        int i5;
        Object obj;
        final int i6 = 3;
        i3 = this.c;
        i4 = this.v;
        i5 = i + i2;
        if (this.b == i6 && i <= i3 + i4 && i5 >= i3 && this.w == object3) {
            i3 = this.c;
            i4 = this.v;
            if (i <= i3 + i4) {
                i5 = i + i2;
                if (i5 >= i3) {
                    if (this.w == object3) {
                        this.c = Math.min(i, i3);
                        this.v = obj6 -= obj7;
                    }
                }
            }
        }
        a();
        this.c = i;
        this.v = i2;
        this.w = object3;
        this.b = i6;
    }

    @Override // androidx.recyclerview.widget.r
    public void onInserted(int i, int i2) {
        int i4;
        int i5;
        int i3;
        final int i6 = 1;
        i4 = this.c;
        i5 = this.v;
        if (this.b == i6 && i >= i4 && i <= i4 + i5) {
            i4 = this.c;
            if (i >= i4) {
                i5 = this.v;
                if (i <= i4 + i5) {
                    this.v = i5 += i2;
                    this.c = Math.min(i, i4);
                }
            }
        }
        a();
        this.c = i;
        this.v = i2;
        this.b = i6;
    }

    @Override // androidx.recyclerview.widget.r
    public void onMoved(int i, int i2) {
        a();
        this.a.onMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.r
    public void onRemoved(int i, int i2) {
        int i3;
        int i4;
        final int i7 = 2;
        i3 = this.c;
        if (this.b == i7 && i3 >= i && i3 <= i + i2) {
            i3 = this.c;
            if (i3 >= i) {
                if (i3 <= i + i2) {
                    this.v = i5 += i2;
                    this.c = i;
                }
            }
        }
        a();
        this.c = i;
        this.v = i2;
        this.b = i7;
    }
}
