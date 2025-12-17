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
public class l4 extends app.dogo.com.dogo_android.h.k4 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l4.V = sparseIntArray;
        sparseIntArray.put(2131362413, 4);
        sparseIntArray.put(2131362750, 5);
        sparseIntArray.put(2131363295, 6);
    }

    public l4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, l4.U, l4.V));
    }

    private l4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (TextView)object3Arr3[2], (TextView)object3Arr3[4], (ImageView)object3Arr3[5], (ImageView)object3Arr3[3], (ImageView)object3Arr3[6]);
        this.T = -1;
        int i8 = 0;
        this.O.setTag(i8);
        this.P.setTag(i8);
        Object obj12 = object3Arr3[0];
        this.S = (ConstraintLayout)obj12;
        obj12.setTag(i8);
        this.Q.setTag(i8);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.k4
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.k4
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

    @Override // app.dogo.com.dogo_android.h.k4
    public void V(ProgramExam programExam) {
        this.R = programExam;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = programExam;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k4
    protected void m() {
        long l;
        int cmp;
        int trickImageUrl;
        int cmp2;
        int i;
        int hasNewUpdates;
        int name;
        int i2;
        l = this.T;
        final int i4 = 0;
        this.T = i4;
        trickImageUrl = this.R;
        final int i5 = 3;
        cmp2 = Long.compare(i6, i4);
        i = 0;
        hasNewUpdates = 0;
        synchronized (this) {
            l = this.T;
            i4 = 0;
            this.T = i4;
            trickImageUrl = this.R;
            i5 = 3;
            cmp2 = Long.compare(i6, i4);
            i = 0;
            hasNewUpdates = 0;
        }
        try {
            if (trickImageUrl != null) {
            } else {
            }
            hasNewUpdates = trickImageUrl.getHasNewUpdates();
            name = trickImageUrl.getName();
            trickImageUrl = trickImageUrl.getTrickImageUrl();
            name = trickImageUrl;
            boolean z = ViewDataBinding.K(hasNewUpdates);
            if (z) {
            } else {
            }
            i2 = 8;
            i2 = 4;
        }
        if (z) {
        } else {
            i = cmp2;
        }
        hasNewUpdates = trickImageUrl;
        if (Long.compare(i3, i4) != 0) {
            m.o(this.O, hasNewUpdates);
            g.c(this.P, name);
            this.Q.setVisibility(i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k4
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
