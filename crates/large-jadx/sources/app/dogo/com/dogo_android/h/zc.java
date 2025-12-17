package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.c;
import app.dogo.com.dogo_android.exam.i;
import app.dogo.com.dogo_android.exam.j.i;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class zc extends app.dogo.com.dogo_android.h.yc {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final ConstraintLayout a0;
    private long b0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zc.d0 = sparseIntArray;
        sparseIntArray.put(2131362193, 5);
        sparseIntArray.put(2131363514, 6);
        sparseIntArray.put(2131363516, 7);
        sparseIntArray.put(2131363513, 8);
        sparseIntArray.put(2131363135, 9);
        sparseIntArray.put(2131363512, 10);
    }

    public zc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, zc.c0, zc.d0));
    }

    private zc(e e, View view2, Object[] object3Arr3) {
        final Object obj24 = this;
        super(e, view2, 1, (ImageButton)object3Arr3[5], (FrameLayout)object3Arr3[4], (MaterialButton)object3Arr3[9], (FrameLayout)object3Arr3[1], (Button)object3Arr3[10], (ImageView)object3Arr3[8], (ProgressBar)object3Arr3[6], (LinearLayout)object3Arr3[3], (AppCompatTextView)object3Arr3[7], (TextureView)object3Arr3[2]);
        obj24.b0 = -1;
        int i13 = 0;
        obj24.P.setTag(i13);
        Object obj12 = object3Arr3[0];
        obj24.a0 = (ConstraintLayout)obj12;
        obj12.setTag(i13);
        obj24.R.setTag(i13);
        obj24.V.setTag(i13);
        obj24.X.setTag(i13);
        N(view2);
        A();
    }

    private boolean V(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public void A() {
        this.b0 = 8;
        I();
        return;
        synchronized (this) {
            this.b0 = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yc
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return V((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            W((i)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                X((i)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public void W(i i) {
        this.Z = i;
        this.b0 = l |= i3;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Z = i;
            this.b0 = l |= i3;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public void X(i i) {
        this.Y = i;
        this.b0 = l |= i3;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Y = i;
            this.b0 = l |= i3;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yc
    protected void m() {
        int cmp;
        int value;
        i iVar;
        int cmp2;
        int i;
        androidx.appcompat.widget.AppCompatTextView view;
        android.widget.ImageView view2;
        long l = this.b0;
        final int i3 = 0;
        this.b0 = i3;
        iVar = this.Y;
        cmp2 = Long.compare(i7, i3);
        final int i8 = 0;
        synchronized (this) {
            l = this.b0;
            i3 = 0;
            this.b0 = i3;
            iVar = this.Y;
            cmp2 = Long.compare(i7, i3);
            i8 = 0;
        }
        try {
            if (iVar != null) {
            } else {
            }
            iVar = iVar.m();
            iVar = i8;
            Q(0, iVar);
            if (iVar != 0) {
            } else {
            }
            value = iVar.getValue();
            value = i8;
        }
        c.e(this.P, value, this.Q, this.S);
        c.b(this.V, value, this.U, this.W, this.T);
        if (Long.compare(i2, i3) != 0) {
            n.k0(this.R, i8);
        }
        if (Long.compare(i5, i3) != 0) {
            c.a(this.X, this.Z);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yc
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
