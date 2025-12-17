package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0010¢\u0006\u0002\u0008\u0015J\u0008\u0010\u0016\u001a\u00020\u000cH\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/font/AndroidFileFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "file", "Ljava/io/File;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text_release", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidFileFont extends androidx.compose.ui.text.font.AndroidPreloadedFont {

    public static final int $stable;
    private final String cacheKey;
    private final File file;
    static {
    }

    private AndroidFileFont(File file, androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        int i = 0;
        super(weight, style, variationSettings, i);
        this.file = file;
        setTypeface$ui_text_release(doLoad$ui_text_release(i));
    }

    public AndroidFileFont(File file, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        androidx.compose.ui.text.font.FontWeight fontWeight;
        int i;
        androidx.compose.ui.text.font.FontWeight obj8;
        int obj9;
        if (i5 & 2 != 0) {
            fontWeight = obj8;
        } else {
            fontWeight = fontWeight2;
        }
        if (i5 & 4 != 0) {
            i = obj9;
        } else {
            i = i3;
        }
        super(file, fontWeight, i, settings4, 0);
    }

    public AndroidFileFont(File file, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(file, fontWeight2, i3, settings4);
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public Typeface doLoad$ui_text_release(Context context) {
        return TypefaceBuilderCompat.INSTANCE.createFromFile(this.file, context, getVariationSettings());
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public final File getFile() {
        return this.file;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Font(file=").append(this.file).append(", weight=").append(getWeight()).append(", style=").append(FontStyle.toString-impl(getStyle-_-LCdwA())).append(')').toString();
    }
}
