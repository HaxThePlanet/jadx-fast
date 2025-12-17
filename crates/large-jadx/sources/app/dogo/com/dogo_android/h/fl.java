package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class fl extends app.dogo.com.dogo_android.h.el {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = null;
    private final ConstraintLayout S;
    private long T;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(5);
        fl.U = gVar;
        String str = "layout_library_shortcut";
        int i5 = 4;
        final int[] iArr2 = new int[i5];
        iArr2 = new int[]{1, 2, 3, 4};
        int[] iArr = new int[i5];
        iArr = new int[]{2131558783, 2131558783, 2131558783, 2131558783};
        gVar.a(0, /* result */, iArr2, iArr);
        int i2 = 0;
    }

    public fl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, fl.U, fl.V));
    }

    private fl(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 4, (cl)object3Arr3[4], (cl)object3Arr3[3], (cl)object3Arr3[2], (cl)object3Arr3[1]);
        this.T = -1;
        L(this.O);
        L(this.P);
        L(this.Q);
        Object obj10 = object3Arr3[0];
        this.S = (ConstraintLayout)obj10;
        obj10.setTag(0);
        L(this.R);
        N(view2);
        A();
    }

    private boolean T(app.dogo.com.dogo_android.h.cl cl, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean U(app.dogo.com.dogo_android.h.cl cl, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean V(app.dogo.com.dogo_android.h.cl cl, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean W(app.dogo.com.dogo_android.h.cl cl, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.el
    public void A() {
        this.T = 16;
        this.R.A();
        this.Q.A();
        this.P.A();
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.T = 16;
            this.R.A();
            this.Q.A();
            this.P.A();
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.el
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return U((cl)object2, i3);
                }
                return V((cl)object2, i3);
            }
            return T((cl)object2, i3);
        }
        return W((cl)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.el
    public void M(q q) {
        super.M(q);
        this.R.M(q);
        this.Q.M(q);
        this.P.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.el
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.el
    protected void m() {
        int cmp;
        String string;
        int i2;
        int i;
        i2 = 0;
        this.T = i2;
        synchronized (this) {
            i2 = 0;
            this.T = i2;
        }
        try {
            this.O.T(a.d(w().getContext(), 2131230836));
            this.O.U(Boolean.FALSE);
            this.O.V(w().getResources().getString(2131886146));
            this.P.T(a.d(w().getContext(), 2131231059));
            Boolean tRUE = Boolean.TRUE;
            this.P.U(tRUE);
            this.P.V(w().getResources().getString(2131886727));
            this.Q.T(a.d(w().getContext(), 2131231101));
            this.Q.U(tRUE);
            this.Q.V(w().getResources().getString(2131886667));
            this.R.T(a.d(w().getContext(), 2131231172));
            this.R.U(tRUE);
            this.R.V(w().getResources().getString(2131887623));
            ViewDataBinding.o(this.R);
            ViewDataBinding.o(this.Q);
            ViewDataBinding.o(this.P);
            ViewDataBinding.o(this.O);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.el
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.O.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
