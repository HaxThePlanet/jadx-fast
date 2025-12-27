package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import com.google.android.material.chip.Chip;

/* compiled from: CellLibraryTagBindingImpl.java */
/* loaded from: classes.dex */
public class f3 extends e3 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private final Chip P;
    private long Q;
    public f3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 1, f3.R, f3.S));
    }

    @Override // app.dogo.com.dogo_android.h.e3
    public void A() {
        synchronized (this) {
            try {
                this.Q = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e3
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

    @Override // app.dogo.com.dogo_android.h.e3
    public void V(LibraryTag libraryTag) {
        this.O = libraryTag;
        synchronized (this) {
            try {
                this.Q |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.e3
    protected void m() {
        Object obj = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.Q = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.Q & 3L;
        if (l2 != l3 && this.O != null) {
            String name = this.O.getName();
        }
        if (l2 != l3) {
            g.c(this.P, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.e3
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Q != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private f3(e eVar, View view, Object[] objectArr) {
        final int i = 0;
        super(eVar, view, i);
        this.Q = -1L;
        final Object obj = objectArr[i];
        this.P = obj;
        obj.setTag(null);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.e3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
