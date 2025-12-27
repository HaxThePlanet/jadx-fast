package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.Article;

/* compiled from: FragmentFaqDetailBindingImpl.java */
/* loaded from: classes.dex */
public class dd extends cd {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131363433, 3);
    }

    public dd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, dd.U, dd.V));
    }

    @Override // app.dogo.com.dogo_android.h.cd
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cd
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

    @Override // app.dogo.com.dogo_android.h.cd
    public void V(Article article) {
        this.R = article;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(9);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cd
    protected void m() {
        Object obj = null;
        Object obj2;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.T & 3L;
        if (l2 == l3 || this.R == null) {
        } else {
            String text = this.R.getText();
            String title = this.R.getTitle();
        }
        if (l2 != l3) {
            g.c(this.O, obj);
            g.c(this.P, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cd
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

    private dd(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (TextView)objectArr[1], (MaterialToolbar)objectArr[3]);
        this.T = -1L;
        Object obj4 = objectArr[0];
        this.S = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cd
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
