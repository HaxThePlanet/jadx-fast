package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class l7 extends app.dogo.com.dogo_android.h.k7 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final MaterialCardView Q;
    private final ConstraintLayout R;
    private final app.dogo.com.dogo_android.h.qm S;
    private long T;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        l7.U = gVar;
        int i3 = 1;
        final int[] iArr = new int[i3];
        final int i6 = 0;
        iArr[i6] = 2;
        int[] iArr2 = new int[i3];
        iArr2[i6] = 2131558804;
        gVar.a(i3, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        l7.V = sparseIntArray;
        sparseIntArray.put(2131363490, 3);
    }

    public l7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, l7.U, l7.V));
    }

    private l7(e e, View view2, Object[] object3Arr3) {
        final int i3 = 0;
        super(e, view2, i3, (View)object3Arr3[3]);
        this.T = -1;
        Object obj5 = object3Arr3[i3];
        this.Q = (MaterialCardView)obj5;
        int i2 = 0;
        obj5.setTag(i2);
        obj5 = object3Arr3[1];
        this.R = (ConstraintLayout)obj5;
        obj5.setTag(i2);
        obj5 = object3Arr3[2];
        this.S = (qm)obj5;
        L(obj5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.k7
    public void A() {
        this.T = 2;
        this.S.A();
        I();
        return;
        synchronized (this) {
            this.T = 2;
            this.S.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.k7
    public void M(q q) {
        super.M(q);
        this.S.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.k7
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

    @Override // app.dogo.com.dogo_android.h.k7
    public void V(TrickItem trickItem) {
        this.P = trickItem;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.P = trickItem;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k7
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.T = i2;
        synchronized (this) {
            i2 = 0;
            this.T = i2;
        }
        try {
            this.S.T(this.P);
            ViewDataBinding.o(this.S);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.k7
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.S.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
