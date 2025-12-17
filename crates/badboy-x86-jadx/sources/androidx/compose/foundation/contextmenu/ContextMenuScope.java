package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0007\u0008\u0000¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0001¢\u0006\u0004\u0008\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0002\u0008\u0010Jl\u0010\u0011\u001a\u00020\n2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0008\u000b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182*\u0008\u0002\u0010\u0019\u001a$\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\u0008\u000b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0013¢\u0006\u0002\u0010\u001dR4\u0010\u0003\u001a(\u0012$\u0012\"\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0008\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "()V", "composables", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "Lkotlin/ParameterName;", "name", "colors", "", "Landroidx/compose/runtime/Composable;", "Content", "Content$foundation_release", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/runtime/Composer;I)V", "clear", "clear$foundation_release", "item", "label", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "iconColor", "onClick", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContextMenuScope {

    public static final int $stable;
    private final SnapshotStateList<Function3<androidx.compose.foundation.contextmenu.ContextMenuColors, Composer, Integer, Unit>> composables;
    static {
    }

    public ContextMenuScope() {
        super();
        this.composables = SnapshotStateKt.mutableStateListOf();
    }

    public static void item$default(androidx.compose.foundation.contextmenu.ContextMenuScope contextMenuScope, Function2 function22, Modifier modifier3, boolean z4, Function3 function35, Function0 function06, int i7, Object object8) {
        androidx.compose.ui.Modifier.Companion companion;
        int i2;
        int i;
        androidx.compose.ui.Modifier.Companion obj8;
        int obj9;
        int obj10;
        if (i7 & 2 != 0) {
            companion = obj8;
        } else {
            companion = modifier3;
        }
        i2 = i7 & 4 != 0 ? obj9 : z4;
        i = i7 & 8 != 0 ? obj10 : function35;
        contextMenuScope.item(function22, companion, i2, i, function06);
    }

    public final void Content$foundation_release(androidx.compose.foundation.contextmenu.ContextMenuColors colors, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i3;
        int i;
        int skipping;
        boolean traceInProgress;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i2;
        Integer valueOf;
        traceInProgress2 = 1320309496;
        final Composer obj11 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj11, "C(Content)*234@8533L18:ContextMenuUi.android.kt#3xeu6s");
        if ($changed & 6 == 0) {
            i3 = obj11.changed(colors) ? 4 : 2;
            $dirty |= i3;
        }
        if ($changed & 48 == 0) {
            i = obj11.changed(this) ? 32 : 16;
            $dirty |= i;
        }
        if ($dirty & 19 == 18) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.Content (ContextMenuUi.android.kt:233)");
                }
                SnapshotStateList composables = this.composables;
                skipping = 0;
                index$iv = 0;
                while (index$iv < (List)composables.size()) {
                    i2 = 0;
                    (Function3)composables.get(index$iv).invoke(colors, obj11, Integer.valueOf($dirty & 14));
                    index$iv++;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new ContextMenuScope.Content.2(this, colors, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public final void clear$foundation_release() {
        this.composables.clear();
    }

    public final void item(Function2<? super Composer, ? super Integer, String> label, Modifier modifier, boolean enabled, Function3<? super Color, ? super Composer, ? super Integer, Unit> leadingIcon, Function0<Unit> onClick) {
        ContextMenuScope.item.1 anon = new ContextMenuScope.item.1(label, enabled, modifier, leadingIcon, onClick);
        (Collection)this.composables.add(ComposableLambdaKt.composableLambdaInstance(262103052, true, anon));
    }
}
