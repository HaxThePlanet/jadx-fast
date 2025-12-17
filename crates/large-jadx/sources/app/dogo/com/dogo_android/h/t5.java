package app.dogo.com.dogo_android.h;

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
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class t5 extends app.dogo.com.dogo_android.h.s5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t5.U = sparseIntArray;
        sparseIntArray.put(2131362749, 3);
    }

    public t5(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, t5.T, t5.U));
    }

    private t5(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[3], (ImageView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.S = -1;
        Object obj9 = object3Arr3[0];
        this.R = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        this.P.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s5
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s5
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s5
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

    @Override // app.dogo.com.dogo_android.h.s5
    public void V(ProgramExam programExam) {
        this.Q = programExam;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = programExam;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s5
    protected void m() {
        int cmp;
        int i;
        int i2;
        String str;
        int i4 = 0;
        this.S = i4;
        final ProgramExam programExam = this.Q;
        cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.S = i4;
            programExam = this.Q;
            cmp = Long.compare(i3, i4);
        }
        try {
            if (programExam != null) {
            } else {
            }
            i2 = name;
            i = str;
            i2 = i;
            if (cmp != 0) {
            }
            n.U(this.O, i);
            g.c(this.P, i2);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.s5
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
