package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\u0081\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0014\u0008\u0002\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\u0008\u0011¢\u0006\u0002\u0008\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\u0008\u0011¢\u0006\u0002\u0008\u0012H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002\u001a-\u0010\u0019\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00172\u0014\u0008\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\rH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001e", d2 = {"DISMISS_THRESHOLD", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismiss", "", "state", "Landroidx/compose/material/DismissState;", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material/DismissDirection;", "dismissThresholds", "Lkotlin/Function1;", "Landroidx/compose/material/ThresholdConfig;", "background", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getDismissDirection", "from", "Landroidx/compose/material/DismissValue;", "to", "rememberDismissState", "initialValue", "confirmStateChange", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissKt {

    private static final float DISMISS_THRESHOLD;
    static {
        final int i2 = 0;
        SwipeToDismissKt.DISMISS_THRESHOLD = Dp.constructor-impl((float)i);
    }

    public static final void SwipeToDismiss(androidx.compose.material.DismissState state, Modifier modifier, Set<? extends androidx.compose.material.DismissDirection> directions, Function1<? super androidx.compose.material.DismissDirection, ? extends androidx.compose.material.ThresholdConfig> dismissThresholds, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> background, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> dismissContent, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        int $dirty;
        Object obj3;
        Object obj11;
        Object obj4;
        Set iNSTANCE;
        boolean traceInProgress2;
        int i7;
        Object obj2;
        Object modifier2;
        Object obj6;
        int i8;
        int startToEnd;
        Object obj10;
        int i3;
        int i5;
        Object obj;
        int $dirty2;
        int i2;
        Object obj7;
        int i;
        Object obj5;
        int i4;
        boolean skipping;
        Object set;
        int i6;
        Object obj8;
        Object obj9;
        Function3 function3;
        final int i19 = $changed;
        traceInProgress = 634380143;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SwipeToDismiss)P(5,4,1,3)183@6698L1378,183@6669L1407:SwipeToDismiss.kt#jmzs0o");
        $dirty = $changed;
        iNSTANCE = 2;
        if (i9 & 1 != 0) {
            $dirty |= 6;
            obj3 = state;
        } else {
            if (i19 & 6 == 0) {
                i7 = restartGroup.changed(state) ? 4 : iNSTANCE;
                $dirty |= i7;
            } else {
                obj3 = state;
            }
        }
        int i16 = i9 & 2;
        if (i16 != 0) {
            $dirty |= 48;
            obj6 = modifier;
        } else {
            if (i19 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i8;
            } else {
                obj6 = modifier;
            }
        }
        startToEnd = i9 & 4;
        if (startToEnd != 0) {
            $dirty |= 384;
            obj10 = directions;
        } else {
            if (i19 & 384 == 0) {
                i3 = restartGroup.changedInstance(directions) ? 256 : 128;
                $dirty |= i3;
            } else {
                obj10 = directions;
            }
        }
        i5 = i9 & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            obj = dismissThresholds;
        } else {
            if (i19 & 3072 == 0) {
                i2 = restartGroup.changedInstance(dismissThresholds) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                obj = dismissThresholds;
            }
        }
        if (i9 & 16 != 0) {
            $dirty |= 24576;
            obj7 = background;
        } else {
            if (i19 & 24576 == 0) {
                i = restartGroup.changedInstance(background) ? 16384 : 8192;
                $dirty |= i;
            } else {
                obj7 = background;
            }
        }
        i4 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i4;
            obj5 = dismissContent;
        } else {
            if (i19 & i4 == 0) {
                i4 = restartGroup.changedInstance(dismissContent) ? 131072 : 65536;
                $dirty |= i4;
            } else {
                obj5 = dismissContent;
            }
        }
        if (i26 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj6;
                }
                obj6 = 1;
                if (startToEnd != 0) {
                    androidx.compose.material.DismissDirection[] arr = new DismissDirection[iNSTANCE];
                    arr[0] = DismissDirection.EndToStart;
                    arr[obj6] = DismissDirection.StartToEnd;
                    set = iNSTANCE;
                } else {
                    set = obj10;
                }
                if (i5 != 0) {
                    i6 = iNSTANCE;
                } else {
                    i6 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:183)");
                }
                SwipeToDismissKt.SwipeToDismiss.2 anon = new SwipeToDismissKt.SwipeToDismiss.2(set, i6, obj3, obj7, dismissContent);
                obj4 = set;
                obj10 = modifier2;
                BoxWithConstraintsKt.BoxWithConstraints(obj10, 0, false, (Function3)ComposableLambdaKt.rememberComposableLambda(338007641, obj6, anon, restartGroup, 54), restartGroup, i12 | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj11 = obj10;
                obj2 = i6;
            } else {
                restartGroup.skipToGroupEnd();
                obj11 = obj6;
                obj4 = obj10;
                obj2 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            traceInProgress = new SwipeToDismissKt.SwipeToDismiss.3(state, obj11, obj4, obj2, background, dismissContent, i19, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty2 = $dirty;
        }
    }

    public static final float access$getDISMISS_THRESHOLD$p() {
        return SwipeToDismissKt.DISMISS_THRESHOLD;
    }

    public static final androidx.compose.material.DismissDirection access$getDismissDirection(androidx.compose.material.DismissValue from, androidx.compose.material.DismissValue to) {
        return SwipeToDismissKt.getDismissDirection(from, to);
    }

    private static final androidx.compose.material.DismissDirection getDismissDirection(androidx.compose.material.DismissValue from, androidx.compose.material.DismissValue to) {
        int endToStart;
        androidx.compose.material.DismissValue dismissedToStart;
        endToStart = 0;
        if (from == to && from == DismissValue.Default) {
            if (from == DismissValue.Default) {
            } else {
                if (from == to && from == DismissValue.DismissedToEnd) {
                    if (from == DismissValue.DismissedToEnd) {
                        endToStart = DismissDirection.StartToEnd;
                    } else {
                        if (from == to && from == DismissValue.DismissedToStart) {
                            if (from == DismissValue.DismissedToStart) {
                                endToStart = DismissDirection.EndToStart;
                            } else {
                                if (from == DismissValue.Default && to == DismissValue.DismissedToEnd) {
                                    if (to == DismissValue.DismissedToEnd) {
                                        endToStart = DismissDirection.StartToEnd;
                                    } else {
                                        if (from == DismissValue.Default && to == DismissValue.DismissedToStart) {
                                            if (to == DismissValue.DismissedToStart) {
                                                endToStart = DismissDirection.EndToStart;
                                            } else {
                                                if (from == DismissValue.DismissedToEnd && to == DismissValue.Default) {
                                                    if (to == DismissValue.Default) {
                                                        endToStart = DismissDirection.StartToEnd;
                                                    } else {
                                                        if (from == DismissValue.DismissedToStart && to == DismissValue.Default) {
                                                            if (to == DismissValue.Default) {
                                                                endToStart = DismissDirection.EndToStart;
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                    }
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return endToStart;
    }

    public static final androidx.compose.material.DismissState rememberDismissState(androidx.compose.material.DismissValue initialValue, Function1<? super androidx.compose.material.DismissValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i5) {
        int str;
        int i;
        boolean changed;
        boolean changed2;
        Object empty;
        Object anon;
        androidx.compose.material.DismissValue obj8;
        androidx.compose.material.SwipeToDismissKt.rememberDismissState.1 obj9;
        int obj12;
        int i2 = -1753522702;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberDismissState)P(1)153@5472L62,153@5407L127:SwipeToDismiss.kt#jmzs0o");
        if (i5 & 1 != 0) {
            obj8 = DismissValue.Default;
        }
        if (i5 &= 2 != 0) {
            obj9 = obj12;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material.rememberDismissState (SwipeToDismiss.kt:152)");
        }
        obj12 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 1006276056, "CC(remember):SwipeToDismiss.kt#9igjgp");
        int i7 = 4;
        int i10 = 1;
        if (i4 ^= 6 > i7) {
            if (!$composer.changed(obj8)) {
                i = $changed & 6 == i7 ? i10 : obj12;
            } else {
            }
        } else {
        }
        int i11 = 32;
        if (i8 ^= 48 > i11) {
            if (!$composer.changed(obj9)) {
                if ($changed & 48 == i11) {
                    obj12 = i10;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i9 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (obj12 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SwipeToDismissKt.rememberDismissState.2.1(obj8, obj9);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (DismissState)RememberSaveableKt.rememberSaveable(new Object[obj12], DismissState.Companion.Saver(obj9), 0, (Function0)anon, composer2, 0, 4);
    }
}
