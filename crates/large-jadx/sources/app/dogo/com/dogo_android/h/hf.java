package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class hf extends app.dogo.com.dogo_android.h.gf {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        hf.V = sparseIntArray;
        sparseIntArray.put(2131362690, 2);
        sparseIntArray.put(2131361985, 3);
        sparseIntArray.put(2131363421, 4);
        sparseIntArray.put(2131363147, 5);
        sparseIntArray.put(2131362700, 6);
    }

    public hf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, hf.U, hf.V));
    }

    private hf(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[3], (KonfettiView)object3Arr3[2], (TextView)object3Arr3[6], (Button)object3Arr3[5], (ImageView)object3Arr3[1], (TextView)object3Arr3[4]);
        this.T = -1;
        Object obj12 = object3Arr3[0];
        this.S = (ConstraintLayout)obj12;
        final int obj14 = 0;
        obj12.setTag(obj14);
        this.R.setTag(obj14);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gf
    public void A() {
        this.T = 1;
        I();
        return;
        synchronized (this) {
            this.T = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gf
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.gf
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.gf
    protected void m() {
        int cmp;
        android.view.animation.Animation animation;
        int i;
        i = 0;
        this.T = i;
        synchronized (this) {
            i = 0;
            this.T = i;
        }
        try {
            n.X(this.S, this.O);
            n.o0(this.R, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.gf
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
