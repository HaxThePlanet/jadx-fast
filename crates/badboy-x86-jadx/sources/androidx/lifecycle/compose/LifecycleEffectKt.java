package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.SpreadBuilder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0008\u001a:\u0010\t\u001a\u00020\u00012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aD\u0010\t\u001a\u00020\u00012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001aN\u0010\t\u001a\u00020\u00012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aH\u0010\t\u001a\u00020\u00012\u0016\u0010\u0016\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u000b0\u0017\"\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001a0\u0010\t\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001a6\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000e2\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010H\u0003¢\u0006\u0002\u0010\u001e\u001a:\u0010\u001f\u001a\u00020\u00012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aD\u0010\u001f\u001a\u00020\u00012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001aN\u0010\u001f\u001a\u00020\u00012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aH\u0010\u001f\u001a\u00020\u00012\u0016\u0010\u0016\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u000b0\u0017\"\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001a0\u0010\u001f\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001a6\u0010#\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020 2\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\u0008\u0010H\u0003¢\u0006\u0002\u0010$\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006%²\u0006\u0010\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0007X\u008a\u0084\u0002", d2 = {"LifecycleEventEffect", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEvent", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffect", "key1", "", "effects", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "keys", "", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffectNoParamError", "", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffectImpl", "scope", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LifecycleResumeEffect", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "LifecycleResumeEffectNoParamError", "LifecycleResumeEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "lifecycle-runtime-compose_release", "currentOnEvent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LifecycleEffectKt {

    private static final String LifecycleResumeEffectNoParamError = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";
    private static final String LifecycleStartEffectNoParamError = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal;
            int ordinal2;
            int ordinal4;
            int[] iArr = new int[values.length];
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            LifecycleEffectKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static Unit $r8$lambda$8bzKyHHZCqzb9SblVoFH2ByLKC4(Object object, LifecycleOwner lifecycleOwner2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        return LifecycleEffectKt.LifecycleStartEffect$lambda$7(object, lifecycleOwner2, function13, i4, i5, composer6, i7);
    }

    public static Unit $r8$lambda$J2EU0u4ErqhhsQVd31MMbrXuld4(Object object, Object object2, LifecycleOwner lifecycleOwner3, Function1 function14, int i5, int i6, Composer composer7, int i8) {
        return LifecycleEffectKt.LifecycleResumeEffect$lambda$24(object, object2, lifecycleOwner3, function14, i5, i6, composer7, i8);
    }

    public static DisposableEffectResult $r8$lambda$McoMb-vtYCHG7kqO53pNoUU7vlc(LifecycleOwner lifecycleOwner, Lifecycle.Event lifecycle$Event2, State state3, DisposableEffectScope disposableEffectScope4) {
        return LifecycleEffectKt.LifecycleEventEffect$lambda$4$lambda$3(lifecycleOwner, event2, state3, disposableEffectScope4);
    }

    public static Unit $r8$lambda$Oaq8iy8v4crTBxcqXDHsJaszv7M(Object object, LifecycleOwner lifecycleOwner2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        return LifecycleEffectKt.LifecycleResumeEffect$lambda$22(object, lifecycleOwner2, function13, i4, i5, composer6, i7);
    }

    public static DisposableEffectResult $r8$lambda$PUrLiCRDyxiQyiMILf40eM-DV9Y(LifecycleOwner lifecycleOwner, androidx.lifecycle.compose.LifecycleStartStopEffectScope lifecycleStartStopEffectScope2, Function1 function13, DisposableEffectScope disposableEffectScope4) {
        return LifecycleEffectKt.LifecycleStartEffectImpl$lambda$19$lambda$18(lifecycleOwner, lifecycleStartStopEffectScope2, function13, disposableEffectScope4);
    }

    public static Unit $r8$lambda$S4y9Av_xlpqdpS8rzUtJU7sNCQA(LifecycleOwner lifecycleOwner, androidx.lifecycle.compose.LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope2, Function1 function13, int i4, Composer composer5, int i6) {
        return LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$35(lifecycleOwner, lifecycleResumePauseEffectScope2, function13, i4, composer5, i6);
    }

    public static void $r8$lambda$U8iR5zzpW29bJfZc5BoIrQkGok8(androidx.lifecycle.compose.LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, Ref.ObjectRef ref$ObjectRef2, Function1 function13, LifecycleOwner lifecycleOwner4, Lifecycle.Event lifecycle$Event5) {
        LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$34$lambda$33$lambda$31(lifecycleResumePauseEffectScope, objectRef2, function13, lifecycleOwner4, event5);
    }

    public static Unit $r8$lambda$VhHZ9_5XMFg4BpLseq4yssslLaA(Object[] objectArr, LifecycleOwner lifecycleOwner2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        return LifecycleEffectKt.LifecycleStartEffect$lambda$13(objectArr, lifecycleOwner2, function13, i4, i5, composer6, i7);
    }

    public static Unit $r8$lambda$XqIvy_KZNiIURbcIjbDW9mUMa8M(Lifecycle.Event lifecycle$Event, LifecycleOwner lifecycleOwner2, Function0 function03, int i4, int i5, Composer composer6, int i7) {
        return LifecycleEffectKt.LifecycleEventEffect$lambda$5(event, lifecycleOwner2, function03, i4, i5, composer6, i7);
    }

    public static Unit $r8$lambda$XtWJ-Ap7YlZ8827llsqnMxJradU(Object object, Object object2, Object object3, LifecycleOwner lifecycleOwner4, Function1 function15, int i6, int i7, Composer composer8, int i9) {
        return LifecycleEffectKt.LifecycleResumeEffect$lambda$26(object, object2, object3, lifecycleOwner4, function15, i6, i7, composer8, i9);
    }

    public static Unit $r8$lambda$YvasQY_CHlaaOx9zROCqfNYHlEk(Object object, Object object2, LifecycleOwner lifecycleOwner3, Function1 function14, int i5, int i6, Composer composer7, int i8) {
        return LifecycleEffectKt.LifecycleStartEffect$lambda$9(object, object2, lifecycleOwner3, function14, i5, i6, composer7, i8);
    }

    public static Unit $r8$lambda$ZvKBd6N4WIHuZk_T0f6oNh9FfXM(Object object, Object object2, Object object3, LifecycleOwner lifecycleOwner4, Function1 function15, int i6, int i7, Composer composer8, int i9) {
        return LifecycleEffectKt.LifecycleStartEffect$lambda$11(object, object2, object3, lifecycleOwner4, function15, i6, i7, composer8, i9);
    }

    public static Unit $r8$lambda$dhxYxGcZzmP4EcbgypBPrp4e2Zw(LifecycleOwner lifecycleOwner, androidx.lifecycle.compose.LifecycleStartStopEffectScope lifecycleStartStopEffectScope2, Function1 function13, int i4, Composer composer5, int i6) {
        return LifecycleEffectKt.LifecycleStartEffectImpl$lambda$20(lifecycleOwner, lifecycleStartStopEffectScope2, function13, i4, composer5, i6);
    }

    public static Unit $r8$lambda$fG5EioCWegWkcYAUWasUB3mK4O0(LifecycleOwner lifecycleOwner, Function1 function12, int i3, int i4, Composer composer5, int i6) {
        return LifecycleEffectKt.LifecycleResumeEffect$lambda$29(lifecycleOwner, function12, i3, i4, composer5, i6);
    }

    public static Unit $r8$lambda$hZtSW1S-Z2h0jiUNaDhPVpNEoTI(LifecycleOwner lifecycleOwner, Function1 function12, int i3, int i4, Composer composer5, int i6) {
        return LifecycleEffectKt.LifecycleStartEffect$lambda$14(lifecycleOwner, function12, i3, i4, composer5, i6);
    }

    public static void $r8$lambda$kW42innSE2_-LAefpkhwfqpRLOs(androidx.lifecycle.compose.LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Ref.ObjectRef ref$ObjectRef2, Function1 function13, LifecycleOwner lifecycleOwner4, Lifecycle.Event lifecycle$Event5) {
        LifecycleEffectKt.LifecycleStartEffectImpl$lambda$19$lambda$18$lambda$16(lifecycleStartStopEffectScope, objectRef2, function13, lifecycleOwner4, event5);
    }

    public static void $r8$lambda$mC-yXF6jqj4lSx-8HEVBDRNqsMQ(Lifecycle.Event lifecycle$Event, State state2, LifecycleOwner lifecycleOwner3, Lifecycle.Event lifecycle$Event4) {
        LifecycleEffectKt.LifecycleEventEffect$lambda$4$lambda$3$lambda$1(event, state2, lifecycleOwner3, event4);
    }

    public static Unit $r8$lambda$mhsn_NlV0BEghV4DmYHJjpSKTOk(Object[] objectArr, LifecycleOwner lifecycleOwner2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        return LifecycleEffectKt.LifecycleResumeEffect$lambda$28(objectArr, lifecycleOwner2, function13, i4, i5, composer6, i7);
    }

    public static DisposableEffectResult $r8$lambda$qDm9PLSTXQitJfRVtlwQ3KyApz8(LifecycleOwner lifecycleOwner, androidx.lifecycle.compose.LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope2, Function1 function13, DisposableEffectScope disposableEffectScope4) {
        return LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$34$lambda$33(lifecycleOwner, lifecycleResumePauseEffectScope2, function13, disposableEffectScope4);
    }

    public static final void LifecycleEventEffect(Lifecycle.Event event, LifecycleOwner lifecycleOwner, Function0<Unit> onEvent, Composer $composer, int $changed, int i6) {
        int rememberUpdatedState;
        int $dirty;
        int i4;
        int i2;
        int changedInstance;
        int i3;
        int traceInProgress;
        int defaultsInvalid;
        int localLifecycleOwner;
        boolean traceInProgress2;
        int i5;
        int externalSyntheticLambda4;
        int str;
        Lifecycle.Event event2;
        int rememberedValue;
        Object consume;
        Object obj;
        String empty;
        int i;
        Object externalSyntheticLambda3;
        Object obj10;
        rememberUpdatedState = -709389590;
        final Composer obj12 = $composer.startRestartGroup(rememberUpdatedState);
        ComposerKt.sourceInformation(obj12, "C(LifecycleEventEffect)65@2872L29,66@2939L279,66@2906L312:LifecycleEffect.kt#2vxrgp");
        $dirty = $changed;
        externalSyntheticLambda4 = 4;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if ($changed & 6 == 0) {
                i4 = obj12.changed((Enum)event.ordinal()) ? externalSyntheticLambda4 : 2;
                $dirty |= i4;
            }
        }
        if ($changed & 48 == 0) {
            if (i6 & 2 == 0 && obj12.changedInstance(lifecycleOwner)) {
                i2 = obj12.changedInstance(lifecycleOwner) ? 32 : 16;
            } else {
            }
            $dirty |= i2;
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if ($changed & 384 == 0) {
                i3 = obj12.changedInstance(onEvent) ? 256 : 128;
                $dirty |= i3;
            }
        }
        if ($dirty & 147 == 146) {
            if (!obj12.getSkipping()) {
                obj12.startDefaults();
                ComposerKt.sourceInformation(obj12, "53@2411L7");
                if ($changed & 1 != 0) {
                    if (obj12.getDefaultsInvalid()) {
                        if (i6 & 2 != 0) {
                            str = 6;
                            rememberedValue = 0;
                            ComposerKt.sourceInformationMarkerStart(obj12, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(obj12);
                            obj10 = consume;
                            $dirty &= -113;
                        }
                    } else {
                        obj12.skipToGroupEnd();
                        if (i6 & 2 != 0) {
                        }
                    }
                } else {
                }
                obj12.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(rememberUpdatedState, $dirty, -1, "androidx.lifecycle.compose.LifecycleEventEffect (LifecycleEffect.kt:55)");
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                } else {
                    obj10 = obj12.endRestartGroup();
                    if (obj10 != null) {
                        externalSyntheticLambda4 = new LifecycleEffectKt$$ExternalSyntheticLambda4(event, obj10, onEvent, $changed, i6);
                        obj10.updateScope(externalSyntheticLambda4);
                    } else {
                        event2 = event;
                        obj = onEvent;
                        i = $changed;
                    }
                }
            } else {
                obj12.skipToGroupEnd();
            }
        } else {
        }
        Lifecycle.Event event4 = event;
        Object obj3 = onEvent;
        IllegalArgumentException obj9 = new IllegalArgumentException("LifecycleEventEffect cannot be used to listen for Lifecycle.Event.ON_DESTROY, since Compose disposes of the composition before ON_DESTROY observers are invoked.");
        throw obj9;
    }

    private static final Function0<Unit> LifecycleEventEffect$lambda$0(State<? extends Function0<Unit>> $currentOnEvent$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function0)$currentOnEvent$delegate.getValue();
    }

    private static final DisposableEffectResult LifecycleEventEffect$lambda$4$lambda$3(LifecycleOwner $lifecycleOwner, Lifecycle.Event $event, State $currentOnEvent$delegate, DisposableEffectScope $this$DisposableEffect) {
        LifecycleEffectKt$$ExternalSyntheticLambda7 externalSyntheticLambda7 = new LifecycleEffectKt$$ExternalSyntheticLambda7($event, $currentOnEvent$delegate);
        $lifecycleOwner.getLifecycle().addObserver((LifecycleObserver)externalSyntheticLambda7);
        Object obj = $this$DisposableEffect;
        int i = 0;
        LifecycleEffectKt.LifecycleEventEffect.lambda.4.lambda.3$$inlined.onDispose.1 anon = new LifecycleEffectKt.LifecycleEventEffect.lambda.4.lambda.3$$inlined.onDispose.1($lifecycleOwner, externalSyntheticLambda7);
        return (DisposableEffectResult)anon;
    }

    private static final void LifecycleEventEffect$lambda$4$lambda$3$lambda$1(Lifecycle.Event $event, State $currentOnEvent$delegate, LifecycleOwner lifecycleOwner3, Lifecycle.Event e) {
        Function0 obj2;
        if (e == $event) {
            LifecycleEffectKt.LifecycleEventEffect$lambda$0($currentOnEvent$delegate).invoke();
        }
    }

    private static final Unit LifecycleEventEffect$lambda$5(Lifecycle.Event lifecycle$Event, LifecycleOwner lifecycleOwner2, Function0 function03, int i4, int i5, Composer composer6, int i7) {
        LifecycleEffectKt.LifecycleEventEffect(event, lifecycleOwner2, function03, composer6, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.")
    public static final void LifecycleResumeEffect(LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> effects, Composer $composer, int $changed, int i5) {
        int $dirty;
        int skipping;
        int defaultsInvalid;
        int i;
        Object consume;
        String str;
        Object obj6;
        int obj10;
        int i2 = -747476210;
        final Composer obj8 = $composer.startRestartGroup(i2);
        ComposerKt.sourceInformation(obj8, "C(LifecycleResumeEffect)P(1):LifecycleEffect.kt#2vxrgp");
        $dirty = $changed;
        if ($dirty & 1 == 0) {
            if (!obj8.getSkipping()) {
            } else {
                obj8.skipToGroupEnd();
                ScopeUpdateScope endRestartGroup = obj8.endRestartGroup();
                if (endRestartGroup != null) {
                    skipping = new LifecycleEffectKt$$ExternalSyntheticLambda14(lifecycleOwner, effects, $changed, i5);
                    endRestartGroup.updateScope(skipping);
                }
            }
        }
        obj8.startDefaults();
        ComposerKt.sourceInformation(obj8, "654@31678L7");
        if ($changed & 1 != 0) {
            if (obj8.getDefaultsInvalid()) {
                if (i5 &= 1 != 0) {
                    defaultsInvalid = 6;
                    i = 0;
                    ComposerKt.sourceInformationMarkerStart(obj8, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(obj8);
                    obj6 = consume;
                    $dirty &= -15;
                }
            } else {
                obj8.skipToGroupEnd();
                if (i5 &= 1 != 0) {
                }
            }
        } else {
        }
        obj8.endDefaults();
        if (!ComposerKt.isTraceInProgress()) {
        } else {
            ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:656)");
        }
        obj10 = new IllegalStateException("LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.".toString());
        throw obj10;
    }

    public static final void LifecycleResumeEffect(Object key1, LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> effects, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty;
        int i2;
        int i;
        int changedInstance;
        int i3;
        int skipping;
        int defaultsInvalid;
        int localLifecycleOwner;
        boolean traceInProgress;
        Object obj;
        int str;
        int rememberedValue;
        Object consume;
        String empty;
        Object lifecycleResumePauseEffectScope;
        Lifecycle lifecycle;
        Object obj13;
        final int i10 = $changed;
        traceInProgress2 = 1220373486;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LifecycleResumeEffect)P(1,2)449@21383L92,450@21480L83:LifecycleEffect.kt#2vxrgp");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i10 & 6 == 0) {
                i2 = restartGroup.changedInstance(key1) ? 4 : 2;
                $dirty |= i2;
            }
        }
        if (i10 & 48 == 0) {
            if (i6 & 2 == 0 && restartGroup.changedInstance(lifecycleOwner)) {
                i = restartGroup.changedInstance(lifecycleOwner) ? 32 : 16;
            } else {
            }
            $dirty |= i;
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i10 & 384 == 0) {
                i3 = restartGroup.changedInstance(effects) ? 256 : 128;
                $dirty |= i3;
            }
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "445@21233L7");
                if (i10 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i6 & 2 != 0) {
                            str = 6;
                            rememberedValue = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj13 = consume;
                            $dirty &= -113;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i6 & 2 != 0) {
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:447)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 252856938, "CC(remember):LifecycleEffect.kt#9igjgp");
                Composer composer = restartGroup;
                str = 0;
                rememberedValue = composer.rememberedValue();
                consume = 0;
                if (changed |= changed2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        lifecycleResumePauseEffectScope = new LifecycleResumePauseEffectScope(obj13.getLifecycle());
                        composer.updateRememberedValue(lifecycleResumePauseEffectScope);
                    } else {
                        lifecycleResumePauseEffectScope = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LifecycleEffectKt.LifecycleResumeEffectImpl(obj13, (LifecycleResumePauseEffectScope)lifecycleResumePauseEffectScope, effects, restartGroup, i8 |= skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        obj13 = $dirty;
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LifecycleEffectKt$$ExternalSyntheticLambda2(key1, obj13, effects, i10, i6);
            endRestartGroup.updateScope(traceInProgress2);
        }
    }

    public static final void LifecycleResumeEffect(Object key1, Object key2, LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> effects, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int $dirty;
        Object obj;
        int i;
        int i4;
        Object obj2;
        int changedInstance;
        int i2;
        boolean skipping;
        int localLifecycleOwner;
        boolean traceInProgress;
        int defaultsInvalid;
        int i3;
        int str;
        Object rememberedValue;
        int consume;
        Object empty;
        Object lifecycleResumePauseEffectScope;
        Lifecycle lifecycle;
        final Object obj4 = effects;
        final int i14 = $changed;
        traceInProgress2 = 752680142;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LifecycleResumeEffect)P(1,2,3)508@24459L118,511@24582L83:LifecycleEffect.kt#2vxrgp");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i14 & 6 == 0) {
                i = restartGroup.changedInstance(key1) ? 4 : 2;
                $dirty |= i;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i14 & 48 == 0) {
                i4 = restartGroup.changedInstance(key2) ? 32 : 16;
                $dirty |= i4;
            }
        }
        if (i14 & 384 == 0) {
            if (i7 & 4 == 0) {
                changedInstance = restartGroup.changedInstance(lifecycleOwner) ? 256 : 128;
            } else {
                obj2 = lifecycleOwner;
            }
            $dirty |= changedInstance;
        } else {
            obj2 = lifecycleOwner;
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i14 & 3072 == 0) {
                i2 = restartGroup.changedInstance(obj4) ? 2048 : 1024;
                $dirty |= i2;
            }
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "504@24309L7");
                if (i14 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i7 & 4 != 0) {
                            str = 6;
                            rememberedValue = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj2 = consume;
                            $dirty &= -897;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:506)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1771119972, "CC(remember):LifecycleEffect.kt#9igjgp");
                Composer composer = restartGroup;
                int i16 = 0;
                rememberedValue = composer.rememberedValue();
                consume = 0;
                if (i6 |= changed3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        lifecycleResumePauseEffectScope = new LifecycleResumePauseEffectScope(obj2.getLifecycle());
                        composer.updateRememberedValue(lifecycleResumePauseEffectScope);
                    } else {
                        lifecycleResumePauseEffectScope = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LifecycleEffectKt.LifecycleResumeEffectImpl(obj2, (LifecycleResumePauseEffectScope)lifecycleResumePauseEffectScope, obj4, restartGroup, i10 |= skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i3 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LifecycleEffectKt$$ExternalSyntheticLambda13(key1, key2, obj2, obj4, i14, i7);
            endRestartGroup.updateScope(traceInProgress2);
        }
    }

    public static final void LifecycleResumeEffect(Object key1, Object key2, Object key3, LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> effects, Composer $composer, int $changed, int i8) {
        int traceInProgress2;
        int $dirty;
        Object $dirty2;
        int i3;
        int i;
        int i4;
        Object obj;
        int changedInstance;
        int i5;
        int skipping;
        int localLifecycleOwner;
        boolean traceInProgress;
        int defaultsInvalid;
        int i2;
        int str;
        int rememberedValue;
        Object consume;
        String empty;
        Object lifecycleResumePauseEffectScope;
        Lifecycle lifecycle;
        final Object obj2 = key1;
        final Object obj3 = key2;
        final Object obj4 = key3;
        final Object obj6 = effects;
        final int i14 = $changed;
        traceInProgress2 = -485941842;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LifecycleResumeEffect)P(1,2,3,4)572@27657L124,575@27786L83:LifecycleEffect.kt#2vxrgp");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i14 & 6 == 0) {
                i3 = restartGroup.changedInstance(obj2) ? 4 : 2;
                $dirty |= i3;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i14 & 48 == 0) {
                i = restartGroup.changedInstance(obj3) ? 32 : 16;
                $dirty |= i;
            }
        }
        if (i8 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i14 & 384 == 0) {
                i4 = restartGroup.changedInstance(obj4) ? 256 : 128;
                $dirty |= i4;
            }
        }
        if (i14 & 3072 == 0) {
            if (i8 & 8 == 0) {
                changedInstance = restartGroup.changedInstance(lifecycleOwner) ? 2048 : 1024;
            } else {
                obj = lifecycleOwner;
            }
            $dirty |= changedInstance;
        } else {
            obj = lifecycleOwner;
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i14 & 24576 == 0) {
                i5 = restartGroup.changedInstance(obj6) ? 16384 : 8192;
                $dirty |= i5;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "568@27507L7");
                if (i14 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i8 & 8 != 0) {
                            str = 6;
                            rememberedValue = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj = consume;
                            $dirty &= -7169;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 8 != 0) {
                            $dirty &= -7169;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:570)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1161334858, "CC(remember):LifecycleEffect.kt#9igjgp");
                Composer composer = restartGroup;
                str = 0;
                rememberedValue = composer.rememberedValue();
                consume = 0;
                if (i9 |= changed4 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        lifecycleResumePauseEffectScope = new LifecycleResumePauseEffectScope(obj.getLifecycle());
                        composer.updateRememberedValue(lifecycleResumePauseEffectScope);
                    } else {
                        lifecycleResumePauseEffectScope = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LifecycleEffectKt.LifecycleResumeEffectImpl(obj, (LifecycleResumePauseEffectScope)lifecycleResumePauseEffectScope, obj6, restartGroup, i12 |= i18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i2 = $dirty;
                $dirty2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                i2 = $dirty;
                $dirty2 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LifecycleEffectKt$$ExternalSyntheticLambda11(obj2, obj3, obj4, $dirty2, obj6, i14, i8);
            endRestartGroup.updateScope(traceInProgress2);
        }
    }

    public static final void LifecycleResumeEffect(Object[] keys, LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> effects, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        Object[] lifecycle;
        int $dirty2;
        int $dirty3;
        Object $dirty;
        Object obj;
        int changedInstance;
        int i3;
        int i;
        int i2;
        int skipping;
        int localLifecycleOwner;
        boolean traceInProgress;
        int defaultsInvalid;
        int str;
        int i4;
        int invalid$iv;
        Object consume;
        int rememberedValue;
        int changed;
        Object empty;
        Object lifecycleResumePauseEffectScope;
        Object[] obj17;
        final Object obj2 = keys;
        final Object obj4 = effects;
        final int i9 = $changed;
        traceInProgress2 = -781756895;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LifecycleResumeEffect)P(1,2)631@30683L113,634@30801L83:LifecycleEffect.kt#2vxrgp");
        if (i9 & 48 == 0) {
            if (i6 & 2 == 0) {
                changedInstance = restartGroup.changedInstance(lifecycleOwner) ? 32 : 16;
            } else {
                obj = lifecycleOwner;
            }
            $dirty2 |= changedInstance;
        } else {
            obj = lifecycleOwner;
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i9 & 384 == 0) {
                i3 = restartGroup.changedInstance(obj4) ? 256 : 128;
                $dirty2 |= i3;
            }
        }
        restartGroup.startMovableGroup(350902322, Integer.valueOf(obj2.length));
        ComposerKt.sourceInformation(restartGroup, "627@30533L7");
        int i17 = 4;
        i4 = 0;
        i = restartGroup.changed(obj2.length) ? i17 : i4;
        $dirty2 |= i;
        invalid$iv = i4;
        while (invalid$iv < obj2.length) {
            if (restartGroup.changedInstance(obj2[invalid$iv])) {
            } else {
            }
            rememberedValue = i4;
            $dirty3 |= rememberedValue;
            invalid$iv++;
            rememberedValue = i17;
        }
        restartGroup.endMovableGroup();
        if ($dirty3 & 14 == 0) {
            $dirty3 |= 2;
        }
        if ($dirty3 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "");
                if (i9 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i6 & 2 != 0) {
                            str = 6;
                            invalid$iv = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj = consume;
                            $dirty3 &= -113;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i6 & 2 != 0) {
                            $dirty3 &= -113;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty3, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:629)");
                }
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread(obj2);
                spreadBuilder.add(obj);
                lifecycle = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
                int i14 = 0;
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -568225417, "CC(remember)P(1):Composables.kt#9igjgp");
                invalid$iv = 0;
                while (i4 < lifecycle.length) {
                    invalid$iv |= changed;
                    i4++;
                }
                i4 = restartGroup;
                consume = 0;
                rememberedValue = i4.rememberedValue();
                changed = 0;
                if (invalid$iv == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj17 = lifecycle;
                        lifecycleResumePauseEffectScope = new LifecycleResumePauseEffectScope(obj.getLifecycle());
                        i4.updateRememberedValue(lifecycleResumePauseEffectScope);
                    } else {
                        obj17 = lifecycle;
                        lifecycleResumePauseEffectScope = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LifecycleEffectKt.LifecycleResumeEffectImpl(obj, (LifecycleResumePauseEffectScope)lifecycleResumePauseEffectScope, obj4, restartGroup, i7 |= i15);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i2 = $dirty3;
                $dirty = obj;
            } else {
                restartGroup.skipToGroupEnd();
                i2 = $dirty3;
                $dirty = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LifecycleEffectKt$$ExternalSyntheticLambda6(obj2, $dirty, obj4, i9, i6);
            endRestartGroup.updateScope(traceInProgress2);
        }
    }

    private static final Unit LifecycleResumeEffect$lambda$22(Object object, LifecycleOwner lifecycleOwner2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        LifecycleEffectKt.LifecycleResumeEffect(object, lifecycleOwner2, function13, composer6, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    private static final Unit LifecycleResumeEffect$lambda$24(Object object, Object object2, LifecycleOwner lifecycleOwner3, Function1 function14, int i5, int i6, Composer composer7, int i8) {
        LifecycleEffectKt.LifecycleResumeEffect(object, object2, lifecycleOwner3, function14, composer7, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final Unit LifecycleResumeEffect$lambda$26(Object object, Object object2, Object object3, LifecycleOwner lifecycleOwner4, Function1 function15, int i6, int i7, Composer composer8, int i9) {
        LifecycleEffectKt.LifecycleResumeEffect(object, object2, object3, lifecycleOwner4, function15, composer8, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final Unit LifecycleResumeEffect$lambda$28(Object[] objectArr, LifecycleOwner lifecycleOwner2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        LifecycleEffectKt.LifecycleResumeEffect(objectArr, lifecycleOwner2, function13, composer6, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    private static final Unit LifecycleResumeEffect$lambda$29(LifecycleOwner lifecycleOwner, Function1 function12, int i3, int i4, Composer composer5, int i6) {
        LifecycleEffectKt.LifecycleResumeEffect(lifecycleOwner, function12, composer5, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    private static final void LifecycleResumeEffectImpl(LifecycleOwner lifecycleOwner, androidx.lifecycle.compose.LifecycleResumePauseEffectScope scope, Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> effects, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i3;
        int i6;
        int i4;
        boolean skipping;
        boolean traceInProgress2;
        int i2;
        int i5;
        int rememberedValue;
        int i;
        Object empty;
        Object obj;
        traceInProgress = 912823238;
        final Composer obj11 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj11, "C(LifecycleResumeEffectImpl)P(1,2)664@32092L670,664@32052L710:LifecycleEffect.kt#2vxrgp");
        if ($changed & 6 == 0) {
            i3 = obj11.changedInstance(lifecycleOwner) ? 4 : 2;
            $dirty |= i3;
        }
        if ($changed & 48 == 0) {
            i6 = obj11.changedInstance(scope) ? 32 : 16;
            $dirty |= i6;
        }
        i5 = 256;
        if ($changed & 384 == 0) {
            i4 = obj11.changedInstance(effects) ? i5 : 128;
            $dirty |= i4;
        }
        if ($dirty & 147 == 146) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffectImpl (LifecycleEffect.kt:663)");
                }
                ComposerKt.sourceInformationMarkerStart(obj11, 1049812516, "CC(remember):LifecycleEffect.kt#9igjgp");
                i2 = $dirty & 896 == i5 ? 1 : 0;
                Composer composer = obj11;
                i5 = 0;
                rememberedValue = composer.rememberedValue();
                i = 0;
                if (i8 |= changedInstance3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj = new LifecycleEffectKt$$ExternalSyntheticLambda17(lifecycleOwner, scope, effects);
                        composer.updateRememberedValue(obj);
                    } else {
                        obj = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                EffectsKt.DisposableEffect(lifecycleOwner, scope, (Function1)obj, obj11, i10 |= skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new LifecycleEffectKt$$ExternalSyntheticLambda18(lifecycleOwner, scope, effects, $changed);
            endRestartGroup.updateScope(skipping);
        }
    }

    private static final DisposableEffectResult LifecycleResumeEffectImpl$lambda$34$lambda$33(LifecycleOwner $lifecycleOwner, androidx.lifecycle.compose.LifecycleResumePauseEffectScope $scope, Function1 $effects, DisposableEffectScope $this$DisposableEffect) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LifecycleEffectKt$$ExternalSyntheticLambda12 externalSyntheticLambda12 = new LifecycleEffectKt$$ExternalSyntheticLambda12($scope, objectRef, $effects);
        $lifecycleOwner.getLifecycle().addObserver((LifecycleObserver)externalSyntheticLambda12);
        Object obj = $this$DisposableEffect;
        int i = 0;
        LifecycleEffectKt.LifecycleResumeEffectImpl.lambda.34.lambda.33$$inlined.onDispose.1 anon = new LifecycleEffectKt.LifecycleResumeEffectImpl.lambda.34.lambda.33$$inlined.onDispose.1($lifecycleOwner, externalSyntheticLambda12, objectRef);
        return (DisposableEffectResult)anon;
    }

    private static final void LifecycleResumeEffectImpl$lambda$34$lambda$33$lambda$31(androidx.lifecycle.compose.LifecycleResumePauseEffectScope $scope, Ref.ObjectRef $effectResult, Function1 $effects, LifecycleOwner lifecycleOwner4, Lifecycle.Event event) {
        int ordinal;
        Object invoke;
        int obj5;
        switch (obj5) {
            case 3:
                ordinal = 0;
                $effectResult.element = $effects.invoke($scope);
                break;
            case 4:
                obj5 = $effectResult.element;
                (LifecyclePauseOrDisposeEffectResult)obj5.runPauseOrOnDisposeEffect();
                $effectResult.element = 0;
                break;
            default:
        }
    }

    private static final Unit LifecycleResumeEffectImpl$lambda$35(LifecycleOwner lifecycleOwner, androidx.lifecycle.compose.LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope2, Function1 function13, int i4, Composer composer5, int i6) {
        LifecycleEffectKt.LifecycleResumeEffectImpl(lifecycleOwner, lifecycleResumePauseEffectScope2, function13, composer5, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.")
    public static final void LifecycleStartEffect(LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> effects, Composer $composer, int $changed, int i5) {
        int $dirty;
        int skipping;
        int defaultsInvalid;
        int i;
        Object consume;
        String str;
        Object obj6;
        int obj10;
        int i2 = -50807951;
        final Composer obj8 = $composer.startRestartGroup(i2);
        ComposerKt.sourceInformation(obj8, "C(LifecycleStartEffect)P(1):LifecycleEffect.kt#2vxrgp");
        $dirty = $changed;
        if ($dirty & 1 == 0) {
            if (!obj8.getSkipping()) {
            } else {
                obj8.skipToGroupEnd();
                ScopeUpdateScope endRestartGroup = obj8.endRestartGroup();
                if (endRestartGroup != null) {
                    skipping = new LifecycleEffectKt$$ExternalSyntheticLambda1(lifecycleOwner, effects, $changed, i5);
                    endRestartGroup.updateScope(skipping);
                }
            }
        }
        obj8.startDefaults();
        ComposerKt.sourceInformation(obj8, "331@16104L7");
        if ($changed & 1 != 0) {
            if (obj8.getDefaultsInvalid()) {
                if (i5 &= 1 != 0) {
                    defaultsInvalid = 6;
                    i = 0;
                    ComposerKt.sourceInformationMarkerStart(obj8, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(obj8);
                    obj6 = consume;
                    $dirty &= -15;
                }
            } else {
                obj8.skipToGroupEnd();
                if (i5 &= 1 != 0) {
                }
            }
        } else {
        }
        obj8.endDefaults();
        if (!ComposerKt.isTraceInProgress()) {
        } else {
            ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:333)");
        }
        obj10 = new IllegalStateException("LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.".toString());
        throw obj10;
    }

    public static final void LifecycleStartEffect(Object key1, LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> effects, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty;
        int i;
        int i2;
        int changedInstance;
        int i3;
        int skipping;
        int defaultsInvalid;
        int localLifecycleOwner;
        boolean traceInProgress;
        Object obj;
        int str;
        int rememberedValue;
        Object consume;
        String empty;
        Object lifecycleStartStopEffectScope;
        Lifecycle lifecycle;
        Object obj13;
        final int i10 = $changed;
        traceInProgress2 = -1408314671;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LifecycleStartEffect)P(1,2)131@5981L90,132@6076L80:LifecycleEffect.kt#2vxrgp");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i10 & 6 == 0) {
                i = restartGroup.changedInstance(key1) ? 4 : 2;
                $dirty |= i;
            }
        }
        if (i10 & 48 == 0) {
            if (i6 & 2 == 0 && restartGroup.changedInstance(lifecycleOwner)) {
                i2 = restartGroup.changedInstance(lifecycleOwner) ? 32 : 16;
            } else {
            }
            $dirty |= i2;
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i10 & 384 == 0) {
                i3 = restartGroup.changedInstance(effects) ? 256 : 128;
                $dirty |= i3;
            }
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "127@5836L7");
                if (i10 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i6 & 2 != 0) {
                            str = 6;
                            rememberedValue = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj13 = consume;
                            $dirty &= -113;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i6 & 2 != 0) {
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:129)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -475692085, "CC(remember):LifecycleEffect.kt#9igjgp");
                Composer composer = restartGroup;
                str = 0;
                rememberedValue = composer.rememberedValue();
                consume = 0;
                if (changed |= changed2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        lifecycleStartStopEffectScope = new LifecycleStartStopEffectScope(obj13.getLifecycle());
                        composer.updateRememberedValue(lifecycleStartStopEffectScope);
                    } else {
                        lifecycleStartStopEffectScope = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LifecycleEffectKt.LifecycleStartEffectImpl(obj13, (LifecycleStartStopEffectScope)lifecycleStartStopEffectScope, effects, restartGroup, i8 |= skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        obj13 = $dirty;
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LifecycleEffectKt$$ExternalSyntheticLambda0(key1, obj13, effects, i10, i6);
            endRestartGroup.updateScope(traceInProgress2);
        }
    }

    public static final void LifecycleStartEffect(Object key1, Object key2, LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> effects, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int $dirty;
        Object obj;
        int i4;
        int i;
        Object obj2;
        int changedInstance;
        int i2;
        boolean skipping;
        int localLifecycleOwner;
        boolean traceInProgress;
        int defaultsInvalid;
        int i3;
        int str;
        Object rememberedValue;
        int consume;
        Object empty;
        Object lifecycleStartStopEffectScope;
        Lifecycle lifecycle;
        final Object obj4 = effects;
        final int i14 = $changed;
        traceInProgress2 = 696924721;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LifecycleStartEffect)P(1,2,3)189@9008L116,192@9129L80:LifecycleEffect.kt#2vxrgp");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i14 & 6 == 0) {
                i4 = restartGroup.changedInstance(key1) ? 4 : 2;
                $dirty |= i4;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i14 & 48 == 0) {
                i = restartGroup.changedInstance(key2) ? 32 : 16;
                $dirty |= i;
            }
        }
        if (i14 & 384 == 0) {
            if (i7 & 4 == 0) {
                changedInstance = restartGroup.changedInstance(lifecycleOwner) ? 256 : 128;
            } else {
                obj2 = lifecycleOwner;
            }
            $dirty |= changedInstance;
        } else {
            obj2 = lifecycleOwner;
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i14 & 3072 == 0) {
                i2 = restartGroup.changedInstance(obj4) ? 2048 : 1024;
                $dirty |= i2;
            }
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "185@8863L7");
                if (i14 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i7 & 4 != 0) {
                            str = 6;
                            rememberedValue = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj2 = consume;
                            $dirty &= -897;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:187)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -270232251, "CC(remember):LifecycleEffect.kt#9igjgp");
                Composer composer = restartGroup;
                int i16 = 0;
                rememberedValue = composer.rememberedValue();
                consume = 0;
                if (i6 |= changed3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        lifecycleStartStopEffectScope = new LifecycleStartStopEffectScope(obj2.getLifecycle());
                        composer.updateRememberedValue(lifecycleStartStopEffectScope);
                    } else {
                        lifecycleStartStopEffectScope = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LifecycleEffectKt.LifecycleStartEffectImpl(obj2, (LifecycleStartStopEffectScope)lifecycleStartStopEffectScope, obj4, restartGroup, i10 |= skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i3 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LifecycleEffectKt$$ExternalSyntheticLambda10(key1, key2, obj2, obj4, i14, i7);
            endRestartGroup.updateScope(traceInProgress2);
        }
    }

    public static final void LifecycleStartEffect(Object key1, Object key2, Object key3, LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> effects, Composer $composer, int $changed, int i8) {
        int traceInProgress2;
        int $dirty2;
        Object $dirty;
        int i5;
        int i;
        int i3;
        Object obj;
        int changedInstance;
        int i4;
        int skipping;
        int localLifecycleOwner;
        boolean traceInProgress;
        int defaultsInvalid;
        int i2;
        int str;
        int rememberedValue;
        Object consume;
        String empty;
        Object lifecycleStartStopEffectScope;
        Lifecycle lifecycle;
        final Object obj2 = key1;
        final Object obj3 = key2;
        final Object obj4 = key3;
        final Object obj6 = effects;
        final int i14 = $changed;
        traceInProgress2 = 574812561;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LifecycleStartEffect)P(1,2,3,4)252@12163L122,255@12290L80:LifecycleEffect.kt#2vxrgp");
        $dirty2 = $changed;
        if (i8 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i14 & 6 == 0) {
                i5 = restartGroup.changedInstance(obj2) ? 4 : 2;
                $dirty2 |= i5;
            }
        }
        if (i8 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i14 & 48 == 0) {
                i = restartGroup.changedInstance(obj3) ? 32 : 16;
                $dirty2 |= i;
            }
        }
        if (i8 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i14 & 384 == 0) {
                i3 = restartGroup.changedInstance(obj4) ? 256 : 128;
                $dirty2 |= i3;
            }
        }
        if (i14 & 3072 == 0) {
            if (i8 & 8 == 0) {
                changedInstance = restartGroup.changedInstance(lifecycleOwner) ? 2048 : 1024;
            } else {
                obj = lifecycleOwner;
            }
            $dirty2 |= changedInstance;
        } else {
            obj = lifecycleOwner;
        }
        if (i8 & 16 != 0) {
            $dirty2 |= 24576;
        } else {
            if (i14 & 24576 == 0) {
                i4 = restartGroup.changedInstance(obj6) ? 16384 : 8192;
                $dirty2 |= i4;
            }
        }
        if ($dirty2 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "248@12018L7");
                if (i14 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i8 & 8 != 0) {
                            str = 6;
                            rememberedValue = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj = consume;
                            $dirty2 &= -7169;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:250)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1655900501, "CC(remember):LifecycleEffect.kt#9igjgp");
                Composer composer = restartGroup;
                str = 0;
                rememberedValue = composer.rememberedValue();
                consume = 0;
                if (i9 |= changed4 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        lifecycleStartStopEffectScope = new LifecycleStartStopEffectScope(obj.getLifecycle());
                        composer.updateRememberedValue(lifecycleStartStopEffectScope);
                    } else {
                        lifecycleStartStopEffectScope = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LifecycleEffectKt.LifecycleStartEffectImpl(obj, (LifecycleStartStopEffectScope)lifecycleStartStopEffectScope, obj6, restartGroup, i12 |= i18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i2 = $dirty2;
                $dirty = obj;
            } else {
                restartGroup.skipToGroupEnd();
                i2 = $dirty2;
                $dirty = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LifecycleEffectKt$$ExternalSyntheticLambda15(obj2, obj3, obj4, $dirty, obj6, i14, i8);
            endRestartGroup.updateScope(traceInProgress2);
        }
    }

    public static final void LifecycleStartEffect(Object[] keys, LifecycleOwner lifecycleOwner, Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> effects, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        Object[] lifecycle;
        int $dirty3;
        int $dirty;
        Object $dirty2;
        Object obj;
        int changedInstance;
        int i2;
        int i3;
        int i;
        int skipping;
        int localLifecycleOwner;
        boolean traceInProgress;
        int defaultsInvalid;
        int str;
        int i4;
        int invalid$iv;
        Object consume;
        int rememberedValue;
        int changed;
        Object empty;
        Object lifecycleStartStopEffectScope;
        Object[] obj17;
        final Object obj2 = keys;
        final Object obj4 = effects;
        final int i9 = $changed;
        traceInProgress2 = -1510305724;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LifecycleStartEffect)P(1,2)310@15140L91,311@15236L80:LifecycleEffect.kt#2vxrgp");
        if (i9 & 48 == 0) {
            if (i6 & 2 == 0) {
                changedInstance = restartGroup.changedInstance(lifecycleOwner) ? 32 : 16;
            } else {
                obj = lifecycleOwner;
            }
            $dirty3 |= changedInstance;
        } else {
            obj = lifecycleOwner;
        }
        if (i6 & 4 != 0) {
            $dirty3 |= 384;
        } else {
            if (i9 & 384 == 0) {
                i2 = restartGroup.changedInstance(obj4) ? 256 : 128;
                $dirty3 |= i2;
            }
        }
        restartGroup.startMovableGroup(295146869, Integer.valueOf(obj2.length));
        ComposerKt.sourceInformation(restartGroup, "306@14995L7");
        int i17 = 4;
        i4 = 0;
        i3 = restartGroup.changed(obj2.length) ? i17 : i4;
        $dirty3 |= i3;
        invalid$iv = i4;
        while (invalid$iv < obj2.length) {
            if (restartGroup.changedInstance(obj2[invalid$iv])) {
            } else {
            }
            rememberedValue = i4;
            $dirty |= rememberedValue;
            invalid$iv++;
            rememberedValue = i17;
        }
        restartGroup.endMovableGroup();
        if ($dirty & 14 == 0) {
            $dirty |= 2;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "");
                if (i9 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i6 & 2 != 0) {
                            str = 6;
                            invalid$iv = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj = consume;
                            $dirty &= -113;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i6 & 2 != 0) {
                            $dirty &= -113;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:308)");
                }
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread(obj2);
                spreadBuilder.add(obj);
                lifecycle = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
                int i14 = 0;
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -568225417, "CC(remember)P(1):Composables.kt#9igjgp");
                invalid$iv = 0;
                while (i4 < lifecycle.length) {
                    invalid$iv |= changed;
                    i4++;
                }
                i4 = restartGroup;
                consume = 0;
                rememberedValue = i4.rememberedValue();
                changed = 0;
                if (invalid$iv == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj17 = lifecycle;
                        lifecycleStartStopEffectScope = new LifecycleStartStopEffectScope(obj.getLifecycle());
                        i4.updateRememberedValue(lifecycleStartStopEffectScope);
                    } else {
                        obj17 = lifecycle;
                        lifecycleStartStopEffectScope = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LifecycleEffectKt.LifecycleStartEffectImpl(obj, (LifecycleStartStopEffectScope)lifecycleStartStopEffectScope, obj4, restartGroup, i7 |= i15);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = $dirty;
                $dirty2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                i = $dirty;
                $dirty2 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LifecycleEffectKt$$ExternalSyntheticLambda16(obj2, $dirty2, obj4, i9, i6);
            endRestartGroup.updateScope(traceInProgress2);
        }
    }

    private static final Unit LifecycleStartEffect$lambda$11(Object object, Object object2, Object object3, LifecycleOwner lifecycleOwner4, Function1 function15, int i6, int i7, Composer composer8, int i9) {
        LifecycleEffectKt.LifecycleStartEffect(object, object2, object3, lifecycleOwner4, function15, composer8, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final Unit LifecycleStartEffect$lambda$13(Object[] objectArr, LifecycleOwner lifecycleOwner2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        LifecycleEffectKt.LifecycleStartEffect(objectArr, lifecycleOwner2, function13, composer6, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    private static final Unit LifecycleStartEffect$lambda$14(LifecycleOwner lifecycleOwner, Function1 function12, int i3, int i4, Composer composer5, int i6) {
        LifecycleEffectKt.LifecycleStartEffect(lifecycleOwner, function12, composer5, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    private static final Unit LifecycleStartEffect$lambda$7(Object object, LifecycleOwner lifecycleOwner2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        LifecycleEffectKt.LifecycleStartEffect(object, lifecycleOwner2, function13, composer6, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    private static final Unit LifecycleStartEffect$lambda$9(Object object, Object object2, LifecycleOwner lifecycleOwner3, Function1 function14, int i5, int i6, Composer composer7, int i8) {
        LifecycleEffectKt.LifecycleStartEffect(object, object2, lifecycleOwner3, function14, composer7, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void LifecycleStartEffectImpl(LifecycleOwner lifecycleOwner, androidx.lifecycle.compose.LifecycleStartStopEffectScope scope, Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> effects, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i5;
        int i6;
        int i4;
        boolean skipping;
        boolean traceInProgress2;
        int i2;
        int i3;
        int rememberedValue;
        int i;
        Object empty;
        Object externalSyntheticLambda8;
        traceInProgress = 228371534;
        final Composer obj11 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj11, "C(LifecycleStartEffectImpl)P(1,2)341@16508L661,341@16468L701:LifecycleEffect.kt#2vxrgp");
        if ($changed & 6 == 0) {
            i5 = obj11.changedInstance(lifecycleOwner) ? 4 : 2;
            $dirty |= i5;
        }
        if ($changed & 48 == 0) {
            i6 = obj11.changedInstance(scope) ? 32 : 16;
            $dirty |= i6;
        }
        i3 = 256;
        if ($changed & 384 == 0) {
            i4 = obj11.changedInstance(effects) ? i3 : 128;
            $dirty |= i4;
        }
        if ($dirty & 147 == 146) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffectImpl (LifecycleEffect.kt:340)");
                }
                ComposerKt.sourceInformationMarkerStart(obj11, 421721059, "CC(remember):LifecycleEffect.kt#9igjgp");
                i2 = $dirty & 896 == i3 ? 1 : 0;
                Composer composer = obj11;
                i3 = 0;
                rememberedValue = composer.rememberedValue();
                i = 0;
                if (i8 |= changedInstance3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        externalSyntheticLambda8 = new LifecycleEffectKt$$ExternalSyntheticLambda8(lifecycleOwner, scope, effects);
                        composer.updateRememberedValue(externalSyntheticLambda8);
                    } else {
                        externalSyntheticLambda8 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                EffectsKt.DisposableEffect(lifecycleOwner, scope, (Function1)externalSyntheticLambda8, obj11, i10 |= skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new LifecycleEffectKt$$ExternalSyntheticLambda9(lifecycleOwner, scope, effects, $changed);
            endRestartGroup.updateScope(skipping);
        }
    }

    private static final DisposableEffectResult LifecycleStartEffectImpl$lambda$19$lambda$18(LifecycleOwner $lifecycleOwner, androidx.lifecycle.compose.LifecycleStartStopEffectScope $scope, Function1 $effects, DisposableEffectScope $this$DisposableEffect) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LifecycleEffectKt$$ExternalSyntheticLambda5 externalSyntheticLambda5 = new LifecycleEffectKt$$ExternalSyntheticLambda5($scope, objectRef, $effects);
        $lifecycleOwner.getLifecycle().addObserver((LifecycleObserver)externalSyntheticLambda5);
        Object obj = $this$DisposableEffect;
        int i = 0;
        LifecycleEffectKt.LifecycleStartEffectImpl.lambda.19.lambda.18$$inlined.onDispose.1 anon = new LifecycleEffectKt.LifecycleStartEffectImpl.lambda.19.lambda.18$$inlined.onDispose.1($lifecycleOwner, externalSyntheticLambda5, objectRef);
        return (DisposableEffectResult)anon;
    }

    private static final void LifecycleStartEffectImpl$lambda$19$lambda$18$lambda$16(androidx.lifecycle.compose.LifecycleStartStopEffectScope $scope, Ref.ObjectRef $effectResult, Function1 $effects, LifecycleOwner lifecycleOwner4, Lifecycle.Event event) {
        int ordinal;
        Object invoke;
        int obj5;
        switch (obj5) {
            case 1:
                ordinal = 0;
                $effectResult.element = $effects.invoke($scope);
                break;
            case 2:
                obj5 = $effectResult.element;
                (LifecycleStopOrDisposeEffectResult)obj5.runStopOrDisposeEffect();
                $effectResult.element = 0;
                break;
            default:
        }
    }

    private static final Unit LifecycleStartEffectImpl$lambda$20(LifecycleOwner lifecycleOwner, androidx.lifecycle.compose.LifecycleStartStopEffectScope lifecycleStartStopEffectScope2, Function1 function13, int i4, Composer composer5, int i6) {
        LifecycleEffectKt.LifecycleStartEffectImpl(lifecycleOwner, lifecycleStartStopEffectScope2, function13, composer5, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }
}
