package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Element;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrder;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\u00082\u00020\t2\u00020\n2\u00020\u000b2\u00020\u000c2\u00020\r2\u00020\u000e2\u00020\u000fB\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020\u001eH\u0002J\u0008\u0010A\u001a\u00020\u001eH\u0016J\u0008\u0010B\u001a\u00020<H\u0016J\u0008\u0010C\u001a\u00020<H\u0016J\u0008\u0010D\u001a\u00020<H\u0016J\r\u0010E\u001a\u00020<H\u0000¢\u0006\u0002\u0008FJ\u0010\u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020\"H\u0016J\u0008\u0010L\u001a\u00020<H\u0016J\u0010\u0010M\u001a\u00020<2\u0006\u0010K\u001a\u00020\"H\u0016J*\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\u0008U\u0010VJ\u001a\u0010W\u001a\u00020<2\u0006\u00103\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\u0008X\u0010YJ\u0008\u0010Z\u001a\u00020\u001eH\u0016J\u0008\u0010[\u001a\u00020\\H\u0016J\u0008\u0010]\u001a\u00020<H\u0002J\u0008\u0010^\u001a\u00020<H\u0002J\u0006\u0010_\u001a\u00020<J\u0014\u0010`\u001a\u00020<2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030aH\u0002J\u000c\u0010b\u001a\u00020<*\u00020cH\u0016J\u000c\u0010d\u001a\u00020<*\u00020eH\u0016J\u001c\u0010f\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020gH\u0016J\u001c\u0010l\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010m\u001a\u00020gH\u0016J&\u0010n\u001a\u00020o*\u00020p2\u0006\u0010i\u001a\u00020q2\u0006\u0010r\u001a\u00020sH\u0016ø\u0001\u0000¢\u0006\u0004\u0008t\u0010uJ\u001c\u0010v\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020gH\u0016J\u001c\u0010w\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010m\u001a\u00020gH\u0016J\u0018\u0010x\u001a\u0004\u0018\u00010y*\u00020\u00162\u0008\u0010z\u001a\u0004\u0018\u00010yH\u0016R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u0012R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010*R2\u0010+\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030-0,j\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030-`.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u00100\"\u0004\u00081\u00102R\u001a\u00103\u001a\u0002048VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00085\u00106R$\u00107\u001a\u0002H8\"\u0004\u0008\u0000\u00108*\u0008\u0012\u0004\u0012\u0002H80-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010:\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006{", d2 = {"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "(Landroidx/compose/ui/Modifier$Element;)V", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "value", "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "invalidateCache", "", "isValidOwnerScope", "()Z", "lastOnPlacedCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "initializeModifier", "duringAttach", "interceptOutOfBoundsChildEvents", "onAttach", "onCancelPointerInput", "onDetach", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui_release", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onGloballyPositioned", "coordinates", "onMeasureResultChanged", "onPlaced", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "sharePointerInputWithSiblings", "toString", "", "unInitializeModifier", "updateDrawCache", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "modifyParentData", "", "parentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackwardsCompatNode extends Modifier.Node implements androidx.compose.ui.node.LayoutModifierNode, androidx.compose.ui.node.DrawModifierNode, androidx.compose.ui.node.SemanticsModifierNode, androidx.compose.ui.node.PointerInputModifierNode, ModifierLocalModifierNode, ModifierLocalReadScope, androidx.compose.ui.node.ParentDataModifierNode, androidx.compose.ui.node.LayoutAwareModifierNode, androidx.compose.ui.node.GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, androidx.compose.ui.node.OwnerScope, BuildDrawCacheParams {

    public static final int $stable = 8;
    private BackwardsCompatLocalMap _providedValues;
    private Modifier.Element element;
    private boolean invalidateCache = true;
    private LayoutCoordinates lastOnPlacedCoordinates;
    private HashSet<ModifierLocal<?>> readValues;
    static {
        final int i = 8;
    }

    public BackwardsCompatNode(Modifier.Element element) {
        super();
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element));
        this.element = element;
        int i = 1;
        HashSet hashSet = new HashSet();
        this.readValues = hashSet;
    }

    public static final LayoutCoordinates access$getLastOnPlacedCoordinates$p(androidx.compose.ui.node.BackwardsCompatNode $this) {
        return $this.lastOnPlacedCoordinates;
    }

    private final void initializeModifier(boolean duringAttach) {
        int this_$iv;
        boolean anon;
        int this_$iv2;
        int this_$iv4;
        boolean isChainUpdate2;
        int isChainUpdate3;
        boolean z;
        int this_$iv3;
        boolean isChainUpdate;
        int this_$iv5;
        Object requireOwner;
        String $i$a$CheckPreconditionBackwardsCompatNode$initializeModifier$1;
        int $i$f$getLayoutOLwlOKw;
        int $i$f$getLayoutAwareOLwlOKw;
        int $i$f$getGlobalPositionAwareOLwlOKw;
        int $i$f$getPointerInputOLwlOKw;
        int i3;
        int anon2;
        int i;
        int i2;
        int i4 = 0;
        if (!isAttached()) {
            int i13 = 0;
            InlineClassHelperKt.throwIllegalStateException("initializeModifier called on unattached node");
        }
        Modifier.Element value$iv = this.element;
        int i6 = 0;
        int i15 = 0;
        i2 = 0;
        final int i32 = 1;
        this_$iv = kindSet$ui_release &= $i$f$getLocalsOLwlOKw != 0 ? i32 : i2;
        if (this_$iv != 0 && value$iv instanceof ModifierLocalConsumer) {
            if (value$iv instanceof ModifierLocalConsumer) {
                anon = new BackwardsCompatNode.initializeModifier.2(this);
                sideEffect((Function0)anon);
            }
            if (value$iv instanceof ModifierLocalProvider != null) {
                updateModifierLocalProvider((ModifierLocalProvider)value$iv);
            }
        }
        int i7 = 0;
        int i17 = 0;
        this_$iv2 = kindSet$ui_release2 &= $i$f$getDrawOLwlOKw != 0 ? i32 : i2;
        if (this_$iv2 != 0 && value$iv instanceof DrawCacheModifier) {
            if (value$iv instanceof DrawCacheModifier) {
                this.invalidateCache = i32;
            }
            if (!duringAttach) {
                LayoutModifierNodeKt.invalidateLayer((LayoutModifierNode)this);
            }
        }
        int i8 = 0;
        i3 = 0;
        this_$iv4 = kindSet$ui_release3 &= $i$f$getLayoutOLwlOKw != 0 ? i32 : i2;
        if (this_$iv4 != 0 && BackwardsCompatNodeKt.access$isChainUpdate(this)) {
            if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                $i$f$getLayoutOLwlOKw = getCoordinator$ui_release();
                Intrinsics.checkNotNull($i$f$getLayoutOLwlOKw);
                androidx.compose.ui.node.NodeCoordinator nodeCoordinator = $i$f$getLayoutOLwlOKw;
                (LayoutModifierNodeCoordinator)$i$f$getLayoutOLwlOKw.setLayoutModifierNode$ui_release((LayoutModifierNode)this);
                $i$f$getLayoutOLwlOKw.onLayoutModifierNodeChanged();
            }
            if (!duringAttach) {
                LayoutModifierNodeKt.invalidateLayer((LayoutModifierNode)this);
                DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).invalidateMeasurements$ui_release();
            }
        }
        if (value$iv instanceof RemeasurementModifier) {
            (RemeasurementModifier)value$iv.onRemeasurementAvailable((Remeasurement)DelegatableNodeKt.requireLayoutNode((DelegatableNode)this));
        }
        int i9 = 0;
        anon2 = 0;
        isChainUpdate3 = kindSet$ui_release4 &= $i$f$getLayoutAwareOLwlOKw != 0 ? i32 : i2;
        if (isChainUpdate3 != 0 && value$iv instanceof OnRemeasuredModifier && BackwardsCompatNodeKt.access$isChainUpdate(this)) {
            if (value$iv instanceof OnRemeasuredModifier) {
                if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                    DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).invalidateMeasurements$ui_release();
                }
            }
            this.lastOnPlacedCoordinates = 0;
            if (value$iv instanceof OnPlacedModifier && BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                this.lastOnPlacedCoordinates = 0;
                if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                    anon2 = new BackwardsCompatNode.initializeModifier.3(this);
                    DelegatableNodeKt.requireOwner((DelegatableNode)this).registerOnLayoutCompletedListener((Owner.OnLayoutCompletedListener)anon2);
                }
            }
        }
        int i10 = 0;
        int i21 = 0;
        this_$iv3 = kindSet$ui_release5 &= $i$f$getGlobalPositionAwareOLwlOKw != 0 ? i32 : i2;
        if (this_$iv3 != 0 && value$iv instanceof OnGloballyPositionedModifier && BackwardsCompatNodeKt.access$isChainUpdate(this)) {
            if (value$iv instanceof OnGloballyPositionedModifier) {
                if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                    DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).invalidateMeasurements$ui_release();
                }
            }
        }
        if (value$iv instanceof FocusRequesterModifier) {
            $i$f$getGlobalPositionAwareOLwlOKw = 0;
            (FocusRequesterModifier)value$iv.getFocusRequester().getFocusRequesterNodes$ui_release().add(this);
        }
        int i11 = 0;
        int i23 = 0;
        this_$iv5 = kindSet$ui_release6 &= $i$f$getPointerInputOLwlOKw != 0 ? i32 : i2;
        if (this_$iv5 != 0 && value$iv instanceof PointerInputModifier) {
            if (value$iv instanceof PointerInputModifier) {
                (PointerInputModifier)value$iv.getPointerInputFilter().setLayoutCoordinates$ui_release((LayoutCoordinates)getCoordinator$ui_release());
            }
        }
        int i12 = 0;
        int i25 = 0;
        if (kindSet$ui_release7 &= $i$f$getSemanticsOLwlOKw != 0) {
            i2 = i32;
        }
        if (i2 != 0) {
            DelegatableNodeKt.requireOwner((DelegatableNode)this).onSemanticsChange();
        }
    }

    private final void unInitializeModifier() {
        int this_$iv;
        boolean modifierLocalManager;
        Object requireOwner;
        boolean focusRequesterNodes$ui_release;
        String $i$a$CheckPreconditionBackwardsCompatNode$unInitializeModifier$1;
        int $i$f$getLocalsOLwlOKw;
        int $i$f$getSemanticsOLwlOKw;
        int i;
        int i2 = 0;
        if (!isAttached()) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("unInitializeModifier called on unattached node");
        }
        Modifier.Element value$iv = this.element;
        int i4 = 0;
        int i7 = 0;
        final int i12 = 0;
        this_$iv = kindSet$ui_release &= $i$f$getLocalsOLwlOKw != 0 ? i : i12;
        if (this_$iv != 0 && value$iv instanceof ModifierLocalProvider != null) {
            if (value$iv instanceof ModifierLocalProvider != null) {
                DelegatableNodeKt.requireOwner((DelegatableNode)this).getModifierLocalManager().removedProvider(this, (ModifierLocal)(ModifierLocalProvider)value$iv.getKey());
            }
            if (value$iv instanceof ModifierLocalConsumer) {
                (ModifierLocalConsumer)value$iv.onModifierLocalsUpdated((ModifierLocalReadScope)BackwardsCompatNodeKt.access$getDetachedModifierLocalReadScope$p());
            }
        }
        int i5 = 0;
        int i9 = 0;
        if (kindSet$ui_release2 &= $i$f$getSemanticsOLwlOKw != 0) {
        } else {
            i = i12;
        }
        if (i != 0) {
            DelegatableNodeKt.requireOwner((DelegatableNode)this).onSemanticsChange();
        }
        if (value$iv instanceof FocusRequesterModifier) {
            $i$f$getSemanticsOLwlOKw = 0;
            (FocusRequesterModifier)value$iv.getFocusRequester().getFocusRequesterNodes$ui_release().remove(this);
        }
    }

    private final void updateDrawCache() {
        boolean snapshotObserver;
        Object obj;
        kotlin.jvm.functions.Function1 function1;
        androidx.compose.ui.node.BackwardsCompatNode.updateDrawCache.1 anon;
        final Modifier.Element element = this.element;
        if (element instanceof DrawCacheModifier) {
            anon = new BackwardsCompatNode.updateDrawCache.1(element, this);
            DelegatableNodeKt.requireOwner((DelegatableNode)this).getSnapshotObserver().observeReads$ui_release((OwnerScope)this, BackwardsCompatNodeKt.access$getOnDrawCacheReadsChanged$p(), (Function0)anon);
        }
        this.invalidateCache = false;
    }

    private final void updateModifierLocalProvider(ModifierLocalProvider<?> element) {
        boolean contains$ui_release;
        boolean modifierLocalManager;
        Object modifierLocalManager2;
        androidx.compose.ui.modifier.ProvidableModifierLocal key;
        final BackwardsCompatLocalMap _providedValues = this._providedValues;
        if (_providedValues != null && _providedValues.contains$ui_release((ModifierLocal)element.getKey())) {
            if (_providedValues.contains$ui_release((ModifierLocal)element.getKey())) {
                _providedValues.setElement(element);
                DelegatableNodeKt.requireOwner((DelegatableNode)this).getModifierLocalManager().updatedProvider(this, (ModifierLocal)element.getKey());
            } else {
                BackwardsCompatLocalMap backwardsCompatLocalMap = new BackwardsCompatLocalMap(element);
                this._providedValues = backwardsCompatLocalMap;
                if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                    DelegatableNodeKt.requireOwner((DelegatableNode)this).getModifierLocalManager().insertedProvider(this, (ModifierLocal)element.getKey());
                }
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applyFocusProperties(FocusProperties focusProperties) {
        String $i$a$CheckPreconditionBackwardsCompatNode$applyFocusProperties$1;
        final Modifier.Element element = this.element;
        int i = 0;
        if (!element instanceof FocusOrderModifier) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("applyFocusProperties called on wrong node");
        }
        FocusOrder focusOrder = new FocusOrder(focusProperties);
        (FocusOrderModifier)element.populateFocusOrder(focusOrder);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        Intrinsics.checkNotNull($this$applySemantics, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        (SemanticsConfiguration)$this$applySemantics.collapsePeer$ui_release((SemanticsModifier)element.getSemanticsConfiguration());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        boolean invalidateCache;
        final Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        final int i = 0;
        if (this.invalidateCache && element instanceof DrawCacheModifier) {
            if (element instanceof DrawCacheModifier) {
                updateDrawCache();
            }
        }
        (DrawModifier)element.draw($this$draw);
    }

    public <T> T getCurrent(ModifierLocal<T> $this$current) {
        Object stack$iv$iv;
        int node$iv$iv2;
        Modifier.Node tail$ui_release;
        Object key;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        Object count$iv$iv;
        int count$iv$iv2;
        Modifier.Node node$iv$iv5;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i8;
        int i3;
        Modifier.Node node;
        int i4;
        int node$iv$iv4;
        int node$iv$iv3;
        Object obj;
        Modifier.Node node$iv$iv6;
        Modifier.Node node3;
        int i6;
        Object key2;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i2;
        int this_$iv$iv$iv;
        int i5;
        int i;
        Modifier.Node node$iv$iv;
        int i9;
        int i7;
        stack$iv$iv = this;
        key = $this$current;
        stack$iv$iv.readValues.add(key);
        int i12 = 0;
        int $i$f$getLocalsOLwlOKw = NodeKind.constructor-impl(32);
        int i14 = 0;
        final int i15 = 0;
        final int i16 = $i$f$getLocalsOLwlOKw;
        final Object obj3 = count$iv$iv;
        final int i17 = 0;
        if (!obj3.getNode().isAttached()) {
        } else {
            node$iv$iv5 = obj3.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(obj3);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i16 != 0) {
                } else {
                }
                key2 = key;
                obj = count$iv$iv;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                stack$iv$iv = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && stack$iv$iv != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv5 = tail$ui_release;
                stack$iv$iv = this;
                count$iv$iv = obj;
                key = key2;
                stack$iv$iv = layout$iv$iv.getNodes$ui_release();
                if (stack$iv$iv != null) {
                } else {
                }
                tail$ui_release = stack$iv$iv.getTail$ui_release();
                while (node$iv$iv5 != null) {
                    if (kindSet$ui_release &= i16 == 0) {
                        break loop_4;
                    } else {
                    }
                    key2 = key;
                    obj = count$iv$iv;
                    node$iv$iv5 = node$iv$iv5.getParent$ui_release();
                    stack$iv$iv = this;
                    count$iv$iv = obj;
                    key = key2;
                    i3 = 0;
                    i4 = 0;
                    node$iv$iv4 = 0;
                    int i18 = 0;
                    stack$iv$iv = node$iv$iv6;
                    while (stack$iv$iv != null) {
                        node$iv$iv6 = count$iv$iv;
                        node3 = 0;
                        if (kindSet$ui_release2 &= $i$f$getLocalsOLwlOKw != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv4);
                        count$iv$iv = node$iv$iv6;
                        key = key2;
                        if (stack$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        i6 = 0;
                        node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i2 = 0;
                            i5 = 0;
                            if (kindSet$ui_release3 &= $i$f$getLocalsOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            node$iv$iv = stack$iv$iv;
                            next$iv$iv = node2;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            key = 1;
                            count$iv$iv2++;
                            if (count$iv$iv2 == key) {
                            } else {
                            }
                            if (node$iv$iv4 == 0) {
                            } else {
                            }
                            node$iv$iv = stack$iv$iv;
                            i9 = count$iv$iv2;
                            capacity$iv$iv$iv$iv = 0;
                            node$iv$iv2 = node$iv$iv4;
                            Modifier.Node node5 = node$iv$iv;
                            if (node5 != null) {
                            } else {
                            }
                            node$iv$iv3 = node$iv$iv;
                            if (node$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv = node2;
                            node$iv$iv4 = node$iv$iv2;
                            stack$iv$iv = theNode$iv$iv;
                            count$iv$iv2 = i9;
                            node$iv$iv2.add(node2);
                            if (node$iv$iv2 != 0) {
                            }
                            node$iv$iv3 = 0;
                            node$iv$iv2.add(node5);
                            this_$iv$iv$iv = 0;
                            int i11 = 16;
                            i = 0;
                            node$iv$iv = stack$iv$iv;
                            i9 = count$iv$iv2;
                            i7 = i11;
                            node$iv$iv2 = new MutableVector(new Modifier.Node[i11], 0);
                            stack$iv$iv = node2;
                            next$iv$iv = node2;
                            this_$iv$iv$iv = key;
                        }
                        node$iv$iv = stack$iv$iv;
                        if (count$iv$iv2 == 1) {
                        } else {
                        }
                        stack$iv$iv = node$iv$iv;
                        count$iv$iv = node$iv$iv6;
                        key = key2;
                        stack$iv$iv = node$iv$iv;
                        node2 = node$iv$iv$iv;
                        i2 = 0;
                        i5 = 0;
                        if (kindSet$ui_release3 &= $i$f$getLocalsOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node$iv$iv = stack$iv$iv;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        key = 1;
                        count$iv$iv2++;
                        if (count$iv$iv2 == key) {
                        } else {
                        }
                        if (node$iv$iv4 == 0) {
                        } else {
                        }
                        node$iv$iv = stack$iv$iv;
                        i9 = count$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv2 = node$iv$iv4;
                        node5 = node$iv$iv;
                        if (node5 != null) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv;
                        if (node$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        node$iv$iv4 = node$iv$iv2;
                        stack$iv$iv = theNode$iv$iv;
                        count$iv$iv2 = i9;
                        node$iv$iv2.add(node2);
                        if (node$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = 0;
                        node$iv$iv2.add(node5);
                        this_$iv$iv$iv = 0;
                        i11 = 16;
                        i = 0;
                        node$iv$iv = stack$iv$iv;
                        i9 = count$iv$iv2;
                        i7 = i11;
                        node$iv$iv2 = new MutableVector(new Modifier.Node[i11], 0);
                        stack$iv$iv = node2;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = key;
                        count$iv$iv2 = key;
                        node3 = 0;
                        i6 = node6;
                        key2 = key;
                    }
                    key2 = key;
                    obj = count$iv$iv;
                    node$iv$iv6 = count$iv$iv;
                    node3 = 0;
                    if (kindSet$ui_release2 &= $i$f$getLocalsOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv4);
                    count$iv$iv = node$iv$iv6;
                    key = key2;
                    if (stack$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    i6 = 0;
                    node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i2 = 0;
                        i5 = 0;
                        if (kindSet$ui_release3 &= $i$f$getLocalsOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node$iv$iv = stack$iv$iv;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        key = 1;
                        count$iv$iv2++;
                        if (count$iv$iv2 == key) {
                        } else {
                        }
                        if (node$iv$iv4 == 0) {
                        } else {
                        }
                        node$iv$iv = stack$iv$iv;
                        i9 = count$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv2 = node$iv$iv4;
                        node5 = node$iv$iv;
                        if (node5 != null) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv;
                        if (node$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        node$iv$iv4 = node$iv$iv2;
                        stack$iv$iv = theNode$iv$iv;
                        count$iv$iv2 = i9;
                        node$iv$iv2.add(node2);
                        if (node$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = 0;
                        node$iv$iv2.add(node5);
                        this_$iv$iv$iv = 0;
                        i11 = 16;
                        i = 0;
                        node$iv$iv = stack$iv$iv;
                        i9 = count$iv$iv2;
                        i7 = i11;
                        node$iv$iv2 = new MutableVector(new Modifier.Node[i11], 0);
                        stack$iv$iv = node2;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = key;
                    }
                    node$iv$iv = stack$iv$iv;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    stack$iv$iv = node$iv$iv;
                    count$iv$iv = node$iv$iv6;
                    key = key2;
                    stack$iv$iv = node$iv$iv;
                    node2 = node$iv$iv$iv;
                    i2 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= $i$f$getLocalsOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node$iv$iv = stack$iv$iv;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    key = 1;
                    count$iv$iv2++;
                    if (count$iv$iv2 == key) {
                    } else {
                    }
                    if (node$iv$iv4 == 0) {
                    } else {
                    }
                    node$iv$iv = stack$iv$iv;
                    i9 = count$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv2 = node$iv$iv4;
                    node5 = node$iv$iv;
                    if (node5 != null) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv;
                    if (node$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    node$iv$iv4 = node$iv$iv2;
                    stack$iv$iv = theNode$iv$iv;
                    count$iv$iv2 = i9;
                    node$iv$iv2.add(node2);
                    if (node$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = 0;
                    node$iv$iv2.add(node5);
                    this_$iv$iv$iv = 0;
                    i11 = 16;
                    i = 0;
                    node$iv$iv = stack$iv$iv;
                    i9 = count$iv$iv2;
                    i7 = i11;
                    node$iv$iv2 = new MutableVector(new Modifier.Node[i11], 0);
                    stack$iv$iv = node2;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = key;
                    count$iv$iv2 = key;
                    node3 = 0;
                    i6 = node6;
                    key2 = key;
                }
                key2 = key;
                obj = count$iv$iv;
                if (kindSet$ui_release &= i16 != 0) {
                } else {
                }
                key2 = key;
                obj = count$iv$iv;
                node$iv$iv5 = node$iv$iv5.getParent$ui_release();
                stack$iv$iv = this;
                count$iv$iv = obj;
                key = key2;
                i3 = 0;
                i4 = 0;
                node$iv$iv4 = 0;
                i18 = 0;
                stack$iv$iv = node$iv$iv6;
                while (stack$iv$iv != null) {
                    node$iv$iv6 = count$iv$iv;
                    node3 = 0;
                    if (kindSet$ui_release2 &= $i$f$getLocalsOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv4);
                    count$iv$iv = node$iv$iv6;
                    key = key2;
                    if (stack$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    i6 = 0;
                    node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i2 = 0;
                        i5 = 0;
                        if (kindSet$ui_release3 &= $i$f$getLocalsOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node$iv$iv = stack$iv$iv;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        key = 1;
                        count$iv$iv2++;
                        if (count$iv$iv2 == key) {
                        } else {
                        }
                        if (node$iv$iv4 == 0) {
                        } else {
                        }
                        node$iv$iv = stack$iv$iv;
                        i9 = count$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv2 = node$iv$iv4;
                        node5 = node$iv$iv;
                        if (node5 != null) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv;
                        if (node$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        node$iv$iv4 = node$iv$iv2;
                        stack$iv$iv = theNode$iv$iv;
                        count$iv$iv2 = i9;
                        node$iv$iv2.add(node2);
                        if (node$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = 0;
                        node$iv$iv2.add(node5);
                        this_$iv$iv$iv = 0;
                        i11 = 16;
                        i = 0;
                        node$iv$iv = stack$iv$iv;
                        i9 = count$iv$iv2;
                        i7 = i11;
                        node$iv$iv2 = new MutableVector(new Modifier.Node[i11], 0);
                        stack$iv$iv = node2;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = key;
                    }
                    node$iv$iv = stack$iv$iv;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    stack$iv$iv = node$iv$iv;
                    count$iv$iv = node$iv$iv6;
                    key = key2;
                    stack$iv$iv = node$iv$iv;
                    node2 = node$iv$iv$iv;
                    i2 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= $i$f$getLocalsOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node$iv$iv = stack$iv$iv;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    key = 1;
                    count$iv$iv2++;
                    if (count$iv$iv2 == key) {
                    } else {
                    }
                    if (node$iv$iv4 == 0) {
                    } else {
                    }
                    node$iv$iv = stack$iv$iv;
                    i9 = count$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv2 = node$iv$iv4;
                    node5 = node$iv$iv;
                    if (node5 != null) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv;
                    if (node$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    node$iv$iv4 = node$iv$iv2;
                    stack$iv$iv = theNode$iv$iv;
                    count$iv$iv2 = i9;
                    node$iv$iv2.add(node2);
                    if (node$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = 0;
                    node$iv$iv2.add(node5);
                    this_$iv$iv$iv = 0;
                    i11 = 16;
                    i = 0;
                    node$iv$iv = stack$iv$iv;
                    i9 = count$iv$iv2;
                    i7 = i11;
                    node$iv$iv2 = new MutableVector(new Modifier.Node[i11], 0);
                    stack$iv$iv = node2;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = key;
                    count$iv$iv2 = key;
                    node3 = 0;
                    i6 = node6;
                    key2 = key;
                }
                key2 = key;
                obj = count$iv$iv;
                node$iv$iv6 = count$iv$iv;
                node3 = 0;
                if (kindSet$ui_release2 &= $i$f$getLocalsOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                } else {
                }
                stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv4);
                count$iv$iv = node$iv$iv6;
                key = key2;
                if (stack$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                i6 = 0;
                node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i2 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= $i$f$getLocalsOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node$iv$iv = stack$iv$iv;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    key = 1;
                    count$iv$iv2++;
                    if (count$iv$iv2 == key) {
                    } else {
                    }
                    if (node$iv$iv4 == 0) {
                    } else {
                    }
                    node$iv$iv = stack$iv$iv;
                    i9 = count$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv2 = node$iv$iv4;
                    node5 = node$iv$iv;
                    if (node5 != null) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv;
                    if (node$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    node$iv$iv4 = node$iv$iv2;
                    stack$iv$iv = theNode$iv$iv;
                    count$iv$iv2 = i9;
                    node$iv$iv2.add(node2);
                    if (node$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = 0;
                    node$iv$iv2.add(node5);
                    this_$iv$iv$iv = 0;
                    i11 = 16;
                    i = 0;
                    node$iv$iv = stack$iv$iv;
                    i9 = count$iv$iv2;
                    i7 = i11;
                    node$iv$iv2 = new MutableVector(new Modifier.Node[i11], 0);
                    stack$iv$iv = node2;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = key;
                }
                node$iv$iv = stack$iv$iv;
                if (count$iv$iv2 == 1) {
                } else {
                }
                stack$iv$iv = node$iv$iv;
                count$iv$iv = node$iv$iv6;
                key = key2;
                stack$iv$iv = node$iv$iv;
                node2 = node$iv$iv$iv;
                i2 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= $i$f$getLocalsOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                node$iv$iv = stack$iv$iv;
                next$iv$iv = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                key = 1;
                count$iv$iv2++;
                if (count$iv$iv2 == key) {
                } else {
                }
                if (node$iv$iv4 == 0) {
                } else {
                }
                node$iv$iv = stack$iv$iv;
                i9 = count$iv$iv2;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv2 = node$iv$iv4;
                node5 = node$iv$iv;
                if (node5 != null) {
                } else {
                }
                node$iv$iv3 = node$iv$iv;
                if (node$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = node2;
                node$iv$iv4 = node$iv$iv2;
                stack$iv$iv = theNode$iv$iv;
                count$iv$iv2 = i9;
                node$iv$iv2.add(node2);
                if (node$iv$iv2 != 0) {
                }
                node$iv$iv3 = 0;
                node$iv$iv2.add(node5);
                this_$iv$iv$iv = 0;
                i11 = 16;
                i = 0;
                node$iv$iv = stack$iv$iv;
                i9 = count$iv$iv2;
                i7 = i11;
                node$iv$iv2 = new MutableVector(new Modifier.Node[i11], 0);
                stack$iv$iv = node2;
                next$iv$iv = node2;
                this_$iv$iv$iv = key;
                count$iv$iv2 = key;
                node3 = 0;
                i6 = node6;
                key2 = key;
            }
            return key.getDefaultFactory$ui_release().invoke();
        }
        Object key4 = key;
        int i10 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getDensity();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Modifier.Element getElement() {
        return this.element;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getLayoutDirection();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public ModifierLocalMap getProvidedValues() {
        ModifierLocalMap modifierLocalMapOf;
        if (this._providedValues != null) {
        } else {
            modifierLocalMapOf = ModifierLocalModifierNodeKt.modifierLocalMapOf();
        }
        return modifierLocalMapOf;
    }

    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public long getSize-NH-jbRc() {
        int i = 0;
        int $i$f$getLayoutAwareOLwlOKw = NodeKind.constructor-impl(128);
        return IntSizeKt.toSize-ozmzZPI(DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)this, $i$f$getLayoutAwareOLwlOKw).getSize-YbymL2g());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean interceptOutOfBoundsChildEvents() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        int i = 0;
        return (PointerInputModifier)element.getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        int i = 0;
        return (LayoutModifier)element.maxIntrinsicHeight($this$maxIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        int i = 0;
        return (LayoutModifier)element.maxIntrinsicWidth($this$maxIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        int i = 0;
        return (LayoutModifier)element.measure-3p2s80s($this$measure_u2d3p2s80s, measurable, constraints);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        int i = 0;
        return (LayoutModifier)element.minIntrinsicHeight($this$minIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        int i = 0;
        return (LayoutModifier)element.minIntrinsicWidth($this$minIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        int i = 0;
        return (ParentDataModifier)element.modifyParentData($this$modifyParentData, parentData);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        initializeModifier(true);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onCancelPointerInput() {
        final Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        int i = 0;
        (PointerInputModifier)element.getPointerInputFilter().onCancel();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        unInitializeModifier();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onFocusEvent(FocusState focusState) {
        String $i$a$CheckPreconditionBackwardsCompatNode$onFocusEvent$1;
        final Modifier.Element element = this.element;
        final int i = 0;
        if (!element instanceof FocusEventModifier) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("onFocusEvent called on wrong node");
        }
        (FocusEventModifier)element.onFocusEvent(focusState);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        final Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        (OnGloballyPositionedModifier)element.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onPlaced(LayoutCoordinates coordinates) {
        boolean z;
        this.lastOnPlacedCoordinates = coordinates;
        final Modifier.Element element = this.element;
        if (element instanceof OnPlacedModifier) {
            (OnPlacedModifier)element.onPlaced(coordinates);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        final Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        int i = 0;
        (PointerInputModifier)element.getPointerInputFilter().onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onRemeasured-ozmzZPI(long size) {
        boolean z;
        final Modifier.Element element = this.element;
        if (element instanceof OnRemeasuredModifier) {
            (OnRemeasuredModifier)element.onRemeasured-ozmzZPI(size);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setElement(Modifier.Element value) {
        boolean attached;
        if (isAttached()) {
            unInitializeModifier();
        }
        this.element = value;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(value));
        if (isAttached()) {
            initializeModifier(false);
        }
    }

    public final void setReadValues(HashSet<ModifierLocal<?>> <set-?>) {
        this.readValues = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean sharePointerInputWithSiblings() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        int i = 0;
        return (PointerInputModifier)element.getPointerInputFilter().getShareWithSiblings();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public String toString() {
        return this.element.toString();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void updateModifierLocalConsumer() {
        boolean snapshotObserver;
        Object obj;
        kotlin.jvm.functions.Function1 function1;
        androidx.compose.ui.node.BackwardsCompatNode.updateModifierLocalConsumer.1 anon;
        if (isAttached()) {
            this.readValues.clear();
            anon = new BackwardsCompatNode.updateModifierLocalConsumer.1(this);
            DelegatableNodeKt.requireOwner((DelegatableNode)this).getSnapshotObserver().observeReads$ui_release((OwnerScope)this, BackwardsCompatNodeKt.access$getUpdateModifierLocalConsumer$p(), (Function0)anon);
        }
    }
}
