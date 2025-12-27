package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.j;
import app.dogo.com.dogo_android.repository.domain.Library;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentLibraryBindingImpl.java */
/* loaded from: classes.dex */
public class vd extends ud implements c.a {

    private static final ViewDataBinding.g c0 = new ViewDataBinding$g(12);
    private static final SparseIntArray d0 = new SparseIntArray();
    private final ConstraintLayout Z;
    private final SwipeRefreshLayout.j a0;
    private long b0;
    static {
        i.a(2, new String[] { "layout_library_shortcuts", "layout_library_program_list", "layout_library_trick_list", "layout_library_game_list", "layout_library_skill_list", "layout_library_article_list", "layout_library_subscribe" }, new int[] { 3, 4, 5, 6, 7, 8, 9 }, new int[] { R.layout.layout_library_shortcuts, R.layout.layout_library_program_list, R.layout.layout_library_trick_list, R.layout.layout_library_game_list, R.layout.layout_library_skill_list, R.layout.layout_library_article_list, R.layout.layout_library_subscribe });
        i.put(2131362875, 10);
        i.put(2131363433, 11);
    }

    public vd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, vd.c0, vd.d0));
    }

    private boolean X(wk wkVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(yk ykVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(al alVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(el elVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(gl glVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(il ilVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean d0(kl klVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean e0(LiveData<y<Library>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 1024L;
            } catch (Throwable th) {
            }
        }
        this.S.A();
        this.R.A();
        this.W.A();
        this.P.A();
        this.T.A();
        this.O.A();
        this.U.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ud
    protected boolean E(int i, Object object, int i2) {
        switch (i) {
            case 0:
                return this.b0(object, i2);
            case 1:
                return this.X(object, i2);
            case 2:
                return this.c0(object, i2);
            case 3:
                return this.e0(object, i2);
            case 4:
                return this.d0(object, i2);
            case 5:
                return this.Y(object, i2);
            case 6:
                return this.a0(object, i2);
            case 7:
                return this.Z(object, i2);
            default:
                return false;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public void M(q qVar) {
        super.M(qVar);
        this.S.M(qVar);
        this.R.M(qVar);
        this.W.M(qVar);
        this.P.M(qVar);
        this.T.M(qVar);
        this.O.M(qVar);
        this.U.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public void V(g gVar) {
        this.Y = gVar;
        synchronized (this) {
            try {
                this.b0 |= 256;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public void W(j jVar) {
        this.X = jVar;
        synchronized (this) {
            try {
                this.b0 |= 512;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.X != null ? 1 : 0;
        if (i2 != 0) {
            this.X.t();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ud
    protected void m() {
        LiveData liveData;
        j jVar2;
        int i = 0;
        int i2 = 3;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.b0 = l3;
            } catch (Throwable th) {
            }
        }
        long l6 = 1800L & l;
        i = 0;
        if (l6 != l3) {
            if (this.X != null) {
                liveData = this.X.r();
            } else {
            }
            i2 = 3;
            Q(i2, liveData);
            if (this.X != null) {
            }
        }
        final y yVar = i;
        if (l6 != l3) {
            LibraryBindingAdapters.n(this.Q, yVar, gVar, this.W, this.P, this.T, this.O, this.R, this.U);
        }
        long l4 = 1544L & l;
        if (this.Q != l3) {
            BindingAdapters.setTrainerAvatar(this.Z, yVar);
            BindingAdapters.y0(this.V, yVar);
        }
        long l5 = 1280L & l;
        if (this.Z != l3) {
            this.U.T(this.Y);
        }
        long l2 = l & 1024L;
        if (this.b0 != l3) {
            this.V.setOnRefreshListener(this.a0);
        }
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.W);
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.T);
        ViewDataBinding.o(this.O);
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.ud
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z8 = true;
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.S.y()) {
            return true;
        }
        if (this.R.y()) {
            return true;
        }
        if (this.W.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        if (this.T.y()) {
            return true;
        }
        if (this.O.y()) {
            return true;
        }
        if (this.U.y()) {
            return true;
        }
        return false;
    }

    private vd(e eVar, View view, Object[] objectArr) {
        final Object eVar4 = this;
        super(eVar, view, 8, (wk)objectArr[8], (yk)objectArr[6], (ConstraintLayout)objectArr[2], (NestedScrollView)objectArr[10], (al)objectArr[4], (el)objectArr[3], (gl)objectArr[7], (il)objectArr[9], (SwipeRefreshLayout)objectArr[1], (MaterialToolbar)objectArr[11], (kl)obj);
        eVar4.b0 = -1L;
        eVar4.L(eVar4.O);
        eVar4.L(eVar4.P);
        Object obj13 = null;
        eVar4.Q.setTag(obj13);
        Object obj12 = objectArr[0];
        eVar4.Z = obj12;
        obj12.setTag(obj13);
        eVar4.L(eVar4.R);
        eVar4.L(eVar4.S);
        eVar4.L(eVar4.T);
        eVar4.L(eVar4.U);
        eVar4.V.setTag(obj13);
        eVar4.L(eVar4.W);
        eVar4.N(view);
        eVar4.a0 = new c(eVar4, 1);
        A();
    }
}
