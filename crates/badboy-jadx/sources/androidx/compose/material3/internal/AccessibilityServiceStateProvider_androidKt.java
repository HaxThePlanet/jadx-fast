package androidx.compose.material3.internal;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00030\u00072\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nH\u0003¢\u0006\u0002\u0010\u000b\u001a'\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"SwitchAccessActivityName", "", "ObserveState", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "handleEvent", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "onDispose", "Lkotlin/Function0;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "rememberAccessibilityServiceState", "Landroidx/compose/runtime/State;", "", "listenToTouchExplorationState", "listenToSwitchAccessState", "(ZZLandroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccessibilityServiceStateProvider_androidKt {

    private static final String SwitchAccessActivityName = "SwitchAccess";
    private static final void ObserveState(LifecycleOwner lifecycleOwner, Function1<? super Lifecycle.Event, Unit> handleEvent, Function0<Unit> onDispose, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int i3;
        int $dirty;
        int i4;
        int iNSTANCE;
        boolean traceInProgress;
        int i5;
        int i;
        Object lifecycleOwner2;
        int i7;
        int rememberedValue;
        int i8;
        int i2;
        boolean skipping;
        int i9;
        int anon;
        Object obj9;
        Object obj10;
        traceInProgress2 = -1868327245;
        final Composer obj11 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj11, "C(ObserveState)P(1)75@2842L259,75@2809L292:AccessibilityServiceStateProvider.android.kt#mqatfk");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if ($changed & 6 == 0) {
                i4 = obj11.changedInstance(lifecycleOwner) ? 4 : 2;
                $dirty |= i4;
            }
        }
        iNSTANCE = i6 & 2;
        i = 32;
        if (iNSTANCE != null) {
            $dirty |= 48;
        } else {
            if ($changed & 48 == 0) {
                i7 = obj11.changedInstance(handleEvent) ? i : 16;
                $dirty |= i7;
            }
        }
        rememberedValue = i6 & 4;
        i8 = 256;
        if (rememberedValue != 0) {
            $dirty |= 384;
        } else {
            if ($changed & 384 == 0) {
                i2 = obj11.changedInstance(onDispose) ? i8 : 128;
                $dirty |= i2;
            }
        }
        if ($dirty & 147 == 146) {
            if (!obj11.getSkipping()) {
                if (iNSTANCE != null) {
                    obj9 = iNSTANCE;
                }
                if (rememberedValue != 0) {
                    obj10 = iNSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.internal.ObserveState (AccessibilityServiceStateProvider.android.kt:74)");
                }
                ComposerKt.sourceInformationMarkerStart(obj11, 1591666214, "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp");
                int i16 = 1;
                i3 = $dirty & 112 == i ? i16 : i5;
                if ($dirty & 896 == i8) {
                    i5 = i16;
                }
                iNSTANCE = obj11;
                i = 0;
                rememberedValue = iNSTANCE.rememberedValue();
                i8 = 0;
                if (i12 |= i5 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        skipping = 0;
                        anon = new AccessibilityServiceStateProvider_androidKt.ObserveState.3.1(lifecycleOwner, obj9, obj10);
                        iNSTANCE.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                EffectsKt.DisposableEffect(lifecycleOwner, (Function1)anon, obj11, $dirty & 14);
                if (ComposerKt.isTraceInProgress() != 0) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        obj9 = obj11.endRestartGroup();
        if (obj9 != null) {
            iNSTANCE = new AccessibilityServiceStateProvider_androidKt.ObserveState.4(lifecycleOwner, obj9, obj10, $changed, i6);
            obj9.updateScope((Function2)iNSTANCE);
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i9 = $changed;
        }
    }

    public static final void access$ObserveState(LifecycleOwner lifecycleOwner, Function1 handleEvent, Function0 onDispose, Composer $composer, int $changed, int $default) {
        AccessibilityServiceStateProvider_androidKt.ObserveState(lifecycleOwner, handleEvent, onDispose, $composer, $changed, $default);
    }

    public static final State<Boolean> rememberAccessibilityServiceState(boolean listenToTouchExplorationState, boolean listenToSwitchAccessState, Composer $composer, int $changed, int i5) {
        boolean changed;
        int i;
        int i2;
        int i7;
        boolean traceInProgress;
        String str;
        int i4;
        int i6;
        int i3;
        int changed2;
        int empty;
        Object empty2;
        Object anon2;
        Object empty3;
        Object anon;
        Object listener;
        final Composer composer3 = $composer;
        final int i24 = $changed;
        int i8 = -1771705152;
        ComposerKt.sourceInformationMarkerStart(composer3, i8, "C(rememberAccessibilityServiceState)P(1)47@1997L7,52@2152L157,57@2374L7,58@2405L144,63@2571L45,56@2315L307:AccessibilityServiceStateProvider.android.kt#mqatfk");
        i6 = i5 & 1 != 0 ? i2 : listenToTouchExplorationState;
        i3 = i5 & 2 != 0 ? i7 : listenToSwitchAccessState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i24, -1, "androidx.compose.material3.internal.rememberAccessibilityServiceState (AccessibilityServiceStateProvider.android.kt:46)");
        }
        int i12 = 0;
        int i14 = 0;
        int i19 = 2023513938;
        String str6 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer3, i19, str6);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        Object systemService = (Context)composer3.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()).getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        final Object obj3 = systemService;
        String str5 = "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer3, 18334252, str5);
        int i25 = 4;
        int i30 = 1;
        if (i10 ^= 6 > i25) {
            if (!composer3.changed(i6)) {
                i = i24 & 6 == i25 ? i30 : i4;
            } else {
            }
        } else {
        }
        int i31 = 32;
        if (i26 ^= 48 > i31) {
            if (!composer3.changed(i3)) {
                if (i24 & 48 == i31) {
                    i4 = i30;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i27 = 0;
        Object rememberedValue3 = composer.rememberedValue();
        empty2 = 0;
        if (i |= i4 == 0) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                empty3 = 0;
                listener = new Listener(i6, i3);
                composer.updateRememberedValue(listener);
            } else {
                listener = rememberedValue3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        int i15 = 0;
        int i28 = 0;
        ComposerKt.sourceInformationMarkerStart(composer3, i19, str6);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        ComposerKt.sourceInformationMarkerStart(composer3, 18342335, str5);
        Composer composer4 = $composer;
        int i22 = 0;
        Object rememberedValue2 = composer4.rememberedValue();
        empty = 0;
        if (changed4 |= changedInstance2 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty2 = 0;
                anon = new AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState.1.1(listener, obj3);
                composer4.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        ComposerKt.sourceInformationMarkerStart(composer3, 18347548, str5);
        Composer composer2 = $composer;
        int i20 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i29 = 0;
        if (changed3 |= changedInstance == null) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon2 = new AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState.2.1(listener, obj3);
                composer2.updateRememberedValue((Function0)anon2);
            } else {
                anon2 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        AccessibilityServiceStateProvider_androidKt.ObserveState((LifecycleOwner)composer3.consume((CompositionLocal)LocalLifecycleOwnerKt.getLocalLifecycleOwner()), (Function1)anon, (Function0)anon2, composer3, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)listener;
    }
}
