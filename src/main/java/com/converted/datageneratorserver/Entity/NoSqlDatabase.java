package com.converted.datageneratorserver.Entity;

import com.converted.datageneratorserver.Type.NoSqlStatement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Nosql")
public class NoSqlDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "statement")
    private String nosqlStatement;

    @Column(name = "type") // only 1 type currently
    @Enumerated(EnumType.STRING)
    private NoSqlStatement databaseType;

    @ManyToOne
    @JoinColumn(name = "sql_database_id")
    private SqlDatabase sqlStatement;

}
