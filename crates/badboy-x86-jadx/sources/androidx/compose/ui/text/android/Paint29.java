package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\rH\u0007¨\u0006\u000e", d2 = {"Landroidx/compose/ui/text/android/Paint29;", "", "()V", "getTextBounds", "", "paint", "Landroid/graphics/Paint;", "text", "", "start", "", "end", "rect", "Landroid/graphics/Rect;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Paint29 {

    public static final androidx.compose.ui.text.android.Paint29 INSTANCE;
    static {
        Paint29 paint29 = new Paint29();
        Paint29.INSTANCE = paint29;
    }

    @JvmStatic
    public static final void getTextBounds(Paint paint, java.lang.CharSequence text, int start, int end, Rect rect) {
        paint.getTextBounds(text, start, end, rect);
    }
}
