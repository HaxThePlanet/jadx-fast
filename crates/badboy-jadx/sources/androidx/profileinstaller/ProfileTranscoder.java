package androidx.profileinstaller;

import android.app.LocaleManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes5.dex */
class ProfileTranscoder {

    private static final int FIRST_FLAG = 1;
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    private static final int LAST_FLAG = 4;
    static final byte[] MAGIC_PROF = null;
    static final byte[] MAGIC_PROFM = null;
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;
    static {
        int i = 4;
        final byte[] bArr2 = new byte[i];
        bArr2 = new byte[]{112, 114, 111, 0};
        ProfileTranscoder.MAGIC_PROF = bArr2;
        byte[] bArr = new byte[i];
        bArr = new byte[]{112, 114, 109, 0};
        ProfileTranscoder.MAGIC_PROFM = bArr;
    }

    private static int computeMethodFlags(androidx.profileinstaller.DexProfileData profileData) {
        int methodFlags;
        Object next;
        int intValue;
        methodFlags = 0;
        Iterator iterator = profileData.methods.entrySet().iterator();
        for (Map.Entry next : iterator) {
            methodFlags |= intValue;
        }
        return methodFlags;
    }

    private static byte[] createCompressibleBody(androidx.profileinstaller.DexProfileData[] lines, byte[] version) throws IOException {
        int requiredCapacity;
        int i;
        int i2;
        int length;
        Object obj;
        int dexKey;
        String dexName2;
        int dexName;
        int methodBitmapStorageSize;
        requiredCapacity = 0;
        i = 0;
        i2 = i;
        while (i2 < lines.length) {
            obj = lines[i2];
            requiredCapacity += dexName;
            i2++;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(requiredCapacity);
        if (Arrays.equals(version, ProfileVersion.V009_O_MR1) != null) {
            while (i < lines.length) {
                obj = lines[i];
                ProfileTranscoder.writeLineHeader(byteArrayOutputStream, obj, ProfileTranscoder.generateDexKey(obj.apkName, obj.dexName, version));
                ProfileTranscoder.writeLineData(byteArrayOutputStream, obj);
                i++;
            }
        } else {
            obj = i;
            while (obj < lines.length) {
                dexKey = lines[obj];
                ProfileTranscoder.writeLineHeader(byteArrayOutputStream, dexKey, ProfileTranscoder.generateDexKey(dexKey.apkName, dexKey.dexName, version));
                obj++;
            }
            while (i < lines.length) {
                ProfileTranscoder.writeLineData(byteArrayOutputStream, lines[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() != requiredCapacity) {
        } else {
            return byteArrayOutputStream.toByteArray();
        }
        StringBuilder stringBuilder = new StringBuilder();
        throw Encoding.error(stringBuilder.append("The bytes saved do not match expectation. actual=").append(byteArrayOutputStream.size()).append(" expected=").append(requiredCapacity).toString());
    }

    private static androidx.profileinstaller.WritableFileSection createCompressibleClassSection(androidx.profileinstaller.DexProfileData[] profileData) throws IOException {
        int expectedSize;
        Throwable contents;
        int i;
        Throwable th;
        int i2;
        expectedSize = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i = 0;
        for (Object th : profileData) {
            Encoding.writeUInt16(byteArrayOutputStream, i);
            Encoding.writeUInt16(byteArrayOutputStream, th.classSetSize);
            expectedSize3 += i2;
            ProfileTranscoder.writeClasses(byteArrayOutputStream, th);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (expectedSize != byteArray.length) {
        } else {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.CLASSES, expectedSize, byteArray, 1);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        StringBuilder stringBuilder = new StringBuilder();
        throw Encoding.error(stringBuilder.append("Expected size ").append(expectedSize).append(", does not match actual size ").append(byteArray.length).toString());
    }

    private static androidx.profileinstaller.WritableFileSection createCompressibleMethodsSection(androidx.profileinstaller.DexProfileData[] profileData) throws IOException {
        int expectedSize;
        Throwable contents;
        int i;
        Throwable th;
        int methodFlags;
        byte[] methodBitmapRegionForS;
        byte[] methodsWithInlineCaches;
        int i2;
        long l;
        expectedSize = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i = 0;
        for (Object th : profileData) {
            methodFlags = ProfileTranscoder.computeMethodFlags(th);
            methodBitmapRegionForS = ProfileTranscoder.createMethodBitmapRegionForS(methodFlags, th);
            methodsWithInlineCaches = ProfileTranscoder.createMethodsWithInlineCaches(th);
            Encoding.writeUInt16(byteArrayOutputStream, i);
            i4 += length5;
            Encoding.writeUInt32(byteArrayOutputStream, (long)i2);
            Encoding.writeUInt16(byteArrayOutputStream, methodFlags);
            byteArrayOutputStream.write(methodBitmapRegionForS);
            byteArrayOutputStream.write(methodsWithInlineCaches);
            expectedSize3 += i2;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (expectedSize != byteArray.length) {
        } else {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.METHODS, expectedSize, byteArray, 1);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        StringBuilder stringBuilder = new StringBuilder();
        throw Encoding.error(stringBuilder.append("Expected size ").append(expectedSize).append(", does not match actual size ").append(byteArray.length).toString());
    }

    private static byte[] createMethodBitmapRegionForS(int methodFlags, androidx.profileinstaller.DexProfileData profile) throws IOException {
        Throwable th2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProfileTranscoder.writeMethodBitmapForS(byteArrayOutputStream, methodFlags, profile);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] createMethodsWithInlineCaches(androidx.profileinstaller.DexProfileData profile) throws IOException {
        Throwable th;
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProfileTranscoder.writeMethodsWithInlineCaches(byteArrayOutputStream, profile);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static String enforceSeparator(String value, String separator) {
        String str = "!";
        final String str2 = ":";
        if (str.equals(separator)) {
            return value.replace(str2, str);
        }
        if (str2.equals(separator)) {
            return value.replace(str, str2);
        }
        return value;
    }

    private static String extractKey(String profileKey) {
        int index;
        String str;
        if (profileKey.indexOf("!") < 0) {
            index = profileKey.indexOf(":");
        }
        if (index > 0) {
            return profileKey.substring(index + 1);
        }
        return profileKey;
    }

    private static androidx.profileinstaller.DexProfileData findByDexName(androidx.profileinstaller.DexProfileData[] profile, String profileKey) {
        int i;
        boolean equals;
        int i2 = 0;
        if (profile.length <= 0) {
            return i2;
        }
        i = 0;
        for (Object obj2 : profile) {
        }
        return i2;
    }

    private static String generateDexKey(String apkName, String dexName, byte[] version) {
        boolean contains;
        final String dexKeySeparator = ProfileVersion.dexKeySeparator(version);
        if (apkName.length() <= 0) {
            return ProfileTranscoder.enforceSeparator(dexName, dexKeySeparator);
        }
        if (dexName.equals("classes.dex")) {
            return apkName;
        }
        if (!dexName.contains("!")) {
            if (dexName.contains(":")) {
            } else {
                if (dexName.endsWith(".apk")) {
                    return dexName;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(apkName).append(ProfileVersion.dexKeySeparator(version)).append(dexName).toString();
        }
        return ProfileTranscoder.enforceSeparator(dexName, dexKeySeparator);
    }

    private static int getMethodBitmapStorageSize(int numMethodIds) {
        return roundUpToByte /= 8;
    }

    private static int getMethodBitmapStorageSizeForS(int methodFlags, int numMethodIds) {
        return roundUpToByte /= 8;
    }

    private static int methodFlagBitmapIndex(int flag, int methodIndex, int numMethodIds) {
        switch (flag) {
            case 1:
                throw Encoding.error("HOT methods are not stored in the bitmap");
            case 2:
                return methodIndex;
            case 3:
                StringBuilder stringBuilder = new StringBuilder();
                throw Encoding.error(stringBuilder.append("Unexpected flag: ").append(flag).toString());
            default:
                return methodIndex + numMethodIds;
        }
    }

    private static int[] readClasses(InputStream is, int classSetSize) throws IOException {
        int lastClassIndex;
        int k;
        int i2;
        int i;
        final int[] iArr = new int[classSetSize];
        lastClassIndex = 0;
        k = 0;
        while (k < classSetSize) {
            i = lastClassIndex + i2;
            iArr[k] = i;
            lastClassIndex = i;
            k++;
        }
        return iArr;
    }

    private static int readFlagsFromBitmap(BitSet bs, int methodIndex, int numMethodIds) {
        int result;
        if (bs.get(ProfileTranscoder.methodFlagBitmapIndex(2, methodIndex, numMethodIds)) != null) {
            result |= 2;
        }
        if (bs.get(ProfileTranscoder.methodFlagBitmapIndex(4, methodIndex, numMethodIds)) != null) {
            result |= 4;
        }
        return result;
    }

    static byte[] readHeader(InputStream is, byte[] magic) throws IOException {
        if (!Arrays.equals(magic, Encoding.read(is, magic.length))) {
        } else {
            return Encoding.read(is, v010_P.length);
        }
        throw Encoding.error("Invalid magic");
    }

    private static void readHotMethodRegion(InputStream is, androidx.profileinstaller.DexProfileData data) throws IOException {
        int lastMethodIndex;
        int i;
        int i2;
        int inlineCacheSize;
        Integer valueOf;
        Integer valueOf2;
        available -= hotMethodRegionSize;
        lastMethodIndex = 0;
        while (is.available() > i3) {
            i2 = lastMethodIndex + i;
            data.methods.put(Integer.valueOf(i2), 1);
            inlineCacheSize = Encoding.readUInt16(is);
            while (inlineCacheSize > 0) {
                ProfileTranscoder.skipInlineCache(is);
                inlineCacheSize--;
            }
            lastMethodIndex = i2;
            ProfileTranscoder.skipInlineCache(is);
            inlineCacheSize--;
        }
        if (is.available() != i3) {
        } else {
        }
        throw Encoding.error("Read too much data during profile line parse");
    }

    static androidx.profileinstaller.DexProfileData[] readMeta(InputStream is, byte[] metadataVersion, byte[] desiredProfileVersion, androidx.profileinstaller.DexProfileData[] profile) throws IOException {
        if (Arrays.equals(metadataVersion, ProfileVersion.METADATA_V001_N) != null) {
            if (Arrays.equals(ProfileVersion.V015_S, desiredProfileVersion) != null) {
            } else {
                return ProfileTranscoder.readMetadata001(is, metadataVersion, profile);
            }
            throw Encoding.error("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (Arrays.equals(metadataVersion, ProfileVersion.METADATA_V002) == null) {
        } else {
            return ProfileTranscoder.readMetadataV002(is, desiredProfileVersion, profile);
        }
        throw Encoding.error("Unsupported meta version");
    }

    static androidx.profileinstaller.DexProfileData[] readMetadata001(InputStream is, byte[] metadataVersion, androidx.profileinstaller.DexProfileData[] profile) throws IOException {
        Throwable th2;
        Throwable th;
        if (Arrays.equals(metadataVersion, ProfileVersion.METADATA_V001_N) == null) {
        } else {
            if (is.read() > 0) {
            } else {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Encoding.readCompressed(is, (int)uInt322, (int)uInt32));
                byteArrayInputStream.close();
                return ProfileTranscoder.readMetadataForNBody(byteArrayInputStream, Encoding.readUInt8(is), profile);
            }
            throw Encoding.error("Content found after the end of file");
        }
        throw Encoding.error("Unsupported meta version");
    }

    private static androidx.profileinstaller.DexProfileData[] readMetadataForNBody(InputStream is, int numberOfDexFiles, androidx.profileinstaller.DexProfileData[] profile) throws IOException {
        int i3;
        int i2;
        int i;
        String classes;
        String str;
        if (is.available() == 0) {
            return new DexProfileData[0];
        }
        if (numberOfDexFiles != profile.length) {
        } else {
            String[] strArr = new String[numberOfDexFiles];
            final int[] iArr = new int[numberOfDexFiles];
            i3 = 0;
            while (i3 < numberOfDexFiles) {
                iArr[i3] = Encoding.readUInt16(is);
                strArr[i3] = Encoding.readString(is, Encoding.readUInt16(is));
                i3++;
            }
            i2 = 0;
            while (i2 < numberOfDexFiles) {
                i = profile[i2];
                i.classSetSize = iArr[i2];
                i.classes = ProfileTranscoder.readClasses(is, i.classSetSize);
                i2++;
            }
            return profile;
        }
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    static androidx.profileinstaller.DexProfileData[] readMetadataV002(InputStream is, byte[] desiredProfileVersion, androidx.profileinstaller.DexProfileData[] profile) throws IOException {
        Throwable th;
        Throwable th2;
        if (is.read() > 0) {
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Encoding.readCompressed(is, (int)uInt322, (int)uInt32));
            byteArrayInputStream.close();
            return ProfileTranscoder.readMetadataV002Body(byteArrayInputStream, desiredProfileVersion, Encoding.readUInt16(is), profile);
        }
        throw Encoding.error("Content found after the end of file");
    }

    private static androidx.profileinstaller.DexProfileData[] readMetadataV002Body(InputStream is, byte[] desiredProfileVersion, int dexFileCount, androidx.profileinstaller.DexProfileData[] profile) throws IOException {
        int i;
        int i3;
        String string;
        long l;
        int i2;
        androidx.profileinstaller.DexProfileData byDexName;
        int[] classes;
        boolean equals;
        if (is.available() == 0) {
            return new DexProfileData[0];
        }
        if (dexFileCount != profile.length) {
        } else {
            i = 0;
            while (i < dexFileCount) {
                Encoding.readUInt16(is);
                string = Encoding.readString(is, Encoding.readUInt16(is));
                i2 = Encoding.readUInt16(is);
                byDexName = ProfileTranscoder.findByDexName(profile, string);
                byDexName.mTypeIdCount = Encoding.readUInt32(is);
                if (Arrays.equals(desiredProfileVersion, ProfileVersion.V001_N) != null) {
                }
                i++;
                byDexName.classSetSize = i2;
                byDexName.classes = ProfileTranscoder.readClasses(is, i2);
            }
            return profile;
        }
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    private static void readMethodBitmap(InputStream is, androidx.profileinstaller.DexProfileData data) throws IOException {
        int methodIndex;
        int flagsFromBitmap;
        Object current;
        TreeMap methods;
        Integer valueOf;
        Integer valueOf2;
        Integer valueOf3;
        methodIndex = 0;
        while (methodIndex < data.numMethodIds) {
            flagsFromBitmap = ProfileTranscoder.readFlagsFromBitmap(BitSet.valueOf(Encoding.read(is, Encoding.bitsToBytes(numMethodIds *= 2))), methodIndex, data.numMethodIds);
            if (flagsFromBitmap != null && (Integer)data.methods.get(Integer.valueOf(methodIndex)) == null) {
            }
            methodIndex++;
            if ((Integer)data.methods.get(Integer.valueOf(methodIndex)) == null) {
            }
            data.methods.put(Integer.valueOf(methodIndex), Integer.valueOf(intValue |= flagsFromBitmap));
            current = 0;
        }
    }

    static androidx.profileinstaller.DexProfileData[] readProfile(InputStream is, byte[] version, String apkName) throws IOException {
        Throwable th;
        Throwable th2;
        if (Arrays.equals(version, ProfileVersion.V010_P) == null) {
        } else {
            if (is.read() > 0) {
            } else {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Encoding.readCompressed(is, (int)uInt322, (int)uInt32));
                byteArrayInputStream.close();
                return ProfileTranscoder.readUncompressedBody(byteArrayInputStream, apkName, Encoding.readUInt8(is));
            }
            throw Encoding.error("Content found after the end of file");
        }
        throw Encoding.error("Unsupported version");
    }

    private static androidx.profileinstaller.DexProfileData[] readUncompressedBody(InputStream is, String apkName, int numberOfDexFiles) throws IOException {
        int i;
        int i4;
        int i3;
        androidx.profileinstaller.DexProfileData hotMethodRegionSize;
        String str;
        String string;
        long l2;
        int numMethodIds;
        int i2;
        int i5;
        int i6;
        int[] iArr;
        TreeMap treeMap;
        long l;
        long l3;
        final InputStream inputStream = is;
        final int i7 = numberOfDexFiles;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        androidx.profileinstaller.DexProfileData[] arr = new DexProfileData[i7];
        i4 = 0;
        while (i4 < i7) {
            i2 = Encoding.readUInt16(inputStream);
            long uInt32 = Encoding.readUInt32(inputStream);
            long uInt322 = Encoding.readUInt32(inputStream);
            hotMethodRegionSize = dexProfileData3;
            l = l4;
            treeMap = new TreeMap();
            l3 = uInt322;
            super(apkName, Encoding.readString(inputStream, Encoding.readUInt16(inputStream)), Encoding.readUInt32(inputStream), obj10, 0, obj12, i2, (int)uInt32, (int)uInt322, new int[i2], treeMap);
            arr[i4] = hotMethodRegionSize;
            i4++;
        }
        while (i < arr.length) {
            i3 = arr[i];
            ProfileTranscoder.readHotMethodRegion(inputStream, i3);
            i3.classes = ProfileTranscoder.readClasses(inputStream, i3.classSetSize);
            ProfileTranscoder.readMethodBitmap(inputStream, i3);
            i++;
        }
        return arr;
    }

    private static int roundUpToByte(int bits) {
        return i2 &= -8;
    }

    private static void setMethodBitmapBit(byte[] bitmap, int flag, int methodIndex, androidx.profileinstaller.DexProfileData dexData) {
        int methodFlagBitmapIndex = ProfileTranscoder.methodFlagBitmapIndex(flag, methodIndex, dexData.numMethodIds);
        final int i = methodFlagBitmapIndex / 8;
        bitmap[i] = (byte)i2;
    }

    private static void skipInlineCache(InputStream is) throws IOException {
        int dexPcMapSize;
        int numClasses;
        Encoding.readUInt16(is);
        dexPcMapSize = Encoding.readUInt8(is);
        if (dexPcMapSize == 6) {
        }
        if (dexPcMapSize == 7) {
        }
        while (dexPcMapSize > 0) {
            Encoding.readUInt8(is);
            numClasses = Encoding.readUInt8(is);
            while (numClasses > 0) {
                Encoding.readUInt16(is);
                numClasses--;
            }
            dexPcMapSize--;
            Encoding.readUInt16(is);
            numClasses--;
        }
    }

    static boolean transcodeAndWriteBody(OutputStream os, byte[] desiredVersion, androidx.profileinstaller.DexProfileData[] data) throws IOException {
        final int i2 = 1;
        if (Arrays.equals(desiredVersion, ProfileVersion.V015_S) != null) {
            ProfileTranscoder.writeProfileForS(os, data);
            return i2;
        }
        if (Arrays.equals(desiredVersion, ProfileVersion.V010_P) != null) {
            ProfileTranscoder.writeProfileForP(os, data);
            return i2;
        }
        if (Arrays.equals(desiredVersion, ProfileVersion.V005_O) != null) {
            ProfileTranscoder.writeProfileForO(os, data);
            return i2;
        }
        if (Arrays.equals(desiredVersion, ProfileVersion.V009_O_MR1) != null) {
            ProfileTranscoder.writeProfileForO_MR1(os, data);
            return i2;
        }
        if (Arrays.equals(desiredVersion, ProfileVersion.V001_N) != null) {
            ProfileTranscoder.writeProfileForN(os, data);
            return i2;
        }
        return 0;
    }

    private static void writeClasses(OutputStream os, androidx.profileinstaller.DexProfileData dexData) throws IOException {
        int lastClassIndex;
        int i;
        Integer valueOf;
        int i2;
        lastClassIndex = 0;
        final int[] classes = dexData.classes;
        i = 0;
        while (i < classes.length) {
            valueOf = Integer.valueOf(classes[i]);
            Encoding.writeUInt16(os, intValue -= lastClassIndex);
            lastClassIndex = valueOf.intValue();
            i++;
        }
    }

    private static androidx.profileinstaller.WritableFileSection writeDexFileSection(androidx.profileinstaller.DexProfileData[] profileData) throws IOException {
        int expectedSize;
        Throwable contents;
        int i2;
        Throwable th;
        String dexKey;
        long utf8Length;
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i3 += 2;
        Encoding.writeUInt16(byteArrayOutputStream, profileData.length);
        i2 = 0;
        for (Object th : profileData) {
            Encoding.writeUInt32(byteArrayOutputStream, th.dexChecksum);
            Encoding.writeUInt32(byteArrayOutputStream, th.mTypeIdCount);
            Encoding.writeUInt32(byteArrayOutputStream, (long)numMethodIds);
            dexKey = ProfileTranscoder.generateDexKey(th.apkName, th.dexName, ProfileVersion.V015_S);
            utf8Length = Encoding.utf8Length(dexKey);
            Encoding.writeUInt16(byteArrayOutputStream, utf8Length);
            expectedSize5 += i;
            Encoding.writeString(byteArrayOutputStream, dexKey);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (expectedSize != byteArray.length) {
        } else {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, expectedSize, byteArray, 0);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        StringBuilder stringBuilder = new StringBuilder();
        throw Encoding.error(stringBuilder.append("Expected size ").append(expectedSize).append(", does not match actual size ").append(byteArray.length).toString());
    }

    static void writeHeader(OutputStream os, byte[] version) throws IOException {
        os.write(ProfileTranscoder.MAGIC_PROF);
        os.write(version);
    }

    private static void writeLineData(OutputStream os, androidx.profileinstaller.DexProfileData dexData) throws IOException {
        ProfileTranscoder.writeMethodsWithInlineCaches(os, dexData);
        ProfileTranscoder.writeClasses(os, dexData);
        ProfileTranscoder.writeMethodBitmap(os, dexData);
    }

    private static void writeLineHeader(OutputStream os, androidx.profileinstaller.DexProfileData dexData, String dexKey) throws IOException {
        Encoding.writeUInt16(os, Encoding.utf8Length(dexKey));
        Encoding.writeUInt16(os, dexData.classSetSize);
        Encoding.writeUInt32(os, (long)hotMethodRegionSize);
        Encoding.writeUInt32(os, dexData.dexChecksum);
        Encoding.writeUInt32(os, (long)numMethodIds);
        Encoding.writeString(os, dexKey);
    }

    private static void writeMethodBitmap(OutputStream os, androidx.profileinstaller.DexProfileData dexData) throws IOException {
        Object next;
        int intValue;
        int intValue2;
        int i2;
        int i;
        byte[] bArr = new byte[ProfileTranscoder.getMethodBitmapStorageSize(dexData.numMethodIds)];
        Iterator iterator = dexData.methods.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            intValue = (Integer)(Map.Entry)next.getKey().intValue();
            intValue2 = (Integer)next.getValue().intValue();
            if (intValue2 & 2 != 0) {
            }
            if (intValue2 & 4 != 0) {
            }
            ProfileTranscoder.setMethodBitmapBit(bArr, 4, intValue, dexData);
            ProfileTranscoder.setMethodBitmapBit(bArr, 2, intValue, dexData);
        }
        os.write(bArr);
    }

    private static void writeMethodBitmapForS(OutputStream os, int methodFlags, androidx.profileinstaller.DexProfileData dexData) throws IOException {
        Object next;
        int intValue2;
        int intValue;
        int offset;
        int flag;
        int i2;
        int i4;
        int i3;
        byte b;
        int i;
        final byte[] bArr = new byte[ProfileTranscoder.getMethodBitmapStorageSizeForS(methodFlags, dexData.numMethodIds)];
        Iterator iterator = dexData.methods.entrySet().iterator();
        for (Map.Entry next : iterator) {
            offset = 0;
            flag = 1;
            while (flag <= 4) {
                i2 = 1;
                if (flag == i2) {
                } else {
                }
                if (flag & methodFlags == 0) {
                } else {
                }
                if (flag & intValue == flag) {
                }
                offset++;
                flag <<= 1;
                i7 += intValue2;
                i3 = i4 / 8;
                bArr[i3] = (byte)i6;
                flag <<= 1;
                flag <<= 1;
            }
            i2 = 1;
            if (flag == i2) {
            } else {
            }
            if (flag & methodFlags == 0) {
            } else {
            }
            if (flag & intValue == flag) {
            }
            offset++;
            flag <<= 1;
            i7 += intValue2;
            i3 = i4 / 8;
            bArr[i3] = (byte)i6;
            flag <<= 1;
            flag <<= 1;
        }
        os.write(bArr);
    }

    private static void writeMethodsWithInlineCaches(OutputStream os, androidx.profileinstaller.DexProfileData dexData) throws IOException {
        int lastMethodIndex;
        Object next;
        int intValue2;
        int intValue;
        int i;
        int i2;
        lastMethodIndex = 0;
        Iterator iterator = dexData.methods.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            intValue2 = (Integer)(Map.Entry)next.getKey().intValue();
            if (intValue & 1 == 0) {
            } else {
            }
            Encoding.writeUInt16(os, intValue2 - lastMethodIndex);
            Encoding.writeUInt16(os, 0);
            lastMethodIndex = intValue2;
        }
    }

    private static void writeProfileForN(OutputStream os, androidx.profileinstaller.DexProfileData[] lines) throws IOException {
        int i2;
        Object obj;
        String dexKey;
        int[] classes;
        int length;
        byte[] intValue;
        int i;
        int i3;
        Encoding.writeUInt16(os, lines.length);
        final int i4 = 0;
        i2 = i4;
        while (i2 < lines.length) {
            obj = lines[i2];
            intValue = ProfileVersion.V001_N;
            dexKey = ProfileTranscoder.generateDexKey(obj.apkName, obj.dexName, intValue);
            Encoding.writeUInt16(os, Encoding.utf8Length(dexKey));
            Encoding.writeUInt16(os, obj.methods.size());
            Encoding.writeUInt16(os, classes2.length);
            Encoding.writeUInt32(os, obj.dexChecksum);
            Encoding.writeString(os, dexKey);
            Iterator iterator = obj.methods.keySet().iterator();
            for (Integer next2 : iterator) {
                Encoding.writeUInt16(os, next2.intValue());
            }
            classes = obj.classes;
            i = i4;
            while (i < classes.length) {
                Encoding.writeUInt16(os, classes[i]);
                i++;
            }
            i2++;
            Encoding.writeUInt16(os, classes[i]);
            i++;
            Encoding.writeUInt16(os, (Integer)iterator.next().intValue());
        }
    }

    private static void writeProfileForO(OutputStream os, androidx.profileinstaller.DexProfileData[] lines) throws IOException {
        int i;
        Object obj;
        int i2;
        String dexKey;
        int[] classes;
        int length;
        byte[] intValue;
        int i3;
        int i4;
        Encoding.writeUInt8(os, lines.length);
        final int i5 = 0;
        i = i5;
        while (i < lines.length) {
            obj = lines[i];
            intValue = ProfileVersion.V005_O;
            dexKey = ProfileTranscoder.generateDexKey(obj.apkName, obj.dexName, intValue);
            Encoding.writeUInt16(os, Encoding.utf8Length(dexKey));
            Encoding.writeUInt16(os, classes2.length);
            Encoding.writeUInt32(os, (long)i2);
            Encoding.writeUInt32(os, obj.dexChecksum);
            Encoding.writeString(os, dexKey);
            Iterator iterator = obj.methods.keySet().iterator();
            for (Integer next2 : iterator) {
                Encoding.writeUInt16(os, next2.intValue());
                Encoding.writeUInt16(os, i5);
            }
            classes = obj.classes;
            i3 = i5;
            while (i3 < classes.length) {
                Encoding.writeUInt16(os, classes[i3]);
                i3++;
            }
            i++;
            Encoding.writeUInt16(os, classes[i3]);
            i3++;
            Encoding.writeUInt16(os, (Integer)iterator.next().intValue());
            Encoding.writeUInt16(os, i5);
        }
    }

    private static void writeProfileForO_MR1(OutputStream os, androidx.profileinstaller.DexProfileData[] lines) throws IOException {
        Encoding.writeUInt8(os, lines.length);
        Encoding.writeCompressed(os, ProfileTranscoder.createCompressibleBody(lines, ProfileVersion.V009_O_MR1));
    }

    private static void writeProfileForP(OutputStream os, androidx.profileinstaller.DexProfileData[] lines) throws IOException {
        Encoding.writeUInt8(os, lines.length);
        Encoding.writeCompressed(os, ProfileTranscoder.createCompressibleBody(lines, ProfileVersion.V010_P));
    }

    private static void writeProfileForS(OutputStream os, androidx.profileinstaller.DexProfileData[] profileData) throws IOException {
        ProfileTranscoder.writeProfileSections(os, profileData);
    }

    private static void writeProfileSections(OutputStream os, androidx.profileinstaller.DexProfileData[] profileData) throws IOException {
        int i2;
        int i;
        int offset;
        long l;
        int size;
        long l3;
        byte[] compress;
        long l2;
        int i3 = 3;
        ArrayList arrayList = new ArrayList(i3);
        ArrayList arrayList2 = new ArrayList(i3);
        arrayList.add(ProfileTranscoder.writeDexFileSection(profileData));
        arrayList.add(ProfileTranscoder.createCompressibleClassSection(profileData));
        arrayList.add(ProfileTranscoder.createCompressibleMethodsSection(profileData));
        offset2 += l6;
        Encoding.writeUInt32(os, (long)size3);
        i2 = 0;
        while (i2 < arrayList.size()) {
            l = arrayList.get(i2);
            Encoding.writeUInt32(os, l.mType.getValue());
            Encoding.writeUInt32(os, offset);
            if (l.mNeedsCompression) {
            } else {
            }
            arrayList2.add(l.mContents);
            Encoding.writeUInt32(os, (long)length4);
            Encoding.writeUInt32(os, 0);
            offset += l3;
            i2++;
            compress = Encoding.compress(l.mContents);
            arrayList2.add(compress);
            Encoding.writeUInt32(os, (long)length6);
            Encoding.writeUInt32(os, (long)length3);
            offset += l2;
        }
        i = 0;
        while (i < arrayList2.size()) {
            os.write((byte[])arrayList2.get(i));
            i++;
        }
    }
}
