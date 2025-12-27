package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellBreedListNewBreedRowBindingImpl.java */
/* loaded from: classes.dex */
public class d0 extends c0 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final RelativeLayout Q;
    private long R;
    public d0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, d0.S, d0.T));
    }

    @Override // app.dogo.com.dogo_android.h.c0
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c0
    public boolean O(int i, Object object) {
        boolean z = true;
        if (24 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.c0
    public void V(DogBreed dogBreed) {
        this.P = dogBreed;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(24);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c0
    protected void m() {
        String name = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.R & 3L;
        if (l2 != l3 && this.P != null) {
            name = this.P.getName();
        }
        if (l2 != l3) {
            BindingAdapters.faqFilter(this.O, name);
        }
    }

    @Override // app.dogo.com.dogo_android.h.c0
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private d0(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (TextView)objectArr[1]);
        this.R = -1L;
        Object obj2 = null;
        this.O.setTag(obj2);
        Object obj3 = objectArr[i2];
        this.Q = obj3;
        obj3.setTag(obj2);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.c0
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
