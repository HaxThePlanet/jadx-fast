package com.vimeo.networking;

import java.util.HashMap;
import java.util.Map;

/* compiled from: SearchRefinementBuilder.java */
/* loaded from: classes2.dex */
public class SearchRefinementBuilder {

    private static final int FIVE_MINUTES = 300;
    Map<String, String> parameterMap = new HashMap<>();

    static class AnonymousClass1 {

        static final /* synthetic */ int[] $SwitchMap$com$vimeo$networking$Vimeo$RefineSort;
        static {
            int[] iArr = new int[Vimeo.RefineSort.values().length];
            SearchRefinementBuilder.AnonymousClass1.$SwitchMap$com$vimeo$networking$Vimeo$RefineSort = iArr;
            try {
                iArr[Vimeo.RefineSort.AZ.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                SearchRefinementBuilder.AnonymousClass1.$SwitchMap$com$vimeo$networking$Vimeo$RefineSort[Vimeo.RefineSort.ZA.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public SearchRefinementBuilder() {
        super();
        final HashMap hashMap = new HashMap();
    }

    public Map<String, String> build() {
        return this.parameterMap;
    }

    public SearchRefinementBuilder setDurationOverFiveMinutes() {
        return setMinDuration(300);
    }

    public SearchRefinementBuilder setDurationUnderFiveMinutes() {
        return setMaxDuration(300);
    }

    public SearchRefinementBuilder setMaxDuration(int i) {
        this.parameterMap.put("max_duration", String.valueOf(i));
        return this;
    }

    public SearchRefinementBuilder setMinDuration(int i) {
        this.parameterMap.put("min_duration", String.valueOf(i));
        return this;
    }

    public SearchRefinementBuilder setSort(Vimeo.RefineSort refineSort) {
        int i2 = SearchRefinementBuilder.AnonymousClass1.$SwitchMap$com$vimeo$networking$Vimeo$RefineSort[refineSort.ordinal()];
        int i = 1;
        final String str3 = "sort";
        if (SearchRefinementBuilder.AnonymousClass1.$SwitchMap$com$vimeo$networking$Vimeo$RefineSort == 1 || SearchRefinementBuilder.AnonymousClass1.$SwitchMap$com$vimeo$networking$Vimeo$RefineSort == 2) {
            this.parameterMap.put(str3, "alphabetical");
            str = "direction";
            this.parameterMap.put(str, refineSort.getText());
        } else {
            this.parameterMap.put(str3, refineSort.getText());
        }
        return this;
    }

    public SearchRefinementBuilder setUploadDateFilter(Vimeo.RefineUploadDate refineUploadDate) {
        if (refineUploadDate != Vimeo.RefineUploadDate.ANYTIME) {
            str2 = "upload_date";
            this.parameterMap.put("filter", str2);
            str = "filter_upload_date";
            this.parameterMap.put(str, refineUploadDate.getText());
        }
        return this;
    }

    public SearchRefinementBuilder(Vimeo.RefineSort refineSort) {
        super();
        final HashMap hashMap = new HashMap();
        setSort(refineSort);
    }
}
