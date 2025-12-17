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
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* loaded from: classes.dex */
public class f4 extends app.dogo.com.dogo_android.h.e4 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4.T = sparseIntArray;
        sparseIntArray.put(2131363421, 2);
    }

    public f4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, f4.S, f4.T));
    }

    private f4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.R = -1;
        Object obj8 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public void A() {
        this.R = 4;
        I();
        return;
        synchronized (this) {
            this.R = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (91 == i) {
            V((Boolean)object2);
            obj2 = 1;
        } else {
            if (94 == i) {
                W((ProgramExam)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public void V(Boolean boolean) {
        this.P = boolean;
        this.R = l |= i2;
        notifyPropertyChanged(91);
        super.I();
        return;
        synchronized (this) {
            this.P = boolean;
            this.R = l |= i2;
            notifyPropertyChanged(91);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e4
    public void W(ProgramExam programExam) {
    }

    @Override // app.dogo.com.dogo_android.h.e4
    protected void m() {
        long l;
        int cmp2;
        Object string;
        Resources resources;
        int i;
        int i2;
        int cmp;
        l = this.R;
        final int i4 = 0;
        this.R = i4;
        i = 0;
        final int i5 = 5;
        cmp = Long.compare(i6, i4);
        synchronized (this) {
            l = this.R;
            i4 = 0;
            this.R = i4;
            i = 0;
            i5 = 5;
            cmp = Long.compare(i6, i4);
        }
        try {
            boolean z = ViewDataBinding.K(this.P);
            if (cmp != 0) {
            }
            if (z) {
            } else {
            }
            cmp = 16;
            cmp = 8;
            l |= cmp;
            resources = this.O.getResources();
            i2 = 2131886484;
        }
        resources = this.O.getResources();
        i2 = 2131886655;
        i = string;
        if (Long.compare(i3, i4) != 0) {
            g.c(this.O, i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.e4
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
