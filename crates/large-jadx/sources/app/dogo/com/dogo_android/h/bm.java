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

/* compiled from: LayoutProgramCertificateCompletedBindingImpl.java */
/* loaded from: classes.dex */
public class bm extends am {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131362507, 2);
        obj.put(2131362585, 3);
        obj.put(2131363414, 4);
        obj.put(2131362298, 5);
        obj.put(2131363148, 6);
    }

    public bm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, bm.S, bm.T));
    }

    @Override // app.dogo.com.dogo_android.h.am
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.am
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

    @Override // app.dogo.com.dogo_android.h.am
    public void V(ProgramExamSummary programExamSummary) {
        this.P = programExamSummary;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(68);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.am
    protected void m() {
        String certificatePaperImage = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.R & 3L;
        if (l2 != l3 && this.P != null) {
            certificatePaperImage = this.P.getCertificatePaperImage();
        }
        if (l2 != l3) {
            BindingAdapters.w(this.O, certificatePaperImage);
        }
    }

    @Override // app.dogo.com.dogo_android.h.am
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private bm(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[5], (ImageView)objectArr[1], (ImageView)objectArr[2], (Guideline)objectArr[3], (Button)objectArr[6], (TextView)objectArr[4]);
        this.R = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        Object obj8 = objectArr[0];
        this.Q = obj8;
        obj8.setTag(obj7);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.am
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
