package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/DefaultDebugIndication;", "Landroidx/compose/foundation/IndicationNodeFactory;", "()V", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "equals", "", "other", "", "hashCode", "", "DefaultDebugIndicationInstance", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultDebugIndication implements androidx.compose.foundation.IndicationNodeFactory {

    public static final androidx.compose.foundation.DefaultDebugIndication INSTANCE;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u000c\u0010\u000c\u001a\u00020\u000b*\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/DefaultDebugIndication$DefaultDebugIndicationInstance;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isFocused", "", "isHovered", "isPressed", "onAttach", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DefaultDebugIndicationInstance extends Modifier.Node implements DrawModifierNode {

        private final InteractionSource interactionSource;
        private boolean isFocused;
        private boolean isHovered;
        private boolean isPressed;
        public DefaultDebugIndicationInstance(InteractionSource interactionSource) {
            super();
            this.interactionSource = interactionSource;
        }

        public static final InteractionSource access$getInteractionSource$p(androidx.compose.foundation.DefaultDebugIndication.DefaultDebugIndicationInstance $this) {
            return $this.interactionSource;
        }

        public static final boolean access$isFocused$p(androidx.compose.foundation.DefaultDebugIndication.DefaultDebugIndicationInstance $this) {
            return $this.isFocused;
        }

        public static final boolean access$isHovered$p(androidx.compose.foundation.DefaultDebugIndication.DefaultDebugIndicationInstance $this) {
            return $this.isHovered;
        }

        public static final boolean access$isPressed$p(androidx.compose.foundation.DefaultDebugIndication.DefaultDebugIndicationInstance $this) {
            return $this.isPressed;
        }

        public static final void access$setFocused$p(androidx.compose.foundation.DefaultDebugIndication.DefaultDebugIndicationInstance $this, boolean <set-?>) {
            $this.isFocused = <set-?>;
        }

        public static final void access$setHovered$p(androidx.compose.foundation.DefaultDebugIndication.DefaultDebugIndicationInstance $this, boolean <set-?>) {
            $this.isHovered = <set-?>;
        }

        public static final void access$setPressed$p(androidx.compose.foundation.DefaultDebugIndication.DefaultDebugIndicationInstance $this, boolean <set-?>) {
            $this.isPressed = <set-?>;
        }

        @Override // androidx.compose.ui.Modifier$Node
        public void draw(ContentDrawScope $this$draw) {
            Color.Companion isHovered;
            DrawScope drawScope;
            long copy-wmQWz5c$default;
            int i5;
            int i3;
            long size-NH-jbRc;
            int i4;
            int i7;
            int i2;
            int i8;
            int i;
            int i9;
            int i6;
            $this$draw.drawContent();
            if (this.isPressed) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                DrawScope.drawRect-n-J9OG0$default((DrawScope)$this$draw, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), obj3, 1050253722, i3, 0, i4, 14), obj3, 0, i3, $this$draw.getSize-NH-jbRc(), i4, 0, i2, 0);
            } else {
                if (!this.isHovered) {
                    if (this.isFocused) {
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        DrawScope.drawRect-n-J9OG0$default((DrawScope)$this$draw, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), obj3, 1036831949, i3, 0, i4, 14), obj3, 0, i3, $this$draw.getSize-NH-jbRc(), i4, 0, i2, 0);
                    }
                } else {
                }
            }
        }

        @Override // androidx.compose.ui.Modifier$Node
        public void onAttach() {
            final int i2 = 0;
            DefaultDebugIndication.DefaultDebugIndicationInstance.onAttach.1 anon = new DefaultDebugIndication.DefaultDebugIndicationInstance.onAttach.1(this, i2);
            BuildersKt.launch$default(getCoroutineScope(), 0, i2, (Function2)anon, 3, 0);
        }
    }
    static {
        DefaultDebugIndication defaultDebugIndication = new DefaultDebugIndication();
        DefaultDebugIndication.INSTANCE = defaultDebugIndication;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode create(InteractionSource interactionSource) {
        DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance = new DefaultDebugIndication.DefaultDebugIndicationInstance(interactionSource);
        return (DelegatableNode)defaultDebugIndicationInstance;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public boolean equals(Object other) {
        int i;
        i = other == this ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        return -1;
    }
}
