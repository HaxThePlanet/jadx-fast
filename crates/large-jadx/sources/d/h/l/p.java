package d.h.l;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class p {

    private int a;
    private int b;
    public p(ViewGroup viewGroup) {
        super();
    }

    public int a() {
        return i |= i3;
    }

    public void b(View view, View view2, int i3) {
        c(view, view2, i3, 0);
    }

    public void c(View view, View view2, int i3, int i4) {
        if (i4 == 1) {
            this.b = i3;
        } else {
            this.a = i3;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i2) {
        final int obj2 = 0;
        if (i2 == 1) {
            this.b = obj2;
        } else {
            this.a = obj2;
        }
    }
}
