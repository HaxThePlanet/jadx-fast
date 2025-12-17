package androidx.compose.ui.text;

import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008#\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001Bc\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018Bc\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001bBm\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001cJ\u0082\u0001\u00107\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u00088\u00109J\u0013\u0010:\u001a\u00020\r2\u0008\u0010;\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010<\u001a\u00020\u000bH\u0016J\u0008\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010*\u001a\u0004\u0008)\u0010(R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008-\u0010.\u001a\u0004\u0008/\u00100R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006?", d2 = {"Landroidx/compose/ui/text/TextLayoutInput;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)V", "_developerSuppliedResourceLoader", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getMaxLines", "()I", "getOverflow-gIe3tQ8", "I", "getPlaceholders", "()Ljava/util/List;", "getResourceLoader$annotations", "()V", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "copy", "copy-hu-1Yfo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Landroidx/compose/ui/text/TextLayoutInput;", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutInput {

    public static final int $stable = 8;
    private Font.ResourceLoader _developerSuppliedResourceLoader;
    private final long constraints;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private final LayoutDirection layoutDirection;
    private final int maxLines;
    private final int overflow;
    private final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders;
    private final boolean softWrap;
    private final androidx.compose.ui.text.TextStyle style;
    private final androidx.compose.ui.text.AnnotatedString text;
    static {
        final int i = 8;
    }

    private TextLayoutInput(androidx.compose.ui.text.AnnotatedString text, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean softWrap, int overflow, Density density, LayoutDirection layoutDirection, Font.ResourceLoader resourceLoader, long constraints) {
        super(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, resourceLoader, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader), constraints, obj12);
    }

    @Deprecated(message = "Font.ResourceLoader is replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(...))
    public TextLayoutInput(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle textStyle2, List list3, int i4, boolean z5, int i6, Density density7, LayoutDirection layoutDirection8, Font.ResourceLoader font$ResourceLoader9, long l10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(annotatedString, textStyle2, list3, i4, z5, i6, density7, layoutDirection8, resourceLoader9, l10, defaultConstructorMarker11);
    }

    private TextLayoutInput(androidx.compose.ui.text.AnnotatedString text, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean softWrap, int overflow, Density density, LayoutDirection layoutDirection, Font.ResourceLoader resourceLoader, FontFamily.Resolver fontFamilyResolver, long constraints) {
        super();
        this.text = text;
        this.style = style;
        this.placeholders = placeholders;
        this.maxLines = maxLines;
        this.softWrap = softWrap;
        this.overflow = overflow;
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.fontFamilyResolver = fontFamilyResolver;
        this.constraints = constraints;
        this._developerSuppliedResourceLoader = resourceLoader;
    }

    private TextLayoutInput(androidx.compose.ui.text.AnnotatedString text, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean softWrap, int overflow, Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long constraints) {
        super(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, 0, fontFamilyResolver, constraints, obj12);
    }

    public TextLayoutInput(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle textStyle2, List list3, int i4, boolean z5, int i6, Density density7, LayoutDirection layoutDirection8, FontFamily.Resolver fontFamily$Resolver9, long l10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(annotatedString, textStyle2, list3, i4, z5, i6, density7, layoutDirection8, resolver9, l10, defaultConstructorMarker11);
    }

    public static androidx.compose.ui.text.TextLayoutInput copy-hu-1Yfo$default(androidx.compose.ui.text.TextLayoutInput textLayoutInput, androidx.compose.ui.text.AnnotatedString annotatedString2, androidx.compose.ui.text.TextStyle textStyle3, List list4, int i5, boolean z6, int i7, Density density8, LayoutDirection layoutDirection9, Font.ResourceLoader font$ResourceLoader10, long l11, int i12, Object object13) {
        androidx.compose.ui.text.AnnotatedString obj1;
        androidx.compose.ui.text.TextStyle obj2;
        List obj3;
        int obj4;
        boolean obj5;
        int obj6;
        Density obj7;
        LayoutDirection obj8;
        Font.ResourceLoader obj9;
        long obj10;
        long obj12;
        if (object13 & 1 != 0) {
            obj1 = textLayoutInput.text;
        }
        if (object13 & 2 != 0) {
            obj2 = textLayoutInput.style;
        }
        if (object13 & 4 != 0) {
            obj3 = textLayoutInput.placeholders;
        }
        if (object13 & 8 != 0) {
            obj4 = textLayoutInput.maxLines;
        }
        if (object13 & 16 != 0) {
            obj5 = textLayoutInput.softWrap;
        }
        if (object13 & 32 != 0) {
            obj6 = textLayoutInput.overflow;
        }
        if (object13 & 64 != 0) {
            obj7 = textLayoutInput.density;
        }
        if (object13 & 128 != 0) {
            obj8 = textLayoutInput.layoutDirection;
        }
        int obj13 = object13 & 256;
        if (obj13 != null) {
            obj9 = textLayoutInput.getResourceLoader();
        }
        obj12 = object13 &= 512 != 0 ? obj10 : l11;
        return textLayoutInput.copy-hu-1Yfo(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj12);
    }

    @Deprecated(message = "Replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(...))
    public static void getResourceLoader$annotations() {
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated", replaceWith = @ReplaceWith(...))
    public final androidx.compose.ui.text.TextLayoutInput copy-hu-1Yfo(androidx.compose.ui.text.AnnotatedString text, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean softWrap, int overflow, Density density, LayoutDirection layoutDirection, Font.ResourceLoader resourceLoader, long constraints) {
        TextLayoutInput textLayoutInput = new TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, resourceLoader, this.fontFamilyResolver, constraints, obj12);
        return textLayoutInput;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof TextLayoutInput) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.text, obj2.text)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.style, obj3.style)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.placeholders, obj4.placeholders)) {
            return i2;
        }
        if (this.maxLines != obj5.maxLines) {
            return i2;
        }
        if (this.softWrap != obj6.softWrap) {
            return i2;
        }
        if (!TextOverflow.equals-impl0(this.overflow, obj7.overflow)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.density, obj8.density)) {
            return i2;
        }
        if (this.layoutDirection != obj9.layoutDirection) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, obj10.fontFamilyResolver)) {
            return i2;
        }
        if (!Constraints.equals-impl0(this.constraints, obj4)) {
            return i2;
        }
        return i;
    }

    public final long getConstraints-msEJaDk() {
        return this.constraints;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getOverflow-gIe3tQ8() {
        return this.overflow;
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final Font.ResourceLoader getResourceLoader() {
        Font.ResourceLoader _developerSuppliedResourceLoader;
        FontFamily.Resolver fontFamilyResolver;
        if (this._developerSuppliedResourceLoader == null) {
            _developerSuppliedResourceLoader = DeprecatedBridgeFontResourceLoader.Companion.from(this.fontFamilyResolver);
        }
        return _developerSuppliedResourceLoader;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    public final androidx.compose.ui.text.TextStyle getStyle() {
        return this.style;
    }

    public final androidx.compose.ui.text.AnnotatedString getText() {
        return this.text;
    }

    public int hashCode() {
        return result8 += i19;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextLayoutInput(text=").append(this.text).append(", style=").append(this.style).append(", placeholders=").append(this.placeholders).append(", maxLines=").append(this.maxLines).append(", softWrap=").append(this.softWrap).append(", overflow=").append(TextOverflow.toString-impl(this.overflow)).append(", density=").append(this.density).append(", layoutDirection=").append(this.layoutDirection).append(", fontFamilyResolver=").append(this.fontFamilyResolver).append(", constraints=").append(Constraints.toString-impl(this.constraints)).append(')').toString();
    }
}
