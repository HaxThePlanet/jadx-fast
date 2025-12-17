package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.br;
import java.io.IOException;

/* loaded from: classes.dex */
public class ParsingException extends IOException {

    private final br<String> AFKeystoreWrapper;
    public ParsingException(String string, Throwable throwable2, br<String> br3) {
        super(string, throwable2);
        this.AFKeystoreWrapper = br3;
    }

    public br<String> getRawResponse() {
        return this.AFKeystoreWrapper;
    }
}
