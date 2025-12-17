package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.DpSize.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0097\u0001\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007\u0012\u001b\u0008\u0002\u0010\u0008\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0008\u0007\u0012\u0016\u0008\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0008\u0010\u001a\u001a\u00020\u0002H\u0016J\u0013\u0010\u001b\u001a\u00020\u000f2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\u0008\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u000c\u0010\"\u001a\u00020\u000b*\u00020#H\u0016R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u0012X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0013\u001a\u00020\u0012X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R!\u0010\u0008\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0008\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/foundation/MagnifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MagnifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "J", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MagnifierElement extends ModifierNodeElement<androidx.compose.foundation.MagnifierNode> {

    public static final int $stable;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final Function1<Density, Offset> magnifierCenter;
    private final Function1<DpSize, Unit> onSizeChanged;
    private final androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory;
    private final long size;
    private final Function1<Density, Offset> sourceCenter;
    private final boolean useTextDefault;
    private final float zoom;
    static {
    }

    private MagnifierElement(Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, Function1<? super DpSize, Unit> onSizeChanged, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory) {
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
        this.platformMagnifierFactory = obj11;
    }

    public MagnifierElement(Function1 function1, Function1 function12, Function1 function13, float f4, boolean z5, long l6, float f7, float f8, boolean z9, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory10, int i11, DefaultConstructorMarker defaultConstructorMarker12) {
        int i7;
        int i5;
        int i;
        int unspecified-MYxV2XQ;
        int unspecified-D9Ej5fM2;
        int unspecified-D9Ej5fM;
        int i4;
        int i6;
        int i2;
        int i3;
        long l;
        float f2;
        float f;
        int i8;
        int i9 = defaultConstructorMarker12;
        final int i13 = 0;
        i4 = i9 & 2 != 0 ? i13 : function12;
        i6 = i9 & 4 != 0 ? i13 : function13;
        i2 = i9 & 8 != 0 ? i5 : f4;
        i3 = i9 & 16 != 0 ? i : z5;
        if (i9 & 32 != 0) {
            l = unspecified-MYxV2XQ;
        } else {
            l = l6;
        }
        if (i9 & 64 != 0) {
            f2 = unspecified-D9Ej5fM2;
        } else {
            f2 = f8;
        }
        if (i9 & 128 != 0) {
            f = unspecified-D9Ej5fM;
        } else {
            f = z9;
        }
        i8 = i9 &= 256 != 0 ? i7 : platformMagnifierFactory10;
        super(function1, i4, i6, i2, i3, l, obj10, f2, f, i8, i11, 0);
    }

    public MagnifierElement(Function1 function1, Function1 function12, Function1 function13, float f4, boolean z5, long l6, float f7, float f8, boolean z9, androidx.compose.foundation.PlatformMagnifierFactory platformMagnifierFactory10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(function1, function12, function13, f4, z5, l6, f7, f8, z9, platformMagnifierFactory10, defaultConstructorMarker11);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.MagnifierNode create() {
        MagnifierNode magnifierNode = new MagnifierNode(this.sourceCenter, this.magnifierCenter, this.onSizeChanged, this.zoom, this.useTextDefault, this.size, obj7, this.cornerRadius, this.elevation, this.clippingEnabled, this.platformMagnifierFactory, 0);
        return magnifierNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        final int i2 = 1;
        if (this == other) {
            return i2;
        }
        final int i3 = 0;
        if (!other instanceof MagnifierElement) {
            return i3;
        }
        if (this.sourceCenter != obj2.sourceCenter) {
            return i3;
        }
        if (this.magnifierCenter != obj3.magnifierCenter) {
            return i3;
        }
        i = Float.compare(zoom, zoom2) == 0 ? i2 : i3;
        if (i == 0) {
            return i3;
        }
        if (this.useTextDefault != obj5.useTextDefault) {
            return i3;
        }
        if (!DpSize.equals-impl0(this.size, obj4)) {
            return i3;
        }
        if (!Dp.equals-impl0(this.cornerRadius, obj6.cornerRadius)) {
            return i3;
        }
        if (!Dp.equals-impl0(this.elevation, obj7.elevation)) {
            return i3;
        }
        if (this.clippingEnabled != obj8.clippingEnabled) {
            return i3;
        }
        if (this.onSizeChanged != obj9.onSizeChanged) {
            return i3;
        }
        if (!Intrinsics.areEqual(this.platformMagnifierFactory, obj10.platformMagnifierFactory)) {
            return i3;
        }
        return i2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i2;
        int i;
        Function1 magnifierCenter = this.magnifierCenter;
        if (magnifierCenter != null) {
            i2 = magnifierCenter.hashCode();
        } else {
            i2 = i;
        }
        Function1 onSizeChanged = this.onSizeChanged;
        if (onSizeChanged != null) {
            i = onSizeChanged.hashCode();
        }
        return result8 += i20;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("magnifier");
        $this$inspectableProperties.getProperties().set("sourceCenter", this.sourceCenter);
        $this$inspectableProperties.getProperties().set("magnifierCenter", this.magnifierCenter);
        String str4 = "zoom";
        $this$inspectableProperties.getProperties().set(str4, Float.valueOf(this.zoom));
        $this$inspectableProperties.getProperties().set("size", DpSize.box-impl(this.size));
        $this$inspectableProperties.getProperties().set("cornerRadius", Dp.box-impl(this.cornerRadius));
        $this$inspectableProperties.getProperties().set("elevation", Dp.box-impl(this.elevation));
        $this$inspectableProperties.getProperties().set("clippingEnabled", Boolean.valueOf(this.clippingEnabled));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.MagnifierNode node) {
        node.update-5F03MCQ(this.sourceCenter, this.magnifierCenter, this.zoom, this.useTextDefault, this.size, obj6, this.cornerRadius, this.elevation, this.clippingEnabled, this.onSizeChanged);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((MagnifierNode)node);
    }
}
