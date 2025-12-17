package androidx.compose.ui.text.font;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008`\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0012À\u0006\u0001", d2 = {"Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "", "interceptFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "interceptFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "interceptFontStyle-T2F_aPo", "(I)I", "interceptFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "interceptFontSynthesis-Mscr08Y", "interceptFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PlatformResolveInterceptor {

    public static final androidx.compose.ui.text.font.PlatformResolveInterceptor.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/font/PlatformResolveInterceptor$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "getDefault$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.text.font.PlatformResolveInterceptor.Companion $$INSTANCE;
        private static final androidx.compose.ui.text.font.PlatformResolveInterceptor Default;
        static {
            PlatformResolveInterceptor.Companion companion = new PlatformResolveInterceptor.Companion();
            PlatformResolveInterceptor.Companion.$$INSTANCE = companion;
            PlatformResolveInterceptor.Companion.Default.1 anon = new PlatformResolveInterceptor.Companion.Default.1();
            PlatformResolveInterceptor.Companion.Default = (PlatformResolveInterceptor)anon;
        }

        public final androidx.compose.ui.text.font.PlatformResolveInterceptor getDefault$ui_text_release() {
            return PlatformResolveInterceptor.Companion.Default;
        }
    }
    static {
        PlatformResolveInterceptor.Companion = PlatformResolveInterceptor.Companion.$$INSTANCE;
    }

    public androidx.compose.ui.text.font.FontFamily interceptFontFamily(androidx.compose.ui.text.font.FontFamily fontFamily) {
        return fontFamily;
    }

    public int interceptFontStyle-T2F_aPo(int fontStyle) {
        return fontStyle;
    }

    public int interceptFontSynthesis-Mscr08Y(int fontSynthesis) {
        return fontSynthesis;
    }

    public androidx.compose.ui.text.font.FontWeight interceptFontWeight(androidx.compose.ui.text.font.FontWeight fontWeight) {
        return fontWeight;
    }
}
