package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001ax\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0008\u0012\u001aV\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\u0008\u0017\u001aB\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\u0008\u0018\u001aA\u0010\u0019\u001a\u00020\u0014*\u00020\u00142\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001e\u0008\u0004\u0010\u001a\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c\u0012\u0004\u0012\u00020\u00140\u001bH\u0080\u0008\u001a\u0088\u0001\u0010\u001c\u001a\u00020\u0014*\u00020\u00142\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\u0008\u0002\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0008\u001d\u001at\u0010\u001c\u001a\u00020\u0014*\u00020\u00142\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\u0008\u0002\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0008\u001e\u001a\u009e\u0001\u0010\u001f\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#2\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u00020(0'2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0008)\u001a\u000c\u0010*\u001a\u00020\u000e*\u00020+H\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006,", d2 = {"CombinedClickableNode", "Landroidx/compose/foundation/CombinedClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "CombinedClickableNode-nSzSaCc", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "clickable-XHw0xAI", "clickableWithIndicationIfNeeded", "createClickable", "Lkotlin/Function2;", "combinedClickable", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-Kqv-Bsg", "hasScrollableContainer", "Landroidx/compose/ui/node/TraversableNode;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ClickableKt {
    public static final androidx.compose.foundation.CombinedClickableNode CombinedClickableNode-nSzSaCc(Function0<Unit> onClick, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role) {
        CombinedClickableNodeImpl combinedClickableNodeImpl = new CombinedClickableNodeImpl(onClick, onLongClickLabel, onLongClick, onDoubleClick, interactionSource, indicationNodeFactory, enabled, onClickLabel, role, 0);
        return (CombinedClickableNode)combinedClickableNodeImpl;
    }

    public static final Modifier clickable-O2vRcR0(Modifier $this$clickable_u2dO2vRcR0, MutableInteractionSource interactionSource, androidx.compose.foundation.Indication indication, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        int indication2;
        Object obj2;
        int $i$a$ClickableWithIndicationIfNeededClickableKt$clickable$3;
        String str3;
        Role role2;
        Function0 function02;
        Modifier clickableElement;
        MutableInteractionSource mutableInteractionSource;
        Object obj;
        boolean z2;
        String str2;
        Role role4;
        Function0 function03;
        int i;
        androidx.compose.foundation.ClickableElement clickableElement2;
        MutableInteractionSource mutableInteractionSource2;
        int i2;
        boolean z;
        String str;
        Role role3;
        Function0 function0;
        int i3;
        obj2 = indication;
        final int i5 = 0;
        if (obj2 instanceof IndicationNodeFactory != null) {
            indication2 = 0;
            clickableElement = new ClickableElement(interactionSource, (IndicationNodeFactory)obj2, enabled, onClickLabel, role, onClick, 0);
        } else {
            if (obj2 == null) {
                indication2 = 0;
                clickableElement2 = new ClickableElement(interactionSource, 0, enabled, onClickLabel, role, onClick, 0);
                clickableElement = clickableElement2;
            } else {
                if (interactionSource != null) {
                    int i4 = 0;
                    clickableElement2 = new ClickableElement(interactionSource, 0, enabled, onClickLabel, role, onClick, 0);
                    clickableElement = IndicationKt.indication((Modifier)Modifier.Companion, (InteractionSource)interactionSource, obj2).then((Modifier)clickableElement2);
                } else {
                    indication2 = new ClickableKt.clickable-O2vRcR0$$inlined.clickableWithIndicationIfNeeded.1(obj2, enabled, onClickLabel, role, onClick);
                    $i$a$ClickableWithIndicationIfNeededClickableKt$clickable$3 = 0;
                    clickableElement = ComposedModifierKt.composed$default((Modifier)Modifier.Companion, $i$a$ClickableWithIndicationIfNeededClickableKt$clickable$3, (Function3)indication2, 1, $i$a$ClickableWithIndicationIfNeededClickableKt$clickable$3);
                }
            }
        }
        return $this$clickable_u2dO2vRcR0.then(clickableElement);
    }

    public static Modifier clickable-O2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource2, androidx.compose.foundation.Indication indication3, boolean z4, String string5, Role role6, Function0 function07, int i8, Object object9) {
        int i;
        int i3;
        int i2;
        int obj10;
        i = i8 & 4 != 0 ? obj10 : z4;
        int obj15 = 0;
        i3 = i8 & 8 != 0 ? obj15 : string5;
        i2 = i8 & 16 != 0 ? obj15 : role6;
        return ClickableKt.clickable-O2vRcR0(modifier, mutableInteractionSource2, indication3, i, i3, i2, function07);
    }

    public static final Modifier clickable-XHw0xAI(Modifier $this$clickable_u2dXHw0xAI, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new ClickableKt.clickable-XHw0xAI$$inlined.debugInspectorInfo.1(enabled, onClickLabel, role, onClick);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        ClickableKt.clickable.2 $i$f$debugInspectorInfo = new ClickableKt.clickable.2(enabled, onClickLabel, role, onClick);
        return ComposedModifierKt.composed($this$clickable_u2dXHw0xAI, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static Modifier clickable-XHw0xAI$default(Modifier modifier, boolean z2, String string3, Role role4, Function0 function05, int i6, Object object7) {
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj2 = 1;
        }
        final int i = 0;
        if (i6 & 2 != 0) {
            obj3 = i;
        }
        if (i6 &= 4 != 0) {
            obj4 = i;
        }
        return ClickableKt.clickable-XHw0xAI(modifier, obj2, obj3, obj4, function05);
    }

    public static final Modifier clickableWithIndicationIfNeeded(Modifier $this$clickableWithIndicationIfNeeded, MutableInteractionSource interactionSource, androidx.compose.foundation.Indication indication, Function2<? super MutableInteractionSource, ? super androidx.compose.foundation.IndicationNodeFactory, ? extends Modifier> createClickable) {
        Object composed$default;
        Modifier indication2;
        Object anon;
        int i;
        final int i2 = 0;
        if (indication instanceof IndicationNodeFactory != null) {
            composed$default = createClickable.invoke(interactionSource, indication);
        } else {
            int i3 = 0;
            if (indication == null) {
                composed$default = createClickable.invoke(interactionSource, i3);
            } else {
                if (interactionSource != null) {
                    composed$default = IndicationKt.indication((Modifier)Modifier.Companion, (InteractionSource)interactionSource, indication).then((Modifier)createClickable.invoke(interactionSource, i3));
                } else {
                    anon = new ClickableKt.clickableWithIndicationIfNeeded.1(indication, createClickable);
                    composed$default = ComposedModifierKt.composed$default((Modifier)Modifier.Companion, i3, (Function3)anon, 1, i3);
                }
            }
        }
        return $this$clickableWithIndicationIfNeeded.then(composed$default);
    }

    public static final Modifier combinedClickable-XVZzFYc(Modifier $this$combinedClickable_u2dXVZzFYc, MutableInteractionSource interactionSource, androidx.compose.foundation.Indication indication, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, Function0<Unit> onClick) {
        int indication2;
        Object obj2;
        int $i$a$ClickableWithIndicationIfNeededClickableKt$combinedClickable$3;
        String str4;
        Role role4;
        Function0 function0;
        String str;
        Function0 function06;
        Function0 function05;
        Modifier combinedClickableElement;
        MutableInteractionSource mutableInteractionSource2;
        Object obj;
        boolean z;
        String str2;
        Role role2;
        Function0 function02;
        String str6;
        Function0 function03;
        Function0 function04;
        int i3;
        androidx.compose.foundation.CombinedClickableElement combinedClickableElement2;
        MutableInteractionSource mutableInteractionSource;
        int i2;
        boolean z2;
        String str3;
        Role role3;
        Function0 function08;
        String str5;
        Function0 function07;
        Function0 function09;
        int i;
        obj2 = indication;
        final int i5 = 0;
        if (obj2 instanceof IndicationNodeFactory != null) {
            indication2 = 0;
            combinedClickableElement = new CombinedClickableElement(interactionSource, (IndicationNodeFactory)obj2, enabled, onClickLabel, role, onClick, onLongClickLabel, onLongClick, onDoubleClick, 0);
        } else {
            if (obj2 == null) {
                indication2 = 0;
                combinedClickableElement2 = new CombinedClickableElement(interactionSource, 0, enabled, onClickLabel, role, onClick, onLongClickLabel, onLongClick, onDoubleClick, 0);
                combinedClickableElement = combinedClickableElement2;
            } else {
                if (interactionSource != null) {
                    int i4 = 0;
                    combinedClickableElement2 = new CombinedClickableElement(interactionSource, 0, enabled, onClickLabel, role, onClick, onLongClickLabel, onLongClick, onDoubleClick, 0);
                    combinedClickableElement = IndicationKt.indication((Modifier)Modifier.Companion, (InteractionSource)interactionSource, obj2).then((Modifier)combinedClickableElement2);
                } else {
                    indication2 = new ClickableKt.combinedClickable-XVZzFYc$$inlined.clickableWithIndicationIfNeeded.1(obj2, enabled, onClickLabel, role, onClick, onLongClickLabel, onLongClick, onDoubleClick);
                    $i$a$ClickableWithIndicationIfNeededClickableKt$combinedClickable$3 = 0;
                    combinedClickableElement = ComposedModifierKt.composed$default((Modifier)Modifier.Companion, $i$a$ClickableWithIndicationIfNeededClickableKt$combinedClickable$3, (Function3)indication2, 1, $i$a$ClickableWithIndicationIfNeededClickableKt$combinedClickable$3);
                }
            }
        }
        return $this$combinedClickable_u2dXVZzFYc.then(combinedClickableElement);
    }

    public static Modifier combinedClickable-XVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource2, androidx.compose.foundation.Indication indication3, boolean z4, String string5, Role role6, String string7, Function0 function08, Function0 function09, Function0 function010, int i11, Object object12) {
        int i5;
        int i6;
        int i;
        int i4;
        int i3;
        int i2;
        int obj13;
        int i7 = i11;
        i5 = i7 & 4 != 0 ? obj13 : z4;
        int i9 = 0;
        i6 = i7 & 8 != 0 ? i9 : string5;
        i = i7 & 16 != 0 ? i9 : role6;
        i4 = i7 & 32 != 0 ? i9 : string7;
        i3 = i7 & 64 != 0 ? i9 : function08;
        i2 = i7 & 128 != 0 ? i9 : function09;
        return ClickableKt.combinedClickable-XVZzFYc(modifier, mutableInteractionSource2, indication3, i5, i6, i, i4, i3, i2, function010);
    }

    public static final Modifier combinedClickable-cJG_KMw(Modifier $this$combinedClickable_u2dcJG_KMw, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, Function0<Unit> onClick) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        boolean z;
        String str;
        Role role2;
        Function0 function03;
        Function0 function0;
        Function0 function02;
        String str2;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new ClickableKt.combinedClickable-cJG_KMw$$inlined.debugInspectorInfo.1(enabled, onClickLabel, role, onClick, onDoubleClick, onLongClick, onLongClickLabel);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        ClickableKt.combinedClickable.2 anon = new ClickableKt.combinedClickable.2(enabled, onClickLabel, role, onLongClickLabel, onLongClick, onDoubleClick, onClick);
        return ComposedModifierKt.composed($this$combinedClickable_u2dcJG_KMw, noInspectorInfo, (Function3)anon);
    }

    public static Modifier combinedClickable-cJG_KMw$default(Modifier modifier, boolean z2, String string3, Role role4, String string5, Function0 function06, Function0 function07, Function0 function08, int i9, Object object10) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        int obj9;
        if (i9 & 1 != 0) {
            obj2 = 1;
        }
        final int i = 0;
        if (i9 & 2 != 0) {
            obj3 = i;
        }
        if (i9 & 4 != 0) {
            obj4 = i;
        }
        if (i9 & 8 != 0) {
            obj5 = i;
        }
        if (i9 & 16 != 0) {
            obj6 = i;
        }
        obj9 = i9 &= 32 != 0 ? i : function07;
        return ClickableKt.combinedClickable-cJG_KMw(modifier, obj2, obj3, obj4, obj5, obj6, obj9, function08);
    }

    public static final Modifier genericClickableWithoutGesture-Kqv-Bsg(Modifier $this$genericClickableWithoutGesture_u2dKqv_u2dBsg, MutableInteractionSource interactionSource, androidx.compose.foundation.Indication indication, CoroutineScope indicationScope, Map<Key, PressInteraction.Press> currentKeyPressInteractions, State<Offset> keyClickOffset, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onClick) {
        final boolean z = enabled;
        ClickableSemanticsElement clickableSemanticsElement = new ClickableSemanticsElement(z, role, onLongClickLabel, onLongClick, onClickLabel, onClick, 0);
        return $this$genericClickableWithoutGesture_u2dKqv_u2dBsg.then(FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(ClickableKt.genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey((Modifier)clickableSemanticsElement, z, currentKeyPressInteractions, keyClickOffset, indicationScope, onClick, interactionSource), (InteractionSource)interactionSource, indication), interactionSource, enabled), enabled, interactionSource));
    }

    public static Modifier genericClickableWithoutGesture-Kqv-Bsg$default(Modifier modifier, MutableInteractionSource mutableInteractionSource2, androidx.compose.foundation.Indication indication3, CoroutineScope coroutineScope4, Map map5, State state6, boolean z7, String string8, Role role9, String string10, Function0 function011, Function0 function012, int i13, Object object14) {
        int i3;
        int i6;
        int i5;
        int i;
        int i4;
        int i2;
        int i7 = i13;
        i6 = i7 & 32 != 0 ? i3 : z7;
        int i12 = 0;
        i5 = i7 & 64 != 0 ? i12 : string8;
        i = i7 & 128 != 0 ? i12 : role9;
        i4 = i7 & 256 != 0 ? i12 : string10;
        i2 = i7 &= 512 != 0 ? i12 : function011;
        return ClickableKt.genericClickableWithoutGesture-Kqv-Bsg(modifier, mutableInteractionSource2, indication3, coroutineScope4, map5, state6, i6, i5, i, i4, i2, function012);
    }

    private static final Modifier genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(Modifier $this$genericClickableWithoutGesture_Kqv_Bsg_u24detectPressAndClickFromKey, boolean $enabled, Map<Key, PressInteraction.Press> $currentKeyPressInteractions, State<Offset> $keyClickOffset, CoroutineScope $indicationScope, Function0<Unit> $onClick, MutableInteractionSource $interactionSource) {
        ClickableKt.genericClickableWithoutGesture.detectPressAndClickFromKey.1 anon = new ClickableKt.genericClickableWithoutGesture.detectPressAndClickFromKey.1($enabled, $currentKeyPressInteractions, $keyClickOffset, $indicationScope, $onClick, $interactionSource);
        return KeyInputModifierKt.onKeyEvent($this$genericClickableWithoutGesture_Kqv_Bsg_u24detectPressAndClickFromKey, (Function1)anon);
    }

    public static final boolean hasScrollableContainer(TraversableNode $this$hasScrollableContainer) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ClickableKt.hasScrollableContainer.1 anon = new ClickableKt.hasScrollableContainer.1(booleanRef);
        TraversableNodeKt.traverseAncestors((DelegatableNode)$this$hasScrollableContainer, ScrollableContainerNode.TraverseKey, (Function1)anon);
        return booleanRef.element;
    }
}
