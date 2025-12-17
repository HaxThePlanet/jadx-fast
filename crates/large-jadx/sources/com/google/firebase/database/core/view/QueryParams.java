package com.google.firebase.database.core.view;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.view.filter.LimitedFilter;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.core.view.filter.RangedFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.util.JsonMapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class QueryParams {

    public static final com.google.firebase.database.core.view.QueryParams DEFAULT_PARAMS = null;
    private static final String INDEX = "i";
    private static final String INDEX_END_NAME = "en";
    private static final String INDEX_END_VALUE = "ep";
    private static final String INDEX_START_NAME = "sn";
    private static final String INDEX_START_VALUE = "sp";
    private static final String LIMIT = "l";
    private static final String VIEW_FROM = "vf";
    private Index index;
    private ChildKey indexEndName = null;
    private Node indexEndValue = null;
    private ChildKey indexStartName = null;
    private Node indexStartValue = null;
    private String jsonSerialization = null;
    private Integer limit;
    private com.google.firebase.database.core.view.QueryParams.ViewFrom viewFrom;

    private static enum ViewFrom {

        LEFT,
        RIGHT;
    }
    static {
        QueryParams queryParams = new QueryParams();
        QueryParams.DEFAULT_PARAMS = queryParams;
    }

    public QueryParams() {
        super();
        final int i = 0;
        this.index = PriorityIndex.getInstance();
    }

    private com.google.firebase.database.core.view.QueryParams copy() {
        QueryParams queryParams = new QueryParams();
        queryParams.limit = this.limit;
        queryParams.indexStartValue = this.indexStartValue;
        queryParams.indexStartName = this.indexStartName;
        queryParams.indexEndValue = this.indexEndValue;
        queryParams.indexEndName = this.indexEndName;
        queryParams.viewFrom = this.viewFrom;
        queryParams.index = this.index;
        return queryParams;
    }

    public static com.google.firebase.database.core.view.QueryParams fromQueryObject(Map<String, Object> map) {
        com.google.firebase.database.core.view.QueryParams.ViewFrom rIGHT;
        Object string2;
        Object string;
        Object obj4;
        QueryParams queryParams = new QueryParams();
        rIGHT = "l";
        queryParams.limit = (Integer)map.get(rIGHT);
        string2 = "sp";
        queryParams.indexStartValue = QueryParams.normalizeValue(NodeUtilities.NodeFromJSON(map.get(string2)));
        string2 = map.get("sn");
        if (map.containsKey(string2) && (String)string2 != null) {
            queryParams.indexStartValue = QueryParams.normalizeValue(NodeUtilities.NodeFromJSON(map.get(string2)));
            string2 = map.get("sn");
            if ((String)(String)string2 != null) {
                queryParams.indexStartName = ChildKey.fromString((String)(String)string2);
            }
        }
        string = "ep";
        queryParams.indexEndValue = QueryParams.normalizeValue(NodeUtilities.NodeFromJSON(map.get(string)));
        string = map.get("en");
        if (map.containsKey(string) && (String)string != null) {
            queryParams.indexEndValue = QueryParams.normalizeValue(NodeUtilities.NodeFromJSON(map.get(string)));
            string = map.get("en");
            if ((String)(String)string != null) {
                queryParams.indexEndName = ChildKey.fromString((String)(String)string);
            }
        }
        Object obj2 = map.get("vf");
        if ((String)obj2 != null) {
            rIGHT = (String)obj2.equals(rIGHT) ? QueryParams.ViewFrom.LEFT : QueryParams.ViewFrom.RIGHT;
            queryParams.viewFrom = rIGHT;
        }
        obj4 = map.get("i");
        if ((String)obj4 != null) {
            queryParams.index = Index.fromQueryDefinition((String)obj4);
        }
        return queryParams;
    }

    private static Node normalizeValue(Node node) {
        boolean z;
        if (!node instanceof StringNode && !node instanceof BooleanNode && !node instanceof DoubleNode) {
            if (!node instanceof BooleanNode) {
                if (!node instanceof DoubleNode) {
                    if (node instanceof EmptyNode) {
                    } else {
                        if (!node instanceof LongNode) {
                        } else {
                            DoubleNode doubleNode = new DoubleNode(Double.valueOf((Long)node.getValue().doubleValue()), PriorityUtilities.NullPriority());
                            return doubleNode;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected value passed to normalizeValue: ");
                    stringBuilder.append(node.getValue());
                    IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                    throw illegalStateException;
                }
            }
        }
        return node;
    }

    public com.google.firebase.database.core.view.QueryParams endAt(Node node, ChildKey childKey2) {
        int i;
        boolean leafNode;
        final int i3 = 1;
        if (!node.isLeafNode()) {
            if (node.isEmpty()) {
                i = i3;
            } else {
                i = 0;
            }
        } else {
        }
        Utilities.hardAssert(i);
        Utilities.hardAssert(z ^= i3);
        com.google.firebase.database.core.view.QueryParams copy = copy();
        copy.indexEndValue = node;
        copy.indexEndName = childKey2;
        return copy;
    }

    public boolean equals(Object object) {
        boolean equals2;
        boolean equals;
        ChildKey indexEndName;
        boolean indexEndValue;
        ChildKey indexStartName;
        boolean indexStartValue;
        Class<com.google.firebase.database.core.view.QueryParams> obj;
        Object indexStartValue2;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (QueryParams.class != object.getClass()) {
            } else {
                Integer limit = this.limit;
                if (limit != null) {
                    if (!limit.equals(object.limit)) {
                        return i2;
                    }
                } else {
                    if (object.limit != null) {
                    }
                }
                Index index = this.index;
                if (index != null) {
                    if (!index.equals(object.index)) {
                        return i2;
                    }
                } else {
                    if (object.index != null) {
                    }
                }
                ChildKey indexEndName2 = this.indexEndName;
                if (indexEndName2 != null) {
                    if (!indexEndName2.equals(object.indexEndName)) {
                        return i2;
                    }
                } else {
                    if (object.indexEndName != null) {
                    }
                }
                Node indexEndValue2 = this.indexEndValue;
                if (indexEndValue2 != null) {
                    if (!indexEndValue2.equals(object.indexEndValue)) {
                        return i2;
                    }
                } else {
                    if (object.indexEndValue != null) {
                    }
                }
                ChildKey indexStartName2 = this.indexStartName;
                if (indexStartName2 != null) {
                    if (!indexStartName2.equals(object.indexStartName)) {
                        return i2;
                    }
                } else {
                    if (object.indexStartName != null) {
                    }
                }
                Node indexStartValue3 = this.indexStartValue;
                if (indexStartValue3 != null) {
                    if (!indexStartValue3.equals(object.indexStartValue)) {
                        return i2;
                    }
                } else {
                    if (object.indexStartValue != null) {
                    }
                }
                if (isViewFromLeft() != (QueryParams)object.isViewFromLeft()) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public Index getIndex() {
        return this.index;
    }

    public ChildKey getIndexEndName() {
        if (!hasEnd()) {
        } else {
            ChildKey indexEndName = this.indexEndName;
            if (indexEndName != null) {
                return indexEndName;
            }
            return ChildKey.getMaxName();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot get index end name if start has not been set");
        throw illegalArgumentException;
    }

    public Node getIndexEndValue() {
        if (!hasEnd()) {
        } else {
            return this.indexEndValue;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot get index end value if start has not been set");
        throw illegalArgumentException;
    }

    public ChildKey getIndexStartName() {
        if (!hasStart()) {
        } else {
            ChildKey indexStartName = this.indexStartName;
            if (indexStartName != null) {
                return indexStartName;
            }
            return ChildKey.getMinName();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot get index start name if start has not been set");
        throw illegalArgumentException;
    }

    public Node getIndexStartValue() {
        if (!hasStart()) {
        } else {
            return this.indexStartValue;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot get index start value if start has not been set");
        throw illegalArgumentException;
    }

    public int getLimit() {
        if (!hasLimit()) {
        } else {
            return this.limit.intValue();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot get limit if limit has not been set");
        throw illegalArgumentException;
    }

    public NodeFilter getNodeFilter() {
        if (loadsAllData()) {
            IndexedFilter indexedFilter = new IndexedFilter(getIndex());
            return indexedFilter;
        }
        if (hasLimit()) {
            LimitedFilter limitedFilter = new LimitedFilter(this);
            return limitedFilter;
        }
        RangedFilter rangedFilter = new RangedFilter(this);
        return rangedFilter;
    }

    public Map<String, Object> getWireProtocolParams() {
        boolean indexStartName;
        boolean indexEndName;
        com.google.firebase.database.core.view.QueryParams.ViewFrom viewFrom;
        Integer limit;
        boolean queryDefinition;
        String str2;
        Object instance;
        int i;
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("sp", this.indexStartValue.getValue());
        indexStartName = this.indexStartName;
        if (hasStart() && indexStartName != null) {
            hashMap.put("sp", this.indexStartValue.getValue());
            indexStartName = this.indexStartName;
            if (indexStartName != null) {
                hashMap.put("sn", indexStartName.asString());
            }
        }
        hashMap.put("ep", this.indexEndValue.getValue());
        indexEndName = this.indexEndName;
        if (hasEnd() && indexEndName != null) {
            hashMap.put("ep", this.indexEndValue.getValue());
            indexEndName = this.indexEndName;
            if (indexEndName != null) {
                hashMap.put("en", indexEndName.asString());
            }
        }
        limit = this.limit;
        str2 = "l";
        hashMap.put(str2, limit);
        if (limit != null && this.viewFrom == null) {
            str2 = "l";
            hashMap.put(str2, limit);
            if (this.viewFrom == null) {
                viewFrom = hasStart() ? QueryParams.ViewFrom.LEFT : QueryParams.ViewFrom.RIGHT;
            }
            limit = QueryParams.1.$SwitchMap$com$google$firebase$database$core$view$QueryParams$ViewFrom[viewFrom.ordinal()];
            str = "vf";
            if (limit != 1) {
                if (limit != 2) {
                } else {
                    hashMap.put(str, "r");
                }
            } else {
                hashMap.put(str, str2);
            }
        }
        if (!this.index.equals(PriorityIndex.getInstance())) {
            hashMap.put("i", this.index.getQueryDefinition());
        }
        return hashMap;
    }

    public boolean hasAnchoredLimit() {
        boolean viewFrom;
        int i;
        if (hasLimit() && this.viewFrom != null) {
            i = this.viewFrom != null ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean hasEnd() {
        int i;
        i = this.indexEndValue != null ? 1 : 0;
        return i;
    }

    public boolean hasLimit() {
        int i;
        i = this.limit != null ? 1 : 0;
        return i;
    }

    public boolean hasStart() {
        int i;
        i = this.indexStartValue != null ? 1 : 0;
        return i;
    }

    public int hashCode() {
        int intValue;
        int i4;
        int i;
        int i6;
        int i2;
        int i3;
        int i5;
        Integer limit = this.limit;
        i4 = 0;
        if (limit != null) {
            intValue = limit.intValue();
        } else {
            intValue = i4;
        }
        i = isViewFromLeft() ? 1231 : 1237;
        Node indexStartValue = this.indexStartValue;
        if (indexStartValue != null) {
            i6 = indexStartValue.hashCode();
        } else {
            i6 = i4;
        }
        ChildKey indexStartName = this.indexStartName;
        if (indexStartName != null) {
            i2 = indexStartName.hashCode();
        } else {
            i2 = i4;
        }
        Node indexEndValue = this.indexEndValue;
        if (indexEndValue != null) {
            i3 = indexEndValue.hashCode();
        } else {
            i3 = i4;
        }
        ChildKey indexEndName = this.indexEndName;
        if (indexEndName != null) {
            i5 = indexEndName.hashCode();
        } else {
            i5 = i4;
        }
        Index index = this.index;
        if (index != null) {
            i4 = index.hashCode();
        }
        return i17 += i4;
    }

    public boolean isDefault() {
        boolean loadsAllData;
        int i;
        PriorityIndex instance;
        if (loadsAllData() && this.index.equals(PriorityIndex.getInstance())) {
            i = this.index.equals(PriorityIndex.getInstance()) ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isValid() {
        int i;
        boolean anchoredLimit;
        if (hasStart() && hasEnd() && hasLimit()) {
            if (hasEnd()) {
                if (hasLimit()) {
                    if (hasAnchoredLimit()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public boolean isViewFromLeft() {
        int start;
        com.google.firebase.database.core.view.QueryParams.ViewFrom lEFT;
        com.google.firebase.database.core.view.QueryParams.ViewFrom viewFrom = this.viewFrom;
        if (viewFrom != null) {
            start = viewFrom == QueryParams.ViewFrom.LEFT ? 1 : 0;
        } else {
            start = hasStart();
        }
        return start;
    }

    public com.google.firebase.database.core.view.QueryParams limitToFirst(int i) {
        final com.google.firebase.database.core.view.QueryParams copy = copy();
        copy.limit = Integer.valueOf(i);
        copy.viewFrom = QueryParams.ViewFrom.LEFT;
        return copy;
    }

    public com.google.firebase.database.core.view.QueryParams limitToLast(int i) {
        final com.google.firebase.database.core.view.QueryParams copy = copy();
        copy.limit = Integer.valueOf(i);
        copy.viewFrom = QueryParams.ViewFrom.RIGHT;
        return copy;
    }

    public boolean loadsAllData() {
        int i;
        boolean start;
        if (!hasStart() && !hasEnd() && !hasLimit()) {
            if (!hasEnd()) {
                i = !hasLimit() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public com.google.firebase.database.core.view.QueryParams orderBy(Index index) {
        final com.google.firebase.database.core.view.QueryParams copy = copy();
        copy.index = index;
        return copy;
    }

    public com.google.firebase.database.core.view.QueryParams startAt(Node node, ChildKey childKey2) {
        int i;
        boolean leafNode;
        final int i3 = 1;
        if (!node.isLeafNode()) {
            if (node.isEmpty()) {
                i = i3;
            } else {
                i = 0;
            }
        } else {
        }
        Utilities.hardAssert(i);
        Utilities.hardAssert(z ^= i3);
        com.google.firebase.database.core.view.QueryParams copy = copy();
        copy.indexStartValue = node;
        copy.indexStartName = childKey2;
        return copy;
    }

    public String toJSON() {
        String jsonSerialization;
        if (this.jsonSerialization == null) {
            this.jsonSerialization = JsonMapper.serializeJson(getWireProtocolParams());
        }
        return this.jsonSerialization;
    }

    public String toString() {
        return getWireProtocolParams().toString();
    }
}
