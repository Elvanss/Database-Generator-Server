package com.converted.datageneratorserver.Entity;

import com.converted.datageneratorserver.Type.SQLStatement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Sql")
public class SqlDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SQLStatement statementType;

    @Column(columnDefinition = "TEXT")
    private String sqlStatement;

    @ManyToOne
    @JoinColumn(name = "upload_file_id")
    private Upload uploadFile;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    @NotEmpty(message = "The SQL file should be asssigned to an identified user")
    private User user;
}
