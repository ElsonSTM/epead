package com.epead.authu.models;

import com.epead.authu.enums.UserStatus;
import com.epead.authu.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //Quando o serializable fazer a conversão, JsonInc. vai ocultar os valores nulos
@Entity
@Table (name = "TB_USERS")
public class UserModel extends RepresentationModel<UserModel> implements Serializable { //conversão do objeto java em uma sequencia de bytes.
    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(nullable = false, unique = true, length = 45)
    private String username;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false, length = 180)
    @JsonIgnore //restrito para o usuário
    private String password;
    @Column(nullable = false, length = 120)
    private String fullName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(length = 30)
    private String phoneNumber;
    @Column(length = 30)
    private String cpf;
    @Column
    private String imageUrl;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime creationDate;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime lastUpdateDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserCourseModel> usersCourses;

    public UserCourseModel convertToUserCourseModel(UUID courseId){
        return new UserCourseModel(null, courseId, this);
    }

}
