package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;

/* loaded from: classes.dex */
public class h1 extends app.dogo.com.dogo_android.h.g1 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h1.V = sparseIntArray;
        sparseIntArray.put(2131363272, 4);
        sparseIntArray.put(2131363273, 5);
        sparseIntArray.put(2131363274, 6);
        sparseIntArray.put(2131363275, 7);
        sparseIntArray.put(2131363276, 8);
    }

    public h1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, h1.U, h1.V));
    }

    private h1(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        super(e, view2, 0, (AppCompatImageView)object3Arr3[2], (TextView)object3Arr3[1], (AppCompatImageView)object3Arr3[4], (AppCompatImageView)object3Arr3[5], (AppCompatImageView)object3Arr3[6], (AppCompatImageView)object3Arr3[7], (AppCompatImageView)object3Arr3[8], (TextView)object3Arr3[3]);
        obj20.T = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        Object obj10 = object3Arr3[0];
        obj20.S = (ConstraintLayout)obj10;
        obj10.setTag(i11);
        obj20.P.setTag(i11);
        obj20.Q.setTag(i11);
        View view5 = view2;
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.g1
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.g1
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((CustomerExperience)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.g1
    public void V(CustomerExperience customerExperience) {
        this.R = customerExperience;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = customerExperience;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g1
    protected void m() {
        int cmp;
        int name;
        int text;
        int imageId;
        int i2 = 0;
        this.T = i2;
        final CustomerExperience customerExperience = this.R;
        imageId = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.T = i2;
            customerExperience = this.R;
            imageId = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (customerExperience != null) {
            } else {
            }
            name = customerExperience.getName();
            imageId = customerExperience.getImageId();
            text = customerExperience.getText();
            text = name;
            if (cmp != 0) {
            }
            this.O.setImageResource(imageId);
            g.c(this.P, name);
            g.c(this.Q, text);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.g1
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
