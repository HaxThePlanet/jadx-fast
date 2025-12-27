package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.u.m.v.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import java.util.List;

/* compiled from: FragmentBitingProgramVariationsUnlockedBindingImpl.java */
/* loaded from: classes.dex */
public class ba extends aa {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private long Y;
    static {
        obj.put(2131363185, 6);
        obj.put(2131363441, 7);
        obj.put(2131363414, 8);
        obj.put(2131363529, 9);
        obj.put(2131362298, 10);
        obj.put(2131362322, 11);
        obj.put(2131362505, 12);
    }

    public ba(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 13, ba.Z, ba.a0));
    }

    private boolean X(androidx.lifecycle.x<y<List<TrickItem>>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.aa
    public void A() {
        synchronized (this) {
            try {
                this.Y = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.aa
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.aa
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

    @Override // app.dogo.com.dogo_android.h.aa
    public void V(v.a aVar) {
        this.X = aVar;
        synchronized (this) {
            try {
                this.Y |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.aa
    public void W(app.dogo.com.dogo_android.u.m.x xVar) {
        this.W = xVar;
        synchronized (this) {
            try {
                this.Y |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.aa
    protected void m() {
        Object obj;
        y yVar;
        int cmp3;
        int cmp4;
        int i2;
        java.lang.CharSequence charSequence;
        String str;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.Y = l3;
            } catch (Throwable th) {
            }
        }
        long l5 = 15L & l;
        final long l6 = 12L;
        final Boolean bool = null;
        if (l5 != l3) {
            long l7 = l & 12L;
            if (l7 != l3) {
                if (this.W != null) {
                    TrickItem trickItem = this.W.l();
                } else {
                    cmp4 = bool;
                }
                if (cmp4 != 0) {
                    String imageUrl = cmp4.getImageUrl();
                    String name = cmp4.getName();
                } else {
                }
            }
            if (this.W != null) {
                androidx.lifecycle.x data = this.W.loadData();
            } else {
                int i5 = bool;
            }
            int i3 = 0;
            Q(i3, obj);
            Object value = this.W != null ? (LoadResult)value : bool;
        } else {
        }
        if (l5 != l3) {
            ProgramBindingAdapters.setProgramExamListAdapter(this.Q, yVar, this.X);
        }
        long l4 = 8L & l;
        if (this.X != l3) {
            cmp3 = 2130772022;
            BindingAdapters.o0(this.R, AnimationUtils.loadAnimation(w().getContext(), cmp3));
            BindingAdapters.k0(this.S, bool);
        }
        long l2 = l & 12L;
        if (this.Y != l3) {
            BindingAdapters.n0(this.U, str);
            g.c(this.V, charSequence);
        }
    }

    @Override // app.dogo.com.dogo_android.h.aa
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Y != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private ba(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ConstraintLayout)objectArr[0], (TextView)objectArr[10], (ImageView)objectArr[11], (MaterialButton)objectArr[12], (RecyclerView)objectArr[5], (NestedScrollView)objectArr[6], (ImageView)objectArr[1], (TextView)objectArr[8], (FrameLayout)objectArr[3], (MaterialToolbar)objectArr[7], (ImageView)objectArr[2], (TextView)objectArr[4], (View)objectArr[9]);
        Object eVar3 = this;
        eVar3.Y = -1L;
        Object obj = null;
        eVar3.O.setTag(obj);
        eVar3.Q.setTag(obj);
        eVar3.R.setTag(obj);
        eVar3.S.setTag(obj);
        eVar3.U.setTag(obj);
        eVar3.V.setTag(obj);
        eVar3.N(view);
        A();
    }
}
