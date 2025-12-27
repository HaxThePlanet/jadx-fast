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
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: CellProgramExamPendingCardBindingImpl.java */
/* loaded from: classes.dex */
public class j4 extends i4 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private long V;
    static {
        obj.put(2131363295, 6);
    }

    public j4(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, j4.W, j4.X));
    }

    @Override // app.dogo.com.dogo_android.h.i4
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i4
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

    @Override // app.dogo.com.dogo_android.h.i4
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

    @Override // app.dogo.com.dogo_android.h.i4
    protected void m() {
        long l;
        int i;
        String str;
        int cmp3 = 64;
        Boolean hasNewUpdates;
        java.lang.CharSequence charSequence;
        long l3;
        int i2 = 8;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.V = l5;
            } catch (Throwable th) {
            }
        }
        final long l6 = 3L;
        long l7 = l & l6;
        long l8 = 32L;
        i = 0;
        i = 0;
        if (l7 != l5) {
            if (obj.U != null) {
                hasNewUpdates = obj.U.getHasNewUpdates();
                String videoUrl = obj.U.getVideoUrl();
                String name = obj.U.getName();
                String thumbnailUrl = obj.U.getThumbnailUrl();
            } else {
            }
            if (l7 != l5) {
                l = ViewDataBinding.K(hasNewUpdates) ? l | l8 : l | l2;
            }
            if (i != 0) {
                boolean empty = i.isEmpty();
            } else {
            }
            l3 = l & 3L;
            if (l3 != l5) {
                int r18 = i != 0 ? 8 : 4;
                l = l | (i != 0 ? 8 : 4);
            }
            int r8 = i != 0 ? 8 : i;
        } else {
        }
        long l9 = 32L & l;
        if (l9 != l5) {
            if (obj.U != null) {
                ProgramExam.Status status = obj.U.getStatus();
            }
            int r10 = i != ProgramExam_Status.PENDING ? 1 : i;
        }
        long l10 = l & 3L;
        if (l10 != l5) {
            if (i == 0) {
            }
            if (l10 != l5) {
                int r11 = ProgramExam_Status.PENDING != 0 ? 128 : 64;
                l = l | (ProgramExam_Status.PENDING != 0 ? 128 : 64);
            }
            int r16 = ProgramExam_Status.PENDING != 0 ? i : 8;
            i = (ProgramExam_Status.PENDING != 0 ? i : 8);
        }
        l &= l6;
        if (obj.V != l5) {
            app.dogo.com.dogo_android.util.binding.m.o(obj.P, str);
            g.c(obj.Q, charSequence);
            TrainingBindingAdapters.q(obj.R, obj.U);
            obj.S.setVisibility(i);
            obj.T.setVisibility(i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i4
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

    private j4(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (ImageView)objectArr[1], (TextView)objectArr[4], (TextView)objectArr[3], (ImageView)objectArr[2], (ImageView)objectArr[5], (ImageView)objectArr[6]);
        this.V = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        this.P.setTag(obj8);
        this.Q.setTag(obj8);
        this.R.setTag(obj8);
        this.S.setTag(obj8);
        this.T.setTag(obj8);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i4
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
