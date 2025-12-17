package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.g.n;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.r;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.repository.domain.Dashboard;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.k0.e;
import app.dogo.com.dogo_android.view.dailytraining.l;

/* loaded from: classes.dex */
public class va extends app.dogo.com.dogo_android.h.ua implements c.a {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0 = null;
    private final ConstraintLayout Z;
    private final ConstraintLayout a0;
    private final SwipeRefreshLayout.j b0;
    private long c0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(9);
        va.d0 = gVar;
        int i3 = 1;
        int[] iArr3 = new int[i3];
        final int i8 = 0;
        iArr3[i8] = 6;
        int[] iArr = new int[i3];
        iArr[i8] = 2131558744;
        gVar.a(i8, /* result */, iArr3, iArr);
        int i4 = 2;
        int[] iArr4 = new int[i4];
        iArr4 = new int[]{7, 8};
        int[] iArr2 = new int[i4];
        iArr2 = new int[]{2131558752, 2131558762};
        gVar.a(3, /* result */, iArr4, iArr2);
        int i = 0;
    }

    public va(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, va.d0, va.e0));
    }

    private va(e e, View view2, Object[] object3Arr3) {
        int i6 = 1;
        super(e, view2, 6, (ei)object3Arr3[6], (ConstraintLayout)object3Arr3[3], (NestedScrollView)object3Arr3[2], (LinearLayout)object3Arr3[4], (oj)object3Arr3[8], (SwipeRefreshLayout)object3Arr3[i6], (ui)object3Arr3[7]);
        this.c0 = -1;
        L(this.O);
        int i9 = 0;
        this.P.setTag(i9);
        Object obj13 = object3Arr3[0];
        this.Z = (ConstraintLayout)obj13;
        obj13.setTag(i9);
        obj13 = object3Arr3[5];
        this.a0 = (ConstraintLayout)obj13;
        obj13.setTag(i9);
        this.Q.setTag(i9);
        this.R.setTag(i9);
        L(this.S);
        this.T.setTag(i9);
        L(this.U);
        N(view2);
        obj13 = new c(this, i6);
        this.b0 = obj13;
        A();
    }

    private boolean Z(app.dogo.com.dogo_android.h.ei ei, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(app.dogo.com.dogo_android.h.oj oj, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(app.dogo.com.dogo_android.h.ui ui, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean d0(LiveData<y<Dashboard>> liveData, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean e0(x<CouponTimer> x, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void A() {
        this.c0 = 1024;
        this.O.A();
        this.U.A();
        this.S.A();
        I();
        return;
        synchronized (this) {
            this.c0 = 1024;
            this.O.A();
            this.U.A();
            this.S.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ua
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return 0;
                            }
                            return c0((x)object2, i3);
                        }
                        return b0((ui)object2, i3);
                    }
                    return Z((ei)object2, i3);
                }
                return d0((LiveData)object2, i3);
            }
            return a0((oj)object2, i3);
        }
        return e0((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void M(q q) {
        super.M(q);
        this.O.M(q);
        this.U.M(q);
        this.S.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (64 == i) {
            W((e)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((o)object2);
            } else {
                if (177 == i) {
                    Y((r)object2);
                } else {
                    if (141 == i) {
                        X((l)object2);
                    } else {
                        obj2 = 0;
                    }
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void V(o o) {
        this.W = o;
        this.c0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = o;
            this.c0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void W(e e) {
        this.X = e;
        this.c0 = l |= i2;
        notifyPropertyChanged(64);
        super.I();
        return;
        synchronized (this) {
            this.X = e;
            this.c0 = l |= i2;
            notifyPropertyChanged(64);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void X(l l) {
        this.Y = l;
        this.c0 = l2 |= i2;
        notifyPropertyChanged(141);
        super.I();
        return;
        synchronized (this) {
            this.Y = l;
            this.c0 = l2 |= i2;
            notifyPropertyChanged(141);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void Y(r r) {
        this.V = r;
        this.c0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.V = r;
            this.c0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public final void a(int i) {
        int i2;
        final r obj2 = this.V;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.N();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ua
    protected void m() {
        int cmp6;
        SwipeRefreshLayout.j jVar;
        int cmp7;
        int cmp2;
        int cmp3;
        boolean rVar;
        int cmp4;
        int discountVisible;
        Object lVar;
        int cmp;
        int cmp5;
        int value2;
        boolean z;
        int i3;
        int value;
        int i;
        int timer;
        int i2;
        int i4;
        long l = this.c0;
        final int i6 = 0;
        this.c0 = i6;
        final o oVar = this.W;
        rVar = this.V;
        cmp5 = Long.compare(i17, i6);
        int i18 = 0;
        i3 = 0;
        synchronized (this) {
            l = this.c0;
            i6 = 0;
            this.c0 = i6;
            oVar = this.W;
            rVar = this.V;
            cmp5 = Long.compare(i17, i6);
            i18 = 0;
            i3 = 0;
        }
        try {
            if (rVar != null) {
            } else {
            }
            timer = rVar.getTimer();
            i2 = rVar.F();
            discountVisible = rVar.getDiscountVisible();
            i2 = timer;
            Q(i18, timer);
            Q(2, i2);
            Q(5, discountVisible);
            if (timer != 0) {
            } else {
            }
            value2 = timer.getValue();
            value2 = i3;
        }
        value = i2.getValue();
        if (discountVisible != 0) {
            i3 = discountVisible;
        }
        z = rVar;
        i4 = value;
        if (Long.compare(i, i6) != 0) {
            this.O.U(this.Y);
        }
        if (Long.compare(i15, i6) != 0) {
            this.O.T(this.X);
        }
        if (Long.compare(i8, i6) != 0) {
            n.F0(this.Z, i4);
            n.H0(this.a0, i4);
            n.y0(this.T, i4);
        }
        if (cmp5 != 0) {
            SubscriptionBindingAdapters.setupTimerDashboard(this.Q, this.U, value2, oVar, z, i4, this.S, this.O);
        }
        if (Long.compare(i10, i6) != 0) {
            n.f(this.R, i4, oVar);
        }
        if (Long.compare(i12, i6) != 0) {
            this.S.T(oVar);
        }
        if (Long.compare(i5, i6) != 0) {
            this.T.setOnRefreshListener(this.b0);
        }
        ViewDataBinding.o(this.O);
        ViewDataBinding.o(this.U);
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.O.y()) {
                }
                return i2;
                if (this.U.y()) {
                }
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
