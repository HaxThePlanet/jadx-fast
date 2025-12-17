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
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.n;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.DashboardProgram;
import app.dogo.com.dogo_android.s.b.c1.b;

/* loaded from: classes.dex */
public class ni extends app.dogo.com.dogo_android.h.mi {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z = null;
    private final ConstraintLayout W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(7);
        ni.Y = gVar;
        int i3 = 5;
        int[] iArr2 = new int[i3];
        iArr2 = new int[]{2, 3, 4, 5, 6};
        int[] iArr = new int[i3];
        iArr = new int[]{2131558767, 2131558760, 2131558761, 2131558751, 2131558758};
        gVar.a(0, /* result */, iArr2, iArr);
        int i = 0;
    }

    public ni(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, ni.Y, ni.Z));
    }

    private ni(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 5, (gj)object3Arr3[6], (kj)object3Arr3[3], (mj)object3Arr3[4], (si)object3Arr3[5], (yj)object3Arr3[2], (TextView)object3Arr3[1]);
        this.X = -1;
        Object obj12 = object3Arr3[0];
        this.W = (ConstraintLayout)obj12;
        final int obj14 = 0;
        obj12.setTag(obj14);
        L(this.O);
        L(this.P);
        L(this.Q);
        L(this.R);
        L(this.S);
        this.T.setTag(obj14);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.gj gj, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(app.dogo.com.dogo_android.h.kj kj, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(app.dogo.com.dogo_android.h.mj mj, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(app.dogo.com.dogo_android.h.si si, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(app.dogo.com.dogo_android.h.yj yj, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public void A() {
        this.X = 128;
        this.S.A();
        this.P.A();
        this.Q.A();
        this.R.A();
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.X = 128;
            this.S.A();
            this.P.A();
            this.Q.A();
            this.R.A();
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mi
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return 0;
                        }
                        return X((gj)object2, i3);
                    }
                    return b0((yj)object2, i3);
                }
                return a0((si)object2, i3);
            }
            return Z((mj)object2, i3);
        }
        return Y((kj)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public void M(q q) {
        super.M(q);
        this.S.M(q);
        this.P.M(q);
        this.Q.M(q);
        this.R.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            W((DashboardProgram)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((o)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public void V(o o) {
        this.V = o;
        this.X = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.V = o;
            this.X = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public void W(DashboardProgram dashboardProgram) {
        this.U = dashboardProgram;
        this.X = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.U = dashboardProgram;
            this.X = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mi
    protected void m() {
        int cmp;
        TextView view;
        int i2;
        int i3;
        int i;
        app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary;
        long l = this.X;
        final int i5 = 0;
        this.X = i5;
        final DashboardProgram dashboardProgram = this.U;
        final o oVar = this.V;
        int cmp2 = Long.compare(i7, i5);
        synchronized (this) {
            l = this.X;
            i5 = 0;
            this.X = i5;
            dashboardProgram = this.U;
            oVar = this.V;
            cmp2 = Long.compare(i7, i5);
        }
        try {
            if (dashboardProgram != null) {
            } else {
            }
            i3 = lessonItem;
            i2 = programDescriptionItem;
            i = programCompletionSummary;
            i = i3;
            if (cmp2 != 0) {
            }
            this.O.U(i2);
            this.P.U(i2);
            this.Q.U(i2);
            this.R.U(i3);
            this.R.V(i);
            n.g(this.T, dashboardProgram);
            if (Long.compare(i4, i5) != 0) {
            }
            this.O.T(oVar);
            this.P.T(oVar);
            this.Q.T(oVar);
            this.R.T(oVar);
            this.S.T(oVar);
        }
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.S.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                if (this.R.y()) {
                }
                return i2;
                if (this.O.y()) {
                }
                return i2;
                return 0;
            }
        }
    }
}
