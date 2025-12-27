package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellExamHistoryBindingImpl.java */
/* loaded from: classes.dex */
public class n2 extends m2 {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0 = new SparseIntArray();
    private final ConstraintLayout a0;
    private long b0;
    static {
        obj.put(2131362963, 11);
        obj.put(2131362494, 12);
        obj.put(2131363414, 13);
        obj.put(2131362322, 14);
        obj.put(2131362707, 15);
        obj.put(2131362003, 16);
    }

    public n2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 17, n2.c0, n2.d0));
    }

    @Override // app.dogo.com.dogo_android.h.m2
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m2
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

    @Override // app.dogo.com.dogo_android.h.m2
    public void V(ProgramExam programExam) {
        this.Z = programExam;
        synchronized (this) {
            try {
                this.b0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m2
    protected void m() {
        long l;
        Object obj2 = null;
        String string = null;
        int i = 8;
        int i3 = 0;
        java.lang.CharSequence charSequence2 = null;
        int i4 = 0;
        String str2 = null;
        int i5 = 0;
        Long l8 = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Boolean retakable = null;
        int cmp2 = 16;
        int i9 = 64;
        int cmp3 = 8;
        final Object obj = this;
        synchronized (this) {
            try {
                long l3 = 0L;
                obj.b0 = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 3L;
        long l5 = l & l4;
        long l6 = 4L;
        i = 0;
        if (l5 != l3) {
            if (obj.Z != null) {
                String reviewComment = obj.Z.getReviewComment();
                String evaluatedByAvatar = obj.Z.getEvaluatedByAvatar();
                Long reviewTimeMs = obj.Z.getReviewTimeMs();
                boolean userFeedbackSubmitted = obj.Z.getUserFeedbackSubmitted();
                String name = obj.Z.getName();
                String evaluatedByName = obj.Z.getEvaluatedByName();
                String thumbnailUrl = obj.Z.getThumbnailUrl();
                retakable = obj.Z.isRetakable();
            } else {
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                int i19 = 0;
            }
            if (l5 != l3 && i != 0) {
                i9 = 128;
                l = l | i9;
            }
            i = 8;
            int r16 = i != 0 ? 8 : i;
            boolean z = ViewDataBinding.K(retakable);
            long l9 = l & 3L;
            if (l9 != l3) {
                int r21 = z ? 32 : 16;
                l = l | (z ? 32 : 16);
            }
            if (i7 != 0) {
                boolean empty = i7.isEmpty();
            } else {
            }
            long l10 = l & 3L;
            if (l10 != l3) {
                l = i != 0 ? l | l11 : l | l6;
            }
            if (z) {
            }
        } else {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            i7 = 0;
            i6 = 0;
            i8 = 0;
        }
        long l7 = 4L & l;
        if (l7 != l3) {
            int i2 = 2131886554;
            Object[] arr = new Object[1];
            string = obj.Y.getResources().getString(i2, new Object[] { i7 });
        } else {
            int i14 = 0;
        }
        l &= l4;
        if (obj.b0 == 0) {
            int i10 = 0;
        } else {
            if (i != 0) {
                String string2 = obj.Y.getResources().getString(2131887564);
            } else {
            }
        }
        if (obj.b0 != 0) {
            BindingAdapters.O(obj.O, l8);
            app.dogo.com.dogo_android.util.binding.m.o(obj.P, i8);
            g.c(obj.Q, i6);
            TrainingBindingAdapters.q(obj.R, obj.Z);
            BindingAdapters.m0(obj.S, str2, a.d(obj.S.getContext(), 2131231283));
            obj.T.setVisibility(i);
            obj.U.setVisibility(i);
            obj.W.setVisibility(i);
            g.c(obj.X, charSequence2);
            g.c(obj.Y, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m2
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

    private n2(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Barrier)objectArr[16], (TextView)objectArr[4], (ImageView)objectArr[14], (ImageView)objectArr[1], (TextView)objectArr[3], (TextView)objectArr[2], (CardView)objectArr[12], (ImageView)objectArr[5], (TextView)objectArr[9], (TextView)objectArr[10], (View)objectArr[15], (ImageView)objectArr[11], (Button)objectArr[8], (TextView)objectArr[13], (TextView)objectArr[7], (TextView)objectArr[6]);
        Object eVar3 = this;
        eVar3.b0 = -1L;
        Object obj2 = null;
        eVar3.O.setTag(obj2);
        eVar3.P.setTag(obj2);
        eVar3.Q.setTag(obj2);
        eVar3.R.setTag(obj2);
        eVar3.S.setTag(obj2);
        eVar3.T.setTag(obj2);
        eVar3.U.setTag(obj2);
        Object obj = objectArr[0];
        eVar3.a0 = obj;
        obj.setTag(obj2);
        eVar3.W.setTag(obj2);
        eVar3.X.setTag(obj2);
        eVar3.Y.setTag(obj2);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m2
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
