package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class jn extends app.dogo.com.dogo_android.h.in {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private long Q;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        jn.S = sparseIntArray;
        sparseIntArray.put(2131363450, 1);
        sparseIntArray.put(2131363451, 2);
        sparseIntArray.put(2131362112, 3);
        sparseIntArray.put(2131363421, 4);
        sparseIntArray.put(2131362322, 5);
        sparseIntArray.put(2131362731, 6);
        sparseIntArray.put(2131362619, 7);
        sparseIntArray.put(2131362948, 8);
    }

    public jn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, jn.R, jn.S));
    }

    private jn(e e, View view2, Object[] object3Arr3) {
        final Object obj21 = this;
        super(e, view2, 0, (CardView)object3Arr3[3], (ImageView)object3Arr3[5], (ImageView)object3Arr3[7], (LinearLayout)object3Arr3[6], (TextView)object3Arr3[8], (TextView)object3Arr3[4], (ImageView)object3Arr3[1], (ImageView)object3Arr3[2], (LinearLayout)object3Arr3[0]);
        obj21.Q = -1;
        obj21.P.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.in
    public void A() {
        this.Q = 1;
        I();
        return;
        synchronized (this) {
            this.Q = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.in
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.in
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.in
    protected void m() {
        this.Q = 0;
        return;
        synchronized (this) {
            this.Q = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.in
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
