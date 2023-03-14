package com.dew.itrade.fileprocessingapp.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "file_info", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"checksum"}),
})
public class FileInfo extends  AuditEntiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String checksum;
    private String filename;
    private String process;
    private String status;
}
