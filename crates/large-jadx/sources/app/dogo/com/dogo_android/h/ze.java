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
public class ze extends app.dogo.com.dogo_android.h.ye {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final FrameLayout V;
    private final app.dogo.com.dogo_android.h.ml W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(7);
        ze.Y = gVar;
        int i4 = 1;
        int[] iArr2 = new int[i4];
        final int i11 = 0;
        iArr2[i11] = 3;
        int[] iArr4 = new int[i4];
        iArr4[i11] = 2131558790;
        gVar.a(i11, /* result */, iArr2, iArr4);
        int[] iArr3 = new int[i4];
        iArr3[i11] = 4;
        int[] iArr = new int[i4];
        iArr[i11] = 2131558788;
        gVar.a(2, /* result */, iArr3, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        ze.Z = sparseIntArray;
        sparseIntArray.put(2131362115, 5);
        sparseIntArray.put(2131362246, 6);
    }

    public ze(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, ze.Y, ze.Z));
    }

    private ze(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (View)object3Arr3[5], (CardStackView)object3Arr3[1], (ConstraintLayout)object3Arr3[0], (View)object3Arr3[6], (ql)object3Arr3[3]);
        this.X = -1;
        int i7 = 0;
        this.P.setTag(i7);
        this.Q.setTag(i7);
        Object obj11 = object3Arr3[2];
        this.V = (FrameLayout)obj11;
        obj11.setTag(i7);
        obj11 = object3Arr3[4];
        this.W = (ml)obj11;
        L(obj11);
        L(this.S);
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

    @Override // app.dogo.com.dogo_android.h.ye
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

    @Override // app.dogo.com.dogo_android.h.ye
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((LiveData)object2, i3);
        }
        return X((ql)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ye
    public void M(q q) {
        super.M(q);
        this.S.M(q);
        this.W.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ye
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

    @Override // app.dogo.com.dogo_android.h.ye
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

    @Override // app.dogo.com.dogo_android.h.ye
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

    @Override // app.dogo.com.dogo_android.h.ye
    protected void m() {
        int cmp;
        v0 result;
        int cmp2;
        int i;
        int i2;
        long l = this.X;
        final int i4 = 0;
        this.X = i4;
        result = this.T;
        cmp2 = Long.compare(i7, i4);
        synchronized (this) {
            l = this.X;
            i4 = 0;
            this.X = i4;
            result = this.T;
            cmp2 = Long.compare(i7, i4);
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
            if (cmp2 != 0) {
            }
            d0.h(this.P, i, this.U, this.R, this.O);
        }
        if (Long.compare(i3, i4) != 0) {
            n.D0(this.V, i);
        }
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.ye
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
