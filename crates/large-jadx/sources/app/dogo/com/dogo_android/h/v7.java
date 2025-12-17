package app.dogo.com.dogo_android.h;

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
public class v7 extends app.dogo.com.dogo_android.h.u7 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v7.T = sparseIntArray;
        sparseIntArray.put(2131362633, 2);
        sparseIntArray.put(2131363364, 3);
    }

    public v7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, v7.S, v7.T));
    }

    private v7(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[2], (TextView)object3Arr3[1], (TextView)object3Arr3[3]);
        this.R = -1;
        Object obj9 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u7
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u7
    public boolean O(int i, Object object2) {
        int obj2;
        if (167 == i) {
            V((String)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.u7
    public void V(String string) {
        this.P = string;
        this.R = l |= i2;
        notifyPropertyChanged(167);
        super.I();
        return;
        synchronized (this) {
            this.P = string;
            this.R = l |= i2;
            notifyPropertyChanged(167);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u7
    protected void m() {
        int cmp;
        StringBuilder stringBuilder;
        int i;
        int string;
        i = 0;
        this.R = i;
        string = 0;
        cmp = Long.compare(i2, i);
        synchronized (this) {
            i = 0;
            this.R = i;
            string = 0;
            cmp = Long.compare(i2, i);
        }
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append('+');
            stringBuilder.append(this.P);
            string = stringBuilder.toString();
            if (cmp != 0) {
            }
            g.c(this.O, string);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.u7
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
