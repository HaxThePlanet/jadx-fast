package app.dogo.com.dogo_android.util.exceptions;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* compiled from: CouponExceptions.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0004\u0004\u0005\u0006\u0007B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0004\u0008\t\n\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "AlreadyPremium", "AlreadyUsed", "DoesNotExists", "EmptyCode", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$AlreadyUsed;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$DoesNotExists;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$AlreadyPremium;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$EmptyCode;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract /* sealed */ class CouponExceptions extends Exception {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$AlreadyPremium;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AlreadyPremium extends CouponExceptions {
        public AlreadyPremium() {
            super(null);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$AlreadyUsed;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AlreadyUsed extends CouponExceptions {
        public AlreadyUsed() {
            super(null);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$DoesNotExists;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DoesNotExists extends CouponExceptions {
        public DoesNotExists() {
            super(null);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$EmptyCode;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EmptyCode extends CouponExceptions {
        public EmptyCode() {
            super(null);
        }
    }
    private CouponExceptions() {
        super();
    }

    public /* synthetic */ CouponExceptions(g gVar) {
        this();
    }
}
