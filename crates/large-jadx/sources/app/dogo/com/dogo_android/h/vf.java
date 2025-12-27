package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.z.g;

/* compiled from: FragmentProgramOverviewBindingImpl.java */
/* loaded from: classes.dex */
public class vf extends uf implements b.a {

    private static final ViewDataBinding.g m0;
    private static final SparseIntArray n0 = new SparseIntArray();
    private final Group j0;
    private final View.OnClickListener k0;
    private long l0;
    static {
        obj.put(2131363185, 18);
        obj.put(2131362420, 19);
        obj.put(2131362195, 20);
        obj.put(2131363235, 21);
        obj.put(2131362323, 22);
        obj.put(2131362415, 23);
        obj.put(2131362620, 24);
        obj.put(2131362324, 25);
        obj.put(2131362353, 26);
        obj.put(2131363524, 27);
        obj.put(2131363457, 28);
        obj.put(2131363454, 29);
        obj.put(2131362999, 30);
        obj.put(2131362061, 31);
        obj.put(2131363494, 32);
        obj.put(2131363495, 33);
        obj.put(2131362092, 34);
    }

    public vf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 35, vf.m0, vf.n0));
    }

    private boolean X(f.d.a.a<y<ProgramLessonItem>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(x<y<ProgramOverview>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public void A() {
        synchronized (this) {
            try {
                this.l0 = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.uf
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public boolean O(int i, Object object) {
        int i2 = 128;
        boolean z = true;
        i2 = 128;
        if (128 == i) {
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

    @Override // app.dogo.com.dogo_android.h.uf
    public void V(String str) {
        this.i0 = str;
        synchronized (this) {
            try {
                this.l0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(128);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public void W(g gVar) {
        this.h0 = gVar;
        synchronized (this) {
            try {
                this.l0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.h0 != null ? 1 : 0;
        if (i2 != 0) {
            this.h0.x();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uf
    protected void m() {
        int cmp;
        Object obj;
        y yVar;
        Object obj2;
        int i2;
        y yVar2;
        long l = 0;
        int cmp5 = 1;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.l0 = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 20L & l2;
        long l6 = 27L & l2;
        final long l8 = 26L;
        long l9 = 25L;
        final Boolean bool = null;
        if (l6 != l4) {
            l = l2 & 25L;
            if (l != l4) {
                if (this.h0 != null) {
                    x xVar = this.h0.t();
                } else {
                    int i7 = bool;
                }
                Q(0, obj2);
                Object value2 = obj2 != null ? (LoadResult)value2 : bool;
            }
            long l11 = l2 & 26L;
            if (l11 != l4) {
                if (this.h0 != null) {
                    f.d.a.a aVar = this.h0.s();
                } else {
                    int i3 = bool;
                }
                cmp5 = 1;
                Q(cmp5, obj);
                Object value = this.h0 != null ? (LoadResult)value : bool;
            }
        } else {
        }
        long l10 = 25L & l2;
        if (l10 != l4) {
            ProgramBindingAdapters.x0(this.O, yVar2);
            BindingAdapters.I0(this.P, yVar2);
            ProgramBindingAdapters.y0(this.Q, yVar2);
            ProgramBindingAdapters.e0(this.T, yVar2);
            ProgramBindingAdapters.r0(this.U, yVar2);
            ProgramBindingAdapters.z0(this.V, yVar2);
            ProgramBindingAdapters.d0(this.W, yVar2);
            BindingAdapters.w0(this.j0, yVar2);
            ProgramBindingAdapters.setHtmlText(this.Z, yVar2);
            BindingAdapters.setTrainerAvatar(this.a0, yVar2);
            ProgramBindingAdapters.f0(this.c0, yVar2);
            ProgramBindingAdapters.z0(this.d0, yVar2);
            ProgramBindingAdapters.setProgressBar(this.e0, yVar2);
            ProgramBindingAdapters.w0(this.f0, yVar2);
            ProgramBindingAdapters.setProgramQuestionAdapter(this.g0, yVar2);
        }
        long l7 = l2 & 26L;
        if (l7 != l4) {
            BindingAdapters.Z(this.P, yVar);
        }
        long l3 = l2 & 16L;
        if (this.l0 != l4) {
            this.P.setOnClickListener(this.k0);
            BindingAdapters.k0(this.R, bool);
            BindingAdapters.k0(this.e0, bool);
        }
        if (l5 != l4) {
            BindingAdapters.j0(this.X, this.i0);
            ProgramBindingAdapters.x(this.Y, this.i0);
        }
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public boolean y() {
        synchronized (this) {
            try {
                if (this.l0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private vf(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (TextView)objectArr[15], (AppCompatImageView)objectArr[31], (Button)objectArr[17], (View)objectArr[34], (AppCompatImageView)objectArr[13], (ImageView)objectArr[5], (FrameLayout)objectArr[20], (TextView)objectArr[9], (View)objectArr[22], (View)objectArr[25], (LinearLayout)objectArr[11], (TextView)objectArr[26], (AppCompatImageView)objectArr[3], (AppCompatImageView)objectArr[23], (TextView)objectArr[7], (AppCompatImageView)objectArr[19], (AppCompatImageView)objectArr[6], (View)objectArr[1], (AppCompatImageView)objectArr[24], (TextView)objectArr[30], (RecyclerView)objectArr[10], (ConstraintLayout)objectArr[0], (NestedScrollView)objectArr[18], (AppCompatImageView)objectArr[21], (TextView)objectArr[8], (AppCompatImageView)objectArr[2], (TextView)objectArr[4], (AppCompatImageView)objectArr[29], (TextView)objectArr[28], (View)objectArr[32], (TextView)objectArr[33], (TextView)objectArr[14], (LinearLayout)objectArr[12], (TextView)objectArr[27]);
        Object eVar4 = this;
        eVar4.l0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.P.setTag(obj2);
        eVar4.Q.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.T.setTag(obj2);
        eVar4.U.setTag(obj2);
        eVar4.V.setTag(obj2);
        eVar4.W.setTag(obj2);
        eVar4.X.setTag(obj2);
        eVar4.Y.setTag(obj2);
        Object obj = objectArr[16];
        eVar4.j0 = obj;
        obj.setTag(obj2);
        eVar4.Z.setTag(obj2);
        eVar4.a0.setTag(obj2);
        eVar4.c0.setTag(obj2);
        eVar4.d0.setTag(obj2);
        eVar4.e0.setTag(obj2);
        eVar4.f0.setTag(obj2);
        eVar4.g0.setTag(obj2);
        eVar4.N(view);
        eVar4.k0 = new b(eVar4, 1);
        A();
    }
}
