package androidx.activity.compose;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\u0010\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002", d2 = {"BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackHandlerKt {
    public static final void BackHandler(boolean enabled, Function0<Unit> onBack, Composer $composer, int $changed, int i5) {
        int traceInProgress;
        Object currentOnBack$delegate;
        int $dirty;
        boolean enabled2;
        int onBackPressedDispatcher;
        int i3;
        boolean invalid$iv;
        boolean traceInProgress2;
        int i6;
        int i2;
        boolean skipping;
        int this_$iv;
        Composer composer;
        Object anon;
        int i4;
        Object rememberedValue;
        int i;
        int empty;
        Object empty2;
        State obj18;
        final Object obj = onBack;
        final int i7 = $changed;
        int i8 = i5;
        traceInProgress = -361453782;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(BackHandler)83@3466L28,85@3596L171,93@3868L36,93@3857L47,*95@3985L7,100@4279L7,101@4340L233,101@4291L282:BackHandler.kt#q1dkbc");
        $dirty = $changed;
        int i12 = i8 & 1;
        onBackPressedDispatcher = 4;
        if (i12 != 0) {
            $dirty |= 6;
            invalid$iv = enabled;
        } else {
            if (i7 & 6 == 0) {
                i6 = restartGroup.changed(enabled) ? onBackPressedDispatcher : 2;
                $dirty |= i6;
            } else {
                invalid$iv = enabled;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i7 & 48 == 0) {
                i2 = restartGroup.changedInstance(obj) ? 32 : 16;
                $dirty |= i2;
            }
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                enabled2 = i12 != 0 ? 1 : invalid$iv;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.activity.compose.BackHandler (BackHandler.kt:81)");
                }
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(obj, restartGroup, i10 &= 14);
                String str3 = "CC(remember):BackHandler.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -41177256, str3);
                int i16 = 0;
                Composer composer2 = restartGroup;
                int i21 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i26 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    empty2 = new BackHandlerKt.BackHandler.backCallback.1.1(enabled2, rememberUpdatedState);
                    composer2.updateRememberedValue(empty2);
                } else {
                    empty2 = rememberedValue2;
                }
                invalid$iv = empty2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -41168687, str3);
                i3 = $dirty & 14 == onBackPressedDispatcher ? 1 : 0;
                Composer composer3 = restartGroup;
                int i24 = 0;
                Object rememberedValue3 = composer3.rememberedValue();
                int i28 = 0;
                if (i3 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        anon = new BackHandlerKt.BackHandler.1.1((BackHandlerKt.BackHandler.backCallback.1.1)invalid$iv, enabled2);
                        composer3.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)anon, restartGroup, 0);
                OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(restartGroup, 6);
                if (current == null) {
                } else {
                    onBackPressedDispatcher = current.getOnBackPressedDispatcher();
                    int i22 = 0;
                    int i25 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    this_$iv = consume;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -41153386, str3);
                    composer = restartGroup;
                    i4 = 0;
                    rememberedValue = composer.rememberedValue();
                    i = 0;
                    if (changedInstance |= changedInstance3 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty2 = 0;
                            obj18 = rememberUpdatedState;
                            currentOnBack$delegate = new BackHandlerKt.BackHandler.2.1(onBackPressedDispatcher, this_$iv, invalid$iv);
                            composer.updateRememberedValue((Function1)currentOnBack$delegate);
                        } else {
                            obj18 = rememberUpdatedState;
                            currentOnBack$delegate = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.DisposableEffect(this_$iv, onBackPressedDispatcher, (Function1)currentOnBack$delegate, restartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        onBackPressedDispatcher = new BackHandlerKt.BackHandler.3(enabled2, obj, i7, i8);
                        endRestartGroup.updateScope((Function2)onBackPressedDispatcher);
                    }
                }
            } else {
                restartGroup.skipToGroupEnd();
                enabled2 = invalid$iv;
            }
        } else {
        }
        obj18 = rememberUpdatedState;
        int i9 = 0;
        IllegalStateException $i$a$CheckNotNullBackHandlerKt$BackHandler$backDispatcher$1 = new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
        throw $i$a$CheckNotNullBackHandlerKt$BackHandler$backDispatcher$1;
    }

    private static final Function0<Unit> BackHandler$lambda$0(State<? extends Function0<Unit>> $currentOnBack$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function0)$currentOnBack$delegate.getValue();
    }

    public static final Function0 access$BackHandler$lambda$0(State $currentOnBack$delegate) {
        return BackHandlerKt.BackHandler$lambda$0($currentOnBack$delegate);
    }
}
