package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.b0.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class l extends app.dogo.com.dogo_android.h.k {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l.T = sparseIntArray;
        sparseIntArray.put(2131363001, 2);
    }

    public l(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, l.S, l.T));
    }

    private l(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (ProgressBar)object3Arr3[2], (TextView)object3Arr3[1]);
        this.R = -1;
        Object obj8 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        N(view2);
        A();
    }

    private boolean U(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.R = obj3 |= i;
            return 1;
            synchronized (this) {
                this.R = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean V(x<y<b0.a>> x, int i2) {
        if (i2 == 0) {
            this.R = obj3 |= i;
            return 1;
            synchronized (this) {
                this.R = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.k
    public void A() {
        this.R = 8;
        I();
        return;
        synchronized (this) {
            this.R = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return V((x)object2, i3);
        }
        return U((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.k
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            T((b0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.k
    public void T(b0 b0) {
        this.P = b0;
        this.R = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.P = b0;
            this.R = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k
    protected void m() {
        int cmp;
        int value2;
        int i2;
        int i;
        int value;
        int i3;
        long l = this.R;
        final int i5 = 0;
        this.R = i5;
        value2 = this.P;
        int cmp2 = Long.compare(i7, i5);
        i2 = 0;
        synchronized (this) {
            l = this.R;
            i5 = 0;
            this.R = i5;
            value2 = this.P;
            cmp2 = Long.compare(i7, i5);
            i2 = 0;
        }
        try {
            if (value2 != null) {
            } else {
            }
            i = value2.p();
            value2 = value2.q();
            i = value2;
            Q(0, i);
            Q(1, value2);
            if (i != 0) {
            } else {
            }
            value = i.getValue();
            value = i2;
        }
        i2 = value2;
        if (Long.compare(i4, i5) != 0) {
            n.z0(this.Q, i2);
        }
        if (cmp2 != 0) {
            n.A0(this.O, i2, value);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k
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
