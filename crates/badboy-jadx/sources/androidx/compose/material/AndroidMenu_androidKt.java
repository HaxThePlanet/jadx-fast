package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008\u0011¢\u0006\u0002\u0008\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008\u0011¢\u0006\u0002\u0008\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001ac\u0010\u0017\u001a\u00020\u00012\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008\u0011¢\u0006\u0002\u0008\u0012H\u0007¢\u0006\u0002\u0010\u001f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidMenu_androidKt {
    public static final void DropdownMenu-4kj-_NE(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, long offset, ScrollState scrollState, PopupProperties properties, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        boolean traceInProgress2;
        int i18;
        Object $dirty3;
        int $this$dp$iv;
        int i;
        int $dirty2;
        boolean traceInProgress;
        int i14;
        Object obj3;
        Object properties2;
        Object obj8;
        int i4;
        int i6;
        long l2;
        int $i$f$getDp;
        int i8;
        Object obj10;
        Object obj5;
        boolean booleanValue;
        int i9;
        Object obj2;
        int i13;
        int i16;
        boolean z;
        long rememberedValue;
        Composer composer;
        int empty;
        int i19;
        Object empty2;
        int changed;
        Object mutableTransitionState;
        Object valueOf;
        int i11;
        Object obj6;
        int i7;
        int center-SzJe1aQ;
        Object obj9;
        int i5;
        Object obj7;
        Object obj;
        Object obj4;
        Object dropdownMenuPositionProvider;
        long l3;
        int i15;
        int i12;
        int i3;
        int i17;
        int $dirty;
        int i2;
        long l;
        final int i43 = i10;
        final Composer restartGroup = $changed.startRestartGroup(-2135362555);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)116@5501L21,120@5670L42:AndroidMenu.android.kt#jmzs0o");
        $dirty2 = i10;
        if (obj41 & 1 != 0) {
            $dirty2 |= 6;
            z = expanded;
        } else {
            if (i43 & 6 == 0) {
                i14 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty2 |= i14;
            } else {
                z = expanded;
            }
        }
        if (obj41 & 2 != 0) {
            $dirty2 |= 48;
            obj3 = onDismissRequest;
        } else {
            if (i43 & 48 == 0) {
                i6 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                obj3 = onDismissRequest;
            }
        }
        $i$f$getDp = obj41 & 4;
        if ($i$f$getDp != 0) {
            $dirty2 |= 384;
            obj10 = modifier;
        } else {
            if (i43 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj10 = modifier;
            }
        }
        i13 = obj41 & 8;
        if (i13 != 0) {
            $dirty2 |= 3072;
            rememberedValue = offset;
        } else {
            if (i43 & 3072 == 0) {
                i19 = restartGroup.changed(offset) ? 2048 : 1024;
                $dirty2 |= i19;
            } else {
                rememberedValue = offset;
            }
        }
        if (i43 & 24576 == 0) {
            if (obj41 & 16 == 0) {
                changed = restartGroup.changed(properties) ? 16384 : 8192;
            } else {
                empty2 = properties;
            }
            $dirty2 |= changed;
        } else {
            empty2 = properties;
        }
        mutableTransitionState = obj41 & 32;
        int i51 = 196608;
        if (mutableTransitionState != 0) {
            $dirty2 |= i51;
            valueOf = content;
        } else {
            if (i51 &= i43 == 0) {
                i11 = restartGroup.changed(content) ? 131072 : 65536;
                $dirty2 |= i11;
            } else {
                valueOf = content;
            }
        }
        i7 = 1572864;
        if (obj41 & 64 != 0) {
            $dirty2 |= i7;
            obj6 = $composer;
        } else {
            if (i43 & i7 == 0) {
                i7 = restartGroup.changedInstance($composer) ? 1048576 : 524288;
                $dirty2 |= i7;
            } else {
                obj6 = $composer;
            }
        }
        if ($dirty2 & center-SzJe1aQ == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i55 = -57345;
                if (i43 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if ($i$f$getDp != 0) {
                            obj10 = $this$dp$iv;
                        }
                        if (i13 != 0) {
                            int i31 = 0;
                            i13 = 0;
                            rememberedValue = i4;
                        }
                        if (obj41 & 16 != 0) {
                            i = 0;
                            $dirty2 &= i55;
                            empty2 = $i$f$getDp;
                        }
                        if (mutableTransitionState != 0) {
                            dropdownMenuPositionProvider = new PopupProperties(1, 0, 0, 0, 14, 0);
                            i18 = $dirty2;
                            obj = obj10;
                            l3 = rememberedValue;
                            obj7 = empty2;
                            obj8 = dropdownMenuPositionProvider;
                        } else {
                            i18 = $dirty2;
                            obj = obj10;
                            l3 = rememberedValue;
                            obj7 = empty2;
                            obj8 = valueOf;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj41 & 16 != 0) {
                            $dirty2 &= i55;
                        }
                        i18 = $dirty2;
                        obj = obj10;
                        l3 = rememberedValue;
                        obj7 = empty2;
                        obj8 = valueOf;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2135362555, i18, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:119)");
                }
                String str2 = "CC(remember):AndroidMenu.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 875822944, str2);
                int i25 = 0;
                Composer composer3 = restartGroup;
                i16 = 0;
                rememberedValue = composer3.rememberedValue();
                int i47 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    mutableTransitionState = new MutableTransitionState(false);
                    composer3.updateRememberedValue(mutableTransitionState);
                } else {
                    mutableTransitionState = rememberedValue;
                }
                $dirty2 = mutableTransitionState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                (MutableTransitionState)$dirty2.setTargetState(Boolean.valueOf(z));
                if (!(Boolean)$dirty2.getCurrentState().booleanValue()) {
                    if ((Boolean)$dirty2.getTargetState().booleanValue()) {
                        restartGroup.startReplaceGroup(1380883942);
                        ComposerKt.sourceInformation(restartGroup, "124@5860L51,125@5947L7,129@6071L131,137@6373L282,133@6212L443");
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 875829033, str2);
                        int i35 = 0;
                        Composer composer4 = restartGroup;
                        int i45 = 0;
                        Object rememberedValue3 = composer4.rememberedValue();
                        int i49 = 0;
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            mutableTransitionState = 0;
                            $dirty = i18;
                            int $dirty4 = 0;
                            obj9 = $dirty2;
                            composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), $dirty4, 2, $dirty4));
                        } else {
                            $dirty = i18;
                            obj9 = $dirty2;
                            $dirty3 = rememberedValue3;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        int i36 = 0;
                        int i41 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 875835865, str2);
                        int i27 = 0;
                        Composer composer2 = restartGroup;
                        int i37 = 0;
                        Object rememberedValue2 = composer2.rememberedValue();
                        rememberedValue = 0;
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            empty2 = new AndroidMenu_androidKt.DropdownMenu.popupPositionProvider.1.1((MutableState)$dirty3);
                            composer2.updateRememberedValue((Function2)empty2);
                        } else {
                            empty2 = rememberedValue2;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        dropdownMenuPositionProvider = new DropdownMenuPositionProvider(l3, i15, (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()), (Function2)empty2, 0);
                        center-SzJe1aQ = new AndroidMenu_androidKt.DropdownMenu.2(obj9, $dirty3, obj7, obj, obj6);
                        AndroidPopup_androidKt.Popup((PopupPositionProvider)dropdownMenuPositionProvider, obj3, obj8, (Function2)ComposableLambdaKt.rememberComposableLambda(-47803778, true, center-SzJe1aQ, restartGroup, 54), restartGroup, i40 |= i18, 0);
                        restartGroup.endReplaceGroup();
                    } else {
                        restartGroup.startReplaceGroup(1381689260);
                        restartGroup.endReplaceGroup();
                        $dirty = i18;
                        obj9 = $dirty2;
                        composer = restartGroup;
                    }
                } else {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj8;
                obj5 = obj7;
                properties2 = obj;
                l2 = l3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                l2 = l;
                $dirty = $dirty2;
                properties2 = obj10;
                obj5 = empty2;
                obj2 = valueOf;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AndroidMenu_androidKt.DropdownMenu.3(z, onDismissRequest, properties2, l2, restartGroup, obj5, obj2, $composer, i43, obj41);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(...))
    public static final void DropdownMenu-ILWXrKs(boolean expanded, Function0 onDismissRequest, Modifier modifier, long offset, PopupProperties properties, Function3 content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        Composer restartGroup;
        int $dirty2;
        int i11;
        int i;
        Object obj4;
        Object modifier2;
        Object obj5;
        long l;
        boolean traceInProgress2;
        int i2;
        int $this$dp$iv;
        long l2;
        Object obj2;
        int i14;
        boolean z;
        Object obj3;
        int i12;
        int i5;
        int $dirty;
        Object obj6;
        int i6;
        Object obj7;
        int i8;
        boolean rememberScrollState;
        int i3;
        Object obj;
        Composer composer;
        int i13;
        int i10;
        int i7;
        int i4;
        final int i35 = i9;
        traceInProgress = -840283139;
        restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)59@2347L21,54@2203L219:AndroidMenu.android.kt#jmzs0o");
        $dirty2 = i9;
        if (obj30 & 1 != 0) {
            $dirty2 |= 6;
            z = expanded;
        } else {
            if (i35 & 6 == 0) {
                i11 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty2 |= i11;
            } else {
                z = expanded;
            }
        }
        if (obj30 & 2 != 0) {
            $dirty2 |= 48;
            obj3 = onDismissRequest;
        } else {
            if (i35 & 48 == 0) {
                i = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj3 = onDismissRequest;
            }
        }
        int i21 = obj30 & 4;
        if (i21 != 0) {
            $dirty2 |= 384;
            obj5 = modifier;
        } else {
            if (i35 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                obj5 = modifier;
            }
        }
        $this$dp$iv = obj30 & 8;
        if ($this$dp$iv != 0) {
            $dirty2 |= 3072;
            l2 = offset;
        } else {
            if (i35 & 3072 == 0) {
                i12 = restartGroup.changed(offset) ? 2048 : 1024;
                $dirty2 |= i12;
            } else {
                l2 = offset;
            }
        }
        i5 = obj30 & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            obj6 = content;
        } else {
            if (i35 & 24576 == 0) {
                i6 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                obj6 = content;
            }
        }
        i8 = 196608;
        if (obj30 & 32 != 0) {
            $dirty2 |= i8;
            obj7 = $composer;
        } else {
            if (i35 & i8 == 0) {
                i8 = restartGroup.changedInstance($composer) ? 131072 : 65536;
                $dirty2 |= i8;
            } else {
                obj7 = $composer;
            }
        }
        if (i39 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i21 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj5;
                }
                if ($this$dp$iv != 0) {
                    int i32 = 0;
                    rememberScrollState = 0;
                    l2 = obj5;
                }
                if (i5 != 0) {
                    rememberScrollState = new PopupProperties(1, 0, 0, 0, 14, 0);
                    i3 = rememberScrollState;
                } else {
                    i3 = obj6;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:54)");
                }
                int i15 = 0;
                i5 = modifier2;
                obj6 = l2;
                AndroidMenu_androidKt.DropdownMenu-4kj-_NE(z, obj3, i5, obj6, obj7, ScrollKt.rememberScrollState(i15, restartGroup, i15, 1), i3, obj7, restartGroup, i20 | i31);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = i5;
                l = obj6;
                obj2 = i3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                obj4 = obj5;
                l = l2;
                obj2 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            traceInProgress = new AndroidMenu_androidKt.DropdownMenu.1(expanded, onDismissRequest, obj4, l, $this$dp$iv, obj2, $composer, i35, obj30);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void DropdownMenuItem(Function0<Unit> onClick, Modifier modifier, boolean enabled, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        int $dirty2;
        int i3;
        Object obj3;
        Object modifier2;
        Object obj;
        boolean z;
        int enabled2;
        int i4;
        Object obj2;
        int dropdownMenuItemContentPadding;
        boolean traceInProgress2;
        boolean str;
        Object obj6;
        int i;
        Function3 i6;
        Object obj7;
        Object contentPadding2;
        int i8;
        int i11;
        int $dirty;
        Object obj5;
        int i2;
        int i7;
        boolean skipping;
        Object obj4;
        int i5;
        int i10;
        final int i27 = $changed;
        traceInProgress = -1988562892;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenuItem)P(5,4,2,1,3)175@7877L227:AndroidMenu.android.kt#jmzs0o");
        $dirty2 = $changed;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
            obj7 = onClick;
        } else {
            if (i27 & 6 == 0) {
                i3 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                obj7 = onClick;
            }
        }
        int i17 = i9 & 2;
        if (i17 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i27 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                obj = modifier;
            }
        }
        dropdownMenuItemContentPadding = i9 & 4;
        if (dropdownMenuItemContentPadding != 0) {
            $dirty2 |= 384;
            str = enabled;
        } else {
            if (i27 & 384 == 0) {
                i = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i;
            } else {
                str = enabled;
            }
        }
        i6 = i9 & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            contentPadding2 = contentPadding;
        } else {
            if (i27 & 3072 == 0) {
                i8 = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty2 |= i8;
            } else {
                contentPadding2 = contentPadding;
            }
        }
        i11 = i9 & 16;
        if (i11 != 0) {
            $dirty2 |= 24576;
            obj5 = interactionSource;
        } else {
            if (i27 & 24576 == 0) {
                i2 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                obj5 = interactionSource;
            }
        }
        int i31 = 196608;
        if (i9 & 32 != 0) {
            $dirty2 |= i31;
            obj4 = content;
        } else {
            if (i27 & i31 == 0) {
                i7 = restartGroup.changedInstance(content) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                obj4 = content;
            }
        }
        if (i30 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i17 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                enabled2 = dropdownMenuItemContentPadding != 0 ? 1 : str;
                if (i6 != 0) {
                    contentPadding2 = dropdownMenuItemContentPadding;
                }
                skipping = i11 != 0 ? dropdownMenuItemContentPadding : obj5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:174)");
                }
                i11 = enabled2;
                obj5 = contentPadding2;
                contentPadding2 = modifier2;
                MenuKt.DropdownMenuItemContent(obj7, contentPadding2, i11, obj5, skipping, obj4, restartGroup, i16 | i25, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = contentPadding2;
                z = i11;
                obj2 = obj5;
                obj6 = skipping;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = obj;
                z = str;
                obj2 = contentPadding2;
                obj6 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            traceInProgress = new AndroidMenu_androidKt.DropdownMenuItem.1(onClick, obj3, z, obj2, obj6, content, i27, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty = $dirty2;
        }
    }
}
