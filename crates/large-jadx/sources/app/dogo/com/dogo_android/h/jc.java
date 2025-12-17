package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.profile.invitation.g;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class jc extends app.dogo.com.dogo_android.h.ic implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final View.OnClickListener U;
    private final View.OnClickListener V;
    private long W;
    static {
    }

    public jc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, jc.X, jc.Y));
    }

    private jc(e e, View view2, Object[] object3Arr3) {
        int i4 = 1;
        final int i7 = 2;
        super(e, view2, 2, (Button)object3Arr3[3], (ConstraintLayout)object3Arr3[0], (Button)object3Arr3[4], (ImageView)object3Arr3[i4], (TextView)object3Arr3[i7]);
        this.W = -1;
        int obj14 = 0;
        this.O.setTag(obj14);
        this.P.setTag(obj14);
        this.Q.setTag(obj14);
        this.R.setTag(obj14);
        this.S.setTag(obj14);
        N(view2);
        b obj12 = new b(this, i4);
        this.U = obj12;
        obj12 = new b(this, i7);
        this.V = obj12;
        A();
    }

    private boolean W(LiveData<y<DogOwnerInvitation>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ic
    public void A() {
        this.W = 8;
        I();
        return;
        synchronized (this) {
            this.W = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ic
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((x)object2, i3);
        }
        return W((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ic
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((g)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ic
    public void V(g g) {
        this.T = g;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = g;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ic
    public final void b(int i, View view2) {
        int result;
        g obj3;
        int obj4;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                obj3 = this.T;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.s();
                }
            }
        } else {
            obj3 = this.T;
            result = obj3 != null ? i2 : obj4;
            result = obj3.getResult();
            if (result != null && result != null) {
                result = obj3.getResult();
                if (result != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.h((y)result.getValue());
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ic
    protected void m() {
        int cmp;
        View.OnClickListener list;
        int value2;
        int cmp3;
        int cmp2;
        int result;
        int value;
        int i;
        int i2;
        int cmp4;
        long l = this.W;
        final int i4 = 0;
        this.W = i4;
        value2 = this.T;
        int i8 = 13;
        int i10 = 14;
        i = 0;
        synchronized (this) {
            l = this.W;
            i4 = 0;
            this.W = i4;
            value2 = this.T;
            i8 = 13;
            i10 = 14;
            i = 0;
        }
        try {
            if (Long.compare(i2, i4) != 0) {
            } else {
            }
            if (value2 != null) {
            } else {
            }
            result = value2.getResult();
            result = i;
            Q(0, result);
            if (result != null) {
            } else {
            }
            value = result.getValue();
            value = i;
        }
        if (Long.compare(i12, i4) != 0) {
            if (value2 != null) {
                value2 = value2.n();
            } else {
                value2 = i;
            }
            Q(1, value2);
            if (value2 != null) {
                i = value2;
            }
        }
        if (Long.compare(i11, i4) != 0) {
            n.Z(this.O, i);
            n.x0(this.P, i);
        }
        if (Long.compare(i9, i4) != 0) {
            n.w0(this.O, value);
            n.w0(this.Q, value);
            o.t(this.R, value);
            o.v(this.S, value);
        }
        if (Long.compare(i3, i4) != 0) {
            this.O.setOnClickListener(this.U);
            this.Q.setOnClickListener(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ic
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
