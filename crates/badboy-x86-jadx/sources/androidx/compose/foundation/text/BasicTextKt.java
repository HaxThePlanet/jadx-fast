package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyle.Companion;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¦\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0008\u0002\u0010\u0008\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0014\u0008\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0008\u0002\u0010\u0008\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0014\u0008\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0008\u0002\u0010\u0008\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0014\u0008\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0008\u0002\u0010\u0008\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0008\u0002\u0010\u0008\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010 \u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0008\u0002\u0010\u0008\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010!\u001a°\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0008\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010#\u001a\u00020\u000e2\u0014\u0008\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010'2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+\u001a@\u0010,\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\u000c\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\u000c\u00102\u001a\u0008\u0012\u0004\u0012\u0002030-2\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u000e00H\u0002\u001a\u001e\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207062\u0008\u00108\u001a\u0004\u0018\u000109H\u0002\u001aÂ\u0001\u0010:\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\u0008\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0014\u0010;\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020=0<\u0018\u00010-2\u001c\u0010>\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010?0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0008\u0010&\u001a\u0004\u0018\u00010'2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0002ø\u0001\u0000¢\u0006\u0004\u0008@\u0010A\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0003X\u008a\u008e\u0002", d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "LayoutWithLinksAndInlineContent", "hasInlineContent", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "LayoutWithLinksAndInlineContent-vOo2fZY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "textModifier-cFh6CEA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "foundation_release", "displayedText"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicTextKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicText-4YKlhWE(AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Map inlineContent, Composer $composer, int $changed, int i11) {
        int i;
        Object obj;
        int traceInProgress;
        Object modifier3;
        int $composer2;
        int $dirty;
        androidx.compose.ui.Modifier.Companion $dirty2;
        int i5;
        int emptyMap;
        boolean traceInProgress2;
        Object obj5;
        Object str;
        Object obj6;
        int i10;
        int i20;
        int i8;
        Object obj4;
        boolean z;
        int i4;
        int i19;
        Object obj2;
        Map map;
        Object obj3;
        int i9;
        Object companion;
        int modifier2;
        int overflow2;
        int i6;
        Object i7;
        boolean softWrap2;
        int i15;
        boolean i3;
        int i21;
        int i12;
        int i13;
        int i2;
        int i16;
        int i17;
        int i18;
        int i14;
        androidx.compose.ui.Modifier.Companion companion2;
        final int i48 = $changed;
        final int i49 = i11;
        Composer restartGroup = $composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)303@13046L273:BasicText.kt#423gt5");
        $dirty = $changed;
        if (i49 & 1 != 0) {
            $dirty |= 6;
            obj3 = text;
        } else {
            if (i48 & 6 == 0) {
                i5 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i5;
            } else {
                obj3 = text;
            }
        }
        emptyMap = i49 & 2;
        if (emptyMap != null) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i10 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i10;
            } else {
                str = modifier;
            }
        }
        i20 = i49 & 4;
        if (i20 != 0) {
            $dirty |= 384;
            obj4 = style;
        } else {
            if (i48 & 384 == 0) {
                i4 = restartGroup.changed(style) ? 256 : 128;
                $dirty |= i4;
            } else {
                obj4 = style;
            }
        }
        int i46 = i49 & 8;
        if (i46 != 0) {
            $dirty |= 3072;
            obj2 = onTextLayout;
        } else {
            if (i48 & 3072 == 0) {
                i9 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                obj2 = onTextLayout;
            }
        }
        int i50 = i49 & 16;
        if (i50 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else {
            if (i48 & 24576 == 0) {
                i6 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                overflow2 = overflow;
            }
        }
        i7 = i49 & 32;
        int i52 = 196608;
        if (i7 != 0) {
            $dirty |= i52;
            softWrap2 = softWrap;
        } else {
            if (i52 &= i48 == 0) {
                i15 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty |= i15;
            } else {
                softWrap2 = softWrap;
            }
        }
        i3 = i49 & 64;
        i21 = 1572864;
        if (i3 != 0) {
            $dirty |= i21;
            i = maxLines;
        } else {
            if (i48 & i21 == 0) {
                i12 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= i12;
            } else {
                i = maxLines;
            }
        }
        int i23 = i49 & 128;
        i13 = 12582912;
        if (i23 != 0) {
            $dirty |= i13;
            i2 = i23;
            obj = inlineContent;
        } else {
            if (i48 & i13 == 0) {
                i2 = i23;
                i16 = restartGroup.changedInstance(inlineContent) ? 8388608 : 4194304;
                $dirty |= i16;
            } else {
                i2 = i23;
                obj = inlineContent;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty & i17 == 4793490) {
            if (!composer.getSkipping()) {
                if (emptyMap != null) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = str;
                }
                if (i20 != 0) {
                    obj4 = $composer2;
                }
                if (i46 != 0) {
                    obj2 = $composer2;
                }
                if (i50 != 0) {
                    overflow2 = $composer2;
                }
                if (i7 != 0) {
                    softWrap2 = $composer2;
                }
                $composer2 = i3 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                if (i2 != 0) {
                    i2 = emptyMap;
                } else {
                    i2 = inlineContent;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-648605928, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:302)");
                }
                i21 = $composer2;
                i7 = obj2;
                i3 = softWrap2;
                softWrap2 = overflow2;
                overflow2 = obj4;
                BasicTextKt.BasicText-RWo7tUw(obj3, modifier3, overflow2, i7, softWrap2, i3, i21, 1, i2, 0, composer, i31 | i43, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = overflow2;
                obj6 = i7;
                i8 = softWrap2;
                z = i3;
                i19 = i21;
                map = i2;
            } else {
                composer.skipToGroupEnd();
                i19 = maxLines;
                companion = str;
                obj5 = obj4;
                obj6 = obj2;
                i8 = overflow2;
                z = softWrap2;
                map = inlineContent;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = $dirty;
            traceInProgress = new BasicTextKt.BasicText.5(text, companion, obj5, obj6, i8, z, i19, map, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            modifier2 = $dirty;
            $dirty2 = companion2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public static final void BasicText-4YKlhWE(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Composer $composer, int $changed, int i11) {
        int i7;
        int i21;
        int traceInProgress2;
        Object modifier3;
        int $composer2;
        int $dirty;
        androidx.compose.ui.Modifier.Companion $dirty2;
        int i8;
        int i23;
        boolean traceInProgress;
        Object obj3;
        Object str;
        Object obj5;
        int i5;
        int i18;
        int i20;
        Object obj2;
        boolean z;
        int i2;
        int i9;
        Object obj4;
        int i15;
        Object obj;
        int i19;
        Object companion;
        int modifier2;
        int overflow2;
        int i;
        Object i17;
        boolean softWrap2;
        int i4;
        boolean i10;
        int i12;
        int i13;
        int i14;
        int i3;
        int i22;
        int i16;
        int i6;
        androidx.compose.ui.Modifier.Companion companion2;
        final int i48 = $changed;
        final int i49 = i11;
        Composer restartGroup = $composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)327@13717L86:BasicText.kt#423gt5");
        $dirty = $changed;
        if (i49 & 1 != 0) {
            $dirty |= 6;
            obj = text;
        } else {
            if (i48 & 6 == 0) {
                i8 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i8;
            } else {
                obj = text;
            }
        }
        i23 = i49 & 2;
        if (i23 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i5;
            } else {
                str = modifier;
            }
        }
        i18 = i49 & 4;
        if (i18 != 0) {
            $dirty |= 384;
            obj2 = style;
        } else {
            if (i48 & 384 == 0) {
                i2 = restartGroup.changed(style) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj2 = style;
            }
        }
        int i46 = i49 & 8;
        if (i46 != 0) {
            $dirty |= 3072;
            obj4 = onTextLayout;
        } else {
            if (i48 & 3072 == 0) {
                i19 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty |= i19;
            } else {
                obj4 = onTextLayout;
            }
        }
        int i50 = i49 & 16;
        if (i50 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else {
            if (i48 & 24576 == 0) {
                i = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty |= i;
            } else {
                overflow2 = overflow;
            }
        }
        i17 = i49 & 32;
        int i52 = 196608;
        if (i17 != 0) {
            $dirty |= i52;
            softWrap2 = softWrap;
        } else {
            if (i52 &= i48 == 0) {
                i4 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty |= i4;
            } else {
                softWrap2 = softWrap;
            }
        }
        i10 = i49 & 64;
        i12 = 1572864;
        if (i10 != 0) {
            $dirty |= i12;
            i7 = maxLines;
        } else {
            if (i48 & i12 == 0) {
                i13 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= i13;
            } else {
                i7 = maxLines;
            }
        }
        int i25 = i49 & 128;
        int i54 = 12582912;
        if (i25 != 0) {
            $dirty |= i54;
            i14 = i25;
            i21 = minLines;
        } else {
            if (i48 & i54 == 0) {
                i14 = i25;
                i3 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty |= i3;
            } else {
                i14 = i25;
                i21 = minLines;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty & i22 == 4793490) {
            if (!composer.getSkipping()) {
                if (i23 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = str;
                }
                if (i18 != 0) {
                    obj2 = $composer2;
                }
                if (i46 != 0) {
                    obj4 = $composer2;
                }
                if (i50 != 0) {
                    overflow2 = $composer2;
                }
                if (i17 != 0) {
                    softWrap2 = $composer2;
                }
                $composer2 = i10 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                i14 = i14 != 0 ? i23 : minLines;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1542716361, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                i12 = $composer2;
                i17 = obj4;
                i10 = softWrap2;
                softWrap2 = overflow2;
                overflow2 = obj2;
                BasicTextKt.BasicText-VhcvRP8(obj, modifier3, overflow2, i17, softWrap2, i10, i12, i14, 0, composer, i32 | i44, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = overflow2;
                obj5 = i17;
                i20 = softWrap2;
                z = i10;
                i9 = i12;
                i15 = i14;
            } else {
                composer.skipToGroupEnd();
                i9 = maxLines;
                companion = str;
                obj3 = obj2;
                obj5 = obj4;
                i20 = overflow2;
                z = softWrap2;
                i15 = minLines;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = $dirty;
            traceInProgress2 = new BasicTextKt.BasicText.6(text, companion, obj3, obj5, i20, z, i9, i15, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier2 = $dirty;
            $dirty2 = companion2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicText-BpD7jsM(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Composer $composer, int $changed, int i10) {
        int i6;
        boolean traceInProgress;
        Object modifier2;
        int $composer2;
        boolean traceInProgress2;
        int $dirty2;
        Object $dirty;
        int i15;
        Object obj;
        int str;
        Object obj3;
        Object obj4;
        int i;
        int i4;
        Object obj7;
        boolean z2;
        int i16;
        int i9;
        Object obj6;
        Object obj2;
        Object onTextLayout2;
        int modifier3;
        int i12;
        Object i7;
        int overflow2;
        int i2;
        int i13;
        boolean z;
        int i3;
        int i5;
        int i14;
        int i17;
        int i8;
        int i11;
        int i18;
        Object obj5;
        final int i40 = $changed;
        Composer restartGroup = $composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)279@12355L234:BasicText.kt#423gt5");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj6 = text;
        } else {
            if (i40 & 6 == 0) {
                i15 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i15;
            } else {
                obj6 = text;
            }
        }
        str = i10 & 2;
        if (str != null) {
            $dirty2 |= 48;
            obj3 = modifier;
        } else {
            if (i40 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj3 = modifier;
            }
        }
        int i37 = i10 & 4;
        if (i37 != 0) {
            $dirty2 |= 384;
            obj7 = style;
        } else {
            if (i40 & 384 == 0) {
                i16 = restartGroup.changed(style) ? 256 : 128;
                $dirty2 |= i16;
            } else {
                obj7 = style;
            }
        }
        int i39 = i10 & 8;
        if (i39 != 0) {
            $dirty2 |= 3072;
            obj2 = onTextLayout;
        } else {
            if (i40 & 3072 == 0) {
                i12 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty2 |= i12;
            } else {
                obj2 = onTextLayout;
            }
        }
        i7 = i10 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            overflow2 = overflow;
        } else {
            if (i40 & 24576 == 0) {
                i2 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                overflow2 = overflow;
            }
        }
        i13 = i10 & 32;
        int i43 = 196608;
        if (i13 != 0) {
            $dirty2 |= i43;
            z = softWrap;
        } else {
            if (i43 &= i40 == 0) {
                i3 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty2 |= i3;
            } else {
                z = softWrap;
            }
        }
        i5 = i10 & 64;
        i14 = 1572864;
        if (i5 != 0) {
            $dirty2 |= i14;
            i6 = maxLines;
        } else {
            if (i40 & i14 == 0) {
                i17 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty2 |= i17;
            } else {
                i6 = maxLines;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty2 & i8 == 599186) {
            if (!composer.getSkipping()) {
                if (str != null) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj3;
                }
                if (i37 != 0) {
                    obj7 = $composer2;
                }
                if (i39 != 0) {
                    obj2 = $composer2;
                }
                if (i7 != 0) {
                    overflow2 = $composer2;
                }
                if (i13 != 0) {
                    z = $composer2;
                }
                i5 = i5 != 0 ? $composer2 : maxLines;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1022429478, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:278)");
                }
                i7 = obj7;
                i13 = overflow2;
                overflow2 = obj2;
                BasicTextKt.BasicText-VhcvRP8(obj6, modifier2, i7, overflow2, i13, z, i5, 1, 0, composer, $composer2 | i35, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = i7;
                obj4 = overflow2;
                i4 = i13;
                i9 = i5;
                z2 = z;
            } else {
                composer.skipToGroupEnd();
                onTextLayout2 = obj3;
                obj4 = obj10;
                i9 = maxLines;
                obj = obj7;
                i4 = overflow2;
                z2 = z;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier3 = $dirty2;
            traceInProgress = new BasicTextKt.BasicText.4(text, onTextLayout2, obj, obj4, i4, z2, i9, i40, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            modifier3 = $dirty2;
            $dirty = obj5;
        }
    }

    public static final void BasicText-RWo7tUw(AnnotatedString text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, androidx.compose.foundation.text.InlineTextContent> inlineContent, ColorProducer color, Composer $composer, int $changed, int i13) {
        int i30;
        Object obj2;
        Object obj4;
        int traceInProgress2;
        boolean traceInProgress;
        int selectionRegistrar;
        Object invalid$iv;
        int i38;
        int str;
        int $i$a$CacheBasicTextKt$BasicText$selectionController$2;
        AnnotatedString str2;
        Object it$iv;
        int empty;
        Composer restartGroup;
        int i35;
        Object style2;
        Composer composer3;
        Object $composer3;
        int $dirty2;
        Object obj3;
        int $i$f$cache;
        Function0 factory$iv$iv;
        Object onTextLayout3;
        int i20;
        int i17;
        int i2;
        Object overflow2;
        int i45;
        boolean maxLines3;
        int softWrap4;
        boolean maxLines2;
        int softWrap2;
        Object obj;
        int i36;
        int minLines2;
        int i5;
        int i39;
        Object rememberedValue;
        int i12;
        Object obj5;
        int i6;
        Map map;
        int i;
        int backgroundSelectionColor;
        int currentCompositeKeyHash;
        int i24;
        Object i25;
        int i3;
        int i7;
        int materializeModifier;
        Composer i32;
        int i44;
        Object i28;
        int i31;
        int i34;
        int i16;
        int inlineContent2;
        int i19;
        int i14;
        int i26;
        int i10;
        int i33;
        int onTextLayout2;
        int i37;
        Object softWrap3;
        Composer composer;
        int i15;
        int companion;
        SelectionController selectionController;
        int i8;
        int i21;
        int $composer2;
        Composer composer2;
        int i42;
        int i11;
        int i9;
        int i40;
        int i22;
        int i23;
        int i43;
        int i29;
        int i41;
        int i4;
        int i27;
        int i18;
        int $dirty;
        Object selectionRegistrar2;
        boolean links;
        long l;
        Object obj52;
        long obj53;
        int obj54;
        Object obj55;
        long obj56;
        int obj57;
        int obj58;
        int obj59;
        int obj60;
        i32 = $changed;
        final int i107 = i13;
        restartGroup = $composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)196@9257L7:BasicText.kt#423gt5");
        $dirty2 = $changed;
        if (i107 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i32 & 6 == 0) {
                i20 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i20;
            }
        }
        int i84 = i107 & 2;
        if (i84 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i32 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj = modifier;
            }
        }
        i39 = i107 & 4;
        if (i39 != 0) {
            $dirty2 |= 384;
            obj5 = style;
        } else {
            if (i32 & 384 == 0) {
                i = restartGroup.changed(style) ? 256 : 128;
                $dirty2 |= i;
            } else {
                obj5 = style;
            }
        }
        int i99 = i107 & 8;
        if (i99 != 0) {
            $dirty2 |= 3072;
            i25 = onTextLayout;
        } else {
            if (i32 & 3072 == 0) {
                i3 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                i25 = onTextLayout;
            }
        }
        i7 = i107 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            materializeModifier = overflow;
        } else {
            if (i32 & 24576 == 0) {
                i44 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty2 |= i44;
            } else {
                materializeModifier = overflow;
            }
        }
        i28 = i107 & 32;
        i31 = 196608;
        if (i28 != 0) {
            $dirty2 |= i31;
            maxLines2 = softWrap;
        } else {
            if (i32 & i31 == 0) {
                i31 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty2 |= i31;
            } else {
                maxLines2 = softWrap;
            }
        }
        i34 = i107 & 64;
        i16 = 1572864;
        if (i34 != 0) {
            $dirty2 |= i16;
            i45 = maxLines;
        } else {
            if (i32 & i16 == 0) {
                inlineContent2 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty2 |= inlineContent2;
            } else {
                i45 = maxLines;
            }
        }
        int i47 = i107 & 128;
        int i109 = 12582912;
        if (i47 != 0) {
            $dirty2 |= i109;
            i14 = i47;
            i30 = minLines;
        } else {
            if (i32 & i109 == 0) {
                i14 = i47;
                i26 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty2 |= i26;
            } else {
                i14 = i47;
                i30 = minLines;
            }
        }
        int i48 = i107 & 256;
        int i111 = 100663296;
        if (i48 != 0) {
            $dirty2 |= i111;
            i10 = i48;
            obj2 = inlineContent;
        } else {
            if (i32 & i111 == 0) {
                i10 = i48;
                i33 = restartGroup.changedInstance(inlineContent) ? 67108864 : 33554432;
                $dirty2 |= i33;
            } else {
                i10 = i48;
                obj2 = inlineContent;
            }
        }
        int i49 = i107 & 512;
        int i114 = 805306368;
        if (i49 != 0) {
            $dirty2 |= i114;
            onTextLayout2 = i49;
            obj4 = color;
        } else {
            if (i32 & i114 == 0) {
                onTextLayout2 = i49;
                i37 = restartGroup.changedInstance(color) ? 536870912 : 268435456;
                $dirty2 |= i37;
            } else {
                onTextLayout2 = i49;
                obj4 = color;
            }
        }
        if ($dirty2 & softWrap3 == 306783378) {
            if (!restartGroup.getSkipping()) {
                if (i84 != 0) {
                    softWrap3 = traceInProgress2;
                } else {
                    softWrap3 = obj;
                }
                if (i39 != 0) {
                    obj5 = traceInProgress2;
                }
                if (i99 != 0) {
                    i25 = traceInProgress2;
                }
                if (i7 != 0) {
                    i17 = traceInProgress2;
                } else {
                    i17 = materializeModifier;
                }
                if (i28 != 0) {
                    maxLines2 = traceInProgress2;
                }
                if (i34 != 0) {
                    i45 = traceInProgress2;
                }
                i36 = i14 != 0 ? traceInProgress2 : minLines;
                if (i10 != 0) {
                    i14 = traceInProgress2;
                } else {
                    i14 = inlineContent;
                }
                i7 = onTextLayout2 != 0 ? traceInProgress2 : color;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1064305212, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:191)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(i36, i45);
                $i$a$CacheBasicTextKt$BasicText$selectionController$2 = 6;
                int i95 = 0;
                backgroundSelectionColor = 2023513938;
                String str8 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundSelectionColor, str8);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume3;
                String str7 = "CC(remember):BasicText.kt#9igjgp";
                if ((SelectionRegistrar)this_$iv != null) {
                    restartGroup.startReplaceGroup(-1584983428);
                    ComposerKt.sourceInformation(restartGroup, "198@9393L7,200@9539L69,200@9456L152,203@9617L234");
                    i34 = 6;
                    int i108 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundSelectionColor, str8);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    long backgroundColor-0d7_KjU = (TextSelectionColors)restartGroup.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU();
                    onTextLayout2 = obj7;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -328216839, str7);
                    obj52 = restartGroup;
                    int i117 = 0;
                    it$iv = obj52.rememberedValue();
                    int i120 = 0;
                    if (!restartGroup.changedInstance(this_$iv)) {
                        $composer2 = restartGroup;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            int $composer5 = 0;
                            obj54 = it$iv;
                            it$iv = new BasicTextKt.BasicText.selectionController.selectableId.2.1(this_$iv);
                            obj52.updateRememberedValue((Function0)it$iv);
                        } else {
                            composer3 = obj52;
                            obj54 = it$iv;
                        }
                    } else {
                        $composer2 = restartGroup;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    obj57 = i67;
                    obj54 = i121;
                    obj56 = $composer2;
                    restartGroup = obj56;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -328214178, str7);
                    empty = $dirty2;
                    i19 = i17;
                    long $dirty4 = obj53;
                    composer = restartGroup;
                    i15 = 0;
                    obj55 = this_$iv;
                    Object rememberedValue3 = composer.rememberedValue();
                    companion = 0;
                    if (i112 |= changed11 == 0) {
                        $dirty = empty;
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int $dirty3 = 0;
                            obj53 = $dirty4;
                            obj56 = backgroundColor-0d7_KjU;
                            obj52 = selectionController;
                            super(obj53, obj54, obj55, obj56, obj57, 0, 8, 0);
                            backgroundSelectionColor = obj53;
                            selectionRegistrar2 = obj55;
                            $dirty2 = obj56;
                            obj52 = rememberedValue3;
                            composer.updateRememberedValue(obj52);
                        } else {
                            backgroundSelectionColor = $dirty4;
                            $dirty2 = l;
                            selectionRegistrar2 = obj55;
                            $i$a$CacheBasicTextKt$BasicText$selectionController$2 = obj52;
                            selectionRegistrar = composer;
                        }
                    } else {
                        $dirty = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                    i25 = $i$a$CacheBasicTextKt$BasicText$selectionController$2;
                } else {
                    selectionRegistrar2 = this_$iv;
                    $dirty = $dirty2;
                    i19 = i17;
                    onTextLayout2 = i25;
                    restartGroup.startReplaceGroup(-1584467526);
                    restartGroup.endReplaceGroup();
                    i25 = 0;
                }
                int i85 = i19;
                inlineContent2 = AnnotatedStringResolveInlineContentKt.hasInlineContent(text);
                if (!inlineContent2 && !TextAnnotatedStringNodeKt.hasLinks(text)) {
                    if (!TextAnnotatedStringNodeKt.hasLinks(text)) {
                        restartGroup.startReplaceGroup(-1584294453);
                        ComposerKt.sourceInformation(restartGroup, "229@10603L7,217@10089L814");
                        int i83 = 0;
                        int i96 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str8);
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        i32 = restartGroup;
                        Modifier textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(softWrap3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj35, false, 0, 0, 0, obj40, 0, obj42), text, obj5, onTextLayout2, i85, maxLines2, i45, i36, (FontFamily.Resolver)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), 0, 0, i25, i7, 0);
                        style2 = EmptyMeasurePolicy.INSTANCE;
                        rememberedValue = 48;
                        i6 = 0;
                        ComposerKt.sourceInformationMarkerStart(i32, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(i32, 0);
                        obj52 = textModifier-cFh6CEA;
                        invalid$iv = i32.getCurrentCompositionLocalMap();
                        obj53 = constructor;
                        i28 = 6;
                        i34 = 0;
                        ComposerKt.sourceInformationMarkerStart(i32, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i32.startReusableNode();
                        if (i32.getInserting()) {
                            i32.createNode(obj53);
                        } else {
                            factory$iv$iv = obj53;
                            i32.useNode();
                        }
                        Composer constructor-impl = Updater.constructor-impl(i32);
                        i16 = 0;
                        i15 = factory$iv$iv;
                        Updater.set-impl(constructor-impl, (MeasurePolicy)style2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl, invalid$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(i32, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
                        composer = 0;
                        obj53 = constructor-impl;
                        companion = 0;
                        if (!obj53.getInserting()) {
                            obj55 = invalid$iv;
                            obj56 = style2;
                            if (!Intrinsics.areEqual(obj53.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                obj53.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                i35 = obj53;
                            }
                        } else {
                            obj55 = invalid$iv;
                            obj56 = style2;
                        }
                        i32.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i32);
                        ComposerKt.sourceInformationMarkerEnd(i32);
                        i32.endReplaceGroup();
                        i2 = obj54;
                        composer2 = i32;
                        obj3 = onTextLayout2;
                    } else {
                        i32 = restartGroup;
                        i32.startReplaceGroup(-1583391888);
                        ComposerKt.sourceInformation(i32, "241@11076L39,254@11574L7,257@11697L256,243@11125L838");
                        ComposerKt.sourceInformationMarkerStart(i32, -328167685, str7);
                        i38 = $dirty & 14 == 4 ? 1 : 0;
                        Composer composer4 = i32;
                        $i$f$cache = 0;
                        Object rememberedValue4 = composer4.rememberedValue();
                        int i97 = 0;
                        if (i38 == 0) {
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                backgroundSelectionColor = 0;
                                obj52 = i38;
                                obj53 = $i$f$cache;
                                int invalid$iv2 = 0;
                                composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(text, invalid$iv2, 2, invalid$iv2));
                            } else {
                                obj52 = i38;
                                obj53 = $i$f$cache;
                                invalid$iv = rememberedValue4;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(i32);
                        int i68 = 0;
                        int i86 = 0;
                        ComposerKt.sourceInformationMarkerStart(i32, 2023513938, str8);
                        ComposerKt.sourceInformationMarkerEnd(i32);
                        ComposerKt.sourceInformationMarkerStart(i32, -328147596, str7);
                        Composer composer5 = i32;
                        int i87 = 0;
                        rememberedValue = composer5.rememberedValue();
                        i6 = 0;
                        if (!i32.changed(invalid$iv)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                currentCompositeKeyHash = 0;
                                materializeModifier = new BasicTextKt.BasicText.2.1(invalid$iv);
                                composer5.updateRememberedValue((Function1)materializeModifier);
                            } else {
                                materializeModifier = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(i32);
                        composer2 = i32;
                        i16 = onTextLayout2;
                        i28 = softWrap3;
                        onTextLayout2 = obj54;
                        BasicTextKt.LayoutWithLinksAndInlineContent-vOo2fZY(i28, BasicTextKt.BasicText_RWo7tUw$lambda$5((MutableState)invalid$iv), i16, inlineContent2, i14, obj5, onTextLayout2, maxLines2, i45, i36, (FontFamily.Resolver)i32.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), i25, i7, (Function1)materializeModifier, composer2, i65 | i82, i66 &= 896, 0);
                        obj3 = i16;
                        i2 = onTextLayout2;
                        softWrap3 = i28;
                        composer2.endReplaceGroup();
                    }
                } else {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i12 = i36;
                i24 = i7;
                map = i14;
                $composer3 = softWrap3;
                minLines2 = softWrap2;
                maxLines2 = maxLines3;
                softWrap4 = i2;
                overflow2 = obj3;
                onTextLayout3 = i10;
            } else {
                restartGroup.skipToGroupEnd();
                str2 = text;
                i12 = minLines;
                i24 = color;
                composer2 = restartGroup;
                $dirty = $dirty2;
                $composer3 = obj;
                onTextLayout3 = obj5;
                overflow2 = i25;
                map = inlineContent;
                minLines2 = i45;
                softWrap4 = materializeModifier;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new BasicTextKt.BasicText.3(str2, $composer3, onTextLayout3, overflow2, softWrap4, maxLines2, minLines2, i12, map, i24, $changed, i107);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public static final void BasicText-VhcvRP8(AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map inlineContent, Composer $composer, int $changed, int i12) {
        int i7;
        int i13;
        Object obj7;
        boolean traceInProgress;
        int maxLines2;
        int $composer2;
        int $dirty;
        Object $dirty2;
        int i2;
        Object obj2;
        int emptyMap;
        boolean traceInProgress2;
        Object obj3;
        Object modifier2;
        int i22;
        int i25;
        int str;
        Object obj;
        boolean z;
        int i20;
        int i17;
        int i;
        Object obj6;
        int onTextLayout2;
        int i24;
        Object obj4;
        Object obj5;
        int overflow2;
        int $dirty3;
        int i8;
        int i3;
        boolean softWrap2;
        int i4;
        int i21;
        int i23;
        int i14;
        int i15;
        int i5;
        int i6;
        int i16;
        int i9;
        int i10;
        int i19;
        int i18;
        int i11;
        final int i54 = $changed;
        final int i55 = i12;
        Composer restartGroup = $composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)341@14269L240:BasicText.kt#423gt5");
        $dirty = $changed;
        if (i55 & 1 != 0) {
            $dirty |= 6;
            obj5 = text;
        } else {
            if (i54 & 6 == 0) {
                i2 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj5 = text;
            }
        }
        emptyMap = i55 & 2;
        if (emptyMap != null) {
            $dirty |= 48;
            obj3 = modifier;
        } else {
            if (i54 & 48 == 0) {
                i22 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i22;
            } else {
                obj3 = modifier;
            }
        }
        str = i55 & 4;
        if (str != null) {
            $dirty |= 384;
            obj = style;
        } else {
            if (i54 & 384 == 0) {
                i20 = restartGroup.changed(style) ? 256 : 128;
                $dirty |= i20;
            } else {
                obj = style;
            }
        }
        i = i55 & 8;
        if (i != 0) {
            $dirty |= 3072;
            obj6 = onTextLayout;
        } else {
            if (i54 & 3072 == 0) {
                i24 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty |= i24;
            } else {
                obj6 = onTextLayout;
            }
        }
        int i53 = i55 & 16;
        if (i53 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else {
            if (i54 & 24576 == 0) {
                i8 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty |= i8;
            } else {
                overflow2 = overflow;
            }
        }
        i3 = i55 & 32;
        int i57 = 196608;
        if (i3 != 0) {
            $dirty |= i57;
            softWrap2 = softWrap;
        } else {
            if (i57 &= i54 == 0) {
                i4 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty |= i4;
            } else {
                softWrap2 = softWrap;
            }
        }
        i21 = i55 & 64;
        i23 = 1572864;
        if (i21 != 0) {
            $dirty |= i23;
            i7 = maxLines;
        } else {
            if (i54 & i23 == 0) {
                i14 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= i14;
            } else {
                i7 = maxLines;
            }
        }
        int i27 = i55 & 128;
        int i59 = 12582912;
        if (i27 != 0) {
            $dirty |= i59;
            i15 = i27;
            i13 = minLines;
        } else {
            if (i54 & i59 == 0) {
                i15 = i27;
                i5 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                i15 = i27;
                i13 = minLines;
            }
        }
        int i28 = i55 & 256;
        int i61 = 100663296;
        if (i28 != 0) {
            $dirty |= i61;
            i6 = i28;
            obj7 = inlineContent;
        } else {
            if (i54 & i61 == 0) {
                i6 = i28;
                i9 = restartGroup.changedInstance(inlineContent) ? 67108864 : 33554432;
                $dirty |= i9;
            } else {
                i6 = i28;
                obj7 = inlineContent;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty & i10 == 38347922) {
            if (!composer.getSkipping()) {
                if (emptyMap != null) {
                    obj3 = traceInProgress;
                }
                if (str != null) {
                    obj = traceInProgress;
                }
                if (i != 0) {
                    obj6 = traceInProgress;
                }
                if (i53 != 0) {
                    overflow2 = traceInProgress;
                }
                if (i3 != 0) {
                    softWrap2 = traceInProgress;
                }
                maxLines2 = i21 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                $composer2 = i15 != 0 ? 1 : minLines;
                if (i6 != 0) {
                    i10 = emptyMap;
                } else {
                    i10 = inlineContent;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(851408699, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:341)");
                }
                i15 = maxLines2;
                i3 = obj;
                i21 = overflow2;
                i23 = softWrap2;
                overflow2 = obj3;
                softWrap2 = obj6;
                BasicTextKt.BasicText-RWo7tUw(obj5, overflow2, i3, softWrap2, i21, i23, i15, $composer2, i10, 0, composer, i36 | i50, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = overflow2;
                obj2 = i3;
                obj6 = softWrap2;
                i25 = i21;
                z = i23;
                i17 = i15;
                obj4 = i10;
            } else {
                composer.skipToGroupEnd();
                i17 = maxLines;
                i16 = minLines;
                obj4 = inlineContent;
                obj2 = obj;
                i25 = overflow2;
                z = softWrap2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = $dirty;
            traceInProgress = new BasicTextKt.BasicText.7(text, obj3, obj2, obj6, i25, z, i17, i16, obj4, i54, i55);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty3 = $dirty;
            $dirty2 = obj3;
            modifier2 = obj6;
            onTextLayout2 = i16;
        }
    }

    public static final void BasicText-VhcvRP8(String text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, ColorProducer color, Composer $composer, int $changed, int i12) {
        int i25;
        int i7;
        Object obj5;
        boolean traceInProgress2;
        int maxLines2;
        Modifier textModifier-cFh6CEA;
        Composer restartGroup;
        int $composer2;
        androidx.compose.runtime.ProvidableCompositionLocal selectionController;
        Object it$iv;
        int $dirty3;
        Object $dirty4;
        Object $dirty;
        int empty;
        int i4;
        Object obj;
        int minLines4;
        Composer minLines2;
        Composer composer2;
        Composer composer;
        Object obj7;
        Object color3;
        int color2;
        int i26;
        int i3;
        boolean traceInProgress;
        int selectionRegistrar;
        int graphicsLayer-Ap8cVGQ$default2;
        Object obj3;
        boolean z;
        int i35;
        int softWrap2;
        int str;
        boolean z2;
        Object obj8;
        int i2;
        int i28;
        int i37;
        int i20;
        int i16;
        int localFontFamilyResolver;
        int currentCompositionLocalMap;
        int overflow2;
        Object constructor;
        Composer $composer3;
        int i5;
        int i27;
        int backgroundColor-0d7_KjU;
        boolean $i$f$getCurrent;
        int i21;
        int i33;
        Object consume;
        int i36;
        int i11;
        int i40;
        int i29;
        int i30;
        int i8;
        int i38;
        int i31;
        Object obj6;
        boolean selectionController2;
        Modifier graphicsLayer-Ap8cVGQ$default;
        AnnotatedString $i$a$LetComposerKt$cache$1$iv;
        Object obj4;
        Object companion;
        int i22;
        int i23;
        boolean z3;
        int i;
        int i19;
        Object obj2;
        int i14;
        int i17;
        int i6;
        int i18;
        int i15;
        int i10;
        int i32;
        int i34;
        int i24;
        int i39;
        int i9;
        int i13;
        int $dirty2;
        int minLines3;
        Object obj46;
        int obj47;
        Object obj48;
        Object obj49;
        androidx.compose.foundation.text.EmptyMeasurePolicy obj50;
        int obj51;
        int obj52;
        int obj53;
        Composer obj54;
        final int i68 = $changed;
        final int i69 = i12;
        restartGroup = $composer.startRestartGroup(-1186827822);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)101@5004L7,151@6858L41:BasicText.kt#423gt5");
        $dirty3 = $changed;
        if (i69 & 1 != 0) {
            $dirty3 |= 6;
            constructor = text;
        } else {
            if (i68 & 6 == 0) {
                i4 = restartGroup.changed(text) ? 4 : 2;
                $dirty3 |= i4;
            } else {
                constructor = text;
            }
        }
        int i48 = i69 & 2;
        if (i48 != 0) {
            $dirty3 |= 48;
            obj7 = modifier;
        } else {
            if (i68 & 48 == 0) {
                i26 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i26;
            } else {
                obj7 = modifier;
            }
        }
        int i52 = i69 & 4;
        if (i52 != 0) {
            $dirty3 |= 384;
            obj3 = style;
        } else {
            if (i68 & 384 == 0) {
                i35 = restartGroup.changed(style) ? 256 : 128;
                $dirty3 |= i35;
            } else {
                obj3 = style;
            }
        }
        str = i69 & 8;
        if (str != null) {
            $dirty3 |= 3072;
            obj8 = onTextLayout;
        } else {
            if (i68 & 3072 == 0) {
                i28 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty3 |= i28;
            } else {
                obj8 = onTextLayout;
            }
        }
        i20 = i69 & 16;
        if (i20 != 0) {
            $dirty3 |= 24576;
            currentCompositionLocalMap = overflow;
        } else {
            if (i68 & 24576 == 0) {
                i5 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty3 |= i5;
            } else {
                currentCompositionLocalMap = overflow;
            }
        }
        i27 = i69 & 32;
        int i72 = 196608;
        if (i27 != 0) {
            $dirty3 |= i72;
            $i$f$getCurrent = softWrap;
        } else {
            if (i72 &= i68 == 0) {
                i21 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty3 |= i21;
            } else {
                $i$f$getCurrent = softWrap;
            }
        }
        i33 = i69 & 64;
        i11 = 1572864;
        if (i33 != 0) {
            $dirty3 |= i11;
            i25 = maxLines;
        } else {
            if (i68 & i11 == 0) {
                i40 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty3 |= i40;
            } else {
                i25 = maxLines;
            }
        }
        int i42 = i69 & 128;
        int i76 = 12582912;
        if (i42 != 0) {
            $dirty3 |= i76;
            i29 = i42;
            i7 = minLines;
        } else {
            if (i68 & i76 == 0) {
                i29 = i42;
                i30 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty3 |= i30;
            } else {
                i29 = i42;
                i7 = minLines;
            }
        }
        int i43 = i69 & 256;
        int i78 = 100663296;
        if (i43 != 0) {
            $dirty3 |= i78;
            i8 = i43;
            obj5 = color;
        } else {
            if (i68 & i78 == 0) {
                i8 = i43;
                i38 = restartGroup.changedInstance(color) ? 67108864 : 33554432;
                $dirty3 |= i38;
            } else {
                i8 = i43;
                obj5 = color;
            }
        }
        if ($dirty3 & i31 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (i48 != 0) {
                    obj6 = traceInProgress2;
                } else {
                    obj6 = obj7;
                }
                if (i52 != 0) {
                    obj3 = traceInProgress2;
                }
                if (str != null) {
                    obj8 = traceInProgress2;
                }
                if (i20 != 0) {
                    currentCompositionLocalMap = traceInProgress2;
                }
                if (i27 != 0) {
                    $i$f$getCurrent = traceInProgress2;
                }
                maxLines2 = i33 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                minLines4 = i29 != 0 ? 1 : minLines;
                color2 = i8 != 0 ? 0 : color;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1186827822, $dirty3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(minLines4, maxLines2);
                int i59 = 6;
                i16 = 0;
                backgroundColor-0d7_KjU = 2023513938;
                i29 = maxLines2;
                String maxLines3 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundColor-0d7_KjU, maxLines3);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume;
                if ((SelectionRegistrar)this_$iv != null) {
                    restartGroup.startReplaceGroup(-1589202404);
                    ComposerKt.sourceInformation(restartGroup, "103@5140L7,105@5286L69,105@5203L152,108@5364L234");
                    int i64 = 6;
                    int i75 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundColor-0d7_KjU, maxLines3);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    z2 = $i$f$getCurrent;
                    backgroundColor-0d7_KjU = (TextSelectionColors)restartGroup.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU();
                    $dirty2 = $dirty3;
                    String $dirty5 = "CC(remember):BasicText.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -328352935, $dirty5);
                    obj46 = restartGroup;
                    int i83 = 0;
                    obj54 = restartGroup;
                    it$iv = obj46.rememberedValue();
                    int i85 = 0;
                    if (!restartGroup.changedInstance(this_$iv)) {
                        minLines3 = minLines4;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            int minLines5 = 0;
                            obj47 = it$iv;
                            it$iv = new BasicTextKt.BasicText.selectionController.selectableId.1.1(this_$iv);
                            obj46.updateRememberedValue((Function0)it$iv);
                        } else {
                            composer = obj46;
                            obj47 = it$iv;
                        }
                    } else {
                        minLines3 = minLines4;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj54);
                    obj50 = obj54;
                    obj51 = i50;
                    obj48 = selectionController2;
                    minLines2 = obj50;
                    obj47 = longValue;
                    ComposerKt.sourceInformationMarkerStart(minLines2, -328350274, $dirty5);
                    consume = minLines2;
                    i11 = 0;
                    Object rememberedValue2 = consume.rememberedValue();
                    empty = 0;
                    if (i67 |= changed7 == 0) {
                        $i$a$LetComposerKt$cache$1$iv = empty;
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            int $i$a$LetComposerKt$cache$1$iv2 = 0;
                            obj49 = this_$iv;
                            obj46 = selectionController2;
                            super(obj47, obj48, obj49, backgroundColor-0d7_KjU, obj51, 0, 8, 0);
                            companion = obj47;
                            $dirty = obj49;
                            obj46 = rememberedValue2;
                            consume.updateRememberedValue(obj46);
                        } else {
                            companion = obj47;
                            $dirty = this_$iv;
                            selectionRegistrar = obj46;
                            $composer2 = consume;
                        }
                    } else {
                        $i$a$LetComposerKt$cache$1$iv = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(minLines2);
                    minLines2.endReplaceGroup();
                    i18 = selectionRegistrar;
                } else {
                    $dirty2 = $dirty3;
                    minLines3 = minLines4;
                    $dirty = this_$iv;
                    z2 = $i$f$getCurrent;
                    minLines2 = restartGroup;
                    minLines2.startReplaceGroup(-1588686502);
                    minLines2.endReplaceGroup();
                    i18 = selectionRegistrar;
                }
                int i44 = i18;
                if (i44 == 0) {
                    if (obj8 != null) {
                        obj52 = i44;
                        i27 = obj3;
                        i36 = currentCompositionLocalMap;
                        obj4 = obj6;
                        minLines2.startReplaceGroup(-1588564052);
                        ComposerKt.sourceInformation(minLines2, "130@6178L7");
                        super(text, 0, 0, 6, 0);
                        graphicsLayer-Ap8cVGQ$default2 = 0;
                        obj3 = 0;
                        ComposerKt.sourceInformationMarkerStart(minLines2, 2023513938, maxLines3);
                        ComposerKt.sourceInformationMarkerEnd(minLines2);
                        textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i18, false, 0, 0, 0, obj37, 0, obj39), $i$a$LetComposerKt$cache$1$iv, i27, obj8, i36, z2, i29, minLines3, (FontFamily.Resolver)minLines2.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), 0, 0, obj52, color2, 0);
                        minLines2.endReplaceGroup();
                    } else {
                        minLines2.startReplaceGroup(-1587866335);
                        ComposerKt.sourceInformation(minLines2, "143@6671L7");
                        int i71 = 0;
                        int i73 = 0;
                        ComposerKt.sourceInformationMarkerStart(minLines2, 2023513938, maxLines3);
                        ComposerKt.sourceInformationMarkerEnd(minLines2);
                        overflow2 = new TextStringSimpleElement(constructor, obj3, (FontFamily.Resolver)minLines2.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), currentCompositionLocalMap, z2, i29, minLines3, color2, 0);
                        textModifier-cFh6CEA = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i18, false, 0, 0, 0, obj37, 0, obj39).then((Modifier)overflow2);
                        minLines2.endReplaceGroup();
                        i6 = obj52;
                        i22 = obj8;
                        i31 = $i$a$LetComposerKt$cache$1$iv;
                    }
                } else {
                    obj52 = i44;
                    i27 = obj3;
                    i36 = currentCompositionLocalMap;
                    obj4 = obj6;
                }
                restartGroup = EmptyMeasurePolicy.INSTANCE;
                int i53 = 48;
                int i56 = 0;
                ComposerKt.sourceInformationMarkerStart(minLines2, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(minLines2, 0);
                $i$f$getCurrent = 6;
                i33 = 0;
                obj46 = textModifier-cFh6CEA;
                obj49 = $dirty;
                ComposerKt.sourceInformationMarkerStart(minLines2, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                minLines2.startReusableNode();
                if (minLines2.getInserting()) {
                    minLines2.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    minLines2.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(minLines2);
                obj47 = i47;
                Updater.set-impl(constructor-impl, (MeasurePolicy)restartGroup, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, minLines2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(minLines2, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
                i11 = 0;
                obj48 = constructor-impl;
                i8 = 0;
                if (!obj48.getInserting()) {
                    obj50 = restartGroup;
                    obj54 = minLines2;
                    if (!Intrinsics.areEqual(obj48.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj48.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = obj48;
                    }
                } else {
                    obj50 = restartGroup;
                    obj54 = minLines2;
                }
                obj54.endNode();
                ComposerKt.sourceInformationMarkerEnd(obj54);
                ComposerKt.sourceInformationMarkerEnd(obj54);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i37 = color2;
                z = z2;
                obj = i27;
                softWrap2 = i29;
                $dirty4 = i31;
                color3 = i22;
                i3 = i23;
                i2 = minLines3;
            } else {
                restartGroup.skipToGroupEnd();
                softWrap2 = maxLines;
                i37 = color;
                obj54 = restartGroup;
                $dirty2 = $dirty3;
                $dirty4 = obj7;
                obj = obj3;
                color3 = obj8;
                i3 = currentCompositionLocalMap;
                z = $i$f$getCurrent;
                i2 = minLines;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj54.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = obj54;
            traceInProgress2 = new BasicTextKt.BasicText.1(text, $dirty4, obj, color3, i3, z, softWrap2, i2, i37, i68, i69);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $composer3 = obj54;
        }
    }

    private static final AnnotatedString BasicText_RWo7tUw$lambda$5(MutableState<AnnotatedString> $displayedText$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (AnnotatedString)(State)$displayedText$delegate.getValue();
    }

    private static final void BasicText_RWo7tUw$lambda$6(MutableState<AnnotatedString> $displayedText$delegate, AnnotatedString value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $displayedText$delegate.setValue(value);
    }

    private static final void LayoutWithLinksAndInlineContent-vOo2fZY(Modifier modifier, AnnotatedString text, Function1<? super TextLayoutResult, Unit> onTextLayout, boolean hasInlineContent, Map<String, androidx.compose.foundation.text.InlineTextContent> inlineContent, TextStyle style, int overflow, boolean softWrap, int maxLines, int minLines, FontFamily.Resolver fontFamilyResolver, SelectionController selectionController, ColorProducer color, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation, Composer $composer, int $changed, int $changed1, int i18) {
        int traceInProgress;
        Object inlineContent3;
        int $this$cache$iv2;
        Unit iNSTANCE;
        Unit iNSTANCE2;
        Composer it$iv2;
        Object endRestartGroup;
        int it$iv4;
        boolean traceInProgress2;
        int i20;
        Object obj4;
        int i9;
        Object obj3;
        Object obj5;
        Object obj7;
        Object empty4;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1 it$iv5;
        Object it$iv6;
        Object it$iv;
        boolean textModifier-cFh6CEA;
        int i4;
        int i5;
        int empty;
        Pair resolveInlineContent;
        Object inlineComposables2;
        int invalid$iv;
        Object linksTextMeasurePolicy;
        Composer composer;
        int i15;
        Object obj9;
        Object $composer2;
        int $dirty;
        int $dirty1;
        Composer composer2;
        Object obj6;
        int i27;
        Object currentCompositionLocalMap;
        Object rememberedValue;
        int currentCompositeKeyHash;
        int i28;
        int i11;
        int i;
        int i26;
        int i8;
        int materializeModifier;
        int empty3;
        Object constructor;
        Composer $this$cache$iv;
        int empty2;
        Object anon;
        boolean anon3;
        int changedInstance;
        int i24;
        int i22;
        int i16;
        int i10;
        Object obj8;
        int companion2;
        int companion3;
        int companion;
        Composer $composer3;
        int it$iv3;
        int i14;
        int i6;
        int i12;
        int i3;
        int modifier$iv;
        int i2;
        int changedInstance2;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.2.1 anon2;
        int i13;
        boolean z;
        int i7;
        int i21;
        FontFamily.Resolver resolver;
        Object obj10;
        Object obj2;
        Object obj;
        SelectionController selectionController2;
        ColorProducer colorProducer;
        Function1 function1;
        int i17;
        int i25;
        int i19;
        int i23;
        int $dirty12;
        Object inlineContent2;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1 anon4;
        Object inlineComposables;
        ScopeUpdateScope scopeUpdateScope;
        Object obj49;
        int obj59;
        final Object obj12 = text;
        obj4 = onTextLayout;
        final int i95 = $changed;
        int i29 = $changed1;
        int i35 = i18;
        $composer2 = $composer.startRestartGroup(645129368);
        ComposerKt.sourceInformation($composer2, "C(LayoutWithLinksAndInlineContent)P(6,13,8,2,3,12,9:c#ui.text.style.TextOverflow,11,4,5,1,10)578@22283L117,565@21843L1459:BasicText.kt#423gt5");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (i35 & 1 != 0) {
            $dirty |= 6;
            obj6 = modifier;
        } else {
            if (i95 & 6 == 0) {
                i11 = $composer2.changed(modifier) ? 4 : 2;
                $dirty |= i11;
            } else {
                obj6 = modifier;
            }
        }
        if (i35 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i95 & 48 == 0) {
                i = $composer2.changed(obj12) ? 32 : 16;
                $dirty |= i;
            }
        }
        if (i35 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i95 & 384 == 0) {
                i26 = $composer2.changedInstance(obj4) ? 256 : changedInstance;
                $dirty |= i26;
            }
        }
        companion3 = 1024;
        if (i35 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i95 & 3072 == 0) {
                i8 = $composer2.changed(hasInlineContent) ? i16 : companion3;
                $dirty |= i8;
            }
        }
        materializeModifier = i35 & 16;
        if (materializeModifier != 0) {
            $dirty |= 24576;
            constructor = inlineContent;
        } else {
            if (i95 & 24576 == 0) {
                i6 = $composer2.changedInstance(inlineContent) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                constructor = inlineContent;
            }
        }
        int i101 = 196608;
        if (i35 & 32 != 0) {
            $dirty |= i101;
            currentCompositionLocalMap = style;
        } else {
            if (i95 & i101 == 0) {
                i12 = $composer2.changed(style) ? 131072 : 65536;
                $dirty |= i12;
            } else {
                currentCompositionLocalMap = style;
            }
        }
        modifier$iv = 1572864;
        if (i35 & 64 != 0) {
            $dirty |= modifier$iv;
            currentCompositeKeyHash = overflow;
        } else {
            if (i95 & modifier$iv == 0) {
                modifier$iv = $composer2.changed(overflow) ? 1048576 : 524288;
                $dirty |= modifier$iv;
            } else {
                currentCompositeKeyHash = overflow;
            }
        }
        if (i35 & 128 != 0) {
            $dirty |= i94;
            anon3 = softWrap;
        } else {
            if (i92 &= i95 == 0) {
                i2 = $composer2.changed(softWrap) ? 8388608 : 4194304;
                $dirty |= i2;
            } else {
                anon3 = softWrap;
            }
        }
        if (i35 & 256 != 0) {
            $dirty |= i65;
            empty = maxLines;
        } else {
            if (i72 &= i95 == 0) {
                changedInstance2 = $composer2.changed(maxLines) ? 67108864 : 33554432;
                $dirty |= changedInstance2;
            } else {
                empty = maxLines;
            }
        }
        if (i35 & 512 != 0) {
            $dirty |= i44;
            i9 = minLines;
        } else {
            if (i42 &= i95 == 0) {
                changedInstance2 = $composer2.changed(minLines) ? 536870912 : 268435456;
                $dirty |= changedInstance2;
            } else {
                i9 = minLines;
            }
        }
        if (i35 & 1024 != 0) {
            $dirty1 |= 6;
            obj3 = fontFamilyResolver;
        } else {
            if (i29 & 6 == 0) {
                changedInstance2 = $composer2.changedInstance(fontFamilyResolver) ? 4 : 2;
                $dirty1 |= changedInstance2;
            } else {
                obj3 = fontFamilyResolver;
            }
        }
        if (i35 & 2048 != 0) {
            $dirty1 |= 48;
            obj5 = selectionController;
        } else {
            if (i29 & 48 == 0) {
                it$iv3 = $composer2.changedInstance(selectionController) ? 32 : 16;
                $dirty1 |= it$iv3;
            } else {
                obj5 = selectionController;
            }
        }
        if (i35 & 4096 != 0) {
            $dirty1 |= 384;
            obj7 = color;
        } else {
            if (i29 & 384 == 0) {
                if ($composer2.changedInstance(color)) {
                    changedInstance = 256;
                }
                $dirty1 |= changedInstance;
            } else {
                obj7 = color;
            }
        }
        if (i35 & 8192 != 0) {
            $dirty1 |= 3072;
            empty4 = onShowTranslation;
        } else {
            if (i29 & 3072 == 0) {
                if ($composer2.changedInstance(onShowTranslation)) {
                } else {
                    i16 = companion3;
                }
                $dirty1 |= i16;
            } else {
                empty4 = onShowTranslation;
            }
        }
        if ($dirty & i24 == 306783378 && $dirty1 & 1171 == 1170) {
            if ($dirty1 & 1171 == 1170) {
                if (!$composer2.getSkipping()) {
                    if (materializeModifier != 0) {
                        inlineContent3 = MapsKt.emptyMap();
                    } else {
                        inlineContent3 = constructor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(645129368, $dirty, $dirty1, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:536)");
                    }
                    obj49 = 0;
                    empty3 = "CC(remember):BasicText.kt#9igjgp";
                    i23 = 1;
                    if (TextAnnotatedStringNodeKt.hasLinks(obj12)) {
                        $composer2.startReplaceGroup(-619323167);
                        ComposerKt.sourceInformation($composer2, "539@20954L38");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297072527, empty3);
                        i20 = $dirty & 112 == 32 ? i23 : obj49;
                        constructor = $composer2;
                        i24 = 0;
                        it$iv4 = constructor.rememberedValue();
                        companion3 = 0;
                        if (i20 == 0) {
                            if (it$iv4 == Composer.Companion.getEmpty()) {
                                empty4 = 0;
                                it$iv3 = it$iv4;
                                it$iv4 = new TextLinkScope(obj12);
                                constructor.updateRememberedValue(it$iv4);
                            } else {
                                it$iv3 = it$iv4;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-619265198);
                        $composer2.endReplaceGroup();
                        it$iv4 = 0;
                    }
                    if (TextAnnotatedStringNodeKt.hasLinks(obj12)) {
                        $composer2.startReplaceGroup(-619074547);
                        ComposerKt.sourceInformation($composer2, "545@21203L90");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297064507, empty3);
                        i4 = $dirty & 112 == 32 ? i23 : obj49;
                        $this$cache$iv = $composer2;
                        i22 = 0;
                        it$iv5 = $this$cache$iv.rememberedValue();
                        companion = 0;
                        if (i4 |= changed6 == 0) {
                            if (it$iv5 == Composer.Companion.getEmpty()) {
                                empty = 0;
                                it$iv3 = it$iv5;
                                it$iv5 = new BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1(it$iv4, obj12);
                                $this$cache$iv.updateRememberedValue((Function0)it$iv5);
                            } else {
                                it$iv3 = it$iv5;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                        $dirty12 = $dirty1;
                    } else {
                        $composer2.startReplaceGroup(-618966357);
                        ComposerKt.sourceInformation($composer2, "548@21307L8");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297061261, empty3);
                        i5 = $dirty & 112 == 32 ? i23 : obj49;
                        empty = $composer2;
                        $this$cache$iv = 0;
                        it$iv5 = empty.rememberedValue();
                        i10 = 0;
                        if (i5 == 0) {
                            $dirty12 = $dirty1;
                            if (it$iv5 == Composer.Companion.getEmpty()) {
                                $dirty1 = 0;
                                companion = it$iv5;
                                it$iv5 = new BasicTextKt.LayoutWithLinksAndInlineContent.styledText.2.1(obj12);
                                empty.updateRememberedValue((Function0)it$iv5);
                            } else {
                                companion = it$iv5;
                            }
                        } else {
                            $dirty12 = $dirty1;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    }
                    if (hasInlineContent) {
                        resolveInlineContent = AnnotatedStringResolveInlineContentKt.resolveInlineContent(obj12, inlineContent3);
                    } else {
                        $dirty1 = 0;
                        resolveInlineContent = new Pair($dirty1, $dirty1);
                    }
                    inlineComposables2 = resolveInlineContent.component2();
                    if (hasInlineContent) {
                        $composer2.startReplaceGroup(-618671702);
                        ComposerKt.sourceInformation($composer2, "558@21610L61");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297051512, empty3);
                        $this$cache$iv = 0;
                        i22 = $composer2;
                        i10 = 0;
                        inlineContent2 = inlineContent3;
                        Object rememberedValue2 = i22.rememberedValue();
                        companion = 0;
                        anon4 = it$iv5;
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            it$iv3 = rememberedValue2;
                            obj59 = i52;
                            int it$iv7 = 0;
                            i22.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(it$iv7, it$iv7, 2, it$iv7));
                        } else {
                            it$iv2 = i22;
                            it$iv5 = it$iv3;
                        }
                        $this$cache$iv2 = it$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    } else {
                        inlineContent2 = inlineContent3;
                        anon4 = it$iv5;
                        $composer2.startReplaceGroup(-618591630);
                        $composer2.endReplaceGroup();
                        $this$cache$iv2 = 0;
                    }
                    if (hasInlineContent) {
                        $composer2.startReplaceGroup(-618506565);
                        ComposerKt.sourceInformation($composer2, "562@21777L44");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297046185, empty3);
                        Composer composer5 = $composer2;
                        i22 = 0;
                        it$iv6 = composer5.rememberedValue();
                        i10 = 0;
                        if (!$composer2.changed($this$cache$iv2)) {
                            inlineComposables = inlineComposables2;
                            if (it$iv6 == Composer.Companion.getEmpty()) {
                                inlineComposables2 = 0;
                                companion = it$iv6;
                                it$iv6 = new BasicTextKt.LayoutWithLinksAndInlineContent.onPlaceholderLayout.1.1($this$cache$iv2);
                                composer5.updateRememberedValue((Function1)it$iv6);
                            } else {
                                companion = it$iv6;
                            }
                        } else {
                            inlineComposables = inlineComposables2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                        obj2 = $this$cache$iv;
                    } else {
                        inlineComposables = inlineComposables2;
                        $composer2.startReplaceGroup(-618442830);
                        $composer2.endReplaceGroup();
                        obj2 = 0;
                    }
                    ComposerKt.sourceInformationMarkerStart($composer2, -297029920, empty3);
                    if ($dirty & 896 == 256) {
                    } else {
                        i23 = obj49;
                    }
                    changedInstance3 |= i23;
                    Composer composer4 = $composer2;
                    empty2 = 0;
                    it$iv = composer4.rememberedValue();
                    int i96 = 0;
                    if (invalid$iv == 0) {
                        obj59 = invalid$iv;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            invalid$iv = 0;
                            obj8 = it$iv;
                            it$iv = new BasicTextKt.LayoutWithLinksAndInlineContent.2.1(it$iv4, obj4);
                            composer4.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj8 = it$iv;
                        }
                    } else {
                        obj59 = invalid$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj28, false, 0, 0, 0, obj33, 0, obj35), (AnnotatedString)anon4.invoke(), currentCompositionLocalMap, (Function1)it$iv, currentCompositeKeyHash, anon3, maxLines, minLines, fontFamilyResolver, (List)resolveInlineContent.component1(), obj2, selectionController, color, onShowTranslation);
                    if (!hasInlineContent) {
                        $composer2.startReplaceGroup(-617362851);
                        ComposerKt.sourceInformation($composer2, "595@22992L55");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297007294, empty3);
                        composer2 = $composer2;
                        i27 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i28 = 0;
                        if (!$composer2.changedInstance(it$iv4)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty3 = 0;
                                anon = new BasicTextKt.LayoutWithLinksAndInlineContent.3.1(it$iv4);
                                composer2.updateRememberedValue((Function0)anon);
                            } else {
                                anon = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        linksTextMeasurePolicy = new LinksTextMeasurePolicy((Function0)anon);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-617202116);
                        ComposerKt.sourceInformation($composer2, "599@23147L55,600@23233L39");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297002334, empty3);
                        Composer composer3 = $composer2;
                        int i77 = 0;
                        Object rememberedValue4 = composer3.rememberedValue();
                        int i81 = 0;
                        if (!$composer2.changedInstance(it$iv4)) {
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                anon3 = new BasicTextKt.LayoutWithLinksAndInlineContent.4.1(it$iv4);
                                composer3.updateRememberedValue((Function0)anon3);
                            } else {
                                anon3 = rememberedValue4;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, -296999598, empty3);
                        composer2 = $composer2;
                        i27 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i28 = 0;
                        if (!$composer2.changed($this$cache$iv2)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty3 = 0;
                                anon = new BasicTextKt.LayoutWithLinksAndInlineContent.5.1($this$cache$iv2);
                                composer2.updateRememberedValue((Function0)anon);
                            } else {
                                anon = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        linksTextMeasurePolicy = new TextMeasurePolicy((Function0)anon3, (Function0)anon);
                        $composer2.endReplaceGroup();
                    }
                    obj6 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, obj49);
                    i24 = 0;
                    obj59 = $this$cache$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(ComposeUiNode.Companion.getConstructor());
                    } else {
                        $composer2.useNode();
                    }
                    Composer constructor-impl = Updater.constructor-impl($composer2);
                    companion3 = i40;
                    Updater.set-impl(constructor-impl, linksTextMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, $composer2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i97 = 0;
                    it$iv3 = constructor-impl;
                    i3 = 0;
                    if (!it$iv3.getInserting()) {
                        modifier$iv = textModifier-cFh6CEA;
                        i2 = linksTextMeasurePolicy;
                        if (!Intrinsics.areEqual(it$iv3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            it$iv3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = it$iv3;
                        }
                    } else {
                        modifier$iv = textModifier-cFh6CEA;
                        i2 = linksTextMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($composer2, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
                    obj4 = $composer2;
                    empty4 = 0;
                    i16 = i31;
                    ComposerKt.sourceInformationMarkerStart(obj4, -515487512, "C:BasicText.kt#423gt5");
                    if (it$iv4 == null) {
                        obj4.startReplaceGroup(-515480539);
                        obj4.endReplaceGroup();
                    } else {
                        obj4.startReplaceGroup(537560924);
                        ComposerKt.sourceInformation(obj4, "567@21894L18");
                        it$iv4.LinksComposables(obj4, 0);
                        obj4.endReplaceGroup();
                        iNSTANCE = Unit.INSTANCE;
                    }
                    if (inlineComposables == null) {
                        obj4.startReplaceGroup(-515428893);
                        obj4.endReplaceGroup();
                        obj49 = it$iv4;
                    } else {
                        obj4.startReplaceGroup(-515428892);
                        ComposerKt.sourceInformation(obj4, "*569@21966L48");
                        i15 = 0;
                        obj49 = it$iv4;
                        AnnotatedStringResolveInlineContentKt.InlineChildren(obj12, inlineComposables, obj4, companion3 & 14);
                        Unit it = Unit.INSTANCE;
                        obj4.endReplaceGroup();
                        iNSTANCE2 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj4);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj9 = inlineContent2;
                } else {
                    $composer2.skipToGroupEnd();
                    $dirty12 = $dirty1;
                    obj9 = constructor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = $composer2;
            i14 = $dirty;
            endRestartGroup = new BasicTextKt.LayoutWithLinksAndInlineContent.6(modifier, obj12, onTextLayout, hasInlineContent, obj9, style, overflow, softWrap, maxLines, minLines, fontFamilyResolver, selectionController, color, onShowTranslation, i95, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer3 = $composer2;
            i14 = $dirty;
        }
    }

    public static final void access$BasicText_RWo7tUw$lambda$6(MutableState $displayedText$delegate, AnnotatedString value) {
        BasicTextKt.BasicText_RWo7tUw$lambda$6($displayedText$delegate, value);
    }

    public static final void access$LayoutWithLinksAndInlineContent-vOo2fZY(Modifier modifier, AnnotatedString text, Function1 onTextLayout, boolean hasInlineContent, Map inlineContent, TextStyle style, int overflow, boolean softWrap, int maxLines, int minLines, FontFamily.Resolver fontFamilyResolver, SelectionController selectionController, ColorProducer color, Function1 onShowTranslation, Composer $composer, int $changed, int $changed1, int $default) {
        BasicTextKt.LayoutWithLinksAndInlineContent-vOo2fZY(modifier, text, onTextLayout, hasInlineContent, inlineContent, style, overflow, softWrap, maxLines, minLines, fontFamilyResolver, selectionController, color, onShowTranslation, $composer, $changed, $changed1, $default);
    }

    public static final List access$measureWithTextRangeMeasureConstraints(List measurables, Function0 shouldMeasureLinks) {
        return BasicTextKt.measureWithTextRangeMeasureConstraints(measurables, shouldMeasureLinks);
    }

    private static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> measurables, Function0<Boolean> shouldMeasureLinks) {
        androidx.compose.foundation.text.TextRangeLayoutMeasureScope textRangeLayoutMeasureScope2;
        int i;
        Object obj4;
        int i6;
        ArrayList arrayList;
        Object obj5;
        int i7;
        int index$iv$iv;
        int size;
        Object obj2;
        int i5;
        Object obj3;
        int i2;
        Object obj;
        int i4;
        androidx.compose.foundation.text.TextRangeScopeMeasurePolicy measurePolicy;
        androidx.compose.foundation.text.TextRangeLayoutMeasureResult $this$measureWithTextRangeMeasureConstraints_u24lambda_u249_u24lambda_u248;
        androidx.compose.foundation.text.TextRangeLayoutMeasureScope textRangeLayoutMeasureScope;
        Object obj6;
        int i3;
        ArrayList list;
        Object obj7;
        if ((Boolean)shouldMeasureLinks.invoke().booleanValue()) {
            textRangeLayoutMeasureScope2 = new TextRangeLayoutMeasureScope();
            obj4 = measurables;
            i6 = 0;
            arrayList = new ArrayList(obj4.size());
            i7 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj4.size()) {
                i5 = index$iv$iv;
                i2 = 0;
                obj = obj3;
                i4 = 0;
                Object parentData = (Measurable)obj.getParentData();
                Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
                int i9 = 0;
                $this$measureWithTextRangeMeasureConstraints_u24lambda_u249_u24lambda_u248 = (TextRangeLayoutModifier)parentData.getMeasurePolicy().measure(textRangeLayoutMeasureScope2);
                int width = $this$measureWithTextRangeMeasureConstraints_u24lambda_u249_u24lambda_u248.getWidth();
                list = arrayList;
                Pair pair = new Pair(obj.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(width, $this$measureWithTextRangeMeasureConstraints_u24lambda_u249_u24lambda_u248.getWidth(), $this$measureWithTextRangeMeasureConstraints_u24lambda_u249_u24lambda_u248.getHeight(), $this$measureWithTextRangeMeasureConstraints_u24lambda_u249_u24lambda_u248.getHeight())), $this$measureWithTextRangeMeasureConstraints_u24lambda_u249_u24lambda_u248.getPlace());
                int i8 = 0;
                (Collection)list.add(pair);
                index$iv$iv++;
                textRangeLayoutMeasureScope2 = textRangeLayoutMeasureScope;
                obj4 = obj6;
                i6 = i3;
                arrayList = list;
                obj5 = obj7;
            }
            textRangeLayoutMeasureScope = textRangeLayoutMeasureScope2;
            obj6 = obj4;
            i3 = i6;
            obj7 = obj5;
            i = list;
        } else {
            i = 0;
        }
        return i;
    }

    private static final Saver<Long, Long> selectionIdSaver(SelectionRegistrar selectionRegistrar) {
        BasicTextKt.selectionIdSaver.1 anon = new BasicTextKt.selectionIdSaver.1(selectionRegistrar);
        return SaverKt.Saver((Function2)anon, (Function1)BasicTextKt.selectionIdSaver.2.INSTANCE);
    }

    private static final Modifier textModifier-cFh6CEA(Modifier $this$textModifier_u2dcFh6CEA, AnnotatedString text, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> placeholders, Function1<? super List<Rect>, Unit> onPlaceholderLayout, SelectionController selectionController, ColorProducer color, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation) {
        final Object obj = $this$textModifier_u2dcFh6CEA;
        if (selectionController == null) {
            TextAnnotatedStringElement textAnnotatedStringElement = new TextAnnotatedStringElement(text, style, fontFamilyResolver, onTextLayout, overflow, softWrap, maxLines, minLines, placeholders, onPlaceholderLayout, 0, color, onShowTranslation, 0);
            return obj.then((Modifier)Modifier.Companion).then((Modifier)textAnnotatedStringElement);
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = new SelectableTextAnnotatedStringElement(text, style, fontFamilyResolver, onTextLayout, overflow, softWrap, maxLines, minLines, placeholders, onPlaceholderLayout, selectionController, color, 0);
        return obj.then(selectionController.getModifier()).then((Modifier)selectableTextAnnotatedStringElement);
    }
}
