package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class rl extends app.dogo.com.dogo_android.h.ql {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final FrameLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        rl.V = sparseIntArray;
        sparseIntArray.put(2131361976, 3);
    }

    public rl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, rl.U, rl.V));
    }

    private rl(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[2], (AppCompatImageView)object3Arr3[3], (ConstraintLayout)object3Arr3[1]);
        this.T = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.S = (FrameLayout)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public void A() {
        this.T = 4;
        I();
        return;
        synchronized (this) {
            this.T = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ql
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (180 == i) {
            T((Integer)object2);
            obj2 = 1;
        } else {
            if (181 == i) {
                U((Integer)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public void T(Integer integer) {
        this.R = integer;
        this.T = l |= i2;
        notifyPropertyChanged(180);
        super.I();
        return;
        synchronized (this) {
            this.R = integer;
            this.T = l |= i2;
            notifyPropertyChanged(180);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public void U(Integer integer) {
        this.Q = integer;
        this.T = l |= i2;
        notifyPropertyChanged(181);
        super.I();
        return;
        synchronized (this) {
            this.Q = integer;
            this.T = l |= i2;
            notifyPropertyChanged(181);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ql
    protected void m() {
        Integer intValue;
        int cmp;
        long l;
        int i6;
        int intValue2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i;
        final Object obj = this;
        l = obj.T;
        final int i7 = 0;
        obj.T = i7;
        intValue = obj.R;
        Integer num = obj.Q;
        int i8 = 5;
        int cmp3 = Long.compare(i11, i7);
        i3 = 0;
        synchronized (this) {
            obj = this;
            l = obj.T;
            i7 = 0;
            obj.T = i7;
            intValue = obj.R;
            num = obj.Q;
            i8 = 5;
            cmp3 = Long.compare(i11, i7);
            i3 = 0;
        }
        if (intValue == null) {
            i4 = i2;
        } else {
            try {
                i4 = i3;
                if (cmp3 != 0) {
                }
                if (i4 != 0) {
                } else {
                }
                i5 = 64;
                i5 = 32;
                l |= i5;
                i4 = i3;
            }
            int i12 = 6;
            int cmp4 = Long.compare(i, i7);
            if (cmp4 != 0) {
                if (num == null) {
                } else {
                    i2 = i3;
                }
                if (cmp4 != 0) {
                    i = i2 != 0 ? 16 : 8;
                    l |= i;
                }
            } else {
                i2 = i3;
            }
            int cmp5 = Long.compare(i13, i7);
            if (cmp5 != 0) {
                if (i2 != 0) {
                    intValue2 = i3;
                } else {
                    intValue2 = num.intValue();
                }
            } else {
            }
            int cmp2 = Long.compare(i9, i7);
            if (cmp2 != 0) {
                if (i4 != 0) {
                } else {
                    i3 = intValue;
                }
            }
            if (cmp2 != 0) {
                obj.O.setVisibility(i3);
            }
            if (Long.compare(i6, i7) != 0 && ViewDataBinding.t() >= 21) {
                if (ViewDataBinding.t() >= 21) {
                    obj.S.setStateListAnimator(0);
                }
            }
            if (cmp5 != 0) {
                obj.P.setVisibility(intValue2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ql
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
