package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0005\u0010\u0004J$\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\u0008\u0008\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\n\u0010\u0004J\u0010\u0010\u000c\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0006\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0012\u001a\u0004\u0008\u0014\u0010\u0004¨\u0006\u0017", d2 = {"Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "", "", "component1", "()Ljava/lang/String;", "component2", "keyName", "message", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKeyName", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class SubscriberAttributeError {

    private final String keyName;
    private final String message;
    public SubscriberAttributeError(String string, String string2) {
        n.f(string, "keyName");
        n.f(string2, "message");
        super();
        this.keyName = string;
        this.message = string2;
    }

    public static com.revenuecat.purchases.common.SubscriberAttributeError copy$default(com.revenuecat.purchases.common.SubscriberAttributeError subscriberAttributeError, String string2, String string3, int i4, Object object5) {
        String obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = subscriberAttributeError.keyName;
        }
        if (i4 &= 2 != 0) {
            obj2 = subscriberAttributeError.message;
        }
        return subscriberAttributeError.copy(obj1, obj2);
    }

    public final String component1() {
        return this.keyName;
    }

    public final String component2() {
        return this.message;
    }

    public final com.revenuecat.purchases.common.SubscriberAttributeError copy(String string, String string2) {
        n.f(string, "keyName");
        n.f(string2, "message");
        SubscriberAttributeError subscriberAttributeError = new SubscriberAttributeError(string, string2);
        return subscriberAttributeError;
    }

    public boolean equals(Object object) {
        boolean message;
        String keyName;
        Object obj3;
        if (this != (SubscriberAttributeError)object && object instanceof SubscriberAttributeError != null && n.b(this.keyName, object.keyName) && n.b(this.message, object.message)) {
            if (object instanceof SubscriberAttributeError != null) {
                if (n.b(this.keyName, object.keyName)) {
                    if (n.b(this.message, object.message)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int i;
        int i2;
        String keyName = this.keyName;
        if (keyName != null) {
            i = keyName.hashCode();
        } else {
            i = i2;
        }
        final String message = this.message;
        if (message != null) {
            i2 = message.hashCode();
        }
        return i3 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SubscriberAttributeError(keyName=");
        stringBuilder.append(this.keyName);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
