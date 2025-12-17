package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.p.h0;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class rc extends app.dogo.com.dogo_android.h.qc implements b.a {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0;
    private final ConstraintLayout Y;
    private final ConstraintLayout Z;
    private final FrameLayout a0;
    private final View.OnClickListener b0;
    private long c0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(15);
        rc.d0 = gVar;
        int i8 = 1;
        final int[] iArr2 = new int[i8];
        final int i18 = 0;
        iArr2[i18] = 8;
        int[] iArr = new int[i8];
        iArr[i18] = 2131558816;
        gVar.a(4, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        rc.e0 = sparseIntArray;
        sparseIntArray.put(2131362351, 9);
        sparseIntArray.put(2131362359, 10);
        sparseIntArray.put(2131361977, 11);
        sparseIntArray.put(2131363184, 12);
        sparseIntArray.put(2131363333, 13);
        sparseIntArray.put(2131363002, 14);
    }

    public rc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 15, rc.d0, rc.e0));
    }

    private rc(e e, View view2, Object[] object3Arr3) {
        Object obj30 = this;
        super(e, view2, 3, (ImageView)object3Arr3[3], (ImageView)object3Arr3[5], (ImageView)object3Arr3[11], (TextView)object3Arr3[1], (View)object3Arr3[2], (ConstraintLayout)object3Arr3[9], (ImageView)object3Arr3[10], (ProgressBar)object3Arr3[14], (ScrollView)object3Arr3[12], (ViewPager2)object3Arr3[6], (TabLayout)object3Arr3[13], (in)object3Arr3[8]);
        Object obj18 = this;
        obj18.c0 = -1;
        int i16 = 0;
        obj18.O.setTag(i16);
        obj18.P.setTag(i16);
        obj18.R.setTag(i16);
        obj18.S.setTag(i16);
        Object obj14 = object3Arr3[0];
        obj18.Y = (ConstraintLayout)obj14;
        obj14.setTag(i16);
        Object obj15 = object3Arr3[4];
        obj18.Z = (ConstraintLayout)obj15;
        obj15.setTag(i16);
        Object obj16 = object3Arr3[7];
        obj18.a0 = (FrameLayout)obj16;
        obj16.setTag(i16);
        obj18.T.setTag(i16);
        obj18.L(obj18.V);
        obj18.N(view2);
        b bVar = new b(obj18, 1);
        obj18.b0 = bVar;
        A();
    }

    private boolean X(x<y<Boolean>> x, int i2) {
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

    private boolean Y(x<y<ProfilePreview>> x, int i2) {
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

    private boolean Z(app.dogo.com.dogo_android.h.in in, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.qc
    public void A() {
        this.c0 = 32;
        this.V.A();
        I();
        return;
        synchronized (this) {
            this.c0 = 32;
            this.V.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qc
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return X((x)object2, i3);
            }
            return Y((x)object2, i3);
        }
        return Z((in)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public void M(q q) {
        super.M(q);
        this.V.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((v)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((h0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public void V(v v) {
        this.W = v;
        this.c0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = v;
            this.c0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public void W(h0 h0) {
        this.X = h0;
        this.c0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.X = h0;
            this.c0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public final void b(int i, View view2) {
        int obj2;
        final v obj1 = this.W;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.u();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qc
    protected void m() {
        int cmp6;
        int cmp5;
        int cmp2;
        h0 h0Var;
        int value;
        int cmp;
        int i;
        int cmp3;
        int value2;
        int cmp4;
        long l = this.c0;
        final int i3 = 0;
        this.c0 = i3;
        v vVar = this.W;
        h0Var = this.X;
        cmp = Long.compare(i5, i3);
        final int i9 = 52;
        final int i10 = 0;
        synchronized (this) {
            l = this.c0;
            i3 = 0;
            this.c0 = i3;
            vVar = this.W;
            h0Var = this.X;
            cmp = Long.compare(i5, i3);
            i9 = 52;
            i10 = 0;
        }
        try {
            if (cmp != 0) {
            } else {
            }
            if (h0Var != null) {
            } else {
            }
            cmp3 = h0Var.t();
            cmp3 = i10;
            Q(1, cmp3);
            if (cmp3 != null) {
            } else {
            }
            value2 = cmp3.getValue();
            value2 = i10;
        }
        if (Long.compare(i11, i3) != 0) {
            if (h0Var != null) {
                h0Var = h0Var.q();
            } else {
                h0Var = i10;
            }
            Q(2, h0Var);
            if (h0Var != 0) {
                value = h0Var.getValue();
            } else {
                value = i10;
            }
        } else {
        }
        if (cmp != 0) {
            o.D(this.O, value2, vVar);
            o.H(this.P, value2, vVar);
            o.Q(this.Z, value2, this.V, vVar);
            o.z(this.T, this.U, vVar, value2);
        }
        if (Long.compare(i13, i3) != 0) {
            o.X(this.R, value2);
            n.F0(this.Y, value2);
        }
        if (Long.compare(i, i3) != 0) {
            this.S.setOnClickListener(this.b0);
        }
        if (Long.compare(i2, i3) != 0) {
            n.x0(this.a0, value);
            n.E0(this.a0, value, i10, i10);
        }
        ViewDataBinding.o(this.V);
    }

    @Override // app.dogo.com.dogo_android.h.qc
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.V.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
