package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.AndroidTypeface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000c2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00100\u000cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "()V", "platformTypefaceResolver", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "createDefaultTypeface", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformFontFamilyTypefaceAdapter implements androidx.compose.ui.text.font.FontFamilyTypefaceAdapter {

    public static final int $stable = 8;
    private final androidx.compose.ui.text.font.PlatformTypefaces platformTypefaceResolver;
    static {
        final int i = 8;
    }

    public PlatformFontFamilyTypefaceAdapter() {
        super();
        this.platformTypefaceResolver = PlatformTypefaces_androidKt.PlatformTypefaces();
    }

    public androidx.compose.ui.text.font.TypefaceResult resolve(androidx.compose.ui.text.font.TypefaceRequest typefaceRequest, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader, Function1<? super androidx.compose.ui.text.font.TypefaceResult.Immutable, Unit> onAsyncCompletion, Function1<? super androidx.compose.ui.text.font.TypefaceRequest, ? extends Object> createDefaultTypeface) {
        android.graphics.Typeface nativeTypeface-PYhJU0U;
        boolean z;
        Object fontWeight;
        int fontStyle-_-LCdwA;
        int fontSynthesis-GVVA2EU;
        androidx.compose.ui.text.font.FontFamily fontFamily = typefaceRequest.getFontFamily();
        z = fontFamily == null ? 1 : fontFamily instanceof DefaultFontFamily;
        final int i = 0;
        if (z) {
            nativeTypeface-PYhJU0U = this.platformTypefaceResolver.createDefault-FO1MlWM(typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle-_-LCdwA());
            TypefaceResult.Immutable immutable = new TypefaceResult.Immutable(nativeTypeface-PYhJU0U, 0, 2, i);
            return (TypefaceResult)immutable;
        } else {
            if (fontFamily instanceof GenericFontFamily) {
                nativeTypeface-PYhJU0U = this.platformTypefaceResolver.createNamed-RetOiIg((GenericFontFamily)typefaceRequest.getFontFamily(), typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle-_-LCdwA());
            } else {
                if (fontFamily instanceof LoadedFontFamily) {
                    androidx.compose.ui.text.font.Typeface typeface = (LoadedFontFamily)typefaceRequest.getFontFamily().getTypeface();
                    Intrinsics.checkNotNull(typeface, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
                    nativeTypeface-PYhJU0U = (AndroidTypeface)typeface.getNativeTypeface-PYhJU0U(typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle-_-LCdwA(), typefaceRequest.getFontSynthesis-GVVA2EU());
                }
            }
        }
        return i;
    }
}
