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
        int i20;
        Object obj4;
        int traceInProgress2;
        Object modifier2;
        int $composer2;
        int $dirty2;
        androidx.compose.ui.Modifier.Companion $dirty;
        int i18;
        int emptyMap;
        boolean traceInProgress;
        Object obj;
        Object str;
        Object obj6;
        int i9;
        int i5;
        int i21;
        Object obj2;
        boolean z;
        int i17;
        int i3;
        Object obj3;
        Map map;
        Object obj5;
        int i16;
        Object companion;
        int modifier3;
        int overflow2;
        int i19;
        Object i12;
        boolean softWrap2;
        int i6;
        boolean i13;
        int i14;
        int i15;
        int i8;
        int i10;
        int i4;
        int i;
        int i2;
        int i7;
        androidx.compose.ui.Modifier.Companion companion2;
        final int i48 = $changed;
        final int i49 = i11;
        Composer restartGroup = $composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)303@13046L273:BasicText.kt#423gt5");
        $dirty2 = $changed;
        if (i49 & 1 != 0) {
            $dirty2 |= 6;
            obj5 = text;
        } else {
            if (i48 & 6 == 0) {
                i18 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i18;
            } else {
                obj5 = text;
            }
        }
        emptyMap = i49 & 2;
        if (emptyMap != null) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                str = modifier;
            }
        }
        i5 = i49 & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            obj2 = style;
        } else {
            if (i48 & 384 == 0) {
                i17 = restartGroup.changed(style) ? 256 : 128;
                $dirty2 |= i17;
            } else {
                obj2 = style;
            }
        }
        int i46 = i49 & 8;
        if (i46 != 0) {
            $dirty2 |= 3072;
            obj3 = onTextLayout;
        } else {
            if (i48 & 3072 == 0) {
                i16 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty2 |= i16;
            } else {
                obj3 = onTextLayout;
            }
        }
        int i50 = i49 & 16;
        if (i50 != 0) {
            $dirty2 |= 24576;
            overflow2 = overflow;
        } else {
            if (i48 & 24576 == 0) {
                i19 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty2 |= i19;
            } else {
                overflow2 = overflow;
            }
        }
        i12 = i49 & 32;
        int i52 = 196608;
        if (i12 != 0) {
            $dirty2 |= i52;
            softWrap2 = softWrap;
        } else {
            if (i52 &= i48 == 0) {
                i6 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                softWrap2 = softWrap;
            }
        }
        i13 = i49 & 64;
        i14 = 1572864;
        if (i13 != 0) {
            $dirty2 |= i14;
            i20 = maxLines;
        } else {
            if (i48 & i14 == 0) {
                i15 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty2 |= i15;
            } else {
                i20 = maxLines;
            }
        }
        int i23 = i49 & 128;
        i8 = 12582912;
        if (i23 != 0) {
            $dirty2 |= i8;
            i10 = i23;
            obj4 = inlineContent;
        } else {
            if (i48 & i8 == 0) {
                i10 = i23;
                i4 = restartGroup.changedInstance(inlineContent) ? 8388608 : 4194304;
                $dirty2 |= i4;
            } else {
                i10 = i23;
                obj4 = inlineContent;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty2 & i == 4793490) {
            if (!composer.getSkipping()) {
                if (emptyMap != null) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (i5 != 0) {
                    obj2 = $composer2;
                }
                if (i46 != 0) {
                    obj3 = $composer2;
                }
                if (i50 != 0) {
                    overflow2 = $composer2;
                }
                if (i12 != 0) {
                    softWrap2 = $composer2;
                }
                $composer2 = i13 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                if (i10 != 0) {
                    i10 = emptyMap;
                } else {
                    i10 = inlineContent;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-648605928, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:302)");
                }
                i14 = $composer2;
                i12 = obj3;
                i13 = softWrap2;
                softWrap2 = overflow2;
                overflow2 = obj2;
                BasicTextKt.BasicText-RWo7tUw(obj5, modifier2, overflow2, i12, softWrap2, i13, i14, 1, i10, 0, composer, i31 | i43, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = overflow2;
                obj6 = i12;
                i21 = softWrap2;
                z = i13;
                i3 = i14;
                map = i10;
            } else {
                composer.skipToGroupEnd();
                i3 = maxLines;
                companion = str;
                obj = obj2;
                obj6 = obj3;
                i21 = overflow2;
                z = softWrap2;
                map = inlineContent;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier3 = $dirty2;
            traceInProgress2 = new BasicTextKt.BasicText.5(text, companion, obj, obj6, i21, z, i3, map, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier3 = $dirty2;
            $dirty = companion2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public static final void BasicText-4YKlhWE(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Composer $composer, int $changed, int i11) {
        int i10;
        int i23;
        int traceInProgress2;
        Object modifier3;
        int $composer2;
        int $dirty2;
        androidx.compose.ui.Modifier.Companion $dirty;
        int i4;
        int i9;
        boolean traceInProgress;
        Object obj5;
        Object str;
        Object obj;
        int i6;
        int i2;
        int i16;
        Object obj3;
        boolean z;
        int i15;
        int i7;
        Object obj2;
        int i19;
        Object obj4;
        int i22;
        Object companion;
        int modifier2;
        int overflow2;
        int i;
        Object i20;
        boolean softWrap2;
        int i3;
        boolean i21;
        int i14;
        int i8;
        int i12;
        int i13;
        int i18;
        int i5;
        int i17;
        androidx.compose.ui.Modifier.Companion companion2;
        final int i48 = $changed;
        final int i49 = i11;
        Composer restartGroup = $composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)327@13717L86:BasicText.kt#423gt5");
        $dirty2 = $changed;
        if (i49 & 1 != 0) {
            $dirty2 |= 6;
            obj4 = text;
        } else {
            if (i48 & 6 == 0) {
                i4 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i4;
            } else {
                obj4 = text;
            }
        }
        i9 = i49 & 2;
        if (i9 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                str = modifier;
            }
        }
        i2 = i49 & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            obj3 = style;
        } else {
            if (i48 & 384 == 0) {
                i15 = restartGroup.changed(style) ? 256 : 128;
                $dirty2 |= i15;
            } else {
                obj3 = style;
            }
        }
        int i46 = i49 & 8;
        if (i46 != 0) {
            $dirty2 |= 3072;
            obj2 = onTextLayout;
        } else {
            if (i48 & 3072 == 0) {
                i22 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty2 |= i22;
            } else {
                obj2 = onTextLayout;
            }
        }
        int i50 = i49 & 16;
        if (i50 != 0) {
            $dirty2 |= 24576;
            overflow2 = overflow;
        } else {
            if (i48 & 24576 == 0) {
                i = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty2 |= i;
            } else {
                overflow2 = overflow;
            }
        }
        i20 = i49 & 32;
        int i52 = 196608;
        if (i20 != 0) {
            $dirty2 |= i52;
            softWrap2 = softWrap;
        } else {
            if (i52 &= i48 == 0) {
                i3 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty2 |= i3;
            } else {
                softWrap2 = softWrap;
            }
        }
        i21 = i49 & 64;
        i14 = 1572864;
        if (i21 != 0) {
            $dirty2 |= i14;
            i10 = maxLines;
        } else {
            if (i48 & i14 == 0) {
                i8 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty2 |= i8;
            } else {
                i10 = maxLines;
            }
        }
        int i25 = i49 & 128;
        int i54 = 12582912;
        if (i25 != 0) {
            $dirty2 |= i54;
            i12 = i25;
            i23 = minLines;
        } else {
            if (i48 & i54 == 0) {
                i12 = i25;
                i13 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty2 |= i13;
            } else {
                i12 = i25;
                i23 = minLines;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty2 & i18 == 4793490) {
            if (!composer.getSkipping()) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = str;
                }
                if (i2 != 0) {
                    obj3 = $composer2;
                }
                if (i46 != 0) {
                    obj2 = $composer2;
                }
                if (i50 != 0) {
                    overflow2 = $composer2;
                }
                if (i20 != 0) {
                    softWrap2 = $composer2;
                }
                $composer2 = i21 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                i12 = i12 != 0 ? i9 : minLines;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1542716361, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                i14 = $composer2;
                i20 = obj2;
                i21 = softWrap2;
                softWrap2 = overflow2;
                overflow2 = obj3;
                BasicTextKt.BasicText-VhcvRP8(obj4, modifier3, overflow2, i20, softWrap2, i21, i14, i12, 0, composer, i32 | i44, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = overflow2;
                obj = i20;
                i16 = softWrap2;
                z = i21;
                i7 = i14;
                i19 = i12;
            } else {
                composer.skipToGroupEnd();
                i7 = maxLines;
                companion = str;
                obj5 = obj3;
                obj = obj2;
                i16 = overflow2;
                z = softWrap2;
                i19 = minLines;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = $dirty2;
            traceInProgress2 = new BasicTextKt.BasicText.6(text, companion, obj5, obj, i16, z, i7, i19, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier2 = $dirty2;
            $dirty = companion2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicText-BpD7jsM(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Composer $composer, int $changed, int i10) {
        int i7;
        boolean traceInProgress;
        Object modifier3;
        int $composer2;
        boolean traceInProgress2;
        int $dirty;
        Object $dirty2;
        int i9;
        Object obj;
        int str;
        Object obj4;
        Object obj5;
        int i4;
        int i11;
        Object obj2;
        boolean z;
        int i2;
        int i5;
        Object obj3;
        Object obj6;
        Object onTextLayout2;
        int modifier2;
        int i;
        Object i18;
        int overflow2;
        int i14;
        int i15;
        boolean z2;
        int i3;
        int i12;
        int i13;
        int i16;
        int i17;
        int i6;
        int i8;
        Object obj7;
        final int i40 = $changed;
        Composer restartGroup = $composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)279@12355L234:BasicText.kt#423gt5");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            obj3 = text;
        } else {
            if (i40 & 6 == 0) {
                i9 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i9;
            } else {
                obj3 = text;
            }
        }
        str = i10 & 2;
        if (str != null) {
            $dirty |= 48;
            obj4 = modifier;
        } else {
            if (i40 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i4;
            } else {
                obj4 = modifier;
            }
        }
        int i37 = i10 & 4;
        if (i37 != 0) {
            $dirty |= 384;
            obj2 = style;
        } else {
            if (i40 & 384 == 0) {
                i2 = restartGroup.changed(style) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj2 = style;
            }
        }
        int i39 = i10 & 8;
        if (i39 != 0) {
            $dirty |= 3072;
            obj6 = onTextLayout;
        } else {
            if (i40 & 3072 == 0) {
                i = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty |= i;
            } else {
                obj6 = onTextLayout;
            }
        }
        i18 = i10 & 16;
        if (i18 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else {
            if (i40 & 24576 == 0) {
                i14 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty |= i14;
            } else {
                overflow2 = overflow;
            }
        }
        i15 = i10 & 32;
        int i43 = 196608;
        if (i15 != 0) {
            $dirty |= i43;
            z2 = softWrap;
        } else {
            if (i43 &= i40 == 0) {
                i3 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty |= i3;
            } else {
                z2 = softWrap;
            }
        }
        i12 = i10 & 64;
        i13 = 1572864;
        if (i12 != 0) {
            $dirty |= i13;
            i7 = maxLines;
        } else {
            if (i40 & i13 == 0) {
                i16 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= i16;
            } else {
                i7 = maxLines;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty & i17 == 599186) {
            if (!composer.getSkipping()) {
                if (str != null) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = obj4;
                }
                if (i37 != 0) {
                    obj2 = $composer2;
                }
                if (i39 != 0) {
                    obj6 = $composer2;
                }
                if (i18 != 0) {
                    overflow2 = $composer2;
                }
                if (i15 != 0) {
                    z2 = $composer2;
                }
                i12 = i12 != 0 ? $composer2 : maxLines;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1022429478, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:278)");
                }
                i18 = obj2;
                i15 = overflow2;
                overflow2 = obj6;
                BasicTextKt.BasicText-VhcvRP8(obj3, modifier3, i18, overflow2, i15, z2, i12, 1, 0, composer, $composer2 | i35, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = i18;
                obj5 = overflow2;
                i11 = i15;
                i5 = i12;
                z = z2;
            } else {
                composer.skipToGroupEnd();
                onTextLayout2 = obj4;
                obj5 = obj10;
                i5 = maxLines;
                obj = obj2;
                i11 = overflow2;
                z = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = $dirty;
            traceInProgress = new BasicTextKt.BasicText.4(text, onTextLayout2, obj, obj5, i11, z, i5, i40, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            modifier2 = $dirty;
            $dirty2 = obj7;
        }
    }

    public static final void BasicText-RWo7tUw(AnnotatedString text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, androidx.compose.foundation.text.InlineTextContent> inlineContent, ColorProducer color, Composer $composer, int $changed, int i13) {
        int i6;
        Object obj2;
        Object obj5;
        int traceInProgress2;
        boolean traceInProgress;
        int selectionRegistrar2;
        Object invalid$iv;
        int i26;
        int str2;
        int i3;
        AnnotatedString str;
        Object it$iv;
        int empty;
        Composer restartGroup;
        int i37;
        Object style2;
        Composer composer3;
        Object $composer2;
        int $dirty;
        Object obj4;
        int $i$f$cache;
        Function0 factory$iv$iv;
        Object onTextLayout2;
        int i18;
        int i40;
        int i2;
        Object overflow2;
        int i21;
        boolean maxLines3;
        int softWrap2;
        boolean maxLines2;
        int softWrap3;
        Object obj;
        int i11;
        int minLines2;
        int i45;
        int i24;
        Object rememberedValue;
        int i39;
        Object obj3;
        int i19;
        Map map;
        int i8;
        int backgroundSelectionColor;
        int currentCompositeKeyHash;
        int i38;
        Object i29;
        int i44;
        int i42;
        int materializeModifier;
        Composer i33;
        int i15;
        Object i20;
        int i35;
        int i16;
        int i46;
        int inlineContent2;
        int i22;
        int i27;
        int i7;
        int i43;
        int i9;
        int onTextLayout3;
        int i28;
        Object softWrap4;
        Composer composer;
        int i36;
        int companion;
        SelectionController selectionController;
        int i14;
        int i41;
        int $composer3;
        Composer composer2;
        int i;
        int i4;
        int i5;
        int i23;
        int i34;
        int i10;
        int i30;
        int i31;
        int i17;
        int i32;
        int i25;
        int i12;
        int $dirty2;
        Object selectionRegistrar;
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
        i33 = $changed;
        final int i108 = i13;
        restartGroup = $composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)196@9257L7:BasicText.kt#423gt5");
        $dirty = $changed;
        if (i108 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i33 & 6 == 0) {
                i18 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i18;
            }
        }
        int i85 = i108 & 2;
        if (i85 != 0) {
            $dirty |= 48;
            obj = modifier;
        } else {
            if (i33 & 48 == 0) {
                i45 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i45;
            } else {
                obj = modifier;
            }
        }
        i24 = i108 & 4;
        if (i24 != 0) {
            $dirty |= 384;
            obj3 = style;
        } else {
            if (i33 & 384 == 0) {
                i8 = restartGroup.changed(style) ? 256 : 128;
                $dirty |= i8;
            } else {
                obj3 = style;
            }
        }
        int i100 = i108 & 8;
        if (i100 != 0) {
            $dirty |= 3072;
            i29 = onTextLayout;
        } else {
            if (i33 & 3072 == 0) {
                i44 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty |= i44;
            } else {
                i29 = onTextLayout;
            }
        }
        i42 = i108 & 16;
        if (i42 != 0) {
            $dirty |= 24576;
            materializeModifier = overflow;
        } else {
            if (i33 & 24576 == 0) {
                i15 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty |= i15;
            } else {
                materializeModifier = overflow;
            }
        }
        i20 = i108 & 32;
        i35 = 196608;
        if (i20 != 0) {
            $dirty |= i35;
            maxLines2 = softWrap;
        } else {
            if (i33 & i35 == 0) {
                i35 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty |= i35;
            } else {
                maxLines2 = softWrap;
            }
        }
        i16 = i108 & 64;
        i46 = 1572864;
        if (i16 != 0) {
            $dirty |= i46;
            i21 = maxLines;
        } else {
            if (i33 & i46 == 0) {
                inlineContent2 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= inlineContent2;
            } else {
                i21 = maxLines;
            }
        }
        int i48 = i108 & 128;
        int i110 = 12582912;
        if (i48 != 0) {
            $dirty |= i110;
            i27 = i48;
            i6 = minLines;
        } else {
            if (i33 & i110 == 0) {
                i27 = i48;
                i7 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty |= i7;
            } else {
                i27 = i48;
                i6 = minLines;
            }
        }
        int i49 = i108 & 256;
        int i112 = 100663296;
        if (i49 != 0) {
            $dirty |= i112;
            i43 = i49;
            obj2 = inlineContent;
        } else {
            if (i33 & i112 == 0) {
                i43 = i49;
                i9 = restartGroup.changedInstance(inlineContent) ? 67108864 : 33554432;
                $dirty |= i9;
            } else {
                i43 = i49;
                obj2 = inlineContent;
            }
        }
        int i50 = i108 & 512;
        int i115 = 805306368;
        if (i50 != 0) {
            $dirty |= i115;
            onTextLayout3 = i50;
            obj5 = color;
        } else {
            if (i33 & i115 == 0) {
                onTextLayout3 = i50;
                i28 = restartGroup.changedInstance(color) ? 536870912 : 268435456;
                $dirty |= i28;
            } else {
                onTextLayout3 = i50;
                obj5 = color;
            }
        }
        if ($dirty & softWrap4 == 306783378) {
            if (!restartGroup.getSkipping()) {
                if (i85 != 0) {
                    softWrap4 = traceInProgress2;
                } else {
                    softWrap4 = obj;
                }
                if (i24 != 0) {
                    obj3 = traceInProgress2;
                }
                if (i100 != 0) {
                    i29 = traceInProgress2;
                }
                if (i42 != 0) {
                    i40 = traceInProgress2;
                } else {
                    i40 = materializeModifier;
                }
                if (i20 != 0) {
                    maxLines2 = traceInProgress2;
                }
                if (i16 != 0) {
                    i21 = traceInProgress2;
                }
                i11 = i27 != 0 ? traceInProgress2 : minLines;
                if (i43 != 0) {
                    i27 = traceInProgress2;
                } else {
                    i27 = inlineContent;
                }
                i42 = onTextLayout3 != 0 ? traceInProgress2 : color;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1064305212, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:191)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(i11, i21);
                i3 = 6;
                int i96 = 0;
                backgroundSelectionColor = 2023513938;
                String str8 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundSelectionColor, str8);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume3;
                String str7 = "CC(remember):BasicText.kt#9igjgp";
                if ((SelectionRegistrar)this_$iv != null) {
                    restartGroup.startReplaceGroup(-1584983428);
                    ComposerKt.sourceInformation(restartGroup, "198@9393L7,200@9539L69,200@9456L152,203@9617L234");
                    i16 = 6;
                    int i109 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundSelectionColor, str8);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    long backgroundColor-0d7_KjU = (TextSelectionColors)restartGroup.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU();
                    onTextLayout3 = obj7;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -328216839, str7);
                    obj52 = restartGroup;
                    int i118 = 0;
                    it$iv = obj52.rememberedValue();
                    int i121 = 0;
                    if (!restartGroup.changedInstance(this_$iv)) {
                        $composer3 = restartGroup;
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
                        $composer3 = restartGroup;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    obj57 = i68;
                    obj54 = i122;
                    obj56 = $composer3;
                    restartGroup = obj56;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -328214178, str7);
                    empty = $dirty;
                    i22 = i40;
                    long $dirty4 = obj53;
                    composer = restartGroup;
                    i36 = 0;
                    obj55 = this_$iv;
                    Object rememberedValue3 = composer.rememberedValue();
                    companion = 0;
                    if (i113 |= changed11 == 0) {
                        $dirty2 = empty;
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int $dirty3 = 0;
                            obj53 = $dirty4;
                            obj56 = backgroundColor-0d7_KjU;
                            obj52 = selectionController;
                            super(obj53, obj54, obj55, obj56, obj57, 0, 8, 0);
                            backgroundSelectionColor = obj53;
                            selectionRegistrar = obj55;
                            $dirty = obj56;
                            obj52 = rememberedValue3;
                            composer.updateRememberedValue(obj52);
                        } else {
                            backgroundSelectionColor = $dirty4;
                            $dirty = l;
                            selectionRegistrar = obj55;
                            i3 = obj52;
                            selectionRegistrar2 = composer;
                        }
                    } else {
                        $dirty2 = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                    i29 = i3;
                } else {
                    selectionRegistrar = this_$iv;
                    $dirty2 = $dirty;
                    i22 = i40;
                    onTextLayout3 = i29;
                    restartGroup.startReplaceGroup(-1584467526);
                    restartGroup.endReplaceGroup();
                    i29 = 0;
                }
                int i86 = i22;
                inlineContent2 = AnnotatedStringResolveInlineContentKt.hasInlineContent(text);
                if (!inlineContent2 && !TextAnnotatedStringNodeKt.hasLinks(text)) {
                    if (!TextAnnotatedStringNodeKt.hasLinks(text)) {
                        restartGroup.startReplaceGroup(-1584294453);
                        ComposerKt.sourceInformation(restartGroup, "229@10603L7,217@10089L814");
                        int i84 = 0;
                        int i97 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str8);
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        i33 = restartGroup;
                        Modifier textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(softWrap4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj35, false, 0, 0, 0, obj40, 0, obj42), text, obj3, onTextLayout3, i86, maxLines2, i21, i11, (FontFamily.Resolver)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), 0, 0, i29, i42, 0);
                        style2 = EmptyMeasurePolicy.INSTANCE;
                        rememberedValue = 48;
                        i19 = 0;
                        ComposerKt.sourceInformationMarkerStart(i33, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(i33, 0);
                        obj52 = textModifier-cFh6CEA;
                        invalid$iv = i33.getCurrentCompositionLocalMap();
                        obj53 = constructor;
                        i20 = 6;
                        i16 = 0;
                        ComposerKt.sourceInformationMarkerStart(i33, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i33.startReusableNode();
                        if (i33.getInserting()) {
                            i33.createNode(obj53);
                        } else {
                            factory$iv$iv = obj53;
                            i33.useNode();
                        }
                        Composer constructor-impl = Updater.constructor-impl(i33);
                        i46 = 0;
                        i36 = factory$iv$iv;
                        Updater.set-impl(constructor-impl, (MeasurePolicy)style2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl, invalid$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(i33, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
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
                                i37 = obj53;
                            }
                        } else {
                            obj55 = invalid$iv;
                            obj56 = style2;
                        }
                        i33.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i33);
                        ComposerKt.sourceInformationMarkerEnd(i33);
                        i33.endReplaceGroup();
                        i2 = obj54;
                        composer2 = i33;
                        obj4 = onTextLayout3;
                    } else {
                        i33 = restartGroup;
                        i33.startReplaceGroup(-1583391888);
                        ComposerKt.sourceInformation(i33, "241@11076L39,254@11574L7,257@11697L256,243@11125L838");
                        ComposerKt.sourceInformationMarkerStart(i33, -328167685, str7);
                        i26 = $dirty2 & 14 == 4 ? 1 : 0;
                        Composer composer4 = i33;
                        $i$f$cache = 0;
                        Object rememberedValue4 = composer4.rememberedValue();
                        int i98 = 0;
                        if (i26 == 0) {
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                backgroundSelectionColor = 0;
                                obj52 = i26;
                                obj53 = $i$f$cache;
                                int invalid$iv2 = 0;
                                composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(text, invalid$iv2, 2, invalid$iv2));
                            } else {
                                obj52 = i26;
                                obj53 = $i$f$cache;
                                invalid$iv = rememberedValue4;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(i33);
                        int i69 = 0;
                        int i87 = 0;
                        ComposerKt.sourceInformationMarkerStart(i33, 2023513938, str8);
                        ComposerKt.sourceInformationMarkerEnd(i33);
                        ComposerKt.sourceInformationMarkerStart(i33, -328147596, str7);
                        Composer composer5 = i33;
                        int i88 = 0;
                        rememberedValue = composer5.rememberedValue();
                        i19 = 0;
                        if (!i33.changed(invalid$iv)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                currentCompositeKeyHash = 0;
                                materializeModifier = new BasicTextKt.BasicText.2.1(invalid$iv);
                                composer5.updateRememberedValue((Function1)materializeModifier);
                            } else {
                                materializeModifier = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(i33);
                        composer2 = i33;
                        i46 = onTextLayout3;
                        i20 = softWrap4;
                        onTextLayout3 = obj54;
                        BasicTextKt.LayoutWithLinksAndInlineContent-vOo2fZY(i20, BasicTextKt.BasicText_RWo7tUw$lambda$5((MutableState)invalid$iv), i46, inlineContent2, i27, obj3, onTextLayout3, maxLines2, i21, i11, (FontFamily.Resolver)i33.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), i29, i42, (Function1)materializeModifier, composer2, i66 | i83, i67 &= 896, 0);
                        obj4 = i46;
                        i2 = onTextLayout3;
                        softWrap4 = i20;
                        composer2.endReplaceGroup();
                    }
                } else {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i39 = i11;
                i38 = i42;
                map = i27;
                $composer2 = softWrap4;
                minLines2 = softWrap3;
                maxLines2 = maxLines3;
                softWrap2 = i2;
                overflow2 = obj4;
                onTextLayout2 = i43;
            } else {
                restartGroup.skipToGroupEnd();
                str = text;
                i39 = minLines;
                i38 = color;
                composer2 = restartGroup;
                $dirty2 = $dirty;
                $composer2 = obj;
                onTextLayout2 = obj3;
                overflow2 = i29;
                map = inlineContent;
                minLines2 = i21;
                softWrap2 = materializeModifier;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new BasicTextKt.BasicText.3(str, $composer2, onTextLayout2, overflow2, softWrap2, maxLines2, minLines2, i39, map, i38, $changed, i108);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public static final void BasicText-VhcvRP8(AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map inlineContent, Composer $composer, int $changed, int i12) {
        int i19;
        int i24;
        Object obj4;
        boolean traceInProgress2;
        int maxLines2;
        int $composer2;
        int $dirty;
        Object $dirty3;
        int i11;
        Object obj3;
        int emptyMap;
        boolean traceInProgress;
        Object obj6;
        Object modifier2;
        int i22;
        int i8;
        int str;
        Object obj;
        boolean z;
        int i5;
        int i13;
        int i20;
        Object obj2;
        int onTextLayout2;
        int i3;
        Object obj5;
        Object obj7;
        int overflow2;
        int $dirty2;
        int i7;
        int i25;
        boolean softWrap2;
        int i14;
        int i10;
        int i21;
        int i2;
        int i9;
        int i23;
        int i15;
        int i16;
        int i6;
        int i;
        int i4;
        int i17;
        int i18;
        final int i54 = $changed;
        final int i55 = i12;
        Composer restartGroup = $composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)341@14269L240:BasicText.kt#423gt5");
        $dirty = $changed;
        if (i55 & 1 != 0) {
            $dirty |= 6;
            obj7 = text;
        } else {
            if (i54 & 6 == 0) {
                i11 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i11;
            } else {
                obj7 = text;
            }
        }
        emptyMap = i55 & 2;
        if (emptyMap != null) {
            $dirty |= 48;
            obj6 = modifier;
        } else {
            if (i54 & 48 == 0) {
                i22 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i22;
            } else {
                obj6 = modifier;
            }
        }
        str = i55 & 4;
        if (str != null) {
            $dirty |= 384;
            obj = style;
        } else {
            if (i54 & 384 == 0) {
                i5 = restartGroup.changed(style) ? 256 : 128;
                $dirty |= i5;
            } else {
                obj = style;
            }
        }
        i20 = i55 & 8;
        if (i20 != 0) {
            $dirty |= 3072;
            obj2 = onTextLayout;
        } else {
            if (i54 & 3072 == 0) {
                i3 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                obj2 = onTextLayout;
            }
        }
        int i53 = i55 & 16;
        if (i53 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else {
            if (i54 & 24576 == 0) {
                i7 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty |= i7;
            } else {
                overflow2 = overflow;
            }
        }
        i25 = i55 & 32;
        int i57 = 196608;
        if (i25 != 0) {
            $dirty |= i57;
            softWrap2 = softWrap;
        } else {
            if (i57 &= i54 == 0) {
                i14 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty |= i14;
            } else {
                softWrap2 = softWrap;
            }
        }
        i10 = i55 & 64;
        i21 = 1572864;
        if (i10 != 0) {
            $dirty |= i21;
            i19 = maxLines;
        } else {
            if (i54 & i21 == 0) {
                i2 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= i2;
            } else {
                i19 = maxLines;
            }
        }
        int i27 = i55 & 128;
        int i59 = 12582912;
        if (i27 != 0) {
            $dirty |= i59;
            i9 = i27;
            i24 = minLines;
        } else {
            if (i54 & i59 == 0) {
                i9 = i27;
                i23 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty |= i23;
            } else {
                i9 = i27;
                i24 = minLines;
            }
        }
        int i28 = i55 & 256;
        int i61 = 100663296;
        if (i28 != 0) {
            $dirty |= i61;
            i15 = i28;
            obj4 = inlineContent;
        } else {
            if (i54 & i61 == 0) {
                i15 = i28;
                i6 = restartGroup.changedInstance(inlineContent) ? 67108864 : 33554432;
                $dirty |= i6;
            } else {
                i15 = i28;
                obj4 = inlineContent;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty & i == 38347922) {
            if (!composer.getSkipping()) {
                if (emptyMap != null) {
                    obj6 = traceInProgress2;
                }
                if (str != null) {
                    obj = traceInProgress2;
                }
                if (i20 != 0) {
                    obj2 = traceInProgress2;
                }
                if (i53 != 0) {
                    overflow2 = traceInProgress2;
                }
                if (i25 != 0) {
                    softWrap2 = traceInProgress2;
                }
                maxLines2 = i10 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                $composer2 = i9 != 0 ? 1 : minLines;
                if (i15 != 0) {
                    i = emptyMap;
                } else {
                    i = inlineContent;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(851408699, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:341)");
                }
                i9 = maxLines2;
                i25 = obj;
                i10 = overflow2;
                i21 = softWrap2;
                overflow2 = obj6;
                softWrap2 = obj2;
                BasicTextKt.BasicText-RWo7tUw(obj7, overflow2, i25, softWrap2, i10, i21, i9, $composer2, i, 0, composer, i36 | i50, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = overflow2;
                obj3 = i25;
                obj2 = softWrap2;
                i8 = i10;
                z = i21;
                i13 = i9;
                obj5 = i;
            } else {
                composer.skipToGroupEnd();
                i13 = maxLines;
                i16 = minLines;
                obj5 = inlineContent;
                obj3 = obj;
                i8 = overflow2;
                z = softWrap2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            traceInProgress2 = new BasicTextKt.BasicText.7(text, obj6, obj3, obj2, i8, z, i13, i16, obj5, i54, i55);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty2 = $dirty;
            $dirty3 = obj6;
            modifier2 = obj2;
            onTextLayout2 = i16;
        }
    }

    public static final void BasicText-VhcvRP8(String text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, ColorProducer color, Composer $composer, int $changed, int i12) {
        int i16;
        int i39;
        Object obj;
        boolean traceInProgress;
        int maxLines2;
        Modifier textModifier-cFh6CEA;
        Composer restartGroup;
        int $composer2;
        androidx.compose.runtime.ProvidableCompositionLocal selectionController;
        Object it$iv;
        int $dirty3;
        Object $dirty2;
        Object $dirty4;
        int empty;
        int i27;
        Object obj7;
        int minLines3;
        Composer minLines4;
        Composer composer2;
        Composer composer;
        Object obj2;
        Object color2;
        int color3;
        int i36;
        int i22;
        boolean traceInProgress2;
        int selectionRegistrar;
        int graphicsLayer-Ap8cVGQ$default2;
        Object obj8;
        boolean z2;
        int i8;
        int softWrap2;
        int str;
        boolean z3;
        Object obj3;
        int i9;
        int i40;
        int i28;
        int i11;
        int i19;
        int localFontFamilyResolver;
        int currentCompositionLocalMap;
        int overflow2;
        Object constructor;
        Composer $composer3;
        int i20;
        int i25;
        int backgroundColor-0d7_KjU;
        boolean $i$f$getCurrent;
        int i14;
        int i5;
        Object consume;
        int i37;
        int i2;
        int i21;
        int i34;
        int i3;
        int i;
        int i29;
        int i35;
        Object obj5;
        boolean selectionController2;
        Modifier graphicsLayer-Ap8cVGQ$default;
        AnnotatedString annotatedString;
        Object obj6;
        Object companion;
        int i30;
        int i18;
        boolean z;
        int i26;
        int i15;
        Object obj4;
        int i17;
        int i4;
        int i10;
        int i38;
        int i31;
        int i23;
        int i13;
        int i24;
        int i32;
        int i33;
        int i6;
        int i7;
        int $dirty;
        int minLines2;
        Object obj46;
        int obj47;
        Object obj48;
        Object obj49;
        androidx.compose.foundation.text.EmptyMeasurePolicy obj50;
        int obj51;
        int obj52;
        int obj53;
        Composer obj54;
        final int i69 = $changed;
        final int i70 = i12;
        restartGroup = $composer.startRestartGroup(-1186827822);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)101@5004L7,151@6858L41:BasicText.kt#423gt5");
        $dirty3 = $changed;
        if (i70 & 1 != 0) {
            $dirty3 |= 6;
            constructor = text;
        } else {
            if (i69 & 6 == 0) {
                i27 = restartGroup.changed(text) ? 4 : 2;
                $dirty3 |= i27;
            } else {
                constructor = text;
            }
        }
        int i49 = i70 & 2;
        if (i49 != 0) {
            $dirty3 |= 48;
            obj2 = modifier;
        } else {
            if (i69 & 48 == 0) {
                i36 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i36;
            } else {
                obj2 = modifier;
            }
        }
        int i53 = i70 & 4;
        if (i53 != 0) {
            $dirty3 |= 384;
            obj8 = style;
        } else {
            if (i69 & 384 == 0) {
                i8 = restartGroup.changed(style) ? 256 : 128;
                $dirty3 |= i8;
            } else {
                obj8 = style;
            }
        }
        str = i70 & 8;
        if (str != null) {
            $dirty3 |= 3072;
            obj3 = onTextLayout;
        } else {
            if (i69 & 3072 == 0) {
                i40 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty3 |= i40;
            } else {
                obj3 = onTextLayout;
            }
        }
        i11 = i70 & 16;
        if (i11 != 0) {
            $dirty3 |= 24576;
            currentCompositionLocalMap = overflow;
        } else {
            if (i69 & 24576 == 0) {
                i20 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty3 |= i20;
            } else {
                currentCompositionLocalMap = overflow;
            }
        }
        i25 = i70 & 32;
        int i73 = 196608;
        if (i25 != 0) {
            $dirty3 |= i73;
            $i$f$getCurrent = softWrap;
        } else {
            if (i73 &= i69 == 0) {
                i14 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty3 |= i14;
            } else {
                $i$f$getCurrent = softWrap;
            }
        }
        i5 = i70 & 64;
        i2 = 1572864;
        if (i5 != 0) {
            $dirty3 |= i2;
            i16 = maxLines;
        } else {
            if (i69 & i2 == 0) {
                i21 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty3 |= i21;
            } else {
                i16 = maxLines;
            }
        }
        int i42 = i70 & 128;
        int i77 = 12582912;
        if (i42 != 0) {
            $dirty3 |= i77;
            i34 = i42;
            i39 = minLines;
        } else {
            if (i69 & i77 == 0) {
                i34 = i42;
                i3 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty3 |= i3;
            } else {
                i34 = i42;
                i39 = minLines;
            }
        }
        int i43 = i70 & 256;
        int i79 = 100663296;
        if (i43 != 0) {
            $dirty3 |= i79;
            i = i43;
            obj = color;
        } else {
            if (i69 & i79 == 0) {
                i = i43;
                i29 = restartGroup.changedInstance(color) ? 67108864 : 33554432;
                $dirty3 |= i29;
            } else {
                i = i43;
                obj = color;
            }
        }
        if ($dirty3 & i35 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (i49 != 0) {
                    obj5 = traceInProgress;
                } else {
                    obj5 = obj2;
                }
                if (i53 != 0) {
                    obj8 = traceInProgress;
                }
                if (str != null) {
                    obj3 = traceInProgress;
                }
                if (i11 != 0) {
                    currentCompositionLocalMap = traceInProgress;
                }
                if (i25 != 0) {
                    $i$f$getCurrent = traceInProgress;
                }
                maxLines2 = i5 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                minLines3 = i34 != 0 ? 1 : minLines;
                color3 = i != 0 ? 0 : color;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1186827822, $dirty3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(minLines3, maxLines2);
                int i60 = 6;
                i19 = 0;
                backgroundColor-0d7_KjU = 2023513938;
                i34 = maxLines2;
                String maxLines3 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundColor-0d7_KjU, maxLines3);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume;
                if ((SelectionRegistrar)this_$iv != null) {
                    restartGroup.startReplaceGroup(-1589202404);
                    ComposerKt.sourceInformation(restartGroup, "103@5140L7,105@5286L69,105@5203L152,108@5364L234");
                    int i65 = 6;
                    int i76 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundColor-0d7_KjU, maxLines3);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    z3 = $i$f$getCurrent;
                    backgroundColor-0d7_KjU = (TextSelectionColors)restartGroup.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU();
                    $dirty = $dirty3;
                    String $dirty5 = "CC(remember):BasicText.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -328352935, $dirty5);
                    obj46 = restartGroup;
                    int i84 = 0;
                    obj54 = restartGroup;
                    it$iv = obj46.rememberedValue();
                    int i86 = 0;
                    if (!restartGroup.changedInstance(this_$iv)) {
                        minLines2 = minLines3;
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
                        minLines2 = minLines3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj54);
                    obj50 = obj54;
                    obj51 = i51;
                    obj48 = selectionController2;
                    minLines4 = obj50;
                    obj47 = longValue;
                    ComposerKt.sourceInformationMarkerStart(minLines4, -328350274, $dirty5);
                    consume = minLines4;
                    i2 = 0;
                    Object rememberedValue2 = consume.rememberedValue();
                    empty = 0;
                    if (i68 |= changed7 == 0) {
                        annotatedString = empty;
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            int i48 = 0;
                            obj49 = this_$iv;
                            obj46 = selectionController2;
                            super(obj47, obj48, obj49, backgroundColor-0d7_KjU, obj51, 0, 8, 0);
                            companion = obj47;
                            $dirty4 = obj49;
                            obj46 = rememberedValue2;
                            consume.updateRememberedValue(obj46);
                        } else {
                            companion = obj47;
                            $dirty4 = this_$iv;
                            selectionRegistrar = obj46;
                            $composer2 = consume;
                        }
                    } else {
                        annotatedString = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(minLines4);
                    minLines4.endReplaceGroup();
                    i38 = selectionRegistrar;
                } else {
                    $dirty = $dirty3;
                    minLines2 = minLines3;
                    $dirty4 = this_$iv;
                    z3 = $i$f$getCurrent;
                    minLines4 = restartGroup;
                    minLines4.startReplaceGroup(-1588686502);
                    minLines4.endReplaceGroup();
                    i38 = selectionRegistrar;
                }
                int i44 = i38;
                if (i44 == 0) {
                    if (obj3 != null) {
                        obj52 = i44;
                        i25 = obj8;
                        i37 = currentCompositionLocalMap;
                        obj6 = obj5;
                        minLines4.startReplaceGroup(-1588564052);
                        ComposerKt.sourceInformation(minLines4, "130@6178L7");
                        super(text, 0, 0, 6, 0);
                        graphicsLayer-Ap8cVGQ$default2 = 0;
                        obj8 = 0;
                        ComposerKt.sourceInformationMarkerStart(minLines4, 2023513938, maxLines3);
                        ComposerKt.sourceInformationMarkerEnd(minLines4);
                        textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i38, false, 0, 0, 0, obj37, 0, obj39), annotatedString, i25, obj3, i37, z3, i34, minLines2, (FontFamily.Resolver)minLines4.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), 0, 0, obj52, color3, 0);
                        minLines4.endReplaceGroup();
                    } else {
                        minLines4.startReplaceGroup(-1587866335);
                        ComposerKt.sourceInformation(minLines4, "143@6671L7");
                        int i72 = 0;
                        int i74 = 0;
                        ComposerKt.sourceInformationMarkerStart(minLines4, 2023513938, maxLines3);
                        ComposerKt.sourceInformationMarkerEnd(minLines4);
                        overflow2 = new TextStringSimpleElement(constructor, obj8, (FontFamily.Resolver)minLines4.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), currentCompositionLocalMap, z3, i34, minLines2, color3, 0);
                        textModifier-cFh6CEA = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i38, false, 0, 0, 0, obj37, 0, obj39).then((Modifier)overflow2);
                        minLines4.endReplaceGroup();
                        i10 = obj52;
                        i30 = obj3;
                        i35 = annotatedString;
                    }
                } else {
                    obj52 = i44;
                    i25 = obj8;
                    i37 = currentCompositionLocalMap;
                    obj6 = obj5;
                }
                restartGroup = EmptyMeasurePolicy.INSTANCE;
                int i54 = 48;
                int i57 = 0;
                ComposerKt.sourceInformationMarkerStart(minLines4, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(minLines4, 0);
                $i$f$getCurrent = 6;
                i5 = 0;
                obj46 = textModifier-cFh6CEA;
                obj49 = $dirty4;
                ComposerKt.sourceInformationMarkerStart(minLines4, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                minLines4.startReusableNode();
                if (minLines4.getInserting()) {
                    minLines4.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    minLines4.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(minLines4);
                obj47 = i47;
                Updater.set-impl(constructor-impl, (MeasurePolicy)restartGroup, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, minLines4.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(minLines4, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
                i2 = 0;
                obj48 = constructor-impl;
                i = 0;
                if (!obj48.getInserting()) {
                    obj50 = restartGroup;
                    obj54 = minLines4;
                    if (!Intrinsics.areEqual(obj48.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj48.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = obj48;
                    }
                } else {
                    obj50 = restartGroup;
                    obj54 = minLines4;
                }
                obj54.endNode();
                ComposerKt.sourceInformationMarkerEnd(obj54);
                ComposerKt.sourceInformationMarkerEnd(obj54);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i28 = color3;
                z2 = z3;
                obj7 = i25;
                softWrap2 = i34;
                $dirty2 = i35;
                color2 = i30;
                i22 = i18;
                i9 = minLines2;
            } else {
                restartGroup.skipToGroupEnd();
                softWrap2 = maxLines;
                i28 = color;
                obj54 = restartGroup;
                $dirty = $dirty3;
                $dirty2 = obj2;
                obj7 = obj8;
                color2 = obj3;
                i22 = currentCompositionLocalMap;
                z2 = $i$f$getCurrent;
                i9 = minLines;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj54.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = obj54;
            traceInProgress = new BasicTextKt.BasicText.1(text, $dirty2, obj7, color2, i22, z2, softWrap2, i9, i28, i69, i70);
            endRestartGroup.updateScope((Function2)traceInProgress);
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
        Object inlineContent2;
        int $this$cache$iv2;
        Unit iNSTANCE2;
        Unit iNSTANCE;
        Composer it$iv4;
        Object endRestartGroup;
        int it$iv3;
        boolean traceInProgress2;
        int i4;
        Object obj8;
        int i2;
        Object obj2;
        Object obj9;
        Object obj10;
        Object empty3;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1 it$iv5;
        Object it$iv;
        Object it$iv6;
        boolean textModifier-cFh6CEA;
        int i23;
        int i22;
        int empty;
        Pair resolveInlineContent;
        Object inlineComposables2;
        int invalid$iv;
        Object linksTextMeasurePolicy;
        Composer composer;
        int i10;
        Object obj3;
        Object $composer3;
        int $dirty;
        int $dirty1;
        Composer composer2;
        Object obj;
        int i17;
        Object currentCompositionLocalMap;
        Object rememberedValue;
        int currentCompositeKeyHash;
        int i14;
        int i21;
        int i15;
        int i11;
        int i19;
        int materializeModifier;
        int empty4;
        Object constructor;
        Composer $this$cache$iv;
        int empty2;
        Object anon4;
        boolean anon;
        int changedInstance;
        int i24;
        int i;
        int i25;
        int i7;
        Object obj5;
        int companion3;
        int companion;
        int companion2;
        Composer $composer2;
        int it$iv2;
        int i5;
        int i12;
        int i9;
        int i8;
        int modifier$iv;
        int i26;
        int changedInstance2;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.2.1 anon2;
        int i6;
        boolean z;
        int i13;
        int i27;
        FontFamily.Resolver resolver;
        Object obj6;
        Object obj7;
        Object obj4;
        SelectionController selectionController2;
        ColorProducer colorProducer;
        Function1 function1;
        int i3;
        int i28;
        int i16;
        int i20;
        int $dirty12;
        Object inlineContent3;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1 anon3;
        Object inlineComposables;
        ScopeUpdateScope scopeUpdateScope;
        Object obj49;
        int obj59;
        final Object obj12 = text;
        obj8 = onTextLayout;
        final int i96 = $changed;
        int i29 = $changed1;
        int i35 = i18;
        $composer3 = $composer.startRestartGroup(645129368);
        ComposerKt.sourceInformation($composer3, "C(LayoutWithLinksAndInlineContent)P(6,13,8,2,3,12,9:c#ui.text.style.TextOverflow,11,4,5,1,10)578@22283L117,565@21843L1459:BasicText.kt#423gt5");
        $dirty = $changed;
        $dirty1 = $changed1;
        if (i35 & 1 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i96 & 6 == 0) {
                i21 = $composer3.changed(modifier) ? 4 : 2;
                $dirty |= i21;
            } else {
                obj = modifier;
            }
        }
        if (i35 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i96 & 48 == 0) {
                i15 = $composer3.changed(obj12) ? 32 : 16;
                $dirty |= i15;
            }
        }
        if (i35 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i96 & 384 == 0) {
                i11 = $composer3.changedInstance(obj8) ? 256 : changedInstance;
                $dirty |= i11;
            }
        }
        companion = 1024;
        if (i35 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i96 & 3072 == 0) {
                i19 = $composer3.changed(hasInlineContent) ? i25 : companion;
                $dirty |= i19;
            }
        }
        materializeModifier = i35 & 16;
        if (materializeModifier != 0) {
            $dirty |= 24576;
            constructor = inlineContent;
        } else {
            if (i96 & 24576 == 0) {
                i12 = $composer3.changedInstance(inlineContent) ? 16384 : 8192;
                $dirty |= i12;
            } else {
                constructor = inlineContent;
            }
        }
        int i102 = 196608;
        if (i35 & 32 != 0) {
            $dirty |= i102;
            currentCompositionLocalMap = style;
        } else {
            if (i96 & i102 == 0) {
                i9 = $composer3.changed(style) ? 131072 : 65536;
                $dirty |= i9;
            } else {
                currentCompositionLocalMap = style;
            }
        }
        modifier$iv = 1572864;
        if (i35 & 64 != 0) {
            $dirty |= modifier$iv;
            currentCompositeKeyHash = overflow;
        } else {
            if (i96 & modifier$iv == 0) {
                modifier$iv = $composer3.changed(overflow) ? 1048576 : 524288;
                $dirty |= modifier$iv;
            } else {
                currentCompositeKeyHash = overflow;
            }
        }
        if (i35 & 128 != 0) {
            $dirty |= i95;
            anon = softWrap;
        } else {
            if (i93 &= i96 == 0) {
                i26 = $composer3.changed(softWrap) ? 8388608 : 4194304;
                $dirty |= i26;
            } else {
                anon = softWrap;
            }
        }
        if (i35 & 256 != 0) {
            $dirty |= i66;
            empty = maxLines;
        } else {
            if (i73 &= i96 == 0) {
                changedInstance2 = $composer3.changed(maxLines) ? 67108864 : 33554432;
                $dirty |= changedInstance2;
            } else {
                empty = maxLines;
            }
        }
        if (i35 & 512 != 0) {
            $dirty |= i44;
            i2 = minLines;
        } else {
            if (i42 &= i96 == 0) {
                changedInstance2 = $composer3.changed(minLines) ? 536870912 : 268435456;
                $dirty |= changedInstance2;
            } else {
                i2 = minLines;
            }
        }
        if (i35 & 1024 != 0) {
            $dirty1 |= 6;
            obj2 = fontFamilyResolver;
        } else {
            if (i29 & 6 == 0) {
                changedInstance2 = $composer3.changedInstance(fontFamilyResolver) ? 4 : 2;
                $dirty1 |= changedInstance2;
            } else {
                obj2 = fontFamilyResolver;
            }
        }
        if (i35 & 2048 != 0) {
            $dirty1 |= 48;
            obj9 = selectionController;
        } else {
            if (i29 & 48 == 0) {
                it$iv2 = $composer3.changedInstance(selectionController) ? 32 : 16;
                $dirty1 |= it$iv2;
            } else {
                obj9 = selectionController;
            }
        }
        if (i35 & 4096 != 0) {
            $dirty1 |= 384;
            obj10 = color;
        } else {
            if (i29 & 384 == 0) {
                if ($composer3.changedInstance(color)) {
                    changedInstance = 256;
                }
                $dirty1 |= changedInstance;
            } else {
                obj10 = color;
            }
        }
        if (i35 & 8192 != 0) {
            $dirty1 |= 3072;
            empty3 = onShowTranslation;
        } else {
            if (i29 & 3072 == 0) {
                if ($composer3.changedInstance(onShowTranslation)) {
                } else {
                    i25 = companion;
                }
                $dirty1 |= i25;
            } else {
                empty3 = onShowTranslation;
            }
        }
        if ($dirty & i24 == 306783378 && $dirty1 & 1171 == 1170) {
            if ($dirty1 & 1171 == 1170) {
                if (!$composer3.getSkipping()) {
                    if (materializeModifier != 0) {
                        inlineContent2 = MapsKt.emptyMap();
                    } else {
                        inlineContent2 = constructor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(645129368, $dirty, $dirty1, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:536)");
                    }
                    obj49 = 0;
                    empty4 = "CC(remember):BasicText.kt#9igjgp";
                    i20 = 1;
                    if (TextAnnotatedStringNodeKt.hasLinks(obj12)) {
                        $composer3.startReplaceGroup(-619323167);
                        ComposerKt.sourceInformation($composer3, "539@20954L38");
                        ComposerKt.sourceInformationMarkerStart($composer3, -297072527, empty4);
                        i4 = $dirty & 112 == 32 ? i20 : obj49;
                        constructor = $composer3;
                        i24 = 0;
                        it$iv3 = constructor.rememberedValue();
                        companion = 0;
                        if (i4 == 0) {
                            if (it$iv3 == Composer.Companion.getEmpty()) {
                                empty3 = 0;
                                it$iv2 = it$iv3;
                                it$iv3 = new TextLinkScope(obj12);
                                constructor.updateRememberedValue(it$iv3);
                            } else {
                                it$iv2 = it$iv3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-619265198);
                        $composer3.endReplaceGroup();
                        it$iv3 = 0;
                    }
                    if (TextAnnotatedStringNodeKt.hasLinks(obj12)) {
                        $composer3.startReplaceGroup(-619074547);
                        ComposerKt.sourceInformation($composer3, "545@21203L90");
                        ComposerKt.sourceInformationMarkerStart($composer3, -297064507, empty4);
                        i23 = $dirty & 112 == 32 ? i20 : obj49;
                        $this$cache$iv = $composer3;
                        i = 0;
                        it$iv5 = $this$cache$iv.rememberedValue();
                        companion2 = 0;
                        if (i23 |= changed6 == 0) {
                            if (it$iv5 == Composer.Companion.getEmpty()) {
                                empty = 0;
                                it$iv2 = it$iv5;
                                it$iv5 = new BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1(it$iv3, obj12);
                                $this$cache$iv.updateRememberedValue((Function0)it$iv5);
                            } else {
                                it$iv2 = it$iv5;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                        $dirty12 = $dirty1;
                    } else {
                        $composer3.startReplaceGroup(-618966357);
                        ComposerKt.sourceInformation($composer3, "548@21307L8");
                        ComposerKt.sourceInformationMarkerStart($composer3, -297061261, empty4);
                        i22 = $dirty & 112 == 32 ? i20 : obj49;
                        empty = $composer3;
                        $this$cache$iv = 0;
                        it$iv5 = empty.rememberedValue();
                        i7 = 0;
                        if (i22 == 0) {
                            $dirty12 = $dirty1;
                            if (it$iv5 == Composer.Companion.getEmpty()) {
                                $dirty1 = 0;
                                companion2 = it$iv5;
                                it$iv5 = new BasicTextKt.LayoutWithLinksAndInlineContent.styledText.2.1(obj12);
                                empty.updateRememberedValue((Function0)it$iv5);
                            } else {
                                companion2 = it$iv5;
                            }
                        } else {
                            $dirty12 = $dirty1;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    }
                    if (hasInlineContent) {
                        resolveInlineContent = AnnotatedStringResolveInlineContentKt.resolveInlineContent(obj12, inlineContent2);
                    } else {
                        $dirty1 = 0;
                        resolveInlineContent = new Pair($dirty1, $dirty1);
                    }
                    inlineComposables2 = resolveInlineContent.component2();
                    if (hasInlineContent) {
                        $composer3.startReplaceGroup(-618671702);
                        ComposerKt.sourceInformation($composer3, "558@21610L61");
                        ComposerKt.sourceInformationMarkerStart($composer3, -297051512, empty4);
                        $this$cache$iv = 0;
                        i = $composer3;
                        i7 = 0;
                        inlineContent3 = inlineContent2;
                        Object rememberedValue2 = i.rememberedValue();
                        companion2 = 0;
                        anon3 = it$iv5;
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            it$iv2 = rememberedValue2;
                            obj59 = i52;
                            int it$iv7 = 0;
                            i.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(it$iv7, it$iv7, 2, it$iv7));
                        } else {
                            it$iv4 = i;
                            it$iv5 = it$iv2;
                        }
                        $this$cache$iv2 = it$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    } else {
                        inlineContent3 = inlineContent2;
                        anon3 = it$iv5;
                        $composer3.startReplaceGroup(-618591630);
                        $composer3.endReplaceGroup();
                        $this$cache$iv2 = 0;
                    }
                    if (hasInlineContent) {
                        $composer3.startReplaceGroup(-618506565);
                        ComposerKt.sourceInformation($composer3, "562@21777L44");
                        ComposerKt.sourceInformationMarkerStart($composer3, -297046185, empty4);
                        Composer composer5 = $composer3;
                        i = 0;
                        it$iv = composer5.rememberedValue();
                        i7 = 0;
                        if (!$composer3.changed($this$cache$iv2)) {
                            inlineComposables = inlineComposables2;
                            if (it$iv == Composer.Companion.getEmpty()) {
                                inlineComposables2 = 0;
                                companion2 = it$iv;
                                it$iv = new BasicTextKt.LayoutWithLinksAndInlineContent.onPlaceholderLayout.1.1($this$cache$iv2);
                                composer5.updateRememberedValue((Function1)it$iv);
                            } else {
                                companion2 = it$iv;
                            }
                        } else {
                            inlineComposables = inlineComposables2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                        obj7 = $this$cache$iv;
                    } else {
                        inlineComposables = inlineComposables2;
                        $composer3.startReplaceGroup(-618442830);
                        $composer3.endReplaceGroup();
                        obj7 = 0;
                    }
                    ComposerKt.sourceInformationMarkerStart($composer3, -297029920, empty4);
                    if ($dirty & 896 == 256) {
                    } else {
                        i20 = obj49;
                    }
                    changedInstance3 |= i20;
                    Composer composer4 = $composer3;
                    empty2 = 0;
                    it$iv6 = composer4.rememberedValue();
                    int i97 = 0;
                    if (invalid$iv == 0) {
                        obj59 = invalid$iv;
                        if (it$iv6 == Composer.Companion.getEmpty()) {
                            invalid$iv = 0;
                            obj5 = it$iv6;
                            it$iv6 = new BasicTextKt.LayoutWithLinksAndInlineContent.2.1(it$iv3, obj8);
                            composer4.updateRememberedValue((Function1)it$iv6);
                        } else {
                            obj5 = it$iv6;
                        }
                    } else {
                        obj59 = invalid$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj28, false, 0, 0, 0, obj33, 0, obj35), (AnnotatedString)anon3.invoke(), currentCompositionLocalMap, (Function1)it$iv6, currentCompositeKeyHash, anon, maxLines, minLines, fontFamilyResolver, (List)resolveInlineContent.component1(), obj7, selectionController, color, onShowTranslation);
                    if (!hasInlineContent) {
                        $composer3.startReplaceGroup(-617362851);
                        ComposerKt.sourceInformation($composer3, "595@22992L55");
                        ComposerKt.sourceInformationMarkerStart($composer3, -297007294, empty4);
                        composer2 = $composer3;
                        i17 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i14 = 0;
                        if (!$composer3.changedInstance(it$iv3)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty4 = 0;
                                anon4 = new BasicTextKt.LayoutWithLinksAndInlineContent.3.1(it$iv3);
                                composer2.updateRememberedValue((Function0)anon4);
                            } else {
                                anon4 = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        linksTextMeasurePolicy = new LinksTextMeasurePolicy((Function0)anon4);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-617202116);
                        ComposerKt.sourceInformation($composer3, "599@23147L55,600@23233L39");
                        ComposerKt.sourceInformationMarkerStart($composer3, -297002334, empty4);
                        Composer composer3 = $composer3;
                        int i78 = 0;
                        Object rememberedValue4 = composer3.rememberedValue();
                        int i82 = 0;
                        if (!$composer3.changedInstance(it$iv3)) {
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                anon = new BasicTextKt.LayoutWithLinksAndInlineContent.4.1(it$iv3);
                                composer3.updateRememberedValue((Function0)anon);
                            } else {
                                anon = rememberedValue4;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, -296999598, empty4);
                        composer2 = $composer3;
                        i17 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i14 = 0;
                        if (!$composer3.changed($this$cache$iv2)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty4 = 0;
                                anon4 = new BasicTextKt.LayoutWithLinksAndInlineContent.5.1($this$cache$iv2);
                                composer2.updateRememberedValue((Function0)anon4);
                            } else {
                                anon4 = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        linksTextMeasurePolicy = new TextMeasurePolicy((Function0)anon, (Function0)anon4);
                        $composer3.endReplaceGroup();
                    }
                    obj = 0;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, obj49);
                    i24 = 0;
                    obj59 = $this$cache$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(ComposeUiNode.Companion.getConstructor());
                    } else {
                        $composer3.useNode();
                    }
                    Composer constructor-impl = Updater.constructor-impl($composer3);
                    companion = i40;
                    Updater.set-impl(constructor-impl, linksTextMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, $composer3.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i98 = 0;
                    it$iv2 = constructor-impl;
                    i8 = 0;
                    if (!it$iv2.getInserting()) {
                        modifier$iv = textModifier-cFh6CEA;
                        i26 = linksTextMeasurePolicy;
                        if (!Intrinsics.areEqual(it$iv2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            it$iv2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = it$iv2;
                        }
                    } else {
                        modifier$iv = textModifier-cFh6CEA;
                        i26 = linksTextMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($composer3, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
                    obj8 = $composer3;
                    empty3 = 0;
                    i25 = i31;
                    ComposerKt.sourceInformationMarkerStart(obj8, -515487512, "C:BasicText.kt#423gt5");
                    if (it$iv3 == null) {
                        obj8.startReplaceGroup(-515480539);
                        obj8.endReplaceGroup();
                    } else {
                        obj8.startReplaceGroup(537560924);
                        ComposerKt.sourceInformation(obj8, "567@21894L18");
                        it$iv3.LinksComposables(obj8, 0);
                        obj8.endReplaceGroup();
                        iNSTANCE2 = Unit.INSTANCE;
                    }
                    if (inlineComposables == null) {
                        obj8.startReplaceGroup(-515428893);
                        obj8.endReplaceGroup();
                        obj49 = it$iv3;
                    } else {
                        obj8.startReplaceGroup(-515428892);
                        ComposerKt.sourceInformation(obj8, "*569@21966L48");
                        i10 = 0;
                        obj49 = it$iv3;
                        AnnotatedStringResolveInlineContentKt.InlineChildren(obj12, inlineComposables, obj8, companion & 14);
                        Unit it = Unit.INSTANCE;
                        obj8.endReplaceGroup();
                        iNSTANCE = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj8);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = inlineContent3;
                } else {
                    $composer3.skipToGroupEnd();
                    $dirty12 = $dirty1;
                    obj3 = constructor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = $composer3;
            i5 = $dirty;
            endRestartGroup = new BasicTextKt.LayoutWithLinksAndInlineContent.6(modifier, obj12, onTextLayout, hasInlineContent, obj3, style, overflow, softWrap, maxLines, minLines, fontFamilyResolver, selectionController, color, onShowTranslation, i96, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = $composer3;
            i5 = $dirty;
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
        int i6;
        Object obj4;
        int i5;
        ArrayList arrayList;
        Object obj5;
        int i;
        int index$iv$iv;
        int size;
        Object obj2;
        int i7;
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
            i5 = 0;
            arrayList = new ArrayList(obj4.size());
            i = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj4.size()) {
                i7 = index$iv$iv;
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
                i5 = i3;
                arrayList = list;
                obj5 = obj7;
            }
            textRangeLayoutMeasureScope = textRangeLayoutMeasureScope2;
            obj6 = obj4;
            i3 = i5;
            obj7 = obj5;
            i6 = list;
        } else {
            i6 = 0;
        }
        return i6;
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
