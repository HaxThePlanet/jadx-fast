package com.google.firebase.crashlytics;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class CustomKeysAndValues {

    final Map<String, String> keysAndValues;

    public static class Builder {

        private Map<String, String> keysAndValues;
        public Builder() {
            super();
            HashMap hashMap = new HashMap();
            this.keysAndValues = hashMap;
        }

        static Map access$000(com.google.firebase.crashlytics.CustomKeysAndValues.Builder customKeysAndValues$Builder) {
            return builder.keysAndValues;
        }

        public com.google.firebase.crashlytics.CustomKeysAndValues build() {
            CustomKeysAndValues customKeysAndValues = new CustomKeysAndValues(this);
            return customKeysAndValues;
        }

        public com.google.firebase.crashlytics.CustomKeysAndValues.Builder putBoolean(String string, boolean z2) {
            this.keysAndValues.put(string, Boolean.toString(z2));
            return this;
        }

        public com.google.firebase.crashlytics.CustomKeysAndValues.Builder putDouble(String string, double d2) {
            this.keysAndValues.put(string, Double.toString(d2));
            return this;
        }

        public com.google.firebase.crashlytics.CustomKeysAndValues.Builder putFloat(String string, float f2) {
            this.keysAndValues.put(string, Float.toString(f2));
            return this;
        }

        public com.google.firebase.crashlytics.CustomKeysAndValues.Builder putInt(String string, int i2) {
            this.keysAndValues.put(string, Integer.toString(i2));
            return this;
        }

        public com.google.firebase.crashlytics.CustomKeysAndValues.Builder putLong(String string, long l2) {
            this.keysAndValues.put(string, Long.toString(l2));
            return this;
        }

        public com.google.firebase.crashlytics.CustomKeysAndValues.Builder putString(String string, String string2) {
            this.keysAndValues.put(string, string2);
            return this;
        }
    }
    CustomKeysAndValues(com.google.firebase.crashlytics.CustomKeysAndValues.Builder customKeysAndValues$Builder) {
        super();
        this.keysAndValues = CustomKeysAndValues.Builder.access$000(builder);
    }
}
