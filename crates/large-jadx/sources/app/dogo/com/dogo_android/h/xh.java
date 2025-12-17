package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;
import app.dogo.com.dogo_android.u.h;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class xh extends app.dogo.com.dogo_android.h.wh {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        xh.W = sparseIntArray;
        sparseIntArray.put(2131362627, 5);
        sparseIntArray.put(2131362621, 6);
        sparseIntArray.put(2131362132, 7);
    }

    public xh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, xh.V, xh.W));
    }

    private xh(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (Guideline)object3Arr3[7], (ProgressBar)object3Arr3[4], (TextView)object3Arr3[3], (ImageView)object3Arr3[6], (ImageView)object3Arr3[5], (ProgressBar)object3Arr3[2], (TextView)object3Arr3[1]);
        this.U = -1;
        int i9 = 0;
        this.O.setTag(i9);
        this.P.setTag(i9);
        Object obj13 = object3Arr3[0];
        this.T = (ConstraintLayout)obj13;
        obj13.setTag(i9);
        this.Q.setTag(i9);
        this.R.setTag(i9);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wh
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wh
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.wh
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            T((h)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wh
    public void T(h h) {
        this.S = h;
        this.U = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.S = h;
            this.U = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wh
    protected void m() {
        int cmp;
        int valueOf;
        int i;
        int articleCompletionPercentage;
        int i2;
        int programCompletion;
        boolean z;
        int i4 = 0;
        this.U = i4;
        h hVar = this.S;
        programCompletion = 0;
        cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.U = i4;
            hVar = this.S;
            programCompletion = 0;
            cmp = Long.compare(i3, i4);
        }
        try {
            if (hVar != null) {
            }
            programCompletion = hVar.getProgramCompletion();
            if (programCompletion != 0) {
            } else {
            }
            articleCompletionPercentage = programCompletion.getArticleCompletionPercentage();
            i = tricksAreCompleted;
            valueOf = trickCompletionPercentage;
            i2 = z;
            i2 = articleCompletionPercentage;
            if (cmp != 0) {
            }
            n.d(this.O, Integer.valueOf(valueOf));
            l.y(this.O, i);
            l.B(this.P, valueOf);
            n.d(this.Q, Integer.valueOf(articleCompletionPercentage));
            l.y(this.Q, i2);
            l.o0(this.R, articleCompletionPercentage);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wh
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
