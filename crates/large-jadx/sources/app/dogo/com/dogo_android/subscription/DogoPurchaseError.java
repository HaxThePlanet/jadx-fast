package app.dogo.com.dogo_android.subscription;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* compiled from: DogoPurchaseError.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\u0008\u0086\u0001\u0018\u0000 \u000e2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "General", "WaitOperation", "AlreadySubscribed", "ReceiptFailed", "ProductNotAvailableForDevice", "ProductNotAllowedToPurchase", "PendingPurchase", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public enum DogoPurchaseError {

    AlreadySubscribed,
    General,
    PendingPurchase,
    ProductNotAllowedToPurchase,
    ProductNotAvailableForDevice,
    ReceiptFailed,
    WaitOperation;

    private final int value;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError$Companion;", "", "()V", "valueOf", "Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "dogoErrorCode", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final DogoPurchaseError valueOf(int dogoErrorCode) {
            int i;
            app.dogo.com.dogo_android.subscription.DogoPurchaseError dogoPurchaseError = null;
            final app.dogo.com.dogo_android.subscription.DogoPurchaseError[] values = DogoPurchaseError.values();
            i = 0;
            while (i < values.length) {
                int r5 = values[i].getValue() == dogoErrorCode ? 1 : i;
                if (i != 0) {
                    break;
                }
            }
            int i2 = 0;
            return dogoPurchaseError;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
    @Override // java.lang.Enum
    public final int getValue() {
        return this.value;
    }

    private static final /* synthetic */ DogoPurchaseError[] $values() {
        app.dogo.com.dogo_android.subscription.DogoPurchaseError[] arr = new DogoPurchaseError[7];
        return new DogoPurchaseError[] { DogoPurchaseError.General, DogoPurchaseError.WaitOperation, DogoPurchaseError.AlreadySubscribed, DogoPurchaseError.ReceiptFailed, DogoPurchaseError.ProductNotAvailableForDevice, DogoPurchaseError.ProductNotAllowedToPurchase, DogoPurchaseError.PendingPurchase };
    }
}
