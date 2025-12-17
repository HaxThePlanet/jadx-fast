package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
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
import app.dogo.com.dogo_android.d.e.e;

/* loaded from: classes.dex */
public class r8 extends app.dogo.com.dogo_android.h.q8 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout S;
    private g T;
    private long U;

    class a implements g {

        final app.dogo.com.dogo_android.h.r8 a;
        a(app.dogo.com.dogo_android.h.r8 r8) {
            this.a = r8;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object codeInput;
            int i2;
            int i;
            codeInput = r8Var2.R;
            final int i3 = 0;
            i = codeInput != null ? i2 : i3;
            if (i != 0) {
                codeInput = codeInput.getCodeInput();
                if (codeInput != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    codeInput.setValue(g.a(r8Var.P));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r8.W = sparseIntArray;
        sparseIntArray.put(2131363423, 2);
        sparseIntArray.put(2131362105, 3);
        sparseIntArray.put(2131362911, 4);
    }

    public r8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, r8.V, r8.W));
    }

    private r8(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (Button)object3Arr3[3], (AppCompatEditText)object3Arr3[1], (Button)object3Arr3[4], (TextView)object3Arr3[2]);
        r8.a obj10 = new r8.a(this);
        this.T = obj10;
        this.U = -1;
        int i6 = 0;
        this.P.setTag(i6);
        obj10 = object3Arr3[0];
        this.S = (ConstraintLayout)obj10;
        obj10.setTag(i6);
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

    @Override // app.dogo.com.dogo_android.h.q8
    public void A() {
        this.U = 4;
        I();
        return;
        synchronized (this) {
            this.U = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q8
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.q8
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

    @Override // app.dogo.com.dogo_android.h.q8
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

    @Override // app.dogo.com.dogo_android.h.q8
    protected void m() {
        int cmp;
        g gVar;
        int value;
        e codeInput;
        int cmp2;
        int i;
        long l = this.U;
        final int i3 = 0;
        this.U = i3;
        codeInput = this.R;
        cmp2 = Long.compare(i6, i3);
        final int i7 = 0;
        synchronized (this) {
            l = this.U;
            i3 = 0;
            this.U = i3;
            codeInput = this.R;
            cmp2 = Long.compare(i6, i3);
            i7 = 0;
        }
        try {
            if (codeInput != null) {
            } else {
            }
            codeInput = codeInput.getCodeInput();
            codeInput = i7;
            Q(0, codeInput);
            if (codeInput != 0) {
            } else {
            }
            value = codeInput.getValue();
            value = i7;
        }
        g.c(this.P, value);
        if (Long.compare(i2, i3) != 0) {
            g.e(this.P, i7, i7, i7, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.q8
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
