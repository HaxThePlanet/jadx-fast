package app.dogo.com.dogo_android.welcome_v2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.p;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008B!\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0011\u001a\u00020\u0012H\u0014J\u0008\u0010\u0013\u001a\u00020\u0012H\u0014R\u0016\u0010\u000c\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/AnimatedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "foregroundColorSpan", "Landroid/text/style/ForegroundColorSpan;", "onAttachedToWindow", "", "onDetachedFromWindow", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AnimatedTextView extends AppCompatTextView implements p {

    private final ForegroundColorSpan a;
    private final ValueAnimator b;
    public AnimatedTextView(Context context, AttributeSet attributeSet2) {
        boolean obj5;
        n.f(context, "context");
        super(context, attributeSet2);
        final int obj6 = 0;
        obj5 = new ForegroundColorSpan(obj6);
        this.a = obj5;
        obj5 = 2;
        int[] iArr = new int[obj5];
        iArr = new int[]{0, 4};
        ValueAnimator int = ValueAnimator.ofInt(iArr);
        int.setRepeatCount(-1);
        int.setDuration(1000);
        java.lang.CharSequence text = getText();
        n.e(text, "text");
        if (l.R(text, "...", obj6, obj5, 0)) {
            obj5 = new a(this);
            int.addUpdateListener(obj5);
        }
        obj5 = w.a;
        this.b = int;
    }

    private static final void i(app.dogo.com.dogo_android.welcome_v2.AnimatedTextView animatedTextView, ValueAnimator valueAnimator2) {
        int text;
        ForegroundColorSpan foregroundColorSpan;
        int i;
        Object obj3;
        int obj4;
        n.f(animatedTextView, "this$0");
        obj4 = valueAnimator2.getAnimatedValue();
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Int");
        obj4 = (Integer)obj4.intValue();
        if (obj4 < 4) {
            text = animatedTextView.getText();
            Objects.requireNonNull(text, "null cannot be cast to non-null type android.text.Spannable");
            (Spannable)text.setSpan(animatedTextView.a, i2 += obj4, animatedTextView.getText().length(), 33);
        }
    }

    public static void j(app.dogo.com.dogo_android.welcome_v2.AnimatedTextView animatedTextView, ValueAnimator valueAnimator2) {
        AnimatedTextView.i(animatedTextView, valueAnimator2);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.start();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.cancel();
    }
}
