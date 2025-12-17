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
import app.dogo.com.dogo_android.y.t.d;

/* loaded from: classes.dex */
public class lf extends app.dogo.com.dogo_android.h.kf {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        lf.W = sparseIntArray;
        sparseIntArray.put(2131363538, 3);
        sparseIntArray.put(2131361985, 4);
        sparseIntArray.put(2131363306, 5);
        sparseIntArray.put(2131362088, 6);
    }

    public lf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, lf.V, lf.W));
    }

    private lf(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[4], (Button)object3Arr3[6], (ImageView)object3Arr3[1], (TextView)object3Arr3[5], (TextView)object3Arr3[2], (KonfettiView)object3Arr3[3]);
        this.U = -1;
        Object obj12 = object3Arr3[0];
        this.T = (ConstraintLayout)obj12;
        final int obj14 = 0;
        obj12.setTag(obj14);
        this.P.setTag(obj14);
        this.Q.setTag(obj14);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kf
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kf
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.kf
    public boolean O(int i, Object object2) {
        int obj2;
        if (179 == i) {
            V((d)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.kf
    public void V(d d) {
        this.S = d;
        this.U = l |= i2;
        notifyPropertyChanged(179);
        super.I();
        return;
        synchronized (this) {
            this.S = d;
            this.U = l |= i2;
            notifyPropertyChanged(179);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kf
    protected void m() {
        int cmp;
        android.view.animation.Animation animation;
        int i2;
        int string;
        Object valueOf;
        int i;
        Resources resources;
        int i3;
        Object[] arr;
        long l = this.U;
        i2 = 0;
        this.U = i2;
        string = 0;
        valueOf = this.S;
        int cmp2 = Long.compare(i7, i2);
        synchronized (this) {
            l = this.U;
            i2 = 0;
            this.U = i2;
            string = 0;
            valueOf = this.S;
            cmp2 = Long.compare(i7, i2);
        }
        try {
            int i5 = 0;
            if (valueOf != null) {
            } else {
            }
            i = valueOf.h();
            i = i5;
            arr = new Object[1];
            arr[i5] = Integer.valueOf(i);
            string = this.Q.getResources().getString(2131887587, arr);
            if (Long.compare(i4, i2) != 0) {
            }
            n.o0(this.P, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
        }
        g.c(this.Q, string);
    }

    @Override // app.dogo.com.dogo_android.h.kf
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
