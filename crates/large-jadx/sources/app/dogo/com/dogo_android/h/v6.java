package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: CellRecommendedProgramListCardBindingImpl.java */
/* loaded from: classes.dex */
public class v6 extends u6 {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0 = new SparseIntArray();
    private final ConstraintLayout Z;
    private long a0;
    static {
        obj.put(2131362692, 10);
        obj.put(2131363418, 11);
        obj.put(2131362322, 12);
        obj.put(2131362711, 13);
        obj.put(2131363414, 14);
        obj.put(2131363156, 15);
        obj.put(2131363235, 16);
        obj.put(2131363386, 17);
        obj.put(2131362415, 18);
        obj.put(2131363388, 19);
        obj.put(2131362397, 20);
    }

    public v6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 21, v6.b0, v6.c0));
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public void A() {
        synchronized (this) {
            try {
                this.a0 = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 92;
            if (92 == i) {
                T(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public void T(Boolean boolean) {
        this.Y = boolean;
        synchronized (this) {
            try {
                this.a0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(92);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.X = programDescriptionItem;
        synchronized (this) {
            try {
                this.a0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u6
    protected void m() {
        String name;
        int numberOfEnrolledUsers;
        long l;
        Object obj2;
        String cardBackgroundColor;
        Object obj3;
        Object obj4;
        Object obj5 = null;
        String iconUrl;
        java.util.List dogSkillsHighlights;
        long l2;
        int i2 = 16;
        final Object obj = this;
        synchronized (this) {
            try {
                long l4 = 0L;
                obj.a0 = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = l & 5L;
        int i = 0;
        numberOfEnrolledUsers = 0;
        if (l5 != l4) {
            if (obj.X != null) {
                numberOfEnrolledUsers = obj.X.getNumberOfExams();
                numberOfEnrolledUsers = obj.X.getNumberOfEnrolledUsers();
                iconUrl = obj.X.getIconUrl();
                numberOfEnrolledUsers = obj.X.getSurveyCompatibility();
                numberOfEnrolledUsers = obj.X.getNumberOfSkills();
                dogSkillsHighlights = obj.X.getDogSkillsHighlights();
                cardBackgroundColor = obj.X.getCardBackgroundColor();
                name = obj.X.getName();
            } else {
            }
            int i3 = 1;
            Object[] arr2 = new Object[i3];
            arr2[numberOfEnrolledUsers] = Integer.valueOf(numberOfEnrolledUsers);
            Object[] arr3 = new Object[i3];
            arr3[numberOfEnrolledUsers] = Integer.valueOf(numberOfEnrolledUsers);
            String string3 = obj.Q.getResources().getString(2131887171, arr3);
            int cmp3 = 2131887593;
            Object[] arr = new Object[i3];
            arr[numberOfEnrolledUsers] = Integer.valueOf(numberOfEnrolledUsers);
            String string2 = obj.W.getResources().getString(cmp3, arr);
        } else {
        }
        long l6 = 6L;
        l2 = l & l6;
        if (l2 != 0 && l2 != 0) {
            int r21 = z ? 16 : 8;
            l = l | (z ? 16 : 8);
            if (!(z)) {
            }
        }
        long l7 = l & 5L;
        if (l7 != 0) {
            ProgramBindingAdapters.m0(obj.O, numberOfEnrolledUsers);
            g.c(obj.P, obj5);
            g.c(obj.Q, obj3);
            ProgramBindingAdapters.setProgramTasksAdapter(obj.R, dogSkillsHighlights);
            BindingAdapters.setRatingChange(obj.S, cardBackgroundColor);
            BindingAdapters.w(obj.T, iconUrl);
            g.c(obj.U, obj4);
            g.c(obj.W, obj2);
        }
        l &= l6;
        if (obj.a0 != 0) {
            obj.V.setVisibility(numberOfEnrolledUsers);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u6
    public boolean y() {
        synchronized (this) {
            try {
                if (this.a0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private v6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (View)objectArr[12], (TextView)objectArr[9], (ImageView)objectArr[20], (TextView)objectArr[8], (ImageView)objectArr[18], (TextView)objectArr[3], (TextView)objectArr[10], (LinearLayout)objectArr[5], (ImageView)objectArr[13], (CardView)objectArr[1], (ImageView)objectArr[2], (TextView)objectArr[4], (Button)objectArr[6], (ImageView)objectArr[15], (TextView)objectArr[7], (ImageView)objectArr[16], (View)objectArr[17], (View)objectArr[19], (TextView)objectArr[14], (Guideline)objectArr[11]);
        Object eVar3 = this;
        eVar3.a0 = -1L;
        Object obj2 = null;
        eVar3.O.setTag(obj2);
        eVar3.P.setTag(obj2);
        eVar3.Q.setTag(obj2);
        eVar3.R.setTag(obj2);
        Object obj = objectArr[0];
        eVar3.Z = obj;
        obj.setTag(obj2);
        eVar3.S.setTag(obj2);
        eVar3.T.setTag(obj2);
        eVar3.U.setTag(obj2);
        eVar3.V.setTag(obj2);
        eVar3.W.setTag(obj2);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
