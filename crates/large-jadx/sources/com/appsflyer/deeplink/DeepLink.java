package com.appsflyer.deeplink;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeepLink {

    public final JSONObject values;
    private DeepLink(JSONObject jSONObject) {
        super();
        this.values = jSONObject;
    }

    public static com.appsflyer.deeplink.DeepLink AFKeystoreWrapper(Map<String, String> map) {
        String next;
        String str;
        String str2;
        Set keySet = map.keySet();
        keySet.removeAll(Arrays.asList(/* result */));
        HashMap hashMap = new HashMap();
        Iterator iterator = keySet.iterator();
        for (String next : iterator) {
            hashMap.put(next, map.get(next));
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        return DeepLink.AFKeystoreWrapper(jSONObject);
    }

    public static com.appsflyer.deeplink.DeepLink AFKeystoreWrapper(JSONObject jSONObject) {
        Object keys;
        Object next;
        Object obj;
        keys = "custom_params";
        final JSONObject optJSONObject = jSONObject.optJSONObject(keys);
        if (optJSONObject != null) {
            jSONObject.remove(keys);
            keys = optJSONObject.keys();
            for (String next : keys) {
                jSONObject.put(next, optJSONObject.opt(next));
            }
        }
        DeepLink deepLink = new DeepLink(jSONObject);
        return deepLink;
    }

    public String getAfSub1() {
        Object obj;
        if (this.values.opt("af_sub1") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getAfSub2() {
        Object obj;
        if (this.values.opt("af_sub2") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getAfSub3() {
        Object obj;
        if (this.values.opt("af_sub3") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getAfSub4() {
        Object obj;
        if (this.values.opt("af_sub4") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getAfSub5() {
        Object obj;
        if (this.values.opt("af_sub5") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getCampaign() {
        Object obj;
        if (this.values.opt("campaign") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getCampaignId() {
        Object obj;
        if (this.values.opt("campaign_id") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public JSONObject getClickEvent() {
        return this.values;
    }

    public String getClickHttpReferrer() {
        Object obj;
        if (this.values.opt("click_http_referrer") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getDeepLinkValue() {
        Object obj;
        if (this.values.opt("deep_link_value") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getMatchType() {
        Object obj;
        if (this.values.opt("match_type") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getMediaSource() {
        Object obj;
        if (this.values.opt("media_source") == JSONObject.NULL) {
            obj = 0;
        }
        return (String)obj;
    }

    public String getStringValue(String string) {
        Object obj3;
        final int i = 0;
        if (this.values.opt(string) == JSONObject.NULL) {
            obj3 = i;
        }
        if (obj3 == null) {
            return i;
        }
        return String.valueOf(obj3);
    }

    public Boolean isDeferred() {
        Object obj;
        if (this.values.opt("is_deferred") == JSONObject.NULL) {
            obj = 0;
        }
        return (Boolean)obj;
    }

    public String toString() {
        return this.values.toString();
    }
}
