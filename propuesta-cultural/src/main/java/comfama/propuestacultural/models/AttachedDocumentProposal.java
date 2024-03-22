package comfama.propuestacultural.models;

import comfama.propuestacultural.models.keys.AttachedDocumentProposalPk;
import jakarta.persistence.*;

@Entity
@Table(name = "proposal_document")
@IdClass(AttachedDocumentProposalPk.class)
public class AttachedDocumentProposal {
    @Id
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Proposal proposal;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_attached_document", referencedColumnName = "id_attached_document")
    private AttachedDocument attachedDocument;

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public AttachedDocument getAttachedDocument() {
        return attachedDocument;
    }

    public void setAttachedDocument(AttachedDocument attachedDocument) {
        this.attachedDocument = attachedDocument;
    }
}
