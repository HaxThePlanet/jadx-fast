package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.k.m;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: FragmentLibraryArticleDetailsBindingImpl.java */
/* loaded from: classes.dex */
public class rd extends qd {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        obj.put(2131363185, 6);
        obj.put(2131363441, 7);
        obj.put(2131362483, 8);
    }

    public rd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, rd.X, rd.Y));
    }

    private boolean W(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.qd
    public void A() {
        synchronized (this) {
            try {
                this.W = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qd
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.qd
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

    @Override // app.dogo.com.dogo_android.h.qd
    public void V(m mVar) {
        this.U = mVar;
        synchronized (this) {
            try {
                this.W |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qd
    protected void m() {
        Object obj;
        y yVar;
        int i2;
        Article article2;
        java.lang.CharSequence charSequence;
        String str;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.W = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 7L & l;
        long l5 = 6L;
        final Boolean bool = null;
        if (l4 != l3) {
            long l7 = l & 6L;
            if (l7 != l3) {
                if (this.U != null) {
                    Article article = this.U.j();
                } else {
                    i2 = bool;
                }
                if (i2 != 0) {
                    String title = i2.getTitle();
                    String image = i2.getImage();
                } else {
                    i2 = bool;
                }
            } else {
            }
            if (this.U != null) {
                x xVar = this.U.l();
            } else {
                int i4 = bool;
            }
            int i3 = 0;
            Q(i3, obj);
            Object value = this.U != null ? (LoadResult)value : bool;
        } else {
        }
        long l6 = 6L & l;
        if (l6 != l3) {
            ProgramBindingAdapters.addCompleteTaskView(this.O, article2, this.Q);
            g.c(this.P, charSequence);
            LibraryBindingAdapters.f(this.R, str);
        }
        if (l4 != l3) {
            BindingAdapters.Z(this.Q, yVar);
            BindingAdapters.x0(this.V, yVar);
        }
        long l2 = l & 4L;
        if (this.W != l3) {
            BindingAdapters.k0(this.S, bool);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qd
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private rd(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 1, (WebView)objectArr[4], (TextView)objectArr[3], (ImageView)objectArr[8], (MaterialButton)objectArr[5], (ImageView)objectArr[1], (ScrollView)objectArr[6], (FrameLayout)objectArr[2], (MaterialToolbar)objectArr[7]);
        eVar3.W = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.P.setTag(obj10);
        eVar3.Q.setTag(obj10);
        eVar3.R.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.V = obj9;
        obj9.setTag(obj10);
        eVar3.S.setTag(obj10);
        N(view);
        A();
    }
}
