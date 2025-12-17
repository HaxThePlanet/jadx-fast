package androidx.compose.ui.window;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0007H\u0007¢\u0006\u0002\u0010\u0008\u001a*\u0010\t\u001a\u00020\u00012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0007H\u0003¢\u0006\u0002\u0010\u000c¨\u0006\r²\u0006\u0015\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0007X\u008a\u0084\u0002", d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidDialog_androidKt {
    public static final void Dialog(Function0<Unit> onDismissRequest, androidx.compose.ui.window.DialogProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int density;
        int $dirty2;
        Object $dirty;
        int i11;
        int traceInProgress2;
        boolean traceInProgress;
        int view;
        Object $i$a$CacheAndroidDialog_androidKt$Dialog$1;
        Object empty;
        int i9;
        Object properties2;
        Object obj;
        int i2;
        int i13;
        int i3;
        boolean skipping;
        Object rememberSaveable;
        int i;
        int i8;
        int i12;
        Object rememberedValue;
        int i10;
        Object dialogProperties;
        Object anon;
        int layoutDirection;
        int i4;
        int i5;
        Composer.Companion companion2;
        Composer.Companion companion;
        int i7;
        androidx.compose.ui.window.DialogWrapper dialogWrapper;
        Object obj2;
        Object obj24;
        final Object obj3 = onDismissRequest;
        obj = content;
        i2 = $changed;
        density = -2032877254;
        final Composer restartGroup = $composer.startRestartGroup(density);
        ComposerKt.sourceInformation(restartGroup, "C(Dialog)P(1,2)167@7096L7,168@7135L7,169@7190L7,170@7220L28,171@7275L29,172@7324L38,173@7380L616,194@8027L129,194@8002L154,203@8173L182,203@8162L193:AndroidDialog.android.kt#2oxthz");
        $dirty2 = $changed;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i2 & 6 == 0) {
                i11 = restartGroup.changedInstance(obj3) ? 4 : 2;
                $dirty2 |= i11;
            }
        }
        traceInProgress2 = i6 & 2;
        i9 = 32;
        if (traceInProgress2 != 0) {
            $dirty2 |= 48;
            properties2 = properties;
        } else {
            if (i2 & 48 == 0) {
                i13 = restartGroup.changed(properties) ? i9 : 16;
                $dirty2 |= i13;
            } else {
                properties2 = properties;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i2 & 384 == 0) {
                i3 = restartGroup.changedInstance(obj) ? 256 : 128;
                $dirty2 |= i3;
            }
        }
        if ($dirty2 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (traceInProgress2 != 0) {
                    dialogProperties = new DialogProperties(0, 0, 0, 7, 0);
                    properties2 = dialogProperties;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(density, $dirty2, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:166)");
                }
                int i15 = 6;
                int i23 = 0;
                int i29 = 2023513938;
                String str2 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object $changed$iv = consume2;
                int i24 = 6;
                int i36 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume3;
                int i37 = 6;
                int i42 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object obj5 = consume;
                int i25 = 0;
                int i38 = i25;
                i5 = i45;
                String str3 = "CC(remember):AndroidDialog.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -464840651, str3);
                Composer composer2 = restartGroup;
                int i44 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                companion2 = 0;
                obj24 = rememberSaveable;
                if (changed3 |= changed4 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        companion = 0;
                        int i21 = i9;
                        layoutDirection = $dirty2;
                        DialogWrapper density2 = new DialogWrapper(obj3, properties2, $changed$iv, (LayoutDirection)obj5, this_$iv, obj24);
                        i7 = 0;
                        AndroidDialog_androidKt.Dialog.dialog.1.1.1 anon2 = new AndroidDialog_androidKt.Dialog.dialog.1.1.1(SnapshotStateKt.rememberUpdatedState(obj, restartGroup, i34 &= 14));
                        obj2 = $changed$iv;
                        density2.setContent(ComposablesKt.rememberCompositionContext(restartGroup, i25), (Function2)ComposableLambdaKt.composableLambdaInstance(488261145, true, anon2));
                        composer2.updateRememberedValue(density2);
                    } else {
                        i9 = this_$iv;
                        obj2 = $changed$iv;
                        density = rememberedValue2;
                        empty = obj5;
                        view = 1;
                        layoutDirection = $dirty2;
                        $dirty = properties2;
                        properties2 = obj24;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -464820434, str3);
                Composer composer = restartGroup;
                int i39 = 0;
                dialogProperties = composer.rememberedValue();
                int i47 = 0;
                if (!restartGroup.changedInstance((DialogWrapper)density)) {
                    if (dialogProperties == Composer.Companion.getEmpty()) {
                        obj24 = i20;
                        $i$a$CacheAndroidDialog_androidKt$Dialog$1 = new AndroidDialog_androidKt.Dialog.1.1(density);
                        composer.updateRememberedValue((Function1)$i$a$CacheAndroidDialog_androidKt$Dialog$1);
                    } else {
                        $i$a$CacheAndroidDialog_androidKt$Dialog$1 = dialogProperties;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.DisposableEffect(density, (Function1)$i$a$CacheAndroidDialog_androidKt$Dialog$1, restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -464815709, str3);
                i = layoutDirection & 14 == 4 ? 1 : 0;
                i8 = layoutDirection & 112 == 32 ? 1 : 0;
                skipping = restartGroup;
                i12 = 0;
                rememberedValue = skipping.rememberedValue();
                int i41 = 0;
                if (i18 |= changed2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        dialogProperties = 0;
                        anon = new AndroidDialog_androidKt.Dialog.2.1(density, obj3, $dirty, empty);
                        skipping.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)anon, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                layoutDirection = $dirty2;
                $dirty = properties2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            density = new AndroidDialog_androidKt.Dialog.3(obj3, $dirty, content, $changed, i6);
            endRestartGroup.updateScope((Function2)density);
        }
    }

    private static final Function2<Composer, Integer, Unit> Dialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function2)$currentContent$delegate.getValue();
    }

    private static final void DialogLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i5) {
        int traceInProgress2;
        boolean iNSTANCE;
        int $dirty;
        int setCompositeKeyHash;
        Object modifier2;
        Object obj;
        boolean traceInProgress;
        Integer valueOf;
        Composer composer;
        int i9;
        int i3;
        boolean skipping;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier;
        Function0 constructor;
        int i8;
        int i4;
        int i6;
        int i7;
        Composer composer2;
        int i2;
        androidx.compose.ui.window.AndroidDialog_androidKt.DialogLayout.1 measurePolicy$iv;
        int i;
        Object obj21;
        int obj23;
        final Object obj2 = content;
        final int i10 = $changed;
        final int i11 = i5;
        traceInProgress2 = -1177876616;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DialogLayout)P(1)465@18400L455:AndroidDialog.android.kt#2oxthz");
        $dirty = $changed;
        setCompositeKeyHash = i11 & 1;
        if (setCompositeKeyHash != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i10 & 6 == 0) {
                i9 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i9;
            } else {
                obj = modifier;
            }
        }
        if (i11 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i10 & 48 == 0) {
                i3 = restartGroup.changedInstance(obj2) ? 32 : 16;
                $dirty |= i3;
            }
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (setCompositeKeyHash != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:464)");
                }
                iNSTANCE = AndroidDialog_androidKt.DialogLayout.1.INSTANCE;
                i17 |= i19;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i4 = 0;
                obj23 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                $dirty = Updater.constructor-impl(restartGroup);
                i6 = 0;
                Updater.set-impl($dirty, (MeasurePolicy)iNSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($dirty, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i7 = 0;
                composer2 = $dirty;
                i2 = 0;
                if (!composer2.getInserting()) {
                    measurePolicy$iv = iNSTANCE;
                    i = valueOf;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        $dirty.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer2;
                    }
                } else {
                    measurePolicy$iv = iNSTANCE;
                    i = valueOf;
                }
                Updater.set-impl($dirty, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                obj2.invoke(restartGroup, Integer.valueOf(i12 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj21;
            } else {
                restartGroup.skipToGroupEnd();
                obj23 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new AndroidDialog_androidKt.DialogLayout.2(obj, obj2, i10, i11);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final Function2 access$Dialog$lambda$0(State $currentContent$delegate) {
        return AndroidDialog_androidKt.Dialog$lambda$0($currentContent$delegate);
    }

    public static final void access$DialogLayout(Modifier modifier, Function2 content, Composer $composer, int $changed, int $default) {
        AndroidDialog_androidKt.DialogLayout(modifier, content, $composer, $changed, $default);
    }
}
