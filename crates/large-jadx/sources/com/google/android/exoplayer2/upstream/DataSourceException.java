package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes2.dex */
public class DataSourceException extends IOException {

    public final int reason;
    public DataSourceException(int i) {
        super();
        this.reason = i;
    }

    public DataSourceException(String string, int i2) {
        super(string);
        this.reason = i2;
    }

    public DataSourceException(String string, Throwable throwable2, int i3) {
        super(string, throwable2);
        this.reason = i3;
    }

    public DataSourceException(Throwable throwable, int i2) {
        super(throwable);
        this.reason = i2;
    }
}
