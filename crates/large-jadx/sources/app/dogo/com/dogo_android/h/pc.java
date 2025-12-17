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
public class pc extends app.dogo.com.dogo_android.h.oc implements b.a {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final ConstraintLayout X;
    private final ConstraintLayout Y;
    private final FrameLayout Z;
    private final View.OnClickListener a0;
    private long b0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(13);
        pc.c0 = gVar;
        int i6 = 1;
        final int[] iArr = new int[i6];
        final int i12 = 0;
        iArr[i12] = 8;
        int[] iArr2 = new int[i6];
        iArr2[i12] = 2131558816;
        gVar.a(i6, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        pc.d0 = sparseIntArray;
        sparseIntArray.put(2131363183, 9);
        sparseIntArray.put(2131362359, 10);
        sparseIntArray.put(2131363333, 11);
        sparseIntArray.put(2131363002, 12);
    }

    public pc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 13, pc.c0, pc.d0));
    }

    private pc(e e, View view2, Object[] object3Arr3) {
        final Object obj25 = this;
        super(e, view2, 3, (ImageView)object3Arr3[4], (ImageView)object3Arr3[5], (TextView)object3Arr3[2], (View)object3Arr3[3], (ImageView)object3Arr3[10], (ProgressBar)object3Arr3[12], (ScrollView)object3Arr3[9], (ViewPager2)object3Arr3[6], (TabLayout)object3Arr3[11], (in)object3Arr3[8]);
        obj25.b0 = -1;
        int i14 = 0;
        obj25.O.setTag(i14);
        obj25.P.setTag(i14);
        obj25.Q.setTag(i14);
        obj25.R.setTag(i14);
        Object obj11 = object3Arr3[0];
        obj25.X = (ConstraintLayout)obj11;
        obj11.setTag(i14);
        int i13 = 1;
        Object obj13 = object3Arr3[i13];
        obj25.Y = (ConstraintLayout)obj13;
        obj13.setTag(i14);
        Object obj14 = object3Arr3[7];
        obj25.Z = (FrameLayout)obj14;
        obj14.setTag(i14);
        obj25.S.setTag(i14);
        L(obj25.U);
        N(view2);
        b bVar = new b(this, i13);
        obj25.a0 = bVar;
        A();
    }

    private boolean X(x<y<Boolean>> x, int i2) {
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

    private boolean Y(x<y<ProfilePreview>> x, int i2) {
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

    private boolean Z(app.dogo.com.dogo_android.h.in in, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.oc
    public void A() {
        this.b0 = 32;
        this.U.A();
        I();
        return;
        synchronized (this) {
            this.b0 = 32;
            this.U.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oc
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return Z((in)object2, i3);
            }
            return X((x)object2, i3);
        }
        return Y((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public void M(q q) {
        super.M(q);
        this.U.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.oc
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

    @Override // app.dogo.com.dogo_android.h.oc
    public void V(v v) {
        this.V = v;
        this.b0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.V = v;
            this.b0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public void W(h0 h0) {
        this.W = h0;
        this.b0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.W = h0;
            this.b0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public final void b(int i, View view2) {
        int obj2;
        final v obj1 = this.V;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.u();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oc
    protected void m() {
        int cmp2;
        int cmp4;
        int cmp5;
        h0 h0Var;
        int value;
        int cmp3;
        int i;
        int cmp;
        int value2;
        int cmp6;
        long l = this.b0;
        final int i3 = 0;
        this.b0 = i3;
        v vVar = this.V;
        h0Var = this.W;
        cmp3 = Long.compare(i5, i3);
        final int i9 = 50;
        final int i10 = 0;
        synchronized (this) {
            l = this.b0;
            i3 = 0;
            this.b0 = i3;
            vVar = this.V;
            h0Var = this.W;
            cmp3 = Long.compare(i5, i3);
            i9 = 50;
            i10 = 0;
        }
        try {
            if (cmp3 != 0) {
            } else {
            }
            if (h0Var != null) {
            } else {
            }
            cmp = h0Var.t();
            cmp = i10;
            Q(0, cmp);
            if (cmp != null) {
            } else {
            }
            value2 = cmp.getValue();
            value2 = i10;
        }
        if (Long.compare(i11, i3) != 0) {
            if (h0Var != null) {
                h0Var = h0Var.q();
            } else {
                h0Var = i10;
            }
            Q(1, h0Var);
            if (h0Var != 0) {
                value = h0Var.getValue();
            } else {
                value = i10;
            }
        } else {
        }
        if (cmp3 != 0) {
            o.D(this.O, value2, vVar);
            o.H(this.P, value2, vVar);
            o.Q(this.Y, value2, this.U, vVar);
            o.z(this.S, this.T, vVar, value2);
        }
        if (Long.compare(i13, i3) != 0) {
            o.X(this.Q, value2);
            n.F0(this.X, value2);
        }
        if (Long.compare(i, i3) != 0) {
            this.R.setOnClickListener(this.a0);
        }
        if (Long.compare(i2, i3) != 0) {
            n.x0(this.Z, value);
            n.E0(this.Z, value, i10, i10);
        }
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.oc
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.U.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
