package com.andreinicolescu.spotifysubscriptiondemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USER")
public class UserEntity extends BaseEntity {

    private String email;

    private String password;
}
