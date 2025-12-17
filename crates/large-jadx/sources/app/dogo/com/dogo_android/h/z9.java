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
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.u.m.p;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class z9 extends app.dogo.com.dogo_android.h.y9 implements c.a {

    private static final ViewDataBinding.g q0;
    private static final SparseIntArray r0;
    private final SwipeRefreshLayout k0;
    private final ConstraintLayout l0;
    private final ConstraintLayout m0;
    private final Group n0;
    private final SwipeRefreshLayout.j o0;
    private long p0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z9.r0 = sparseIntArray;
        sparseIntArray.put(2131363185, 11);
        sparseIntArray.put(2131362992, 12);
        sparseIntArray.put(2131362991, 13);
        sparseIntArray.put(2131362998, 14);
        sparseIntArray.put(2131363030, 15);
        sparseIntArray.put(2131363031, 16);
        sparseIntArray.put(2131362395, 17);
        sparseIntArray.put(2131363500, 18);
        sparseIntArray.put(2131363441, 19);
        sparseIntArray.put(2131363584, 20);
        sparseIntArray.put(2131363586, 21);
        sparseIntArray.put(2131362690, 22);
    }

    public z9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 23, z9.q0, z9.r0));
    }

    private z9(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 1, (Button)object3Arr3[4], (TextView)object3Arr3[17], (KonfettiView)object3Arr3[22], (LinearLayout)object3Arr3[3], (TextView)object3Arr3[2], (AppCompatImageView)object3Arr3[13], (FrameLayout)object3Arr3[12], (TextView)object3Arr3[14], (TextView)object3Arr3[15], (View)object3Arr3[16], (NestedScrollView)object3Arr3[11], (FrameLayout)object3Arr3[7], (TextView)object3Arr3[9], (MaterialToolbar)object3Arr3[19], (Button)object3Arr3[5], (TextView)object3Arr3[18], (AppCompatImageView)object3Arr3[20], (View)object3Arr3[8], (AppCompatImageView)object3Arr3[21]);
        Object obj4 = this;
        obj4.p0 = -1;
        int i4 = 0;
        obj4.O.setTag(i4);
        Object obj2 = object3Arr3[0];
        obj4.k0 = (SwipeRefreshLayout)obj2;
        obj2.setTag(i4);
        int i3 = 1;
        Object obj6 = object3Arr3[i3];
        obj4.l0 = (ConstraintLayout)obj6;
        obj6.setTag(i4);
        Object obj7 = object3Arr3[10];
        obj4.m0 = (ConstraintLayout)obj7;
        obj7.setTag(i4);
        Object obj8 = object3Arr3[6];
        obj4.n0 = (Group)obj8;
        obj8.setTag(i4);
        obj4.R.setTag(i4);
        obj4.S.setTag(i4);
        obj4.Z.setTag(i4);
        obj4.a0.setTag(i4);
        obj4.c0.setTag(i4);
        obj4.f0.setTag(i4);
        obj4.N(view2);
        c cVar = new c(obj4, i3);
        obj4.o0 = cVar;
        A();
    }

    private boolean Y(x<y<SpecialProgramOverviewItem>> x, int i2) {
        if (i2 == 0) {
            this.p0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.p0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public void A() {
        this.p0 = 16;
        I();
        return;
        synchronized (this) {
            this.p0 = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return Y((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (90 == i) {
            W((Boolean)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((j)object2);
            } else {
                if (177 == i) {
                    X((p)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public void V(j j) {
        this.i0 = j;
        this.p0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.i0 = j;
            this.p0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public void W(Boolean boolean) {
        this.j0 = boolean;
        this.p0 = l |= i2;
        notifyPropertyChanged(90);
        super.I();
        return;
        synchronized (this) {
            this.j0 = boolean;
            this.p0 = l |= i2;
            notifyPropertyChanged(90);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public void X(p p) {
        this.h0 = p;
        this.p0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.h0 = p;
            this.p0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public final void a(int i) {
        int i2;
        final p obj2 = this.h0;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.s();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
    protected void m() {
        boolean bool;
        int cmp2;
        int cmp;
        int cmp3;
        int i3;
        View view5;
        int value;
        int i4;
        boolean i;
        Button button2;
        int i6;
        int i2;
        int i5;
        androidx.appcompat.widget.AppCompatImageView view4;
        TextView view;
        TextView view2;
        Button button3;
        TextView view3;
        Button button;
        final Object obj = this;
        long l = obj.p0;
        final int i7 = 0;
        obj.p0 = i7;
        final j jVar = obj.i0;
        p pVar = obj.h0;
        int cmp4 = Long.compare(i9, i7);
        synchronized (this) {
            obj = this;
            l = obj.p0;
            i7 = 0;
            obj.p0 = i7;
            jVar = obj.i0;
            pVar = obj.h0;
            cmp4 = Long.compare(i9, i7);
        }
        if (pVar != null) {
            i4 = pVar.q();
        } else {
            try {
                i4 = 0;
                obj.Q(0, i4);
                if (i4 != 0) {
                } else {
                }
                value = i4.getValue();
                value = 0;
                i = bool;
                value = 0;
            }
            n.Z(obj.O, value);
            n.F0(obj.k0, value);
            n.y0(obj.k0, value);
            l.u0(obj.l0, value, obj.T, obj.V, obj.P, obj.O, obj.d0, obj.c0);
            n.H0(obj.m0, value);
            n.w0(obj.n0, value);
            l.H0(obj.a0, value);
            n.Z(obj.c0, value);
            if (Long.compare(i6, i7) != 0) {
                i6 = 0;
                n.a0(obj.k0, i6);
                obj.k0.setOnRefreshListener(obj.o0);
                n.k0(obj.Z, i6);
            }
            if (Long.compare(i3, i7) != 0) {
                l.t0(obj.R, value, jVar);
                l.u(obj.S, value, obj.W, jVar, obj.X);
            }
            if (cmp4 != 0) {
                l.M0(obj.f0, value, obj.g0, jVar, i);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
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
