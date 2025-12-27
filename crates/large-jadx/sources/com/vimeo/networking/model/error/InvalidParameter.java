package com.vimeo.networking.model.error;

import com.google.gson.annotations.SerializedName;

/* compiled from: InvalidParameter.java */
/* loaded from: classes2.dex */
public class InvalidParameter {

    @SerializedName("developer_message")
    private String developerMessage;
    @SerializedName("error_code")
    private ErrorCode errorCode;
    @SerializedName("field")
    private String field;
    @SerializedName("user_message")
    private String userMessage;
    public InvalidParameter(String str, ErrorCode th, String str2) {
        super();
        this.field = str;
        this.errorCode = th;
        this.developerMessage = str2;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public ErrorCode getErrorCode() {
        com.vimeo.networking.model.error.ErrorCode errorCode2;
        if (this.errorCode == null) {
            errorCode2 = ErrorCode.DEFAULT;
        }
        return errorCode2;
    }

    public String getField() {
        return this.field;
    }

    public String getUserMessage() {
        return this.userMessage;
    }
}
