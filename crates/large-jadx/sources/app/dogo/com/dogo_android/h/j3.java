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
public class j3 extends app.dogo.com.dogo_android.h.i3 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j3.U = sparseIntArray;
        sparseIntArray.put(2131362585, 3);
    }

    public j3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, j3.T, j3.U));
    }

    private j3(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (Guideline)object3Arr3[3], (ImageView)object3Arr3[1]);
        this.S = -1;
        int i5 = 0;
        this.O.setTag(i5);
        this.P.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.R = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i3
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.i3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((TrickItem.TrickStep)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.i3
    public void V(TrickItem.TrickStep trickItem$TrickStep) {
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

    @Override // app.dogo.com.dogo_android.h.i3
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

    @Override // app.dogo.com.dogo_android.h.i3
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
