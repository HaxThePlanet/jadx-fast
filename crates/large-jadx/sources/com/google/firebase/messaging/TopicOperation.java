package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.p;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class TopicOperation {

    private static final Pattern TOPIC_NAME_REGEXP;
    private final String operation;
    private final String serializedString;
    private final String topic;
    static {
        TopicOperation.TOPIC_NAME_REGEXP = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    }

    private TopicOperation(String string, String string2) {
        super();
        this.topic = TopicOperation.normalizeTopicOrThrow(string2, string);
        this.operation = string;
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(string);
        stringBuilder.append("!");
        stringBuilder.append(string2);
        this.serializedString = stringBuilder.toString();
    }

    static com.google.firebase.messaging.TopicOperation from(String string) {
        int i2 = 0;
        if (TextUtils.isEmpty(string)) {
            return i2;
        }
        String[] obj3 = string.split("!", -1);
        if (obj3.length != 2) {
            return i2;
        }
        TopicOperation topicOperation = new TopicOperation(obj3[0], obj3[1]);
        return topicOperation;
    }

    private static String normalizeTopicOrThrow(String string, String string2) {
        boolean startsWith;
        String obj3;
        Object obj4;
        final int i = 1;
        final int i2 = 0;
        if (string != null && string.startsWith("/topics/")) {
            if (string.startsWith("/topics/")) {
                Object[] arr2 = new Object[i];
                arr2[i2] = string2;
                Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", arr2));
                obj3 = string.substring(8);
            }
        }
        if (obj3 == null) {
        } else {
            if (!TopicOperation.TOPIC_NAME_REGEXP.matcher(obj3).matches()) {
            } else {
                return obj3;
            }
        }
        Object[] arr = new Object[2];
        arr[i2] = obj3;
        arr[i] = "[a-zA-Z0-9-_.~%]{1,900}";
        obj4 = new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", arr));
        throw obj4;
    }

    public static com.google.firebase.messaging.TopicOperation subscribe(String string) {
        TopicOperation topicOperation = new TopicOperation("S", string);
        return topicOperation;
    }

    public static com.google.firebase.messaging.TopicOperation unsubscribe(String string) {
        TopicOperation topicOperation = new TopicOperation("U", string);
        return topicOperation;
    }

    public boolean equals(Object object) {
        boolean operation;
        Object obj4;
        final int i = 0;
        if (!object instanceof TopicOperation) {
            return i;
        }
        if (this.topic.equals(object.topic) && this.operation.equals(object.operation)) {
            if (this.operation.equals(object.operation)) {
                return 1;
            }
        }
        return i;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getTopic() {
        return this.topic;
    }

    public int hashCode() {
        Object[] arr = new Object[2];
        return p.b(this.operation, this.topic);
    }

    public String serialize() {
        return this.serializedString;
    }
}
