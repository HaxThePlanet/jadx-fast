package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.t.d;

/* compiled from: FragmentProgramLessonCompleteBindingImpl.java */
/* loaded from: classes.dex */
public class lf extends kf {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        obj.put(2131363538, 3);
        obj.put(2131361985, 4);
        obj.put(2131363306, 5);
        obj.put(2131362088, 6);
    }

    public lf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, lf.V, lf.W));
    }

    @Override // app.dogo.com.dogo_android.h.kf
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kf
    public boolean O(int i, Object object) {
        boolean z = true;
        if (179 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.kf
    public void V(d dVar) {
        this.S = dVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(179);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kf
    protected void m() {
        int cmp;
        Object obj = null;
        int lessonIndex;
        synchronized (this) {
            try {
                long l = 0L;
                this.U = l;
            } catch (Throwable th) {
            }
        }
        int i3 = 0;
        long l4 = 3L & l2;
        if (l4 != l && this.S != null) {
            lessonIndex = this.S.getLessonIndex();
            int i = 2131887587;
            Object[] arr = new Object[1];
            String string = this.Q.getResources().getString(i, new Object[] { Integer.valueOf(lessonIndex) });
        }
        long l3 = l2 & 2L;
        if (this.U != l) {
            BindingAdapters.o0(this.P, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
        }
        if (l4 != l) {
            g.c(this.Q, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.kf
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

    private lf(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[4], (Button)objectArr[6], (ImageView)objectArr[1], (TextView)objectArr[5], (TextView)objectArr[2], (KonfettiView)objectArr[3]);
        this.U = -1L;
        Object obj7 = objectArr[0];
        this.T = obj7;
        final Object obj8 = null;
        obj7.setTag(obj8);
        this.P.setTag(obj8);
        this.Q.setTag(obj8);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kf
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
