package com.phuocnd.shopdev.entities.user;

import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.phuocnd.shopdev.entities.feed.FeedEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude // Exclude feeds from toString FeedEntity has a reference to UserEntity, it is
                      // looping
    private List<FeedEntity> feeds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_identify_id")
    private UserIdentifyEntity userIdentify;

}
