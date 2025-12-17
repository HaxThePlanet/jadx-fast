package com.vimeo.networking;

import com.vimeo.networking.callbacks.ModelCallback;
import com.vimeo.networking.model.search.SearchResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

/* loaded from: classes2.dex */
public final class Search {

    static final String FILTER_CATEGORY = "filter_category";
    static final String FILTER_DURATION = "filter_duration";
    static final String FILTER_FEATURED_COUNT = "featured_clip_count";
    static final String FILTER_TYPE = "filter_type";
    public static final String FILTER_TYPE_CHANNEL = "channel";
    public static final String FILTER_TYPE_GROUP = "group";
    public static final String FILTER_TYPE_USER = "people";
    public static final String FILTER_TYPE_VIDEO = "clip";
    public static final String FILTER_TYPE_VOD = "ondemand";
    static final String FILTER_UPLOADED = "filter_uploaded";
    static final String PARAMETER_GET_FACETS = "facets";

    public static enum Facet {

        TYPE("type"),
        CATEGORY("category"),
        DURATION("duration"),
        LICENSE("license"),
        UPLOADED("uploaded"),
        USER_TYPE("user_type");

        private final String mText;
        public static com.vimeo.networking.Search.Facet fromString(String string) {
            com.vimeo.networking.Search.Facet[] values;
            int length;
            int i;
            com.vimeo.networking.Search.Facet facet;
            boolean equalsIgnoreCase;
            if (string == null) {
            } else {
                values = Search.Facet.values();
                i = 0;
                while (i < values.length) {
                    facet = values[i];
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
            return this.mText;
        }
    }

    public static enum FilterDuration {

        SHORT("short"),
        MEDIUM("medium"),
        LONG("long");

        private final String mText;
        public static com.vimeo.networking.Search.FilterDuration fromString(String string) {
            com.vimeo.networking.Search.FilterDuration[] values;
            int length;
            int i;
            com.vimeo.networking.Search.FilterDuration filterDuration;
            boolean equalsIgnoreCase;
            if (string == null) {
            } else {
                values = Search.FilterDuration.values();
                i = 0;
                while (i < values.length) {
                    filterDuration = values[i];
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
            return this.mText;
        }
    }

    public static enum FilterType {

        VIDEO("clip"),
        VOD("ondemand"),
        USER("people"),
        CHANNEL("channel"),
        GROUP("group");

        private final String mText;
        public static com.vimeo.networking.Search.FilterType fromString(String string) {
            com.vimeo.networking.Search.FilterType[] values;
            int length;
            int i;
            com.vimeo.networking.Search.FilterType filterType;
            boolean equalsIgnoreCase;
            if (string == null) {
            } else {
                values = Search.FilterType.values();
                i = 0;
                while (i < values.length) {
                    filterType = values[i];
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
            return this.mText;
        }
    }

    public static enum FilterUpload {

        TODAY("today"),
        THIS_WEEK("this-week"),
        THIS_MONTH("this-month"),
        THIS_YEAR("this-year");

        private final String mText;
        public static com.vimeo.networking.Search.FilterUpload fromString(String string) {
            com.vimeo.networking.Search.FilterUpload[] values;
            int length;
            int i;
            com.vimeo.networking.Search.FilterUpload filterUpload;
            boolean equalsIgnoreCase;
            if (string == null) {
            } else {
                values = Search.FilterUpload.values();
                i = 0;
                while (i < values.length) {
                    filterUpload = values[i];
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
            return this.mText;
        }
    }

    public static class QueryParameterProvider {

        private final Map<String, String> mQueryParameters;
        public QueryParameterProvider() {
            super();
            HashMap hashMap = new HashMap();
            this.mQueryParameters = hashMap;
        }

        public Map<String, String> getQueryParameters() {
            return this.mQueryParameters;
        }

        public com.vimeo.networking.Search.QueryParameterProvider setCategory(String string) {
            Map mQueryParameters;
            Object obj3;
            final String str = "filter_category";
            if (string != null) {
                this.mQueryParameters.put(str, string);
            } else {
                this.mQueryParameters.remove(str);
            }
            return this;
        }

        public com.vimeo.networking.Search.QueryParameterProvider setDirection(String string) {
            boolean mQueryParameters;
            Object obj3;
            final String str3 = "direction";
            if (!"asc".equals(string)) {
                if ("desc".equals(string)) {
                    this.mQueryParameters.put(str3, string);
                } else {
                    this.mQueryParameters.remove(str3);
                }
            } else {
            }
            return this;
        }

        public com.vimeo.networking.Search.QueryParameterProvider setDuration(com.vimeo.networking.Search.FilterDuration search$FilterDuration) {
            Map mQueryParameters;
            Object obj3;
            final String str = "filter_duration";
            if (filterDuration != null) {
                this.mQueryParameters.put(str, filterDuration.getText());
            } else {
                this.mQueryParameters.remove(str);
            }
            return this;
        }

        public com.vimeo.networking.Search.QueryParameterProvider setFeaturedVideoCount(int i) {
            this.mQueryParameters.put("featured_clip_count", String.valueOf(i));
            return this;
        }

        public com.vimeo.networking.Search.QueryParameterProvider setSort(com.vimeo.networking.Search.Sort search$Sort) {
            Map mQueryParameters;
            Object obj3;
            final String str = "sort";
            if (sort != null) {
                this.mQueryParameters.put(str, sort.getText());
            } else {
                this.mQueryParameters.remove(str);
            }
            return this;
        }

        public com.vimeo.networking.Search.QueryParameterProvider setUploadDate(com.vimeo.networking.Search.FilterUpload search$FilterUpload) {
            Map mQueryParameters;
            Object obj3;
            final String str = "filter_uploaded";
            if (filterUpload != null) {
                this.mQueryParameters.put(str, filterUpload.getText());
            } else {
                this.mQueryParameters.remove(str);
            }
            return this;
        }
    }

    public static enum Sort {

        RELEVANCE("relevance"),
        LATEST("latest"),
        POPULARITY("popularity"),
        DURATION("duration"),
        JOIN_DATE("join_date"),
        ALPHABETICAL("alphabetical");

        private final String mText;
        public static com.vimeo.networking.Search.Sort fromString(String string) {
            com.vimeo.networking.Search.Sort[] values;
            int length;
            int i;
            com.vimeo.networking.Search.Sort sort;
            boolean equalsIgnoreCase;
            if (string == null) {
            } else {
                values = Search.Sort.values();
                i = 0;
                while (i < values.length) {
                    sort = values[i];
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
            return this.mText;
        }
    }
    public static Call<SearchResponse> search(String string, com.vimeo.networking.Search.FilterType search$FilterType2, ModelCallback<SearchResponse> modelCallback3, Map<String, String> map4, List<com.vimeo.networking.Search.Facet> list5, String string6, String string7) {
        String str;
        boolean next;
        String obj3;
        HashMap obj5;
        String obj6;
        if (map4 == null) {
            obj5 = new HashMap();
        }
        obj5.put("filter_type", filterType2.getText());
        if (list5 != null) {
            obj3 = new StringBuilder();
            obj6 = list5.iterator();
            str = "";
            for (Search.Facet next : obj6) {
                obj3.append(str);
                obj3.append(next.getText());
                str = ",";
            }
            obj5.put("facets", obj3.toString());
        }
        if (string6 != null) {
            obj5.put("container_fields", string6);
        }
        return VimeoClient.getInstance().search(VimeoClient.getInstance().createQueryMap(string, obj5, string7), modelCallback3);
    }
}
