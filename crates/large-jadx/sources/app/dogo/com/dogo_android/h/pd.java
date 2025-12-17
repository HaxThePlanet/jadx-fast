package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.inappmessaging.n;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class pd extends app.dogo.com.dogo_android.h.od {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        pd.Y = sparseIntArray;
        sparseIntArray.put(2131363278, 4);
        sparseIntArray.put(2131362389, 5);
        sparseIntArray.put(2131362644, 6);
        sparseIntArray.put(2131362476, 7);
        sparseIntArray.put(2131362897, 8);
        sparseIntArray.put(2131363309, 9);
    }

    public pd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 10, pd.X, pd.Y));
    }

    private pd(e e, View view2, Object[] object3Arr3) {
        final Object obj22 = this;
        super(e, view2, 0, (TextView)object3Arr3[2], (TextView)object3Arr3[1], (Guideline)object3Arr3[5], (TextView)object3Arr3[7], (ImageView)object3Arr3[6], (Button)object3Arr3[8], (OneTenRadioGroup)object3Arr3[3], (Guideline)object3Arr3[4], (MaterialButton)object3Arr3[9]);
        obj22.W = -1;
        int i12 = 0;
        obj22.O.setTag(i12);
        obj22.P.setTag(i12);
        Object obj11 = object3Arr3[0];
        obj22.V = (ConstraintLayout)obj11;
        obj11.setTag(i12);
        obj22.S.setTag(i12);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.od
    public void A() {
        this.W = 2;
        I();
        return;
        synchronized (this) {
            this.W = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.od
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.od
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((n)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.od
    public void V(n n) {
        this.U = n;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.U = n;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.od
    protected void m() {
        int cmp;
        android.widget.ImageView view;
        int i;
        int i2;
        n nVar;
        int cmp2;
        int i3;
        String str;
        long l = this.W;
        i = 0;
        this.W = i;
        nVar = this.U;
        cmp2 = Long.compare(i7, i);
        i3 = 0;
        synchronized (this) {
            l = this.W;
            i = 0;
            this.W = i;
            nVar = this.U;
            cmp2 = Long.compare(i7, i);
            i3 = 0;
        }
        try {
            if (nVar != null) {
            } else {
            }
            nVar = nVar.h();
            nVar = i3;
            if (nVar != 0) {
            } else {
            }
            i3 = bodyText;
            i2 = str;
            i2 = i3;
        }
        g.c(this.O, i3);
        g.c(this.P, i2);
        if (Long.compare(i4, i) != 0) {
            n.c0(this.S, this.Q, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.od
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
