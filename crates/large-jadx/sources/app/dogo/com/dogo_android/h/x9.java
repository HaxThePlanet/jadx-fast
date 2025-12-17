package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.y.q.e;

/* loaded from: classes.dex */
public class x9 extends app.dogo.com.dogo_android.h.w9 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x9.U = sparseIntArray;
        sparseIntArray.put(2131362105, 1);
        sparseIntArray.put(2131362857, 2);
        sparseIntArray.put(2131362747, 3);
    }

    public x9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, x9.T, x9.U));
    }

    private x9(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (ImageButton)object3Arr3[1], (ContentLoadingProgressBar)object3Arr3[3], (VideoView)object3Arr3[2]);
        this.S = -1;
        Object obj9 = object3Arr3[0];
        this.R = (ConstraintLayout)obj9;
        obj9.setTag(0);
        N(view2);
        A();
    }

    private boolean X(e e, int i2) {
        if (i2 == 0) {
            this.S = obj3 |= i;
            return 1;
            synchronized (this) {
                this.S = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public void A() {
        this.S = 4;
        I();
        return;
        synchronized (this) {
            this.S = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w9
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((e)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((e)object2);
            obj2 = 1;
        } else {
            if (116 == i) {
                V((a0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public void V(a0 a0) {
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public void W(e e) {
    }

    @Override // app.dogo.com.dogo_android.h.w9
    protected void m() {
        this.S = 0;
        return;
        synchronized (this) {
            this.S = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.w9
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
