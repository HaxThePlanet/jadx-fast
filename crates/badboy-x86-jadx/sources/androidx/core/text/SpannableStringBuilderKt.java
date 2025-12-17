package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0008\u0008\u0001\u0010\u0008\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a&\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a0\u0010\u0008\u001a\u00020\u0004*\u00020\u00042\u0008\u0008\u0001\u0010\u0008\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a.\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000c\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a?\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0\u000f\"\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008¢\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a&\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a&\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008\u001a&\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086\u0008¨\u0006\u0019", d2 = {"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "backgroundColor", "color", "", "bold", "inSpans", "span", "", "spans", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "scale", "proportion", "", "strikeThrough", "subscript", "superscript", "underline", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannableStringBuilderKt {
    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder $this$backgroundColor, int color, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color);
        final Object obj = $this$backgroundColor;
        final int i2 = 0;
        builderAction.invoke(obj);
        obj.setSpan(backgroundColorSpan, obj.length(), obj.length(), 17);
        return obj;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder $this$bold, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        StyleSpan styleSpan = new StyleSpan(1);
        Object obj = $this$bold;
        final int i3 = 0;
        builderAction.invoke(obj);
        obj.setSpan(styleSpan, obj.length(), obj.length(), 17);
        return obj;
    }

    public static final SpannedString buildSpannedString(Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        builderAction.invoke(spannableStringBuilder);
        SpannedString spannedString = new SpannedString((CharSequence)spannableStringBuilder);
        return spannedString;
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder $this$color, int color, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        final Object obj = $this$color;
        final int i2 = 0;
        builderAction.invoke(obj);
        obj.setSpan(foregroundColorSpan, obj.length(), obj.length(), 17);
        return obj;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder $this$inSpans, Object span, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        builderAction.invoke($this$inSpans);
        $this$inSpans.setSpan(span, $this$inSpans.length(), $this$inSpans.length(), 17);
        return $this$inSpans;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder $this$inSpans, Object[] spans, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        int i2;
        Object obj;
        int length;
        int i;
        final int i3 = 0;
        builderAction.invoke($this$inSpans);
        i2 = 0;
        while (i2 < spans.length) {
            $this$inSpans.setSpan(spans[i2], $this$inSpans.length(), $this$inSpans.length(), 17);
            i2++;
        }
        return $this$inSpans;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder $this$italic, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        StyleSpan styleSpan = new StyleSpan(2);
        Object obj = $this$italic;
        final int i3 = 0;
        builderAction.invoke(obj);
        obj.setSpan(styleSpan, obj.length(), obj.length(), 17);
        return obj;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder $this$scale, float proportion, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(proportion);
        final Object obj = $this$scale;
        final int i2 = 0;
        builderAction.invoke(obj);
        obj.setSpan(relativeSizeSpan, obj.length(), obj.length(), 17);
        return obj;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder $this$strikeThrough, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        final Object obj = $this$strikeThrough;
        final int i2 = 0;
        builderAction.invoke(obj);
        obj.setSpan(strikethroughSpan, obj.length(), obj.length(), 17);
        return obj;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder $this$subscript, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        final Object obj = $this$subscript;
        final int i2 = 0;
        builderAction.invoke(obj);
        obj.setSpan(subscriptSpan, obj.length(), obj.length(), 17);
        return obj;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder $this$superscript, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        final Object obj = $this$superscript;
        final int i2 = 0;
        builderAction.invoke(obj);
        obj.setSpan(superscriptSpan, obj.length(), obj.length(), 17);
        return obj;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder $this$underline, Function1<? super SpannableStringBuilder, Unit> builderAction) {
        final int i = 0;
        UnderlineSpan underlineSpan = new UnderlineSpan();
        final Object obj = $this$underline;
        final int i2 = 0;
        builderAction.invoke(obj);
        obj.setSpan(underlineSpan, obj.length(), obj.length(), 17);
        return obj;
    }
}
