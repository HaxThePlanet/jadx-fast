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
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.s.b.c1.b;
import app.dogo.com.dogo_android.service.v2.b;

/* loaded from: classes.dex */
public class bk extends app.dogo.com.dogo_android.h.ak {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = null;
    private final ConstraintLayout T;
    private long U;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(5);
        bk.V = gVar;
        String str = "layout_dashboard_timer_square_segment";
        int i3 = 4;
        final int[] iArr2 = new int[i3];
        iArr2 = new int[]{1, 2, 3, 4};
        int[] iArr = new int[i3];
        iArr = new int[]{2131558769, 2131558769, 2131558769, 2131558769};
        gVar.a(0, /* result */, iArr2, iArr);
        int i = 0;
    }

    public bk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, bk.V, bk.W));
    }

    private bk(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 4, (ck)object3Arr3[1], (ck)object3Arr3[2], (ck)object3Arr3[3], (ck)object3Arr3[4]);
        this.U = -1;
        L(this.O);
        L(this.P);
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        obj10.setTag(0);
        L(this.Q);
        L(this.R);
        N(view2);
        A();
    }

    private boolean U(app.dogo.com.dogo_android.h.ck ck, int i2) {
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

    private boolean V(app.dogo.com.dogo_android.h.ck ck, int i2) {
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

    private boolean W(app.dogo.com.dogo_android.h.ck ck, int i2) {
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

    private boolean X(app.dogo.com.dogo_android.h.ck ck, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ak
    public void A() {
        this.U = 32;
        this.O.A();
        this.P.A();
        this.Q.A();
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.U = 32;
            this.O.A();
            this.P.A();
            this.Q.A();
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ak
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return V((ck)object2, i3);
                }
                return X((ck)object2, i3);
            }
            return W((ck)object2, i3);
        }
        return U((ck)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ak
    public void M(q q) {
        super.M(q);
        this.O.M(q);
        this.P.M(q);
        this.Q.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ak
    public boolean O(int i, Object object2) {
        int obj2;
        if (54 == i) {
            T((CouponTimer)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ak
    public void T(CouponTimer couponTimer) {
        this.S = couponTimer;
        this.U = l |= i2;
        notifyPropertyChanged(54);
        super.I();
        return;
        synchronized (this) {
            this.S = couponTimer;
            this.U = l |= i2;
            notifyPropertyChanged(54);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ak
    protected void m() {
        int time;
        int cmp;
        int cmp2;
        long l;
        int sECONDS;
        int valueOf;
        int i2;
        int seconds;
        int days;
        int hours;
        int minutes;
        int i;
        final Object obj = this;
        l = obj.U;
        final int i3 = 0;
        obj.U = i3;
        time = obj.S;
        int i4 = 48;
        int cmp4 = Long.compare(i6, i3);
        synchronized (this) {
            obj = this;
            l = obj.U;
            i3 = 0;
            obj.U = i3;
            time = obj.S;
            i4 = 48;
            cmp4 = Long.compare(i6, i3);
        }
        if (time != null) {
            seconds = time.getSeconds();
            days = time.getDays();
            hours = time.getHours();
            minutes = time.getMinutes();
        } else {
            try {
                minutes = hours;
                if (Long.compare(days, i3) > 0) {
                } else {
                }
                time = 1;
                time = i2;
                i = 128;
            }
            if (time != 0) {
            } else {
                i2 = time;
            }
            if (Long.compare(valueOf, i3) != 0) {
                obj.O.T(Long.valueOf(days));
                obj.O.w().setVisibility(i2);
                obj.P.T(Long.valueOf(hours));
                obj.Q.T(Long.valueOf(minutes));
                obj.R.T(Long.valueOf(seconds));
            }
            if (Long.compare(sECONDS, i3) != 0) {
                obj.O.U(v2.b.DAYS);
                obj.P.U(v2.b.HOURS);
                obj.Q.U(v2.b.MINUTES);
                obj.R.U(v2.b.SECONDS);
            }
            ViewDataBinding.o(obj.O);
            ViewDataBinding.o(obj.P);
            ViewDataBinding.o(obj.Q);
            ViewDataBinding.o(obj.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ak
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
                if (this.Q.y()) {
                }
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
