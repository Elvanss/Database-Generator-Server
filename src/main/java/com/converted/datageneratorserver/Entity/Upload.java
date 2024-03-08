package com.converted.datageneratorserver.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Upload")
public class Upload implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "upload-date")
    private LocalDateTime uploadDate;

    @OneToMany(mappedBy = "uploadFile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SqlDatabase> sqlStatements = new ArrayList<>();

}
