package com.google.firebase.abt;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class AbtExperimentInfo {

    private static final String[] ALL_REQUIRED_KEYS = null;
    static final String EXPERIMENT_ID_KEY = "experimentId";
    static final String EXPERIMENT_START_TIME_KEY = "experimentStartTime";
    static final String TIME_TO_LIVE_KEY = "timeToLiveMillis";
    static final String TRIGGER_EVENT_KEY = "triggerEvent";
    static final String TRIGGER_TIMEOUT_KEY = "triggerTimeoutMillis";
    static final String VARIANT_ID_KEY = "variantId";
    static final DateFormat protoTimestampStringParser;
    private final String experimentId;
    private final Date experimentStartTime;
    private final long timeToLiveInMillis;
    private final String triggerEventName;
    private final long triggerTimeoutInMillis;
    private final String variantId;
    static {
        AbtExperimentInfo.ALL_REQUIRED_KEYS = /* result */;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        AbtExperimentInfo.protoTimestampStringParser = simpleDateFormat;
    }

    public AbtExperimentInfo(String string, String string2, String string3, Date date4, long l5, long l6) {
        super();
        this.experimentId = string;
        this.variantId = string2;
        this.triggerEventName = string3;
        this.experimentStartTime = date4;
        this.triggerTimeoutInMillis = l5;
        this.timeToLiveInMillis = obj7;
    }

    static com.google.firebase.abt.AbtExperimentInfo fromConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        String triggerEventName;
        if (conditionalUserProperty.triggerEventName != null) {
        } else {
            triggerEventName = "";
        }
        Date date = new Date(conditionalUserProperty.creationTimestamp, obj7);
        super(conditionalUserProperty.name, String.valueOf(conditionalUserProperty.value), triggerEventName, date, conditionalUserProperty.triggerTimeout, obj7, conditionalUserProperty.timeToLive, obj9);
        return abtExperimentInfo;
    }

    static com.google.firebase.abt.AbtExperimentInfo fromMap(Map<String, String> map) {
        Object obj12;
        final String str = "triggerEvent";
        AbtExperimentInfo.validateExperimentInfoMap(map);
        if (map.containsKey(str)) {
            obj12 = map.get(str);
        } else {
            obj12 = "";
        }
        super((String)map.get("experimentId"), (String)map.get("variantId"), obj12, AbtExperimentInfo.protoTimestampStringParser.parse((String)map.get("experimentStartTime")), Long.parseLong((String)map.get("triggerTimeoutMillis")), obj9, Long.parseLong((String)map.get("timeToLiveMillis")), obj11);
        return abtExperimentInfo;
    }

    static void validateAbtExperimentInfo(com.google.firebase.abt.AbtExperimentInfo abtExperimentInfo) {
        AbtExperimentInfo.validateExperimentInfoMap(abtExperimentInfo.toStringMap());
    }

    private static void validateExperimentInfoMap(Map<String, String> map) {
        int i;
        String str;
        boolean key;
        ArrayList arrayList = new ArrayList();
        String[] aLL_REQUIRED_KEYS = AbtExperimentInfo.ALL_REQUIRED_KEYS;
        final int i3 = 0;
        i = i3;
        while (i < aLL_REQUIRED_KEYS.length) {
            str = aLL_REQUIRED_KEYS[i];
            if (!map.containsKey(str)) {
            }
            i++;
            arrayList.add(str);
        }
        if (!arrayList.isEmpty()) {
        } else {
        }
        Object[] arr = new Object[1];
        arr[i3] = arrayList;
        AbtException obj7 = new AbtException(String.format("The following keys are missing from the experiment info map: %s", arr));
        throw obj7;
    }

    String getExperimentId() {
        return this.experimentId;
    }

    long getStartTimeInMillisSinceEpoch() {
        return this.experimentStartTime.getTime();
    }

    long getTimeToLiveInMillis() {
        return this.timeToLiveInMillis;
    }

    String getTriggerEventName() {
        return this.triggerEventName;
    }

    long getTriggerTimeoutInMillis() {
        return this.triggerTimeoutInMillis;
    }

    String getVariantId() {
        return this.variantId;
    }

    AnalyticsConnector.ConditionalUserProperty toConditionalUserProperty(String string) {
        int obj4;
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = string;
        conditionalUserProperty.creationTimestamp = getStartTimeInMillisSinceEpoch();
        conditionalUserProperty.name = this.experimentId;
        conditionalUserProperty.value = this.variantId;
        obj4 = TextUtils.isEmpty(this.triggerEventName) ? 0 : this.triggerEventName;
        conditionalUserProperty.triggerEventName = obj4;
        conditionalUserProperty.triggerTimeout = this.triggerTimeoutInMillis;
        conditionalUserProperty.timeToLive = this.timeToLiveInMillis;
        return conditionalUserProperty;
    }

    Map<String, String> toStringMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("experimentId", this.experimentId);
        hashMap.put("variantId", this.variantId);
        hashMap.put("triggerEvent", this.triggerEventName);
        String str4 = "experimentStartTime";
        hashMap.put(str4, AbtExperimentInfo.protoTimestampStringParser.format(this.experimentStartTime));
        String str5 = "triggerTimeoutMillis";
        hashMap.put(str5, Long.toString(this.triggerTimeoutInMillis));
        hashMap.put("timeToLiveMillis", Long.toString(this.timeToLiveInMillis));
        return hashMap;
    }
}
