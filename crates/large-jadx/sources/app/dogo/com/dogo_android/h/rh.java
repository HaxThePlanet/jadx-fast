package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
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
public class rh extends app.dogo.com.dogo_android.h.qh implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout S;
    private final View.OnClickListener T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        rh.W = sparseIntArray;
        sparseIntArray.put(2131362507, 3);
        sparseIntArray.put(2131363414, 4);
        sparseIntArray.put(2131362298, 5);
        sparseIntArray.put(2131362592, 6);
        sparseIntArray.put(2131362593, 7);
        sparseIntArray.put(2131362004, 8);
    }

    public rh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, rh.V, rh.W));
    }

    private rh(e e, View view2, Object[] object3Arr3) {
        final Object obj19 = this;
        final int i12 = 1;
        super(e, view2, 0, (Barrier)object3Arr3[8], (TextView)object3Arr3[5], (ImageView)object3Arr3[i12], (ImageView)object3Arr3[3], (Guideline)object3Arr3[6], (Guideline)object3Arr3[7], (Button)object3Arr3[2], (TextView)object3Arr3[4]);
        obj19.U = -1;
        int i10 = 0;
        obj19.O.setTag(i10);
        Object obj9 = object3Arr3[0];
        obj19.S = (ConstraintLayout)obj9;
        obj9.setTag(i10);
        obj19.P.setTag(i10);
        N(view2);
        b bVar = new b(this, i12);
        obj19.T = bVar;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.qh
    public void A() {
        this.U = 4;
        I();
        return;
        synchronized (this) {
            this.U = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qh
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.qh
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

    @Override // app.dogo.com.dogo_android.h.qh
    public void T(j j) {
        this.R = j;
        this.U = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = j;
            this.U = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qh
    public void U(SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData) {
        this.Q = certificateData;
        this.U = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = certificateData;
            this.U = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qh
    public final void b(int i, View view2) {
        int i2;
        final j obj3 = this.R;
        i2 = obj3 != null ? 1 : 0;
        if (i2 != 0) {
            obj3.H(this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qh
    protected void m() {
        int cmp;
        View.OnClickListener list;
        Object certificateData;
        int certificatePaperImage;
        long l = this.U;
        final int i2 = 0;
        this.U = i2;
        certificateData = this.Q;
        certificatePaperImage = 0;
        int cmp2 = Long.compare(i5, i2);
        synchronized (this) {
            l = this.U;
            i2 = 0;
            this.U = i2;
            certificateData = this.Q;
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
            this.P.setOnClickListener(this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qh
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
