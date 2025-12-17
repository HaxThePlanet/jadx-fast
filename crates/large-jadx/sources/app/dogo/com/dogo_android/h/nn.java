package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* loaded from: classes.dex */
public class nn extends app.dogo.com.dogo_android.h.mn {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final FrameLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nn.T = sparseIntArray;
        sparseIntArray.put(2131362260, 2);
        sparseIntArray.put(2131362262, 3);
    }

    public nn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, nn.S, nn.T));
    }

    private nn(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[1], (ImageView)object3Arr3[2], (TextView)object3Arr3[3]);
        this.R = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.Q = (FrameLayout)obj9;
        obj9.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mn
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mn
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.mn
    public boolean O(int i, Object object2) {
        int obj2;
        if (57 == i) {
            T((Integer)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.mn
    public void T(Integer integer) {
        this.P = integer;
        this.R = l |= i2;
        notifyPropertyChanged(57);
        super.I();
        return;
        synchronized (this) {
            this.P = integer;
            this.R = l |= i2;
            notifyPropertyChanged(57);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mn
    protected void m() {
        int cmp;
        Resources resources;
        int intValue;
        Object[] arr;
        int quantityString;
        int i2;
        int i;
        intValue = 0;
        this.R = intValue;
        final Integer num = this.P;
        quantityString = 0;
        cmp = Long.compare(i3, intValue);
        synchronized (this) {
            intValue = 0;
            this.R = intValue;
            num = this.P;
            quantityString = 0;
            cmp = Long.compare(i3, intValue);
        }
        try {
            int i4 = 1;
            Object[] arr2 = new Object[i4];
            i2 = 0;
            arr2[i2] = num;
            i = 2131755018;
            this.O.getResources().getQuantityString(i, num.intValue(), arr2);
            arr = new Object[i4];
            arr[i2] = num;
            quantityString = this.O.getResources().getQuantityString(i, num.intValue(), arr);
            if (cmp != 0) {
            }
            g.c(this.O, quantityString);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mn
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
