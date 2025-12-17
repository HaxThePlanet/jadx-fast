package androidx.compose.foundation.layout;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u000c\u0010\u0014\u001a\u00020\u0015*\u00020\u0015H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"DecelMinusOne", "", "DecelerationRate", "EndTension", "", "GravityEarth", "InchesPerMeter", "Inflection", "P1", "P2", "PlatformFlingScrollFriction", "StartTension", "rememberWindowInsetsConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "rememberWindowInsetsConnection-VRgvIgI", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "imeNestedScroll", "Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowInsetsConnection_androidKt {

    private static final double DecelMinusOne = 0d;
    private static final double DecelerationRate = 0d;
    private static final float EndTension = 1f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float PlatformFlingScrollFriction = 0f;
    private static final float StartTension = 0.5f;
    static {
        WindowInsetsConnection_androidKt.PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
        WindowInsetsConnection_androidKt.DecelerationRate = d /= d2;
        WindowInsetsConnection_androidKt.DecelMinusOne = decelerationRate -= l3;
    }

    public static final double access$getDecelMinusOne$p() {
        return WindowInsetsConnection_androidKt.DecelMinusOne;
    }

    public static final double access$getDecelerationRate$p() {
        return WindowInsetsConnection_androidKt.DecelerationRate;
    }

    public static final float access$getPlatformFlingScrollFriction$p() {
        return WindowInsetsConnection_androidKt.PlatformFlingScrollFriction;
    }

    public static final Modifier imeNestedScroll(Modifier $this$imeNestedScroll) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        if (Build.VERSION.SDK_INT < 30) {
            return $this$imeNestedScroll;
        }
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsConnection_androidKt.imeNestedScroll$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed($this$imeNestedScroll, noInspectorInfo, (Function3)WindowInsetsConnection_androidKt.imeNestedScroll.2.INSTANCE);
    }

    public static final NestedScrollConnection rememberWindowInsetsConnection-VRgvIgI(androidx.compose.foundation.layout.AndroidWindowInsets windowInsets, int side, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i;
        boolean changed;
        Object windowInsetsNestedScrollConnection;
        int empty2;
        Object empty;
        Object anon;
        final Object obj = windowInsets;
        final Composer composer = $composer;
        final int i2 = $changed;
        int i3 = -1011341039;
        composer.startReplaceGroup(i3);
        ComposerKt.sourceInformation(composer, "C(rememberWindowInsetsConnection)P(1,0:c#foundation.layout.WindowInsetsSides)112@4564L7,114@4677L7,115@4716L7,116@4745L149,119@4928L70,119@4899L99:WindowInsetsConnection.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.foundation.layout.rememberWindowInsetsConnection (WindowInsetsConnection.android.kt:108)");
        }
        if (Build.VERSION.SDK_INT < 30 && ComposerKt.isTraceInProgress()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return (NestedScrollConnection)DoNothingNestedScrollConnection.INSTANCE;
        }
        int i5 = 0;
        int i6 = 0;
        int i8 = 2023513938;
        String str3 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, i8, str3);
        ComposerKt.sourceInformationMarkerEnd(composer);
        androidx.compose.foundation.layout.SideCalculator chooseCalculator-ni1skBw = SideCalculator.Companion.chooseCalculator-ni1skBw(side, (LayoutDirection)composer.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()));
        int i14 = 0;
        int i16 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, i8, str3);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object this_$iv2 = consume3;
        int i17 = 0;
        int i19 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, i8, str3);
        Object consume = composer.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        String str4 = "CC(remember):WindowInsetsConnection.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, 786091504, str4);
        int i20 = 4;
        if (i10 ^= 6 > i20) {
            if (!composer.changed(obj)) {
                i = i2 & 6 == i20 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i22 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        empty2 = 0;
        if (i12 |= changed4 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty = 0;
                windowInsetsNestedScrollConnection = new WindowInsetsNestedScrollConnection(obj, this_$iv2, chooseCalculator-ni1skBw, consume);
                composer3.updateRememberedValue(windowInsetsNestedScrollConnection);
            } else {
                windowInsetsNestedScrollConnection = rememberedValue2;
            }
        } else {
        }
        Object invalid$iv = windowInsetsNestedScrollConnection;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 786097281, str4);
        Composer composer2 = $composer;
        int i21 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i23 = 0;
        if (!composer.changedInstance((WindowInsetsNestedScrollConnection)invalid$iv)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty2 = 0;
                anon = new WindowInsetsConnection_androidKt.rememberWindowInsetsConnection.1.1(invalid$iv);
                composer2.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(invalid$iv, (Function1)anon, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return (NestedScrollConnection)invalid$iv;
    }
}
