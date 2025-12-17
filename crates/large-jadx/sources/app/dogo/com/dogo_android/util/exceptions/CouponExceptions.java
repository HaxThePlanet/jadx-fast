package app.dogo.com.dogo_android.util.exceptions;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0004\u0004\u0005\u0006\u0007B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0004\u0008\t\n\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "AlreadyPremium", "AlreadyUsed", "DoesNotExists", "EmptyCode", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$AlreadyUsed;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$DoesNotExists;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$AlreadyPremium;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$EmptyCode;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class CouponExceptions extends Exception {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$AlreadyPremium;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AlreadyPremium extends app.dogo.com.dogo_android.util.exceptions.CouponExceptions {
        public AlreadyPremium() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$AlreadyUsed;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AlreadyUsed extends app.dogo.com.dogo_android.util.exceptions.CouponExceptions {
        public AlreadyUsed() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$DoesNotExists;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DoesNotExists extends app.dogo.com.dogo_android.util.exceptions.CouponExceptions {
        public DoesNotExists() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions$EmptyCode;", "Lapp/dogo/com/dogo_android/util/exceptions/CouponExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EmptyCode extends app.dogo.com.dogo_android.util.exceptions.CouponExceptions {
        public EmptyCode() {
            super(0);
        }
    }
    public CouponExceptions(g g) {
        super();
    }
}
