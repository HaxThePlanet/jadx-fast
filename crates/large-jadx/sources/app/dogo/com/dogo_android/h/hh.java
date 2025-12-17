package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.q.r.d;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class hh extends app.dogo.com.dogo_android.h.gh implements b.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private g V;
    private g W;
    private long X;

    class a implements g {

        final app.dogo.com.dogo_android.h.hh a;
        a(app.dogo.com.dogo_android.h.hh hh) {
            this.a = hh;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object dVar;
            int i2;
            int i;
            dVar = hhVar2.S;
            final int i3 = 0;
            i = dVar != null ? i2 : i3;
            if (i != 0) {
                dVar = dVar.h();
                if (dVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    dVar.setValue(g.a(hhVar.O));
                }
            }
        }
    }

    class b implements g {

        final app.dogo.com.dogo_android.h.hh a;
        b(app.dogo.com.dogo_android.h.hh hh) {
            this.a = hh;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object dVar;
            int i2;
            int i;
            dVar = hhVar2.S;
            final int i3 = 0;
            i = dVar != null ? i2 : i3;
            if (i != 0) {
                dVar = dVar.k();
                if (dVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    dVar.setValue(g.a(hhVar.P));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        hh.Z = sparseIntArray;
        sparseIntArray.put(2131363433, 4);
        sparseIntArray.put(2131362401, 5);
        sparseIntArray.put(2131362860, 6);
        sparseIntArray.put(2131362400, 7);
        sparseIntArray.put(2131362385, 8);
    }

    public hh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, hh.Y, hh.Z));
    }

    private hh(e e, View view2, Object[] object3Arr3) {
        final Object obj19 = this;
        final int i12 = 1;
        super(e, view2, 3, (TextInputEditText)object3Arr3[2], (TextView)object3Arr3[8], (TextInputLayout)object3Arr3[7], (TextInputLayout)object3Arr3[5], (TextInputEditText)object3Arr3[i12], (TextView)object3Arr3[6], (Button)object3Arr3[3], (MaterialToolbar)object3Arr3[4]);
        hh.a aVar = new hh.a(this);
        obj19.V = aVar;
        hh.b bVar = new hh.b(this);
        obj19.W = bVar;
        obj19.X = -1;
        int i10 = 0;
        obj19.O.setTag(i10);
        Object obj9 = object3Arr3[0];
        obj19.T = (ConstraintLayout)obj9;
        obj9.setTag(i10);
        obj19.P.setTag(i10);
        obj19.Q.setTag(i10);
        N(view2);
        b bVar2 = new b(this, i12);
        obj19.U = bVar2;
        A();
    }

    private boolean W(x<String> x, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<String> x, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.gh
    public void A() {
        this.X = 16;
        I();
        return;
        synchronized (this) {
            this.X = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gh
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return X((x)object2, i3);
            }
            return W((x)object2, i3);
        }
        return Y((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.gh
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((d)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gh
    public void V(d d) {
        this.S = d;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = d;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gh
    public final void b(int i, View view2) {
        int obj2;
        final d obj1 = this.S;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.m();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gh
    protected void m() {
        d dVar;
        int value;
        int cmp;
        x cmp4;
        Object value2;
        int i;
        int cmp2;
        Object value3;
        int i2;
        int cmp3;
        int cmp7;
        int cmp6;
        int cmp5;
        int i3;
        final Object obj = this;
        long l = obj.X;
        final int i5 = 0;
        obj.X = i5;
        dVar = obj.S;
        i = 0;
        final int i10 = 28;
        final int i14 = 26;
        final int i15 = 0;
        synchronized (this) {
            obj = this;
            l = obj.X;
            i5 = 0;
            obj.X = i5;
            dVar = obj.S;
            i = 0;
            i10 = 28;
            i14 = 26;
            i15 = 0;
        }
        if (Long.compare(i16, i5) != 0) {
            if (dVar != null) {
                try {
                    cmp4 = dVar.k();
                    cmp4 = i15;
                    obj.Q(i, cmp4);
                    if (cmp4 != null) {
                    } else {
                    }
                    value2 = cmp4.getValue();
                    value2 = i15;
                }
                value3 = i15;
                if (Long.compare(i3, i5) != 0) {
                    if (dVar != null) {
                        dVar = dVar.j();
                    } else {
                        dVar = i15;
                    }
                    obj.Q(2, dVar);
                    if (dVar != 0) {
                        value = dVar.getValue();
                    } else {
                        value = i15;
                    }
                } else {
                }
                if (Long.compare(i13, i5) != 0) {
                    g.c(obj.O, value3);
                }
                if (Long.compare(i12, i5) != 0) {
                    g.e(obj.O, i15, i15, i15, obj.V);
                    g.e(obj.P, i15, i15, i15, obj.W);
                    m.q(obj.P, 6, i);
                    obj.Q.setOnClickListener(obj.U);
                }
                if (Long.compare(i8, i5) != 0) {
                    n.x0(obj.T, value);
                    n.Z(obj.Q, value);
                }
                if (Long.compare(i4, i5) != 0) {
                    g.c(obj.P, value2);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.gh
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
