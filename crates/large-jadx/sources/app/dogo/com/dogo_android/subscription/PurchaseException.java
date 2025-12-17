package app.dogo.com.dogo_android.subscription;

import com.revenuecat.purchases.PurchasesErrorCode;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/subscription/PurchaseException;", "", "revenueCatError", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "(Lcom/revenuecat/purchases/PurchasesErrorCode;)V", "dogoError", "Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "getDogoError", "()Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PurchaseException extends Throwable {

    public static final app.dogo.com.dogo_android.subscription.PurchaseException.Companion Companion;
    private final app.dogo.com.dogo_android.subscription.DogoPurchaseError dogoError;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/PurchaseException$Companion;", "", "()V", "mapToDogoError", "Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "error", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.subscription.DogoPurchaseError mapToDogoError(PurchasesErrorCode purchasesErrorCode) {
            app.dogo.com.dogo_android.subscription.DogoPurchaseError obj2;
            n.f(purchasesErrorCode, "error");
            switch (obj2) {
                case 1:
                    obj2 = DogoPurchaseError.WaitOperation;
                    break;
                case 2:
                    obj2 = DogoPurchaseError.AlreadySubscribed;
                    break;
                case 3:
                    obj2 = DogoPurchaseError.ReceiptFailed;
                    break;
                case 4:
                    obj2 = DogoPurchaseError.ProductNotAvailableForDevice;
                    break;
                case 5:
                    obj2 = DogoPurchaseError.ProductNotAllowedToPurchase;
                    break;
                case 6:
                    obj2 = DogoPurchaseError.PendingPurchase;
                    break;
                default:
                    obj2 = DogoPurchaseError.General;
            }
            return obj2;
        }
    }
    static {
        PurchaseException.Companion companion = new PurchaseException.Companion(0);
        PurchaseException.Companion = companion;
    }

    public PurchaseException(PurchasesErrorCode purchasesErrorCode) {
        n.f(purchasesErrorCode, "revenueCatError");
        super();
        this.dogoError = PurchaseException.Companion.mapToDogoError(purchasesErrorCode);
    }

    @Override // java.lang.Throwable
    public final app.dogo.com.dogo_android.subscription.DogoPurchaseError getDogoError() {
        return this.dogoError;
    }
}
