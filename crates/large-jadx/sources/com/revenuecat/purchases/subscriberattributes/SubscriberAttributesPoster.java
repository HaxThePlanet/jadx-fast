package com.revenuecat.purchases.subscriberattributes;

import android.net.Uri;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.q;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\u0008\u0014\u0010\u0015Jk\u0010\u000f\u001a\u00020\u00072 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062$\u0010\u000e\u001a \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013¨\u0006\u0016", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "", "", "", "attributes", "appUserID", "Lkotlin/Function0;", "Lkotlin/w;", "onSuccessHandler", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/PurchasesError;", "", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "onErrorHandler", "postSubscriberAttributes", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/d0/c/a;Lkotlin/d0/c/q;)V", "Lcom/revenuecat/purchases/common/Backend;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "<init>", "(Lcom/revenuecat/purchases/common/Backend;)V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
public final class SubscriberAttributesPoster {

    private final Backend backend;
    public SubscriberAttributesPoster(Backend backend) {
        n.f(backend, "backend");
        super();
        this.backend = backend;
    }

    public final void postSubscriberAttributes(Map<String, ? extends Map<String, ? extends Object>> map, String string2, a<w> a3, q<? super PurchasesError, ? super Boolean, ? super List<SubscriberAttributeError>, w> q4) {
        String str = "attributes";
        n.f(map, str);
        n.f(string2, "appUserID");
        n.f(a3, "onSuccessHandler");
        n.f(q4, "onErrorHandler");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/subscribers/");
        stringBuilder.append(Uri.encode(string2));
        stringBuilder.append("/attributes");
        SubscriberAttributesPoster.postSubscriberAttributes.1 anon = new SubscriberAttributesPoster.postSubscriberAttributes.1(q4);
        SubscriberAttributesPoster.postSubscriberAttributes.2 anon2 = new SubscriberAttributesPoster.postSubscriberAttributes.2(q4, a3);
        this.backend.performRequest(stringBuilder.toString(), j0.e(u.a(str, map)), anon, anon2);
    }
}
