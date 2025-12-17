package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOrigin.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.DpOffset.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JU\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\u0008\u0010¢\u0006\u0002\u0008\u0011H\u0007¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\n*\u00020\n2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0006H&¨\u0006\u0015", d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "()V", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {

    public static final int $stable;
    static {
    }

    public static Modifier exposedDropdownSize$default(androidx.compose.material.ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            final int obj4 = 1;
            if (i4 &= obj4 != 0) {
                obj2 = obj4;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        throw obj0;
    }

    public final void ExposedDropdownMenu(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        int i2;
        boolean booleanValue;
        Object invalid$iv;
        int traceInProgress;
        int $dirty;
        boolean traceInProgress2;
        int i6;
        Object obj8;
        Boolean valueOf;
        Object $composer2;
        int i7;
        Object modifier2;
        int composer2;
        int $i$f$cache;
        Object obj4;
        Object rememberScrollState;
        Object empty3;
        boolean z;
        int i9;
        Object obj5;
        int i5;
        int changed;
        Object obj7;
        Composer composer;
        int i4;
        int i;
        int rememberedValue;
        int defaultsInvalid;
        Object anon;
        Object empty;
        int i3;
        Object mutableTransitionState;
        Object empty2;
        Object obj2;
        Object obj3;
        Object obj;
        Object companion2;
        Composer.Companion companion;
        androidx.compose.material.DropdownMenuPositionProvider dropdownMenuPositionProvider;
        long center-SzJe1aQ;
        Object obj6;
        Object obj9;
        int i10;
        int obj28;
        int obj29;
        int obj31;
        final int i32 = $changed;
        traceInProgress = 63962088;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ExposedDropdownMenu)P(1,3,2,4)235@9118L21,247@9618L42:ExposedDropdownMenu.android.kt#jmzs0o");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
            z = expanded;
        } else {
            if (i32 & 6 == 0) {
                i6 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty |= i6;
            } else {
                z = expanded;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
            obj8 = onDismissRequest;
        } else {
            if (i32 & 48 == 0) {
                i7 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty |= i7;
            } else {
                obj8 = onDismissRequest;
            }
        }
        int i28 = i8 & 4;
        if (i28 != 0) {
            $dirty |= 384;
            rememberScrollState = modifier;
        } else {
            if (i32 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i9;
            } else {
                rememberScrollState = modifier;
            }
        }
        if (i32 & 3072 == 0) {
            if (i8 & 8 == 0) {
                changed = restartGroup.changed(scrollState) ? 2048 : 1024;
            } else {
                obj5 = scrollState;
            }
            $dirty |= changed;
        } else {
            obj5 = scrollState;
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
            obj7 = content;
        } else {
            if (i32 & 24576 == 0) {
                i4 = restartGroup.changedInstance(content) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                obj7 = content;
            }
        }
        int i39 = 196608;
        if (i8 & 32 != 0) {
            $dirty |= i39;
            obj3 = this;
        } else {
            if (i32 & i39 == 0) {
                i = restartGroup.changed(this) ? 131072 : 65536;
                $dirty |= i;
            } else {
                obj3 = this;
            }
        }
        if (i37 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i40 = 0;
                if (i32 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i28 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = rememberScrollState;
                        }
                        if (i8 & 8 != 0) {
                            i5 = $dirty;
                            obj = modifier2;
                            obj2 = rememberScrollState;
                        } else {
                            obj = modifier2;
                            obj2 = obj5;
                            i5 = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        obj = rememberScrollState;
                        obj2 = obj5;
                        i5 = $dirty;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i5, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:237)");
                }
                $dirty = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1129921793, $dirty);
                int i12 = 0;
                composer2 = restartGroup;
                rememberScrollState = 0;
                rememberedValue = composer2.rememberedValue();
                companion2 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    mutableTransitionState = new MutableTransitionState(Boolean.valueOf(i40));
                    composer2.updateRememberedValue(mutableTransitionState);
                } else {
                    mutableTransitionState = rememberedValue;
                }
                i3 = mutableTransitionState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                (MutableTransitionState)i3.setTargetState(Boolean.valueOf(z));
                if (!(Boolean)i3.getCurrentState().booleanValue()) {
                    if ((Boolean)i3.getTargetState().booleanValue()) {
                        restartGroup.startReplaceGroup(-667649880);
                        ComposerKt.sourceInformation(restartGroup, "251@9820L51,252@9911L7,256@10058L139,263@10366L336,260@10211L491");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1129915320, $dirty);
                        int i15 = 0;
                        Composer composer4 = restartGroup;
                        $i$f$cache = 0;
                        Object rememberedValue3 = composer4.rememberedValue();
                        int i38 = 0;
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty2 = 0;
                            obj28 = i15;
                            obj8 = 0;
                            obj29 = $i$f$cache;
                            composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), obj8, 2, obj8));
                        } else {
                            obj28 = i15;
                            obj29 = $i$f$cache;
                            invalid$iv = rememberedValue3;
                        }
                        mutableTransitionState = invalid$iv;
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        int i24 = 0;
                        int i26 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1129907616, $dirty);
                        int i17 = 0;
                        Composer composer3 = restartGroup;
                        int i25 = 0;
                        Object rememberedValue2 = composer3.rememberedValue();
                        int i30 = 0;
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty3 = 0;
                            anon = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.popupPositionProvider.1.1((MutableState)mutableTransitionState);
                            composer3.updateRememberedValue((Function2)anon);
                        } else {
                            anon = rememberedValue2;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        dropdownMenuPositionProvider = new DropdownMenuPositionProvider(DpOffset.Companion.getZero-RKDOV3M(), obj21, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()), (Function2)anon, 0);
                        rememberedValue = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.1(i3, mutableTransitionState, obj2, obj3, obj, obj7);
                        ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(onDismissRequest, (PopupPositionProvider)dropdownMenuPositionProvider, (Function2)ComposableLambdaKt.rememberComposableLambda(1001349006, true, rememberedValue, restartGroup, 54), restartGroup, i2 | 384, 0);
                        restartGroup.endReplaceGroup();
                    } else {
                        restartGroup.startReplaceGroup(-666753267);
                        restartGroup.endReplaceGroup();
                        composer = restartGroup;
                    }
                } else {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj2;
                $composer2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = rememberScrollState;
                obj4 = obj5;
                i5 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.2(this, z, onDismissRequest, $composer2, obj4, content, i32, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z2);
}
