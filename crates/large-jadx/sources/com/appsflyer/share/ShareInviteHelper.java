package com.appsflyer.share;

import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ShareInviteHelper {
    public static com.appsflyer.share.LinkGenerator generateInviteUrl(Context context) {
        String length;
        String string;
        LinkGenerator linkGenerator = new LinkGenerator("af_app_invites");
        com.appsflyer.share.LinkGenerator obj6 = linkGenerator.setBaseURL(AppsFlyerProperties.getInstance().getString("oneLinkSlug"), AppsFlyerProperties.getInstance().getString("onelinkDomain"), context.getPackageName()).setReferrerUID(AppsFlyerLib.getInstance().getAppsFlyerUID(context)).setReferrerCustomerId(AppsFlyerProperties.getInstance().getString("AppUserId")).addParameter("af_siteid", context.getPackageName());
        String string2 = AppsFlyerProperties.getInstance().getString("onelinkScheme");
        if (string2 != null && string2.length() > 3) {
            if (string2.length() > 3) {
                obj6.setBaseDeeplink(string2);
            }
        }
        return obj6;
    }

    public static void logInvite(Context context, String string2, Map<String, String> map3) {
        Object userParams;
        boolean equals;
        String obj5;
        if (TextUtils.isEmpty(string2)) {
            AFLogger.init("[Invite] Cannot report App-Invite with null/empty channel");
        }
        if (AppsFlyerProperties.getInstance().getBoolean("waitForCustomerId", false)) {
            AFLogger.valueOf("CustomerUserId not set, report Invite is disabled", true);
        }
        userParams = ShareInviteHelper.generateInviteUrl(context);
        userParams.addParameters(map3);
        AFLogger.values("[Invite] Reporting App-Invite via channel: ".concat(String.valueOf(string2)));
        obj5 = new StringBuilder("[Invite] Generated URL: ");
        obj5.append(userParams.generateLink());
        AFLogger.values(obj5.toString());
        obj5 = userParams.getMediaSource();
        if ("af_app_invites".equals(obj5)) {
            obj5 = "af_invite";
        } else {
            if ("af_user_share".equals(obj5)) {
                obj5 = "af_share";
            }
        }
        HashMap hashMap = new HashMap();
        if (userParams.getUserParams() != null) {
            hashMap.putAll(userParams.getUserParams());
        }
        hashMap.put("af_channel", string2);
        AppsFlyerLib.getInstance().logEvent(context, obj5, hashMap);
    }
}
