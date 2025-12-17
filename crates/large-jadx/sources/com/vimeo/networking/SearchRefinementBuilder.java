package com.vimeo.networking;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SearchRefinementBuilder {

    private static final int FIVE_MINUTES = 300;
    Map<String, String> parameterMap;
    public SearchRefinementBuilder() {
        super();
        HashMap hashMap = new HashMap();
        this.parameterMap = hashMap;
    }

    public SearchRefinementBuilder(com.vimeo.networking.Vimeo.RefineSort vimeo$RefineSort) {
        super();
        HashMap hashMap = new HashMap();
        this.parameterMap = hashMap;
        setSort(refineSort);
    }

    public Map<String, String> build() {
        return this.parameterMap;
    }

    public com.vimeo.networking.SearchRefinementBuilder setDurationOverFiveMinutes() {
        return setMinDuration(300);
    }

    public com.vimeo.networking.SearchRefinementBuilder setDurationUnderFiveMinutes() {
        return setMaxDuration(300);
    }

    public com.vimeo.networking.SearchRefinementBuilder setMaxDuration(int i) {
        this.parameterMap.put("max_duration", String.valueOf(i));
        return this;
    }

    public com.vimeo.networking.SearchRefinementBuilder setMinDuration(int i) {
        this.parameterMap.put("min_duration", String.valueOf(i));
        return this;
    }

    public com.vimeo.networking.SearchRefinementBuilder setSort(com.vimeo.networking.Vimeo.RefineSort vimeo$RefineSort) {
        Map parameterMap;
        int str;
        String obj4;
        int i = SearchRefinementBuilder.1.$SwitchMap$com$vimeo$networking$Vimeo$RefineSort[refineSort.ordinal()];
        final String str3 = "sort";
        if (i != 1 && i != 2) {
            if (i != 2) {
                this.parameterMap.put(str3, refineSort.getText());
            } else {
                this.parameterMap.put(str3, "alphabetical");
                this.parameterMap.put("direction", refineSort.getText());
            }
        } else {
        }
        return this;
    }

    public com.vimeo.networking.SearchRefinementBuilder setUploadDateFilter(com.vimeo.networking.Vimeo.RefineUploadDate vimeo$RefineUploadDate) {
        Object parameterMap;
        String str;
        String str2;
        Object obj4;
        if (refineUploadDate != Vimeo.RefineUploadDate.ANYTIME) {
            this.parameterMap.put("filter", "upload_date");
            this.parameterMap.put("filter_upload_date", refineUploadDate.getText());
        }
        return this;
    }
}
