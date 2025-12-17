package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.j;
import d.a.j;

/* loaded from: classes.dex */
class n extends PopupWindow {

    private static final boolean b = false;
    private boolean a;
    static {
        if (Build.VERSION.SDK_INT < 21) {
            int i = 1;
        }
        int i2 = 0;
    }

    public n(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        a(context, attributeSet2, i3, i4);
    }

    private void a(Context context, AttributeSet attributeSet2, int i3, int i4) {
        int obj3;
        boolean obj4;
        final androidx.appcompat.widget.t0 obj2 = t0.v(context, attributeSet2, j.Q1, i3, i4);
        obj3 = j.S1;
        if (obj2.s(obj3)) {
            b(obj2.a(obj3, false));
        }
        setBackgroundDrawable(obj2.g(j.R1));
        obj2.w();
    }

    private void b(boolean z) {
        if (n.b) {
            this.a = z;
        } else {
            j.a(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        boolean height;
        int obj4;
        if (n.b && this.a) {
            if (this.a) {
                i3 -= height;
            }
        }
        super.showAsDropDown(view, i2, obj4);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        boolean height;
        int obj4;
        if (n.b && this.a) {
            if (this.a) {
                i3 -= height;
            }
        }
        super.showAsDropDown(view, i2, obj4, i4);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        boolean height;
        int obj9;
        if (n.b && this.a) {
            if (this.a) {
                i3 -= height;
            }
        }
        super.update(view, i2, obj9, i4, i5);
    }
}
