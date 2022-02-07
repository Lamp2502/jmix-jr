package ru.lamp2502.jmixjavarush.entity.document;

import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@JmixEntity
@Table(name = "CONTRACT")
@Entity
public class Contract extends AbstractDocument {

    @Column(name = "COMMUNICATION_TYPE")
    private String communicationType;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @Column(name = "COMPLETED")
    private Boolean completed = false;

    public Boolean getCompleted() {return completed;}

    public void setCompleted(Boolean completed) {this.completed = completed;}

    public Integer getVersion() {return version;}

    public void setVersion(Integer version) {this.version = version;}

    public CommunicationType getCommunicationType() {return communicationType == null ? null : CommunicationType.fromId(communicationType);}

    public void setCommunicationType(CommunicationType communicationType) {this.communicationType = communicationType == null ? null : communicationType.getId();}

    @InstanceName
    @DependsOnProperties({"titel"})
    public String getInstanceName() {
        return String.format("%s", getTitel());
    }
}