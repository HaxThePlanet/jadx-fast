package d.h.l;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class p {

    private int a;
    private int b;
    public p(ViewGroup viewGroup) {
        super();
    }

    public int a() {
        return this.a | this.b;
    }

    public void b(View view, View view2, int i) {
        c(view, view2, i, 0);
    }

    public void c(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.b = i;
        } else {
            this.a = i;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i) {
        final int i3 = 0;
        if (i == 1) {
            this.b = i3;
        } else {
            this.a = i3;
        }
    }
}
