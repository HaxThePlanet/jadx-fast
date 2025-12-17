package app.dogo.com.dogo_android.h;

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
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.d0;
import app.dogo.com.dogo_android.g.n;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;

/* loaded from: classes.dex */
public class fk extends app.dogo.com.dogo_android.h.ek {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(7);
        fk.X = gVar;
        int i4 = 1;
        final int[] iArr2 = new int[i4];
        final int i9 = 0;
        iArr2[i9] = 4;
        int[] iArr = new int[i4];
        iArr[i9] = 2131558754;
        gVar.a(i9, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        fk.Y = sparseIntArray;
        sparseIntArray.put(2131363421, 5);
        sparseIntArray.put(2131363299, 6);
    }

    public fk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, fk.X, fk.Y));
    }

    private fk(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (ConstraintLayout)object3Arr3[0], (RecyclerView)object3Arr3[3], (AppCompatImageView)object3Arr3[6], (TextView)object3Arr3[2], (TextView)object3Arr3[5], (yi)object3Arr3[4]);
        this.W = -1;
        int i8 = 0;
        this.O.setTag(i8);
        Object obj12 = object3Arr3[1];
        this.V = (ConstraintLayout)obj12;
        obj12.setTag(i8);
        this.P.setTag(i8);
        this.Q.setTag(i8);
        L(this.S);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.yi yi, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public void A() {
        this.W = 8;
        this.S.A();
        I();
        return;
        synchronized (this) {
            this.W = 8;
            this.S.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ek
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((yi)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public void M(q q) {
        super.M(q);
        this.S.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            W((TrainingTimeMetrics)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((d0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public void V(d0 d0) {
        this.T = d0;
        this.W = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = d0;
            this.W = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public void W(TrainingTimeMetrics trainingTimeMetrics) {
        this.U = trainingTimeMetrics;
        this.W = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.U = trainingTimeMetrics;
            this.W = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ek
    protected void m() {
        int cmp2;
        long l;
        int currentStreak;
        int string;
        int cmp3;
        app.dogo.com.dogo_android.h.yi yiVar;
        int cmp;
        int i;
        int i2;
        int i3;
        final Object obj = this;
        l = obj.W;
        final int i5 = 0;
        obj.W = i5;
        TrainingTimeMetrics time = obj.U;
        final d0 d0Var = obj.T;
        string = 0;
        int i6 = 14;
        final int i9 = 10;
        i = 0;
        synchronized (this) {
            obj = this;
            l = obj.W;
            i5 = 0;
            obj.W = i5;
            time = obj.U;
            d0Var = obj.T;
            string = 0;
            i6 = 14;
            i9 = 10;
            i = 0;
        }
        cmp = Long.compare(i2, i5);
        if (cmp != 0) {
            if (time != null) {
                try {
                    currentStreak = time.getCurrentStreak();
                    currentStreak = i;
                    if (currentStreak > 0) {
                    } else {
                    }
                    i2 = 1;
                    i2 = i;
                    string = Integer.toString(currentStreak);
                }
                if (i2 != 0) {
                } else {
                    i = cmp;
                }
            } else {
            }
        }
        if (Long.compare(i7, i5) != 0) {
            n.m(obj.O, obj.S, obj.R, d0Var, time);
            n.k(obj.P, time, d0Var);
        }
        if (Long.compare(i4, i5) != 0) {
            obj.V.setVisibility(i);
            g.c(obj.Q, string);
        }
        ViewDataBinding.o(obj.S);
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.S.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
