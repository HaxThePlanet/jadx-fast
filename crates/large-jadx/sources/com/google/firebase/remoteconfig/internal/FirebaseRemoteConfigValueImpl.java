package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {

    private static final String ILLEGAL_ARGUMENT_STRING_FORMAT = "[Value: %s] cannot be converted to a %s.";
    private final int source;
    private final String value;
    FirebaseRemoteConfigValueImpl(String string, int i2) {
        super();
        this.value = string;
        this.source = i2;
    }

    private String asTrimmedString() {
        return asString().trim();
    }

    private void throwIfNullValue() {
        if (this.value == null) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        throw illegalArgumentException;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public boolean asBoolean() {
        final int i = 0;
        if (this.source == 0) {
            return i;
        }
        String trimmedString = asTrimmedString();
        final int i2 = 1;
        if (ConfigGetParameterHandler.TRUE_REGEX.matcher(trimmedString).matches()) {
            return i2;
        }
        if (!ConfigGetParameterHandler.FALSE_REGEX.matcher(trimmedString).matches()) {
        } else {
            return i;
        }
        Object[] arr = new Object[2];
        arr[i] = trimmedString;
        arr[i2] = "boolean";
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", arr));
        throw illegalArgumentException;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public byte[] asByteArray() {
        if (this.source == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        return this.value.getBytes(ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public double asDouble() {
        if (this.source == 0) {
            return 0;
        }
        return Double.valueOf(asTrimmedString()).doubleValue();
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public long asLong() {
        if (this.source == 0) {
            return 0;
        }
        return Long.valueOf(asTrimmedString()).longValue();
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public String asString() {
        if (this.source == 0) {
            return "";
        }
        throwIfNullValue();
        return this.value;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public int getSource() {
        return this.source;
    }
}
