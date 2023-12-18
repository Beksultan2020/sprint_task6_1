package kz.bitlab.SPRING_SPRINT_TASK_2.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="APPLICATIONREQUEST")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME",nullable = false)
    private String userName;

    @Column(name = "COURSENAME",nullable = false)
    private String courseName;

    @Column(name = "COMMENTARY", columnDefinition = "TEXT")
    private String commentary;

    @Column(name = "PHONE",nullable = false)
    private String phone;

    @Column(name = "HANDLED")
    private boolean handled;

}
