package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.c0.a;
import app.dogo.com.dogo_android.welcome_v2.d0;
import app.dogo.com.dogo_android.welcome_v2.v0;
import java.util.List;

/* loaded from: classes.dex */
public class za extends app.dogo.com.dogo_android.h.ya {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final FrameLayout V;
    private final app.dogo.com.dogo_android.h.ml W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(11);
        za.Y = gVar;
        int i8 = 1;
        int[] iArr2 = new int[i8];
        final int i19 = 0;
        iArr2[i19] = 3;
        int[] iArr4 = new int[i8];
        iArr4[i19] = 2131558790;
        gVar.a(i19, /* result */, iArr2, iArr4);
        int[] iArr3 = new int[i8];
        iArr3[i19] = 4;
        int[] iArr = new int[i8];
        iArr[i19] = 2131558788;
        gVar.a(2, /* result */, iArr3, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        za.Z = sparseIntArray;
        sparseIntArray.put(2131362712, 5);
        sparseIntArray.put(2131362713, 6);
        sparseIntArray.put(2131363157, 7);
        sparseIntArray.put(2131363158, 8);
        sparseIntArray.put(2131362115, 9);
        sparseIntArray.put(2131362246, 10);
    }

    public za(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, za.Y, za.Z));
    }

    private za(e e, View view2, Object[] object3Arr3) {
        final Object obj23 = this;
        super(e, view2, 2, (View)object3Arr3[9], (CardStackView)object3Arr3[1], (ConstraintLayout)object3Arr3[0], (View)object3Arr3[10], (ImageView)object3Arr3[5], (ImageView)object3Arr3[6], (ImageView)object3Arr3[7], (ImageView)object3Arr3[8], (ql)object3Arr3[3]);
        obj23.X = -1;
        int i13 = 0;
        obj23.P.setTag(i13);
        obj23.Q.setTag(i13);
        Object obj11 = object3Arr3[2];
        obj23.V = (FrameLayout)obj11;
        obj11.setTag(i13);
        Object obj12 = object3Arr3[4];
        obj23.W = (ml)obj12;
        L(obj12);
        L(obj23.S);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.ql ql, int i2) {
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

    private boolean Y(LiveData<y<List<SurveyQuestion>>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ya
    public void A() {
        this.X = 16;
        this.S.A();
        this.W.A();
        I();
        return;
        synchronized (this) {
            this.X = 16;
            this.S.A();
            this.W.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ya
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((LiveData)object2, i3);
        }
        return X((ql)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public void M(q q) {
        super.M(q);
        this.S.M(q);
        this.W.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (8 == i) {
            V((c0.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((v0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public void V(c0.a c0$a) {
        this.U = a;
        this.X = l |= i2;
        notifyPropertyChanged(8);
        super.I();
        return;
        synchronized (this) {
            this.U = a;
            this.X = l |= i2;
            notifyPropertyChanged(8);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public void W(v0 v0) {
        this.T = v0;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = v0;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ya
    protected void m() {
        int cmp2;
        Integer valueOf;
        int cmp3;
        v0 result;
        int cmp;
        int i;
        int i2;
        long l = this.X;
        final int i5 = 0;
        this.X = i5;
        result = this.T;
        cmp = Long.compare(i10, i5);
        synchronized (this) {
            l = this.X;
            i5 = 0;
            this.X = i5;
            result = this.T;
            cmp = Long.compare(i10, i5);
        }
        try {
            if (result != null) {
            } else {
            }
            result = result.getResult();
            result = i;
            Q(1, result);
            if (result != null) {
            }
            i = result;
            if (cmp != 0) {
            }
            d0.h(this.P, i, this.U, this.R, this.O);
        }
        if (Long.compare(i7, i5) != 0) {
            n.D0(this.V, i);
        }
        if (Long.compare(i3, i5) != 0) {
            this.S.U(4);
        }
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.ya
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.S.y()) {
                }
                return i2;
                if (this.W.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
