package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.c;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.p.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class bc extends app.dogo.com.dogo_android.h.ac {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final ConstraintLayout U;
    private g V;
    private g W;
    private g X;
    private long Y;

    class a implements g {

        final app.dogo.com.dogo_android.h.bc a;
        a(app.dogo.com.dogo_android.h.bc bc) {
            this.a = bc;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int dayOfMonth;
            Object rVar;
            int i2;
            int i;
            rVar = bcVar2.T;
            final int i3 = 0;
            i = rVar != null ? i2 : i3;
            if (i != 0) {
                rVar = rVar.m();
                if (rVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    rVar.setValue(Integer.valueOf(bcVar.O.getDayOfMonth()));
                }
            }
        }
    }

    class b implements g {

        final app.dogo.com.dogo_android.h.bc a;
        b(app.dogo.com.dogo_android.h.bc bc) {
            this.a = bc;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int valueOf;
            Object rVar;
            int i2;
            int i;
            rVar = bcVar2.T;
            final int i3 = 0;
            i = rVar != null ? i2 : i3;
            if (i != 0) {
                rVar = rVar.o();
                if (rVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    rVar.setValue(Integer.valueOf(bcVar.O.getMonth()));
                }
            }
        }
    }

    class c implements g {

        final app.dogo.com.dogo_android.h.bc a;
        c(app.dogo.com.dogo_android.h.bc bc) {
            this.a = bc;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int valueOf;
            Object rVar;
            int i;
            int i2;
            rVar = bcVar2.T;
            final int i3 = 0;
            i2 = rVar != null ? i : i3;
            if (i2 != 0) {
                rVar = rVar.q();
                if (rVar != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    rVar.setValue(Integer.valueOf(bcVar.O.getYear()));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bc.a0 = sparseIntArray;
        sparseIntArray.put(2131363433, 4);
    }

    public bc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, bc.Z, bc.a0));
    }

    private bc(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 4, (DatePicker)object3Arr3[2], (Button)object3Arr3[3], (TextView)object3Arr3[1], (MaterialToolbar)object3Arr3[4]);
        bc.a obj10 = new bc.a(this);
        this.V = obj10;
        obj10 = new bc.b(this);
        this.W = obj10;
        obj10 = new bc.c(this);
        this.X = obj10;
        this.Y = -1;
        int i6 = 0;
        this.O.setTag(i6);
        obj10 = object3Arr3[0];
        this.U = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.P.setTag(i6);
        this.Q.setTag(i6);
        N(view2);
        A();
    }

    private boolean X(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ac
    public void A() {
        this.Y = 64;
        I();
        return;
        synchronized (this) {
            this.Y = 64;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ac
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return a0((x)object2, i3);
                }
                return Z((x)object2, i3);
            }
            return Y((x)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ac
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (161 == i) {
            V((String)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((r)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ac
    public void V(String string) {
        this.S = string;
        this.Y = l |= i2;
        notifyPropertyChanged(161);
        super.I();
        return;
        synchronized (this) {
            this.S = string;
            this.Y = l |= i2;
            notifyPropertyChanged(161);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ac
    public void W(r r) {
        this.T = r;
        this.Y = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = r;
            this.Y = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ac
    protected void m() {
        int cmp;
        r value;
        int cmp3;
        int cmp4;
        x xVar3;
        Object value4;
        int i3;
        int i2;
        Object value3;
        int i8;
        int i5;
        x xVar;
        Object value2;
        int cmp2;
        x i7;
        int i;
        x xVar2;
        int i6;
        int i9;
        int i4;
        g gVar3;
        g gVar2;
        g gVar;
        final Object obj = this;
        long l = obj.Y;
        final int i11 = 0;
        obj.Y = i11;
        value = obj.T;
        final int i16 = 100;
        int i17 = 107;
        i2 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i11 = 0;
            obj.Y = i11;
            value = obj.T;
            i16 = 100;
            i17 = 107;
            i2 = 0;
        }
        if (Long.compare(i7, i11) != 0) {
            if (value != null) {
                try {
                    xVar3 = value.m();
                    i7 = value.o();
                    xVar = xVar2;
                    xVar3 = 0;
                    xVar = 0;
                    i7 = 0;
                    obj.Q(i2, xVar3);
                    obj.Q(1, i7);
                    obj.Q(3, xVar);
                    if (xVar3 != null) {
                    } else {
                    }
                    value4 = xVar3.getValue();
                    value4 = 0;
                    value3 = i7.getValue();
                }
                value3 = 0;
                if (xVar != null) {
                    value2 = xVar.getValue();
                } else {
                    value2 = 0;
                }
                cmp4 = ViewDataBinding.J(value4);
                i2 = ViewDataBinding.J(value3);
                i5 = ViewDataBinding.J(value2);
            } else {
            }
        } else {
            i5 = cmp4;
        }
        if (Long.compare(i20, i11) != 0) {
            if (value != null) {
                value = value.p();
            } else {
                value = 0;
            }
            obj.Q(2, value);
            if (value != null) {
                i9 = cmp4;
                i6 = i2;
                i = i5;
                i8 = value;
            } else {
                i9 = cmp4;
                i6 = i2;
                i = i5;
                i8 = 0;
            }
        } else {
        }
        if (Long.compare(i3, i11) != 0) {
            c.a(obj.O, i, i6, i9, 0, obj.X, obj.W, obj.V);
        }
        if (Long.compare(i10, i11) != 0) {
            n.x0(obj.U, i8);
            n.Z(obj.P, i8);
        }
        if (Long.compare(i13, i11) != 0) {
            g.c(obj.Q, obj.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ac
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
