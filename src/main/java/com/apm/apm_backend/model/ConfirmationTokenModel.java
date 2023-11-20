package com.apm.apm_backend.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="confirmationToken")
public class ConfirmationTokenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private Integer tokenId;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    @OneToOne(targetEntity = UserModel.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UserModel userModel;

    public ConfirmationTokenModel() {
    }

    public ConfirmationTokenModel(UserModel userModel) {
        this.userModel = userModel;
        confirmationToken = UUID.randomUUID().toString();
        createdDate = new Date();
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public  UserModel getUserEntity() {
        return userModel;
    }

    public void setUserEntity(UserModel userModel) {
        this.userModel = userModel;
    }
}
