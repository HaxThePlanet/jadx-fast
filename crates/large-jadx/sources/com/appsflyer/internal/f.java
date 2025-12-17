package com.appsflyer.internal;

import android.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class f {

    String AFInAppEventParameterName;
    String AFInAppEventType;
    private byte[] AFKeystoreWrapper;
    String valueOf;
    f(String string, byte[] b2Arr2, String string3) {
        super();
        this.valueOf = string;
        this.AFKeystoreWrapper = b2Arr2;
        this.AFInAppEventType = string3;
    }

    f(char[] cArr) {
        int int;
        Object nextLine;
        boolean startsWith;
        int i2;
        int i;
        int obj7;
        super();
        String string = new String(cArr);
        Scanner scanner = new Scanner(string);
        int = obj7;
        while (scanner.hasNextLine()) {
            nextLine = scanner.nextLine();
            i2 = 4;
            if (nextLine.startsWith("url=")) {
            } else {
            }
            i = 2;
            if (nextLine.startsWith("version=")) {
            } else {
            }
            if (nextLine.startsWith("data=")) {
            }
            String trim = nextLine.substring(5).trim();
            if (obj7 <= i2 && int < 11) {
            } else {
            }
            nextLine = Base64.decode(trim, i);
            this.AFKeystoreWrapper = nextLine;
            if (int < 11) {
            } else {
            }
            nextLine = trim.getBytes();
            this.AFInAppEventType = nextLine.substring(8).trim();
            nextLine = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.AFInAppEventType);
            if (nextLine.matches()) {
            }
            obj7 = Integer.parseInt(nextLine.group(1));
            int = Integer.parseInt(nextLine.group(i));
            this.valueOf = nextLine.substring(i2).trim();
        }
        scanner.close();
    }

    final byte[] AFKeystoreWrapper() {
        return this.AFKeystoreWrapper;
    }
}
