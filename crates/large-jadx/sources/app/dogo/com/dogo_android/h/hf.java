package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentProgramExamsCompletedBindingImpl.java */
/* loaded from: classes.dex */
public class hf extends gf {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131362690, 2);
        obj.put(2131361985, 3);
        obj.put(2131363421, 4);
        obj.put(2131363147, 5);
        obj.put(2131362700, 6);
    }

    public hf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, hf.U, hf.V));
    }

    @Override // app.dogo.com.dogo_android.h.gf
    public void A() {
        synchronized (this) {
            try {
                this.T = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gf
    protected void m() {
        synchronized (this) {
            try {
                long l = 0L;
                this.T = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.T & 1L;
        if (l3 != l) {
            BindingAdapters.X(this.S, this.O);
            BindingAdapters.o0(this.R, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
        }
    }

    @Override // app.dogo.com.dogo_android.h.gf
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

    private hf(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[3], (KonfettiView)objectArr[2], (TextView)objectArr[6], (Button)objectArr[5], (ImageView)objectArr[1], (TextView)objectArr[4]);
        this.T = -1L;
        Object obj7 = objectArr[0];
        this.S = obj7;
        final Object obj8 = null;
        obj7.setTag(obj8);
        this.R.setTag(obj8);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gf
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.gf
    public boolean O(int i, Object object) {
        return true;
    }
}
