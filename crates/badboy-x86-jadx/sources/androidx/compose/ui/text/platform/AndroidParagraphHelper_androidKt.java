package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.text.SpannableString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.EmojiSupportMatch.Companion;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.LineHeightStyle.Companion;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndent.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.emoji2.text.EmojiCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000]\n\u0000\n\u0002\u0008\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002*\u0001\u0001\u001a\u0080\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u000c2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\r0\u000c2\u0006\u0010\u0011\u001a\u00020\u00122&\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\u000c\u0010\u001c\u001a\u00020\u001b*\u00020\nH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001d", d2 = {"NoopSpan", "androidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1", "Landroidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1;", "createCharSequence", "", "text", "", "contextFontSize", "", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "useEmojiCompat", "", "isIncludeFontPaddingEnabled", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidParagraphHelper_androidKt {

    private static final androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt.NoopSpan.1 NoopSpan;
    static {
        AndroidParagraphHelper_androidKt.NoopSpan.1 anon = new AndroidParagraphHelper_androidKt.NoopSpan.1();
        AndroidParagraphHelper_androidKt.NoopSpan = anon;
    }

    public static final java.lang.CharSequence createCharSequence(String text, float contextFontSize, TextStyle contextTextStyle, List<AnnotatedString.Range<SpanStyle>> spanStyles, List<AnnotatedString.Range<Placeholder>> placeholders, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface, boolean useEmojiCompat) {
        boolean includeFontPaddingEnabled;
        LineHeightStyle lineHeightStyle;
        SpannableString str;
        EmojiSupportMatch configured;
        boolean unspecified--R2X_6o;
        Object lineHeight-XSAIIZE2;
        Object paragraphStyle;
        java.lang.CharSequence process;
        boolean lineHeight-XSAIIZE;
        boolean equals-impl0;
        int i3;
        int unbox-impl;
        TextDecoration underline;
        EmojiCompat emojiCompat;
        java.lang.CharSequence charSequence;
        int i4;
        int length;
        int i2;
        int i;
        final Density density2 = density;
        int i5 = 0;
        if (useEmojiCompat && EmojiCompat.isConfigured()) {
            if (EmojiCompat.isConfigured()) {
                paragraphStyle = contextTextStyle.getPlatformStyle();
                paragraphStyle = paragraphStyle.getParagraphStyle();
                if (paragraphStyle != null && paragraphStyle != null) {
                    paragraphStyle = paragraphStyle.getParagraphStyle();
                    if (paragraphStyle != null) {
                        configured = EmojiSupportMatch.box-impl(paragraphStyle.getEmojiSupportMatch-_3YsG6Y());
                    } else {
                        configured = 0;
                    }
                } else {
                }
                if (configured == null) {
                    equals-impl0 = i5;
                } else {
                    equals-impl0 = EmojiSupportMatch.equals-impl0(configured.unbox-impl(), EmojiSupportMatch.Companion.getAll-_3YsG6Y());
                }
                i3 = equals-impl0 ? 1 : i5;
                Intrinsics.checkNotNull(EmojiCompat.get().process((CharSequence)text, 0, text.length(), Integer.MAX_VALUE, i3));
            } else {
                process = text;
            }
        } else {
        }
        java.lang.CharSequence charSequence2 = process;
        process = TextIndent.Companion.getNone();
        if (spanStyles.isEmpty() && placeholders.isEmpty() && Intrinsics.areEqual(contextTextStyle.getTextIndent(), process) && TextUnitKt.isUnspecified--R2X_6o(contextTextStyle.getLineHeight-XSAIIZE())) {
            if (placeholders.isEmpty()) {
                process = TextIndent.Companion.getNone();
                if (Intrinsics.areEqual(contextTextStyle.getTextIndent(), process)) {
                    if (TextUnitKt.isUnspecified--R2X_6o(contextTextStyle.getLineHeight-XSAIIZE())) {
                        return charSequence2;
                    }
                }
            }
        }
        if (charSequence2 instanceof Spannable) {
            lineHeight-XSAIIZE2 = charSequence2;
        } else {
            lineHeight-XSAIIZE2 = new SpannableString(charSequence2);
        }
        if (Intrinsics.areEqual(contextTextStyle.getTextDecoration(), TextDecoration.Companion.getUnderline())) {
            SpannableExtensions_androidKt.setSpan(lineHeight-XSAIIZE2, AndroidParagraphHelper_androidKt.NoopSpan, i5, text.length());
        }
        if (AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(contextTextStyle) && contextTextStyle.getLineHeightStyle() == null) {
            if (contextTextStyle.getLineHeightStyle() == null) {
                SpannableExtensions_androidKt.setLineHeight-r9BaKPg(lineHeight-XSAIIZE2, contextTextStyle.getLineHeight-XSAIIZE(), underline, contextFontSize);
                str = lineHeight-XSAIIZE2;
            } else {
                if (contextTextStyle.getLineHeightStyle() == null) {
                    lineHeightStyle = LineHeightStyle.Companion.getDefault();
                }
                SpannableExtensions_androidKt.setLineHeight-KmRG4DE(lineHeight-XSAIIZE2, contextTextStyle.getLineHeight-XSAIIZE(), lineHeight-XSAIIZE, contextFontSize, density2);
            }
        } else {
        }
        SpannableExtensions_androidKt.setTextIndent(str, contextTextStyle.getTextIndent(), contextFontSize, density2);
        SpannableExtensions_androidKt.setSpanStyles(str, contextTextStyle, spanStyles, density2, resolveTypeface);
        PlaceholderExtensions_androidKt.setPlaceholders(str, placeholders, density2);
        return (CharSequence)str;
    }

    public static final boolean isIncludeFontPaddingEnabled(TextStyle $this$isIncludeFontPaddingEnabled) {
        Object paragraphStyle;
        int includeFontPadding;
        paragraphStyle = $this$isIncludeFontPaddingEnabled.getPlatformStyle();
        paragraphStyle = paragraphStyle.getParagraphStyle();
        if (paragraphStyle != null && paragraphStyle != null) {
            paragraphStyle = paragraphStyle.getParagraphStyle();
            if (paragraphStyle != null) {
                includeFontPadding = paragraphStyle.getIncludeFontPadding();
            } else {
                includeFontPadding = 0;
            }
        } else {
        }
        return includeFontPadding;
    }
}
