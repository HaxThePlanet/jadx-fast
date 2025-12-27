package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.profile.invitation.g;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogInviteBindingImpl.java */
/* loaded from: classes.dex */
public class jc extends ic implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final View.OnClickListener U;
    private final View.OnClickListener V;
    private long W;
    public jc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, jc.X, jc.Y));
    }

    private boolean W(LiveData<y<DogOwnerInvitation>> liveData, int i) {
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

    private boolean X(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ic
    public void A() {
        synchronized (this) {
            try {
                this.W = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ic
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ic
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

    @Override // app.dogo.com.dogo_android.h.ic
    public void V(g gVar) {
        this.T = gVar;
        synchronized (this) {
            try {
                this.W |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ic
    public final void b(int i, View view) {
        int view22;
        view22 = 0;
        view22 = 1;
        if (i == view22) {
            int r1 = this.T != null ? view22 : 0;
            if (view22 != null && result != null) {
                if (view22 != null) {
                    this.T.setInviteId((LoadResult)result.getValue());
                }
            }
        } else {
            view22 = 2;
            if (this.T == 2) {
                if (this.T != null) {
                }
                if (view22 != null) {
                    this.T.s();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ic
    protected void m() {
        Object obj;
        LiveData result;
        int i;
        y yVar;
        y yVar2 = null;
        long l = 0;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.W = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 15L & l2;
        long l6 = 13L;
        long l8 = 14L;
        i = 0;
        if (l5 != l4) {
            l = l2 & 13L;
            if (l != l4) {
                if (this.T != null) {
                    result = this.T.getResult();
                } else {
                }
                Q(0, result);
                Object value2 = result != null ? (LoadResult)value2 : i;
            }
            long l10 = l2 & 14L;
            if (l10 != l4) {
                if (this.T != null) {
                    x xVar = this.T.n();
                } else {
                }
                int cmp5 = 1;
                Q(cmp5, obj);
                if (this.T != null) {
                }
            }
        } else {
        }
        long l9 = 14L & l2;
        if (l9 != l4) {
            BindingAdapters.Z(this.O, yVar2);
            BindingAdapters.x0(this.P, yVar2);
        }
        long l7 = 13L & l2;
        if (l7 != l4) {
            BindingAdapters.w0(this.O, yVar);
            BindingAdapters.w0(this.Q, yVar);
            DogProfileBindingAdapters.t(this.R, yVar);
            DogProfileBindingAdapters.v(this.S, yVar);
        }
        long l3 = l2 & 8L;
        if (this.W != l4) {
            this.O.setOnClickListener(this.U);
            this.Q.setOnClickListener(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ic
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

    private jc(e eVar, View view, Object[] objectArr) {
        int i4 = 1;
        final int i7 = 2;
        super(eVar, view, 2, (Button)objectArr[3], (ConstraintLayout)objectArr[0], (Button)objectArr[4], (ImageView)objectArr[i4], (TextView)objectArr[i7]);
        this.W = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        this.R.setTag(obj6);
        this.S.setTag(obj6);
        N(view);
        this.U = new b(this, i4);
        this.V = new b(this, i7);
        A();
    }

}
