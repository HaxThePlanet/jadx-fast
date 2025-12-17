package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* loaded from: classes.dex */
public class hn extends app.dogo.com.dogo_android.h.gn {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        hn.V = sparseIntArray;
        sparseIntArray.put(2131362261, 4);
        sparseIntArray.put(2131362260, 5);
        sparseIntArray.put(2131362262, 6);
        sparseIntArray.put(2131362322, 7);
        sparseIntArray.put(2131362756, 8);
        sparseIntArray.put(2131362755, 9);
        sparseIntArray.put(2131362333, 10);
        sparseIntArray.put(2131363409, 11);
        sparseIntArray.put(2131363408, 12);
    }

    public hn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 13, hn.U, hn.V));
    }

    private hn(e e, View view2, Object[] object3Arr3) {
        Object obj28 = this;
        super(e, view2, 0, (TextView)object3Arr3[1], (ImageView)object3Arr3[5], (ConstraintLayout)object3Arr3[4], (TextView)object3Arr3[6], (View)object3Arr3[7], (View)object3Arr3[10], (TextView)object3Arr3[2], (ImageView)object3Arr3[9], (ConstraintLayout)object3Arr3[8], (TextView)object3Arr3[3], (ImageView)object3Arr3[12], (ConstraintLayout)object3Arr3[11]);
        Object obj16 = this;
        obj16.T = -1;
        int i15 = 0;
        obj16.O.setTag(i15);
        obj16.P.setTag(i15);
        Object obj14 = object3Arr3[0];
        obj16.S = (ConstraintLayout)obj14;
        obj14.setTag(i15);
        obj16.Q.setTag(i15);
        obj16.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gn
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gn
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.gn
    public boolean O(int i, Object object2) {
        int obj2;
        if (127 == i) {
            V((ProfilePreview)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gn
    public void V(ProfilePreview profilePreview) {
        this.R = profilePreview;
        this.T = l |= i2;
        notifyPropertyChanged(127);
        super.I();
        return;
        synchronized (this) {
            this.R = profilePreview;
            this.T = l |= i2;
            notifyPropertyChanged(127);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gn
    protected void m() {
        int cmp;
        int quantityString2;
        int quantityString;
        int longestStreak;
        int currentStreak;
        int timeTrained;
        Resources resources;
        Object[] arr;
        Integer valueOf;
        int i;
        Integer valueOf2;
        int i4 = 0;
        this.T = i4;
        ProfilePreview profilePreview = this.R;
        final int i5 = 3;
        cmp = Long.compare(i2, i4);
        synchronized (this) {
            i4 = 0;
            this.T = i4;
            profilePreview = this.R;
            i5 = 3;
            cmp = Long.compare(i2, i4);
        }
        try {
            int i3 = 0;
            if (profilePreview != null) {
            } else {
            }
            longestStreak = profilePreview.getLongestStreak();
            currentStreak = profilePreview.getCurrentStreak();
            timeTrained = profilePreview.getTimeTrained();
            timeTrained = i4;
            currentStreak = longestStreak;
            int i6 = 1;
            Object[] arr2 = new Object[i6];
            arr2[i3] = Integer.valueOf(longestStreak);
            i = 2131755018;
            this.P.getResources().getQuantityString(i, longestStreak, arr2);
            Object[] arr3 = new Object[i6];
            arr3[i3] = Integer.valueOf(longestStreak);
            quantityString = this.P.getResources().getQuantityString(i, longestStreak, arr3);
            Object[] arr4 = new Object[i6];
            arr4[i3] = Integer.valueOf(currentStreak);
            this.O.getResources().getQuantityString(i, currentStreak, arr4);
            arr = new Object[i6];
            arr[i3] = Integer.valueOf(currentStreak);
            quantityString2 = this.O.getResources().getQuantityString(i, currentStreak, arr);
            timeTrained = i4;
            quantityString = quantityString2;
            if (cmp != 0) {
            }
            g.c(this.O, quantityString2);
            g.c(this.P, quantityString);
            o.B(this.Q, timeTrained);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gn
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
