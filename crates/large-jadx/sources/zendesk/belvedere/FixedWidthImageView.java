package zendesk.belvedere;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.squareup.picasso.c0;
import com.squareup.picasso.t;
import com.squareup.picasso.t.e;
import com.squareup.picasso.x;
import java.util.concurrent.atomic.AtomicBoolean;
import zendesk.belvedere.b0.d;

/* loaded from: classes3.dex */
public class FixedWidthImageView extends AppCompatImageView implements c0 {

    private int a = -1;
    private int b = -1;
    private int c;
    private int v;
    private Uri w = null;
    private t x;
    private final AtomicBoolean y;
    private zendesk.belvedere.FixedWidthImageView.c z;

    class a implements Runnable {

        final zendesk.belvedere.FixedWidthImageView a;
        a(zendesk.belvedere.FixedWidthImageView fixedWidthImageView) {
            this.a = fixedWidthImageView;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.requestLayout();
        }
    }

    static class b {

        private final int a;
        private final int b;
        private final int c;
        private final int d;
        b(int i, int i2, int i3, int i4) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        static int a(zendesk.belvedere.FixedWidthImageView.b fixedWidthImageView$b) {
            return b.b;
        }

        static int b(zendesk.belvedere.FixedWidthImageView.b fixedWidthImageView$b) {
            return b.a;
        }

        static int c(zendesk.belvedere.FixedWidthImageView.b fixedWidthImageView$b) {
            return b.c;
        }

        static int d(zendesk.belvedere.FixedWidthImageView.b fixedWidthImageView$b) {
            return b.d;
        }
    }

    interface c {
        public abstract void a(zendesk.belvedere.FixedWidthImageView.b fixedWidthImageView$b);
    }
    public FixedWidthImageView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        int obj1 = -1;
        obj1 = 0;
        obj1 = new AtomicBoolean(0);
        this.y = obj1;
        init();
    }

    private void a(t t, int i2, int i3, Uri uri4) {
        zendesk.belvedere.FixedWidthImageView.c view;
        zendesk.belvedere.FixedWidthImageView.b bVar;
        int i6;
        int i5;
        int i;
        int i4;
        this.b = i3;
        FixedWidthImageView.a aVar = new FixedWidthImageView.a(this);
        post(aVar);
        view = this.z;
        if (view != null) {
            bVar = new FixedWidthImageView.b(this.v, this.c, this.b, this.a);
            view.a(bVar);
            this.z = 0;
        }
        final x obj7 = t.j(uri4);
        obj7.k(i2, i3);
        obj7.l(a0.d(getContext(), d.d));
        obj7.f(this);
    }

    private Pair<Integer, Integer> b(int i, int i2, int i3) {
        return Pair.create(Integer.valueOf(i), Integer.valueOf((int)obj3));
    }

    private void g(t t, Uri uri2, int i3, int i4, int i5) {
        Object obj3;
        int obj5;
        int obj6;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Start loading image: ");
        stringBuilder.append(i3);
        String str2 = " ";
        stringBuilder.append(str2);
        stringBuilder.append(i4);
        stringBuilder.append(str2);
        stringBuilder.append(i5);
        q.a("FixedWidthImageView", stringBuilder.toString());
        if (i4 > 0 && i5 > 0) {
            if (i5 > 0) {
                obj5 = b(i3, i4, i5);
                a(t, (Integer)obj5.first.intValue(), (Integer)obj5.second.intValue(), uri2);
            } else {
                t.j(uri2).h(this);
            }
        } else {
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void c(t t, Uri uri2, long l3, long l4, zendesk.belvedere.FixedWidthImageView.c fixedWidthImageView$c5) {
        boolean equals;
        t tVar;
        Object obj;
        t tVar2;
        Uri uri;
        Object obj8;
        int obj9;
        if (uri2 != null) {
            if (uri2.equals(this.w)) {
            } else {
                tVar = this.x;
                if (tVar != null) {
                    tVar.c(this);
                    this.x.b(this);
                }
                this.w = uri2;
                this.x = t;
                final int i2 = (int)l3;
                this.c = i2;
                final int i3 = (int)c5;
                this.v = i3;
                this.z = obj14;
                final int i = this.a;
                if (i > 0) {
                    this.g(t, uri2, i, i2, i3);
                } else {
                    this.y.set(true);
                }
            }
        }
        obj8 = new StringBuilder();
        obj8.append("Image already loaded. ");
        obj8.append(uri2);
        q.a("FixedWidthImageView", obj8.toString());
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void d(t t, Uri uri2, zendesk.belvedere.FixedWidthImageView.b fixedWidthImageView$b3) {
        t tVar;
        boolean equals;
        if (uri2 != null) {
            if (uri2.equals(this.w)) {
            } else {
                tVar = this.x;
                if (tVar != null) {
                    tVar.c(this);
                    this.x.b(this);
                }
            }
            this.w = uri2;
            this.x = t;
            this.c = FixedWidthImageView.b.a(b3);
            this.v = FixedWidthImageView.b.b(b3);
            this.b = FixedWidthImageView.b.c(b3);
            final int i4 = FixedWidthImageView.b.d(b3);
            this.a = i4;
            this.g(t, uri2, i4, this.c, this.v);
        }
        StringBuilder obj8 = new StringBuilder();
        obj8.append("Image already loaded. ");
        obj8.append(uri2);
        q.a("FixedWidthImageView", obj8.toString());
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    void init() {
        this.b = getResources().getDimensionPixelOffset(d.c);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void onBitmapFailed(Exception exception, Drawable drawable2) {
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void onBitmapLoaded(Bitmap bitmap, t.e t$e2) {
        this.v = bitmap.getHeight();
        int obj3 = bitmap.getWidth();
        this.c = obj3;
        obj3 = b(this.a, obj3, this.v);
        a(this.x, (Integer)obj3.first.intValue(), (Integer)obj3.second.intValue(), this.w);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onMeasure(int i, int i2) {
        int i6;
        int i3;
        int i4;
        int i5;
        int i7;
        int i8;
        int obj8;
        int obj9;
        i6 = 1073741824;
        if (this.a == -1) {
            this.a = View.MeasureSpec.getSize(i);
        }
        obj9 = this.a;
        obj8 = View.MeasureSpec.makeMeasureSpec(obj9, i6);
        if (obj9 > 0 && this.y.compareAndSet(true, false)) {
            obj8 = View.MeasureSpec.makeMeasureSpec(obj9, i6);
            if (this.y.compareAndSet(true, false)) {
                this.g(this.x, this.w, this.a, this.c, this.v);
            }
        }
        super.onMeasure(obj8, View.MeasureSpec.makeMeasureSpec(this.b, i6));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void onPrepareLoad(Drawable drawable) {
    }
}
