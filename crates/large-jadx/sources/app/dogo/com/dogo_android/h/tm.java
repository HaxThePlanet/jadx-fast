package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class tm extends app.dogo.com.dogo_android.h.sm {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout Q;
    private final RecyclerView R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        tm.U = sparseIntArray;
        sparseIntArray.put(2131363207, 2);
    }

    public tm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, tm.T, tm.U));
    }

    private tm(e e, View view2, Object[] object3Arr3) {
        final int i3 = 0;
        super(e, view2, i3, (TextView)object3Arr3[2]);
        this.S = -1;
        Object obj5 = object3Arr3[i3];
        this.Q = (ConstraintLayout)obj5;
        int i2 = 0;
        obj5.setTag(i2);
        obj5 = object3Arr3[1];
        this.R = (RecyclerView)obj5;
        obj5.setTag(i2);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.sm
    public void A() {
        this.S = 4;
        I();
        return;
        synchronized (this) {
            this.S = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sm
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.sm
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            W((SpecialProgramOverviewItem)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((j)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.sm
    public void V(j j) {
        this.P = j;
        this.S = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.P = j;
            this.S = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sm
    public void W(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.O = specialProgramOverviewItem;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.O = specialProgramOverviewItem;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sm
    protected void m() {
        int cmp;
        int exercise;
        final int i2 = 0;
        this.S = i2;
        exercise = 0;
        final SpecialProgramOverviewItem specialProgramOverviewItem = this.O;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.S = i2;
            exercise = 0;
            specialProgramOverviewItem = this.O;
            cmp = Long.compare(i, i2);
        }
        try {
            if (specialProgramOverviewItem != null) {
            }
            exercise = specialProgramOverviewItem.getExercise();
            if (cmp != 0) {
            }
            l.E0(this.R, exercise, this.P);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sm
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
