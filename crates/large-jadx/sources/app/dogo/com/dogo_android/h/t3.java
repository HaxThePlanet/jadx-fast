package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;
import com.google.android.material.card.MaterialCardView;

/* compiled from: CellPottyOverviewArticleBindingImpl.java */
/* loaded from: classes.dex */
public class t3 extends s3 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final MaterialCardView R;
    private long S;
    static {
        obj.put(2131362619, 3);
    }

    public t3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, t3.T, t3.U));
    }

    @Override // app.dogo.com.dogo_android.h.s3
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s3
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

    @Override // app.dogo.com.dogo_android.h.s3
    public void V(ArticleWithStatus articleWithStatus) {
        this.Q = articleWithStatus;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s3
    protected void m() {
        long l;
        Article article;
        java.lang.CharSequence charSequence;
        boolean read = false;
        int i2 = 2131231108;
        int i = 0;
        android.graphics.drawable.Drawable drawable = null;
        int i3;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        i2 = 0;
        final long l4 = 3L;
        long l5 = l & l4;
        i = 0;
        if (l5 != l3) {
            if (this.Q != null) {
            } else {
            }
            if (l5 != l3) {
                int r10 = read ? 8 : 4;
                l = l | (read ? 8 : 4);
            }
            if (this.Q != null) {
                String title = article.getTitle();
            }
            int r5 = read ? R.drawable.ic_green_check : R.drawable.arrow_right_green;
        } else {
        }
        l &= l4;
        if (this.S != l3) {
            this.O.setImageDrawable(drawable);
            g.c(this.P, charSequence);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s3
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private t3(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[2], (TextView)objectArr[1], (AppCompatImageView)objectArr[3]);
        this.S = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        this.P.setTag(obj4);
        Object obj5 = objectArr[0];
        this.R = obj5;
        obj5.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
