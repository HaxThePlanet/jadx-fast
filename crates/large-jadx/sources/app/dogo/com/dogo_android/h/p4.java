package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* loaded from: classes.dex */
public class p4 extends app.dogo.com.dogo_android.h.o4 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p4.R = sparseIntArray;
        sparseIntArray.put(2131363421, 1);
        sparseIntArray.put(2131363306, 2);
    }

    public p4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, p4.Q, p4.R));
    }

    private p4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.P = -1;
        Object obj8 = object3Arr3[0];
        this.O = (ConstraintLayout)obj8;
        obj8.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o4
    public void A() {
        this.P = 2;
        I();
        return;
        synchronized (this) {
            this.P = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.o4
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((ProgramExam)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.o4
    public void V(ProgramExam programExam) {
    }

    @Override // app.dogo.com.dogo_android.h.o4
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.o4
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
