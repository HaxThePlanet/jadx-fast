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
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class z5 extends app.dogo.com.dogo_android.h.y5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
    }

    public z5(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, z5.T, z5.U));
    }

    private z5(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.S = -1;
        Object obj8 = object3Arr3[0];
        this.R = (ConstraintLayout)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        this.P.setTag(obj10);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y5
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y5
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.y5
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((TrickItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.y5
    public void V(TrickItem trickItem) {
        this.Q = trickItem;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = trickItem;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y5
    protected void m() {
        int cmp;
        int imageUrl;
        final int i2 = 0;
        this.S = i2;
        imageUrl = 0;
        final TrickItem trickItem = this.Q;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.S = i2;
            imageUrl = 0;
            trickItem = this.Q;
            cmp = Long.compare(i, i2);
        }
        try {
            if (trickItem != null) {
            }
            imageUrl = trickItem.getImageUrl();
            if (cmp != 0) {
            }
            n.n0(this.O, imageUrl);
            f.r(this.P, trickItem);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.y5
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
