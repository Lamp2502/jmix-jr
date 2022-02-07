package ru.lamp2502.jmixjavarush.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import ru.lamp2502.jmixjavarush.entity.document.Contract;
import ru.lamp2502.jmixjavarush.entity.document.Status;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "TASK_", indexes = {
        @Index(name = "IDX_TASK_DOCUMENT_ID", columnList = "DOCUMENT_ID"),
        @Index(name = "IDX_TASK_ADMINISTRATOR_ID", columnList = "ADMINISTRATOR_ID")
})
@Entity(name = "Task_")
public class Task {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

   // @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "DOCUMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contract document;

    @Column(name = "PERFORM_BEFORE")
    private LocalDate performBefore;


    @Column(name = "CONTRAGENT")
    private String contragent;

    @JoinColumn(name = "ADMINISTRATOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User administrator;

    @Column(name = "ACTIONS")
    private String actions;

    @Column(name = "STATUS")
    private String status;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "COMPLETED")
    private Boolean completed = false;

    public Boolean getCompleted() {return completed;}

    public void setCompleted(Boolean completed) {this.completed = completed;}

    public Contract getDocument() {return document;}

    public void setDocument(Contract document) {this.document = document;}

    public Action getActions() {return actions == null ? null : Action.fromId(actions);}

    public void setActions(Action actions) {this.actions = actions == null ? null : actions.getId();}

    public User getAdministrator() {return administrator;}

    public void setAdministrator(User administrator) {this.administrator = administrator;}

    public Organization getContragent() {return contragent == null ? null : Organization.fromId(contragent);}

    public void setContragent(Organization contragent) {this.contragent = contragent == null ? null : contragent.getId();}

    public Status getStatus() {return status == null ? null : Status.fromId(status);}

    public void setStatus(Status status) {this.status = status == null ? null : status.getId();}

    public LocalDate getPerformBefore() {return performBefore;}

    public void setPerformBefore(LocalDate performBefore) {this.performBefore = performBefore;}

    public Date getLastModifiedDate() {return lastModifiedDate;}

    public void setLastModifiedDate(Date lastModifiedDate) {this.lastModifiedDate = lastModifiedDate;}

    public String getLastModifiedBy() {return lastModifiedBy;}

    public void setLastModifiedBy(String lastModifiedBy) {this.lastModifiedBy = lastModifiedBy;}

    public Date getCreatedDate() {return createdDate;}

    public void setCreatedDate(Date createdDate) {this.createdDate = createdDate;}

    public String getCreatedBy() {return createdBy;}

    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}
}