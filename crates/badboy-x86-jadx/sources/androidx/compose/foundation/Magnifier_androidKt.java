package androidx.compose.foundation;

import android.os.Build.VERSION;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.DpSize.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0001\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0000\u001a\u0094\u0001\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\u0008\u00122\u001b\u0008\u0002\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\u0002\u0008\u00122\u0016\u0008\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00102\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a¬\u0001\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\u0008\u00122\u001b\u0008\u0002\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\u0002\u0008\u00122\u0016\u0008\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00102\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001a2\u0008\u0008\u0002\u0010 \u001a\u00020\u00072\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0000ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\" \u0010\u0000\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006%", d2 = {"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "isPlatformMagnifierSupported", "", "sdkVersion", "", "equalsIncludingNaN", "", "other", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clip", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FJFFZ)Landroidx/compose/ui/Modifier;", "useTextDefault", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Magnifier_androidKt {

    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot;
    static {
        final int i = 0;
        SemanticsPropertyKey semanticsPropertyKey = new SemanticsPropertyKey("MagnifierPositionInRoot", i, 2, i);
        Magnifier_androidKt.MagnifierPositionInRoot = semanticsPropertyKey;
    }

    public static final boolean equalsIncludingNaN(float $this$equalsIncludingNaN, float other) {
        boolean naN;
        int i;
        if (Float.isNaN($this$equalsIncludingNaN) && Float.isNaN(other)) {
            if (Float.isNaN(other)) {
                return 1;
            }
        }
        if (Float.compare($this$equalsIncludingNaN, other) == 0) {
        } else {
            i = 0;
        }
        return i;
    }

    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return Magnifier_androidKt.MagnifierPositionInRoot;
    }

    public static final boolean isPlatformMagnifierSupported(int sdkVersion) {
        int i;
        i = sdkVersion >= 28 ? 1 : 0;
        return i;
    }

    public static boolean isPlatformMagnifierSupported$default(int i, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = Build.VERSION.SDK_INT;
        }
        return Magnifier_androidKt.isPlatformMagnifierSupported(obj0);
    }

    public static final Modifier magnifier-UpNRX3w(Modifier $this$magnifier_u2dUpNRX3w, Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, Function1<? super DpSize, Unit> onSizeChanged, float zoom, long size, float cornerRadius, float elevation, boolean clip) {
        return Magnifier_androidKt.magnifier-jPUL71Q$default($this$magnifier_u2dUpNRX3w, sourceCenter, magnifierCenter, onSizeChanged, zoom, false, size, obj7, elevation, clip, obj23, 0, 512);
    }

    public static Modifier magnifier-UpNRX3w$default(Modifier modifier, Function1 function12, Function1 function13, Function1 function14, float f5, long l6, float f7, float f8, boolean z9, int i10, Object object11) {
        int obj3;
        int obj4;
        int obj5;
        long obj6;
        float obj8;
        float obj9;
        int obj10;
        final int i = 0;
        if (object11 & 2 != 0) {
            obj3 = i;
        }
        if (object11 & 4 != 0) {
            obj4 = i;
        }
        if (object11 & 8 != 0) {
            obj5 = 2143289344;
        }
        if (object11 & 16 != 0) {
            obj6 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }
        if (object11 & 32 != 0) {
            obj8 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (object11 & 64 != 0) {
            obj9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (object11 &= 128 != 0) {
            obj10 = 1;
        }
        return Magnifier_androidKt.magnifier-UpNRX3w(modifier, function12, obj3, obj4, obj5, obj6, f7, obj8, obj9);
    }

    public static final Modifier magnifier-jPUL71Q(Modifier $this$magnifier_u2djPUL71Q, Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, Function1<? super DpSize, Unit> onSizeChanged, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory) {
        boolean platformMagnifierSupported$default;
        Modifier then;
        int magnifierElement;
        int i2;
        Function1 function1;
        Function1 function12;
        float f2;
        boolean z;
        long l;
        float f;
        boolean z2;
        androidx.compose.foundation.PlatformMagnifierFactory factory;
        androidx.compose.foundation.PlatformMagnifierFactory factory2;
        int i;
        if (Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, 0)) {
            if (obj25 == null) {
                factory2 = platformMagnifierSupported$default;
            } else {
                factory2 = obj25;
            }
            magnifierElement = new MagnifierElement(sourceCenter, magnifierCenter, onSizeChanged, zoom, useTextDefault, size, obj8, elevation, clippingEnabled, platformMagnifierFactory, factory2, 0);
            then = $this$magnifier_u2djPUL71Q.then((Modifier)magnifierElement);
        } else {
            then = $this$magnifier_u2djPUL71Q;
        }
        return then;
    }

    public static Modifier magnifier-jPUL71Q$default(Modifier modifier, Function1 function12, Function1 function13, Function1 function14, float f5, boolean z6, long l7, float f8, float f9, boolean z10, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory11, int i12, Object object13) {
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        long obj7;
        float obj9;
        float obj10;
        int obj11;
        int obj12;
        final int i = 0;
        if (object13 & 2 != 0) {
            obj3 = i;
        }
        if (object13 & 4 != 0) {
            obj4 = i;
        }
        if (object13 & 8 != 0) {
            obj5 = 2143289344;
        }
        if (object13 & 16 != 0) {
            obj6 = 0;
        }
        if (object13 & 32 != 0) {
            obj7 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }
        if (object13 & 64 != 0) {
            obj9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (object13 & 128 != 0) {
            obj10 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (object13 & 256 != 0) {
            obj11 = 1;
        }
        if (object13 &= 512 != 0) {
            obj12 = i;
        }
        return Magnifier_androidKt.magnifier-jPUL71Q(modifier, function12, obj3, obj4, obj5, obj6, obj7, f8, obj9, obj10, obj11);
    }
}
