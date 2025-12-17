package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001ay\u0010\u0007\u001a\u00020\u0003\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00080\u00012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0016\u0008\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0014\u0008\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u00030\u00012\u0014\u0008\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001aK\u0010\u0007\u001a\u00020\u0003\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00080\u00012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0014\u0008\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0013\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00080\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0017\"\u0008\u0008\u0000\u0010\u0008*\u00020\u0002*\u00020\u0014H\u0002\u001a^\u0010\u0018\u001a\u00020\u0003\"\u0008\u0008\u0000\u0010\u0008*\u00020\u0002*\u0008\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\u0008\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006(", d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "onReset", "onRelease", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "compositeKeyHash", "", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidView_androidKt {

    private static final Function1<View, Unit> NoOpUpdate;
    static {
        AndroidView_androidKt.NoOpUpdate = (Function1)AndroidView_androidKt.NoOpUpdate.1.INSTANCE;
    }

    public static final <T extends View> void AndroidView(Function1<? super Context, ? extends T> factory, Modifier modifier, Function1<? super T, Unit> update, Composer $composer, int $changed, int i6) {
        int anon;
        int $dirty;
        boolean $dirty2;
        int i7;
        Object obj4;
        int i4;
        Object obj2;
        Object obj;
        int i8;
        int i;
        int i2;
        Function1 noOpUpdate;
        Object obj3;
        int i5;
        int i3;
        Object obj15;
        final int i13 = $changed;
        anon = -1783766393;
        final Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(AndroidView)108@5537L130:AndroidView.android.kt#z33iqn");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i13 & 6 == 0) {
                i7 = restartGroup.changedInstance(factory) ? 4 : 2;
                $dirty |= i7;
            }
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            $dirty |= 48;
        } else {
            if (i13 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i4;
            }
        }
        int i12 = i6 & 4;
        if (i12 != 0) {
            $dirty |= 384;
            obj = update;
        } else {
            if (i13 & 384 == 0) {
                i8 = restartGroup.changedInstance(update) ? 256 : 128;
                $dirty |= i8;
            } else {
                obj = update;
            }
        }
        final int i15 = $dirty;
        if (i15 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (i11 != 0) {
                    i = obj15;
                } else {
                    i = modifier;
                }
                obj3 = i12 != 0 ? obj15 : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, i15, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:107)");
                }
                AndroidView_androidKt.AndroidView(factory, i, 0, AndroidView_androidKt.NoOpUpdate, obj3, restartGroup, obj15 | anon, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = i;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = modifier;
                obj2 = obj;
            }
        } else {
        }
        obj15 = restartGroup.endRestartGroup();
        if (obj15 != null) {
            anon = new AndroidView_androidKt.AndroidView.1(factory, obj4, obj2, i13, i6);
            obj15.updateScope((Function2)anon);
        }
    }

    public static final <T extends View> void AndroidView(Function1<? super Context, ? extends T> factory, Modifier modifier, Function1<? super T, Unit> onReset, Function1<? super T, Unit> onRelease, Function1<? super T, Unit> update, Composer $composer, int $changed, int i8) {
        boolean traceInProgress;
        int $dirty;
        int $dirty2;
        Object modifier2;
        int i;
        Object onReset2;
        Object noOpUpdate;
        boolean traceInProgress2;
        Function0 androidViewNodeFactory;
        Object obj9;
        int i6;
        int str2;
        int i3;
        Object obj3;
        Object obj;
        int i2;
        kotlin.jvm.internal.Lambda iNSTANCE;
        Object obj7;
        int i5;
        String str;
        Object obj8;
        int i4;
        Composer constructor-impl;
        Modifier materializeModifier;
        int currentCompositeKeyHash;
        Object obj6;
        Object obj4;
        Object obj5;
        Object obj2;
        CompositionLocalMap currentCompositionLocalMap;
        final Object obj10 = factory;
        final int i19 = $changed;
        traceInProgress = -180024211;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(AndroidView)P(!2,3)212@11953L23,214@12100L7,215@12155L7,222@12611L7,223@12682L7:AndroidView.android.kt#z33iqn");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i19 & 6 == 0) {
                i = restartGroup.changedInstance(obj10) ? 4 : 2;
                $dirty |= i;
            }
        }
        int i9 = i8 & 2;
        if (i9 != 0) {
            $dirty |= 48;
            noOpUpdate = modifier;
        } else {
            if (i19 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i6;
            } else {
                noOpUpdate = modifier;
            }
        }
        str2 = i8 & 4;
        if (str2 != null) {
            $dirty |= 384;
            obj = onReset;
        } else {
            if (i19 & 384 == 0) {
                i2 = restartGroup.changedInstance(onReset) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj = onReset;
            }
        }
        iNSTANCE = i8 & 8;
        if (iNSTANCE != null) {
            $dirty |= 3072;
            obj7 = onRelease;
        } else {
            if (i19 & 3072 == 0) {
                i5 = restartGroup.changedInstance(onRelease) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                obj7 = onRelease;
            }
        }
        str = i8 & 16;
        if (str != null) {
            $dirty |= 24576;
            obj8 = update;
        } else {
            if (i19 & 24576 == 0) {
                i4 = restartGroup.changedInstance(update) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                obj8 = update;
            }
        }
        int i30 = $dirty;
        if (i30 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = noOpUpdate;
                }
                onReset2 = str2 != null ? 0 : obj;
                if (iNSTANCE != null) {
                    obj7 = noOpUpdate;
                }
                if (str != null) {
                    obj8 = noOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i30, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:211)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, FocusGroupNode_androidKt.focusInteropModifier(modifier2));
                int i15 = 6;
                int i21 = 0;
                int i27 = 2023513938;
                str = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i27, str);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj6 = consume2;
                int i16 = 6;
                int i22 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i27, str);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj2 = consume3;
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                int i17 = 0;
                int i23 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i27, str);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj4 = consume4;
                int i18 = 6;
                int i24 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i27, str);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj5 = consume;
                if (onReset2 != null) {
                    restartGroup.startReplaceGroup(607871394);
                    ComposerKt.sourceInformation(restartGroup, "227@12792L37,226@12726L843");
                    i3 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!applier instanceof UiApplier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(AndroidView_androidKt.createAndroidViewNodeFactory(obj10, restartGroup, i30 & 14));
                    } else {
                        restartGroup.useNode();
                    }
                    constructor-impl = Updater.constructor-impl(restartGroup);
                    obj = 0;
                    AndroidView_androidKt.updateViewHolderParams-6NefGtU(constructor-impl, materializeModifier, currentCompositeKeyHash, (Density)obj6, (LifecycleOwner)obj4, (SavedStateRegistryOwner)obj5, (LayoutDirection)obj2, currentCompositionLocalMap);
                    Updater.set-impl(constructor-impl, onReset2, (Function2)AndroidView_androidKt.AndroidView.2.1.INSTANCE);
                    Updater.set-impl(constructor-impl, obj8, (Function2)AndroidView_androidKt.AndroidView.2.2.INSTANCE);
                    Updater.set-impl(constructor-impl, obj7, (Function2)AndroidView_androidKt.AndroidView.2.3.INSTANCE);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(608726777);
                    ComposerKt.sourceInformation(restartGroup, "245@13649L37,244@13591L756");
                    i3 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1886828752, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!applier2 instanceof UiApplier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(AndroidView_androidKt.createAndroidViewNodeFactory(obj10, restartGroup, i30 & 14));
                    } else {
                        restartGroup.useNode();
                    }
                    constructor-impl = Updater.constructor-impl(restartGroup);
                    obj = 0;
                    AndroidView_androidKt.updateViewHolderParams-6NefGtU(constructor-impl, materializeModifier, currentCompositeKeyHash, obj6, obj4, obj5, obj2, currentCompositionLocalMap);
                    Updater.set-impl(constructor-impl, obj8, (Function2)AndroidView_androidKt.AndroidView.3.1.INSTANCE);
                    Updater.set-impl(constructor-impl, obj7, (Function2)AndroidView_androidKt.AndroidView.3.2.INSTANCE);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj9 = obj7;
                obj3 = obj8;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = noOpUpdate;
                onReset2 = obj;
                obj9 = obj7;
                obj3 = obj8;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AndroidView_androidKt.AndroidView.4(obj10, modifier2, onReset2, obj9, obj3, i19, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final androidx.compose.ui.viewinterop.ViewFactoryHolder access$requireViewFactoryHolder(LayoutNode $receiver) {
        return AndroidView_androidKt.requireViewFactoryHolder($receiver);
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(Function1<? super Context, ? extends T> factory, Composer $composer, int $changed) {
        int i2;
        boolean traceInProgress;
        Object anon;
        boolean changedInstance;
        String str;
        Object stateRegistry;
        boolean changed;
        Object obj;
        int i;
        int i3 = 2030558801;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(createAndroidViewNodeFactory)267@14499L23,268@14554L7,269@14588L28,270@14668L7,271@14706L7,273@14726L297:AndroidView.android.kt#z33iqn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:266)");
        }
        i2 = 0;
        final int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, i2);
        int i11 = 6;
        int i12 = 0;
        int i13 = 2023513938;
        String str3 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, i13, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object $changed$iv = consume2;
        int i9 = i13;
        androidx.compose.runtime.CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext($composer, i2);
        int i15 = 0;
        int i16 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i9, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume3;
        int i17 = 6;
        int i19 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i9, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv2 = consume;
        ComposerKt.sourceInformationMarkerStart($composer, -1137327224, "CC(remember):AndroidView.android.kt#9igjgp");
        int i18 = 4;
        if (i14 ^= 6 > i18) {
            if (!$composer.changed(factory)) {
                if ($changed & 6 == i18) {
                    i2 = 1;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i20 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i21 = 0;
        if (i7 |= changedInstance == null) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i = 0;
                anon = new AndroidView_androidKt.createAndroidViewNodeFactory.1.1($changed$iv, factory, rememberCompositionContext, this_$iv, currentCompositeKeyHash, this_$iv2);
                composer.updateRememberedValue((Function0)anon);
            } else {
                obj = this_$iv;
                anon = rememberedValue;
                stateRegistry = factory;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Function0)anon;
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return AndroidView_androidKt.NoOpUpdate;
    }

    private static final <T extends View> androidx.compose.ui.viewinterop.ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode $this$requireViewFactoryHolder) {
        final androidx.compose.ui.viewinterop.AndroidViewHolder interopViewFactoryHolder$ui_release = $this$requireViewFactoryHolder.getInteropViewFactoryHolder$ui_release();
        final int i = 0;
        if (interopViewFactoryHolder$ui_release == null) {
        } else {
            return (ViewFactoryHolder)interopViewFactoryHolder$ui_release;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final <T extends View> void updateViewHolderParams-6NefGtU(Composer $this$updateViewHolderParams_u2d6NefGtU, Modifier modifier, int compositeKeyHash, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        boolean valueOf2;
        Integer valueOf;
        Updater.set-impl($this$updateViewHolderParams_u2d6NefGtU, compositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.set-impl($this$updateViewHolderParams_u2d6NefGtU, modifier, (Function2)AndroidView_androidKt.updateViewHolderParams.1.INSTANCE);
        Updater.set-impl($this$updateViewHolderParams_u2d6NefGtU, density, (Function2)AndroidView_androidKt.updateViewHolderParams.2.INSTANCE);
        Updater.set-impl($this$updateViewHolderParams_u2d6NefGtU, lifecycleOwner, (Function2)AndroidView_androidKt.updateViewHolderParams.3.INSTANCE);
        Updater.set-impl($this$updateViewHolderParams_u2d6NefGtU, savedStateRegistryOwner, (Function2)AndroidView_androidKt.updateViewHolderParams.4.INSTANCE);
        Updater.set-impl($this$updateViewHolderParams_u2d6NefGtU, layoutDirection, (Function2)AndroidView_androidKt.updateViewHolderParams.5.INSTANCE);
        final int i = 0;
        final Composer composer = $this$updateViewHolderParams_u2d6NefGtU;
        final int i2 = 0;
        if (!composer.getInserting()) {
            if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
                composer.updateRememberedValue(Integer.valueOf(compositeKeyHash));
                $this$updateViewHolderParams_u2d6NefGtU.apply(Integer.valueOf(compositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            }
        } else {
        }
    }
}
