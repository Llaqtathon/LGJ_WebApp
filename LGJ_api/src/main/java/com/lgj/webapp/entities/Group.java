package com.lgj.webapp.entities;

import javax.persistence.GenerationType;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lgj.webapp.dto.GroupRequest;

import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "photo_url") //TODO: (bug) DOESN'T WORK! 
  private String photoUrl;
  

  @ManyToMany
  @JoinTable(
      name = "groups_users", 
      joinColumns = @JoinColumn(name = "group_id"), 
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  Set<User> users = Collections.emptySet();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "game_id", referencedColumnName = "id")
  private Game game;

  //TODO: Add relationship to Event

  public Group addUser(User user) {
    users.add(user);
    return this;
  }

  public Group(GroupRequest groupRequest) {
    this.name = groupRequest.getName();
    this.photoUrl = groupRequest.getPhotoUrl();
  }
}