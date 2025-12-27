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

/* compiled from: CellProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class b4 extends a4 {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final Group X;
    private long Y;
    static {
        obj.put(2131363387, 9);
        obj.put(2131363418, 10);
    }

    public b4(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, b4.Z, b4.a0));
    }

    @Override // app.dogo.com.dogo_android.h.a4
    public void A() {
        synchronized (this) {
            try {
                this.Y = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a4
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

    @Override // app.dogo.com.dogo_android.h.a4
    public void V(ProgramDescriptionItem programDescriptionItem) {
        this.W = programDescriptionItem;
        synchronized (this) {
            try {
                this.Y |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a4
    protected void m() {
        long l;
        int numberOfSkills;
        Object obj2;
        Object obj3;
        String str = null;
        int i;
        String str2;
        int i3 = 16;
        int i2 = 3;
        java.lang.CharSequence charSequence;
        int i4;
        int i5;
        final Object obj = this;
        synchronized (this) {
            try {
                long l8 = 0L;
                obj.Y = l8;
            } catch (Throwable th) {
            }
        }
        long l2 = 3L;
        long l9 = l & l2;
        i = 0;
        numberOfSkills = 0;
        if (l9 != l8) {
            if (obj.W != null) {
                boolean special = obj.W.isSpecial();
                String iconUrl = obj.W.getIconUrl();
                numberOfSkills = obj.W.getNumberOfSkills();
                ProgramDescriptionItem.State programState = obj.W.getProgramState();
                String cardBackgroundColor = obj.W.getCardBackgroundColor();
                String name = obj.W.getName();
                numberOfSkills = obj.W.getModulesCount();
            } else {
            }
            if (l9 != l8) {
                int r17 = numberOfSkills != 0 ? 8 : 4;
                l = l | (numberOfSkills != 0 ? 8 : 4);
            }
            int r8 = numberOfSkills != 0 ? 4 : numberOfSkills;
            numberOfSkills = 1;
            Object[] arr2 = new Object[numberOfSkills];
            int r4 = numberOfSkills;
            int r6 = numberOfSkills;
            Object[] arr = new Object[numberOfSkills];
            String string2 = obj.V.getResources().getString(2131887581, new Object[] { Integer.valueOf(numberOfSkills) });
            long l3 = 3L;
            l5 = l & 3L;
            long l4 = 0L;
            if (l5 != l4) {
                int r18 = ProgramDescriptionItem_State.COMPLETED != 0 ? 128 : 64;
                l = l | (ProgramDescriptionItem_State.COMPLETED != 0 ? 128 : 64);
            }
            l6 = l & 3L;
            if (l6 != l4 && ProgramDescriptionItem_State.NOT_STARTED != 0) {
                i3 = 32;
                l = l | i3;
            }
            numberOfSkills = 8;
            r4 = numberOfSkills;
            if (ProgramDescriptionItem_State.NOT_STARTED != 0) {
            }
            i2 = 3;
        } else {
        }
        l &= i2;
        if (obj.Y != 0) {
            obj.O.setVisibility(numberOfSkills);
            obj.P.setVisibility(numberOfSkills);
            obj.X.setVisibility(numberOfSkills);
            BindingAdapters.setRatingChange(obj.Q, str);
            BindingAdapters.w(obj.R, str2);
            ProgramBindingAdapters.Y(obj.S, obj.W);
            g.c(obj.T, charSequence);
            g.c(obj.U, obj2);
            g.c(obj.V, obj3);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a4
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Y != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private b4(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (ConstraintLayout)objectArr[2], (ImageView)objectArr[3], (CardView)objectArr[0], (ImageView)objectArr[1], (TextView)objectArr[4], (TextView)objectArr[5], (TextView)objectArr[6], (TextView)objectArr[9], (Guideline)objectArr[10], (TextView)objectArr[7]);
        eVar3.Y = -1L;
        Object obj12 = null;
        eVar3.O.setTag(obj12);
        eVar3.P.setTag(obj12);
        Object obj11 = objectArr[8];
        eVar3.X = obj11;
        obj11.setTag(obj12);
        eVar3.Q.setTag(obj12);
        eVar3.R.setTag(obj12);
        eVar3.S.setTag(obj12);
        eVar3.T.setTag(obj12);
        eVar3.U.setTag(obj12);
        eVar3.V.setTag(obj12);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a4
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
