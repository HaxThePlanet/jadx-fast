package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
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

/* loaded from: classes.dex */
public class pn extends app.dogo.com.dogo_android.h.on {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        pn.V = sparseIntArray;
        sparseIntArray.put(2131362261, 3);
        sparseIntArray.put(2131362260, 4);
        sparseIntArray.put(2131362262, 5);
        sparseIntArray.put(2131362322, 6);
        sparseIntArray.put(2131362756, 7);
        sparseIntArray.put(2131362755, 8);
    }

    public pn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, pn.U, pn.V));
    }

    private pn(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        super(e, view2, 0, (TextView)object3Arr3[1], (ImageView)object3Arr3[4], (ConstraintLayout)object3Arr3[3], (TextView)object3Arr3[5], (View)object3Arr3[6], (TextView)object3Arr3[2], (ImageView)object3Arr3[8], (ConstraintLayout)object3Arr3[7]);
        obj20.T = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        obj20.P.setTag(i11);
        Object obj10 = object3Arr3[0];
        obj20.S = (ConstraintLayout)obj10;
        obj10.setTag(i11);
        View view4 = view2;
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.on
    public void A() {
        this.T = 4;
        I();
        return;
        synchronized (this) {
            this.T = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.on
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.on
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (57 == i) {
            T((Integer)object2);
            obj2 = 1;
        } else {
            if (105 == i) {
                U((Integer)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.on
    public void T(Integer integer) {
        this.Q = integer;
        this.T = l |= i2;
        notifyPropertyChanged(57);
        super.I();
        return;
        synchronized (this) {
            this.Q = integer;
            this.T = l |= i2;
            notifyPropertyChanged(57);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.on
    public void U(Integer integer) {
        this.R = integer;
        this.T = l |= i2;
        notifyPropertyChanged(105);
        super.I();
        return;
        synchronized (this) {
            this.R = integer;
            this.T = l |= i2;
            notifyPropertyChanged(105);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.on
    protected void m() {
        int cmp;
        Resources resources;
        int intValue;
        Object[] arr;
        int quantityString2;
        int quantityString;
        Resources resources2;
        int intValue2;
        Object[] arr2;
        long l = this.T;
        intValue = 0;
        this.T = intValue;
        Integer num = this.Q;
        final Integer num2 = this.R;
        int cmp2 = Long.compare(i3, intValue);
        final int i4 = 0;
        final int i5 = 1;
        final int i6 = 2131755018;
        synchronized (this) {
            l = this.T;
            intValue = 0;
            this.T = intValue;
            num = this.Q;
            num2 = this.R;
            cmp2 = Long.compare(i3, intValue);
            i4 = 0;
            i5 = 1;
            i6 = 2131755018;
        }
        try {
            Object[] arr4 = new Object[i5];
            arr4[i4] = num;
            this.O.getResources().getQuantityString(i6, num.intValue(), arr4);
            arr2 = new Object[i5];
            arr2[i4] = num;
            quantityString2 = this.O.getResources().getQuantityString(i6, num.intValue(), arr2);
            quantityString2 = quantityString;
            cmp = Long.compare(i, intValue);
            if (cmp != 0) {
            }
            Object[] arr3 = new Object[i5];
            arr3[i4] = num2;
            this.P.getResources().getQuantityString(i6, num2.intValue(), arr3);
            arr = new Object[i5];
            arr[i4] = num2;
            quantityString = this.P.getResources().getQuantityString(i6, num2.intValue(), arr);
            if (cmp2 != 0) {
            }
            g.c(this.O, quantityString2);
        }
        g.c(this.P, quantityString);
    }

    @Override // app.dogo.com.dogo_android.h.on
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
