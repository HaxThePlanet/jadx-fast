package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005", d2 = {"setAlpha", "", "Landroid/text/TextPaint;", "alpha", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint $this$setAlpha, float alpha) {
        boolean $i$f$fastRoundToInt;
        int i2;
        float f;
        int i;
        float $this$fastCoerceAtMost$iv$iv;
        int i3;
        int i4;
        int cmp;
        int i5 = 0;
        i2 = 1065353216;
        i = 0;
        int i7 = 0;
        if (!Float.isNaN(alpha) && Float.compare($this$fastCoerceAtMost$iv$iv, i5) < 0) {
            i5 = 0;
            i2 = 1065353216;
            i = 0;
            i7 = 0;
            if (Float.compare($this$fastCoerceAtMost$iv$iv, i5) < 0) {
                $this$fastCoerceAtMost$iv$iv = i5;
            }
            i4 = 0;
            if (Float.compare($this$fastCoerceAtMost$iv$iv, i2) > 0) {
                $this$fastCoerceAtMost$iv$iv = i2;
            }
            int i6 = 0;
            $this$setAlpha.setAlpha(Math.round($this$fastCoerceAtMost$iv$iv *= f2));
        }
    }
}
