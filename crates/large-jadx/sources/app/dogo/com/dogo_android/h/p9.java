package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.v.d.a;

/* compiled from: DialogProgramLessonIntroductionBindingImpl.java */
/* loaded from: classes.dex */
public class p9 extends o9 {

    private static final ViewDataBinding.g X = new ViewDataBinding$g(6);
    private static final SparseIntArray Y = new SparseIntArray();
    private final CardView U;
    private final ConstraintLayout V;
    private long W;
    static {
        int i4 = 1;
        final int[] iArr = new int[i4];
        final int i8 = 0;
        iArr[i8] = 3;
        int[] iArr2 = new int[i4];
        iArr2[i8] = R.layout.cell_program_lesson_introduction_top;
        obj.a(i4, new String[] { "cell_program_lesson_introduction_top" }, iArr, iArr2);
        obj.put(2131363331, 4);
        obj.put(2131362887, 5);
    }

    public p9(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, p9.X, p9.Y));
    }

    private boolean X(e5 e5Var, int i) {
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

    @Override // app.dogo.com.dogo_android.h.o9
    public void A() {
        synchronized (this) {
            try {
                this.W = 8L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o9
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.o9
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.o9
    public boolean O(int i, Object object) {
        int i2 = 4;
        boolean z = true;
        i2 = 4;
        if (4 == i) {
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

    @Override // app.dogo.com.dogo_android.h.o9
    public void V(d.a aVar) {
        this.T = aVar;
        synchronized (this) {
            try {
                this.W |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(4);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.o9
    public void W(app.dogo.com.dogo_android.y.v.e eVar) {
        this.S = eVar;
        synchronized (this) {
            try {
                this.W |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.o9
    protected void m() {
        int i = 0;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.W = l4;
            } catch (Throwable th) {
            }
        }
        i = 0;
        long l = 14L;
        long l3 = this.W & l;
        if (l3 != l4 && this.S != null) {
            java.util.List listOfLessonIntroduction = this.S.listOfLessonIntroduction();
        }
        if (l3 != l4) {
            ProgramBindingAdapters.H(this.O, this.T, this.Q, i, this.P, this.R);
        }
        ViewDataBinding.o(this.R);
    }

    @Override // app.dogo.com.dogo_android.h.o9
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private p9(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ViewPager2)objectArr[2], (Button)objectArr[5], (TabLayout)objectArr[4], (e5)objectArr[3]);
        this.W = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.U = obj6;
        obj6.setTag(obj5);
        Object obj7 = objectArr[1];
        this.V = obj7;
        obj7.setTag(obj5);
        L(this.R);
        N(view);
        A();
    }
}
