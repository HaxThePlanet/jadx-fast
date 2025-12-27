package f.c.a.d.b.i;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.a;
import com.android.billingclient.api.c0;
import com.android.billingclient.api.f;
import com.android.billingclient.api.g;
import com.android.billingclient.api.g.a;
import com.android.billingclient.api.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes2.dex */
public final class a {

    public static final int a = 0;
    static {
        a.a = Runtime.getRuntime().availableProcessors();
    }

    public static int a(Bundle bundle, String str) throws java.io.UnsupportedEncodingException {
        String concatenated;
        final int i = 6;
        if (bundle == null) {
            a.k(str, "Unexpected null bundle received!");
            return i;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            a.j(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return obj.intValue();
        }
        String str5 = String.valueOf(obj.getClass().getName());
        String str3 = "Unexpected type for bundle response code: ";
        if (str5.length() != 0) {
            concatenated = str3.concat(str5);
        } else {
            concatenated = new String(str3);
        }
        a.k(str, concatenated);
        return i;
    }

    public static Bundle b(a aVar, String str) {
        final Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        return bundle;
    }

    public static Bundle c(h hVar, boolean z, String str) {
        final Bundle bundle = new Bundle();
        if (z) {
            str = "playBillingLibraryVersion";
            bundle.putString(str, str);
        }
        return bundle;
    }

    public static Bundle d(int i, boolean z, String str, String str2, ArrayList<c0> arrayList) {
        int i2 = 0;
        int i3;
        final Bundle bundle = new Bundle();
        i2 = 9;
        if (i >= i2) {
            str = "playBillingLibraryVersion";
            bundle.putString(str, str);
        }
        z = true;
        if (i >= i2 && z) {
            str2 = "enablePendingPurchases";
            bundle.putBoolean(str2, z);
        }
        int size = 14;
        if (i >= 14) {
            arrayList = new ArrayList();
            i2 = 0;
            while (i2 < arrayList.size()) {
                Object obj = null;
                arrayList.add(obj);
                i3 = TextUtils.isEmpty(obj) ^ z;
                i2 = i2 | i3;
                i2 = i2 + 1;
            }
            if (i2 != 0) {
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList);
            }
        }
        return bundle;
    }

    public static Bundle e(f fVar, boolean z, boolean z2, String str) {
        boolean empty4;
        final Bundle bundle = new Bundle();
        str = "playBillingLibraryVersion";
        bundle.putString(str, str);
        if (fVar.d() != 0) {
            str = "prorationMode";
            bundle.putInt(str, fVar.d());
        }
        if (!TextUtils.isEmpty(fVar.h())) {
            str = "accountId";
            bundle.putString(str, fVar.h());
        }
        if (!TextUtils.isEmpty(fVar.i())) {
            str = "obfuscatedProfileId";
            bundle.putString(str, fVar.i());
        }
        boolean z4 = true;
        if (fVar.a()) {
            bundle.putBoolean("vr", z4);
        }
        java.lang.CharSequence charSequence = null;
        if (!TextUtils.isEmpty(charSequence)) {
            str2 = "skusToReplace";
            bundle.putStringArrayList(str2, new ArrayList(Arrays.asList(new String[] { charSequence })));
        }
        if (!TextUtils.isEmpty(fVar.j())) {
            bundle.putString("oldSkuPurchaseToken", fVar.j());
        }
        if (!TextUtils.isEmpty(charSequence)) {
            bundle.putString("oldSkuPurchaseId", charSequence);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            bundle.putString("paymentsPurchaseParams", charSequence);
        }
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", z4);
        }
        return bundle;
    }

    public static Bundle f(boolean z, boolean z2, String str) {
        final Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (z && z2) {
            boolean z3 = true;
            str = "enablePendingPurchases";
            bundle.putBoolean(str, z3);
        }
        return bundle;
    }

    public static g g(Intent intent, String str) {
        if (intent == null) {
            a.k("BillingHelper", "Got null intent!");
            g.a aVar2 = g.c();
            aVar2.c(6);
            aVar2.b("An internal error occurred.");
            return aVar2.a();
        }
        final g.a aVar = g.c();
        aVar.c(a.a(intent.getExtras(), str));
        aVar.b(a.h(intent.getExtras(), str));
        return aVar.a();
    }

    public static String h(Bundle bundle, String str) throws java.io.UnsupportedEncodingException {
        String concatenated;
        str = "";
        if (bundle == null) {
            a.k(str, "Unexpected null bundle received!");
            return str;
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            a.j(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return str;
        }
        if (obj instanceof String) {
            return obj;
        }
        String str6 = String.valueOf(obj.getClass().getName());
        String str4 = "Unexpected type for debug message: ";
        if (str6.length() != 0) {
            concatenated = str4.concat(str6);
        } else {
            concatenated = new String(str4);
        }
        a.k(str, concatenated);
        return str;
    }

    public static List<Purchase> i(Bundle bundle) {
        Object item;
        int i = 0;
        int size = 0;
        if (bundle == null) {
            return null;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        final ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            str = "BillingHelper";
            a.k(str, "Couldn't find purchase lists, trying to find single data.");
            str2 = "INAPP_DATA_SIGNATURE";
            Purchase purchase = a.l(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString(str2));
            if (purchase == null) {
                a.k(str, "Couldn't find single purchase data as well.");
                return size;
            }
            arrayList.add(purchase);
        }
        return arrayList;
    }

    public static void j(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void k(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    private static Purchase l(String str, String str2) {
        a.k("BillingHelper", "Received a bad purchase data.");
        return null;
    }
}
