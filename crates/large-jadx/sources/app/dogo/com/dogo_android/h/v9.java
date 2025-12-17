package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.p.b.d;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class v9 extends app.dogo.com.dogo_android.h.u9 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final FrameLayout S;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v9.W = sparseIntArray;
        sparseIntArray.put(2131363421, 2);
        sparseIntArray.put(2131363532, 3);
        sparseIntArray.put(2131362105, 4);
        sparseIntArray.put(2131363530, 5);
        sparseIntArray.put(2131362526, 6);
    }

    public v9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, v9.V, v9.W));
    }

    private v9(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (FrameLayout)object3Arr3[4], (FrameLayout)object3Arr3[6], (TextView)object3Arr3[2], (ImageView)object3Arr3[5], (VideoView)object3Arr3[3]);
        this.U = -1;
        Object obj11 = object3Arr3[0];
        this.S = (FrameLayout)obj11;
        int i7 = 0;
        obj11.setTag(i7);
        obj11 = object3Arr3[1];
        this.T = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u9
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u9
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u9
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

    @Override // app.dogo.com.dogo_android.h.u9
    public void V(d d) {
        this.R = d;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = d;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u9
    protected void m() {
        int cmp;
        android.widget.VideoView view;
        int i;
        final int i3 = 0;
        this.U = i3;
        i = 0;
        final d dVar = this.R;
        cmp = Long.compare(i2, i3);
        synchronized (this) {
            i3 = 0;
            this.U = i3;
            i = 0;
            dVar = this.R;
            cmp = Long.compare(i2, i3);
        }
        try {
            if (dVar != null) {
            }
            i = dVar.h();
            if (cmp != 0) {
            }
            n.p0(this.T, this.Q, i);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.u9
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
