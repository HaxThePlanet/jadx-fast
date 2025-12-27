package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
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
import app.dogo.com.dogo_android.g.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutDashboardRecommendedProgramCardV2BindingImpl.java */
/* loaded from: classes.dex */
public class nj extends mj implements b.a {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0 = new SparseIntArray();
    private final ConstraintLayout Z;
    private final View.OnClickListener a0;
    private final View.OnClickListener b0;
    private long c0;
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

    public nj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 21, nj.d0, nj.e0));
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public void A() {
        synchronized (this) {
            try {
                this.c0 = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                T(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public void T(x xVar) {
        this.Y = xVar;
        synchronized (this) {
            try {
                this.c0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.X = programDescriptionItem;
        synchronized (this) {
            try {
                this.c0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.Y != null) {
            }
            if (i2 != 0) {
                this.Y.onReviewRecommendedProgramSelected(this.X);
            }
        } else {
            if (this.X == 2) {
                if (this.Y != null) {
                }
                if (i2 != 0) {
                    this.Y.onReviewRecommendedProgramSelected(this.X);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.mj
    protected void m() {
        int i;
        java.lang.CharSequence charSequence;
        Object obj;
        Object obj3;
        int numberOfEnrolledUsers;
        Object obj4 = null;
        String str;
        java.util.List list;
        String str2;
        final Object obj2 = this;
        synchronized (this) {
            try {
                long l3 = 0L;
                obj2.c0 = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 5L & l2;
        i = 0;
        numberOfEnrolledUsers = 0;
        if (l4 != l3) {
            if (obj2.X != null) {
                numberOfEnrolledUsers = obj2.X.getNumberOfExams();
                numberOfEnrolledUsers = obj2.X.getNumberOfEnrolledUsers();
                String iconUrl = obj2.X.getIconUrl();
                numberOfEnrolledUsers = obj2.X.getSurveyCompatibility();
                numberOfEnrolledUsers = obj2.X.getNumberOfSkills();
                java.util.List dogSkillsHighlights = obj2.X.getDogSkillsHighlights();
                String cardBackgroundColor = obj2.X.getCardBackgroundColor();
                String name = obj2.X.getName();
            } else {
            }
            int i5 = 1;
            Object[] arr = new Object[i5];
            arr[numberOfEnrolledUsers] = Integer.valueOf(numberOfEnrolledUsers);
            String string3 = obj2.P.getResources().getString(2131886974, arr);
            Object[] arr3 = new Object[i5];
            arr3[numberOfEnrolledUsers] = Integer.valueOf(numberOfEnrolledUsers);
            String string = obj2.Q.getResources().getString(2131887171, arr3);
            int i2 = 2131887593;
            Object[] arr2 = new Object[i5];
            arr2[numberOfEnrolledUsers] = Integer.valueOf(numberOfEnrolledUsers);
            String string2 = obj2.W.getResources().getString(i2, arr2);
        } else {
        }
        if (l4 != obj2.Q) {
            ProgramBindingAdapters.m0(obj2.O, numberOfEnrolledUsers);
            g.c(obj2.P, obj4);
            g.c(obj2.Q, obj);
            ProgramBindingAdapters.setProgramTasksAdapter(obj2.R, list);
            BindingAdapters.setRatingChange(obj2.S, str2);
            BindingAdapters.w(obj2.T, str);
            g.c(obj2.U, charSequence);
            g.c(obj2.W, obj3);
        }
        l = l2 & 4L;
        if (obj2.c0 != 0) {
            obj2.S.setOnClickListener(obj2.b0);
            obj2.V.setOnClickListener(obj2.a0);
        }
    }

    @Override // app.dogo.com.dogo_android.h.mj
    public boolean y() {
        synchronized (this) {
            try {
                if (this.c0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private nj(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (View)objectArr[12], (TextView)objectArr[9], (ImageView)objectArr[20], (TextView)objectArr[8], (ImageView)objectArr[18], (TextView)objectArr[3], (TextView)objectArr[10], (LinearLayout)objectArr[5], (ImageView)objectArr[13], (CardView)objectArr[1], (ImageView)objectArr[2], (TextView)objectArr[4], (Button)objectArr[6], (ImageView)objectArr[15], (TextView)objectArr[7], (ImageView)objectArr[16], (View)objectArr[17], (View)objectArr[19], (TextView)objectArr[14], (Guideline)objectArr[11]);
        Object eVar4 = this;
        eVar4.c0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.P.setTag(obj2);
        eVar4.Q.setTag(obj2);
        eVar4.R.setTag(obj2);
        Object obj = objectArr[0];
        eVar4.Z = obj;
        obj.setTag(obj2);
        eVar4.S.setTag(obj2);
        eVar4.T.setTag(obj2);
        eVar4.U.setTag(obj2);
        eVar4.V.setTag(obj2);
        eVar4.W.setTag(obj2);
        eVar4.N(view);
        eVar4.a0 = new b(eVar4, 2);
        eVar4.b0 = new b(eVar4, 1);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
