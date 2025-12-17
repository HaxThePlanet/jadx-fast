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
        int traceInProgress;
        int $dirty;
        int i3;
        boolean changedInstance2;
        int i4;
        int i2;
        int traceInProgress2;
        int i5;
        int changedInstance;
        int rememberedValue;
        int str;
        Object empty;
        Object anon;
        int i6;
        traceInProgress = -627258109;
        final Composer obj12 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj12, "C(HandleInteractions)P(!1,2)110@4384L587,110@4350L621:Label.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i3 = obj12.changed(enabled) ? 4 : 2;
            $dirty |= i3;
        }
        changedInstance = 32;
        if ($changed & 48 == 0) {
            if ($changed & 64 == 0) {
                changedInstance2 = obj12.changed(state);
            } else {
                changedInstance2 = obj12.changedInstance(state);
            }
            i4 = changedInstance2 ? changedInstance : 16;
            $dirty |= i4;
        }
        rememberedValue = 256;
        if ($changed & 384 == 0) {
            i2 = obj12.changed(interactionSource) ? rememberedValue : 128;
            $dirty |= i2;
        }
        if ($dirty & 147 == 146) {
            if (!obj12.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
                }
                if (enabled) {
                    ComposerKt.sourceInformationMarkerStart(obj12, 354570583, "CC(remember):Label.kt#9igjgp");
                    int i13 = 0;
                    i = $dirty & 896 == rememberedValue ? i5 : i13;
                    if ($dirty & 112 != changedInstance) {
                        if ($dirty & 64 != 0 && obj12.changedInstance(state)) {
                            if (obj12.changedInstance(state)) {
                            } else {
                                i5 = i13;
                            }
                        } else {
                        }
                    }
                    traceInProgress2 = obj12;
                    changedInstance = 0;
                    rememberedValue = traceInProgress2.rememberedValue();
                    str = 0;
                    if (i |= i5 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon = new LabelKt.HandleInteractions.1.1(interactionSource, state, 0);
                            traceInProgress2.updateRememberedValue((Function2)anon);
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
            traceInProgress2 = new LabelKt.HandleInteractions.2(enabled, state, interactionSource, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void Label(Function3<? super androidx.compose.material3.TooltipScope, ? super Composer, ? super Integer, Unit> label, Modifier modifier, MutableInteractionSource interactionSource, boolean isPersistent, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        androidx.compose.material3.TooltipScopeImpl invalid$iv;
        int $dirty4;
        Object $dirty2;
        Object $dirty3;
        int i11;
        Object mutableStateOf$default;
        int i6;
        Object obj2;
        Object modifier2;
        int i7;
        boolean z;
        Object rememberBasicTooltipState;
        Object obj4;
        boolean traceInProgress;
        int i4;
        int i12;
        int str;
        int i;
        Object obj;
        Composer modifier3;
        int i3;
        int rememberedValue;
        Composer composer;
        int empty;
        boolean i10;
        int i5;
        Object tooltipScopeImpl;
        int i2;
        int i13;
        androidx.compose.runtime.internal.ComposableLambda interactionSource2;
        Object $i$a$CacheLabelKt$Label$interactionSource$1;
        Composer i9;
        Object rememberedValue2;
        androidx.compose.material3.LabelKt.Label.scope.1.1 anon;
        int positionProvider;
        int i14;
        Object obj5;
        boolean z2;
        int $dirty;
        Object obj3;
        int obj24;
        final Object obj6 = label;
        final Object obj8 = content;
        final int i26 = $changed;
        invalid$iv = -544399326;
        modifier3 = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(modifier3, "C(Label)P(3,4,1,2)74@3254L38,79@3493L33,80@3543L52,82@3646L103,88@3835L17,86@3755L249,95@4009L127:Label.kt#uh7d8r");
        $dirty4 = $changed;
        if (i8 & 1 != 0) {
            $dirty4 |= 6;
        } else {
            if (i26 & 6 == 0) {
                i6 = modifier3.changedInstance(obj6) ? 4 : 2;
                $dirty4 |= i6;
            }
        }
        int i19 = i8 & 2;
        if (i19 != 0) {
            $dirty4 |= 48;
            obj4 = modifier;
        } else {
            if (i26 & 48 == 0) {
                i12 = modifier3.changed(modifier) ? 32 : 16;
                $dirty4 |= i12;
            } else {
                obj4 = modifier;
            }
        }
        str = i8 & 4;
        if (str != null) {
            $dirty4 |= 384;
            obj = interactionSource;
        } else {
            if (i26 & 384 == 0) {
                i3 = modifier3.changed(interactionSource) ? 256 : 128;
                $dirty4 |= i3;
            } else {
                obj = interactionSource;
            }
        }
        rememberedValue = i8 & 8;
        if (rememberedValue != 0) {
            $dirty4 |= 3072;
            i10 = isPersistent;
        } else {
            if (i26 & 3072 == 0) {
                i2 = modifier3.changed(isPersistent) ? 2048 : 1024;
                $dirty4 |= i2;
            } else {
                i10 = isPersistent;
            }
        }
        if (i8 & 16 != 0) {
            $dirty4 |= 24576;
        } else {
            if (i26 & 24576 == 0) {
                i13 = modifier3.changedInstance(obj8) ? 16384 : 8192;
                $dirty4 |= i13;
            }
        }
        if ($dirty4 & 9363 == 9362) {
            if (!modifier3.getSkipping()) {
                if (i19 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj4;
                }
                obj5 = str != null ? obj4 : obj;
                z2 = rememberedValue != 0 ? obj4 : i10;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, $dirty4, -1, "androidx.compose.material3.Label (Label.kt:70)");
                }
                modifier3.startReplaceGroup(519104973);
                ComposerKt.sourceInformation(modifier3, "72@3116L39");
                String str3 = "CC(remember):Label.kt#9igjgp";
                if (obj5 == null) {
                    ComposerKt.sourceInformationMarkerStart(modifier3, 519105624, str3);
                    traceInProgress = 0;
                    str = modifier3;
                    obj = 0;
                    rememberedValue = str.rememberedValue();
                    i10 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i44 = 0;
                        str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheLabelKt$Label$interactionSource$1 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(modifier3);
                } else {
                    $i$a$CacheLabelKt$Label$interactionSource$1 = obj5;
                }
                modifier3.endReplaceGroup();
                i4 = 0;
                i = 0;
                if (z2) {
                    modifier3.startReplaceGroup(-1087377900);
                    ComposerKt.sourceInformation(modifier3, "76@3335L29");
                    ComposerKt.sourceInformationMarkerStart(modifier3, 519112622, str3);
                    int i40 = 0;
                    composer = modifier3;
                    i5 = 0;
                    rememberedValue2 = composer.rememberedValue();
                    i14 = 0;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberBasicTooltipState = 0;
                        $dirty = $dirty4;
                        obj3 = modifier2;
                        $dirty3 = new LabelStateImpl(i4, i4, 3, i);
                        composer.updateRememberedValue($dirty3);
                    } else {
                        $dirty = $dirty4;
                        obj3 = modifier2;
                        $dirty3 = rememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(modifier3);
                    modifier3.endReplaceGroup();
                    obj = $dirty3;
                    i11 = i4;
                    i7 = i;
                } else {
                    $dirty = $dirty4;
                    obj3 = modifier2;
                    modifier3.startReplaceGroup(519114025);
                    ComposerKt.sourceInformation(modifier3, "77@3378L56");
                    MutatorMutex mutatorMutex = new MutatorMutex();
                    i11 = i4;
                    i7 = i;
                    modifier3.endReplaceGroup();
                    obj = rememberBasicTooltipState;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ComposerKt.sourceInformationMarkerStart(modifier3, 519117682, str3);
                int i30 = 0;
                Composer composer3 = modifier3;
                int i41 = 0;
                Object rememberedValue4 = composer3.rememberedValue();
                anon = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj24 = i18;
                    composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(i7, i7, 2, i7));
                } else {
                    mutableStateOf$default = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd(modifier3);
                objectRef.element = (MutableState)mutableStateOf$default;
                ComposerKt.sourceInformationMarkerStart(modifier3, 519119301, str3);
                int i16 = 0;
                Composer composer2 = modifier3;
                int i20 = 0;
                Object rememberedValue3 = composer2.rememberedValue();
                int i34 = 0;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = new LabelKt.Label.scope.1.1(objectRef);
                    tooltipScopeImpl = new TooltipScopeImpl((Function0)anon);
                    composer2.updateRememberedValue(tooltipScopeImpl);
                } else {
                    tooltipScopeImpl = rememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd(modifier3);
                LabelKt.Label.wrappedContent.1 anon2 = new LabelKt.Label.wrappedContent.1(objectRef, obj8);
                int i31 = 54;
                int i35 = 1;
                LabelKt.Label.1 anon3 = new LabelKt.Label.1(obj6, (TooltipScopeImpl)tooltipScopeImpl);
                i9 = modifier3;
                BasicTooltip_androidKt.BasicTooltipBox(TooltipDefaults.INSTANCE.rememberPlainTooltipPositionProvider-kHDZbjc(0, modifier3, 48, 1), (Function2)ComposableLambdaKt.rememberComposableLambda(784196780, i35, anon3, modifier3, i31), obj, obj3, false, false, (Function2)ComposableLambdaKt.rememberComposableLambda(1950723216, i35, anon2, modifier3, i31), i9, i23 |= i32, 0);
                LabelKt.HandleInteractions(z2 ^ 1, obj, $i$a$CacheLabelKt$Label$interactionSource$1, i9, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj5;
                z = z2;
                $dirty2 = obj3;
            } else {
                modifier3.skipToGroupEnd();
                $dirty = $dirty4;
                $dirty2 = obj4;
                obj2 = obj;
                z = i10;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = modifier3.endRestartGroup();
        if (endRestartGroup != null) {
            invalid$iv = new LabelKt.Label.2(obj6, $dirty2, obj2, z, obj8, i26, i8);
            endRestartGroup.updateScope((Function2)invalid$iv);
        }
    }

    public static final void access$HandleInteractions(boolean enabled, androidx.compose.material3.TooltipState state, MutableInteractionSource interactionSource, Composer $composer, int $changed) {
        LabelKt.HandleInteractions(enabled, state, interactionSource, $composer, $changed);
    }
}
