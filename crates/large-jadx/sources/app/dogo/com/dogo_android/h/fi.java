package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.k0.e;
import app.dogo.com.dogo_android.view.dailytraining.l;

/* loaded from: classes.dex */
public class fi extends app.dogo.com.dogo_android.h.ei {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0;
    private long a0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fi.c0 = sparseIntArray;
        sparseIntArray.put(2131362256, 5);
        sparseIntArray.put(2131362346, 6);
        sparseIntArray.put(2131362359, 7);
        sparseIntArray.put(2131362347, 8);
        sparseIntArray.put(2131362183, 9);
        sparseIntArray.put(2131362231, 10);
    }

    public fi(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, fi.b0, fi.c0));
    }

    private fi(e e, View view2, Object[] object3Arr3) {
        final Object obj25 = this;
        super(e, view2, 2, (FrameLayout)object3Arr3[3], (TextView)object3Arr3[4], (ImageView)object3Arr3[9], (ImageView)object3Arr3[1], (ImageView)object3Arr3[10], (ImageView)object3Arr3[5], (TextView)object3Arr3[6], (View)object3Arr3[8], (ConstraintLayout)object3Arr3[0], (ImageView)object3Arr3[7], (ImageView)object3Arr3[2]);
        obj25.a0 = -1;
        int i13 = 0;
        obj25.O.setTag(i13);
        obj25.P.setTag(i13);
        obj25.R.setTag(i13);
        obj25.W.setTag(i13);
        obj25.X.setTag(i13);
        obj25.N(view2);
        A();
    }

    private boolean V(v<y<DogProfile>> v, int i2) {
        if (i2 == 0) {
            this.a0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.a0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean W(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.a0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.a0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public void A() {
        this.a0 = 16;
        I();
        return;
        synchronized (this) {
            this.a0 = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ei
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return V((v)object2, i3);
        }
        return W((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            T((e)object2);
            obj2 = 1;
        } else {
            if (141 == i) {
                U((l)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public void T(e e) {
        this.Z = e;
        this.a0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Z = e;
            this.a0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ei
    public void U(l l) {
        this.Y = l;
        this.a0 = l2 |= i2;
        notifyPropertyChanged(141);
        super.I();
        return;
        synchronized (this) {
            this.Y = l;
            this.a0 = l2 |= i2;
            notifyPropertyChanged(141);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ei
    protected void m() {
        l cmp;
        int i10;
        int cmp3;
        long l;
        int i3;
        int i11;
        int i7;
        int cmp5;
        int i12;
        TextView view;
        int i2;
        int value;
        int i13;
        View view2;
        int i14;
        int cmp4;
        int string;
        int i;
        Object value2;
        int i9;
        int i4;
        int i15;
        int i16;
        int i5;
        int i8;
        boolean z;
        int i6;
        int cmp2;
        final Object obj = this;
        l = obj.a0;
        final int i18 = 0;
        obj.a0 = i18;
        cmp = obj.Y;
        int i21 = 256;
        i13 = 128;
        int i24 = 1024;
        final int i25 = 25;
        final int i26 = 24;
        i4 = 0;
        value = 0;
        synchronized (this) {
            obj = this;
            l = obj.a0;
            i18 = 0;
            obj.a0 = i18;
            cmp = obj.Y;
            i21 = 256;
            i13 = 128;
            i24 = 1024;
            i25 = 25;
            i26 = 24;
            i4 = 0;
            value = 0;
        }
        int cmp9 = Long.compare(i27, i18);
        i14 = 1;
        if (cmp9 != 0) {
            if (cmp != null) {
                try {
                    i = cmp.J();
                    i = i4;
                    obj.Q(value, i);
                    if (i != 0) {
                    } else {
                    }
                    value2 = i.getValue();
                    value2 = i4;
                    int i23 = ViewDataBinding.J(value2);
                    i5 = i14;
                }
                i5 = value;
                string = Integer.toString(i23);
                if (cmp9 != 0) {
                    l = i5 != 0 ? l | i24 : l | i8;
                }
            } else {
            }
        } else {
            i5 = value;
            string = i4;
        }
        int cmp10 = Long.compare(i28, i18);
        if (cmp10 != 0) {
            if (cmp != null) {
                z = cmp.N();
                i6 = cmp.b0();
            } else {
                i6 = z;
            }
            if (cmp10 != 0) {
                cmp2 = z ? 64 : 32;
                l |= cmp2;
            }
            if (Long.compare(cmp2, i18) != 0) {
                l = i6 ? l | i21 : l | i13;
            }
            i3 = z ? value : 8;
            i8 = i6 ? value : 8;
        } else {
            i6 = i8;
        }
        if (Long.compare(i29, i18) != 0) {
            if (cmp != null) {
                value = cmp2;
            } else {
                value = i4;
            }
            obj.Q(i14, value);
            if (value != null) {
                i4 = value;
            }
        }
        i2 = i8;
        if (Long.compare(i9, i18) != 0 && cmp != null) {
            if (cmp != null) {
                i6 = cmp.b0();
            }
            if (Long.compare(i9, i18) != 0) {
                l = i6 != 0 ? l | i21 : l | i13;
            }
        }
        int cmp6 = Long.compare(i7, i18);
        if (cmp6 != 0) {
            if (i5 != 0) {
            } else {
                i6 = 0;
            }
            if (cmp6 != 0) {
                i7 = i6 != 0 ? 4096 : 2048;
                l |= i7;
            }
            i15 = i6 != 0 ? 0 : 8;
            i10 = i15;
        } else {
            i10 = 0;
        }
        if (Long.compare(i22, i18) != 0) {
            obj.O.setVisibility(i10);
            g.c(obj.P, string);
        }
        if (Long.compare(i12, i18) != 0) {
            obj.R.setVisibility(i3);
            obj.X.setVisibility(i2);
        }
        if (Long.compare(i17, i18) != 0) {
            o.J(obj.W, i4, obj.U, obj.T, obj.Z, obj.Q, obj.V, obj.X, obj.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ei
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
