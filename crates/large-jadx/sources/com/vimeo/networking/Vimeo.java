package com.vimeo.networking;

/* loaded from: classes2.dex */
public class Vimeo {

    public static final String CLIENT_CREDENTIALS_GRANT_TYPE = "client_credentials";
    public static final String CODE_GRANT_PATH = "/oauth/authorize";
    public static final String CODE_GRANT_RESPONSE_TYPE = "code";
    public static final String CODE_GRANT_STATE = "state";
    public static final String CODE_GRANT_TYPE = "authorization_code";
    public static final String DEVICE_GRANT_TYPE = "device_grant";
    public static final String ENDPOINT_ME = "me";
    public static final String ENDPOINT_RECOMMENDATIONS = "/recommendations";
    public static final String FACEBOOK_GRANT_TYPE = "facebook";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_TOKEN = "token";
    public static final String FIELD_USERNAME = "username";
    public static final String FILTER_RELATED = "related";
    public static final String FILTER_UPLOAD = "upload_date";
    public static final String FILTER_UPLOAD_DATE_MONTH = "month";
    public static final String FILTER_UPLOAD_DATE_TODAY = "day";
    public static final String FILTER_UPLOAD_DATE_WEEK = "week";
    public static final String FILTER_UPLOAD_DATE_YEAR = "year";
    public static final String FILTER_VIEWABLE = "viewable";
    public static final String FILTER_VOD_PURCHASES = "purchased";
    public static final String FILTER_VOD_RENTALS = "rented";
    public static final String FILTER_VOD_SUBSCRIPTIONS = "subscription";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_CACHE_PUBLIC = "public";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final int NOT_FOUND = -1;
    public static final String OAUTH_ONE_GRANT_TYPE = "vimeo_oauth1";
    public static final String OPTIONS_POST = "POST";
    public static final String PAGE_SIZE_MAX = "100";
    public static final String PARAMETER_ACTIVE = "active";
    public static final String PARAMETER_BUTTON_STATE = "button_state";
    public static final String PARAMETER_CLIENT_ID = "client_id";
    public static final String PARAMETER_COMMENT_TEXT_BODY = "text";
    public static final String PARAMETER_DURATION = "duration";
    public static final String PARAMETER_EMAIL = "email";
    public static final String PARAMETER_GET_CONTAINER_FIELD_FILTER = "container_fields";
    public static final String PARAMETER_GET_DIRECTION = "direction";
    public static final String PARAMETER_GET_FIELD_FILTER = "fields";
    public static final String PARAMETER_GET_FILTER = "filter";
    public static final String PARAMETER_GET_LENGTH_MAX_DURATION = "max_duration";
    public static final String PARAMETER_GET_LENGTH_MIN_DURATION = "min_duration";
    public static final String PARAMETER_GET_PAGE_SIZE = "per_page";
    public static final String PARAMETER_GET_QUERY = "query";
    public static final String PARAMETER_GET_SORT = "sort";
    public static final String PARAMETER_GET_UPLOAD_DATE_FILTER = "filter_upload_date";
    public static final String PARAMETER_LOCALE = "locale";
    public static final String PARAMETER_PASSWORD = "password";
    public static final String PARAMETER_PROGRESS = "progress";
    @Deprecated
    public static final String PARAMETER_QUALITY = "quality";
    public static final String PARAMETER_REDIRECT_URI = "redirect_uri";
    public static final String PARAMETER_RESPONSE_TYPE = "response_type";
    public static final String PARAMETER_SCOPE = "scope";
    public static final String PARAMETER_SESSION_ID = "session_id";
    public static final String PARAMETER_SESSION_TIME = "session_time";
    public static final String PARAMETER_STATE = "state";
    @Deprecated
    public static final String PARAMETER_TIME = "time";
    public static final String PARAMETER_TOKEN = "token";
    public static final String PARAMETER_USERS_BIO = "bio";
    public static final String PARAMETER_USERS_LOCATION = "location";
    public static final String PARAMETER_USERS_NAME = "name";
    public static final String PARAMETER_VIDEO_DESCRIPTION = "description";
    public static final String PARAMETER_VIDEO_NAME = "name";
    public static final String PARAMETER_VIDEO_PASSWORD = "password";
    public static final String PARAMETER_VIDEO_PRIVACY = "privacy";
    public static final String PARAMETER_VIDEO_VIEW = "view";
    public static final String PARAMETER_VUID = "vuid";
    public static final String PASSWORD_GRANT_TYPE = "password";
    public static final String SORT_ALPHABETICAL = "alphabetical";
    public static final String SORT_DATE = "date";
    public static final String SORT_DEFAULT = "default";
    public static final String SORT_DIRECTION_ASCENDING = "asc";
    public static final String SORT_DIRECTION_DESCENDING = "desc";
    public static final String SORT_FOLLOWERS = "followers";
    public static final String SORT_MANUAL = "manual";
    public static final String SORT_POPULAR = "popularity";
    public static final String SORT_PURCHASE_TIME = "purchase_time";
    public static final String SORT_RELEVANCE = "relevant";
    public static final String VIMEO_BASE_URL_STRING = "https://api.vimeo.com/";

    public static enum LogLevel {

        VERBOSE,
        DEBUG,
        ERROR,
        NONE;
    }

    public static enum RefineLength {

        ANY,
        UNDER_FIVE_MINUTES,
        OVER_FIVE_MINUTES;
    }

    public static enum RefineSort {

        DEFAULT("default"),
        RELEVANCE("relevant"),
        POPULARITY("popularity"),
        RECENT("date"),
        FOLLOWERS("followers"),
        AZ("asc"),
        ZA("desc");

        private String text;
        public static com.vimeo.networking.Vimeo.RefineSort fromString(String string) {
            com.vimeo.networking.Vimeo.RefineSort[] values;
            int length;
            int i;
            com.vimeo.networking.Vimeo.RefineSort refineSort;
            boolean equalsIgnoreCase;
            if (string == null) {
            } else {
                values = Vimeo.RefineSort.values();
                i = 0;
                while (i < values.length) {
                    refineSort = values[i];
                    i++;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No constant with text ");
            stringBuilder.append(string);
            stringBuilder.append(" found");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // java.lang.Enum
        public String getText() {
            return this.text;
        }
    }

    public static enum RefineUploadDate {

        ANYTIME(""),
        TODAY("day"),
        THIS_WEEK("week"),
        THIS_MONTH("month"),
        THIS_YEAR("year");

        private String text;
        public static com.vimeo.networking.Vimeo.RefineUploadDate fromString(String string) {
            com.vimeo.networking.Vimeo.RefineUploadDate[] values;
            int length;
            int i;
            com.vimeo.networking.Vimeo.RefineUploadDate date;
            boolean equalsIgnoreCase;
            if (string == null) {
            } else {
                values = Vimeo.RefineUploadDate.values();
                i = 0;
                while (i < values.length) {
                    date = values[i];
                    i++;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No constant with text ");
            stringBuilder.append(string);
            stringBuilder.append(" found");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // java.lang.Enum
        public String getText() {
            return this.text;
        }
    }
}
