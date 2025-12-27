package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutPottyOverviewArticlesBindingImpl.java */
/* loaded from: classes.dex */
public class tl extends sl {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout Q;
    private final RecyclerView R;
    private long S;
    static {
        obj.put(2131363207, 2);
    }

    public tl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, tl.T, tl.U));
    }

    @Override // app.dogo.com.dogo_android.h.sl
    public void A() {
        synchronized (this) {
            try {
                this.S = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sl
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.sl
    public void V(j jVar) {
        this.P = jVar;
        synchronized (this) {
            try {
                this.S |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sl
    public void W(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.O = specialProgramOverviewItem;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sl
    protected void m() {
        java.util.List articlesWithProgress = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.S & 7L;
        if (l2 != l3 && this.O != null) {
            articlesWithProgress = this.O.getArticlesWithProgress();
        }
        if (l2 != l3) {
            ProgramBindingAdapters.v0(this.R, articlesWithProgress, this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.sl
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

    private tl(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (TextView)objectArr[2]);
        this.S = -1L;
        Object obj3 = objectArr[i2];
        this.Q = obj3;
        Object obj2 = null;
        obj3.setTag(obj2);
        Object obj4 = objectArr[1];
        this.R = obj4;
        obj4.setTag(obj2);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.sl
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
