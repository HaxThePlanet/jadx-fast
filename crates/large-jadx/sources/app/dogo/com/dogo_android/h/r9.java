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
import app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class r9 extends app.dogo.com.dogo_android.h.q9 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout S;
    private g T;
    private long U;

    class a implements g {

        final app.dogo.com.dogo_android.h.r9 a;
        a(app.dogo.com.dogo_android.h.r9 r9) {
            this.a = r9;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object codeInput;
            int i;
            int i2;
            codeInput = r9Var2.R;
            final int i3 = 0;
            i2 = codeInput != null ? i : i3;
            if (i2 != 0) {
                codeInput = codeInput.getCodeInput();
                if (codeInput != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    codeInput.setValue(g.a(r9Var.P));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r9.W = sparseIntArray;
        sparseIntArray.put(2131363423, 3);
        sparseIntArray.put(2131362105, 4);
    }

    public r9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, r9.V, r9.W));
    }

    private r9(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (Button)object3Arr3[4], (AppCompatEditText)object3Arr3[1], (Button)object3Arr3[2], (TextView)object3Arr3[3]);
        r9.a obj10 = new r9.a(this);
        this.T = obj10;
        this.U = -1;
        int i6 = 0;
        this.P.setTag(i6);
        obj10 = object3Arr3[0];
        this.S = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.Q.setTag(i6);
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

    private boolean X(LiveData<y<Boolean>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.q9
    public void A() {
        this.U = 8;
        I();
        return;
        synchronized (this) {
            this.U = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q9
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return W((x)object2, i3);
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.q9
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((RedeemCodeViewModel)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.q9
    public void V(RedeemCodeViewModel redeemCodeViewModel) {
        this.R = redeemCodeViewModel;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = redeemCodeViewModel;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q9
    protected void m() {
        int cmp3;
        RedeemCodeViewModel codeInput;
        int value2;
        int cmp;
        int result;
        int value;
        int cmp2;
        int i2;
        int i;
        int cmp4;
        long l = this.U;
        final int i4 = 0;
        this.U = i4;
        codeInput = this.R;
        final int i7 = 13;
        int i8 = 14;
        final int i11 = 0;
        synchronized (this) {
            l = this.U;
            i4 = 0;
            this.U = i4;
            codeInput = this.R;
            i7 = 13;
            i8 = 14;
            i11 = 0;
        }
        try {
            if (Long.compare(i, i4) != 0) {
            } else {
            }
            if (codeInput != null) {
            } else {
            }
            result = codeInput.getResult();
            result = i11;
            Q(0, result);
            if (result != null) {
            } else {
            }
            value = result.getValue();
            value = i11;
        }
        if (Long.compare(i12, i4) != 0) {
            if (codeInput != null) {
                codeInput = codeInput.getCodeInput();
            } else {
                codeInput = i11;
            }
            Q(1, codeInput);
            if (codeInput != 0) {
                value2 = codeInput.getValue();
            } else {
                value2 = i11;
            }
        } else {
        }
        if (Long.compare(i9, i4) != 0) {
            g.c(this.P, value2);
        }
        if (Long.compare(i2, i4) != 0) {
            g.e(this.P, i11, i11, i11, this.T);
        }
        if (Long.compare(i3, i4) != 0) {
            n.x0(this.S, value);
            n.Z(this.Q, value);
        }
    }

    @Override // app.dogo.com.dogo_android.h.q9
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
