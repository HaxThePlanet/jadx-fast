package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
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
import app.dogo.com.dogo_android.util.f0.n;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class j9 extends app.dogo.com.dogo_android.h.i9 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j9.W = sparseIntArray;
        sparseIntArray.put(2131363421, 3);
    }

    public j9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, j9.V, j9.W));
    }

    private j9(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (TextView)object3Arr3[2], (TextView)object3Arr3[3]);
        this.U = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public void A() {
        this.U = 8;
        I();
        return;
        synchronized (this) {
            this.U = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i9
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (89 == i) {
            X((String)object2);
            obj2 = 1;
        } else {
            if (14 == i) {
                V((String)object2);
            } else {
                if (65 == i) {
                    W((String)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public void V(String string) {
        this.S = string;
        this.U = l |= i2;
        notifyPropertyChanged(14);
        super.I();
        return;
        synchronized (this) {
            this.S = string;
            this.U = l |= i2;
            notifyPropertyChanged(14);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public void W(String string) {
        this.Q = string;
        this.U = l |= i2;
        notifyPropertyChanged(65);
        super.I();
        return;
        synchronized (this) {
            this.Q = string;
            this.U = l |= i2;
            notifyPropertyChanged(65);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i9
    public void X(String string) {
        this.R = string;
        this.U = l |= i2;
        notifyPropertyChanged(89);
        super.I();
        return;
        synchronized (this) {
            this.R = string;
            this.U = l |= i2;
            notifyPropertyChanged(89);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i9
    protected void m() {
        int cmp;
        android.graphics.drawable.Drawable drawable;
        int i2;
        int string;
        String str;
        int i3;
        Object[] arr;
        int i;
        long l = this.U;
        i2 = 0;
        this.U = i2;
        string = 0;
        int cmp2 = Long.compare(i6, i2);
        synchronized (this) {
            l = this.U;
            i2 = 0;
            this.U = i2;
            string = 0;
            cmp2 = Long.compare(i6, i2);
        }
        try {
            arr = new Object[2];
            string = this.P.getResources().getString(2131886789, this.Q, this.R);
            if (Long.compare(i4, i2) != 0) {
            }
            cmp = this.O;
            n.m0(cmp, this.S, a.d(cmp.getContext(), 2131231085));
            if (cmp2 != 0) {
            }
            g.c(this.P, string);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.i9
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
