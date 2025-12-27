package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.f.l.i.b;
import app.dogo.com.dogo_android.f.l.l;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: FragmentTodaysWorkoutBindingImpl.java */
/* loaded from: classes.dex */
public class zg extends yg {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z = new SparseIntArray();
    private long X;
    static {
        obj.put(2131363279, 3);
        obj.put(2131363433, 4);
        obj.put(2131363005, 5);
        obj.put(2131363554, 6);
        obj.put(2131362371, 7);
    }

    public zg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, zg.Y, zg.Z));
    }

    @Override // app.dogo.com.dogo_android.h.yg
    public void A() {
        synchronized (this) {
            try {
                this.X = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yg
    public boolean O(int i, Object object) {
        int i2 = 119;
        boolean z = true;
        i2 = 119;
        if (119 == i) {
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

    @Override // app.dogo.com.dogo_android.h.yg
    public void V(i.b bVar) {
        this.W = bVar;
        synchronized (this) {
            try {
                this.X |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(119);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yg
    public void W(l lVar) {
        this.V = lVar;
        synchronized (this) {
            try {
                this.X |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yg
    protected void m() {
        int cmp;
        app.dogo.com.dogo_android.util.ViewPagerCustomDuration viewPagerCustomDuration;
        app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.X = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l4 = 7L & l;
        if (l4 != l3 && this.V != null) {
            workoutSession = this.V.r();
        }
        long l2 = l & 4L;
        if (this.X != l3) {
            app.dogo.com.dogo_android.util.binding.m.c(this.P, this.Q);
        }
        if (l4 != l3) {
            TrainingBindingAdapters.setLibraryTrickVideoDetailsTab(this.Q, workoutSession, this.W, this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yg
    public boolean y() {
        synchronized (this) {
            try {
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private zg(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (ClickerSoundMaterialButton)objectArr[2], (ViewPagerCustomDuration)objectArr[1], (View)objectArr[7], (SegmentedProgressBar)objectArr[5], (Guideline)objectArr[3], (MaterialToolbar)objectArr[4], (View)objectArr[6]);
        eVar3.X = -1L;
        Object obj9 = null;
        eVar3.O.setTag(obj9);
        eVar3.P.setTag(obj9);
        eVar3.Q.setTag(obj9);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yg
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
