package com.revenuecat.purchases;

import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.revenuecat.purchases.interfaces.GetProductDetailsCallback;
import com.revenuecat.purchases.interfaces.GetSkusResponseListener;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.MakePurchaseListener;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.ProductChangeListener;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsListener;
import com.revenuecat.purchases.interfaces.ReceivePurchaserInfoListener;
import com.revenuecat.purchases.models.ProductDetails;
import com.revenuecat.purchases.models.PurchaseDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u001d\u001aK\u0010\u000b\u001a\u00020\n2\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00042\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0008H\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001aK\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u000e2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0008H\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u001aM\u0010\u0014\u001a\u00020\u00132\u001e\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00122\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0008H\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001aA\u0010\u001c\u001a\u00020\u001b2\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00030\u00162\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001aH\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001aM\u0010\u0014\u001a\u00020\u001f2\u001e\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u001e2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0008H\u0000¢\u0006\u0004\u0008\u0014\u0010 \u001aA\u0010#\u001a\u00020\"2\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020!0\u0017\u0012\u0004\u0012\u00020\u00030\u00162\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001aH\u0000¢\u0006\u0004\u0008#\u0010$\u001a?\u0010(\u001a\u00020'2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`&2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001aH\u0000¢\u0006\u0004\u0008(\u0010)\u001aG\u0010,\u001a\u00020+2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016j\u0004\u0018\u0001`*2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016j\u0004\u0018\u0001`\u001aH\u0000¢\u0006\u0004\u0008,\u0010-\u001aM\u00100\u001a\u00020/2 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000j\u0004\u0018\u0001`.2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016j\u0004\u0018\u0001`\u001aH\u0000¢\u0006\u0004\u00080\u00101\u001aC\u00103\u001a\u00020\u0003*\u0002022\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`&¢\u0006\u0004\u00083\u00104\u001a_\u00108\u001a\u00020\u0003*\u0002022\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00182\u001e\u0008\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00082\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0004¢\u0006\u0004\u00088\u00109\u001aa\u00108\u001a\u00020\u0003*\u0002022\u0006\u00106\u001a\u0002052\u0006\u0010:\u001a\u00020!2\u001e\u0008\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00082\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u000eH\u0000¢\u0006\u0004\u00088\u0010;\u001ai\u00108\u001a\u00020\u0003*\u0002022\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00182\u0006\u0010=\u001a\u00020<2\u001e\u0008\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00082\u001e\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0012¢\u0006\u0004\u00088\u0010>\u001ak\u00108\u001a\u00020\u0003*\u0002022\u0006\u00106\u001a\u0002052\u0006\u0010:\u001a\u00020!2\u0006\u0010=\u001a\u00020<2\u001e\u0008\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00082\u001e\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u001eH\u0000¢\u0006\u0004\u00088\u0010?\u001ai\u0010B\u001a\u00020\u0003*\u0002022\u0006\u00106\u001a\u0002052\u0006\u0010A\u001a\u00020@2\u0006\u0010=\u001a\u00020<2\u001e\u0008\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00082\u001e\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0012¢\u0006\u0004\u0008B\u0010C\u001a_\u0010B\u001a\u00020\u0003*\u0002022\u0006\u00106\u001a\u0002052\u0006\u0010A\u001a\u00020@2\u001e\u0008\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00082\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0004¢\u0006\u0004\u0008B\u0010D\u001aC\u0010E\u001a\u00020\u0003*\u0002022\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`*¢\u0006\u0004\u0008E\u00104\u001aK\u0010H\u001a\u00020\u0003*\u0002022\u0006\u0010G\u001a\u00020F2\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`*¢\u0006\u0004\u0008H\u0010I\u001aK\u0010K\u001a\u00020\u0003*\u0002022\u0006\u0010J\u001a\u00020F2\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`*¢\u0006\u0004\u0008K\u0010I\u001aQ\u0010L\u001a\u00020\u0003*\u0002022\u0006\u0010J\u001a\u00020F2\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`.¢\u0006\u0004\u0008L\u0010M\u001aC\u0010N\u001a\u00020\u0003*\u0002022\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`*¢\u0006\u0004\u0008N\u00104\u001aC\u0010O\u001a\u00020\u0003*\u0002022\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`*¢\u0006\u0004\u0008O\u00104\u001aC\u0010P\u001a\u00020\u0003*\u0002022\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`*¢\u0006\u0004\u0008P\u00104\u001aS\u0010S\u001a\u00020\u0003*\u0002022\u000c\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020F0\u00172\u0018\u0008\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0018\u0010R\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0004\u0008S\u0010T\u001aQ\u0010U\u001a\u00020\u0003*\u0002022\u000c\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020F0\u00172\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a2\u0018\u0010R\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0004\u0008U\u0010T\"&\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016j\u0002`\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008V\u0010W\",\u0010X\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008X\u0010Y*$\u0008\u0002\u0010Z\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00162\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0016*4\u0008\u0002\u0010[\"\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000*0\u0008\u0002\u0010\\\"\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000*4\u0008\u0002\u0010]\"\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000*0\u0008\u0002\u0010^\"\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000*0\u0008\u0002\u0010_\"\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00002\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000*0\u0008\u0002\u0010`\"\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0000*$\u0008\u0002\u0010a\"\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\u00162\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\u0016*$\u0008\u0002\u0010b\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016¨\u0006c", d2 = {"Lkotlin/Function2;", "Lcom/android/billingclient/api/Purchase;", "Lcom/revenuecat/purchases/PurchaserInfo;", "Lkotlin/w;", "Lcom/revenuecat/purchases/PurchaseCompletedFunction;", "onSuccess", "Lcom/revenuecat/purchases/PurchasesError;", "", "Lcom/revenuecat/purchases/PurchaseErrorFunction;", "onError", "Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;", "purchaseCompletedListener", "(Lkotlin/d0/c/p;Lkotlin/d0/c/p;)Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "Lcom/revenuecat/purchases/NewPurchaseCompletedFunction;", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "purchaseCompletedCallback", "(Lkotlin/d0/c/p;Lkotlin/d0/c/p;)Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "Lcom/revenuecat/purchases/ProductChangeCompletedFunction;", "Lcom/revenuecat/purchases/interfaces/ProductChangeListener;", "productChangeCompletedListener", "(Lkotlin/d0/c/p;Lkotlin/d0/c/p;)Lcom/revenuecat/purchases/interfaces/ProductChangeListener;", "Lkotlin/Function1;", "", "Lcom/android/billingclient/api/SkuDetails;", "onReceived", "Lcom/revenuecat/purchases/ErrorFunction;", "Lcom/revenuecat/purchases/interfaces/GetSkusResponseListener;", "getSkusResponseListener", "(Lkotlin/d0/c/l;Lkotlin/d0/c/l;)Lcom/revenuecat/purchases/interfaces/GetSkusResponseListener;", "Lcom/revenuecat/purchases/NewProductChangeCompletedFunction;", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "(Lkotlin/d0/c/p;Lkotlin/d0/c/p;)Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "Lcom/revenuecat/purchases/models/ProductDetails;", "Lcom/revenuecat/purchases/interfaces/GetProductDetailsCallback;", "getProductDetailsCallback", "(Lkotlin/d0/c/l;Lkotlin/d0/c/l;)Lcom/revenuecat/purchases/interfaces/GetProductDetailsCallback;", "Lcom/revenuecat/purchases/Offerings;", "Lcom/revenuecat/purchases/ReceiveOfferingsSuccessFunction;", "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsListener;", "receiveOfferingsListener", "(Lkotlin/d0/c/l;Lkotlin/d0/c/l;)Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsListener;", "Lcom/revenuecat/purchases/ReceivePurchaserInfoSuccessFunction;", "Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "receivePurchaserInfoListener", "(Lkotlin/d0/c/l;Lkotlin/d0/c/l;)Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "Lcom/revenuecat/purchases/ReceiveLogInSuccessFunction;", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logInSuccessListener", "(Lkotlin/d0/c/p;Lkotlin/d0/c/l;)Lcom/revenuecat/purchases/interfaces/LogInCallback;", "Lcom/revenuecat/purchases/Purchases;", "getOfferingsWith", "(Lcom/revenuecat/purchases/Purchases;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "Landroid/app/Activity;", "activity", "skuDetails", "purchaseProductWith", "(Lcom/revenuecat/purchases/Purchases;Landroid/app/Activity;Lcom/android/billingclient/api/SkuDetails;Lkotlin/d0/c/p;Lkotlin/d0/c/p;)V", "productDetails", "(Lcom/revenuecat/purchases/Purchases;Landroid/app/Activity;Lcom/revenuecat/purchases/models/ProductDetails;Lkotlin/d0/c/p;Lkotlin/d0/c/p;)V", "Lcom/revenuecat/purchases/UpgradeInfo;", "upgradeInfo", "(Lcom/revenuecat/purchases/Purchases;Landroid/app/Activity;Lcom/android/billingclient/api/SkuDetails;Lcom/revenuecat/purchases/UpgradeInfo;Lkotlin/d0/c/p;Lkotlin/d0/c/p;)V", "(Lcom/revenuecat/purchases/Purchases;Landroid/app/Activity;Lcom/revenuecat/purchases/models/ProductDetails;Lcom/revenuecat/purchases/UpgradeInfo;Lkotlin/d0/c/p;Lkotlin/d0/c/p;)V", "Lcom/revenuecat/purchases/Package;", "packageToPurchase", "purchasePackageWith", "(Lcom/revenuecat/purchases/Purchases;Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/UpgradeInfo;Lkotlin/d0/c/p;Lkotlin/d0/c/p;)V", "(Lcom/revenuecat/purchases/Purchases;Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lkotlin/d0/c/p;Lkotlin/d0/c/p;)V", "restorePurchasesWith", "", "newAppUserID", "createAliasWith", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "appUserID", "identifyWith", "logInWith", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lkotlin/d0/c/l;Lkotlin/d0/c/p;)V", "logOutWith", "resetWith", "getPurchaserInfoWith", "skus", "onReceiveSkus", "getSubscriptionSkusWith", "(Lcom/revenuecat/purchases/Purchases;Ljava/util/List;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "getNonSubscriptionSkusWith", "ON_ERROR_STUB", "Lkotlin/d0/c/l;", "ON_PURCHASE_ERROR_STUB", "Lkotlin/d0/c/p;", "ErrorFunction", "NewProductChangeCompletedFunction", "NewPurchaseCompletedFunction", "ProductChangeCompletedFunction", "PurchaseCompletedFunction", "PurchaseErrorFunction", "ReceiveLogInSuccessFunction", "ReceiveOfferingsSuccessFunction", "ReceivePurchaserInfoSuccessFunction", "purchases_release"}, k = 2, mv = {1, 4, 0})
public final class ListenerConversionsKt {

    private static final l<com.revenuecat.purchases.PurchasesError, w> ON_ERROR_STUB;
    private static final p<com.revenuecat.purchases.PurchasesError, Boolean, w> ON_PURCHASE_ERROR_STUB;
    static {
        ListenerConversionsKt.ON_ERROR_STUB = ListenerConversionsKt.ON_ERROR_STUB.1.INSTANCE;
        ListenerConversionsKt.ON_PURCHASE_ERROR_STUB = ListenerConversionsKt.ON_PURCHASE_ERROR_STUB.1.INSTANCE;
    }

    public static final void createAliasWith(com.revenuecat.purchases.Purchases purchases, String string2, l<? super com.revenuecat.purchases.PurchasesError, w> l3, l<? super com.revenuecat.purchases.PurchaserInfo, w> l4) {
        n.f(purchases, "$this$createAliasWith");
        n.f(string2, "newAppUserID");
        n.f(l3, "onError");
        n.f(l4, "onSuccess");
        purchases.createAlias(string2, ListenerConversionsKt.receivePurchaserInfoListener(l4, l3));
    }

    public static void createAliasWith$default(com.revenuecat.purchases.Purchases purchases, String string2, l l3, l l4, int i5, Object object6) {
        l obj2;
        if (i5 &= 2 != 0) {
            obj2 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.createAliasWith(purchases, string2, obj2, l4);
    }

    public static final void getNonSubscriptionSkusWith(com.revenuecat.purchases.Purchases purchases, List<String> list2, l<? super com.revenuecat.purchases.PurchasesError, w> l3, l<? super List<? extends SkuDetails>, w> l4) {
        n.f(purchases, "$this$getNonSubscriptionSkusWith");
        n.f(list2, "skus");
        n.f(l3, "onError");
        n.f(l4, "onReceiveSkus");
        purchases.getNonSubscriptionSkus(list2, ListenerConversionsKt.getSkusResponseListener(l4, l3));
    }

    public static final void getOfferingsWith(com.revenuecat.purchases.Purchases purchases, l<? super com.revenuecat.purchases.PurchasesError, w> l2, l<? super com.revenuecat.purchases.Offerings, w> l3) {
        n.f(purchases, "$this$getOfferingsWith");
        n.f(l2, "onError");
        n.f(l3, "onSuccess");
        purchases.getOfferings(ListenerConversionsKt.receiveOfferingsListener(l3, l2));
    }

    public static void getOfferingsWith$default(com.revenuecat.purchases.Purchases purchases, l l2, l l3, int i4, Object object5) {
        l obj1;
        if (i4 &= 1 != 0) {
            obj1 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.getOfferingsWith(purchases, obj1, l3);
    }

    public static final GetProductDetailsCallback getProductDetailsCallback(l<? super List<ProductDetails>, w> l, l<? super com.revenuecat.purchases.PurchasesError, w> l2) {
        n.f(l, "onReceived");
        n.f(l2, "onError");
        ListenerConversionsKt.getProductDetailsCallback.1 anon = new ListenerConversionsKt.getProductDetailsCallback.1(l, l2);
        return anon;
    }

    public static final void getPurchaserInfoWith(com.revenuecat.purchases.Purchases purchases, l<? super com.revenuecat.purchases.PurchasesError, w> l2, l<? super com.revenuecat.purchases.PurchaserInfo, w> l3) {
        n.f(purchases, "$this$getPurchaserInfoWith");
        n.f(l2, "onError");
        n.f(l3, "onSuccess");
        purchases.getPurchaserInfo(ListenerConversionsKt.receivePurchaserInfoListener(l3, l2));
    }

    public static void getPurchaserInfoWith$default(com.revenuecat.purchases.Purchases purchases, l l2, l l3, int i4, Object object5) {
        l obj1;
        if (i4 &= 1 != 0) {
            obj1 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.getPurchaserInfoWith(purchases, obj1, l3);
    }

    public static final GetSkusResponseListener getSkusResponseListener(l<? super List<? extends SkuDetails>, w> l, l<? super com.revenuecat.purchases.PurchasesError, w> l2) {
        n.f(l, "onReceived");
        n.f(l2, "onError");
        ListenerConversionsKt.getSkusResponseListener.1 anon = new ListenerConversionsKt.getSkusResponseListener.1(l, l2);
        return anon;
    }

    public static final void getSubscriptionSkusWith(com.revenuecat.purchases.Purchases purchases, List<String> list2, l<? super com.revenuecat.purchases.PurchasesError, w> l3, l<? super List<? extends SkuDetails>, w> l4) {
        n.f(purchases, "$this$getSubscriptionSkusWith");
        n.f(list2, "skus");
        n.f(l3, "onError");
        n.f(l4, "onReceiveSkus");
        purchases.getSubscriptionSkus(list2, ListenerConversionsKt.getSkusResponseListener(l4, l3));
    }

    public static void getSubscriptionSkusWith$default(com.revenuecat.purchases.Purchases purchases, List list2, l l3, l l4, int i5, Object object6) {
        l obj2;
        if (i5 &= 2 != 0) {
            obj2 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.getSubscriptionSkusWith(purchases, list2, obj2, l4);
    }

    public static final void identifyWith(com.revenuecat.purchases.Purchases purchases, String string2, l<? super com.revenuecat.purchases.PurchasesError, w> l3, l<? super com.revenuecat.purchases.PurchaserInfo, w> l4) {
        n.f(purchases, "$this$identifyWith");
        n.f(string2, "appUserID");
        n.f(l3, "onError");
        n.f(l4, "onSuccess");
        purchases.identify(string2, ListenerConversionsKt.receivePurchaserInfoListener(l4, l3));
    }

    public static void identifyWith$default(com.revenuecat.purchases.Purchases purchases, String string2, l l3, l l4, int i5, Object object6) {
        l obj2;
        if (i5 &= 2 != 0) {
            obj2 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.identifyWith(purchases, string2, obj2, l4);
    }

    public static final LogInCallback logInSuccessListener(p<? super com.revenuecat.purchases.PurchaserInfo, ? super Boolean, w> p, l<? super com.revenuecat.purchases.PurchasesError, w> l2) {
        ListenerConversionsKt.logInSuccessListener.1 anon = new ListenerConversionsKt.logInSuccessListener.1(p, l2);
        return anon;
    }

    public static final void logInWith(com.revenuecat.purchases.Purchases purchases, String string2, l<? super com.revenuecat.purchases.PurchasesError, w> l3, p<? super com.revenuecat.purchases.PurchaserInfo, ? super Boolean, w> p4) {
        n.f(purchases, "$this$logInWith");
        n.f(string2, "appUserID");
        n.f(l3, "onError");
        n.f(p4, "onSuccess");
        purchases.logIn(string2, ListenerConversionsKt.logInSuccessListener(p4, l3));
    }

    public static void logInWith$default(com.revenuecat.purchases.Purchases purchases, String string2, l l3, p p4, int i5, Object object6) {
        l obj2;
        if (i5 &= 2 != 0) {
            obj2 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.logInWith(purchases, string2, obj2, p4);
    }

    public static final void logOutWith(com.revenuecat.purchases.Purchases purchases, l<? super com.revenuecat.purchases.PurchasesError, w> l2, l<? super com.revenuecat.purchases.PurchaserInfo, w> l3) {
        n.f(purchases, "$this$logOutWith");
        n.f(l2, "onError");
        n.f(l3, "onSuccess");
        purchases.logOut(ListenerConversionsKt.receivePurchaserInfoListener(l3, l2));
    }

    public static void logOutWith$default(com.revenuecat.purchases.Purchases purchases, l l2, l l3, int i4, Object object5) {
        l obj1;
        if (i4 &= 1 != 0) {
            obj1 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.logOutWith(purchases, obj1, l3);
    }

    public static final ProductChangeCallback productChangeCompletedListener(p<? super PurchaseDetails, ? super com.revenuecat.purchases.PurchaserInfo, w> p, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p2) {
        n.f(p, "onSuccess");
        n.f(p2, "onError");
        ListenerConversionsKt.productChangeCompletedListener.2 anon = new ListenerConversionsKt.productChangeCompletedListener.2(p, p2);
        return anon;
    }

    public static final ProductChangeListener productChangeCompletedListener(p<? super Purchase, ? super com.revenuecat.purchases.PurchaserInfo, w> p, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p2) {
        n.f(p, "onSuccess");
        n.f(p2, "onError");
        ListenerConversionsKt.productChangeCompletedListener.1 anon = new ListenerConversionsKt.productChangeCompletedListener.1(p, p2);
        return anon;
    }

    public static final PurchaseCallback purchaseCompletedCallback(p<? super PurchaseDetails, ? super com.revenuecat.purchases.PurchaserInfo, w> p, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p2) {
        n.f(p, "onSuccess");
        n.f(p2, "onError");
        ListenerConversionsKt.purchaseCompletedCallback.1 anon = new ListenerConversionsKt.purchaseCompletedCallback.1(p, p2);
        return anon;
    }

    public static final MakePurchaseListener purchaseCompletedListener(p<? super Purchase, ? super com.revenuecat.purchases.PurchaserInfo, w> p, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p2) {
        n.f(p, "onSuccess");
        n.f(p2, "onError");
        ListenerConversionsKt.purchaseCompletedListener.1 anon = new ListenerConversionsKt.purchaseCompletedListener.1(p, p2);
        return anon;
    }

    public static final void purchasePackageWith(com.revenuecat.purchases.Purchases purchases, Activity activity2, com.revenuecat.purchases.Package package3, com.revenuecat.purchases.UpgradeInfo upgradeInfo4, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p5, p<? super Purchase, ? super com.revenuecat.purchases.PurchaserInfo, w> p6) {
        n.f(purchases, "$this$purchasePackageWith");
        n.f(activity2, "activity");
        n.f(package3, "packageToPurchase");
        n.f(upgradeInfo4, "upgradeInfo");
        n.f(p5, "onError");
        n.f(p6, "onSuccess");
        purchases.purchasePackage(activity2, package3, upgradeInfo4, ListenerConversionsKt.productChangeCompletedListener(p6, p5));
    }

    public static final void purchasePackageWith(com.revenuecat.purchases.Purchases purchases, Activity activity2, com.revenuecat.purchases.Package package3, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p4, p<? super Purchase, ? super com.revenuecat.purchases.PurchaserInfo, w> p5) {
        n.f(purchases, "$this$purchasePackageWith");
        n.f(activity2, "activity");
        n.f(package3, "packageToPurchase");
        n.f(p4, "onError");
        n.f(p5, "onSuccess");
        purchases.purchasePackage(activity2, package3, ListenerConversionsKt.purchaseCompletedListener(p5, p4));
    }

    public static void purchasePackageWith$default(com.revenuecat.purchases.Purchases purchases, Activity activity2, com.revenuecat.purchases.Package package3, com.revenuecat.purchases.UpgradeInfo upgradeInfo4, p p5, p p6, int i7, Object object8) {
        p obj10;
        if (i7 &= 8 != 0) {
            obj10 = ListenerConversionsKt.ON_PURCHASE_ERROR_STUB;
        }
        ListenerConversionsKt.purchasePackageWith(purchases, activity2, package3, upgradeInfo4, obj10, p6);
    }

    public static void purchasePackageWith$default(com.revenuecat.purchases.Purchases purchases, Activity activity2, com.revenuecat.purchases.Package package3, p p4, p p5, int i6, Object object7) {
        p obj3;
        if (i6 &= 4 != 0) {
            obj3 = ListenerConversionsKt.ON_PURCHASE_ERROR_STUB;
        }
        ListenerConversionsKt.purchasePackageWith(purchases, activity2, package3, obj3, p5);
    }

    public static final void purchaseProductWith(com.revenuecat.purchases.Purchases purchases, Activity activity2, SkuDetails skuDetails3, com.revenuecat.purchases.UpgradeInfo upgradeInfo4, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p5, p<? super Purchase, ? super com.revenuecat.purchases.PurchaserInfo, w> p6) {
        n.f(purchases, "$this$purchaseProductWith");
        n.f(activity2, "activity");
        n.f(skuDetails3, "skuDetails");
        n.f(upgradeInfo4, "upgradeInfo");
        n.f(p5, "onError");
        n.f(p6, "onSuccess");
        purchases.purchaseProduct(activity2, skuDetails3, upgradeInfo4, ListenerConversionsKt.productChangeCompletedListener(p6, p5));
    }

    public static final void purchaseProductWith(com.revenuecat.purchases.Purchases purchases, Activity activity2, SkuDetails skuDetails3, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p4, p<? super Purchase, ? super com.revenuecat.purchases.PurchaserInfo, w> p5) {
        n.f(purchases, "$this$purchaseProductWith");
        n.f(activity2, "activity");
        n.f(skuDetails3, "skuDetails");
        n.f(p4, "onError");
        n.f(p5, "onSuccess");
        purchases.purchaseProduct(activity2, skuDetails3, ListenerConversionsKt.purchaseCompletedListener(p5, p4));
    }

    public static final void purchaseProductWith(com.revenuecat.purchases.Purchases purchases, Activity activity2, ProductDetails productDetails3, com.revenuecat.purchases.UpgradeInfo upgradeInfo4, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p5, p<? super PurchaseDetails, ? super com.revenuecat.purchases.PurchaserInfo, w> p6) {
        n.f(purchases, "$this$purchaseProductWith");
        n.f(activity2, "activity");
        n.f(productDetails3, "productDetails");
        n.f(upgradeInfo4, "upgradeInfo");
        n.f(p5, "onError");
        n.f(p6, "onSuccess");
        purchases.purchaseProduct$purchases_release(activity2, productDetails3, upgradeInfo4, ListenerConversionsKt.productChangeCompletedListener(p6, p5));
    }

    public static final void purchaseProductWith(com.revenuecat.purchases.Purchases purchases, Activity activity2, ProductDetails productDetails3, p<? super com.revenuecat.purchases.PurchasesError, ? super Boolean, w> p4, p<? super PurchaseDetails, ? super com.revenuecat.purchases.PurchaserInfo, w> p5) {
        n.f(purchases, "$this$purchaseProductWith");
        n.f(activity2, "activity");
        n.f(productDetails3, "productDetails");
        n.f(p4, "onError");
        n.f(p5, "onSuccess");
        purchases.purchaseProduct$purchases_release(activity2, productDetails3, ListenerConversionsKt.purchaseCompletedCallback(p5, p4));
    }

    public static void purchaseProductWith$default(com.revenuecat.purchases.Purchases purchases, Activity activity2, SkuDetails skuDetails3, com.revenuecat.purchases.UpgradeInfo upgradeInfo4, p p5, p p6, int i7, Object object8) {
        p obj10;
        if (i7 &= 8 != 0) {
            obj10 = ListenerConversionsKt.ON_PURCHASE_ERROR_STUB;
        }
        ListenerConversionsKt.purchaseProductWith(purchases, activity2, skuDetails3, upgradeInfo4, obj10, p6);
    }

    public static void purchaseProductWith$default(com.revenuecat.purchases.Purchases purchases, Activity activity2, SkuDetails skuDetails3, p p4, p p5, int i6, Object object7) {
        p obj3;
        if (i6 &= 4 != 0) {
            obj3 = ListenerConversionsKt.ON_PURCHASE_ERROR_STUB;
        }
        ListenerConversionsKt.purchaseProductWith(purchases, activity2, skuDetails3, obj3, p5);
    }

    public static void purchaseProductWith$default(com.revenuecat.purchases.Purchases purchases, Activity activity2, ProductDetails productDetails3, com.revenuecat.purchases.UpgradeInfo upgradeInfo4, p p5, p p6, int i7, Object object8) {
        p obj10;
        if (i7 &= 8 != 0) {
            obj10 = ListenerConversionsKt.ON_PURCHASE_ERROR_STUB;
        }
        ListenerConversionsKt.purchaseProductWith(purchases, activity2, productDetails3, upgradeInfo4, obj10, p6);
    }

    public static void purchaseProductWith$default(com.revenuecat.purchases.Purchases purchases, Activity activity2, ProductDetails productDetails3, p p4, p p5, int i6, Object object7) {
        p obj3;
        if (i6 &= 4 != 0) {
            obj3 = ListenerConversionsKt.ON_PURCHASE_ERROR_STUB;
        }
        ListenerConversionsKt.purchaseProductWith(purchases, activity2, productDetails3, obj3, p5);
    }

    public static final ReceiveOfferingsListener receiveOfferingsListener(l<? super com.revenuecat.purchases.Offerings, w> l, l<? super com.revenuecat.purchases.PurchasesError, w> l2) {
        n.f(l, "onSuccess");
        n.f(l2, "onError");
        ListenerConversionsKt.receiveOfferingsListener.1 anon = new ListenerConversionsKt.receiveOfferingsListener.1(l, l2);
        return anon;
    }

    public static final ReceivePurchaserInfoListener receivePurchaserInfoListener(l<? super com.revenuecat.purchases.PurchaserInfo, w> l, l<? super com.revenuecat.purchases.PurchasesError, w> l2) {
        ListenerConversionsKt.receivePurchaserInfoListener.1 anon = new ListenerConversionsKt.receivePurchaserInfoListener.1(l, l2);
        return anon;
    }

    public static final void resetWith(com.revenuecat.purchases.Purchases purchases, l<? super com.revenuecat.purchases.PurchasesError, w> l2, l<? super com.revenuecat.purchases.PurchaserInfo, w> l3) {
        n.f(purchases, "$this$resetWith");
        n.f(l2, "onError");
        n.f(l3, "onSuccess");
        purchases.reset(ListenerConversionsKt.receivePurchaserInfoListener(l3, l2));
    }

    public static void resetWith$default(com.revenuecat.purchases.Purchases purchases, l l2, l l3, int i4, Object object5) {
        l obj1;
        if (i4 &= 1 != 0) {
            obj1 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.resetWith(purchases, obj1, l3);
    }

    public static final void restorePurchasesWith(com.revenuecat.purchases.Purchases purchases, l<? super com.revenuecat.purchases.PurchasesError, w> l2, l<? super com.revenuecat.purchases.PurchaserInfo, w> l3) {
        n.f(purchases, "$this$restorePurchasesWith");
        n.f(l2, "onError");
        n.f(l3, "onSuccess");
        purchases.restorePurchases(ListenerConversionsKt.receivePurchaserInfoListener(l3, l2));
    }

    public static void restorePurchasesWith$default(com.revenuecat.purchases.Purchases purchases, l l2, l l3, int i4, Object object5) {
        l obj1;
        if (i4 &= 1 != 0) {
            obj1 = ListenerConversionsKt.ON_ERROR_STUB;
        }
        ListenerConversionsKt.restorePurchasesWith(purchases, obj1, l3);
    }
}
