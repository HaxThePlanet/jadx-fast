package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: CellLibraryProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class d3 extends c3 {

    private static final ViewDataBinding.g a0;
    private static final SparseIntArray b0 = new SparseIntArray();
    private final Group Y;
    private long Z;
    static {
        obj.put(2131363387, 10);
        obj.put(2131363418, 11);
    }

    public d3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, d3.a0, d3.b0));
    }

    @Override // app.dogo.com.dogo_android.h.c3
    public void A() {
        synchronized (this) {
            try {
                this.Z = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c3
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            W(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.c3
    public void W(ProgramDescriptionItem programDescriptionItem) {
        this.X = programDescriptionItem;
        synchronized (this) {
            try {
                this.Z |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c3
    protected void m() {
        long l;
        java.lang.CharSequence charSequence;
        int numberOfSkills;
        Object obj2;
        String str;
        int i;
        Object obj3;
        int i2 = 1024;
        String str2;
        long l2 = 3;
        int i3 = 4;
        long l4 = 0;
        int i4 = 16;
        int i5;
        long l6;
        int i6 = 256;
        int i7 = 4096;
        final Object obj = this;
        synchronized (this) {
            try {
                long l11 = 0L;
                obj.Z = l11;
            } catch (Throwable th) {
            }
        }
        l2 = 3L;
        long l12 = l & l2;
        i = 0;
        numberOfSkills = 1;
        numberOfSkills = 0;
        if (l12 != l11) {
            if (obj.X != null) {
                boolean special = obj.X.isSpecial();
                String iconUrl = obj.X.getIconUrl();
                numberOfSkills = obj.X.getNumberOfSkills();
                ProgramDescriptionItem.State programState = obj.X.getProgramState();
                String cardBackgroundColor = obj.X.getCardBackgroundColor();
                String name = obj.X.getName();
                numberOfSkills = obj.X.getModulesCount();
            } else {
            }
            if (l12 != l11 && numberOfSkills != 0) {
                i5 = 128;
                l = l | i5;
            }
            Object[] arr = new Object[numberOfSkills];
            int r5 = numberOfSkills;
            int r8 = numberOfSkills;
            int r9 = numberOfSkills;
            Object[] arr2 = new Object[numberOfSkills];
            String string2 = obj.W.getResources().getString(2131887581, new Object[] { Integer.valueOf(numberOfSkills) });
            long l3 = 3L;
            l7 = l & 3L;
            long l5 = 0L;
            if (l7 != l5) {
                int r22 = ProgramDescriptionItem_State.COMING_SOON != 0 ? 8192 : 4096;
                l = l | (ProgramDescriptionItem_State.COMING_SOON != 0 ? 8192 : 4096);
            }
            l6 = l & 3L;
            if (l6 != l5) {
                r22 = obj.V != 0 ? 512 : 256;
                l = l | (obj.V != 0 ? 512 : 256);
            }
            l8 = l & 3L;
            if (l8 != l5) {
                int r14 = ProgramDescriptionItem_State.NOT_STARTED != 0 ? 2048 : 1024;
                l = l | (ProgramDescriptionItem_State.NOT_STARTED != 0 ? 2048 : 1024);
            }
            int r7 = ProgramDescriptionItem_State.COMING_SOON != 0 ? numberOfSkills : 8;
            r8 = obj.V != 0 ? numberOfSkills : 8;
            int i13 = 3;
        } else {
        }
        l9 = l & l2;
        l4 = 0L;
        if (l9 != l4) {
            int r10 = numberOfSkills;
            if (ProgramDescriptionItem_State.NOT_STARTED == 0) {
            }
            if (l9 != l4 && numberOfSkills != 0) {
                i4 = 32;
                l = l | i4;
            }
            l9 = l & 3L;
            l4 = 0L;
            if (l9 != l4) {
                int r16 = numberOfSkills != 0 ? 8 : 4;
                l = l | (numberOfSkills != 0 ? 8 : 4);
            }
            r9 = numberOfSkills != 0 ? 8 : numberOfSkills;
            if (numberOfSkills != 0) {
                numberOfSkills = 4;
            }
        } else {
        }
        l &= 3;
        if (obj.Z != 0) {
            obj.O.setVisibility(numberOfSkills);
            obj.P.setVisibility(numberOfSkills);
            obj.Q.setVisibility(numberOfSkills);
            obj.Y.setVisibility(numberOfSkills);
            BindingAdapters.setRatingChange(obj.R, str2);
            BindingAdapters.w(obj.S, str);
            ProgramBindingAdapters.Y(obj.T, obj.X);
            g.c(obj.U, charSequence);
            g.c(obj.V, obj3);
            g.c(obj.W, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.c3
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Z != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private d3(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (ConstraintLayout)objectArr[2], (ImageView)objectArr[3], (TextView)objectArr[8], (CardView)objectArr[0], (ImageView)objectArr[1], (TextView)objectArr[4], (TextView)objectArr[5], (TextView)objectArr[6], (TextView)objectArr[10], (Guideline)objectArr[11], (TextView)objectArr[7]);
        eVar3.Z = -1L;
        Object obj13 = null;
        eVar3.O.setTag(obj13);
        eVar3.P.setTag(obj13);
        eVar3.Q.setTag(obj13);
        Object obj12 = objectArr[9];
        eVar3.Y = obj12;
        obj12.setTag(obj13);
        eVar3.R.setTag(obj13);
        eVar3.S.setTag(obj13);
        eVar3.T.setTag(obj13);
        eVar3.U.setTag(obj13);
        eVar3.V.setTag(obj13);
        eVar3.W.setTag(obj13);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
