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
public class b8 extends app.dogo.com.dogo_android.h.a8 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        b8.W = sparseIntArray;
        sparseIntArray.put(2131362112, 4);
    }

    public b8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, b8.V, b8.W));
    }

    private b8(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (CardView)object3Arr3[4], (TextView)object3Arr3[3], (TextView)object3Arr3[2], (ImageView)object3Arr3[1]);
        this.U = -1;
        int i6 = 0;
        this.P.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.Q.setTag(i6);
        this.R.setTag(i6);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a8
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a8
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.a8
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

    @Override // app.dogo.com.dogo_android.h.a8
    public void V(TrickItem trickItem) {
        this.S = trickItem;
        this.U = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.S = trickItem;
            this.U = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a8
    protected void m() {
        int cmp;
        int i2;
        int name;
        int i;
        String str;
        int i4 = 0;
        this.U = i4;
        final TrickItem trickItem = this.S;
        cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.U = i4;
            trickItem = this.S;
            cmp = Long.compare(i3, i4);
        }
        try {
            if (trickItem != null) {
            } else {
            }
            name = trickItem.getName();
            i = imageUrl;
            i2 = str;
            i = name;
            if (cmp != 0) {
            }
            g.c(this.P, i2);
            g.c(this.Q, name);
            n.w(this.R, i);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.a8
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
