package androidx.compose.material3;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.material3.internal.BasicTooltip_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0008\u001a^\u0010\t\u001a\u00020\u00012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0008\r¢\u0006\u0002\u0008\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015", d2 = {"HandleInteractions", "", "enabled", "", "state", "Landroidx/compose/material3/TooltipState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "Label", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "isPersistent", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LabelKt {
    private static final void HandleInteractions(boolean enabled, androidx.compose.material3.TooltipState state, MutableInteractionSource interactionSource, Composer $composer, int $changed) {
        int i;
        int traceInProgress2;
        int $dirty;
        int i4;
        boolean changedInstance2;
        int i5;
        int i3;
        int traceInProgress;
        int i2;
        int changedInstance;
        int rememberedValue;
        int str;
        Object empty;
        Object anon;
        int i6;
        traceInProgress2 = -627258109;
        final Composer obj12 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj12, "C(HandleInteractions)P(!1,2)110@4384L587,110@4350L621:Label.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i4 = obj12.changed(enabled) ? 4 : 2;
            $dirty |= i4;
        }
        changedInstance = 32;
        if ($changed & 48 == 0) {
            if ($changed & 64 == 0) {
                changedInstance2 = obj12.changed(state);
            } else {
                changedInstance2 = obj12.changedInstance(state);
            }
            i5 = changedInstance2 ? changedInstance : 16;
            $dirty |= i5;
        }
        rememberedValue = 256;
        if ($changed & 384 == 0) {
            i3 = obj12.changed(interactionSource) ? rememberedValue : 128;
            $dirty |= i3;
        }
        if ($dirty & 147 == 146) {
            if (!obj12.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
                }
                if (enabled) {
                    ComposerKt.sourceInformationMarkerStart(obj12, 354570583, "CC(remember):Label.kt#9igjgp");
                    int i13 = 0;
                    i = $dirty & 896 == rememberedValue ? i2 : i13;
                    if ($dirty & 112 != changedInstance) {
                        if ($dirty & 64 != 0 && obj12.changedInstance(state)) {
                            if (obj12.changedInstance(state)) {
                            } else {
                                i2 = i13;
                            }
                        } else {
                        }
                    }
                    traceInProgress = obj12;
                    changedInstance = 0;
                    rememberedValue = traceInProgress.rememberedValue();
                    str = 0;
                    if (i |= i2 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon = new LabelKt.HandleInteractions.1.1(interactionSource, state, 0);
                            traceInProgress.updateRememberedValue((Function2)anon);
                        } else {
                            anon = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj12);
                    EffectsKt.LaunchedEffect(interactionSource, (Function2)anon, obj12, i10 &= 14);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj12.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj12.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new LabelKt.HandleInteractions.2(enabled, state, interactionSource, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void Label(Function3<? super androidx.compose.material3.TooltipScope, ? super Composer, ? super Integer, Unit> label, Modifier modifier, MutableInteractionSource interactionSource, boolean isPersistent, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        androidx.compose.material3.TooltipScopeImpl invalid$iv;
        int $dirty3;
        Object $dirty4;
        Object $dirty2;
        int i7;
        Object mutableStateOf$default;
        int i11;
        Object obj;
        Object modifier3;
        int i6;
        boolean z2;
        Object rememberBasicTooltipState;
        Object obj5;
        boolean traceInProgress;
        int i10;
        int i;
        int str;
        int i5;
        Object obj4;
        Composer modifier2;
        int i13;
        int rememberedValue2;
        Composer composer;
        int empty;
        boolean i9;
        int i14;
        Object tooltipScopeImpl;
        int i12;
        int i2;
        androidx.compose.runtime.internal.ComposableLambda interactionSource2;
        Object obj3;
        Composer i4;
        Object rememberedValue;
        androidx.compose.material3.LabelKt.Label.scope.1.1 anon;
        int positionProvider;
        int i3;
        Object obj2;
        boolean z;
        int $dirty;
        Object obj6;
        int obj24;
        final Object obj7 = label;
        final Object obj9 = content;
        final int i27 = $changed;
        invalid$iv = -544399326;
        modifier2 = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(modifier2, "C(Label)P(3,4,1,2)74@3254L38,79@3493L33,80@3543L52,82@3646L103,88@3835L17,86@3755L249,95@4009L127:Label.kt#uh7d8r");
        $dirty3 = $changed;
        if (i8 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i27 & 6 == 0) {
                i11 = modifier2.changedInstance(obj7) ? 4 : 2;
                $dirty3 |= i11;
            }
        }
        int i20 = i8 & 2;
        if (i20 != 0) {
            $dirty3 |= 48;
            obj5 = modifier;
        } else {
            if (i27 & 48 == 0) {
                i = modifier2.changed(modifier) ? 32 : 16;
                $dirty3 |= i;
            } else {
                obj5 = modifier;
            }
        }
        str = i8 & 4;
        if (str != null) {
            $dirty3 |= 384;
            obj4 = interactionSource;
        } else {
            if (i27 & 384 == 0) {
                i13 = modifier2.changed(interactionSource) ? 256 : 128;
                $dirty3 |= i13;
            } else {
                obj4 = interactionSource;
            }
        }
        rememberedValue2 = i8 & 8;
        if (rememberedValue2 != 0) {
            $dirty3 |= 3072;
            i9 = isPersistent;
        } else {
            if (i27 & 3072 == 0) {
                i12 = modifier2.changed(isPersistent) ? 2048 : 1024;
                $dirty3 |= i12;
            } else {
                i9 = isPersistent;
            }
        }
        if (i8 & 16 != 0) {
            $dirty3 |= 24576;
        } else {
            if (i27 & 24576 == 0) {
                i2 = modifier2.changedInstance(obj9) ? 16384 : 8192;
                $dirty3 |= i2;
            }
        }
        if ($dirty3 & 9363 == 9362) {
            if (!modifier2.getSkipping()) {
                if (i20 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = obj5;
                }
                obj2 = str != null ? obj5 : obj4;
                z = rememberedValue2 != 0 ? obj5 : i9;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, $dirty3, -1, "androidx.compose.material3.Label (Label.kt:70)");
                }
                modifier2.startReplaceGroup(519104973);
                ComposerKt.sourceInformation(modifier2, "72@3116L39");
                String str3 = "CC(remember):Label.kt#9igjgp";
                if (obj2 == null) {
                    ComposerKt.sourceInformationMarkerStart(modifier2, 519105624, str3);
                    traceInProgress = 0;
                    str = modifier2;
                    obj4 = 0;
                    rememberedValue2 = str.rememberedValue();
                    i9 = 0;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        int i45 = 0;
                        str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        obj3 = rememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(modifier2);
                } else {
                    obj3 = obj2;
                }
                modifier2.endReplaceGroup();
                i10 = 0;
                i5 = 0;
                if (z) {
                    modifier2.startReplaceGroup(-1087377900);
                    ComposerKt.sourceInformation(modifier2, "76@3335L29");
                    ComposerKt.sourceInformationMarkerStart(modifier2, 519112622, str3);
                    int i41 = 0;
                    composer = modifier2;
                    i14 = 0;
                    rememberedValue = composer.rememberedValue();
                    i3 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberBasicTooltipState = 0;
                        $dirty = $dirty3;
                        obj6 = modifier3;
                        $dirty2 = new LabelStateImpl(i10, i10, 3, i5);
                        composer.updateRememberedValue($dirty2);
                    } else {
                        $dirty = $dirty3;
                        obj6 = modifier3;
                        $dirty2 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(modifier2);
                    modifier2.endReplaceGroup();
                    obj4 = $dirty2;
                    i7 = i10;
                    i6 = i5;
                } else {
                    $dirty = $dirty3;
                    obj6 = modifier3;
                    modifier2.startReplaceGroup(519114025);
                    ComposerKt.sourceInformation(modifier2, "77@3378L56");
                    MutatorMutex mutatorMutex = new MutatorMutex();
                    i7 = i10;
                    i6 = i5;
                    modifier2.endReplaceGroup();
                    obj4 = rememberBasicTooltipState;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ComposerKt.sourceInformationMarkerStart(modifier2, 519117682, str3);
                int i31 = 0;
                Composer composer3 = modifier2;
                int i42 = 0;
                Object rememberedValue4 = composer3.rememberedValue();
                anon = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj24 = i18;
                    composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(i6, i6, 2, i6));
                } else {
                    mutableStateOf$default = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd(modifier2);
                objectRef.element = (MutableState)mutableStateOf$default;
                ComposerKt.sourceInformationMarkerStart(modifier2, 519119301, str3);
                int i16 = 0;
                Composer composer2 = modifier2;
                int i21 = 0;
                Object rememberedValue3 = composer2.rememberedValue();
                int i35 = 0;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = new LabelKt.Label.scope.1.1(objectRef);
                    tooltipScopeImpl = new TooltipScopeImpl((Function0)anon);
                    composer2.updateRememberedValue(tooltipScopeImpl);
                } else {
                    tooltipScopeImpl = rememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd(modifier2);
                LabelKt.Label.wrappedContent.1 anon2 = new LabelKt.Label.wrappedContent.1(objectRef, obj9);
                int i32 = 54;
                int i36 = 1;
                LabelKt.Label.1 anon3 = new LabelKt.Label.1(obj7, (TooltipScopeImpl)tooltipScopeImpl);
                i4 = modifier2;
                BasicTooltip_androidKt.BasicTooltipBox(TooltipDefaults.INSTANCE.rememberPlainTooltipPositionProvider-kHDZbjc(0, modifier2, 48, 1), (Function2)ComposableLambdaKt.rememberComposableLambda(784196780, i36, anon3, modifier2, i32), obj4, obj6, false, false, (Function2)ComposableLambdaKt.rememberComposableLambda(1950723216, i36, anon2, modifier2, i32), i4, i24 |= i33, 0);
                LabelKt.HandleInteractions(z ^ 1, obj4, obj3, i4, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj2;
                z2 = z;
                $dirty4 = obj6;
            } else {
                modifier2.skipToGroupEnd();
                $dirty = $dirty3;
                $dirty4 = obj5;
                obj = obj4;
                z2 = i9;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = modifier2.endRestartGroup();
        if (endRestartGroup != null) {
            invalid$iv = new LabelKt.Label.2(obj7, $dirty4, obj, z2, obj9, i27, i8);
            endRestartGroup.updateScope((Function2)invalid$iv);
        }
    }

    public static final void access$HandleInteractions(boolean enabled, androidx.compose.material3.TooltipState state, MutableInteractionSource interactionSource, Composer $composer, int $changed) {
        LabelKt.HandleInteractions(enabled, state, interactionSource, $composer, $changed);
    }
}
