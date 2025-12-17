package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* loaded from: classes.dex */
public class x4 extends app.dogo.com.dogo_android.h.w4 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x4.U = sparseIntArray;
        sparseIntArray.put(2131362585, 3);
        sparseIntArray.put(2131362626, 4);
    }

    public x4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, x4.T, x4.U));
    }

    private x4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (Guideline)object3Arr3[3], (ImageView)object3Arr3[4], (TextView)object3Arr3[1]);
        this.S = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.R = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.P.setTag(i6);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w4
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.w4
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

    @Override // app.dogo.com.dogo_android.h.w4
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

    @Override // app.dogo.com.dogo_android.h.w4
    protected void m() {
        String description;
        long l;
        int i2;
        int string;
        int i;
        Object[] arr;
        String str;
        int recap;
        int itemNumber;
        Integer valueOf;
        int i3;
        final Object obj = this;
        l = obj.S;
        final int i5 = 0;
        obj.S = i5;
        ProgramLesson programLesson = obj.Q;
        final int i6 = 3;
        int cmp2 = Long.compare(i7, i5);
        int i8 = 4;
        i = 0;
        synchronized (this) {
            obj = this;
            l = obj.S;
            i5 = 0;
            obj.S = i5;
            programLesson = obj.Q;
            i6 = 3;
            cmp2 = Long.compare(i7, i5);
            i8 = 4;
            i = 0;
        }
        if (programLesson != null) {
            recap = programLesson.isRecap();
            itemNumber = programLesson.getItemNumber();
        } else {
            try {
                itemNumber = recap;
                if (cmp2 != 0) {
                }
                if (recap != 0) {
                } else {
                }
                l |= i3;
                l |= i8;
                arr = new Object[1];
                arr[i] = Integer.valueOf(itemNumber);
                string = obj.P.getResources().getString(2131887585, arr);
                i = recap;
                string = 0;
            }
            if (Long.compare(i9, i5) != 0 && programLesson != null) {
                if (programLesson != null) {
                    description = programLesson.getDescription();
                } else {
                    description = 0;
                }
            } else {
            }
            int cmp = Long.compare(i4, i5);
            if (cmp != 0) {
                if (i != 0) {
                    description = obj.O.getResources().getString(2131887596);
                }
                str = description;
            } else {
                str = 0;
            }
            if (cmp != 0) {
                g.c(obj.O, str);
                g.c(obj.P, string);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.w4
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
