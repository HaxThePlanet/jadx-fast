package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class he extends app.dogo.com.dogo_android.h.ge {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final ConstraintLayout X;
    private long Y;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        he.a0 = sparseIntArray;
        sparseIntArray.put(2131361912, 8);
    }

    public he(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, he.Z, he.a0));
    }

    private he(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        super(e, view2, 1, (TextView)object3Arr3[8], (Button)object3Arr3[4], (Button)object3Arr3[3], (Button)object3Arr3[1], (Button)object3Arr3[2], (TextView)object3Arr3[6], (TextView)object3Arr3[7], (TextView)object3Arr3[5]);
        obj20.Y = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        obj20.P.setTag(i11);
        obj20.Q.setTag(i11);
        obj20.R.setTag(i11);
        Object obj10 = object3Arr3[0];
        obj20.X = (ConstraintLayout)obj10;
        obj10.setTag(i11);
        obj20.S.setTag(i11);
        obj20.T.setTag(i11);
        obj20.U.setTag(i11);
        View view5 = view2;
        N(view2);
        A();
    }

    private boolean X(x<Boolean> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ge
    public void A() {
        this.Y = 8;
        I();
        return;
        synchronized (this) {
            this.Y = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ge
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ge
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((c0)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((b0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ge
    public void V(c0 c0) {
        this.W = c0;
        this.Y = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = c0;
            this.Y = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ge
    public void W(b0 b0) {
        this.V = b0;
        this.Y = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.V = b0;
            this.Y = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ge
    protected void m() {
        long l;
        int cmp3;
        b0 value;
        int cmp;
        int cmp2;
        int i;
        int i5;
        int i2;
        app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation dogOwnerInvitation;
        int i3;
        int i4;
        final Object obj = this;
        l = obj.Y;
        final int i7 = 0;
        obj.Y = i7;
        value = obj.V;
        final int i11 = 13;
        final int i13 = 12;
        i5 = 0;
        i2 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i7 = 0;
            obj.Y = i7;
            value = obj.V;
            i11 = 13;
            i13 = 12;
            i5 = 0;
            i2 = 0;
        }
        int cmp5 = Long.compare(i14, i7);
        if (cmp5 != 0) {
            if (value != null) {
                try {
                    dogOwnerInvitation = value.k();
                    dogOwnerInvitation = i5;
                    if (dogOwnerInvitation != null) {
                    } else {
                    }
                    i3 = 1;
                    i3 = i2;
                }
                if (i3 != 0) {
                    i = i2;
                } else {
                    i = 8;
                }
            } else {
            }
        } else {
            dogOwnerInvitation = i5;
        }
        if (value != null) {
            value = value.j();
        } else {
            value = i5;
        }
        obj.Q(i2, value);
        if (value != null) {
            i5 = value;
        }
        i2 = ViewDataBinding.K(i5);
        i5 = dogOwnerInvitation;
        if (Long.compare(i8, i7) != 0) {
            obj.O.setEnabled(i2);
            obj.P.setEnabled(i2);
            obj.Q.setEnabled(i2);
            obj.R.setEnabled(i2);
        }
        if (Long.compare(i9, i7) != 0) {
            o.u(obj.S, i5);
            obj.U.setVisibility(i);
        }
        if (Long.compare(i6, i7) != 0) {
            n.v0(obj.T, obj.W);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ge
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
