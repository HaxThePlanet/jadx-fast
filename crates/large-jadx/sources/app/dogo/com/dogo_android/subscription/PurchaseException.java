package app.dogo.com.dogo_android.subscription;

import com.revenuecat.purchases.PurchasesErrorCode;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: PurchaseException.kt */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/subscription/PurchaseException;", "", "revenueCatError", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "(Lcom/revenuecat/purchases/PurchasesErrorCode;)V", "dogoError", "Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "getDogoError", "()Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PurchaseException extends Throwable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final PurchaseException.Companion INSTANCE = new PurchaseException$Companion(0);
    private final DogoPurchaseError dogoError;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/PurchaseException$Companion;", "", "()V", "mapToDogoError", "Lapp/dogo/com/dogo_android/subscription/DogoPurchaseError;", "error", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final DogoPurchaseError mapToDogoError(PurchasesErrorCode error) {
            app.dogo.com.dogo_android.subscription.DogoPurchaseError waitOperation2;
            n.f(error, "error");
            switch (PurchaseException.Companion.WhenMappings.$EnumSwitchMapping$0[error.ordinal()]) {
                case 1: /* ordinal */
                    waitOperation2 = DogoPurchaseError.WaitOperation;
                    break;
                case 2: /* ordinal */
                    waitOperation2 = DogoPurchaseError.AlreadySubscribed;
                    break;
                case 3: /* ordinal */
                    waitOperation2 = DogoPurchaseError.ReceiptFailed;
                    break;
                case 4: /* ordinal */
                    waitOperation2 = DogoPurchaseError.ProductNotAvailableForDevice;
                    break;
                case 5: /* ordinal */
                    waitOperation2 = DogoPurchaseError.ProductNotAllowedToPurchase;
                    break;
                case 6: /* ordinal */
                    waitOperation2 = DogoPurchaseError.PendingPurchase;
                    break;
                default:
                    waitOperation2 = DogoPurchaseError.General;
            }
            return waitOperation2;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
    public PurchaseException(PurchasesErrorCode th) {
        n.f(th, "revenueCatError");
        super();
        this.dogoError = PurchaseException.INSTANCE.mapToDogoError(th);
    }

    @Override // java.lang.Throwable
    public final DogoPurchaseError getDogoError() {
        return this.dogoError;
    }

}
