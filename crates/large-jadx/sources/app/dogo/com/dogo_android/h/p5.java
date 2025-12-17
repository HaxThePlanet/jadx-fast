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
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class p5 extends app.dogo.com.dogo_android.h.o5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p5.U = sparseIntArray;
        sparseIntArray.put(2131363485, 3);
        sparseIntArray.put(2131363294, 4);
    }

    public p5(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, p5.T, p5.U));
    }

    private p5(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[4], (ImageView)object3Arr3[1], (ConstraintLayout)object3Arr3[3], (TextView)object3Arr3[2]);
        this.S = -1;
        Object obj10 = object3Arr3[0];
        this.R = (ConstraintLayout)obj10;
        final int obj12 = 0;
        obj10.setTag(obj12);
        this.O.setTag(obj12);
        this.P.setTag(obj12);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o5
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o5
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.o5
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

    @Override // app.dogo.com.dogo_android.h.o5
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

    @Override // app.dogo.com.dogo_android.h.o5
    protected void m() {
        int cmp;
        int i2;
        int i;
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
            i = name;
            i2 = str;
            i = i2;
            if (cmp != 0) {
            }
            m.p(this.O, i2);
            g.c(this.P, i);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.o5
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
