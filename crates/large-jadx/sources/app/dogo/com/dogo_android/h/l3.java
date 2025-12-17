package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep;

/* loaded from: classes.dex */
public class l3 extends app.dogo.com.dogo_android.h.k3 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l3.U = sparseIntArray;
        sparseIntArray.put(2131362594, 2);
        sparseIntArray.put(2131362595, 3);
        sparseIntArray.put(2131362964, 4);
    }

    public l3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, l3.T, l3.U));
    }

    private l3(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[1], (Guideline)object3Arr3[2], (Guideline)object3Arr3[3], (PlayerView)object3Arr3[4]);
        this.S = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.R = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.k3
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.k3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((TrickItem.VideoStep)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.k3
    public void V(TrickItem.VideoStep trickItem$VideoStep) {
        this.Q = videoStep;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = videoStep;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k3
    protected void m() {
        int cmp;
        int description;
        final int i2 = 0;
        this.S = i2;
        final TrickItem.VideoStep videoStep = this.Q;
        description = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.S = i2;
            videoStep = this.Q;
            description = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (videoStep != null) {
            }
            description = videoStep.getDescription();
            if (cmp != 0) {
            }
            g.c(this.O, description);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.k3
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
