package sk.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "SUSERS")
public class User {
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_GUID")
    private String userGuid;

    @Column(name = "USER_NAME")
    private String userName;

}
