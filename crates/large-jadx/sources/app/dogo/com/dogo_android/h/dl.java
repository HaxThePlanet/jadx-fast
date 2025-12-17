package app.dogo.com.dogo_android.h;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.d;
import androidx.databinding.k.g;

/* loaded from: classes.dex */
public class dl extends app.dogo.com.dogo_android.h.cl {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final View U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        dl.X = sparseIntArray;
        sparseIntArray.put(2131362626, 4);
    }

    public dl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, dl.W, dl.X));
    }

    private dl(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (ImageView)object3Arr3[4], (AppCompatImageView)object3Arr3[1]);
        this.V = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        obj9 = object3Arr3[3];
        this.U = (View)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cl
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (80 == i) {
            T((Drawable)object2);
            obj2 = 1;
        } else {
            if (142 == i) {
                U((Boolean)object2);
            } else {
                if (152 == i) {
                    V((String)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public void T(Drawable drawable) {
        this.S = drawable;
        this.V = l |= i2;
        notifyPropertyChanged(80);
        super.I();
        return;
        synchronized (this) {
            this.S = drawable;
            this.V = l |= i2;
            notifyPropertyChanged(80);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public void U(Boolean boolean) {
        this.Q = boolean;
        this.V = l |= i2;
        notifyPropertyChanged(142);
        super.I();
        return;
        synchronized (this) {
            this.Q = boolean;
            this.V = l |= i2;
            notifyPropertyChanged(142);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cl
    public void V(String string) {
        this.R = string;
        this.V = l |= i2;
        notifyPropertyChanged(152);
        super.I();
        return;
        synchronized (this) {
            this.R = string;
            this.V = l |= i2;
            notifyPropertyChanged(152);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cl
    protected void m() {
        long l;
        int cmp;
        Boolean bool;
        int cmp2;
        int cmp3;
        int i2;
        int i;
        l = this.V;
        final int i4 = 0;
        this.V = i4;
        final int i7 = 10;
        int cmp4 = Long.compare(i8, i4);
        i2 = 0;
        synchronized (this) {
            l = this.V;
            i4 = 0;
            this.V = i4;
            i7 = 10;
            cmp4 = Long.compare(i8, i4);
            i2 = 0;
        }
        try {
            bool = ViewDataBinding.K(this.Q);
            if (cmp4 != 0) {
            }
            if (bool) {
            } else {
            }
            i = 32;
            i = 16;
            l |= i;
        }
        i2 = bool;
        if (Long.compare(i10, i4) != 0) {
            g.c(this.O, this.R);
        }
        if (Long.compare(i5, i4) != 0) {
            this.U.setVisibility(i2);
        }
        if (Long.compare(i3, i4) != 0) {
            d.a(this.P, this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cl
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
