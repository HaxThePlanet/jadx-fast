package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008'\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/font/AndroidFont;", "Landroidx/compose/ui/text/font/Font;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "typefaceLoader", "Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "(ILandroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(ILandroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;Landroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLoadingStrategy-PKNRLFQ", "()I", "I", "getTypefaceLoader", "()Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "getVariationSettings", "()Landroidx/compose/ui/text/font/FontVariation$Settings;", "TypefaceLoader", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AndroidFont implements androidx.compose.ui.text.font.Font {

    public static final int $stable;
    private final int loadingStrategy;
    private final androidx.compose.ui.text.font.AndroidFont.TypefaceLoader typefaceLoader;
    private final androidx.compose.ui.text.font.FontVariation.Settings variationSettings;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0008J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "", "awaitLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/AndroidFont;", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface TypefaceLoader {
        public abstract Object awaitLoad(Context context, androidx.compose.ui.text.font.AndroidFont androidFont2, Continuation<? super Typeface> continuation3);

        public abstract Typeface loadBlocking(Context context, androidx.compose.ui.text.font.AndroidFont androidFont2);
    }
    static {
    }

    private AndroidFont(int loadingStrategy, androidx.compose.ui.text.font.AndroidFont.TypefaceLoader typefaceLoader) {
        FontVariation.Settings settings = new FontVariation.Settings(new FontVariation.Setting[0]);
        super(loadingStrategy, typefaceLoader, settings, 0);
    }

    private AndroidFont(int loadingStrategy, androidx.compose.ui.text.font.AndroidFont.TypefaceLoader typefaceLoader, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        super();
        this.loadingStrategy = loadingStrategy;
        this.typefaceLoader = typefaceLoader;
        this.variationSettings = variationSettings;
    }

    public AndroidFont(int i, androidx.compose.ui.text.font.AndroidFont.TypefaceLoader androidFont$TypefaceLoader2, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(i, typefaceLoader2, settings3);
    }

    @Deprecated(message = "Replaced with fontVariation constructor", replaceWith = @ReplaceWith(...))
    public AndroidFont(int i, androidx.compose.ui.text.font.AndroidFont.TypefaceLoader androidFont$TypefaceLoader2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(i, typefaceLoader2);
    }

    @Override // androidx.compose.ui.text.font.Font
    public final int getLoadingStrategy-PKNRLFQ() {
        return this.loadingStrategy;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final androidx.compose.ui.text.font.AndroidFont.TypefaceLoader getTypefaceLoader() {
        return this.typefaceLoader;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final androidx.compose.ui.text.font.FontVariation.Settings getVariationSettings() {
        return this.variationSettings;
    }
}
