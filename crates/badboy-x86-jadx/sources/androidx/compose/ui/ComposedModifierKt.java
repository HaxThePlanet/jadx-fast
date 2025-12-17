package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0019\u0008\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0010\t\u001a\\\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0019\u0008\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\u000e\u001af\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0019\u0008\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\u0010\u001ap\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0019\u0008\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\u0012\u001aj\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0013\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2\u0019\u0008\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0008\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0019\u0010\u001b\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0008\u0016\u001a\u0014\u0010\u001c\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0000¨\u0006\u001d", d2 = {"composed", "Landroidx/compose/ui/Modifier;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "fullyQualifiedName", "", "key1", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key3", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "keys", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "materialize", "Landroidx/compose/runtime/Composer;", "modifier", "materializeModifier", "materializeImpl", "materializeWithCompositionLocalInjection", "materializeWithCompositionLocalInjectionInternal", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComposedModifierKt {
    public static final androidx.compose.ui.Modifier access$materializeImpl(Composer $receiver, androidx.compose.ui.Modifier modifier) {
        return ComposedModifierKt.materializeImpl($receiver, modifier);
    }

    public static final androidx.compose.ui.Modifier composed(androidx.compose.ui.Modifier $this$composed, String fullyQualifiedName, Object key1, Object key2, Object key3, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super androidx.compose.ui.Modifier, ? super Composer, ? super Integer, ? extends androidx.compose.ui.Modifier> factory) {
        KeyedComposedModifier3 keyedComposedModifier3 = new KeyedComposedModifier3(fullyQualifiedName, key1, key2, key3, inspectorInfo, factory);
        return $this$composed.then((Modifier)keyedComposedModifier3);
    }

    public static final androidx.compose.ui.Modifier composed(androidx.compose.ui.Modifier $this$composed, String fullyQualifiedName, Object key1, Object key2, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super androidx.compose.ui.Modifier, ? super Composer, ? super Integer, ? extends androidx.compose.ui.Modifier> factory) {
        KeyedComposedModifier2 keyedComposedModifier2 = new KeyedComposedModifier2(fullyQualifiedName, key1, key2, inspectorInfo, factory);
        return $this$composed.then((Modifier)keyedComposedModifier2);
    }

    public static final androidx.compose.ui.Modifier composed(androidx.compose.ui.Modifier $this$composed, String fullyQualifiedName, Object key1, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super androidx.compose.ui.Modifier, ? super Composer, ? super Integer, ? extends androidx.compose.ui.Modifier> factory) {
        KeyedComposedModifier1 keyedComposedModifier1 = new KeyedComposedModifier1(fullyQualifiedName, key1, inspectorInfo, factory);
        return $this$composed.then((Modifier)keyedComposedModifier1);
    }

    public static final androidx.compose.ui.Modifier composed(androidx.compose.ui.Modifier $this$composed, String fullyQualifiedName, Object[] keys, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super androidx.compose.ui.Modifier, ? super Composer, ? super Integer, ? extends androidx.compose.ui.Modifier> factory) {
        KeyedComposedModifierN keyedComposedModifierN = new KeyedComposedModifierN(fullyQualifiedName, keys, inspectorInfo, factory);
        return $this$composed.then((Modifier)keyedComposedModifierN);
    }

    public static final androidx.compose.ui.Modifier composed(androidx.compose.ui.Modifier $this$composed, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super androidx.compose.ui.Modifier, ? super Composer, ? super Integer, ? extends androidx.compose.ui.Modifier> factory) {
        ComposedModifier composedModifier = new ComposedModifier(inspectorInfo, factory);
        return $this$composed.then((Modifier)composedModifier);
    }

    public static androidx.compose.ui.Modifier composed$default(androidx.compose.ui.Modifier modifier, String string2, Object object3, Object object4, Object object5, Function1 function16, Function3 function37, int i8, Object object9) {
        Function1 function1;
        Function1 obj12;
        if (i8 &= 16 != 0) {
            function1 = obj12;
        } else {
            function1 = function16;
        }
        return ComposedModifierKt.composed(modifier, string2, object3, object4, object5, function1, function37);
    }

    public static androidx.compose.ui.Modifier composed$default(androidx.compose.ui.Modifier modifier, String string2, Object object3, Object object4, Function1 function15, Function3 function36, int i7, Object object8) {
        Function1 function1;
        Function1 obj10;
        if (i7 &= 8 != 0) {
            function1 = obj10;
        } else {
            function1 = function15;
        }
        return ComposedModifierKt.composed(modifier, string2, object3, object4, function1, function36);
    }

    public static androidx.compose.ui.Modifier composed$default(androidx.compose.ui.Modifier modifier, String string2, Object object3, Function1 function14, Function3 function35, int i6, Object object7) {
        Function1 obj3;
        if (i6 &= 4 != 0) {
            obj3 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, string2, object3, obj3, function35);
    }

    public static androidx.compose.ui.Modifier composed$default(androidx.compose.ui.Modifier modifier, String string2, Object[] object3Arr3, Function1 function14, Function3 function35, int i6, Object object7) {
        Function1 obj3;
        if (i6 &= 4 != 0) {
            obj3 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, string2, object3Arr3, obj3, function35);
    }

    public static androidx.compose.ui.Modifier composed$default(androidx.compose.ui.Modifier modifier, Function1 function12, Function3 function33, int i4, Object object5) {
        Function1 obj1;
        if (i4 &= 1 != 0) {
            obj1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, obj1, function33);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for backwards compatibility only. If you are recompiling, use materialize.", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.Modifier materialize(Composer $this$materializeWithCompositionLocalInjection, androidx.compose.ui.Modifier modifier) {
        return ComposedModifierKt.materializeWithCompositionLocalInjectionInternal($this$materializeWithCompositionLocalInjection, modifier);
    }

    private static final androidx.compose.ui.Modifier materializeImpl(Composer $this$materializeImpl, androidx.compose.ui.Modifier modifier) {
        if (modifier.all((Function1)ComposedModifierKt.materializeImpl.1.INSTANCE)) {
            return modifier;
        }
        $this$materializeImpl.startReplaceableGroup(1219399079);
        ComposedModifierKt.materializeImpl.result.1 anon = new ComposedModifierKt.materializeImpl.result.1($this$materializeImpl);
        $this$materializeImpl.endReplaceableGroup();
        return (Modifier)modifier.foldIn(Modifier.Companion, (Function2)anon);
    }

    public static final androidx.compose.ui.Modifier materializeModifier(Composer $this$materialize, androidx.compose.ui.Modifier modifier) {
        $this$materialize.startReplaceGroup(439770924);
        $this$materialize.endReplaceGroup();
        return ComposedModifierKt.materializeImpl($this$materialize, modifier);
    }

    public static final androidx.compose.ui.Modifier materializeWithCompositionLocalInjectionInternal(Composer $this$materializeWithCompositionLocalInjectionInternal, androidx.compose.ui.Modifier modifier) {
        androidx.compose.ui.Modifier materializeModifier;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        if (modifier == Modifier.Companion) {
            materializeModifier = modifier;
        } else {
            CompositionLocalMapInjectionElement compositionLocalMapInjectionElement = new CompositionLocalMapInjectionElement($this$materializeWithCompositionLocalInjectionInternal.getCurrentCompositionLocalMap());
            materializeModifier = ComposedModifierKt.materializeModifier($this$materializeWithCompositionLocalInjectionInternal, compositionLocalMapInjectionElement.then(modifier));
        }
        return materializeModifier;
    }
}
