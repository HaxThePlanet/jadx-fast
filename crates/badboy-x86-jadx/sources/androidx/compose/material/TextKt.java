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
        int i2;
        int i3;
        int traceInProgress2;
        boolean traceInProgress;
        int str;
        int i;
        String str2;
        merge = 1772272796;
        final Composer obj8 = $composer.startRestartGroup(merge);
        ComposerKt.sourceInformation(obj8, "C(ProvideTextStyle)P(1)397@17792L7,398@17817L80:Text.kt#jmzs0o");
        if ($changed & 6 == 0) {
            i2 = obj8.changed(value) ? 4 : 2;
            $dirty |= i2;
        }
        if ($changed & 48 == 0) {
            i3 = obj8.changedInstance(content) ? 32 : 16;
            $dirty |= i3;
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
            traceInProgress2 = new TextKt.ProvideTextStyle.1(value, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text--4IGK_g(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Map inlineContent, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj10;
        Object i7;
        int $dirty5;
        Object obj13;
        Object obj5;
        boolean traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress;
        Object obj6;
        Object obj2;
        int textDecoration2;
        Object obj3;
        int i;
        int $dirty1;
        int $dirty13;
        long $dirty14;
        Composer $composer2;
        int $dirty4;
        long $dirty3;
        long l2;
        long modifier3;
        Object inlineContent3;
        Object inlineContent2;
        boolean softWrap3;
        Object obj;
        Object obj9;
        int i20;
        Object obj4;
        Object fontSize2;
        long fontStyle2;
        long l;
        int obj11;
        int i30;
        long fontStyle3;
        Object obj7;
        long fontSize3;
        int fontFamily2;
        int i8;
        Object obj8;
        int letterSpacing3;
        long modifier2;
        int i6;
        long l3;
        int textAlign3;
        Object fontWeight2;
        int textAlign2;
        int maxLines3;
        int maxLines4;
        int i27;
        boolean lineHeight4;
        long letterSpacing2;
        long letterSpacing4;
        int i28;
        int i23;
        int i24;
        Object overflow2;
        Object onTextLayout3;
        int onTextLayout2;
        int changedInstance;
        Object softWrap2;
        boolean z;
        int i29;
        int $dirty12;
        int i15;
        Object maxLines2;
        long lineHeight2;
        int lineHeight3;
        int changed2;
        boolean changed;
        int i18;
        int overflow4;
        int overflow3;
        int i19;
        int style2;
        Object obj12;
        int i14;
        Composer composer;
        int i31;
        int i4;
        int i9;
        int i3;
        int i2;
        int i16;
        int i26;
        int i22;
        int i25;
        int $dirty;
        int i12;
        int $dirty2;
        int i10;
        int i5;
        int i17;
        int i11;
        int changed3;
        ScopeUpdateScope scopeUpdateScope;
        int i13;
        int obj44;
        int obj45;
        int obj64;
        int i32 = obj65;
        int i35 = obj66;
        int i54 = obj67;
        $composer2 = obj64.startRestartGroup(-422393234);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)354@16476L7,356@16492L345:Text.kt#jmzs0o");
        $dirty4 = obj65;
        int i89 = obj66;
        if (i54 & 1 != 0) {
            $dirty4 |= 6;
            obj = text;
        } else {
            if (i32 & 6 == 0) {
                i30 = $composer2.changed(text) ? 4 : 2;
                $dirty4 |= i30;
            } else {
                obj = text;
            }
        }
        int i94 = i54 & 2;
        if (i94 != 0) {
            $dirty4 |= 48;
            obj8 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i6 = $composer2.changed(modifier) ? 32 : 16;
                $dirty4 |= i6;
            } else {
                obj8 = modifier;
            }
        }
        textAlign3 = i54 & 4;
        int i96 = 128;
        if (textAlign3 != 0) {
            $dirty4 |= 384;
            i27 = i94;
            l = color;
        } else {
            if (i32 & 384 == 0) {
                i27 = i94;
                i28 = $composer2.changed(color) ? 256 : i96;
                $dirty4 |= i28;
            } else {
                i27 = i94;
                l = color;
            }
        }
        int i98 = i54 & 8;
        changedInstance = 1024;
        if (i98 != 0) {
            $dirty4 |= 3072;
            fontSize3 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i18 = $composer2.changed(fontStyle) ? i24 : changedInstance;
                $dirty4 |= i18;
            } else {
                fontSize3 = fontStyle;
            }
        }
        overflow4 = i54 & 16;
        int i109 = 8192;
        if (overflow4 != 0) {
            $dirty4 |= 24576;
            obj4 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i31 = $composer2.changed(fontFamily) ? i19 : i109;
                $dirty4 |= i31;
            } else {
                obj4 = fontFamily;
            }
        }
        i4 = i54 & 32;
        i3 = 196608;
        final int i110 = 65536;
        if (i4 != 0) {
            $dirty4 |= i3;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i3 == 0) {
                i16 = $composer2.changed(letterSpacing) ? i9 : i110;
                $dirty4 |= i16;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i111 = i54 & 64;
        final int i112 = 1572864;
        if (i111 != 0) {
            $dirty4 |= i112;
            obj3 = textDecoration;
        } else {
            if (i32 & i112 == 0) {
                i22 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty4 |= i22;
            } else {
                obj3 = textDecoration;
            }
        }
        int i33 = i54 & 128;
        int i113 = 12582912;
        if (i33 != 0) {
            $dirty = $dirty6;
            i25 = i89;
            $dirty3 = textAlign;
        } else {
            if (obj65 & i113 == 0) {
                i25 = i89;
                i10 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i115 |= i10;
            } else {
                $dirty = $dirty4;
                i25 = i89;
                $dirty3 = textAlign;
            }
        }
        int i34 = i54 & 256;
        int i118 = 100663296;
        if (i34 != 0) {
            $dirty |= i118;
            i5 = i34;
            obj10 = overflow;
        } else {
            if (obj65 & i118 == 0) {
                i5 = i34;
                i17 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty |= i17;
            } else {
                i5 = i34;
                obj10 = overflow;
            }
        }
        i7 = i54 & 512;
        int i120 = 805306368;
        if (i7 != 0) {
            $dirty |= i120;
            i11 = i7;
        } else {
            if (obj65 & i120 == 0) {
                i11 = i7;
                changed3 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty |= changed3;
            } else {
                i11 = i7;
                i7 = softWrap;
            }
        }
        $dirty5 = $dirty;
        int i82 = i54 & 1024;
        if (i82 != 0) {
            $dirty12 = i25 | 6;
            l2 = maxLines;
        } else {
        }
        i = i54 & 2048;
        if (i != 0) {
            $dirty12 |= 48;
            i12 = i;
        } else {
            if (i35 & 48 == 0) {
                i12 = i;
                i14 = $composer2.changed(onTextLayout) ? 32 : 16;
                $dirty12 |= i14;
            } else {
                i12 = i;
                i = onTextLayout;
            }
        }
        $dirty1 = $dirty12;
        int i86 = i54 & 4096;
        if (i86 != 0) {
            $dirty1 |= 384;
            softWrap3 = style;
        } else {
            if (i35 & 384 == 0) {
                i2 = $composer2.changed(style) ? 256 : i96;
                $dirty1 |= i2;
            } else {
                softWrap3 = style;
            }
        }
        int i87 = i54 & 8192;
        if (i87 != 0) {
            $dirty1 |= 3072;
        } else {
            $dirty12 = $dirty1;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i24 = changedInstance;
                }
                $dirty13 = i24;
            } else {
                int i83 = $composer;
                $dirty13 = $dirty12;
            }
        }
        int i88 = i54 & 16384;
        if (i88 != 0) {
            $dirty13 |= 24576;
            obj6 = $changed;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed)) {
                } else {
                    i19 = i109;
                }
                $dirty13 |= i19;
            } else {
                obj6 = $changed;
            }
        }
        int i101 = obj67 & i100;
        if (i101 != 0) {
            $dirty13 |= i3;
            obj13 = $changed1;
        } else {
            if (i35 & i3 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i9 = i110;
                }
                $dirty13 |= i9;
            } else {
                obj13 = $changed1;
            }
        }
        if (obj66 & i112 == 0) {
            if (obj67 & i110 == 0) {
                i15 = $composer2.changed(i21) ? 1048576 : 524288;
            } else {
                obj5 = i21;
            }
            $dirty13 |= i15;
        } else {
            obj5 = i21;
        }
        if ($dirty5 & i104 == 306783378 && i36 &= $dirty13 == 599186) {
            if (i36 &= $dirty13 == 599186) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj65 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i27 != 0) {
                                obj8 = unspecified-0d7_KjU;
                            }
                            if (textAlign3 != 0) {
                                l = unspecified-0d7_KjU;
                            }
                            if (i98 != 0) {
                                fontSize3 = unspecified-0d7_KjU;
                            }
                            if (overflow4 != 0) {
                                obj4 = unspecified-0d7_KjU;
                            }
                            if (i4 != 0) {
                                fontWeight2 = unspecified-0d7_KjU;
                            }
                            this_$iv = i111 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i5 != 0 ? 0 : overflow;
                            textAlign3 = i11 != 0 ? 0 : softWrap;
                            if (i82 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i12 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = onTextLayout;
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
                                obj12 = this_$iv;
                                $dirty13 = textDecoration2;
                                z = softWrap3;
                                softWrap3 = l;
                                i19 = onTextLayout3;
                                onTextLayout2 = overflow3;
                                overflow4 = inlineContent3;
                                obj7 = obj4;
                                fontStyle2 = fontSize3;
                                inlineContent2 = obj8;
                                fontSize3 = fontWeight2;
                                i8 = obj44;
                                fontWeight2 = obj45;
                                maxLines4 = textAlign3;
                                modifier2 = letterSpacing2;
                                letterSpacing4 = lineHeight2;
                                lineHeight3 = i13;
                            } else {
                                obj64 = $dirty13;
                                obj12 = i21;
                                z = softWrap3;
                                softWrap3 = l;
                                i19 = onTextLayout3;
                                onTextLayout2 = overflow3;
                                overflow4 = inlineContent3;
                                obj7 = obj4;
                                fontStyle2 = fontSize3;
                                inlineContent2 = obj8;
                                fontSize3 = fontWeight2;
                                i8 = obj44;
                                fontWeight2 = obj45;
                                maxLines4 = textAlign3;
                                modifier2 = letterSpacing2;
                                letterSpacing4 = lineHeight2;
                                lineHeight3 = i13;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj67 & i110 != 0) {
                                maxLines4 = softWrap;
                                letterSpacing4 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight3 = $composer;
                                overflow4 = $changed;
                                i19 = $changed1;
                                obj12 = i21;
                                $dirty13 = this_$iv;
                                z = softWrap3;
                                softWrap3 = l;
                                inlineContent2 = obj8;
                                modifier2 = textAlign;
                                obj7 = obj4;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                i8 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines4 = softWrap;
                                letterSpacing4 = maxLines;
                                onTextLayout2 = onTextLayout;
                                lineHeight3 = $composer;
                                overflow4 = $changed;
                                i19 = $changed1;
                                obj12 = i21;
                                z = softWrap3;
                                softWrap3 = l;
                                inlineContent2 = obj8;
                                modifier2 = textAlign;
                                obj7 = obj4;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                i8 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-422393234, $dirty5, $dirty13, "androidx.compose.material.Text (Text.kt:355)");
                    }
                    TextKt.Text-IbK3jfQ(text, inlineContent2, softWrap3, obj, fontStyle2, l, obj7, fontSize3, i8, modifier2, textAlign3, fontWeight2, maxLines4, letterSpacing4, i98, onTextLayout2, z, lineHeight3, 1, overflow4, i19, obj12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj2 = inlineContent2;
                    style2 = $dirty13;
                    $dirty14 = softWrap3;
                    modifier3 = fontStyle2;
                    obj9 = obj7;
                    fontSize2 = fontSize3;
                    obj11 = i8;
                    fontStyle3 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing3 = maxLines4;
                    l3 = letterSpacing4;
                    textAlign2 = onTextLayout2;
                    lineHeight4 = z;
                    i23 = lineHeight3;
                    overflow2 = overflow4;
                    softWrap2 = i19;
                    maxLines2 = i13;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign2 = onTextLayout;
                    i23 = $composer;
                    overflow2 = $changed;
                    softWrap2 = $changed1;
                    maxLines2 = i21;
                    style2 = $dirty13;
                    composer = $composer2;
                    lineHeight4 = softWrap3;
                    obj9 = obj4;
                    $dirty14 = l;
                    modifier3 = fontSize3;
                    obj2 = obj8;
                    fontSize2 = fontWeight2;
                    obj11 = textDecoration;
                    fontStyle3 = textAlign;
                    fontFamily2 = overflow;
                    letterSpacing3 = softWrap;
                    l3 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty5;
            $dirty5 = new TextKt.Text.9(text, obj2, $dirty14, $composer2, modifier3, softWrap3, obj9, fontSize2, obj11, fontStyle3, fontSize3, fontFamily2, letterSpacing3, l3, fontWeight2, textAlign2, lineHeight4, i23, overflow2, softWrap2, maxLines2, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)$dirty5);
        } else {
            $dirty2 = $dirty5;
        }
    }

    public static final void Text--4IGK_g(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj10;
        Object i34;
        int i5;
        Object endRestartGroup;
        Object it$iv;
        Object obj5;
        Object obj6;
        boolean copy-wmQWz5c$default;
        int style3;
        int i25;
        Object obj3;
        int i13;
        int str;
        long $composer2;
        Object $composer3;
        int $dirty3;
        long $dirty;
        long l;
        boolean z;
        int $dirty117;
        int $dirty15;
        int $dirty1;
        int $dirty18;
        int i23;
        long minLines4;
        int minLines2;
        int i29;
        int minLines3;
        Object traceInProgress;
        int i19;
        Object obj4;
        int fontStyle2;
        long unspecified-0d7_KjU;
        Object color2;
        int i15;
        Object obj;
        long unspecified-XSAIIZE;
        long l2;
        int fontSize2;
        int i11;
        Object obj2;
        int modifier2;
        int i26;
        int style2;
        int companion2;
        Object fontWeight3;
        Object fontWeight2;
        Object obj8;
        long l3;
        Object fontFamily2;
        int fontFamily3;
        Object letterSpacing2;
        boolean traceInProgress2;
        int i18;
        int unspecified-e0LSkKk;
        int companion3;
        int fontSize3;
        long l4;
        int i7;
        int z2;
        int textDecoration2;
        int i20;
        int fontWeight4;
        int maxLines2;
        Object maxLines3;
        int changed4;
        int fontStyle3;
        int onTextLayout3;
        Object onTextLayout2;
        int changed3;
        int overflow3;
        int overflow2;
        int cmp;
        int i;
        int $dirty13;
        Object fontFamily4;
        int softWrap2;
        Object softWrap3;
        int i9;
        int textAlign2;
        int i16;
        int i27;
        int i8;
        int lineHeight3;
        long lineHeight2;
        int changed2;
        int i24;
        int changed;
        Composer composer;
        int i22;
        Composer.Companion companion;
        int i10;
        int i12;
        int $dirty19;
        int $dirty115;
        int changed5;
        int i33;
        int i32;
        int $dirty16;
        int $dirty17;
        int i17;
        int $dirty116;
        int $dirty2;
        int $dirty114;
        int i14;
        int i31;
        int i30;
        int i4;
        int $dirty110;
        int $dirty14;
        int $dirty111;
        int $dirty112;
        int $dirty12;
        int $dirty113;
        int i3;
        int i6;
        int i2;
        long l5;
        int i28;
        ScopeUpdateScope scopeUpdateScope;
        Object obj9;
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
        $composer3 = obj73.startRestartGroup(1028090691);
        ComposerKt.sourceInformation($composer3, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)109@5711L7,128@6923L7,129@6977L7,156@7800L30,138@7204L632:Text.kt#jmzs0o");
        $dirty3 = obj74;
        int i60 = obj75;
        if (i42 & 1 != 0) {
            $dirty3 |= 6;
            traceInProgress = text;
        } else {
            if (i35 & 6 == 0) {
                i15 = $composer3.changed(text) ? 4 : 2;
                $dirty3 |= i15;
            } else {
                traceInProgress = text;
            }
        }
        int i69 = i42 & 2;
        if (i69 != 0) {
            $dirty3 |= 48;
            obj2 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i26 = $composer3.changed(modifier) ? 32 : 16;
                $dirty3 |= i26;
            } else {
                obj2 = modifier;
            }
        }
        companion2 = i42 & 4;
        if (companion2 != 0) {
            $dirty3 |= 384;
            companion3 = i69;
            unspecified-0d7_KjU = color;
        } else {
            if (i35 & 384 == 0) {
                companion3 = i69;
                i7 = $composer3.changed(color) ? 256 : 128;
                $dirty3 |= i7;
            } else {
                companion3 = i69;
                unspecified-0d7_KjU = color;
            }
        }
        textDecoration2 = i42 & 8;
        changed4 = 1024;
        if (textDecoration2 != 0) {
            $dirty3 |= 3072;
            unspecified-XSAIIZE = fontStyle;
        } else {
            if (i35 & 3072 == 0) {
                i9 = $composer3.changed(fontStyle) ? i20 : changed4;
                $dirty3 |= i9;
            } else {
                unspecified-XSAIIZE = fontStyle;
            }
        }
        textAlign2 = i42 & 16;
        i24 = 8192;
        if (textAlign2 != 0) {
            $dirty3 |= 24576;
            obj4 = fontFamily;
        } else {
            if (i35 & 24576 == 0) {
                i10 = $composer3.changed(fontFamily) ? i27 : i24;
                $dirty3 |= i10;
            } else {
                obj4 = fontFamily;
            }
        }
        i12 = i42 & 32;
        $dirty19 = 196608;
        $dirty115 = 65536;
        if (i12 != 0) {
            $dirty3 |= $dirty19;
            obj8 = letterSpacing;
        } else {
            if (i35 & $dirty19 == 0) {
                i33 = $composer3.changed(letterSpacing) ? 131072 : $dirty115;
                $dirty3 |= i33;
            } else {
                obj8 = letterSpacing;
            }
        }
        i32 = i42 & 64;
        $dirty16 = 1572864;
        if (i32 != 0) {
            $dirty3 |= $dirty16;
            letterSpacing2 = textDecoration;
        } else {
            if (i35 & $dirty16 == 0) {
                i17 = $composer3.changed(textDecoration) ? 1048576 : 524288;
                $dirty3 |= i17;
            } else {
                letterSpacing2 = textDecoration;
            }
        }
        int i36 = i42 & 128;
        int i102 = 12582912;
        if (i36 != 0) {
            $dirty2 = $dirty5;
            $dirty116 = i60;
            $dirty = textAlign;
        } else {
            if (obj74 & i102 == 0) {
                $dirty116 = i60;
                i14 = $composer3.changed(textAlign) ? 8388608 : 4194304;
                i104 |= i14;
            } else {
                $dirty2 = $dirty3;
                $dirty116 = i60;
                $dirty = textAlign;
            }
        }
        int i37 = i42 & 256;
        int i106 = 100663296;
        if (i37 != 0) {
            $dirty2 |= i106;
            i30 = i37;
            obj10 = overflow;
        } else {
            if (obj74 & i106 == 0) {
                i30 = i37;
                i4 = $composer3.changed(overflow) ? 67108864 : 33554432;
                $dirty2 |= i4;
            } else {
                i30 = i37;
                obj10 = overflow;
            }
        }
        i34 = i42 & 512;
        int i108 = 805306368;
        if (i34 != 0) {
            $dirty2 |= i108;
            $dirty110 = i34;
        } else {
            if (obj74 & i108 == 0) {
                $dirty110 = i34;
                $dirty14 = $composer3.changed(softWrap) ? 536870912 : 268435456;
                $dirty2 |= $dirty14;
            } else {
                $dirty110 = i34;
                i34 = softWrap;
            }
        }
        i5 = $dirty2;
        int i53 = i42 & 1024;
        if (i53 != 0) {
            $dirty114 = i53;
            $dirty116 = $dirty18;
            l = maxLines;
        } else {
            $dirty18 = i38 & 6;
            if ($dirty18 == 0) {
                $dirty114 = i53;
                i = $composer3.changed(maxLines) ? 4 : 2;
                $dirty116 = changed3;
            } else {
                $dirty114 = i53;
                l = maxLines;
            }
        }
        int i54 = i42 & 2048;
        if (i54 != 0) {
            $dirty116 |= 48;
            i23 = onTextLayout;
        } else {
            if (i38 & 48 == 0) {
                changed = $composer3.changed(onTextLayout) ? 32 : 16;
                $dirty116 |= changed;
            } else {
                i23 = onTextLayout;
            }
        }
        int i55 = $dirty116;
        int i61 = i42 & 4096;
        if (i61 != 0) {
            i55 |= 384;
        } else {
            if (i38 & 384 == 0) {
                changed5 = $composer3.changed(style) ? 256 : 128;
                $dirty13 |= changed5;
            } else {
                z = style;
            }
            $dirty117 = $dirty13;
        }
        int i62 = i42 & 8192;
        if (i62 != 0) {
            $dirty117 |= 3072;
        } else {
            changed = $dirty117;
            if (i38 & 3072 == 0) {
                if ($composer3.changed($composer)) {
                } else {
                    i20 = changed4;
                }
                $dirty15 = i20;
            } else {
                int i58 = $composer;
                $dirty15 = changed;
            }
        }
        int i63 = i42 & 16384;
        if (i63 != 0) {
            $dirty15 |= 24576;
            i25 = $changed;
        } else {
            if (i38 & 24576 == 0) {
                if ($composer3.changed($changed)) {
                } else {
                    i27 = i24;
                }
                $dirty15 |= i27;
            } else {
                i25 = $changed;
            }
        }
        int i86 = obj76 & i85;
        if (i86 != 0) {
            $dirty15 |= $dirty19;
            obj5 = $changed1;
        } else {
            if (i38 & $dirty19 == 0) {
                i27 = $composer3.changedInstance($changed1) ? 131072 : $dirty115;
                $dirty15 |= i27;
            } else {
                obj5 = $changed1;
            }
        }
        if (obj75 & $dirty16 == 0) {
            if (obj76 & $dirty115 == 0) {
                i8 = $composer3.changed(i21) ? 1048576 : 524288;
            } else {
                obj6 = i21;
            }
            $dirty15 |= i8;
        } else {
            obj6 = i21;
        }
        if (i5 & lineHeight3 == 306783378 && i39 &= $dirty15 == 599186) {
            if (i39 &= $dirty15 == 599186) {
                if (!$composer3.getSkipping()) {
                    $composer3.startDefaults();
                    str = "CC:CompositionLocal.kt#9igjgp";
                    if (obj74 & 1 != 0) {
                        if ($composer3.getDefaultsInvalid()) {
                            if (companion3 != 0) {
                                obj2 = companion3;
                            }
                            if (companion2 != 0) {
                                unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
                            }
                            if (textDecoration2 != 0) {
                                unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
                            }
                            if (textAlign2 != 0) {
                                obj4 = 0;
                            }
                            fontWeight3 = i12 != 0 ? 0 : obj8;
                            fontFamily2 = i32 != 0 ? 0 : letterSpacing2;
                            if (i36 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i30 != 0 ? 0 : overflow;
                            textAlign2 = $dirty110 != 0 ? 0 : softWrap;
                            if ($dirty114 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i54 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = onTextLayout;
                            }
                            softWrap2 = i61 != 0 ? 1 : style;
                            maxLines2 = i62 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            minLines2 = i63 != 0 ? 1 : $changed;
                            onTextLayout3 = i86 != 0 ? 0 : $changed1;
                            if (obj76 & $dirty115 != 0) {
                                changed = 6;
                                i12 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                i32 = textDecoration2;
                                i31 = lineHeight2;
                                lineHeight3 = letterSpacing2;
                                l4 = unspecified-XSAIIZE;
                                i11 = onTextLayout3;
                                fontSize2 = minLines2;
                                onTextLayout2 = obj4;
                                fontStyle2 = maxLines2;
                                minLines3 = softWrap2;
                                maxLines3 = fontWeight3;
                                softWrap3 = fontFamily2;
                                fontWeight2 = this_$iv;
                                fontFamily3 = i57;
                                $dirty1 = overflow2;
                                style3 = textAlign2;
                            } else {
                                i32 = textDecoration2;
                                $dirty1 = overflow2;
                                style3 = textAlign2;
                                i31 = lineHeight2;
                                lineHeight3 = letterSpacing2;
                                l4 = unspecified-XSAIIZE;
                                i11 = onTextLayout3;
                                fontSize2 = minLines2;
                                onTextLayout2 = obj4;
                                fontStyle2 = maxLines2;
                                minLines3 = softWrap2;
                                maxLines3 = fontWeight3;
                                softWrap3 = fontFamily2;
                                fontFamily3 = $dirty19;
                                fontWeight2 = i21;
                            }
                        } else {
                            $composer3.skipToGroupEnd();
                            if (obj76 & $dirty115 != 0) {
                                $dirty15 &= i29;
                            }
                            lineHeight3 = textAlign;
                            i32 = overflow;
                            style3 = softWrap;
                            i31 = maxLines;
                            minLines3 = style;
                            fontWeight2 = i21;
                            onTextLayout2 = obj4;
                            l4 = unspecified-XSAIIZE;
                            maxLines3 = obj8;
                            softWrap3 = letterSpacing2;
                            fontStyle2 = $composer;
                            fontSize2 = $changed;
                            i11 = $changed1;
                            fontFamily3 = $dirty15;
                            $dirty1 = onTextLayout;
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj65 = style3;
                        ComposerKt.traceEventStart(1028090691, i5, fontFamily3, "androidx.compose.material.Text (Text.kt:110)");
                    } else {
                        obj65 = style3;
                    }
                    int i71 = 6;
                    int i87 = 0;
                    i2 = i5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    int i88 = 6;
                    int i96 = 0;
                    obj53 = unbox-impl;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    float floatValue = (Number)$composer3.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                    i18 = 0;
                    cmp = Long.compare(l6, i22) != 0 ? i16 : 0;
                    if (cmp != 0) {
                        l5 = obj53;
                        copy-wmQWz5c$default = unspecified-0d7_KjU;
                    } else {
                        i18 = 0;
                        if (Long.compare(color-0d7_KjU, i22) != 0) {
                        } else {
                            i16 = 0;
                        }
                        if (i16 != 0) {
                            copy-wmQWz5c$default = fontWeight2.getColor-0d7_KjU();
                            l5 = obj53;
                        } else {
                            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(obj53, color, floatValue, 0, 0, 0, 14);
                            l5 = obj53;
                        }
                    }
                    if (obj65 != null) {
                        unspecified-e0LSkKk = obj65.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    i28 = i115;
                    obj66 = floatValue;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1041441905, "CC(remember):Text.kt#9igjgp");
                    Composer composer3 = $composer3;
                    int i90 = 0;
                    it$iv = composer3.rememberedValue();
                    textAlign2 = 0;
                    if (!$composer3.changed(copy-wmQWz5c$default)) {
                        obj73 = $composer3;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $composer3 = 0;
                            obj54 = it$iv;
                            it$iv = new TextKt.Text.1.1(copy-wmQWz5c$default, str);
                            composer3.updateRememberedValue((ColorProducer)it$iv);
                        } else {
                            obj54 = it$iv;
                        }
                    } else {
                        obj73 = $composer3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj73);
                    obj62 = obj73;
                    obj57 = $dirty1;
                    obj58 = minLines3;
                    obj59 = fontStyle2;
                    obj60 = fontSize2;
                    obj56 = i11;
                    BasicTextKt.BasicText-VhcvRP8(traceInProgress, obj2, TextStyle.merge-dA7vx0o$default(fontWeight2, 0, unspecified-e0LSkKk, l4, textDecoration2, maxLines3, onTextLayout2, 0, softWrap3, 0, lineHeight3, i24, 0, 0, 0, 0, changed5, i32, 0, 0, unspecified-e0LSkKk, 0, i31, i30, 0, 0, 0), obj56, obj57, obj58, obj59, obj60, (ColorProducer)it$iv, obj62, i50 |= i83, 0);
                    composer = obj62;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = obj2;
                    obj4 = onTextLayout2;
                    l2 = lineHeight3;
                    modifier2 = i32;
                    l3 = i31;
                    fontStyle3 = i64;
                    minLines4 = l4;
                    fontSize3 = i95;
                    overflow3 = i5;
                    z2 = i52;
                    style2 = obj65;
                    fontWeight4 = $dirty15;
                    $composer2 = unspecified-0d7_KjU;
                    color2 = obj7;
                    obj = softWrap3;
                    fontFamily4 = obj9;
                } else {
                    $composer3.skipToGroupEnd();
                    style2 = softWrap;
                    fontSize3 = onTextLayout;
                    z2 = style;
                    fontWeight4 = $composer;
                    fontStyle3 = $changed;
                    overflow3 = $changed1;
                    fontFamily4 = i21;
                    i2 = i5;
                    composer = $composer3;
                    i28 = $dirty15;
                    $composer2 = unspecified-0d7_KjU;
                    minLines4 = unspecified-XSAIIZE;
                    obj3 = obj2;
                    color2 = obj8;
                    obj = letterSpacing2;
                    l2 = textAlign;
                    modifier2 = overflow;
                    l3 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new TextKt.Text.2(text, obj3, $composer2, $dirty15, minLines4, traceInProgress, obj4, color2, obj, l2, i11, modifier2, style2, l3, letterSpacing2, fontSize3, z2, fontWeight4, fontStyle3, overflow3, fontFamily4, obj74, obj75, obj76);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void Text-IbK3jfQ(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i22) {
        Object obj8;
        Object i20;
        Object it$iv;
        androidx.compose.material.TextKt.Text.5 i8;
        Object endRestartGroup;
        Object obj3;
        Object obj14;
        Object obj12;
        int copy-wmQWz5c$default;
        int textAlign2;
        int unspecified-XSAIIZE;
        long letterSpacing2;
        int i4;
        int i;
        int f;
        int localContentAlpha;
        Object obj11;
        int $composer2;
        long overflow3;
        int $dirty;
        long $dirty2;
        long l;
        boolean z;
        int $dirty111;
        int $dirty110;
        int $dirty18;
        int $dirty15;
        int i27;
        int minLines3;
        int minLines2;
        long minLines4;
        Object obj6;
        int i25;
        Object obj2;
        int fontStyle3;
        long l4;
        Object color2;
        int i19;
        Object obj5;
        long anon;
        Object fontSize2;
        long l2;
        Object obj9;
        Object obj4;
        int modifier2;
        int i26;
        Object textDecoration3;
        int textDecoration2;
        int style2;
        Object obj10;
        int fontWeight3;
        long l5;
        Object f2;
        boolean traceInProgress;
        int i31;
        int unspecified-e0LSkKk;
        int i18;
        long textAlign4;
        int textAlign3;
        int fontSize3;
        int i7;
        int overflow2;
        int i23;
        int i30;
        Object maxLines3;
        int maxLines2;
        int fontWeight2;
        int changed3;
        Object inlineContent3;
        Object inlineContent2;
        int fontStyle2;
        int changed2;
        int softWrap3;
        int cmp;
        Map softWrap2;
        int i2;
        int $dirty17;
        Object onTextLayout2;
        Object onTextLayout3;
        androidx.compose.material.TextKt.Text.5 fontFamily2;
        int i32;
        int i28;
        int i5;
        Object obj7;
        int i33;
        long i15;
        int i11;
        int i21;
        int lineHeight2;
        int changed;
        int $dirty114;
        int i3;
        int i10;
        Composer $composer3;
        int $dirty12;
        int $dirty14;
        int changed4;
        int i29;
        int $dirty112;
        int $dirty13;
        int i6;
        int i9;
        int $dirty115;
        int $dirty19;
        int $dirty3;
        int i13;
        int $dirty4;
        int i24;
        int $dirty1;
        int $dirty116;
        int i12;
        int $dirty113;
        int $dirty117;
        int $dirty16;
        int $dirty118;
        int i14;
        int i16;
        long l3;
        int i17;
        ScopeUpdateScope scopeUpdateScope;
        Object obj;
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
            obj6 = text;
        } else {
            if (i34 & 6 == 0) {
                i19 = $composer2.changed(text) ? 4 : 2;
                $dirty |= i19;
            } else {
                obj6 = text;
            }
        }
        int i73 = i43 & 2;
        if (i73 != 0) {
            $dirty |= 48;
            obj4 = modifier;
        } else {
            if (i34 & 48 == 0) {
                i26 = $composer2.changed(modifier) ? 32 : 16;
                $dirty |= i26;
            } else {
                obj4 = modifier;
            }
        }
        int i75 = i43 & 4;
        if (i75 != 0) {
            $dirty |= 384;
            i18 = i73;
            l4 = color;
        } else {
            if (i34 & 384 == 0) {
                i18 = i73;
                i7 = $composer2.changed(color) ? 256 : 128;
                $dirty |= i7;
            } else {
                i18 = i73;
                l4 = color;
            }
        }
        overflow2 = i43 & 8;
        changed3 = 1024;
        if (overflow2 != 0) {
            $dirty |= 3072;
            anon = fontStyle;
        } else {
            if (i34 & 3072 == 0) {
                i32 = $composer2.changed(fontStyle) ? i30 : changed3;
                $dirty |= i32;
            } else {
                anon = fontStyle;
            }
        }
        i28 = i43 & 16;
        i11 = 8192;
        if (i28 != 0) {
            $dirty |= 24576;
            obj2 = fontFamily;
        } else {
            if (i34 & 24576 == 0) {
                i10 = $composer2.changed(fontFamily) ? i33 : i11;
                $dirty |= i10;
            } else {
                obj2 = fontFamily;
            }
        }
        int i108 = i43 & 32;
        $dirty12 = 65536;
        $dirty14 = 196608;
        final int i112 = 131072;
        if (i108 != 0) {
            $dirty |= $dirty14;
            obj10 = letterSpacing;
        } else {
            if (i34 & $dirty14 == 0) {
                i29 = $composer2.changed(letterSpacing) ? i112 : $dirty12;
                $dirty |= i29;
            } else {
                obj10 = letterSpacing;
            }
        }
        $dirty112 = i43 & 64;
        $dirty13 = 1572864;
        if ($dirty112 != 0) {
            $dirty |= $dirty13;
            f2 = textDecoration;
        } else {
            if (i34 & $dirty13 == 0) {
                i9 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                f2 = textDecoration;
            }
        }
        int i35 = i43 & 128;
        $dirty115 = 12582912;
        if (i35 != 0) {
            $dirty3 = $dirty6;
            $dirty19 = i64;
            $dirty2 = textAlign;
        } else {
            if (obj75 & $dirty115 == 0) {
                $dirty19 = i64;
                i24 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i117 |= i24;
            } else {
                $dirty3 = $dirty;
                $dirty19 = i64;
                $dirty2 = textAlign;
            }
        }
        int i36 = i43 & 256;
        int i119 = 100663296;
        if (i36 != 0) {
            $dirty3 |= i119;
            $dirty116 = i36;
            obj8 = overflow;
        } else {
            if (obj75 & i119 == 0) {
                $dirty116 = i36;
                i12 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty3 |= i12;
            } else {
                $dirty116 = i36;
                obj8 = overflow;
            }
        }
        i20 = i43 & 512;
        int i122 = 805306368;
        if (i20 != 0) {
            $dirty3 |= i122;
            $dirty113 = i20;
        } else {
            if (obj75 & i122 == 0) {
                $dirty113 = i20;
                $dirty117 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty3 |= $dirty117;
            } else {
                $dirty113 = i20;
                i20 = softWrap;
            }
        }
        i8 = $dirty3;
        int i59 = i43 & 1024;
        if (i59 != 0) {
            i13 = i59;
            $dirty19 = $dirty15;
            l = maxLines;
        } else {
            $dirty15 = i37 & 6;
            if ($dirty15 == 0) {
                i13 = i59;
                i2 = $composer2.changed(maxLines) ? 4 : 2;
                $dirty19 = changed2;
            } else {
                i13 = i59;
                l = maxLines;
            }
        }
        int i60 = i43 & 2048;
        if (i60 != 0) {
            $dirty19 |= 48;
            i27 = inlineContent;
        } else {
            if (i37 & 48 == 0) {
                $dirty114 = $composer2.changed(inlineContent) ? 32 : 16;
                $dirty19 |= $dirty114;
            } else {
                i27 = inlineContent;
            }
        }
        int i61 = $dirty19;
        int i65 = i43 & 4096;
        if (i65 != 0) {
            i61 |= 384;
        } else {
            if (i37 & 384 == 0) {
                changed4 = $composer2.changed(onTextLayout) ? 256 : 128;
                $dirty17 |= changed4;
            } else {
                z = onTextLayout;
            }
            $dirty111 = $dirty17;
        }
        int i66 = i43 & 8192;
        if (i66 != 0) {
            $dirty111 |= 3072;
        } else {
            $dirty114 = $dirty111;
            if (i37 & 3072 == 0) {
                if ($composer2.changed(style)) {
                } else {
                    i30 = changed3;
                }
                $dirty110 = i30;
            } else {
                int i62 = style;
                $dirty110 = $dirty114;
            }
        }
        int i67 = i43 & 16384;
        if (i67 != 0) {
            $dirty110 |= 24576;
            i4 = $composer;
        } else {
            if (i37 & 24576 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i33 = i11;
                }
                $dirty110 |= i33;
            } else {
                i4 = $composer;
            }
        }
        int i94 = obj77 & i93;
        if (i94 != 0) {
            $dirty110 |= $dirty14;
            obj3 = $changed;
        } else {
            if (i37 & $dirty14 == 0) {
                i33 = $composer2.changedInstance($changed) ? i112 : $dirty12;
                $dirty110 |= i33;
            } else {
                obj3 = $changed;
            }
        }
        i15 = obj77 & $dirty12;
        if (i15 != 0) {
            $dirty110 |= $dirty13;
            obj14 = $changed1;
        } else {
            if (obj76 & $dirty13 == 0) {
                i11 = $composer2.changedInstance($changed1) ? 1048576 : 524288;
                $dirty110 |= i11;
            } else {
                obj14 = $changed1;
            }
        }
        if (obj76 & $dirty115 == 0) {
            if (obj77 & i112 == 0) {
                i21 = $composer2.changed(i22) ? 8388608 : 4194304;
            } else {
                obj12 = i22;
            }
            $dirty110 |= i21;
        } else {
            obj12 = i22;
        }
        if (i8 & lineHeight2 == 306783378 && i42 &= $dirty110 == 4793490) {
            if (i42 &= $dirty110 == 4793490) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj75 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i18 != 0) {
                                obj4 = unspecified-XSAIIZE;
                            }
                            if (i75 != 0) {
                                l4 = unspecified-XSAIIZE;
                            }
                            if (overflow2 != 0) {
                                anon = unspecified-XSAIIZE;
                            }
                            if (i28 != 0) {
                                obj2 = unspecified-XSAIIZE;
                            }
                            if (i108 != 0) {
                                obj10 = unspecified-XSAIIZE;
                            }
                            if ($dirty112 != 0) {
                                f2 = unspecified-XSAIIZE;
                            }
                            if (i35 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = $dirty116 != 0 ? 0 : overflow;
                            textAlign3 = $dirty113 != 0 ? 0 : softWrap;
                            if (i13 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i60 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = inlineContent;
                            }
                            softWrap3 = i65 != 0 ? 1 : onTextLayout;
                            maxLines2 = i66 != 0 ? 0x7fffffff /* Unknown resource */ : style;
                            minLines2 = i67 != 0 ? 1 : $composer;
                            if (i94 != 0) {
                                inlineContent2 = MapsKt.emptyMap();
                            } else {
                                inlineContent2 = $changed;
                            }
                            if (i15 != 0) {
                                onTextLayout3 = TextKt.Text.5.INSTANCE;
                            } else {
                                onTextLayout3 = $changed1;
                            }
                            if (obj77 & i112 != 0) {
                                i28 = 0;
                                obj55 = i44;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                changed4 = textDecoration2;
                                $dirty18 = softWrap3;
                                $dirty19 = lineHeight2;
                                i15 = obj53;
                                textDecoration3 = this_$iv;
                                textAlign2 = textAlign3;
                                fontWeight3 = i46;
                                f = overflow2;
                                textAlign4 = anon;
                                fontSize2 = inlineContent2;
                                obj9 = onTextLayout3;
                                inlineContent3 = obj2;
                                onTextLayout2 = f2;
                                fontStyle3 = minLines2;
                                minLines3 = maxLines2;
                                maxLines3 = obj;
                            } else {
                                changed4 = textDecoration2;
                                textAlign2 = textAlign3;
                                f = overflow2;
                                $dirty18 = softWrap3;
                                $dirty19 = lineHeight2;
                                i15 = obj53;
                                textDecoration3 = i22;
                                textAlign4 = anon;
                                fontSize2 = inlineContent2;
                                obj9 = onTextLayout3;
                                inlineContent3 = obj2;
                                onTextLayout2 = f2;
                                fontStyle3 = minLines2;
                                minLines3 = maxLines2;
                                maxLines3 = obj10;
                                fontWeight3 = obj74;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj77 & i112 != 0) {
                                i15 = textAlign;
                                changed4 = overflow;
                                $dirty19 = maxLines;
                                f = inlineContent;
                                $dirty18 = onTextLayout;
                                minLines3 = style;
                                textDecoration3 = i22;
                                inlineContent3 = obj2;
                                textAlign4 = anon;
                                maxLines3 = obj10;
                                onTextLayout2 = f2;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj9 = $changed1;
                                fontWeight3 = i40;
                                textAlign2 = softWrap;
                            } else {
                                i15 = textAlign;
                                changed4 = overflow;
                                textAlign2 = softWrap;
                                $dirty19 = maxLines;
                                f = inlineContent;
                                minLines3 = style;
                                textDecoration3 = i22;
                                inlineContent3 = obj2;
                                textAlign4 = anon;
                                maxLines3 = obj10;
                                onTextLayout2 = f2;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj9 = $changed1;
                                fontWeight3 = $dirty110;
                                $dirty18 = onTextLayout;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj66 = textAlign2;
                        ComposerKt.traceEventStart(744129681, i8, fontWeight3, "androidx.compose.material.Text (Text.kt:281)");
                    } else {
                        obj66 = textAlign2;
                    }
                    int i76 = 6;
                    int i95 = 0;
                    obj74 = i8;
                    obj57 = f;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i77 = 6;
                    int i96 = 0;
                    obj58 = unbox-impl;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    float floatValue = (Number)$composer2.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                    i31 = 0;
                    cmp = Long.compare(l6, i3) != 0 ? i5 : 0;
                    if (cmp != 0) {
                        l3 = obj58;
                        copy-wmQWz5c$default = l4;
                    } else {
                        i31 = 0;
                        if (Long.compare(color-0d7_KjU, i3) != 0) {
                        } else {
                            i5 = 0;
                        }
                        if (i5 != 0) {
                            copy-wmQWz5c$default = textDecoration3.getColor-0d7_KjU();
                            l3 = obj58;
                        } else {
                            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(obj58, letterSpacing, floatValue, 0, 0, 0, 14);
                            l3 = obj58;
                        }
                    }
                    if (obj66 != null) {
                        unspecified-e0LSkKk = obj66.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    i17 = i127;
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
                    obj58 = $dirty18;
                    obj59 = minLines3;
                    obj60 = fontStyle3;
                    obj61 = fontSize2;
                    obj56 = obj9;
                    BasicTextKt.BasicText-RWo7tUw(obj6, obj4, TextStyle.merge-dA7vx0o$default(textDecoration3, 0, unspecified-e0LSkKk, textAlign4, overflow2, maxLines3, inlineContent3, 0, onTextLayout2, 0, i15, lineHeight2, 0, 0, 0, 0, i112, changed4, 0, 0, unspecified-e0LSkKk, 0, $dirty19, i13, 0, 0, 0), obj56, obj57, obj58, obj59, obj60, obj61, (ColorProducer)it$iv, $composer3, i55 |= i91, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj11 = obj4;
                    obj7 = textDecoration3;
                    obj2 = inlineContent3;
                    l2 = i15;
                    modifier2 = changed4;
                    l5 = $dirty19;
                    style2 = obj66;
                    fontStyle2 = i68;
                    fontFamily2 = i8;
                    fontSize3 = i57;
                    i23 = i104;
                    softWrap2 = obj6;
                    minLines4 = l7;
                    fontWeight2 = $dirty110;
                    overflow3 = l4;
                    color2 = obj13;
                    obj5 = obj;
                } else {
                    $composer2.skipToGroupEnd();
                    style2 = softWrap;
                    fontSize3 = inlineContent;
                    i23 = onTextLayout;
                    fontWeight2 = style;
                    fontStyle2 = $composer;
                    softWrap2 = $changed;
                    fontFamily2 = $changed1;
                    obj7 = i22;
                    obj74 = i8;
                    $composer3 = $composer2;
                    i17 = $dirty110;
                    overflow3 = l4;
                    minLines4 = anon;
                    obj11 = obj4;
                    color2 = obj10;
                    obj5 = f2;
                    l2 = textAlign;
                    modifier2 = overflow;
                    l5 = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = obj74;
            endRestartGroup = new TextKt.Text.7(text, obj11, overflow3, $dirty110, minLines4, obj6, obj2, color2, obj5, l2, obj9, modifier2, style2, l5, f2, fontSize3, i23, fontWeight2, fontStyle2, softWrap2, fontFamily2, obj7, obj75, obj76, obj77);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty4 = obj74;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text-fLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj5;
        Object i9;
        int $dirty5;
        Object obj;
        int traceInProgress2;
        int this_$iv;
        boolean traceInProgress;
        int unspecified-XSAIIZE;
        ScopeUpdateScope endRestartGroup;
        Object obj7;
        int textDecoration2;
        Object obj4;
        Object obj10;
        int i28;
        int $dirty1;
        int $dirty14;
        long $dirty13;
        Object $composer2;
        int $dirty3;
        long $dirty;
        long l2;
        Object onTextLayout2;
        Object onTextLayout3;
        long modifier3;
        boolean softWrap3;
        Object obj12;
        Object obj8;
        int i5;
        Object obj9;
        long fontStyle2;
        Object fontSize3;
        long l4;
        int i30;
        int i3;
        Object obj6;
        long fontStyle3;
        long fontSize2;
        int obj11;
        int fontFamily2;
        Object obj3;
        long modifier2;
        int letterSpacing4;
        int i10;
        int textAlign2;
        long l;
        Object fontWeight2;
        int maxLines3;
        int maxLines2;
        int textAlign3;
        int i29;
        long letterSpacing3;
        long letterSpacing2;
        boolean lineHeight3;
        int i22;
        int i4;
        int i13;
        int i21;
        androidx.compose.material.TextKt.Text.3 overflow4;
        int changedInstance;
        boolean changed;
        boolean overflow3;
        TextUnit.Companion companion;
        int overflow2;
        Object softWrap2;
        int i8;
        int $dirty12;
        int i26;
        boolean lineHeight2;
        int i;
        Object i12;
        int i2;
        Object obj2;
        int style2;
        Composer composer;
        int i24;
        int i25;
        int i23;
        int i14;
        int i6;
        int i19;
        int i16;
        int i11;
        int i17;
        int $dirty4;
        int i31;
        int $dirty2;
        int i7;
        int i15;
        int i27;
        int i18;
        int changed2;
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
        $dirty3 = obj64;
        int i86 = obj65;
        if (i53 & 1 != 0) {
            $dirty3 |= 6;
            obj12 = text;
        } else {
            if (i32 & 6 == 0) {
                i3 = $composer2.changed(text) ? 4 : 2;
                $dirty3 |= i3;
            } else {
                obj12 = text;
            }
        }
        int i91 = i53 & 2;
        if (i91 != 0) {
            $dirty3 |= 48;
            obj3 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i10 = $composer2.changed(modifier) ? 32 : 16;
                $dirty3 |= i10;
            } else {
                obj3 = modifier;
            }
        }
        textAlign2 = i53 & 4;
        int i93 = 128;
        if (textAlign2 != 0) {
            $dirty3 |= 384;
            i29 = i91;
            l4 = color;
        } else {
            if (i32 & 384 == 0) {
                i29 = i91;
                i22 = $composer2.changed(color) ? 256 : i93;
                $dirty3 |= i22;
            } else {
                i29 = i91;
                l4 = color;
            }
        }
        int i95 = i53 & 8;
        changedInstance = 1024;
        if (i95 != 0) {
            $dirty3 |= 3072;
            fontSize2 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i = $composer2.changed(fontStyle) ? i13 : changedInstance;
                $dirty3 |= i;
            } else {
                fontSize2 = fontStyle;
            }
        }
        i12 = i53 & 16;
        int i102 = 8192;
        if (i12 != 0) {
            $dirty3 |= 24576;
            obj9 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i25 = $composer2.changed(fontFamily) ? i2 : i102;
                $dirty3 |= i25;
            } else {
                obj9 = fontFamily;
            }
        }
        i23 = i53 & 32;
        final int i103 = 65536;
        final int i104 = 196608;
        if (i23 != 0) {
            $dirty3 |= i104;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i104 == 0) {
                i19 = $composer2.changed(letterSpacing) ? i14 : i103;
                $dirty3 |= i19;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i105 = i53 & 64;
        i16 = 1572864;
        if (i105 != 0) {
            $dirty3 |= i16;
            obj10 = textDecoration;
        } else {
            if (i32 & i16 == 0) {
                i11 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty3 |= i11;
            } else {
                obj10 = textDecoration;
            }
        }
        int i33 = i53 & 128;
        int i106 = 12582912;
        if (i33 != 0) {
            $dirty4 = $dirty6;
            i17 = i86;
            $dirty = textAlign;
        } else {
            if (obj64 & i106 == 0) {
                i17 = i86;
                i7 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i108 |= i7;
            } else {
                $dirty4 = $dirty3;
                i17 = i86;
                $dirty = textAlign;
            }
        }
        int i34 = i53 & 256;
        int i111 = 100663296;
        if (i34 != 0) {
            $dirty4 |= i111;
            i15 = i34;
            obj5 = overflow;
        } else {
            if (obj64 & i111 == 0) {
                i15 = i34;
                i27 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty4 |= i27;
            } else {
                i15 = i34;
                obj5 = overflow;
            }
        }
        i9 = i53 & 512;
        int i113 = 805306368;
        if (i9 != 0) {
            $dirty4 |= i113;
            i18 = i9;
        } else {
            if (obj64 & i113 == 0) {
                i18 = i9;
                changed2 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty4 |= changed2;
            } else {
                i18 = i9;
                i9 = softWrap;
            }
        }
        $dirty5 = $dirty4;
        int i79 = i53 & 1024;
        if (i79 != 0) {
            $dirty12 = i17 | 6;
            l2 = maxLines;
        } else {
        }
        i28 = i53 & 2048;
        if (i28 != 0) {
            $dirty12 |= 48;
            i31 = i28;
        } else {
            if (i35 & 48 == 0) {
                i31 = i28;
                i24 = $composer2.changed(style) ? 32 : 16;
                $dirty12 |= i24;
            } else {
                i31 = i28;
                i28 = style;
            }
        }
        $dirty1 = $dirty12;
        int i83 = i53 & 4096;
        if (i83 != 0) {
            $dirty1 |= 384;
            softWrap3 = $composer;
        } else {
            if (i35 & 384 == 0) {
                i6 = $composer2.changed($composer) ? 256 : i93;
                $dirty1 |= i6;
            } else {
                softWrap3 = $composer;
            }
        }
        int i84 = i53 & 8192;
        if (i84 != 0) {
            $dirty1 |= 3072;
        } else {
            $dirty12 = $dirty1;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($changed)) {
                } else {
                    i13 = changedInstance;
                }
                $dirty14 = i13;
            } else {
                int i80 = $changed;
                $dirty14 = $dirty12;
            }
        }
        int i85 = i53 & 16384;
        if (i85 != 0) {
            $dirty14 |= 24576;
            obj7 = $changed1;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i2 = i102;
                }
                $dirty14 |= i2;
            } else {
                obj7 = $changed1;
            }
        }
        i26 = 32768;
        if (i35 & i104 == 0) {
            if (obj66 & i26 == 0) {
                if ($composer2.changed(i20)) {
                } else {
                    i14 = i103;
                }
            } else {
                obj = i20;
            }
            $dirty14 |= i14;
        } else {
            obj = i20;
        }
        if ($dirty5 & companion == 306783378 && i52 &= $dirty14 == 74898) {
            if (i52 &= $dirty14 == 74898) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj64 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i29 != 0) {
                                obj3 = unspecified-XSAIIZE;
                            }
                            if (textAlign2 != 0) {
                                l4 = unspecified-XSAIIZE;
                            }
                            if (i95 != 0) {
                                fontSize2 = unspecified-XSAIIZE;
                            }
                            if (i12 != 0) {
                                obj9 = unspecified-XSAIIZE;
                            }
                            if (i23 != 0) {
                                fontWeight2 = unspecified-XSAIIZE;
                            }
                            this_$iv = i105 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i15 != 0 ? 0 : overflow;
                            textAlign2 = i18 != 0 ? 0 : softWrap;
                            if (i79 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i31 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = style;
                            }
                            if (i83 != 0) {
                                softWrap3 = 1;
                            }
                            maxLines2 = i84 != 0 ? 0x7fffffff /* Unknown resource */ : $changed;
                            if (i85 != 0) {
                                onTextLayout3 = TextKt.Text.3.INSTANCE;
                            } else {
                                onTextLayout3 = $changed1;
                            }
                            if (obj66 & i26 != 0) {
                                int i98 = 6;
                                int i99 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj2 = this_$iv;
                                $dirty14 = textDecoration2;
                                i26 = maxLines2;
                                i21 = overflow2;
                                overflow3 = softWrap3;
                                softWrap3 = l4;
                                maxLines3 = textAlign2;
                                obj6 = obj9;
                                fontStyle2 = fontSize2;
                                fontSize2 = fontWeight2;
                                obj11 = obj44;
                                fontWeight2 = obj45;
                                i12 = onTextLayout3;
                                onTextLayout2 = obj3;
                                modifier2 = letterSpacing2;
                                letterSpacing3 = l3;
                            } else {
                                obj63 = $dirty14;
                                obj2 = i20;
                                i26 = maxLines2;
                                i21 = overflow2;
                                overflow3 = softWrap3;
                                softWrap3 = l4;
                                maxLines3 = textAlign2;
                                obj6 = obj9;
                                fontStyle2 = fontSize2;
                                fontSize2 = fontWeight2;
                                obj11 = obj44;
                                fontWeight2 = obj45;
                                i12 = onTextLayout3;
                                onTextLayout2 = obj3;
                                modifier2 = letterSpacing2;
                                letterSpacing3 = l3;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj66 & i26 != 0) {
                                maxLines3 = softWrap;
                                letterSpacing3 = maxLines;
                                i21 = style;
                                i26 = $changed;
                                i12 = $changed1;
                                obj2 = i20;
                                $dirty14 = this_$iv;
                                overflow3 = softWrap3;
                                softWrap3 = l4;
                                onTextLayout2 = obj3;
                                modifier2 = textAlign;
                                obj6 = obj9;
                                fontStyle2 = fontSize2;
                                fontSize2 = fontWeight2;
                                obj11 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines3 = softWrap;
                                letterSpacing3 = maxLines;
                                i21 = style;
                                i26 = $changed;
                                i12 = $changed1;
                                obj2 = i20;
                                overflow3 = softWrap3;
                                softWrap3 = l4;
                                onTextLayout2 = obj3;
                                modifier2 = textAlign;
                                obj6 = obj9;
                                fontStyle2 = fontSize2;
                                fontSize2 = fontWeight2;
                                obj11 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-366126944, $dirty5, $dirty14, "androidx.compose.material.Text (Text.kt:182)");
                    }
                    TextKt.Text--4IGK_g(text, onTextLayout2, softWrap3, obj12, fontStyle2, l4, obj6, fontSize2, obj11, modifier2, textAlign2, fontWeight2, maxLines3, letterSpacing3, i95, i21, overflow3, i26, 1, i12, obj2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj4 = onTextLayout2;
                    style2 = $dirty14;
                    $dirty13 = softWrap3;
                    modifier3 = fontStyle2;
                    obj8 = obj6;
                    fontSize3 = fontSize2;
                    i30 = obj11;
                    fontStyle3 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing4 = maxLines3;
                    l = letterSpacing3;
                    textAlign3 = i21;
                    lineHeight3 = overflow3;
                    i4 = i26;
                    overflow4 = i12;
                    softWrap2 = l3;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign3 = style;
                    i4 = $changed;
                    overflow4 = $changed1;
                    softWrap2 = i20;
                    style2 = $dirty14;
                    composer = $composer2;
                    lineHeight3 = softWrap3;
                    obj8 = obj9;
                    $dirty13 = l4;
                    modifier3 = fontSize2;
                    obj4 = obj3;
                    fontSize3 = fontWeight2;
                    i30 = textDecoration;
                    fontStyle3 = textAlign;
                    fontFamily2 = overflow;
                    letterSpacing4 = softWrap;
                    l = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty5;
            $dirty5 = new TextKt.Text.4(text, obj4, $dirty13, $composer2, modifier3, softWrap3, obj8, fontSize3, i30, fontStyle3, fontSize2, fontFamily2, letterSpacing4, l, fontWeight2, textAlign3, lineHeight3, i4, overflow4, softWrap2, obj64, obj65, obj66);
            endRestartGroup.updateScope((Function2)$dirty5);
        } else {
            $dirty2 = $dirty5;
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return TextKt.LocalTextStyle;
    }
}
