package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.m.t.g;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import f.d.a.a;

/* loaded from: classes.dex */
public class hg extends app.dogo.com.dogo_android.h.gg implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout S;
    private final ScrollView T;
    private final View.OnClickListener U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(7);
        hg.W = gVar;
        int i4 = 1;
        final int[] iArr = new int[i4];
        final int i8 = 0;
        iArr[i8] = 4;
        int[] iArr2 = new int[i4];
        iArr2[i8] = 2131558802;
        gVar.a(i4, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        hg.X = sparseIntArray;
        sparseIntArray.put(2131362322, 5);
        sparseIntArray.put(2131362956, 6);
    }

    public hg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, hg.W, hg.X));
    }

    private hg(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 3, (Button)object3Arr3[2], (Button)object3Arr3[3], (ImageView)object3Arr3[5], (om)object3Arr3[4], (TextView)object3Arr3[6]);
        this.V = -1;
        int i7 = 0;
        this.O.setTag(i7);
        this.P.setTag(i7);
        L(this.Q);
        Object obj11 = object3Arr3[0];
        this.S = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        obj11 = 1;
        final Object obj13 = object3Arr3[obj11];
        this.T = (ScrollView)obj13;
        obj13.setTag(i7);
        N(view2);
        b obj12 = new b(this, obj11);
        this.U = obj12;
        A();
    }

    private boolean V(app.dogo.com.dogo_android.h.om om, int i2) {
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

    private boolean W(x<Integer> x, int i2) {
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

    private boolean X(a<y<Boolean>> a, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.gg
    public void A() {
        this.V = 16;
        this.Q.A();
        I();
        return;
        synchronized (this) {
            this.V = 16;
            this.Q.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gg
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return V((om)object2, i3);
            }
            return X((a)object2, i3);
        }
        return W((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            Y((g)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public void Y(g g) {
        this.R = g;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = g;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public final void b(int i, View view2) {
        int obj2;
        final g obj1 = this.R;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.G(obj1.C());
        }
    }

    @Override // app.dogo.com.dogo_android.h.gg
    protected void m() {
        long l;
        int cmp3;
        int i2;
        View.OnClickListener list;
        int i9;
        int cmp;
        int value2;
        int i12;
        int string;
        int i4;
        int cmp2;
        int cmp4;
        int i6;
        Object value;
        int i7;
        int arr;
        int i;
        int i3;
        int i8;
        int i5;
        int i10;
        int i11;
        final Object obj = this;
        l = obj.V;
        final int i14 = 0;
        obj.V = i14;
        g gVar = obj.R;
        int i19 = 24;
        int i26 = 1024;
        i = 0;
        final int i28 = 0;
        synchronized (this) {
            obj = this;
            l = obj.V;
            i14 = 0;
            obj.V = i14;
            gVar = obj.R;
            i19 = 24;
            i26 = 1024;
            i = 0;
            i28 = 0;
        }
        int cmp6 = Long.compare(i3, i14);
        if (cmp6 != 0) {
            if (gVar != null) {
                try {
                    i6 = i3;
                    i6 = i;
                    obj.Q(i28, i6);
                    if (i6 != 0) {
                    } else {
                    }
                    value = i6.getValue();
                    value = i;
                    cmp4 = 1;
                }
                cmp4 = i28;
                if (cmp6 != 0) {
                    if (cmp4 != 0) {
                        l |= i31;
                        i5 = 256;
                    } else {
                        l |= i30;
                        i5 = 128;
                    }
                    i2 |= i5;
                }
                i7 = cmp4 != 0 ? i9 : i28;
                if (cmp4 != 0) {
                    i9 = i28;
                }
            } else {
            }
        } else {
            i7 = i9;
        }
        int cmp9 = Long.compare(i29, i14);
        if (cmp9 != 0) {
            if (gVar != null) {
                i8 = gVar.w();
            } else {
                i8 = i;
            }
            i10 = i8 != 0 ? 1 : i28;
            if (cmp9 != 0) {
                l = i10 != 0 ? l | i26 : l | i11;
            }
        } else {
            i10 = i28;
            i8 = i;
        }
        if (Long.compare(i11, i14) != 0) {
            if (gVar != null) {
                cmp4 = gVar.D();
            } else {
                cmp4 = i;
            }
            obj.Q(1, cmp4);
            if (cmp4 != 0) {
                value2 = cmp4.getValue();
            } else {
                value2 = i;
            }
        } else {
        }
        if (Long.compare(arr, i14) != 0) {
            arr = new Object[1];
            arr[i28] = i8;
            string = obj.P.getResources().getString(2131887154, arr);
        } else {
            string = i;
        }
        int cmp8 = Long.compare(i20, i14);
        if (cmp8 != 0) {
            if (i10 != 0) {
            } else {
                string = obj.P.getResources().getString(2131887156);
            }
            i = string;
        }
        if (Long.compare(i22, i14) != 0) {
            obj.O.setVisibility(i7);
            obj.P.setVisibility(i9);
        }
        if (Long.compare(i24, i14) != 0) {
            n.Z(obj.P, value2);
            n.F0(obj.S, value2);
        }
        if (Long.compare(i13, i14) != 0) {
            obj.P.setOnClickListener(obj.U);
        }
        if (cmp8 != 0) {
            g.c(obj.P, i);
            obj.Q.T(gVar);
        }
        ViewDataBinding.o(obj.Q);
    }

    @Override // app.dogo.com.dogo_android.h.gg
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
