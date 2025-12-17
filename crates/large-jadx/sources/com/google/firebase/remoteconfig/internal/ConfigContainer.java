package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConfigContainer {

    static final String ABT_EXPERIMENTS_KEY = "abt_experiments_key";
    static final String CONFIGS_KEY = "configs_key";
    private static final Date DEFAULTS_FETCH_TIME = null;
    static final String FETCH_TIME_KEY = "fetch_time_key";
    static final String PERSONALIZATION_METADATA_KEY = "personalization_metadata_key";
    private JSONArray abtExperiments;
    private JSONObject configsJson;
    private JSONObject containerJson;
    private Date fetchTime;
    private JSONObject personalizationMetadata;

    public static class Builder {

        private JSONArray builderAbtExperiments;
        private JSONObject builderConfigsJson;
        private Date builderFetchTime;
        private JSONObject builderPersonalizationMetadata;
        private Builder() {
            super();
            JSONObject jSONObject = new JSONObject();
            this.builderConfigsJson = jSONObject;
            this.builderFetchTime = ConfigContainer.access$000();
            JSONArray jSONArray = new JSONArray();
            this.builderAbtExperiments = jSONArray;
            JSONObject jSONObject2 = new JSONObject();
            this.builderPersonalizationMetadata = jSONObject2;
        }

        Builder(com.google.firebase.remoteconfig.internal.ConfigContainer.1 configContainer$1) {
            super();
        }

        public Builder(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer) {
            super();
            this.builderConfigsJson = configContainer.getConfigs();
            this.builderFetchTime = configContainer.getFetchTime();
            this.builderAbtExperiments = configContainer.getAbtExperiments();
            this.builderPersonalizationMetadata = configContainer.getPersonalizationMetadata();
        }

        public com.google.firebase.remoteconfig.internal.ConfigContainer build() {
            super(this.builderConfigsJson, this.builderFetchTime, this.builderAbtExperiments, this.builderPersonalizationMetadata, 0);
            return configContainer2;
        }

        public com.google.firebase.remoteconfig.internal.ConfigContainer.Builder replaceConfigsWith(Map<String, String> map) {
            JSONObject jSONObject = new JSONObject(map);
            this.builderConfigsJson = jSONObject;
            return this;
        }

        public com.google.firebase.remoteconfig.internal.ConfigContainer.Builder replaceConfigsWith(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                this.builderConfigsJson = jSONObject2;
                return this;
            }
        }

        public com.google.firebase.remoteconfig.internal.ConfigContainer.Builder withAbtExperiments(JSONArray jSONArray) {
            try {
                JSONArray jSONArray2 = new JSONArray(jSONArray.toString());
                this.builderAbtExperiments = jSONArray2;
                return this;
            }
        }

        public com.google.firebase.remoteconfig.internal.ConfigContainer.Builder withFetchTime(Date date) {
            this.builderFetchTime = date;
            return this;
        }

        public com.google.firebase.remoteconfig.internal.ConfigContainer.Builder withPersonalizationMetadata(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                this.builderPersonalizationMetadata = jSONObject2;
                return this;
            }
        }
    }
    static {
        Date date = new Date(0, obj2);
        ConfigContainer.DEFAULTS_FETCH_TIME = date;
    }

    private ConfigContainer(JSONObject jSONObject, Date date2, JSONArray jSONArray3, JSONObject jSONObject4) {
        super();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date2.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray3);
        jSONObject2.put("personalization_metadata_key", jSONObject4);
        this.configsJson = jSONObject;
        this.fetchTime = date2;
        this.abtExperiments = jSONArray3;
        this.personalizationMetadata = jSONObject4;
        this.containerJson = jSONObject2;
    }

    ConfigContainer(JSONObject jSONObject, Date date2, JSONArray jSONArray3, JSONObject jSONObject4, com.google.firebase.remoteconfig.internal.ConfigContainer.1 configContainer$15) {
        super(jSONObject, date2, jSONArray3, jSONObject4);
    }

    static Date access$000() {
        return ConfigContainer.DEFAULTS_FETCH_TIME;
    }

    static com.google.firebase.remoteconfig.internal.ConfigContainer copyOf(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject.optJSONObject("personalization_metadata_key") == null) {
            optJSONObject = new JSONObject();
        }
        Date date = new Date(jSONObject.getLong("fetch_time_key"), obj5);
        ConfigContainer configContainer = new ConfigContainer(jSONObject.getJSONObject("configs_key"), date, jSONObject.getJSONArray("abt_experiments_key"), optJSONObject);
        return configContainer;
    }

    public static com.google.firebase.remoteconfig.internal.ConfigContainer.Builder newBuilder() {
        ConfigContainer.Builder builder = new ConfigContainer.Builder(0);
        return builder;
    }

    public static com.google.firebase.remoteconfig.internal.ConfigContainer.Builder newBuilder(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer) {
        ConfigContainer.Builder builder = new ConfigContainer.Builder(configContainer);
        return builder;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof ConfigContainer) {
            return 0;
        }
        return this.containerJson.toString().equals((ConfigContainer)object.toString());
    }

    public JSONArray getAbtExperiments() {
        return this.abtExperiments;
    }

    public JSONObject getConfigs() {
        return this.configsJson;
    }

    public Date getFetchTime() {
        return this.fetchTime;
    }

    public JSONObject getPersonalizationMetadata() {
        return this.personalizationMetadata;
    }

    public int hashCode() {
        return this.containerJson.hashCode();
    }

    public String toString() {
        return this.containerJson.toString();
    }
}
