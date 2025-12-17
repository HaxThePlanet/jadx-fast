package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shadow.Companion;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001LBQ\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0008\u0010&\u001a\u00020'H\u0002J\u001e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eJ\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0002J\u0008\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u0006H\u0002J\u0018\u00101\u001a\u00020\u000e2\u0008\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\u0008J@\u00103\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cø\u0001\u0000¢\u0006\u0004\u00084\u00105J\u000e\u00106\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\u000c\u00107\u001a\u00020'*\u000208H\u0016J\u000c\u00109\u001a\u00020'*\u00020:H\u0016J\u001c\u0010;\u001a\u00020\u0010*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0010H\u0016J\u001c\u0010@\u001a\u00020\u0010*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0010H\u0016J&\u0010B\u001a\u00020C*\u00020D2\u0006\u0010=\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\u0008H\u0010IJ\u001c\u0010J\u001a\u00020\u0010*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0010H\u0016J\u001c\u0010K\u001a\u00020\u0010*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0010H\u0016R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u000cX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u000e\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006M", d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getBaselineCache$annotations", "()V", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "I", "semanticsTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textSubstitution", "Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "clearSubstitution", "", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "density", "Landroidx/compose/ui/unit/Density;", "invalidateForTranslate", "setSubstitution", "updatedText", "updateDraw", "color", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-HuAbxIM", "(Landroidx/compose/ui/text/TextStyle;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateText", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "TextSubstitutionValue", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {

    public static final int $stable = 8;
    private androidx.compose.foundation.text.modifiers.ParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private int overflow;
    private ColorProducer overrideColor;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private String text;
    private androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue textSubstitution;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0008HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0008\u0010\u001f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012\"\u0004\u0008\u0014\u0010\u0015¨\u0006 ", d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "", "original", "", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "getOriginal", "()Ljava/lang/String;", "getSubstitution", "setSubstitution", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TextSubstitutionValue {

        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private androidx.compose.foundation.text.modifiers.ParagraphLayoutCache layoutCache;
        private final String original;
        private String substitution;
        static {
            final int i = 8;
        }

        public TextSubstitutionValue(String original, String substitution, boolean isShowingSubstitution, androidx.compose.foundation.text.modifiers.ParagraphLayoutCache layoutCache) {
            super();
            this.original = original;
            this.substitution = substitution;
            this.isShowingSubstitution = isShowingSubstitution;
            this.layoutCache = layoutCache;
        }

        public TextSubstitutionValue(String string, String string2, boolean z3, androidx.compose.foundation.text.modifiers.ParagraphLayoutCache paragraphLayoutCache4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
            int obj3;
            int obj4;
            obj3 = i5 & 4 != 0 ? 0 : obj3;
            obj4 = i5 &= 8 != 0 ? 0 : obj4;
            super(string, string2, obj3, obj4);
        }

        public static androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue copy$default(androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue textStringSimpleNode$TextSubstitutionValue, String string2, String string3, boolean z4, androidx.compose.foundation.text.modifiers.ParagraphLayoutCache paragraphLayoutCache5, int i6, Object object7) {
            String obj1;
            String obj2;
            boolean obj3;
            androidx.compose.foundation.text.modifiers.ParagraphLayoutCache obj4;
            if (i6 & 1 != 0) {
                obj1 = textSubstitutionValue.original;
            }
            if (i6 & 2 != 0) {
                obj2 = textSubstitutionValue.substitution;
            }
            if (i6 & 4 != 0) {
                obj3 = textSubstitutionValue.isShowingSubstitution;
            }
            if (i6 &= 8 != 0) {
                obj4 = textSubstitutionValue.layoutCache;
            }
            return textSubstitutionValue.copy(obj1, obj2, obj3, obj4);
        }

        public final String component1() {
            return this.original;
        }

        public final String component2() {
            return this.substitution;
        }

        public final boolean component3() {
            return this.isShowingSubstitution;
        }

        public final androidx.compose.foundation.text.modifiers.ParagraphLayoutCache component4() {
            return this.layoutCache;
        }

        public final androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue copy(String string, String string2, boolean z3, androidx.compose.foundation.text.modifiers.ParagraphLayoutCache paragraphLayoutCache4) {
            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue = new TextStringSimpleNode.TextSubstitutionValue(string, string2, z3, paragraphLayoutCache4);
            return textSubstitutionValue;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TextStringSimpleNode.TextSubstitutionValue) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.original, obj.original)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.substitution, obj.substitution)) {
                return i2;
            }
            if (this.isShowingSubstitution != obj.isShowingSubstitution) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.layoutCache, obj.layoutCache)) {
                return i2;
            }
            return i;
        }

        public final androidx.compose.foundation.text.modifiers.ParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final String getOriginal() {
            return this.original;
        }

        public final String getSubstitution() {
            return this.substitution;
        }

        public int hashCode() {
            int i;
            if (this.layoutCache == null) {
                i = 0;
            } else {
                i = this.layoutCache.hashCode();
            }
            return i7 += i;
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(androidx.compose.foundation.text.modifiers.ParagraphLayoutCache <set-?>) {
            this.layoutCache = <set-?>;
        }

        public final void setShowingSubstitution(boolean <set-?>) {
            this.isShowingSubstitution = <set-?>;
        }

        public final void setSubstitution(String <set-?>) {
            this.substitution = <set-?>;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("TextSubstitution(layoutCache=").append(this.layoutCache).append(", isShowingSubstitution=").append(this.isShowingSubstitution).append(')').toString();
        }
    }
    static {
        final int i = 8;
    }

    private TextStringSimpleNode(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines, ColorProducer overrideColor) {
        super();
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.overrideColor = overrideColor;
    }

    public TextStringSimpleNode(String string, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, int i4, boolean z5, int i6, int i7, ColorProducer colorProducer8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        int i3;
        int clip-gIe3tQ8;
        int i5;
        int i;
        int i2;
        int i11;
        int i10;
        int i8;
        int i12 = i9;
        if (i12 & 8 != 0) {
            i = clip-gIe3tQ8;
        } else {
            i = i4;
        }
        int i15 = 1;
        i2 = i12 & 16 != 0 ? i15 : z5;
        i11 = i12 & 32 != 0 ? i5 : i6;
        i10 = i12 & 64 != 0 ? i15 : i7;
        i8 = i12 &= 128 != 0 ? i3 : colorProducer8;
        super(string, textStyle2, resolver3, i, i2, i11, i10, i8, 0);
    }

    public TextStringSimpleNode(String string, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, int i4, boolean z5, int i6, int i7, ColorProducer colorProducer8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(string, textStyle2, resolver3, i4, z5, i6, i7, colorProducer8);
    }

    public static final void access$clearSubstitution(androidx.compose.foundation.text.modifiers.TextStringSimpleNode $this) {
        $this.clearSubstitution();
    }

    public static final androidx.compose.foundation.text.modifiers.ParagraphLayoutCache access$getLayoutCache(androidx.compose.foundation.text.modifiers.TextStringSimpleNode $this) {
        return $this.getLayoutCache();
    }

    public static final ColorProducer access$getOverrideColor$p(androidx.compose.foundation.text.modifiers.TextStringSimpleNode $this) {
        return $this.overrideColor;
    }

    public static final TextStyle access$getStyle$p(androidx.compose.foundation.text.modifiers.TextStringSimpleNode $this) {
        return $this.style;
    }

    public static final androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue access$getTextSubstitution$p(androidx.compose.foundation.text.modifiers.TextStringSimpleNode $this) {
        return $this.textSubstitution;
    }

    public static final void access$invalidateForTranslate(androidx.compose.foundation.text.modifiers.TextStringSimpleNode $this) {
        $this.invalidateForTranslate();
    }

    public static final boolean access$setSubstitution(androidx.compose.foundation.text.modifiers.TextStringSimpleNode $this, String updatedText) {
        return $this.setSubstitution(updatedText);
    }

    private final void clearSubstitution() {
        this.textSubstitution = 0;
    }

    private static void getBaselineCache$annotations() {
    }

    private final androidx.compose.foundation.text.modifiers.ParagraphLayoutCache getLayoutCache() {
        androidx.compose.foundation.text.modifiers.ParagraphLayoutCache paragraphLayoutCache;
        String text;
        TextStyle style;
        FontFamily.Resolver fontFamilyResolver;
        int overflow;
        boolean softWrap;
        int maxLines;
        int minLines;
        int i;
        if (this._layoutCache == null) {
            paragraphLayoutCache = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, 0);
            this._layoutCache = paragraphLayoutCache;
        }
        androidx.compose.foundation.text.modifiers.ParagraphLayoutCache _layoutCache2 = this._layoutCache;
        Intrinsics.checkNotNull(_layoutCache2);
        return _layoutCache2;
    }

    private final androidx.compose.foundation.text.modifiers.ParagraphLayoutCache getLayoutCache(Density density) {
        int i;
        boolean showingSubstitution;
        androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue textSubstitution = this.textSubstitution;
        i = 0;
        showingSubstitution = textSubstitution.getLayoutCache();
        if (textSubstitution != null && textSubstitution.isShowingSubstitution() && showingSubstitution != null) {
            i = 0;
            if (textSubstitution.isShowingSubstitution()) {
                showingSubstitution = textSubstitution.getLayoutCache();
                if (showingSubstitution != null) {
                    final int i3 = 0;
                    final int i4 = 0;
                    showingSubstitution.setDensity$foundation_release(density);
                    return showingSubstitution;
                }
            }
        }
        androidx.compose.foundation.text.modifiers.ParagraphLayoutCache layoutCache = getLayoutCache();
        int i2 = 0;
        layoutCache.setDensity$foundation_release(density);
        return layoutCache;
    }

    private final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)this);
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
    }

    private final boolean setSubstitution(String updatedText) {
        int paragraphLayoutCache;
        Object density$foundation_release;
        TextStyle style;
        FontFamily.Resolver fontFamilyResolver;
        int overflow;
        boolean softWrap;
        int maxLines;
        int minLines;
        int i;
        androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue str;
        final androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue textSubstitution = this.textSubstitution;
        if (textSubstitution != null) {
            i = 0;
            if (Intrinsics.areEqual(updatedText, textSubstitution.getSubstitution())) {
                return i;
            }
            textSubstitution.setSubstitution(updatedText);
            androidx.compose.foundation.text.modifiers.ParagraphLayoutCache layoutCache = textSubstitution.getLayoutCache();
            if (layoutCache != null) {
                layoutCache.update-L6sJoHM(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
                paragraphLayoutCache = Unit.INSTANCE;
            } else {
                paragraphLayoutCache = 0;
            }
            if (paragraphLayoutCache == 0) {
                return i;
            }
        } else {
            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue = new TextStringSimpleNode.TextSubstitutionValue(this.text, updatedText, 0, 0, 12, 0);
            str = textSubstitutionValue;
            paragraphLayoutCache = new ParagraphLayoutCache(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, 0);
            paragraphLayoutCache.setDensity$foundation_release(getLayoutCache().getDensity$foundation_release());
            str.setLayoutCache(paragraphLayoutCache);
            this.textSubstitution = str;
        }
        return 1;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Function1 localSemanticsTextLayoutResult;
        androidx.compose.foundation.text.modifiers.TextStringSimpleNode.applySemantics.1 anon;
        String showingSubstitution;
        int annotatedString;
        int substitution;
        int i3;
        int i;
        int i2;
        int i4;
        if (this.semanticsTextLayoutResult == null) {
            anon = new TextStringSimpleNode.applySemantics.1(this);
            this.semanticsTextLayoutResult = (Function1)anon;
        }
        AnnotatedString annotatedString2 = new AnnotatedString(this.text, 0, 0, 6, 0);
        SemanticsPropertiesKt.setText($this$applySemantics, annotatedString2);
        androidx.compose.foundation.text.modifiers.TextStringSimpleNode.TextSubstitutionValue textSubstitution = this.textSubstitution;
        if (textSubstitution != null) {
            SemanticsPropertiesKt.setShowingTextSubstitution($this$applySemantics, textSubstitution.isShowingSubstitution());
            annotatedString = new AnnotatedString(textSubstitution.getSubstitution(), 0, 0, 6, 0);
            SemanticsPropertiesKt.setTextSubstitution($this$applySemantics, annotatedString);
        }
        TextStringSimpleNode.applySemantics.2 anon2 = new TextStringSimpleNode.applySemantics.2(this);
        int i5 = 0;
        int i6 = 1;
        SemanticsPropertiesKt.setTextSubstitution$default($this$applySemantics, i5, (Function1)anon2, i6, i5);
        TextStringSimpleNode.applySemantics.3 anon3 = new TextStringSimpleNode.applySemantics.3(this);
        SemanticsPropertiesKt.showTextSubstitution$default($this$applySemantics, i5, (Function1)anon3, i6, i5);
        TextStringSimpleNode.applySemantics.4 anon4 = new TextStringSimpleNode.applySemantics.4(this);
        SemanticsPropertiesKt.clearTextSubstitution$default($this$applySemantics, i5, (Function0)anon4, i6, i5);
        SemanticsPropertiesKt.getTextLayoutResult$default($this$applySemantics, i5, localSemanticsTextLayoutResult, i6, i5);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged) {
        androidx.compose.foundation.text.modifiers.ParagraphLayoutCache layoutCache;
        boolean semanticsTextLayoutResult;
        String text;
        TextStyle style;
        FontFamily.Resolver fontFamilyResolver;
        int overflow;
        boolean softWrap;
        int maxLines;
        int minLines;
        if (!textChanged) {
            if (layoutChanged) {
                getLayoutCache().update-L6sJoHM(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
            }
        } else {
        }
        if (!isAttached()) {
        }
        if (!textChanged) {
            if (drawChanged && this.semanticsTextLayoutResult != null) {
                if (this.semanticsTextLayoutResult != null) {
                    SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
                }
            }
        } else {
        }
        if (!textChanged) {
            if (layoutChanged) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)this);
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
            }
        } else {
        }
        if (drawChanged) {
            DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        DrawContext drawContext;
        TextDecoration textDecoration;
        Shadow shadow;
        androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle;
        androidx.compose.ui.graphics.Brush brush;
        int i9;
        androidx.compose.ui.graphics.Brush color-0d7_KjU;
        long unspecified-0d7_KjU;
        int $this$isSpecified$iv;
        long alpha;
        float f;
        float f2;
        int i2;
        int i6;
        int i;
        int i7;
        int i10;
        int i3;
        int cmp;
        int i8;
        long l;
        int cmp2;
        int i4;
        int i5;
        final Object obj = this;
        if (!obj.isAttached()) {
        }
        final androidx.compose.foundation.text.modifiers.ParagraphLayoutCache layoutCache = obj.getLayoutCache((Density)$this$draw);
        Paragraph paragraph$foundation_release = layoutCache.getParagraph$foundation_release();
        if (paragraph$foundation_release == null) {
        } else {
            Paragraph paragraph = paragraph$foundation_release;
            final int i13 = 0;
            Canvas canvas = (DrawScope)$this$draw.getDrawContext().getCanvas();
            final int i14 = 0;
            final boolean didOverflow$foundation_release = layoutCache.getDidOverflow$foundation_release();
            if (didOverflow$foundation_release) {
                canvas.save();
                Canvas.clipRect-N_I0leg$default(canvas, 0, 0, (float)width-impl, (float)drawContext, 0, 16, 0);
            }
            if (obj.style.getTextDecoration() == null) {
                textDecoration = TextDecoration.Companion.getNone();
            }
            TextDecoration textDecoration2 = textDecoration;
            if (obj.style.getShadow() == null) {
                shadow = Shadow.Companion.getNone();
            }
            Shadow shadow2 = shadow;
            if (obj.style.getDrawStyle() == null) {
                drawStyle = Fill.INSTANCE;
            }
            androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle2 = drawStyle;
            color-0d7_KjU = obj.style.getBrush();
            if (color-0d7_KjU != null) {
                Paragraph.paint-hn5TExg$default(paragraph, canvas, color-0d7_KjU, obj.style.getAlpha(), shadow2, textDecoration2, drawStyle2, 0, 64, 0);
                brush = color-0d7_KjU;
            } else {
                brush = color-0d7_KjU;
                ColorProducer brush2 = obj.overrideColor;
                if (brush2 != null) {
                    unspecified-0d7_KjU = brush2.invoke-0d7_KjU();
                } else {
                    unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
                }
                i7 = 0;
                cmp = 16;
                i5 = 0;
                $this$isSpecified$iv = Long.compare(unspecified-0d7_KjU, cmp) != 0 ? i4 : i5;
                if ($this$isSpecified$iv != 0) {
                    color-0d7_KjU = l;
                } else {
                    i7 = 0;
                    if (Long.compare(color-0d7_KjU2, cmp) != 0) {
                    } else {
                        i4 = i5;
                    }
                    if (i4 != 0) {
                        color-0d7_KjU = obj.style.getColor-0d7_KjU();
                    } else {
                        color-0d7_KjU = Color.Companion.getBlack-0d7_KjU();
                    }
                }
                Paragraph.paint-LG529CI$default(paragraph, canvas, color-0d7_KjU, alpha, shadow2, textDecoration2, drawStyle2, 0, 32);
            }
            if (didOverflow$foundation_release) {
                canvas.restore();
            }
        }
        int i11 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("no paragraph (layoutCache=").append(obj._layoutCache).append(", textSubstitution=").append(obj.textSubstitution).append(')').toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return getLayoutCache((Density)$this$maxIntrinsicHeight).intrinsicHeight(width, $this$maxIntrinsicHeight.getLayoutDirection());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return getLayoutCache((Density)$this$maxIntrinsicWidth).maxIntrinsicWidth($this$maxIntrinsicWidth.getLayoutDirection());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Object cache;
        LinkedHashMap linkedHashMap;
        int valueOf;
        int i;
        androidx.compose.foundation.text.modifiers.ParagraphLayoutCache layoutCache = getLayoutCache((Density)$this$measure_u2d3p2s80s);
        layoutCache.getObserveFontChanges$foundation_release();
        final Paragraph paragraph$foundation_release = layoutCache.getParagraph$foundation_release();
        Intrinsics.checkNotNull(paragraph$foundation_release);
        final long layoutSize-YbymL2g$foundation_release = layoutCache.getLayoutSize-YbymL2g$foundation_release();
        LayoutModifierNodeKt.invalidateLayer((LayoutModifierNode)this);
        if (layoutCache.layoutWithConstraints-K40F9xA(constraints, obj14) && this.baselineCache == null) {
            LayoutModifierNodeKt.invalidateLayer((LayoutModifierNode)this);
            if (this.baselineCache == null) {
                linkedHashMap = new LinkedHashMap(2);
                cache = linkedHashMap;
            }
            int i2 = 0;
            cache.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(paragraph$foundation_release.getFirstBaseline())));
            i = 0;
            cache.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(paragraph$foundation_release.getLastBaseline())));
            this.baselineCache = cache;
        }
        int width-impl = IntSize.getWidth-impl(layoutSize-YbymL2g$foundation_release);
        Map baselineCache = this.baselineCache;
        Intrinsics.checkNotNull(baselineCache);
        TextStringSimpleNode.measure.1 anon = new TextStringSimpleNode.measure.1(measurable.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(width-impl, IntSize.getWidth-impl(layoutSize-YbymL2g$foundation_release), IntSize.getHeight-impl(layoutSize-YbymL2g$foundation_release), IntSize.getHeight-impl(layoutSize-YbymL2g$foundation_release))));
        return $this$measure_u2d3p2s80s.layout(IntSize.getWidth-impl(layoutSize-YbymL2g$foundation_release), IntSize.getHeight-impl(layoutSize-YbymL2g$foundation_release), baselineCache, (Function1)anon);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return getLayoutCache((Density)$this$minIntrinsicHeight).intrinsicHeight(width, $this$minIntrinsicHeight.getLayoutDirection());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return getLayoutCache((Density)$this$minIntrinsicWidth).minIntrinsicWidth($this$minIntrinsicWidth.getLayoutDirection());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean updateDraw(ColorProducer color, TextStyle style) {
        int changed;
        int i;
        boolean sameDrawAffectingAttributes;
        changed = 0;
        if (!Intrinsics.areEqual(color, this.overrideColor)) {
            changed = 1;
        }
        this.overrideColor = color;
        if (changed == 0) {
            if (!style.hasSameDrawAffectingAttributes(this.style)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean updateLayoutRelatedArgs-HuAbxIM(TextStyle style, int minLines, int maxLines, boolean softWrap, FontFamily.Resolver fontFamilyResolver, int overflow) {
        int changed;
        int i = 0;
        sameLayoutAffectingAttributes ^= 1;
        this.style = style;
        if (this.minLines != minLines) {
            this.minLines = minLines;
            changed = 1;
        }
        if (this.maxLines != maxLines) {
            this.maxLines = maxLines;
            changed = 1;
        }
        if (this.softWrap != softWrap) {
            this.softWrap = softWrap;
            changed = 1;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            changed = 1;
        }
        if (!TextOverflow.equals-impl0(this.overflow, overflow)) {
            this.overflow = overflow;
            changed = 1;
        }
        return changed;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean updateText(String text) {
        if (Intrinsics.areEqual(this.text, text)) {
            return 0;
        }
        this.text = text;
        clearSubstitution();
        return 1;
    }
}
