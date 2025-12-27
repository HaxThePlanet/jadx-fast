package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* compiled from: LayoutTrainingStreakStatsBindingImpl.java */
/* loaded from: classes.dex */
public class hn extends gn {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131362261, 4);
        obj.put(2131362260, 5);
        obj.put(2131362262, 6);
        obj.put(2131362322, 7);
        obj.put(2131362756, 8);
        obj.put(2131362755, 9);
        obj.put(2131362333, 10);
        obj.put(2131363409, 11);
        obj.put(2131363408, 12);
    }

    public hn(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 13, hn.U, hn.V));
    }

    @Override // app.dogo.com.dogo_android.h.gn
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gn
    public boolean O(int i, Object object) {
        boolean z = true;
        if (127 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.gn
    public void V(ProfilePreview profilePreview) {
        this.R = profilePreview;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(127);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gn
    protected void m() {
        Object obj = null;
        int longestStreak;
        Object obj2;
        long timeTrained;
        TextView textView4;
        synchronized (this) {
            try {
                timeTrained = 0L;
                this.T = timeTrained;
            } catch (Throwable th) {
            }
        }
        final long l3 = 3L;
        long l2 = this.T & l3;
        if (l2 != timeTrained) {
            longestStreak = 0;
            if (this.R != null) {
                longestStreak = this.R.getLongestStreak();
                longestStreak = this.R.getCurrentStreak();
                timeTrained = this.R.getTimeTrained();
            } else {
            }
            int i3 = 1;
            Object[] arr2 = new Object[i3];
            arr2[longestStreak] = Integer.valueOf(longestStreak);
            int i2 = 2131755018;
            this.P.getResources().getQuantityString(i2, longestStreak, arr2);
            Object[] arr3 = new Object[i3];
            arr3[longestStreak] = Integer.valueOf(longestStreak);
            String quantityString2 = this.P.getResources().getQuantityString(i2, longestStreak, arr3);
            Object[] arr4 = new Object[i3];
            arr4[longestStreak] = Integer.valueOf(longestStreak);
            this.O.getResources().getQuantityString(i2, longestStreak, arr4);
            Object[] arr = new Object[i3];
            arr[longestStreak] = Integer.valueOf(longestStreak);
            String quantityString = this.O.getResources().getQuantityString(i2, longestStreak, arr);
        } else {
        }
        if (l2 != timeTrained) {
            g.c(this.O, obj);
            g.c(this.P, obj2);
            DogProfileBindingAdapters.dogBreedFilter(this.Q, textView4);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gn
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private hn(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[1], (ImageView)objectArr[5], (ConstraintLayout)objectArr[4], (TextView)objectArr[6], (View)objectArr[7], (View)objectArr[10], (TextView)objectArr[2], (ImageView)objectArr[9], (ConstraintLayout)objectArr[8], (TextView)objectArr[3], (ImageView)objectArr[12], (ConstraintLayout)obj);
        Object eVar3 = this;
        eVar3.T = -1L;
        Object obj14 = null;
        eVar3.O.setTag(obj14);
        eVar3.P.setTag(obj14);
        Object obj13 = objectArr[0];
        eVar3.S = obj13;
        obj13.setTag(obj14);
        eVar3.Q.setTag(obj14);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gn
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
