package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\u0008\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00142\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010'\u001a\u00020&2\u0014\u0008\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\u0008\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\u0008\u0008\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u00101\u001aÜ\u0001\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00142\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0014\u0008\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\u0008\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\u0008\u0008\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00103\u001aÆ\u0001\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00142\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0014\u0008\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\u0008\u0008\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u001aÒ\u0001\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00142\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010'\u001a\u00020&2\u0016\u0008\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0008\u0008\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00106\"\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00067", d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextKt {

    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle;
    static {
        TextKt.LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)TextKt.LocalTextStyle.1.INSTANCE);
    }

    public static final void ProvideTextStyle(TextStyle value, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int merge;
        int $dirty;
        int i2;
        int i;
        int traceInProgress;
        boolean traceInProgress2;
        int str2;
        int i3;
        String str;
        merge = -460300127;
        final Composer obj8 = $composer.startRestartGroup(merge);
        ComposerKt.sourceInformation(obj8, "C(ProvideTextStyle)P(1)347@14710L7,348@14735L80:Text.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i2 = obj8.changed(value) ? 4 : 2;
            $dirty |= i2;
        }
        if ($changed & 48 == 0) {
            i = obj8.changedInstance(content) ? 32 : 16;
            $dirty |= i;
        }
        if ($dirty & 19 == 18) {
            if (!obj8.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(merge, $dirty, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:346)");
                }
                int i4 = 6;
                int i5 = 0;
                ComposerKt.sourceInformationMarkerStart(obj8, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj8);
                CompositionLocalKt.CompositionLocalProvider(TextKt.LocalTextStyle.provides((TextStyle)obj8.consume((CompositionLocal)TextKt.LocalTextStyle).merge(value)), content, obj8, $stable |= i3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj8.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj8.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TextKt.ProvideTextStyle.1(value, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text--4IGK_g(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Map inlineContent, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj4;
        Object i10;
        int $dirty5;
        Object obj8;
        Object obj11;
        boolean traceInProgress;
        ScopeUpdateScope endRestartGroup;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress2;
        Object obj7;
        Object obj9;
        int textDecoration2;
        Object obj6;
        int i20;
        int $dirty13;
        int $dirty12;
        long $dirty14;
        Composer $composer2;
        int $dirty;
        long $dirty3;
        long l2;
        long modifier2;
        Object inlineContent2;
        Object inlineContent3;
        boolean softWrap3;
        Object obj2;
        Object obj12;
        int i;
        Object obj13;
        Object fontSize2;
        long fontStyle3;
        long l3;
        int obj5;
        int i7;
        long fontStyle2;
        Object obj;
        long fontSize3;
        int fontFamily2;
        int i26;
        Object obj10;
        int letterSpacing2;
        long modifier3;
        int i29;
        long l;
        int textAlign2;
        Object fontWeight2;
        int textAlign3;
        int maxLines2;
        int maxLines4;
        int i12;
        boolean lineHeight4;
        long letterSpacing4;
        long letterSpacing3;
        int i2;
        int i9;
        int i8;
        Object overflow2;
        Object onTextLayout3;
        int onTextLayout2;
        int changedInstance;
        Object softWrap2;
        boolean z;
        int i22;
        int $dirty1;
        int i30;
        Object maxLines3;
        long lineHeight3;
        int lineHeight2;
        int changed;
        boolean changed3;
        int i11;
        int overflow3;
        int overflow4;
        int i17;
        int style2;
        Object obj3;
        int i15;
        Composer composer;
        int i6;
        int i5;
        int i18;
        int i28;
        int i13;
        int i19;
        int i4;
        int i23;
        int i31;
        int $dirty4;
        int i24;
        int $dirty2;
        int i16;
        int i27;
        int i3;
        int i14;
        int changed2;
        ScopeUpdateScope scopeUpdateScope;
        int i25;
        int obj44;
        int obj45;
        int obj64;
        int i32 = obj65;
        int i35 = obj66;
        int i54 = obj67;
        $composer2 = obj64.startRestartGroup(224529679);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)304@13393L7,306@13409L345:Text.kt#uh7d8r");
        $dirty = obj65;
        int i89 = obj66;
        if (i54 & 1 != 0) {
            $dirty |= 6;
            obj2 = text;
        } else {
            if (i32 & 6 == 0) {
                i7 = $composer2.changed(text) ? 4 : 2;
                $dirty |= i7;
            } else {
                obj2 = text;
            }
        }
        int i94 = i54 & 2;
        if (i94 != 0) {
            $dirty |= 48;
            obj10 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i29 = $composer2.changed(modifier) ? 32 : 16;
                $dirty |= i29;
            } else {
                obj10 = modifier;
            }
        }
        textAlign2 = i54 & 4;
        int i96 = 128;
        if (textAlign2 != 0) {
            $dirty |= 384;
            i12 = i94;
            l3 = color;
        } else {
            if (i32 & 384 == 0) {
                i12 = i94;
                i2 = $composer2.changed(color) ? 256 : i96;
                $dirty |= i2;
            } else {
                i12 = i94;
                l3 = color;
            }
        }
        int i98 = i54 & 8;
        changedInstance = 1024;
        if (i98 != 0) {
            $dirty |= 3072;
            fontSize3 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i11 = $composer2.changed(fontStyle) ? i8 : changedInstance;
                $dirty |= i11;
            } else {
                fontSize3 = fontStyle;
            }
        }
        overflow3 = i54 & 16;
        int i109 = 8192;
        if (overflow3 != 0) {
            $dirty |= 24576;
            obj13 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i6 = $composer2.changed(fontFamily) ? i17 : i109;
                $dirty |= i6;
            } else {
                obj13 = fontFamily;
            }
        }
        i5 = i54 & 32;
        i28 = 196608;
        final int i110 = 65536;
        if (i5 != 0) {
            $dirty |= i28;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i28 == 0) {
                i19 = $composer2.changed(letterSpacing) ? i18 : i110;
                $dirty |= i19;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i111 = i54 & 64;
        final int i112 = 1572864;
        if (i111 != 0) {
            $dirty |= i112;
            obj6 = textDecoration;
        } else {
            if (i32 & i112 == 0) {
                i23 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty |= i23;
            } else {
                obj6 = textDecoration;
            }
        }
        int i33 = i54 & 128;
        int i113 = 12582912;
        if (i33 != 0) {
            $dirty4 = $dirty6;
            i31 = i89;
            $dirty3 = textAlign;
        } else {
            if (obj65 & i113 == 0) {
                i31 = i89;
                i16 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i115 |= i16;
            } else {
                $dirty4 = $dirty;
                i31 = i89;
                $dirty3 = textAlign;
            }
        }
        int i34 = i54 & 256;
        int i118 = 100663296;
        if (i34 != 0) {
            $dirty4 |= i118;
            i27 = i34;
            obj4 = overflow;
        } else {
            if (obj65 & i118 == 0) {
                i27 = i34;
                i3 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty4 |= i3;
            } else {
                i27 = i34;
                obj4 = overflow;
            }
        }
        i10 = i54 & 512;
        int i120 = 805306368;
        if (i10 != 0) {
            $dirty4 |= i120;
            i14 = i10;
        } else {
            if (obj65 & i120 == 0) {
                i14 = i10;
                changed2 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty4 |= changed2;
            } else {
                i14 = i10;
                i10 = softWrap;
            }
        }
        $dirty5 = $dirty4;
        int i82 = i54 & 1024;
        if (i82 != 0) {
            $dirty1 = i31 | 6;
            l2 = maxLines;
        } else {
        }
        i20 = i54 & 2048;
        if (i20 != 0) {
            $dirty1 |= 48;
            i24 = i20;
        } else {
            if (i35 & 48 == 0) {
                i24 = i20;
                i15 = $composer2.changed(onTextLayout) ? 32 : 16;
                $dirty1 |= i15;
            } else {
                i24 = i20;
                i20 = onTextLayout;
            }
        }
        $dirty13 = $dirty1;
        int i86 = i54 & 4096;
        if (i86 != 0) {
            $dirty13 |= 384;
            softWrap3 = style;
        } else {
            if (i35 & 384 == 0) {
                i13 = $composer2.changed(style) ? 256 : i96;
                $dirty13 |= i13;
            } else {
                softWrap3 = style;
            }
        }
        int i87 = i54 & 8192;
        if (i87 != 0) {
            $dirty13 |= 3072;
        } else {
            $dirty1 = $dirty13;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i8 = changedInstance;
                }
                $dirty12 = i8;
            } else {
                int i83 = $composer;
                $dirty12 = $dirty1;
            }
        }
        int i88 = i54 & 16384;
        if (i88 != 0) {
            $dirty12 |= 24576;
            obj7 = $changed;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed)) {
                } else {
                    i17 = i109;
                }
                $dirty12 |= i17;
            } else {
                obj7 = $changed;
            }
        }
        int i101 = obj67 & i100;
        if (i101 != 0) {
            $dirty12 |= i28;
            obj8 = $changed1;
        } else {
            if (i35 & i28 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i18 = i110;
                }
                $dirty12 |= i18;
            } else {
                obj8 = $changed1;
            }
        }
        if (obj66 & i112 == 0) {
            if (obj67 & i110 == 0) {
                i30 = $composer2.changed(i21) ? 1048576 : 524288;
            } else {
                obj11 = i21;
            }
            $dirty12 |= i30;
        } else {
            obj11 = i21;
        }
        if ($dirty5 & i104 == 306783378 && i36 &= $dirty12 == 599186) {
            if (i36 &= $dirty12 == 599186) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj65 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                obj10 = unspecified-0d7_KjU;
                            }
                            if (textAlign2 != 0) {
                                l3 = unspecified-0d7_KjU;
                            }
                            if (i98 != 0) {
                                fontSize3 = unspecified-0d7_KjU;
                            }
                            if (overflow3 != 0) {
                                obj13 = unspecified-0d7_KjU;
                            }
                            if (i5 != 0) {
                                fontWeight2 = unspecified-0d7_KjU;
                            }
                            this_$iv = i111 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing4 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing4 = textAlign;
                            }
                            textDecoration2 = i27 != 0 ? 0 : overflow;
                            textAlign2 = i14 != 0 ? 0 : softWrap;
                            if (i82 != 0) {
                                lineHeight3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight3 = maxLines;
                            }
                            if (i24 != 0) {
                                overflow4 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow4 = onTextLayout;
                            }
                            if (i86 != 0) {
                                softWrap3 = 1;
                            }
                            maxLines2 = i87 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            if (i88 != 0) {
                                inlineContent2 = MapsKt.emptyMap();
                            } else {
                                inlineContent2 = $changed;
                            }
                            if (i101 != 0) {
                                onTextLayout3 = TextKt.Text.6.INSTANCE;
                            } else {
                                onTextLayout3 = $changed1;
                            }
                            if (obj67 & i110 != 0) {
                                int i103 = 6;
                                int i108 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj3 = this_$iv;
                                $dirty12 = textDecoration2;
                                z = softWrap3;
                                softWrap3 = l3;
                                i17 = onTextLayout3;
                                onTextLayout2 = overflow4;
                                overflow3 = inlineContent2;
                                obj = obj13;
                                fontStyle3 = fontSize3;
                                inlineContent3 = obj10;
                                fontSize3 = fontWeight2;
                                i26 = obj44;
                                fontWeight2 = obj45;
                                maxLines4 = textAlign2;
                                modifier3 = letterSpacing4;
                                letterSpacing3 = lineHeight3;
                                lineHeight2 = i25;
                            } else {
                                obj64 = $dirty12;
                                obj3 = i21;
                                z = softWrap3;
                                softWrap3 = l3;
                                i17 = onTextLayout3;
                                onTextLayout2 = overflow4;
                                overflow3 = inlineContent2;
                                obj = obj13;
                                fontStyle3 = fontSize3;
                                inlineContent3 = obj10;
                                fontSize3 = fontWeight2;
                                i26 = obj44;
                                fontWeight2 = obj45;
                                maxLines4 = textAlign2;
                                modifier3 = letterSpacing4;
                                letterSpacing3 = lineHeight3;
                                lineHeight2 = i25;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj67 & i110 != 0) {
                                maxLines4 = softWrap;
                                letterSpacing3 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight2 = $composer;
                                overflow3 = $changed;
                                i17 = $changed1;
                                obj3 = i21;
                                $dirty12 = this_$iv;
                                z = softWrap3;
                                softWrap3 = l3;
                                inlineContent3 = obj10;
                                modifier3 = textAlign;
                                obj = obj13;
                                fontStyle3 = fontSize3;
                                fontSize3 = fontWeight2;
                                i26 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines4 = softWrap;
                                letterSpacing3 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight2 = $composer;
                                overflow3 = $changed;
                                i17 = $changed1;
                                obj3 = i21;
                                z = softWrap3;
                                softWrap3 = l3;
                                inlineContent3 = obj10;
                                modifier3 = textAlign;
                                obj = obj13;
                                fontStyle3 = fontSize3;
                                fontSize3 = fontWeight2;
                                i26 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(224529679, $dirty5, $dirty12, "androidx.compose.material3.Text (Text.kt:305)");
                    }
                    TextKt.Text-IbK3jfQ(text, inlineContent3, softWrap3, obj2, fontStyle3, l3, obj, fontSize3, i26, modifier3, textAlign2, fontWeight2, maxLines4, letterSpacing3, i98, onTextLayout2, z, lineHeight2, 1, overflow3, i17, obj3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj9 = inlineContent3;
                    style2 = $dirty12;
                    $dirty14 = softWrap3;
                    modifier2 = fontStyle3;
                    obj12 = obj;
                    fontSize2 = fontSize3;
                    obj5 = i26;
                    fontStyle2 = modifier3;
                    fontFamily2 = fontWeight2;
                    letterSpacing2 = maxLines4;
                    l = letterSpacing3;
                    textAlign3 = onTextLayout2;
                    lineHeight4 = z;
                    i9 = lineHeight2;
                    overflow2 = overflow3;
                    softWrap2 = i17;
                    maxLines3 = i25;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign3 = onTextLayout;
                    i9 = $composer;
                    overflow2 = $changed;
                    softWrap2 = $changed1;
                    maxLines3 = i21;
                    style2 = $dirty12;
                    composer = $composer2;
                    lineHeight4 = softWrap3;
                    obj12 = obj13;
                    $dirty14 = l3;
                    modifier2 = fontSize3;
                    obj9 = obj10;
                    fontSize2 = fontWeight2;
                    obj5 = textDecoration;
                    fontStyle2 = textAlign;
                    fontFamily2 = overflow;
                    letterSpacing2 = softWrap;
                    l = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty5;
            $dirty5 = new TextKt.Text.7(text, obj9, $dirty14, $composer2, modifier2, softWrap3, obj12, fontSize2, obj5, fontStyle2, fontSize3, fontFamily2, letterSpacing2, l, fontWeight2, textAlign3, lineHeight4, i9, overflow2, softWrap2, maxLines3, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)$dirty5);
        } else {
            $dirty2 = $dirty5;
        }
    }

    public static final void Text--4IGK_g(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj8;
        Object i20;
        int traceInProgress;
        Object endRestartGroup;
        int unspecified-e0LSkKk;
        Object obj12;
        Object obj2;
        boolean skipping;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress2;
        long consume;
        int i39;
        Object obj11;
        int textDecoration2;
        Object obj9;
        int i47;
        int $dirty12;
        int $dirty15;
        long $dirty1;
        int $dirty;
        long $dirty2;
        long l5;
        long minLines2;
        int minLines3;
        boolean z;
        Object obj7;
        Object obj15;
        int i23;
        Object obj10;
        Object obj3;
        long l3;
        int color2;
        int i11;
        long l;
        long l6;
        int obj4;
        int i30;
        Object obj14;
        int modifier2;
        int i5;
        long textAlign2;
        int textAlign3;
        Object obj13;
        int maxLines2;
        int maxLines3;
        int letterSpacing2;
        boolean z2;
        int cmp;
        int i17;
        int i12;
        int i26;
        int i16;
        int onTextLayout3;
        int onTextLayout2;
        int changed3;
        int obj5;
        int $this$takeOrElse_u2dDxMtmZc$iv;
        int i24;
        int $dirty14;
        int i13;
        Object obj;
        long lineHeight2;
        int changed4;
        boolean changed2;
        int i31;
        int overflow2;
        int i10;
        Composer composer;
        int i25;
        int i43;
        int i32;
        int i8;
        int i38;
        int i27;
        int i40;
        int i3;
        int i34;
        int $dirty13;
        int $dirty3;
        int i9;
        int $dirty4;
        int i48;
        int i44;
        int i33;
        int i28;
        int changed;
        Object obj6;
        int i6;
        int i14;
        int i4;
        long l4;
        int i37;
        int i;
        int i49;
        int i29;
        int i41;
        int i18;
        int i15;
        int i35;
        int i45;
        long l2;
        int i36;
        int i7;
        int i46;
        int i42;
        int i22;
        int i50;
        int i19;
        int i2;
        ScopeUpdateScope scopeUpdateScope;
        int obj69;
        int obj70;
        TextStyle obj71;
        int obj72;
        int obj73;
        boolean obj74;
        int obj75;
        int obj76;
        int obj77;
        Composer obj78;
        int obj79;
        int obj80;
        int obj89;
        int i51 = obj90;
        int i54 = obj91;
        int i64 = obj92;
        Composer restartGroup = obj89.startRestartGroup(-2055108902);
        ComposerKt.sourceInformation(restartGroup, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)108@5620L7,113@5732L530:Text.kt#uh7d8r");
        $dirty = obj90;
        int i87 = obj91;
        if (i64 & 1 != 0) {
            $dirty |= 6;
            obj7 = text;
        } else {
            if (i51 & 6 == 0) {
                i11 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i11;
            } else {
                obj7 = text;
            }
        }
        int i98 = i64 & 2;
        if (i98 != 0) {
            $dirty |= 48;
            obj14 = modifier;
        } else {
            if (i51 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i5;
            } else {
                obj14 = modifier;
            }
        }
        int i101 = i64 & 4;
        int i102 = 128;
        if (i101 != 0) {
            $dirty |= 384;
            letterSpacing2 = i98;
            l3 = color;
        } else {
            if (i51 & 384 == 0) {
                letterSpacing2 = i98;
                i17 = restartGroup.changed(color) ? 256 : i102;
                $dirty |= i17;
            } else {
                letterSpacing2 = i98;
                l3 = color;
            }
        }
        int i105 = i64 & 8;
        changed3 = 1024;
        if (i105 != 0) {
            $dirty |= 3072;
            l6 = fontStyle;
        } else {
            if (i51 & 3072 == 0) {
                i31 = restartGroup.changed(fontStyle) ? i16 : changed3;
                $dirty |= i31;
            } else {
                l6 = fontStyle;
            }
        }
        overflow2 = i64 & 16;
        int i108 = 8192;
        if (overflow2 != 0) {
            $dirty |= 24576;
            obj10 = fontFamily;
        } else {
            if (i51 & 24576 == 0) {
                i32 = restartGroup.changed(fontFamily) ? i10 : i108;
                $dirty |= i32;
            } else {
                obj10 = fontFamily;
            }
        }
        int i109 = i64 & 32;
        final int i110 = 196608;
        final int i111 = 65536;
        if (i109 != 0) {
            $dirty |= i110;
            obj13 = letterSpacing;
        } else {
            if (i51 & i110 == 0) {
                i27 = restartGroup.changed(letterSpacing) ? i8 : i111;
                $dirty |= i27;
            } else {
                obj13 = letterSpacing;
            }
        }
        int i112 = i64 & 64;
        final int i113 = 1572864;
        if (i112 != 0) {
            $dirty |= i113;
            obj9 = textDecoration;
        } else {
            if (i51 & i113 == 0) {
                i3 = restartGroup.changed(textDecoration) ? 1048576 : 524288;
                $dirty |= i3;
            } else {
                obj9 = textDecoration;
            }
        }
        int i52 = i64 & 128;
        int i114 = 12582912;
        if (i52 != 0) {
            $dirty3 = $dirty6;
            i34 = i87;
            $dirty2 = textAlign;
        } else {
            if (obj90 & i114 == 0) {
                i34 = i87;
                i48 = restartGroup.changed(textAlign) ? 8388608 : 4194304;
                i116 |= i48;
            } else {
                $dirty3 = $dirty;
                i34 = i87;
                $dirty2 = textAlign;
            }
        }
        int i118 = i52;
        int i53 = i64 & 256;
        int i119 = 100663296;
        if (i53 != 0) {
            $dirty3 |= i119;
            i44 = i53;
            obj8 = overflow;
        } else {
            if (obj90 & i119 == 0) {
                i44 = i53;
                i33 = restartGroup.changed(overflow) ? 67108864 : 33554432;
                $dirty3 |= i33;
            } else {
                i44 = i53;
                obj8 = overflow;
            }
        }
        i20 = i64 & 512;
        int i121 = 805306368;
        if (i20 != 0) {
            $dirty3 |= i121;
            i28 = i20;
        } else {
            if (obj90 & i121 == 0) {
                i28 = i20;
                changed = restartGroup.changed(softWrap) ? 536870912 : 268435456;
                $dirty3 |= changed;
            } else {
                i28 = i20;
                i20 = softWrap;
            }
        }
        traceInProgress = $dirty3;
        int i80 = i64 & 1024;
        if (i80 != 0) {
            $dirty14 = i34 | 6;
            l5 = maxLines;
        } else {
        }
        i47 = i64 & 2048;
        if (i47 != 0) {
            $dirty14 |= 48;
            i9 = i47;
        } else {
            if (i54 & 48 == 0) {
                i9 = i47;
                i25 = restartGroup.changed(onTextLayout) ? 32 : 16;
                $dirty14 |= i25;
            } else {
                i9 = i47;
                i47 = onTextLayout;
            }
        }
        $dirty12 = $dirty14;
        int i84 = i64 & 4096;
        if (i84 != 0) {
            $dirty12 |= 384;
            z = style;
        } else {
            if (i54 & 384 == 0) {
                i38 = restartGroup.changed(style) ? 256 : i102;
                $dirty12 |= i38;
            } else {
                z = style;
            }
        }
        int i85 = i64 & 8192;
        if (i85 != 0) {
            $dirty12 |= 3072;
        } else {
            $dirty14 = $dirty12;
            if (i54 & 3072 == 0) {
                if (restartGroup.changed($composer)) {
                } else {
                    i16 = changed3;
                }
                $dirty15 = i16;
            } else {
                int i81 = $composer;
                $dirty15 = $dirty14;
            }
        }
        int i86 = i64 & 16384;
        if (i86 != 0) {
            $dirty15 |= 24576;
            i39 = $changed;
        } else {
            if (i54 & 24576 == 0) {
                if (restartGroup.changed($changed)) {
                } else {
                    i10 = i108;
                }
                $dirty15 |= i10;
            } else {
                i39 = $changed;
            }
        }
        $this$takeOrElse_u2dDxMtmZc$iv = obj92 & i107;
        if ($this$takeOrElse_u2dDxMtmZc$iv != 0) {
            $dirty15 |= i110;
            obj12 = $changed1;
        } else {
            if (i54 & i110 == 0) {
                if (restartGroup.changedInstance($changed1)) {
                } else {
                    i8 = i111;
                }
                $dirty15 |= i8;
            } else {
                obj12 = $changed1;
            }
        }
        if (obj91 & i113 == 0) {
            if (obj92 & i111 == 0) {
                i13 = restartGroup.changed(i21) ? 1048576 : 524288;
            } else {
                obj2 = i21;
            }
            $dirty15 |= i13;
        } else {
            obj2 = i21;
        }
        if (traceInProgress & lineHeight2 == 306783378 && i55 &= $dirty15 == 599186) {
            if (i55 &= $dirty15 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj90 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (letterSpacing2 != 0) {
                                obj14 = unspecified-0d7_KjU;
                            }
                            if (i101 != 0) {
                                l3 = unspecified-0d7_KjU;
                            }
                            if (i105 != 0) {
                                l6 = unspecified-0d7_KjU;
                            }
                            if (overflow2 != 0) {
                                obj10 = unspecified-0d7_KjU;
                            }
                            if (i109 != 0) {
                                obj13 = unspecified-0d7_KjU;
                            }
                            this_$iv = i112 != 0 ? 0 : textDecoration;
                            if (i118 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i44 != 0 ? 0 : overflow;
                            textAlign3 = i28 != 0 ? 0 : softWrap;
                            if (i80 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i9 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = onTextLayout;
                            }
                            if (i84 != 0) {
                                z = 1;
                            }
                            maxLines3 = i85 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            minLines3 = i86 != 0 ? 1 : $changed;
                            onTextLayout2 = $this$takeOrElse_u2dDxMtmZc$iv != 0 ? 0 : $changed1;
                            if (obj92 & i111 != 0) {
                                $this$takeOrElse_u2dDxMtmZc$iv = 6;
                                i10 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                i14 = obj69;
                                i41 = obj70;
                                $dirty13 = this_$iv;
                                $dirty15 = textDecoration2;
                                obj6 = obj10;
                                i44 = l6;
                                changed = obj13;
                                l4 = letterSpacing2;
                                l2 = lineHeight2;
                            } else {
                                obj89 = $dirty15;
                                i14 = obj69;
                                i41 = obj70;
                                $dirty13 = i21;
                                obj6 = obj10;
                                i44 = l6;
                                changed = obj13;
                                l4 = letterSpacing2;
                                l2 = lineHeight2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (obj92 & i111 != 0) {
                                i14 = textDecoration;
                                l4 = textAlign;
                                i41 = overflow;
                                textAlign3 = softWrap;
                                l2 = maxLines;
                                overflow2 = onTextLayout;
                                maxLines3 = $composer;
                                minLines3 = $changed;
                                onTextLayout2 = $changed1;
                                $dirty13 = i21;
                                $dirty15 = this_$iv;
                                obj6 = obj10;
                                i44 = l6;
                                changed = obj13;
                            } else {
                                i14 = textDecoration;
                                l4 = textAlign;
                                i41 = overflow;
                                textAlign3 = softWrap;
                                l2 = maxLines;
                                overflow2 = onTextLayout;
                                maxLines3 = $composer;
                                minLines3 = $changed;
                                onTextLayout2 = $changed1;
                                $dirty13 = i21;
                                obj6 = obj10;
                                i44 = l6;
                                changed = obj13;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2055108902, traceInProgress, $dirty15, "androidx.compose.material3.Text (Text.kt:109)");
                    }
                    restartGroup.startReplaceGroup(-1827892941);
                    ComposerKt.sourceInformation(restartGroup, "");
                    consume = l3;
                    int i92 = 0;
                    obj13 = 0;
                    cmp = Long.compare(l6, i104) != 0 ? i26 : 0;
                    if (cmp != 0) {
                        obj89 = traceInProgress;
                        i9 = consume;
                    } else {
                        l6 = 0;
                        restartGroup.startReplaceGroup(-1827892168);
                        ComposerKt.sourceInformation(restartGroup, "*111@5715L7");
                        i30 = 0;
                        obj13 = 0;
                        if (Long.compare(i10, i25) != 0) {
                        } else {
                            i26 = 0;
                        }
                        if (i26 != 0) {
                            obj89 = traceInProgress;
                            obj69 = consume;
                        } else {
                            obj13 = 0;
                            obj89 = traceInProgress;
                            cmp = 6;
                            i26 = 0;
                            obj69 = consume;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $this$takeOrElse_u2dDxMtmZc$iv = traceInProgress;
                        }
                        restartGroup.endReplaceGroup();
                        i9 = $this$takeOrElse_u2dDxMtmZc$iv;
                    }
                    restartGroup.endReplaceGroup();
                    if (textAlign3 != 0) {
                        unspecified-e0LSkKk = textAlign3.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    obj78 = restartGroup;
                    BasicTextKt.BasicText-VhcvRP8(obj7, obj14, TextStyle.merge-dA7vx0o$default($dirty13, i9, i118, i44, i28, changed, obj6, 0, i14, 0, l4, obj46, 0, 0, 0, 0, obj51, i41, 0, 0, unspecified-e0LSkKk, 0, l2, obj58, 0, 0, 0), onTextLayout2, overflow2, z, maxLines3, minLines3, 0, obj78, i63 |= i76, 256);
                    composer = obj78;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i43 = $dirty15;
                    z2 = z;
                    $dirty1 = l3;
                    obj11 = obj14;
                    modifier2 = textAlign3;
                    i12 = maxLines3;
                    obj5 = onTextLayout2;
                    maxLines2 = overflow2;
                    obj = $dirty13;
                    obj3 = changed;
                    obj15 = obj6;
                    color2 = i14;
                    l = l4;
                    obj4 = i41;
                    textAlign2 = l2;
                    onTextLayout3 = minLines3;
                    minLines2 = i44;
                } else {
                    restartGroup.skipToGroupEnd();
                    maxLines2 = onTextLayout;
                    i12 = $composer;
                    onTextLayout3 = $changed;
                    obj5 = $changed1;
                    obj = i21;
                    obj89 = traceInProgress;
                    i43 = $dirty15;
                    composer = restartGroup;
                    z2 = z;
                    obj15 = obj10;
                    $dirty1 = l3;
                    minLines2 = l6;
                    obj11 = obj14;
                    obj3 = obj13;
                    color2 = textDecoration;
                    l = textAlign;
                    obj4 = overflow;
                    modifier2 = softWrap;
                    textAlign2 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = obj89;
            endRestartGroup = new TextKt.Text.1(text, obj11, $dirty1, restartGroup, minLines2, z, obj15, obj3, color2, l, l6, obj4, modifier2, textAlign2, obj13, maxLines2, z2, i12, onTextLayout3, obj5, obj, obj90, obj91, obj92);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty4 = obj89;
        }
    }

    public static final void Text-IbK3jfQ(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i22) {
        Object obj2;
        Object i42;
        long unbox-impl;
        int unspecified-e0LSkKk;
        Object endRestartGroup;
        Object obj9;
        Object obj10;
        Object obj;
        int skipping;
        int textAlign4;
        Object consume;
        int unspecified-XSAIIZE;
        long letterSpacing2;
        int i30;
        int i8;
        int overflow3;
        Object maxLines4;
        long inlineContent2;
        int $dirty4;
        long $dirty3;
        long l4;
        boolean z;
        int $dirty1;
        int $dirty13;
        int $dirty12;
        int $dirty14;
        int i12;
        int minLines3;
        int minLines4;
        long minLines2;
        Object traceInProgress2;
        int i29;
        Object obj6;
        int fontStyle2;
        long l3;
        Object color2;
        int i13;
        Object obj3;
        long anon;
        Object fontSize2;
        long l;
        Object obj4;
        Object obj12;
        int modifier2;
        int i18;
        Object textDecoration2;
        int textDecoration3;
        int style2;
        Object obj7;
        int fontWeight2;
        long l2;
        Object i16;
        boolean traceInProgress;
        int i2;
        long textAlign2;
        int textAlign3;
        int fontSize3;
        int i39;
        int overflow2;
        int i21;
        int i4;
        Object maxLines2;
        int maxLines3;
        int fontWeight3;
        int changed5;
        Object inlineContent4;
        Object inlineContent3;
        int fontStyle3;
        int changed;
        int softWrap2;
        int i10;
        Map softWrap3;
        int i40;
        int $dirty15;
        Object onTextLayout3;
        Object onTextLayout2;
        androidx.compose.material3.TextKt.Text.4 fontFamily2;
        int i23;
        int i25;
        int i5;
        Object obj8;
        int i6;
        long i14;
        int i3;
        int i36;
        int lineHeight2;
        int changed4;
        int textColor;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i35;
        Composer composer;
        long $this$takeOrElse_u2dDxMtmZc$iv2;
        int i15;
        int i41;
        int cmp;
        int changed2;
        int i;
        long i24;
        int i28;
        int i19;
        int i7;
        int i26;
        int i33;
        int $dirty16;
        int $dirty2;
        int i17;
        int $dirty;
        int i27;
        int i38;
        int i20;
        int i11;
        int i32;
        int changed3;
        int i34;
        int i31;
        int i9;
        int i37;
        ScopeUpdateScope scopeUpdateScope;
        Object obj11;
        Object obj5;
        long obj49;
        int obj50;
        int obj51;
        androidx.compose.material3.TextKt.Text.4 obj52;
        int obj53;
        int obj54;
        int obj55;
        int obj56;
        Map obj57;
        int obj58;
        Composer obj59;
        int obj60;
        int obj61;
        int obj62;
        int obj70;
        int i43 = obj71;
        int i54 = obj72;
        int i60 = obj73;
        Composer restartGroup = obj70.startRestartGroup(2027001676);
        ComposerKt.sourceInformation(restartGroup, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)254@11726L7,258@11837L706:Text.kt#uh7d8r");
        $dirty4 = obj71;
        int i86 = obj72;
        if (i60 & 1 != 0) {
            $dirty4 |= 6;
            traceInProgress2 = text;
        } else {
            if (i43 & 6 == 0) {
                i13 = restartGroup.changed(text) ? 4 : 2;
                $dirty4 |= i13;
            } else {
                traceInProgress2 = text;
            }
        }
        int i95 = i60 & 2;
        if (i95 != 0) {
            $dirty4 |= 48;
            obj12 = modifier;
        } else {
            if (i43 & 48 == 0) {
                i18 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty4 |= i18;
            } else {
                obj12 = modifier;
            }
        }
        int i97 = i60 & 4;
        if (i97 != 0) {
            $dirty4 |= 384;
            i2 = i95;
            l3 = color;
        } else {
            if (i43 & 384 == 0) {
                i2 = i95;
                i39 = restartGroup.changed(color) ? 256 : 128;
                $dirty4 |= i39;
            } else {
                i2 = i95;
                l3 = color;
            }
        }
        overflow2 = i60 & 8;
        changed5 = 1024;
        if (overflow2 != 0) {
            $dirty4 |= 3072;
            anon = fontStyle;
        } else {
            if (i43 & 3072 == 0) {
                i23 = restartGroup.changed(fontStyle) ? i4 : changed5;
                $dirty4 |= i23;
            } else {
                anon = fontStyle;
            }
        }
        i25 = i60 & 16;
        i3 = 8192;
        if (i25 != 0) {
            $dirty4 |= 24576;
            obj6 = fontFamily;
        } else {
            if (i43 & 24576 == 0) {
                i35 = restartGroup.changed(fontFamily) ? i6 : i3;
                $dirty4 |= i35;
            } else {
                obj6 = fontFamily;
            }
        }
        int i111 = i60 & 32;
        int i113 = 65536;
        i41 = 196608;
        cmp = 131072;
        if (i111 != 0) {
            $dirty4 |= i41;
            obj7 = letterSpacing;
        } else {
            if (i43 & i41 == 0) {
                i = restartGroup.changed(letterSpacing) ? cmp : i113;
                $dirty4 |= i;
            } else {
                obj7 = letterSpacing;
            }
        }
        i28 = i60 & 64;
        i19 = 1572864;
        if (i28 != 0) {
            $dirty4 |= i19;
            i16 = textDecoration;
        } else {
            if (i43 & i19 == 0) {
                i26 = restartGroup.changed(textDecoration) ? 1048576 : 524288;
                $dirty4 |= i26;
            } else {
                i16 = textDecoration;
            }
        }
        int i44 = i60 & 128;
        i33 = 12582912;
        if (i44 != 0) {
            $dirty2 = $dirty6;
            $dirty16 = i86;
            $dirty3 = textAlign;
        } else {
            if (obj71 & i33 == 0) {
                $dirty16 = i86;
                i27 = restartGroup.changed(textAlign) ? 8388608 : 4194304;
                i116 |= i27;
            } else {
                $dirty2 = $dirty4;
                $dirty16 = i86;
                $dirty3 = textAlign;
            }
        }
        int i45 = i60 & 256;
        int i117 = 100663296;
        if (i45 != 0) {
            $dirty2 |= i117;
            i20 = i45;
            obj2 = overflow;
        } else {
            if (obj71 & i117 == 0) {
                i20 = i45;
                i11 = restartGroup.changed(overflow) ? 67108864 : 33554432;
                $dirty2 |= i11;
            } else {
                i20 = i45;
                obj2 = overflow;
            }
        }
        i42 = i60 & 512;
        int i119 = 805306368;
        if (i42 != 0) {
            $dirty2 |= i119;
            i32 = i42;
        } else {
            if (obj71 & i119 == 0) {
                i32 = i42;
                changed3 = restartGroup.changed(softWrap) ? 536870912 : 268435456;
                $dirty2 |= changed3;
            } else {
                i32 = i42;
                i42 = softWrap;
            }
        }
        unbox-impl = $dirty2;
        int i81 = i60 & 1024;
        if (i81 != 0) {
            i17 = i81;
            $dirty16 = $dirty14;
            l4 = maxLines;
        } else {
            $dirty14 = i54 & 6;
            if ($dirty14 == 0) {
                i17 = i81;
                i40 = restartGroup.changed(maxLines) ? 4 : 2;
                $dirty16 = changed;
            } else {
                i17 = i81;
                l4 = maxLines;
            }
        }
        int i82 = i60 & 2048;
        if (i82 != 0) {
            $dirty16 |= 48;
            i12 = inlineContent;
        } else {
            if (i54 & 48 == 0) {
                textColor = restartGroup.changed(inlineContent) ? 32 : 16;
                $dirty16 |= textColor;
            } else {
                i12 = inlineContent;
            }
        }
        int i83 = $dirty16;
        int i87 = i60 & 4096;
        if (i87 != 0) {
            i83 |= 384;
        } else {
            if (i54 & 384 == 0) {
                changed2 = restartGroup.changed(onTextLayout) ? 256 : 128;
                $dirty15 |= changed2;
            } else {
                z = onTextLayout;
            }
            $dirty1 = $dirty15;
        }
        int i88 = i60 & 8192;
        if (i88 != 0) {
            $dirty1 |= 3072;
        } else {
            textColor = $dirty1;
            if (i54 & 3072 == 0) {
                if (restartGroup.changed(style)) {
                } else {
                    i4 = changed5;
                }
                $dirty13 = i4;
            } else {
                int i84 = style;
                $dirty13 = textColor;
            }
        }
        int i89 = i60 & 16384;
        if (i89 != 0) {
            $dirty13 |= 24576;
            i30 = $composer;
        } else {
            if (i54 & 24576 == 0) {
                if (restartGroup.changed($composer)) {
                } else {
                    i6 = i3;
                }
                $dirty13 |= i6;
            } else {
                i30 = $composer;
            }
        }
        int i100 = obj73 & i99;
        if (i100 != 0) {
            $dirty13 |= i41;
            obj9 = $changed;
        } else {
            if (i54 & i41 == 0) {
                i6 = restartGroup.changedInstance($changed) ? cmp : i113;
                $dirty13 |= i6;
            } else {
                obj9 = $changed;
            }
        }
        i14 = obj73 & i113;
        if (i14 != 0) {
            $dirty13 |= i19;
            obj10 = $changed1;
        } else {
            if (obj72 & i19 == 0) {
                i3 = restartGroup.changedInstance($changed1) ? 1048576 : 524288;
                $dirty13 |= i3;
            } else {
                obj10 = $changed1;
            }
        }
        if (obj72 & i33 == 0) {
            if (obj73 & cmp == 0) {
                i36 = restartGroup.changed(i22) ? 8388608 : 4194304;
            } else {
                obj = i22;
            }
            $dirty13 |= i36;
        } else {
            obj = i22;
        }
        if (unbox-impl & lineHeight2 == 306783378 && i59 &= $dirty13 == 4793490) {
            if (i59 &= $dirty13 == 4793490) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj71 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i2 != 0) {
                                obj12 = unspecified-XSAIIZE;
                            }
                            if (i97 != 0) {
                                l3 = unspecified-XSAIIZE;
                            }
                            if (overflow2 != 0) {
                                anon = unspecified-XSAIIZE;
                            }
                            if (i25 != 0) {
                                obj6 = unspecified-XSAIIZE;
                            }
                            if (i111 != 0) {
                                obj7 = unspecified-XSAIIZE;
                            }
                            if (i28 != 0) {
                                i16 = unspecified-XSAIIZE;
                            }
                            if (i44 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration3 = i20 != 0 ? 0 : overflow;
                            textAlign3 = i32 != 0 ? 0 : softWrap;
                            if (i17 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i82 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = inlineContent;
                            }
                            softWrap2 = i87 != 0 ? 1 : onTextLayout;
                            maxLines3 = i88 != 0 ? 0x7fffffff /* Unknown resource */ : style;
                            minLines4 = i89 != 0 ? 1 : $composer;
                            if (i100 != 0) {
                                inlineContent3 = MapsKt.emptyMap();
                            } else {
                                inlineContent3 = $changed;
                            }
                            if (i14 != 0) {
                                onTextLayout2 = TextKt.Text.4.INSTANCE;
                            } else {
                                onTextLayout2 = $changed1;
                            }
                            if (obj73 & cmp != 0) {
                                i25 = 0;
                                obj51 = i75;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                changed2 = textDecoration3;
                                $dirty12 = softWrap2;
                                $dirty16 = lineHeight2;
                                i14 = obj49;
                                textDecoration2 = this_$iv;
                                textAlign4 = textAlign3;
                                fontWeight2 = i77;
                                overflow3 = overflow2;
                                textAlign2 = anon;
                                fontSize2 = inlineContent3;
                                obj4 = onTextLayout2;
                                inlineContent4 = obj6;
                                onTextLayout3 = i16;
                                fontStyle2 = minLines4;
                                minLines3 = maxLines3;
                                maxLines2 = obj11;
                            } else {
                                changed2 = textDecoration3;
                                textAlign4 = textAlign3;
                                overflow3 = overflow2;
                                $dirty12 = softWrap2;
                                $dirty16 = lineHeight2;
                                i14 = obj49;
                                textDecoration2 = i22;
                                textAlign2 = anon;
                                fontSize2 = inlineContent3;
                                obj4 = onTextLayout2;
                                inlineContent4 = obj6;
                                onTextLayout3 = i16;
                                fontStyle2 = minLines4;
                                minLines3 = maxLines3;
                                maxLines2 = obj7;
                                fontWeight2 = obj70;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (obj73 & cmp != 0) {
                                i14 = textAlign;
                                changed2 = overflow;
                                $dirty16 = maxLines;
                                overflow3 = inlineContent;
                                $dirty12 = onTextLayout;
                                minLines3 = style;
                                textDecoration2 = i22;
                                inlineContent4 = obj6;
                                textAlign2 = anon;
                                maxLines2 = obj7;
                                onTextLayout3 = i16;
                                fontStyle2 = $composer;
                                fontSize2 = $changed;
                                obj4 = $changed1;
                                fontWeight2 = i57;
                                textAlign4 = softWrap;
                            } else {
                                i14 = textAlign;
                                changed2 = overflow;
                                textAlign4 = softWrap;
                                $dirty16 = maxLines;
                                overflow3 = inlineContent;
                                minLines3 = style;
                                textDecoration2 = i22;
                                inlineContent4 = obj6;
                                textAlign2 = anon;
                                maxLines2 = obj7;
                                onTextLayout3 = i16;
                                fontStyle2 = $composer;
                                fontSize2 = $changed;
                                obj4 = $changed1;
                                fontWeight2 = $dirty13;
                                $dirty12 = onTextLayout;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj62 = textAlign4;
                        ComposerKt.traceEventStart(2027001676, unbox-impl, fontWeight2, "androidx.compose.material3.Text (Text.kt:255)");
                    } else {
                        obj62 = textAlign4;
                    }
                    restartGroup.startReplaceGroup(-1827697581);
                    ComposerKt.sourceInformation(restartGroup, "");
                    consume = 0;
                    i16 = 0;
                    i10 = Long.compare($this$takeOrElse_u2dDxMtmZc$iv2, i24) != 0 ? i5 : 0;
                    if (i10 != 0) {
                        obj70 = unbox-impl;
                        obj53 = overflow3;
                    } else {
                        i16 = 0;
                        obj70 = unbox-impl;
                        restartGroup.startReplaceGroup(-1827696808);
                        ComposerKt.sourceInformation(restartGroup, "*256@11820L7");
                        i10 = 0;
                        if (Long.compare(i24, i7) != 0) {
                        } else {
                            i5 = 0;
                        }
                        if (i5 != 0) {
                            obj50 = consume;
                            obj53 = overflow3;
                        } else {
                            i10 = 0;
                            obj49 = unbox-impl;
                            i5 = 6;
                            cmp = 0;
                            obj50 = consume;
                            obj53 = overflow3;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $this$takeOrElse_u2dDxMtmZc$iv2 = unbox-impl;
                        }
                        restartGroup.endReplaceGroup();
                        $this$takeOrElse_u2dDxMtmZc$iv = $this$takeOrElse_u2dDxMtmZc$iv2;
                    }
                    restartGroup.endReplaceGroup();
                    if (obj62 != null) {
                        unspecified-e0LSkKk = obj62.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    skipping = fontWeight2;
                    obj59 = restartGroup;
                    obj54 = $dirty12;
                    obj55 = minLines3;
                    obj56 = fontStyle2;
                    obj57 = fontSize2;
                    obj52 = obj4;
                    BasicTextKt.BasicText-RWo7tUw(traceInProgress2, obj12, TextStyle.merge-dA7vx0o$default(textDecoration2, $this$takeOrElse_u2dDxMtmZc$iv, i16, textAlign2, overflow2, maxLines2, inlineContent4, 0, onTextLayout3, 0, i14, lineHeight2, 0, 0, 0, 0, cmp, changed2, 0, 0, unspecified-e0LSkKk, 0, $dirty16, i17, 0, 0, 0), obj52, obj53, obj54, obj55, obj56, obj57, 0, obj59, i52 |= i72, 512);
                    composer = obj59;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i15 = skipping;
                    obj8 = textDecoration2;
                    obj6 = inlineContent4;
                    l = i14;
                    l2 = $dirty16;
                    style2 = obj62;
                    fontStyle3 = i90;
                    minLines2 = textAlign2;
                    i21 = i109;
                    fontSize3 = unbox-impl;
                    softWrap3 = map;
                    fontWeight3 = i74;
                    maxLines4 = obj12;
                    modifier2 = changed2;
                    fontFamily2 = $dirty13;
                    inlineContent2 = l3;
                    color2 = obj11;
                    obj3 = obj5;
                } else {
                    restartGroup.skipToGroupEnd();
                    style2 = softWrap;
                    fontSize3 = inlineContent;
                    i21 = onTextLayout;
                    fontWeight3 = style;
                    fontStyle3 = $composer;
                    softWrap3 = $changed;
                    fontFamily2 = $changed1;
                    obj8 = i22;
                    obj70 = unbox-impl;
                    composer = restartGroup;
                    i15 = $dirty13;
                    inlineContent2 = l3;
                    minLines2 = anon;
                    maxLines4 = obj12;
                    color2 = obj7;
                    obj3 = i16;
                    l = textAlign;
                    modifier2 = overflow;
                    l2 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = obj70;
            endRestartGroup = new TextKt.Text.5(text, maxLines4, inlineContent2, $dirty13, minLines2, traceInProgress2, obj6, color2, obj3, l, obj4, modifier2, style2, l2, i16, fontSize3, i21, fontWeight3, fontStyle3, softWrap3, fontFamily2, obj8, obj71, obj72, obj73);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty = obj70;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text-fLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj7;
        Object i25;
        int $dirty;
        Object obj6;
        int traceInProgress;
        int this_$iv;
        boolean traceInProgress2;
        int unspecified-XSAIIZE;
        ScopeUpdateScope endRestartGroup;
        Object obj3;
        int textDecoration2;
        Object obj11;
        Object obj9;
        int i10;
        int $dirty13;
        int $dirty1;
        long $dirty12;
        Object $composer2;
        int $dirty2;
        long $dirty3;
        long l2;
        Object onTextLayout3;
        Object onTextLayout2;
        long modifier3;
        boolean softWrap2;
        Object obj4;
        Object obj5;
        int i29;
        Object obj10;
        long fontStyle3;
        Object fontSize3;
        long l4;
        int i8;
        int i21;
        Object obj8;
        long fontStyle2;
        long fontSize2;
        int obj;
        int fontFamily2;
        Object obj2;
        long modifier2;
        int letterSpacing3;
        int i12;
        int textAlign3;
        long l;
        Object fontWeight2;
        int maxLines3;
        int maxLines2;
        int textAlign2;
        int i13;
        long letterSpacing4;
        long letterSpacing2;
        boolean lineHeight3;
        int i28;
        int i9;
        int i11;
        int i27;
        androidx.compose.material3.TextKt.Text.2 overflow2;
        int changedInstance;
        boolean changed2;
        boolean overflow3;
        TextUnit.Companion companion;
        int overflow4;
        Object softWrap3;
        int i23;
        int $dirty14;
        int i19;
        boolean lineHeight2;
        int i22;
        Object i3;
        int i4;
        Object obj12;
        int style2;
        Composer composer;
        int i31;
        int i7;
        int i14;
        int i;
        int i6;
        int i15;
        int i16;
        int i2;
        int i17;
        int $dirty5;
        int i30;
        int $dirty4;
        int i5;
        int i18;
        int i26;
        int i24;
        int changed;
        ScopeUpdateScope scopeUpdateScope;
        long l3;
        int obj44;
        int obj45;
        int obj63;
        int i32 = obj64;
        int i35 = obj65;
        int i53 = obj66;
        $composer2 = obj63.startRestartGroup(1968784669);
        ComposerKt.sourceInformation($composer2, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)156@7042L7,158@7058L322:Text.kt#uh7d8r");
        $dirty2 = obj64;
        int i86 = obj65;
        if (i53 & 1 != 0) {
            $dirty2 |= 6;
            obj4 = text;
        } else {
            if (i32 & 6 == 0) {
                i21 = $composer2.changed(text) ? 4 : 2;
                $dirty2 |= i21;
            } else {
                obj4 = text;
            }
        }
        int i91 = i53 & 2;
        if (i91 != 0) {
            $dirty2 |= 48;
            obj2 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i12 = $composer2.changed(modifier) ? 32 : 16;
                $dirty2 |= i12;
            } else {
                obj2 = modifier;
            }
        }
        textAlign3 = i53 & 4;
        int i93 = 128;
        if (textAlign3 != 0) {
            $dirty2 |= 384;
            i13 = i91;
            l4 = color;
        } else {
            if (i32 & 384 == 0) {
                i13 = i91;
                i28 = $composer2.changed(color) ? 256 : i93;
                $dirty2 |= i28;
            } else {
                i13 = i91;
                l4 = color;
            }
        }
        int i95 = i53 & 8;
        changedInstance = 1024;
        if (i95 != 0) {
            $dirty2 |= 3072;
            fontSize2 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i22 = $composer2.changed(fontStyle) ? i11 : changedInstance;
                $dirty2 |= i22;
            } else {
                fontSize2 = fontStyle;
            }
        }
        i3 = i53 & 16;
        int i102 = 8192;
        if (i3 != 0) {
            $dirty2 |= 24576;
            obj10 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i7 = $composer2.changed(fontFamily) ? i4 : i102;
                $dirty2 |= i7;
            } else {
                obj10 = fontFamily;
            }
        }
        i14 = i53 & 32;
        final int i103 = 65536;
        final int i104 = 196608;
        if (i14 != 0) {
            $dirty2 |= i104;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i104 == 0) {
                i15 = $composer2.changed(letterSpacing) ? i : i103;
                $dirty2 |= i15;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i105 = i53 & 64;
        i16 = 1572864;
        if (i105 != 0) {
            $dirty2 |= i16;
            obj9 = textDecoration;
        } else {
            if (i32 & i16 == 0) {
                i2 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty2 |= i2;
            } else {
                obj9 = textDecoration;
            }
        }
        int i33 = i53 & 128;
        int i106 = 12582912;
        if (i33 != 0) {
            $dirty5 = $dirty6;
            i17 = i86;
            $dirty3 = textAlign;
        } else {
            if (obj64 & i106 == 0) {
                i17 = i86;
                i5 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i108 |= i5;
            } else {
                $dirty5 = $dirty2;
                i17 = i86;
                $dirty3 = textAlign;
            }
        }
        int i34 = i53 & 256;
        int i111 = 100663296;
        if (i34 != 0) {
            $dirty5 |= i111;
            i18 = i34;
            obj7 = overflow;
        } else {
            if (obj64 & i111 == 0) {
                i18 = i34;
                i26 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty5 |= i26;
            } else {
                i18 = i34;
                obj7 = overflow;
            }
        }
        i25 = i53 & 512;
        int i113 = 805306368;
        if (i25 != 0) {
            $dirty5 |= i113;
            i24 = i25;
        } else {
            if (obj64 & i113 == 0) {
                i24 = i25;
                changed = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty5 |= changed;
            } else {
                i24 = i25;
                i25 = softWrap;
            }
        }
        $dirty = $dirty5;
        int i79 = i53 & 1024;
        if (i79 != 0) {
            $dirty14 = i17 | 6;
            l2 = maxLines;
        } else {
        }
        i10 = i53 & 2048;
        if (i10 != 0) {
            $dirty14 |= 48;
            i30 = i10;
        } else {
            if (i35 & 48 == 0) {
                i30 = i10;
                i31 = $composer2.changed(style) ? 32 : 16;
                $dirty14 |= i31;
            } else {
                i30 = i10;
                i10 = style;
            }
        }
        $dirty13 = $dirty14;
        int i83 = i53 & 4096;
        if (i83 != 0) {
            $dirty13 |= 384;
            softWrap2 = $composer;
        } else {
            if (i35 & 384 == 0) {
                i6 = $composer2.changed($composer) ? 256 : i93;
                $dirty13 |= i6;
            } else {
                softWrap2 = $composer;
            }
        }
        int i84 = i53 & 8192;
        if (i84 != 0) {
            $dirty13 |= 3072;
        } else {
            $dirty14 = $dirty13;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($changed)) {
                } else {
                    i11 = changedInstance;
                }
                $dirty1 = i11;
            } else {
                int i80 = $changed;
                $dirty1 = $dirty14;
            }
        }
        int i85 = i53 & 16384;
        if (i85 != 0) {
            $dirty1 |= 24576;
            obj3 = $changed1;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i4 = i102;
                }
                $dirty1 |= i4;
            } else {
                obj3 = $changed1;
            }
        }
        i19 = 32768;
        if (i35 & i104 == 0) {
            if (obj66 & i19 == 0) {
                if ($composer2.changed(i20)) {
                } else {
                    i = i103;
                }
            } else {
                obj6 = i20;
            }
            $dirty1 |= i;
        } else {
            obj6 = i20;
        }
        if ($dirty & companion == 306783378 && i52 &= $dirty1 == 74898) {
            if (i52 &= $dirty1 == 74898) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj64 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                obj2 = unspecified-XSAIIZE;
                            }
                            if (textAlign3 != 0) {
                                l4 = unspecified-XSAIIZE;
                            }
                            if (i95 != 0) {
                                fontSize2 = unspecified-XSAIIZE;
                            }
                            if (i3 != 0) {
                                obj10 = unspecified-XSAIIZE;
                            }
                            if (i14 != 0) {
                                fontWeight2 = unspecified-XSAIIZE;
                            }
                            this_$iv = i105 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i18 != 0 ? 0 : overflow;
                            textAlign3 = i24 != 0 ? 0 : softWrap;
                            if (i79 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i30 != 0) {
                                overflow4 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow4 = style;
                            }
                            if (i83 != 0) {
                                softWrap2 = 1;
                            }
                            maxLines2 = i84 != 0 ? 0x7fffffff /* Unknown resource */ : $changed;
                            if (i85 != 0) {
                                onTextLayout2 = TextKt.Text.2.INSTANCE;
                            } else {
                                onTextLayout2 = $changed1;
                            }
                            if (obj66 & i19 != 0) {
                                int i98 = 6;
                                int i99 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj12 = this_$iv;
                                $dirty1 = textDecoration2;
                                i19 = maxLines2;
                                i27 = overflow4;
                                overflow3 = softWrap2;
                                softWrap2 = l4;
                                maxLines3 = textAlign3;
                                obj8 = obj10;
                                fontStyle3 = fontSize2;
                                fontSize2 = fontWeight2;
                                obj = obj44;
                                fontWeight2 = obj45;
                                i3 = onTextLayout2;
                                onTextLayout3 = obj2;
                                modifier2 = letterSpacing2;
                                letterSpacing4 = l3;
                            } else {
                                obj63 = $dirty1;
                                obj12 = i20;
                                i19 = maxLines2;
                                i27 = overflow4;
                                overflow3 = softWrap2;
                                softWrap2 = l4;
                                maxLines3 = textAlign3;
                                obj8 = obj10;
                                fontStyle3 = fontSize2;
                                fontSize2 = fontWeight2;
                                obj = obj44;
                                fontWeight2 = obj45;
                                i3 = onTextLayout2;
                                onTextLayout3 = obj2;
                                modifier2 = letterSpacing2;
                                letterSpacing4 = l3;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj66 & i19 != 0) {
                                maxLines3 = softWrap;
                                letterSpacing4 = maxLines;
                                i27 = style;
                                i19 = $changed;
                                i3 = $changed1;
                                obj12 = i20;
                                $dirty1 = this_$iv;
                                overflow3 = softWrap2;
                                softWrap2 = l4;
                                onTextLayout3 = obj2;
                                modifier2 = textAlign;
                                obj8 = obj10;
                                fontStyle3 = fontSize2;
                                fontSize2 = fontWeight2;
                                obj = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines3 = softWrap;
                                letterSpacing4 = maxLines;
                                i27 = style;
                                i19 = $changed;
                                i3 = $changed1;
                                obj12 = i20;
                                overflow3 = softWrap2;
                                softWrap2 = l4;
                                onTextLayout3 = obj2;
                                modifier2 = textAlign;
                                obj8 = obj10;
                                fontStyle3 = fontSize2;
                                fontSize2 = fontWeight2;
                                obj = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1968784669, $dirty, $dirty1, "androidx.compose.material3.Text (Text.kt:157)");
                    }
                    TextKt.Text--4IGK_g(text, onTextLayout3, softWrap2, obj4, fontStyle3, l4, obj8, fontSize2, obj, modifier2, textAlign3, fontWeight2, maxLines3, letterSpacing4, i95, i27, overflow3, i19, 1, i3, obj12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj11 = onTextLayout3;
                    style2 = $dirty1;
                    $dirty12 = softWrap2;
                    modifier3 = fontStyle3;
                    obj5 = obj8;
                    fontSize3 = fontSize2;
                    i8 = obj;
                    fontStyle2 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing3 = maxLines3;
                    l = letterSpacing4;
                    textAlign2 = i27;
                    lineHeight3 = overflow3;
                    i9 = i19;
                    overflow2 = i3;
                    softWrap3 = l3;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign2 = style;
                    i9 = $changed;
                    overflow2 = $changed1;
                    softWrap3 = i20;
                    style2 = $dirty1;
                    composer = $composer2;
                    lineHeight3 = softWrap2;
                    obj5 = obj10;
                    $dirty12 = l4;
                    modifier3 = fontSize2;
                    obj11 = obj2;
                    fontSize3 = fontWeight2;
                    i8 = textDecoration;
                    fontStyle2 = textAlign;
                    fontFamily2 = overflow;
                    letterSpacing3 = softWrap;
                    l = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = $dirty;
            $dirty = new TextKt.Text.3(text, obj11, $dirty12, $composer2, modifier3, softWrap2, obj5, fontSize3, i8, fontStyle2, fontSize2, fontFamily2, letterSpacing3, l, fontWeight2, textAlign2, lineHeight3, i9, overflow2, softWrap3, obj64, obj65, obj66);
            endRestartGroup.updateScope((Function2)$dirty);
        } else {
            $dirty4 = $dirty;
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return TextKt.LocalTextStyle;
    }
}
