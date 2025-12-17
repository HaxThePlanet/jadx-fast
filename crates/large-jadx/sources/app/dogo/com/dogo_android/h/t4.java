package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
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
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* loaded from: classes.dex */
public class t4 extends app.dogo.com.dogo_android.h.s4 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t4.V = sparseIntArray;
        sparseIntArray.put(2131362585, 4);
        sparseIntArray.put(2131362626, 5);
    }

    public t4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, t4.U, t4.V));
    }

    private t4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (Guideline)object3Arr3[4], (ImageView)object3Arr3[3], (ImageView)object3Arr3[5], (TextView)object3Arr3[1]);
        this.T = -1;
        int i7 = 0;
        this.O.setTag(i7);
        this.P.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.S = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        this.Q.setTag(i7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s4
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s4
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

    @Override // app.dogo.com.dogo_android.h.s4
    public void V(ProgramLesson programLesson) {
        this.R = programLesson;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = programLesson;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s4
    protected void m() {
        int description;
        long l;
        int i6;
        int string;
        int i5;
        int valueOf;
        int resources;
        int i3;
        int i2;
        int i;
        int recap;
        int itemNumber;
        int new;
        int i4;
        final Object obj = this;
        l = obj.T;
        final int i8 = 0;
        obj.T = i8;
        ProgramLesson programLesson = obj.R;
        int i9 = 3;
        resources = Long.compare(i11, i8);
        final int i14 = 4;
        i = 0;
        synchronized (this) {
            obj = this;
            l = obj.T;
            i8 = 0;
            obj.T = i8;
            programLesson = obj.R;
            i9 = 3;
            resources = Long.compare(i11, i8);
            i14 = 4;
            i = 0;
        }
        if (programLesson != null) {
            recap = programLesson.isRecap();
            itemNumber = programLesson.getItemNumber();
            new = programLesson.isNew();
        } else {
            try {
                new = itemNumber;
                if (resources != 0) {
                }
                if (recap != 0) {
                } else {
                }
                l |= i4;
                l |= i14;
            }
            Object[] arr = new Object[1];
            arr[i] = Integer.valueOf(itemNumber);
            string = obj.Q.getResources().getString(2131887585, arr);
            if (new != 0) {
            } else {
                i = valueOf;
            }
            i5 = i;
            i = recap;
            if (Long.compare(i12, i8) != 0 && programLesson != null) {
                if (programLesson != null) {
                    description = programLesson.getDescription();
                } else {
                    description = 0;
                }
            } else {
            }
            int cmp = Long.compare(i7, i8);
            if (cmp != 0) {
                if (i != 0) {
                    description = obj.O.getResources().getString(2131887596);
                }
                i2 = description;
            } else {
                i2 = 0;
            }
            if (cmp != 0) {
                g.c(obj.O, i2);
                obj.P.setVisibility(i5);
                g.c(obj.Q, string);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.s4
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
