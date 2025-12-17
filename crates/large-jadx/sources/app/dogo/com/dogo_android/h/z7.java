package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.WelcomeSlide;

/* loaded from: classes.dex */
public class z7 extends app.dogo.com.dogo_android.h.y7 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z7.V = sparseIntArray;
        sparseIntArray.put(2131363517, 4);
        sparseIntArray.put(2131362759, 5);
    }

    public z7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, z7.U, z7.V));
    }

    private z7(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[5], (TextView)object3Arr3[2], (TextView)object3Arr3[3], (TextView)object3Arr3[1], (AppCompatImageView)object3Arr3[4]);
        this.T = -1;
        Object obj11 = object3Arr3[0];
        this.S = (ConstraintLayout)obj11;
        final int obj13 = 0;
        obj11.setTag(obj13);
        this.O.setTag(obj13);
        this.P.setTag(obj13);
        this.Q.setTag(obj13);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y7
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.y7
    public boolean O(int i, Object object2) {
        int obj2;
        if (145 == i) {
            V((WelcomeSlide)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.y7
    public void V(WelcomeSlide welcomeSlide) {
        this.R = welcomeSlide;
        this.T = l |= i2;
        notifyPropertyChanged(145);
        super.I();
        return;
        synchronized (this) {
            this.R = welcomeSlide;
            this.T = l |= i2;
            notifyPropertyChanged(145);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y7
    protected void m() {
        int cmp;
        int descriptionRes;
        int titleRes;
        int authorRes;
        int i2 = 0;
        this.T = i2;
        final WelcomeSlide welcomeSlide = this.R;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.T = i2;
            welcomeSlide = this.R;
            cmp = Long.compare(i, i2);
        }
        try {
            if (welcomeSlide != null) {
            } else {
            }
            descriptionRes = welcomeSlide.getDescriptionRes();
            titleRes = welcomeSlide.getTitleRes();
            authorRes = welcomeSlide.getAuthorRes();
            authorRes = titleRes;
            if (cmp != 0) {
            }
            this.O.setText(descriptionRes);
            this.P.setText(authorRes);
            this.Q.setText(titleRes);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.y7
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
