package com.google.gson.internal;

/* loaded from: classes2.dex */
public final class JavaVersion {

    private static final int majorJavaVersion;
    static {
        JavaVersion.majorJavaVersion = JavaVersion.determineMajorJavaVersion();
    }

    private static int determineMajorJavaVersion() {
        return JavaVersion.getMajorJavaVersion(System.getProperty("java.version"));
    }

    private static int extractBeginningInt(String string) {
        int i;
        char charAt;
        boolean digit;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            while (i < string.length()) {
                charAt = string.charAt(i);
                if (Character.isDigit(charAt)) {
                }
                stringBuilder.append(charAt);
                i++;
            }
            charAt = string.charAt(i);
            if (Character.isDigit(charAt)) {
            }
            stringBuilder.append(charAt);
            i++;
            return Integer.parseInt(stringBuilder.toString());
            string = -1;
            return string;
        }
    }

    public static int getMajorJavaVersion() {
        return JavaVersion.majorJavaVersion;
    }

    static int getMajorJavaVersion(String string) {
        int beginningInt;
        final int i = -1;
        if (JavaVersion.parseDotted(string) == i) {
            beginningInt = JavaVersion.extractBeginningInt(string);
        }
        if (beginningInt == i) {
            return 6;
        }
        return beginningInt;
    }

    public static boolean isJava9OrLater() {
        int i;
        i = JavaVersion.majorJavaVersion >= 9 ? 1 : 0;
        return i;
    }

    private static int parseDotted(String string) {
        int length;
        try {
            String[] obj3 = string.split("[._]");
            int int = Integer.parseInt(obj3[0]);
            final int i2 = 1;
            if (int == i2 && obj3.length > i2) {
            }
            if (obj3.length > i2) {
            }
            return Integer.parseInt(obj3[i2]);
            return int;
            string = -1;
            return string;
        }
    }
}
