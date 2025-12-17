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

/* loaded from: classes2.dex */
public final class a {

    public static final int a;
    static {
        a.a = Runtime.getRuntime().availableProcessors();
    }

    public static int a(Bundle bundle, String string2) {
        String obj3;
        final int i = 6;
        if (bundle == null) {
            a.k(string2, "Unexpected null bundle received!");
            return i;
        }
        obj3 = bundle.get("RESPONSE_CODE");
        if (obj3 == null) {
            a.j(string2, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj3 instanceof Integer) {
            return (Integer)obj3.intValue();
        }
        obj3 = String.valueOf(obj3.getClass().getName());
        String str2 = "Unexpected type for bundle response code: ";
        if (obj3.length() != 0) {
            obj3 = str2.concat(obj3);
        } else {
            obj3 = new String(str2);
        }
        a.k(string2, obj3);
        return i;
    }

    public static Bundle b(a a, String string2) {
        Bundle obj1 = new Bundle();
        obj1.putString("playBillingLibraryVersion", string2);
        return obj1;
    }

    public static Bundle c(h h, boolean z2, String string3) {
        String obj1;
        Bundle obj0 = new Bundle();
        if (z2 != null) {
            obj0.putString("playBillingLibraryVersion", string3);
        }
        return obj0;
    }

    public static Bundle d(int i, boolean z2, String string3, String string4, ArrayList<c0> arrayList5) {
        int i2;
        String str;
        int i3;
        int obj3;
        String obj4;
        Bundle obj6 = new Bundle();
        i2 = 9;
        if (i >= i2) {
            obj6.putString("playBillingLibraryVersion", string3);
        }
        final int obj5 = 1;
        if (i >= i2 && z2 != null) {
            if (z2 != null) {
                obj6.putBoolean("enablePendingPurchases", obj5);
            }
        }
        if (i >= 14) {
            obj3 = new ArrayList();
            str = i2;
            while (i2 < arrayList5.size()) {
                Object obj = arrayList5.get(i2);
                int i4 = 0;
                obj3.add(i4);
                str |= i3;
                i2++;
            }
            if (str != null) {
                obj6.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", obj3);
            }
        }
        return obj6;
    }

    public static Bundle e(f f, boolean z2, boolean z3, String string4) {
        String str;
        boolean arrayList;
        boolean empty;
        String str2;
        String obj4;
        int obj7;
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", string4);
        if (f.d() != 0) {
            bundle.putInt("prorationMode", f.d());
        }
        if (!TextUtils.isEmpty(f.h())) {
            bundle.putString("accountId", f.h());
        }
        if (!TextUtils.isEmpty(f.i())) {
            bundle.putString("obfuscatedProfileId", f.i());
        }
        int i = 1;
        if (f.a()) {
            bundle.putBoolean("vr", i);
        }
        obj7 = 0;
        if (!TextUtils.isEmpty(obj7)) {
            arrayList = new ArrayList(Arrays.asList(/* result */));
            bundle.putStringArrayList("skusToReplace", arrayList);
        }
        if (!TextUtils.isEmpty(f.j())) {
            bundle.putString("oldSkuPurchaseToken", f.j());
        }
        if (!TextUtils.isEmpty(obj7)) {
            bundle.putString("oldSkuPurchaseId", obj7);
        }
        if (!TextUtils.isEmpty(obj7)) {
            bundle.putString("paymentsPurchaseParams", obj7);
        }
        if (z2 && z3) {
            if (z3) {
                bundle.putBoolean("enablePendingPurchases", i);
            }
        }
        return bundle;
    }

    public static Bundle f(boolean z, boolean z2, String string3) {
        int obj2;
        String obj3;
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", string3);
        if (z != 0 && z2 != null) {
            if (z2 != null) {
                bundle.putBoolean("enablePendingPurchases", true);
            }
        }
        return bundle;
    }

    public static g g(Intent intent, String string2) {
        if (intent == null) {
            a.k("BillingHelper", "Got null intent!");
            g.a obj2 = g.c();
            obj2.c(6);
            obj2.b("An internal error occurred.");
            return obj2.a();
        }
        final g.a aVar = g.c();
        aVar.c(a.a(intent.getExtras(), string2));
        aVar.b(a.h(intent.getExtras(), string2));
        return aVar.a();
    }

    public static String h(Bundle bundle, String string2) {
        String obj3;
        final String str = "";
        if (bundle == null) {
            a.k(string2, "Unexpected null bundle received!");
            return str;
        }
        obj3 = bundle.get("DEBUG_MESSAGE");
        if (obj3 == null) {
            a.j(string2, "getDebugMessageFromBundle() got null response code, assuming OK");
            return str;
        }
        if (obj3 instanceof String != null) {
            return (String)obj3;
        }
        obj3 = String.valueOf(obj3.getClass().getName());
        String str3 = "Unexpected type for debug message: ";
        if (obj3.length() != 0) {
            obj3 = str3.concat(obj3);
        } else {
            obj3 = new String(str3);
        }
        a.k(string2, obj3);
        return str;
    }

    public static List<Purchase> i(Bundle bundle) {
        int size;
        Object stringArrayList;
        Object stringArrayList2;
        Object str;
        int obj5;
        size = 0;
        if (bundle == null) {
            return size;
        }
        stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList != null) {
            if (stringArrayList2 == null) {
                stringArrayList = "BillingHelper";
                a.k(stringArrayList, "Couldn't find purchase lists, trying to find single data.");
                obj5 = a.l(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
                if (obj5 == null) {
                    a.k(stringArrayList, "Couldn't find single purchase data as well.");
                    return size;
                }
                arrayList.add(obj5);
            } else {
                obj5 = 0;
                while (obj5 < stringArrayList.size()) {
                    if (obj5 < stringArrayList2.size()) {
                    }
                    size = a.l((String)stringArrayList.get(obj5), (String)stringArrayList2.get(obj5));
                    if (size != 0) {
                    }
                    obj5++;
                    arrayList.add(size);
                }
            }
        } else {
        }
        return arrayList;
    }

    public static void j(String string, String string2) {
        if (Log.isLoggable(string, 2)) {
            Log.v(string, string2);
        }
    }

    public static void k(String string, String string2) {
        if (Log.isLoggable(string, 5)) {
            Log.w(string, string2);
        }
    }

    private static Purchase l(String string, String string2) {
        Purchase purchase;
        String obj3;
        String obj4;
        if (string != null) {
            if (string2 == null) {
            } else {
                purchase = new Purchase(string, string2);
            }
            return purchase;
        }
        a.k("BillingHelper", "Received a bad purchase data.");
        return null;
    }
}
