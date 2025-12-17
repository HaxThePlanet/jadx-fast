package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.EmojiSupportMatch.Companion;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextDirection.Companion;
import androidx.compose.ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aP\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u000c0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000c0\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"hasEmojiCompat", "", "Landroidx/compose/ui/text/TextStyle;", "getHasEmojiCompat", "(Landroidx/compose/ui/text/TextStyle;)Z", "ActualParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "resolveTextDirectionHeuristics", "", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "resolveTextDirectionHeuristics-HklW4sA", "(ILandroidx/compose/ui/text/intl/LocaleList;)I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidParagraphIntrinsics_androidKt {
    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String text, TextStyle style, List<AnnotatedString.Range<SpanStyle>> spanStyles, List<AnnotatedString.Range<Placeholder>> placeholders, Density density, FontFamily.Resolver fontFamilyResolver) {
        AndroidParagraphIntrinsics androidParagraphIntrinsics = new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, fontFamilyResolver, density);
        return (ParagraphIntrinsics)androidParagraphIntrinsics;
    }

    public static final boolean access$getHasEmojiCompat(TextStyle $receiver) {
        return AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat($receiver);
    }

    private static final boolean getHasEmojiCompat(TextStyle $this$hasEmojiCompat) {
        Object paragraphStyle;
        int box-impl;
        boolean equals-impl0;
        paragraphStyle = $this$hasEmojiCompat.getPlatformStyle();
        paragraphStyle = paragraphStyle.getParagraphStyle();
        if (paragraphStyle != null && paragraphStyle != null) {
            paragraphStyle = paragraphStyle.getParagraphStyle();
            if (paragraphStyle != null) {
                box-impl = EmojiSupportMatch.box-impl(paragraphStyle.getEmojiSupportMatch-_3YsG6Y());
            } else {
                box-impl = 0;
            }
        } else {
        }
        if (box-impl == 0) {
            equals-impl0 = 0;
        } else {
            equals-impl0 = EmojiSupportMatch.equals-impl0(box-impl.unbox-impl(), EmojiSupportMatch.Companion.getNone-_3YsG6Y());
        }
        return equals-impl0 ^= 1;
    }

    public static final int resolveTextDirectionHeuristics-HklW4sA(int textDirection, LocaleList localeList) {
        boolean it;
        int i;
        int i2;
        int layoutDirectionFromLocale;
        int equals-impl0;
        i = 2;
        if (TextDirection.equals-impl0(textDirection, TextDirection.Companion.getContentOrLtr-s_7X-co())) {
            return i;
        } else {
            i2 = 3;
            if (TextDirection.equals-impl0(textDirection, TextDirection.Companion.getContentOrRtl-s_7X-co())) {
                i = i2;
            } else {
                layoutDirectionFromLocale = 0;
                if (TextDirection.equals-impl0(textDirection, TextDirection.Companion.getLtr-s_7X-co())) {
                    i = layoutDirectionFromLocale;
                } else {
                    if (TextDirection.equals-impl0(textDirection, TextDirection.Companion.getRtl-s_7X-co())) {
                        i = equals-impl0;
                    } else {
                        if (TextDirection.equals-impl0(textDirection, TextDirection.Companion.getContent-s_7X-co())) {
                        } else {
                            equals-impl0 = TextDirection.equals-impl0(textDirection, TextDirection.Companion.getUnspecified-s_7X-co());
                        }
                        if (equals-impl0 == 0) {
                        } else {
                            if (localeList != null) {
                                equals-impl0 = 0;
                                if (localeList.get(layoutDirectionFromLocale).getPlatformLocale() == null) {
                                    it = Locale.getDefault();
                                }
                            } else {
                            }
                            switch (layoutDirectionFromLocale) {
                                case 0:
                                    break;
                                case 1:
                                    i = i2;
                                    break;
                                default:
                            }
                        }
                    }
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Invalid TextDirection.".toString());
        throw illegalStateException;
    }

    public static int resolveTextDirectionHeuristics-HklW4sA$default(int i, LocaleList localeList2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = 0;
        }
        return AndroidParagraphIntrinsics_androidKt.resolveTextDirectionHeuristics-HklW4sA(i, obj1);
    }
}
