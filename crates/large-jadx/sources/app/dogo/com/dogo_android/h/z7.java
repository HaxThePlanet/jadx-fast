package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.WelcomeSlide;

/* compiled from: CellWelcomeSlideBindingImpl.java */
/* loaded from: classes.dex */
public class z7 extends y7 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131363517, 4);
        obj.put(2131362759, 5);
    }

    public z7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, z7.U, z7.V));
    }

    @Override // app.dogo.com.dogo_android.h.y7
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.y7
    public boolean O(int i, Object object) {
        boolean z = true;
        if (145 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.y7
    public void V(WelcomeSlide welcomeSlide) {
        this.R = welcomeSlide;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(145);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y7
    protected void m() {
        int descriptionRes = 0;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.T & 3L;
        descriptionRes = 0;
        if (l2 == l3 || this.R == null) {
        } else {
            descriptionRes = this.R.getDescriptionRes();
            descriptionRes = this.R.getTitleRes();
            descriptionRes = this.R.getAuthorRes();
        }
        if (l2 != l3) {
            this.O.setText(descriptionRes);
            this.P.setText(descriptionRes);
            this.Q.setText(descriptionRes);
        }
    }

    @Override // app.dogo.com.dogo_android.h.y7
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

    private z7(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[5], (TextView)objectArr[2], (TextView)objectArr[3], (TextView)objectArr[1], (AppCompatImageView)objectArr[4]);
        this.T = -1L;
        Object obj6 = objectArr[0];
        this.S = obj6;
        final Object obj7 = null;
        obj6.setTag(obj7);
        this.O.setTag(obj7);
        this.P.setTag(obj7);
        this.Q.setTag(obj7);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
