package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellWorkoutTrickCardBindingImpl.java */
/* loaded from: classes.dex */
public class d8 extends c8 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    public d8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, d8.T, d8.U));
    }

    @Override // app.dogo.com.dogo_android.h.c8
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c8
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.c8
    public void V(TrickItem trickItem) {
        this.Q = trickItem;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c8
    protected void m() {
        String imageUrl = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.S & 3L;
        if (l2 != l3 && this.Q != null) {
            imageUrl = this.Q.getImageUrl();
        }
        if (l2 != l3) {
            BindingAdapters.n0(this.O, imageUrl);
            LibraryBindingAdapters.r(this.P, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.c8
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

    private d8(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[1], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj3 = objectArr[0];
        this.R = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.c8
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
