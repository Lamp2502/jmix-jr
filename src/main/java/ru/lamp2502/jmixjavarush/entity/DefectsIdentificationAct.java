package ru.lamp2502.jmixjavarush.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import ru.lamp2502.jmixjavarush.entity.document.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@JmixEntity
@Table(name = "DEFECTS_IDENTIFICATION_ACT")
@Entity
public class DefectsIdentificationAct implements Document {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "HAT")
    private String hat;

    @InstanceName
    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY_")
    private String body;

    public String getBody() {return body;}

    public void setBody(String body) {this.body = body;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getHat() {return hat;}

    public void setHat(String hat) {this.hat = hat;}


    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}
}