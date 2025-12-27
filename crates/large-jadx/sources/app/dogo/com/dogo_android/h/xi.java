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
import app.dogo.com.dogo_android.g.t;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutDashboardExamsCardBindingImpl.java */
/* loaded from: classes.dex */
public class xi extends wi implements b.a {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final View.OnClickListener X;
    private long Y;
    static {
        obj.put(2131362789, 7);
        obj.put(2131363007, 8);
    }

    public xi(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, xi.Z, xi.a0));
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public void A() {
        synchronized (this) {
            try {
                this.Y = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 68;
            if (68 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public void V(t tVar) {
        this.W = tVar;
        synchronized (this) {
            try {
                this.Y |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public void W(ProgramExamSummary programExamSummary) {
        this.V = programExamSummary;
        synchronized (this) {
            try {
                this.Y |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(68);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wi
    public final void b(int i, View view) {
        int i2 = 1;
        int r0 = this.W != null ? 1 : 0;
        if (i2 != 0) {
            this.W.onStartLessonSelected(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wi
    protected void m() {
        long l;
        Object obj;
        int cmp3 = 8;
        Integer passedExamsCount = null;
        Object obj3 = null;
        String certificateLaurelsImage;
        Integer allExamsCount;
        String cardBackgroundColor;
        Integer activeExamsCount;
        int i2 = 16;
        final Object obj2 = this;
        synchronized (this) {
            try {
                long l4 = 0L;
                obj2.Y = l4;
            } catch (Throwable th) {
            }
        }
        long l3 = 6L;
        long l6 = l & l3;
        cmp3 = 0;
        int i = 0;
        if (l6 != l4) {
            if (obj2.V != null) {
                allExamsCount = obj2.V.getAllExamsCount();
                cardBackgroundColor = obj2.V.getCardBackgroundColor();
                activeExamsCount = obj2.V.getActiveExamsCount();
            } else {
            }
            Object[] arr = new Object[2];
            cmp3 = 1;
            arr[cmp3] = allExamsCount;
            String string = obj2.R.getResources().getString(2131886581, arr);
            int i7 = ViewDataBinding.J(activeExamsCount);
            if (i7 <= 0) {
            }
            if (l6 != l4) {
                int r14 = cmp3 != 0 ? 16 : 8;
                l = l | (cmp3 != 0 ? 16 : 8);
            }
            if (cmp3 == 0) {
                cmp3 = 8;
            }
        } else {
        }
        long l5 = l & 6L;
        if (l5 != 0) {
            obj2.O.setVisibility(cmp3);
            ProgramBindingAdapters.W(obj2.O, obj2.V, obj2.P);
            g.c(obj2.P, obj3);
            BindingAdapters.w(obj2.Q, certificateLaurelsImage);
            g.c(obj2.R, obj);
            ProgramBindingAdapters.z(obj2.S, obj2.V);
            BindingAdapters.setRatingChange(obj2.T, cardBackgroundColor);
            DashboardBindingAdapters.setDashboardAdapter(obj2.U, obj2.V);
        }
        l2 = l & 4L;
        if (obj2.Y != 0) {
            obj2.T.setOnClickListener(obj2.X);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wi
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

    private xi(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i11 = 1;
        super(eVar, view, 0, (FrameLayout)objectArr[2], (TextView)objectArr[3], (ImageView)objectArr[6], (TextView)objectArr[4], (ProgressBar)objectArr[5], (Guideline)objectArr[7], (CardView)objectArr[0], (Barrier)objectArr[8], (TextView)objectArr[i11]);
        eVar3.Y = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.P.setTag(obj10);
        eVar3.Q.setTag(obj10);
        eVar3.R.setTag(obj10);
        eVar3.S.setTag(obj10);
        eVar3.T.setTag(obj10);
        eVar3.U.setTag(obj10);
        N(view);
        eVar3.X = new b(this, i11);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wi
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
