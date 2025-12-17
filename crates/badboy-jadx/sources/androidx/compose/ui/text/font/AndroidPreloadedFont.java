package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001B\u001f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH ¢\u0006\u0002\u0008\u001dJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\u0008\u001fR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019\u0082\u0001\u0003 !\"\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "Landroidx/compose/ui/text/font/AndroidFont;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "didInitWithContext", "", "getStyle-_-LCdwA", "()I", "I", "typeface", "Landroid/graphics/Typeface;", "getTypeface$ui_text_release", "()Landroid/graphics/Typeface;", "setTypeface$ui_text_release", "(Landroid/graphics/Typeface;)V", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "doLoad", "context", "Landroid/content/Context;", "doLoad$ui_text_release", "loadCached", "loadCached$ui_text_release", "Landroidx/compose/ui/text/font/AndroidAssetFont;", "Landroidx/compose/ui/text/font/AndroidFileDescriptorFont;", "Landroidx/compose/ui/text/font/AndroidFileFont;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AndroidPreloadedFont extends androidx.compose.ui.text.font.AndroidFont {

    public static final int $stable;
    private boolean didInitWithContext;
    private final int style;
    private Typeface typeface;
    private final androidx.compose.ui.text.font.FontWeight weight;
    static {
    }

    private AndroidPreloadedFont(androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        super(FontLoadingStrategy.Companion.getBlocking-PKNRLFQ(), (AndroidFont.TypefaceLoader)AndroidPreloadedFontTypefaceLoader.INSTANCE, variationSettings, 0);
        this.weight = weight;
        this.style = style;
    }

    public AndroidPreloadedFont(androidx.compose.ui.text.font.FontWeight fontWeight, int i2, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(fontWeight, i2, settings3);
    }

    @Override // androidx.compose.ui.text.font.AndroidFont
    public abstract Typeface doLoad$ui_text_release(Context context);

    @Override // androidx.compose.ui.text.font.AndroidFont
    public abstract String getCacheKey();

    @Override // androidx.compose.ui.text.font.AndroidFont
    public final int getStyle-_-LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.AndroidFont
    public final Typeface getTypeface$ui_text_release() {
        return this.typeface;
    }

    @Override // androidx.compose.ui.text.font.AndroidFont
    public final androidx.compose.ui.text.font.FontWeight getWeight() {
        return this.weight;
    }

    @Override // androidx.compose.ui.text.font.AndroidFont
    public final Typeface loadCached$ui_text_release(Context context) {
        boolean doLoad$ui_text_release;
        if (this.didInitWithContext == null && this.typeface == null) {
            if (this.typeface == null) {
                this.typeface = doLoad$ui_text_release(context);
            }
        }
        this.didInitWithContext = true;
        return this.typeface;
    }

    @Override // androidx.compose.ui.text.font.AndroidFont
    public final void setTypeface$ui_text_release(Typeface <set-?>) {
        this.typeface = <set-?>;
    }
}
