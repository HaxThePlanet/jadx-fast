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
public class j1 extends app.dogo.com.dogo_android.h.i1 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
    }

    public j1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, j1.U, j1.V));
    }

    private j1(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[3], (TextView)object3Arr3[2], (ImageView)object3Arr3[1]);
        this.T = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.S = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        this.Q.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i1
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.i1
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            T((TrickItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.i1
    public void T(TrickItem trickItem) {
        this.R = trickItem;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = trickItem;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i1
    protected void m() {
        int cmp;
        int i2;
        int name;
        int i;
        String str;
        int i4 = 0;
        this.T = i4;
        final TrickItem trickItem = this.R;
        cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.T = i4;
            trickItem = this.R;
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
            g.c(this.O, i2);
            g.c(this.P, name);
            n.w(this.Q, i);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.i1
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
