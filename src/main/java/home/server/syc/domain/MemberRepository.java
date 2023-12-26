package home.server.syc.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, Long> {
    MemberVO findByUsername(String username);
}
