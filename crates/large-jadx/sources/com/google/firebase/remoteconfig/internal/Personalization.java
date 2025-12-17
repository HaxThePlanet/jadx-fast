package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Personalization {

    public static final String ANALYTICS_ORIGIN_PERSONALIZATION = "fp";
    public static final String ARM_INDEX = "armIndex";
    public static final String CHOICE_ID = "choiceId";
    public static final String EXTERNAL_ARM_INDEX_PARAM = "arm_index";
    public static final String EXTERNAL_ARM_VALUE_PARAM = "arm_value";
    public static final String EXTERNAL_EVENT = "personalization_assignment";
    public static final String EXTERNAL_GROUP_PARAM = "group";
    public static final String EXTERNAL_PERSONALIZATION_ID_PARAM = "personalization_id";
    public static final String EXTERNAL_RC_PARAMETER_PARAM = "arm_key";
    public static final String GROUP = "group";
    public static final String INTERNAL_CHOICE_ID_PARAM = "_fpid";
    public static final String INTERNAL_EVENT = "_fpc";
    public static final String PERSONALIZATION_ID = "personalizationId";
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final Map<String, String> loggedChoiceIds;
    public Personalization(Provider<AnalyticsConnector> provider) {
        super();
        HashMap hashMap = new HashMap();
        this.loggedChoiceIds = Collections.synchronizedMap(hashMap);
        this.analyticsConnector = provider;
    }

    public void logArmActive(String string, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer2) {
        Object obj = this.analyticsConnector.get();
        if ((AnalyticsConnector)obj == null) {
        }
        JSONObject personalizationMetadata = configContainer2.getPersonalizationMetadata();
        int i = 1;
        if (personalizationMetadata.length() < i) {
        }
        JSONObject obj7 = configContainer2.getConfigs();
        if (obj7.length() < i) {
        }
        JSONObject optJSONObject = personalizationMetadata.optJSONObject(string);
        if (optJSONObject == null) {
        }
        String optString = optJSONObject.optString("choiceId");
        if (optString.isEmpty()) {
        }
        Map loggedChoiceIds = this.loggedChoiceIds;
        synchronized (loggedChoiceIds) {
        }
    }
}
