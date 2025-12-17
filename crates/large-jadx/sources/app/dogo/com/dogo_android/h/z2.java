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
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class z2 extends app.dogo.com.dogo_android.h.y2 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z2.U = sparseIntArray;
        sparseIntArray.put(2131362642, 3);
    }

    public z2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, z2.T, z2.U));
    }

    private z2(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (ImageView)object3Arr3[3], (TextView)object3Arr3[2]);
        this.S = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.R = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y2
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y2
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.y2
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

    @Override // app.dogo.com.dogo_android.h.y2
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

    @Override // app.dogo.com.dogo_android.h.y2
    protected void m() {
        int cmp;
        int imageUrl;
        int name;
        int i2 = 0;
        this.S = i2;
        final TrickItem trickItem = this.Q;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.S = i2;
            trickItem = this.Q;
            cmp = Long.compare(i, i2);
        }
        try {
            if (trickItem != null) {
            } else {
            }
            imageUrl = trickItem.getImageUrl();
            name = trickItem.getName();
            name = imageUrl;
            if (cmp != 0) {
            }
            n.w(this.O, imageUrl);
            g.c(this.P, name);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.y2
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
