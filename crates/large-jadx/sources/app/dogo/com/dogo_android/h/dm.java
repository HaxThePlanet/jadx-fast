package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class dm extends app.dogo.com.dogo_android.h.cm {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        dm.V = sparseIntArray;
        sparseIntArray.put(2131362298, 4);
        sparseIntArray.put(2131361940, 5);
    }

    public dm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, dm.U, dm.V));
    }

    private dm(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[5], (TextView)object3Arr3[4], (ImageView)object3Arr3[1], (ProgressBar)object3Arr3[3], (TextView)object3Arr3[2]);
        this.T = -1;
        int i7 = 0;
        this.O.setTag(i7);
        this.P.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.S = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        this.Q.setTag(i7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cm
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cm
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.cm
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

    @Override // app.dogo.com.dogo_android.h.cm
    public void V(ProgramExamSummary programExamSummary) {
        this.R = programExamSummary;
        this.T = l |= i2;
        notifyPropertyChanged(68);
        super.I();
        return;
        synchronized (this) {
            this.R = programExamSummary;
            this.T = l |= i2;
            notifyPropertyChanged(68);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cm
    protected void m() {
        int cmp;
        int i4;
        int i;
        int i2;
        int certificatePaperImage;
        int resources;
        int i5;
        Object[] arr;
        int i3;
        Integer num;
        int i8 = 0;
        this.T = i8;
        final ProgramExamSummary programExamSummary = this.R;
        cmp = Long.compare(i6, i8);
        i4 = 0;
        synchronized (this) {
            i8 = 0;
            this.T = i8;
            programExamSummary = this.R;
            cmp = Long.compare(i6, i8);
            i4 = 0;
        }
        try {
            if (programExamSummary != null) {
            } else {
            }
            certificatePaperImage = programExamSummary.getCertificatePaperImage();
            i2 = allExamsCount;
            i4 = num;
            certificatePaperImage = i2;
            arr = new Object[2];
            i = string;
            i4 = certificatePaperImage;
            i = i4;
            if (cmp != 0) {
            }
            n.w(this.O, i4);
            l.z(this.P, programExamSummary);
            g.c(this.Q, i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cm
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
