package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.n.o.a;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class xl extends app.dogo.com.dogo_android.h.wl {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        xl.U = sparseIntArray;
        sparseIntArray.put(2131363207, 2);
        sparseIntArray.put(2131362301, 3);
    }

    public xl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, xl.T, xl.U));
    }

    private xl(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[3], (RecyclerView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.S = -1;
        Object obj9 = object3Arr3[0];
        this.R = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wl
    public void A() {
        this.S = 4;
        I();
        return;
        synchronized (this) {
            this.S = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wl
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.wl
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            W((SpecialProgramOverviewItem)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((o.a)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wl
    public void V(o.a o$a) {
        this.Q = a;
        this.S = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Q = a;
            this.S = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wl
    public void W(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.P = specialProgramOverviewItem;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.P = specialProgramOverviewItem;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wl
    protected void m() {
        int cmp;
        int reminders;
        final int i2 = 0;
        this.S = i2;
        final SpecialProgramOverviewItem specialProgramOverviewItem = this.P;
        reminders = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.S = i2;
            specialProgramOverviewItem = this.P;
            reminders = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (specialProgramOverviewItem != null) {
            }
            reminders = specialProgramOverviewItem.getReminders();
            if (cmp != 0) {
            }
            l.D0(this.O, reminders, this.Q);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.wl
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
