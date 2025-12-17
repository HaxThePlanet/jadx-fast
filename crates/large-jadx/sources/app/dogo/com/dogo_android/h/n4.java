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
public class n4 extends app.dogo.com.dogo_android.h.m4 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n4.V = sparseIntArray;
        sparseIntArray.put(2131362413, 4);
        sparseIntArray.put(2131363295, 5);
    }

    public n4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, n4.U, n4.V));
    }

    private n4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (TextView)object3Arr3[2], (TextView)object3Arr3[4], (ImageView)object3Arr3[3], (ImageView)object3Arr3[5]);
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

    @Override // app.dogo.com.dogo_android.h.m4
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.m4
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

    @Override // app.dogo.com.dogo_android.h.m4
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

    @Override // app.dogo.com.dogo_android.h.m4
    protected void m() {
        long l;
        int cmp2;
        int trickImageUrl;
        int cmp;
        int i2;
        int hasNewUpdates;
        int name;
        int i;
        l = this.T;
        final int i4 = 0;
        this.T = i4;
        trickImageUrl = this.R;
        final int i5 = 3;
        cmp = Long.compare(i6, i4);
        i2 = 0;
        hasNewUpdates = 0;
        synchronized (this) {
            l = this.T;
            i4 = 0;
            this.T = i4;
            trickImageUrl = this.R;
            i5 = 3;
            cmp = Long.compare(i6, i4);
            i2 = 0;
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
            i = 8;
            i = 4;
        }
        if (z) {
        } else {
            i2 = cmp;
        }
        hasNewUpdates = trickImageUrl;
        if (Long.compare(i3, i4) != 0) {
            m.o(this.O, hasNewUpdates);
            g.c(this.P, name);
            this.Q.setVisibility(i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m4
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
