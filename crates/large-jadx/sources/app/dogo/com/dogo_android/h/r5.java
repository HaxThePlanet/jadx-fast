package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class r5 extends app.dogo.com.dogo_android.h.q5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r5.U = sparseIntArray;
        sparseIntArray.put(2131363421, 2);
        sparseIntArray.put(2131363306, 3);
        sparseIntArray.put(2131362619, 4);
        sparseIntArray.put(2131362180, 5);
    }

    public r5(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, r5.T, r5.U));
    }

    private r5(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (View)object3Arr3[5], (RecyclerView)object3Arr3[1], (ImageView)object3Arr3[4], (TextView)object3Arr3[3], (TextView)object3Arr3[2]);
        this.S = -1;
        int i7 = 0;
        this.P.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.R = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q5
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q5
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.q5
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((ProgramLesson)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.q5
    public void V(ProgramLesson programLesson) {
        this.Q = programLesson;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = programLesson;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q5
    protected void m() {
        int cmp;
        int moduleExams;
        final int i2 = 0;
        this.S = i2;
        moduleExams = 0;
        final ProgramLesson programLesson = this.Q;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.S = i2;
            moduleExams = 0;
            programLesson = this.Q;
            cmp = Long.compare(i, i2);
        }
        try {
            if (programLesson != null) {
            }
            moduleExams = programLesson.getModuleExams();
            if (cmp != 0) {
            }
            l.S(this.P, moduleExams);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.q5
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
