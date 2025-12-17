package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;
import com.google.android.material.card.MaterialCardView;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class t3 extends app.dogo.com.dogo_android.h.s3 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final MaterialCardView R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t3.U = sparseIntArray;
        sparseIntArray.put(2131362619, 3);
    }

    public t3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, t3.T, t3.U));
    }

    private t3(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[2], (TextView)object3Arr3[1], (AppCompatImageView)object3Arr3[3]);
        this.S = -1;
        int i5 = 0;
        this.O.setTag(i5);
        this.P.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.R = (MaterialCardView)obj9;
        obj9.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s3
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((ArticleWithStatus)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.s3
    public void V(ArticleWithStatus articleWithStatus) {
        this.Q = articleWithStatus;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = articleWithStatus;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s3
    protected void m() {
        long l;
        int cmp;
        int i2;
        int i;
        int i3;
        int title;
        int i4;
        Article article;
        l = this.S;
        final int i6 = 0;
        this.S = i6;
        ArticleWithStatus articleWithStatus = this.Q;
        i3 = 0;
        final int i7 = 3;
        int cmp2 = Long.compare(i8, i6);
        title = 0;
        synchronized (this) {
            l = this.S;
            i6 = 0;
            this.S = i6;
            articleWithStatus = this.Q;
            i3 = 0;
            i7 = 3;
            cmp2 = Long.compare(i8, i6);
            title = 0;
        }
        try {
            if (articleWithStatus != null) {
            } else {
            }
            i3 = read;
            i2 = article;
            i2 = title;
            if (i3 != 0) {
            } else {
            }
            i4 = 8;
            i4 = 4;
        }
        if (i2 != 0) {
            title = i2.getTitle();
        }
        i3 = i3 != 0 ? R.drawable.ic_green_check : R.drawable.arrow_right_green;
        title = drawable;
        i = article;
        if (Long.compare(i5, i6) != 0) {
            this.O.setImageDrawable(title);
            g.c(this.P, i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s3
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
