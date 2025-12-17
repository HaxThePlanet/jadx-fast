package androidx.compose.foundation.text;

import androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0008\u0008H\u0001¢\u0006\u0002\u0010\t\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0008\u0008H\u0001¢\u0006\u0002\u0010\u000c\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\r2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0008\u0008H\u0001¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0008\u0004\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\u0008¨\u0006\u0016", d2 = {"ContextMenuArea", "", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "enabled", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "(Landroidx/compose/foundation/text/selection/SelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextItem", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "label", "Landroidx/compose/foundation/text/TextContextMenuItems;", "operation", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextMenu_androidKt {
    public static final void ContextMenuArea(TextFieldSelectionState selectionState, boolean enabled, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int invalid$iv;
        int i;
        int i2;
        int i5;
        boolean skipping;
        boolean traceInProgress;
        int $this$cache$iv;
        kotlin.jvm.functions.Function1 contextMenuBuilder;
        int i6;
        boolean z;
        Object obj;
        int empty2;
        int empty;
        int i3;
        Object contextMenuState;
        Object anon;
        int i7;
        int i4;
        boolean obj12;
        Object obj13;
        int obj14;
        invalid$iv = 2103477555;
        final Composer restartGroup = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenuArea)P(2,1)52@2019L31,55@2155L17,53@2095L214:ContextMenu.android.kt#423gt5");
        if ($changed & 6 == 0) {
            i = restartGroup.changedInstance(selectionState) ? 4 : 2;
            obj14 |= i;
        }
        if ($changed & 48 == 0) {
            i2 = restartGroup.changed(enabled) ? 32 : 16;
            obj14 |= i2;
        }
        if ($changed & 384 == 0) {
            i5 = restartGroup.changedInstance(content) ? 256 : 128;
            obj14 |= i5;
        }
        if (obj14 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, obj14, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:51)");
                }
                String str = "CC(remember):ContextMenu.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 181410547, str);
                int i9 = 0;
                Composer composer = restartGroup;
                int i15 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i20 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    i4 = 0;
                    contextMenuState = new ContextMenuState(i4, 1, i4);
                    composer.updateRememberedValue(contextMenuState);
                } else {
                    contextMenuState = rememberedValue;
                }
                invalid$iv = contextMenuState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 181414885, str);
                int i10 = 0;
                Composer composer2 = restartGroup;
                int i16 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i21 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = new ContextMenu_androidKt.ContextMenuArea.3.1((ContextMenuState)invalid$iv);
                    composer2.updateRememberedValue((Function0)anon);
                } else {
                    anon = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ContextMenuArea_androidKt.ContextMenuArea(invalid$iv, (Function0)anon, TextFieldSelectionState_androidKt.contextMenuBuilder(selectionState, invalid$iv), 0, enabled, content, restartGroup, i13 | i19, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                z = enabled;
                obj = content;
            }
        } else {
        }
        obj12 = restartGroup.endRestartGroup();
        if (obj12 != null) {
            obj13 = new ContextMenu_androidKt.ContextMenuArea.4(selectionState, z, obj, $changed);
            obj12.updateScope((Function2)obj13);
        }
    }

    public static final void ContextMenuArea(SelectionManager manager, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int invalid$iv;
        int i7;
        int i2;
        int skipping;
        boolean traceInProgress;
        int $this$cache$iv;
        kotlin.jvm.functions.Function1 contextMenuBuilder;
        int i5;
        int i6;
        int empty;
        int empty2;
        Object obj;
        Object contextMenuState;
        Object anon;
        int i3;
        int i4;
        int i;
        Object obj12;
        int obj13;
        invalid$iv = 605522716;
        final Composer restartGroup = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenuArea)P(1)67@2449L31,70@2585L17,68@2525L180:ContextMenu.android.kt#423gt5");
        if ($changed & 6 == 0) {
            i7 = restartGroup.changedInstance(manager) ? 4 : 2;
            obj13 |= i7;
        }
        if ($changed & 48 == 0) {
            i2 = restartGroup.changedInstance(content) ? 32 : 16;
            obj13 |= i2;
        }
        if (obj13 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, obj13, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:66)");
                }
                String str = "CC(remember):ContextMenu.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 181424307, str);
                int i9 = 0;
                Composer composer = restartGroup;
                int i14 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i17 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    i = 0;
                    contextMenuState = new ContextMenuState(i, 1, i);
                    composer.updateRememberedValue(contextMenuState);
                } else {
                    contextMenuState = rememberedValue;
                }
                invalid$iv = contextMenuState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 181428645, str);
                int i10 = 0;
                Composer composer2 = restartGroup;
                int i15 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i18 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    anon = new ContextMenu_androidKt.ContextMenuArea.5.1((ContextMenuState)invalid$iv);
                    composer2.updateRememberedValue((Function0)anon);
                } else {
                    anon = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ContextMenuArea_androidKt.ContextMenuArea(invalid$iv, (Function0)anon, SelectionManager_androidKt.contextMenuBuilder(manager, invalid$iv), 0, false, content, restartGroup, i12 | 54, 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj = content;
            }
        } else {
        }
        obj12 = restartGroup.endRestartGroup();
        if (obj12 != null) {
            invalid$iv = new ContextMenu_androidKt.ContextMenuArea.6(manager, obj, $changed);
            obj12.updateScope((Function2)invalid$iv);
        }
    }

    public static final void ContextMenuArea(TextFieldSelectionManager manager, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int invalid$iv;
        int i6;
        int i3;
        int skipping;
        boolean traceInProgress;
        int $this$cache$iv;
        kotlin.jvm.functions.Function1 contextMenuBuilder;
        int i5;
        boolean enabled;
        int empty2;
        int empty;
        Object obj;
        Object contextMenuState;
        Object anon;
        int i4;
        int i;
        int i2;
        Object obj12;
        int obj13;
        invalid$iv = -1985516685;
        final Composer restartGroup = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenuArea)P(1)36@1552L31,39@1688L17,37@1628L215:ContextMenu.android.kt#423gt5");
        if ($changed & 6 == 0) {
            i6 = restartGroup.changedInstance(manager) ? 4 : 2;
            obj13 |= i6;
        }
        if ($changed & 48 == 0) {
            i3 = restartGroup.changedInstance(content) ? 32 : 16;
            obj13 |= i3;
        }
        if (obj13 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, obj13, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:35)");
                }
                String str = "CC(remember):ContextMenu.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 181395603, str);
                int i8 = 0;
                Composer composer = restartGroup;
                int i13 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i16 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    i2 = 0;
                    contextMenuState = new ContextMenuState(i2, 1, i2);
                    composer.updateRememberedValue(contextMenuState);
                } else {
                    contextMenuState = rememberedValue;
                }
                invalid$iv = contextMenuState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 181399941, str);
                int i9 = 0;
                Composer composer2 = restartGroup;
                int i14 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i17 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = new ContextMenu_androidKt.ContextMenuArea.1.1((ContextMenuState)invalid$iv);
                    composer2.updateRememberedValue((Function0)anon);
                } else {
                    anon = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ContextMenuArea_androidKt.ContextMenuArea(invalid$iv, (Function0)anon, TextFieldSelectionManager_androidKt.contextMenuBuilder(manager, invalid$iv), 0, manager.getEnabled(), content, restartGroup, i11 | 54, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj = content;
            }
        } else {
        }
        obj12 = restartGroup.endRestartGroup();
        if (obj12 != null) {
            invalid$iv = new ContextMenu_androidKt.ContextMenuArea.2(manager, obj, $changed);
            obj12.updateScope((Function2)invalid$iv);
        }
    }

    public static final void TextItem(ContextMenuScope $this$TextItem, ContextMenuState state, androidx.compose.foundation.text.TextContextMenuItems label, boolean enabled, Function0<Unit> operation) {
        final int i = 0;
        ContextMenu_androidKt.TextItem.1 anon = new ContextMenu_androidKt.TextItem.1(label);
        ContextMenu_androidKt.TextItem.2 anon2 = new ContextMenu_androidKt.TextItem.2(operation, state);
        ContextMenuScope.item$default($this$TextItem, (Function2)anon, 0, enabled, 0, (Function0)anon2, 10, 0);
    }
}
