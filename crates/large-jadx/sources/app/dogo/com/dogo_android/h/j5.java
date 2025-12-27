package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus;
import app.dogo.com.dogo_android.y.l;

/* compiled from: CellProgramLessonTrainingCardBindingImpl.java */
/* loaded from: classes.dex */
public class j5 extends i5 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final CardView U;
    private long V;
    static {
        obj.put(2131361950, 6);
        obj.put(2131362190, 7);
    }

    public j5(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, j5.W, j5.X));
    }

    @Override // app.dogo.com.dogo_android.h.i5
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i5
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

    @Override // app.dogo.com.dogo_android.h.i5
    public void V(LessonCardItem lessonCardItem) {
        this.T = lessonCardItem;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i5
    protected void m() {
        long l;
        long l2;
        int cmp3 = 16;
        int cmp2 = 64;
        int i;
        int i2 = 0;
        int i3 = 2131100379;
        android.graphics.drawable.Drawable drawable = null;
        java.lang.CharSequence charSequence;
        int i4 = 2131231152;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.V = l4;
            } catch (Throwable th) {
            }
        }
        final long l5 = 3L;
        long l6 = l & l5;
        i2 = 0;
        i = 0;
        if (l6 != l4) {
            if (this.T != null) {
            } else {
            }
            i = 1;
            int r11 = i2 == LessonCardItem_CardStatus.COMPLETED ? 1 : i;
            if (i2 != LessonCardItem_CardStatus.IN_PROGRESS) {
            }
            if (l6 != l4) {
                if (LessonCardItem_CardStatus.COMPLETED != 0) {
                    l2 = l | 8L;
                    cmp2 = 128;
                } else {
                    l2 = l | 4L;
                    cmp2 = 64;
                }
                l = l2 | cmp2;
            }
            long l7 = l & 3L;
            if (l7 != l4) {
                int r7 = i != 0 ? 32 : 16;
                l = l | (i != 0 ? 32 : 16);
            }
            int r8 = LessonCardItem_CardStatus.COMPLETED != 0 ? R.color.lightBackgroundGreen : R.color.white;
            r11 = LessonCardItem_CardStatus.COMPLETED != 0 ? R.drawable.ic_program_active_checkmark : R.drawable.ic_program_disabled_checkmark;
            drawable = a.d((LessonCardItem_CardStatus.COMPLETED != 0 ? R.color.lightBackgroundGreen : R.color.white).getContext(), (LessonCardItem_CardStatus.COMPLETED != 0 ? R.drawable.ic_program_active_checkmark : R.drawable.ic_program_disabled_checkmark));
            if (i == 0) {
                i = 8;
            }
        } else {
        }
        l &= l5;
        if (this.V != l4) {
            ProgramBindingAdapters.setSegmentKnowledgeColor(this.O, this.T);
            h.a(this.P, drawable);
            this.U.setCardBackgroundColor(i);
            g.c(this.Q, charSequence);
            ProgramBindingAdapters.setupPottyOverview(this.R, this.T);
            this.S.setVisibility(i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i5
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

    private j5(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ImageView)objectArr[6], (ImageView)objectArr[1], (ImageView)objectArr[2], (ImageView)objectArr[7], (TextView)objectArr[5], (TextView)objectArr[3], (TextView)objectArr[4]);
        this.V = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        this.P.setTag(obj8);
        Object obj9 = objectArr[0];
        this.U = obj9;
        obj9.setTag(obj8);
        this.Q.setTag(obj8);
        this.R.setTag(obj8);
        this.S.setTag(obj8);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i5
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
