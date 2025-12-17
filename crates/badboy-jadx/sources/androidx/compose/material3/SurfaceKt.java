package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u001a\u0091\u0001\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00022\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0008\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001am\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00022\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0008\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a\u0099\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000c2\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00022\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0008\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \u001a\u009f\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000c2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00060#2\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00022\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0008\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010$\u001a\"\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001a8\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020+H\u0003ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\"\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006.", d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SurfaceKt {

    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation;
    static {
        final int i2 = 0;
        SurfaceKt.LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)SurfaceKt.LocalAbsoluteTonalElevation.1.INSTANCE, 1, i2);
    }

    public static final void Surface-T9BRK9s(Modifier modifier, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        androidx.compose.ui.Modifier.Companion modifier2;
        Shape shape2;
        long color2;
        int i2;
        long contentColor2;
        float tonalElevation2;
        int i;
        float shadowElevation2;
        float f2;
        int border2;
        float f;
        boolean traceInProgress;
        String str;
        final Composer composer = i11;
        int i3 = obj27;
        int i5 = -513881741;
        ComposerKt.sourceInformationMarkerStart(composer, i5, "C(Surface)P(4,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)96@5014L11,97@5061L22,*103@5278L7,107@5451L741,104@5307L885:Surface.kt#uh7d8r");
        if (obj28 & 1 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if (obj28 & 2 != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if (obj28 & 4 != 0) {
            color2 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface-0d7_KjU();
        } else {
            color2 = color;
        }
        if (obj28 & 8 != 0) {
            contentColor2 = ColorSchemeKt.contentColorFor-ek8zF_U(color2, i2, composer);
        } else {
            contentColor2 = tonalElevation;
        }
        if (obj28 & 16 != 0) {
            i = 0;
            tonalElevation2 = Dp.constructor-impl((float)i15);
        } else {
            tonalElevation2 = border;
        }
        if (obj28 & 32 != 0) {
            f2 = 0;
            shadowElevation2 = Dp.constructor-impl((float)i17);
        } else {
            shadowElevation2 = content;
        }
        border2 = obj28 & 64 != 0 ? 0 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.Surface (Surface.kt:102)");
        }
        int i19 = 6;
        int i22 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i20 = 0;
        float arg0$iv = Dp.constructor-impl(unbox-impl + tonalElevation2);
        ProvidedValue[] arr = new ProvidedValue[2];
        int i27 = 1;
        arr[i27] = SurfaceKt.LocalAbsoluteTonalElevation.provides(Dp.box-impl(arg0$iv));
        final androidx.compose.ui.Modifier.Companion obj17 = modifier2;
        final Shape obj18 = shape2;
        final float obj23 = shadowElevation2;
        final int obj22 = border2;
        final androidx.compose.material3.SurfaceKt.Surface.1 obj16 = anon2;
        super(obj17, obj18, color2, tonalElevation, arg0$iv, obj22, obj23, $changed);
        androidx.compose.ui.Modifier.Companion companion = obj17;
        Shape shape3 = obj18;
        int i24 = obj22;
        float f3 = obj23;
        CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-70914509, i27, obj16, composer, 54), composer, $stable |= 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void Surface-d85dljk(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i16) {
        int i2;
        String traceInProgress;
        int companion;
        int i7;
        int rectangleShape;
        int surface-0d7_KjU;
        int contentColorFor-ek8zF_U;
        float tonalElevation2;
        int i3;
        int $this$dp$iv;
        int i5;
        int i4;
        androidx.compose.ui.Modifier.Companion companion2;
        Shape shape2;
        long l;
        float f;
        float f2;
        int i8;
        int i;
        int i6;
        float f3;
        long l2;
        final Composer composer = $changed1;
        final int i9 = i16;
        int i10 = obj37;
        int i12 = 540296512;
        ComposerKt.sourceInformationMarkerStart(composer, i12, "C(Surface)P(8,7,6,4,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,5)299@16163L11,300@16210L22,*307@16484L7,311@16657L899,308@16513L1043:Surface.kt#uh7d8r");
        if (i10 & 4 != 0) {
            companion2 = companion;
        } else {
            companion2 = modifier;
        }
        i6 = i10 & 8 != 0 ? i7 : enabled;
        if (i10 & 16 != 0) {
            shape2 = rectangleShape;
        } else {
            shape2 = shape;
        }
        if (i10 & 32 != 0) {
            l = surface-0d7_KjU;
        } else {
            l = color;
        }
        if (i10 & 64 != 0) {
            l2 = contentColorFor-ek8zF_U;
        } else {
            l2 = tonalElevation;
        }
        if (i10 & 128 != 0) {
            i3 = 0;
            tonalElevation2 = Dp.constructor-impl((float)i18);
        } else {
            tonalElevation2 = border;
        }
        if (i10 & 256 != 0) {
            f = 0;
            f3 = $this$dp$iv;
        } else {
            f3 = interactionSource;
        }
        i8 = i10 & 512 != 0 ? i5 : content;
        i = i10 &= 1024 != 0 ? i2 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i12, i9, obj36, "androidx.compose.material3.Surface (Surface.kt:306)");
        } else {
            i4 = obj36;
        }
        int i13 = 6;
        int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i14 = 0;
        float constructor-impl = Dp.constructor-impl(unbox-impl + tonalElevation2);
        ProvidedValue[] arr = new ProvidedValue[2];
        int i27 = 1;
        arr[i27] = SurfaceKt.LocalAbsoluteTonalElevation.provides(Dp.box-impl(constructor-impl));
        SurfaceKt.Surface.3 anon = new SurfaceKt.Surface.3(companion2, shape2, l, obj9, constructor-impl, i8, selected, i, i6, onClick, f3, $changed);
        CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-1164547968, i27, anon, composer, 54), composer, $stable |= 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void Surface-d85dljk(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i16) {
        int i3;
        String traceInProgress;
        int companion;
        int i8;
        int rectangleShape;
        int surface-0d7_KjU;
        int contentColorFor-ek8zF_U;
        float tonalElevation2;
        int i4;
        int $this$dp$iv;
        int i5;
        int i;
        androidx.compose.ui.Modifier.Companion companion2;
        Shape shape2;
        long l;
        float f3;
        float f2;
        int i6;
        int i2;
        int i7;
        float f;
        long l2;
        final Composer composer = $changed1;
        final int i9 = i16;
        int i10 = obj37;
        int i12 = -1877401889;
        ComposerKt.sourceInformationMarkerStart(composer, i12, "C(Surface)P(1,8,7,5,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,6)403@21903L11,404@21950L22,*411@22224L7,415@22397L909,412@22253L1053:Surface.kt#uh7d8r");
        if (i10 & 4 != 0) {
            companion2 = companion;
        } else {
            companion2 = modifier;
        }
        i7 = i10 & 8 != 0 ? i8 : enabled;
        if (i10 & 16 != 0) {
            shape2 = rectangleShape;
        } else {
            shape2 = shape;
        }
        if (i10 & 32 != 0) {
            l = surface-0d7_KjU;
        } else {
            l = color;
        }
        if (i10 & 64 != 0) {
            l2 = contentColorFor-ek8zF_U;
        } else {
            l2 = tonalElevation;
        }
        if (i10 & 128 != 0) {
            i4 = 0;
            tonalElevation2 = Dp.constructor-impl((float)i18);
        } else {
            tonalElevation2 = border;
        }
        if (i10 & 256 != 0) {
            f3 = 0;
            f = $this$dp$iv;
        } else {
            f = interactionSource;
        }
        i6 = i10 & 512 != 0 ? i5 : content;
        i2 = i10 &= 1024 != 0 ? i3 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i12, i9, obj36, "androidx.compose.material3.Surface (Surface.kt:410)");
        } else {
            i = obj36;
        }
        int i13 = 6;
        int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i14 = 0;
        float constructor-impl = Dp.constructor-impl(unbox-impl + tonalElevation2);
        ProvidedValue[] arr = new ProvidedValue[2];
        int i27 = 1;
        arr[i27] = SurfaceKt.LocalAbsoluteTonalElevation.provides(Dp.box-impl(constructor-impl));
        SurfaceKt.Surface.4 anon = new SurfaceKt.Surface.4(companion2, shape2, l, obj9, constructor-impl, i6, checked, i2, i7, onCheckedChange, f, $changed);
        CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(712720927, i27, anon, composer, 54), composer, $stable |= 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void Surface-o_FOJdg(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        int i;
        String traceInProgress;
        int companion2;
        int i7;
        int rectangleShape;
        int surface-0d7_KjU;
        int contentColorFor-ek8zF_U;
        float tonalElevation2;
        int i6;
        int $this$dp$iv;
        int i4;
        int i2;
        androidx.compose.ui.Modifier.Companion companion;
        Shape shape2;
        long l;
        float f;
        float f2;
        int i3;
        int i5;
        int i8;
        float f3;
        long l2;
        final Composer composer = $changed1;
        int i9 = i15;
        int i11 = obj35;
        int i14 = -789752804;
        ComposerKt.sourceInformationMarkerStart(composer, i14, "C(Surface)P(7,6,4,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp!1,5)196@10536L11,197@10583L22,*204@10857L7,208@11030L853,205@10886L997:Surface.kt#uh7d8r");
        if (i11 & 2 != 0) {
            companion = companion2;
        } else {
            companion = modifier;
        }
        i8 = i11 & 4 != 0 ? i7 : enabled;
        if (i11 & 8 != 0) {
            shape2 = rectangleShape;
        } else {
            shape2 = shape;
        }
        if (i11 & 16 != 0) {
            l = surface-0d7_KjU;
        } else {
            l = color;
        }
        if (i11 & 32 != 0) {
            l2 = contentColorFor-ek8zF_U;
        } else {
            l2 = tonalElevation;
        }
        if (i11 & 64 != 0) {
            i6 = 0;
            tonalElevation2 = Dp.constructor-impl((float)i22);
        } else {
            tonalElevation2 = border;
        }
        if (i11 & 128 != 0) {
            f = 0;
            f3 = $this$dp$iv;
        } else {
            f3 = interactionSource;
        }
        i3 = i11 & 256 != 0 ? i4 : content;
        i5 = i11 &= 512 != 0 ? i : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i14, i9, obj34, "androidx.compose.material3.Surface (Surface.kt:203)");
        } else {
            i2 = obj34;
        }
        int i16 = 6;
        int i26 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i12 = 0;
        float constructor-impl = Dp.constructor-impl(unbox-impl + tonalElevation2);
        ProvidedValue[] arr = new ProvidedValue[2];
        int i19 = 1;
        arr[i19] = SurfaceKt.LocalAbsoluteTonalElevation.provides(Dp.box-impl(constructor-impl));
        SurfaceKt.Surface.2 anon = new SurfaceKt.Surface.2(companion, shape2, l, obj9, constructor-impl, i3, i5, i8, onClick, f3, $changed);
        CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(1279702876, i19, anon, composer, 54), composer, $stable |= 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final Modifier access$surface-XO-JAsU(Modifier $receiver, Shape shape, long backgroundColor, BorderStroke border, float shadowElevation) {
        return SurfaceKt.surface-XO-JAsU($receiver, shape, backgroundColor, border, shadowElevation);
    }

    public static final long access$surfaceColorAtElevation-CLU3JFs(long color, float elevation, Composer $composer, int $changed) {
        return SurfaceKt.surfaceColorAtElevation-CLU3JFs(color, elevation, $composer, $changed);
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return SurfaceKt.LocalAbsoluteTonalElevation;
    }

    private static final Modifier surface-XO-JAsU(Modifier $this$surface_u2dXO_u2dJAsU, Shape shape, long backgroundColor, BorderStroke border, float shadowElevation) {
        Modifier graphicsLayer-Ap8cVGQ$default;
        int i4;
        int i6;
        Modifier companion;
        int i18;
        int i15;
        int i16;
        int i14;
        int i8;
        int i;
        int i17;
        int i11;
        int i9;
        Shape shape2;
        int i7;
        int i2;
        int i3;
        int i10;
        int i12;
        int i13;
        int i5;
        final BorderStroke borderStroke = shadowElevation;
        if (Float.compare(obj29, i19) > 0) {
            graphicsLayer-Ap8cVGQ$default = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default((Modifier)Modifier.Companion, 0, 0, 0, 0, 0, obj29, 0, 0, 0, 0, 0, obj13, shape, 0, 0, 0, obj18, 0, obj20);
        } else {
            shape2 = shape;
            graphicsLayer-Ap8cVGQ$default = Modifier.Companion;
        }
        if (borderStroke != null) {
            companion = BorderKt.border((Modifier)Modifier.Companion, borderStroke, shape2);
        }
        return ClipKt.clip(BackgroundKt.background-bw27NRU($this$surface_u2dXO_u2dJAsU.then(graphicsLayer-Ap8cVGQ$default).then(companion), backgroundColor, i18), shape2);
    }

    private static final long surfaceColorAtElevation-CLU3JFs(long color, float elevation, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2079918090;
        ComposerKt.sourceInformationMarkerStart($changed, i, "C(surfaceColorAtElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)465@24025L11,465@24037L37:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, obj12, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:465)");
        }
        final Composer composer = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return ColorSchemeKt.applyTonalElevation-RFCenO8(MaterialTheme.INSTANCE.getColorScheme($changed, 6), color, obj4, $composer, composer);
    }
}
