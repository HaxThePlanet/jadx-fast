package com.google.firebase.perf.network;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

/* loaded from: classes2.dex */
public final class NetworkRequestMetricBuilderUtil {

    private static final Pattern FLG_USER_AGENT_PATTERN;
    static {
        NetworkRequestMetricBuilderUtil.FLG_USER_AGENT_PATTERN = Pattern.compile("(^|.*\\s)datatransport/\\S+ android/($|\\s.*)");
    }

    public static Long getApacheHttpMessageContentLength(HttpMessage httpMessage) {
        String str;
        Header obj2;
        try {
            obj2 = httpMessage.getFirstHeader("content-length");
            if (obj2 != null) {
            }
            return Long.valueOf(Long.parseLong(obj2.getValue()));
            httpMessage = AndroidLogger.getInstance();
            httpMessage.debug("The content-length value is not a valid number");
            return null;
        }
    }

    public static String getApacheHttpResponseContentType(HttpResponse httpResponse) {
        Object obj1;
        obj1 = httpResponse.getFirstHeader("content-type");
        obj1 = obj1.getValue();
        if (obj1 != null && obj1 != null) {
            obj1 = obj1.getValue();
            if (obj1 != null) {
                return obj1;
            }
        }
        return null;
    }

    public static boolean isAllowedUserAgent(String string) {
        Pattern fLG_USER_AGENT_PATTERN;
        int obj1;
        if (string != null) {
            if (!NetworkRequestMetricBuilderUtil.FLG_USER_AGENT_PATTERN.matcher(string).matches()) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static void logError(NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        if (!networkRequestMetricBuilder.hasHttpResponseCode()) {
            networkRequestMetricBuilder.setNetworkClientErrorReason();
        }
        networkRequestMetricBuilder.build();
    }
}
