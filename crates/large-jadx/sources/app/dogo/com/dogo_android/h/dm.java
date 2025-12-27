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

/* compiled from: LayoutProgramCertificateInProgressBindingImpl.java */
/* loaded from: classes.dex */
public class dm extends cm {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131362298, 4);
        obj.put(2131361940, 5);
    }

    public dm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, dm.U, dm.V));
    }

    @Override // app.dogo.com.dogo_android.h.cm
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cm
    public boolean O(int i, Object object) {
        boolean z = true;
        if (68 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.cm
    public void V(ProgramExamSummary programExamSummary) {
        this.R = programExamSummary;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(68);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cm
    protected void m() {
        int i = 0;
        String str = null;
        Object obj;
        Integer passedExamsCount;
        synchronized (this) {
            try {
                long l4 = 0L;
                this.T = l4;
            } catch (Throwable th) {
            }
        }
        long l = 3L;
        long l3 = this.T & l;
        i = 0;
        if (l3 != l4) {
            if (this.R != null) {
                String certificatePaperImage = this.R.getCertificatePaperImage();
            } else {
            }
            int i2 = 2131886580;
            Object[] arr = new Object[2];
            int i3 = 0;
            arr[i3] = i;
            arr[1] = i;
        } else {
        }
        if (l3 != l4) {
            BindingAdapters.w(this.O, str);
            ProgramBindingAdapters.z(this.P, this.R);
            g.c(this.Q, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cm
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private dm(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[5], (TextView)objectArr[4], (ImageView)objectArr[1], (ProgressBar)objectArr[3], (TextView)objectArr[2]);
        this.T = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        Object obj7 = objectArr[0];
        this.S = obj7;
        obj7.setTag(obj6);
        this.Q.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cm
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
