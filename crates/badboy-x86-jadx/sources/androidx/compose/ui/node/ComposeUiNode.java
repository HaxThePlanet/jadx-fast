package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008a\u0018\u0000 .2\u00020\u0001:\u0001.R\"\u0010\u0002\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0011X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001dX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u0018\u0010\"\u001a\u00020#X¦\u000e¢\u0006\u000c\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u0018\u0010(\u001a\u00020)X¦\u000e¢\u0006\u000c\u001a\u0004\u0008*\u0010+\"\u0004\u0008,\u0010-ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006/À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/ComposeUiNode;", "", "compositeKeyHash", "", "getCompositeKeyHash$annotations", "()V", "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ComposeUiNode {

    public static final androidx.compose.ui.node.ComposeUiNode.Companion Companion;

    @Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R3\u0010\u0008\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c8GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u000fR(\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR(\u0010\u0013\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u000fR(\u0010\u0016\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u000fR(\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u000fR(\u0010\u001c\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u000fR(\u0010\u001f\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u000fR\u0017\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0007¨\u0006$", d2 = {"Landroidx/compose/ui/node/ComposeUiNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/ComposeUiNode;", "getConstructor", "()Lkotlin/jvm/functions/Function0;", "SetCompositeKeyHash", "Lkotlin/Function2;", "", "", "Lkotlin/ExtensionFunctionType;", "getSetCompositeKeyHash$annotations", "getSetCompositeKeyHash", "()Lkotlin/jvm/functions/Function2;", "SetDensity", "Landroidx/compose/ui/unit/Density;", "getSetDensity", "SetLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getSetLayoutDirection", "SetMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getSetMeasurePolicy", "SetModifier", "Landroidx/compose/ui/Modifier;", "getSetModifier", "SetResolvedCompositionLocals", "Landroidx/compose/runtime/CompositionLocalMap;", "getSetResolvedCompositionLocals", "SetViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getSetViewConfiguration", "VirtualConstructor", "getVirtualConstructor", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.node.ComposeUiNode.Companion $$INSTANCE;
        private static final Function0<androidx.compose.ui.node.ComposeUiNode> Constructor;
        private static final Function2<androidx.compose.ui.node.ComposeUiNode, Integer, Unit> SetCompositeKeyHash;
        private static final Function2<androidx.compose.ui.node.ComposeUiNode, Density, Unit> SetDensity;
        private static final Function2<androidx.compose.ui.node.ComposeUiNode, LayoutDirection, Unit> SetLayoutDirection;
        private static final Function2<androidx.compose.ui.node.ComposeUiNode, MeasurePolicy, Unit> SetMeasurePolicy;
        private static final Function2<androidx.compose.ui.node.ComposeUiNode, Modifier, Unit> SetModifier;
        private static final Function2<androidx.compose.ui.node.ComposeUiNode, CompositionLocalMap, Unit> SetResolvedCompositionLocals;
        private static final Function2<androidx.compose.ui.node.ComposeUiNode, ViewConfiguration, Unit> SetViewConfiguration;
        private static final Function0<androidx.compose.ui.node.ComposeUiNode> VirtualConstructor;
        static {
            ComposeUiNode.Companion companion = new ComposeUiNode.Companion();
            ComposeUiNode.Companion.$$INSTANCE = companion;
            ComposeUiNode.Companion.Constructor = LayoutNode.Companion.getConstructor$ui_release();
            ComposeUiNode.Companion.VirtualConstructor = (Function0)ComposeUiNode.Companion.VirtualConstructor.1.INSTANCE;
            ComposeUiNode.Companion.SetModifier = (Function2)ComposeUiNode.Companion.SetModifier.1.INSTANCE;
            ComposeUiNode.Companion.SetDensity = (Function2)ComposeUiNode.Companion.SetDensity.1.INSTANCE;
            ComposeUiNode.Companion.SetResolvedCompositionLocals = (Function2)ComposeUiNode.Companion.SetResolvedCompositionLocals.1.INSTANCE;
            ComposeUiNode.Companion.SetMeasurePolicy = (Function2)ComposeUiNode.Companion.SetMeasurePolicy.1.INSTANCE;
            ComposeUiNode.Companion.SetLayoutDirection = (Function2)ComposeUiNode.Companion.SetLayoutDirection.1.INSTANCE;
            ComposeUiNode.Companion.SetViewConfiguration = (Function2)ComposeUiNode.Companion.SetViewConfiguration.1.INSTANCE;
            ComposeUiNode.Companion.SetCompositeKeyHash = (Function2)ComposeUiNode.Companion.SetCompositeKeyHash.1.INSTANCE;
        }

        public static void getSetCompositeKeyHash$annotations() {
        }

        public final Function0<androidx.compose.ui.node.ComposeUiNode> getConstructor() {
            return ComposeUiNode.Companion.Constructor;
        }

        public final Function2<androidx.compose.ui.node.ComposeUiNode, Integer, Unit> getSetCompositeKeyHash() {
            return ComposeUiNode.Companion.SetCompositeKeyHash;
        }

        public final Function2<androidx.compose.ui.node.ComposeUiNode, Density, Unit> getSetDensity() {
            return ComposeUiNode.Companion.SetDensity;
        }

        public final Function2<androidx.compose.ui.node.ComposeUiNode, LayoutDirection, Unit> getSetLayoutDirection() {
            return ComposeUiNode.Companion.SetLayoutDirection;
        }

        public final Function2<androidx.compose.ui.node.ComposeUiNode, MeasurePolicy, Unit> getSetMeasurePolicy() {
            return ComposeUiNode.Companion.SetMeasurePolicy;
        }

        public final Function2<androidx.compose.ui.node.ComposeUiNode, Modifier, Unit> getSetModifier() {
            return ComposeUiNode.Companion.SetModifier;
        }

        public final Function2<androidx.compose.ui.node.ComposeUiNode, CompositionLocalMap, Unit> getSetResolvedCompositionLocals() {
            return ComposeUiNode.Companion.SetResolvedCompositionLocals;
        }

        public final Function2<androidx.compose.ui.node.ComposeUiNode, ViewConfiguration, Unit> getSetViewConfiguration() {
            return ComposeUiNode.Companion.SetViewConfiguration;
        }

        public final Function0<androidx.compose.ui.node.ComposeUiNode> getVirtualConstructor() {
            return ComposeUiNode.Companion.VirtualConstructor;
        }
    }
    static {
        ComposeUiNode.Companion = ComposeUiNode.Companion.$$INSTANCE;
    }

    public static void getCompositeKeyHash$annotations() {
    }

    public abstract int getCompositeKeyHash();

    public abstract CompositionLocalMap getCompositionLocalMap();

    public abstract Density getDensity();

    public abstract LayoutDirection getLayoutDirection();

    public abstract MeasurePolicy getMeasurePolicy();

    public abstract Modifier getModifier();

    public abstract ViewConfiguration getViewConfiguration();

    public abstract void setCompositeKeyHash(int i);

    public abstract void setCompositionLocalMap(CompositionLocalMap compositionLocalMap);

    public abstract void setDensity(Density density);

    public abstract void setLayoutDirection(LayoutDirection layoutDirection);

    public abstract void setMeasurePolicy(MeasurePolicy measurePolicy);

    public abstract void setModifier(Modifier modifier);

    public abstract void setViewConfiguration(ViewConfiguration viewConfiguration);
}
