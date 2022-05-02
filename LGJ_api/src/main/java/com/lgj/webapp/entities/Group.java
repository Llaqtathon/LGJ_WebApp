package com.lgj.webapp.entities;

import javax.persistence.*;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.lgj.webapp.dto.GroupRequest;

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

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;

    public Group(GroupRequest groupRequest) {
        this.name = groupRequest.getName();
        this.photoUrl = groupRequest.getPhotoUrl();
    }

    //TODO: Add relationship to Event

    public Group addUser(User user) {
        users.add(user);
        return this;
    }

    public Group removeUser(Long userId) {
        this.users = users
                .stream()
                .filter(user -> !user.getId().equals(userId))
                .collect(Collectors.toSet());

        return this;
    }
}