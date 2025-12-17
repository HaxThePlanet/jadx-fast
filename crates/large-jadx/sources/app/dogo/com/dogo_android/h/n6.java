package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class n6 extends app.dogo.com.dogo_android.h.m6 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
    }

    public n6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, n6.T, n6.U));
    }

    private n6(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (ImageView)object3Arr3[1]);
        this.S = -1;
        int i4 = 0;
        this.O.setTag(i4);
        this.P.setTag(i4);
        Object obj8 = object3Arr3[0];
        this.R = (ConstraintLayout)obj8;
        obj8.setTag(i4);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m6
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.m6
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            T((TrickItem.TrickStep)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.m6
    public void T(TrickItem.TrickStep trickItem$TrickStep) {
        this.Q = trickStep;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = trickStep;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m6
    protected void m() {
        int cmp;
        int i;
        int i2;
        String str;
        int i4 = 0;
        this.S = i4;
        final TrickItem.TrickStep trickStep = this.Q;
        cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.S = i4;
            trickStep = this.Q;
            cmp = Long.compare(i3, i4);
        }
        try {
            if (trickStep != null) {
            } else {
            }
            i2 = image;
            i = str;
            i2 = i;
            if (cmp != 0) {
            }
            g.c(this.O, i);
            n.w(this.P, i2);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.m6
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
