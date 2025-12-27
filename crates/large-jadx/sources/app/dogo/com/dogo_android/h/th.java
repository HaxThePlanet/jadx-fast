package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState;
import app.dogo.com.dogo_android.u.j;

/* compiled from: LayoutBitingProgramCertificateCombinedBindingImpl.java */
/* loaded from: classes.dex */
public class th extends sh {

    private static final ViewDataBinding.g U = new ViewDataBinding$g(4);
    private static final SparseIntArray V = new SparseIntArray();
    private long T;
    static {
        obj.a(0, new String[] { "layout_biting_program_certificate", "layout_biting_program_unlock_certificate" }, new int[] { 1, 2 }, new int[] { R.layout.layout_biting_program_certificate, R.layout.layout_biting_program_unlock_certificate });
        obj.put(2131362322, 3);
    }

    public th(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, th.U, th.V));
    }

    private boolean V(qh qhVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(yh yhVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public void A() {
        synchronized (this) {
            try {
                this.T = 16L;
            } catch (Throwable th) {
            }
        }
        this.P.A();
        this.Q.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sh
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public void M(q qVar) {
        super.M(qVar);
        this.P.M(qVar);
        this.Q.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            Y(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                X(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public void X(j jVar) {
        this.S = jVar;
        synchronized (this) {
            try {
                this.T |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public void Y(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.R = specialProgramOverviewItem;
        synchronized (this) {
            try {
                this.T |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sh
    protected void m() {
        long l;
        int cmp;
        int i;
        int cmp2;
        int cmp3 = 32;
        SpecialProgramOverviewItem.CertificateData certificateData = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 20L;
        long l5 = l & l4;
        cmp2 = 0;
        if (l5 != l3) {
            if (this.R != null) {
                SpecialProgramOverviewItem.CertificateData certificate = this.R.getCertificate();
            } else {
            }
            if (this.R != 0) {
                SpecialProgramOverviewItem.CertificateState state = i.getState();
            }
            cmp2 = 1;
            int r11 = i == SpecialProgramOverviewItem_CertificateState.LOCKED ? 1 : cmp2;
            if (i != SpecialProgramOverviewItem_CertificateState.UNLOCKED) {
            }
            if (l5 != l3) {
                int r8 = SpecialProgramOverviewItem_CertificateState.LOCKED != 0 ? 256 : 128;
                l = l | (SpecialProgramOverviewItem_CertificateState.LOCKED != 0 ? 256 : 128);
            }
            long l6 = l & 20L;
            if (l6 != l3 && cmp2 != 0) {
                cmp3 = 64;
                l = l | cmp3;
            }
            cmp2 = 8;
            int r9 = cmp2;
            if (cmp2 == 0) {
            }
        } else {
        }
        long l7 = 24L & l;
        l &= l4;
        if (this.T != l3) {
            this.P.U(certificateData);
            this.P.w().setVisibility(cmp2);
            this.Q.U(certificateData);
            this.Q.w().setVisibility(cmp2);
        }
        if (SpecialProgramOverviewItem_CertificateState.LOCKED != l3) {
            this.P.T(this.S);
            this.Q.T(this.S);
        }
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.Q);
    }

    @Override // app.dogo.com.dogo_android.h.sh
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z3 = true;
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.P.y()) {
            return true;
        }
        if (this.Q.y()) {
            return true;
        }
        return false;
    }

    private th(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (ConstraintLayout)objectArr[0], (qh)objectArr[1], (ImageView)objectArr[3], (yh)objectArr[2]);
        this.T = -1L;
        this.O.setTag(null);
        L(this.P);
        L(this.Q);
        N(view);
        A();
    }
}
