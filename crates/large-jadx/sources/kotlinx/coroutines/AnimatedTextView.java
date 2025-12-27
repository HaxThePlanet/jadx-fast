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

/* compiled from: AnimatedTextView.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008B!\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0011\u001a\u00020\u0012H\u0014J\u0008\u0010\u0013\u001a\u00020\u0012H\u0014R\u0016\u0010\u000c\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/AnimatedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "foregroundColorSpan", "Landroid/text/style/ForegroundColorSpan;", "onAttachedToWindow", "", "onDetachedFromWindow", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedTextView extends AppCompatTextView implements p {

    /* renamed from: a, reason: from kotlin metadata */
    private final ForegroundColorSpan animator = new ForegroundColorSpan(0);
    /* renamed from: b, reason: from kotlin metadata */
    private final ValueAnimator foregroundColorSpan;
    public AnimatedTextView(Context context, AttributeSet set) {
        n.f(context, "context");
        super(context, set);
        final int i5 = 0;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i5);
        ValueAnimator _int = ValueAnimator.ofInt(new int[] { 0, 4 });
        _int.setRepeatCount(-1);
        _int.setDuration(1000L);
        java.lang.CharSequence text = getText();
        n.e(text, "text");
        if (l.R(text, "...", false, 2, null)) {
            _int.addUpdateListener(new kotlinx.coroutines.a(this));
        }
        this.foregroundColorSpan = _int;
    }

    private static final void i(AnimatedTextView animatedTextView, ValueAnimator valueAnimator) {
        n.f(animatedTextView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int value = animatedValue.intValue();
        int i = 4;
        if (value < 4) {
            java.lang.CharSequence text = animatedTextView.getText();
            Objects.requireNonNull(text, "null cannot be cast to non-null type android.text.Spannable");
            i2 = (animatedTextView.getText().length() - 3) + value;
            value = 33;
            text.setSpan(animatedTextView.animator, i2, animatedTextView.getText().length(), value);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.foregroundColorSpan.start();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.foregroundColorSpan.cancel();
    }

    public static /* synthetic */ void j(AnimatedTextView animatedTextView, ValueAnimator valueAnimator) {
        kotlinx.coroutines.AnimatedTextView.i(animatedTextView, valueAnimator);
    }
}
