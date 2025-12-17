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
        int i8;
        Object obj2;
        int traceInProgress2;
        Object modifier3;
        int $composer2;
        int $dirty2;
        androidx.compose.ui.Modifier.Companion $dirty;
        int i20;
        int emptyMap;
        boolean traceInProgress;
        Object obj3;
        Object str;
        Object obj4;
        int i18;
        int i15;
        int i3;
        Object obj;
        boolean z;
        int i14;
        int i5;
        Object obj5;
        Map map;
        Object obj6;
        int i;
        Object companion2;
        int modifier2;
        int overflow2;
        int i9;
        Object i7;
        boolean softWrap2;
        int i6;
        boolean i13;
        int i2;
        int i4;
        int i17;
        int i10;
        int i16;
        int i21;
        int i19;
        int i12;
        androidx.compose.ui.Modifier.Companion companion;
        final int i48 = $changed;
        final int i49 = i11;
        Composer restartGroup = $composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)303@13046L273:BasicText.kt#423gt5");
        $dirty2 = $changed;
        if (i49 & 1 != 0) {
            $dirty2 |= 6;
            obj6 = text;
        } else {
            if (i48 & 6 == 0) {
                i20 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i20;
            } else {
                obj6 = text;
            }
        }
        emptyMap = i49 & 2;
        if (emptyMap != null) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i18 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i18;
            } else {
                str = modifier;
            }
        }
        i15 = i49 & 4;
        if (i15 != 0) {
            $dirty2 |= 384;
            obj = style;
        } else {
            if (i48 & 384 == 0) {
                i14 = restartGroup.changed(style) ? 256 : 128;
                $dirty2 |= i14;
            } else {
                obj = style;
            }
        }
        int i46 = i49 & 8;
        if (i46 != 0) {
            $dirty2 |= 3072;
            obj5 = onTextLayout;
        } else {
            if (i48 & 3072 == 0) {
                i = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty2 |= i;
            } else {
                obj5 = onTextLayout;
            }
        }
        int i50 = i49 & 16;
        if (i50 != 0) {
            $dirty2 |= 24576;
            overflow2 = overflow;
        } else {
            if (i48 & 24576 == 0) {
                i9 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty2 |= i9;
            } else {
                overflow2 = overflow;
            }
        }
        i7 = i49 & 32;
        int i52 = 196608;
        if (i7 != 0) {
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
        i2 = 1572864;
        if (i13 != 0) {
            $dirty2 |= i2;
            i8 = maxLines;
        } else {
            if (i48 & i2 == 0) {
                i4 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                i8 = maxLines;
            }
        }
        int i23 = i49 & 128;
        i17 = 12582912;
        if (i23 != 0) {
            $dirty2 |= i17;
            i10 = i23;
            obj2 = inlineContent;
        } else {
            if (i48 & i17 == 0) {
                i10 = i23;
                i16 = restartGroup.changedInstance(inlineContent) ? 8388608 : 4194304;
                $dirty2 |= i16;
            } else {
                i10 = i23;
                obj2 = inlineContent;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty2 & i21 == 4793490) {
            if (!composer.getSkipping()) {
                if (emptyMap != null) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = str;
                }
                if (i15 != 0) {
                    obj = $composer2;
                }
                if (i46 != 0) {
                    obj5 = $composer2;
                }
                if (i50 != 0) {
                    overflow2 = $composer2;
                }
                if (i7 != 0) {
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
                i2 = $composer2;
                i7 = obj5;
                i13 = softWrap2;
                softWrap2 = overflow2;
                overflow2 = obj;
                BasicTextKt.BasicText-RWo7tUw(obj6, modifier3, overflow2, i7, softWrap2, i13, i2, 1, i10, 0, composer, i31 | i43, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = overflow2;
                obj4 = i7;
                i3 = softWrap2;
                z = i13;
                i5 = i2;
                map = i10;
            } else {
                composer.skipToGroupEnd();
                i5 = maxLines;
                companion2 = str;
                obj3 = obj;
                obj4 = obj5;
                i3 = overflow2;
                z = softWrap2;
                map = inlineContent;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = $dirty2;
            traceInProgress2 = new BasicTextKt.BasicText.5(text, companion2, obj3, obj4, i3, z, i5, map, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier2 = $dirty2;
            $dirty = companion;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public static final void BasicText-4YKlhWE(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Composer $composer, int $changed, int i11) {
        int i2;
        int i23;
        int traceInProgress2;
        Object modifier3;
        int $composer2;
        int $dirty2;
        androidx.compose.ui.Modifier.Companion $dirty;
        int i7;
        int i21;
        boolean traceInProgress;
        Object obj3;
        Object str;
        Object obj;
        int i8;
        int i;
        int i10;
        Object obj4;
        boolean z;
        int i16;
        int i6;
        Object obj5;
        int i15;
        Object obj2;
        int i9;
        Object companion2;
        int modifier2;
        int overflow2;
        int i18;
        Object i14;
        boolean softWrap2;
        int i5;
        boolean i3;
        int i22;
        int i12;
        int i4;
        int i13;
        int i20;
        int i19;
        int i17;
        androidx.compose.ui.Modifier.Companion companion;
        final int i48 = $changed;
        final int i49 = i11;
        Composer restartGroup = $composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)327@13717L86:BasicText.kt#423gt5");
        $dirty2 = $changed;
        if (i49 & 1 != 0) {
            $dirty2 |= 6;
            obj2 = text;
        } else {
            if (i48 & 6 == 0) {
                i7 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                obj2 = text;
            }
        }
        i21 = i49 & 2;
        if (i21 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i8;
            } else {
                str = modifier;
            }
        }
        i = i49 & 4;
        if (i != 0) {
            $dirty2 |= 384;
            obj4 = style;
        } else {
            if (i48 & 384 == 0) {
                i16 = restartGroup.changed(style) ? 256 : 128;
                $dirty2 |= i16;
            } else {
                obj4 = style;
            }
        }
        int i46 = i49 & 8;
        if (i46 != 0) {
            $dirty2 |= 3072;
            obj5 = onTextLayout;
        } else {
            if (i48 & 3072 == 0) {
                i9 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty2 |= i9;
            } else {
                obj5 = onTextLayout;
            }
        }
        int i50 = i49 & 16;
        if (i50 != 0) {
            $dirty2 |= 24576;
            overflow2 = overflow;
        } else {
            if (i48 & 24576 == 0) {
                i18 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty2 |= i18;
            } else {
                overflow2 = overflow;
            }
        }
        i14 = i49 & 32;
        int i52 = 196608;
        if (i14 != 0) {
            $dirty2 |= i52;
            softWrap2 = softWrap;
        } else {
            if (i52 &= i48 == 0) {
                i5 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                softWrap2 = softWrap;
            }
        }
        i3 = i49 & 64;
        i22 = 1572864;
        if (i3 != 0) {
            $dirty2 |= i22;
            i2 = maxLines;
        } else {
            if (i48 & i22 == 0) {
                i12 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty2 |= i12;
            } else {
                i2 = maxLines;
            }
        }
        int i25 = i49 & 128;
        int i54 = 12582912;
        if (i25 != 0) {
            $dirty2 |= i54;
            i4 = i25;
            i23 = minLines;
        } else {
            if (i48 & i54 == 0) {
                i4 = i25;
                i13 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty2 |= i13;
            } else {
                i4 = i25;
                i23 = minLines;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty2 & i20 == 4793490) {
            if (!composer.getSkipping()) {
                if (i21 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = str;
                }
                if (i != 0) {
                    obj4 = $composer2;
                }
                if (i46 != 0) {
                    obj5 = $composer2;
                }
                if (i50 != 0) {
                    overflow2 = $composer2;
                }
                if (i14 != 0) {
                    softWrap2 = $composer2;
                }
                $composer2 = i3 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                i4 = i4 != 0 ? i21 : minLines;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1542716361, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                }
                i22 = $composer2;
                i14 = obj5;
                i3 = softWrap2;
                softWrap2 = overflow2;
                overflow2 = obj4;
                BasicTextKt.BasicText-VhcvRP8(obj2, modifier3, overflow2, i14, softWrap2, i3, i22, i4, 0, composer, i32 | i44, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = overflow2;
                obj = i14;
                i10 = softWrap2;
                z = i3;
                i6 = i22;
                i15 = i4;
            } else {
                composer.skipToGroupEnd();
                i6 = maxLines;
                companion2 = str;
                obj3 = obj4;
                obj = obj5;
                i10 = overflow2;
                z = softWrap2;
                i15 = minLines;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = $dirty2;
            traceInProgress2 = new BasicTextKt.BasicText.6(text, companion2, obj3, obj, i10, z, i6, i15, i48, i49);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier2 = $dirty2;
            $dirty = companion;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final void BasicText-BpD7jsM(String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Composer $composer, int $changed, int i10) {
        int i18;
        boolean traceInProgress2;
        Object modifier2;
        int $composer2;
        boolean traceInProgress;
        int $dirty;
        Object $dirty2;
        int i9;
        Object obj7;
        int str;
        Object obj2;
        Object obj6;
        int i7;
        int i;
        Object obj3;
        boolean z;
        int i14;
        int i3;
        Object obj5;
        Object obj4;
        Object onTextLayout2;
        int modifier3;
        int i11;
        Object i12;
        int overflow2;
        int i2;
        int i8;
        boolean z2;
        int i4;
        int i6;
        int i16;
        int i13;
        int i17;
        int i5;
        int i15;
        Object obj;
        final int i40 = $changed;
        Composer restartGroup = $composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)279@12355L234:BasicText.kt#423gt5");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            obj5 = text;
        } else {
            if (i40 & 6 == 0) {
                i9 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i9;
            } else {
                obj5 = text;
            }
        }
        str = i10 & 2;
        if (str != null) {
            $dirty |= 48;
            obj2 = modifier;
        } else {
            if (i40 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i7;
            } else {
                obj2 = modifier;
            }
        }
        int i37 = i10 & 4;
        if (i37 != 0) {
            $dirty |= 384;
            obj3 = style;
        } else {
            if (i40 & 384 == 0) {
                i14 = restartGroup.changed(style) ? 256 : 128;
                $dirty |= i14;
            } else {
                obj3 = style;
            }
        }
        int i39 = i10 & 8;
        if (i39 != 0) {
            $dirty |= 3072;
            obj4 = onTextLayout;
        } else {
            if (i40 & 3072 == 0) {
                i11 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty |= i11;
            } else {
                obj4 = onTextLayout;
            }
        }
        i12 = i10 & 16;
        if (i12 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else {
            if (i40 & 24576 == 0) {
                i2 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty |= i2;
            } else {
                overflow2 = overflow;
            }
        }
        i8 = i10 & 32;
        int i43 = 196608;
        if (i8 != 0) {
            $dirty |= i43;
            z2 = softWrap;
        } else {
            if (i43 &= i40 == 0) {
                i4 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty |= i4;
            } else {
                z2 = softWrap;
            }
        }
        i6 = i10 & 64;
        i16 = 1572864;
        if (i6 != 0) {
            $dirty |= i16;
            i18 = maxLines;
        } else {
            if (i40 & i16 == 0) {
                i13 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= i13;
            } else {
                i18 = maxLines;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty & i17 == 599186) {
            if (!composer.getSkipping()) {
                if (str != null) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj2;
                }
                if (i37 != 0) {
                    obj3 = $composer2;
                }
                if (i39 != 0) {
                    obj4 = $composer2;
                }
                if (i12 != 0) {
                    overflow2 = $composer2;
                }
                if (i8 != 0) {
                    z2 = $composer2;
                }
                i6 = i6 != 0 ? $composer2 : maxLines;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1022429478, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:278)");
                }
                i12 = obj3;
                i8 = overflow2;
                overflow2 = obj4;
                BasicTextKt.BasicText-VhcvRP8(obj5, modifier2, i12, overflow2, i8, z2, i6, 1, 0, composer, $composer2 | i35, 256);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj7 = i12;
                obj6 = overflow2;
                i = i8;
                i3 = i6;
                z = z2;
            } else {
                composer.skipToGroupEnd();
                onTextLayout2 = obj2;
                obj6 = obj10;
                i3 = maxLines;
                obj7 = obj3;
                i = overflow2;
                z = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier3 = $dirty;
            traceInProgress2 = new BasicTextKt.BasicText.4(text, onTextLayout2, obj7, obj6, i, z, i3, i40, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier3 = $dirty;
            $dirty2 = obj;
        }
    }

    public static final void BasicText-RWo7tUw(AnnotatedString text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, androidx.compose.foundation.text.InlineTextContent> inlineContent, ColorProducer color, Composer $composer, int $changed, int i13) {
        int i8;
        Object obj5;
        Object obj3;
        int traceInProgress2;
        boolean traceInProgress;
        int selectionRegistrar;
        Object invalid$iv;
        int i14;
        int str2;
        int $i$a$CacheBasicTextKt$BasicText$selectionController$2;
        AnnotatedString str;
        Object it$iv;
        int empty;
        Composer restartGroup;
        int i5;
        Object style2;
        Composer composer3;
        Object $composer3;
        int $dirty2;
        Object obj4;
        int $i$f$cache;
        Function0 factory$iv$iv;
        Object onTextLayout2;
        int i25;
        int i4;
        int i26;
        Object overflow2;
        int i33;
        boolean maxLines2;
        int softWrap2;
        boolean maxLines3;
        int softWrap3;
        Object obj2;
        int i7;
        int minLines2;
        int i23;
        int i34;
        Object rememberedValue;
        int i;
        Object obj;
        int i2;
        Map map;
        int i6;
        int backgroundSelectionColor;
        int currentCompositeKeyHash;
        int i20;
        Object i28;
        int i36;
        int i9;
        int materializeModifier;
        Composer i16;
        int i44;
        Object i32;
        int i41;
        int i43;
        int i29;
        int inlineContent2;
        int i42;
        int i35;
        int i45;
        int i10;
        int i17;
        int onTextLayout3;
        int i40;
        Object softWrap4;
        Composer composer2;
        int i22;
        int companion;
        SelectionController selectionController;
        int i11;
        int i27;
        int $composer2;
        Composer composer;
        int i3;
        int i18;
        int i15;
        int i31;
        int i19;
        int i21;
        int i37;
        int i30;
        int i38;
        int i39;
        int i12;
        int i24;
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
        i16 = $changed;
        final int i107 = i13;
        restartGroup = $composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)196@9257L7:BasicText.kt#423gt5");
        $dirty2 = $changed;
        if (i107 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i16 & 6 == 0) {
                i25 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i25;
            }
        }
        int i84 = i107 & 2;
        if (i84 != 0) {
            $dirty2 |= 48;
            obj2 = modifier;
        } else {
            if (i16 & 48 == 0) {
                i23 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i23;
            } else {
                obj2 = modifier;
            }
        }
        i34 = i107 & 4;
        if (i34 != 0) {
            $dirty2 |= 384;
            obj = style;
        } else {
            if (i16 & 384 == 0) {
                i6 = restartGroup.changed(style) ? 256 : 128;
                $dirty2 |= i6;
            } else {
                obj = style;
            }
        }
        int i99 = i107 & 8;
        if (i99 != 0) {
            $dirty2 |= 3072;
            i28 = onTextLayout;
        } else {
            if (i16 & 3072 == 0) {
                i36 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty2 |= i36;
            } else {
                i28 = onTextLayout;
            }
        }
        i9 = i107 & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
            materializeModifier = overflow;
        } else {
            if (i16 & 24576 == 0) {
                i44 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty2 |= i44;
            } else {
                materializeModifier = overflow;
            }
        }
        i32 = i107 & 32;
        i41 = 196608;
        if (i32 != 0) {
            $dirty2 |= i41;
            maxLines3 = softWrap;
        } else {
            if (i16 & i41 == 0) {
                i41 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty2 |= i41;
            } else {
                maxLines3 = softWrap;
            }
        }
        i43 = i107 & 64;
        i29 = 1572864;
        if (i43 != 0) {
            $dirty2 |= i29;
            i33 = maxLines;
        } else {
            if (i16 & i29 == 0) {
                inlineContent2 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty2 |= inlineContent2;
            } else {
                i33 = maxLines;
            }
        }
        int i47 = i107 & 128;
        int i109 = 12582912;
        if (i47 != 0) {
            $dirty2 |= i109;
            i35 = i47;
            i8 = minLines;
        } else {
            if (i16 & i109 == 0) {
                i35 = i47;
                i45 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty2 |= i45;
            } else {
                i35 = i47;
                i8 = minLines;
            }
        }
        int i48 = i107 & 256;
        int i111 = 100663296;
        if (i48 != 0) {
            $dirty2 |= i111;
            i10 = i48;
            obj5 = inlineContent;
        } else {
            if (i16 & i111 == 0) {
                i10 = i48;
                i17 = restartGroup.changedInstance(inlineContent) ? 67108864 : 33554432;
                $dirty2 |= i17;
            } else {
                i10 = i48;
                obj5 = inlineContent;
            }
        }
        int i49 = i107 & 512;
        int i114 = 805306368;
        if (i49 != 0) {
            $dirty2 |= i114;
            onTextLayout3 = i49;
            obj3 = color;
        } else {
            if (i16 & i114 == 0) {
                onTextLayout3 = i49;
                i40 = restartGroup.changedInstance(color) ? 536870912 : 268435456;
                $dirty2 |= i40;
            } else {
                onTextLayout3 = i49;
                obj3 = color;
            }
        }
        if ($dirty2 & softWrap4 == 306783378) {
            if (!restartGroup.getSkipping()) {
                if (i84 != 0) {
                    softWrap4 = traceInProgress2;
                } else {
                    softWrap4 = obj2;
                }
                if (i34 != 0) {
                    obj = traceInProgress2;
                }
                if (i99 != 0) {
                    i28 = traceInProgress2;
                }
                if (i9 != 0) {
                    i4 = traceInProgress2;
                } else {
                    i4 = materializeModifier;
                }
                if (i32 != 0) {
                    maxLines3 = traceInProgress2;
                }
                if (i43 != 0) {
                    i33 = traceInProgress2;
                }
                i7 = i35 != 0 ? traceInProgress2 : minLines;
                if (i10 != 0) {
                    i35 = traceInProgress2;
                } else {
                    i35 = inlineContent;
                }
                i9 = onTextLayout3 != 0 ? traceInProgress2 : color;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1064305212, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:191)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(i7, i33);
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
                    i43 = 6;
                    int i108 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, backgroundSelectionColor, str8);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    long backgroundColor-0d7_KjU = (TextSelectionColors)restartGroup.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU();
                    onTextLayout3 = obj7;
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
                    i42 = i4;
                    long $dirty4 = obj53;
                    composer2 = restartGroup;
                    i22 = 0;
                    obj55 = this_$iv;
                    Object rememberedValue3 = composer2.rememberedValue();
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
                            composer2.updateRememberedValue(obj52);
                        } else {
                            backgroundSelectionColor = $dirty4;
                            $dirty2 = l;
                            selectionRegistrar2 = obj55;
                            $i$a$CacheBasicTextKt$BasicText$selectionController$2 = obj52;
                            selectionRegistrar = composer2;
                        }
                    } else {
                        $dirty = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                    i28 = $i$a$CacheBasicTextKt$BasicText$selectionController$2;
                } else {
                    selectionRegistrar2 = this_$iv;
                    $dirty = $dirty2;
                    i42 = i4;
                    onTextLayout3 = i28;
                    restartGroup.startReplaceGroup(-1584467526);
                    restartGroup.endReplaceGroup();
                    i28 = 0;
                }
                int i85 = i42;
                inlineContent2 = AnnotatedStringResolveInlineContentKt.hasInlineContent(text);
                if (!inlineContent2 && !TextAnnotatedStringNodeKt.hasLinks(text)) {
                    if (!TextAnnotatedStringNodeKt.hasLinks(text)) {
                        restartGroup.startReplaceGroup(-1584294453);
                        ComposerKt.sourceInformation(restartGroup, "229@10603L7,217@10089L814");
                        int i83 = 0;
                        int i96 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str8);
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        i16 = restartGroup;
                        Modifier textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(softWrap4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj35, false, 0, 0, 0, obj40, 0, obj42), text, obj, onTextLayout3, i85, maxLines3, i33, i7, (FontFamily.Resolver)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), 0, 0, i28, i9, 0);
                        style2 = EmptyMeasurePolicy.INSTANCE;
                        rememberedValue = 48;
                        i2 = 0;
                        ComposerKt.sourceInformationMarkerStart(i16, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(i16, 0);
                        obj52 = textModifier-cFh6CEA;
                        invalid$iv = i16.getCurrentCompositionLocalMap();
                        obj53 = constructor;
                        i32 = 6;
                        i43 = 0;
                        ComposerKt.sourceInformationMarkerStart(i16, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!applier instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        i16.startReusableNode();
                        if (i16.getInserting()) {
                            i16.createNode(obj53);
                        } else {
                            factory$iv$iv = obj53;
                            i16.useNode();
                        }
                        Composer constructor-impl = Updater.constructor-impl(i16);
                        i29 = 0;
                        i22 = factory$iv$iv;
                        Updater.set-impl(constructor-impl, (MeasurePolicy)style2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl, invalid$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(i16, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
                        composer2 = 0;
                        obj53 = constructor-impl;
                        companion = 0;
                        if (!obj53.getInserting()) {
                            obj55 = invalid$iv;
                            obj56 = style2;
                            if (!Intrinsics.areEqual(obj53.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                obj53.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                i5 = obj53;
                            }
                        } else {
                            obj55 = invalid$iv;
                            obj56 = style2;
                        }
                        i16.endNode();
                        ComposerKt.sourceInformationMarkerEnd(i16);
                        ComposerKt.sourceInformationMarkerEnd(i16);
                        i16.endReplaceGroup();
                        i26 = obj54;
                        composer = i16;
                        obj4 = onTextLayout3;
                    } else {
                        i16 = restartGroup;
                        i16.startReplaceGroup(-1583391888);
                        ComposerKt.sourceInformation(i16, "241@11076L39,254@11574L7,257@11697L256,243@11125L838");
                        ComposerKt.sourceInformationMarkerStart(i16, -328167685, str7);
                        i14 = $dirty & 14 == 4 ? 1 : 0;
                        Composer composer4 = i16;
                        $i$f$cache = 0;
                        Object rememberedValue4 = composer4.rememberedValue();
                        int i97 = 0;
                        if (i14 == 0) {
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                backgroundSelectionColor = 0;
                                obj52 = i14;
                                obj53 = $i$f$cache;
                                int invalid$iv2 = 0;
                                composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(text, invalid$iv2, 2, invalid$iv2));
                            } else {
                                obj52 = i14;
                                obj53 = $i$f$cache;
                                invalid$iv = rememberedValue4;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(i16);
                        int i68 = 0;
                        int i86 = 0;
                        ComposerKt.sourceInformationMarkerStart(i16, 2023513938, str8);
                        ComposerKt.sourceInformationMarkerEnd(i16);
                        ComposerKt.sourceInformationMarkerStart(i16, -328147596, str7);
                        Composer composer5 = i16;
                        int i87 = 0;
                        rememberedValue = composer5.rememberedValue();
                        i2 = 0;
                        if (!i16.changed(invalid$iv)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                currentCompositeKeyHash = 0;
                                materializeModifier = new BasicTextKt.BasicText.2.1(invalid$iv);
                                composer5.updateRememberedValue((Function1)materializeModifier);
                            } else {
                                materializeModifier = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(i16);
                        composer = i16;
                        i29 = onTextLayout3;
                        i32 = softWrap4;
                        onTextLayout3 = obj54;
                        BasicTextKt.LayoutWithLinksAndInlineContent-vOo2fZY(i32, BasicTextKt.BasicText_RWo7tUw$lambda$5((MutableState)invalid$iv), i29, inlineContent2, i35, obj, onTextLayout3, maxLines3, i33, i7, (FontFamily.Resolver)i16.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), i28, i9, (Function1)materializeModifier, composer, i65 | i82, i66 &= 896, 0);
                        obj4 = i29;
                        i26 = onTextLayout3;
                        softWrap4 = i32;
                        composer.endReplaceGroup();
                    }
                } else {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = i7;
                i20 = i9;
                map = i35;
                $composer3 = softWrap4;
                minLines2 = softWrap3;
                maxLines3 = maxLines2;
                softWrap2 = i26;
                overflow2 = obj4;
                onTextLayout2 = i10;
            } else {
                restartGroup.skipToGroupEnd();
                str = text;
                i = minLines;
                i20 = color;
                composer = restartGroup;
                $dirty = $dirty2;
                $composer3 = obj2;
                onTextLayout2 = obj;
                overflow2 = i28;
                map = inlineContent;
                minLines2 = i33;
                softWrap2 = materializeModifier;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new BasicTextKt.BasicText.3(str, $composer3, onTextLayout2, overflow2, softWrap2, maxLines3, minLines2, i, map, i20, $changed, i107);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public static final void BasicText-VhcvRP8(AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map inlineContent, Composer $composer, int $changed, int i12) {
        int i9;
        int i2;
        Object obj7;
        boolean traceInProgress2;
        int maxLines2;
        int $composer2;
        int $dirty2;
        Object $dirty3;
        int i;
        Object obj4;
        int emptyMap;
        boolean traceInProgress;
        Object obj2;
        Object modifier2;
        int i3;
        int i14;
        int str;
        Object obj5;
        boolean z;
        int i4;
        int i10;
        int i8;
        Object obj3;
        int onTextLayout2;
        int i5;
        Object obj;
        Object obj6;
        int overflow2;
        int $dirty;
        int i18;
        int i16;
        boolean softWrap2;
        int i23;
        int i13;
        int i21;
        int i25;
        int i6;
        int i22;
        int i17;
        int i7;
        int i19;
        int i20;
        int i11;
        int i15;
        int i24;
        final int i54 = $changed;
        final int i55 = i12;
        Composer restartGroup = $composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation(restartGroup, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)341@14269L240:BasicText.kt#423gt5");
        $dirty2 = $changed;
        if (i55 & 1 != 0) {
            $dirty2 |= 6;
            obj6 = text;
        } else {
            if (i54 & 6 == 0) {
                i = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i;
            } else {
                obj6 = text;
            }
        }
        emptyMap = i55 & 2;
        if (emptyMap != null) {
            $dirty2 |= 48;
            obj2 = modifier;
        } else {
            if (i54 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                obj2 = modifier;
            }
        }
        str = i55 & 4;
        if (str != null) {
            $dirty2 |= 384;
            obj5 = style;
        } else {
            if (i54 & 384 == 0) {
                i4 = restartGroup.changed(style) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                obj5 = style;
            }
        }
        i8 = i55 & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            obj3 = onTextLayout;
        } else {
            if (i54 & 3072 == 0) {
                i5 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                obj3 = onTextLayout;
            }
        }
        int i53 = i55 & 16;
        if (i53 != 0) {
            $dirty2 |= 24576;
            overflow2 = overflow;
        } else {
            if (i54 & 24576 == 0) {
                i18 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty2 |= i18;
            } else {
                overflow2 = overflow;
            }
        }
        i16 = i55 & 32;
        int i57 = 196608;
        if (i16 != 0) {
            $dirty2 |= i57;
            softWrap2 = softWrap;
        } else {
            if (i57 &= i54 == 0) {
                i23 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty2 |= i23;
            } else {
                softWrap2 = softWrap;
            }
        }
        i13 = i55 & 64;
        i21 = 1572864;
        if (i13 != 0) {
            $dirty2 |= i21;
            i9 = maxLines;
        } else {
            if (i54 & i21 == 0) {
                i25 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty2 |= i25;
            } else {
                i9 = maxLines;
            }
        }
        int i27 = i55 & 128;
        int i59 = 12582912;
        if (i27 != 0) {
            $dirty2 |= i59;
            i6 = i27;
            i2 = minLines;
        } else {
            if (i54 & i59 == 0) {
                i6 = i27;
                i22 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty2 |= i22;
            } else {
                i6 = i27;
                i2 = minLines;
            }
        }
        int i28 = i55 & 256;
        int i61 = 100663296;
        if (i28 != 0) {
            $dirty2 |= i61;
            i17 = i28;
            obj7 = inlineContent;
        } else {
            if (i54 & i61 == 0) {
                i17 = i28;
                i19 = restartGroup.changedInstance(inlineContent) ? 67108864 : 33554432;
                $dirty2 |= i19;
            } else {
                i17 = i28;
                obj7 = inlineContent;
            }
        }
        final Composer composer = restartGroup;
        if ($dirty2 & i20 == 38347922) {
            if (!composer.getSkipping()) {
                if (emptyMap != null) {
                    obj2 = traceInProgress2;
                }
                if (str != null) {
                    obj5 = traceInProgress2;
                }
                if (i8 != 0) {
                    obj3 = traceInProgress2;
                }
                if (i53 != 0) {
                    overflow2 = traceInProgress2;
                }
                if (i16 != 0) {
                    softWrap2 = traceInProgress2;
                }
                maxLines2 = i13 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                $composer2 = i6 != 0 ? 1 : minLines;
                if (i17 != 0) {
                    i20 = emptyMap;
                } else {
                    i20 = inlineContent;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(851408699, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:341)");
                }
                i6 = maxLines2;
                i16 = obj5;
                i13 = overflow2;
                i21 = softWrap2;
                overflow2 = obj2;
                softWrap2 = obj3;
                BasicTextKt.BasicText-RWo7tUw(obj6, overflow2, i16, softWrap2, i13, i21, i6, $composer2, i20, 0, composer, i36 | i50, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = overflow2;
                obj4 = i16;
                obj3 = softWrap2;
                i14 = i13;
                z = i21;
                i10 = i6;
                obj = i20;
            } else {
                composer.skipToGroupEnd();
                i10 = maxLines;
                i7 = minLines;
                obj = inlineContent;
                obj4 = obj5;
                i14 = overflow2;
                z = softWrap2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            traceInProgress2 = new BasicTextKt.BasicText.7(text, obj2, obj4, obj3, i14, z, i10, i7, obj, i54, i55);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty = $dirty2;
            $dirty3 = obj2;
            modifier2 = obj3;
            onTextLayout2 = i7;
        }
    }

    public static final void BasicText-VhcvRP8(String text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, ColorProducer color, Composer $composer, int $changed, int i12) {
        int i31;
        int i28;
        Object obj6;
        boolean traceInProgress2;
        int maxLines2;
        Modifier textModifier-cFh6CEA;
        Composer restartGroup;
        int $composer3;
        androidx.compose.runtime.ProvidableCompositionLocal selectionController;
        Object it$iv;
        int $dirty3;
        Object $dirty4;
        Object $dirty2;
        int empty;
        int i30;
        Object obj;
        int minLines2;
        Composer minLines3;
        Composer composer;
        Composer composer2;
        Object obj2;
        Object color3;
        int color2;
        int i35;
        int i3;
        boolean traceInProgress;
        int selectionRegistrar;
        int graphicsLayer-Ap8cVGQ$default2;
        Object obj4;
        boolean z3;
        int i40;
        int softWrap2;
        int str;
        boolean z;
        Object obj7;
        int i;
        int i32;
        int i23;
        int i37;
        int i21;
        int localFontFamilyResolver;
        int currentCompositionLocalMap;
        int overflow2;
        Object constructor;
        Composer $composer2;
        int i18;
        int i2;
        int backgroundColor-0d7_KjU;
        boolean $i$f$getCurrent;
        int i38;
        int i10;
        Object consume;
        int i4;
        int i26;
        int i14;
        int i17;
        int i16;
        int i6;
        int i33;
        int i27;
        Object obj5;
        boolean selectionController2;
        Modifier graphicsLayer-Ap8cVGQ$default;
        AnnotatedString $i$a$LetComposerKt$cache$1$iv;
        Object obj8;
        Object companion;
        int i25;
        int i5;
        boolean z2;
        int i8;
        int i13;
        Object obj3;
        int i34;
        int i7;
        int i15;
        int i39;
        int i20;
        int i11;
        int i19;
        int i36;
        int i29;
        int i9;
        int i22;
        int i24;
        int $dirty;
        int minLines4;
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
                i30 = restartGroup.changed(text) ? 4 : 2;
                $dirty3 |= i30;
            } else {
                constructor = text;
            }
        }
        int i48 = i69 & 2;
        if (i48 != 0) {
            $dirty3 |= 48;
            obj2 = modifier;
        } else {
            if (i68 & 48 == 0) {
                i35 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i35;
            } else {
                obj2 = modifier;
            }
        }
        int i52 = i69 & 4;
        if (i52 != 0) {
            $dirty3 |= 384;
            obj4 = style;
        } else {
            if (i68 & 384 == 0) {
                i40 = restartGroup.changed(style) ? 256 : 128;
                $dirty3 |= i40;
            } else {
                obj4 = style;
            }
        }
        str = i69 & 8;
        if (str != null) {
            $dirty3 |= 3072;
            obj7 = onTextLayout;
        } else {
            if (i68 & 3072 == 0) {
                i32 = restartGroup.changedInstance(onTextLayout) ? 2048 : 1024;
                $dirty3 |= i32;
            } else {
                obj7 = onTextLayout;
            }
        }
        i37 = i69 & 16;
        if (i37 != 0) {
            $dirty3 |= 24576;
            currentCompositionLocalMap = overflow;
        } else {
            if (i68 & 24576 == 0) {
                i18 = restartGroup.changed(overflow) ? 16384 : 8192;
                $dirty3 |= i18;
            } else {
                currentCompositionLocalMap = overflow;
            }
        }
        i2 = i69 & 32;
        int i72 = 196608;
        if (i2 != 0) {
            $dirty3 |= i72;
            $i$f$getCurrent = softWrap;
        } else {
            if (i72 &= i68 == 0) {
                i38 = restartGroup.changed(softWrap) ? 131072 : 65536;
                $dirty3 |= i38;
            } else {
                $i$f$getCurrent = softWrap;
            }
        }
        i10 = i69 & 64;
        i26 = 1572864;
        if (i10 != 0) {
            $dirty3 |= i26;
            i31 = maxLines;
        } else {
            if (i68 & i26 == 0) {
                i14 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty3 |= i14;
            } else {
                i31 = maxLines;
            }
        }
        int i42 = i69 & 128;
        int i76 = 12582912;
        if (i42 != 0) {
            $dirty3 |= i76;
            i17 = i42;
            i28 = minLines;
        } else {
            if (i68 & i76 == 0) {
                i17 = i42;
                i16 = restartGroup.changed(minLines) ? 8388608 : 4194304;
                $dirty3 |= i16;
            } else {
                i17 = i42;
                i28 = minLines;
            }
        }
        int i43 = i69 & 256;
        int i78 = 100663296;
        if (i43 != 0) {
            $dirty3 |= i78;
            i6 = i43;
            obj6 = color;
        } else {
            if (i68 & i78 == 0) {
                i6 = i43;
                i33 = restartGroup.changedInstance(color) ? 67108864 : 33554432;
                $dirty3 |= i33;
            } else {
                i6 = i43;
                obj6 = color;
            }
        }
        if ($dirty3 & i27 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (i48 != 0) {
                    obj5 = traceInProgress2;
                } else {
                    obj5 = obj2;
                }
                if (i52 != 0) {
                    obj4 = traceInProgress2;
                }
                if (str != null) {
                    obj7 = traceInProgress2;
                }
                if (i37 != 0) {
                    currentCompositionLocalMap = traceInProgress2;
                }
                if (i2 != 0) {
                    $i$f$getCurrent = traceInProgress2;
                }
                maxLines2 = i10 != 0 ? 0x7fffffff /* Unknown resource */ : maxLines;
                minLines2 = i17 != 0 ? 1 : minLines;
                color2 = i6 != 0 ? 0 : color;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1186827822, $dirty3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(minLines2, maxLines2);
                int i59 = 6;
                i21 = 0;
                backgroundColor-0d7_KjU = 2023513938;
                i17 = maxLines2;
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
                    z = $i$f$getCurrent;
                    backgroundColor-0d7_KjU = (TextSelectionColors)restartGroup.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU();
                    $dirty = $dirty3;
                    String $dirty5 = "CC(remember):BasicText.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -328352935, $dirty5);
                    obj46 = restartGroup;
                    int i83 = 0;
                    obj54 = restartGroup;
                    it$iv = obj46.rememberedValue();
                    int i85 = 0;
                    if (!restartGroup.changedInstance(this_$iv)) {
                        minLines4 = minLines2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            int minLines5 = 0;
                            obj47 = it$iv;
                            it$iv = new BasicTextKt.BasicText.selectionController.selectableId.1.1(this_$iv);
                            obj46.updateRememberedValue((Function0)it$iv);
                        } else {
                            composer2 = obj46;
                            obj47 = it$iv;
                        }
                    } else {
                        minLines4 = minLines2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj54);
                    obj50 = obj54;
                    obj51 = i50;
                    obj48 = selectionController2;
                    minLines3 = obj50;
                    obj47 = longValue;
                    ComposerKt.sourceInformationMarkerStart(minLines3, -328350274, $dirty5);
                    consume = minLines3;
                    i26 = 0;
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
                            $dirty2 = obj49;
                            obj46 = rememberedValue2;
                            consume.updateRememberedValue(obj46);
                        } else {
                            companion = obj47;
                            $dirty2 = this_$iv;
                            selectionRegistrar = obj46;
                            $composer3 = consume;
                        }
                    } else {
                        $i$a$LetComposerKt$cache$1$iv = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(minLines3);
                    minLines3.endReplaceGroup();
                    i39 = selectionRegistrar;
                } else {
                    $dirty = $dirty3;
                    minLines4 = minLines2;
                    $dirty2 = this_$iv;
                    z = $i$f$getCurrent;
                    minLines3 = restartGroup;
                    minLines3.startReplaceGroup(-1588686502);
                    minLines3.endReplaceGroup();
                    i39 = selectionRegistrar;
                }
                int i44 = i39;
                if (i44 == 0) {
                    if (obj7 != null) {
                        obj52 = i44;
                        i2 = obj4;
                        i4 = currentCompositionLocalMap;
                        obj8 = obj5;
                        minLines3.startReplaceGroup(-1588564052);
                        ComposerKt.sourceInformation(minLines3, "130@6178L7");
                        super(text, 0, 0, 6, 0);
                        graphicsLayer-Ap8cVGQ$default2 = 0;
                        obj4 = 0;
                        ComposerKt.sourceInformationMarkerStart(minLines3, 2023513938, maxLines3);
                        ComposerKt.sourceInformationMarkerEnd(minLines3);
                        textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i39, false, 0, 0, 0, obj37, 0, obj39), $i$a$LetComposerKt$cache$1$iv, i2, obj7, i4, z, i17, minLines4, (FontFamily.Resolver)minLines3.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), 0, 0, obj52, color2, 0);
                        minLines3.endReplaceGroup();
                    } else {
                        minLines3.startReplaceGroup(-1587866335);
                        ComposerKt.sourceInformation(minLines3, "143@6671L7");
                        int i71 = 0;
                        int i73 = 0;
                        ComposerKt.sourceInformationMarkerStart(minLines3, 2023513938, maxLines3);
                        ComposerKt.sourceInformationMarkerEnd(minLines3);
                        overflow2 = new TextStringSimpleElement(constructor, obj4, (FontFamily.Resolver)minLines3.consume((CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver()), currentCompositionLocalMap, z, i17, minLines4, color2, 0);
                        textModifier-cFh6CEA = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i39, false, 0, 0, 0, obj37, 0, obj39).then((Modifier)overflow2);
                        minLines3.endReplaceGroup();
                        i15 = obj52;
                        i25 = obj7;
                        i27 = $i$a$LetComposerKt$cache$1$iv;
                    }
                } else {
                    obj52 = i44;
                    i2 = obj4;
                    i4 = currentCompositionLocalMap;
                    obj8 = obj5;
                }
                restartGroup = EmptyMeasurePolicy.INSTANCE;
                int i53 = 48;
                int i56 = 0;
                ComposerKt.sourceInformationMarkerStart(minLines3, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(minLines3, 0);
                $i$f$getCurrent = 6;
                i10 = 0;
                obj46 = textModifier-cFh6CEA;
                obj49 = $dirty2;
                ComposerKt.sourceInformationMarkerStart(minLines3, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                minLines3.startReusableNode();
                if (minLines3.getInserting()) {
                    minLines3.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    minLines3.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(minLines3);
                obj47 = i47;
                Updater.set-impl(constructor-impl, (MeasurePolicy)restartGroup, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, minLines3.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(minLines3, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
                i26 = 0;
                obj48 = constructor-impl;
                i6 = 0;
                if (!obj48.getInserting()) {
                    obj50 = restartGroup;
                    obj54 = minLines3;
                    if (!Intrinsics.areEqual(obj48.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj48.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = obj48;
                    }
                } else {
                    obj50 = restartGroup;
                    obj54 = minLines3;
                }
                obj54.endNode();
                ComposerKt.sourceInformationMarkerEnd(obj54);
                ComposerKt.sourceInformationMarkerEnd(obj54);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i23 = color2;
                z3 = z;
                obj = i2;
                softWrap2 = i17;
                $dirty4 = i27;
                color3 = i25;
                i3 = i5;
                i = minLines4;
            } else {
                restartGroup.skipToGroupEnd();
                softWrap2 = maxLines;
                i23 = color;
                obj54 = restartGroup;
                $dirty = $dirty3;
                $dirty4 = obj2;
                obj = obj4;
                color3 = obj7;
                i3 = currentCompositionLocalMap;
                z3 = $i$f$getCurrent;
                i = minLines;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj54.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = obj54;
            traceInProgress2 = new BasicTextKt.BasicText.1(text, $dirty4, obj, color3, i3, z3, softWrap2, i, i23, i68, i69);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $composer2 = obj54;
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
        int traceInProgress2;
        Object inlineContent3;
        int $this$cache$iv;
        Unit iNSTANCE;
        Unit iNSTANCE2;
        Composer it$iv4;
        Object endRestartGroup;
        int it$iv5;
        boolean traceInProgress;
        int i25;
        Object obj7;
        int i17;
        Object obj4;
        Object obj;
        Object obj5;
        Object empty2;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1 it$iv3;
        Object it$iv6;
        Object it$iv2;
        boolean textModifier-cFh6CEA;
        int i16;
        int i19;
        int empty3;
        Pair resolveInlineContent;
        Object inlineComposables;
        int invalid$iv;
        Object linksTextMeasurePolicy;
        Composer composer;
        int i11;
        Object obj10;
        Object $composer2;
        int $dirty;
        int $dirty12;
        Composer composer2;
        Object obj9;
        int i4;
        Object currentCompositionLocalMap;
        Object rememberedValue;
        int currentCompositeKeyHash;
        int i27;
        int i5;
        int i2;
        int i26;
        int i3;
        int materializeModifier;
        int empty;
        Object constructor;
        Composer $this$cache$iv2;
        int empty4;
        Object anon4;
        boolean anon;
        int changedInstance;
        int i24;
        int i22;
        int i6;
        int i23;
        Object obj2;
        int companion2;
        int companion3;
        int companion;
        Composer $composer3;
        int it$iv;
        int i15;
        int i13;
        int i12;
        int i28;
        int modifier$iv;
        int i21;
        int changedInstance2;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.2.1 anon3;
        int i7;
        boolean z;
        int i8;
        int i9;
        FontFamily.Resolver resolver;
        Object obj3;
        Object obj8;
        Object obj6;
        SelectionController selectionController2;
        ColorProducer colorProducer;
        Function1 function1;
        int i14;
        int i20;
        int i10;
        int i;
        int $dirty1;
        Object inlineContent2;
        androidx.compose.foundation.text.BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1 anon2;
        Object inlineComposables2;
        ScopeUpdateScope scopeUpdateScope;
        Object obj49;
        int obj59;
        final Object obj12 = text;
        obj7 = onTextLayout;
        final int i95 = $changed;
        int i29 = $changed1;
        int i35 = i18;
        $composer2 = $composer.startRestartGroup(645129368);
        ComposerKt.sourceInformation($composer2, "C(LayoutWithLinksAndInlineContent)P(6,13,8,2,3,12,9:c#ui.text.style.TextOverflow,11,4,5,1,10)578@22283L117,565@21843L1459:BasicText.kt#423gt5");
        $dirty = $changed;
        $dirty12 = $changed1;
        if (i35 & 1 != 0) {
            $dirty |= 6;
            obj9 = modifier;
        } else {
            if (i95 & 6 == 0) {
                i5 = $composer2.changed(modifier) ? 4 : 2;
                $dirty |= i5;
            } else {
                obj9 = modifier;
            }
        }
        if (i35 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i95 & 48 == 0) {
                i2 = $composer2.changed(obj12) ? 32 : 16;
                $dirty |= i2;
            }
        }
        if (i35 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i95 & 384 == 0) {
                i26 = $composer2.changedInstance(obj7) ? 256 : changedInstance;
                $dirty |= i26;
            }
        }
        companion3 = 1024;
        if (i35 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i95 & 3072 == 0) {
                i3 = $composer2.changed(hasInlineContent) ? i6 : companion3;
                $dirty |= i3;
            }
        }
        materializeModifier = i35 & 16;
        if (materializeModifier != 0) {
            $dirty |= 24576;
            constructor = inlineContent;
        } else {
            if (i95 & 24576 == 0) {
                i13 = $composer2.changedInstance(inlineContent) ? 16384 : 8192;
                $dirty |= i13;
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
            anon = softWrap;
        } else {
            if (i92 &= i95 == 0) {
                i21 = $composer2.changed(softWrap) ? 8388608 : 4194304;
                $dirty |= i21;
            } else {
                anon = softWrap;
            }
        }
        if (i35 & 256 != 0) {
            $dirty |= i65;
            empty3 = maxLines;
        } else {
            if (i72 &= i95 == 0) {
                changedInstance2 = $composer2.changed(maxLines) ? 67108864 : 33554432;
                $dirty |= changedInstance2;
            } else {
                empty3 = maxLines;
            }
        }
        if (i35 & 512 != 0) {
            $dirty |= i44;
            i17 = minLines;
        } else {
            if (i42 &= i95 == 0) {
                changedInstance2 = $composer2.changed(minLines) ? 536870912 : 268435456;
                $dirty |= changedInstance2;
            } else {
                i17 = minLines;
            }
        }
        if (i35 & 1024 != 0) {
            $dirty12 |= 6;
            obj4 = fontFamilyResolver;
        } else {
            if (i29 & 6 == 0) {
                changedInstance2 = $composer2.changedInstance(fontFamilyResolver) ? 4 : 2;
                $dirty12 |= changedInstance2;
            } else {
                obj4 = fontFamilyResolver;
            }
        }
        if (i35 & 2048 != 0) {
            $dirty12 |= 48;
            obj = selectionController;
        } else {
            if (i29 & 48 == 0) {
                it$iv = $composer2.changedInstance(selectionController) ? 32 : 16;
                $dirty12 |= it$iv;
            } else {
                obj = selectionController;
            }
        }
        if (i35 & 4096 != 0) {
            $dirty12 |= 384;
            obj5 = color;
        } else {
            if (i29 & 384 == 0) {
                if ($composer2.changedInstance(color)) {
                    changedInstance = 256;
                }
                $dirty12 |= changedInstance;
            } else {
                obj5 = color;
            }
        }
        if (i35 & 8192 != 0) {
            $dirty12 |= 3072;
            empty2 = onShowTranslation;
        } else {
            if (i29 & 3072 == 0) {
                if ($composer2.changedInstance(onShowTranslation)) {
                } else {
                    i6 = companion3;
                }
                $dirty12 |= i6;
            } else {
                empty2 = onShowTranslation;
            }
        }
        if ($dirty & i24 == 306783378 && $dirty12 & 1171 == 1170) {
            if ($dirty12 & 1171 == 1170) {
                if (!$composer2.getSkipping()) {
                    if (materializeModifier != 0) {
                        inlineContent3 = MapsKt.emptyMap();
                    } else {
                        inlineContent3 = constructor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(645129368, $dirty, $dirty12, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:536)");
                    }
                    obj49 = 0;
                    empty = "CC(remember):BasicText.kt#9igjgp";
                    i = 1;
                    if (TextAnnotatedStringNodeKt.hasLinks(obj12)) {
                        $composer2.startReplaceGroup(-619323167);
                        ComposerKt.sourceInformation($composer2, "539@20954L38");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297072527, empty);
                        i25 = $dirty & 112 == 32 ? i : obj49;
                        constructor = $composer2;
                        i24 = 0;
                        it$iv5 = constructor.rememberedValue();
                        companion3 = 0;
                        if (i25 == 0) {
                            if (it$iv5 == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                it$iv = it$iv5;
                                it$iv5 = new TextLinkScope(obj12);
                                constructor.updateRememberedValue(it$iv5);
                            } else {
                                it$iv = it$iv5;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-619265198);
                        $composer2.endReplaceGroup();
                        it$iv5 = 0;
                    }
                    if (TextAnnotatedStringNodeKt.hasLinks(obj12)) {
                        $composer2.startReplaceGroup(-619074547);
                        ComposerKt.sourceInformation($composer2, "545@21203L90");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297064507, empty);
                        i16 = $dirty & 112 == 32 ? i : obj49;
                        $this$cache$iv2 = $composer2;
                        i22 = 0;
                        it$iv3 = $this$cache$iv2.rememberedValue();
                        companion = 0;
                        if (i16 |= changed6 == 0) {
                            if (it$iv3 == Composer.Companion.getEmpty()) {
                                empty3 = 0;
                                it$iv = it$iv3;
                                it$iv3 = new BasicTextKt.LayoutWithLinksAndInlineContent.styledText.1.1(it$iv5, obj12);
                                $this$cache$iv2.updateRememberedValue((Function0)it$iv3);
                            } else {
                                it$iv = it$iv3;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                        $dirty1 = $dirty12;
                    } else {
                        $composer2.startReplaceGroup(-618966357);
                        ComposerKt.sourceInformation($composer2, "548@21307L8");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297061261, empty);
                        i19 = $dirty & 112 == 32 ? i : obj49;
                        empty3 = $composer2;
                        $this$cache$iv2 = 0;
                        it$iv3 = empty3.rememberedValue();
                        i23 = 0;
                        if (i19 == 0) {
                            $dirty1 = $dirty12;
                            if (it$iv3 == Composer.Companion.getEmpty()) {
                                $dirty12 = 0;
                                companion = it$iv3;
                                it$iv3 = new BasicTextKt.LayoutWithLinksAndInlineContent.styledText.2.1(obj12);
                                empty3.updateRememberedValue((Function0)it$iv3);
                            } else {
                                companion = it$iv3;
                            }
                        } else {
                            $dirty1 = $dirty12;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    }
                    if (hasInlineContent) {
                        resolveInlineContent = AnnotatedStringResolveInlineContentKt.resolveInlineContent(obj12, inlineContent3);
                    } else {
                        $dirty12 = 0;
                        resolveInlineContent = new Pair($dirty12, $dirty12);
                    }
                    inlineComposables = resolveInlineContent.component2();
                    if (hasInlineContent) {
                        $composer2.startReplaceGroup(-618671702);
                        ComposerKt.sourceInformation($composer2, "558@21610L61");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297051512, empty);
                        $this$cache$iv2 = 0;
                        i22 = $composer2;
                        i23 = 0;
                        inlineContent2 = inlineContent3;
                        Object rememberedValue2 = i22.rememberedValue();
                        companion = 0;
                        anon2 = it$iv3;
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            it$iv = rememberedValue2;
                            obj59 = i52;
                            int it$iv7 = 0;
                            i22.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(it$iv7, it$iv7, 2, it$iv7));
                        } else {
                            it$iv4 = i22;
                            it$iv3 = it$iv;
                        }
                        $this$cache$iv = it$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    } else {
                        inlineContent2 = inlineContent3;
                        anon2 = it$iv3;
                        $composer2.startReplaceGroup(-618591630);
                        $composer2.endReplaceGroup();
                        $this$cache$iv = 0;
                    }
                    if (hasInlineContent) {
                        $composer2.startReplaceGroup(-618506565);
                        ComposerKt.sourceInformation($composer2, "562@21777L44");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297046185, empty);
                        Composer composer5 = $composer2;
                        i22 = 0;
                        it$iv6 = composer5.rememberedValue();
                        i23 = 0;
                        if (!$composer2.changed($this$cache$iv)) {
                            inlineComposables2 = inlineComposables;
                            if (it$iv6 == Composer.Companion.getEmpty()) {
                                inlineComposables = 0;
                                companion = it$iv6;
                                it$iv6 = new BasicTextKt.LayoutWithLinksAndInlineContent.onPlaceholderLayout.1.1($this$cache$iv);
                                composer5.updateRememberedValue((Function1)it$iv6);
                            } else {
                                companion = it$iv6;
                            }
                        } else {
                            inlineComposables2 = inlineComposables;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                        obj8 = $this$cache$iv2;
                    } else {
                        inlineComposables2 = inlineComposables;
                        $composer2.startReplaceGroup(-618442830);
                        $composer2.endReplaceGroup();
                        obj8 = 0;
                    }
                    ComposerKt.sourceInformationMarkerStart($composer2, -297029920, empty);
                    if ($dirty & 896 == 256) {
                    } else {
                        i = obj49;
                    }
                    changedInstance3 |= i;
                    Composer composer4 = $composer2;
                    empty4 = 0;
                    it$iv2 = composer4.rememberedValue();
                    int i96 = 0;
                    if (invalid$iv == 0) {
                        obj59 = invalid$iv;
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            invalid$iv = 0;
                            obj2 = it$iv2;
                            it$iv2 = new BasicTextKt.LayoutWithLinksAndInlineContent.2.1(it$iv5, obj7);
                            composer4.updateRememberedValue((Function1)it$iv2);
                        } else {
                            obj2 = it$iv2;
                        }
                    } else {
                        obj59 = invalid$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    textModifier-cFh6CEA = BasicTextKt.textModifier-cFh6CEA(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(obj9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj28, false, 0, 0, 0, obj33, 0, obj35), (AnnotatedString)anon2.invoke(), currentCompositionLocalMap, (Function1)it$iv2, currentCompositeKeyHash, anon, maxLines, minLines, fontFamilyResolver, (List)resolveInlineContent.component1(), obj8, selectionController, color, onShowTranslation);
                    if (!hasInlineContent) {
                        $composer2.startReplaceGroup(-617362851);
                        ComposerKt.sourceInformation($composer2, "595@22992L55");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297007294, empty);
                        composer2 = $composer2;
                        i4 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i27 = 0;
                        if (!$composer2.changedInstance(it$iv5)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty = 0;
                                anon4 = new BasicTextKt.LayoutWithLinksAndInlineContent.3.1(it$iv5);
                                composer2.updateRememberedValue((Function0)anon4);
                            } else {
                                anon4 = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        linksTextMeasurePolicy = new LinksTextMeasurePolicy((Function0)anon4);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-617202116);
                        ComposerKt.sourceInformation($composer2, "599@23147L55,600@23233L39");
                        ComposerKt.sourceInformationMarkerStart($composer2, -297002334, empty);
                        Composer composer3 = $composer2;
                        int i77 = 0;
                        Object rememberedValue4 = composer3.rememberedValue();
                        int i81 = 0;
                        if (!$composer2.changedInstance(it$iv5)) {
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                empty4 = 0;
                                anon = new BasicTextKt.LayoutWithLinksAndInlineContent.4.1(it$iv5);
                                composer3.updateRememberedValue((Function0)anon);
                            } else {
                                anon = rememberedValue4;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, -296999598, empty);
                        composer2 = $composer2;
                        i4 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i27 = 0;
                        if (!$composer2.changed($this$cache$iv)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty = 0;
                                anon4 = new BasicTextKt.LayoutWithLinksAndInlineContent.5.1($this$cache$iv);
                                composer2.updateRememberedValue((Function0)anon4);
                            } else {
                                anon4 = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        linksTextMeasurePolicy = new TextMeasurePolicy((Function0)anon, (Function0)anon4);
                        $composer2.endReplaceGroup();
                    }
                    obj9 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, obj49);
                    i24 = 0;
                    obj59 = $this$cache$iv;
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
                    it$iv = constructor-impl;
                    i28 = 0;
                    if (!it$iv.getInserting()) {
                        modifier$iv = textModifier-cFh6CEA;
                        i21 = linksTextMeasurePolicy;
                        if (!Intrinsics.areEqual(it$iv.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            it$iv.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = it$iv;
                        }
                    } else {
                        modifier$iv = textModifier-cFh6CEA;
                        i21 = linksTextMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($composer2, textModifier-cFh6CEA), ComposeUiNode.Companion.getSetModifier());
                    obj7 = $composer2;
                    empty2 = 0;
                    i6 = i31;
                    ComposerKt.sourceInformationMarkerStart(obj7, -515487512, "C:BasicText.kt#423gt5");
                    if (it$iv5 == null) {
                        obj7.startReplaceGroup(-515480539);
                        obj7.endReplaceGroup();
                    } else {
                        obj7.startReplaceGroup(537560924);
                        ComposerKt.sourceInformation(obj7, "567@21894L18");
                        it$iv5.LinksComposables(obj7, 0);
                        obj7.endReplaceGroup();
                        iNSTANCE = Unit.INSTANCE;
                    }
                    if (inlineComposables2 == null) {
                        obj7.startReplaceGroup(-515428893);
                        obj7.endReplaceGroup();
                        obj49 = it$iv5;
                    } else {
                        obj7.startReplaceGroup(-515428892);
                        ComposerKt.sourceInformation(obj7, "*569@21966L48");
                        i11 = 0;
                        obj49 = it$iv5;
                        AnnotatedStringResolveInlineContentKt.InlineChildren(obj12, inlineComposables2, obj7, companion3 & 14);
                        Unit it = Unit.INSTANCE;
                        obj7.endReplaceGroup();
                        iNSTANCE2 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj7);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj10 = inlineContent2;
                } else {
                    $composer2.skipToGroupEnd();
                    $dirty1 = $dirty12;
                    obj10 = constructor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = $composer2;
            i15 = $dirty;
            endRestartGroup = new BasicTextKt.LayoutWithLinksAndInlineContent.6(modifier, obj12, onTextLayout, hasInlineContent, obj10, style, overflow, softWrap, maxLines, minLines, fontFamilyResolver, selectionController, color, onShowTranslation, i95, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer3 = $composer2;
            i15 = $dirty;
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
        int i5;
        Object obj4;
        int i;
        ArrayList arrayList;
        Object obj5;
        int i7;
        int index$iv$iv;
        int size;
        Object obj3;
        int i4;
        Object obj2;
        int i3;
        Object obj;
        int i2;
        androidx.compose.foundation.text.TextRangeScopeMeasurePolicy measurePolicy;
        androidx.compose.foundation.text.TextRangeLayoutMeasureResult $this$measureWithTextRangeMeasureConstraints_u24lambda_u249_u24lambda_u248;
        androidx.compose.foundation.text.TextRangeLayoutMeasureScope textRangeLayoutMeasureScope;
        Object obj6;
        int i6;
        ArrayList list;
        Object obj7;
        if ((Boolean)shouldMeasureLinks.invoke().booleanValue()) {
            textRangeLayoutMeasureScope2 = new TextRangeLayoutMeasureScope();
            obj4 = measurables;
            i = 0;
            arrayList = new ArrayList(obj4.size());
            i7 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj4.size()) {
                i4 = index$iv$iv;
                i3 = 0;
                obj = obj2;
                i2 = 0;
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
                i = i6;
                arrayList = list;
                obj5 = obj7;
            }
            textRangeLayoutMeasureScope = textRangeLayoutMeasureScope2;
            obj6 = obj4;
            i6 = i;
            obj7 = obj5;
            i5 = list;
        } else {
            i5 = 0;
        }
        return i5;
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
