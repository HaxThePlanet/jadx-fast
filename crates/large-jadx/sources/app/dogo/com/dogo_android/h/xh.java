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

/* compiled from: LayoutBitingProgramProgressDisplayBindingImpl.java */
/* loaded from: classes.dex */
public class xh extends wh {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131362627, 5);
        obj.put(2131362621, 6);
        obj.put(2131362132, 7);
    }

    public xh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, xh.V, xh.W));
    }

    @Override // app.dogo.com.dogo_android.h.wh
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wh
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.wh
    public void T(h hVar) {
        this.S = hVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wh
    protected void m() {
        int articleCompletionPercentage = 0;
        boolean tricksAreCompleted;
        boolean articlesAreCompleted;
        int i = 0;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        i = 0;
        long l2 = this.U & 3L;
        articleCompletionPercentage = 0;
        if (l2 != l3) {
            if (this.S != null) {
                SpecialProgramOverviewItem.ProgramProgressData programCompletion = this.S.getProgramCompletion();
            }
            if (i != 0) {
                articleCompletionPercentage = i.getArticleCompletionPercentage();
            } else {
            }
        }
        if (l2 != l3) {
            BindingAdapters.d(this.O, Integer.valueOf(articleCompletionPercentage));
            ProgramBindingAdapters.y(this.O, tricksAreCompleted);
            ProgramBindingAdapters.loadRealCertificate(this.P, articleCompletionPercentage);
            BindingAdapters.d(this.Q, Integer.valueOf(articleCompletionPercentage));
            ProgramBindingAdapters.y(this.Q, articlesAreCompleted);
            ProgramBindingAdapters.o0(this.R, articleCompletionPercentage);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wh
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private xh(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Guideline)objectArr[7], (ProgressBar)objectArr[4], (TextView)objectArr[3], (ImageView)objectArr[6], (ImageView)objectArr[5], (ProgressBar)objectArr[2], (TextView)objectArr[1]);
        this.U = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        this.P.setTag(obj8);
        Object obj9 = objectArr[0];
        this.T = obj9;
        obj9.setTag(obj8);
        this.Q.setTag(obj8);
        this.R.setTag(obj8);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wh
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
