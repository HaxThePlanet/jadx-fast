package app.dogo.com.dogo_android.subscription;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\u0008\u0086\u0001\u0018\u0000 \u000e2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "General", "WaitOperation", "AlreadySubscribed", "ReceiptFailed", "ProductNotAvailableForDevice", "ProductNotAllowedToPurchase", "PendingPurchase", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum DogoPurchaseError {

    General(101),
    WaitOperation(101),
    AlreadySubscribed(101),
    ReceiptFailed(101),
    ProductNotAvailableForDevice(101),
    ProductNotAllowedToPurchase(101),
    PendingPurchase(101);

    private final int value;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError$Companion;", "", "()V", "valueOf", "Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "dogoErrorCode", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.subscription.DogoPurchaseError valueOf(int i) {
            int i2;
            app.dogo.com.dogo_android.subscription.DogoPurchaseError th;
            int i3;
            final app.dogo.com.dogo_android.subscription.DogoPurchaseError[] values = DogoPurchaseError.values();
            final int i4 = 0;
            i2 = i4;
            while (i2 < values.length) {
                if (values[i2].getValue() == i) {
                } else {
                }
                i3 = i4;
                i2++;
                i3 = 1;
            }
            th = 0;
            return th;
        }
    }
    private static final app.dogo.com.dogo_android.subscription.DogoPurchaseError[] $values() {
        app.dogo.com.dogo_android.subscription.DogoPurchaseError[] arr = new DogoPurchaseError[7];
        return arr;
    }

    @Override // java.lang.Enum
    public final int getValue() {
        return this.value;
    }
}
