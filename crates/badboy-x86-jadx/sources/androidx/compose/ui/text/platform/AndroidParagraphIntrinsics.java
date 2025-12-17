package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u00080\u0007\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010%R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u0014\u00101\u001a\u000202X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0014\u00105\u001a\u000206X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108¨\u00069", d2 = {"Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;)V", "charSequence", "", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "emojiCompatProcessed", "", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "hasStaleResolvedFonts", "getHasStaleResolvedFonts", "()Z", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "getLayoutIntrinsics$ui_text_release", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "getPlaceholders", "()Ljava/util/List;", "resolvedTypefaces", "Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;", "getSpanStyles", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Ljava/lang/String;", "textDirectionHeuristic", "", "getTextDirectionHeuristic$ui_text_release", "()I", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {

    public static final int $stable = 8;
    private final java.lang.CharSequence charSequence;
    private final Density density;
    private final boolean emojiCompatProcessed;
    private final FontFamily.Resolver fontFamilyResolver;
    private final LayoutIntrinsics layoutIntrinsics;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList resolvedTypefaces;
    private final List<AnnotatedString.Range<SpanStyle>> spanStyles;
    private final TextStyle style;
    private final String text;
    private final int textDirectionHeuristic;
    private final androidx.compose.ui.text.platform.AndroidTextPaint textPaint;
    static {
        final int i = 8;
    }

    public AndroidParagraphIntrinsics(String text, TextStyle style, List<AnnotatedString.Range<SpanStyle>> spanStyles, List<AnnotatedString.Range<Placeholder>> placeholders, FontFamily.Resolver fontFamilyResolver, Density density) {
        String str;
        int i3;
        boolean booleanValue;
        float density2;
        Object spanStyles2;
        SpanStyle spanStyle;
        Density density3;
        Object list;
        int i2;
        int i;
        AnnotatedString.Range range;
        final Object obj = this;
        super();
        obj.text = text;
        obj.style = style;
        obj.spanStyles = spanStyles;
        obj.placeholders = placeholders;
        obj.fontFamilyResolver = fontFamilyResolver;
        obj.density = density;
        int i4 = 1;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(i4, obj.density.getDensity());
        obj.textPaint = androidTextPaint;
        if (!AndroidParagraphIntrinsics_androidKt.access$getHasEmojiCompat(obj.style)) {
            booleanValue = 0;
        } else {
            booleanValue = (Boolean)EmojiCompatStatus.INSTANCE.getFontLoaded().getValue().booleanValue();
        }
        obj.emojiCompatProcessed = booleanValue;
        obj.textDirectionHeuristic = AndroidParagraphIntrinsics_androidKt.resolveTextDirectionHeuristics-HklW4sA(obj.style.getTextDirection-s_7X-co(), obj.style.getLocaleList());
        AndroidParagraphIntrinsics.resolveTypeface.1 anon = new AndroidParagraphIntrinsics.resolveTypeface.1(obj);
        TextPaintExtensions_androidKt.setTextMotion(obj.textPaint, obj.style.getTextMotion());
        SpanStyle spanStyle3 = TextPaintExtensions_androidKt.applySpanStyle(obj.textPaint, obj.style.toSpanStyle(), (Function4)anon, obj.density, empty ^= i4);
        if (spanStyle3 != null) {
            size += i4;
            spanStyles2 = new ArrayList(spanStyle);
            density3 = 0;
            while (density3 < spanStyle) {
                i2 = density3;
                i = 0;
                if (i2 == 0) {
                } else {
                }
                i3 = 0;
                range = density2;
                spanStyles2.add(range);
                density3++;
                str = text;
                range = new AnnotatedString.Range(spanStyle3, 0, obj.text.length());
            }
            list = spanStyles2;
        } else {
            list = spanStyles2;
        }
        SpanStyle spanStyle2 = spanStyle3;
        obj.charSequence = AndroidParagraphHelper_androidKt.createCharSequence(obj.text, obj.textPaint.getTextSize(), obj.style, list, obj.placeholders, obj.density, anon, obj.emojiCompatProcessed);
        LayoutIntrinsics layoutIntrinsics = new LayoutIntrinsics(obj.charSequence, (TextPaint)obj.textPaint, obj.textDirectionHeuristic);
        obj.layoutIntrinsics = layoutIntrinsics;
    }

    public static final androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList access$getResolvedTypefaces$p(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics $this) {
        return $this.resolvedTypefaces;
    }

    public static final void access$setResolvedTypefaces$p(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics $this, androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList <set-?>) {
        $this.resolvedTypefaces = <set-?>;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final java.lang.CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        int emojiCompatProcessed;
        int i;
        androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList resolvedTypefaces = this.resolvedTypefaces;
        if (resolvedTypefaces != null) {
            emojiCompatProcessed = resolvedTypefaces.isStaleResolvedFont();
        } else {
            emojiCompatProcessed = i;
        }
        if (emojiCompatProcessed == 0) {
            if (!this.emojiCompatProcessed && AndroidParagraphIntrinsics_androidKt.access$getHasEmojiCompat(this.style) && (Boolean)EmojiCompatStatus.INSTANCE.getFontLoaded().getValue().booleanValue()) {
                if (AndroidParagraphIntrinsics_androidKt.access$getHasEmojiCompat(this.style)) {
                    if ((Boolean)EmojiCompatStatus.INSTANCE.getFontLoaded().getValue().booleanValue()) {
                        i = 1;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final LayoutIntrinsics getLayoutIntrinsics$ui_text_release() {
        return this.layoutIntrinsics;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final List<AnnotatedString.Range<SpanStyle>> getSpanStyles() {
        return this.spanStyles;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final TextStyle getStyle() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final String getText() {
        return this.text;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final int getTextDirectionHeuristic$ui_text_release() {
        return this.textDirectionHeuristic;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final androidx.compose.ui.text.platform.AndroidTextPaint getTextPaint$ui_text_release() {
        return this.textPaint;
    }
}
