package com.appsflyer.internal;

import android.os.Bundle;
import com.appsflyer.AFLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class m {

    public final String[] AFInAppEventType;

    public interface e {
        public abstract void AFInAppEventType(String string);

        public abstract void AFKeystoreWrapper(String string, String string2, String string3);
    }
    public m(String... stringArr) {
        int length;
        int i;
        String lowerCase;
        boolean matches;
        super();
        final int i2 = 0;
        if (stringArr != null) {
            if (stringArr.length == 0) {
            } else {
                ArrayList arrayList = new ArrayList();
                final int i3 = 0;
                i = i3;
                while (i < stringArr.length) {
                    Object obj = stringArr[i];
                    if (obj != null && Pattern.compile("[\\w]{1,45}").matcher(obj).matches()) {
                    } else {
                    }
                    AFLogger.init("Invalid partner name: ".concat(String.valueOf(obj)));
                    i++;
                    if (compile.matcher(obj).matches()) {
                    } else {
                    }
                    arrayList.add(obj.toLowerCase());
                }
                String obj9 = "all";
                if (arrayList.contains(obj9)) {
                    this.AFInAppEventType = /* result */;
                }
                if (!arrayList.isEmpty()) {
                    this.AFInAppEventType = (String[])arrayList.toArray(new String[i3]);
                }
            }
            this.AFInAppEventType = i2;
        }
        this.AFInAppEventType = i2;
    }
}
