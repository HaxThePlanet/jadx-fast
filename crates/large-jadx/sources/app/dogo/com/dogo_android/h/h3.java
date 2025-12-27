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
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellLibraryTrickItemBindingImpl.java */
/* loaded from: classes.dex */
public class h3 extends g3 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    public h3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, h3.U, h3.V));
    }

    @Override // app.dogo.com.dogo_android.h.g3
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g3
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            W(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.g3
    public void W(TrickItem trickItem) {
        this.R = trickItem;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g3
    protected void m() {
        long l;
        String imageUrl = null;
        int knowledge;
        boolean ratingBarVisible;
        int i;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        int i2 = 0;
        final long l4 = 3L;
        long l5 = l & l4;
        knowledge = 0;
        if (l5 != l3) {
            if (this.R != null) {
                imageUrl = this.R.getImageUrl();
                knowledge = this.R.getKnowledge();
                ratingBarVisible = this.R.getRatingBarVisible();
            } else {
            }
            if (l5 != l3) {
                int r12 = ratingBarVisible ? 8 : 4;
                l = l | (ratingBarVisible ? 8 : 4);
            }
            if (!(ratingBarVisible)) {
                knowledge = 8;
            }
        } else {
        }
        l &= l4;
        if (this.T != l3) {
            TrainingBindingAdapters.setLibraryTrickAdapter(this.O, knowledge);
            this.O.setVisibility(knowledge);
            BindingAdapters.n0(this.P, imageUrl);
            LibraryBindingAdapters.setupTrickDetailsToolbar(this.Q, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g3
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

    private h3(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[2], (ImageView)objectArr[1], (TextView)objectArr[3]);
        this.T = -1L;
        Object obj4 = objectArr[0];
        this.S = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.g3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
