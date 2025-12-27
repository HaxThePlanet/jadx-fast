package com.vimeo.networking;

import com.vimeo.networking.callbacks.ModelCallback;
import com.vimeo.networking.model.search.SearchResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

/* compiled from: Search.java */
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

    public enum Facet {

        CATEGORY,
        DURATION,
        LICENSE,
        TYPE,
        UPLOADED,
        USER_TYPE;

        private final String mText;
        public static Search.Facet fromString(String str) {
            int i = 0;
            com.vimeo.networking.Search.Facet facet;
            boolean equalsIgnoreCase;
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "No constant with text ";
                String str3 = " found";
                str = str2 + str + str3;
                throw new IllegalArgumentException(str);
            } else {
                com.vimeo.networking.Search.Facet[] values = Search.Facet.values();
                length = values.length;
                i = 0;
                for (com.vimeo.networking.Search.Facet facet : values) {
                    if (str.equalsIgnoreCase(facet.mText)) {
                        return facet;
                    }
                }
            }
        }

        @Override // java.lang.Enum
        public String getText() {
            return this.mText;
        }
    }

    public enum FilterDuration {

        LONG,
        MEDIUM,
        SHORT;

        private final String mText;
        public static Search.FilterDuration fromString(String str) {
            int i = 0;
            com.vimeo.networking.Search.FilterDuration filterDuration;
            boolean equalsIgnoreCase;
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "No constant with text ";
                String str3 = " found";
                str = str2 + str + str3;
                throw new IllegalArgumentException(str);
            } else {
                com.vimeo.networking.Search.FilterDuration[] values = Search.FilterDuration.values();
                length = values.length;
                i = 0;
                for (com.vimeo.networking.Search.FilterDuration filterDuration : values) {
                    if (str.equalsIgnoreCase(filterDuration.mText)) {
                        return filterDuration;
                    }
                }
            }
        }

        @Override // java.lang.Enum
        public String getText() {
            return this.mText;
        }
    }

    public enum FilterType {

        CHANNEL,
        GROUP,
        USER,
        VIDEO,
        VOD;

        private final String mText;
        public static Search.FilterType fromString(String str) {
            int i = 0;
            com.vimeo.networking.Search.FilterType filterType;
            boolean equalsIgnoreCase;
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "No constant with text ";
                String str3 = " found";
                str = str2 + str + str3;
                throw new IllegalArgumentException(str);
            } else {
                com.vimeo.networking.Search.FilterType[] values = Search.FilterType.values();
                length = values.length;
                i = 0;
                for (com.vimeo.networking.Search.FilterType filterType : values) {
                    if (str.equalsIgnoreCase(filterType.mText)) {
                        return filterType;
                    }
                }
            }
        }

        @Override // java.lang.Enum
        public String getText() {
            return this.mText;
        }
    }

    public enum FilterUpload {

        THIS_MONTH,
        THIS_WEEK,
        THIS_YEAR,
        TODAY;

        private final String mText;
        public static Search.FilterUpload fromString(String str) {
            int i = 0;
            com.vimeo.networking.Search.FilterUpload filterUpload;
            boolean equalsIgnoreCase;
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "No constant with text ";
                String str3 = " found";
                str = str2 + str + str3;
                throw new IllegalArgumentException(str);
            } else {
                com.vimeo.networking.Search.FilterUpload[] values = Search.FilterUpload.values();
                length = values.length;
                i = 0;
                for (com.vimeo.networking.Search.FilterUpload filterUpload : values) {
                    if (str.equalsIgnoreCase(filterUpload.mText)) {
                        return filterUpload;
                    }
                }
            }
        }

        @Override // java.lang.Enum
        public String getText() {
            return this.mText;
        }
    }

    public static class QueryParameterProvider {

        private final Map<String, String> mQueryParameters = new HashMap<>();
        public QueryParameterProvider() {
            super();
            final HashMap hashMap = new HashMap();
        }

        public Map<String, String> getQueryParameters() {
            return this.mQueryParameters;
        }

        public Search.QueryParameterProvider setCategory(String str) {
            final String str2 = "filter_category";
            if (str != null) {
                this.mQueryParameters.put(str2, str);
            } else {
                this.mQueryParameters.remove(str2);
            }
            return this;
        }

        public Search.QueryParameterProvider setDirection(String str) {
            final String str4 = "direction";
            if (!"asc".equals(str)) {
                if ("desc".equals(str)) {
                    this.mQueryParameters.put(str4, str);
                } else {
                    this.mQueryParameters.remove(str4);
                }
            }
            return this;
        }

        public Search.QueryParameterProvider setDuration(Search.FilterDuration filterDuration) {
            final String str = "filter_duration";
            if (filterDuration != null) {
                this.mQueryParameters.put(str, filterDuration.getText());
            } else {
                this.mQueryParameters.remove(str);
            }
            return this;
        }

        public Search.QueryParameterProvider setFeaturedVideoCount(int i) {
            this.mQueryParameters.put("featured_clip_count", String.valueOf(i));
            return this;
        }

        public Search.QueryParameterProvider setSort(Search.Sort sort) {
            final String str = "sort";
            if (sort != null) {
                this.mQueryParameters.put(str, sort.getText());
            } else {
                this.mQueryParameters.remove(str);
            }
            return this;
        }

        public Search.QueryParameterProvider setUploadDate(Search.FilterUpload filterUpload) {
            final String str = "filter_uploaded";
            if (filterUpload != null) {
                this.mQueryParameters.put(str, filterUpload.getText());
            } else {
                this.mQueryParameters.remove(str);
            }
            return this;
        }
    }

    public enum Sort {

        ALPHABETICAL,
        DURATION,
        JOIN_DATE,
        LATEST,
        POPULARITY,
        RELEVANCE;

        private final String mText;
        public static Search.Sort fromString(String str) {
            int i = 0;
            com.vimeo.networking.Search.Sort sort;
            boolean equalsIgnoreCase;
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "No constant with text ";
                String str3 = " found";
                str = str2 + str + str3;
                throw new IllegalArgumentException(str);
            } else {
                com.vimeo.networking.Search.Sort[] values = Search.Sort.values();
                length = values.length;
                i = 0;
                for (com.vimeo.networking.Search.Sort sort : values) {
                    if (str.equalsIgnoreCase(sort.mText)) {
                        return sort;
                    }
                }
            }
        }

        @Override // java.lang.Enum
        public String getText() {
            return this.mText;
        }
    }
    private Search() {
        super();
    }

    public static Call<SearchResponse> search(String str, Search.FilterType filterType, ModelCallback<SearchResponse> modelCallback, Map<String, String> map, List<Search.Facet> list, String str2, String str3) {
        String text;
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        str2 = "filter_type";
        hashMap.put(str2, filterType.getText());
        if (list != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = list.iterator();
            str2 = "";
            while (it.hasNext()) {
                stringBuilder.append(str2);
                stringBuilder.append((Search.Facet)it.next().getText());
                str2 = ",";
            }
            str3 = "facets";
            hashMap.put(str3, stringBuilder.toString());
        }
        if (str2 != null) {
            text = "container_fields";
            hashMap.put(text, str2);
        }
        return VimeoClient.getInstance().search(VimeoClient.getInstance().createQueryMap(str, hashMap, str3), modelCallback);
    }
}
