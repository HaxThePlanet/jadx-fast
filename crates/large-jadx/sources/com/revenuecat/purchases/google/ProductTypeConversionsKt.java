package com.revenuecat.purchases.google;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0000*\u00020\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"", "Lcom/revenuecat/purchases/ProductType;", "toProductType", "(Ljava/lang/String;)Lcom/revenuecat/purchases/ProductType;", "toSKUType", "(Lcom/revenuecat/purchases/ProductType;)Ljava/lang/String;", "google_release"}, k = 2, mv = {1, 4, 0})
public final class ProductTypeConversionsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            ProductTypeConversionsKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[ProductType.INAPP.ordinal()] = 1;
            iArr[ProductType.SUBS.ordinal()] = 2;
        }
    }
    public static final ProductType toProductType(String string) {
        String str;
        int i;
        ProductType obj2;
        if (string == null) {
            obj2 = ProductType.UNKNOWN;
        } else {
            str = string.hashCode();
            if (str != 3541555) {
                if (str != 100343516) {
                } else {
                    if (string.equals("inapp")) {
                        obj2 = ProductType.INAPP;
                    } else {
                    }
                }
            } else {
                if (string.equals("subs")) {
                    obj2 = ProductType.SUBS;
                } else {
                }
            }
        }
        return obj2;
    }

    public static final String toSKUType(ProductType productType) {
        int i;
        String obj1;
        n.f(productType, "$this$toSKUType");
        obj1 = ProductTypeConversionsKt.WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (obj1 != 1) {
            obj1 = obj1 != 2 ? 0 : "subs";
        } else {
            obj1 = "inapp";
        }
        return obj1;
    }
}
