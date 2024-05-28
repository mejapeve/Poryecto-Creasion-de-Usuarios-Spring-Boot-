package com.bci.users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(name = "created_at", updatable=false)
    private LocalDateTime created_at;
    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modified_at;
    @LastModifiedDate
    @Column(name = "last_login")
    private LocalDateTime last_login;
    @Column(name = "token")
    private String token;
    @Column(name = "isActive")
    private boolean isActive;



}
