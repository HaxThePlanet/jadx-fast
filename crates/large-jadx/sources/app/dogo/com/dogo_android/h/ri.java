package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.s.b.c1.b;
import java.util.List;

/* loaded from: classes.dex */
public class ri extends app.dogo.com.dogo_android.h.qi {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        ri.U = gVar;
        int i3 = 2;
        final int[] iArr2 = new int[i3];
        iArr2 = new int[]{1, 2};
        int[] iArr = new int[i3];
        iArr = new int[]{2131558772, 2131558771};
        gVar.a(0, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        ri.V = sparseIntArray;
        sparseIntArray.put(2131363468, 3);
    }

    public ri(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, ri.U, ri.V));
    }

    private ri(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (ik)object3Arr3[1], (TextView)object3Arr3[3], (gk)object3Arr3[2]);
        this.T = -1;
        L(this.O);
        Object obj9 = object3Arr3[0];
        this.S = (ConstraintLayout)obj9;
        obj9.setTag(0);
        L(this.P);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.ik ik, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(app.dogo.com.dogo_android.h.gk gk, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public void A() {
        this.T = 16;
        this.O.A();
        this.P.A();
        I();
        return;
        synchronized (this) {
            this.T = 16;
            this.O.A();
            this.P.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qi
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((gk)object2, i3);
        }
        return X((ik)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public void M(q q) {
        super.M(q);
        this.O.M(q);
        this.P.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            W((WorkoutSession)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((e0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public void V(e0 e0) {
        this.R = e0;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = e0;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public void W(WorkoutSession workoutSession) {
        this.Q = workoutSession;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = workoutSession;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qi
    protected void m() {
        long l;
        int i5;
        int cmp;
        int trainingTricksList;
        int cmp2;
        int cmp3;
        int i;
        int i2;
        int i4;
        int i6;
        int cmp4;
        int i3;
        l = this.T;
        final int i8 = 0;
        this.T = i8;
        final WorkoutSession workoutSession = this.Q;
        trainingTricksList = 0;
        final e0 e0Var = this.R;
        final int i9 = 20;
        cmp3 = Long.compare(i10, i8);
        i = 0;
        synchronized (this) {
            l = this.T;
            i8 = 0;
            this.T = i8;
            workoutSession = this.Q;
            trainingTricksList = 0;
            e0Var = this.R;
            i9 = 20;
            cmp3 = Long.compare(i10, i8);
            i = 0;
        }
        try {
            if (workoutSession != null) {
            } else {
            }
            i2 = 1;
            i2 = i;
            if (i2 != 0) {
            } else {
            }
            i6 = 64;
            i6 = 32;
        }
        if (workoutSession != null) {
            trainingTricksList = workoutSession.getTrainingTricksList();
        }
        cmp3 = 8;
        i4 = i2 != 0 ? i : cmp3;
        if (trainingTricksList != null) {
            trainingTricksList = trainingTricksList.isEmpty();
        } else {
            trainingTricksList = i;
        }
        if (Long.compare(i11, i8) != 0) {
            if (trainingTricksList != null) {
                l |= i13;
                cmp4 = 1024;
            } else {
                l |= i12;
                cmp4 = 512;
            }
            i5 |= cmp4;
        }
        i3 = trainingTricksList != null ? cmp3 : i;
        if (trainingTricksList != null) {
        } else {
            i = cmp3;
        }
        if (Long.compare(i15, i8) != 0) {
            this.O.T(e0Var);
            this.P.T(e0Var);
        }
        if (Long.compare(i7, i8) != 0) {
            this.O.w().setVisibility(i);
            this.S.setVisibility(i4);
            this.P.U(workoutSession);
            this.P.w().setVisibility(i3);
        }
        ViewDataBinding.o(this.O);
        ViewDataBinding.o(this.P);
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.O.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
