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
        int i3;
        int i2;
        int traceInProgress;
        boolean traceInProgress2;
        int str;
        int i;
        String str2;
        merge = -460300127;
        final Composer obj8 = $composer.startRestartGroup(merge);
        ComposerKt.sourceInformation(obj8, "C(ProvideTextStyle)P(1)347@14710L7,348@14735L80:Text.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i3 = obj8.changed(value) ? 4 : 2;
            $dirty |= i3;
        }
        if ($changed & 48 == 0) {
            i2 = obj8.changedInstance(content) ? 32 : 16;
            $dirty |= i2;
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
                CompositionLocalKt.CompositionLocalProvider(TextKt.LocalTextStyle.provides((TextStyle)obj8.consume((CompositionLocal)TextKt.LocalTextStyle).merge(value)), content, obj8, $stable |= i);
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
        Object obj10;
        Object i24;
        int $dirty5;
        Object obj5;
        Object obj9;
        boolean traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress;
        Object obj2;
        Object obj11;
        int textDecoration2;
        Object obj;
        int i18;
        int $dirty14;
        int $dirty12;
        long $dirty1;
        Composer $composer2;
        int $dirty2;
        long $dirty;
        long l;
        long modifier3;
        Object inlineContent2;
        Object inlineContent3;
        boolean softWrap2;
        Object obj7;
        Object obj12;
        int i23;
        Object obj8;
        Object fontSize2;
        long fontStyle2;
        long l2;
        int obj3;
        int i2;
        long fontStyle3;
        Object obj4;
        long fontSize3;
        int fontFamily2;
        int i28;
        Object obj6;
        int letterSpacing4;
        long modifier2;
        int i3;
        long l3;
        int textAlign2;
        Object fontWeight2;
        int textAlign3;
        int maxLines4;
        int maxLines2;
        int i16;
        boolean lineHeight2;
        long letterSpacing3;
        long letterSpacing2;
        int i10;
        int i5;
        int i22;
        Object overflow4;
        Object onTextLayout3;
        int onTextLayout2;
        int changedInstance;
        Object softWrap3;
        boolean z;
        int i25;
        int $dirty13;
        int i9;
        Object maxLines3;
        long lineHeight4;
        int lineHeight3;
        int changed;
        boolean changed3;
        int i29;
        int overflow2;
        int overflow3;
        int i26;
        int style2;
        Object obj13;
        int i6;
        Composer composer;
        int i30;
        int i31;
        int i7;
        int i14;
        int i27;
        int i8;
        int i11;
        int i12;
        int i20;
        int $dirty3;
        int i15;
        int $dirty4;
        int i;
        int i13;
        int i19;
        int i17;
        int changed2;
        ScopeUpdateScope scopeUpdateScope;
        int i4;
        int obj44;
        int obj45;
        int obj64;
        int i32 = obj65;
        int i35 = obj66;
        int i54 = obj67;
        $composer2 = obj64.startRestartGroup(224529679);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)304@13393L7,306@13409L345:Text.kt#uh7d8r");
        $dirty2 = obj65;
        int i89 = obj66;
        if (i54 & 1 != 0) {
            $dirty2 |= 6;
            obj7 = text;
        } else {
            if (i32 & 6 == 0) {
                i2 = $composer2.changed(text) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                obj7 = text;
            }
        }
        int i94 = i54 & 2;
        if (i94 != 0) {
            $dirty2 |= 48;
            obj6 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i3 = $composer2.changed(modifier) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                obj6 = modifier;
            }
        }
        textAlign2 = i54 & 4;
        int i96 = 128;
        if (textAlign2 != 0) {
            $dirty2 |= 384;
            i16 = i94;
            l2 = color;
        } else {
            if (i32 & 384 == 0) {
                i16 = i94;
                i10 = $composer2.changed(color) ? 256 : i96;
                $dirty2 |= i10;
            } else {
                i16 = i94;
                l2 = color;
            }
        }
        int i98 = i54 & 8;
        changedInstance = 1024;
        if (i98 != 0) {
            $dirty2 |= 3072;
            fontSize3 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i29 = $composer2.changed(fontStyle) ? i22 : changedInstance;
                $dirty2 |= i29;
            } else {
                fontSize3 = fontStyle;
            }
        }
        overflow2 = i54 & 16;
        int i109 = 8192;
        if (overflow2 != 0) {
            $dirty2 |= 24576;
            obj8 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i30 = $composer2.changed(fontFamily) ? i26 : i109;
                $dirty2 |= i30;
            } else {
                obj8 = fontFamily;
            }
        }
        i31 = i54 & 32;
        i14 = 196608;
        final int i110 = 65536;
        if (i31 != 0) {
            $dirty2 |= i14;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i14 == 0) {
                i8 = $composer2.changed(letterSpacing) ? i7 : i110;
                $dirty2 |= i8;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i111 = i54 & 64;
        final int i112 = 1572864;
        if (i111 != 0) {
            $dirty2 |= i112;
            obj = textDecoration;
        } else {
            if (i32 & i112 == 0) {
                i12 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty2 |= i12;
            } else {
                obj = textDecoration;
            }
        }
        int i33 = i54 & 128;
        int i113 = 12582912;
        if (i33 != 0) {
            $dirty3 = $dirty6;
            i20 = i89;
            $dirty = textAlign;
        } else {
            if (obj65 & i113 == 0) {
                i20 = i89;
                i = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i115 |= i;
            } else {
                $dirty3 = $dirty2;
                i20 = i89;
                $dirty = textAlign;
            }
        }
        int i34 = i54 & 256;
        int i118 = 100663296;
        if (i34 != 0) {
            $dirty3 |= i118;
            i13 = i34;
            obj10 = overflow;
        } else {
            if (obj65 & i118 == 0) {
                i13 = i34;
                i19 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty3 |= i19;
            } else {
                i13 = i34;
                obj10 = overflow;
            }
        }
        i24 = i54 & 512;
        int i120 = 805306368;
        if (i24 != 0) {
            $dirty3 |= i120;
            i17 = i24;
        } else {
            if (obj65 & i120 == 0) {
                i17 = i24;
                changed2 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty3 |= changed2;
            } else {
                i17 = i24;
                i24 = softWrap;
            }
        }
        $dirty5 = $dirty3;
        int i82 = i54 & 1024;
        if (i82 != 0) {
            $dirty13 = i20 | 6;
            l = maxLines;
        } else {
        }
        i18 = i54 & 2048;
        if (i18 != 0) {
            $dirty13 |= 48;
            i15 = i18;
        } else {
            if (i35 & 48 == 0) {
                i15 = i18;
                i6 = $composer2.changed(onTextLayout) ? 32 : 16;
                $dirty13 |= i6;
            } else {
                i15 = i18;
                i18 = onTextLayout;
            }
        }
        $dirty14 = $dirty13;
        int i86 = i54 & 4096;
        if (i86 != 0) {
            $dirty14 |= 384;
            softWrap2 = style;
        } else {
            if (i35 & 384 == 0) {
                i27 = $composer2.changed(style) ? 256 : i96;
                $dirty14 |= i27;
            } else {
                softWrap2 = style;
            }
        }
        int i87 = i54 & 8192;
        if (i87 != 0) {
            $dirty14 |= 3072;
        } else {
            $dirty13 = $dirty14;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i22 = changedInstance;
                }
                $dirty12 = i22;
            } else {
                int i83 = $composer;
                $dirty12 = $dirty13;
            }
        }
        int i88 = i54 & 16384;
        if (i88 != 0) {
            $dirty12 |= 24576;
            obj2 = $changed;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed)) {
                } else {
                    i26 = i109;
                }
                $dirty12 |= i26;
            } else {
                obj2 = $changed;
            }
        }
        int i101 = obj67 & i100;
        if (i101 != 0) {
            $dirty12 |= i14;
            obj5 = $changed1;
        } else {
            if (i35 & i14 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i7 = i110;
                }
                $dirty12 |= i7;
            } else {
                obj5 = $changed1;
            }
        }
        if (obj66 & i112 == 0) {
            if (obj67 & i110 == 0) {
                i9 = $composer2.changed(i21) ? 1048576 : 524288;
            } else {
                obj9 = i21;
            }
            $dirty12 |= i9;
        } else {
            obj9 = i21;
        }
        if ($dirty5 & i104 == 306783378 && i36 &= $dirty12 == 599186) {
            if (i36 &= $dirty12 == 599186) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj65 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i16 != 0) {
                                obj6 = unspecified-0d7_KjU;
                            }
                            if (textAlign2 != 0) {
                                l2 = unspecified-0d7_KjU;
                            }
                            if (i98 != 0) {
                                fontSize3 = unspecified-0d7_KjU;
                            }
                            if (overflow2 != 0) {
                                obj8 = unspecified-0d7_KjU;
                            }
                            if (i31 != 0) {
                                fontWeight2 = unspecified-0d7_KjU;
                            }
                            this_$iv = i111 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing3 = textAlign;
                            }
                            textDecoration2 = i13 != 0 ? 0 : overflow;
                            textAlign2 = i17 != 0 ? 0 : softWrap;
                            if (i82 != 0) {
                                lineHeight4 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight4 = maxLines;
                            }
                            if (i15 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = onTextLayout;
                            }
                            if (i86 != 0) {
                                softWrap2 = 1;
                            }
                            maxLines4 = i87 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
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
                                obj13 = this_$iv;
                                $dirty12 = textDecoration2;
                                z = softWrap2;
                                softWrap2 = l2;
                                i26 = onTextLayout3;
                                onTextLayout2 = overflow3;
                                overflow2 = inlineContent2;
                                obj4 = obj8;
                                fontStyle2 = fontSize3;
                                inlineContent3 = obj6;
                                fontSize3 = fontWeight2;
                                i28 = obj44;
                                fontWeight2 = obj45;
                                maxLines2 = textAlign2;
                                modifier2 = letterSpacing3;
                                letterSpacing2 = lineHeight4;
                                lineHeight3 = i4;
                            } else {
                                obj64 = $dirty12;
                                obj13 = i21;
                                z = softWrap2;
                                softWrap2 = l2;
                                i26 = onTextLayout3;
                                onTextLayout2 = overflow3;
                                overflow2 = inlineContent2;
                                obj4 = obj8;
                                fontStyle2 = fontSize3;
                                inlineContent3 = obj6;
                                fontSize3 = fontWeight2;
                                i28 = obj44;
                                fontWeight2 = obj45;
                                maxLines2 = textAlign2;
                                modifier2 = letterSpacing3;
                                letterSpacing2 = lineHeight4;
                                lineHeight3 = i4;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj67 & i110 != 0) {
                                maxLines2 = softWrap;
                                letterSpacing2 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight3 = $composer;
                                overflow2 = $changed;
                                i26 = $changed1;
                                obj13 = i21;
                                $dirty12 = this_$iv;
                                z = softWrap2;
                                softWrap2 = l2;
                                inlineContent3 = obj6;
                                modifier2 = textAlign;
                                obj4 = obj8;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                i28 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines2 = softWrap;
                                letterSpacing2 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight3 = $composer;
                                overflow2 = $changed;
                                i26 = $changed1;
                                obj13 = i21;
                                z = softWrap2;
                                softWrap2 = l2;
                                inlineContent3 = obj6;
                                modifier2 = textAlign;
                                obj4 = obj8;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                i28 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(224529679, $dirty5, $dirty12, "androidx.compose.material3.Text (Text.kt:305)");
                    }
                    TextKt.Text-IbK3jfQ(text, inlineContent3, softWrap2, obj7, fontStyle2, l2, obj4, fontSize3, i28, modifier2, textAlign2, fontWeight2, maxLines2, letterSpacing2, i98, onTextLayout2, z, lineHeight3, 1, overflow2, i26, obj13);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj11 = inlineContent3;
                    style2 = $dirty12;
                    $dirty1 = softWrap2;
                    modifier3 = fontStyle2;
                    obj12 = obj4;
                    fontSize2 = fontSize3;
                    obj3 = i28;
                    fontStyle3 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing4 = maxLines2;
                    l3 = letterSpacing2;
                    textAlign3 = onTextLayout2;
                    lineHeight2 = z;
                    i5 = lineHeight3;
                    overflow4 = overflow2;
                    softWrap3 = i26;
                    maxLines3 = i4;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign3 = onTextLayout;
                    i5 = $composer;
                    overflow4 = $changed;
                    softWrap3 = $changed1;
                    maxLines3 = i21;
                    style2 = $dirty12;
                    composer = $composer2;
                    lineHeight2 = softWrap2;
                    obj12 = obj8;
                    $dirty1 = l2;
                    modifier3 = fontSize3;
                    obj11 = obj6;
                    fontSize2 = fontWeight2;
                    obj3 = textDecoration;
                    fontStyle3 = textAlign;
                    fontFamily2 = overflow;
                    letterSpacing4 = softWrap;
                    l3 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = $dirty5;
            $dirty5 = new TextKt.Text.7(text, obj11, $dirty1, $composer2, modifier3, softWrap2, obj12, fontSize2, obj3, fontStyle3, fontSize3, fontFamily2, letterSpacing4, l3, fontWeight2, textAlign3, lineHeight2, i5, overflow4, softWrap3, maxLines3, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)$dirty5);
        } else {
            $dirty4 = $dirty5;
        }
    }

    public static final void Text--4IGK_g(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj2;
        Object i37;
        int traceInProgress;
        Object endRestartGroup;
        int unspecified-e0LSkKk;
        Object obj4;
        Object obj12;
        boolean skipping;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress2;
        long consume;
        int i46;
        Object obj14;
        int textDecoration2;
        Object obj10;
        int i39;
        int $dirty14;
        int $dirty12;
        long $dirty15;
        int $dirty2;
        long $dirty3;
        long l6;
        long minLines2;
        int minLines3;
        boolean z2;
        Object obj9;
        Object obj15;
        int i43;
        Object obj7;
        Object obj8;
        long l;
        int color2;
        int i27;
        long l3;
        long l5;
        int obj5;
        int i34;
        Object obj;
        int modifier2;
        int i4;
        long textAlign3;
        int textAlign2;
        Object obj3;
        int maxLines2;
        int maxLines3;
        int letterSpacing2;
        boolean z;
        int cmp;
        int i15;
        int i30;
        int i38;
        int i40;
        int onTextLayout3;
        int onTextLayout2;
        int changed;
        int obj11;
        int $this$takeOrElse_u2dDxMtmZc$iv;
        int i18;
        int $dirty13;
        int i20;
        Object obj13;
        long lineHeight2;
        int changed2;
        boolean changed3;
        int i3;
        int overflow2;
        int i35;
        Composer composer;
        int i13;
        int i19;
        int i10;
        int i41;
        int i14;
        int i5;
        int i6;
        int i22;
        int i28;
        int $dirty1;
        int $dirty;
        int i36;
        int $dirty4;
        int i9;
        int i50;
        int i23;
        int i31;
        int changed4;
        Object obj6;
        int i11;
        int i;
        int i47;
        long l4;
        int i16;
        int i48;
        int i25;
        int i42;
        int i8;
        int i49;
        int i2;
        int i32;
        int i29;
        long l2;
        int i44;
        int i17;
        int i33;
        int i7;
        int i12;
        int i24;
        int i45;
        int i26;
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
        $dirty2 = obj90;
        int i87 = obj91;
        if (i64 & 1 != 0) {
            $dirty2 |= 6;
            obj9 = text;
        } else {
            if (i51 & 6 == 0) {
                i27 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i27;
            } else {
                obj9 = text;
            }
        }
        int i98 = i64 & 2;
        if (i98 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i51 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                obj = modifier;
            }
        }
        int i101 = i64 & 4;
        int i102 = 128;
        if (i101 != 0) {
            $dirty2 |= 384;
            letterSpacing2 = i98;
            l = color;
        } else {
            if (i51 & 384 == 0) {
                letterSpacing2 = i98;
                i15 = restartGroup.changed(color) ? 256 : i102;
                $dirty2 |= i15;
            } else {
                letterSpacing2 = i98;
                l = color;
            }
        }
        int i105 = i64 & 8;
        changed = 1024;
        if (i105 != 0) {
            $dirty2 |= 3072;
            l5 = fontStyle;
        } else {
            if (i51 & 3072 == 0) {
                i3 = restartGroup.changed(fontStyle) ? i40 : changed;
                $dirty2 |= i3;
            } else {
                l5 = fontStyle;
            }
        }
        overflow2 = i64 & 16;
        int i108 = 8192;
        if (overflow2 != 0) {
            $dirty2 |= 24576;
            obj7 = fontFamily;
        } else {
            if (i51 & 24576 == 0) {
                i10 = restartGroup.changed(fontFamily) ? i35 : i108;
                $dirty2 |= i10;
            } else {
                obj7 = fontFamily;
            }
        }
        int i109 = i64 & 32;
        final int i110 = 196608;
        final int i111 = 65536;
        if (i109 != 0) {
            $dirty2 |= i110;
            obj3 = letterSpacing;
        } else {
            if (i51 & i110 == 0) {
                i5 = restartGroup.changed(letterSpacing) ? i41 : i111;
                $dirty2 |= i5;
            } else {
                obj3 = letterSpacing;
            }
        }
        int i112 = i64 & 64;
        final int i113 = 1572864;
        if (i112 != 0) {
            $dirty2 |= i113;
            obj10 = textDecoration;
        } else {
            if (i51 & i113 == 0) {
                i22 = restartGroup.changed(textDecoration) ? 1048576 : 524288;
                $dirty2 |= i22;
            } else {
                obj10 = textDecoration;
            }
        }
        int i52 = i64 & 128;
        int i114 = 12582912;
        if (i52 != 0) {
            $dirty = $dirty6;
            i28 = i87;
            $dirty3 = textAlign;
        } else {
            if (obj90 & i114 == 0) {
                i28 = i87;
                i9 = restartGroup.changed(textAlign) ? 8388608 : 4194304;
                i116 |= i9;
            } else {
                $dirty = $dirty2;
                i28 = i87;
                $dirty3 = textAlign;
            }
        }
        int i118 = i52;
        int i53 = i64 & 256;
        int i119 = 100663296;
        if (i53 != 0) {
            $dirty |= i119;
            i50 = i53;
            obj2 = overflow;
        } else {
            if (obj90 & i119 == 0) {
                i50 = i53;
                i23 = restartGroup.changed(overflow) ? 67108864 : 33554432;
                $dirty |= i23;
            } else {
                i50 = i53;
                obj2 = overflow;
            }
        }
        i37 = i64 & 512;
        int i121 = 805306368;
        if (i37 != 0) {
            $dirty |= i121;
            i31 = i37;
        } else {
            if (obj90 & i121 == 0) {
                i31 = i37;
                changed4 = restartGroup.changed(softWrap) ? 536870912 : 268435456;
                $dirty |= changed4;
            } else {
                i31 = i37;
                i37 = softWrap;
            }
        }
        traceInProgress = $dirty;
        int i80 = i64 & 1024;
        if (i80 != 0) {
            $dirty13 = i28 | 6;
            l6 = maxLines;
        } else {
        }
        i39 = i64 & 2048;
        if (i39 != 0) {
            $dirty13 |= 48;
            i36 = i39;
        } else {
            if (i54 & 48 == 0) {
                i36 = i39;
                i13 = restartGroup.changed(onTextLayout) ? 32 : 16;
                $dirty13 |= i13;
            } else {
                i36 = i39;
                i39 = onTextLayout;
            }
        }
        $dirty14 = $dirty13;
        int i84 = i64 & 4096;
        if (i84 != 0) {
            $dirty14 |= 384;
            z2 = style;
        } else {
            if (i54 & 384 == 0) {
                i14 = restartGroup.changed(style) ? 256 : i102;
                $dirty14 |= i14;
            } else {
                z2 = style;
            }
        }
        int i85 = i64 & 8192;
        if (i85 != 0) {
            $dirty14 |= 3072;
        } else {
            $dirty13 = $dirty14;
            if (i54 & 3072 == 0) {
                if (restartGroup.changed($composer)) {
                } else {
                    i40 = changed;
                }
                $dirty12 = i40;
            } else {
                int i81 = $composer;
                $dirty12 = $dirty13;
            }
        }
        int i86 = i64 & 16384;
        if (i86 != 0) {
            $dirty12 |= 24576;
            i46 = $changed;
        } else {
            if (i54 & 24576 == 0) {
                if (restartGroup.changed($changed)) {
                } else {
                    i35 = i108;
                }
                $dirty12 |= i35;
            } else {
                i46 = $changed;
            }
        }
        $this$takeOrElse_u2dDxMtmZc$iv = obj92 & i107;
        if ($this$takeOrElse_u2dDxMtmZc$iv != 0) {
            $dirty12 |= i110;
            obj4 = $changed1;
        } else {
            if (i54 & i110 == 0) {
                if (restartGroup.changedInstance($changed1)) {
                } else {
                    i41 = i111;
                }
                $dirty12 |= i41;
            } else {
                obj4 = $changed1;
            }
        }
        if (obj91 & i113 == 0) {
            if (obj92 & i111 == 0) {
                i20 = restartGroup.changed(i21) ? 1048576 : 524288;
            } else {
                obj12 = i21;
            }
            $dirty12 |= i20;
        } else {
            obj12 = i21;
        }
        if (traceInProgress & lineHeight2 == 306783378 && i55 &= $dirty12 == 599186) {
            if (i55 &= $dirty12 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj90 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (letterSpacing2 != 0) {
                                obj = unspecified-0d7_KjU;
                            }
                            if (i101 != 0) {
                                l = unspecified-0d7_KjU;
                            }
                            if (i105 != 0) {
                                l5 = unspecified-0d7_KjU;
                            }
                            if (overflow2 != 0) {
                                obj7 = unspecified-0d7_KjU;
                            }
                            if (i109 != 0) {
                                obj3 = unspecified-0d7_KjU;
                            }
                            this_$iv = i112 != 0 ? 0 : textDecoration;
                            if (i118 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i50 != 0 ? 0 : overflow;
                            textAlign2 = i31 != 0 ? 0 : softWrap;
                            if (i80 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i36 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = onTextLayout;
                            }
                            if (i84 != 0) {
                                z2 = 1;
                            }
                            maxLines3 = i85 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            minLines3 = i86 != 0 ? 1 : $changed;
                            onTextLayout2 = $this$takeOrElse_u2dDxMtmZc$iv != 0 ? 0 : $changed1;
                            if (obj92 & i111 != 0) {
                                $this$takeOrElse_u2dDxMtmZc$iv = 6;
                                i35 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                i = obj69;
                                i8 = obj70;
                                $dirty1 = this_$iv;
                                $dirty12 = textDecoration2;
                                obj6 = obj7;
                                i50 = l5;
                                changed4 = obj3;
                                l4 = letterSpacing2;
                                l2 = lineHeight2;
                            } else {
                                obj89 = $dirty12;
                                i = obj69;
                                i8 = obj70;
                                $dirty1 = i21;
                                obj6 = obj7;
                                i50 = l5;
                                changed4 = obj3;
                                l4 = letterSpacing2;
                                l2 = lineHeight2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (obj92 & i111 != 0) {
                                i = textDecoration;
                                l4 = textAlign;
                                i8 = overflow;
                                textAlign2 = softWrap;
                                l2 = maxLines;
                                overflow2 = onTextLayout;
                                maxLines3 = $composer;
                                minLines3 = $changed;
                                onTextLayout2 = $changed1;
                                $dirty1 = i21;
                                $dirty12 = this_$iv;
                                obj6 = obj7;
                                i50 = l5;
                                changed4 = obj3;
                            } else {
                                i = textDecoration;
                                l4 = textAlign;
                                i8 = overflow;
                                textAlign2 = softWrap;
                                l2 = maxLines;
                                overflow2 = onTextLayout;
                                maxLines3 = $composer;
                                minLines3 = $changed;
                                onTextLayout2 = $changed1;
                                $dirty1 = i21;
                                obj6 = obj7;
                                i50 = l5;
                                changed4 = obj3;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2055108902, traceInProgress, $dirty12, "androidx.compose.material3.Text (Text.kt:109)");
                    }
                    restartGroup.startReplaceGroup(-1827892941);
                    ComposerKt.sourceInformation(restartGroup, "");
                    consume = l;
                    int i92 = 0;
                    obj3 = 0;
                    cmp = Long.compare(l5, i104) != 0 ? i38 : 0;
                    if (cmp != 0) {
                        obj89 = traceInProgress;
                        i36 = consume;
                    } else {
                        l5 = 0;
                        restartGroup.startReplaceGroup(-1827892168);
                        ComposerKt.sourceInformation(restartGroup, "*111@5715L7");
                        i34 = 0;
                        obj3 = 0;
                        if (Long.compare(i35, i13) != 0) {
                        } else {
                            i38 = 0;
                        }
                        if (i38 != 0) {
                            obj89 = traceInProgress;
                            obj69 = consume;
                        } else {
                            obj3 = 0;
                            obj89 = traceInProgress;
                            cmp = 6;
                            i38 = 0;
                            obj69 = consume;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $this$takeOrElse_u2dDxMtmZc$iv = traceInProgress;
                        }
                        restartGroup.endReplaceGroup();
                        i36 = $this$takeOrElse_u2dDxMtmZc$iv;
                    }
                    restartGroup.endReplaceGroup();
                    if (textAlign2 != 0) {
                        unspecified-e0LSkKk = textAlign2.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    obj78 = restartGroup;
                    BasicTextKt.BasicText-VhcvRP8(obj9, obj, TextStyle.merge-dA7vx0o$default($dirty1, i36, i118, i50, i31, changed4, obj6, 0, i, 0, l4, obj46, 0, 0, 0, 0, obj51, i8, 0, 0, unspecified-e0LSkKk, 0, l2, obj58, 0, 0, 0), onTextLayout2, overflow2, z2, maxLines3, minLines3, 0, obj78, i63 |= i76, 256);
                    composer = obj78;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i19 = $dirty12;
                    z = z2;
                    $dirty15 = l;
                    obj14 = obj;
                    modifier2 = textAlign2;
                    i30 = maxLines3;
                    obj11 = onTextLayout2;
                    maxLines2 = overflow2;
                    obj13 = $dirty1;
                    obj8 = changed4;
                    obj15 = obj6;
                    color2 = i;
                    l3 = l4;
                    obj5 = i8;
                    textAlign3 = l2;
                    onTextLayout3 = minLines3;
                    minLines2 = i50;
                } else {
                    restartGroup.skipToGroupEnd();
                    maxLines2 = onTextLayout;
                    i30 = $composer;
                    onTextLayout3 = $changed;
                    obj11 = $changed1;
                    obj13 = i21;
                    obj89 = traceInProgress;
                    i19 = $dirty12;
                    composer = restartGroup;
                    z = z2;
                    obj15 = obj7;
                    $dirty15 = l;
                    minLines2 = l5;
                    obj14 = obj;
                    obj8 = obj3;
                    color2 = textDecoration;
                    l3 = textAlign;
                    obj5 = overflow;
                    modifier2 = softWrap;
                    textAlign3 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = obj89;
            endRestartGroup = new TextKt.Text.1(text, obj14, $dirty15, restartGroup, minLines2, z2, obj15, obj8, color2, l3, l5, obj5, modifier2, textAlign3, obj3, maxLines2, z, i30, onTextLayout3, obj11, obj13, obj90, obj91, obj92);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty4 = obj89;
        }
    }

    public static final void Text-IbK3jfQ(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i22) {
        Object obj4;
        Object i27;
        long unbox-impl;
        int unspecified-e0LSkKk;
        Object endRestartGroup;
        Object obj11;
        Object obj10;
        Object obj12;
        int skipping;
        int textAlign2;
        Object consume;
        int unspecified-XSAIIZE;
        long letterSpacing2;
        int i38;
        int i35;
        int overflow2;
        Object maxLines4;
        long inlineContent4;
        int $dirty;
        long $dirty4;
        long l2;
        boolean z;
        int $dirty13;
        int $dirty1;
        int $dirty15;
        int $dirty12;
        int i28;
        int minLines4;
        int minLines3;
        long minLines2;
        Object traceInProgress2;
        int i25;
        Object obj7;
        int fontStyle3;
        long l;
        Object color2;
        int i7;
        Object obj5;
        long anon;
        Object fontSize2;
        long l3;
        Object obj2;
        Object obj6;
        int modifier2;
        int i3;
        Object textDecoration3;
        int textDecoration2;
        int style2;
        Object obj;
        int fontWeight3;
        long l4;
        Object i34;
        boolean traceInProgress;
        int i39;
        long textAlign3;
        int textAlign4;
        int fontSize3;
        int i20;
        int overflow3;
        int i33;
        int i19;
        Object maxLines3;
        int maxLines2;
        int fontWeight2;
        int changed5;
        Object inlineContent2;
        Object inlineContent3;
        int fontStyle2;
        int changed4;
        int softWrap2;
        int i18;
        Map softWrap3;
        int i23;
        int $dirty14;
        Object onTextLayout2;
        Object onTextLayout3;
        androidx.compose.material3.TextKt.Text.4 fontFamily2;
        int i17;
        int i30;
        int i36;
        Object obj9;
        int i11;
        long i37;
        int i26;
        int i16;
        int lineHeight2;
        int changed;
        int textColor;
        long $this$takeOrElse_u2dDxMtmZc$iv2;
        int i13;
        Composer composer;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i6;
        int i12;
        int cmp;
        int changed2;
        int i;
        long i5;
        int i10;
        int i32;
        int i31;
        int i24;
        int i21;
        int $dirty16;
        int $dirty2;
        int i14;
        int $dirty3;
        int i41;
        int i2;
        int i4;
        int i8;
        int i42;
        int changed3;
        int i9;
        int i29;
        int i40;
        int i15;
        ScopeUpdateScope scopeUpdateScope;
        Object obj3;
        Object obj8;
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
        int i59 = obj73;
        Composer restartGroup = obj70.startRestartGroup(2027001676);
        ComposerKt.sourceInformation(restartGroup, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)254@11726L7,258@11837L706:Text.kt#uh7d8r");
        $dirty = obj71;
        int i85 = obj72;
        if (i59 & 1 != 0) {
            $dirty |= 6;
            traceInProgress2 = text;
        } else {
            if (i43 & 6 == 0) {
                i7 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i7;
            } else {
                traceInProgress2 = text;
            }
        }
        int i94 = i59 & 2;
        if (i94 != 0) {
            $dirty |= 48;
            obj6 = modifier;
        } else {
            if (i43 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                obj6 = modifier;
            }
        }
        int i96 = i59 & 4;
        if (i96 != 0) {
            $dirty |= 384;
            i39 = i94;
            l = color;
        } else {
            if (i43 & 384 == 0) {
                i39 = i94;
                i20 = restartGroup.changed(color) ? 256 : 128;
                $dirty |= i20;
            } else {
                i39 = i94;
                l = color;
            }
        }
        overflow3 = i59 & 8;
        changed5 = 1024;
        if (overflow3 != 0) {
            $dirty |= 3072;
            anon = fontStyle;
        } else {
            if (i43 & 3072 == 0) {
                i17 = restartGroup.changed(fontStyle) ? i19 : changed5;
                $dirty |= i17;
            } else {
                anon = fontStyle;
            }
        }
        i30 = i59 & 16;
        i26 = 8192;
        if (i30 != 0) {
            $dirty |= 24576;
            obj7 = fontFamily;
        } else {
            if (i43 & 24576 == 0) {
                i13 = restartGroup.changed(fontFamily) ? i11 : i26;
                $dirty |= i13;
            } else {
                obj7 = fontFamily;
            }
        }
        int i110 = i59 & 32;
        int i112 = 65536;
        i12 = 196608;
        cmp = 131072;
        if (i110 != 0) {
            $dirty |= i12;
            obj = letterSpacing;
        } else {
            if (i43 & i12 == 0) {
                i = restartGroup.changed(letterSpacing) ? cmp : i112;
                $dirty |= i;
            } else {
                obj = letterSpacing;
            }
        }
        i10 = i59 & 64;
        i32 = 1572864;
        if (i10 != 0) {
            $dirty |= i32;
            i34 = textDecoration;
        } else {
            if (i43 & i32 == 0) {
                i24 = restartGroup.changed(textDecoration) ? 1048576 : 524288;
                $dirty |= i24;
            } else {
                i34 = textDecoration;
            }
        }
        int i44 = i59 & 128;
        i21 = 12582912;
        if (i44 != 0) {
            $dirty2 = $dirty6;
            $dirty16 = i85;
            $dirty4 = textAlign;
        } else {
            if (obj71 & i21 == 0) {
                $dirty16 = i85;
                i41 = restartGroup.changed(textAlign) ? 8388608 : 4194304;
                i115 |= i41;
            } else {
                $dirty2 = $dirty;
                $dirty16 = i85;
                $dirty4 = textAlign;
            }
        }
        int i45 = i59 & 256;
        int i116 = 100663296;
        if (i45 != 0) {
            $dirty2 |= i116;
            i4 = i45;
            obj4 = overflow;
        } else {
            if (obj71 & i116 == 0) {
                i4 = i45;
                i8 = restartGroup.changed(overflow) ? 67108864 : 33554432;
                $dirty2 |= i8;
            } else {
                i4 = i45;
                obj4 = overflow;
            }
        }
        i27 = i59 & 512;
        int i118 = 805306368;
        if (i27 != 0) {
            $dirty2 |= i118;
            i42 = i27;
        } else {
            if (obj71 & i118 == 0) {
                i42 = i27;
                changed3 = restartGroup.changed(softWrap) ? 536870912 : 268435456;
                $dirty2 |= changed3;
            } else {
                i42 = i27;
                i27 = softWrap;
            }
        }
        unbox-impl = $dirty2;
        int i80 = i59 & 1024;
        if (i80 != 0) {
            i14 = i80;
            $dirty16 = $dirty12;
            l2 = maxLines;
        } else {
            $dirty12 = i54 & 6;
            if ($dirty12 == 0) {
                i14 = i80;
                i23 = restartGroup.changed(maxLines) ? 4 : 2;
                $dirty16 = changed4;
            } else {
                i14 = i80;
                l2 = maxLines;
            }
        }
        int i81 = i59 & 2048;
        if (i81 != 0) {
            $dirty16 |= 48;
            i28 = inlineContent;
        } else {
            if (i54 & 48 == 0) {
                textColor = restartGroup.changed(inlineContent) ? 32 : 16;
                $dirty16 |= textColor;
            } else {
                i28 = inlineContent;
            }
        }
        int i82 = $dirty16;
        int i86 = i59 & 4096;
        if (i86 != 0) {
            i82 |= 384;
        } else {
            if (i54 & 384 == 0) {
                changed2 = restartGroup.changed(onTextLayout) ? 256 : 128;
                $dirty14 |= changed2;
            } else {
                z = onTextLayout;
            }
            $dirty13 = $dirty14;
        }
        int i87 = i59 & 8192;
        if (i87 != 0) {
            $dirty13 |= 3072;
        } else {
            textColor = $dirty13;
            if (i54 & 3072 == 0) {
                if (restartGroup.changed(style)) {
                } else {
                    i19 = changed5;
                }
                $dirty1 = i19;
            } else {
                int i83 = style;
                $dirty1 = textColor;
            }
        }
        int i88 = i59 & 16384;
        if (i88 != 0) {
            $dirty1 |= 24576;
            i38 = $composer;
        } else {
            if (i54 & 24576 == 0) {
                if (restartGroup.changed($composer)) {
                } else {
                    i11 = i26;
                }
                $dirty1 |= i11;
            } else {
                i38 = $composer;
            }
        }
        int i99 = obj73 & i98;
        if (i99 != 0) {
            $dirty1 |= i12;
            obj11 = $changed;
        } else {
            if (i54 & i12 == 0) {
                i11 = restartGroup.changedInstance($changed) ? cmp : i112;
                $dirty1 |= i11;
            } else {
                obj11 = $changed;
            }
        }
        i37 = obj73 & i112;
        if (i37 != 0) {
            $dirty1 |= i32;
            obj10 = $changed1;
        } else {
            if (obj72 & i32 == 0) {
                i26 = restartGroup.changedInstance($changed1) ? 1048576 : 524288;
                $dirty1 |= i26;
            } else {
                obj10 = $changed1;
            }
        }
        if (obj72 & i21 == 0) {
            if (obj73 & cmp == 0) {
                i16 = restartGroup.changed(i22) ? 8388608 : 4194304;
            } else {
                obj12 = i22;
            }
            $dirty1 |= i16;
        } else {
            obj12 = i22;
        }
        if (unbox-impl & lineHeight2 == 306783378 && i58 &= $dirty1 == 4793490) {
            if (i58 &= $dirty1 == 4793490) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj71 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i39 != 0) {
                                obj6 = unspecified-XSAIIZE;
                            }
                            if (i96 != 0) {
                                l = unspecified-XSAIIZE;
                            }
                            if (overflow3 != 0) {
                                anon = unspecified-XSAIIZE;
                            }
                            if (i30 != 0) {
                                obj7 = unspecified-XSAIIZE;
                            }
                            if (i110 != 0) {
                                obj = unspecified-XSAIIZE;
                            }
                            if (i10 != 0) {
                                i34 = unspecified-XSAIIZE;
                            }
                            if (i44 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i4 != 0 ? 0 : overflow;
                            textAlign4 = i42 != 0 ? 0 : softWrap;
                            if (i14 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i81 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = inlineContent;
                            }
                            softWrap2 = i86 != 0 ? 1 : onTextLayout;
                            maxLines2 = i87 != 0 ? 0x7fffffff /* Unknown resource */ : style;
                            minLines3 = i88 != 0 ? 1 : $composer;
                            if (i99 != 0) {
                                inlineContent3 = MapsKt.emptyMap();
                            } else {
                                inlineContent3 = $changed;
                            }
                            if (i37 != 0) {
                                onTextLayout3 = TextKt.Text.4.INSTANCE;
                            } else {
                                onTextLayout3 = $changed1;
                            }
                            if (obj73 & cmp != 0) {
                                i30 = 0;
                                obj51 = i74;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                changed2 = textDecoration2;
                                $dirty15 = softWrap2;
                                $dirty16 = lineHeight2;
                                i37 = obj49;
                                textDecoration3 = this_$iv;
                                textAlign2 = textAlign4;
                                fontWeight3 = i76;
                                overflow2 = overflow3;
                                textAlign3 = anon;
                                fontSize2 = inlineContent3;
                                obj2 = onTextLayout3;
                                inlineContent2 = obj7;
                                onTextLayout2 = i34;
                                fontStyle3 = minLines3;
                                minLines4 = maxLines2;
                                maxLines3 = obj3;
                            } else {
                                changed2 = textDecoration2;
                                textAlign2 = textAlign4;
                                overflow2 = overflow3;
                                $dirty15 = softWrap2;
                                $dirty16 = lineHeight2;
                                i37 = obj49;
                                textDecoration3 = i22;
                                textAlign3 = anon;
                                fontSize2 = inlineContent3;
                                obj2 = onTextLayout3;
                                inlineContent2 = obj7;
                                onTextLayout2 = i34;
                                fontStyle3 = minLines3;
                                minLines4 = maxLines2;
                                maxLines3 = obj;
                                fontWeight3 = obj70;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (obj73 & cmp != 0) {
                                i37 = textAlign;
                                changed2 = overflow;
                                $dirty16 = maxLines;
                                overflow2 = inlineContent;
                                $dirty15 = onTextLayout;
                                minLines4 = style;
                                textDecoration3 = i22;
                                inlineContent2 = obj7;
                                textAlign3 = anon;
                                maxLines3 = obj;
                                onTextLayout2 = i34;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj2 = $changed1;
                                fontWeight3 = i57;
                                textAlign2 = softWrap;
                            } else {
                                i37 = textAlign;
                                changed2 = overflow;
                                textAlign2 = softWrap;
                                $dirty16 = maxLines;
                                overflow2 = inlineContent;
                                minLines4 = style;
                                textDecoration3 = i22;
                                inlineContent2 = obj7;
                                textAlign3 = anon;
                                maxLines3 = obj;
                                onTextLayout2 = i34;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj2 = $changed1;
                                fontWeight3 = $dirty1;
                                $dirty15 = onTextLayout;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj62 = textAlign2;
                        ComposerKt.traceEventStart(2027001676, unbox-impl, fontWeight3, "androidx.compose.material3.Text (Text.kt:255)");
                    } else {
                        obj62 = textAlign2;
                    }
                    restartGroup.startReplaceGroup(-1827697581);
                    ComposerKt.sourceInformation(restartGroup, "");
                    consume = 0;
                    i34 = 0;
                    i18 = Long.compare($this$takeOrElse_u2dDxMtmZc$iv, i5) != 0 ? i36 : 0;
                    if (i18 != 0) {
                        obj70 = unbox-impl;
                        obj53 = overflow2;
                    } else {
                        i34 = 0;
                        obj70 = unbox-impl;
                        restartGroup.startReplaceGroup(-1827696808);
                        ComposerKt.sourceInformation(restartGroup, "*256@11820L7");
                        i18 = 0;
                        if (Long.compare(i5, i31) != 0) {
                        } else {
                            i36 = 0;
                        }
                        if (i36 != 0) {
                            obj50 = consume;
                            obj53 = overflow2;
                        } else {
                            i18 = 0;
                            obj49 = unbox-impl;
                            i36 = 6;
                            cmp = 0;
                            obj50 = consume;
                            obj53 = overflow2;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $this$takeOrElse_u2dDxMtmZc$iv = unbox-impl;
                        }
                        restartGroup.endReplaceGroup();
                        $this$takeOrElse_u2dDxMtmZc$iv2 = $this$takeOrElse_u2dDxMtmZc$iv;
                    }
                    restartGroup.endReplaceGroup();
                    if (obj62 != null) {
                        unspecified-e0LSkKk = obj62.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    skipping = fontWeight3;
                    obj59 = restartGroup;
                    obj54 = $dirty15;
                    obj55 = minLines4;
                    obj56 = fontStyle3;
                    obj57 = fontSize2;
                    obj52 = obj2;
                    BasicTextKt.BasicText-RWo7tUw(traceInProgress2, obj6, TextStyle.merge-dA7vx0o$default(textDecoration3, $this$takeOrElse_u2dDxMtmZc$iv2, i34, textAlign3, overflow3, maxLines3, inlineContent2, 0, onTextLayout2, 0, i37, lineHeight2, 0, 0, 0, 0, cmp, changed2, 0, 0, unspecified-e0LSkKk, 0, $dirty16, i14, 0, 0, 0), obj52, obj53, obj54, obj55, obj56, obj57, 0, obj59, i52 |= i71, 512);
                    composer = obj59;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i6 = skipping;
                    obj9 = textDecoration3;
                    obj7 = inlineContent2;
                    l3 = i37;
                    l4 = $dirty16;
                    style2 = obj62;
                    fontStyle2 = i89;
                    minLines2 = textAlign3;
                    i33 = i108;
                    fontSize3 = unbox-impl;
                    softWrap3 = map;
                    fontWeight2 = i73;
                    maxLines4 = obj6;
                    modifier2 = changed2;
                    fontFamily2 = $dirty1;
                    inlineContent4 = l;
                    color2 = obj3;
                    obj5 = obj8;
                } else {
                    restartGroup.skipToGroupEnd();
                    style2 = softWrap;
                    fontSize3 = inlineContent;
                    i33 = onTextLayout;
                    fontWeight2 = style;
                    fontStyle2 = $composer;
                    softWrap3 = $changed;
                    fontFamily2 = $changed1;
                    obj9 = i22;
                    obj70 = unbox-impl;
                    composer = restartGroup;
                    i6 = $dirty1;
                    inlineContent4 = l;
                    minLines2 = anon;
                    maxLines4 = obj6;
                    color2 = obj;
                    obj5 = i34;
                    l3 = textAlign;
                    modifier2 = overflow;
                    l4 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = obj70;
            endRestartGroup = new TextKt.Text.5(text, maxLines4, inlineContent4, $dirty1, minLines2, traceInProgress2, obj7, color2, obj5, l3, obj2, modifier2, style2, l4, i34, fontSize3, i33, fontWeight2, fontStyle2, softWrap3, fontFamily2, obj9, obj71, obj72, obj73);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty3 = obj70;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text-fLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj9;
        Object i30;
        int $dirty3;
        Object obj;
        int traceInProgress;
        int this_$iv;
        boolean traceInProgress2;
        int unspecified-XSAIIZE;
        ScopeUpdateScope endRestartGroup;
        Object obj4;
        int textDecoration2;
        Object obj2;
        Object obj6;
        int i29;
        int $dirty12;
        int $dirty14;
        long $dirty13;
        Object $composer2;
        int $dirty5;
        long $dirty;
        long l;
        Object onTextLayout3;
        Object onTextLayout2;
        long modifier3;
        boolean softWrap2;
        Object obj8;
        Object obj12;
        int i5;
        Object obj10;
        long fontStyle2;
        Object fontSize2;
        long l2;
        int i9;
        int i19;
        Object obj3;
        long fontStyle3;
        long fontSize3;
        int obj5;
        int fontFamily2;
        Object obj7;
        long modifier2;
        int letterSpacing2;
        int i17;
        int textAlign3;
        long l3;
        Object fontWeight2;
        int maxLines3;
        int maxLines2;
        int textAlign2;
        int i13;
        long letterSpacing4;
        long letterSpacing3;
        boolean lineHeight3;
        int i21;
        int i31;
        int i7;
        int i18;
        androidx.compose.material3.TextKt.Text.2 overflow2;
        int changedInstance;
        boolean changed;
        boolean overflow3;
        TextUnit.Companion companion;
        int overflow4;
        Object softWrap3;
        int i4;
        int $dirty1;
        int i22;
        boolean lineHeight2;
        int i8;
        Object i26;
        int i11;
        Object obj11;
        int style2;
        Composer composer;
        int i10;
        int i2;
        int i3;
        int i23;
        int i24;
        int i15;
        int i25;
        int i27;
        int i14;
        int $dirty2;
        int i28;
        int $dirty4;
        int i;
        int i12;
        int i6;
        int i16;
        int changed2;
        ScopeUpdateScope scopeUpdateScope;
        long l4;
        int obj44;
        int obj45;
        int obj63;
        int i32 = obj64;
        int i35 = obj65;
        int i53 = obj66;
        $composer2 = obj63.startRestartGroup(1968784669);
        ComposerKt.sourceInformation($composer2, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)156@7042L7,158@7058L322:Text.kt#uh7d8r");
        $dirty5 = obj64;
        int i86 = obj65;
        if (i53 & 1 != 0) {
            $dirty5 |= 6;
            obj8 = text;
        } else {
            if (i32 & 6 == 0) {
                i19 = $composer2.changed(text) ? 4 : 2;
                $dirty5 |= i19;
            } else {
                obj8 = text;
            }
        }
        int i91 = i53 & 2;
        if (i91 != 0) {
            $dirty5 |= 48;
            obj7 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i17 = $composer2.changed(modifier) ? 32 : 16;
                $dirty5 |= i17;
            } else {
                obj7 = modifier;
            }
        }
        textAlign3 = i53 & 4;
        int i93 = 128;
        if (textAlign3 != 0) {
            $dirty5 |= 384;
            i13 = i91;
            l2 = color;
        } else {
            if (i32 & 384 == 0) {
                i13 = i91;
                i21 = $composer2.changed(color) ? 256 : i93;
                $dirty5 |= i21;
            } else {
                i13 = i91;
                l2 = color;
            }
        }
        int i95 = i53 & 8;
        changedInstance = 1024;
        if (i95 != 0) {
            $dirty5 |= 3072;
            fontSize3 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i8 = $composer2.changed(fontStyle) ? i7 : changedInstance;
                $dirty5 |= i8;
            } else {
                fontSize3 = fontStyle;
            }
        }
        i26 = i53 & 16;
        int i102 = 8192;
        if (i26 != 0) {
            $dirty5 |= 24576;
            obj10 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i2 = $composer2.changed(fontFamily) ? i11 : i102;
                $dirty5 |= i2;
            } else {
                obj10 = fontFamily;
            }
        }
        i3 = i53 & 32;
        final int i103 = 65536;
        final int i104 = 196608;
        if (i3 != 0) {
            $dirty5 |= i104;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i104 == 0) {
                i15 = $composer2.changed(letterSpacing) ? i23 : i103;
                $dirty5 |= i15;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i105 = i53 & 64;
        i25 = 1572864;
        if (i105 != 0) {
            $dirty5 |= i25;
            obj6 = textDecoration;
        } else {
            if (i32 & i25 == 0) {
                i27 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty5 |= i27;
            } else {
                obj6 = textDecoration;
            }
        }
        int i33 = i53 & 128;
        int i106 = 12582912;
        if (i33 != 0) {
            $dirty2 = $dirty6;
            i14 = i86;
            $dirty = textAlign;
        } else {
            if (obj64 & i106 == 0) {
                i14 = i86;
                i = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i108 |= i;
            } else {
                $dirty2 = $dirty5;
                i14 = i86;
                $dirty = textAlign;
            }
        }
        int i34 = i53 & 256;
        int i111 = 100663296;
        if (i34 != 0) {
            $dirty2 |= i111;
            i12 = i34;
            obj9 = overflow;
        } else {
            if (obj64 & i111 == 0) {
                i12 = i34;
                i6 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty2 |= i6;
            } else {
                i12 = i34;
                obj9 = overflow;
            }
        }
        i30 = i53 & 512;
        int i113 = 805306368;
        if (i30 != 0) {
            $dirty2 |= i113;
            i16 = i30;
        } else {
            if (obj64 & i113 == 0) {
                i16 = i30;
                changed2 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty2 |= changed2;
            } else {
                i16 = i30;
                i30 = softWrap;
            }
        }
        $dirty3 = $dirty2;
        int i79 = i53 & 1024;
        if (i79 != 0) {
            $dirty1 = i14 | 6;
            l = maxLines;
        } else {
        }
        i29 = i53 & 2048;
        if (i29 != 0) {
            $dirty1 |= 48;
            i28 = i29;
        } else {
            if (i35 & 48 == 0) {
                i28 = i29;
                i10 = $composer2.changed(style) ? 32 : 16;
                $dirty1 |= i10;
            } else {
                i28 = i29;
                i29 = style;
            }
        }
        $dirty12 = $dirty1;
        int i83 = i53 & 4096;
        if (i83 != 0) {
            $dirty12 |= 384;
            softWrap2 = $composer;
        } else {
            if (i35 & 384 == 0) {
                i24 = $composer2.changed($composer) ? 256 : i93;
                $dirty12 |= i24;
            } else {
                softWrap2 = $composer;
            }
        }
        int i84 = i53 & 8192;
        if (i84 != 0) {
            $dirty12 |= 3072;
        } else {
            $dirty1 = $dirty12;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($changed)) {
                } else {
                    i7 = changedInstance;
                }
                $dirty14 = i7;
            } else {
                int i80 = $changed;
                $dirty14 = $dirty1;
            }
        }
        int i85 = i53 & 16384;
        if (i85 != 0) {
            $dirty14 |= 24576;
            obj4 = $changed1;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i11 = i102;
                }
                $dirty14 |= i11;
            } else {
                obj4 = $changed1;
            }
        }
        i22 = 32768;
        if (i35 & i104 == 0) {
            if (obj66 & i22 == 0) {
                if ($composer2.changed(i20)) {
                } else {
                    i23 = i103;
                }
            } else {
                obj = i20;
            }
            $dirty14 |= i23;
        } else {
            obj = i20;
        }
        if ($dirty3 & companion == 306783378 && i52 &= $dirty14 == 74898) {
            if (i52 &= $dirty14 == 74898) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj64 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                obj7 = unspecified-XSAIIZE;
                            }
                            if (textAlign3 != 0) {
                                l2 = unspecified-XSAIIZE;
                            }
                            if (i95 != 0) {
                                fontSize3 = unspecified-XSAIIZE;
                            }
                            if (i26 != 0) {
                                obj10 = unspecified-XSAIIZE;
                            }
                            if (i3 != 0) {
                                fontWeight2 = unspecified-XSAIIZE;
                            }
                            this_$iv = i105 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing3 = textAlign;
                            }
                            textDecoration2 = i12 != 0 ? 0 : overflow;
                            textAlign3 = i16 != 0 ? 0 : softWrap;
                            if (i79 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i28 != 0) {
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
                            if (obj66 & i22 != 0) {
                                int i98 = 6;
                                int i99 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj11 = this_$iv;
                                $dirty14 = textDecoration2;
                                i22 = maxLines2;
                                i18 = overflow4;
                                overflow3 = softWrap2;
                                softWrap2 = l2;
                                maxLines3 = textAlign3;
                                obj3 = obj10;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj5 = obj44;
                                fontWeight2 = obj45;
                                i26 = onTextLayout2;
                                onTextLayout3 = obj7;
                                modifier2 = letterSpacing3;
                                letterSpacing4 = l4;
                            } else {
                                obj63 = $dirty14;
                                obj11 = i20;
                                i22 = maxLines2;
                                i18 = overflow4;
                                overflow3 = softWrap2;
                                softWrap2 = l2;
                                maxLines3 = textAlign3;
                                obj3 = obj10;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj5 = obj44;
                                fontWeight2 = obj45;
                                i26 = onTextLayout2;
                                onTextLayout3 = obj7;
                                modifier2 = letterSpacing3;
                                letterSpacing4 = l4;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj66 & i22 != 0) {
                                maxLines3 = softWrap;
                                letterSpacing4 = maxLines;
                                i18 = style;
                                i22 = $changed;
                                i26 = $changed1;
                                obj11 = i20;
                                $dirty14 = this_$iv;
                                overflow3 = softWrap2;
                                softWrap2 = l2;
                                onTextLayout3 = obj7;
                                modifier2 = textAlign;
                                obj3 = obj10;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj5 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines3 = softWrap;
                                letterSpacing4 = maxLines;
                                i18 = style;
                                i22 = $changed;
                                i26 = $changed1;
                                obj11 = i20;
                                overflow3 = softWrap2;
                                softWrap2 = l2;
                                onTextLayout3 = obj7;
                                modifier2 = textAlign;
                                obj3 = obj10;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj5 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1968784669, $dirty3, $dirty14, "androidx.compose.material3.Text (Text.kt:157)");
                    }
                    TextKt.Text--4IGK_g(text, onTextLayout3, softWrap2, obj8, fontStyle2, l2, obj3, fontSize3, obj5, modifier2, textAlign3, fontWeight2, maxLines3, letterSpacing4, i95, i18, overflow3, i22, 1, i26, obj11);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj2 = onTextLayout3;
                    style2 = $dirty14;
                    $dirty13 = softWrap2;
                    modifier3 = fontStyle2;
                    obj12 = obj3;
                    fontSize2 = fontSize3;
                    i9 = obj5;
                    fontStyle3 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing2 = maxLines3;
                    l3 = letterSpacing4;
                    textAlign2 = i18;
                    lineHeight3 = overflow3;
                    i31 = i22;
                    overflow2 = i26;
                    softWrap3 = l4;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign2 = style;
                    i31 = $changed;
                    overflow2 = $changed1;
                    softWrap3 = i20;
                    style2 = $dirty14;
                    composer = $composer2;
                    lineHeight3 = softWrap2;
                    obj12 = obj10;
                    $dirty13 = l2;
                    modifier3 = fontSize3;
                    obj2 = obj7;
                    fontSize2 = fontWeight2;
                    i9 = textDecoration;
                    fontStyle3 = textAlign;
                    fontFamily2 = overflow;
                    letterSpacing2 = softWrap;
                    l3 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = $dirty3;
            $dirty3 = new TextKt.Text.3(text, obj2, $dirty13, $composer2, modifier3, softWrap2, obj12, fontSize2, i9, fontStyle3, fontSize3, fontFamily2, letterSpacing2, l3, fontWeight2, textAlign2, lineHeight3, i31, overflow2, softWrap3, obj64, obj65, obj66);
            endRestartGroup.updateScope((Function2)$dirty3);
        } else {
            $dirty4 = $dirty3;
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return TextKt.LocalTextStyle;
    }
}
