package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.profile.invitation.g;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class h extends app.dogo.com.dogo_android.h.g {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final app.dogo.com.dogo_android.h.ml R;
    private long S;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(5);
        h.T = gVar;
        int i4 = 1;
        final int[] iArr = new int[i4];
        final int i8 = 0;
        iArr[i8] = 2;
        int[] iArr2 = new int[i4];
        iArr2[i8] = 2131558788;
        gVar.a(i4, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        h.U = sparseIntArray;
        sparseIntArray.put(2131362533, 3);
        sparseIntArray.put(2131363244, 4);
    }

    public h(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, h.T, h.U));
    }

    private h(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (ConstraintLayout)object3Arr3[0], (FrameLayout)object3Arr3[3], (FrameLayout)object3Arr3[1], (CoordinatorLayout)object3Arr3[4]);
        this.S = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj10 = object3Arr3[2];
        this.R = (ml)obj10;
        L(obj10);
        this.P.setTag(i6);
        N(view2);
        A();
    }

    private boolean T(LiveData<y<DogOwnerInvitation>> liveData, int i2) {
        if (i2 == 0) {
            this.S = obj3 |= i;
            return 1;
            synchronized (this) {
                this.S = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.g
    public void A() {
        this.S = 4;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.S = 4;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return T((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.g
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.g
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            U((g)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.g
    public void U(g g) {
        this.Q = g;
        this.S = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Q = g;
            this.S = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g
    protected void m() {
        int cmp;
        int value;
        int result;
        int i;
        result = 0;
        this.S = result;
        final g gVar = this.Q;
        cmp = Long.compare(i2, result);
        synchronized (this) {
            result = 0;
            this.S = result;
            gVar = this.Q;
            cmp = Long.compare(i2, result);
        }
        try {
            if (gVar != null) {
            } else {
            }
            result = gVar.getResult();
            result = value;
            Q(0, result);
            if (result != null) {
            }
            value = result.getValue();
            if (cmp != 0) {
            }
            n.x0(this.O, value);
            n.D0(this.P, value);
        }
        ViewDataBinding.o(this.R);
    }

    @Override // app.dogo.com.dogo_android.h.g
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
