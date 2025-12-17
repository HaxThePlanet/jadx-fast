package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
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
@Metadata(d1 = "\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\u0008\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00142\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010'\u001a\u00020&2\u0014\u0008\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\u0008\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\u0008\u0008\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u00101\u001aÜ\u0001\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00142\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0014\u0008\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\u0008\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\u0008\u0008\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00103\u001aÆ\u0001\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00142\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0014\u0008\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\u0008\u0008\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u001aÒ\u0001\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00142\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00142\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010'\u001a\u00020&2\u0016\u0008\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0008\u0008\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00106\"\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00067", d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextKt {

    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle;
    static {
        TextKt.LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)TextKt.LocalTextStyle.1.INSTANCE);
    }

    public static final void ProvideTextStyle(TextStyle value, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int merge;
        int $dirty;
        int i;
        int i2;
        int traceInProgress2;
        boolean traceInProgress;
        int str;
        int i3;
        String str2;
        merge = 1772272796;
        final Composer obj8 = $composer.startRestartGroup(merge);
        ComposerKt.sourceInformation(obj8, "C(ProvideTextStyle)P(1)397@17792L7,398@17817L80:Text.kt#jmzs0o");
        if ($changed & 6 == 0) {
            i = obj8.changed(value) ? 4 : 2;
            $dirty |= i;
        }
        if ($changed & 48 == 0) {
            i2 = obj8.changedInstance(content) ? 32 : 16;
            $dirty |= i2;
        }
        if ($dirty & 19 == 18) {
            if (!obj8.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(merge, $dirty, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:396)");
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
            traceInProgress2 = new TextKt.ProvideTextStyle.1(value, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text--4IGK_g(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Map inlineContent, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj13;
        Object i29;
        int $dirty5;
        Object obj5;
        Object obj12;
        boolean traceInProgress;
        ScopeUpdateScope endRestartGroup;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress2;
        Object obj3;
        Object obj11;
        int textDecoration2;
        Object obj9;
        int i6;
        int $dirty1;
        int $dirty13;
        long $dirty12;
        Composer $composer2;
        int $dirty2;
        long $dirty;
        long l;
        long modifier3;
        Object inlineContent3;
        Object inlineContent2;
        boolean softWrap3;
        Object obj10;
        Object obj;
        int i26;
        Object obj6;
        Object fontSize3;
        long fontStyle3;
        long l3;
        int obj2;
        int i23;
        long fontStyle2;
        Object obj4;
        long fontSize2;
        int fontFamily2;
        int i5;
        Object obj7;
        int letterSpacing3;
        long modifier2;
        int i30;
        long l2;
        int textAlign2;
        Object fontWeight2;
        int textAlign3;
        int maxLines3;
        int maxLines2;
        int i16;
        boolean lineHeight4;
        long letterSpacing4;
        long letterSpacing2;
        int i;
        int i31;
        int i19;
        Object overflow2;
        Object onTextLayout3;
        int onTextLayout2;
        int changedInstance;
        Object softWrap2;
        boolean z;
        int i2;
        int $dirty14;
        int i22;
        Object maxLines4;
        long lineHeight2;
        int lineHeight3;
        int changed2;
        boolean changed3;
        int i7;
        int overflow3;
        int overflow4;
        int i24;
        int style2;
        Object obj8;
        int i3;
        Composer composer;
        int i20;
        int i17;
        int i25;
        int i9;
        int i10;
        int i18;
        int i15;
        int i11;
        int i14;
        int $dirty4;
        int i28;
        int $dirty3;
        int i12;
        int i13;
        int i4;
        int i8;
        int changed;
        ScopeUpdateScope scopeUpdateScope;
        int i27;
        int obj44;
        int obj45;
        int obj64;
        int i32 = obj65;
        int i35 = obj66;
        int i54 = obj67;
        $composer2 = obj64.startRestartGroup(-422393234);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)354@16476L7,356@16492L345:Text.kt#jmzs0o");
        $dirty2 = obj65;
        int i89 = obj66;
        if (i54 & 1 != 0) {
            $dirty2 |= 6;
            obj10 = text;
        } else {
            if (i32 & 6 == 0) {
                i23 = $composer2.changed(text) ? 4 : 2;
                $dirty2 |= i23;
            } else {
                obj10 = text;
            }
        }
        int i94 = i54 & 2;
        if (i94 != 0) {
            $dirty2 |= 48;
            obj7 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i30 = $composer2.changed(modifier) ? 32 : 16;
                $dirty2 |= i30;
            } else {
                obj7 = modifier;
            }
        }
        textAlign2 = i54 & 4;
        int i96 = 128;
        if (textAlign2 != 0) {
            $dirty2 |= 384;
            i16 = i94;
            l3 = color;
        } else {
            if (i32 & 384 == 0) {
                i16 = i94;
                i = $composer2.changed(color) ? 256 : i96;
                $dirty2 |= i;
            } else {
                i16 = i94;
                l3 = color;
            }
        }
        int i98 = i54 & 8;
        changedInstance = 1024;
        if (i98 != 0) {
            $dirty2 |= 3072;
            fontSize2 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i7 = $composer2.changed(fontStyle) ? i19 : changedInstance;
                $dirty2 |= i7;
            } else {
                fontSize2 = fontStyle;
            }
        }
        overflow3 = i54 & 16;
        int i109 = 8192;
        if (overflow3 != 0) {
            $dirty2 |= 24576;
            obj6 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i20 = $composer2.changed(fontFamily) ? i24 : i109;
                $dirty2 |= i20;
            } else {
                obj6 = fontFamily;
            }
        }
        i17 = i54 & 32;
        i9 = 196608;
        final int i110 = 65536;
        if (i17 != 0) {
            $dirty2 |= i9;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i9 == 0) {
                i18 = $composer2.changed(letterSpacing) ? i25 : i110;
                $dirty2 |= i18;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i111 = i54 & 64;
        final int i112 = 1572864;
        if (i111 != 0) {
            $dirty2 |= i112;
            obj9 = textDecoration;
        } else {
            if (i32 & i112 == 0) {
                i11 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty2 |= i11;
            } else {
                obj9 = textDecoration;
            }
        }
        int i33 = i54 & 128;
        int i113 = 12582912;
        if (i33 != 0) {
            $dirty4 = $dirty6;
            i14 = i89;
            $dirty = textAlign;
        } else {
            if (obj65 & i113 == 0) {
                i14 = i89;
                i12 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i115 |= i12;
            } else {
                $dirty4 = $dirty2;
                i14 = i89;
                $dirty = textAlign;
            }
        }
        int i34 = i54 & 256;
        int i118 = 100663296;
        if (i34 != 0) {
            $dirty4 |= i118;
            i13 = i34;
            obj13 = overflow;
        } else {
            if (obj65 & i118 == 0) {
                i13 = i34;
                i4 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty4 |= i4;
            } else {
                i13 = i34;
                obj13 = overflow;
            }
        }
        i29 = i54 & 512;
        int i120 = 805306368;
        if (i29 != 0) {
            $dirty4 |= i120;
            i8 = i29;
        } else {
            if (obj65 & i120 == 0) {
                i8 = i29;
                changed = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty4 |= changed;
            } else {
                i8 = i29;
                i29 = softWrap;
            }
        }
        $dirty5 = $dirty4;
        int i82 = i54 & 1024;
        if (i82 != 0) {
            $dirty14 = i14 | 6;
            l = maxLines;
        } else {
        }
        i6 = i54 & 2048;
        if (i6 != 0) {
            $dirty14 |= 48;
            i28 = i6;
        } else {
            if (i35 & 48 == 0) {
                i28 = i6;
                i3 = $composer2.changed(onTextLayout) ? 32 : 16;
                $dirty14 |= i3;
            } else {
                i28 = i6;
                i6 = onTextLayout;
            }
        }
        $dirty1 = $dirty14;
        int i86 = i54 & 4096;
        if (i86 != 0) {
            $dirty1 |= 384;
            softWrap3 = style;
        } else {
            if (i35 & 384 == 0) {
                i10 = $composer2.changed(style) ? 256 : i96;
                $dirty1 |= i10;
            } else {
                softWrap3 = style;
            }
        }
        int i87 = i54 & 8192;
        if (i87 != 0) {
            $dirty1 |= 3072;
        } else {
            $dirty14 = $dirty1;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i19 = changedInstance;
                }
                $dirty13 = i19;
            } else {
                int i83 = $composer;
                $dirty13 = $dirty14;
            }
        }
        int i88 = i54 & 16384;
        if (i88 != 0) {
            $dirty13 |= 24576;
            obj3 = $changed;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed)) {
                } else {
                    i24 = i109;
                }
                $dirty13 |= i24;
            } else {
                obj3 = $changed;
            }
        }
        int i101 = obj67 & i100;
        if (i101 != 0) {
            $dirty13 |= i9;
            obj5 = $changed1;
        } else {
            if (i35 & i9 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i25 = i110;
                }
                $dirty13 |= i25;
            } else {
                obj5 = $changed1;
            }
        }
        if (obj66 & i112 == 0) {
            if (obj67 & i110 == 0) {
                i22 = $composer2.changed(i21) ? 1048576 : 524288;
            } else {
                obj12 = i21;
            }
            $dirty13 |= i22;
        } else {
            obj12 = i21;
        }
        if ($dirty5 & i104 == 306783378 && i36 &= $dirty13 == 599186) {
            if (i36 &= $dirty13 == 599186) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj65 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i16 != 0) {
                                obj7 = unspecified-0d7_KjU;
                            }
                            if (textAlign2 != 0) {
                                l3 = unspecified-0d7_KjU;
                            }
                            if (i98 != 0) {
                                fontSize2 = unspecified-0d7_KjU;
                            }
                            if (overflow3 != 0) {
                                obj6 = unspecified-0d7_KjU;
                            }
                            if (i17 != 0) {
                                fontWeight2 = unspecified-0d7_KjU;
                            }
                            this_$iv = i111 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing4 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing4 = textAlign;
                            }
                            textDecoration2 = i13 != 0 ? 0 : overflow;
                            textAlign2 = i8 != 0 ? 0 : softWrap;
                            if (i82 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i28 != 0) {
                                overflow4 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow4 = onTextLayout;
                            }
                            if (i86 != 0) {
                                softWrap3 = 1;
                            }
                            maxLines3 = i87 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            if (i88 != 0) {
                                inlineContent3 = MapsKt.emptyMap();
                            } else {
                                inlineContent3 = $changed;
                            }
                            if (i101 != 0) {
                                onTextLayout3 = TextKt.Text.8.INSTANCE;
                            } else {
                                onTextLayout3 = $changed1;
                            }
                            if (obj67 & i110 != 0) {
                                int i103 = 6;
                                int i108 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj8 = this_$iv;
                                $dirty13 = textDecoration2;
                                z = softWrap3;
                                softWrap3 = l3;
                                i24 = onTextLayout3;
                                onTextLayout2 = overflow4;
                                overflow3 = inlineContent3;
                                obj4 = obj6;
                                fontStyle3 = fontSize2;
                                inlineContent2 = obj7;
                                fontSize2 = fontWeight2;
                                i5 = obj44;
                                fontWeight2 = obj45;
                                maxLines2 = textAlign2;
                                modifier2 = letterSpacing4;
                                letterSpacing2 = lineHeight2;
                                lineHeight3 = i27;
                            } else {
                                obj64 = $dirty13;
                                obj8 = i21;
                                z = softWrap3;
                                softWrap3 = l3;
                                i24 = onTextLayout3;
                                onTextLayout2 = overflow4;
                                overflow3 = inlineContent3;
                                obj4 = obj6;
                                fontStyle3 = fontSize2;
                                inlineContent2 = obj7;
                                fontSize2 = fontWeight2;
                                i5 = obj44;
                                fontWeight2 = obj45;
                                maxLines2 = textAlign2;
                                modifier2 = letterSpacing4;
                                letterSpacing2 = lineHeight2;
                                lineHeight3 = i27;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj67 & i110 != 0) {
                                maxLines2 = softWrap;
                                letterSpacing2 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight3 = $composer;
                                overflow3 = $changed;
                                i24 = $changed1;
                                obj8 = i21;
                                $dirty13 = this_$iv;
                                z = softWrap3;
                                softWrap3 = l3;
                                inlineContent2 = obj7;
                                modifier2 = textAlign;
                                obj4 = obj6;
                                fontStyle3 = fontSize2;
                                fontSize2 = fontWeight2;
                                i5 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines2 = softWrap;
                                letterSpacing2 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight3 = $composer;
                                overflow3 = $changed;
                                i24 = $changed1;
                                obj8 = i21;
                                z = softWrap3;
                                softWrap3 = l3;
                                inlineContent2 = obj7;
                                modifier2 = textAlign;
                                obj4 = obj6;
                                fontStyle3 = fontSize2;
                                fontSize2 = fontWeight2;
                                i5 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-422393234, $dirty5, $dirty13, "androidx.compose.material.Text (Text.kt:355)");
                    }
                    TextKt.Text-IbK3jfQ(text, inlineContent2, softWrap3, obj10, fontStyle3, l3, obj4, fontSize2, i5, modifier2, textAlign2, fontWeight2, maxLines2, letterSpacing2, i98, onTextLayout2, z, lineHeight3, 1, overflow3, i24, obj8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj11 = inlineContent2;
                    style2 = $dirty13;
                    $dirty12 = softWrap3;
                    modifier3 = fontStyle3;
                    obj = obj4;
                    fontSize3 = fontSize2;
                    obj2 = i5;
                    fontStyle2 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing3 = maxLines2;
                    l2 = letterSpacing2;
                    textAlign3 = onTextLayout2;
                    lineHeight4 = z;
                    i31 = lineHeight3;
                    overflow2 = overflow3;
                    softWrap2 = i24;
                    maxLines4 = i27;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign3 = onTextLayout;
                    i31 = $composer;
                    overflow2 = $changed;
                    softWrap2 = $changed1;
                    maxLines4 = i21;
                    style2 = $dirty13;
                    composer = $composer2;
                    lineHeight4 = softWrap3;
                    obj = obj6;
                    $dirty12 = l3;
                    modifier3 = fontSize2;
                    obj11 = obj7;
                    fontSize3 = fontWeight2;
                    obj2 = textDecoration;
                    fontStyle2 = textAlign;
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
            $dirty3 = $dirty5;
            $dirty5 = new TextKt.Text.9(text, obj11, $dirty12, $composer2, modifier3, softWrap3, obj, fontSize3, obj2, fontStyle2, fontSize2, fontFamily2, letterSpacing3, l2, fontWeight2, textAlign3, lineHeight4, i31, overflow2, softWrap2, maxLines4, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)$dirty5);
        } else {
            $dirty3 = $dirty5;
        }
    }

    public static final void Text--4IGK_g(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj3;
        Object i33;
        int i11;
        Object endRestartGroup;
        Object it$iv;
        Object obj9;
        Object obj2;
        boolean copy-wmQWz5c$default;
        int style2;
        int i8;
        Object obj6;
        int i16;
        int str;
        long $composer3;
        Object $composer2;
        int $dirty3;
        long $dirty2;
        long l;
        boolean z;
        int $dirty18;
        int $dirty115;
        int $dirty19;
        int $dirty112;
        int i3;
        long minLines2;
        int minLines4;
        int i25;
        int minLines3;
        Object traceInProgress2;
        int i32;
        Object obj;
        int fontStyle3;
        long unspecified-0d7_KjU;
        Object color2;
        int i2;
        Object obj10;
        long unspecified-XSAIIZE;
        long l4;
        int fontSize3;
        int i22;
        Object obj4;
        int modifier2;
        int i5;
        int style3;
        int companion;
        Object fontWeight2;
        Object fontWeight4;
        Object obj5;
        long l5;
        Object fontFamily3;
        int fontFamily4;
        Object letterSpacing2;
        boolean traceInProgress;
        int i15;
        int unspecified-e0LSkKk;
        int companion2;
        int fontSize2;
        long l3;
        int i31;
        int z2;
        int textDecoration2;
        int i30;
        int fontWeight3;
        int maxLines2;
        Object maxLines3;
        int changed2;
        int fontStyle2;
        int onTextLayout3;
        Object onTextLayout2;
        int changed;
        int overflow2;
        int overflow3;
        int cmp;
        int i19;
        int $dirty116;
        Object fontFamily2;
        int softWrap3;
        Object softWrap2;
        int i24;
        int textAlign2;
        int i27;
        int i12;
        int i34;
        int lineHeight2;
        long lineHeight3;
        int changed3;
        int i6;
        int changed4;
        Composer composer;
        int i28;
        Composer.Companion companion3;
        int i23;
        int i;
        int $dirty17;
        int $dirty1;
        int changed5;
        int i17;
        int i7;
        int $dirty117;
        int $dirty12;
        int i20;
        int $dirty111;
        int $dirty;
        int $dirty110;
        int i18;
        int i10;
        int i26;
        int i13;
        int $dirty114;
        int $dirty113;
        int $dirty13;
        int $dirty14;
        int $dirty15;
        int $dirty16;
        int i29;
        int i14;
        int i4;
        long l2;
        int i9;
        ScopeUpdateScope scopeUpdateScope;
        Object obj8;
        Object obj7;
        Object obj53;
        long obj54;
        float obj55;
        int obj56;
        int obj57;
        int obj58;
        int obj59;
        int obj60;
        Object obj61;
        Composer obj62;
        int obj63;
        int obj64;
        int obj65;
        float obj66;
        Composer obj73;
        int i35 = obj74;
        int i38 = obj75;
        int i42 = obj76;
        $composer2 = obj73.startRestartGroup(1028090691);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)109@5711L7,128@6923L7,129@6977L7,156@7800L30,138@7204L632:Text.kt#jmzs0o");
        $dirty3 = obj74;
        int i60 = obj75;
        if (i42 & 1 != 0) {
            $dirty3 |= 6;
            traceInProgress2 = text;
        } else {
            if (i35 & 6 == 0) {
                i2 = $composer2.changed(text) ? 4 : 2;
                $dirty3 |= i2;
            } else {
                traceInProgress2 = text;
            }
        }
        int i69 = i42 & 2;
        if (i69 != 0) {
            $dirty3 |= 48;
            obj4 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i5 = $composer2.changed(modifier) ? 32 : 16;
                $dirty3 |= i5;
            } else {
                obj4 = modifier;
            }
        }
        companion = i42 & 4;
        if (companion != 0) {
            $dirty3 |= 384;
            companion2 = i69;
            unspecified-0d7_KjU = color;
        } else {
            if (i35 & 384 == 0) {
                companion2 = i69;
                i31 = $composer2.changed(color) ? 256 : 128;
                $dirty3 |= i31;
            } else {
                companion2 = i69;
                unspecified-0d7_KjU = color;
            }
        }
        textDecoration2 = i42 & 8;
        changed2 = 1024;
        if (textDecoration2 != 0) {
            $dirty3 |= 3072;
            unspecified-XSAIIZE = fontStyle;
        } else {
            if (i35 & 3072 == 0) {
                i24 = $composer2.changed(fontStyle) ? i30 : changed2;
                $dirty3 |= i24;
            } else {
                unspecified-XSAIIZE = fontStyle;
            }
        }
        textAlign2 = i42 & 16;
        i6 = 8192;
        if (textAlign2 != 0) {
            $dirty3 |= 24576;
            obj = fontFamily;
        } else {
            if (i35 & 24576 == 0) {
                i23 = $composer2.changed(fontFamily) ? i12 : i6;
                $dirty3 |= i23;
            } else {
                obj = fontFamily;
            }
        }
        i = i42 & 32;
        $dirty17 = 196608;
        $dirty1 = 65536;
        if (i != 0) {
            $dirty3 |= $dirty17;
            obj5 = letterSpacing;
        } else {
            if (i35 & $dirty17 == 0) {
                i17 = $composer2.changed(letterSpacing) ? 131072 : $dirty1;
                $dirty3 |= i17;
            } else {
                obj5 = letterSpacing;
            }
        }
        i7 = i42 & 64;
        $dirty117 = 1572864;
        if (i7 != 0) {
            $dirty3 |= $dirty117;
            letterSpacing2 = textDecoration;
        } else {
            if (i35 & $dirty117 == 0) {
                i20 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty3 |= i20;
            } else {
                letterSpacing2 = textDecoration;
            }
        }
        int i36 = i42 & 128;
        int i102 = 12582912;
        if (i36 != 0) {
            $dirty = $dirty5;
            $dirty111 = i60;
            $dirty2 = textAlign;
        } else {
            if (obj74 & i102 == 0) {
                $dirty111 = i60;
                i18 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i104 |= i18;
            } else {
                $dirty = $dirty3;
                $dirty111 = i60;
                $dirty2 = textAlign;
            }
        }
        int i37 = i42 & 256;
        int i106 = 100663296;
        if (i37 != 0) {
            $dirty |= i106;
            i26 = i37;
            obj3 = overflow;
        } else {
            if (obj74 & i106 == 0) {
                i26 = i37;
                i13 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty |= i13;
            } else {
                i26 = i37;
                obj3 = overflow;
            }
        }
        i33 = i42 & 512;
        int i108 = 805306368;
        if (i33 != 0) {
            $dirty |= i108;
            $dirty114 = i33;
        } else {
            if (obj74 & i108 == 0) {
                $dirty114 = i33;
                $dirty113 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty |= $dirty113;
            } else {
                $dirty114 = i33;
                i33 = softWrap;
            }
        }
        i11 = $dirty;
        int i53 = i42 & 1024;
        if (i53 != 0) {
            $dirty110 = i53;
            $dirty111 = $dirty112;
            l = maxLines;
        } else {
            $dirty112 = i38 & 6;
            if ($dirty112 == 0) {
                $dirty110 = i53;
                i19 = $composer2.changed(maxLines) ? 4 : 2;
                $dirty111 = changed;
            } else {
                $dirty110 = i53;
                l = maxLines;
            }
        }
        int i54 = i42 & 2048;
        if (i54 != 0) {
            $dirty111 |= 48;
            i3 = onTextLayout;
        } else {
            if (i38 & 48 == 0) {
                changed4 = $composer2.changed(onTextLayout) ? 32 : 16;
                $dirty111 |= changed4;
            } else {
                i3 = onTextLayout;
            }
        }
        int i55 = $dirty111;
        int i61 = i42 & 4096;
        if (i61 != 0) {
            i55 |= 384;
        } else {
            if (i38 & 384 == 0) {
                changed5 = $composer2.changed(style) ? 256 : 128;
                $dirty116 |= changed5;
            } else {
                z = style;
            }
            $dirty18 = $dirty116;
        }
        int i62 = i42 & 8192;
        if (i62 != 0) {
            $dirty18 |= 3072;
        } else {
            changed4 = $dirty18;
            if (i38 & 3072 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i30 = changed2;
                }
                $dirty115 = i30;
            } else {
                int i58 = $composer;
                $dirty115 = changed4;
            }
        }
        int i63 = i42 & 16384;
        if (i63 != 0) {
            $dirty115 |= 24576;
            i8 = $changed;
        } else {
            if (i38 & 24576 == 0) {
                if ($composer2.changed($changed)) {
                } else {
                    i12 = i6;
                }
                $dirty115 |= i12;
            } else {
                i8 = $changed;
            }
        }
        int i86 = obj76 & i85;
        if (i86 != 0) {
            $dirty115 |= $dirty17;
            obj9 = $changed1;
        } else {
            if (i38 & $dirty17 == 0) {
                i12 = $composer2.changedInstance($changed1) ? 131072 : $dirty1;
                $dirty115 |= i12;
            } else {
                obj9 = $changed1;
            }
        }
        if (obj75 & $dirty117 == 0) {
            if (obj76 & $dirty1 == 0) {
                i34 = $composer2.changed(i21) ? 1048576 : 524288;
            } else {
                obj2 = i21;
            }
            $dirty115 |= i34;
        } else {
            obj2 = i21;
        }
        if (i11 & lineHeight2 == 306783378 && i39 &= $dirty115 == 599186) {
            if (i39 &= $dirty115 == 599186) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    str = "CC:CompositionLocal.kt#9igjgp";
                    if (obj74 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (companion2 != 0) {
                                obj4 = companion2;
                            }
                            if (companion != 0) {
                                unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
                            }
                            if (textDecoration2 != 0) {
                                unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
                            }
                            if (textAlign2 != 0) {
                                obj = 0;
                            }
                            fontWeight2 = i != 0 ? 0 : obj5;
                            fontFamily3 = i7 != 0 ? 0 : letterSpacing2;
                            if (i36 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i26 != 0 ? 0 : overflow;
                            textAlign2 = $dirty114 != 0 ? 0 : softWrap;
                            if ($dirty110 != 0) {
                                lineHeight3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight3 = maxLines;
                            }
                            if (i54 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = onTextLayout;
                            }
                            softWrap3 = i61 != 0 ? 1 : style;
                            maxLines2 = i62 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            minLines4 = i63 != 0 ? 1 : $changed;
                            onTextLayout3 = i86 != 0 ? 0 : $changed1;
                            if (obj76 & $dirty1 != 0) {
                                changed4 = 6;
                                i = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                i7 = textDecoration2;
                                i10 = lineHeight3;
                                lineHeight2 = letterSpacing2;
                                l3 = unspecified-XSAIIZE;
                                i22 = onTextLayout3;
                                fontSize3 = minLines4;
                                onTextLayout2 = obj;
                                fontStyle3 = maxLines2;
                                minLines3 = softWrap3;
                                maxLines3 = fontWeight2;
                                softWrap2 = fontFamily3;
                                fontWeight4 = this_$iv;
                                fontFamily4 = i57;
                                $dirty19 = overflow3;
                                style2 = textAlign2;
                            } else {
                                i7 = textDecoration2;
                                $dirty19 = overflow3;
                                style2 = textAlign2;
                                i10 = lineHeight3;
                                lineHeight2 = letterSpacing2;
                                l3 = unspecified-XSAIIZE;
                                i22 = onTextLayout3;
                                fontSize3 = minLines4;
                                onTextLayout2 = obj;
                                fontStyle3 = maxLines2;
                                minLines3 = softWrap3;
                                maxLines3 = fontWeight2;
                                softWrap2 = fontFamily3;
                                fontFamily4 = $dirty17;
                                fontWeight4 = i21;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj76 & $dirty1 != 0) {
                                $dirty115 &= i25;
                            }
                            lineHeight2 = textAlign;
                            i7 = overflow;
                            style2 = softWrap;
                            i10 = maxLines;
                            minLines3 = style;
                            fontWeight4 = i21;
                            onTextLayout2 = obj;
                            l3 = unspecified-XSAIIZE;
                            maxLines3 = obj5;
                            softWrap2 = letterSpacing2;
                            fontStyle3 = $composer;
                            fontSize3 = $changed;
                            i22 = $changed1;
                            fontFamily4 = $dirty115;
                            $dirty19 = onTextLayout;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj65 = style2;
                        ComposerKt.traceEventStart(1028090691, i11, fontFamily4, "androidx.compose.material.Text (Text.kt:110)");
                    } else {
                        obj65 = style2;
                    }
                    int i71 = 6;
                    int i87 = 0;
                    i4 = i11;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i88 = 6;
                    int i96 = 0;
                    obj53 = unbox-impl;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    float floatValue = (Number)$composer2.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                    i15 = 0;
                    cmp = Long.compare(l6, i28) != 0 ? i27 : 0;
                    if (cmp != 0) {
                        l2 = obj53;
                        copy-wmQWz5c$default = unspecified-0d7_KjU;
                    } else {
                        i15 = 0;
                        if (Long.compare(color-0d7_KjU, i28) != 0) {
                        } else {
                            i27 = 0;
                        }
                        if (i27 != 0) {
                            copy-wmQWz5c$default = fontWeight4.getColor-0d7_KjU();
                            l2 = obj53;
                        } else {
                            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(obj53, color, floatValue, 0, 0, 0, 14);
                            l2 = obj53;
                        }
                    }
                    if (obj65 != null) {
                        unspecified-e0LSkKk = obj65.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    i9 = i115;
                    obj66 = floatValue;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1041441905, "CC(remember):Text.kt#9igjgp");
                    Composer composer3 = $composer2;
                    int i90 = 0;
                    it$iv = composer3.rememberedValue();
                    textAlign2 = 0;
                    if (!$composer2.changed(copy-wmQWz5c$default)) {
                        obj73 = $composer2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $composer2 = 0;
                            obj54 = it$iv;
                            it$iv = new TextKt.Text.1.1(copy-wmQWz5c$default, str);
                            composer3.updateRememberedValue((ColorProducer)it$iv);
                        } else {
                            obj54 = it$iv;
                        }
                    } else {
                        obj73 = $composer2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj73);
                    obj62 = obj73;
                    obj57 = $dirty19;
                    obj58 = minLines3;
                    obj59 = fontStyle3;
                    obj60 = fontSize3;
                    obj56 = i22;
                    BasicTextKt.BasicText-VhcvRP8(traceInProgress2, obj4, TextStyle.merge-dA7vx0o$default(fontWeight4, 0, unspecified-e0LSkKk, l3, textDecoration2, maxLines3, onTextLayout2, 0, softWrap2, 0, lineHeight2, i6, 0, 0, 0, 0, changed5, i7, 0, 0, unspecified-e0LSkKk, 0, i10, i26, 0, 0, 0), obj56, obj57, obj58, obj59, obj60, (ColorProducer)it$iv, obj62, i50 |= i83, 0);
                    composer = obj62;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj6 = obj4;
                    obj = onTextLayout2;
                    l4 = lineHeight2;
                    modifier2 = i7;
                    l5 = i10;
                    fontStyle2 = i64;
                    minLines2 = l3;
                    fontSize2 = i95;
                    overflow2 = i11;
                    z2 = i52;
                    style3 = obj65;
                    fontWeight3 = $dirty115;
                    $composer3 = unspecified-0d7_KjU;
                    color2 = obj7;
                    obj10 = softWrap2;
                    fontFamily2 = obj8;
                } else {
                    $composer2.skipToGroupEnd();
                    style3 = softWrap;
                    fontSize2 = onTextLayout;
                    z2 = style;
                    fontWeight3 = $composer;
                    fontStyle2 = $changed;
                    overflow2 = $changed1;
                    fontFamily2 = i21;
                    i4 = i11;
                    composer = $composer2;
                    i9 = $dirty115;
                    $composer3 = unspecified-0d7_KjU;
                    minLines2 = unspecified-XSAIIZE;
                    obj6 = obj4;
                    color2 = obj5;
                    obj10 = letterSpacing2;
                    l4 = textAlign;
                    modifier2 = overflow;
                    l5 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextKt.Text.2(text, obj6, $composer3, $dirty115, minLines2, traceInProgress2, obj, color2, obj10, l4, i22, modifier2, style3, l5, letterSpacing2, fontSize2, z2, fontWeight3, fontStyle2, overflow2, fontFamily2, obj74, obj75, obj76);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void Text-IbK3jfQ(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i22) {
        Object obj4;
        Object i19;
        Object it$iv;
        androidx.compose.material.TextKt.Text.5 i21;
        Object endRestartGroup;
        Object obj8;
        Object obj14;
        Object obj;
        int copy-wmQWz5c$default;
        int textAlign2;
        int unspecified-XSAIIZE;
        long letterSpacing2;
        int i20;
        int i15;
        int f;
        int localContentAlpha;
        Object obj7;
        int $composer2;
        long overflow2;
        int $dirty;
        long $dirty2;
        long l3;
        boolean z;
        int $dirty1;
        int $dirty16;
        int $dirty117;
        int $dirty116;
        int i14;
        int minLines4;
        int minLines3;
        long minLines2;
        Object obj11;
        int i9;
        Object obj3;
        int fontStyle3;
        long l;
        Object color2;
        int i6;
        Object obj5;
        long anon;
        Object fontSize2;
        long l5;
        Object obj2;
        Object obj10;
        int modifier2;
        int i8;
        Object textDecoration2;
        int textDecoration3;
        int style2;
        Object obj12;
        int fontWeight3;
        long l2;
        Object f2;
        boolean traceInProgress;
        int i13;
        int unspecified-e0LSkKk;
        int i27;
        long textAlign3;
        int textAlign4;
        int fontSize3;
        int i17;
        int overflow3;
        int i32;
        int i18;
        Object maxLines3;
        int maxLines2;
        int fontWeight2;
        int changed2;
        Object inlineContent3;
        Object inlineContent2;
        int fontStyle2;
        int changed3;
        int softWrap3;
        int cmp;
        Map softWrap2;
        int i2;
        int $dirty114;
        Object onTextLayout3;
        Object onTextLayout2;
        androidx.compose.material.TextKt.Text.5 fontFamily2;
        int i26;
        int i24;
        int i29;
        Object obj6;
        int i3;
        long i10;
        int i31;
        int i16;
        int lineHeight2;
        int changed4;
        int $dirty118;
        int i11;
        int i23;
        Composer $composer3;
        int $dirty17;
        int $dirty12;
        int changed;
        int i12;
        int $dirty112;
        int $dirty115;
        int i;
        int i25;
        int $dirty18;
        int $dirty15;
        int $dirty3;
        int i30;
        int $dirty4;
        int i33;
        int $dirty111;
        int $dirty14;
        int i28;
        int $dirty13;
        int $dirty19;
        int $dirty110;
        int $dirty113;
        int i7;
        int i5;
        long l4;
        int i4;
        ScopeUpdateScope scopeUpdateScope;
        Object obj9;
        Object obj13;
        long obj53;
        Object obj54;
        int obj55;
        androidx.compose.material.TextKt.Text.5 obj56;
        int obj57;
        int obj58;
        int obj59;
        float obj60;
        int obj61;
        int obj62;
        int obj63;
        int obj64;
        int obj65;
        int obj66;
        float obj67;
        int obj74;
        int i34 = obj75;
        int i37 = obj76;
        int i43 = obj77;
        $composer2 = obj74.startRestartGroup(744129681);
        ComposerKt.sourceInformation($composer2, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)280@13469L7,299@14681L7,300@14735L7,328@15590L30,309@14955L671:Text.kt#jmzs0o");
        $dirty = obj75;
        int i64 = obj76;
        if (i43 & 1 != 0) {
            $dirty |= 6;
            obj11 = text;
        } else {
            if (i34 & 6 == 0) {
                i6 = $composer2.changed(text) ? 4 : 2;
                $dirty |= i6;
            } else {
                obj11 = text;
            }
        }
        int i73 = i43 & 2;
        if (i73 != 0) {
            $dirty |= 48;
            obj10 = modifier;
        } else {
            if (i34 & 48 == 0) {
                i8 = $composer2.changed(modifier) ? 32 : 16;
                $dirty |= i8;
            } else {
                obj10 = modifier;
            }
        }
        int i75 = i43 & 4;
        if (i75 != 0) {
            $dirty |= 384;
            i27 = i73;
            l = color;
        } else {
            if (i34 & 384 == 0) {
                i27 = i73;
                i17 = $composer2.changed(color) ? 256 : 128;
                $dirty |= i17;
            } else {
                i27 = i73;
                l = color;
            }
        }
        overflow3 = i43 & 8;
        changed2 = 1024;
        if (overflow3 != 0) {
            $dirty |= 3072;
            anon = fontStyle;
        } else {
            if (i34 & 3072 == 0) {
                i26 = $composer2.changed(fontStyle) ? i18 : changed2;
                $dirty |= i26;
            } else {
                anon = fontStyle;
            }
        }
        i24 = i43 & 16;
        i31 = 8192;
        if (i24 != 0) {
            $dirty |= 24576;
            obj3 = fontFamily;
        } else {
            if (i34 & 24576 == 0) {
                i23 = $composer2.changed(fontFamily) ? i3 : i31;
                $dirty |= i23;
            } else {
                obj3 = fontFamily;
            }
        }
        int i108 = i43 & 32;
        $dirty17 = 65536;
        $dirty12 = 196608;
        final int i112 = 131072;
        if (i108 != 0) {
            $dirty |= $dirty12;
            obj12 = letterSpacing;
        } else {
            if (i34 & $dirty12 == 0) {
                i12 = $composer2.changed(letterSpacing) ? i112 : $dirty17;
                $dirty |= i12;
            } else {
                obj12 = letterSpacing;
            }
        }
        $dirty112 = i43 & 64;
        $dirty115 = 1572864;
        if ($dirty112 != 0) {
            $dirty |= $dirty115;
            f2 = textDecoration;
        } else {
            if (i34 & $dirty115 == 0) {
                i25 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty |= i25;
            } else {
                f2 = textDecoration;
            }
        }
        int i35 = i43 & 128;
        $dirty18 = 12582912;
        if (i35 != 0) {
            $dirty3 = $dirty6;
            $dirty15 = i64;
            $dirty2 = textAlign;
        } else {
            if (obj75 & $dirty18 == 0) {
                $dirty15 = i64;
                i33 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i117 |= i33;
            } else {
                $dirty3 = $dirty;
                $dirty15 = i64;
                $dirty2 = textAlign;
            }
        }
        int i36 = i43 & 256;
        int i119 = 100663296;
        if (i36 != 0) {
            $dirty3 |= i119;
            $dirty14 = i36;
            obj4 = overflow;
        } else {
            if (obj75 & i119 == 0) {
                $dirty14 = i36;
                i28 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty3 |= i28;
            } else {
                $dirty14 = i36;
                obj4 = overflow;
            }
        }
        i19 = i43 & 512;
        int i122 = 805306368;
        if (i19 != 0) {
            $dirty3 |= i122;
            $dirty13 = i19;
        } else {
            if (obj75 & i122 == 0) {
                $dirty13 = i19;
                $dirty19 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty3 |= $dirty19;
            } else {
                $dirty13 = i19;
                i19 = softWrap;
            }
        }
        i21 = $dirty3;
        int i59 = i43 & 1024;
        if (i59 != 0) {
            i30 = i59;
            $dirty15 = $dirty116;
            l3 = maxLines;
        } else {
            $dirty116 = i37 & 6;
            if ($dirty116 == 0) {
                i30 = i59;
                i2 = $composer2.changed(maxLines) ? 4 : 2;
                $dirty15 = changed3;
            } else {
                i30 = i59;
                l3 = maxLines;
            }
        }
        int i60 = i43 & 2048;
        if (i60 != 0) {
            $dirty15 |= 48;
            i14 = inlineContent;
        } else {
            if (i37 & 48 == 0) {
                $dirty118 = $composer2.changed(inlineContent) ? 32 : 16;
                $dirty15 |= $dirty118;
            } else {
                i14 = inlineContent;
            }
        }
        int i61 = $dirty15;
        int i65 = i43 & 4096;
        if (i65 != 0) {
            i61 |= 384;
        } else {
            if (i37 & 384 == 0) {
                changed = $composer2.changed(onTextLayout) ? 256 : 128;
                $dirty114 |= changed;
            } else {
                z = onTextLayout;
            }
            $dirty1 = $dirty114;
        }
        int i66 = i43 & 8192;
        if (i66 != 0) {
            $dirty1 |= 3072;
        } else {
            $dirty118 = $dirty1;
            if (i37 & 3072 == 0) {
                if ($composer2.changed(style)) {
                } else {
                    i18 = changed2;
                }
                $dirty16 = i18;
            } else {
                int i62 = style;
                $dirty16 = $dirty118;
            }
        }
        int i67 = i43 & 16384;
        if (i67 != 0) {
            $dirty16 |= 24576;
            i20 = $composer;
        } else {
            if (i37 & 24576 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i3 = i31;
                }
                $dirty16 |= i3;
            } else {
                i20 = $composer;
            }
        }
        int i94 = obj77 & i93;
        if (i94 != 0) {
            $dirty16 |= $dirty12;
            obj8 = $changed;
        } else {
            if (i37 & $dirty12 == 0) {
                i3 = $composer2.changedInstance($changed) ? i112 : $dirty17;
                $dirty16 |= i3;
            } else {
                obj8 = $changed;
            }
        }
        i10 = obj77 & $dirty17;
        if (i10 != 0) {
            $dirty16 |= $dirty115;
            obj14 = $changed1;
        } else {
            if (obj76 & $dirty115 == 0) {
                i31 = $composer2.changedInstance($changed1) ? 1048576 : 524288;
                $dirty16 |= i31;
            } else {
                obj14 = $changed1;
            }
        }
        if (obj76 & $dirty18 == 0) {
            if (obj77 & i112 == 0) {
                i16 = $composer2.changed(i22) ? 8388608 : 4194304;
            } else {
                obj = i22;
            }
            $dirty16 |= i16;
        } else {
            obj = i22;
        }
        if (i21 & lineHeight2 == 306783378 && i42 &= $dirty16 == 4793490) {
            if (i42 &= $dirty16 == 4793490) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj75 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i27 != 0) {
                                obj10 = unspecified-XSAIIZE;
                            }
                            if (i75 != 0) {
                                l = unspecified-XSAIIZE;
                            }
                            if (overflow3 != 0) {
                                anon = unspecified-XSAIIZE;
                            }
                            if (i24 != 0) {
                                obj3 = unspecified-XSAIIZE;
                            }
                            if (i108 != 0) {
                                obj12 = unspecified-XSAIIZE;
                            }
                            if ($dirty112 != 0) {
                                f2 = unspecified-XSAIIZE;
                            }
                            if (i35 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration3 = $dirty14 != 0 ? 0 : overflow;
                            textAlign4 = $dirty13 != 0 ? 0 : softWrap;
                            if (i30 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i60 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = inlineContent;
                            }
                            softWrap3 = i65 != 0 ? 1 : onTextLayout;
                            maxLines2 = i66 != 0 ? 0x7fffffff /* Unknown resource */ : style;
                            minLines3 = i67 != 0 ? 1 : $composer;
                            if (i94 != 0) {
                                inlineContent2 = MapsKt.emptyMap();
                            } else {
                                inlineContent2 = $changed;
                            }
                            if (i10 != 0) {
                                onTextLayout2 = TextKt.Text.5.INSTANCE;
                            } else {
                                onTextLayout2 = $changed1;
                            }
                            if (obj77 & i112 != 0) {
                                i24 = 0;
                                obj55 = i44;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                changed = textDecoration3;
                                $dirty117 = softWrap3;
                                $dirty15 = lineHeight2;
                                i10 = obj53;
                                textDecoration2 = this_$iv;
                                textAlign2 = textAlign4;
                                fontWeight3 = i46;
                                f = overflow3;
                                textAlign3 = anon;
                                fontSize2 = inlineContent2;
                                obj2 = onTextLayout2;
                                inlineContent3 = obj3;
                                onTextLayout3 = f2;
                                fontStyle3 = minLines3;
                                minLines4 = maxLines2;
                                maxLines3 = obj9;
                            } else {
                                changed = textDecoration3;
                                textAlign2 = textAlign4;
                                f = overflow3;
                                $dirty117 = softWrap3;
                                $dirty15 = lineHeight2;
                                i10 = obj53;
                                textDecoration2 = i22;
                                textAlign3 = anon;
                                fontSize2 = inlineContent2;
                                obj2 = onTextLayout2;
                                inlineContent3 = obj3;
                                onTextLayout3 = f2;
                                fontStyle3 = minLines3;
                                minLines4 = maxLines2;
                                maxLines3 = obj12;
                                fontWeight3 = obj74;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj77 & i112 != 0) {
                                i10 = textAlign;
                                changed = overflow;
                                $dirty15 = maxLines;
                                f = inlineContent;
                                $dirty117 = onTextLayout;
                                minLines4 = style;
                                textDecoration2 = i22;
                                inlineContent3 = obj3;
                                textAlign3 = anon;
                                maxLines3 = obj12;
                                onTextLayout3 = f2;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj2 = $changed1;
                                fontWeight3 = i40;
                                textAlign2 = softWrap;
                            } else {
                                i10 = textAlign;
                                changed = overflow;
                                textAlign2 = softWrap;
                                $dirty15 = maxLines;
                                f = inlineContent;
                                minLines4 = style;
                                textDecoration2 = i22;
                                inlineContent3 = obj3;
                                textAlign3 = anon;
                                maxLines3 = obj12;
                                onTextLayout3 = f2;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj2 = $changed1;
                                fontWeight3 = $dirty16;
                                $dirty117 = onTextLayout;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj66 = textAlign2;
                        ComposerKt.traceEventStart(744129681, i21, fontWeight3, "androidx.compose.material.Text (Text.kt:281)");
                    } else {
                        obj66 = textAlign2;
                    }
                    int i76 = 6;
                    int i95 = 0;
                    obj74 = i21;
                    obj57 = f;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i77 = 6;
                    int i96 = 0;
                    obj58 = unbox-impl;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    float floatValue = (Number)$composer2.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                    i13 = 0;
                    cmp = Long.compare(l6, i11) != 0 ? i29 : 0;
                    if (cmp != 0) {
                        l4 = obj58;
                        copy-wmQWz5c$default = l;
                    } else {
                        i13 = 0;
                        if (Long.compare(color-0d7_KjU, i11) != 0) {
                        } else {
                            i29 = 0;
                        }
                        if (i29 != 0) {
                            copy-wmQWz5c$default = textDecoration2.getColor-0d7_KjU();
                            l4 = obj58;
                        } else {
                            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(obj58, letterSpacing, floatValue, 0, 0, 0, 14);
                            l4 = obj58;
                        }
                    }
                    if (obj66 != null) {
                        unspecified-e0LSkKk = obj66.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    i4 = i127;
                    obj67 = floatValue;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1041691185, "CC(remember):Text.kt#9igjgp");
                    Composer composer = $composer2;
                    int i98 = 0;
                    it$iv = composer.rememberedValue();
                    int i106 = 0;
                    if (!$composer2.changed(copy-wmQWz5c$default)) {
                        $composer3 = $composer2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $composer2 = 0;
                            obj54 = it$iv;
                            it$iv = new TextKt.Text.6.1(copy-wmQWz5c$default, localContentAlpha);
                            composer.updateRememberedValue((ColorProducer)it$iv);
                        } else {
                            obj54 = it$iv;
                        }
                    } else {
                        $composer3 = $composer2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    obj58 = $dirty117;
                    obj59 = minLines4;
                    obj60 = fontStyle3;
                    obj61 = fontSize2;
                    obj56 = obj2;
                    BasicTextKt.BasicText-RWo7tUw(obj11, obj10, TextStyle.merge-dA7vx0o$default(textDecoration2, 0, unspecified-e0LSkKk, textAlign3, overflow3, maxLines3, inlineContent3, 0, onTextLayout3, 0, i10, lineHeight2, 0, 0, 0, 0, i112, changed, 0, 0, unspecified-e0LSkKk, 0, $dirty15, i30, 0, 0, 0), obj56, obj57, obj58, obj59, obj60, obj61, (ColorProducer)it$iv, $composer3, i55 |= i91, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj7 = obj10;
                    obj6 = textDecoration2;
                    obj3 = inlineContent3;
                    l5 = i10;
                    modifier2 = changed;
                    l2 = $dirty15;
                    style2 = obj66;
                    fontStyle2 = i68;
                    fontFamily2 = i21;
                    fontSize3 = i57;
                    i32 = i104;
                    softWrap2 = obj11;
                    minLines2 = l7;
                    fontWeight2 = $dirty16;
                    overflow2 = l;
                    color2 = obj13;
                    obj5 = obj9;
                } else {
                    $composer2.skipToGroupEnd();
                    style2 = softWrap;
                    fontSize3 = inlineContent;
                    i32 = onTextLayout;
                    fontWeight2 = style;
                    fontStyle2 = $composer;
                    softWrap2 = $changed;
                    fontFamily2 = $changed1;
                    obj6 = i22;
                    obj74 = i21;
                    $composer3 = $composer2;
                    i4 = $dirty16;
                    overflow2 = l;
                    minLines2 = anon;
                    obj7 = obj10;
                    color2 = obj12;
                    obj5 = f2;
                    l5 = textAlign;
                    modifier2 = overflow;
                    l2 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = obj74;
            endRestartGroup = new TextKt.Text.7(text, obj7, overflow2, $dirty16, minLines2, obj11, obj3, color2, obj5, l5, obj2, modifier2, style2, l2, f2, fontSize3, i32, fontWeight2, fontStyle2, softWrap2, fontFamily2, obj6, obj75, obj76, obj77);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty4 = obj74;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text-fLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj2;
        Object i28;
        int $dirty3;
        Object obj8;
        int traceInProgress2;
        int this_$iv;
        boolean traceInProgress;
        int unspecified-XSAIIZE;
        ScopeUpdateScope endRestartGroup;
        Object obj6;
        int textDecoration2;
        Object obj4;
        Object obj3;
        int i17;
        int $dirty12;
        int $dirty1;
        long $dirty13;
        Object $composer2;
        int $dirty4;
        long $dirty5;
        long l4;
        Object onTextLayout3;
        Object onTextLayout2;
        long modifier2;
        boolean softWrap3;
        Object obj11;
        Object obj;
        int i11;
        Object obj7;
        long fontStyle3;
        Object fontSize2;
        long l;
        int i2;
        int i5;
        Object obj5;
        long fontStyle2;
        long fontSize3;
        int obj10;
        int fontFamily2;
        Object obj9;
        long modifier3;
        int letterSpacing3;
        int i10;
        int textAlign3;
        long l2;
        Object fontWeight2;
        int maxLines2;
        int maxLines3;
        int textAlign2;
        int i3;
        long letterSpacing2;
        long letterSpacing4;
        boolean lineHeight2;
        int i29;
        int i30;
        int i4;
        int i25;
        androidx.compose.material.TextKt.Text.3 overflow2;
        int changedInstance;
        boolean changed2;
        boolean overflow3;
        TextUnit.Companion companion;
        int overflow4;
        Object softWrap2;
        int i7;
        int $dirty14;
        int i31;
        boolean lineHeight3;
        int i22;
        Object i6;
        int i16;
        Object obj12;
        int style2;
        Composer composer;
        int i12;
        int i26;
        int i24;
        int i;
        int i8;
        int i23;
        int i21;
        int i13;
        int i27;
        int $dirty;
        int i14;
        int $dirty2;
        int i9;
        int i18;
        int i19;
        int i15;
        int changed;
        ScopeUpdateScope scopeUpdateScope;
        long l3;
        int obj44;
        int obj45;
        int obj63;
        int i32 = obj64;
        int i35 = obj65;
        int i53 = obj66;
        $composer2 = obj63.startRestartGroup(-366126944);
        ComposerKt.sourceInformation($composer2, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)181@8616L7,183@8632L322:Text.kt#jmzs0o");
        $dirty4 = obj64;
        int i86 = obj65;
        if (i53 & 1 != 0) {
            $dirty4 |= 6;
            obj11 = text;
        } else {
            if (i32 & 6 == 0) {
                i5 = $composer2.changed(text) ? 4 : 2;
                $dirty4 |= i5;
            } else {
                obj11 = text;
            }
        }
        int i91 = i53 & 2;
        if (i91 != 0) {
            $dirty4 |= 48;
            obj9 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i10 = $composer2.changed(modifier) ? 32 : 16;
                $dirty4 |= i10;
            } else {
                obj9 = modifier;
            }
        }
        textAlign3 = i53 & 4;
        int i93 = 128;
        if (textAlign3 != 0) {
            $dirty4 |= 384;
            i3 = i91;
            l = color;
        } else {
            if (i32 & 384 == 0) {
                i3 = i91;
                i29 = $composer2.changed(color) ? 256 : i93;
                $dirty4 |= i29;
            } else {
                i3 = i91;
                l = color;
            }
        }
        int i95 = i53 & 8;
        changedInstance = 1024;
        if (i95 != 0) {
            $dirty4 |= 3072;
            fontSize3 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i22 = $composer2.changed(fontStyle) ? i4 : changedInstance;
                $dirty4 |= i22;
            } else {
                fontSize3 = fontStyle;
            }
        }
        i6 = i53 & 16;
        int i102 = 8192;
        if (i6 != 0) {
            $dirty4 |= 24576;
            obj7 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i26 = $composer2.changed(fontFamily) ? i16 : i102;
                $dirty4 |= i26;
            } else {
                obj7 = fontFamily;
            }
        }
        i24 = i53 & 32;
        final int i103 = 65536;
        final int i104 = 196608;
        if (i24 != 0) {
            $dirty4 |= i104;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i104 == 0) {
                i23 = $composer2.changed(letterSpacing) ? i : i103;
                $dirty4 |= i23;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i105 = i53 & 64;
        i21 = 1572864;
        if (i105 != 0) {
            $dirty4 |= i21;
            obj3 = textDecoration;
        } else {
            if (i32 & i21 == 0) {
                i13 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty4 |= i13;
            } else {
                obj3 = textDecoration;
            }
        }
        int i33 = i53 & 128;
        int i106 = 12582912;
        if (i33 != 0) {
            $dirty = $dirty6;
            i27 = i86;
            $dirty5 = textAlign;
        } else {
            if (obj64 & i106 == 0) {
                i27 = i86;
                i9 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i108 |= i9;
            } else {
                $dirty = $dirty4;
                i27 = i86;
                $dirty5 = textAlign;
            }
        }
        int i34 = i53 & 256;
        int i111 = 100663296;
        if (i34 != 0) {
            $dirty |= i111;
            i18 = i34;
            obj2 = overflow;
        } else {
            if (obj64 & i111 == 0) {
                i18 = i34;
                i19 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty |= i19;
            } else {
                i18 = i34;
                obj2 = overflow;
            }
        }
        i28 = i53 & 512;
        int i113 = 805306368;
        if (i28 != 0) {
            $dirty |= i113;
            i15 = i28;
        } else {
            if (obj64 & i113 == 0) {
                i15 = i28;
                changed = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty |= changed;
            } else {
                i15 = i28;
                i28 = softWrap;
            }
        }
        $dirty3 = $dirty;
        int i79 = i53 & 1024;
        if (i79 != 0) {
            $dirty14 = i27 | 6;
            l4 = maxLines;
        } else {
        }
        i17 = i53 & 2048;
        if (i17 != 0) {
            $dirty14 |= 48;
            i14 = i17;
        } else {
            if (i35 & 48 == 0) {
                i14 = i17;
                i12 = $composer2.changed(style) ? 32 : 16;
                $dirty14 |= i12;
            } else {
                i14 = i17;
                i17 = style;
            }
        }
        $dirty12 = $dirty14;
        int i83 = i53 & 4096;
        if (i83 != 0) {
            $dirty12 |= 384;
            softWrap3 = $composer;
        } else {
            if (i35 & 384 == 0) {
                i8 = $composer2.changed($composer) ? 256 : i93;
                $dirty12 |= i8;
            } else {
                softWrap3 = $composer;
            }
        }
        int i84 = i53 & 8192;
        if (i84 != 0) {
            $dirty12 |= 3072;
        } else {
            $dirty14 = $dirty12;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($changed)) {
                } else {
                    i4 = changedInstance;
                }
                $dirty1 = i4;
            } else {
                int i80 = $changed;
                $dirty1 = $dirty14;
            }
        }
        int i85 = i53 & 16384;
        if (i85 != 0) {
            $dirty1 |= 24576;
            obj6 = $changed1;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i16 = i102;
                }
                $dirty1 |= i16;
            } else {
                obj6 = $changed1;
            }
        }
        i31 = 32768;
        if (i35 & i104 == 0) {
            if (obj66 & i31 == 0) {
                if ($composer2.changed(i20)) {
                } else {
                    i = i103;
                }
            } else {
                obj8 = i20;
            }
            $dirty1 |= i;
        } else {
            obj8 = i20;
        }
        if ($dirty3 & companion == 306783378 && i52 &= $dirty1 == 74898) {
            if (i52 &= $dirty1 == 74898) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj64 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i3 != 0) {
                                obj9 = unspecified-XSAIIZE;
                            }
                            if (textAlign3 != 0) {
                                l = unspecified-XSAIIZE;
                            }
                            if (i95 != 0) {
                                fontSize3 = unspecified-XSAIIZE;
                            }
                            if (i6 != 0) {
                                obj7 = unspecified-XSAIIZE;
                            }
                            if (i24 != 0) {
                                fontWeight2 = unspecified-XSAIIZE;
                            }
                            this_$iv = i105 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing4 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing4 = textAlign;
                            }
                            textDecoration2 = i18 != 0 ? 0 : overflow;
                            textAlign3 = i15 != 0 ? 0 : softWrap;
                            if (i79 != 0) {
                                lineHeight3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight3 = maxLines;
                            }
                            if (i14 != 0) {
                                overflow4 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow4 = style;
                            }
                            if (i83 != 0) {
                                softWrap3 = 1;
                            }
                            maxLines3 = i84 != 0 ? 0x7fffffff /* Unknown resource */ : $changed;
                            if (i85 != 0) {
                                onTextLayout2 = TextKt.Text.3.INSTANCE;
                            } else {
                                onTextLayout2 = $changed1;
                            }
                            if (obj66 & i31 != 0) {
                                int i98 = 6;
                                int i99 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj12 = this_$iv;
                                $dirty1 = textDecoration2;
                                i31 = maxLines3;
                                i25 = overflow4;
                                overflow3 = softWrap3;
                                softWrap3 = l;
                                maxLines2 = textAlign3;
                                obj5 = obj7;
                                fontStyle3 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj10 = obj44;
                                fontWeight2 = obj45;
                                i6 = onTextLayout2;
                                onTextLayout3 = obj9;
                                modifier3 = letterSpacing4;
                                letterSpacing2 = l3;
                            } else {
                                obj63 = $dirty1;
                                obj12 = i20;
                                i31 = maxLines3;
                                i25 = overflow4;
                                overflow3 = softWrap3;
                                softWrap3 = l;
                                maxLines2 = textAlign3;
                                obj5 = obj7;
                                fontStyle3 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj10 = obj44;
                                fontWeight2 = obj45;
                                i6 = onTextLayout2;
                                onTextLayout3 = obj9;
                                modifier3 = letterSpacing4;
                                letterSpacing2 = l3;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj66 & i31 != 0) {
                                maxLines2 = softWrap;
                                letterSpacing2 = maxLines;
                                i25 = style;
                                i31 = $changed;
                                i6 = $changed1;
                                obj12 = i20;
                                $dirty1 = this_$iv;
                                overflow3 = softWrap3;
                                softWrap3 = l;
                                onTextLayout3 = obj9;
                                modifier3 = textAlign;
                                obj5 = obj7;
                                fontStyle3 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj10 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines2 = softWrap;
                                letterSpacing2 = maxLines;
                                i25 = style;
                                i31 = $changed;
                                i6 = $changed1;
                                obj12 = i20;
                                overflow3 = softWrap3;
                                softWrap3 = l;
                                onTextLayout3 = obj9;
                                modifier3 = textAlign;
                                obj5 = obj7;
                                fontStyle3 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj10 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-366126944, $dirty3, $dirty1, "androidx.compose.material.Text (Text.kt:182)");
                    }
                    TextKt.Text--4IGK_g(text, onTextLayout3, softWrap3, obj11, fontStyle3, l, obj5, fontSize3, obj10, modifier3, textAlign3, fontWeight2, maxLines2, letterSpacing2, i95, i25, overflow3, i31, 1, i6, obj12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj4 = onTextLayout3;
                    style2 = $dirty1;
                    $dirty13 = softWrap3;
                    modifier2 = fontStyle3;
                    obj = obj5;
                    fontSize2 = fontSize3;
                    i2 = obj10;
                    fontStyle2 = modifier3;
                    fontFamily2 = fontWeight2;
                    letterSpacing3 = maxLines2;
                    l2 = letterSpacing2;
                    textAlign2 = i25;
                    lineHeight2 = overflow3;
                    i30 = i31;
                    overflow2 = i6;
                    softWrap2 = l3;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign2 = style;
                    i30 = $changed;
                    overflow2 = $changed1;
                    softWrap2 = i20;
                    style2 = $dirty1;
                    composer = $composer2;
                    lineHeight2 = softWrap3;
                    obj = obj7;
                    $dirty13 = l;
                    modifier2 = fontSize3;
                    obj4 = obj9;
                    fontSize2 = fontWeight2;
                    i2 = textDecoration;
                    fontStyle2 = textAlign;
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
            $dirty2 = $dirty3;
            $dirty3 = new TextKt.Text.4(text, obj4, $dirty13, $composer2, modifier2, softWrap3, obj, fontSize2, i2, fontStyle2, fontSize3, fontFamily2, letterSpacing3, l2, fontWeight2, textAlign2, lineHeight2, i30, overflow2, softWrap2, obj64, obj65, obj66);
            endRestartGroup.updateScope((Function2)$dirty3);
        } else {
            $dirty2 = $dirty3;
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return TextKt.LocalTextStyle;
    }
}
