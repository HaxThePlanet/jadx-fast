package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.DpSize.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0099\u0001\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n\u0012\u001b\u0008\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0008\n\u0012\u0016\u0008\u0002\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0008\u0010R\u001a\u00020\u000eH\u0016J\u0008\u0010S\u001a\u00020\u000eH\u0016J\u0010\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020/H\u0016J\u0008\u0010V\u001a\u00020\u000eH\u0016J\u0008\u0010W\u001a\u00020\u000eH\u0002J\u0092\u0001\u0010X\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n2\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0008\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0014\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010ZJ\u0008\u0010[\u001a\u00020\u000eH\u0002J\u0008\u0010\\\u001a\u00020\u000eH\u0002J\u000c\u0010]\u001a\u00020\u000e*\u00020^H\u0016J\u000c\u0010_\u001a\u00020\u000e*\u00020`H\u0016R\u001a\u0010\u001b\u001a\u00020\t8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\"\u0010\u0014\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\u0008,\u0010%\"\u0004\u0008-\u0010'R/\u00100\u001a\u0004\u0018\u00010/2\u0008\u0010.\u001a\u0004\u0018\u00010/8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u00085\u00106\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0008\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00089\u0010:\"\u0004\u0008;\u0010<R(\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010:\"\u0004\u0008>\u0010<R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u0010@\"\u0004\u0008A\u0010BR\u0016\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u00020\rX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\u0008E\u0010\u001d\"\u0004\u0008F\u0010GR+\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010:\"\u0004\u0008J\u0010<R\u0016\u0010K\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010HR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008L\u0010!\"\u0004\u0008M\u0010#R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008P\u0010%\"\u0004\u0008Q\u0010'\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006a", d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "()J", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "getClippingEnabled", "()Z", "setClippingEnabled", "(Z)V", "getCornerRadius-D9Ej5fM", "()F", "setCornerRadius-0680j_4", "(F)V", "F", "density", "drawSignalChannel", "Lkotlinx/coroutines/channels/Channel;", "getElevation-D9Ej5fM", "setElevation-0680j_4", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "getMagnifierCenter", "()Lkotlin/jvm/functions/Function1;", "setMagnifierCenter", "(Lkotlin/jvm/functions/Function1;)V", "getOnSizeChanged", "setOnSizeChanged", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "getSize-MYxV2XQ", "setSize-EaSLcWc", "(J)V", "J", "getSourceCenter", "setSourceCenter", "sourceCenterInRoot", "getUseTextDefault", "setUseTextDefault", "view", "Landroid/view/View;", "getZoom", "setZoom", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "onObservedReadsChanged", "recreateMagnifier", "update", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "updateMagnifier", "updateSizeIfNecessary", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {

    public static final int $stable = 8;
    private State<Offset> anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    private Channel<Unit> drawSignalChannel;
    private float elevation;
    private final MutableState layoutCoordinates$delegate;
    private androidx.compose.foundation.PlatformMagnifier magnifier;
    private Function1<? super Density, Offset> magnifierCenter;
    private Function1<? super DpSize, Unit> onSizeChanged;
    private androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1<? super Density, Offset> sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;
    static {
        final int i = 8;
    }

    private MagnifierNode(Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, Function1<? super DpSize, Unit> onSizeChanged, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory) {
        super();
        this.sourceCenter = sourceCenter;
        this.magnifierCenter = magnifierCenter;
        this.onSizeChanged = onSizeChanged;
        this.zoom = zoom;
        this.useTextDefault = useTextDefault;
        this.size = size;
        this.cornerRadius = elevation;
        this.elevation = clippingEnabled;
        this.clippingEnabled = platformMagnifierFactory;
        this.platformMagnifierFactory = obj13;
        this.layoutCoordinates$delegate = SnapshotStateKt.mutableStateOf(0, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.Companion.getUnspecified-F1C5BW0();
    }

    public MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f4, boolean z5, long l6, float f7, float f8, boolean z9, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory10, int i11, DefaultConstructorMarker defaultConstructorMarker12) {
        androidx.compose.foundation.PlatformMagnifierFactory forCurrentPlatform;
        int i6;
        int i2;
        int unspecified-MYxV2XQ;
        int unspecified-D9Ej5fM;
        int unspecified-D9Ej5fM2;
        int i7;
        int i5;
        int i3;
        int i;
        int i8;
        long l;
        float f2;
        float f;
        int i4;
        androidx.compose.foundation.PlatformMagnifierFactory factory;
        int i9 = defaultConstructorMarker12;
        final int i13 = 0;
        i5 = i9 & 2 != 0 ? i13 : function12;
        i3 = i9 & 4 != 0 ? i13 : function13;
        i = i9 & 8 != 0 ? i6 : f4;
        i8 = i9 & 16 != 0 ? i2 : z5;
        if (i9 & 32 != 0) {
            l = unspecified-MYxV2XQ;
        } else {
            l = l6;
        }
        if (i9 & 64 != 0) {
            f2 = unspecified-D9Ej5fM;
        } else {
            f2 = f8;
        }
        if (i9 & 128 != 0) {
            f = unspecified-D9Ej5fM2;
        } else {
            f = z9;
        }
        i4 = i9 & 256 != 0 ? i7 : platformMagnifierFactory10;
        if (i9 &= 512 != 0) {
            factory = forCurrentPlatform;
        } else {
            factory = i11;
        }
        super(function1, i5, i3, i, i8, l, obj10, f2, f, i4, factory, 0);
    }

    public MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f4, boolean z5, long l6, float f7, float f8, boolean z9, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(function1, function12, function13, f4, z5, l6, f7, f8, z9, platformMagnifierFactory10, defaultConstructorMarker11);
    }

    public static final Channel access$getDrawSignalChannel$p(androidx.compose.foundation.MagnifierNode $this) {
        return $this.drawSignalChannel;
    }

    public static final LayoutCoordinates access$getLayoutCoordinates(androidx.compose.foundation.MagnifierNode $this) {
        return $this.getLayoutCoordinates();
    }

    public static final androidx.compose.foundation.PlatformMagnifier access$getMagnifier$p(androidx.compose.foundation.MagnifierNode $this) {
        return $this.magnifier;
    }

    public static final long access$getSourceCenterInRoot$p(androidx.compose.foundation.MagnifierNode $this) {
        return $this.sourceCenterInRoot;
    }

    public static final void access$updateMagnifier(androidx.compose.foundation.MagnifierNode $this) {
        $this.updateMagnifier();
    }

    private final long getAnchorPositionInRoot-F1C5BW0() {
        State anchorPositionInRootState;
        long unbox-impl;
        if (this.anchorPositionInRootState == null) {
            MagnifierNode.anchorPositionInRoot.1 anon = new MagnifierNode.anchorPositionInRoot.1(this);
            this.anchorPositionInRootState = SnapshotStateKt.derivedStateOf((Function0)anon);
        }
        State anchorPositionInRootState2 = this.anchorPositionInRootState;
        if (anchorPositionInRootState2 != null) {
            unbox-impl = (Offset)anchorPositionInRootState2.getValue().unbox-impl();
        } else {
            unbox-impl = Offset.Companion.getUnspecified-F1C5BW0();
        }
        return unbox-impl;
    }

    private final LayoutCoordinates getLayoutCoordinates() {
        final int i = 0;
        final int i2 = 0;
        return (LayoutCoordinates)(State)this.layoutCoordinates$delegate.getValue();
    }

    private final void recreateMagnifier() {
        View requireView;
        Density requireDensity;
        androidx.compose.foundation.PlatformMagnifier magnifier = this.magnifier;
        if (magnifier != null) {
            magnifier.dismiss();
        }
        if (this.view == null) {
            requireView = DelegatableNode_androidKt.requireView((DelegatableNode)this);
        }
        final int i2 = 0;
        this.view = requireView;
        if (this.density == null) {
            requireDensity = DelegatableNodeKt.requireDensity((DelegatableNode)this);
        }
        final Density density2 = requireDensity;
        int i = 0;
        this.density = density2;
        this.magnifier = this.platformMagnifierFactory.create-nHHXs2Y(requireView, this.useTextDefault, this.size, obj7, this.cornerRadius, this.elevation, this.clippingEnabled, density2);
        updateSizeIfNecessary();
    }

    private final void setLayoutCoordinates(LayoutCoordinates <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.layoutCoordinates$delegate.setValue(<set-?>);
    }

    private final void updateMagnifier() {
        Density requireDensity;
        Density density;
        int i;
        long it2;
        Object magnifierCenter;
        boolean specified-k-4lQ0M;
        long it;
        long l;
        int sourceCenterInRoot;
        float zoom;
        if (this.density == null) {
            i = 0;
            this.density = DelegatableNodeKt.requireDensity((DelegatableNode)this);
        }
        long unbox-impl = (Offset)this.sourceCenter.invoke(requireDensity).unbox-impl();
        if (OffsetKt.isSpecified-k-4lQ0M(unbox-impl) && OffsetKt.isSpecified-k-4lQ0M(getAnchorPositionInRoot-F1C5BW0())) {
            if (OffsetKt.isSpecified-k-4lQ0M(getAnchorPositionInRoot-F1C5BW0())) {
                this.sourceCenterInRoot = Offset.plus-MK-Hz9U(getAnchorPositionInRoot-F1C5BW0(), obj4);
                magnifierCenter = this.magnifierCenter;
                if (magnifierCenter != null) {
                    sourceCenterInRoot = 0;
                    it = OffsetKt.isSpecified-k-4lQ0M(Offset.box-impl((Offset)magnifierCenter.invoke(requireDensity).unbox-impl()).unbox-impl());
                    if (it) {
                    } else {
                        magnifierCenter = 0;
                    }
                    if (magnifierCenter != null) {
                        l = 0;
                        it2 = Offset.plus-MK-Hz9U(getAnchorPositionInRoot-F1C5BW0(), obj7);
                    } else {
                        it2 = Offset.Companion.getUnspecified-F1C5BW0();
                    }
                } else {
                }
                if (this.magnifier == null) {
                    recreateMagnifier();
                }
                androidx.compose.foundation.PlatformMagnifier magnifier3 = this.magnifier;
                if (magnifier3 != null) {
                    magnifier3.update-Wko1d7g(this.sourceCenterInRoot, obj7, it2);
                }
                updateSizeIfNecessary();
            }
        }
        this.sourceCenterInRoot = Offset.Companion.getUnspecified-F1C5BW0();
        androidx.compose.foundation.PlatformMagnifier magnifier2 = this.magnifier;
        if (magnifier2 != null) {
            magnifier2.dismiss();
        }
    }

    private final void updateSizeIfNecessary() {
        boolean equals-impl;
        long box-impl;
        IntSize previousSize;
        long size-ozmzZPI;
        final androidx.compose.foundation.PlatformMagnifier magnifier = this.magnifier;
        if (magnifier == null) {
        }
        final Density density = this.density;
        if (density == null) {
        }
        Function1 onSizeChanged = this.onSizeChanged;
        if (!IntSize.equals-impl(magnifier.getSize-YbymL2g(), obj3) && onSizeChanged != null) {
            onSizeChanged = this.onSizeChanged;
            if (onSizeChanged != null) {
                onSizeChanged.invoke(DpSize.box-impl(density.toDpSize-k-rfVVM(IntSizeKt.toSize-ozmzZPI(magnifier.getSize-YbymL2g()))));
            }
            this.previousSize = IntSize.box-impl(magnifier.getSize-YbymL2g());
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        MagnifierNode.applySemantics.1 anon = new MagnifierNode.applySemantics.1(this);
        $this$applySemantics.set(Magnifier_androidKt.getMagnifierPositionInRoot(), anon);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        Object drawSignalChannel;
        Unit iNSTANCE;
        $this$draw.drawContent();
        drawSignalChannel = this.drawSignalChannel;
        if (drawSignalChannel != null) {
            ChannelResult.box-impl(drawSignalChannel.trySend-JP2dKIU(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getCornerRadius-D9Ej5fM() {
        return this.cornerRadius;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getElevation-D9Ej5fM() {
        return this.elevation;
    }

    public final Function1<Density, Offset> getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final Function1<DpSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getSize-MYxV2XQ() {
        return this.size;
    }

    public final Function1<Density, Offset> getSourceCenter() {
        return this.sourceCenter;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getZoom() {
        return this.zoom;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        onObservedReadsChanged();
        final int i3 = 0;
        this.drawSignalChannel = ChannelKt.Channel$default(0, i3, i3, 7, i3);
        MagnifierNode.onAttach.1 anon = new MagnifierNode.onAttach.1(this, i3);
        BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        androidx.compose.foundation.PlatformMagnifier magnifier = this.magnifier;
        if (magnifier != null) {
            magnifier.dismiss();
        }
        this.magnifier = 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        setLayoutCoordinates(coordinates);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onObservedReadsChanged() {
        MagnifierNode.onObservedReadsChanged.1 anon = new MagnifierNode.onObservedReadsChanged.1(this);
        ObserverModifierNodeKt.observeReads((Modifier.Node)this, (Function0)anon);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setClippingEnabled(boolean <set-?>) {
        this.clippingEnabled = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setCornerRadius-0680j_4(float <set-?>) {
        this.cornerRadius = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setElevation-0680j_4(float <set-?>) {
        this.elevation = <set-?>;
    }

    public final void setMagnifierCenter(Function1<? super Density, Offset> <set-?>) {
        this.magnifierCenter = <set-?>;
    }

    public final void setOnSizeChanged(Function1<? super DpSize, Unit> <set-?>) {
        this.onSizeChanged = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setPlatformMagnifierFactory(androidx.compose.foundation.PlatformMagnifierFactory <set-?>) {
        this.platformMagnifierFactory = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setSize-EaSLcWc(long <set-?>) {
        this.size = <set-?>;
    }

    public final void setSourceCenter(Function1<? super Density, Offset> <set-?>) {
        this.sourceCenter = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setUseTextDefault(boolean <set-?>) {
        this.useTextDefault = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setZoom(float <set-?>) {
        this.zoom = <set-?>;
    }

    public final void update-5F03MCQ(Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, Function1<? super DpSize, Unit> onSizeChanged, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory) {
        Density previousView2;
        Density view2;
        boolean previousClippingEnabled;
        boolean equalsIncludingNaN;
        boolean equal;
        int previousClippingEnabled2;
        androidx.compose.foundation.PlatformMagnifierFactory previousPlatformMagnifierFactory;
        View previousView;
        View view;
        Object obj = this;
        float f = zoom;
        final boolean z = useTextDefault;
        final long l = size;
        final float f2 = elevation;
        final float f3 = clippingEnabled;
        final boolean z2 = onSizeChanged;
        final androidx.compose.foundation.PlatformMagnifierFactory factory2 = obj33;
        equal = clippingEnabled2;
        final Density density2 = previousView3;
        obj.sourceCenter = sourceCenter;
        obj.magnifierCenter = magnifierCenter;
        obj.zoom = f;
        obj.useTextDefault = z;
        obj.size = l;
        obj.cornerRadius = f2;
        obj.elevation = f3;
        obj.clippingEnabled = z2;
        obj.onSizeChanged = platformMagnifierFactory;
        obj.platformMagnifierFactory = factory2;
        Density density3 = requireDensity;
        if (obj.magnifier != null) {
            if (!Magnifier_androidKt.equalsIncludingNaN(f, obj.zoom)) {
                if (factory2.getCanUpdateZoom()) {
                    if (DpSize.equals-impl0(l, obj4)) {
                        if (Dp.equals-impl0(f2, obj.cornerRadius)) {
                            if (Dp.equals-impl0(f3, obj.elevation)) {
                                if (z == obj.useTextDefault) {
                                    if (z2 == equal) {
                                        androidx.compose.foundation.PlatformMagnifierFactory factory = previousPlatformMagnifierFactory;
                                        if (Intrinsics.areEqual(factory2, factory)) {
                                            previousPlatformMagnifierFactory = factory;
                                            View previousPlatformMagnifierFactory2 = previousView;
                                            View view3 = view;
                                            if (Intrinsics.areEqual(view3, previousPlatformMagnifierFactory2)) {
                                                previousView = previousPlatformMagnifierFactory2;
                                                view = view3;
                                                if (!Intrinsics.areEqual(density3, density2)) {
                                                    previousClippingEnabled2 = 1;
                                                } else {
                                                    previousClippingEnabled2 = 0;
                                                }
                                            } else {
                                                previousView = previousPlatformMagnifierFactory2;
                                                view = view3;
                                                previousView2 = density2;
                                                view2 = density3;
                                            }
                                        } else {
                                            previousPlatformMagnifierFactory = factory;
                                            previousView2 = density2;
                                            view2 = density3;
                                        }
                                    } else {
                                        previousView2 = density2;
                                        view2 = density3;
                                    }
                                } else {
                                    previousClippingEnabled = equal;
                                    previousView2 = density2;
                                    view2 = density3;
                                }
                            } else {
                                previousClippingEnabled = equal;
                                previousView2 = density2;
                                view2 = density3;
                            }
                        } else {
                            previousClippingEnabled = equal;
                            previousView2 = density2;
                            view2 = density3;
                        }
                    } else {
                        previousClippingEnabled = equal;
                        previousView2 = density2;
                        view2 = density3;
                    }
                } else {
                    previousClippingEnabled = equal;
                    previousView2 = density2;
                    view2 = density3;
                }
            } else {
            }
        } else {
            previousClippingEnabled = equal;
            previousView2 = density2;
            view2 = density3;
        }
        if (previousClippingEnabled2 != 0) {
            recreateMagnifier();
        }
        updateMagnifier();
    }
}
