package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.b0;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;

/* loaded from: classes.dex */
public class vi extends app.dogo.com.dogo_android.h.ui implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final View.OnClickListener U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        vi.W = gVar;
        int i3 = 1;
        final int[] iArr = new int[i3];
        final int i6 = 0;
        iArr[i6] = 2;
        int[] iArr2 = new int[i3];
        iArr2[i6] = 2131558768;
        gVar.a(i3, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        vi.X = sparseIntArray;
        sparseIntArray.put(2131362318, 3);
    }

    public vi(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, vi.W, vi.X));
    }

    private vi(e e, View view2, Object[] object3Arr3) {
        int i2 = 1;
        super(e, view2, 1, (TextView)object3Arr3[3], (ConstraintLayout)object3Arr3[i2], (ShimmerFrameLayout)object3Arr3[0], (ak)object3Arr3[2]);
        this.V = -1;
        int obj12 = 0;
        this.P.setTag(obj12);
        this.Q.setTag(obj12);
        L(this.R);
        N(view2);
        b obj10 = new b(this, i2);
        this.U = obj10;
        A();
    }

    private boolean V(app.dogo.com.dogo_android.h.ak ak, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ui
    public void A() {
        this.V = 8;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.V = 8;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ui
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return V((ak)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            T((o)object2);
            obj2 = 1;
        } else {
            if (55 == i) {
                U((CouponTimer)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public void T(o o) {
        this.T = o;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = o;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public void U(CouponTimer couponTimer) {
        this.S = couponTimer;
        this.V = l |= i2;
        notifyPropertyChanged(55);
        super.I();
        return;
        synchronized (this) {
            this.S = couponTimer;
            this.V = l |= i2;
            notifyPropertyChanged(55);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public final void b(int i, View view2) {
        int obj2;
        final o obj1 = this.T;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.c();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ui
    protected void m() {
        int cmp;
        View.OnClickListener list;
        long l = this.V;
        final int i2 = 0;
        this.V = i2;
        synchronized (this) {
            l = this.V;
            i2 = 0;
            this.V = i2;
        }
        try {
            this.Q.setOnClickListener(this.U);
            if (Long.compare(i4, i2) != 0) {
            }
            SubscriptionBindingAdapters.setupTimerDashboard(this.Q, this.S, this.R);
            ViewDataBinding.o(this.R);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
