package com.vimeo.networking.model.error;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class InvalidParameter {

    @SerializedName("developer_message")
    private String developerMessage;
    @SerializedName("error_code")
    private com.vimeo.networking.model.error.ErrorCode errorCode;
    @SerializedName("field")
    private String field;
    @SerializedName("user_message")
    private String userMessage;
    public InvalidParameter(String string, com.vimeo.networking.model.error.ErrorCode errorCode2, String string3) {
        super();
        this.field = string;
        this.errorCode = errorCode2;
        this.developerMessage = string3;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public com.vimeo.networking.model.error.ErrorCode getErrorCode() {
        com.vimeo.networking.model.error.ErrorCode errorCode;
        if (this.errorCode == null) {
            errorCode = ErrorCode.DEFAULT;
        }
        return errorCode;
    }

    public String getField() {
        return this.field;
    }

    public String getUserMessage() {
        return this.userMessage;
    }
}
