package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.Article;

/* compiled from: CellFaqListRowBindingImpl.java */
/* loaded from: classes.dex */
public class r2 extends q2 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final RelativeLayout P;
    private final TextView Q;
    private long R;
    public r2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, r2.S, r2.T));
    }

    @Override // app.dogo.com.dogo_android.h.q2
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.q2
    public boolean O(int i, Object object) {
        boolean z = true;
        if (9 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.q2
    public void V(Article article) {
        this.O = article;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(9);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.q2
    protected void m() {
        Object obj = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.R & 3L;
        if (l2 != l3 && this.O != null) {
            String title = this.O.getTitle();
        }
        if (l2 != l3) {
            g.c(this.Q, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.q2
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

    private r2(e eVar, View view, Object[] objectArr) {
        int i = 0;
        super(eVar, view, i);
        this.R = -1L;
        Object obj2 = objectArr[i];
        this.P = obj2;
        Object obj = null;
        obj2.setTag(obj);
        Object obj3 = objectArr[1];
        this.Q = obj3;
        obj3.setTag(obj);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.q2
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
