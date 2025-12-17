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
        int i;
        int traceInProgress2;
        boolean traceInProgress;
        int str;
        int i2;
        String str2;
        merge = -460300127;
        final Composer obj8 = $composer.startRestartGroup(merge);
        ComposerKt.sourceInformation(obj8, "C(ProvideTextStyle)P(1)347@14710L7,348@14735L80:Text.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i3 = obj8.changed(value) ? 4 : 2;
            $dirty |= i3;
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
                CompositionLocalKt.CompositionLocalProvider(TextKt.LocalTextStyle.provides((TextStyle)obj8.consume((CompositionLocal)TextKt.LocalTextStyle).merge(value)), content, obj8, $stable |= i2);
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
            traceInProgress2 = new TextKt.ProvideTextStyle.1(value, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text--4IGK_g(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Map inlineContent, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj9;
        Object i18;
        int $dirty5;
        Object obj4;
        Object obj13;
        boolean traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress;
        Object obj6;
        Object obj11;
        int textDecoration2;
        Object obj10;
        int i4;
        int $dirty13;
        int $dirty1;
        long $dirty14;
        Composer $composer2;
        int $dirty3;
        long $dirty2;
        long l2;
        long modifier3;
        Object inlineContent2;
        Object inlineContent3;
        boolean softWrap2;
        Object obj12;
        Object obj7;
        int i5;
        Object obj8;
        Object fontSize3;
        long fontStyle3;
        long l;
        int obj3;
        int i2;
        long fontStyle2;
        Object obj;
        long fontSize2;
        int fontFamily2;
        int i14;
        Object obj5;
        int letterSpacing2;
        long modifier2;
        int i30;
        long l3;
        int textAlign2;
        Object fontWeight2;
        int textAlign3;
        int maxLines2;
        int maxLines4;
        int i29;
        boolean lineHeight4;
        long letterSpacing3;
        long letterSpacing4;
        int i15;
        int i27;
        int i11;
        Object overflow2;
        Object onTextLayout3;
        int onTextLayout2;
        int changedInstance;
        Object softWrap3;
        boolean z;
        int i3;
        int $dirty12;
        int i6;
        Object maxLines3;
        long lineHeight3;
        int lineHeight2;
        int changed;
        boolean changed3;
        int i16;
        int overflow4;
        int overflow3;
        int i8;
        int style2;
        Object obj2;
        int i28;
        Composer composer;
        int i7;
        int i25;
        int i31;
        int i24;
        int i13;
        int i9;
        int i19;
        int i10;
        int i12;
        int $dirty;
        int i17;
        int $dirty4;
        int i;
        int i26;
        int i23;
        int i22;
        int changed2;
        ScopeUpdateScope scopeUpdateScope;
        int i20;
        int obj44;
        int obj45;
        int obj64;
        int i32 = obj65;
        int i35 = obj66;
        int i54 = obj67;
        $composer2 = obj64.startRestartGroup(224529679);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)304@13393L7,306@13409L345:Text.kt#uh7d8r");
        $dirty3 = obj65;
        int i89 = obj66;
        if (i54 & 1 != 0) {
            $dirty3 |= 6;
            obj12 = text;
        } else {
            if (i32 & 6 == 0) {
                i2 = $composer2.changed(text) ? 4 : 2;
                $dirty3 |= i2;
            } else {
                obj12 = text;
            }
        }
        int i94 = i54 & 2;
        if (i94 != 0) {
            $dirty3 |= 48;
            obj5 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i30 = $composer2.changed(modifier) ? 32 : 16;
                $dirty3 |= i30;
            } else {
                obj5 = modifier;
            }
        }
        textAlign2 = i54 & 4;
        int i96 = 128;
        if (textAlign2 != 0) {
            $dirty3 |= 384;
            i29 = i94;
            l = color;
        } else {
            if (i32 & 384 == 0) {
                i29 = i94;
                i15 = $composer2.changed(color) ? 256 : i96;
                $dirty3 |= i15;
            } else {
                i29 = i94;
                l = color;
            }
        }
        int i98 = i54 & 8;
        changedInstance = 1024;
        if (i98 != 0) {
            $dirty3 |= 3072;
            fontSize2 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i16 = $composer2.changed(fontStyle) ? i11 : changedInstance;
                $dirty3 |= i16;
            } else {
                fontSize2 = fontStyle;
            }
        }
        overflow4 = i54 & 16;
        int i109 = 8192;
        if (overflow4 != 0) {
            $dirty3 |= 24576;
            obj8 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i7 = $composer2.changed(fontFamily) ? i8 : i109;
                $dirty3 |= i7;
            } else {
                obj8 = fontFamily;
            }
        }
        i25 = i54 & 32;
        i24 = 196608;
        final int i110 = 65536;
        if (i25 != 0) {
            $dirty3 |= i24;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i24 == 0) {
                i9 = $composer2.changed(letterSpacing) ? i31 : i110;
                $dirty3 |= i9;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i111 = i54 & 64;
        final int i112 = 1572864;
        if (i111 != 0) {
            $dirty3 |= i112;
            obj10 = textDecoration;
        } else {
            if (i32 & i112 == 0) {
                i10 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty3 |= i10;
            } else {
                obj10 = textDecoration;
            }
        }
        int i33 = i54 & 128;
        int i113 = 12582912;
        if (i33 != 0) {
            $dirty = $dirty6;
            i12 = i89;
            $dirty2 = textAlign;
        } else {
            if (obj65 & i113 == 0) {
                i12 = i89;
                i = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i115 |= i;
            } else {
                $dirty = $dirty3;
                i12 = i89;
                $dirty2 = textAlign;
            }
        }
        int i34 = i54 & 256;
        int i118 = 100663296;
        if (i34 != 0) {
            $dirty |= i118;
            i26 = i34;
            obj9 = overflow;
        } else {
            if (obj65 & i118 == 0) {
                i26 = i34;
                i23 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty |= i23;
            } else {
                i26 = i34;
                obj9 = overflow;
            }
        }
        i18 = i54 & 512;
        int i120 = 805306368;
        if (i18 != 0) {
            $dirty |= i120;
            i22 = i18;
        } else {
            if (obj65 & i120 == 0) {
                i22 = i18;
                changed2 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty |= changed2;
            } else {
                i22 = i18;
                i18 = softWrap;
            }
        }
        $dirty5 = $dirty;
        int i82 = i54 & 1024;
        if (i82 != 0) {
            $dirty12 = i12 | 6;
            l2 = maxLines;
        } else {
        }
        i4 = i54 & 2048;
        if (i4 != 0) {
            $dirty12 |= 48;
            i17 = i4;
        } else {
            if (i35 & 48 == 0) {
                i17 = i4;
                i28 = $composer2.changed(onTextLayout) ? 32 : 16;
                $dirty12 |= i28;
            } else {
                i17 = i4;
                i4 = onTextLayout;
            }
        }
        $dirty13 = $dirty12;
        int i86 = i54 & 4096;
        if (i86 != 0) {
            $dirty13 |= 384;
            softWrap2 = style;
        } else {
            if (i35 & 384 == 0) {
                i13 = $composer2.changed(style) ? 256 : i96;
                $dirty13 |= i13;
            } else {
                softWrap2 = style;
            }
        }
        int i87 = i54 & 8192;
        if (i87 != 0) {
            $dirty13 |= 3072;
        } else {
            $dirty12 = $dirty13;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i11 = changedInstance;
                }
                $dirty1 = i11;
            } else {
                int i83 = $composer;
                $dirty1 = $dirty12;
            }
        }
        int i88 = i54 & 16384;
        if (i88 != 0) {
            $dirty1 |= 24576;
            obj6 = $changed;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed)) {
                } else {
                    i8 = i109;
                }
                $dirty1 |= i8;
            } else {
                obj6 = $changed;
            }
        }
        int i101 = obj67 & i100;
        if (i101 != 0) {
            $dirty1 |= i24;
            obj4 = $changed1;
        } else {
            if (i35 & i24 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i31 = i110;
                }
                $dirty1 |= i31;
            } else {
                obj4 = $changed1;
            }
        }
        if (obj66 & i112 == 0) {
            if (obj67 & i110 == 0) {
                i6 = $composer2.changed(i21) ? 1048576 : 524288;
            } else {
                obj13 = i21;
            }
            $dirty1 |= i6;
        } else {
            obj13 = i21;
        }
        if ($dirty5 & i104 == 306783378 && i36 &= $dirty1 == 599186) {
            if (i36 &= $dirty1 == 599186) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj65 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i29 != 0) {
                                obj5 = unspecified-0d7_KjU;
                            }
                            if (textAlign2 != 0) {
                                l = unspecified-0d7_KjU;
                            }
                            if (i98 != 0) {
                                fontSize2 = unspecified-0d7_KjU;
                            }
                            if (overflow4 != 0) {
                                obj8 = unspecified-0d7_KjU;
                            }
                            if (i25 != 0) {
                                fontWeight2 = unspecified-0d7_KjU;
                            }
                            this_$iv = i111 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing3 = textAlign;
                            }
                            textDecoration2 = i26 != 0 ? 0 : overflow;
                            textAlign2 = i22 != 0 ? 0 : softWrap;
                            if (i82 != 0) {
                                lineHeight3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight3 = maxLines;
                            }
                            if (i17 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = onTextLayout;
                            }
                            if (i86 != 0) {
                                softWrap2 = 1;
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
                                obj2 = this_$iv;
                                $dirty1 = textDecoration2;
                                z = softWrap2;
                                softWrap2 = l;
                                i8 = onTextLayout3;
                                onTextLayout2 = overflow3;
                                overflow4 = inlineContent2;
                                obj = obj8;
                                fontStyle3 = fontSize2;
                                inlineContent3 = obj5;
                                fontSize2 = fontWeight2;
                                i14 = obj44;
                                fontWeight2 = obj45;
                                maxLines4 = textAlign2;
                                modifier2 = letterSpacing3;
                                letterSpacing4 = lineHeight3;
                                lineHeight2 = i20;
                            } else {
                                obj64 = $dirty1;
                                obj2 = i21;
                                z = softWrap2;
                                softWrap2 = l;
                                i8 = onTextLayout3;
                                onTextLayout2 = overflow3;
                                overflow4 = inlineContent2;
                                obj = obj8;
                                fontStyle3 = fontSize2;
                                inlineContent3 = obj5;
                                fontSize2 = fontWeight2;
                                i14 = obj44;
                                fontWeight2 = obj45;
                                maxLines4 = textAlign2;
                                modifier2 = letterSpacing3;
                                letterSpacing4 = lineHeight3;
                                lineHeight2 = i20;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj67 & i110 != 0) {
                                maxLines4 = softWrap;
                                letterSpacing4 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight2 = $composer;
                                overflow4 = $changed;
                                i8 = $changed1;
                                obj2 = i21;
                                $dirty1 = this_$iv;
                                z = softWrap2;
                                softWrap2 = l;
                                inlineContent3 = obj5;
                                modifier2 = textAlign;
                                obj = obj8;
                                fontStyle3 = fontSize2;
                                fontSize2 = fontWeight2;
                                i14 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines4 = softWrap;
                                letterSpacing4 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight2 = $composer;
                                overflow4 = $changed;
                                i8 = $changed1;
                                obj2 = i21;
                                z = softWrap2;
                                softWrap2 = l;
                                inlineContent3 = obj5;
                                modifier2 = textAlign;
                                obj = obj8;
                                fontStyle3 = fontSize2;
                                fontSize2 = fontWeight2;
                                i14 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(224529679, $dirty5, $dirty1, "androidx.compose.material3.Text (Text.kt:305)");
                    }
                    TextKt.Text-IbK3jfQ(text, inlineContent3, softWrap2, obj12, fontStyle3, l, obj, fontSize2, i14, modifier2, textAlign2, fontWeight2, maxLines4, letterSpacing4, i98, onTextLayout2, z, lineHeight2, 1, overflow4, i8, obj2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj11 = inlineContent3;
                    style2 = $dirty1;
                    $dirty14 = softWrap2;
                    modifier3 = fontStyle3;
                    obj7 = obj;
                    fontSize3 = fontSize2;
                    obj3 = i14;
                    fontStyle2 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing2 = maxLines4;
                    l3 = letterSpacing4;
                    textAlign3 = onTextLayout2;
                    lineHeight4 = z;
                    i27 = lineHeight2;
                    overflow2 = overflow4;
                    softWrap3 = i8;
                    maxLines3 = i20;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign3 = onTextLayout;
                    i27 = $composer;
                    overflow2 = $changed;
                    softWrap3 = $changed1;
                    maxLines3 = i21;
                    style2 = $dirty1;
                    composer = $composer2;
                    lineHeight4 = softWrap2;
                    obj7 = obj8;
                    $dirty14 = l;
                    modifier3 = fontSize2;
                    obj11 = obj5;
                    fontSize3 = fontWeight2;
                    obj3 = textDecoration;
                    fontStyle2 = textAlign;
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
            $dirty4 = $dirty5;
            $dirty5 = new TextKt.Text.7(text, obj11, $dirty14, $composer2, modifier3, softWrap2, obj7, fontSize3, obj3, fontStyle2, fontSize2, fontFamily2, letterSpacing2, l3, fontWeight2, textAlign3, lineHeight4, i27, overflow2, softWrap3, maxLines3, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)$dirty5);
        } else {
            $dirty4 = $dirty5;
        }
    }

    public static final void Text--4IGK_g(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj6;
        Object i32;
        int traceInProgress2;
        Object endRestartGroup;
        int unspecified-e0LSkKk;
        Object obj9;
        Object obj12;
        boolean skipping;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress;
        long consume;
        int i48;
        Object obj7;
        int textDecoration2;
        Object obj2;
        int i19;
        int $dirty1;
        int $dirty12;
        long $dirty14;
        int $dirty2;
        long $dirty4;
        long l5;
        long minLines3;
        int minLines2;
        boolean z2;
        Object obj11;
        Object obj8;
        int i25;
        Object obj14;
        Object obj;
        long l2;
        int color2;
        int i28;
        long l4;
        long l3;
        int obj5;
        int i37;
        Object obj15;
        int modifier2;
        int i11;
        long textAlign3;
        int textAlign2;
        Object obj4;
        int maxLines2;
        int maxLines3;
        int letterSpacing2;
        boolean z;
        int cmp;
        int i41;
        int i16;
        int i30;
        int i29;
        int onTextLayout2;
        int onTextLayout3;
        int changed3;
        int obj13;
        int $this$takeOrElse_u2dDxMtmZc$iv;
        int i42;
        int $dirty13;
        int i33;
        Object obj10;
        long lineHeight2;
        int changed2;
        boolean changed4;
        int i23;
        int overflow2;
        int i27;
        Composer composer;
        int i38;
        int i50;
        int i39;
        int i35;
        int i40;
        int i47;
        int i9;
        int i31;
        int i;
        int $dirty15;
        int $dirty;
        int i26;
        int $dirty3;
        int i6;
        int i18;
        int i43;
        int i2;
        int changed;
        Object obj3;
        int i45;
        int i46;
        int i3;
        long l;
        int i22;
        int i20;
        int i17;
        int i4;
        int i49;
        int i15;
        int i5;
        int i7;
        int i34;
        long l6;
        int i12;
        int i24;
        int i8;
        int i13;
        int i44;
        int i14;
        int i10;
        int i36;
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
            obj11 = text;
        } else {
            if (i51 & 6 == 0) {
                i28 = restartGroup.changed(text) ? 4 : 2;
                $dirty2 |= i28;
            } else {
                obj11 = text;
            }
        }
        int i98 = i64 & 2;
        if (i98 != 0) {
            $dirty2 |= 48;
            obj15 = modifier;
        } else {
            if (i51 & 48 == 0) {
                i11 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i11;
            } else {
                obj15 = modifier;
            }
        }
        int i101 = i64 & 4;
        int i102 = 128;
        if (i101 != 0) {
            $dirty2 |= 384;
            letterSpacing2 = i98;
            l2 = color;
        } else {
            if (i51 & 384 == 0) {
                letterSpacing2 = i98;
                i41 = restartGroup.changed(color) ? 256 : i102;
                $dirty2 |= i41;
            } else {
                letterSpacing2 = i98;
                l2 = color;
            }
        }
        int i105 = i64 & 8;
        changed3 = 1024;
        if (i105 != 0) {
            $dirty2 |= 3072;
            l3 = fontStyle;
        } else {
            if (i51 & 3072 == 0) {
                i23 = restartGroup.changed(fontStyle) ? i29 : changed3;
                $dirty2 |= i23;
            } else {
                l3 = fontStyle;
            }
        }
        overflow2 = i64 & 16;
        int i108 = 8192;
        if (overflow2 != 0) {
            $dirty2 |= 24576;
            obj14 = fontFamily;
        } else {
            if (i51 & 24576 == 0) {
                i39 = restartGroup.changed(fontFamily) ? i27 : i108;
                $dirty2 |= i39;
            } else {
                obj14 = fontFamily;
            }
        }
        int i109 = i64 & 32;
        final int i110 = 196608;
        final int i111 = 65536;
        if (i109 != 0) {
            $dirty2 |= i110;
            obj4 = letterSpacing;
        } else {
            if (i51 & i110 == 0) {
                i47 = restartGroup.changed(letterSpacing) ? i35 : i111;
                $dirty2 |= i47;
            } else {
                obj4 = letterSpacing;
            }
        }
        int i112 = i64 & 64;
        final int i113 = 1572864;
        if (i112 != 0) {
            $dirty2 |= i113;
            obj2 = textDecoration;
        } else {
            if (i51 & i113 == 0) {
                i31 = restartGroup.changed(textDecoration) ? 1048576 : 524288;
                $dirty2 |= i31;
            } else {
                obj2 = textDecoration;
            }
        }
        int i52 = i64 & 128;
        int i114 = 12582912;
        if (i52 != 0) {
            $dirty = $dirty6;
            i = i87;
            $dirty4 = textAlign;
        } else {
            if (obj90 & i114 == 0) {
                i = i87;
                i6 = restartGroup.changed(textAlign) ? 8388608 : 4194304;
                i116 |= i6;
            } else {
                $dirty = $dirty2;
                i = i87;
                $dirty4 = textAlign;
            }
        }
        int i118 = i52;
        int i53 = i64 & 256;
        int i119 = 100663296;
        if (i53 != 0) {
            $dirty |= i119;
            i18 = i53;
            obj6 = overflow;
        } else {
            if (obj90 & i119 == 0) {
                i18 = i53;
                i43 = restartGroup.changed(overflow) ? 67108864 : 33554432;
                $dirty |= i43;
            } else {
                i18 = i53;
                obj6 = overflow;
            }
        }
        i32 = i64 & 512;
        int i121 = 805306368;
        if (i32 != 0) {
            $dirty |= i121;
            i2 = i32;
        } else {
            if (obj90 & i121 == 0) {
                i2 = i32;
                changed = restartGroup.changed(softWrap) ? 536870912 : 268435456;
                $dirty |= changed;
            } else {
                i2 = i32;
                i32 = softWrap;
            }
        }
        traceInProgress2 = $dirty;
        int i80 = i64 & 1024;
        if (i80 != 0) {
            $dirty13 = i | 6;
            l5 = maxLines;
        } else {
        }
        i19 = i64 & 2048;
        if (i19 != 0) {
            $dirty13 |= 48;
            i26 = i19;
        } else {
            if (i54 & 48 == 0) {
                i26 = i19;
                i38 = restartGroup.changed(onTextLayout) ? 32 : 16;
                $dirty13 |= i38;
            } else {
                i26 = i19;
                i19 = onTextLayout;
            }
        }
        $dirty1 = $dirty13;
        int i84 = i64 & 4096;
        if (i84 != 0) {
            $dirty1 |= 384;
            z2 = style;
        } else {
            if (i54 & 384 == 0) {
                i40 = restartGroup.changed(style) ? 256 : i102;
                $dirty1 |= i40;
            } else {
                z2 = style;
            }
        }
        int i85 = i64 & 8192;
        if (i85 != 0) {
            $dirty1 |= 3072;
        } else {
            $dirty13 = $dirty1;
            if (i54 & 3072 == 0) {
                if (restartGroup.changed($composer)) {
                } else {
                    i29 = changed3;
                }
                $dirty12 = i29;
            } else {
                int i81 = $composer;
                $dirty12 = $dirty13;
            }
        }
        int i86 = i64 & 16384;
        if (i86 != 0) {
            $dirty12 |= 24576;
            i48 = $changed;
        } else {
            if (i54 & 24576 == 0) {
                if (restartGroup.changed($changed)) {
                } else {
                    i27 = i108;
                }
                $dirty12 |= i27;
            } else {
                i48 = $changed;
            }
        }
        $this$takeOrElse_u2dDxMtmZc$iv = obj92 & i107;
        if ($this$takeOrElse_u2dDxMtmZc$iv != 0) {
            $dirty12 |= i110;
            obj9 = $changed1;
        } else {
            if (i54 & i110 == 0) {
                if (restartGroup.changedInstance($changed1)) {
                } else {
                    i35 = i111;
                }
                $dirty12 |= i35;
            } else {
                obj9 = $changed1;
            }
        }
        if (obj91 & i113 == 0) {
            if (obj92 & i111 == 0) {
                i33 = restartGroup.changed(i21) ? 1048576 : 524288;
            } else {
                obj12 = i21;
            }
            $dirty12 |= i33;
        } else {
            obj12 = i21;
        }
        if (traceInProgress2 & lineHeight2 == 306783378 && i55 &= $dirty12 == 599186) {
            if (i55 &= $dirty12 == 599186) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj90 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (letterSpacing2 != 0) {
                                obj15 = unspecified-0d7_KjU;
                            }
                            if (i101 != 0) {
                                l2 = unspecified-0d7_KjU;
                            }
                            if (i105 != 0) {
                                l3 = unspecified-0d7_KjU;
                            }
                            if (overflow2 != 0) {
                                obj14 = unspecified-0d7_KjU;
                            }
                            if (i109 != 0) {
                                obj4 = unspecified-0d7_KjU;
                            }
                            this_$iv = i112 != 0 ? 0 : textDecoration;
                            if (i118 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i18 != 0 ? 0 : overflow;
                            textAlign2 = i2 != 0 ? 0 : softWrap;
                            if (i80 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i26 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = onTextLayout;
                            }
                            if (i84 != 0) {
                                z2 = 1;
                            }
                            maxLines3 = i85 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            minLines2 = i86 != 0 ? 1 : $changed;
                            onTextLayout3 = $this$takeOrElse_u2dDxMtmZc$iv != 0 ? 0 : $changed1;
                            if (obj92 & i111 != 0) {
                                $this$takeOrElse_u2dDxMtmZc$iv = 6;
                                i27 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                i46 = obj69;
                                i49 = obj70;
                                $dirty15 = this_$iv;
                                $dirty12 = textDecoration2;
                                obj3 = obj14;
                                i18 = l3;
                                changed = obj4;
                                l = letterSpacing2;
                                l6 = lineHeight2;
                            } else {
                                obj89 = $dirty12;
                                i46 = obj69;
                                i49 = obj70;
                                $dirty15 = i21;
                                obj3 = obj14;
                                i18 = l3;
                                changed = obj4;
                                l = letterSpacing2;
                                l6 = lineHeight2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (obj92 & i111 != 0) {
                                i46 = textDecoration;
                                l = textAlign;
                                i49 = overflow;
                                textAlign2 = softWrap;
                                l6 = maxLines;
                                overflow2 = onTextLayout;
                                maxLines3 = $composer;
                                minLines2 = $changed;
                                onTextLayout3 = $changed1;
                                $dirty15 = i21;
                                $dirty12 = this_$iv;
                                obj3 = obj14;
                                i18 = l3;
                                changed = obj4;
                            } else {
                                i46 = textDecoration;
                                l = textAlign;
                                i49 = overflow;
                                textAlign2 = softWrap;
                                l6 = maxLines;
                                overflow2 = onTextLayout;
                                maxLines3 = $composer;
                                minLines2 = $changed;
                                onTextLayout3 = $changed1;
                                $dirty15 = i21;
                                obj3 = obj14;
                                i18 = l3;
                                changed = obj4;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2055108902, traceInProgress2, $dirty12, "androidx.compose.material3.Text (Text.kt:109)");
                    }
                    restartGroup.startReplaceGroup(-1827892941);
                    ComposerKt.sourceInformation(restartGroup, "");
                    consume = l2;
                    int i92 = 0;
                    obj4 = 0;
                    cmp = Long.compare(l3, i104) != 0 ? i30 : 0;
                    if (cmp != 0) {
                        obj89 = traceInProgress2;
                        i26 = consume;
                    } else {
                        l3 = 0;
                        restartGroup.startReplaceGroup(-1827892168);
                        ComposerKt.sourceInformation(restartGroup, "*111@5715L7");
                        i37 = 0;
                        obj4 = 0;
                        if (Long.compare(i27, i38) != 0) {
                        } else {
                            i30 = 0;
                        }
                        if (i30 != 0) {
                            obj89 = traceInProgress2;
                            obj69 = consume;
                        } else {
                            obj4 = 0;
                            obj89 = traceInProgress2;
                            cmp = 6;
                            i30 = 0;
                            obj69 = consume;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $this$takeOrElse_u2dDxMtmZc$iv = traceInProgress2;
                        }
                        restartGroup.endReplaceGroup();
                        i26 = $this$takeOrElse_u2dDxMtmZc$iv;
                    }
                    restartGroup.endReplaceGroup();
                    if (textAlign2 != 0) {
                        unspecified-e0LSkKk = textAlign2.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    obj78 = restartGroup;
                    BasicTextKt.BasicText-VhcvRP8(obj11, obj15, TextStyle.merge-dA7vx0o$default($dirty15, i26, i118, i18, i2, changed, obj3, 0, i46, 0, l, obj46, 0, 0, 0, 0, obj51, i49, 0, 0, unspecified-e0LSkKk, 0, l6, obj58, 0, 0, 0), onTextLayout3, overflow2, z2, maxLines3, minLines2, 0, obj78, i63 |= i76, 256);
                    composer = obj78;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i50 = $dirty12;
                    z = z2;
                    $dirty14 = l2;
                    obj7 = obj15;
                    modifier2 = textAlign2;
                    i16 = maxLines3;
                    obj13 = onTextLayout3;
                    maxLines2 = overflow2;
                    obj10 = $dirty15;
                    obj = changed;
                    obj8 = obj3;
                    color2 = i46;
                    l4 = l;
                    obj5 = i49;
                    textAlign3 = l6;
                    onTextLayout2 = minLines2;
                    minLines3 = i18;
                } else {
                    restartGroup.skipToGroupEnd();
                    maxLines2 = onTextLayout;
                    i16 = $composer;
                    onTextLayout2 = $changed;
                    obj13 = $changed1;
                    obj10 = i21;
                    obj89 = traceInProgress2;
                    i50 = $dirty12;
                    composer = restartGroup;
                    z = z2;
                    obj8 = obj14;
                    $dirty14 = l2;
                    minLines3 = l3;
                    obj7 = obj15;
                    obj = obj4;
                    color2 = textDecoration;
                    l4 = textAlign;
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
            $dirty3 = obj89;
            endRestartGroup = new TextKt.Text.1(text, obj7, $dirty14, restartGroup, minLines3, z2, obj8, obj, color2, l4, l3, obj5, modifier2, textAlign3, obj4, maxLines2, z, i16, onTextLayout2, obj13, obj10, obj90, obj91, obj92);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty3 = obj89;
        }
    }

    public static final void Text-IbK3jfQ(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i22) {
        Object obj3;
        Object i40;
        long unbox-impl;
        int unspecified-e0LSkKk;
        Object endRestartGroup;
        Object obj;
        Object obj8;
        Object obj2;
        int skipping;
        int textAlign4;
        Object consume;
        int unspecified-XSAIIZE;
        long letterSpacing2;
        int i28;
        int i5;
        int overflow2;
        Object maxLines3;
        long inlineContent2;
        int $dirty;
        long $dirty4;
        long l3;
        boolean z;
        int $dirty15;
        int $dirty16;
        int $dirty12;
        int $dirty1;
        int i18;
        int minLines3;
        int minLines4;
        long minLines2;
        Object traceInProgress2;
        int i34;
        Object obj9;
        int fontStyle3;
        long l;
        Object color2;
        int i35;
        Object obj6;
        long anon;
        Object fontSize2;
        long l4;
        Object obj10;
        Object obj5;
        int modifier2;
        int i2;
        Object textDecoration3;
        int textDecoration2;
        int style2;
        Object obj7;
        int fontWeight3;
        long l2;
        Object i3;
        boolean traceInProgress;
        int i4;
        long textAlign3;
        int textAlign2;
        int fontSize3;
        int i25;
        int overflow3;
        int i20;
        int i41;
        Object maxLines4;
        int maxLines2;
        int fontWeight2;
        int changed3;
        Object inlineContent3;
        Object inlineContent4;
        int fontStyle2;
        int changed5;
        int softWrap3;
        int i31;
        Map softWrap2;
        int i10;
        int $dirty14;
        Object onTextLayout3;
        Object onTextLayout2;
        androidx.compose.material3.TextKt.Text.4 fontFamily2;
        int i39;
        int i14;
        int i12;
        Object obj12;
        int i32;
        long i29;
        int i38;
        int i27;
        int lineHeight2;
        int changed4;
        int textColor;
        long $this$takeOrElse_u2dDxMtmZc$iv2;
        int i19;
        Composer composer;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i24;
        int i33;
        int cmp;
        int changed2;
        int i30;
        long i;
        int i17;
        int i11;
        int i42;
        int i23;
        int i15;
        int $dirty13;
        int $dirty3;
        int i13;
        int $dirty2;
        int i21;
        int i37;
        int i6;
        int i16;
        int i7;
        int changed;
        int i26;
        int i8;
        int i36;
        int i9;
        ScopeUpdateScope scopeUpdateScope;
        Object obj11;
        Object obj4;
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
                i35 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i35;
            } else {
                traceInProgress2 = text;
            }
        }
        int i94 = i59 & 2;
        if (i94 != 0) {
            $dirty |= 48;
            obj5 = modifier;
        } else {
            if (i43 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i2;
            } else {
                obj5 = modifier;
            }
        }
        int i96 = i59 & 4;
        if (i96 != 0) {
            $dirty |= 384;
            i4 = i94;
            l = color;
        } else {
            if (i43 & 384 == 0) {
                i4 = i94;
                i25 = restartGroup.changed(color) ? 256 : 128;
                $dirty |= i25;
            } else {
                i4 = i94;
                l = color;
            }
        }
        overflow3 = i59 & 8;
        changed3 = 1024;
        if (overflow3 != 0) {
            $dirty |= 3072;
            anon = fontStyle;
        } else {
            if (i43 & 3072 == 0) {
                i39 = restartGroup.changed(fontStyle) ? i41 : changed3;
                $dirty |= i39;
            } else {
                anon = fontStyle;
            }
        }
        i14 = i59 & 16;
        i38 = 8192;
        if (i14 != 0) {
            $dirty |= 24576;
            obj9 = fontFamily;
        } else {
            if (i43 & 24576 == 0) {
                i19 = restartGroup.changed(fontFamily) ? i32 : i38;
                $dirty |= i19;
            } else {
                obj9 = fontFamily;
            }
        }
        int i110 = i59 & 32;
        int i112 = 65536;
        i33 = 196608;
        cmp = 131072;
        if (i110 != 0) {
            $dirty |= i33;
            obj7 = letterSpacing;
        } else {
            if (i43 & i33 == 0) {
                i30 = restartGroup.changed(letterSpacing) ? cmp : i112;
                $dirty |= i30;
            } else {
                obj7 = letterSpacing;
            }
        }
        i17 = i59 & 64;
        i11 = 1572864;
        if (i17 != 0) {
            $dirty |= i11;
            i3 = textDecoration;
        } else {
            if (i43 & i11 == 0) {
                i23 = restartGroup.changed(textDecoration) ? 1048576 : 524288;
                $dirty |= i23;
            } else {
                i3 = textDecoration;
            }
        }
        int i44 = i59 & 128;
        i15 = 12582912;
        if (i44 != 0) {
            $dirty3 = $dirty6;
            $dirty13 = i85;
            $dirty4 = textAlign;
        } else {
            if (obj71 & i15 == 0) {
                $dirty13 = i85;
                i21 = restartGroup.changed(textAlign) ? 8388608 : 4194304;
                i115 |= i21;
            } else {
                $dirty3 = $dirty;
                $dirty13 = i85;
                $dirty4 = textAlign;
            }
        }
        int i45 = i59 & 256;
        int i116 = 100663296;
        if (i45 != 0) {
            $dirty3 |= i116;
            i6 = i45;
            obj3 = overflow;
        } else {
            if (obj71 & i116 == 0) {
                i6 = i45;
                i16 = restartGroup.changed(overflow) ? 67108864 : 33554432;
                $dirty3 |= i16;
            } else {
                i6 = i45;
                obj3 = overflow;
            }
        }
        i40 = i59 & 512;
        int i118 = 805306368;
        if (i40 != 0) {
            $dirty3 |= i118;
            i7 = i40;
        } else {
            if (obj71 & i118 == 0) {
                i7 = i40;
                changed = restartGroup.changed(softWrap) ? 536870912 : 268435456;
                $dirty3 |= changed;
            } else {
                i7 = i40;
                i40 = softWrap;
            }
        }
        unbox-impl = $dirty3;
        int i80 = i59 & 1024;
        if (i80 != 0) {
            i13 = i80;
            $dirty13 = $dirty1;
            l3 = maxLines;
        } else {
            $dirty1 = i54 & 6;
            if ($dirty1 == 0) {
                i13 = i80;
                i10 = restartGroup.changed(maxLines) ? 4 : 2;
                $dirty13 = changed5;
            } else {
                i13 = i80;
                l3 = maxLines;
            }
        }
        int i81 = i59 & 2048;
        if (i81 != 0) {
            $dirty13 |= 48;
            i18 = inlineContent;
        } else {
            if (i54 & 48 == 0) {
                textColor = restartGroup.changed(inlineContent) ? 32 : 16;
                $dirty13 |= textColor;
            } else {
                i18 = inlineContent;
            }
        }
        int i82 = $dirty13;
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
            $dirty15 = $dirty14;
        }
        int i87 = i59 & 8192;
        if (i87 != 0) {
            $dirty15 |= 3072;
        } else {
            textColor = $dirty15;
            if (i54 & 3072 == 0) {
                if (restartGroup.changed(style)) {
                } else {
                    i41 = changed3;
                }
                $dirty16 = i41;
            } else {
                int i83 = style;
                $dirty16 = textColor;
            }
        }
        int i88 = i59 & 16384;
        if (i88 != 0) {
            $dirty16 |= 24576;
            i28 = $composer;
        } else {
            if (i54 & 24576 == 0) {
                if (restartGroup.changed($composer)) {
                } else {
                    i32 = i38;
                }
                $dirty16 |= i32;
            } else {
                i28 = $composer;
            }
        }
        int i99 = obj73 & i98;
        if (i99 != 0) {
            $dirty16 |= i33;
            obj = $changed;
        } else {
            if (i54 & i33 == 0) {
                i32 = restartGroup.changedInstance($changed) ? cmp : i112;
                $dirty16 |= i32;
            } else {
                obj = $changed;
            }
        }
        i29 = obj73 & i112;
        if (i29 != 0) {
            $dirty16 |= i11;
            obj8 = $changed1;
        } else {
            if (obj72 & i11 == 0) {
                i38 = restartGroup.changedInstance($changed1) ? 1048576 : 524288;
                $dirty16 |= i38;
            } else {
                obj8 = $changed1;
            }
        }
        if (obj72 & i15 == 0) {
            if (obj73 & cmp == 0) {
                i27 = restartGroup.changed(i22) ? 8388608 : 4194304;
            } else {
                obj2 = i22;
            }
            $dirty16 |= i27;
        } else {
            obj2 = i22;
        }
        if (unbox-impl & lineHeight2 == 306783378 && i58 &= $dirty16 == 4793490) {
            if (i58 &= $dirty16 == 4793490) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj71 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i4 != 0) {
                                obj5 = unspecified-XSAIIZE;
                            }
                            if (i96 != 0) {
                                l = unspecified-XSAIIZE;
                            }
                            if (overflow3 != 0) {
                                anon = unspecified-XSAIIZE;
                            }
                            if (i14 != 0) {
                                obj9 = unspecified-XSAIIZE;
                            }
                            if (i110 != 0) {
                                obj7 = unspecified-XSAIIZE;
                            }
                            if (i17 != 0) {
                                i3 = unspecified-XSAIIZE;
                            }
                            if (i44 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i6 != 0 ? 0 : overflow;
                            textAlign2 = i7 != 0 ? 0 : softWrap;
                            if (i13 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i81 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = inlineContent;
                            }
                            softWrap3 = i86 != 0 ? 1 : onTextLayout;
                            maxLines2 = i87 != 0 ? 0x7fffffff /* Unknown resource */ : style;
                            minLines4 = i88 != 0 ? 1 : $composer;
                            if (i99 != 0) {
                                inlineContent4 = MapsKt.emptyMap();
                            } else {
                                inlineContent4 = $changed;
                            }
                            if (i29 != 0) {
                                onTextLayout2 = TextKt.Text.4.INSTANCE;
                            } else {
                                onTextLayout2 = $changed1;
                            }
                            if (obj73 & cmp != 0) {
                                i14 = 0;
                                obj51 = i74;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                changed2 = textDecoration2;
                                $dirty12 = softWrap3;
                                $dirty13 = lineHeight2;
                                i29 = obj49;
                                textDecoration3 = this_$iv;
                                textAlign4 = textAlign2;
                                fontWeight3 = i76;
                                overflow2 = overflow3;
                                textAlign3 = anon;
                                fontSize2 = inlineContent4;
                                obj10 = onTextLayout2;
                                inlineContent3 = obj9;
                                onTextLayout3 = i3;
                                fontStyle3 = minLines4;
                                minLines3 = maxLines2;
                                maxLines4 = obj11;
                            } else {
                                changed2 = textDecoration2;
                                textAlign4 = textAlign2;
                                overflow2 = overflow3;
                                $dirty12 = softWrap3;
                                $dirty13 = lineHeight2;
                                i29 = obj49;
                                textDecoration3 = i22;
                                textAlign3 = anon;
                                fontSize2 = inlineContent4;
                                obj10 = onTextLayout2;
                                inlineContent3 = obj9;
                                onTextLayout3 = i3;
                                fontStyle3 = minLines4;
                                minLines3 = maxLines2;
                                maxLines4 = obj7;
                                fontWeight3 = obj70;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (obj73 & cmp != 0) {
                                i29 = textAlign;
                                changed2 = overflow;
                                $dirty13 = maxLines;
                                overflow2 = inlineContent;
                                $dirty12 = onTextLayout;
                                minLines3 = style;
                                textDecoration3 = i22;
                                inlineContent3 = obj9;
                                textAlign3 = anon;
                                maxLines4 = obj7;
                                onTextLayout3 = i3;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj10 = $changed1;
                                fontWeight3 = i57;
                                textAlign4 = softWrap;
                            } else {
                                i29 = textAlign;
                                changed2 = overflow;
                                textAlign4 = softWrap;
                                $dirty13 = maxLines;
                                overflow2 = inlineContent;
                                minLines3 = style;
                                textDecoration3 = i22;
                                inlineContent3 = obj9;
                                textAlign3 = anon;
                                maxLines4 = obj7;
                                onTextLayout3 = i3;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj10 = $changed1;
                                fontWeight3 = $dirty16;
                                $dirty12 = onTextLayout;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj62 = textAlign4;
                        ComposerKt.traceEventStart(2027001676, unbox-impl, fontWeight3, "androidx.compose.material3.Text (Text.kt:255)");
                    } else {
                        obj62 = textAlign4;
                    }
                    restartGroup.startReplaceGroup(-1827697581);
                    ComposerKt.sourceInformation(restartGroup, "");
                    consume = 0;
                    i3 = 0;
                    i31 = Long.compare($this$takeOrElse_u2dDxMtmZc$iv, i) != 0 ? i12 : 0;
                    if (i31 != 0) {
                        obj70 = unbox-impl;
                        obj53 = overflow2;
                    } else {
                        i3 = 0;
                        obj70 = unbox-impl;
                        restartGroup.startReplaceGroup(-1827696808);
                        ComposerKt.sourceInformation(restartGroup, "*256@11820L7");
                        i31 = 0;
                        if (Long.compare(i, i42) != 0) {
                        } else {
                            i12 = 0;
                        }
                        if (i12 != 0) {
                            obj50 = consume;
                            obj53 = overflow2;
                        } else {
                            i31 = 0;
                            obj49 = unbox-impl;
                            i12 = 6;
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
                    obj54 = $dirty12;
                    obj55 = minLines3;
                    obj56 = fontStyle3;
                    obj57 = fontSize2;
                    obj52 = obj10;
                    BasicTextKt.BasicText-RWo7tUw(traceInProgress2, obj5, TextStyle.merge-dA7vx0o$default(textDecoration3, $this$takeOrElse_u2dDxMtmZc$iv2, i3, textAlign3, overflow3, maxLines4, inlineContent3, 0, onTextLayout3, 0, i29, lineHeight2, 0, 0, 0, 0, cmp, changed2, 0, 0, unspecified-e0LSkKk, 0, $dirty13, i13, 0, 0, 0), obj52, obj53, obj54, obj55, obj56, obj57, 0, obj59, i52 |= i71, 512);
                    composer = obj59;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i24 = skipping;
                    obj12 = textDecoration3;
                    obj9 = inlineContent3;
                    l4 = i29;
                    l2 = $dirty13;
                    style2 = obj62;
                    fontStyle2 = i89;
                    minLines2 = textAlign3;
                    i20 = i108;
                    fontSize3 = unbox-impl;
                    softWrap2 = map;
                    fontWeight2 = i73;
                    maxLines3 = obj5;
                    modifier2 = changed2;
                    fontFamily2 = $dirty16;
                    inlineContent2 = l;
                    color2 = obj11;
                    obj6 = obj4;
                } else {
                    restartGroup.skipToGroupEnd();
                    style2 = softWrap;
                    fontSize3 = inlineContent;
                    i20 = onTextLayout;
                    fontWeight2 = style;
                    fontStyle2 = $composer;
                    softWrap2 = $changed;
                    fontFamily2 = $changed1;
                    obj12 = i22;
                    obj70 = unbox-impl;
                    composer = restartGroup;
                    i24 = $dirty16;
                    inlineContent2 = l;
                    minLines2 = anon;
                    maxLines3 = obj5;
                    color2 = obj7;
                    obj6 = i3;
                    l4 = textAlign;
                    modifier2 = overflow;
                    l2 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj70;
            endRestartGroup = new TextKt.Text.5(text, maxLines3, inlineContent2, $dirty16, minLines2, traceInProgress2, obj9, color2, obj6, l4, obj10, modifier2, style2, l2, i3, fontSize3, i20, fontWeight2, fontStyle2, softWrap2, fontFamily2, obj12, obj71, obj72, obj73);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty2 = obj70;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text-fLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj6;
        Object i8;
        int $dirty3;
        Object obj7;
        int traceInProgress;
        int this_$iv;
        boolean traceInProgress2;
        int unspecified-XSAIIZE;
        ScopeUpdateScope endRestartGroup;
        Object obj;
        int textDecoration2;
        Object obj12;
        Object obj9;
        int i23;
        int $dirty1;
        int $dirty12;
        long $dirty14;
        Object $composer2;
        int $dirty;
        long $dirty4;
        long l4;
        Object onTextLayout2;
        Object onTextLayout3;
        long modifier3;
        boolean softWrap2;
        Object obj11;
        Object obj3;
        int i;
        Object obj2;
        long fontStyle2;
        Object fontSize2;
        long l;
        int i12;
        int i3;
        Object obj10;
        long fontStyle3;
        long fontSize3;
        int obj5;
        int fontFamily2;
        Object obj4;
        long modifier2;
        int letterSpacing3;
        int i17;
        int textAlign2;
        long l2;
        Object fontWeight2;
        int maxLines2;
        int maxLines3;
        int textAlign3;
        int i24;
        long letterSpacing4;
        long letterSpacing2;
        boolean lineHeight2;
        int i5;
        int i27;
        int i28;
        int i10;
        androidx.compose.material3.TextKt.Text.2 overflow3;
        int changedInstance;
        boolean changed;
        boolean overflow4;
        TextUnit.Companion companion;
        int overflow2;
        Object softWrap3;
        int i7;
        int $dirty13;
        int i25;
        boolean lineHeight3;
        int i15;
        Object i16;
        int i29;
        Object obj8;
        int style2;
        Composer composer;
        int i4;
        int i14;
        int i21;
        int i31;
        int i22;
        int i11;
        int i6;
        int i18;
        int i9;
        int $dirty2;
        int i2;
        int $dirty5;
        int i26;
        int i30;
        int i19;
        int i13;
        int changed2;
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
        $dirty = obj64;
        int i86 = obj65;
        if (i53 & 1 != 0) {
            $dirty |= 6;
            obj11 = text;
        } else {
            if (i32 & 6 == 0) {
                i3 = $composer2.changed(text) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj11 = text;
            }
        }
        int i91 = i53 & 2;
        if (i91 != 0) {
            $dirty |= 48;
            obj4 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i17 = $composer2.changed(modifier) ? 32 : 16;
                $dirty |= i17;
            } else {
                obj4 = modifier;
            }
        }
        textAlign2 = i53 & 4;
        int i93 = 128;
        if (textAlign2 != 0) {
            $dirty |= 384;
            i24 = i91;
            l = color;
        } else {
            if (i32 & 384 == 0) {
                i24 = i91;
                i5 = $composer2.changed(color) ? 256 : i93;
                $dirty |= i5;
            } else {
                i24 = i91;
                l = color;
            }
        }
        int i95 = i53 & 8;
        changedInstance = 1024;
        if (i95 != 0) {
            $dirty |= 3072;
            fontSize3 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i15 = $composer2.changed(fontStyle) ? i28 : changedInstance;
                $dirty |= i15;
            } else {
                fontSize3 = fontStyle;
            }
        }
        i16 = i53 & 16;
        int i102 = 8192;
        if (i16 != 0) {
            $dirty |= 24576;
            obj2 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i14 = $composer2.changed(fontFamily) ? i29 : i102;
                $dirty |= i14;
            } else {
                obj2 = fontFamily;
            }
        }
        i21 = i53 & 32;
        final int i103 = 65536;
        final int i104 = 196608;
        if (i21 != 0) {
            $dirty |= i104;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i104 == 0) {
                i11 = $composer2.changed(letterSpacing) ? i31 : i103;
                $dirty |= i11;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i105 = i53 & 64;
        i6 = 1572864;
        if (i105 != 0) {
            $dirty |= i6;
            obj9 = textDecoration;
        } else {
            if (i32 & i6 == 0) {
                i18 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty |= i18;
            } else {
                obj9 = textDecoration;
            }
        }
        int i33 = i53 & 128;
        int i106 = 12582912;
        if (i33 != 0) {
            $dirty2 = $dirty6;
            i9 = i86;
            $dirty4 = textAlign;
        } else {
            if (obj64 & i106 == 0) {
                i9 = i86;
                i26 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i108 |= i26;
            } else {
                $dirty2 = $dirty;
                i9 = i86;
                $dirty4 = textAlign;
            }
        }
        int i34 = i53 & 256;
        int i111 = 100663296;
        if (i34 != 0) {
            $dirty2 |= i111;
            i30 = i34;
            obj6 = overflow;
        } else {
            if (obj64 & i111 == 0) {
                i30 = i34;
                i19 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty2 |= i19;
            } else {
                i30 = i34;
                obj6 = overflow;
            }
        }
        i8 = i53 & 512;
        int i113 = 805306368;
        if (i8 != 0) {
            $dirty2 |= i113;
            i13 = i8;
        } else {
            if (obj64 & i113 == 0) {
                i13 = i8;
                changed2 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty2 |= changed2;
            } else {
                i13 = i8;
                i8 = softWrap;
            }
        }
        $dirty3 = $dirty2;
        int i79 = i53 & 1024;
        if (i79 != 0) {
            $dirty13 = i9 | 6;
            l4 = maxLines;
        } else {
        }
        i23 = i53 & 2048;
        if (i23 != 0) {
            $dirty13 |= 48;
            i2 = i23;
        } else {
            if (i35 & 48 == 0) {
                i2 = i23;
                i4 = $composer2.changed(style) ? 32 : 16;
                $dirty13 |= i4;
            } else {
                i2 = i23;
                i23 = style;
            }
        }
        $dirty1 = $dirty13;
        int i83 = i53 & 4096;
        if (i83 != 0) {
            $dirty1 |= 384;
            softWrap2 = $composer;
        } else {
            if (i35 & 384 == 0) {
                i22 = $composer2.changed($composer) ? 256 : i93;
                $dirty1 |= i22;
            } else {
                softWrap2 = $composer;
            }
        }
        int i84 = i53 & 8192;
        if (i84 != 0) {
            $dirty1 |= 3072;
        } else {
            $dirty13 = $dirty1;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($changed)) {
                } else {
                    i28 = changedInstance;
                }
                $dirty12 = i28;
            } else {
                int i80 = $changed;
                $dirty12 = $dirty13;
            }
        }
        int i85 = i53 & 16384;
        if (i85 != 0) {
            $dirty12 |= 24576;
            obj = $changed1;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i29 = i102;
                }
                $dirty12 |= i29;
            } else {
                obj = $changed1;
            }
        }
        i25 = 32768;
        if (i35 & i104 == 0) {
            if (obj66 & i25 == 0) {
                if ($composer2.changed(i20)) {
                } else {
                    i31 = i103;
                }
            } else {
                obj7 = i20;
            }
            $dirty12 |= i31;
        } else {
            obj7 = i20;
        }
        if ($dirty3 & companion == 306783378 && i52 &= $dirty12 == 74898) {
            if (i52 &= $dirty12 == 74898) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj64 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i24 != 0) {
                                obj4 = unspecified-XSAIIZE;
                            }
                            if (textAlign2 != 0) {
                                l = unspecified-XSAIIZE;
                            }
                            if (i95 != 0) {
                                fontSize3 = unspecified-XSAIIZE;
                            }
                            if (i16 != 0) {
                                obj2 = unspecified-XSAIIZE;
                            }
                            if (i21 != 0) {
                                fontWeight2 = unspecified-XSAIIZE;
                            }
                            this_$iv = i105 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i30 != 0 ? 0 : overflow;
                            textAlign2 = i13 != 0 ? 0 : softWrap;
                            if (i79 != 0) {
                                lineHeight3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight3 = maxLines;
                            }
                            if (i2 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = style;
                            }
                            if (i83 != 0) {
                                softWrap2 = 1;
                            }
                            maxLines3 = i84 != 0 ? 0x7fffffff /* Unknown resource */ : $changed;
                            if (i85 != 0) {
                                onTextLayout3 = TextKt.Text.2.INSTANCE;
                            } else {
                                onTextLayout3 = $changed1;
                            }
                            if (obj66 & i25 != 0) {
                                int i98 = 6;
                                int i99 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj8 = this_$iv;
                                $dirty12 = textDecoration2;
                                i25 = maxLines3;
                                i10 = overflow2;
                                overflow4 = softWrap2;
                                softWrap2 = l;
                                maxLines2 = textAlign2;
                                obj10 = obj2;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj5 = obj44;
                                fontWeight2 = obj45;
                                i16 = onTextLayout3;
                                onTextLayout2 = obj4;
                                modifier2 = letterSpacing2;
                                letterSpacing4 = l3;
                            } else {
                                obj63 = $dirty12;
                                obj8 = i20;
                                i25 = maxLines3;
                                i10 = overflow2;
                                overflow4 = softWrap2;
                                softWrap2 = l;
                                maxLines2 = textAlign2;
                                obj10 = obj2;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj5 = obj44;
                                fontWeight2 = obj45;
                                i16 = onTextLayout3;
                                onTextLayout2 = obj4;
                                modifier2 = letterSpacing2;
                                letterSpacing4 = l3;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj66 & i25 != 0) {
                                maxLines2 = softWrap;
                                letterSpacing4 = maxLines;
                                i10 = style;
                                i25 = $changed;
                                i16 = $changed1;
                                obj8 = i20;
                                $dirty12 = this_$iv;
                                overflow4 = softWrap2;
                                softWrap2 = l;
                                onTextLayout2 = obj4;
                                modifier2 = textAlign;
                                obj10 = obj2;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj5 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines2 = softWrap;
                                letterSpacing4 = maxLines;
                                i10 = style;
                                i25 = $changed;
                                i16 = $changed1;
                                obj8 = i20;
                                overflow4 = softWrap2;
                                softWrap2 = l;
                                onTextLayout2 = obj4;
                                modifier2 = textAlign;
                                obj10 = obj2;
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
                        ComposerKt.traceEventStart(1968784669, $dirty3, $dirty12, "androidx.compose.material3.Text (Text.kt:157)");
                    }
                    TextKt.Text--4IGK_g(text, onTextLayout2, softWrap2, obj11, fontStyle2, l, obj10, fontSize3, obj5, modifier2, textAlign2, fontWeight2, maxLines2, letterSpacing4, i95, i10, overflow4, i25, 1, i16, obj8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj12 = onTextLayout2;
                    style2 = $dirty12;
                    $dirty14 = softWrap2;
                    modifier3 = fontStyle2;
                    obj3 = obj10;
                    fontSize2 = fontSize3;
                    i12 = obj5;
                    fontStyle3 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing3 = maxLines2;
                    l2 = letterSpacing4;
                    textAlign3 = i10;
                    lineHeight2 = overflow4;
                    i27 = i25;
                    overflow3 = i16;
                    softWrap3 = l3;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign3 = style;
                    i27 = $changed;
                    overflow3 = $changed1;
                    softWrap3 = i20;
                    style2 = $dirty12;
                    composer = $composer2;
                    lineHeight2 = softWrap2;
                    obj3 = obj2;
                    $dirty14 = l;
                    modifier3 = fontSize3;
                    obj12 = obj4;
                    fontSize2 = fontWeight2;
                    i12 = textDecoration;
                    fontStyle3 = textAlign;
                    fontFamily2 = overflow;
                    letterSpacing3 = softWrap;
                    l2 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty5 = $dirty3;
            $dirty3 = new TextKt.Text.3(text, obj12, $dirty14, $composer2, modifier3, softWrap2, obj3, fontSize2, i12, fontStyle3, fontSize3, fontFamily2, letterSpacing3, l2, fontWeight2, textAlign3, lineHeight2, i27, overflow3, softWrap3, obj64, obj65, obj66);
            endRestartGroup.updateScope((Function2)$dirty3);
        } else {
            $dirty5 = $dirty3;
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return TextKt.LocalTextStyle;
    }
}
