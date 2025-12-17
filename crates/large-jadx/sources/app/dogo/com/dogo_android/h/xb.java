package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.a;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.a;
import app.dogo.com.dogo_android.l.a.a.a;
import app.dogo.com.dogo_android.r.l;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes.dex */
public class xb extends app.dogo.com.dogo_android.h.wb implements a.a {

    private static final ViewDataBinding.g n0;
    private static final SparseIntArray o0;
    private final ConstraintLayout a0;
    private final TextInputEditText b0;
    private final TextInputEditText c0;
    private final CompoundButton.OnCheckedChangeListener d0;
    private final CompoundButton.OnCheckedChangeListener e0;
    private final CompoundButton.OnCheckedChangeListener f0;
    private final CompoundButton.OnCheckedChangeListener g0;
    private final CompoundButton.OnCheckedChangeListener h0;
    private final CompoundButton.OnCheckedChangeListener i0;
    private final CompoundButton.OnCheckedChangeListener j0;
    private g k0;
    private g l0;
    private long m0;

    class a implements g {

        final app.dogo.com.dogo_android.h.xb a;
        a(app.dogo.com.dogo_android.h.xb xb) {
            this.a = xb;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object lVar;
            int i;
            int i2;
            lVar = xbVar2.Z;
            final int i3 = 0;
            i2 = lVar != null ? i : i3;
            if (i2 != 0) {
                lVar = lVar.s();
                if (lVar != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    lVar.setValue(g.a(xb.W(this.a)));
                }
            }
        }
    }

    class b implements g {

        final app.dogo.com.dogo_android.h.xb a;
        b(app.dogo.com.dogo_android.h.xb xb) {
            this.a = xb;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object lVar;
            int i2;
            int i;
            lVar = xbVar2.Z;
            final int i3 = 0;
            i = lVar != null ? i2 : i3;
            if (i != 0) {
                lVar = lVar.t();
                if (lVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    lVar.setValue(g.a(xb.X(this.a)));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        xb.o0 = sparseIntArray;
        sparseIntArray.put(2131363433, 10);
        sparseIntArray.put(2131363436, 11);
        sparseIntArray.put(2131362876, 12);
        sparseIntArray.put(2131362342, 13);
        sparseIntArray.put(2131363414, 14);
        sparseIntArray.put(2131362615, 15);
        sparseIntArray.put(2131362617, 16);
        sparseIntArray.put(2131362805, 17);
        sparseIntArray.put(2131362616, 18);
        sparseIntArray.put(2131362806, 19);
        sparseIntArray.put(2131362282, 20);
        sparseIntArray.put(2131362156, 21);
        sparseIntArray.put(2131363172, 22);
    }

    public xb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 23, xb.n0, xb.o0));
    }

    private xb(e e, View view2, Object[] object3Arr3) {
        app.dogo.com.dogo_android.h.xb xbVar3 = this;
        super(e, view2, 2, (LinearLayout)object3Arr3[21], (TextView)object3Arr3[20], (AppCompatImageView)object3Arr3[13], (FocusedBorderTextInput)object3Arr3[15], (TextView)object3Arr3[18], (TextView)object3Arr3[16], (FocusedBorderTextInput)object3Arr3[17], (TextView)object3Arr3[19], (NestedScrollView)object3Arr3[12], (MaterialButton)object3Arr3[22], (TextView)object3Arr3[14], (CheckBox)object3Arr3[3], (CheckBox)object3Arr3[4], (CheckBox)object3Arr3[5], (CheckBox)object3Arr3[6], (CheckBox)object3Arr3[7], (CheckBox)object3Arr3[8], (CheckBox)object3Arr3[9], (MaterialToolbar)object3Arr3[10], (TextView)object3Arr3[11]);
        app.dogo.com.dogo_android.h.xb xbVar2 = this;
        xb.a aVar = new xb.a(xbVar2);
        xbVar2.k0 = aVar;
        xb.b bVar = new xb.b(xbVar2);
        xbVar2.l0 = bVar;
        xbVar2.m0 = -1;
        Object obj = object3Arr3[0];
        xbVar2.a0 = (ConstraintLayout)obj;
        int i4 = 0;
        obj.setTag(i4);
        int i2 = 1;
        Object obj3 = object3Arr3[i2];
        xbVar2.b0 = (TextInputEditText)obj3;
        obj3.setTag(i4);
        int i10 = 2;
        Object obj5 = object3Arr3[i10];
        xbVar2.c0 = (TextInputEditText)obj5;
        obj5.setTag(i4);
        xbVar2.Q.setTag(i4);
        xbVar2.R.setTag(i4);
        xbVar2.S.setTag(i4);
        xbVar2.T.setTag(i4);
        xbVar2.U.setTag(i4);
        xbVar2.V.setTag(i4);
        xbVar2.W.setTag(i4);
        xbVar2.N(view2);
        a aVar2 = new a(xbVar2, 7);
        xbVar2.d0 = aVar2;
        a aVar3 = new a(xbVar2, 4);
        xbVar2.e0 = aVar3;
        a aVar4 = new a(xbVar2, i10);
        xbVar2.f0 = aVar4;
        a aVar5 = new a(xbVar2, 6);
        xbVar2.g0 = aVar5;
        a aVar6 = new a(xbVar2, 5);
        xbVar2.h0 = aVar6;
        a aVar7 = new a(xbVar2, 3);
        xbVar2.i0 = aVar7;
        a aVar8 = new a(xbVar2, i2);
        xbVar2.j0 = aVar8;
        A();
    }

    static TextInputEditText W(app.dogo.com.dogo_android.h.xb xb) {
        return xb.b0;
    }

    static TextInputEditText X(app.dogo.com.dogo_android.h.xb xb) {
        return xb.c0;
    }

    private boolean Y(x<String> x, int i2) {
        if (i2 == 0) {
            this.m0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.m0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(x<String> x, int i2) {
        if (i2 == 0) {
            this.m0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.m0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.wb
    public void A() {
        this.m0 = 8;
        I();
        return;
        synchronized (this) {
            this.m0 = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((x)object2, i3);
        }
        return Z((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.wb
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

    @Override // app.dogo.com.dogo_android.h.wb
    public void V(l l) {
        this.Z = l;
        this.m0 = l2 |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Z = l;
            this.m0 = l2 |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wb
    public final void c(int i, CompoundButton compoundButton2, boolean z3) {
        l obj2;
        int obj3;
        obj3 = 0;
        final int i3 = 1;
        switch (i) {
            case 1:
                obj2 = this.Z;
                obj3 = i3;
                obj2.o(i3, z3);
                break;
            case 2:
                obj2 = this.Z;
                obj3 = i3;
                obj2.o(2, z3);
                break;
            case 3:
                obj2 = this.Z;
                obj3 = i3;
                obj2.o(3, z3);
                break;
            case 4:
                obj2 = this.Z;
                obj3 = i3;
                obj2.o(4, z3);
                break;
            case 5:
                obj2 = this.Z;
                obj3 = i3;
                obj2.o(5, z3);
                break;
            case 6:
                obj2 = this.Z;
                obj3 = i3;
                obj2.o(6, z3);
                break;
            case 7:
                obj2 = this.Z;
                obj3 = i3;
                obj2.o(7, z3);
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.wb
    protected void m() {
        int cmp;
        l lVar;
        int value;
        int cmp2;
        int value2;
        int cmp3;
        int i;
        int cmp4;
        int cmp5;
        CompoundButton.OnCheckedChangeListener list;
        long l = this.m0;
        final int i3 = 0;
        this.m0 = i3;
        lVar = this.Z;
        int i6 = 14;
        final int i8 = 13;
        final int i9 = 0;
        synchronized (this) {
            l = this.m0;
            i3 = 0;
            this.m0 = i3;
            lVar = this.Z;
            i6 = 14;
            i8 = 13;
            i9 = 0;
        }
        try {
            if (Long.compare(i, i3) != 0) {
            } else {
            }
            if (lVar != null) {
            } else {
            }
            cmp2 = lVar.t();
            cmp2 = i9;
            Q(0, cmp2);
            if (cmp2 != null) {
            } else {
            }
            value2 = cmp2.getValue();
            value2 = i9;
        }
        if (Long.compare(i10, i3) != 0) {
            if (lVar != null) {
                lVar = lVar.s();
            } else {
                lVar = i9;
            }
            Q(1, lVar);
            if (lVar != 0) {
                value = lVar.getValue();
            } else {
                value = i9;
            }
        } else {
        }
        if (Long.compare(i12, i3) != 0) {
            n.P(this.b0, 24);
            g.e(this.b0, i9, i9, i9, this.k0);
            n.P(this.c0, 59);
            g.e(this.c0, i9, i9, i9, this.l0);
            a.b(this.Q, this.j0, i9);
            a.b(this.R, this.f0, i9);
            a.b(this.S, this.i0, i9);
            a.b(this.T, this.e0, i9);
            a.b(this.U, this.h0, i9);
            a.b(this.V, this.g0, i9);
            a.b(this.W, this.d0, i9);
        }
        if (Long.compare(i7, i3) != 0) {
            g.c(this.b0, value);
        }
        if (Long.compare(i2, i3) != 0) {
            g.c(this.c0, value2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wb
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
