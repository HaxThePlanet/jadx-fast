package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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

/* compiled from: LayoutBitingProgramUnlockCertificateBindingImpl.java */
/* loaded from: classes.dex */
public class zh extends yh implements b.a {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout R;
    private final View.OnClickListener S;
    private long T;
    static {
        obj.put(2131363414, 2);
        obj.put(2131362298, 3);
        obj.put(2131361940, 4);
        obj.put(2131362637, 5);
    }

    public zh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, zh.U, zh.V));
    }

    @Override // app.dogo.com.dogo_android.h.yh
    public void A() {
        synchronized (this) {
            try {
                this.T = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yh
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

    @Override // app.dogo.com.dogo_android.h.yh
    public void T(j jVar) {
        this.Q = jVar;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yh
    public void U(SpecialProgramOverviewItem.CertificateData certificateData) {
        this.P = certificateData;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yh
    public final void b(int i, View view) {
        int i2 = 1;
        int r0 = this.Q != null ? 1 : 0;
        if (i2 != 0) {
            this.Q.onReviewCertificateSelected(this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yh
    protected void m() {
        String certificatePaperImage = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        int i2 = 0;
        long l4 = 5L & l;
        if (l4 != l3 && this.P != null) {
            certificatePaperImage = this.P.getCertificatePaperImage();
        }
        if (l4 != l3) {
            BindingAdapters.w(this.O, certificatePaperImage);
        }
        long l2 = l & 4L;
        if (this.T != l3) {
            this.R.setOnClickListener(this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yh
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

    private zh(e eVar, View view, Object[] objectArr) {
        int i2 = 1;
        super(eVar, view, 0, (ImageView)objectArr[4], (ImageView)objectArr[i2], (TextView)objectArr[3], (ImageView)objectArr[5], (TextView)objectArr[2]);
        this.T = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.R = obj7;
        obj7.setTag(obj6);
        N(view);
        this.S = new b(this, i2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yh
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
