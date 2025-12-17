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
        int i2;
        Throwable th;
        int i;
        expectedSize = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i2 = 0;
        for (Object th : profileData) {
            Encoding.writeUInt16(byteArrayOutputStream, i2);
            Encoding.writeUInt16(byteArrayOutputStream, th.classSetSize);
            expectedSize3 += i;
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
        int i2;
        Throwable th;
        int methodFlags;
        byte[] methodBitmapRegionForS;
        byte[] methodsWithInlineCaches;
        int i;
        long l;
        expectedSize = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i2 = 0;
        for (Object th : profileData) {
            methodFlags = ProfileTranscoder.computeMethodFlags(th);
            methodBitmapRegionForS = ProfileTranscoder.createMethodBitmapRegionForS(methodFlags, th);
            methodsWithInlineCaches = ProfileTranscoder.createMethodsWithInlineCaches(th);
            Encoding.writeUInt16(byteArrayOutputStream, i2);
            i4 += length5;
            Encoding.writeUInt32(byteArrayOutputStream, (long)i);
            Encoding.writeUInt16(byteArrayOutputStream, methodFlags);
            byteArrayOutputStream.write(methodBitmapRegionForS);
            byteArrayOutputStream.write(methodsWithInlineCaches);
            expectedSize3 += i;
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
        Throwable th2;
        Throwable th;
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
        int i;
        int i2;
        final int[] iArr = new int[classSetSize];
        lastClassIndex = 0;
        k = 0;
        while (k < classSetSize) {
            i2 = lastClassIndex + i;
            iArr[k] = i2;
            lastClassIndex = i2;
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
        int i;
        int i3;
        int i2;
        String classes;
        String str;
        if (is.available() == 0) {
            return new DexProfileData[0];
        }
        if (numberOfDexFiles != profile.length) {
        } else {
            String[] strArr = new String[numberOfDexFiles];
            final int[] iArr = new int[numberOfDexFiles];
            i = 0;
            while (i < numberOfDexFiles) {
                iArr[i] = Encoding.readUInt16(is);
                strArr[i] = Encoding.readString(is, Encoding.readUInt16(is));
                i++;
            }
            i3 = 0;
            while (i3 < numberOfDexFiles) {
                i2 = profile[i3];
                i2.classSetSize = iArr[i3];
                i2.classes = ProfileTranscoder.readClasses(is, i2.classSetSize);
                i3++;
            }
            return profile;
        }
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    static androidx.profileinstaller.DexProfileData[] readMetadataV002(InputStream is, byte[] desiredProfileVersion, androidx.profileinstaller.DexProfileData[] profile) throws IOException {
        Throwable th2;
        Throwable th;
        if (is.read() > 0) {
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Encoding.readCompressed(is, (int)uInt322, (int)uInt32));
            byteArrayInputStream.close();
            return ProfileTranscoder.readMetadataV002Body(byteArrayInputStream, desiredProfileVersion, Encoding.readUInt16(is), profile);
        }
        throw Encoding.error("Content found after the end of file");
    }

    private static androidx.profileinstaller.DexProfileData[] readMetadataV002Body(InputStream is, byte[] desiredProfileVersion, int dexFileCount, androidx.profileinstaller.DexProfileData[] profile) throws IOException {
        int i2;
        int i;
        String string;
        long l;
        int i3;
        androidx.profileinstaller.DexProfileData byDexName;
        int[] classes;
        boolean equals;
        if (is.available() == 0) {
            return new DexProfileData[0];
        }
        if (dexFileCount != profile.length) {
        } else {
            i2 = 0;
            while (i2 < dexFileCount) {
                Encoding.readUInt16(is);
                string = Encoding.readString(is, Encoding.readUInt16(is));
                i3 = Encoding.readUInt16(is);
                byDexName = ProfileTranscoder.findByDexName(profile, string);
                byDexName.mTypeIdCount = Encoding.readUInt32(is);
                if (Arrays.equals(desiredProfileVersion, ProfileVersion.V001_N) != null) {
                }
                i2++;
                byDexName.classSetSize = i3;
                byDexName.classes = ProfileTranscoder.readClasses(is, i3);
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
        Integer valueOf3;
        Integer valueOf2;
        Integer valueOf;
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
        int i3;
        int i6;
        int i5;
        androidx.profileinstaller.DexProfileData hotMethodRegionSize;
        String str;
        String string;
        long l;
        int numMethodIds;
        int i4;
        int i;
        int i2;
        int[] iArr;
        TreeMap treeMap;
        long l2;
        long l3;
        final InputStream inputStream = is;
        final int i7 = numberOfDexFiles;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        androidx.profileinstaller.DexProfileData[] arr = new DexProfileData[i7];
        i6 = 0;
        while (i6 < i7) {
            i4 = Encoding.readUInt16(inputStream);
            long uInt32 = Encoding.readUInt32(inputStream);
            long uInt322 = Encoding.readUInt32(inputStream);
            hotMethodRegionSize = dexProfileData3;
            l2 = l4;
            treeMap = new TreeMap();
            l3 = uInt322;
            super(apkName, Encoding.readString(inputStream, Encoding.readUInt16(inputStream)), Encoding.readUInt32(inputStream), obj10, 0, obj12, i4, (int)uInt32, (int)uInt322, new int[i4], treeMap);
            arr[i6] = hotMethodRegionSize;
            i6++;
        }
        while (i3 < arr.length) {
            i5 = arr[i3];
            ProfileTranscoder.readHotMethodRegion(inputStream, i5);
            i5.classes = ProfileTranscoder.readClasses(inputStream, i5.classSetSize);
            ProfileTranscoder.readMethodBitmap(inputStream, i5);
            i3++;
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
        int i2;
        Integer valueOf;
        int i;
        lastClassIndex = 0;
        final int[] classes = dexData.classes;
        i2 = 0;
        while (i2 < classes.length) {
            valueOf = Integer.valueOf(classes[i2]);
            Encoding.writeUInt16(os, intValue -= lastClassIndex);
            lastClassIndex = valueOf.intValue();
            i2++;
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
        int intValue2;
        int intValue;
        int i;
        int i2;
        byte[] bArr = new byte[ProfileTranscoder.getMethodBitmapStorageSize(dexData.numMethodIds)];
        Iterator iterator = dexData.methods.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            intValue2 = (Integer)(Map.Entry)next.getKey().intValue();
            intValue = (Integer)next.getValue().intValue();
            if (intValue & 2 != 0) {
            }
            if (intValue & 4 != 0) {
            }
            ProfileTranscoder.setMethodBitmapBit(bArr, 4, intValue2, dexData);
            ProfileTranscoder.setMethodBitmapBit(bArr, 2, intValue2, dexData);
        }
        os.write(bArr);
    }

    private static void writeMethodBitmapForS(OutputStream os, int methodFlags, androidx.profileinstaller.DexProfileData dexData) throws IOException {
        Object next;
        int intValue;
        int intValue2;
        int offset;
        int flag;
        int i2;
        int i;
        int i3;
        byte b;
        int i4;
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
                if (flag & intValue2 == flag) {
                }
                offset++;
                flag <<= 1;
                i7 += intValue;
                i3 = i / 8;
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
            if (flag & intValue2 == flag) {
            }
            offset++;
            flag <<= 1;
            i7 += intValue;
            i3 = i / 8;
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
        int i3;
        Object obj;
        String dexKey;
        int[] classes;
        int length;
        byte[] intValue;
        int i2;
        int i;
        Encoding.writeUInt16(os, lines.length);
        final int i4 = 0;
        i3 = i4;
        while (i3 < lines.length) {
            obj = lines[i3];
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
            i2 = i4;
            while (i2 < classes.length) {
                Encoding.writeUInt16(os, classes[i2]);
                i2++;
            }
            i3++;
            Encoding.writeUInt16(os, classes[i2]);
            i2++;
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
        int i4;
        int i3;
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
            i4 = i5;
            while (i4 < classes.length) {
                Encoding.writeUInt16(os, classes[i4]);
                i4++;
            }
            i++;
            Encoding.writeUInt16(os, classes[i4]);
            i4++;
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
        long l3;
        int size;
        long l2;
        byte[] compress;
        long l;
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
            l3 = arrayList.get(i2);
            Encoding.writeUInt32(os, l3.mType.getValue());
            Encoding.writeUInt32(os, offset);
            if (l3.mNeedsCompression) {
            } else {
            }
            arrayList2.add(l3.mContents);
            Encoding.writeUInt32(os, (long)length4);
            Encoding.writeUInt32(os, 0);
            offset += l2;
            i2++;
            compress = Encoding.compress(l3.mContents);
            arrayList2.add(compress);
            Encoding.writeUInt32(os, (long)length6);
            Encoding.writeUInt32(os, (long)length3);
            offset += l;
        }
        i = 0;
        while (i < arrayList2.size()) {
            os.write((byte[])arrayList2.get(i));
            i++;
        }
    }
}
