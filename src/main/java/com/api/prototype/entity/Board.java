package com.api.prototype.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;


@ToString
@Getter
@NoArgsConstructor
@Entity(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "board" ,cascade = CascadeType.REMOVE)
    private List<Reply> replyList;

    @CreationTimestamp
    private Date creationTime;


    @Builder
    public Board(Integer id, String title, String content, User user, List<Reply> replyList, Date creationTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.replyList = replyList;
        this.creationTime = creationTime;
    }
}
