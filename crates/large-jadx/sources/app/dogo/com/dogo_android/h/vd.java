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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.j;
import app.dogo.com.dogo_android.repository.domain.Library;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class vd extends app.dogo.com.dogo_android.h.ud implements c.a {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final ConstraintLayout Z;
    private final SwipeRefreshLayout.j a0;
    private long b0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(12);
        vd.c0 = gVar;
        int i5 = 7;
        int[] iArr2 = new int[i5];
        iArr2 = new int[]{3, 4, 5, 6, 7, 8, 9};
        int[] iArr = new int[i5];
        iArr = new int[]{2131558784, 2131558782, 2131558787, 2131558781, 2131558785, 2131558780, 2131558786};
        gVar.a(2, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        vd.d0 = sparseIntArray;
        sparseIntArray.put(2131362875, 10);
        sparseIntArray.put(2131363433, 11);
    }

    public vd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, vd.c0, vd.d0));
    }

    private vd(e e, View view2, Object[] object3Arr3) {
        final Object obj26 = this;
        super(e, view2, 8, (wk)object3Arr3[8], (yk)object3Arr3[6], (ConstraintLayout)object3Arr3[2], (NestedScrollView)object3Arr3[10], (al)object3Arr3[4], (el)object3Arr3[3], (gl)object3Arr3[7], (il)object3Arr3[9], (SwipeRefreshLayout)object3Arr3[1], (MaterialToolbar)object3Arr3[11], (kl)object3Arr3[5]);
        obj26.b0 = -1;
        obj26.L(obj26.O);
        obj26.L(obj26.P);
        int i13 = 0;
        obj26.Q.setTag(i13);
        Object obj13 = object3Arr3[0];
        obj26.Z = (ConstraintLayout)obj13;
        obj13.setTag(i13);
        obj26.L(obj26.R);
        obj26.L(obj26.S);
        obj26.L(obj26.T);
        obj26.L(obj26.U);
        obj26.V.setTag(i13);
        obj26.L(obj26.W);
        obj26.N(view2);
        c cVar = new c(obj26, 1);
        obj26.a0 = cVar;
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.wk wk, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(app.dogo.com.dogo_android.h.yk yk, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(app.dogo.com.dogo_android.h.al al, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(app.dogo.com.dogo_android.h.el el, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(app.dogo.com.dogo_android.h.gl gl, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(app.dogo.com.dogo_android.h.il il, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean d0(app.dogo.com.dogo_android.h.kl kl, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean e0(LiveData<y<Library>> liveData, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public void A() {
        this.b0 = 1024;
        this.S.A();
        this.R.A();
        this.W.A();
        this.P.A();
        this.T.A();
        this.O.A();
        this.U.A();
        I();
        return;
        synchronized (this) {
            this.b0 = 1024;
            this.S.A();
            this.R.A();
            this.W.A();
            this.P.A();
            this.T.A();
            this.O.A();
            this.U.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ud
    protected boolean E(int i, Object object2, int i3) {
        switch (i) {
            case 0:
                return b0((gl)object2, i3);
            case 1:
                return X((wk)object2, i3);
            case 2:
                return c0((il)object2, i3);
            case 3:
                return e0((LiveData)object2, i3);
            case 4:
                return d0((kl)object2, i3);
            case 5:
                return Y((yk)object2, i3);
            case 6:
                return a0((el)object2, i3);
            case 7:
                return Z((al)object2, i3);
            default:
                return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public void M(q q) {
        super.M(q);
        this.S.M(q);
        this.R.M(q);
        this.W.M(q);
        this.P.M(q);
        this.T.M(q);
        this.O.M(q);
        this.U.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((g)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((j)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public void V(g g) {
        this.Y = g;
        this.b0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Y = g;
            this.b0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public void W(j j) {
        this.X = j;
        this.b0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.X = j;
            this.b0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public final void a(int i) {
        int i2;
        final j obj2 = this.X;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.t();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ud
    protected void m() {
        int cmp4;
        SwipeRefreshLayout.j jVar;
        j value;
        int cmp;
        int cmp2;
        int cmp3;
        int i2;
        int i;
        app.dogo.com.dogo_android.h.yk ykVar;
        app.dogo.com.dogo_android.h.gl glVar;
        app.dogo.com.dogo_android.h.wk wkVar;
        app.dogo.com.dogo_android.h.al alVar;
        app.dogo.com.dogo_android.h.il ilVar;
        long l = this.b0;
        final int i4 = 0;
        this.b0 = i4;
        final g gVar = this.Y;
        value = this.X;
        cmp3 = Long.compare(i11, i4);
        synchronized (this) {
            l = this.b0;
            i4 = 0;
            this.b0 = i4;
            gVar = this.Y;
            value = this.X;
            cmp3 = Long.compare(i11, i4);
        }
        try {
            if (value != null) {
            } else {
            }
            value = value.r();
            value = i2;
            Q(3, value);
            if (value != null) {
            }
            i2 = value;
            final int i12 = i2;
            if (cmp3 != 0) {
            }
            f.n(this.Q, i12, gVar, this.W, this.P, this.T, this.O, this.R, this.U);
        }
        if (Long.compare(i6, i4) != 0) {
            n.F0(this.Z, i12);
            n.y0(this.V, i12);
        }
        if (Long.compare(i8, i4) != 0) {
            this.U.T(gVar);
        }
        if (Long.compare(i3, i4) != 0) {
            this.V.setOnRefreshListener(this.a0);
        }
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.W);
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.T);
        ViewDataBinding.o(this.O);
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.S.y()) {
                }
                return i2;
                if (this.R.y()) {
                }
                return i2;
                if (this.W.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.T.y()) {
                }
                return i2;
            }
            return i2;
        }
    }
}
