package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class dj extends app.dogo.com.dogo_android.h.cj implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        dj.X = sparseIntArray;
        sparseIntArray.put(2131363414, 3);
        sparseIntArray.put(2131362322, 4);
    }

    public dj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, dj.W, dj.X));
    }

    private dj(e e, View view2, Object[] object3Arr3) {
        int i3 = 1;
        final int i7 = 2;
        super(e, view2, 0, (ImageView)object3Arr3[4], (MaterialCardView)object3Arr3[0], (ImageView)object3Arr3[i3], (Button)object3Arr3[i7], (TextView)object3Arr3[3]);
        this.V = -1;
        int obj14 = 0;
        this.O.setTag(obj14);
        this.P.setTag(obj14);
        this.Q.setTag(obj14);
        N(view2);
        b obj12 = new b(this, i3);
        this.T = obj12;
        obj12 = new b(this, i7);
        this.U = obj12;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            V((PottyProgramProgress)object2);
            obj2 = 1;
        } else {
            if (83 == i) {
                U((String)object2);
            } else {
                if (29 == i) {
                    T((a0)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public void T(a0 a0) {
        this.R = a0;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = a0;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public void U(String string) {
        this.S = string;
        this.V = l |= i2;
        notifyPropertyChanged(83);
        super.I();
        return;
        synchronized (this) {
            this.S = string;
            this.V = l |= i2;
            notifyPropertyChanged(83);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public void V(PottyProgramProgress pottyProgramProgress) {
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public final void b(int i, View view2) {
        int i2;
        a0 obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.R;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.B("read");
                }
            }
        } else {
            obj3 = this.R;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.B("potty_card");
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.cj
    protected void m() {
        int cmp;
        View.OnClickListener list;
        long l = this.V;
        final int i2 = 0;
        this.V = i2;
        synchronized (this) {
            l = this.V;
            i2 = 0;
            this.V = i2;
        }
        try {
            this.O.setOnClickListener(this.T);
            this.Q.setOnClickListener(this.U);
            if (Long.compare(i4, i2) != 0) {
            }
            n.w(this.P, this.S);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.cj
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
