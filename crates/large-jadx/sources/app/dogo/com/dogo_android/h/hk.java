package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;

/* compiled from: LayoutDashboardWorkoutCardBindingImpl.java */
/* loaded from: classes.dex */
public class hk extends gk implements b.a {

    private static final ViewDataBinding.g Z = new ViewDataBinding$g(10);
    private static final SparseIntArray a0 = new SparseIntArray();
    private final CardView U;
    private final ConstraintLayout V;
    private final View.OnClickListener W;
    private final View.OnClickListener X;
    private long Y;
    static {
        int i6 = 1;
        final int[] iArr = new int[i6];
        final int i12 = 0;
        iArr[i12] = 5;
        int[] iArr2 = new int[i6];
        iArr2[i12] = R.layout.layout_workout_streaks_combined;
        obj.a(i6, new String[] { "layout_workout_streaks_combined" }, iArr, iArr2);
        obj.put(2131362711, 6);
        obj.put(2131363414, 7);
        obj.put(2131362298, 8);
        obj.put(2131363156, 9);
    }

    public hk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 10, hk.Z, hk.a0));
    }

    private boolean V(kn knVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.gk
    public void A() {
        synchronized (this) {
            try {
                this.Y = 8L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gk
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.gk
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

    @Override // app.dogo.com.dogo_android.h.gk
    public void T(e0 e0Var) {
        this.S = e0Var;
        synchronized (this) {
            try {
                this.Y |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public void U(WorkoutSession workoutSession) {
        this.T = workoutSession;
        synchronized (this) {
            try {
                this.Y |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.S != null) {
            }
            if (i2 != 0) {
                this.S.onExploreTricksSelected();
            }
        } else {
            int i3 = 2;
            if (this.S == 2) {
                if (this.S != null) {
                }
                if (i2 != 0) {
                    this.S.p1();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.gk
    protected void m() {
        long l;
        int currentStreak;
        int i;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.Y = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 14L;
        long l8 = l & l6;
        final long l9 = 10L;
        currentStreak = 0;
        if (l8 != l5) {
            l4 = l & 10L;
            if (l4 != l5) {
                if (obj.T != null) {
                    currentStreak = obj.T.getCurrentStreak();
                    boolean streaksEnabled = obj.T.isStreaksEnabled();
                    currentStreak = obj.T.getLongestStreak();
                } else {
                }
                if (l4 != l5) {
                    int r16 = currentStreak != 0 ? 32 : 16;
                    l = l | (currentStreak != 0 ? 32 : 16);
                }
                if (currentStreak == 0) {
                    currentStreak = 8;
                }
            } else {
            }
        }
        long l7 = 14L & l;
        if (l7 != l5) {
            TrainingBindingAdapters.setTrickAdapter(obj.O, obj.T, obj.S);
        }
        l3 = 8L & l;
        if (obj.S != l5) {
            obj.P.setOnClickListener(obj.W);
            obj.Q.setOnClickListener(obj.X);
        }
        l2 = l & 10L;
        if (obj.Y != l5) {
            obj.R.w().setVisibility(currentStreak);
            obj.R.T(Integer.valueOf(currentStreak));
            obj.R.U(Integer.valueOf(currentStreak));
        }
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.Y != 0) {
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

    private hk(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i12 = 2;
        super(eVar, view, 1, (TextView)objectArr[8], (RecyclerView)objectArr[3], (ImageView)objectArr[i12], (ImageView)objectArr[6], (ImageView)objectArr[9], (Button)objectArr[4], (kn)objectArr[5], (TextView)objectArr[7]);
        eVar3.Y = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.P.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.U = obj9;
        obj9.setTag(obj10);
        int i10 = 1;
        Object obj11 = objectArr[i10];
        eVar3.V = obj11;
        obj11.setTag(obj10);
        eVar3.Q.setTag(obj10);
        L(eVar3.R);
        N(view);
        eVar3.W = new b(this, i10);
        eVar3.X = new b(this, i12);
        A();
    }
}
