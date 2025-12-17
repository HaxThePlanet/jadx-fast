package com.appsflyer.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.ah;
import com.appsflyer.internal.cr;
import com.appsflyer.internal.cu;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public class CrossPromotionHelper {

    private static String AFInAppEventType = "https://%simpression.%s";

    static class d implements Runnable {

        private final cu AFInAppEventParameterName;
        private final WeakReference<Context> AFKeystoreWrapper;
        private final boolean valueOf;
        private final String values;
        d(String string, cu cu2, Context context3, boolean z4) {
            super();
            this.values = string;
            this.AFInAppEventParameterName = cu2;
            WeakReference obj1 = new WeakReference(context3);
            this.AFKeystoreWrapper = obj1;
            this.valueOf = z4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            cu aFInAppEventParameterName;
            Throwable th2;
            Object instrument;
            String responseCode;
            int i;
            Object valueOf;
            String str;
            Throwable th;
            if (this.valueOf) {
            }
            int i2 = 0;
            URL url = new URL(this.values);
            instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
            (HttpURLConnection)(URLConnection)instrument.setConnectTimeout(10000);
            aFInAppEventParameterName = 0;
            instrument.setInstanceFollowRedirects(aFInAppEventParameterName);
            responseCode = instrument.getResponseCode();
            if (responseCode != 200) {
                if (responseCode != 301 && responseCode != 302) {
                    if (responseCode != 302) {
                        StringBuilder stringBuilder = new StringBuilder("call to ");
                        stringBuilder.append(this.values);
                        stringBuilder.append(" failed: ");
                        stringBuilder.append(responseCode);
                        AFLogger.AFInAppEventType(stringBuilder.toString());
                    } else {
                        try {
                            StringBuilder stringBuilder2 = new StringBuilder("Cross promotion redirection success: ");
                            stringBuilder2.append(this.values);
                            AFLogger.valueOf(stringBuilder2.toString(), aFInAppEventParameterName);
                            aFInAppEventParameterName2.valueOf = instrument.getHeaderField("Location");
                            aFInAppEventParameterName = this.AFInAppEventParameterName;
                            if (this.AFInAppEventParameterName != null && this.AFKeystoreWrapper.get() != null && aFInAppEventParameterName.valueOf != null) {
                            }
                            if (this.AFKeystoreWrapper.get() != null) {
                            }
                            aFInAppEventParameterName2.valueOf = instrument.getHeaderField("Location");
                            aFInAppEventParameterName = this.AFInAppEventParameterName;
                            if (aFInAppEventParameterName.valueOf != null) {
                            }
                            valueOf = new Intent("android.intent.action.VIEW", Uri.parse(aFInAppEventParameterName.valueOf));
                            (Context)this.AFKeystoreWrapper.get().startActivity(valueOf.setFlags(268435456));
                            StringBuilder stringBuilder3 = new StringBuilder("Cross promotion impressions success: ");
                            stringBuilder3.append(this.values);
                            AFLogger.valueOf(stringBuilder3.toString(), aFInAppEventParameterName);
                            if (instrument != null) {
                            }
                            instrument.disconnect();
                            th2 = th3;
                            Throwable th3 = th;
                            AFLogger.AFInAppEventType(th3.getMessage(), th3);
                            if (th2 != null) {
                            }
                            th2.disconnect();
                            if (th2 == null) {
                            } else {
                            }
                            th2.disconnect();
                            throw th3;
                        } catch (Throwable th) {
                        }
                    }
                } else {
                }
            } else {
            }
        }
    }
    static {
    }

    private static com.appsflyer.share.LinkGenerator AFInAppEventParameterName(Context context, String string2, String string3, Map<String, String> map4, String string5) {
        String obj3;
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.AFKeystoreWrapper = string5;
        linkGenerator.valueOf = string2;
        linkGenerator.addParameter("af_siteid", context.getPackageName());
        if (string3 != null) {
            linkGenerator.setCampaign(string3);
        }
        if (map4 != null) {
            linkGenerator.addParameters(map4);
        }
        String obj2 = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (obj2 != null) {
            linkGenerator.addParameter("advertising_id", obj2);
        }
        return linkGenerator;
    }

    public static void logAndOpenStore(Context context, String string2, String string3) {
        CrossPromotionHelper.logAndOpenStore(context, string2, string3, 0);
    }

    public static void logAndOpenStore(Context context, String string2, String string3, Map<String, String> map4) {
        Object obj8;
        Object[] arr = new Object[2];
        final int i2 = 0;
        arr[i2] = AppsFlyerLib.getInstance().getHostPrefix();
        final int i3 = 1;
        arr[i3] = ah.AFKeystoreWrapper().getHostName();
        if (AppsFlyerProperties.getInstance().getBoolean("waitForCustomerId", i2)) {
            AFLogger.valueOf("CustomerUserId not set, track And Open Store is disabled", i3);
        }
        if (map4 == null) {
            obj8 = new HashMap();
        }
        obj8.put("af_campaign", string3);
        AppsFlyerLib.getInstance().logEvent(context, "af_cross_promotion", obj8);
        obj8 = new cu();
        CrossPromotionHelper.d obj7 = new CrossPromotionHelper.d(CrossPromotionHelper.AFInAppEventParameterName(context, string2, string3, map4, String.format(cr.valueOf, arr)).generateLink(), obj8, context, AppsFlyerLib.getInstance().isStopped());
        Thread obj5 = new Thread(obj7);
        obj5.start();
    }

    public static void logCrossPromoteImpression(Context context, String string2, String string3) {
        CrossPromotionHelper.logCrossPromoteImpression(context, string2, string3, 0);
    }

    public static void logCrossPromoteImpression(Context context, String string2, String string3, Map<String, String> map4) {
        int i2 = 0;
        int i = 1;
        if (AppsFlyerProperties.getInstance().getBoolean("waitForCustomerId", i2)) {
            AFLogger.valueOf("CustomerUserId not set, Promote Impression is disabled", i);
        }
        Object[] arr = new Object[2];
        arr[i2] = AppsFlyerLib.getInstance().getHostPrefix();
        arr[i] = ah.AFKeystoreWrapper().getHostName();
        final int obj8 = 0;
        CrossPromotionHelper.d obj6 = new CrossPromotionHelper.d(CrossPromotionHelper.AFInAppEventParameterName(context, string2, string3, map4, String.format(CrossPromotionHelper.AFInAppEventType, arr)).generateLink(), obj8, obj8, AppsFlyerLib.getInstance().isStopped());
        Thread obj5 = new Thread(obj6);
        obj5.start();
    }

    public static void setUrl(Map<String, String> map) {
        Object equals;
        Object value;
        int i2;
        int str;
        int i;
        int i3;
        Iterator obj6 = map.entrySet().iterator();
        while (obj6.hasNext()) {
            Object next2 = obj6.next();
            value = (Map.Entry)next2.getValue();
            equals = next2.getKey();
            i2 = -1;
            str = (String)equals.hashCode();
            i3 = 1;
            if (str != 96801) {
            } else {
            }
            if (equals.equals("app")) {
            }
            if (i2 != 0) {
            } else {
            }
            cr.valueOf = (String)value;
            if (i2 != i3) {
            } else {
            }
            CrossPromotionHelper.AFInAppEventType = value;
            i2 = 0;
            if (str != 120623625) {
            } else {
            }
            if (equals.equals("impression")) {
            }
            i2 = i3;
        }
    }
}
