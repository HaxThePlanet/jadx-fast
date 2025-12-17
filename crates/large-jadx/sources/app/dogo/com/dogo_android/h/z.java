package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class z extends app.dogo.com.dogo_android.h.y {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final MaterialCardView Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z.T = sparseIntArray;
        sparseIntArray.put(2131362619, 2);
        sparseIntArray.put(2131361940, 3);
    }

    public z(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, z.S, z.T));
    }

    private z(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[3], (AppCompatImageView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.R = -1;
        Object obj9 = object3Arr3[0];
        this.Q = (MaterialCardView)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.y
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

    @Override // app.dogo.com.dogo_android.h.y
    public void V(TrickItem trickItem) {
        this.P = trickItem;
        this.R = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.P = trickItem;
            this.R = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y
    protected void m() {
        int cmp;
        int shortDescription;
        final int i2 = 0;
        this.R = i2;
        final TrickItem trickItem = this.P;
        shortDescription = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.R = i2;
            trickItem = this.P;
            shortDescription = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (trickItem != null) {
            }
            shortDescription = trickItem.getShortDescription();
            if (cmp != 0) {
            }
            g.c(this.O, shortDescription);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.y
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
