package app.dogo.com.dogo_android.h;

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
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.z;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class tj extends app.dogo.com.dogo_android.h.sj implements b.a {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final View.OnClickListener X;
    private long Y;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        tj.a0 = sparseIntArray;
        sparseIntArray.put(2131363418, 6);
    }

    public tj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, tj.Z, tj.a0));
    }

    private tj(e e, View view2, Object[] object3Arr3) {
        int i4 = 1;
        super(e, view2, 0, (ProgressBar)object3Arr3[5], (TextView)object3Arr3[4], (CardView)object3Arr3[0], (ImageView)object3Arr3[i4], (ProgressBar)object3Arr3[3], (TextView)object3Arr3[2], (Guideline)object3Arr3[6]);
        this.Y = -1;
        int obj15 = 0;
        this.O.setTag(obj15);
        this.P.setTag(obj15);
        this.Q.setTag(obj15);
        this.R.setTag(obj15);
        this.S.setTag(obj15);
        this.T.setTag(obj15);
        N(view2);
        b obj13 = new b(this, i4);
        this.X = obj13;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public void A() {
        this.Y = 8;
        I();
        return;
        synchronized (this) {
            this.Y = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (50 == i) {
            U((SpecialProgramOverviewItem.ProgramProgressData)object2);
            obj2 = 1;
        } else {
            if (94 == i) {
                V((ProgramDescriptionItem)object2);
            } else {
                if (29 == i) {
                    T((o)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public void T(o o) {
        this.W = o;
        this.Y = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = o;
            this.Y = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public void U(SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData) {
        this.V = programProgressData;
        this.Y = l |= i2;
        notifyPropertyChanged(50);
        super.I();
        return;
        synchronized (this) {
            this.V = programProgressData;
            this.Y = l |= i2;
            notifyPropertyChanged(50);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public void V(ProgramDescriptionItem programDescriptionItem) {
        this.U = programDescriptionItem;
        this.Y = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.U = programDescriptionItem;
            this.Y = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public final void b(int i, View view2) {
        int i3;
        int i2;
        Object obj4;
        obj4 = this.U;
        final o obj5 = this.W;
        final int i4 = 0;
        i2 = obj5 != null ? i3 : i4;
        if (i2 != 0) {
            if (obj4 != null) {
            } else {
                i3 = i4;
            }
            if (i3 != 0) {
                obj5.L0(obj4.getId());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.sj
    protected void m() {
        int cmp2;
        View.OnClickListener list;
        int articleCompletionPercentage;
        int i2;
        int cmp;
        int trickCompletionPercentage;
        int i;
        String str;
        long l = this.Y;
        final int i4 = 0;
        this.Y = i4;
        SpecialProgramOverviewItem.ProgramProgressData programProgressData = this.V;
        ProgramDescriptionItem programDescriptionItem = this.U;
        cmp = Long.compare(i7, i4);
        synchronized (this) {
            l = this.Y;
            i4 = 0;
            this.Y = i4;
            programProgressData = this.V;
            programDescriptionItem = this.U;
            cmp = Long.compare(i7, i4);
        }
        try {
            if (programProgressData != null) {
            } else {
            }
            trickCompletionPercentage = programProgressData.getTrickCompletionPercentage();
            articleCompletionPercentage = programProgressData.getArticleCompletionPercentage();
            articleCompletionPercentage = trickCompletionPercentage;
            int cmp3 = Long.compare(i9, i4);
            if (cmp3 != 0 && programDescriptionItem != null) {
            } else {
            }
            if (programDescriptionItem != null) {
            } else {
            }
            i = cardBackgroundColor;
            i2 = str;
            i2 = i;
        }
        if (cmp != 0) {
            this.O.setProgress(trickCompletionPercentage);
            l.B(this.P, trickCompletionPercentage);
            this.S.setProgress(articleCompletionPercentage);
            l.o0(this.T, articleCompletionPercentage);
        }
        if (cmp3 != 0) {
            n.E(this.Q, i);
            n.w(this.R, i2);
        }
        if (Long.compare(i3, i4) != 0) {
            this.Q.setOnClickListener(this.X);
        }
    }

    @Override // app.dogo.com.dogo_android.h.sj
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
