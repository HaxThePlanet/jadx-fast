package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutProgramOverviewCertificateBindingImpl.java */
/* loaded from: classes.dex */
public class hm extends gm {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private long S;
    static {
        obj.put(2131361940, 3);
    }

    public hm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, hm.T, hm.U));
    }

    @Override // app.dogo.com.dogo_android.h.gm
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gm
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

    @Override // app.dogo.com.dogo_android.h.gm
    public void T(Program program) {
        this.R = program;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gm
    protected void m() {
        long l;
        String certificatePaperImage;
        Object obj;
        int cmp2 = 8;
        String name = null;
        int i2 = 4;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 3L;
        long l5 = l & l4;
        int i = 0;
        cmp2 = 0;
        if (l5 != l3) {
            cmp2 = 1;
            int r11 = cmp2;
            if (l5 != l3) {
                int r12 = cmp2 != 0 ? 8 : 4;
                l = l | (cmp2 != 0 ? 8 : 4);
            }
            if (this.R != null) {
            } else {
            }
            int r7 = cmp2 != 0 ? cmp2 : 8;
            int i3 = 2131887132;
            Object[] arr = new Object[cmp2];
            cmp2 = (cmp2 != 0 ? cmp2 : 8);
        } else {
        }
        l &= l4;
        if (this.S != l3) {
            BindingAdapters.w(this.O, certificatePaperImage);
            this.P.setVisibility(cmp2);
            g.c(this.Q, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gm
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private hm(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[3], (ImageView)objectArr[1], (CardView)objectArr[0], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gm
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
