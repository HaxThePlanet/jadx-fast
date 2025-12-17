package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.u.m.y.g;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class pg extends app.dogo.com.dogo_android.h.og {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final CoordinatorLayout X;
    private final ConstraintLayout Y;
    private final FrameLayout Z;
    private final app.dogo.com.dogo_android.h.ml a0;
    private long b0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(15);
        pg.c0 = gVar;
        int i6 = 1;
        int[] iArr2 = new int[i6];
        final int i15 = 0;
        iArr2[i15] = 9;
        int[] iArr4 = new int[i6];
        iArr4[i15] = 2131558740;
        gVar.a(i6, /* result */, iArr2, iArr4);
        int[] iArr3 = new int[i6];
        iArr3[i15] = 10;
        int[] iArr = new int[i6];
        iArr[i15] = 2131558788;
        gVar.a(8, /* result */, iArr3, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        pg.d0 = sparseIntArray;
        sparseIntArray.put(2131363435, 11);
        sparseIntArray.put(2131363278, 12);
        sparseIntArray.put(2131362389, 13);
        sparseIntArray.put(2131362136, 14);
    }

    public pg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 15, pg.c0, pg.d0));
    }

    private pg(e e, View view2, Object[] object3Arr3) {
        final Object obj29 = this;
        super(e, view2, 2, (TextView)object3Arr3[7], (ImageView)object3Arr3[14], (ImageView)object3Arr3[2], (TextView)object3Arr3[6], (Guideline)object3Arr3[13], (wh)object3Arr3[9], (MaterialButton)object3Arr3[3], (MaterialButton)object3Arr3[5], (Space)object3Arr3[4], (Guideline)object3Arr3[12], (MaterialToolbar)object3Arr3[11]);
        obj29.b0 = -1;
        int i17 = 0;
        obj29.O.setTag(i17);
        obj29.P.setTag(i17);
        obj29.Q.setTag(i17);
        Object obj13 = object3Arr3[0];
        obj29.X = (CoordinatorLayout)obj13;
        obj13.setTag(i17);
        Object obj14 = object3Arr3[1];
        obj29.Y = (ConstraintLayout)obj14;
        obj14.setTag(i17);
        Object obj15 = object3Arr3[8];
        obj29.Z = (FrameLayout)obj15;
        obj15.setTag(i17);
        Object obj16 = object3Arr3[10];
        obj29.a0 = (ml)obj16;
        obj29.L(obj16);
        obj29.L(obj29.R);
        obj29.S.setTag(i17);
        obj29.T.setTag(i17);
        obj29.U.setTag(i17);
        obj29.N(view2);
        A();
    }

    private boolean W(app.dogo.com.dogo_android.h.wh wh, int i2) {
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

    private boolean X(x<y<CertificateInfo>> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.og
    public void A() {
        this.b0 = 8;
        this.R.A();
        this.a0.A();
        I();
        return;
        synchronized (this) {
            this.b0 = 8;
            this.R.A();
            this.a0.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.og
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((x)object2, i3);
        }
        return W((wh)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.og
    public void M(q q) {
        super.M(q);
        this.R.M(q);
        this.a0.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.og
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

    @Override // app.dogo.com.dogo_android.h.og
    public void V(g g) {
        this.W = g;
        this.b0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.W = g;
            this.b0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.og
    protected void m() {
        int i4;
        int cmp2;
        long l;
        int i3;
        int string;
        int i5;
        Object[] arr;
        int certificateRequirements;
        int string2;
        int i6;
        int value;
        int i8;
        int i2;
        int i7;
        int dogName;
        Resources resources;
        int i9;
        int certificatePlaceholderUrl;
        int cmp;
        int certificateUnlocked;
        String programTitle;
        int i;
        final Object obj = this;
        l = obj.b0;
        int i13 = 0;
        obj.b0 = i13;
        g gVar = obj.W;
        int i21 = 16;
        int i25 = 32;
        final int i28 = 1;
        final int i29 = 0;
        i9 = 0;
        synchronized (this) {
            obj = this;
            l = obj.b0;
            i13 = 0;
            obj.b0 = i13;
            gVar = obj.W;
            i21 = 16;
            i25 = 32;
            i28 = 1;
            i29 = 0;
            i9 = 0;
        }
        if (gVar != null) {
            i8 = gVar.j();
            i4 = gVar.i();
        } else {
            try {
                i8 = i4;
                obj.Q(i28, i8);
                if (i8 != 0) {
                } else {
                }
                value = i8.getValue();
                value = i9;
                if (i4 != 0) {
                } else {
                }
                certificatePlaceholderUrl = i4.getCertificatePlaceholderUrl();
                certificatePlaceholderUrl = i9;
            }
            cmp = Long.compare(i30, i13);
            if (cmp != 0) {
                if (i4 != 0) {
                    certificateUnlocked = i4.isCertificateUnlocked();
                    programTitle = i4.getProgramTitle();
                } else {
                    certificateUnlocked = i29;
                    programTitle = i9;
                }
                if (cmp != 0) {
                    if (certificateUnlocked) {
                        i12 |= i32;
                        i = 512;
                    } else {
                        i11 |= i31;
                        i = 256;
                    }
                    i3 |= i;
                }
                i = certificateUnlocked ? i29 : cmp;
                if (certificateUnlocked) {
                } else {
                    cmp = i29;
                }
                Object[] arr2 = new Object[i28];
                arr2[i29] = programTitle;
                string2 = obj.Q.getResources().getString(2131887132, arr2);
                i6 = certificatePlaceholderUrl;
                i2 = cmp;
                i7 = i;
            } else {
                certificateUnlocked = i7;
                string2 = i9;
                i6 = certificatePlaceholderUrl;
            }
            if (Long.compare(i26, i13) != 0) {
                if (i4 != 0) {
                    dogName = i4.getDogName();
                } else {
                    dogName = i9;
                }
                arr = new Object[i28];
                arr[i29] = dogName;
                string = obj.O.getResources().getString(2131886257, arr);
            } else {
                string = i9;
            }
            int i27 = 0;
            if (Long.compare(i22, i27) != 0 && i4 != 0) {
                if (i4 != 0) {
                    certificateRequirements = i4.getCertificateRequirements();
                } else {
                    certificateRequirements = i9;
                }
            } else {
            }
            int cmp5 = Long.compare(i24, i27);
            if (cmp5 != 0) {
                i9 = certificateUnlocked != 0 ? string : certificateRequirements;
            }
            if (cmp5 != 0) {
                g.c(obj.O, i9);
                g.c(obj.Q, string2);
                obj.R.w().setVisibility(i2);
                obj.R.T(i4);
                obj.S.setVisibility(i7);
                obj.T.setVisibility(i7);
                obj.U.setVisibility(i7);
            }
            if (Long.compare(i10, i15) != 0) {
                l.t(obj.P, value, i6);
                n.D0(obj.Z, value);
            }
            ViewDataBinding.o(obj.R);
            ViewDataBinding.o(obj.a0);
        }
    }

    @Override // app.dogo.com.dogo_android.h.og
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                if (this.a0.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
