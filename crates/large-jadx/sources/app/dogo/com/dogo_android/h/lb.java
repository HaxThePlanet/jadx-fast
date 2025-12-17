package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.f;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.k.f;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class lb extends app.dogo.com.dogo_android.h.kb {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout U;
    private g V;
    private long W;

    class a implements g {

        final app.dogo.com.dogo_android.h.lb a;
        a(app.dogo.com.dogo_android.h.lb lb) {
            this.a = lb;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int valueOf;
            Object fVar;
            int i2;
            int i;
            fVar = lbVar2.T;
            final int i3 = 0;
            i = fVar != null ? i2 : i3;
            if (i != 0) {
                fVar = fVar.l();
                if (fVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    fVar.setValue(Integer.valueOf(lbVar.O.getValue()));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        lb.Y = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
        sparseIntArray.put(2131363436, 4);
        sparseIntArray.put(2131363424, 5);
    }

    public lb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, lb.X, lb.Y));
    }

    private lb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (NumberPicker)object3Arr3[1], (Button)object3Arr3[2], (TextView)object3Arr3[5], (MaterialToolbar)object3Arr3[3], (TextView)object3Arr3[4]);
        lb.a obj11 = new lb.a(this);
        this.V = obj11;
        this.W = -1;
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
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.kb
    public void A() {
        this.W = 8;
        I();
        return;
        synchronized (this) {
            this.W = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((x)object2, i3);
        }
        return W((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.kb
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

    @Override // app.dogo.com.dogo_android.h.kb
    public void V(f f) {
        this.T = f;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = f;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kb
    protected void m() {
        int cmp2;
        x fVar;
        Object value;
        int value2;
        x xVar;
        int cmp4;
        int cmp3;
        int cmp;
        int i2;
        int i3;
        int i;
        long l = this.W;
        final int i5 = 0;
        this.W = i5;
        fVar = this.T;
        final int i8 = 14;
        i2 = 1;
        final int i10 = 13;
        final int i11 = 0;
        synchronized (this) {
            l = this.W;
            i5 = 0;
            this.W = i5;
            fVar = this.T;
            i8 = 14;
            i2 = 1;
            i10 = 13;
            i11 = 0;
        }
        try {
            if (fVar != null) {
            } else {
            }
            xVar = fVar.l();
            xVar = i11;
            Q(0, xVar);
            if (xVar != null) {
            } else {
            }
            value2 = xVar.getValue();
            value2 = i11;
        }
        if (Long.compare(i, i5) != 0) {
            if (fVar != null) {
                fVar = fVar.m();
            } else {
                fVar = i11;
            }
            Q(i2, fVar);
            if (fVar != null) {
                value = fVar.getValue();
            } else {
                value = i11;
            }
        } else {
        }
        if (Long.compare(i14, i5) != 0) {
            o.Y(this.O, i2);
            f.a(this.O, i11, this.V);
        }
        if (Long.compare(i9, i5) != 0) {
            f.b(this.O, i3);
        }
        if (Long.compare(i4, i5) != 0) {
            n.x0(this.U, value);
            n.Z(this.P, value);
        }
    }

    @Override // app.dogo.com.dogo_android.h.kb
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
