package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.text.style.TypefaceSpan;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/platform/Api28Impl;", "", "()V", "createTypefaceSpan", "Landroid/text/style/TypefaceSpan;", "typeface", "Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api28Impl {

    public static final androidx.compose.ui.text.platform.Api28Impl INSTANCE;
    static {
        Api28Impl api28Impl = new Api28Impl();
        Api28Impl.INSTANCE = api28Impl;
    }

    public final TypefaceSpan createTypefaceSpan(Typeface typeface) {
        TypefaceSpan typefaceSpan = new TypefaceSpan(typeface);
        return typefaceSpan;
    }
}
