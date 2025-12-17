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
        int i3;
        int traceInProgress2;
        boolean traceInProgress;
        int str;
        int i2;
        String str2;
        merge = 1772272796;
        final Composer obj8 = $composer.startRestartGroup(merge);
        ComposerKt.sourceInformation(obj8, "C(ProvideTextStyle)P(1)397@17792L7,398@17817L80:Text.kt#jmzs0o");
        if ($changed & 6 == 0) {
            i = obj8.changed(value) ? 4 : 2;
            $dirty |= i;
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
        Object i19;
        int $dirty;
        Object obj7;
        Object obj3;
        boolean traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        int unspecified-0d7_KjU;
        int this_$iv;
        boolean traceInProgress;
        Object obj12;
        Object obj13;
        int textDecoration2;
        Object obj5;
        int i30;
        int $dirty14;
        int $dirty13;
        long $dirty12;
        Composer $composer2;
        int $dirty4;
        long $dirty2;
        long l3;
        long modifier2;
        Object inlineContent3;
        Object inlineContent2;
        boolean softWrap3;
        Object obj6;
        Object obj2;
        int i17;
        Object obj10;
        Object fontSize2;
        long fontStyle3;
        long l;
        int obj8;
        int i29;
        long fontStyle2;
        Object obj4;
        long fontSize3;
        int fontFamily2;
        int i8;
        Object obj;
        int letterSpacing3;
        long modifier3;
        int i9;
        long l2;
        int textAlign3;
        Object fontWeight2;
        int textAlign2;
        int maxLines4;
        int maxLines3;
        int i7;
        boolean lineHeight2;
        long letterSpacing4;
        long letterSpacing2;
        int i2;
        int i18;
        int i11;
        Object overflow2;
        Object onTextLayout2;
        int onTextLayout3;
        int changedInstance;
        Object softWrap2;
        boolean z;
        int i20;
        int $dirty1;
        int i14;
        Object maxLines2;
        long lineHeight3;
        int lineHeight4;
        int changed3;
        boolean changed;
        int i10;
        int overflow4;
        int overflow3;
        int i6;
        int style2;
        Object obj11;
        int i31;
        Composer composer;
        int i22;
        int i4;
        int i16;
        int i;
        int i15;
        int i23;
        int i25;
        int i24;
        int i26;
        int $dirty3;
        int i27;
        int $dirty5;
        int i5;
        int i13;
        int i28;
        int i3;
        int changed2;
        ScopeUpdateScope scopeUpdateScope;
        int i12;
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
            obj6 = text;
        } else {
            if (i32 & 6 == 0) {
                i29 = $composer2.changed(text) ? 4 : 2;
                $dirty4 |= i29;
            } else {
                obj6 = text;
            }
        }
        int i94 = i54 & 2;
        if (i94 != 0) {
            $dirty4 |= 48;
            obj = modifier;
        } else {
            if (i32 & 48 == 0) {
                i9 = $composer2.changed(modifier) ? 32 : 16;
                $dirty4 |= i9;
            } else {
                obj = modifier;
            }
        }
        textAlign3 = i54 & 4;
        int i96 = 128;
        if (textAlign3 != 0) {
            $dirty4 |= 384;
            i7 = i94;
            l = color;
        } else {
            if (i32 & 384 == 0) {
                i7 = i94;
                i2 = $composer2.changed(color) ? 256 : i96;
                $dirty4 |= i2;
            } else {
                i7 = i94;
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
                i10 = $composer2.changed(fontStyle) ? i11 : changedInstance;
                $dirty4 |= i10;
            } else {
                fontSize3 = fontStyle;
            }
        }
        overflow4 = i54 & 16;
        int i109 = 8192;
        if (overflow4 != 0) {
            $dirty4 |= 24576;
            obj10 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i22 = $composer2.changed(fontFamily) ? i6 : i109;
                $dirty4 |= i22;
            } else {
                obj10 = fontFamily;
            }
        }
        i4 = i54 & 32;
        i = 196608;
        final int i110 = 65536;
        if (i4 != 0) {
            $dirty4 |= i;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i == 0) {
                i23 = $composer2.changed(letterSpacing) ? i16 : i110;
                $dirty4 |= i23;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i111 = i54 & 64;
        final int i112 = 1572864;
        if (i111 != 0) {
            $dirty4 |= i112;
            obj5 = textDecoration;
        } else {
            if (i32 & i112 == 0) {
                i24 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty4 |= i24;
            } else {
                obj5 = textDecoration;
            }
        }
        int i33 = i54 & 128;
        int i113 = 12582912;
        if (i33 != 0) {
            $dirty3 = $dirty6;
            i26 = i89;
            $dirty2 = textAlign;
        } else {
            if (obj65 & i113 == 0) {
                i26 = i89;
                i5 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i115 |= i5;
            } else {
                $dirty3 = $dirty4;
                i26 = i89;
                $dirty2 = textAlign;
            }
        }
        int i34 = i54 & 256;
        int i118 = 100663296;
        if (i34 != 0) {
            $dirty3 |= i118;
            i13 = i34;
            obj9 = overflow;
        } else {
            if (obj65 & i118 == 0) {
                i13 = i34;
                i28 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty3 |= i28;
            } else {
                i13 = i34;
                obj9 = overflow;
            }
        }
        i19 = i54 & 512;
        int i120 = 805306368;
        if (i19 != 0) {
            $dirty3 |= i120;
            i3 = i19;
        } else {
            if (obj65 & i120 == 0) {
                i3 = i19;
                changed2 = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty3 |= changed2;
            } else {
                i3 = i19;
                i19 = softWrap;
            }
        }
        $dirty = $dirty3;
        int i82 = i54 & 1024;
        if (i82 != 0) {
            $dirty1 = i26 | 6;
            l3 = maxLines;
        } else {
        }
        i30 = i54 & 2048;
        if (i30 != 0) {
            $dirty1 |= 48;
            i27 = i30;
        } else {
            if (i35 & 48 == 0) {
                i27 = i30;
                i31 = $composer2.changed(onTextLayout) ? 32 : 16;
                $dirty1 |= i31;
            } else {
                i27 = i30;
                i30 = onTextLayout;
            }
        }
        $dirty14 = $dirty1;
        int i86 = i54 & 4096;
        if (i86 != 0) {
            $dirty14 |= 384;
            softWrap3 = style;
        } else {
            if (i35 & 384 == 0) {
                i15 = $composer2.changed(style) ? 256 : i96;
                $dirty14 |= i15;
            } else {
                softWrap3 = style;
            }
        }
        int i87 = i54 & 8192;
        if (i87 != 0) {
            $dirty14 |= 3072;
        } else {
            $dirty1 = $dirty14;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($composer)) {
                } else {
                    i11 = changedInstance;
                }
                $dirty13 = i11;
            } else {
                int i83 = $composer;
                $dirty13 = $dirty1;
            }
        }
        int i88 = i54 & 16384;
        if (i88 != 0) {
            $dirty13 |= 24576;
            obj12 = $changed;
        } else {
            if (i35 & 24576 == 0) {
                if ($composer2.changedInstance($changed)) {
                } else {
                    i6 = i109;
                }
                $dirty13 |= i6;
            } else {
                obj12 = $changed;
            }
        }
        int i101 = obj67 & i100;
        if (i101 != 0) {
            $dirty13 |= i;
            obj7 = $changed1;
        } else {
            if (i35 & i == 0) {
                if ($composer2.changedInstance($changed1)) {
                } else {
                    i16 = i110;
                }
                $dirty13 |= i16;
            } else {
                obj7 = $changed1;
            }
        }
        if (obj66 & i112 == 0) {
            if (obj67 & i110 == 0) {
                i14 = $composer2.changed(i21) ? 1048576 : 524288;
            } else {
                obj3 = i21;
            }
            $dirty13 |= i14;
        } else {
            obj3 = i21;
        }
        if ($dirty & i104 == 306783378 && i36 &= $dirty13 == 599186) {
            if (i36 &= $dirty13 == 599186) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj65 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                obj = unspecified-0d7_KjU;
                            }
                            if (textAlign3 != 0) {
                                l = unspecified-0d7_KjU;
                            }
                            if (i98 != 0) {
                                fontSize3 = unspecified-0d7_KjU;
                            }
                            if (overflow4 != 0) {
                                obj10 = unspecified-0d7_KjU;
                            }
                            if (i4 != 0) {
                                fontWeight2 = unspecified-0d7_KjU;
                            }
                            this_$iv = i111 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing4 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing4 = textAlign;
                            }
                            textDecoration2 = i13 != 0 ? 0 : overflow;
                            textAlign3 = i3 != 0 ? 0 : softWrap;
                            if (i82 != 0) {
                                lineHeight3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight3 = maxLines;
                            }
                            if (i27 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = onTextLayout;
                            }
                            if (i86 != 0) {
                                softWrap3 = 1;
                            }
                            maxLines4 = i87 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            if (i88 != 0) {
                                inlineContent3 = MapsKt.emptyMap();
                            } else {
                                inlineContent3 = $changed;
                            }
                            if (i101 != 0) {
                                onTextLayout2 = TextKt.Text.8.INSTANCE;
                            } else {
                                onTextLayout2 = $changed1;
                            }
                            if (obj67 & i110 != 0) {
                                int i103 = 6;
                                int i108 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj11 = this_$iv;
                                $dirty13 = textDecoration2;
                                z = softWrap3;
                                softWrap3 = l;
                                i6 = onTextLayout2;
                                onTextLayout3 = overflow3;
                                overflow4 = inlineContent3;
                                obj4 = obj10;
                                fontStyle3 = fontSize3;
                                inlineContent2 = obj;
                                fontSize3 = fontWeight2;
                                i8 = obj44;
                                fontWeight2 = obj45;
                                maxLines3 = textAlign3;
                                modifier3 = letterSpacing4;
                                letterSpacing2 = lineHeight3;
                                lineHeight4 = i12;
                            } else {
                                obj64 = $dirty13;
                                obj11 = i21;
                                z = softWrap3;
                                softWrap3 = l;
                                i6 = onTextLayout2;
                                onTextLayout3 = overflow3;
                                overflow4 = inlineContent3;
                                obj4 = obj10;
                                fontStyle3 = fontSize3;
                                inlineContent2 = obj;
                                fontSize3 = fontWeight2;
                                i8 = obj44;
                                fontWeight2 = obj45;
                                maxLines3 = textAlign3;
                                modifier3 = letterSpacing4;
                                letterSpacing2 = lineHeight3;
                                lineHeight4 = i12;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj67 & i110 != 0) {
                                maxLines3 = softWrap;
                                letterSpacing2 = maxLines;
                                onTextLayout3 = onTextLayout;
                                lineHeight4 = $composer;
                                overflow4 = $changed;
                                i6 = $changed1;
                                obj11 = i21;
                                $dirty13 = this_$iv;
                                z = softWrap3;
                                softWrap3 = l;
                                inlineContent2 = obj;
                                modifier3 = textAlign;
                                obj4 = obj10;
                                fontStyle3 = fontSize3;
                                fontSize3 = fontWeight2;
                                i8 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines3 = softWrap;
                                letterSpacing2 = maxLines;
                                onTextLayout3 = onTextLayout;
                                lineHeight4 = $composer;
                                overflow4 = $changed;
                                i6 = $changed1;
                                obj11 = i21;
                                z = softWrap3;
                                softWrap3 = l;
                                inlineContent2 = obj;
                                modifier3 = textAlign;
                                obj4 = obj10;
                                fontStyle3 = fontSize3;
                                fontSize3 = fontWeight2;
                                i8 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-422393234, $dirty, $dirty13, "androidx.compose.material.Text (Text.kt:355)");
                    }
                    TextKt.Text-IbK3jfQ(text, inlineContent2, softWrap3, obj6, fontStyle3, l, obj4, fontSize3, i8, modifier3, textAlign3, fontWeight2, maxLines3, letterSpacing2, i98, onTextLayout3, z, lineHeight4, 1, overflow4, i6, obj11);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj13 = inlineContent2;
                    style2 = $dirty13;
                    $dirty12 = softWrap3;
                    modifier2 = fontStyle3;
                    obj2 = obj4;
                    fontSize2 = fontSize3;
                    obj8 = i8;
                    fontStyle2 = modifier3;
                    fontFamily2 = fontWeight2;
                    letterSpacing3 = maxLines3;
                    l2 = letterSpacing2;
                    textAlign2 = onTextLayout3;
                    lineHeight2 = z;
                    i18 = lineHeight4;
                    overflow2 = overflow4;
                    softWrap2 = i6;
                    maxLines2 = i12;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign2 = onTextLayout;
                    i18 = $composer;
                    overflow2 = $changed;
                    softWrap2 = $changed1;
                    maxLines2 = i21;
                    style2 = $dirty13;
                    composer = $composer2;
                    lineHeight2 = softWrap3;
                    obj2 = obj10;
                    $dirty12 = l;
                    modifier2 = fontSize3;
                    obj13 = obj;
                    fontSize2 = fontWeight2;
                    obj8 = textDecoration;
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
            $dirty5 = $dirty;
            $dirty = new TextKt.Text.9(text, obj13, $dirty12, $composer2, modifier2, softWrap3, obj2, fontSize2, obj8, fontStyle2, fontSize3, fontFamily2, letterSpacing3, l2, fontWeight2, textAlign2, lineHeight2, i18, overflow2, softWrap2, maxLines2, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)$dirty);
        } else {
            $dirty5 = $dirty;
        }
    }

    public static final void Text--4IGK_g(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i21) {
        Object obj10;
        Object i15;
        int i14;
        Object endRestartGroup;
        Object it$iv;
        Object obj;
        Object obj5;
        boolean copy-wmQWz5c$default;
        int style3;
        int i34;
        Object obj7;
        int i10;
        int str;
        long $composer2;
        Object $composer3;
        int $dirty3;
        long $dirty2;
        long l3;
        boolean z;
        int $dirty117;
        int $dirty110;
        int $dirty16;
        int $dirty115;
        int i29;
        long minLines4;
        int minLines3;
        int i30;
        int minLines2;
        Object traceInProgress2;
        int i25;
        Object obj3;
        int fontStyle3;
        long unspecified-0d7_KjU;
        Object color2;
        int i28;
        Object obj4;
        long unspecified-XSAIIZE;
        long l;
        int fontSize2;
        int i20;
        Object obj8;
        int modifier2;
        int i16;
        int style2;
        int companion2;
        Object fontWeight3;
        Object fontWeight2;
        Object obj9;
        long l2;
        Object fontFamily4;
        int fontFamily2;
        Object letterSpacing2;
        boolean traceInProgress;
        int i33;
        int unspecified-e0LSkKk;
        int companion;
        int fontSize3;
        long l5;
        int i;
        int z2;
        int textDecoration2;
        int i32;
        int fontWeight4;
        int maxLines2;
        Object maxLines3;
        int changed3;
        int fontStyle2;
        int onTextLayout3;
        Object onTextLayout2;
        int changed;
        int overflow2;
        int overflow3;
        int cmp;
        int i6;
        int $dirty114;
        Object fontFamily3;
        int softWrap2;
        Object softWrap3;
        int i24;
        int textAlign2;
        int i17;
        int i7;
        int i11;
        int lineHeight2;
        long lineHeight3;
        int changed5;
        int i31;
        int changed2;
        Composer composer;
        int i12;
        Composer.Companion companion3;
        int i19;
        int i22;
        int $dirty111;
        int $dirty112;
        int changed4;
        int i2;
        int i4;
        int $dirty17;
        int $dirty19;
        int i26;
        int $dirty1;
        int $dirty;
        int $dirty14;
        int i27;
        int i9;
        int i3;
        int i23;
        int $dirty15;
        int $dirty18;
        int $dirty116;
        int $dirty13;
        int $dirty113;
        int $dirty12;
        int i8;
        int i13;
        int i18;
        long l4;
        int i5;
        ScopeUpdateScope scopeUpdateScope;
        Object obj2;
        Object obj6;
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
            traceInProgress2 = text;
        } else {
            if (i35 & 6 == 0) {
                i28 = $composer3.changed(text) ? 4 : 2;
                $dirty3 |= i28;
            } else {
                traceInProgress2 = text;
            }
        }
        int i69 = i42 & 2;
        if (i69 != 0) {
            $dirty3 |= 48;
            obj8 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i16 = $composer3.changed(modifier) ? 32 : 16;
                $dirty3 |= i16;
            } else {
                obj8 = modifier;
            }
        }
        companion2 = i42 & 4;
        if (companion2 != 0) {
            $dirty3 |= 384;
            companion = i69;
            unspecified-0d7_KjU = color;
        } else {
            if (i35 & 384 == 0) {
                companion = i69;
                i = $composer3.changed(color) ? 256 : 128;
                $dirty3 |= i;
            } else {
                companion = i69;
                unspecified-0d7_KjU = color;
            }
        }
        textDecoration2 = i42 & 8;
        changed3 = 1024;
        if (textDecoration2 != 0) {
            $dirty3 |= 3072;
            unspecified-XSAIIZE = fontStyle;
        } else {
            if (i35 & 3072 == 0) {
                i24 = $composer3.changed(fontStyle) ? i32 : changed3;
                $dirty3 |= i24;
            } else {
                unspecified-XSAIIZE = fontStyle;
            }
        }
        textAlign2 = i42 & 16;
        i31 = 8192;
        if (textAlign2 != 0) {
            $dirty3 |= 24576;
            obj3 = fontFamily;
        } else {
            if (i35 & 24576 == 0) {
                i19 = $composer3.changed(fontFamily) ? i7 : i31;
                $dirty3 |= i19;
            } else {
                obj3 = fontFamily;
            }
        }
        i22 = i42 & 32;
        $dirty111 = 196608;
        $dirty112 = 65536;
        if (i22 != 0) {
            $dirty3 |= $dirty111;
            obj9 = letterSpacing;
        } else {
            if (i35 & $dirty111 == 0) {
                i2 = $composer3.changed(letterSpacing) ? 131072 : $dirty112;
                $dirty3 |= i2;
            } else {
                obj9 = letterSpacing;
            }
        }
        i4 = i42 & 64;
        $dirty17 = 1572864;
        if (i4 != 0) {
            $dirty3 |= $dirty17;
            letterSpacing2 = textDecoration;
        } else {
            if (i35 & $dirty17 == 0) {
                i26 = $composer3.changed(textDecoration) ? 1048576 : 524288;
                $dirty3 |= i26;
            } else {
                letterSpacing2 = textDecoration;
            }
        }
        int i36 = i42 & 128;
        int i102 = 12582912;
        if (i36 != 0) {
            $dirty = $dirty5;
            $dirty1 = i60;
            $dirty2 = textAlign;
        } else {
            if (obj74 & i102 == 0) {
                $dirty1 = i60;
                i27 = $composer3.changed(textAlign) ? 8388608 : 4194304;
                i104 |= i27;
            } else {
                $dirty = $dirty3;
                $dirty1 = i60;
                $dirty2 = textAlign;
            }
        }
        int i37 = i42 & 256;
        int i106 = 100663296;
        if (i37 != 0) {
            $dirty |= i106;
            i3 = i37;
            obj10 = overflow;
        } else {
            if (obj74 & i106 == 0) {
                i3 = i37;
                i23 = $composer3.changed(overflow) ? 67108864 : 33554432;
                $dirty |= i23;
            } else {
                i3 = i37;
                obj10 = overflow;
            }
        }
        i15 = i42 & 512;
        int i108 = 805306368;
        if (i15 != 0) {
            $dirty |= i108;
            $dirty15 = i15;
        } else {
            if (obj74 & i108 == 0) {
                $dirty15 = i15;
                $dirty18 = $composer3.changed(softWrap) ? 536870912 : 268435456;
                $dirty |= $dirty18;
            } else {
                $dirty15 = i15;
                i15 = softWrap;
            }
        }
        i14 = $dirty;
        int i53 = i42 & 1024;
        if (i53 != 0) {
            $dirty14 = i53;
            $dirty1 = $dirty115;
            l3 = maxLines;
        } else {
            $dirty115 = i38 & 6;
            if ($dirty115 == 0) {
                $dirty14 = i53;
                i6 = $composer3.changed(maxLines) ? 4 : 2;
                $dirty1 = changed;
            } else {
                $dirty14 = i53;
                l3 = maxLines;
            }
        }
        int i54 = i42 & 2048;
        if (i54 != 0) {
            $dirty1 |= 48;
            i29 = onTextLayout;
        } else {
            if (i38 & 48 == 0) {
                changed2 = $composer3.changed(onTextLayout) ? 32 : 16;
                $dirty1 |= changed2;
            } else {
                i29 = onTextLayout;
            }
        }
        int i55 = $dirty1;
        int i61 = i42 & 4096;
        if (i61 != 0) {
            i55 |= 384;
        } else {
            if (i38 & 384 == 0) {
                changed4 = $composer3.changed(style) ? 256 : 128;
                $dirty114 |= changed4;
            } else {
                z = style;
            }
            $dirty117 = $dirty114;
        }
        int i62 = i42 & 8192;
        if (i62 != 0) {
            $dirty117 |= 3072;
        } else {
            changed2 = $dirty117;
            if (i38 & 3072 == 0) {
                if ($composer3.changed($composer)) {
                } else {
                    i32 = changed3;
                }
                $dirty110 = i32;
            } else {
                int i58 = $composer;
                $dirty110 = changed2;
            }
        }
        int i63 = i42 & 16384;
        if (i63 != 0) {
            $dirty110 |= 24576;
            i34 = $changed;
        } else {
            if (i38 & 24576 == 0) {
                if ($composer3.changed($changed)) {
                } else {
                    i7 = i31;
                }
                $dirty110 |= i7;
            } else {
                i34 = $changed;
            }
        }
        int i86 = obj76 & i85;
        if (i86 != 0) {
            $dirty110 |= $dirty111;
            obj = $changed1;
        } else {
            if (i38 & $dirty111 == 0) {
                i7 = $composer3.changedInstance($changed1) ? 131072 : $dirty112;
                $dirty110 |= i7;
            } else {
                obj = $changed1;
            }
        }
        if (obj75 & $dirty17 == 0) {
            if (obj76 & $dirty112 == 0) {
                i11 = $composer3.changed(i21) ? 1048576 : 524288;
            } else {
                obj5 = i21;
            }
            $dirty110 |= i11;
        } else {
            obj5 = i21;
        }
        if (i14 & lineHeight2 == 306783378 && i39 &= $dirty110 == 599186) {
            if (i39 &= $dirty110 == 599186) {
                if (!$composer3.getSkipping()) {
                    $composer3.startDefaults();
                    str = "CC:CompositionLocal.kt#9igjgp";
                    if (obj74 & 1 != 0) {
                        if ($composer3.getDefaultsInvalid()) {
                            if (companion != 0) {
                                obj8 = companion;
                            }
                            if (companion2 != 0) {
                                unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
                            }
                            if (textDecoration2 != 0) {
                                unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
                            }
                            if (textAlign2 != 0) {
                                obj3 = 0;
                            }
                            fontWeight3 = i22 != 0 ? 0 : obj9;
                            fontFamily4 = i4 != 0 ? 0 : letterSpacing2;
                            if (i36 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = i3 != 0 ? 0 : overflow;
                            textAlign2 = $dirty15 != 0 ? 0 : softWrap;
                            if ($dirty14 != 0) {
                                lineHeight3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight3 = maxLines;
                            }
                            if (i54 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = onTextLayout;
                            }
                            softWrap2 = i61 != 0 ? 1 : style;
                            maxLines2 = i62 != 0 ? 0x7fffffff /* Unknown resource */ : $composer;
                            minLines3 = i63 != 0 ? 1 : $changed;
                            onTextLayout3 = i86 != 0 ? 0 : $changed1;
                            if (obj76 & $dirty112 != 0) {
                                changed2 = 6;
                                i22 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                i4 = textDecoration2;
                                i9 = lineHeight3;
                                lineHeight2 = letterSpacing2;
                                l5 = unspecified-XSAIIZE;
                                i20 = onTextLayout3;
                                fontSize2 = minLines3;
                                onTextLayout2 = obj3;
                                fontStyle3 = maxLines2;
                                minLines2 = softWrap2;
                                maxLines3 = fontWeight3;
                                softWrap3 = fontFamily4;
                                fontWeight2 = this_$iv;
                                fontFamily2 = i57;
                                $dirty16 = overflow3;
                                style3 = textAlign2;
                            } else {
                                i4 = textDecoration2;
                                $dirty16 = overflow3;
                                style3 = textAlign2;
                                i9 = lineHeight3;
                                lineHeight2 = letterSpacing2;
                                l5 = unspecified-XSAIIZE;
                                i20 = onTextLayout3;
                                fontSize2 = minLines3;
                                onTextLayout2 = obj3;
                                fontStyle3 = maxLines2;
                                minLines2 = softWrap2;
                                maxLines3 = fontWeight3;
                                softWrap3 = fontFamily4;
                                fontFamily2 = $dirty111;
                                fontWeight2 = i21;
                            }
                        } else {
                            $composer3.skipToGroupEnd();
                            if (obj76 & $dirty112 != 0) {
                                $dirty110 &= i30;
                            }
                            lineHeight2 = textAlign;
                            i4 = overflow;
                            style3 = softWrap;
                            i9 = maxLines;
                            minLines2 = style;
                            fontWeight2 = i21;
                            onTextLayout2 = obj3;
                            l5 = unspecified-XSAIIZE;
                            maxLines3 = obj9;
                            softWrap3 = letterSpacing2;
                            fontStyle3 = $composer;
                            fontSize2 = $changed;
                            i20 = $changed1;
                            fontFamily2 = $dirty110;
                            $dirty16 = onTextLayout;
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj65 = style3;
                        ComposerKt.traceEventStart(1028090691, i14, fontFamily2, "androidx.compose.material.Text (Text.kt:110)");
                    } else {
                        obj65 = style3;
                    }
                    int i71 = 6;
                    int i87 = 0;
                    i18 = i14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    int i88 = 6;
                    int i96 = 0;
                    obj53 = unbox-impl;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    float floatValue = (Number)$composer3.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                    i33 = 0;
                    cmp = Long.compare(l6, i12) != 0 ? i17 : 0;
                    if (cmp != 0) {
                        l4 = obj53;
                        copy-wmQWz5c$default = unspecified-0d7_KjU;
                    } else {
                        i33 = 0;
                        if (Long.compare(color-0d7_KjU, i12) != 0) {
                        } else {
                            i17 = 0;
                        }
                        if (i17 != 0) {
                            copy-wmQWz5c$default = fontWeight2.getColor-0d7_KjU();
                            l4 = obj53;
                        } else {
                            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(obj53, color, floatValue, 0, 0, 0, 14);
                            l4 = obj53;
                        }
                    }
                    if (obj65 != null) {
                        unspecified-e0LSkKk = obj65.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    i5 = i115;
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
                    obj57 = $dirty16;
                    obj58 = minLines2;
                    obj59 = fontStyle3;
                    obj60 = fontSize2;
                    obj56 = i20;
                    BasicTextKt.BasicText-VhcvRP8(traceInProgress2, obj8, TextStyle.merge-dA7vx0o$default(fontWeight2, 0, unspecified-e0LSkKk, l5, textDecoration2, maxLines3, onTextLayout2, 0, softWrap3, 0, lineHeight2, i31, 0, 0, 0, 0, changed4, i4, 0, 0, unspecified-e0LSkKk, 0, i9, i3, 0, 0, 0), obj56, obj57, obj58, obj59, obj60, (ColorProducer)it$iv, obj62, i50 |= i83, 0);
                    composer = obj62;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj7 = obj8;
                    obj3 = onTextLayout2;
                    l = lineHeight2;
                    modifier2 = i4;
                    l2 = i9;
                    fontStyle2 = i64;
                    minLines4 = l5;
                    fontSize3 = i95;
                    overflow2 = i14;
                    z2 = i52;
                    style2 = obj65;
                    fontWeight4 = $dirty110;
                    $composer2 = unspecified-0d7_KjU;
                    color2 = obj6;
                    obj4 = softWrap3;
                    fontFamily3 = obj2;
                } else {
                    $composer3.skipToGroupEnd();
                    style2 = softWrap;
                    fontSize3 = onTextLayout;
                    z2 = style;
                    fontWeight4 = $composer;
                    fontStyle2 = $changed;
                    overflow2 = $changed1;
                    fontFamily3 = i21;
                    i18 = i14;
                    composer = $composer3;
                    i5 = $dirty110;
                    $composer2 = unspecified-0d7_KjU;
                    minLines4 = unspecified-XSAIIZE;
                    obj7 = obj8;
                    color2 = obj9;
                    obj4 = letterSpacing2;
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
            endRestartGroup = new TextKt.Text.2(text, obj7, $composer2, $dirty110, minLines4, traceInProgress2, obj3, color2, obj4, l, i20, modifier2, style2, l2, letterSpacing2, fontSize3, z2, fontWeight4, fontStyle2, overflow2, fontFamily3, obj74, obj75, obj76);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void Text-IbK3jfQ(AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> inlineContent, Function1<? super TextLayoutResult, Unit> onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i22) {
        Object obj5;
        Object i6;
        Object it$iv;
        androidx.compose.material.TextKt.Text.5 i;
        Object endRestartGroup;
        Object obj8;
        Object obj3;
        Object obj2;
        int copy-wmQWz5c$default;
        int textAlign3;
        int unspecified-XSAIIZE;
        long letterSpacing2;
        int i29;
        int i7;
        int f;
        int localContentAlpha;
        Object obj9;
        int $composer3;
        long overflow3;
        int $dirty4;
        long $dirty;
        long l5;
        boolean z;
        int $dirty19;
        int $dirty12;
        int $dirty15;
        int $dirty117;
        int i19;
        int minLines4;
        int minLines3;
        long minLines2;
        Object obj12;
        int i12;
        Object obj14;
        int fontStyle3;
        long l4;
        Object color2;
        int i9;
        Object obj13;
        long anon;
        Object fontSize2;
        long l3;
        Object obj6;
        Object obj11;
        int modifier2;
        int i5;
        Object textDecoration3;
        int textDecoration2;
        int style2;
        Object obj10;
        int fontWeight3;
        long l;
        Object f2;
        boolean traceInProgress;
        int i25;
        int unspecified-e0LSkKk;
        int i11;
        long textAlign4;
        int textAlign2;
        int fontSize3;
        int i17;
        int overflow2;
        int i33;
        int i24;
        Object maxLines3;
        int maxLines2;
        int fontWeight2;
        int changed2;
        Object inlineContent3;
        Object inlineContent2;
        int fontStyle2;
        int changed;
        int softWrap2;
        int cmp;
        Map softWrap3;
        int i27;
        int $dirty112;
        Object onTextLayout2;
        Object onTextLayout3;
        androidx.compose.material.TextKt.Text.5 fontFamily2;
        int i14;
        int i30;
        int i8;
        Object obj7;
        int i10;
        long i18;
        int i26;
        int i2;
        int lineHeight2;
        int changed4;
        int $dirty17;
        int i13;
        int i3;
        Composer $composer2;
        int $dirty116;
        int $dirty14;
        int changed3;
        int i23;
        int $dirty13;
        int $dirty115;
        int i31;
        int i15;
        int $dirty16;
        int $dirty18;
        int $dirty2;
        int i20;
        int $dirty3;
        int i28;
        int $dirty1;
        int $dirty114;
        int i32;
        int $dirty110;
        int $dirty111;
        int $dirty118;
        int $dirty113;
        int i4;
        int i21;
        long l2;
        int i16;
        ScopeUpdateScope scopeUpdateScope;
        Object obj4;
        Object obj;
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
        $composer3 = obj74.startRestartGroup(744129681);
        ComposerKt.sourceInformation($composer3, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)280@13469L7,299@14681L7,300@14735L7,328@15590L30,309@14955L671:Text.kt#jmzs0o");
        $dirty4 = obj75;
        int i64 = obj76;
        if (i43 & 1 != 0) {
            $dirty4 |= 6;
            obj12 = text;
        } else {
            if (i34 & 6 == 0) {
                i9 = $composer3.changed(text) ? 4 : 2;
                $dirty4 |= i9;
            } else {
                obj12 = text;
            }
        }
        int i73 = i43 & 2;
        if (i73 != 0) {
            $dirty4 |= 48;
            obj11 = modifier;
        } else {
            if (i34 & 48 == 0) {
                i5 = $composer3.changed(modifier) ? 32 : 16;
                $dirty4 |= i5;
            } else {
                obj11 = modifier;
            }
        }
        int i75 = i43 & 4;
        if (i75 != 0) {
            $dirty4 |= 384;
            i11 = i73;
            l4 = color;
        } else {
            if (i34 & 384 == 0) {
                i11 = i73;
                i17 = $composer3.changed(color) ? 256 : 128;
                $dirty4 |= i17;
            } else {
                i11 = i73;
                l4 = color;
            }
        }
        overflow2 = i43 & 8;
        changed2 = 1024;
        if (overflow2 != 0) {
            $dirty4 |= 3072;
            anon = fontStyle;
        } else {
            if (i34 & 3072 == 0) {
                i14 = $composer3.changed(fontStyle) ? i24 : changed2;
                $dirty4 |= i14;
            } else {
                anon = fontStyle;
            }
        }
        i30 = i43 & 16;
        i26 = 8192;
        if (i30 != 0) {
            $dirty4 |= 24576;
            obj14 = fontFamily;
        } else {
            if (i34 & 24576 == 0) {
                i3 = $composer3.changed(fontFamily) ? i10 : i26;
                $dirty4 |= i3;
            } else {
                obj14 = fontFamily;
            }
        }
        int i108 = i43 & 32;
        $dirty116 = 65536;
        $dirty14 = 196608;
        final int i112 = 131072;
        if (i108 != 0) {
            $dirty4 |= $dirty14;
            obj10 = letterSpacing;
        } else {
            if (i34 & $dirty14 == 0) {
                i23 = $composer3.changed(letterSpacing) ? i112 : $dirty116;
                $dirty4 |= i23;
            } else {
                obj10 = letterSpacing;
            }
        }
        $dirty13 = i43 & 64;
        $dirty115 = 1572864;
        if ($dirty13 != 0) {
            $dirty4 |= $dirty115;
            f2 = textDecoration;
        } else {
            if (i34 & $dirty115 == 0) {
                i15 = $composer3.changed(textDecoration) ? 1048576 : 524288;
                $dirty4 |= i15;
            } else {
                f2 = textDecoration;
            }
        }
        int i35 = i43 & 128;
        $dirty16 = 12582912;
        if (i35 != 0) {
            $dirty2 = $dirty6;
            $dirty18 = i64;
            $dirty = textAlign;
        } else {
            if (obj75 & $dirty16 == 0) {
                $dirty18 = i64;
                i28 = $composer3.changed(textAlign) ? 8388608 : 4194304;
                i117 |= i28;
            } else {
                $dirty2 = $dirty4;
                $dirty18 = i64;
                $dirty = textAlign;
            }
        }
        int i36 = i43 & 256;
        int i119 = 100663296;
        if (i36 != 0) {
            $dirty2 |= i119;
            $dirty114 = i36;
            obj5 = overflow;
        } else {
            if (obj75 & i119 == 0) {
                $dirty114 = i36;
                i32 = $composer3.changed(overflow) ? 67108864 : 33554432;
                $dirty2 |= i32;
            } else {
                $dirty114 = i36;
                obj5 = overflow;
            }
        }
        i6 = i43 & 512;
        int i122 = 805306368;
        if (i6 != 0) {
            $dirty2 |= i122;
            $dirty110 = i6;
        } else {
            if (obj75 & i122 == 0) {
                $dirty110 = i6;
                $dirty111 = $composer3.changed(softWrap) ? 536870912 : 268435456;
                $dirty2 |= $dirty111;
            } else {
                $dirty110 = i6;
                i6 = softWrap;
            }
        }
        i = $dirty2;
        int i59 = i43 & 1024;
        if (i59 != 0) {
            i20 = i59;
            $dirty18 = $dirty117;
            l5 = maxLines;
        } else {
            $dirty117 = i37 & 6;
            if ($dirty117 == 0) {
                i20 = i59;
                i27 = $composer3.changed(maxLines) ? 4 : 2;
                $dirty18 = changed;
            } else {
                i20 = i59;
                l5 = maxLines;
            }
        }
        int i60 = i43 & 2048;
        if (i60 != 0) {
            $dirty18 |= 48;
            i19 = inlineContent;
        } else {
            if (i37 & 48 == 0) {
                $dirty17 = $composer3.changed(inlineContent) ? 32 : 16;
                $dirty18 |= $dirty17;
            } else {
                i19 = inlineContent;
            }
        }
        int i61 = $dirty18;
        int i65 = i43 & 4096;
        if (i65 != 0) {
            i61 |= 384;
        } else {
            if (i37 & 384 == 0) {
                changed3 = $composer3.changed(onTextLayout) ? 256 : 128;
                $dirty112 |= changed3;
            } else {
                z = onTextLayout;
            }
            $dirty19 = $dirty112;
        }
        int i66 = i43 & 8192;
        if (i66 != 0) {
            $dirty19 |= 3072;
        } else {
            $dirty17 = $dirty19;
            if (i37 & 3072 == 0) {
                if ($composer3.changed(style)) {
                } else {
                    i24 = changed2;
                }
                $dirty12 = i24;
            } else {
                int i62 = style;
                $dirty12 = $dirty17;
            }
        }
        int i67 = i43 & 16384;
        if (i67 != 0) {
            $dirty12 |= 24576;
            i29 = $composer;
        } else {
            if (i37 & 24576 == 0) {
                if ($composer3.changed($composer)) {
                } else {
                    i10 = i26;
                }
                $dirty12 |= i10;
            } else {
                i29 = $composer;
            }
        }
        int i94 = obj77 & i93;
        if (i94 != 0) {
            $dirty12 |= $dirty14;
            obj8 = $changed;
        } else {
            if (i37 & $dirty14 == 0) {
                i10 = $composer3.changedInstance($changed) ? i112 : $dirty116;
                $dirty12 |= i10;
            } else {
                obj8 = $changed;
            }
        }
        i18 = obj77 & $dirty116;
        if (i18 != 0) {
            $dirty12 |= $dirty115;
            obj3 = $changed1;
        } else {
            if (obj76 & $dirty115 == 0) {
                i26 = $composer3.changedInstance($changed1) ? 1048576 : 524288;
                $dirty12 |= i26;
            } else {
                obj3 = $changed1;
            }
        }
        if (obj76 & $dirty16 == 0) {
            if (obj77 & i112 == 0) {
                i2 = $composer3.changed(i22) ? 8388608 : 4194304;
            } else {
                obj2 = i22;
            }
            $dirty12 |= i2;
        } else {
            obj2 = i22;
        }
        if (i & lineHeight2 == 306783378 && i42 &= $dirty12 == 4793490) {
            if (i42 &= $dirty12 == 4793490) {
                if (!$composer3.getSkipping()) {
                    $composer3.startDefaults();
                    if (obj75 & 1 != 0) {
                        if ($composer3.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                obj11 = unspecified-XSAIIZE;
                            }
                            if (i75 != 0) {
                                l4 = unspecified-XSAIIZE;
                            }
                            if (overflow2 != 0) {
                                anon = unspecified-XSAIIZE;
                            }
                            if (i30 != 0) {
                                obj14 = unspecified-XSAIIZE;
                            }
                            if (i108 != 0) {
                                obj10 = unspecified-XSAIIZE;
                            }
                            if ($dirty13 != 0) {
                                f2 = unspecified-XSAIIZE;
                            }
                            if (i35 != 0) {
                                letterSpacing2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing2 = textAlign;
                            }
                            textDecoration2 = $dirty114 != 0 ? 0 : overflow;
                            textAlign2 = $dirty110 != 0 ? 0 : softWrap;
                            if (i20 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i60 != 0) {
                                overflow2 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow2 = inlineContent;
                            }
                            softWrap2 = i65 != 0 ? 1 : onTextLayout;
                            maxLines2 = i66 != 0 ? 0x7fffffff /* Unknown resource */ : style;
                            minLines3 = i67 != 0 ? 1 : $composer;
                            if (i94 != 0) {
                                inlineContent2 = MapsKt.emptyMap();
                            } else {
                                inlineContent2 = $changed;
                            }
                            if (i18 != 0) {
                                onTextLayout3 = TextKt.Text.5.INSTANCE;
                            } else {
                                onTextLayout3 = $changed1;
                            }
                            if (obj77 & i112 != 0) {
                                i30 = 0;
                                obj55 = i44;
                                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                changed3 = textDecoration2;
                                $dirty15 = softWrap2;
                                $dirty18 = lineHeight2;
                                i18 = obj53;
                                textDecoration3 = this_$iv;
                                textAlign3 = textAlign2;
                                fontWeight3 = i46;
                                f = overflow2;
                                textAlign4 = anon;
                                fontSize2 = inlineContent2;
                                obj6 = onTextLayout3;
                                inlineContent3 = obj14;
                                onTextLayout2 = f2;
                                fontStyle3 = minLines3;
                                minLines4 = maxLines2;
                                maxLines3 = obj4;
                            } else {
                                changed3 = textDecoration2;
                                textAlign3 = textAlign2;
                                f = overflow2;
                                $dirty15 = softWrap2;
                                $dirty18 = lineHeight2;
                                i18 = obj53;
                                textDecoration3 = i22;
                                textAlign4 = anon;
                                fontSize2 = inlineContent2;
                                obj6 = onTextLayout3;
                                inlineContent3 = obj14;
                                onTextLayout2 = f2;
                                fontStyle3 = minLines3;
                                minLines4 = maxLines2;
                                maxLines3 = obj10;
                                fontWeight3 = obj74;
                            }
                        } else {
                            $composer3.skipToGroupEnd();
                            if (obj77 & i112 != 0) {
                                i18 = textAlign;
                                changed3 = overflow;
                                $dirty18 = maxLines;
                                f = inlineContent;
                                $dirty15 = onTextLayout;
                                minLines4 = style;
                                textDecoration3 = i22;
                                inlineContent3 = obj14;
                                textAlign4 = anon;
                                maxLines3 = obj10;
                                onTextLayout2 = f2;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj6 = $changed1;
                                fontWeight3 = i40;
                                textAlign3 = softWrap;
                            } else {
                                i18 = textAlign;
                                changed3 = overflow;
                                textAlign3 = softWrap;
                                $dirty18 = maxLines;
                                f = inlineContent;
                                minLines4 = style;
                                textDecoration3 = i22;
                                inlineContent3 = obj14;
                                textAlign4 = anon;
                                maxLines3 = obj10;
                                onTextLayout2 = f2;
                                fontStyle3 = $composer;
                                fontSize2 = $changed;
                                obj6 = $changed1;
                                fontWeight3 = $dirty12;
                                $dirty15 = onTextLayout;
                            }
                        }
                    } else {
                    }
                    $composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj66 = textAlign3;
                        ComposerKt.traceEventStart(744129681, i, fontWeight3, "androidx.compose.material.Text (Text.kt:281)");
                    } else {
                        obj66 = textAlign3;
                    }
                    int i76 = 6;
                    int i95 = 0;
                    obj74 = i;
                    obj57 = f;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    int i77 = 6;
                    int i96 = 0;
                    obj58 = unbox-impl;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    float floatValue = (Number)$composer3.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                    i25 = 0;
                    cmp = Long.compare(l6, i13) != 0 ? i8 : 0;
                    if (cmp != 0) {
                        l2 = obj58;
                        copy-wmQWz5c$default = l4;
                    } else {
                        i25 = 0;
                        if (Long.compare(color-0d7_KjU, i13) != 0) {
                        } else {
                            i8 = 0;
                        }
                        if (i8 != 0) {
                            copy-wmQWz5c$default = textDecoration3.getColor-0d7_KjU();
                            l2 = obj58;
                        } else {
                            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(obj58, letterSpacing, floatValue, 0, 0, 0, 14);
                            l2 = obj58;
                        }
                    }
                    if (obj66 != null) {
                        unspecified-e0LSkKk = obj66.unbox-impl();
                    } else {
                        unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
                    }
                    i16 = i127;
                    obj67 = floatValue;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1041691185, "CC(remember):Text.kt#9igjgp");
                    Composer composer = $composer3;
                    int i98 = 0;
                    it$iv = composer.rememberedValue();
                    int i106 = 0;
                    if (!$composer3.changed(copy-wmQWz5c$default)) {
                        $composer2 = $composer3;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $composer3 = 0;
                            obj54 = it$iv;
                            it$iv = new TextKt.Text.6.1(copy-wmQWz5c$default, localContentAlpha);
                            composer.updateRememberedValue((ColorProducer)it$iv);
                        } else {
                            obj54 = it$iv;
                        }
                    } else {
                        $composer2 = $composer3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    obj58 = $dirty15;
                    obj59 = minLines4;
                    obj60 = fontStyle3;
                    obj61 = fontSize2;
                    obj56 = obj6;
                    BasicTextKt.BasicText-RWo7tUw(obj12, obj11, TextStyle.merge-dA7vx0o$default(textDecoration3, 0, unspecified-e0LSkKk, textAlign4, overflow2, maxLines3, inlineContent3, 0, onTextLayout2, 0, i18, lineHeight2, 0, 0, 0, 0, i112, changed3, 0, 0, unspecified-e0LSkKk, 0, $dirty18, i20, 0, 0, 0), obj56, obj57, obj58, obj59, obj60, obj61, (ColorProducer)it$iv, $composer2, i55 |= i91, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj9 = obj11;
                    obj7 = textDecoration3;
                    obj14 = inlineContent3;
                    l3 = i18;
                    modifier2 = changed3;
                    l = $dirty18;
                    style2 = obj66;
                    fontStyle2 = i68;
                    fontFamily2 = i;
                    fontSize3 = i57;
                    i33 = i104;
                    softWrap3 = obj12;
                    minLines2 = l7;
                    fontWeight2 = $dirty12;
                    overflow3 = l4;
                    color2 = obj;
                    obj13 = obj4;
                } else {
                    $composer3.skipToGroupEnd();
                    style2 = softWrap;
                    fontSize3 = inlineContent;
                    i33 = onTextLayout;
                    fontWeight2 = style;
                    fontStyle2 = $composer;
                    softWrap3 = $changed;
                    fontFamily2 = $changed1;
                    obj7 = i22;
                    obj74 = i;
                    $composer2 = $composer3;
                    i16 = $dirty12;
                    overflow3 = l4;
                    minLines2 = anon;
                    obj9 = obj11;
                    color2 = obj10;
                    obj13 = f2;
                    l3 = textAlign;
                    modifier2 = overflow;
                    l = maxLines;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = obj74;
            endRestartGroup = new TextKt.Text.7(text, obj9, overflow3, $dirty12, minLines2, obj12, obj14, color2, obj13, l3, obj6, modifier2, style2, l, f2, fontSize3, i33, fontWeight2, fontStyle2, softWrap3, fontFamily2, obj7, obj75, obj76, obj77);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty3 = obj74;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final void Text-fLXpl1I(String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, int $changed, int $changed1, int i20) {
        Object obj6;
        Object i14;
        int $dirty4;
        Object obj10;
        int traceInProgress2;
        int this_$iv;
        boolean traceInProgress;
        int unspecified-XSAIIZE;
        ScopeUpdateScope endRestartGroup;
        Object obj;
        int textDecoration2;
        Object obj2;
        Object obj5;
        int i;
        int $dirty14;
        int $dirty12;
        long $dirty1;
        Object $composer2;
        int $dirty2;
        long $dirty5;
        long l2;
        Object onTextLayout3;
        Object onTextLayout2;
        long modifier3;
        boolean softWrap2;
        Object obj7;
        Object obj4;
        int i10;
        Object obj11;
        long fontStyle2;
        Object fontSize2;
        long l3;
        int i22;
        int i5;
        Object obj3;
        long fontStyle3;
        long fontSize3;
        int obj12;
        int fontFamily2;
        Object obj8;
        long modifier2;
        int letterSpacing4;
        int i6;
        int textAlign2;
        long l;
        Object fontWeight2;
        int maxLines2;
        int maxLines3;
        int textAlign3;
        int i28;
        long letterSpacing2;
        long letterSpacing3;
        boolean lineHeight3;
        int i21;
        int i7;
        int i2;
        int i23;
        androidx.compose.material.TextKt.Text.3 overflow4;
        int changedInstance;
        boolean changed2;
        boolean overflow2;
        TextUnit.Companion companion;
        int overflow3;
        Object softWrap3;
        int i16;
        int $dirty13;
        int i24;
        boolean lineHeight2;
        int i17;
        Object i25;
        int i8;
        Object obj9;
        int style2;
        Composer composer;
        int i26;
        int i13;
        int i15;
        int i27;
        int i9;
        int i4;
        int i29;
        int i12;
        int i11;
        int $dirty3;
        int i18;
        int $dirty;
        int i19;
        int i30;
        int i3;
        int i31;
        int changed;
        ScopeUpdateScope scopeUpdateScope;
        long l4;
        int obj44;
        int obj45;
        int obj63;
        int i32 = obj64;
        int i35 = obj65;
        int i53 = obj66;
        $composer2 = obj63.startRestartGroup(-366126944);
        ComposerKt.sourceInformation($composer2, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)181@8616L7,183@8632L322:Text.kt#jmzs0o");
        $dirty2 = obj64;
        int i86 = obj65;
        if (i53 & 1 != 0) {
            $dirty2 |= 6;
            obj7 = text;
        } else {
            if (i32 & 6 == 0) {
                i5 = $composer2.changed(text) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                obj7 = text;
            }
        }
        int i91 = i53 & 2;
        if (i91 != 0) {
            $dirty2 |= 48;
            obj8 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i6 = $composer2.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                obj8 = modifier;
            }
        }
        textAlign2 = i53 & 4;
        int i93 = 128;
        if (textAlign2 != 0) {
            $dirty2 |= 384;
            i28 = i91;
            l3 = color;
        } else {
            if (i32 & 384 == 0) {
                i28 = i91;
                i21 = $composer2.changed(color) ? 256 : i93;
                $dirty2 |= i21;
            } else {
                i28 = i91;
                l3 = color;
            }
        }
        int i95 = i53 & 8;
        changedInstance = 1024;
        if (i95 != 0) {
            $dirty2 |= 3072;
            fontSize3 = fontStyle;
        } else {
            if (i32 & 3072 == 0) {
                i17 = $composer2.changed(fontStyle) ? i2 : changedInstance;
                $dirty2 |= i17;
            } else {
                fontSize3 = fontStyle;
            }
        }
        i25 = i53 & 16;
        int i102 = 8192;
        if (i25 != 0) {
            $dirty2 |= 24576;
            obj11 = fontFamily;
        } else {
            if (i32 & 24576 == 0) {
                i13 = $composer2.changed(fontFamily) ? i8 : i102;
                $dirty2 |= i13;
            } else {
                obj11 = fontFamily;
            }
        }
        i15 = i53 & 32;
        final int i103 = 65536;
        final int i104 = 196608;
        if (i15 != 0) {
            $dirty2 |= i104;
            fontWeight2 = letterSpacing;
        } else {
            if (i32 & i104 == 0) {
                i4 = $composer2.changed(letterSpacing) ? i27 : i103;
                $dirty2 |= i4;
            } else {
                fontWeight2 = letterSpacing;
            }
        }
        int i105 = i53 & 64;
        i29 = 1572864;
        if (i105 != 0) {
            $dirty2 |= i29;
            obj5 = textDecoration;
        } else {
            if (i32 & i29 == 0) {
                i12 = $composer2.changed(textDecoration) ? 1048576 : 524288;
                $dirty2 |= i12;
            } else {
                obj5 = textDecoration;
            }
        }
        int i33 = i53 & 128;
        int i106 = 12582912;
        if (i33 != 0) {
            $dirty3 = $dirty6;
            i11 = i86;
            $dirty5 = textAlign;
        } else {
            if (obj64 & i106 == 0) {
                i11 = i86;
                i19 = $composer2.changed(textAlign) ? 8388608 : 4194304;
                i108 |= i19;
            } else {
                $dirty3 = $dirty2;
                i11 = i86;
                $dirty5 = textAlign;
            }
        }
        int i34 = i53 & 256;
        int i111 = 100663296;
        if (i34 != 0) {
            $dirty3 |= i111;
            i30 = i34;
            obj6 = overflow;
        } else {
            if (obj64 & i111 == 0) {
                i30 = i34;
                i3 = $composer2.changed(overflow) ? 67108864 : 33554432;
                $dirty3 |= i3;
            } else {
                i30 = i34;
                obj6 = overflow;
            }
        }
        i14 = i53 & 512;
        int i113 = 805306368;
        if (i14 != 0) {
            $dirty3 |= i113;
            i31 = i14;
        } else {
            if (obj64 & i113 == 0) {
                i31 = i14;
                changed = $composer2.changed(softWrap) ? 536870912 : 268435456;
                $dirty3 |= changed;
            } else {
                i31 = i14;
                i14 = softWrap;
            }
        }
        $dirty4 = $dirty3;
        int i79 = i53 & 1024;
        if (i79 != 0) {
            $dirty13 = i11 | 6;
            l2 = maxLines;
        } else {
        }
        i = i53 & 2048;
        if (i != 0) {
            $dirty13 |= 48;
            i18 = i;
        } else {
            if (i35 & 48 == 0) {
                i18 = i;
                i26 = $composer2.changed(style) ? 32 : 16;
                $dirty13 |= i26;
            } else {
                i18 = i;
                i = style;
            }
        }
        $dirty14 = $dirty13;
        int i83 = i53 & 4096;
        if (i83 != 0) {
            $dirty14 |= 384;
            softWrap2 = $composer;
        } else {
            if (i35 & 384 == 0) {
                i9 = $composer2.changed($composer) ? 256 : i93;
                $dirty14 |= i9;
            } else {
                softWrap2 = $composer;
            }
        }
        int i84 = i53 & 8192;
        if (i84 != 0) {
            $dirty14 |= 3072;
        } else {
            $dirty13 = $dirty14;
            if (i35 & 3072 == 0) {
                if ($composer2.changed($changed)) {
                } else {
                    i2 = changedInstance;
                }
                $dirty12 = i2;
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
                    i8 = i102;
                }
                $dirty12 |= i8;
            } else {
                obj = $changed1;
            }
        }
        i24 = 32768;
        if (i35 & i104 == 0) {
            if (obj66 & i24 == 0) {
                if ($composer2.changed(i20)) {
                } else {
                    i27 = i103;
                }
            } else {
                obj10 = i20;
            }
            $dirty12 |= i27;
        } else {
            obj10 = i20;
        }
        if ($dirty4 & companion == 306783378 && i52 &= $dirty12 == 74898) {
            if (i52 &= $dirty12 == 74898) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    if (obj64 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i28 != 0) {
                                obj8 = unspecified-XSAIIZE;
                            }
                            if (textAlign2 != 0) {
                                l3 = unspecified-XSAIIZE;
                            }
                            if (i95 != 0) {
                                fontSize3 = unspecified-XSAIIZE;
                            }
                            if (i25 != 0) {
                                obj11 = unspecified-XSAIIZE;
                            }
                            if (i15 != 0) {
                                fontWeight2 = unspecified-XSAIIZE;
                            }
                            this_$iv = i105 != 0 ? 0 : textDecoration;
                            if (i33 != 0) {
                                letterSpacing3 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                letterSpacing3 = textAlign;
                            }
                            textDecoration2 = i30 != 0 ? 0 : overflow;
                            textAlign2 = i31 != 0 ? 0 : softWrap;
                            if (i79 != 0) {
                                lineHeight2 = TextUnit.Companion.getUnspecified-XSAIIZE();
                            } else {
                                lineHeight2 = maxLines;
                            }
                            if (i18 != 0) {
                                overflow3 = TextOverflow.Companion.getClip-gIe3tQ8();
                            } else {
                                overflow3 = style;
                            }
                            if (i83 != 0) {
                                softWrap2 = 1;
                            }
                            maxLines3 = i84 != 0 ? 0x7fffffff /* Unknown resource */ : $changed;
                            if (i85 != 0) {
                                onTextLayout2 = TextKt.Text.3.INSTANCE;
                            } else {
                                onTextLayout2 = $changed1;
                            }
                            if (obj66 & i24 != 0) {
                                int i98 = 6;
                                int i99 = 0;
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                obj9 = this_$iv;
                                $dirty12 = textDecoration2;
                                i24 = maxLines3;
                                i23 = overflow3;
                                overflow2 = softWrap2;
                                softWrap2 = l3;
                                maxLines2 = textAlign2;
                                obj3 = obj11;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj12 = obj44;
                                fontWeight2 = obj45;
                                i25 = onTextLayout2;
                                onTextLayout3 = obj8;
                                modifier2 = letterSpacing3;
                                letterSpacing2 = l4;
                            } else {
                                obj63 = $dirty12;
                                obj9 = i20;
                                i24 = maxLines3;
                                i23 = overflow3;
                                overflow2 = softWrap2;
                                softWrap2 = l3;
                                maxLines2 = textAlign2;
                                obj3 = obj11;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj12 = obj44;
                                fontWeight2 = obj45;
                                i25 = onTextLayout2;
                                onTextLayout3 = obj8;
                                modifier2 = letterSpacing3;
                                letterSpacing2 = l4;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj66 & i24 != 0) {
                                maxLines2 = softWrap;
                                letterSpacing2 = maxLines;
                                i23 = style;
                                i24 = $changed;
                                i25 = $changed1;
                                obj9 = i20;
                                $dirty12 = this_$iv;
                                overflow2 = softWrap2;
                                softWrap2 = l3;
                                onTextLayout3 = obj8;
                                modifier2 = textAlign;
                                obj3 = obj11;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj12 = textDecoration;
                                fontWeight2 = overflow;
                            } else {
                                maxLines2 = softWrap;
                                letterSpacing2 = maxLines;
                                i23 = style;
                                i24 = $changed;
                                i25 = $changed1;
                                obj9 = i20;
                                overflow2 = softWrap2;
                                softWrap2 = l3;
                                onTextLayout3 = obj8;
                                modifier2 = textAlign;
                                obj3 = obj11;
                                fontStyle2 = fontSize3;
                                fontSize3 = fontWeight2;
                                obj12 = textDecoration;
                                fontWeight2 = overflow;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-366126944, $dirty4, $dirty12, "androidx.compose.material.Text (Text.kt:182)");
                    }
                    TextKt.Text--4IGK_g(text, onTextLayout3, softWrap2, obj7, fontStyle2, l3, obj3, fontSize3, obj12, modifier2, textAlign2, fontWeight2, maxLines2, letterSpacing2, i95, i23, overflow2, i24, 1, i25, obj9);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj2 = onTextLayout3;
                    style2 = $dirty12;
                    $dirty1 = softWrap2;
                    modifier3 = fontStyle2;
                    obj4 = obj3;
                    fontSize2 = fontSize3;
                    i22 = obj12;
                    fontStyle3 = modifier2;
                    fontFamily2 = fontWeight2;
                    letterSpacing4 = maxLines2;
                    l = letterSpacing2;
                    textAlign3 = i23;
                    lineHeight3 = overflow2;
                    i7 = i24;
                    overflow4 = i25;
                    softWrap3 = l4;
                } else {
                    $composer2.skipToGroupEnd();
                    textAlign3 = style;
                    i7 = $changed;
                    overflow4 = $changed1;
                    softWrap3 = i20;
                    style2 = $dirty12;
                    composer = $composer2;
                    lineHeight3 = softWrap2;
                    obj4 = obj11;
                    $dirty1 = l3;
                    modifier3 = fontSize3;
                    obj2 = obj8;
                    fontSize2 = fontWeight2;
                    i22 = textDecoration;
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
            $dirty = $dirty4;
            $dirty4 = new TextKt.Text.4(text, obj2, $dirty1, $composer2, modifier3, softWrap2, obj4, fontSize2, i22, fontStyle3, fontSize3, fontFamily2, letterSpacing4, l, fontWeight2, textAlign3, lineHeight3, i7, overflow4, softWrap3, obj64, obj65, obj66);
            endRestartGroup.updateScope((Function2)$dirty4);
        } else {
            $dirty = $dirty4;
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return TextKt.LocalTextStyle;
    }
}
