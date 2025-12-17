package com.google.firebase.perf.logging;

/* loaded from: classes2.dex */
public final class ConsoleUrlGenerator {

    private static final String URL_BASE_PATH = "https://console.firebase.google.com";
    private static final String UTM_MEDIUM = "android-ide";
    private static final String UTM_SOURCE = "perf-android-sdk";
    public static String generateCustomTraceUrl(String string, String string2, String string3) {
        Object[] obj2 = new Object[4];
        return String.format("%s/metrics/trace/DURATION_TRACE/%s?utm_source=%s&utm_medium=%s", ConsoleUrlGenerator.getRootUrl(string, string2), string3, "perf-android-sdk", "android-ide");
    }

    public static String generateDashboardUrl(String string, String string2) {
        Object[] obj2 = new Object[3];
        return String.format("%s/trends?utm_source=%s&utm_medium=%s", ConsoleUrlGenerator.getRootUrl(string, string2), "perf-android-sdk", "android-ide");
    }

    public static String generateScreenTraceUrl(String string, String string2, String string3) {
        Object[] obj2 = new Object[4];
        return String.format("%s/metrics/trace/SCREEN_TRACE/%s?utm_source=%s&utm_medium=%s", ConsoleUrlGenerator.getRootUrl(string, string2), string3, "perf-android-sdk", "android-ide");
    }

    private static String getRootUrl(String string, String string2) {
        Object[] arr = new Object[3];
        return String.format("%s/project/%s/performance/app/android:%s", "https://console.firebase.google.com", string, string2);
    }
}
