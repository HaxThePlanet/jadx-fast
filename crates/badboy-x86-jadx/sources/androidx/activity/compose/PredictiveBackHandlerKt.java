package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u001aZ\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032A\u0010\u0004\u001a=\u0008\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\u0008\u00080\u000c\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006E\u0010\u0010\u001a=\u0008\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\u0008\u00080\u000c\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u008a\u0084\u0002", d2 = {"PredictiveBackHandler", "", "enabled", "", "onBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PredictiveBackHandlerKt {
    public static final void PredictiveBackHandler(boolean enabled, Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> onBack, Composer $composer, int $changed, int i5) {
        int invalid$iv;
        Object currentOnBack$delegate;
        int $dirty;
        Object $dirty2;
        boolean enabled2;
        Object this_$iv;
        kotlinx.coroutines.CoroutineScope onBackScope;
        boolean traceInProgress2;
        boolean traceInProgress;
        int empty;
        int i;
        int i4;
        boolean skipping;
        int i2;
        Object rememberedValue;
        int i3;
        int i6;
        Object rememberedValue3;
        int empty2;
        Object anon;
        Object predictiveBackHandlerCallback;
        Object rememberedValue2;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        State currentOnBack$delegate2;
        int obj20;
        final Object obj = onBack;
        final int i7 = $changed;
        int i8 = i5;
        invalid$iv = -642000585;
        Composer restartGroup = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(PredictiveBackHandler)78@3130L28,79@3181L24,81@3230L91,86@3419L142,91@3591L38,91@3567L62,*94@3711L7,100@4006L7,102@4068L117,102@4019L166:PredictiveBackHandler.kt#q1dkbc");
        $dirty = $changed;
        int i14 = i8 & 1;
        if (i14 != 0) {
            $dirty |= 6;
            traceInProgress2 = enabled;
        } else {
            if (i7 & 6 == 0) {
                i = restartGroup.changed(enabled) ? 4 : 2;
                $dirty |= i;
            } else {
                traceInProgress2 = enabled;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i7 & 48 == 0) {
                i4 = restartGroup.changedInstance(obj) ? 32 : 16;
                $dirty |= i4;
            }
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                enabled2 = i14 != 0 ? 1 : traceInProgress2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, $dirty, -1, "androidx.activity.compose.PredictiveBackHandler (PredictiveBackHandler.kt:76)");
                }
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(obj, restartGroup, i10 &= 14);
                int i22 = i18;
                int i26 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
                int i37 = 0;
                Composer composer5 = restartGroup;
                int i42 = 0;
                rememberedValue2 = composer5.rememberedValue();
                int i45 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    int i46 = 0;
                    currentOnBack$delegate2 = rememberUpdatedState;
                    currentOnBack$delegate = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    composer5.updateRememberedValue(currentOnBack$delegate);
                } else {
                    currentOnBack$delegate2 = rememberUpdatedState;
                    currentOnBack$delegate = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                onBackScope = (CompositionScopedCoroutineScopeCanceller)currentOnBack$delegate.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                String str3 = "CC(remember):PredictiveBackHandler.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1140798889, str3);
                int i13 = 0;
                Composer composer = restartGroup;
                int i27 = 0;
                Object rememberedValue4 = composer.rememberedValue();
                int i38 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    predictiveBackHandlerCallback = new PredictiveBackHandlerCallback(enabled2, onBackScope, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(currentOnBack$delegate2));
                    composer.updateRememberedValue(predictiveBackHandlerCallback);
                } else {
                    predictiveBackHandlerCallback = rememberedValue4;
                }
                invalid$iv = predictiveBackHandlerCallback;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1140804988, str3);
                Composer composer2 = restartGroup;
                int i33 = 0;
                int i41 = 0;
                if (changed2 |= changed3 == 0) {
                    if (composer2.rememberedValue() == Composer.Companion.getEmpty()) {
                        int i43 = 0;
                        (PredictiveBackHandlerCallback)invalid$iv.setCurrentOnBack(PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(currentOnBack$delegate2));
                        invalid$iv.setOnBackScope(onBackScope);
                        composer2.updateRememberedValue(Unit.INSTANCE);
                    } else {
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1140810388, str3);
                i3 = $dirty & 14 == 4 ? 1 : 0;
                Composer composer4 = restartGroup;
                int i40 = 0;
                rememberedValue3 = composer4.rememberedValue();
                int i44 = 0;
                if (changedInstance5 |= i3 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = 0;
                        obj20 = $dirty;
                        coroutineScope = onBackScope;
                        $dirty2 = new PredictiveBackHandlerKt.PredictiveBackHandler.2.1(invalid$iv, enabled2, 0);
                        composer4.updateRememberedValue((Function2)$dirty2);
                    } else {
                        obj20 = $dirty;
                        coroutineScope = onBackScope;
                        $dirty2 = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(Boolean.valueOf(enabled2), (Function2)$dirty2, restartGroup, obj20 & 14);
                OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(restartGroup, 6);
                if (current == null) {
                } else {
                    $dirty = current.getOnBackPressedDispatcher();
                    int i24 = 0;
                    int i31 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    this_$iv = consume;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1140825731, str3);
                    skipping = restartGroup;
                    i2 = 0;
                    rememberedValue = skipping.rememberedValue();
                    i6 = 0;
                    if (i19 |= changedInstance3 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue3 = 0;
                            anon = new PredictiveBackHandlerKt.PredictiveBackHandler.3.1($dirty, this_$iv, invalid$iv);
                            skipping.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.DisposableEffect(this_$iv, $dirty, (Function1)anon, restartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        $dirty = new PredictiveBackHandlerKt.PredictiveBackHandler.4(enabled2, obj, i7, i8);
                        endRestartGroup.updateScope((Function2)$dirty);
                    }
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj20 = $dirty;
                enabled2 = traceInProgress2;
            }
        } else {
        }
        int i9 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
        throw illegalStateException;
    }

    private static final Function2<Flow<BackEventCompat>, Continuation<Unit>, Object> PredictiveBackHandler$lambda$0(State<? extends Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object>> $currentOnBack$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function2)$currentOnBack$delegate.getValue();
    }
}
