package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: FragmentSpecialProgramCertificateBindingImpl.java */
/* loaded from: classes.dex */
public class pg extends og {

    private static final ViewDataBinding.g c0 = new ViewDataBinding$g(15);
    private static final SparseIntArray d0 = new SparseIntArray();
    private final CoordinatorLayout X;
    private final ConstraintLayout Y;
    private final FrameLayout Z;
    private final ml a0;
    private long b0;
    static {
        int i6 = 1;
        int[] iArr2 = new int[i6];
        final int i15 = 0;
        iArr2[i15] = 9;
        int[] iArr4 = new int[i6];
        iArr4[i15] = R.layout.layout_biting_program_progress_display;
        obj.a(i6, new String[] { "layout_biting_program_progress_display" }, iArr2, iArr4);
        int[] iArr3 = new int[i6];
        iArr3[i15] = 10;
        int[] iArr = new int[i6];
        iArr[i15] = R.layout.layout_loading_spinner;
        obj.a(8, new String[] { "layout_loading_spinner" }, iArr3, iArr);
        obj.put(2131363435, 11);
        obj.put(2131363278, 12);
        obj.put(2131362389, 13);
        obj.put(2131362136, 14);
    }

    public pg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 15, pg.c0, pg.d0));
    }

    private boolean W(wh whVar, int i) {
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

    private boolean X(x<y<CertificateInfo>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.og
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 8L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        this.a0.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.og
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.og
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
        this.a0.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.og
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.og
    public void V(app.dogo.com.dogo_android.u.m.y.g gVar) {
        this.W = gVar;
        synchronized (this) {
            try {
                this.b0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.og
    protected void m() {
        int cmp;
        app.dogo.com.dogo_android.u.h hVar;
        long l;
        long l2;
        String string;
        String certificateRequirements;
        Object obj2;
        String str;
        Object obj3;
        y yVar;
        int cmp3;
        int i = 512;
        final Object obj = this;
        synchronized (this) {
            try {
                long l6 = 0L;
                obj.b0 = l6;
            } catch (Throwable th) {
            }
        }
        long l7 = l & 14L;
        long l8 = 16L;
        long l11 = 32L;
        final int i9 = 1;
        cmp3 = 0;
        cmp = 0;
        if (l7 != l6) {
            if (obj.W != null) {
                x xVar = obj.W.j();
                SpecialProgramOverviewItem.CertificateData certificateData = obj.W.i();
            } else {
            }
            obj.Q(i9, obj3);
            Object value = obj3 != null ? (LoadResult)value : cmp;
            if (obj.W != 0) {
                String certificatePlaceholderUrl = cmp.getCertificatePlaceholderUrl();
            } else {
            }
            long l14 = l & 12L;
            if (l14 != l6) {
                if (obj.W != 0) {
                    boolean certificateUnlocked = cmp.isCertificateUnlocked();
                    String programTitle = cmp.getProgramTitle();
                } else {
                }
                if (l14 != l6 && cmp3 != 0) {
                    l2 = (l | 32L) | 128L;
                    i = 512;
                    l = l2 | i;
                }
                cmp3 = 8;
                int r22 = cmp3 != 0 ? cmp3 : 8;
                if (cmp3 == 0) {
                }
                Object[] arr2 = new Object[i9];
                String string2 = obj.Q.getResources().getString(2131887132, new Object[] { cmp });
            } else {
            }
        } else {
        }
        long l12 = 32L & l;
        if (l12 != l6) {
            if (obj.W != null) {
                String dogName = hVar.getDogName();
            } else {
            }
            Object[] arr = new Object[i9];
            string = obj.O.getResources().getString(2131886257, new Object[] { cmp });
        } else {
        }
        long l9 = 16L & l;
        long l13 = 0L;
        if (l9 == l13 || obj.W == null) {
        } else {
            certificateRequirements = hVar.getCertificateRequirements();
        }
        long l10 = 12L & l;
        if (l10 != l13) {
            String r17 = cmp3 != 0 ? string : certificateRequirements;
        }
        if (l10 != l13) {
            g.c(obj.O, (cmp3 != 0 ? string : certificateRequirements));
            g.c(obj.Q, obj2);
            obj.R.w().setVisibility(cmp3);
            obj.R.T(hVar);
            obj.S.setVisibility(cmp3);
            obj.T.setVisibility(cmp3);
            obj.U.setVisibility(cmp3);
        }
        l &= 14;
        if (obj.b0 != 0) {
            ProgramBindingAdapters.t(obj.P, yVar, str);
            BindingAdapters.setDebugJsonEntryItemAdapter(obj.Z, yVar);
        }
        ViewDataBinding.o(obj.R);
        ViewDataBinding.o(obj.a0);
    }

    @Override // app.dogo.com.dogo_android.h.og
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z3 = true;
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        if (this.a0.y()) {
            return true;
        }
        return false;
    }

    private pg(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 2, (TextView)objectArr[7], (ImageView)objectArr[14], (ImageView)objectArr[2], (TextView)objectArr[6], (Guideline)objectArr[13], (wh)objectArr[9], (MaterialButton)objectArr[3], (MaterialButton)objectArr[5], (Space)objectArr[4], (Guideline)objectArr[12], (MaterialToolbar)objectArr[11]);
        eVar3.b0 = -1L;
        Object obj16 = null;
        eVar3.O.setTag(obj16);
        eVar3.P.setTag(obj16);
        eVar3.Q.setTag(obj16);
        Object obj12 = objectArr[0];
        eVar3.X = obj12;
        obj12.setTag(obj16);
        Object obj13 = objectArr[1];
        eVar3.Y = obj13;
        obj13.setTag(obj16);
        Object obj14 = objectArr[8];
        eVar3.Z = obj14;
        obj14.setTag(obj16);
        Object obj15 = objectArr[10];
        eVar3.a0 = obj15;
        eVar3.L(obj15);
        eVar3.L(eVar3.R);
        eVar3.S.setTag(obj16);
        eVar3.T.setTag(obj16);
        eVar3.U.setTag(obj16);
        eVar3.N(view);
        A();
    }
}
