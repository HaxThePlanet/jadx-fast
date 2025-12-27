package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentWorkoutCompletedBindingImpl.java */
/* loaded from: classes.dex */
public class lh extends kh {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ScrollView T;
    private long U;
    static {
        obj.put(2131362339, 4);
        obj.put(2131363421, 5);
        obj.put(2131362237, 6);
    }

    public lh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, lh.V, lh.W));
    }

    @Override // app.dogo.com.dogo_android.h.kh
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kh
    public boolean O(int i, Object object) {
        boolean z = true;
        if (189 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.kh
    public void V(WorkoutStreakInfo workoutStreakInfo) {
        this.S = workoutStreakInfo;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(189);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kh
    protected void m() {
        long l;
        int longestStreak;
        Object obj = null;
        Object[] arr;
        int i = 8;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        int i3 = 0;
        final long l4 = 3L;
        long l5 = l & l4;
        longestStreak = 0;
        if (l5 != l3) {
            if (this.S != null) {
                longestStreak = this.S.getLongestStreak();
                longestStreak = this.S.getCurrentStreak();
            } else {
            }
            longestStreak = 1;
            int r5 = longestStreak;
            int i2 = 2131887691;
            arr = new Object[longestStreak];
            if (l5 != l3) {
                int r11 = longestStreak != 0 ? 8 : 4;
                l = l | (longestStreak != 0 ? 8 : 4);
            }
            if (longestStreak != 0) {
                longestStreak = 8;
            }
        }
        l &= l4;
        if (this.U != l3) {
            BindingAdapters.showLoading(this.P, this.S);
            this.P.setVisibility(longestStreak);
            this.Q.setVisibility(longestStreak);
            g.c(this.R, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.kh
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private lh(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Button)objectArr[6], (LottieAnimationView)objectArr[4], (TextView)objectArr[3], (ImageView)objectArr[2], (TextView)objectArr[1], (TextView)objectArr[5]);
        this.U = -1L;
        Object obj7 = null;
        this.P.setTag(obj7);
        Object obj8 = objectArr[0];
        this.T = obj8;
        obj8.setTag(obj7);
        this.Q.setTag(obj7);
        this.R.setTag(obj7);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kh
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
