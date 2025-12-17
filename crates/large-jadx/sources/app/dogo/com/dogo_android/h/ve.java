package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.n0;

/* loaded from: classes.dex */
public class ve extends app.dogo.com.dogo_android.h.ue implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final View.OnClickListener T;
    private long U;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(5);
        ve.V = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i7 = 0;
        iArr2[i7] = 3;
        int[] iArr = new int[i3];
        iArr[i7] = 2131558790;
        gVar.a(i7, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        ve.W = sparseIntArray;
        sparseIntArray.put(2131361928, 4);
    }

    public ve(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, ve.V, ve.W));
    }

    private ve(e e, View view2, Object[] object3Arr3) {
        int i5 = 1;
        super(e, view2, 2, (AnimatedTextView)object3Arr3[4], (ConstraintLayout)object3Arr3[0], (Button)object3Arr3[2], (ql)object3Arr3[3], (ImageView)object3Arr3[i5]);
        this.U = -1;
        int obj13 = 0;
        this.O.setTag(obj13);
        this.P.setTag(obj13);
        L(this.Q);
        this.R.setTag(obj13);
        N(view2);
        b obj11 = new b(this, i5);
        this.T = obj11;
        A();
    }

    private boolean W(app.dogo.com.dogo_android.h.ql ql, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(LiveData<y<RecommendedOrderedPrograms>> liveData, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public void A() {
        this.U = 8;
        this.Q.A();
        I();
        return;
        synchronized (this) {
            this.U = 8;
            this.Q.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ue
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((LiveData)object2, i3);
        }
        return W((ql)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((n0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public void V(n0 n0) {
        this.S = n0;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = n0;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ue
    public final void b(int i, View view2) {
        int obj2;
        final n0 obj1 = this.S;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.m();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ue
    protected void m() {
        int cmp;
        String str;
        int valueOf;
        n0 result;
        int i2;
        int i;
        long l = this.U;
        valueOf = 0;
        this.U = valueOf;
        result = this.S;
        int cmp2 = Long.compare(i7, valueOf);
        synchronized (this) {
            l = this.U;
            valueOf = 0;
            this.U = valueOf;
            result = this.S;
            cmp2 = Long.compare(i7, valueOf);
        }
        try {
            if (result != null) {
            } else {
            }
            result = result.getResult();
            result = i2;
            Q(1, result);
            if (result != null) {
            }
            i2 = result;
            if (cmp2 != 0) {
            }
            n.F0(this.O, i2);
            n.C0(this.P, i2);
        }
        if (Long.compare(i3, valueOf) != 0) {
            this.P.setOnClickListener(this.T);
            int i4 = 4;
            this.Q.T(Integer.valueOf(i4));
            this.Q.U(Integer.valueOf(i4));
            n.B0(this.R, "walking_dog");
        }
        ViewDataBinding.o(this.Q);
    }

    @Override // app.dogo.com.dogo_android.h.ue
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
