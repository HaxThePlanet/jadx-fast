package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.d0.n.a;
import app.dogo.com.dogo_android.y.d0.o;

/* loaded from: classes.dex */
public class dg extends app.dogo.com.dogo_android.h.cg {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final ConstraintLayout U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(6);
        dg.W = gVar;
        int i5 = 1;
        final int[] iArr = new int[i5];
        final int i10 = 0;
        iArr[i10] = 2;
        int[] iArr2 = new int[i5];
        iArr2[i10] = 2131558801;
        gVar.a(i5, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        dg.X = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
        sparseIntArray.put(2131363182, 4);
        sparseIntArray.put(2131363287, 5);
    }

    public dg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, dg.W, dg.X));
    }

    private dg(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 3, (NestedScrollView)object3Arr3[4], (Button)object3Arr3[5], (MaterialToolbar)object3Arr3[3], (mm)object3Arr3[2]);
        this.V = -1;
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        int i6 = 0;
        obj10.setTag(i6);
        obj10 = object3Arr3[1];
        this.U = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        L(this.Q);
        N(view2);
        A();
    }

    private boolean Y(app.dogo.com.dogo_android.h.mm mm, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(x<TrickItem> x, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(LiveData<y<TrickItem>> liveData, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void A() {
        this.V = 64;
        this.Q.A();
        I();
        return;
        synchronized (this) {
            this.V = 64;
            this.Q.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cg
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return Y((mm)object2, i3);
            }
            return Z((x)object2, i3);
        }
        return a0((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (137 == i) {
            V((n.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                X((o)object2);
            } else {
                if (141 == i) {
                    W((l)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void V(n.a n$a) {
        this.R = a;
        this.V = l |= i2;
        notifyPropertyChanged(137);
        super.I();
        return;
        synchronized (this) {
            this.R = a;
            this.V = l |= i2;
            notifyPropertyChanged(137);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void W(l l) {
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public void X(o o) {
        this.S = o;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = o;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cg
    protected void m() {
        int cmp3;
        long l;
        o value;
        int cmp;
        int cmp2;
        int cmp6;
        TrainingSession cmp5;
        java.util.List trainingTricksList;
        int i;
        int i2;
        int i3;
        Object value2;
        int result;
        int cmp4;
        final Object obj = this;
        l = obj.V;
        final int i5 = 0;
        obj.V = i5;
        value = obj.S;
        int i8 = 82;
        final int i12 = 80;
        int i13 = 81;
        synchronized (this) {
            obj = this;
            l = obj.V;
            i5 = 0;
            obj.V = i5;
            value = obj.S;
            i8 = 82;
            i12 = 80;
            i13 = 81;
        }
        if (Long.compare(i15, i5) != 0) {
            if (value != null) {
                try {
                    cmp5 = value.i();
                    cmp5 = 0;
                    if (cmp5 != null) {
                    } else {
                    }
                    trainingTricksList = cmp5.getTrainingTricksList();
                    trainingTricksList = 0;
                }
                value2 = 0;
                cmp4 = Long.compare(i17, i5);
                if (cmp4 != 0) {
                    if (value != null) {
                        value = value.h();
                    } else {
                        value = 0;
                    }
                    obj.Q(1, value);
                    if (value != null) {
                        result = value;
                    } else {
                        result = 0;
                    }
                    if (result != null) {
                    } else {
                        i = 0;
                    }
                    if (cmp4 != 0) {
                        result = i != 0 ? 256 : 128;
                        l |= result;
                    }
                    if (i != 0) {
                        i2 = 0;
                    } else {
                        i2 = value;
                    }
                } else {
                }
                if (Long.compare(i14, i5) != 0) {
                    n.F0(obj.T, value2);
                }
                if (Long.compare(i9, i5) != 0) {
                    obj.Q.w().setVisibility(i2);
                }
                if (Long.compare(i11, i5) != 0) {
                    obj.Q.T(obj.R);
                }
                if (Long.compare(i4, i5) != 0) {
                    obj.Q.U(trainingTricksList);
                }
                ViewDataBinding.o(obj.Q);
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.cg
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
