package nc.opt.docubase.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class PostDocument implements Serializable {
    private String digestValueEncodedBase64;
    private String docType;
    private String storageType;
    private boolean docOwnerPublic;
    private String docOwnerGroup;
    private String uuid;
    private Criterion[] criterionList;

    public String getDigestValueEncodedBase64() {
        return digestValueEncodedBase64;
    }

    public void setDigestValueEncodedBase64(String digestValueEncodedBase64) {
        this.digestValueEncodedBase64 = digestValueEncodedBase64;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public boolean isDocOwnerPublic() {
        return docOwnerPublic;
    }

    public void setDocOwnerPublic(boolean docOwnerPublic) {
        this.docOwnerPublic = docOwnerPublic;
    }

    public String getDocOwnerGroup() {
        return docOwnerGroup;
    }

    public void setDocOwnerGroup(String docOwnerGroup) {
        this.docOwnerGroup = docOwnerGroup;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Criterion[] getCriterionList() {
        return criterionList;
    }

    public void setCriterionList(Criterion[] criterionList) {
        this.criterionList = criterionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDocument that = (PostDocument) o;
        return docOwnerPublic == that.docOwnerPublic &&
                Objects.equals(digestValueEncodedBase64, that.digestValueEncodedBase64) &&
                Objects.equals(docType, that.docType) &&
                Objects.equals(storageType, that.storageType) &&
                Objects.equals(docOwnerGroup, that.docOwnerGroup) &&
                Objects.equals(uuid, that.uuid) &&
                Arrays.equals(criterionList, that.criterionList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(digestValueEncodedBase64, docType, storageType, docOwnerPublic, docOwnerGroup, uuid);
        result = 31 * result + Arrays.hashCode(criterionList);
        return result;
    }

    @Override
    public String toString() {
        return "PostDocument{" +
                "digestValueEncodedBase64='" + digestValueEncodedBase64 + '\'' +
                ", docType='" + docType + '\'' +
                ", storageType='" + storageType + '\'' +
                ", docOwnerPublic=" + docOwnerPublic +
                ", docOwnerGroup='" + docOwnerGroup + '\'' +
                ", uuid='" + uuid + '\'' +
                ", criterionList=" + Arrays.toString(criterionList) +
                '}';
    }
}
