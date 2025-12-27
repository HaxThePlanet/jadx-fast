package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;

/* compiled from: FragmentTrainingMetricsStreakCompletedBindingImpl.java */
/* loaded from: classes.dex */
public class bh extends ah {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ScrollView U;
    private long V;
    static {
        obj.put(2131362339, 4);
        obj.put(2131363421, 5);
        obj.put(2131362322, 6);
        obj.put(2131362190, 7);
        obj.put(2131363467, 8);
        obj.put(2131363299, 9);
        obj.put(2131363302, 10);
        obj.put(2131363300, 11);
        obj.put(2131362328, 12);
        obj.put(2131362336, 13);
        obj.put(2131362337, 14);
        obj.put(2131362329, 15);
        obj.put(2131362237, 16);
    }

    public bh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 17, bh.W, bh.X));
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public void A() {
        synchronized (this) {
            try {
                this.V = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public boolean O(int i, Object object) {
        int i2 = 109;
        boolean z = true;
        i2 = 109;
        if (109 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 65;
            if (65 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public void V(String str) {
        this.T = str;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(65);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public void W(TrainingTimeMetrics trainingTimeMetrics) {
        this.S = trainingTimeMetrics;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(109);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ah
    protected void m() {
        Resources resources;
        Object obj = null;
        int currentStreak;
        Object obj2;
        synchronized (this) {
            try {
                long l = 0L;
                this.V = l;
            } catch (Throwable th) {
            }
        }
        long l4 = 5L & l2;
        final int i5 = 1;
        currentStreak = 0;
        if (l4 != l) {
            if (this.S != null) {
                currentStreak = this.S.getCurrentStreak();
            } else {
            }
            Object[] arr3 = new Object[i5];
            int i2 = 2131755026;
            this.P.getResources().getQuantityString(i2, currentStreak, new Object[] { Integer.valueOf(currentStreak) });
            Object[] arr2 = new Object[i5];
            String quantityString = this.P.getResources().getQuantityString(i2, currentStreak, new Object[] { Integer.valueOf(currentStreak) });
        } else {
        }
        long l3 = l2 & 6L;
        if (this.V != l) {
            Object[] arr = new Object[i5];
            String string = this.Q.getResources().getString(2131887509, new Object[] { this.T });
        }
        if (l4 != l) {
            g.c(this.P, obj2);
            TrainingMetricsBindingAdapters.b(this.R, this.S);
        }
        if (this.V != l) {
            g.c(this.Q, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private bh(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[7], (Button)objectArr[16], (AppCompatImageView)objectArr[6], (Barrier)objectArr[12], (Space)objectArr[15], (Barrier)objectArr[13], (Space)objectArr[14], (LottieAnimationView)objectArr[4], (TextView)objectArr[3], (FrameLayout)objectArr[9], (TextView)objectArr[11], (AppCompatImageView)objectArr[10], (TextView)objectArr[1], (TextView)objectArr[5], (TextView)objectArr[2], (TextView)objectArr[8]);
        Object eVar3 = this;
        eVar3.V = -1L;
        Object obj = objectArr[0];
        eVar3.U = obj;
        Object obj2 = null;
        obj.setTag(obj2);
        eVar3.P.setTag(obj2);
        eVar3.Q.setTag(obj2);
        eVar3.R.setTag(obj2);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ah
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
