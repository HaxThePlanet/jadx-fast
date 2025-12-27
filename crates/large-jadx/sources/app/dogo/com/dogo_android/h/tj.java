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

/* compiled from: LayoutDashboardSpecialProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class tj extends sj implements b.a {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final View.OnClickListener X;
    private long Y;
    static {
        obj.put(2131363418, 6);
    }

    public tj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, tj.Z, tj.a0));
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public void A() {
        synchronized (this) {
            try {
                this.Y = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 50;
        if (50 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 94;
            if (94 == i) {
                V(object);
            } else {
                i2 = 29;
                if (29 == i) {
                    T(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public void T(o oVar) {
        this.W = oVar;
        synchronized (this) {
            try {
                this.Y |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public void U(SpecialProgramOverviewItem.ProgramProgressData programProgressData) {
        this.V = programProgressData;
        synchronized (this) {
            try {
                this.Y |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(50);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public void V(ProgramDescriptionItem programDescriptionItem) {
        this.U = programDescriptionItem;
        synchronized (this) {
            try {
                this.Y |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public final void b(int i, View view) {
        int i2 = 1;
        i2 = 1;
        i2 = 0;
        int r2 = this.W != null ? 1 : i2;
        if (i2 != 0 && this.U != null) {
            if (i2 != 0) {
                this.W.onProgramOverviewSelected(this.U.getId());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.sj
    protected void m() {
        int articleCompletionPercentage;
        String iconUrl;
        String cardBackgroundColor = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.Y = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 9L & l;
        articleCompletionPercentage = 0;
        if (l4 == l3 || this.V == null) {
        } else {
            articleCompletionPercentage = this.V.getTrickCompletionPercentage();
            articleCompletionPercentage = this.V.getArticleCompletionPercentage();
        }
        long l5 = 10L & l;
        if (l5 == l3 || this.U == null) {
        } else {
        }
        if (l4 != l3) {
            this.O.setProgress(articleCompletionPercentage);
            ProgramBindingAdapters.loadRealCertificate(this.P, articleCompletionPercentage);
            this.S.setProgress(articleCompletionPercentage);
            ProgramBindingAdapters.o0(this.T, articleCompletionPercentage);
        }
        if (l5 != l3) {
            BindingAdapters.setRatingChange(this.Q, cardBackgroundColor);
            BindingAdapters.w(this.R, iconUrl);
        }
        long l2 = l & 8L;
        if (this.Y != l3) {
            this.Q.setOnClickListener(this.X);
        }
    }

    @Override // app.dogo.com.dogo_android.h.sj
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Y != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private tj(e eVar, View view, Object[] objectArr) {
        int i4 = 1;
        super(eVar, view, 0, (ProgressBar)objectArr[5], (TextView)objectArr[4], (CardView)objectArr[0], (ImageView)objectArr[i4], (ProgressBar)objectArr[3], (TextView)objectArr[2], (Guideline)objectArr[6]);
        this.Y = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        this.P.setTag(obj8);
        this.Q.setTag(obj8);
        this.R.setTag(obj8);
        this.S.setTag(obj8);
        this.T.setTag(obj8);
        N(view);
        this.X = new b(this, i4);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.sj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
