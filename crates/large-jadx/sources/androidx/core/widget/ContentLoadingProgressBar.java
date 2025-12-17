package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    boolean a = false;
    private final Runnable b;
    private final Runnable c;
    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
        a obj2 = new a(this);
        this.b = obj2;
        obj2 = new b(this);
        this.c = obj2;
    }

    private void a() {
        setVisibility(8);
    }

    private void c() {
        boolean z;
        if (!this.a) {
            System.currentTimeMillis();
            setVisibility(0);
        }
    }

    private void e() {
        removeCallbacks(this.b);
        removeCallbacks(this.c);
    }

    @Override // android.widget.ProgressBar
    public void b() {
        a();
    }

    @Override // android.widget.ProgressBar
    public void d() {
        c();
    }

    @Override // android.widget.ProgressBar
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.widget.ProgressBar
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }
}
