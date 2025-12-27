package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import app.dogo.com.dogo_android.g.w;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutDashboardRecommendedProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class lj extends kj implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0 = new SparseIntArray();
    private final ConstraintLayout X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private long a0;
    static {
        obj.put(2131362986, 8);
        obj.put(2131362355, 9);
        obj.put(2131363036, 10);
        obj.put(2131363387, 11);
    }

    public lj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, lj.b0, lj.c0));
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public void A() {
        synchronized (this) {
            try {
                this.a0 = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                T(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public void T(w wVar) {
        this.W = wVar;
        synchronized (this) {
            try {
                this.a0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.V = programDescriptionItem;
        synchronized (this) {
            try {
                this.a0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.W != null) {
            }
            if (i2 != 0) {
                this.W.onOtherTrainingProgramsSelected(this.V);
            }
        } else {
            if (this.V == 2) {
                if (this.W != null) {
                }
                if (i2 != 0) {
                    this.W.onReviewProgramSelected("recommended_program_card");
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.kj
    protected void m() {
        int numberOfSkills;
        Object obj;
        int cmp;
        int i = 0;
        String str = null;
        String str2;
        Object obj3;
        java.lang.CharSequence charSequence;
        final Object obj2 = this;
        synchronized (this) {
            try {
                final long l3 = 0L;
                obj2.a0 = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 5L & l;
        i = 0;
        if (l4 != l3) {
            numberOfSkills = 0;
            if (obj2.V != null) {
                String name = obj2.V.getName();
                numberOfSkills = obj2.V.getModulesCount();
            } else {
            }
            int i6 = 1;
            Object[] arr2 = new Object[i6];
            arr2[numberOfSkills] = Integer.valueOf(numberOfSkills);
            String string2 = obj2.T.getResources().getString(2131887593, arr2);
            int i2 = 2131887581;
            Object[] arr = new Object[i6];
            arr[numberOfSkills] = Integer.valueOf(numberOfSkills);
            String string = obj2.U.getResources().getString(i2, arr);
        } else {
        }
        long l2 = l & 4L;
        if (obj2.a0 != l3) {
            obj2.O.setOnClickListener(obj2.Z);
            obj2.S.setOnClickListener(obj2.Y);
        }
        if (l4 != l3) {
            BindingAdapters.setRatingChange(obj2.P, str);
            BindingAdapters.w(obj2.Q, str2);
            g.c(obj2.R, charSequence);
            g.c(obj2.T, obj3);
            g.c(obj2.U, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public boolean y() {
        synchronized (this) {
            try {
                if (this.a0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private lj(e eVar, View view, Object[] objectArr) {
        final Object eVar4 = this;
        super(eVar, view, 0, (Button)objectArr[7], (ImageView)objectArr[9], (CardView)objectArr[1], (CardView)objectArr[8], (ImageView)objectArr[2], (TextView)objectArr[3], (TextView)objectArr[10], (Button)objectArr[6], (TextView)objectArr[4], (TextView)obj, (TextView)obj2);
        eVar4.a0 = -1L;
        Object obj13 = null;
        eVar4.O.setTag(obj13);
        Object obj12 = objectArr[0];
        eVar4.X = obj12;
        obj12.setTag(obj13);
        eVar4.P.setTag(obj13);
        eVar4.Q.setTag(obj13);
        eVar4.R.setTag(obj13);
        eVar4.S.setTag(obj13);
        eVar4.T.setTag(obj13);
        eVar4.U.setTag(obj13);
        eVar4.N(view);
        eVar4.Y = new b(eVar4, 1);
        eVar4.Z = new b(eVar4, 2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
