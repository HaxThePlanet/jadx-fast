package zendesk.support;

/* loaded from: classes3.dex */
class LastSearch {

    private final String origin;
    private final String query;
    private final int resultsCount;
    LastSearch(String string, int i2) {
        super();
        this.origin = "mobile_sdk";
        this.query = string;
        this.resultsCount = i2;
    }

    String getQuery() {
        return this.query;
    }

    int getResultsCount() {
        return this.resultsCount;
    }
}
