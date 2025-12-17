package retrofit2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l.f;
import l.g;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.MultipartBody.Part;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
final class RequestBuilder {

    private static final char[] HEX_DIGITS = null;
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private static final Pattern PATH_TRAVERSAL;
    private final HttpUrl baseUrl;
    private RequestBody body;
    private MediaType contentType;
    private FormBody.Builder formBuilder;
    private final boolean hasBody;
    private final Headers.Builder headersBuilder;
    private final String method;
    private MultipartBody.Builder multipartBuilder;
    private String relativeUrl;
    private final Request.Builder requestBuilder;
    private HttpUrl.Builder urlBuilder;

    private static class ContentTypeOverridingRequestBody extends RequestBody {

        private final MediaType contentType;
        private final RequestBody delegate;
        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType2) {
            super();
            this.delegate = requestBody;
            this.contentType = mediaType2;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(g g) {
            this.delegate.writeTo(g);
        }
    }
    static {
        char[] cArr = new char[16];
        cArr = new short[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        RequestBuilder.HEX_DIGITS = cArr;
        RequestBuilder.PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    }

    RequestBuilder(String string, HttpUrl httpUrl2, String string3, Headers headers4, MediaType mediaType5, boolean z6, boolean z7, boolean z8) {
        Headers.Builder obj1;
        Object obj2;
        super();
        this.method = string;
        this.baseUrl = httpUrl2;
        this.relativeUrl = string3;
        obj1 = new Request.Builder();
        this.requestBuilder = obj1;
        this.contentType = mediaType5;
        this.hasBody = z6;
        if (headers4 != null) {
            this.headersBuilder = headers4.newBuilder();
        } else {
            obj1 = new Headers.Builder();
            this.headersBuilder = obj1;
        }
        if (z7) {
            obj1 = new FormBody.Builder();
            this.formBuilder = obj1;
        } else {
            if (z8) {
                obj1 = new MultipartBody.Builder();
                this.multipartBuilder = obj1;
                obj1.setType(MultipartBody.FORM);
            }
        }
    }

    private static String canonicalizeForPath(String string, boolean z2) {
        int i2;
        int charCount;
        int indexOf;
        int i;
        String obj6;
        final int length = string.length();
        final int i3 = 0;
        i2 = i3;
        while (i2 < length) {
            int codePointAt = string.codePointAt(i2);
            i2 += charCount;
        }
        return obj6;
    }

    private static void canonicalizeForPath(f f, String string2, int i3, int i4, boolean z5) {
        int fVar;
        int charCount;
        int indexOf;
        int i;
        int hEX_DIGITS;
        char c;
        int obj8;
        fVar = 0;
        while (obj8 < i4) {
            int codePointAt = string2.codePointAt(obj8);
            if (z5) {
            } else {
            }
            i = 37;
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1) {
            } else {
            }
            if (fVar == 0) {
            }
            fVar.g1(codePointAt);
            while (!fVar.b0()) {
                byte &= 255;
                f.z0(i);
                hEX_DIGITS = RequestBuilder.HEX_DIGITS;
                f.z0(hEX_DIGITS[i6 &= 15]);
                f.z0(hEX_DIGITS[i2 &= 15]);
            }
            obj8 += charCount;
            byte &= 255;
            f.z0(i);
            hEX_DIGITS = RequestBuilder.HEX_DIGITS;
            f.z0(hEX_DIGITS[i6 &= 15]);
            f.z0(hEX_DIGITS[i2 &= 15]);
            fVar = new f();
            if (codePointAt < 127) {
            } else {
            }
            if (" \"<>^`{}|\\?#".indexOf(codePointAt) == -1) {
            } else {
            }
            if (!z5) {
            } else {
            }
            f.g1(codePointAt);
            if (codePointAt != 47) {
            } else {
            }
            if (codePointAt == i) {
            } else {
            }
            if (codePointAt != 9 && codePointAt != 10 && codePointAt != 12) {
            }
            if (codePointAt != 10) {
            }
            if (codePointAt != 12) {
            }
            if (codePointAt == 13) {
            } else {
            }
        }
    }

    void addFormField(String string, String string2, boolean z3) {
        FormBody.Builder obj3;
        if (z3) {
            this.formBuilder.addEncoded(string, string2);
        } else {
            this.formBuilder.add(string, string2);
        }
    }

    void addHeader(String string, String string2) {
        Headers.Builder equalsIgnoreCase;
        Object obj4;
        if ("Content-Type".equalsIgnoreCase(string)) {
            this.contentType = MediaType.get(string2);
        } else {
            this.headersBuilder.add(string, string2);
        }
    }

    void addHeaders(Headers headers) {
        this.headersBuilder.addAll(headers);
    }

    void addPart(Headers headers, RequestBody requestBody2) {
        this.multipartBuilder.addPart(headers, requestBody2);
    }

    void addPart(MultipartBody.Part multipartBody$Part) {
        this.multipartBuilder.addPart(part);
    }

    void addPathParam(String string, String string2, boolean z3) {
        if (this.relativeUrl == null) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append(string);
            stringBuilder.append("}");
            String obj4 = this.relativeUrl.replace(stringBuilder.toString(), RequestBuilder.canonicalizeForPath(string2, z3));
            if (RequestBuilder.PATH_TRAVERSAL.matcher(obj4).matches()) {
            } else {
                this.relativeUrl = obj4;
            }
            StringBuilder obj6 = new StringBuilder();
            obj6.append("@Path parameters shouldn't perform path traversal ('.' or '..'): ");
            obj6.append(string2);
            obj4 = new IllegalArgumentException(obj6.toString());
            throw obj4;
        }
        obj4 = new AssertionError();
        throw obj4;
    }

    void addQueryParam(String string, String string2, boolean z3) {
        String relativeUrl;
        HttpUrl baseUrl;
        HttpUrl.Builder obj5;
        relativeUrl = this.relativeUrl;
        if (relativeUrl != null) {
            HttpUrl.Builder builder = this.baseUrl.newBuilder(relativeUrl);
            this.urlBuilder = builder;
            if (builder == null) {
            } else {
                this.relativeUrl = 0;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Malformed URL. Base: ");
            obj4.append(this.baseUrl);
            obj4.append(", Relative: ");
            obj4.append(this.relativeUrl);
            IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
            throw obj3;
        }
        if (z3) {
            this.urlBuilder.addEncodedQueryParameter(string, string2);
        } else {
            this.urlBuilder.addQueryParameter(string, string2);
        }
    }

    <T> void addTag(Class<T> class, T t2) {
        this.requestBuilder.tag(class, t2);
    }

    Request.Builder get() {
        HttpUrl resolve;
        String relativeUrl;
        RequestBody create;
        MultipartBody.Builder multipartBuilder;
        Object contentType;
        Object contentTypeOverridingRequestBody;
        String str;
        HttpUrl.Builder urlBuilder = this.urlBuilder;
        if (urlBuilder != null) {
            resolve = urlBuilder.build();
            if (this.body == null) {
                multipartBuilder = this.formBuilder;
                if (multipartBuilder != null) {
                    create = multipartBuilder.build();
                } else {
                    multipartBuilder = this.multipartBuilder;
                    if (multipartBuilder != null) {
                        create = multipartBuilder.build();
                    } else {
                        if (this.hasBody) {
                            create = RequestBody.create(0, new byte[0]);
                        }
                    }
                }
            }
            contentType = this.contentType;
            if (contentType != null) {
                if (create != null) {
                    contentTypeOverridingRequestBody = new RequestBuilder.ContentTypeOverridingRequestBody(create, contentType);
                    create = contentTypeOverridingRequestBody;
                } else {
                    this.headersBuilder.add("Content-Type", contentType.toString());
                }
            }
            return this.requestBuilder.url(resolve).headers(this.headersBuilder.build()).method(this.method, create);
        } else {
            if (this.baseUrl.resolve(this.relativeUrl) == null) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Malformed URL. Base: ");
        stringBuilder.append(this.baseUrl);
        stringBuilder.append(", Relative: ");
        stringBuilder.append(this.relativeUrl);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    void setRelativeUrl(Object object) {
        this.relativeUrl = object.toString();
    }
}
