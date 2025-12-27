package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;

/* compiled from: CellCustomerExperienceBindingImpl.java */
/* loaded from: classes.dex */
public class h1 extends g1 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131363272, 4);
        obj.put(2131363273, 5);
        obj.put(2131363274, 6);
        obj.put(2131363275, 7);
        obj.put(2131363276, 8);
    }

    public h1(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, h1.U, h1.V));
    }

    @Override // app.dogo.com.dogo_android.h.g1
    public void A() {
        synchronized (this) {
            try {
                this.T = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g1
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.g1
    public void V(CustomerExperience customerExperience) {
        this.R = customerExperience;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g1
    protected void m() {
        Object obj = null;
        Object obj2;
        int imageId = 0;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        imageId = 0;
        long l2 = this.T & 3L;
        if (l2 == l3 || this.R == null) {
        } else {
            String name = this.R.getName();
            imageId = this.R.getImageId();
            String text = this.R.getText();
        }
        if (l2 != l3) {
            this.O.setImageResource(imageId);
            g.c(this.P, obj);
            g.c(this.Q, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g1
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

    private h1(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (AppCompatImageView)objectArr[2], (TextView)objectArr[1], (AppCompatImageView)objectArr[4], (AppCompatImageView)objectArr[5], (AppCompatImageView)objectArr[6], (AppCompatImageView)objectArr[7], (AppCompatImageView)objectArr[8], (TextView)objectArr[3]);
        eVar3.T = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.S = obj9;
        obj9.setTag(obj10);
        eVar3.P.setTag(obj10);
        eVar3.Q.setTag(obj10);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.g1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
