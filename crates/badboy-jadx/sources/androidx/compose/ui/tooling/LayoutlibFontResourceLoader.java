package androidx.compose.ui.tooling;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/ui/tooling/LayoutlibFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "load", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutlibFontResourceLoader implements Font.ResourceLoader {

    public static final int $stable = 8;
    private final Context context;
    static {
        final int i = 8;
    }

    public LayoutlibFontResourceLoader(Context context) {
        super();
        this.context = context;
    }

    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(...))
    public Typeface load(Font font) {
        if (!font instanceof ResourceFont) {
        } else {
            return ResourceFontHelper.INSTANCE.load(this.context, (ResourceFont)font);
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unknown font type: ").append(font.getClass().getName()).toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.text.font.Font$ResourceLoader
    public Object load(Font font) {
        return load(font);
    }
}
