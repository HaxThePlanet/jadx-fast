package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class zh extends app.dogo.com.dogo_android.h.yh implements b.a {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout R;
    private final View.OnClickListener S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zh.V = sparseIntArray;
        sparseIntArray.put(2131363414, 2);
        sparseIntArray.put(2131362298, 3);
        sparseIntArray.put(2131361940, 4);
        sparseIntArray.put(2131362637, 5);
    }

    public zh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, zh.U, zh.V));
    }

    private zh(e e, View view2, Object[] object3Arr3) {
        int i2 = 1;
        super(e, view2, 0, (ImageView)object3Arr3[4], (ImageView)object3Arr3[i2], (TextView)object3Arr3[3], (ImageView)object3Arr3[5], (TextView)object3Arr3[2]);
        this.T = -1;
        int i7 = 0;
        this.O.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.R = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        N(view2);
        obj11 = new b(this, i2);
        this.S = obj11;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yh
    public void A() {
        this.T = 4;
        I();
        return;
        synchronized (this) {
            this.T = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yh
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.yh
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((SpecialProgramOverviewItem.CertificateData)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                T((j)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.yh
    public void T(j j) {
        this.Q = j;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Q = j;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yh
    public void U(SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData) {
        this.P = certificateData;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.P = certificateData;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yh
    public final void b(int i, View view2) {
        int i2;
        final j obj3 = this.Q;
        i2 = obj3 != null ? 1 : 0;
        if (i2 != 0) {
            obj3.H(this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yh
    protected void m() {
        int cmp;
        View.OnClickListener list;
        Object certificateData;
        int certificatePaperImage;
        long l = this.T;
        final int i2 = 0;
        this.T = i2;
        certificateData = this.P;
        certificatePaperImage = 0;
        int cmp2 = Long.compare(i5, i2);
        synchronized (this) {
            l = this.T;
            i2 = 0;
            this.T = i2;
            certificateData = this.P;
            certificatePaperImage = 0;
            cmp2 = Long.compare(i5, i2);
        }
        try {
            if (certificateData != null) {
            }
            certificatePaperImage = certificateData.getCertificatePaperImage();
            if (cmp2 != 0) {
            }
            n.w(this.O, certificatePaperImage);
            if (Long.compare(i, i2) != 0) {
            }
            this.R.setOnClickListener(this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yh
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
