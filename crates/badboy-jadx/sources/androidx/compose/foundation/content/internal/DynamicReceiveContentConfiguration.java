package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.ReceiveContentNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/content/internal/DynamicReceiveContentConfiguration;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentNode", "Landroidx/compose/foundation/content/ReceiveContentNode;", "(Landroidx/compose/foundation/content/ReceiveContentNode;)V", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "getReceiveContentNode", "()Landroidx/compose/foundation/content/ReceiveContentNode;", "getParentReceiveContentListener", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DynamicReceiveContentConfiguration extends androidx.compose.foundation.content.internal.ReceiveContentConfiguration {

    public static final int $stable = 8;
    private final ReceiveContentListener receiveContentListener;
    private final ReceiveContentNode receiveContentNode;
    static {
        final int i = 8;
    }

    public DynamicReceiveContentConfiguration(ReceiveContentNode receiveContentNode) {
        super();
        this.receiveContentNode = receiveContentNode;
        DynamicReceiveContentConfiguration.receiveContentListener.1 anon = new DynamicReceiveContentConfiguration.receiveContentListener.1(this);
        this.receiveContentListener = (ReceiveContentListener)anon;
    }

    public static final ReceiveContentListener access$getParentReceiveContentListener(androidx.compose.foundation.content.internal.DynamicReceiveContentConfiguration $this) {
        return $this.getParentReceiveContentListener();
    }

    private final ReceiveContentListener getParentReceiveContentListener() {
        ReceiveContentListener receiveContentListener;
        androidx.compose.foundation.content.internal.ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration((ModifierLocalModifierNode)this.receiveContentNode);
        if (receiveContentConfiguration != null) {
            receiveContentListener = receiveContentConfiguration.getReceiveContentListener();
        } else {
            receiveContentListener = 0;
        }
        return receiveContentListener;
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public final ReceiveContentNode getReceiveContentNode() {
        return this.receiveContentNode;
    }
}
