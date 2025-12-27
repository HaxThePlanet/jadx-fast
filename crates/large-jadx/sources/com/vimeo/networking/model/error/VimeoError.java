package com.vimeo.networking.model.error;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Headers;
import retrofit2.Response;

/* compiled from: VimeoError.java */
/* loaded from: classes2.dex */
public class VimeoError extends RuntimeException {

    private static final String AUTHENTICATION_HEADER = "WWW-Authenticate";
    private static final String AUTHENTICATION_TOKEN_ERROR = "Bearer error=\"invalid_token\"";
    private static final long serialVersionUID = -5252307626841557962L;
    @SerializedName("developer_message")
    private String developerMessage;
    @SerializedName("error_code")
    private ErrorCode errorCode;
    @SerializedName("error")
    private String errorMessage;
    private Exception exception;
    private int httpStatusCode = -1;
    @SerializedName("invalid_parameters")
    private List<InvalidParameter> invalidParameters;
    private boolean isCanceledError;
    @SerializedName("link")
    private String link;
    private Response response;
    public VimeoError() {
        super();
    }

    @Override // java.lang.RuntimeException
    public void addInvalidParameter(String str, ErrorCode th, String str2) {
        if (this.invalidParameters == null) {
            this.invalidParameters = new ArrayList();
        }
        this.invalidParameters.add(new InvalidParameter(str, th, str2));
    }

    @Override // java.lang.RuntimeException
    public String getDeveloperMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.RuntimeException
    public ErrorCode getErrorCode() {
        com.vimeo.networking.model.error.ErrorCode errorCode2;
        if (this.errorCode == null) {
            errorCode2 = ErrorCode.DEFAULT;
        }
        return errorCode2;
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
        if (this.response != null) {
            return this.response.code();
        }
        return this.httpStatusCode;
    }

    @Override // java.lang.RuntimeException
    public InvalidParameter getInvalidParameter() {
        int i = 0;
        if (this.invalidParameters == null || this.invalidParameters.isEmpty()) {
            i = 0;
        } else {
            int i2 = 0;
            Object item = this.invalidParameters.get(i2);
        }
        return i;
    }

    @Override // java.lang.RuntimeException
    public ErrorCode getInvalidParameterErrorCode() {
        com.vimeo.networking.model.error.ErrorCode errorCode = null;
        if (getInvalidParameter() != null) {
            errorCode = getInvalidParameter().getErrorCode();
        } else {
            int i = 0;
        }
        return errorCode;
    }

    @Override // java.lang.RuntimeException
    public List<InvalidParameter> getInvalidParameters() {
        return this.invalidParameters;
    }

    @Override // java.lang.RuntimeException
    public String getLink() {
        return this.link;
    }

    @Override // java.lang.RuntimeException
    public String getLogString() {
        if (getDeveloperMessage() != null) {
            return getDeveloperMessage();
        }
        if (this.errorMessage != null) {
            return this.errorMessage;
        }
        if (this.exception != null && this.exception.getMessage() != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String str7 = "Exception: ";
            String message2 = this.exception.getMessage();
            str4 = str7 + message2;
            return str4;
        }
        if (getErrorCode() != ErrorCode.DEFAULT) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str6 = "Error Code ";
            com.vimeo.networking.model.error.ErrorCode errorCode2 = getErrorCode();
            str3 = str6 + errorCode2;
            return str3;
        }
        if (getHttpStatusCode() != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "HTTP Status Code: ";
            int httpStatusCode2 = getHttpStatusCode();
            str2 = str5 + httpStatusCode2;
            return str2;
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
        boolean z = false;
        int i = 403;
        if (this.response != null) {
            i = 403;
            int r0 = this.response.code() == 403 ? 1 : 0;
        }
        return (this.response.code() == 403 ? 1 : 0);
    }

    @Override // java.lang.RuntimeException
    public boolean isInvalidTokenError() {
        Object obj;
        if (this.response != null) {
            int i = 401;
            if (this.response.code() == 401) {
                str = "WWW-Authenticate";
                Iterator it = this.response.headers().values(str).iterator();
                while (it.hasNext()) {
                    if ((String)it.next().equals("Bearer error=\"invalid_token\"")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.RuntimeException
    public boolean isNetworkError() {
        boolean z = false;
        int r0 = this.isCanceledError == null && this.response == null ? 1 : 0;
        return (this.isCanceledError == null && this.response == null ? 1 : 0);
    }

    @Override // java.lang.RuntimeException
    public boolean isPasswordRequiredError() {
        com.vimeo.networking.model.error.ErrorCode iNVALID_INPUT_VIDEO_PASSWORD_MISMATCH2;
        if (getInvalidParameter() != null) {
            if (getInvalidParameter().getErrorCode() != ErrorCode.INVALID_INPUT_VIDEO_NO_PASSWORD && this.getInvalidParameter() != null) {
                if (getInvalidParameter().getErrorCode() != ErrorCode.INVALID_INPUT_VIDEO_PASSWORD_MISMATCH) {
                    if (getErrorCode() != ErrorCode.INVALID_INPUT_VIDEO_NO_PASSWORD) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // java.lang.RuntimeException
    public boolean isServiceUnavailable() {
        boolean z = false;
        int i = 503;
        if (this.response != null) {
            i = 503;
            int r0 = this.response.code() == 503 ? 1 : 0;
        }
        return (this.response.code() == 503 ? 1 : 0);
    }

    @Override // java.lang.RuntimeException
    public void setDeveloperMessage(String str) {
        this.developerMessage = str;
    }

    @Override // java.lang.RuntimeException
    public void setErrorCode(ErrorCode th) {
        this.errorCode = th;
    }

    @Override // java.lang.RuntimeException
    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    @Override // java.lang.RuntimeException
    public void setException(Exception exc) {
        this.exception = exc;
    }

    @Override // java.lang.RuntimeException
    public void setHttpStatusCode(int i) {
        this.httpStatusCode = i;
    }

    @Override // java.lang.RuntimeException
    public void setInvalidParameters(List<InvalidParameter> list) {
        this.invalidParameters = list;
    }

    @Override // java.lang.RuntimeException
    public void setIsCanceledError(boolean z) {
        this.isCanceledError = z;
    }

    @Override // java.lang.RuntimeException
    public void setLink(String str) {
        this.link = str;
    }

    @Override // java.lang.RuntimeException
    public void setResponse(Response response) {
        this.response = response;
    }

    public VimeoError(String str) {
        super();
        this.developerMessage = str;
    }

    public VimeoError(String str, Exception exc) {
        super();
        this.developerMessage = str;
        this.exception = exc;
    }
}
