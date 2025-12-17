package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction.Enter;
import androidx.compose.foundation.interaction.HoverInteraction.Exit;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction.Cancel;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEventType.Companion;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008 \u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001aBC\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J\u0008\u00106\u001a\u00020\u000cH\u0002J\u0008\u00107\u001a\u00020\u0013H\u0004J\u0008\u00108\u001a\u00020\u0013H\u0002J\u0008\u00109\u001a\u00020\u0013H\u0002J\u0008\u0010:\u001a\u00020\u0013H\u0002J\u0006\u0010;\u001a\u00020\u0013J\u0006\u0010<\u001a\u00020\u0013J\u0006\u0010=\u001a\u00020\u0013J\u000e\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@J\u0018\u0010A\u001a\u00020\u000c2\u0006\u0010B\u001a\u00020Cø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ(\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020Lø\u0001\u0000¢\u0006\u0004\u0008M\u0010NJ\u0018\u0010O\u001a\u00020\u000c2\u0006\u0010B\u001a\u00020Cø\u0001\u0000¢\u0006\u0004\u0008P\u0010EJ\u000f\u0010Q\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0002\u0010RJ\u0008\u0010S\u001a\u00020\u000cH\u0002JN\u0010T\u001a\u00020\u00132\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012H\u0004ø\u0001\u0000¢\u0006\u0002\u0008UJ\u000c\u0010V\u001a\u00020\u0013*\u00020WH\u0016J\n\u0010X\u001a\u00020\u0013*\u00020WJ\u0012\u0010Y\u001a\u00020\u0013*\u00020ZH¦@¢\u0006\u0002\u0010[J\u001f\u0010\\\u001a\u00020\u0013*\u00020]2\u0006\u0010^\u001a\u00020\u0016H\u0084@ø\u0001\u0000¢\u0006\u0004\u0008_\u0010`R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001c\u001a\u00020\u000c@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u00122\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u000cX\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u001eR\u0011\u0010/\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00080\u0010\u001eR\u0014\u00101\u001a\u000202X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0010\u00105\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006b", d2 = {"Landroidx/compose/foundation/AbstractClickableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "J", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "<set-?>", "getEnabled", "()Z", "focusableInNonTouchMode", "Landroidx/compose/foundation/FocusableInNonTouchMode;", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "indicationNode", "Landroidx/compose/ui/node/DelegatableNode;", "lazilyCreateIndication", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pressInteraction", "shouldAutoInvalidate", "getShouldAutoInvalidate", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "userProvidedInteractionSource", "delayPressInteraction", "disposeInteractions", "emitHoverEnter", "emitHoverExit", "initializeIndicationAndInteractionSourceIfNeeded", "onAttach", "onCancelPointerInput", "onDetach", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "resetPointerInputHandler", "()Lkotlin/Unit;", "shouldLazilyCreateIndication", "updateCommon", "updateCommon-QzZPfjk", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applySemantics", "clickPointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "handlePressInteraction-d-4ec7I", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TraverseKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, FocusEventModifierNode, SemanticsModifierNode, TraversableNode {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.AbstractClickableNode.TraverseKey TraverseKey;
    private long centerOffset;
    private final Map<Key, PressInteraction.Press> currentKeyPressInteractions;
    private boolean enabled;
    private final androidx.compose.foundation.FocusableInNonTouchMode focusableInNonTouchMode;
    private final androidx.compose.foundation.FocusableNode focusableNode;
    private HoverInteraction.Enter hoverInteraction;
    private DelegatableNode indicationNode;
    private androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory;
    private MutableInteractionSource interactionSource;
    private boolean lazilyCreateIndication;
    private Function0<Unit> onClick;
    private String onClickLabel;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private PressInteraction.Press pressInteraction;
    private Role role;
    private final boolean shouldAutoInvalidate;
    private final Object traverseKey;
    private MutableInteractionSource userProvidedInteractionSource;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/AbstractClickableNode$TraverseKey;", "", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TraverseKey {
        public TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        AbstractClickableNode.TraverseKey traverseKey = new AbstractClickableNode.TraverseKey(0);
        AbstractClickableNode.TraverseKey = traverseKey;
        int i = 8;
    }

    private AbstractClickableNode(MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        super();
        this.interactionSource = interactionSource;
        this.indicationNodeFactory = indicationNodeFactory;
        this.onClickLabel = onClickLabel;
        this.role = role;
        this.enabled = enabled;
        this.onClick = onClick;
        FocusableInNonTouchMode focusableInNonTouchMode = new FocusableInNonTouchMode();
        this.focusableInNonTouchMode = focusableInNonTouchMode;
        FocusableNode focusableNode = new FocusableNode(this.interactionSource);
        this.focusableNode = focusableNode;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.currentKeyPressInteractions = (Map)linkedHashMap;
        this.centerOffset = Offset.Companion.getZero-F1C5BW0();
        this.userProvidedInteractionSource = this.interactionSource;
        this.lazilyCreateIndication = shouldLazilyCreateIndication();
        this.traverseKey = AbstractClickableNode.TraverseKey;
    }

    public AbstractClickableNode(MutableInteractionSource mutableInteractionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory2, boolean z3, String string4, Role role5, Function0 function06, DefaultConstructorMarker defaultConstructorMarker7) {
        super(mutableInteractionSource, indicationNodeFactory2, z3, string4, role5, function06);
    }

    public static final boolean access$delayPressInteraction(androidx.compose.foundation.AbstractClickableNode $this) {
        return $this.delayPressInteraction();
    }

    public static final void access$emitHoverEnter(androidx.compose.foundation.AbstractClickableNode $this) {
        $this.emitHoverEnter();
    }

    public static final void access$emitHoverExit(androidx.compose.foundation.AbstractClickableNode $this) {
        $this.emitHoverExit();
    }

    public static final MutableInteractionSource access$getInteractionSource$p(androidx.compose.foundation.AbstractClickableNode $this) {
        return $this.interactionSource;
    }

    public static final PressInteraction.Press access$getPressInteraction$p(androidx.compose.foundation.AbstractClickableNode $this) {
        return $this.pressInteraction;
    }

    public static final void access$setPressInteraction$p(androidx.compose.foundation.AbstractClickableNode $this, PressInteraction.Press <set-?>) {
        $this.pressInteraction = <set-?>;
    }

    private final boolean delayPressInteraction() {
        int i;
        boolean composeRootInScrollableContainer;
        if (!ClickableKt.hasScrollableContainer((TraversableNode)this)) {
            if (Clickable_androidKt.isComposeRootInScrollableContainer((DelegatableNode)this)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final void emitHoverEnter() {
        HoverInteraction.Enter hoverInteraction;
        MutableInteractionSource interactionSource;
        int i3;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i;
        int i4;
        androidx.compose.foundation.AbstractClickableNode.emitHoverEnter.1.1 anon;
        int i2;
        int i5;
        hoverInteraction = new HoverInteraction.Enter();
        interactionSource = this.interactionSource;
        if (this.hoverInteraction == null && interactionSource != null) {
            hoverInteraction = new HoverInteraction.Enter();
            interactionSource = this.interactionSource;
            if (interactionSource != null) {
                i3 = 0;
                i4 = 0;
                AbstractClickableNode.emitHoverEnter.1.1 anon2 = new AbstractClickableNode.emitHoverEnter.1.1(interactionSource, hoverInteraction, i4);
                BuildersKt.launch$default(getCoroutineScope(), 0, i4, (Function2)anon2, 3, 0);
            }
            this.hoverInteraction = hoverInteraction;
        }
    }

    private final void emitHoverExit() {
        int i4;
        HoverInteraction.Exit exit;
        MutableInteractionSource interactionSource;
        int i3;
        int i5;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i2;
        int i;
        androidx.compose.foundation.AbstractClickableNode.emitHoverExit.1.1.1 anon;
        int i7;
        int i6;
        final HoverInteraction.Enter hoverInteraction = this.hoverInteraction;
        i4 = 0;
        exit = new HoverInteraction.Exit(hoverInteraction);
        interactionSource = this.interactionSource;
        i3 = 0;
        if (hoverInteraction != null && interactionSource != null) {
            i4 = 0;
            exit = new HoverInteraction.Exit(hoverInteraction);
            interactionSource = this.interactionSource;
            i3 = 0;
            if (interactionSource != null) {
                i5 = 0;
                AbstractClickableNode.emitHoverExit.1.1.1 anon2 = new AbstractClickableNode.emitHoverExit.1.1.1(interactionSource, exit, i3);
                BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)anon2, 3, 0);
            }
            this.hoverInteraction = i3;
        }
    }

    private final void initializeIndicationAndInteractionSourceIfNeeded() {
        int i;
        MutableInteractionSource interactionSource2;
        DelegatableNode create;
        MutableInteractionSource interactionSource;
        if (this.indicationNode != null) {
        }
        androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory = this.indicationNodeFactory;
        i = 0;
        if (indicationNodeFactory != null && this.interactionSource == null) {
            i = 0;
            if (this.interactionSource == null) {
                this.interactionSource = InteractionSourceKt.MutableInteractionSource();
            }
            this.focusableNode.update(this.interactionSource);
            MutableInteractionSource interactionSource3 = this.interactionSource;
            Intrinsics.checkNotNull(interactionSource3);
            create = indicationNodeFactory.create((InteractionSource)interactionSource3);
            delegate(create);
            this.indicationNode = create;
        }
    }

    private final boolean shouldLazilyCreateIndication() {
        Object userProvidedInteractionSource;
        int i;
        if (this.userProvidedInteractionSource == null && this.indicationNodeFactory != null) {
            i = this.indicationNodeFactory != null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver $this$applyAdditionalSemantics) {
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Role unbox-impl;
        androidx.compose.foundation.FocusableNode focusableNode;
        int anon;
        if (this.role != null) {
            Role role = this.role;
            Intrinsics.checkNotNull(role);
            SemanticsPropertiesKt.setRole-kuIjeqM($this$applySemantics, role.unbox-impl());
        }
        anon = new AbstractClickableNode.applySemantics.1(this);
        SemanticsPropertiesKt.onClick($this$applySemantics, this.onClickLabel, (Function0)anon);
        if (this.enabled) {
            anon = 0;
            this.focusableNode.applySemantics($this$applySemantics);
        } else {
            SemanticsPropertiesKt.disabled($this$applySemantics);
        }
        applyAdditionalSemantics($this$applySemantics);
    }

    public abstract Object clickPointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation2);

    @Override // androidx.compose.ui.node.DelegatingNode
    protected final void disposeInteractions() {
        int i2;
        java.util.Collection values;
        int i3;
        Object iterator;
        boolean next;
        PressInteraction.Cancel cancel;
        int i;
        PressInteraction.Cancel cancel2;
        MutableInteractionSource interactionSource = this.interactionSource;
        i2 = 0;
        PressInteraction.Press pressInteraction = this.pressInteraction;
        if (interactionSource != null && pressInteraction != null) {
            i2 = 0;
            pressInteraction = this.pressInteraction;
            if (pressInteraction != null) {
                i3 = 0;
                iterator = new PressInteraction.Cancel(pressInteraction);
                interactionSource.tryEmit((Interaction)iterator);
            }
            HoverInteraction.Enter hoverInteraction = this.hoverInteraction;
            if (hoverInteraction != null) {
                i3 = 0;
                iterator = new HoverInteraction.Exit(hoverInteraction);
                interactionSource.tryEmit((Interaction)iterator);
            }
            i3 = 0;
            iterator = (Iterable)this.currentKeyPressInteractions.values().iterator();
            for (Object next : iterator) {
                i = 0;
                cancel2 = new PressInteraction.Cancel((PressInteraction.Press)next);
                interactionSource.tryEmit((Interaction)cancel2);
            }
        }
        int i4 = 0;
        this.pressInteraction = i4;
        this.hoverInteraction = i4;
        this.currentKeyPressInteractions.clear();
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean getShouldMergeDescendantSemantics() {
        return 1;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    protected final Object handlePressInteraction-d-4ec7I(PressGestureScope $this$handlePressInteraction_u2dd_u2d4ec7I, long offset, Continuation<? super Unit> $completion) {
        int interactionSource;
        androidx.compose.foundation.AbstractClickableNode.handlePressInteraction.2.1 anon;
        PressGestureScope $this$handlePressInteraction_u2dd_u2d4ec7I2;
        long l;
        MutableInteractionSource mutableInteractionSource;
        Object obj;
        int i;
        Object obj9;
        Object obj10;
        interactionSource = this.interactionSource;
        if (interactionSource != null) {
            interactionSource = 0;
            anon = new AbstractClickableNode.handlePressInteraction.2.1($this$handlePressInteraction_u2dd_u2d4ec7I, offset, obj4, interactionSource, this, 0);
            obj9 = CoroutineScopeKt.coroutineScope((Function2)anon, obj12);
            if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return obj9;
            }
        } else {
            $this$handlePressInteraction_u2dd_u2d4ec7I2 = $this$handlePressInteraction_u2dd_u2d4ec7I;
            l = offset;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void onAttach() {
        boolean focusableNode;
        if (!this.lazilyCreateIndication) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            delegate((DelegatableNode)this.focusableInNonTouchMode);
            delegate((DelegatableNode)this.focusableNode);
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void onCancelPointerInput() {
        int i2;
        HoverInteraction.Enter hoverInteraction;
        int i;
        HoverInteraction.Exit exit;
        HoverInteraction.Exit exit2;
        MutableInteractionSource interactionSource = this.interactionSource;
        i2 = 0;
        hoverInteraction = this.hoverInteraction;
        if (interactionSource != null && hoverInteraction != null) {
            i2 = 0;
            hoverInteraction = this.hoverInteraction;
            if (hoverInteraction != null) {
                i = 0;
                exit = new HoverInteraction.Exit(hoverInteraction);
                interactionSource.tryEmit((Interaction)exit);
            }
        }
        this.hoverInteraction = 0;
        SuspendingPointerInputModifierNode pointerInputNode = this.pointerInputNode;
        if (pointerInputNode != null) {
            pointerInputNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void onDetach() {
        int i;
        disposeInteractions();
        final int i2 = 0;
        if (this.userProvidedInteractionSource == null) {
            this.interactionSource = i2;
        }
        DelegatableNode indicationNode = this.indicationNode;
        if (indicationNode != null) {
            i = 0;
            undelegate(indicationNode);
        }
        this.indicationNode = i2;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void onFocusEvent(FocusState focusState) {
        boolean focusableNode;
        if (focusState.isFocused()) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            this.focusableNode.onFocusEvent(focusState);
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean onKeyEvent-ZmokQxo(KeyEvent event) {
        PressInteraction.Press click-ZmokQxo;
        boolean press-ZmokQxo;
        int i5;
        Object interactionSource2;
        Object interactionSource;
        long coroutineScope;
        int i4;
        androidx.compose.foundation.AbstractClickableNode.onKeyEvent.1 anon;
        int i;
        int i3;
        int i2;
        initializeIndicationAndInteractionSourceIfNeeded();
        i5 = 1;
        interactionSource2 = 0;
        final int i6 = 0;
        if (this.enabled && Clickable_androidKt.isPress-ZmokQxo(event)) {
            if (Clickable_androidKt.isPress-ZmokQxo(event)) {
                if (!this.currentKeyPressInteractions.containsKey(Key.box-impl(KeyEvent_androidKt.getKey-ZmokQxo(event)))) {
                    click-ZmokQxo = new PressInteraction.Press(this.centerOffset, obj5, i6);
                    this.currentKeyPressInteractions.put(Key.box-impl(KeyEvent_androidKt.getKey-ZmokQxo(event)), click-ZmokQxo);
                    if (this.interactionSource != null) {
                        interactionSource2 = new AbstractClickableNode.onKeyEvent.1(this, click-ZmokQxo, i6);
                        BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)interactionSource2, 3, 0);
                    }
                } else {
                    i5 = interactionSource2;
                }
            } else {
                if (this.enabled && Clickable_androidKt.isClick-ZmokQxo(event)) {
                    if (Clickable_androidKt.isClick-ZmokQxo(event)) {
                        Object remove = this.currentKeyPressInteractions.remove(Key.box-impl(KeyEvent_androidKt.getKey-ZmokQxo(event)));
                        interactionSource2 = 0;
                        if ((PressInteraction.Press)remove != null && this.interactionSource != null) {
                            interactionSource2 = 0;
                            if (this.interactionSource != null) {
                                interactionSource = new AbstractClickableNode.onKeyEvent.2.1(this, (PressInteraction.Press)remove, i6);
                                BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)interactionSource, 3, 0);
                            }
                        }
                        this.onClick.invoke();
                    } else {
                        i5 = interactionSource2;
                    }
                } else {
                }
            }
        } else {
        }
        return i5;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean enabled;
        DelegatableNode pointerInputNode;
        int coroutineScope;
        float coroutineScope2;
        float f;
        int i;
        androidx.compose.foundation.AbstractClickableNode.onPointerEvent.1 anon;
        int i3;
        int i2;
        long center-ozmzZPI = IntSizeKt.getCenter-ozmzZPI(bounds);
        coroutineScope = 0;
        this.centerOffset = OffsetKt.Offset((float)x-impl, (float)y-impl);
        initializeIndicationAndInteractionSourceIfNeeded();
        final int i4 = 0;
        if (this.enabled && pass == PointerEventPass.Main) {
            if (pass == PointerEventPass.Main) {
                int type-7fucELk = pointerEvent.getType-7fucELk();
                if (PointerEventType.equals-impl0(type-7fucELk, PointerEventType.Companion.getEnter-7fucELk())) {
                    enabled = new AbstractClickableNode.onPointerEvent.1(this, i4);
                    BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)enabled, 3, 0);
                } else {
                    if (PointerEventType.equals-impl0(type-7fucELk, PointerEventType.Companion.getExit-7fucELk())) {
                        enabled = new AbstractClickableNode.onPointerEvent.2(this, i4);
                        BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)enabled, 3, 0);
                    }
                }
            }
        }
        if (this.pointerInputNode == null) {
            AbstractClickableNode.onPointerEvent.3 anon2 = new AbstractClickableNode.onPointerEvent.3(this, i4);
            this.pointerInputNode = (SuspendingPointerInputModifierNode)delegate((DelegatableNode)SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode((Function2)anon2));
        }
        SuspendingPointerInputModifierNode pointerInputNode2 = this.pointerInputNode;
        if (pointerInputNode2 != null) {
            pointerInputNode2.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean onPreKeyEvent-ZmokQxo(KeyEvent event) {
        return 0;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    protected final Unit resetPointerInputHandler() {
        Unit iNSTANCE;
        SuspendingPointerInputModifierNode pointerInputNode = this.pointerInputNode;
        iNSTANCE = pointerInputNode != null ? Unit.INSTANCE : 0;
        return iNSTANCE;
    }

    protected final void updateCommon-QzZPfjk(MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        int isIndicationNodeDirty;
        boolean enabled2;
        boolean equal;
        boolean equal2;
        boolean it;
        androidx.compose.foundation.FocusableNode focusableNode;
        boolean lazilyCreateIndication;
        isIndicationNodeDirty = 0;
        if (!Intrinsics.areEqual(this.userProvidedInteractionSource, interactionSource)) {
            disposeInteractions();
            this.userProvidedInteractionSource = interactionSource;
            this.interactionSource = interactionSource;
            isIndicationNodeDirty = 1;
        }
        if (!Intrinsics.areEqual(this.indicationNodeFactory, indicationNodeFactory)) {
            this.indicationNodeFactory = indicationNodeFactory;
            isIndicationNodeDirty = 1;
        }
        if (this.enabled != enabled) {
            if (enabled) {
                delegate((DelegatableNode)this.focusableInNonTouchMode);
                delegate((DelegatableNode)this.focusableNode);
            } else {
                undelegate((DelegatableNode)this.focusableInNonTouchMode);
                undelegate((DelegatableNode)this.focusableNode);
                disposeInteractions();
            }
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
            this.enabled = enabled;
        }
        if (!Intrinsics.areEqual(this.onClickLabel, onClickLabel)) {
            this.onClickLabel = onClickLabel;
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        }
        if (!Intrinsics.areEqual(this.role, role)) {
            this.role = role;
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        }
        this.onClick = onClick;
        this.lazilyCreateIndication = shouldLazilyCreateIndication();
        if (this.lazilyCreateIndication != shouldLazilyCreateIndication() && !this.lazilyCreateIndication && this.indicationNode == null) {
            this.lazilyCreateIndication = shouldLazilyCreateIndication();
            if (!this.lazilyCreateIndication) {
                if (this.indicationNode == null) {
                    isIndicationNodeDirty = 1;
                }
            }
        }
        if (isIndicationNodeDirty != 0) {
            if (this.indicationNode == null) {
                DelegatableNode indicationNode = this.indicationNode;
                if (!this.lazilyCreateIndication && indicationNode != null) {
                    indicationNode = this.indicationNode;
                    if (indicationNode != null) {
                        lazilyCreateIndication = 0;
                        undelegate(indicationNode);
                    }
                    this.indicationNode = 0;
                    initializeIndicationAndInteractionSourceIfNeeded();
                }
            } else {
            }
        }
        this.focusableNode.update(this.interactionSource);
    }
}
