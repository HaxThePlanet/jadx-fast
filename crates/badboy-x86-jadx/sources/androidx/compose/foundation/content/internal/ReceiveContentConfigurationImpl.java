package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/content/internal/ReceiveContentConfigurationImpl;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "(Landroidx/compose/foundation/content/ReceiveContentListener;)V", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ReceiveContentConfigurationImpl extends androidx.compose.foundation.content.internal.ReceiveContentConfiguration {

    private final ReceiveContentListener receiveContentListener;
    public ReceiveContentConfigurationImpl(ReceiveContentListener receiveContentListener) {
        super();
        this.receiveContentListener = receiveContentListener;
    }

    public static androidx.compose.foundation.content.internal.ReceiveContentConfigurationImpl copy$default(androidx.compose.foundation.content.internal.ReceiveContentConfigurationImpl receiveContentConfigurationImpl, ReceiveContentListener receiveContentListener2, int i3, Object object4) {
        ReceiveContentListener obj1;
        if (i3 &= 1 != 0) {
            obj1 = receiveContentConfigurationImpl.receiveContentListener;
        }
        return receiveContentConfigurationImpl.copy(obj1);
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public final ReceiveContentListener component1() {
        return this.receiveContentListener;
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public final androidx.compose.foundation.content.internal.ReceiveContentConfigurationImpl copy(ReceiveContentListener receiveContentListener) {
        ReceiveContentConfigurationImpl receiveContentConfigurationImpl = new ReceiveContentConfigurationImpl(receiveContentListener);
        return receiveContentConfigurationImpl;
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ReceiveContentConfigurationImpl) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.receiveContentListener, obj.receiveContentListener)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public int hashCode() {
        return this.receiveContentListener.hashCode();
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ReceiveContentConfigurationImpl(receiveContentListener=").append(this.receiveContentListener).append(')').toString();
    }
}
