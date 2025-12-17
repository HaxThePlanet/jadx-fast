package app.dogo.com.dogo_android.h;

import android.net.Uri;
import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.c;
import app.dogo.com.dogo_android.exam.g;
import app.dogo.com.dogo_android.exam.k.h;
import app.dogo.com.dogo_android.exam.k.k;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import f.d.a.a;

/* loaded from: classes.dex */
public class bd extends app.dogo.com.dogo_android.h.ad {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final FrameLayout X;
    private long Y;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bd.a0 = sparseIntArray;
        sparseIntArray.put(2131362193, 7);
        sparseIntArray.put(2131363039, 8);
    }

    public bd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, bd.Z, bd.a0));
    }

    private bd(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        super(e, view2, 2, (TextureView)object3Arr3[2], (ImageButton)object3Arr3[7], (AppCompatTextView)object3Arr3[4], (VideoRecordingButton)object3Arr3[6], (ProgressBar)object3Arr3[8], (ConstraintLayout)object3Arr3[0], (FrameLayout)object3Arr3[1], (ImageButton)object3Arr3[3]);
        obj20.Y = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        obj20.Q.setTag(i11);
        Object obj10 = object3Arr3[5];
        obj20.X = (FrameLayout)obj10;
        obj10.setTag(i11);
        obj20.R.setTag(i11);
        obj20.S.setTag(i11);
        obj20.T.setTag(i11);
        obj20.U.setTag(i11);
        View view4 = view2;
        N(view2);
        A();
    }

    private boolean V(a<y<Uri>> a, int i2) {
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

    private boolean W(x<Boolean> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ad
    public void A() {
        this.Y = 16;
        I();
        return;
        synchronized (this) {
            this.Y = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ad
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return W((x)object2, i3);
        }
        return V((a)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ad
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            X((h)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                Y((k)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ad
    public void X(h h) {
        this.W = h;
        this.Y = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = h;
            this.Y = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ad
    public void Y(k k) {
        this.V = k;
        this.Y = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.V = k;
            this.Y = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ad
    protected void m() {
        int cmp2;
        long l;
        int i4;
        boolean z;
        int cmp3;
        int cmp8;
        int cmp7;
        int cmp;
        int i6;
        int valueOf;
        int i;
        Object value;
        int i5;
        int value2;
        int cmp4;
        int cmp5;
        int i7;
        int i3;
        int cmp6;
        x xVar;
        int i2;
        final Object obj = this;
        l = obj.Y;
        final int i8 = 0;
        obj.Y = i8;
        h hVar = obj.W;
        k kVar = obj.V;
        int i19 = 24;
        final int i21 = 25;
        int i22 = 256;
        final int i27 = 26;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i8 = 0;
            obj.Y = i8;
            hVar = obj.W;
            kVar = obj.V;
            i19 = 24;
            i21 = 25;
            i22 = 256;
            i27 = 26;
        }
        if (Long.compare(i16, i8) != 0) {
            if (kVar != null) {
                try {
                    cmp4 = kVar.k();
                    cmp4 = 0;
                    if (Long.compare(i28, i8) != 0 && cmp4 != 0) {
                    } else {
                    }
                    if (cmp4 != 0) {
                    } else {
                    }
                    i7 = cmp4.d();
                    i7 = 0;
                }
                i3 = cmp4.b();
            } else {
            }
        } else {
            i3 = i8;
            i7 = 0;
        }
        if (Long.compare(i29, i8) != 0) {
            if (kVar != null) {
                cmp5 = kVar.l();
            } else {
                cmp5 = 0;
            }
            obj.Q(0, cmp5);
            if (cmp5 != 0) {
                value2 = cmp5.getValue();
            } else {
                value2 = 0;
            }
        } else {
        }
        cmp6 = Long.compare(i30, i8);
        if (cmp6 != 0) {
            if (kVar != null) {
                i = xVar;
            } else {
                i = 0;
            }
            int i15 = 1;
            obj.Q(i15, i);
            if (i != 0) {
                value = i.getValue();
            } else {
                value = 0;
            }
            boolean z2 = ViewDataBinding.K(value);
            if (cmp6 != 0) {
                i2 = z2 ? 64 : 32;
                l |= i2;
            }
            cmp6 = z2 ? 4 : 0;
            if (Long.compare(i2, i8) != 0) {
                l = z2 ^= i15 != 0 ? l | i22 : l | i2;
            }
            i5 = cmp6;
        } else {
            i6 = 0;
            i5 = 0;
        }
        if (Long.compare(i23, i8) != 0 && kVar != null) {
            if (kVar != null) {
                z = kVar.q();
            } else {
                z = 0;
            }
        } else {
        }
        int cmp13 = Long.compare(i24, i8);
        if (cmp13 != 0 && i6 != 0) {
            valueOf = i6 != 0 ? z : 0;
        } else {
        }
        if (Long.compare(i26, i8) != 0) {
            c.a(obj.O, hVar);
        }
        if (Long.compare(i20, i8) != 0) {
            g.c(obj.Q, i7);
        }
        if (cmp13 != 0) {
            obj.Q.setVisibility(i5);
            n.J0(obj.U, Boolean.valueOf(valueOf));
        }
        if (Long.compare(i9, i8) != 0) {
            n.D0(obj.X, value2);
        }
        if (Long.compare(i11, i8) != 0) {
            c.c(obj.R, Long.valueOf(i3), hVar);
        }
        if (Long.compare(i4, i8) != 0) {
            n.k0(obj.T, 0);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ad
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
