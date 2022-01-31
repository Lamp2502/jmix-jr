package ru.lamp2502.jmixjavarush.entity.document;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import ru.lamp2502.jmixjavarush.entity.User;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "DOCUMENTS", indexes = {
        @Index(name = "IDX_DOCUMENTIMPL_USER_ID", columnList = "USER_ID")
})
@Entity
public class DocumentImpl implements ru.lamp2502.jmixjavarush.entity.document.Document {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "HAT")
    private String hat;

    @InstanceName
    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY_")
    private String body;

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}


    public String getBody() {return body;}

    public void setBody(String body) {this.body = body;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getHat() {return hat;}

    public void setHat(String hat) {this.hat = hat;}


    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}
}