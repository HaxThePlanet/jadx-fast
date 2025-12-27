package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutBitingProgramCertificateBindingImpl.java */
/* loaded from: classes.dex */
public class rh extends qh implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout S;
    private final View.OnClickListener T;
    private long U;
    static {
        obj.put(2131362507, 3);
        obj.put(2131363414, 4);
        obj.put(2131362298, 5);
        obj.put(2131362592, 6);
        obj.put(2131362593, 7);
        obj.put(2131362004, 8);
    }

    public rh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, rh.V, rh.W));
    }

    @Override // app.dogo.com.dogo_android.h.qh
    public void A() {
        synchronized (this) {
            try {
                this.U = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qh
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                T(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.qh
    public void T(j jVar) {
        this.R = jVar;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qh
    public void U(SpecialProgramOverviewItem.CertificateData certificateData) {
        this.Q = certificateData;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qh
    public final void b(int i, View view) {
        int i2 = 1;
        int r0 = this.R != null ? 1 : 0;
        if (i2 != 0) {
            this.R.onReviewCertificateSelected(this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qh
    protected void m() {
        String certificatePaperImage = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        int i2 = 0;
        long l4 = 5L & l;
        if (l4 != l3 && this.Q != null) {
            certificatePaperImage = this.Q.getCertificatePaperImage();
        }
        if (l4 != l3) {
            BindingAdapters.w(this.O, certificatePaperImage);
        }
        long l2 = l & 4L;
        if (this.U != l3) {
            this.P.setOnClickListener(this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qh
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

    private rh(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i11 = 1;
        super(eVar, view, 0, (Barrier)objectArr[8], (TextView)objectArr[5], (ImageView)objectArr[i11], (ImageView)objectArr[3], (Guideline)objectArr[6], (Guideline)objectArr[7], (Button)objectArr[2], (TextView)objectArr[4]);
        eVar3.U = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.S = obj9;
        obj9.setTag(obj10);
        eVar3.P.setTag(obj10);
        N(view);
        eVar3.T = new b(this, i11);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.qh
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
