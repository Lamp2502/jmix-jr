package ru.lamp2502.jmixjavarush.entity.document;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;

@JmixEntity
@Table(name = "DOCUMENT", indexes = {
        @Index(name = "IDX_DOCUMENT_CONTRACT_ID", columnList = "CONTRACT_ID")
})
@Entity
public class Document extends AbstractDocument {

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "CONTRACT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @Column(name = "TYPE_")
    private String type;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "AMOUNT")
    private Double amount;

    public Type getType() {return type == null ? null : Type.fromId(type);}

    public void setType(Type type) {this.type = type == null ? null : type.getId();}

    public Content getContent() {return content == null ? null : Content.fromId(content);}

    public void setContent(Content content) {this.content = content == null ? null : content.getId();}

    public Double getAmount() {return amount;}

    public void setAmount(Double amount) {this.amount = amount;}

    public Contract getContract() {return contract;}

    public void setContract(Contract contract) {this.contract = contract;}

    @InstanceName
    @DependsOnProperties({"titel"})
    public String getInstanceName() {
        return String.format("%s", getTitel());
    }
}