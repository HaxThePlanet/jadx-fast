package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState;
import app.dogo.com.dogo_android.u.j;

/* loaded from: classes.dex */
public class th extends app.dogo.com.dogo_android.h.sh {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private long T;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        th.U = gVar;
        int i3 = 2;
        final int[] iArr2 = new int[i3];
        iArr2 = new int[]{1, 2};
        int[] iArr = new int[i3];
        iArr = new int[]{2131558737, 2131558741};
        gVar.a(0, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        th.V = sparseIntArray;
        sparseIntArray.put(2131362322, 3);
    }

    public th(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, th.U, th.V));
    }

    private th(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (ConstraintLayout)object3Arr3[0], (qh)object3Arr3[1], (ImageView)object3Arr3[3], (yh)object3Arr3[2]);
        this.T = -1;
        this.O.setTag(0);
        L(this.P);
        L(this.Q);
        N(view2);
        A();
    }

    private boolean V(app.dogo.com.dogo_android.h.qh qh, int i2) {
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

    private boolean W(app.dogo.com.dogo_android.h.yh yh, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.sh
    public void A() {
        this.T = 16;
        this.P.A();
        this.Q.A();
        I();
        return;
        synchronized (this) {
            this.T = 16;
            this.P.A();
            this.Q.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sh
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return V((qh)object2, i3);
        }
        return W((yh)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public void M(q q) {
        super.M(q);
        this.P.M(q);
        this.Q.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            Y((SpecialProgramOverviewItem)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                X((j)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public void X(j j) {
        this.S = j;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = j;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public void Y(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.R = specialProgramOverviewItem;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = specialProgramOverviewItem;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sh
    protected void m() {
        long l;
        int cmp2;
        int i;
        int certificate;
        int cmp3;
        int cmp;
        int state;
        int i3;
        int i4;
        int i2;
        int i6;
        SpecialProgramOverviewItem.CertificateState uNLOCKED;
        int i5;
        l = this.T;
        final int i8 = 0;
        this.T = i8;
        SpecialProgramOverviewItem specialProgramOverviewItem = this.R;
        final j jVar = this.S;
        final int i9 = 20;
        cmp3 = Long.compare(i10, i8);
        i4 = 0;
        synchronized (this) {
            l = this.T;
            i8 = 0;
            this.T = i8;
            specialProgramOverviewItem = this.R;
            jVar = this.S;
            i9 = 20;
            cmp3 = Long.compare(i10, i8);
            i4 = 0;
        }
        try {
            if (specialProgramOverviewItem != null) {
            } else {
            }
            certificate = specialProgramOverviewItem.getCertificate();
            certificate = state;
            if (certificate != null) {
            }
            state = certificate.getState();
            i2 = i6;
        }
        i2 = i4;
        if (state == SpecialProgramOverviewItem.CertificateState.UNLOCKED) {
        } else {
            i6 = i4;
        }
        if (cmp3 != 0) {
            cmp3 = i2 != 0 ? 256 : 128;
            l |= cmp3;
        }
        if (Long.compare(i11, i8) != 0) {
            cmp = i6 != 0 ? 64 : 32;
            l |= cmp;
        }
        cmp3 = 8;
        i3 = i2 != 0 ? i4 : cmp3;
        if (i6 != 0) {
        } else {
            i4 = cmp3;
        }
        state = certificate;
        i = i5;
        if (Long.compare(i7, i8) != 0) {
            this.P.U(state);
            this.P.w().setVisibility(i4);
            this.Q.U(state);
            this.Q.w().setVisibility(i);
        }
        if (Long.compare(i13, i8) != 0) {
            this.P.T(jVar);
            this.Q.T(jVar);
        }
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.Q);
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
