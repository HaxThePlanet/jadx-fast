package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class GsonBuilder {

    private boolean complexMapKeySerialization = false;
    private String datePattern;
    private int dateStyle = 2;
    private boolean escapeHtmlChars = true;
    private Excluder excluder;
    private final List<com.google.gson.TypeAdapterFactory> factories;
    private com.google.gson.FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson = false;
    private final List<com.google.gson.TypeAdapterFactory> hierarchyFactories;
    private final Map<Type, com.google.gson.InstanceCreator<?>> instanceCreators;
    private boolean lenient = false;
    private com.google.gson.LongSerializationPolicy longSerializationPolicy;
    private boolean prettyPrinting = false;
    private boolean serializeNulls = false;
    private boolean serializeSpecialFloatingPointValues = false;
    private int timeStyle = 2;
    public GsonBuilder() {
        super();
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        HashMap hashMap = new HashMap();
        this.instanceCreators = hashMap;
        ArrayList arrayList = new ArrayList();
        this.factories = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.hierarchyFactories = arrayList2;
        int i = 0;
        int i2 = 2;
        int i3 = 1;
    }

    GsonBuilder(com.google.gson.Gson gson) {
        super();
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        HashMap hashMap = new HashMap();
        this.instanceCreators = hashMap;
        ArrayList arrayList = new ArrayList();
        this.factories = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.hierarchyFactories = arrayList2;
        int i = 0;
        int i2 = 2;
        int i3 = 1;
        this.excluder = gson.excluder;
        this.fieldNamingPolicy = gson.fieldNamingStrategy;
        hashMap.putAll(gson.instanceCreators);
        this.serializeNulls = gson.serializeNulls;
        this.complexMapKeySerialization = gson.complexMapKeySerialization;
        this.generateNonExecutableJson = gson.generateNonExecutableJson;
        this.escapeHtmlChars = gson.htmlSafe;
        this.prettyPrinting = gson.prettyPrinting;
        this.lenient = gson.lenient;
        this.serializeSpecialFloatingPointValues = gson.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = gson.longSerializationPolicy;
        this.datePattern = gson.datePattern;
        this.dateStyle = gson.dateStyle;
        this.timeStyle = gson.timeStyle;
        arrayList.addAll(gson.builderFactories);
        arrayList2.addAll(gson.builderHierarchyFactories);
    }

    private void addTypeAdaptersForDate(String string, int i2, int i3, List<com.google.gson.TypeAdapterFactory> list4) {
        boolean defaultDateTypeAdapter;
        Object defaultDateTypeAdapter2;
        Class<java.sql.Date> obj;
        int obj4;
        int obj5;
        int obj6;
        if (string != null && !"".equals(string.trim())) {
            if (!"".equals(string.trim())) {
                obj5 = new DefaultDateTypeAdapter(Date.class, string);
                obj6 = new DefaultDateTypeAdapter(Timestamp.class, string);
                defaultDateTypeAdapter = new DefaultDateTypeAdapter(Date.class, string);
                list4.add(TypeAdapters.newFactory(Date.class, obj5));
                list4.add(TypeAdapters.newFactory(Timestamp.class, obj6));
                list4.add(TypeAdapters.newFactory(Date.class, defaultDateTypeAdapter));
            } else {
                obj4 = 2;
                if (i2 != obj4 && i3 != obj4) {
                    if (i3 != obj4) {
                        obj4 = new DefaultDateTypeAdapter(Date.class, i2, i3);
                        DefaultDateTypeAdapter defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(Timestamp.class, i2, i3);
                        defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Date.class, i2, i3);
                        obj5 = obj4;
                        obj6 = defaultDateTypeAdapter3;
                        defaultDateTypeAdapter = defaultDateTypeAdapter2;
                    }
                }
            }
        } else {
        }
    }

    public com.google.gson.GsonBuilder addDeserializationExclusionStrategy(com.google.gson.ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public com.google.gson.GsonBuilder addSerializationExclusionStrategy(com.google.gson.ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public com.google.gson.Gson create() {
        final Object obj = this;
        ArrayList arrayList = new ArrayList(i += 3);
        arrayList.addAll(obj.factories);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(obj.hierarchyFactories);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        obj.addTypeAdaptersForDate(obj.datePattern, obj.dateStyle, obj.timeStyle, arrayList);
        super(obj.excluder, obj.fieldNamingPolicy, obj.instanceCreators, obj.serializeNulls, obj.complexMapKeySerialization, obj.generateNonExecutableJson, obj.escapeHtmlChars, obj.prettyPrinting, obj.lenient, obj.serializeSpecialFloatingPointValues, obj.longSerializationPolicy, obj.datePattern, obj.dateStyle, obj.timeStyle, obj.factories, obj.hierarchyFactories, arrayList);
        return gson3;
    }

    public com.google.gson.GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public com.google.gson.GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public com.google.gson.GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public com.google.gson.GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        this.excluder = this.excluder.withModifiers(iArr);
        return this;
    }

    public com.google.gson.GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public com.google.gson.GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public com.google.gson.GsonBuilder registerTypeAdapter(Type type, Object object2) {
        boolean factoryWithMatchRawType;
        boolean factories;
        boolean z;
        int i;
        boolean instanceCreators;
        Object obj;
        Object obj4;
        factoryWithMatchRawType = object2 instanceof JsonSerializer;
        if (!factoryWithMatchRawType && !object2 instanceof JsonDeserializer && !object2 instanceof InstanceCreator) {
            if (!object2 instanceof JsonDeserializer) {
                if (!object2 instanceof InstanceCreator) {
                    if (object2 instanceof TypeAdapter != null) {
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
        .Gson.Preconditions.checkArgument(i);
        if (object2 instanceof InstanceCreator) {
            this.instanceCreators.put(type, (InstanceCreator)object2);
        }
        if (!factoryWithMatchRawType) {
            if (object2 instanceof JsonDeserializer) {
                this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), object2));
            }
        } else {
        }
        if (object2 instanceof TypeAdapter != null) {
            this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter)object2));
        }
        return this;
    }

    public com.google.gson.GsonBuilder registerTypeAdapterFactory(com.google.gson.TypeAdapterFactory typeAdapterFactory) {
        this.factories.add(typeAdapterFactory);
        return this;
    }

    public com.google.gson.GsonBuilder registerTypeHierarchyAdapter(Class<?> class, Object object2) {
        boolean hierarchyFactories;
        boolean factories;
        int i;
        boolean typeHierarchyFactory;
        boolean z;
        Object obj3;
        hierarchyFactories = object2 instanceof JsonSerializer;
        if (!hierarchyFactories && !object2 instanceof JsonDeserializer) {
            if (!object2 instanceof JsonDeserializer) {
                if (object2 instanceof TypeAdapter != null) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        .Gson.Preconditions.checkArgument(i);
        if (!object2 instanceof JsonDeserializer) {
            if (hierarchyFactories) {
                this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(class, object2));
            }
        } else {
        }
        if (object2 instanceof TypeAdapter != null) {
            this.factories.add(TypeAdapters.newTypeHierarchyFactory(class, (TypeAdapter)object2));
        }
        return this;
    }

    public com.google.gson.GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public com.google.gson.GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public com.google.gson.GsonBuilder setDateFormat(int i) {
        this.dateStyle = i;
        this.datePattern = 0;
        return this;
    }

    public com.google.gson.GsonBuilder setDateFormat(int i, int i2) {
        this.dateStyle = i;
        this.timeStyle = i2;
        this.datePattern = 0;
        return this;
    }

    public com.google.gson.GsonBuilder setDateFormat(String string) {
        this.datePattern = string;
        return this;
    }

    public com.google.gson.GsonBuilder setExclusionStrategies(com.google.gson.ExclusionStrategy... exclusionStrategyArr) {
        int i2;
        Excluder exclusionStrategy;
        Excluder excluder;
        int i;
        i2 = 0;
        while (i2 < exclusionStrategyArr.length) {
            i = 1;
            this.excluder = this.excluder.withExclusionStrategy(exclusionStrategyArr[i2], i, i);
            i2++;
        }
        return this;
    }

    public com.google.gson.GsonBuilder setFieldNamingPolicy(com.google.gson.FieldNamingPolicy fieldNamingPolicy) {
        this.fieldNamingPolicy = fieldNamingPolicy;
        return this;
    }

    public com.google.gson.GsonBuilder setFieldNamingStrategy(com.google.gson.FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public com.google.gson.GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public com.google.gson.GsonBuilder setLongSerializationPolicy(com.google.gson.LongSerializationPolicy longSerializationPolicy) {
        this.longSerializationPolicy = longSerializationPolicy;
        return this;
    }

    public com.google.gson.GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public com.google.gson.GsonBuilder setVersion(double d) {
        this.excluder = this.excluder.withVersion(d);
        return this;
    }
}
