package com.lgj.webapp.CompositeKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class UserMicroKey implements Serializable {
   @Column(name = "user_id")
   private Long userId;

   @Column(name = "microevento_id")
   private Long microeventoId;

}
