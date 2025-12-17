package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.x.a;
import app.dogo.com.dogo_android.x.b.d;

/* loaded from: classes.dex */
public class xg extends app.dogo.com.dogo_android.h.wg {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        xg.Y = sparseIntArray;
        sparseIntArray.put(2131363567, 6);
        sparseIntArray.put(2131362563, 7);
        sparseIntArray.put(2131362579, 8);
    }

    public xg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, xg.X, xg.Y));
    }

    private xg(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        super(e, view2, 0, (ArcProgressBar)object3Arr3[3], (TextView)object3Arr3[7], (TextView)object3Arr3[5], (MaterialButton)object3Arr3[8], (ImageView)object3Arr3[2], (TextView)object3Arr3[1], (TextView)object3Arr3[4], (ImageView)object3Arr3[6]);
        obj20.W = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        obj20.P.setTag(i11);
        Object obj10 = object3Arr3[0];
        obj20.V = (ConstraintLayout)obj10;
        obj10.setTag(i11);
        obj20.R.setTag(i11);
        obj20.S.setTag(i11);
        obj20.T.setTag(i11);
        View view6 = view2;
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wg
    public void A() {
        this.W = 2;
        I();
        return;
        synchronized (this) {
            this.W = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wg
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.wg
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((d)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wg
    public void V(d d) {
        this.U = d;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.U = d;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wg
    protected void m() {
        int cmp;
        android.view.animation.Animation animation;
        int i9;
        int i4;
        int i5;
        int cmp2;
        int i2;
        int i3;
        int i7;
        int i8;
        int i;
        int i6;
        Resources resources;
        int i10;
        Object[] arr;
        long l = this.W;
        i9 = 0;
        this.W = i9;
        d dVar = this.U;
        cmp2 = Long.compare(i14, i9);
        i2 = 0;
        i3 = 0;
        synchronized (this) {
            l = this.W;
            i9 = 0;
            this.W = i9;
            dVar = this.U;
            cmp2 = Long.compare(i14, i9);
            i2 = 0;
            i3 = 0;
        }
        try {
            if (dVar != null) {
            } else {
            }
            i7 = dVar.k();
            i = dVar.m();
            i6 = dVar.o();
            i5 = dVar.l();
            i = i9;
            i6 = i5;
            i7 = i2;
            arr = new Object[1];
            arr[i2] = Long.valueOf(i);
            i8 = i5;
            i4 = string;
            i2 = i7;
            i3 = i6;
            i8 = i4;
            if (cmp2 != 0) {
            }
            a.a(this.O, i3);
            g.c(this.P, i4);
            this.S.setText(i2);
            g.c(this.T, i8);
        }
        if (Long.compare(i11, i9) != 0) {
            n.o0(this.R, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
        }
    }

    @Override // app.dogo.com.dogo_android.h.wg
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
