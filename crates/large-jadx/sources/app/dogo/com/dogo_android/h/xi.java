package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.g.n;
import app.dogo.com.dogo_android.g.t;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class xi extends app.dogo.com.dogo_android.h.wi implements b.a {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final View.OnClickListener X;
    private long Y;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        xi.a0 = sparseIntArray;
        sparseIntArray.put(2131362789, 7);
        sparseIntArray.put(2131363007, 8);
    }

    public xi(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, xi.Z, xi.a0));
    }

    private xi(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        final int i12 = 1;
        super(e, view2, 0, (FrameLayout)object3Arr3[2], (TextView)object3Arr3[3], (ImageView)object3Arr3[6], (TextView)object3Arr3[4], (ProgressBar)object3Arr3[5], (Guideline)object3Arr3[7], (CardView)object3Arr3[0], (Barrier)object3Arr3[8], (TextView)object3Arr3[i12]);
        obj20.Y = -1;
        int i10 = 0;
        obj20.O.setTag(i10);
        obj20.P.setTag(i10);
        obj20.Q.setTag(i10);
        obj20.R.setTag(i10);
        obj20.S.setTag(i10);
        obj20.T.setTag(i10);
        obj20.U.setTag(i10);
        N(view2);
        b bVar = new b(this, i12);
        obj20.X = bVar;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public void A() {
        this.Y = 4;
        I();
        return;
        synchronized (this) {
            this.Y = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wi
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((t)object2);
            obj2 = 1;
        } else {
            if (68 == i) {
                W((ProgramExamSummary)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public void V(t t) {
        this.W = t;
        this.Y = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = t;
            this.Y = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public void W(ProgramExamSummary programExamSummary) {
        this.V = programExamSummary;
        this.Y = l |= i2;
        notifyPropertyChanged(68);
        super.I();
        return;
        synchronized (this) {
            this.V = programExamSummary;
            this.Y = l |= i2;
            notifyPropertyChanged(68);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public final void b(int i, View view2) {
        int i2;
        final t obj3 = this.W;
        i2 = obj3 != null ? 1 : 0;
        if (i2 != 0) {
            obj3.Z(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wi
    protected void m() {
        int cmp3;
        long l;
        int i;
        String string;
        String string2;
        int cmp;
        int i3;
        int cmp2;
        int i6;
        String i5;
        int i4;
        int i2;
        int allExamsCount;
        int cardBackgroundColor;
        int activeExamsCount;
        Resources resources;
        Integer num;
        final Object obj = this;
        l = obj.Y;
        int i7 = 0;
        obj.Y = i7;
        ProgramExamSummary programExamSummary = obj.V;
        i3 = 6;
        cmp2 = Long.compare(i15, i7);
        i6 = 0;
        i5 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i7 = 0;
            obj.Y = i7;
            programExamSummary = obj.V;
            i3 = 6;
            cmp2 = Long.compare(i15, i7);
            i6 = 0;
            i5 = 0;
        }
        if (programExamSummary != null) {
            allExamsCount = programExamSummary.getAllExamsCount();
            cardBackgroundColor = programExamSummary.getCardBackgroundColor();
            activeExamsCount = programExamSummary.getActiveExamsCount();
            i2 = certificateLaurelsImage;
            i5 = num;
        } else {
            try {
                activeExamsCount = cardBackgroundColor;
                Object[] arr = new Object[2];
                arr[i6] = i5;
                arr[1] = allExamsCount;
                string = obj.R.getResources().getString(2131886581, arr);
                int i13 = ViewDataBinding.J(activeExamsCount);
                if (i13 > 0) {
                } else {
                }
                i4 = i6;
                activeExamsCount = 16;
            }
            if (i4 != 0) {
            } else {
                i6 = cmp2;
            }
            i5 = string2;
            if (Long.compare(i11, i14) != 0) {
                obj.O.setVisibility(i6);
                l.W(obj.O, programExamSummary, obj.P);
                g.c(obj.P, i5);
                n.w(obj.Q, i2);
                g.c(obj.R, string);
                l.z(obj.S, programExamSummary);
                n.E(obj.T, cardBackgroundColor);
                n.h(obj.U, programExamSummary);
            }
            if (Long.compare(i, i9) != 0) {
                obj.T.setOnClickListener(obj.X);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.wi
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
