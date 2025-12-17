package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class bm extends app.dogo.com.dogo_android.h.am {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bm.T = sparseIntArray;
        sparseIntArray.put(2131362507, 2);
        sparseIntArray.put(2131362585, 3);
        sparseIntArray.put(2131363414, 4);
        sparseIntArray.put(2131362298, 5);
        sparseIntArray.put(2131363148, 6);
    }

    public bm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, bm.S, bm.T));
    }

    private bm(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[5], (ImageView)object3Arr3[1], (ImageView)object3Arr3[2], (Guideline)object3Arr3[3], (Button)object3Arr3[6], (TextView)object3Arr3[4]);
        this.R = -1;
        int i8 = 0;
        this.O.setTag(i8);
        Object obj12 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj12;
        obj12.setTag(i8);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.am
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.am
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.am
    public boolean O(int i, Object object2) {
        int obj2;
        if (68 == i) {
            V((ProgramExamSummary)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.am
    public void V(ProgramExamSummary programExamSummary) {
        this.P = programExamSummary;
        this.R = l |= i2;
        notifyPropertyChanged(68);
        super.I();
        return;
        synchronized (this) {
            this.P = programExamSummary;
            this.R = l |= i2;
            notifyPropertyChanged(68);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.am
    protected void m() {
        int cmp;
        int certificatePaperImage;
        final int i2 = 0;
        this.R = i2;
        final ProgramExamSummary programExamSummary = this.P;
        certificatePaperImage = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.R = i2;
            programExamSummary = this.P;
            certificatePaperImage = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (programExamSummary != null) {
            }
            certificatePaperImage = programExamSummary.getCertificatePaperImage();
            if (cmp != 0) {
            }
            n.w(this.O, certificatePaperImage);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.am
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
