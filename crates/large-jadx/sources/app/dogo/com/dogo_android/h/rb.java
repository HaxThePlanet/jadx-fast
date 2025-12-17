package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
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
import app.dogo.com.dogo_android.dogcreation.m.e;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class rb extends app.dogo.com.dogo_android.h.qb {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout S;
    private g T;
    private long U;

    class a implements g {

        final app.dogo.com.dogo_android.h.rb a;
        a(app.dogo.com.dogo_android.h.rb rb) {
            this.a = rb;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object eVar;
            int i;
            int i2;
            eVar = rbVar2.R;
            final int i3 = 0;
            i2 = eVar != null ? i : i3;
            if (i2 != 0) {
                eVar = eVar.p();
                if (eVar != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    eVar.setValue(g.a(rbVar.O));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        rb.W = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
        sparseIntArray.put(2131363414, 4);
    }

    public rb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, rb.V, rb.W));
    }

    private rb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (EditText)object3Arr3[1], (Button)object3Arr3[2], (TextView)object3Arr3[4], (MaterialToolbar)object3Arr3[3]);
        rb.a obj10 = new rb.a(this);
        this.T = obj10;
        this.U = -1;
        int i6 = 0;
        this.O.setTag(i6);
        obj10 = object3Arr3[0];
        this.S = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.P.setTag(i6);
        N(view2);
        A();
    }

    private boolean W(x<String> x, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(x<y<DogProfile>> x, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.qb
    public void A() {
        this.U = 8;
        I();
        return;
        synchronized (this) {
            this.U = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return W((x)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qb
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((e)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qb
    public void V(e e) {
        this.R = e;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = e;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qb
    protected void m() {
        int cmp5;
        e eVar;
        int value2;
        int cmp2;
        int cmp3;
        int value;
        int cmp;
        int i2;
        int i;
        int cmp4;
        long l = this.U;
        final int i4 = 0;
        this.U = i4;
        eVar = this.R;
        final int i7 = 13;
        int i8 = 14;
        final int i11 = 0;
        synchronized (this) {
            l = this.U;
            i4 = 0;
            this.U = i4;
            eVar = this.R;
            i7 = 13;
            i8 = 14;
            i11 = 0;
        }
        try {
            if (Long.compare(i, i4) != 0) {
            } else {
            }
            if (eVar != null) {
            } else {
            }
            cmp3 = eVar.q();
            cmp3 = i11;
            Q(0, cmp3);
            if (cmp3 != null) {
            } else {
            }
            value = cmp3.getValue();
            value = i11;
        }
        if (Long.compare(i12, i4) != 0) {
            if (eVar != null) {
                eVar = eVar.p();
            } else {
                eVar = i11;
            }
            Q(1, eVar);
            if (eVar != 0) {
                value2 = eVar.getValue();
            } else {
                value2 = i11;
            }
        } else {
        }
        if (Long.compare(i9, i4) != 0) {
            g.c(this.O, value2);
        }
        if (Long.compare(i2, i4) != 0) {
            g.e(this.O, i11, i11, i11, this.T);
        }
        if (Long.compare(i3, i4) != 0) {
            n.x0(this.S, value);
            n.Z(this.P, value);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qb
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
