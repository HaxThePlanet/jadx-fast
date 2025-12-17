package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.n.k;
import app.dogo.com.dogo_android.u.n.n;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class bf extends app.dogo.com.dogo_android.h.af implements c.a {

    private static final ViewDataBinding.g j0;
    private static final SparseIntArray k0;
    private final SwipeRefreshLayout d0;
    private final ConstraintLayout e0;
    private final Group f0;
    private final ConstraintLayout g0;
    private final SwipeRefreshLayout.j h0;
    private long i0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bf.k0 = sparseIntArray;
        sparseIntArray.put(2131363185, 9);
        sparseIntArray.put(2131362992, 10);
        sparseIntArray.put(2131362991, 11);
        sparseIntArray.put(2131362998, 12);
        sparseIntArray.put(2131362990, 13);
        sparseIntArray.put(2131362395, 14);
        sparseIntArray.put(2131363500, 15);
        sparseIntArray.put(2131363441, 16);
        sparseIntArray.put(2131362690, 17);
    }

    public bf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 18, bf.j0, bf.k0));
    }

    private bf(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 1, (Button)object3Arr3[3], (TextView)object3Arr3[14], (KonfettiView)object3Arr3[17], (LinearLayout)object3Arr3[2], (TextView)object3Arr3[13], (AppCompatImageView)object3Arr3[11], (FrameLayout)object3Arr3[10], (TextView)object3Arr3[12], (NestedScrollView)object3Arr3[9], (FrameLayout)object3Arr3[6], (TextView)object3Arr3[7], (MaterialToolbar)object3Arr3[16], (Button)object3Arr3[4], (TextView)object3Arr3[15]);
        Object obj4 = this;
        obj4.i0 = -1;
        int i4 = 0;
        obj4.O.setTag(i4);
        Object obj2 = object3Arr3[0];
        obj4.d0 = (SwipeRefreshLayout)obj2;
        obj2.setTag(i4);
        int i3 = 1;
        Object obj6 = object3Arr3[i3];
        obj4.e0 = (ConstraintLayout)obj6;
        obj6.setTag(i4);
        Object obj7 = object3Arr3[5];
        obj4.f0 = (Group)obj7;
        obj7.setTag(i4);
        Object obj8 = object3Arr3[8];
        obj4.g0 = (ConstraintLayout)obj8;
        obj8.setTag(i4);
        obj4.R.setTag(i4);
        obj4.W.setTag(i4);
        obj4.X.setTag(i4);
        obj4.Z.setTag(i4);
        obj4.N(view2);
        c cVar = new c(obj4, i3);
        obj4.h0 = cVar;
        A();
    }

    private boolean X(x<y<SpecialProgramOverviewItem>> x, int i2) {
        if (i2 == 0) {
            this.i0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.i0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.af
    public void A() {
        this.i0 = 8;
        I();
        return;
        synchronized (this) {
            this.i0 = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.af
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.af
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((k)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((n)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.af
    public void V(k k) {
        this.c0 = k;
        this.i0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.c0 = k;
            this.i0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.af
    public void W(n n) {
        this.b0 = n;
        this.i0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.b0 = n;
            this.i0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.af
    public final void a(int i) {
        int i2;
        final n obj2 = this.b0;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.u();
        }
    }

    @Override // app.dogo.com.dogo_android.h.af
    protected void m() {
        int cmp;
        SwipeRefreshLayout.j jVar;
        int value;
        n nVar;
        int i;
        int cmp2;
        int i2;
        androidx.appcompat.widget.AppCompatImageView view2;
        TextView view3;
        TextView view;
        Button button;
        TextView view4;
        Button button2;
        final Object obj = this;
        long l = obj.i0;
        final int i4 = 0;
        obj.i0 = i4;
        nVar = obj.b0;
        int cmp3 = Long.compare(i6, i4);
        final int i7 = 0;
        synchronized (this) {
            obj = this;
            l = obj.i0;
            i4 = 0;
            obj.i0 = i4;
            nVar = obj.b0;
            cmp3 = Long.compare(i6, i4);
            i7 = 0;
        }
        if (nVar != null) {
            nVar = nVar.s();
        } else {
            try {
                nVar = i7;
                obj.Q(0, nVar);
                if (nVar != 0) {
                } else {
                }
                value = nVar.getValue();
                value = i7;
                if (Long.compare(i9, i4) != 0) {
                }
                n.Z(obj.O, value);
                n.F0(obj.d0, value);
                n.y0(obj.d0, value);
                l.u0(obj.e0, value, obj.S, obj.U, obj.P, obj.O, obj.a0, obj.Z);
                n.w0(obj.f0, value);
                n.H0(obj.g0, value);
                l.H0(obj.X, value);
                n.Z(obj.Z, value);
            }
            n.a0(obj.d0, i7);
            obj.d0.setOnRefreshListener(obj.h0);
            n.k0(obj.W, i7);
            if (cmp3 != 0) {
                l.t0(obj.R, value, obj.c0);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.af
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
