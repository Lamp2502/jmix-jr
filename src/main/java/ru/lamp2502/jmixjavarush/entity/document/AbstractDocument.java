package ru.lamp2502.jmixjavarush.entity.document;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import ru.lamp2502.jmixjavarush.entity.Organization;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@MappedSuperclass
public abstract class AbstractDocument {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "HAT")
    private String hat;

    @Column(name = "TITEL")
    private String titel;

    @Column(name = "BODY_")
    @Lob
    private String body;

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

    @Column(name = "CUSTOMER", nullable = false)
    private String customer;

    @Column(name = "PERFORMER")
    private String performer;

    @Column(name = "NUMBER_")
    private String number;

    @Column(name = "STATUS")
    private String status;

    public void setNumber(String number) {this.number = number;}

    public String getNumber() {return number;}


    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public String getHat() {return hat;}

    public void setHat(String hat) {this.hat = hat;}

    public String getTitel() {return titel;}

    public void setTitel(String titel) {this.titel = titel;}

    public String getBody() {return body;}

    public void setBody(String body) {this.body = body;}

    public Date getLastModifiedDate() {return lastModifiedDate;}

    public void setLastModifiedDate(Date lastModifiedDate) {this.lastModifiedDate = lastModifiedDate;}

    public String getLastModifiedBy() {return lastModifiedBy;}

    public void setLastModifiedBy(String lastModifiedBy) {this.lastModifiedBy = lastModifiedBy;}

    public Date getCreatedDate() {return createdDate;}

    public void setCreatedDate(Date createdDate) {this.createdDate = createdDate;}

    public String getCreatedBy() {return createdBy;}

    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}

    public Organization getPerformer() {return performer == null ? null : Organization.fromId(performer);}

    public void setPerformer(Organization performer) {this.performer = performer == null ? null : performer.getId();}

    public Organization getCustomer() {return customer == null ? null : Organization.fromId(customer);}

    public void setCustomer(Organization customer) {this.customer = customer == null ? null : customer.getId();}

    public void setStatus(Status status) {this.status = status == null ? null : status.getId();}

    public Status getStatus() {return status == null ? null : Status.fromId(status);}
}