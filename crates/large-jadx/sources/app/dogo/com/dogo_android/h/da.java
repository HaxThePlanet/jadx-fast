package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.n.j;

/* compiled from: FragmentCertificateDetailBindingImpl.java */
/* loaded from: classes.dex */
public class da extends ca {

    private static final ViewDataBinding.g c0 = new ViewDataBinding$g(15);
    private static final SparseIntArray d0 = new SparseIntArray();
    private final CoordinatorLayout Z;
    private final ConstraintLayout a0;
    private long b0;
    static {
        int i6 = 1;
        final int[] iArr = new int[i6];
        final int i12 = 0;
        iArr[i12] = 10;
        int[] iArr2 = new int[i6];
        iArr2[i12] = R.layout.fragment_certificate_detail_state;
        obj.a(i6, new String[] { "fragment_certificate_detail_state" }, iArr, iArr2);
        obj.put(2131363435, 11);
        obj.put(2131363278, 12);
        obj.put(2131362389, 13);
        obj.put(2131362136, 14);
    }

    public da(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 15, da.c0, da.d0));
    }

    private boolean Y(ea eaVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(LiveData<y<CertificateInfo>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 16L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ca
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public boolean O(int i, Object object) {
        int i2 = 141;
        boolean z = true;
        i2 = 141;
        if (141 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                X(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public void X(j jVar) {
        this.Y = jVar;
        synchronized (this) {
            try {
                this.b0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ca
    protected void m() {
        long l;
        long l2;
        int cmp2;
        LiveData result;
        y yVar;
        Integer allExamsCount;
        java.lang.CharSequence charSequence2;
        int i = 8;
        java.lang.CharSequence charSequence3;
        String str;
        int i4 = 512;
        long l4;
        Integer passedExamsCount;
        final Object obj = this;
        synchronized (this) {
            try {
                long l6 = 0L;
                obj.b0 = l6;
            } catch (Throwable th) {
            }
        }
        long l7 = l & 26L;
        long l8 = 32L;
        int i3 = 1;
        long l3 = 24L;
        i = 0;
        cmp2 = 0;
        if (l7 != l6) {
            long l11 = l & 24L;
            if (l11 != l6) {
                if (obj.Y != null) {
                    boolean z = obj.Y.p();
                    boolean z2 = obj.Y.p();
                } else {
                }
                if (l11 != l6) {
                    if (i != 0) {
                        l2 = l | 256L;
                        i4 = 1024;
                    } else {
                        l2 = l | 128L;
                        i4 = 512;
                    }
                    l = l2 | i4;
                }
                long l12 = l & 24L;
                if (l12 != l6 && i != 0) {
                    l = l | 64L;
                }
                i = 8;
                int r20 = i != 0 ? i : 8;
                if (i == 0) {
                }
            } else {
            }
            if (obj.Y != null) {
                ProgramExamSummary programExamSummary = obj.Y.m();
            } else {
            }
            obj.Q(i3, result);
            l4 = l & 24L;
            if (l4 != l6) {
                if (cmp2 != 0) {
                    allExamsCount = cmp2.getAllExamsCount();
                    String programName = cmp2.getProgramName();
                    passedExamsCount = cmp2.getPassedExamsCount();
                } else {
                }
                i = ViewDataBinding.J(allExamsCount);
                Object[] arr2 = new Object[i3];
                String string3 = obj.Q.getResources().getString(2131887132, new Object[] { cmp2 });
                Object[] arr = new Object[2];
                String string2 = obj.T.getResources().getString(2131886580, new Object[] { passedExamsCount, allExamsCount });
                i = ViewDataBinding.J(passedExamsCount);
            } else {
            }
            if (cmp2 != 0) {
                String certificatePlaceholderUrl = cmp2.getCertificatePlaceholderUrl();
            } else {
            }
            Object value = result != null ? (LoadResult)value : cmp2;
        } else {
        }
        long l9 = 32L & l;
        if (l9 == l6 || cmp2 == 0) {
        } else {
            String certificateRequirements = cmp2.getCertificateRequirements();
        }
        long l13 = l & 64L;
        if (l13 != l6) {
            if (obj.Y != null) {
                String dogName = obj.Y.getDogName();
            } else {
            }
            int i2 = 2131886257;
            Object[] arr3 = new Object[i3];
            String string = obj.O.getResources().getString(i2, new Object[] { cmp2 });
        } else {
        }
        long l10 = 24L & l;
        if (l10 != 0) {
            int r17 = cmp2;
        }
        if (l10 != 0) {
            g.c(obj.O, cmp2);
            g.c(obj.Q, charSequence3);
            obj.R.T(obj.Y);
            obj.S.setMax(i);
            obj.S.setProgress(i);
            obj.S.setVisibility(i);
            g.c(obj.T, charSequence2);
            obj.T.setVisibility(i);
            obj.U.setVisibility(i);
            obj.V.setVisibility(i);
            obj.W.setVisibility(i);
        }
        l &= 26;
        if (obj.b0 != 0) {
            ProgramBindingAdapters.t(obj.P, yVar, str);
            BindingAdapters.setTrainerAvatar(obj.Z, yVar);
        }
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private da(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (TextView)objectArr[9], (ImageView)objectArr[14], (ImageView)objectArr[2], (TextView)objectArr[8], (Guideline)objectArr[13], (ea)objectArr[10], (ProgressBar)objectArr[4], (TextView)objectArr[3], (MaterialButton)objectArr[5], (MaterialButton)objectArr[7], (Space)objectArr[6], (Guideline)objectArr[12], (Toolbar)objectArr[11]);
        Object eVar3 = this;
        eVar3.b0 = -1L;
        Object obj3 = null;
        eVar3.O.setTag(obj3);
        eVar3.P.setTag(obj3);
        eVar3.Q.setTag(obj3);
        eVar3.L(eVar3.R);
        Object obj = objectArr[0];
        eVar3.Z = obj;
        obj.setTag(obj3);
        Object obj2 = objectArr[1];
        eVar3.a0 = obj2;
        obj2.setTag(obj3);
        eVar3.S.setTag(obj3);
        eVar3.T.setTag(obj3);
        eVar3.U.setTag(obj3);
        eVar3.V.setTag(obj3);
        eVar3.W.setTag(obj3);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ca
    public void W(app.dogo.com.dogo_android.view.dailytraining.l lVar) {
    }
}
