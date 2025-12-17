package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.n.j;

/* loaded from: classes.dex */
public class da extends app.dogo.com.dogo_android.h.ca {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final CoordinatorLayout Z;
    private final ConstraintLayout a0;
    private long b0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(15);
        da.c0 = gVar;
        int i6 = 1;
        final int[] iArr = new int[i6];
        final int i12 = 0;
        iArr[i12] = 10;
        int[] iArr2 = new int[i6];
        iArr2[i12] = 2131558630;
        gVar.a(i6, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        da.d0 = sparseIntArray;
        sparseIntArray.put(2131363435, 11);
        sparseIntArray.put(2131363278, 12);
        sparseIntArray.put(2131362389, 13);
        sparseIntArray.put(2131362136, 14);
    }

    public da(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 15, da.c0, da.d0));
    }

    private da(e e, View view2, Object[] object3Arr3) {
        Object obj6 = this;
        super(e, view2, 2, (TextView)object3Arr3[9], (ImageView)object3Arr3[14], (ImageView)object3Arr3[2], (TextView)object3Arr3[8], (Guideline)object3Arr3[13], (ea)object3Arr3[10], (ProgressBar)object3Arr3[4], (TextView)object3Arr3[3], (MaterialButton)object3Arr3[5], (MaterialButton)object3Arr3[7], (Space)object3Arr3[6], (Guideline)object3Arr3[12], (Toolbar)object3Arr3[11]);
        Object obj5 = this;
        obj5.b0 = -1;
        int i4 = 0;
        obj5.O.setTag(i4);
        obj5.P.setTag(i4);
        obj5.Q.setTag(i4);
        obj5.L(obj5.R);
        Object obj2 = object3Arr3[0];
        obj5.Z = (CoordinatorLayout)obj2;
        obj2.setTag(i4);
        Object obj3 = object3Arr3[1];
        obj5.a0 = (ConstraintLayout)obj3;
        obj3.setTag(i4);
        obj5.S.setTag(i4);
        obj5.T.setTag(i4);
        obj5.U.setTag(i4);
        obj5.V.setTag(i4);
        obj5.W.setTag(i4);
        obj5.N(view2);
        A();
    }

    private boolean Y(app.dogo.com.dogo_android.h.ea ea, int i2) {
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

    private boolean Z(LiveData<y<CertificateInfo>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ca
    public void A() {
        this.b0 = 16;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.b0 = 16;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ca
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Z((LiveData)object2, i3);
        }
        return Y((ea)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (141 == i) {
            W((l)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                X((j)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public void W(l l) {
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public void X(j j) {
        this.Y = j;
        this.b0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Y = j;
            this.b0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ca
    protected void m() {
        Object jVar;
        int cmp2;
        long l;
        int i10;
        String string2;
        int i;
        int i13;
        int cmp;
        int i8;
        int value;
        int allExamsCount;
        String string3;
        int i5;
        String string;
        int i9;
        int certificateRequirements;
        String dogName;
        Object[] arr;
        int i14;
        String certificatePlaceholderUrl;
        Object[] arr2;
        int i2;
        int i4;
        int i7;
        int i3;
        int i12;
        int i11;
        LiveData result;
        int programName;
        int passedExamsCount;
        int i6;
        int i15;
        final Object obj = this;
        l = obj.b0;
        int i17 = 0;
        obj.b0 = i17;
        jVar = obj.Y;
        int i23 = 32;
        arr = 1;
        i14 = 24;
        final int i29 = 0;
        i4 = 0;
        synchronized (this) {
            obj = this;
            l = obj.b0;
            i17 = 0;
            obj.b0 = i17;
            jVar = obj.Y;
            i23 = 32;
            arr = 1;
            i14 = 24;
            i29 = 0;
            i4 = 0;
        }
        int cmp5 = Long.compare(i7, i17);
        if (cmp5 != 0) {
            if (jVar != null) {
                try {
                    i7 = jVar.p();
                    i12 = jVar.p();
                    i12 = i7;
                    if (cmp5 != 0) {
                    }
                    if (i7 != 0) {
                    } else {
                    }
                    l |= i31;
                    i11 = 1024;
                    l |= i30;
                    i11 = 512;
                    i10 |= i11;
                }
                if (Long.compare(i32, i17) != 0) {
                    l = i12 != 0 ? l | i22 : l | i23;
                }
                i11 = i7 != 0 ? i29 : i5;
                if (i7 != 0) {
                } else {
                    i5 = i29;
                }
            } else {
            }
        } else {
            i11 = i12;
        }
        if (jVar != null) {
            i3 = jVar.m();
            i8 = result;
        } else {
            i3 = i8;
        }
        obj.Q(arr, i8);
        if (Long.compare(programName, i17) != 0) {
            if (i3 != 0) {
                allExamsCount = i3.getAllExamsCount();
                programName = i3.getProgramName();
                passedExamsCount = i3.getPassedExamsCount();
            } else {
                passedExamsCount = programName;
            }
            i6 = ViewDataBinding.J(allExamsCount);
            Object[] arr3 = new Object[arr];
            arr3[i29] = programName;
            string = obj.Q.getResources().getString(2131887132, arr3);
            arr2 = new Object[2];
            arr2[i29] = passedExamsCount;
            arr2[arr] = allExamsCount;
            string3 = obj.T.getResources().getString(2131886580, arr2);
            i9 = ViewDataBinding.J(passedExamsCount);
        } else {
            i6 = i9;
            string = string3;
        }
        if (i3 != 0) {
            certificatePlaceholderUrl = i3.getCertificatePlaceholderUrl();
        } else {
            certificatePlaceholderUrl = i4;
        }
        if (i8 != 0) {
            value = i8.getValue();
        } else {
            value = i4;
        }
        i2 = i11;
        i15 = i6;
        if (Long.compare(i24, i17) != 0 && i3 != 0) {
            if (i3 != 0) {
                certificateRequirements = i3.getCertificateRequirements();
            } else {
                certificateRequirements = i4;
            }
        } else {
        }
        if (Long.compare(i34, i17) != 0) {
            if (jVar != null) {
                dogName = jVar.getDogName();
            } else {
                dogName = i4;
            }
            arr = new Object[arr];
            arr[i29] = dogName;
            string2 = obj.O.getResources().getString(2131886257, arr);
        } else {
            string2 = i4;
        }
        cmp = Long.compare(i26, i35);
        if (cmp != 0) {
            i4 = i12 != 0 ? string2 : certificateRequirements;
        }
        if (cmp != 0) {
            g.c(obj.O, i4);
            g.c(obj.Q, string);
            obj.R.T(jVar);
            obj.S.setMax(i15);
            obj.S.setProgress(i9);
            obj.S.setVisibility(i5);
            g.c(obj.T, string3);
            obj.T.setVisibility(i5);
            obj.U.setVisibility(i2);
            obj.V.setVisibility(i2);
            obj.W.setVisibility(i2);
        }
        if (Long.compare(i16, i19) != 0) {
            l.t(obj.P, value, certificatePlaceholderUrl);
            n.F0(obj.Z, value);
        }
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
