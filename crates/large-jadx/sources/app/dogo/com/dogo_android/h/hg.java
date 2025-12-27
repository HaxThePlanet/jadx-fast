package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentRateTrickV2BindingImpl.java */
/* loaded from: classes.dex */
public class hg extends gg implements b.a {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(7);
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout S;
    private final ScrollView T;
    private final View.OnClickListener U;
    private long V;
    static {
        int i4 = 1;
        final int[] iArr = new int[i4];
        final int i8 = 0;
        iArr[i8] = 4;
        int[] iArr2 = new int[i4];
        iArr2[i8] = R.layout.layout_rate;
        obj.a(i4, new String[] { "layout_rate" }, iArr, iArr2);
        obj.put(2131362322, 5);
        obj.put(2131362956, 6);
    }

    public hg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, hg.W, hg.X));
    }

    private boolean V(om omVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(f.d.a.a<y<Boolean>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public void A() {
        synchronized (this) {
            try {
                this.V = 16L;
            } catch (Throwable th) {
            }
        }
        this.Q.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gg
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return V(object, i2);
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public void M(q qVar) {
        super.M(qVar);
        this.Q.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            Y(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public void Y(app.dogo.com.dogo_android.n.m.t.g gVar) {
        this.R = gVar;
        synchronized (this) {
            try {
                this.V |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.R != null ? 1 : 0;
        if (i2 != 0) {
            this.R.G(this.R.C());
        }
    }

    @Override // app.dogo.com.dogo_android.h.gg
    protected void m() {
        long l;
        int cmp;
        long l2;
        int i;
        y yVar;
        int i2;
        String string;
        int i3 = 2131887156;
        long l4 = 25;
        Object obj2;
        int cmp4;
        Object obj3;
        Integer num;
        long l6;
        int i4;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l10 = 0L;
                obj.V = l10;
            } catch (Throwable th) {
            }
        }
        long l11 = 27L & l;
        long l3 = 26L;
        long l12 = 24L;
        l4 = 25L;
        long l16 = 1024L;
        i2 = 0;
        i = 0;
        if (l11 != l10) {
            l6 = l & 25L;
            if (l6 != l10) {
                x xVar = obj.R != null ? xVar : i2;
                obj.Q(i, obj3);
                Object value2 = obj3 != null ? (Integer)value2 : i2;
                int r11 = ViewDataBinding.J(num) > 0 ? 1 : i;
                if (l6 != l10 && i != 0) {
                    l2 = l | 64L;
                    i4 = 256;
                    l = l2 | i4;
                }
                i = 4;
                int r12 = i != 0 ? 4 : i;
                if (i != 0) {
                }
            } else {
            }
            long l17 = l & 24L;
            if (l17 != l10) {
                if (obj.R != null) {
                    String str = obj.R.w();
                } else {
                }
                int r20 = i2 != 0 ? 1 : i;
                if (l17 != l10) {
                    l = i != 0 ? l | l16 : l | l8;
                }
            } else {
            }
            l7 = l & 26L;
            if (l7 != l10) {
                if (obj.R != null) {
                    f.d.a.a aVar = obj.R.D();
                } else {
                }
                obj.Q(1, obj2);
                Object value = obj2 != null ? (LoadResult)value : i2;
            }
        } else {
        }
        l5 = 1024L & l;
        if (l5 != l10) {
            Object[] arr = new Object[1];
            String string2 = obj.P.getResources().getString(2131887154, new Object[] { i2 });
        } else {
        }
        long l13 = 24L & l;
        if (l13 != l10 && i != 0) {
        }
        long l14 = 25L & l;
        if (l14 != l10) {
            obj.O.setVisibility(i);
            obj.P.setVisibility(i);
        }
        long l15 = 26L & l;
        if (obj.P != l10) {
            BindingAdapters.Z(obj.P, yVar);
            BindingAdapters.setTrainerAvatar(obj.S, yVar);
        }
        l &= 16;
        if (obj.V != l10) {
            obj.P.setOnClickListener(obj.U);
        }
        if (l13 != l10) {
            g.c(obj.P, i2);
            obj.Q.T(obj.R);
        }
        ViewDataBinding.o(obj.Q);
    }

    @Override // app.dogo.com.dogo_android.h.gg
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.Q.y()) {
            return true;
        }
        return false;
    }

    private hg(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 3, (Button)objectArr[2], (Button)objectArr[3], (ImageView)objectArr[5], (om)objectArr[4], (TextView)objectArr[6]);
        this.V = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        L(this.Q);
        Object obj7 = objectArr[0];
        this.S = obj7;
        obj7.setTag(obj6);
        int i9 = 1;
        final Object obj8 = objectArr[i9];
        this.T = obj8;
        obj8.setTag(obj6);
        N(view);
        this.U = new b(this, i9);
        A();
    }
}
