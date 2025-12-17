package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.a;
import app.dogo.com.dogo_android.l.a.a.a;
import app.dogo.com.dogo_android.u.n.p.e;
import app.dogo.com.dogo_android.u.n.q.l;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class df extends app.dogo.com.dogo_android.h.cf implements a.a {

    private static final ViewDataBinding.g m0;
    private static final SparseIntArray n0;
    private final CoordinatorLayout d0;
    private final CompoundButton.OnCheckedChangeListener e0;
    private final CompoundButton.OnCheckedChangeListener f0;
    private final CompoundButton.OnCheckedChangeListener g0;
    private final CompoundButton.OnCheckedChangeListener h0;
    private final CompoundButton.OnCheckedChangeListener i0;
    private final CompoundButton.OnCheckedChangeListener j0;
    private final CompoundButton.OnCheckedChangeListener k0;
    private long l0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        df.n0 = sparseIntArray;
        sparseIntArray.put(2131361934, 14);
        sparseIntArray.put(2131363433, 15);
        sparseIntArray.put(2131362876, 16);
        sparseIntArray.put(2131362342, 17);
        sparseIntArray.put(2131362676, 18);
        sparseIntArray.put(2131362323, 19);
        sparseIntArray.put(2131362678, 20);
        sparseIntArray.put(2131362324, 21);
        sparseIntArray.put(2131362675, 22);
        sparseIntArray.put(2131362325, 23);
        sparseIntArray.put(2131363055, 24);
    }

    public df(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 25, df.m0, df.n0));
    }

    private df(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 7, (AppBarLayout)object3Arr3[14], (LinearLayout)object3Arr3[5], (TextView)object3Arr3[4], (ImageView)object3Arr3[19], (ImageView)object3Arr3[21], (ImageView)object3Arr3[23], (AppCompatImageView)object3Arr3[17], (TextView)object3Arr3[22], (TextView)object3Arr3[18], (MaterialButton)object3Arr3[1], (TextView)object3Arr3[20], (MaterialButton)object3Arr3[2], (MaterialButton)object3Arr3[3], (NestedScrollView)object3Arr3[16], (TextView)object3Arr3[24], (MaterialButton)object3Arr3[13], (CheckBox)object3Arr3[6], (CheckBox)object3Arr3[7], (CheckBox)object3Arr3[8], (CheckBox)object3Arr3[9], (CheckBox)object3Arr3[10], (CheckBox)object3Arr3[11], (CheckBox)object3Arr3[12], (MaterialToolbar)object3Arr3[15]);
        Object obj4 = this;
        obj4.l0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        obj4.S.setTag(i3);
        Object obj2 = object3Arr3[0];
        obj4.d0 = (CoordinatorLayout)obj2;
        obj2.setTag(i3);
        obj4.T.setTag(i3);
        obj4.U.setTag(i3);
        obj4.V.setTag(i3);
        obj4.W.setTag(i3);
        obj4.X.setTag(i3);
        obj4.Y.setTag(i3);
        obj4.Z.setTag(i3);
        obj4.a0.setTag(i3);
        obj4.N(view2);
        a aVar = new a(obj4, 3);
        obj4.e0 = aVar;
        a aVar2 = new a(obj4, 6);
        obj4.f0 = aVar2;
        a aVar3 = new a(obj4, 7);
        obj4.g0 = aVar3;
        a aVar4 = new a(obj4, 1);
        obj4.h0 = aVar4;
        a aVar5 = new a(obj4, 4);
        obj4.i0 = aVar5;
        a aVar6 = new a(obj4, 2);
        obj4.j0 = aVar6;
        a aVar7 = new a(obj4, 5);
        obj4.k0 = aVar7;
        A();
    }

    private boolean W(x<List<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(x<Long> x, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
    public void A() {
        this.l0 = 256;
        I();
        return;
        synchronized (this) {
            this.l0 = 256;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
    protected boolean E(int i, Object object2, int i3) {
        switch (i) {
            case 0:
                return a0((x)object2, i3);
            case 1:
                return b0((x)object2, i3);
            case 2:
                return Y((x)object2, i3);
            case 3:
                return W((x)object2, i3);
            case 4:
                return c0((x)object2, i3);
            case 5:
                return X((x)object2, i3);
            case 6:
                return Z((x)object2, i3);
            default:
                return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((l)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.cf
    public void V(l l) {
        this.c0 = l;
        this.l0 = l2 |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.c0 = l;
            this.l0 = l2 |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
    public final void c(int i, CompoundButton compoundButton2, boolean z3) {
        int i3;
        l obj2;
        int obj3;
        obj3 = 1;
        i3 = 0;
        switch (i) {
            case 1:
                obj2 = this.c0;
                obj3 = i3;
                obj2.A(i3, z3);
                break;
            case 2:
                obj2 = this.c0;
                i3 = obj3;
                obj2.A(obj3, z3);
                break;
            case 3:
                obj2 = this.c0;
                obj3 = i3;
                obj2.A(2, z3);
                break;
            case 4:
                obj2 = this.c0;
                obj3 = i3;
                obj2.A(3, z3);
                break;
            case 5:
                obj2 = this.c0;
                obj3 = i3;
                obj2.A(4, z3);
                break;
            case 6:
                obj2 = this.c0;
                obj3 = i3;
                obj2.A(5, z3);
                break;
            case 7:
                obj2 = this.c0;
                obj3 = i3;
                obj2.A(6, z3);
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
    protected void m() {
        int value2;
        int cmp3;
        int cmp7;
        int lVar;
        int i6;
        int i9;
        int value5;
        int cmp10;
        int value4;
        int cmp11;
        int i2;
        int value3;
        int i8;
        int i10;
        int value6;
        int cmp4;
        int cmp8;
        int i3;
        int i;
        int cmp6;
        int value7;
        int i4;
        int value;
        int cmp5;
        int cmp9;
        int cmp2;
        int cmp;
        x xVar;
        int i5;
        int i7;
        final Object obj = this;
        long l = obj.l0;
        final int i11 = 0;
        obj.l0 = i11;
        lVar = obj.c0;
        int i26 = 392;
        final int i34 = 384;
        synchronized (this) {
            obj = this;
            l = obj.l0;
            i11 = 0;
            obj.l0 = i11;
            lVar = obj.c0;
            i26 = 392;
            i34 = 384;
        }
        if (Long.compare(i35, i11) != 0) {
            if (lVar != null) {
                try {
                    cmp10 = lVar.v();
                    cmp10 = 0;
                    obj.Q(0, cmp10);
                    if (cmp10 != 0) {
                    } else {
                    }
                    value5 = cmp10.getValue();
                    value5 = 0;
                }
                value4 = 0;
                value3 = 0;
                if (Long.compare(i30, i11) != 0) {
                    if (lVar != null) {
                        cmp2 = lVar.r();
                        i4 = xVar;
                    } else {
                        i4 = 0;
                        cmp2 = 0;
                    }
                    obj.Q(2, cmp2);
                    obj.Q(5, i4);
                    if (cmp2 != 0) {
                        value = cmp2.getValue();
                    } else {
                        value = 0;
                    }
                    if (i4 != 0) {
                        value7 = i4.getValue();
                    } else {
                        value7 = 0;
                    }
                } else {
                    value7 = 0;
                    value = 0;
                }
                if (Long.compare(i31, i11) != 0) {
                    if (lVar != null) {
                        cmp = lVar.o();
                    } else {
                        cmp = 0;
                    }
                    obj.Q(3, cmp);
                    if (cmp != 0) {
                        value6 = cmp.getValue();
                    } else {
                        value6 = 0;
                    }
                } else {
                }
                if (Long.compare(i32, i11) != 0 && lVar != null) {
                    if (lVar != null) {
                        i = lVar.p();
                    } else {
                        i = 0;
                    }
                } else {
                }
                if (Long.compare(i7, i11) != 0) {
                    if (lVar != null) {
                        lVar = lVar.u();
                    } else {
                        lVar = 0;
                    }
                    obj.Q(6, lVar);
                    if (lVar != 0) {
                        value2 = lVar.getValue();
                    } else {
                        value2 = 0;
                    }
                } else {
                }
                if (Long.compare(i28, i11) != 0) {
                    n.u0(obj.O, i);
                }
                if (Long.compare(i27, i11) != 0) {
                    n.r0(obj.P, value6);
                }
                if (Long.compare(i20, i11) != 0) {
                    e.d(obj.Q, value7, value);
                }
                if (Long.compare(i22, i11) != 0) {
                    e.d(obj.R, value3, value4);
                }
                if (Long.compare(i16, i11) != 0) {
                    n.W(obj.S, value2);
                }
                if (Long.compare(i18, i11) != 0) {
                    n.x0(obj.d0, value5);
                    n.Z(obj.T, value5);
                }
                if (Long.compare(i6, i11) != 0) {
                    i9 = 0;
                    a.b(obj.U, obj.h0, i9);
                    a.b(obj.V, obj.j0, i9);
                    a.b(obj.W, obj.e0, i9);
                    a.b(obj.X, obj.i0, i9);
                    a.b(obj.Y, obj.k0, i9);
                    a.b(obj.Z, obj.f0, i9);
                    a.b(obj.a0, obj.g0, i9);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
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
