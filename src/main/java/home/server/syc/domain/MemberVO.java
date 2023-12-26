package home.server.syc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEMBER")
public class MemberVO {

    @Id
    @Column(name = "MEMBER_ID")
    private String username;

    @Column(name = "PASSWORD")
    private String password;
}
