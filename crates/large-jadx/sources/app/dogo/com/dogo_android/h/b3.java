package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.repository.domain.Article;

/* loaded from: classes.dex */
public class b3 extends app.dogo.com.dogo_android.h.a3 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        b3.X = sparseIntArray;
        sparseIntArray.put(2131362111, 6);
        sparseIntArray.put(2131361982, 7);
        sparseIntArray.put(2131362003, 8);
        sparseIntArray.put(2131363187, 9);
    }

    public b3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 10, b3.W, b3.X));
    }

    private b3(e e, View view2, Object[] object3Arr3) {
        final Object obj22 = this;
        super(e, view2, 0, (ImageView)object3Arr3[2], (TextView)object3Arr3[4], (TextView)object3Arr3[1], (ImageView)object3Arr3[7], (Barrier)object3Arr3[8], (CardView)object3Arr3[6], (ChipGroupWithState)object3Arr3[5], (TextView)object3Arr3[3], (HorizontalScrollView)object3Arr3[9]);
        obj22.V = -1;
        int i12 = 0;
        obj22.O.setTag(i12);
        obj22.P.setTag(i12);
        obj22.Q.setTag(i12);
        obj22.R.setTag(i12);
        Object obj11 = object3Arr3[0];
        obj22.U = (ConstraintLayout)obj11;
        obj11.setTag(i12);
        obj22.S.setTag(i12);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a3
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.a3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((Article)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.a3
    public void V(Article article) {
        this.T = article;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.T = article;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a3
    protected void m() {
        long l;
        int i7;
        int cmp;
        int i;
        String str;
        int read;
        int i5;
        int i3;
        int image;
        int readingTime;
        Integer valueOf;
        int i4;
        int i2;
        int i6;
        Object[] arr;
        l = this.V;
        final int i9 = 0;
        this.V = i9;
        final Article article = this.T;
        final int i10 = 3;
        int cmp2 = Long.compare(i11, i9);
        i5 = 0;
        i3 = 0;
        synchronized (this) {
            l = this.V;
            i9 = 0;
            this.V = i9;
            article = this.T;
            i10 = 3;
            cmp2 = Long.compare(i11, i9);
            i5 = 0;
            i3 = 0;
        }
        try {
            if (article != null) {
            } else {
            }
            read = article.isRead();
            image = article.getImage();
            readingTime = article.getReadingTime();
            image = i5;
            readingTime = read;
            if (read != 0) {
            } else {
            }
            l |= i12;
            i4 = 32;
            l |= i13;
            i4 = 16;
        }
        i2 = read != 0 ? i : i3;
        if (read != 0) {
            i = i3;
        }
        arr = new Object[1];
        arr[i3] = Integer.valueOf(readingTime);
        i3 = i;
        str = string;
        i5 = image;
        if (Long.compare(i8, i9) != 0) {
            f.f(this.O, i5);
            this.P.setVisibility(i3);
            f.j(this.Q, article);
            f.i(this.R, article);
            g.c(this.S, str);
            this.S.setVisibility(i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a3
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
