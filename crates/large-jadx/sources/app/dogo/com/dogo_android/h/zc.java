package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.c;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentExamVideoPlaybackBindingImpl.java */
/* loaded from: classes.dex */
public class zc extends yc {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0 = new SparseIntArray();
    private final ConstraintLayout a0;
    private long b0;
    static {
        obj.put(2131362193, 5);
        obj.put(2131363514, 6);
        obj.put(2131363516, 7);
        obj.put(2131363513, 8);
        obj.put(2131363135, 9);
        obj.put(2131363512, 10);
    }

    public zc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, zc.c0, zc.d0));
    }

    private boolean V(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yc
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                X(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public void W(app.dogo.com.dogo_android.exam.i iVar) {
        this.Z = iVar;
        synchronized (this) {
            try {
                this.b0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public void X(app.dogo.com.dogo_android.exam.j.i iVar) {
        this.Y = iVar;
        synchronized (this) {
            try {
                this.b0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yc
    protected void m() {
        int cmp;
        Object obj;
        Integer num;
        int i = 0;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.b0 = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 10L & l;
        long l5 = 13L & l;
        final Boolean bool = null;
        if (l5 != l3) {
            if (this.Y != null) {
                x xVar = this.Y.m();
            } else {
                int i2 = bool;
            }
            i = 0;
            Q(i, obj);
            Object value = this.Y != null ? (Integer)value : bool;
        }
        if (l5 != l3) {
            ExamFlowBindingAdapters.setBindingSurfaceTextureListener(this.P, num, this.Q, this.S);
            ExamFlowBindingAdapters.b(this.V, num, this.U, this.W, this.T);
        }
        long l2 = l & 8L;
        if (this.b0 != l3) {
            BindingAdapters.k0(this.R, bool);
        }
        if (l4 != l3) {
            ExamFlowBindingAdapters.setupExamPlaybackButton(this.X, this.Z);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yc
    public boolean y() {
        synchronized (this) {
            try {
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private zc(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 1, (ImageButton)objectArr[5], (FrameLayout)objectArr[4], (MaterialButton)objectArr[9], (FrameLayout)objectArr[1], (Button)objectArr[10], (ImageView)objectArr[8], (ProgressBar)objectArr[6], (LinearLayout)objectArr[3], (AppCompatTextView)objectArr[7], (TextureView)objectArr[2]);
        eVar3.b0 = -1L;
        Object obj12 = null;
        eVar3.P.setTag(obj12);
        Object obj11 = objectArr[0];
        eVar3.a0 = obj11;
        obj11.setTag(obj12);
        eVar3.R.setTag(obj12);
        eVar3.V.setTag(obj12);
        eVar3.X.setTag(obj12);
        N(view);
        A();
    }
}
