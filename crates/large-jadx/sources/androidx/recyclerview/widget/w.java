package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class w {
    static int a(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.t t2, View view3, View view4, androidx.recyclerview.widget.RecyclerView.p recyclerView$p5, boolean z6) {
        int obj1;
        if (p5.g0() != 0 && b0.c() != 0 && view3 != null) {
            if (b0.c() != 0) {
                if (view3 != null) {
                    if (view4 == null) {
                    } else {
                        if (!z6) {
                            return obj1++;
                        }
                    }
                    return Math.min(t2.n(), obj1 -= obj3);
                }
            }
        }
        return 0;
    }

    static int b(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.t t2, View view3, View view4, androidx.recyclerview.widget.RecyclerView.p recyclerView$p5, boolean z6, boolean z7) {
        int i;
        int obj4;
        final int i4 = 0;
        if (p5.g0() != 0 && b0.c() != 0 && view3 != null) {
            if (b0.c() != 0) {
                if (view3 != null) {
                    if (view4 == null) {
                    } else {
                        if (z7) {
                            obj4 = Math.max(i4, obj4--);
                        } else {
                            obj4 = Math.max(i4, Math.min(p5.A0(view3), p5.A0(view4)));
                        }
                        if (!z6) {
                            return obj4;
                        }
                    }
                    return Math.round(obj4 += obj5);
                }
            }
        }
        return i4;
    }

    static int c(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.t t2, View view3, View view4, androidx.recyclerview.widget.RecyclerView.p recyclerView$p5, boolean z6) {
        int i;
        if (p5.g0() != 0 && b0.c() != 0 && view3 != null) {
            if (b0.c() != 0) {
                if (view3 != null) {
                    if (view4 == null) {
                    } else {
                        if (!z6) {
                            return b0.c();
                        }
                    }
                    return (int)obj3;
                }
            }
        }
        return 0;
    }
}
