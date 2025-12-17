package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008 \u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "", "()V", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "onCommitContent", "", "transferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ReceiveContentConfiguration {

    public static final int $stable;
    public static final androidx.compose.foundation.content.internal.ReceiveContentConfiguration.Companion Companion;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration$Companion;", "", "()V", "invoke", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.foundation.content.internal.ReceiveContentConfiguration invoke(ReceiveContentListener receiveContentListener) {
            ReceiveContentConfigurationImpl receiveContentConfigurationImpl = new ReceiveContentConfigurationImpl(receiveContentListener);
            return (ReceiveContentConfiguration)receiveContentConfigurationImpl;
        }
    }
    static {
        ReceiveContentConfiguration.Companion companion = new ReceiveContentConfiguration.Companion(0);
        ReceiveContentConfiguration.Companion = companion;
    }

    public abstract ReceiveContentListener getReceiveContentListener();

    public final boolean onCommitContent(TransferableContent transferableContent) {
        return equal ^= 1;
    }
}
