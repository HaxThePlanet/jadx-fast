package com.vimeo.networking.model.error;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Headers;
import retrofit2.Response;

/* loaded from: classes2.dex */
public class VimeoError extends RuntimeException {

    private static final String AUTHENTICATION_HEADER = "WWW-Authenticate";
    private static final String AUTHENTICATION_TOKEN_ERROR = "Bearer error=\"invalid_token\"";
    private static final long serialVersionUID = -5252307626841557962L;
    @SerializedName("developer_message")
    private String developerMessage;
    @SerializedName("error_code")
    private com.vimeo.networking.model.error.ErrorCode errorCode;
    @SerializedName("error")
    private String errorMessage;
    private Exception exception;
    private int httpStatusCode = -1;
    @SerializedName("invalid_parameters")
    private List<com.vimeo.networking.model.error.InvalidParameter> invalidParameters;
    private boolean isCanceledError;
    @SerializedName("link")
    private String link;
    private Response response;
    public VimeoError() {
        super();
        final int i = -1;
    }

    public VimeoError(String string) {
        super();
        final int i = -1;
        this.developerMessage = string;
    }

    public VimeoError(String string, Exception exception2) {
        super();
        final int i = -1;
        this.developerMessage = string;
        this.exception = exception2;
    }

    @Override // java.lang.RuntimeException
    public void addInvalidParameter(String string, com.vimeo.networking.model.error.ErrorCode errorCode2, String string3) {
        Object obj2;
        InvalidParameter invalidParameter = new InvalidParameter(string, errorCode2, string3);
        if (this.invalidParameters == null) {
            obj2 = new ArrayList();
            this.invalidParameters = obj2;
        }
        this.invalidParameters.add(invalidParameter);
    }

    @Override // java.lang.RuntimeException
    public String getDeveloperMessage() {
        String developerMessage;
        developerMessage = this.developerMessage;
        if (developerMessage != null && developerMessage.isEmpty()) {
            if (developerMessage.isEmpty()) {
            }
            return this.developerMessage;
        }
        return this.errorMessage;
    }

    @Override // java.lang.RuntimeException
    public com.vimeo.networking.model.error.ErrorCode getErrorCode() {
        com.vimeo.networking.model.error.ErrorCode errorCode;
        if (this.errorCode == null) {
            errorCode = ErrorCode.DEFAULT;
        }
        return errorCode;
    }

    @Override // java.lang.RuntimeException
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.RuntimeException
    public Exception getException() {
        return this.exception;
    }

    @Override // java.lang.RuntimeException
    public int getHttpStatusCode() {
        Response response = this.response;
        if (response != null) {
            return response.code();
        }
        return this.httpStatusCode;
    }

    @Override // java.lang.RuntimeException
    public com.vimeo.networking.model.error.InvalidParameter getInvalidParameter() {
        List invalidParameters;
        int i;
        int i2;
        invalidParameters = this.invalidParameters;
        if (invalidParameters != null && !invalidParameters.isEmpty()) {
            if (!invalidParameters.isEmpty()) {
                i = this.invalidParameters.get(0);
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.RuntimeException
    public com.vimeo.networking.model.error.ErrorCode getInvalidParameterErrorCode() {
        com.vimeo.networking.model.error.ErrorCode errorCode;
        if (getInvalidParameter() != null) {
            errorCode = getInvalidParameter().getErrorCode();
        } else {
            errorCode = 0;
        }
        return errorCode;
    }

    public List<com.vimeo.networking.model.error.InvalidParameter> getInvalidParameters() {
        return this.invalidParameters;
    }

    @Override // java.lang.RuntimeException
    public String getLink() {
        return this.link;
    }

    @Override // java.lang.RuntimeException
    public String getLogString() {
        Object exception;
        if (getDeveloperMessage() != null) {
            return getDeveloperMessage();
        }
        String errorMessage = this.errorMessage;
        if (errorMessage != null) {
            return errorMessage;
        }
        exception = this.exception;
        if (exception != null && exception.getMessage() != null) {
            if (exception.getMessage() != null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Exception: ");
                stringBuilder3.append(this.exception.getMessage());
                return stringBuilder3.toString();
            }
        }
        if (getErrorCode() != ErrorCode.DEFAULT) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Error Code ");
            stringBuilder2.append(getErrorCode());
            return stringBuilder2.toString();
        }
        if (getHttpStatusCode() != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HTTP Status Code: ");
            stringBuilder.append(getHttpStatusCode());
            return stringBuilder.toString();
        }
        return "";
    }

    @Override // java.lang.RuntimeException
    public Response getResponse() {
        return this.response;
    }

    @Override // java.lang.RuntimeException
    public boolean isCanceledError() {
        return this.isCanceledError;
    }

    @Override // java.lang.RuntimeException
    public boolean isForbiddenError() {
        Response response;
        int i;
        int i2;
        response = this.response;
        if (response != null && response.code() == 403) {
            i = response.code() == 403 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.lang.RuntimeException
    public boolean isInvalidTokenError() {
        Response response;
        String equals;
        int next;
        String str;
        response = this.response;
        if (response != null && response.code() == 401) {
            if (response.code() == 401) {
                response = this.response.headers().values("WWW-Authenticate").iterator();
                for (String next2 : response) {
                }
            }
        }
        return 0;
    }

    @Override // java.lang.RuntimeException
    public boolean isNetworkError() {
        boolean isCanceledError;
        int i;
        if (this.isCanceledError == null && this.response == null) {
            i = this.response == null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.lang.RuntimeException
    public boolean isPasswordRequiredError() {
        Object invalidParameter;
        com.vimeo.networking.model.error.ErrorCode iNVALID_INPUT_VIDEO_PASSWORD_MISMATCH;
        if (getInvalidParameter() != null) {
            if (getInvalidParameter().getErrorCode() != ErrorCode.INVALID_INPUT_VIDEO_NO_PASSWORD) {
                if (getInvalidParameter() != null) {
                    if (getInvalidParameter().getErrorCode() != ErrorCode.INVALID_INPUT_VIDEO_PASSWORD_MISMATCH && getErrorCode() != ErrorCode.INVALID_INPUT_VIDEO_NO_PASSWORD && getErrorCode() == ErrorCode.INVALID_INPUT_VIDEO_PASSWORD_MISMATCH) {
                        if (getErrorCode() != ErrorCode.INVALID_INPUT_VIDEO_NO_PASSWORD) {
                            if (getErrorCode() == ErrorCode.INVALID_INPUT_VIDEO_PASSWORD_MISMATCH) {
                            }
                            return 0;
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return 1;
    }

    @Override // java.lang.RuntimeException
    public boolean isServiceUnavailable() {
        Response response;
        int i2;
        int i;
        response = this.response;
        if (response != null && response.code() == 503) {
            i2 = response.code() == 503 ? 1 : 0;
        } else {
        }
        return i2;
    }

    @Override // java.lang.RuntimeException
    public void setDeveloperMessage(String string) {
        this.developerMessage = string;
    }

    @Override // java.lang.RuntimeException
    public void setErrorCode(com.vimeo.networking.model.error.ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override // java.lang.RuntimeException
    public void setErrorMessage(String string) {
        this.errorMessage = string;
    }

    @Override // java.lang.RuntimeException
    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override // java.lang.RuntimeException
    public void setHttpStatusCode(int i) {
        this.httpStatusCode = i;
    }

    public void setInvalidParameters(List<com.vimeo.networking.model.error.InvalidParameter> list) {
        this.invalidParameters = list;
    }

    @Override // java.lang.RuntimeException
    public void setIsCanceledError(boolean z) {
        this.isCanceledError = z;
    }

    @Override // java.lang.RuntimeException
    public void setLink(String string) {
        this.link = string;
    }

    @Override // java.lang.RuntimeException
    public void setResponse(Response response) {
        this.response = response;
    }
}
