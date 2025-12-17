package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.c;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.i.f;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class fb extends app.dogo.com.dogo_android.h.eb {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final ConstraintLayout U;
    private g V;
    private g W;
    private g X;
    private long Y;

    class a implements g {

        final app.dogo.com.dogo_android.h.fb a;
        a(app.dogo.com.dogo_android.h.fb fb) {
            this.a = fb;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int dayOfMonth;
            Object fVar;
            int i2;
            int i;
            fVar = fbVar2.T;
            final int i3 = 0;
            i = fVar != null ? i2 : i3;
            if (i != 0) {
                fVar = fVar.l();
                if (fVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    fVar.setValue(Integer.valueOf(fbVar.O.getDayOfMonth()));
                }
            }
        }
    }

    class b implements g {

        final app.dogo.com.dogo_android.h.fb a;
        b(app.dogo.com.dogo_android.h.fb fb) {
            this.a = fb;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int valueOf;
            Object fVar;
            int i;
            int i2;
            fVar = fbVar2.T;
            final int i3 = 0;
            i2 = fVar != null ? i : i3;
            if (i2 != 0) {
                fVar = fVar.n();
                if (fVar != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    fVar.setValue(Integer.valueOf(fbVar.O.getMonth()));
                }
            }
        }
    }

    class c implements g {

        final app.dogo.com.dogo_android.h.fb a;
        c(app.dogo.com.dogo_android.h.fb fb) {
            this.a = fb;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int valueOf;
            Object fVar;
            int i2;
            int i;
            fVar = fbVar2.T;
            final int i3 = 0;
            i = fVar != null ? i2 : i3;
            if (i != 0) {
                fVar = fVar.p();
                if (fVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    fVar.setValue(Integer.valueOf(fbVar.O.getYear()));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fb.a0 = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
        sparseIntArray.put(2131363436, 4);
        sparseIntArray.put(2131363414, 5);
    }

    public fb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, fb.Z, fb.a0));
    }

    private fb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 4, (DatePicker)object3Arr3[1], (Button)object3Arr3[2], (TextView)object3Arr3[5], (MaterialToolbar)object3Arr3[3], (TextView)object3Arr3[4]);
        fb.a obj11 = new fb.a(this);
        this.V = obj11;
        obj11 = new fb.b(this);
        this.W = obj11;
        obj11 = new fb.c(this);
        this.X = obj11;
        this.Y = -1;
        int i7 = 0;
        this.O.setTag(i7);
        obj11 = object3Arr3[0];
        this.U = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        this.P.setTag(i7);
        N(view2);
        A();
    }

    private boolean W(x<Integer> x, int i2) {
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

    private boolean Y(x<y<Boolean>> x, int i2) {
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

    private boolean Z(x<Integer> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.eb
    public void A() {
        this.Y = 32;
        I();
        return;
        synchronized (this) {
            this.Y = 32;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.eb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return Z((x)object2, i3);
                }
                return X((x)object2, i3);
            }
            return Y((x)object2, i3);
        }
        return W((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.eb
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((f)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.eb
    public void V(f f) {
        this.T = f;
        this.Y = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = f;
            this.Y = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.eb
    protected void m() {
        Object value3;
        int cmp2;
        int cmp4;
        int cmp3;
        x xVar;
        Object value2;
        int i5;
        int i3;
        Object value;
        int i7;
        int i6;
        x xVar2;
        Object value4;
        int cmp;
        int i2;
        int i;
        int i8;
        int i4;
        g gVar3;
        g gVar;
        g gVar2;
        final Object obj = this;
        long l = obj.Y;
        final int i10 = 0;
        obj.Y = i10;
        value3 = obj.T;
        final int i13 = 50;
        int i14 = 61;
        i3 = 0;
        i7 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i10 = 0;
            obj.Y = i10;
            value3 = obj.T;
            i13 = 50;
            i14 = 61;
            i3 = 0;
            i7 = 0;
        }
        if (Long.compare(i17, i10) != 0) {
            if (value3 != null) {
                try {
                    xVar = value3.l();
                    xVar2 = value3.n();
                    cmp = value3.p();
                    cmp = xVar2;
                    obj.Q(i3, xVar);
                    obj.Q(2, xVar2);
                    obj.Q(3, cmp);
                    if (xVar != null) {
                    } else {
                    }
                    value2 = xVar.getValue();
                    value2 = i7;
                    value = xVar2.getValue();
                }
                value = i7;
                if (cmp != null) {
                    value4 = cmp.getValue();
                } else {
                    value4 = i7;
                }
                cmp3 = ViewDataBinding.J(value2);
                i3 = ViewDataBinding.J(value);
                i6 = ViewDataBinding.J(value4);
            } else {
            }
        } else {
            i6 = cmp3;
        }
        if (Long.compare(i18, i10) != 0) {
            if (value3 != null) {
                value3 = value3.o();
            } else {
                value3 = i7;
            }
            obj.Q(1, value3);
            if (value3 != null) {
                i7 = value3;
            }
        }
        i8 = cmp3;
        i = i3;
        i2 = i6;
        if (Long.compare(i5, i10) != 0) {
            c.a(obj.O, i2, i, i8, 0, obj.X, obj.W, obj.V);
        }
        if (Long.compare(i9, i10) != 0) {
            n.x0(obj.U, i7);
            n.Z(obj.P, i7);
        }
    }

    @Override // app.dogo.com.dogo_android.h.eb
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
