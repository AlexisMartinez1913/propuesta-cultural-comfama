package comfama.propuestacultural.models.keys;

import java.io.Serializable;

public class AttachedDocumentProposalPk implements Serializable {
    private Integer proposal;
    private Integer attachedDocument;

    public Integer getProposal() {
        return proposal;
    }

    public void setProposal(Integer proposal) {
        this.proposal = proposal;
    }

    public Integer getAttachedDocument() {
        return attachedDocument;
    }

    public void setAttachedDocument(Integer attachedDocument) {
        this.attachedDocument = attachedDocument;
    }
}
