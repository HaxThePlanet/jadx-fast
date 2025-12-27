package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellExamHistoryPendingBindingImpl.java */
/* loaded from: classes.dex */
public class p2 extends o2 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private long V;
    public p2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, p2.W, p2.X));
    }

    @Override // app.dogo.com.dogo_android.h.o2
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o2
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

    @Override // app.dogo.com.dogo_android.h.o2
    public void V(ProgramExam programExam) {
        this.U = programExam;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.o2
    protected void m() {
        long l;
        int cmp2 = 8;
        String videoUrl = null;
        boolean empty;
        Long reviewTimeMs = null;
        String name;
        Object obj2;
        String thumbnailUrl;
        int i2;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l3 = 0L;
                obj.V = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 3L;
        long l5 = l & l4;
        cmp2 = 0;
        int i = 0;
        if (l5 != l3) {
            if (obj.U != null) {
                name = obj.U.getName();
                thumbnailUrl = obj.U.getThumbnailUrl();
            } else {
            }
            if (videoUrl != null) {
                empty = videoUrl.isEmpty();
            } else {
            }
            if (l5 != l3) {
                int r14 = empty ? 8 : 4;
                l = l | (empty ? 8 : 4);
            }
            if (empty) {
                cmp2 = 8;
            }
        } else {
        }
        l &= l4;
        if (obj.V != l3) {
            BindingAdapters.O(obj.O, reviewTimeMs);
            app.dogo.com.dogo_android.util.binding.m.o(obj.Q, thumbnailUrl);
            g.c(obj.R, obj2);
            TrainingBindingAdapters.q(obj.S, obj.U);
            obj.T.setVisibility(cmp2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.o2
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

    private p2(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[5], (ConstraintLayout)objectArr[0], (ImageView)objectArr[1], (TextView)objectArr[4], (TextView)objectArr[3], (ImageView)objectArr[2]);
        this.V = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        this.P.setTag(obj7);
        this.Q.setTag(obj7);
        this.R.setTag(obj7);
        this.S.setTag(obj7);
        this.T.setTag(obj7);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.o2
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
