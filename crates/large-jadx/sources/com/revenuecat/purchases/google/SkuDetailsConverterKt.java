package com.revenuecat.purchases.google;

import com.android.billingclient.api.SkuDetails;
import com.revenuecat.purchases.models.ProductDetails;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lcom/android/billingclient/api/SkuDetails;", "Lcom/revenuecat/purchases/models/ProductDetails;", "toProductDetails", "(Lcom/android/billingclient/api/SkuDetails;)Lcom/revenuecat/purchases/models/ProductDetails;", "google_release"}, k = 2, mv = {1, 4, 0})
public final class SkuDetailsConverterKt {
    public static final ProductDetails toProductDetails(SkuDetails skuDetails) {
        int str;
        int i;
        String str2;
        int i2;
        n.f(skuDetails, "$this$toProductDetails");
        final String str14 = skuDetails.n();
        n.e(str14, "sku");
        final String str15 = skuDetails.k();
        n.e(str15, "price");
        final String str16 = skuDetails.m();
        n.e(str16, "priceCurrencyCode");
        final String str18 = skuDetails.p();
        n.e(str18, "title");
        final String str19 = skuDetails.a();
        n.e(str19, "description");
        String str10 = skuDetails.o();
        String str12 = "it";
        n.e(str10, str12);
        i = z2 ^= 1 != 0 ? str10 : 0;
        str = skuDetails.b();
        n.e(str, str12);
        if (z3 ^= 1 != 0) {
        } else {
            str = 0;
        }
        String str20 = skuDetails.d();
        n.e(str20, str12);
        str2 = z4 ^= 1 != 0 ? str20 : 0;
        final long l4 = skuDetails.e();
        String str21 = skuDetails.g();
        n.e(str21, str12);
        i2 = z ^= 1 != 0 ? str21 : 0;
        String str13 = skuDetails.c();
        n.e(str13, "iconUrl");
        JSONObject jSONObject = new JSONObject(skuDetails.h());
        super(str14, ProductTypeConversionsKt.toProductType(skuDetails.q()), str15, skuDetails.l(), obj7, str16, skuDetails.i(), skuDetails.j(), obj11, str18, str19, i, str, str2, l4, l4, i2, skuDetails.f(), str13, jSONObject);
        return productDetails;
    }
}
